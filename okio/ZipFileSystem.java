package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.collections.v;
import okio.Path;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipKt;
/* loaded from: classes.dex */
public final class ZipFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
    private final String comment;
    private final Map<Path, ZipEntry> entries;
    private final FileSystem fileSystem;
    private final Path zipPath;

    /* loaded from: classes.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }
    }

    public ZipFileSystem(Path path, FileSystem fileSystem, Map<Path, ZipEntry> map, String str) {
        kotlin.jvm.internal.l.d(path, "zipPath");
        kotlin.jvm.internal.l.d(fileSystem, "fileSystem");
        kotlin.jvm.internal.l.d(map, "entries");
        this.zipPath = path;
        this.fileSystem = fileSystem;
        this.entries = map;
        this.comment = str;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(Path path, Path path2) {
        kotlin.jvm.internal.l.d(path, "source");
        kotlin.jvm.internal.l.d(path2, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) {
        kotlin.jvm.internal.l.d(path, "path");
        Path canonicalizeInternal = canonicalizeInternal(path);
        if (this.entries.containsKey(canonicalizeInternal)) {
            return canonicalizeInternal;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    @Override // okio.FileSystem
    public void createDirectory(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(Path path, Path path2) {
        kotlin.jvm.internal.l.d(path, "source");
        kotlin.jvm.internal.l.d(path2, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public List<Path> list(Path path) {
        kotlin.jvm.internal.l.d(path, "dir");
        List<Path> list = list(path, true);
        kotlin.jvm.internal.l.b(list);
        return list;
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path path) {
        kotlin.jvm.internal.l.d(path, "dir");
        return list(path, false);
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        BufferedSource bufferedSource;
        kotlin.jvm.internal.l.d(path, "path");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        Throwable th = null;
        if (zipEntry == null) {
            return null;
        }
        FileMetadata fileMetadata = new FileMetadata(!zipEntry.isDirectory(), zipEntry.isDirectory(), null, zipEntry.isDirectory() ? null : Long.valueOf(zipEntry.getSize()), null, zipEntry.getLastModifiedAtMillis(), null, null, 128, null);
        if (zipEntry.getOffset() == -1) {
            return fileMetadata;
        }
        FileHandle openReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        try {
            bufferedSource = Okio.buffer(openReadOnly.source(zipEntry.getOffset()));
        } catch (Throwable th2) {
            th = th2;
            bufferedSource = null;
        }
        if (openReadOnly != null) {
            try {
                openReadOnly.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    h4.b.a(th, th3);
                }
            }
        }
        if (th == null) {
            kotlin.jvm.internal.l.b(bufferedSource);
            return ZipKt.readLocalHeader(bufferedSource, fileMetadata);
        }
        throw th;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path path) {
        kotlin.jvm.internal.l.d(path, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path path, boolean z5, boolean z6) {
        kotlin.jvm.internal.l.d(path, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // okio.FileSystem
    public Sink sink(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public Source source(Path path) {
        BufferedSource bufferedSource;
        kotlin.jvm.internal.l.d(path, "file");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry == null) {
            throw new FileNotFoundException("no such file: " + path);
        }
        FileHandle openReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        Throwable th = null;
        try {
            bufferedSource = Okio.buffer(openReadOnly.source(zipEntry.getOffset()));
        } catch (Throwable th2) {
            bufferedSource = null;
            th = th2;
        }
        if (openReadOnly != null) {
            try {
                openReadOnly.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    h4.b.a(th, th3);
                }
            }
        }
        if (th == null) {
            kotlin.jvm.internal.l.b(bufferedSource);
            ZipKt.skipLocalHeader(bufferedSource);
            return zipEntry.getCompressionMethod() == 0 ? new FixedLengthSource(bufferedSource, zipEntry.getSize(), true) : new FixedLengthSource(new InflaterSource(new FixedLengthSource(bufferedSource, zipEntry.getCompressedSize(), true), new Inflater(true)), zipEntry.getSize(), false);
        }
        throw th;
    }

    private final List<Path> list(Path path, boolean z5) {
        List<Path> O;
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry != null) {
            O = v.O(zipEntry.getChildren());
            return O;
        } else if (z5) {
            throw new IOException("not a directory: " + path);
        } else {
            return null;
        }
    }
}
