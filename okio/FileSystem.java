package okio;

import java.util.List;
import okio.Path;
import okio.internal.ResourceFileSystem;
import okio.internal._FileSystemKt;
/* loaded from: classes.dex */
public abstract class FileSystem {
    public static final Companion Companion = new Companion(null);
    public static final FileSystem RESOURCES;
    public static final FileSystem SYSTEM;
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* renamed from: -write$default  reason: not valid java name */
    public static /* synthetic */ Object m173write$default(FileSystem fileSystem, Path path, boolean z5, p4.l lVar, int i6, Object obj) {
        Object obj2;
        if (obj == null) {
            if ((i6 & 2) != 0) {
                z5 = false;
            }
            kotlin.jvm.internal.l.d(path, "file");
            kotlin.jvm.internal.l.d(lVar, "writerAction");
            BufferedSink buffer = Okio.buffer(fileSystem.sink(path, z5));
            Throwable th = null;
            try {
                obj2 = lVar.invoke(buffer);
            } catch (Throwable th2) {
                obj2 = null;
                th = th2;
            }
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    } else {
                        h4.b.a(th, th3);
                    }
                }
            }
            if (th == null) {
                kotlin.jvm.internal.l.b(obj2);
                return obj2;
            }
            throw th;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
    }

    static {
        FileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        Path.Companion companion = Path.Companion;
        String property = System.getProperty("java.io.tmpdir");
        kotlin.jvm.internal.l.c(property, "getProperty(\"java.io.tmpdir\")");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        kotlin.jvm.internal.l.c(classLoader, "ResourceFileSystem::class.java.classLoader");
        RESOURCES = new ResourceFileSystem(classLoader, false);
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 2) != 0) {
                z5 = false;
            }
            return fileSystem.appendingSink(path, z5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
    }

    public static /* synthetic */ void createDirectories$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        fileSystem.createDirectories(path, z5);
    }

    public static /* synthetic */ void createDirectory$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        fileSystem.createDirectory(path, z5);
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        fileSystem.delete(path, z5);
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        fileSystem.deleteRecursively(path, z5);
    }

    public static /* synthetic */ t4.d listRecursively$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 2) != 0) {
                z5 = false;
            }
            return fileSystem.listRecursively(path, z5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean z5, boolean z6, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 2) != 0) {
                z5 = false;
            }
            if ((i6 & 4) != 0) {
                z6 = false;
            }
            return fileSystem.openReadWrite(path, z5, z6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
    }

    public static /* synthetic */ Sink sink$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 2) != 0) {
                z5 = false;
            }
            return fileSystem.sink(path, z5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    /* renamed from: -read  reason: not valid java name */
    public final <T> T m174read(Path path, p4.l lVar) {
        T t5;
        kotlin.jvm.internal.l.d(path, "file");
        kotlin.jvm.internal.l.d(lVar, "readerAction");
        BufferedSource buffer = Okio.buffer(source(path));
        Throwable th = null;
        try {
            t5 = (T) lVar.invoke(buffer);
        } catch (Throwable th2) {
            th = th2;
            t5 = null;
        }
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    h4.b.a(th, th3);
                }
            }
        }
        if (th == null) {
            kotlin.jvm.internal.l.b(t5);
            return t5;
        }
        throw th;
    }

    /* renamed from: -write  reason: not valid java name */
    public final <T> T m175write(Path path, boolean z5, p4.l lVar) {
        T t5;
        kotlin.jvm.internal.l.d(path, "file");
        kotlin.jvm.internal.l.d(lVar, "writerAction");
        BufferedSink buffer = Okio.buffer(sink(path, z5));
        Throwable th = null;
        try {
            t5 = (T) lVar.invoke(buffer);
        } catch (Throwable th2) {
            t5 = null;
            th = th2;
        }
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    h4.b.a(th, th3);
                }
            }
        }
        if (th == null) {
            kotlin.jvm.internal.l.b(t5);
            return t5;
        }
        throw th;
    }

    public final Sink appendingSink(Path path) {
        kotlin.jvm.internal.l.d(path, "file");
        return appendingSink(path, false);
    }

    public abstract Sink appendingSink(Path path, boolean z5);

    public abstract void atomicMove(Path path, Path path2);

    public abstract Path canonicalize(Path path);

    public void copy(Path path, Path path2) {
        kotlin.jvm.internal.l.d(path, "source");
        kotlin.jvm.internal.l.d(path2, "target");
        _FileSystemKt.commonCopy(this, path, path2);
    }

    public final void createDirectories(Path path) {
        kotlin.jvm.internal.l.d(path, "dir");
        createDirectories(path, false);
    }

    public final void createDirectory(Path path) {
        kotlin.jvm.internal.l.d(path, "dir");
        createDirectory(path, false);
    }

    public abstract void createDirectory(Path path, boolean z5);

    public abstract void createSymlink(Path path, Path path2);

    public final void delete(Path path) {
        kotlin.jvm.internal.l.d(path, "path");
        delete(path, false);
    }

    public abstract void delete(Path path, boolean z5);

    public final void deleteRecursively(Path path) {
        kotlin.jvm.internal.l.d(path, "fileOrDirectory");
        deleteRecursively(path, false);
    }

    public final boolean exists(Path path) {
        kotlin.jvm.internal.l.d(path, "path");
        return _FileSystemKt.commonExists(this, path);
    }

    public abstract List<Path> list(Path path);

    public abstract List<Path> listOrNull(Path path);

    public final t4.d listRecursively(Path path) {
        kotlin.jvm.internal.l.d(path, "dir");
        return listRecursively(path, false);
    }

    public final FileMetadata metadata(Path path) {
        kotlin.jvm.internal.l.d(path, "path");
        return _FileSystemKt.commonMetadata(this, path);
    }

    public abstract FileMetadata metadataOrNull(Path path);

    public abstract FileHandle openReadOnly(Path path);

    public final FileHandle openReadWrite(Path path) {
        kotlin.jvm.internal.l.d(path, "file");
        return openReadWrite(path, false, false);
    }

    public abstract FileHandle openReadWrite(Path path, boolean z5, boolean z6);

    public final Sink sink(Path path) {
        kotlin.jvm.internal.l.d(path, "file");
        return sink(path, false);
    }

    public abstract Sink sink(Path path, boolean z5);

    public abstract Source source(Path path);

    public final void createDirectories(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "dir");
        _FileSystemKt.commonCreateDirectories(this, path, z5);
    }

    public void deleteRecursively(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "fileOrDirectory");
        _FileSystemKt.commonDeleteRecursively(this, path, z5);
    }

    public t4.d listRecursively(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "dir");
        return _FileSystemKt.commonListRecursively(this, path, z5);
    }
}
