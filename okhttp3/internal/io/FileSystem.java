package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.l;
import okio.Okio;
import okio.Okio__JvmOkioKt;
import okio.Sink;
import okio.Source;
/* loaded from: classes.dex */
public interface FileSystem {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* loaded from: classes.dex */
        private static final class SystemFileSystem implements FileSystem {
            @Override // okhttp3.internal.io.FileSystem
            public Sink appendingSink(File file) {
                l.d(file, "file");
                try {
                    return Okio.appendingSink(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.appendingSink(file);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void delete(File file) {
                l.d(file, "file");
                if (!file.delete() && file.exists()) {
                    throw new IOException(l.i("failed to delete ", file));
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void deleteContents(File file) {
                l.d(file, "directory");
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    throw new IOException(l.i("not a readable directory: ", file));
                }
                int length = listFiles.length;
                int i6 = 0;
                while (i6 < length) {
                    File file2 = listFiles[i6];
                    i6++;
                    if (file2.isDirectory()) {
                        l.c(file2, "file");
                        deleteContents(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException(l.i("failed to delete ", file2));
                    }
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean exists(File file) {
                l.d(file, "file");
                return file.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public void rename(File file, File file2) {
                l.d(file, "from");
                l.d(file2, "to");
                delete(file2);
                if (file.renameTo(file2)) {
                    return;
                }
                throw new IOException("failed to rename " + file + " to " + file2);
            }

            @Override // okhttp3.internal.io.FileSystem
            public Sink sink(File file) {
                Sink sink$default;
                Sink sink$default2;
                l.d(file, "file");
                try {
                    sink$default2 = Okio__JvmOkioKt.sink$default(file, false, 1, null);
                    return sink$default2;
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    sink$default = Okio__JvmOkioKt.sink$default(file, false, 1, null);
                    return sink$default;
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public long size(File file) {
                l.d(file, "file");
                return file.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            public Source source(File file) {
                l.d(file, "file");
                return Okio.source(file);
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }
    }

    Sink appendingSink(File file);

    void delete(File file);

    void deleteContents(File file);

    boolean exists(File file);

    void rename(File file, File file2);

    Sink sink(File file);

    long size(File file);

    Source source(File file);
}
