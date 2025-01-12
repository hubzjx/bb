package okio.internal;

import h4.b;
import h4.l;
import h4.q;
import j4.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.e;
import kotlin.collections.n;
import kotlin.coroutines.intrinsics.d;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;
import t4.f;
import t4.h;
/* loaded from: classes.dex */
public final class _FileSystemKt {
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e1, code lost:
        if (r0 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e3, code lost:
        if (r14 != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e5, code lost:
        r6.d(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ec, code lost:
        r13 = r12;
        r12 = r11;
        r11 = r6;
        r6 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0130, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0131, code lost:
        r11 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object collectRecursively(f fVar, FileSystem fileSystem, e eVar, Path path, boolean z5, boolean z6, a aVar) {
        _FileSystemKt$collectRecursively$1 _filesystemkt_collectrecursively_1;
        Object b6;
        int i6;
        FileSystem fileSystem2;
        e eVar2;
        boolean z7;
        f fVar2;
        boolean z8;
        FileSystem fileSystem3;
        List<Path> listOrNull;
        Path path2 = path;
        boolean z9 = z6;
        if (aVar instanceof _FileSystemKt$collectRecursively$1) {
            _filesystemkt_collectrecursively_1 = (_FileSystemKt$collectRecursively$1) aVar;
            int i7 = _filesystemkt_collectrecursively_1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                _filesystemkt_collectrecursively_1.label = i7 - Integer.MIN_VALUE;
                Object obj = _filesystemkt_collectrecursively_1.result;
                b6 = d.b();
                i6 = _filesystemkt_collectrecursively_1.label;
                if (i6 != 0) {
                    l.b(obj);
                    if (z9) {
                        fileSystem2 = fileSystem;
                        eVar2 = eVar;
                        z7 = z5;
                    } else {
                        _filesystemkt_collectrecursively_1.L$0 = fVar;
                        fileSystem2 = fileSystem;
                        _filesystemkt_collectrecursively_1.L$1 = fileSystem2;
                        eVar2 = eVar;
                        _filesystemkt_collectrecursively_1.L$2 = eVar2;
                        _filesystemkt_collectrecursively_1.L$3 = path2;
                        z7 = z5;
                        _filesystemkt_collectrecursively_1.Z$0 = z7;
                        _filesystemkt_collectrecursively_1.Z$1 = z9;
                        _filesystemkt_collectrecursively_1.label = 1;
                        if (fVar.a(path2, _filesystemkt_collectrecursively_1) == b6) {
                            return b6;
                        }
                    }
                    fVar2 = fVar;
                    z8 = z7;
                    fileSystem3 = fileSystem2;
                } else if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 == 3) {
                            l.b(obj);
                            return q.f10774a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z10 = _filesystemkt_collectrecursively_1.Z$1;
                    boolean z11 = _filesystemkt_collectrecursively_1.Z$0;
                    Iterator<Path> it = (Iterator) _filesystemkt_collectrecursively_1.L$4;
                    Path path3 = (Path) _filesystemkt_collectrecursively_1.L$3;
                    e eVar3 = (e) _filesystemkt_collectrecursively_1.L$2;
                    FileSystem fileSystem4 = (FileSystem) _filesystemkt_collectrecursively_1.L$1;
                    f fVar3 = (f) _filesystemkt_collectrecursively_1.L$0;
                    try {
                        l.b(obj);
                        while (it.hasNext()) {
                            Path next = it.next();
                            boolean z12 = z10;
                            _filesystemkt_collectrecursively_1.L$0 = fVar3;
                            _filesystemkt_collectrecursively_1.L$1 = fileSystem4;
                            _filesystemkt_collectrecursively_1.L$2 = eVar3;
                            _filesystemkt_collectrecursively_1.L$3 = path3;
                            _filesystemkt_collectrecursively_1.L$4 = it;
                            _filesystemkt_collectrecursively_1.Z$0 = z11;
                            _filesystemkt_collectrecursively_1.Z$1 = z10;
                            _filesystemkt_collectrecursively_1.label = 2;
                            if (collectRecursively(fVar3, fileSystem4, eVar3, next, z11, z12, _filesystemkt_collectrecursively_1) == b6) {
                                return b6;
                            }
                        }
                        eVar3.m();
                        z9 = z10;
                        path2 = path3;
                        fVar2 = fVar3;
                        if (z9) {
                            _filesystemkt_collectrecursively_1.L$0 = null;
                            _filesystemkt_collectrecursively_1.L$1 = null;
                            _filesystemkt_collectrecursively_1.L$2 = null;
                            _filesystemkt_collectrecursively_1.L$3 = null;
                            _filesystemkt_collectrecursively_1.L$4 = null;
                            _filesystemkt_collectrecursively_1.label = 3;
                            if (fVar2.a(path2, _filesystemkt_collectrecursively_1) == b6) {
                                return b6;
                            }
                            return q.f10774a;
                        }
                        return q.f10774a;
                    } catch (Throwable th) {
                        th = th;
                        eVar3.m();
                        throw th;
                    }
                } else {
                    boolean z13 = _filesystemkt_collectrecursively_1.Z$1;
                    boolean z14 = _filesystemkt_collectrecursively_1.Z$0;
                    Path path4 = (Path) _filesystemkt_collectrecursively_1.L$3;
                    eVar2 = (e) _filesystemkt_collectrecursively_1.L$2;
                    fileSystem3 = (FileSystem) _filesystemkt_collectrecursively_1.L$1;
                    fVar2 = (f) _filesystemkt_collectrecursively_1.L$0;
                    l.b(obj);
                    z9 = z13;
                    z8 = z14;
                    path2 = path4;
                }
                listOrNull = fileSystem3.listOrNull(path2);
                if (listOrNull == null) {
                    listOrNull = n.f();
                }
                if (!listOrNull.isEmpty()) {
                    Path path5 = path2;
                    int i8 = 0;
                    while (true) {
                        if (z8 && eVar2.contains(path5)) {
                            throw new IOException("symlink cycle at " + path2);
                        }
                        Path symlinkTarget = symlinkTarget(fileSystem3, path5);
                        if (symlinkTarget == null) {
                            break;
                        }
                        i8++;
                        path5 = symlinkTarget;
                    }
                }
                if (z9) {
                }
            }
        }
        _filesystemkt_collectrecursively_1 = new _FileSystemKt$collectRecursively$1(aVar);
        Object obj2 = _filesystemkt_collectrecursively_1.result;
        b6 = d.b();
        i6 = _filesystemkt_collectrecursively_1.label;
        if (i6 != 0) {
        }
        listOrNull = fileSystem3.listOrNull(path2);
        if (listOrNull == null) {
        }
        if (!listOrNull.isEmpty()) {
        }
        if (z9) {
        }
    }

    public static final void commonCopy(FileSystem fileSystem, Path path, Path path2) {
        Long l6;
        Long l7;
        kotlin.jvm.internal.l.d(fileSystem, "<this>");
        kotlin.jvm.internal.l.d(path, "source");
        kotlin.jvm.internal.l.d(path2, "target");
        Source source = fileSystem.source(path);
        Throwable th = null;
        try {
            BufferedSink buffer = Okio.buffer(fileSystem.sink(path2));
            try {
                l7 = Long.valueOf(buffer.writeAll(source));
                th = null;
            } catch (Throwable th2) {
                th = th2;
                l7 = null;
            }
            if (buffer != null) {
                buffer.close();
            }
        } catch (Throwable th3) {
            th = th3;
            l6 = null;
        }
        if (th != null) {
            throw th;
        }
        kotlin.jvm.internal.l.b(l7);
        l6 = Long.valueOf(l7.longValue());
        if (source != null) {
            try {
                source.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                } else {
                    b.a(th, th4);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        kotlin.jvm.internal.l.b(l6);
    }

    public static final void commonCreateDirectories(FileSystem fileSystem, Path path, boolean z5) {
        kotlin.jvm.internal.l.d(fileSystem, "<this>");
        kotlin.jvm.internal.l.d(path, "dir");
        e eVar = new e();
        for (Path path2 = path; path2 != null && !fileSystem.exists(path2); path2 = path2.parent()) {
            eVar.c(path2);
        }
        if (z5 && eVar.isEmpty()) {
            throw new IOException(path + " already exist.");
        }
        Iterator<E> it = eVar.iterator();
        while (it.hasNext()) {
            fileSystem.createDirectory((Path) it.next());
        }
    }

    public static final void commonDeleteRecursively(FileSystem fileSystem, Path path, boolean z5) {
        t4.d b6;
        kotlin.jvm.internal.l.d(fileSystem, "<this>");
        kotlin.jvm.internal.l.d(path, "fileOrDirectory");
        b6 = h.b(new _FileSystemKt$commonDeleteRecursively$sequence$1(fileSystem, path, null));
        Iterator it = b6.iterator();
        while (it.hasNext()) {
            fileSystem.delete((Path) it.next(), z5 && !it.hasNext());
        }
    }

    public static final boolean commonExists(FileSystem fileSystem, Path path) {
        kotlin.jvm.internal.l.d(fileSystem, "<this>");
        kotlin.jvm.internal.l.d(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final t4.d commonListRecursively(FileSystem fileSystem, Path path, boolean z5) {
        t4.d b6;
        kotlin.jvm.internal.l.d(fileSystem, "<this>");
        kotlin.jvm.internal.l.d(path, "dir");
        b6 = h.b(new _FileSystemKt$commonListRecursively$1(path, fileSystem, z5, null));
        return b6;
    }

    public static final FileMetadata commonMetadata(FileSystem fileSystem, Path path) {
        kotlin.jvm.internal.l.d(fileSystem, "<this>");
        kotlin.jvm.internal.l.d(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final Path symlinkTarget(FileSystem fileSystem, Path path) {
        kotlin.jvm.internal.l.d(fileSystem, "<this>");
        kotlin.jvm.internal.l.d(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path parent = path.parent();
        kotlin.jvm.internal.l.b(parent);
        return parent.resolve(symlinkTarget);
    }
}
