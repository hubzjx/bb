package l0;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import okhttp3.internal.http2.Http2;
/* loaded from: classes.dex */
final class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final File f11409a;

    /* renamed from: b  reason: collision with root package name */
    private final long f11410b;

    /* renamed from: c  reason: collision with root package name */
    private final File f11411c;

    /* renamed from: d  reason: collision with root package name */
    private final RandomAccessFile f11412d;

    /* renamed from: e  reason: collision with root package name */
    private final FileChannel f11413e;

    /* renamed from: f  reason: collision with root package name */
    private final FileLock f11414f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0190b extends File {
        public long crc;

        public C0190b(File file, String str) {
            super(file, str);
            this.crc = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(File file, File file2) {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f11409a = file;
        this.f11411c = file2;
        this.f11410b = f(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f11412d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f11413e = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f11414f = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e6) {
                e = e6;
                b(this.f11413e);
                throw e;
            } catch (Error e7) {
                e = e7;
                b(this.f11413e);
                throw e;
            } catch (RuntimeException e8) {
                e = e8;
                b(this.f11413e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e9) {
            b(this.f11412d);
            throw e9;
        }
    }

    private void a() {
        File[] listFiles = this.f11411c.listFiles(new a());
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f11411c.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            }
        }
    }

    private static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e6) {
            Log.w("MultiDex", "Failed to close resource", e6);
        }
    }

    private static void c(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (!createTempFile.setReadOnly()) {
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            }
            Log.i("MultiDex", "Renaming to " + file.getPath());
            if (createTempFile.renameTo(file)) {
                return;
            }
            throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
        } finally {
            b(inputStream);
            createTempFile.delete();
        }
    }

    private static SharedPreferences d(Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }

    private static long e(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long f(File file) {
        long c6 = c.c(file);
        return c6 == -1 ? c6 - 1 : c6;
    }

    private static boolean g(Context context, File file, long j6, String str) {
        SharedPreferences d6 = d(context);
        if (d6.getLong(str + "timestamp", -1L) == e(file)) {
            if (d6.getLong(str + "crc", -1L) == j6) {
                return false;
            }
        }
        return true;
    }

    private List i(Context context, String str) {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.f11409a.getName() + ".classes";
        SharedPreferences d6 = d(context);
        int i6 = d6.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i6 + (-1));
        int i7 = 2;
        while (i7 <= i6) {
            C0190b c0190b = new C0190b(this.f11411c, str2 + i7 + ".zip");
            if (!c0190b.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + c0190b.getPath() + "'");
            }
            c0190b.crc = f(c0190b);
            long j6 = d6.getLong(str + "dex.crc." + i7, -1L);
            long j7 = d6.getLong(str + "dex.time." + i7, -1L);
            long lastModified = c0190b.lastModified();
            if (j7 == lastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = d6;
                if (j6 == c0190b.crc) {
                    arrayList.add(c0190b);
                    i7++;
                    d6 = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + c0190b + " (key \"" + str + "\"), expected modification time: " + j7 + ", modification time: " + lastModified + ", expected crc: " + j6 + ", file crc: " + c0190b.crc);
        }
        return arrayList;
    }

    private List j() {
        boolean z5;
        String str = this.f11409a.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f11409a);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i6 = 2;
            while (entry != null) {
                C0190b c0190b = new C0190b(this.f11411c, str + i6 + ".zip");
                arrayList.add(c0190b);
                Log.i("MultiDex", "Extraction is needed for file " + c0190b);
                int i7 = 0;
                boolean z6 = false;
                while (i7 < 3 && !z6) {
                    int i8 = i7 + 1;
                    c(zipFile, entry, c0190b, str);
                    try {
                        c0190b.crc = f(c0190b);
                        z5 = true;
                    } catch (IOException e6) {
                        Log.w("MultiDex", "Failed to read crc from " + c0190b.getAbsolutePath(), e6);
                        z5 = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z5 ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(c0190b.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(c0190b.length());
                    sb.append(" - crc: ");
                    sb.append(c0190b.crc);
                    Log.i("MultiDex", sb.toString());
                    if (!z5) {
                        c0190b.delete();
                        if (c0190b.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + c0190b.getPath() + "'");
                        }
                    }
                    z6 = z5;
                    i7 = i8;
                }
                if (!z6) {
                    throw new IOException("Could not create zip file " + c0190b.getAbsolutePath() + " for secondary dex (" + i6 + ")");
                }
                i6++;
                entry = zipFile.getEntry("classes" + i6 + ".dex");
            }
            try {
                zipFile.close();
            } catch (IOException e7) {
                Log.w("MultiDex", "Failed to close resource", e7);
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (IOException e8) {
                Log.w("MultiDex", "Failed to close resource", e8);
            }
            throw th;
        }
    }

    private static void k(Context context, String str, long j6, long j7, List list) {
        SharedPreferences.Editor edit = d(context).edit();
        edit.putLong(str + "timestamp", j6);
        edit.putLong(str + "crc", j7);
        edit.putInt(str + "dex.number", list.size() + 1);
        Iterator it = list.iterator();
        int i6 = 2;
        while (it.hasNext()) {
            C0190b c0190b = (C0190b) it.next();
            edit.putLong(str + "dex.crc." + i6, c0190b.crc);
            edit.putLong(str + "dex.time." + i6, c0190b.lastModified());
            i6++;
        }
        edit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11414f.release();
        this.f11413e.close();
        this.f11412d.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List h(Context context, String str, boolean z5) {
        List list;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f11409a.getPath() + ", " + z5 + ", " + str + ")");
        if (this.f11414f.isValid()) {
            if (!z5 && !g(context, this.f11409a, this.f11410b, str)) {
                try {
                    list = i(context, str);
                } catch (IOException e6) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e6);
                }
                Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
                return list;
            }
            Log.i("MultiDex", z5 ? "Forced extraction must be performed." : "Detected that extraction must be performed.");
            List j6 = j();
            k(context, str, e(this.f11409a), this.f11410b, j6);
            list = j6;
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
}
