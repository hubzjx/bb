package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import okio.Path;
/* loaded from: classes.dex */
public class JvmSystemFileSystem extends FileSystem {
    private final void requireCreate(Path path) {
        if (exists(path)) {
            throw new IOException(path + " already exists.");
        }
    }

    private final void requireExist(Path path) {
        if (exists(path)) {
            return;
        }
        throw new IOException(path + " doesn't exist.");
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "file");
        if (z5) {
            requireExist(path);
        }
        return Okio.sink(path.toFile(), true);
    }

    @Override // okio.FileSystem
    public void atomicMove(Path path, Path path2) {
        kotlin.jvm.internal.l.d(path, "source");
        kotlin.jvm.internal.l.d(path2, "target");
        if (path.toFile().renameTo(path2.toFile())) {
            return;
        }
        throw new IOException("failed to move " + path + " to " + path2);
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) {
        kotlin.jvm.internal.l.d(path, "path");
        File canonicalFile = path.toFile().getCanonicalFile();
        if (canonicalFile.exists()) {
            Path.Companion companion = Path.Companion;
            kotlin.jvm.internal.l.c(canonicalFile, "canonicalFile");
            return Path.Companion.get$default(companion, canonicalFile, false, 1, (Object) null);
        }
        throw new FileNotFoundException("no such file");
    }

    @Override // okio.FileSystem
    public void createDirectory(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "dir");
        if (path.toFile().mkdir()) {
            return;
        }
        FileMetadata metadataOrNull = metadataOrNull(path);
        boolean z6 = false;
        if (metadataOrNull != null && metadataOrNull.isDirectory()) {
            z6 = true;
        }
        if (!z6) {
            throw new IOException("failed to create directory: " + path);
        } else if (z5) {
            throw new IOException(path + " already exist.");
        }
    }

    @Override // okio.FileSystem
    public void createSymlink(Path path, Path path2) {
        kotlin.jvm.internal.l.d(path, "source");
        kotlin.jvm.internal.l.d(path2, "target");
        throw new IOException("unsupported");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "path");
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException("failed to delete " + path);
        } else if (z5) {
            throw new FileNotFoundException("no such file: " + path);
        }
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
        kotlin.jvm.internal.l.d(path, "path");
        File file = path.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (isFile || isDirectory || lastModified != 0 || length != 0 || file.exists()) {
            return new FileMetadata(isFile, isDirectory, null, Long.valueOf(length), null, Long.valueOf(lastModified), null, null, 128, null);
        }
        return null;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path path) {
        kotlin.jvm.internal.l.d(path, "file");
        return new JvmFileHandle(false, new RandomAccessFile(path.toFile(), "r"));
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path path, boolean z5, boolean z6) {
        kotlin.jvm.internal.l.d(path, "file");
        if ((z5 && z6) ? false : true) {
            if (z5) {
                requireCreate(path);
            }
            if (z6) {
                requireExist(path);
            }
            return new JvmFileHandle(true, new RandomAccessFile(path.toFile(), "rw"));
        }
        throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
    }

    @Override // okio.FileSystem
    public Sink sink(Path path, boolean z5) {
        Sink sink$default;
        kotlin.jvm.internal.l.d(path, "file");
        if (z5) {
            requireCreate(path);
        }
        sink$default = Okio__JvmOkioKt.sink$default(path.toFile(), false, 1, null);
        return sink$default;
    }

    @Override // okio.FileSystem
    public Source source(Path path) {
        kotlin.jvm.internal.l.d(path, "file");
        return Okio.source(path.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }

    private final List<Path> list(Path path, boolean z5) {
        File file = path.toFile();
        String[] list = file.list();
        if (list == null) {
            if (z5) {
                if (file.exists()) {
                    throw new IOException("failed to list " + path);
                }
                throw new FileNotFoundException("no such file: " + path);
            } else {
                return null;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            kotlin.jvm.internal.l.c(str, "it");
            arrayList.add(path.resolve(str));
        }
        kotlin.collections.r.q(arrayList);
        return arrayList;
    }
}
