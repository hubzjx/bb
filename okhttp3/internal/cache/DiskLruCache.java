package okhttp3.internal.cache;

import h4.e;
import h4.q;
import io.jsonwebtoken.JwtParser;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.text.k;
import kotlin.text.w;
import kotlin.text.x;
import n4.a;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable, Flushable {
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final File directory;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    public static final Companion Companion = new Companion(null);
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String VERSION_1 = "1";
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final k LEGAL_KEY_PATTERN = new k("[a-z0-9_-]{1,120}");
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final String REMOVE = "REMOVE";
    public static final String READ = "READ";

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            l.d(diskLruCache, "this$0");
            l.d(entry, "entry");
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = entry.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        public final void abort() {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (!(!this.done)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (l.a(getEntry$okhttp().getCurrentEditor$okhttp(), this)) {
                    diskLruCache.completeEdit$okhttp(this, false);
                }
                this.done = true;
                q qVar = q.f10774a;
            }
        }

        public final void commit() {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (!(!this.done)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (l.a(getEntry$okhttp().getCurrentEditor$okhttp(), this)) {
                    diskLruCache.completeEdit$okhttp(this, true);
                }
                this.done = true;
                q qVar = q.f10774a;
            }
        }

        public final void detach$okhttp() {
            if (l.a(this.entry.getCurrentEditor$okhttp(), this)) {
                if (this.this$0.civilizedFileSystem) {
                    this.this$0.completeEdit$okhttp(this, false);
                } else {
                    this.entry.setZombie$okhttp(true);
                }
            }
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final Sink newSink(int i6) {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (!this.done) {
                    if (!l.a(getEntry$okhttp().getCurrentEditor$okhttp(), this)) {
                        return Okio.blackhole();
                    }
                    if (!getEntry$okhttp().getReadable$okhttp()) {
                        boolean[] written$okhttp = getWritten$okhttp();
                        l.b(written$okhttp);
                        written$okhttp[i6] = true;
                    }
                    try {
                        return new FaultHidingSink(diskLruCache.getFileSystem$okhttp().sink(getEntry$okhttp().getDirtyFiles$okhttp().get(i6)), new DiskLruCache$Editor$newSink$1$1(diskLruCache, this));
                    } catch (FileNotFoundException unused) {
                        return Okio.blackhole();
                    }
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final Source newSource(int i6) {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (!this.done) {
                    Source source = null;
                    if (getEntry$okhttp().getReadable$okhttp() && l.a(getEntry$okhttp().getCurrentEditor$okhttp(), this) && !getEntry$okhttp().getZombie$okhttp()) {
                        try {
                            source = diskLruCache.getFileSystem$okhttp().source(getEntry$okhttp().getCleanFiles$okhttp().get(i6));
                        } catch (FileNotFoundException unused) {
                        }
                        return source;
                    }
                    return null;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Entry {
        private final List<File> cleanFiles;
        private Editor currentEditor;
        private final List<File> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache diskLruCache, String str) {
            l.d(diskLruCache, "this$0");
            l.d(str, "key");
            this.this$0 = diskLruCache;
            this.key = str;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder sb = new StringBuilder(str);
            sb.append(JwtParser.SEPARATOR_CHAR);
            int length = sb.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i6 = 0; i6 < valueCount$okhttp; i6++) {
                sb.append(i6);
                this.cleanFiles.add(new File(this.this$0.getDirectory(), sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(new File(this.this$0.getDirectory(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final Void invalidLengths(List<String> list) {
            throw new IOException(l.i("unexpected journal line: ", list));
        }

        private final Source newSource(int i6) {
            Source source = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i6));
            if (this.this$0.civilizedFileSystem) {
                return source;
            }
            this.lockingSourceCount++;
            return new ForwardingSource(this.this$0, this) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1
                private boolean closed;
                final /* synthetic */ DiskLruCache this$0;
                final /* synthetic */ DiskLruCache.Entry this$1;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(Source.this);
                    this.this$0 = r2;
                    this.this$1 = this;
                }

                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    super.close();
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    DiskLruCache diskLruCache = this.this$0;
                    DiskLruCache.Entry entry = this.this$1;
                    synchronized (diskLruCache) {
                        entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                        if (entry.getLockingSourceCount$okhttp() == 0 && entry.getZombie$okhttp()) {
                            diskLruCache.removeEntry$okhttp(entry);
                        }
                        q qVar = q.f10774a;
                    }
                }
            };
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(List<String> list) {
            l.d(list, "strings");
            if (list.size() != this.this$0.getValueCount$okhttp()) {
                invalidLengths(list);
                throw new e();
            }
            try {
                int size = list.size();
                int i6 = 0;
                while (i6 < size) {
                    int i7 = i6 + 1;
                    this.lengths[i6] = Long.parseLong(list.get(i6));
                    i6 = i7;
                }
            } catch (NumberFormatException unused) {
                invalidLengths(list);
                throw new e();
            }
        }

        public final void setLockingSourceCount$okhttp(int i6) {
            this.lockingSourceCount = i6;
        }

        public final void setReadable$okhttp(boolean z5) {
            this.readable = z5;
        }

        public final void setSequenceNumber$okhttp(long j6) {
            this.sequenceNumber = j6;
        }

        public final void setZombie$okhttp(boolean z5) {
            this.zombie = z5;
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + diskLruCache);
            } else if (this.readable) {
                if (this.this$0.civilizedFileSystem || (this.currentEditor == null && !this.zombie)) {
                    ArrayList<Source> arrayList = new ArrayList();
                    long[] jArr = (long[]) this.lengths.clone();
                    try {
                        int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                        for (int i6 = 0; i6 < valueCount$okhttp; i6++) {
                            arrayList.add(newSource(i6));
                        }
                        return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
                    } catch (FileNotFoundException unused) {
                        for (Source source : arrayList) {
                            Util.closeQuietly(source);
                        }
                        try {
                            this.this$0.removeEntry$okhttp(this);
                        } catch (IOException unused2) {
                        }
                        return null;
                    }
                }
                return null;
            } else {
                return null;
            }
        }

        public final void writeLengths$okhttp(BufferedSink bufferedSink) {
            l.d(bufferedSink, "writer");
            long[] jArr = this.lengths;
            int length = jArr.length;
            int i6 = 0;
            while (i6 < length) {
                long j6 = jArr[i6];
                i6++;
                bufferedSink.writeByte(32).writeDecimalLong(j6);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<Source> sources;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(DiskLruCache diskLruCache, String str, long j6, List<? extends Source> list, long[] jArr) {
            l.d(diskLruCache, "this$0");
            l.d(str, "key");
            l.d(list, "sources");
            l.d(jArr, "lengths");
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j6;
            this.sources = list;
            this.lengths = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.sources) {
                Util.closeQuietly(source);
            }
        }

        public final Editor edit() {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i6) {
            return this.lengths[i6];
        }

        public final Source getSource(int i6) {
            return this.sources.get(i6);
        }

        public final String key() {
            return this.key;
        }
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(FileSystem fileSystem, File file, int i6, int i7, long j6, TaskRunner taskRunner) {
        l.d(fileSystem, "fileSystem");
        l.d(file, "directory");
        l.d(taskRunner, "taskRunner");
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i6;
        this.valueCount = i7;
        this.maxSize = j6;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new Task(l.i(Util.okHttpName, " Cache")) { // from class: okhttp3.internal.cache.DiskLruCache$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                boolean z5;
                boolean journalRebuildRequired;
                DiskLruCache diskLruCache = DiskLruCache.this;
                synchronized (diskLruCache) {
                    z5 = diskLruCache.initialized;
                    if (!z5 || diskLruCache.getClosed$okhttp()) {
                        return -1L;
                    }
                    try {
                        diskLruCache.trimToSize();
                    } catch (IOException unused) {
                        diskLruCache.mostRecentTrimFailed = true;
                    }
                    try {
                        journalRebuildRequired = diskLruCache.journalRebuildRequired();
                        if (journalRebuildRequired) {
                            diskLruCache.rebuildJournal$okhttp();
                            diskLruCache.redundantOpCount = 0;
                        }
                    } catch (IOException unused2) {
                        diskLruCache.mostRecentRebuildFailed = true;
                        diskLruCache.journalWriter = Okio.buffer(Okio.blackhole());
                    }
                    return -1L;
                }
            }
        };
        if (!(j6 > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (!(i7 > 0)) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j6, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j6);
    }

    public final boolean journalRebuildRequired() {
        int i6 = this.redundantOpCount;
        return i6 >= 2000 && i6 >= this.lruEntries.size();
    }

    private final BufferedSink newJournalWriter() {
        return Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void processJournal() {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            l.c(next, "i.next()");
            Entry entry = next;
            int i6 = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i7 = this.valueCount;
                while (i6 < i7) {
                    this.size += entry.getLengths$okhttp()[i6];
                    i6++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i8 = this.valueCount;
                while (i6 < i8) {
                    this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i6));
                    this.fileSystem.delete(entry.getDirtyFiles$okhttp().get(i6));
                    i6++;
                }
                it.remove();
            }
        }
    }

    private final void readJournal() {
        BufferedSource buffer = Okio.buffer(this.fileSystem.source(this.journalFile));
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (l.a(MAGIC, readUtf8LineStrict) && l.a(VERSION_1, readUtf8LineStrict2) && l.a(String.valueOf(this.appVersion), readUtf8LineStrict3) && l.a(String.valueOf(getValueCount$okhttp()), readUtf8LineStrict4)) {
                int i6 = 0;
                if (!(readUtf8LineStrict5.length() > 0)) {
                    while (true) {
                        try {
                            readJournalLine(buffer.readUtf8LineStrict());
                            i6++;
                        } catch (EOFException unused) {
                            this.redundantOpCount = i6 - getLruEntries$okhttp().size();
                            if (buffer.exhausted()) {
                                this.journalWriter = newJournalWriter();
                            } else {
                                rebuildJournal$okhttp();
                            }
                            q qVar = q.f10774a;
                            a.a(buffer, null);
                            return;
                        }
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + ']');
        } finally {
        }
    }

    private final void readJournalLine(String str) {
        int N;
        int N2;
        String substring;
        boolean y5;
        boolean y6;
        boolean y7;
        List<String> j02;
        boolean y8;
        N = x.N(str, ' ', 0, false, 6, null);
        if (N == -1) {
            throw new IOException(l.i("unexpected journal line: ", str));
        }
        int i6 = N + 1;
        N2 = x.N(str, ' ', i6, false, 4, null);
        if (N2 == -1) {
            substring = str.substring(i6);
            l.c(substring, "this as java.lang.String).substring(startIndex)");
            String str2 = REMOVE;
            if (N == str2.length()) {
                y8 = w.y(str, str2, false, 2, null);
                if (y8) {
                    this.lruEntries.remove(substring);
                    return;
                }
            }
        } else {
            substring = str.substring(i6, N2);
            l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        Entry entry = this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(this, substring);
            this.lruEntries.put(substring, entry);
        }
        if (N2 != -1) {
            String str3 = CLEAN;
            if (N == str3.length()) {
                y7 = w.y(str, str3, false, 2, null);
                if (y7) {
                    String substring2 = str.substring(N2 + 1);
                    l.c(substring2, "this as java.lang.String).substring(startIndex)");
                    j02 = x.j0(substring2, new char[]{' '}, false, 0, 6, null);
                    entry.setReadable$okhttp(true);
                    entry.setCurrentEditor$okhttp(null);
                    entry.setLengths$okhttp(j02);
                    return;
                }
            }
        }
        if (N2 == -1) {
            String str4 = DIRTY;
            if (N == str4.length()) {
                y6 = w.y(str, str4, false, 2, null);
                if (y6) {
                    entry.setCurrentEditor$okhttp(new Editor(this, entry));
                    return;
                }
            }
        }
        if (N2 == -1) {
            String str5 = READ;
            if (N == str5.length()) {
                y5 = w.y(str, str5, false, 2, null);
                if (y5) {
                    return;
                }
            }
        }
        throw new IOException(l.i("unexpected journal line: ", str));
    }

    private final boolean removeOldestEntry() {
        for (Entry entry : this.lruEntries.values()) {
            if (!entry.getZombie$okhttp()) {
                l.c(entry, "toEvict");
                removeEntry$okhttp(entry);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.matches(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Editor currentEditor$okhttp;
        if (this.initialized && !this.closed) {
            Collection<Entry> values = this.lruEntries.values();
            l.c(values, "lruEntries.values");
            int i6 = 0;
            Object[] array = values.toArray(new Entry[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            Entry[] entryArr = (Entry[]) array;
            int length = entryArr.length;
            while (i6 < length) {
                Entry entry = entryArr[i6];
                i6++;
                if (entry.getCurrentEditor$okhttp() != null && (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) != null) {
                    currentEditor$okhttp.detach$okhttp();
                }
            }
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            l.b(bufferedSink);
            bufferedSink.close();
            this.journalWriter = null;
            this.closed = true;
            return;
        }
        this.closed = true;
    }

    public final synchronized void completeEdit$okhttp(Editor editor, boolean z5) {
        l.d(editor, "editor");
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (!l.a(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        int i6 = 0;
        if (z5 && !entry$okhttp.getReadable$okhttp()) {
            int i7 = this.valueCount;
            int i8 = 0;
            while (i8 < i7) {
                int i9 = i8 + 1;
                boolean[] written$okhttp = editor.getWritten$okhttp();
                l.b(written$okhttp);
                if (!written$okhttp[i8]) {
                    editor.abort();
                    throw new IllegalStateException(l.i("Newly created entry didn't create value for index ", Integer.valueOf(i8)));
                } else if (!this.fileSystem.exists(entry$okhttp.getDirtyFiles$okhttp().get(i8))) {
                    editor.abort();
                    return;
                } else {
                    i8 = i9;
                }
            }
        }
        int i10 = this.valueCount;
        while (i6 < i10) {
            int i11 = i6 + 1;
            File file = entry$okhttp.getDirtyFiles$okhttp().get(i6);
            if (!z5 || entry$okhttp.getZombie$okhttp()) {
                this.fileSystem.delete(file);
            } else if (this.fileSystem.exists(file)) {
                File file2 = entry$okhttp.getCleanFiles$okhttp().get(i6);
                this.fileSystem.rename(file, file2);
                long j6 = entry$okhttp.getLengths$okhttp()[i6];
                long size = this.fileSystem.size(file2);
                entry$okhttp.getLengths$okhttp()[i6] = size;
                this.size = (this.size - j6) + size;
            }
            i6 = i11;
        }
        entry$okhttp.setCurrentEditor$okhttp(null);
        if (entry$okhttp.getZombie$okhttp()) {
            removeEntry$okhttp(entry$okhttp);
            return;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        l.b(bufferedSink);
        if (!entry$okhttp.getReadable$okhttp() && !z5) {
            getLruEntries$okhttp().remove(entry$okhttp.getKey$okhttp());
            bufferedSink.writeUtf8(REMOVE).writeByte(32);
            bufferedSink.writeUtf8(entry$okhttp.getKey$okhttp());
            bufferedSink.writeByte(10);
            bufferedSink.flush();
            if (this.size <= this.maxSize || journalRebuildRequired()) {
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            }
        }
        entry$okhttp.setReadable$okhttp(true);
        bufferedSink.writeUtf8(CLEAN).writeByte(32);
        bufferedSink.writeUtf8(entry$okhttp.getKey$okhttp());
        entry$okhttp.writeLengths$okhttp(bufferedSink);
        bufferedSink.writeByte(10);
        if (z5) {
            long j7 = this.nextSequenceNumber;
            this.nextSequenceNumber = 1 + j7;
            entry$okhttp.setSequenceNumber$okhttp(j7);
        }
        bufferedSink.flush();
        if (this.size <= this.maxSize) {
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }

    public final void delete() {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final Editor edit(String str) {
        l.d(str, "key");
        return edit$default(this, str, 0L, 2, null);
    }

    public final synchronized void evictAll() {
        initialize();
        Collection<Entry> values = this.lruEntries.values();
        l.c(values, "lruEntries.values");
        Object[] array = values.toArray(new Entry[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        Entry[] entryArr = (Entry[]) array;
        int length = entryArr.length;
        int i6 = 0;
        while (i6 < length) {
            Entry entry = entryArr[i6];
            i6++;
            l.c(entry, "entry");
            removeEntry$okhttp(entry);
        }
        this.mostRecentTrimFailed = false;
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            l.b(bufferedSink);
            bufferedSink.flush();
        }
    }

    public final synchronized Snapshot get(String str) {
        l.d(str, "key");
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        Snapshot snapshot$okhttp = entry.snapshot$okhttp();
        if (snapshot$okhttp == null) {
            return null;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        l.b(bufferedSink);
        bufferedSink.writeUtf8(READ).writeByte(32).writeUtf8(str).writeByte(10);
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return snapshot$okhttp;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        if (this.initialized) {
            return;
        }
        if (this.fileSystem.exists(this.journalFileBackup)) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.rename(this.journalFileBackup, this.journalFile);
            }
        }
        this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);
        if (this.fileSystem.exists(this.journalFile)) {
            try {
                readJournal();
                processJournal();
                this.initialized = true;
                return;
            } catch (IOException e6) {
                Platform platform = Platform.Companion.get();
                platform.log("DiskLruCache " + this.directory + " is corrupt: " + ((Object) e6.getMessage()) + ", removing", 5, e6);
                delete();
                this.closed = false;
            }
        }
        rebuildJournal$okhttp();
        this.initialized = true;
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public final synchronized void rebuildJournal$okhttp() {
        BufferedSink bufferedSink = this.journalWriter;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        BufferedSink buffer = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
        buffer.writeUtf8(MAGIC).writeByte(10);
        buffer.writeUtf8(VERSION_1).writeByte(10);
        buffer.writeDecimalLong(this.appVersion).writeByte(10);
        buffer.writeDecimalLong(getValueCount$okhttp()).writeByte(10);
        buffer.writeByte(10);
        for (Entry entry : getLruEntries$okhttp().values()) {
            if (entry.getCurrentEditor$okhttp() != null) {
                buffer.writeUtf8(DIRTY).writeByte(32);
                buffer.writeUtf8(entry.getKey$okhttp());
            } else {
                buffer.writeUtf8(CLEAN).writeByte(32);
                buffer.writeUtf8(entry.getKey$okhttp());
                entry.writeLengths$okhttp(buffer);
            }
            buffer.writeByte(10);
        }
        q qVar = q.f10774a;
        a.a(buffer, null);
        if (this.fileSystem.exists(this.journalFile)) {
            this.fileSystem.rename(this.journalFile, this.journalFileBackup);
        }
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);
        this.fileSystem.delete(this.journalFileBackup);
        this.journalWriter = newJournalWriter();
        this.hasJournalErrors = false;
        this.mostRecentRebuildFailed = false;
    }

    public final synchronized boolean remove(String str) {
        l.d(str, "key");
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return false;
        }
        boolean removeEntry$okhttp = removeEntry$okhttp(entry);
        if (removeEntry$okhttp && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return removeEntry$okhttp;
    }

    public final boolean removeEntry$okhttp(Entry entry) {
        BufferedSink bufferedSink;
        l.d(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (bufferedSink = this.journalWriter) != null) {
                bufferedSink.writeUtf8(DIRTY);
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(entry.getKey$okhttp());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i6 = this.valueCount;
        for (int i7 = 0; i7 < i6; i7++) {
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i7));
            this.size -= entry.getLengths$okhttp()[i7];
            entry.getLengths$okhttp()[i7] = 0;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey$okhttp());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z5) {
        this.closed = z5;
    }

    public final synchronized void setMaxSize(long j6) {
        this.maxSize = j6;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final synchronized long size() {
        initialize();
        return this.size;
    }

    public final synchronized Iterator<Snapshot> snapshots() {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    public final void trimToSize() {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    public final synchronized Editor edit(String str, long j6) {
        l.d(str, "key");
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (j6 == ANY_SEQUENCE_NUMBER || (entry != null && entry.getSequenceNumber$okhttp() == j6)) {
            if ((entry == null ? null : entry.getCurrentEditor$okhttp()) != null) {
                return null;
            }
            if (entry == null || entry.getLockingSourceCount$okhttp() == 0) {
                if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
                    BufferedSink bufferedSink = this.journalWriter;
                    l.b(bufferedSink);
                    bufferedSink.writeUtf8(DIRTY).writeByte(32).writeUtf8(str).writeByte(10);
                    bufferedSink.flush();
                    if (this.hasJournalErrors) {
                        return null;
                    }
                    if (entry == null) {
                        entry = new Entry(this, str);
                        this.lruEntries.put(str, entry);
                    }
                    Editor editor = new Editor(this, entry);
                    entry.setCurrentEditor$okhttp(editor);
                    return editor;
                }
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
                return null;
            }
            return null;
        }
        return null;
    }
}
