package okio;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class ForwardingFileSystem extends FileSystem {
    private final FileSystem delegate;

    public ForwardingFileSystem(FileSystem fileSystem) {
        kotlin.jvm.internal.l.d(fileSystem, "delegate");
        this.delegate = fileSystem;
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "file");
        return this.delegate.appendingSink(onPathParameter(path, "appendingSink", "file"), z5);
    }

    @Override // okio.FileSystem
    public void atomicMove(Path path, Path path2) {
        kotlin.jvm.internal.l.d(path, "source");
        kotlin.jvm.internal.l.d(path2, "target");
        this.delegate.atomicMove(onPathParameter(path, "atomicMove", "source"), onPathParameter(path2, "atomicMove", "target"));
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) {
        kotlin.jvm.internal.l.d(path, "path");
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", "path")), "canonicalize");
    }

    @Override // okio.FileSystem
    public void createDirectory(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "dir");
        this.delegate.createDirectory(onPathParameter(path, "createDirectory", "dir"), z5);
    }

    @Override // okio.FileSystem
    public void createSymlink(Path path, Path path2) {
        kotlin.jvm.internal.l.d(path, "source");
        kotlin.jvm.internal.l.d(path2, "target");
        this.delegate.createSymlink(onPathParameter(path, "createSymlink", "source"), onPathParameter(path2, "createSymlink", "target"));
    }

    public final FileSystem delegate() {
        return this.delegate;
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "path");
        this.delegate.delete(onPathParameter(path, "delete", "path"), z5);
    }

    @Override // okio.FileSystem
    public List<Path> list(Path path) {
        kotlin.jvm.internal.l.d(path, "dir");
        List<Path> list = this.delegate.list(onPathParameter(path, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        for (Path path2 : list) {
            arrayList.add(onPathResult(path2, "list"));
        }
        kotlin.collections.r.q(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path path) {
        kotlin.jvm.internal.l.d(path, "dir");
        List<Path> listOrNull = this.delegate.listOrNull(onPathParameter(path, "listOrNull", "dir"));
        if (listOrNull == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Path path2 : listOrNull) {
            arrayList.add(onPathResult(path2, "listOrNull"));
        }
        kotlin.collections.r.q(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    public t4.d listRecursively(Path path, boolean z5) {
        t4.d i6;
        kotlin.jvm.internal.l.d(path, "dir");
        i6 = t4.l.i(this.delegate.listRecursively(onPathParameter(path, "listRecursively", "dir"), z5), new ForwardingFileSystem$listRecursively$1(this));
        return i6;
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        FileMetadata copy;
        kotlin.jvm.internal.l.d(path, "path");
        FileMetadata metadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
        if (metadataOrNull == null) {
            return null;
        }
        if (metadataOrNull.getSymlinkTarget() == null) {
            return metadataOrNull;
        }
        copy = metadataOrNull.copy((r18 & 1) != 0 ? metadataOrNull.isRegularFile : false, (r18 & 2) != 0 ? metadataOrNull.isDirectory : false, (r18 & 4) != 0 ? metadataOrNull.symlinkTarget : onPathResult(metadataOrNull.getSymlinkTarget(), "metadataOrNull"), (r18 & 8) != 0 ? metadataOrNull.size : null, (r18 & 16) != 0 ? metadataOrNull.createdAtMillis : null, (r18 & 32) != 0 ? metadataOrNull.lastModifiedAtMillis : null, (r18 & 64) != 0 ? metadataOrNull.lastAccessedAtMillis : null, (r18 & 128) != 0 ? metadataOrNull.extras : null);
        return copy;
    }

    public Path onPathParameter(Path path, String str, String str2) {
        kotlin.jvm.internal.l.d(path, "path");
        kotlin.jvm.internal.l.d(str, "functionName");
        kotlin.jvm.internal.l.d(str2, "parameterName");
        return path;
    }

    public Path onPathResult(Path path, String str) {
        kotlin.jvm.internal.l.d(path, "path");
        kotlin.jvm.internal.l.d(str, "functionName");
        return path;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path path) {
        kotlin.jvm.internal.l.d(path, "file");
        return this.delegate.openReadOnly(onPathParameter(path, "openReadOnly", "file"));
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path path, boolean z5, boolean z6) {
        kotlin.jvm.internal.l.d(path, "file");
        return this.delegate.openReadWrite(onPathParameter(path, "openReadWrite", "file"), z5, z6);
    }

    @Override // okio.FileSystem
    public Sink sink(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "file");
        return this.delegate.sink(onPathParameter(path, "sink", "file"), z5);
    }

    @Override // okio.FileSystem
    public Source source(Path path) {
        kotlin.jvm.internal.l.d(path, "file");
        return this.delegate.source(onPathParameter(path, "source", "file"));
    }

    public String toString() {
        return kotlin.jvm.internal.s.b(getClass()).d() + '(' + this.delegate + ')';
    }
}
