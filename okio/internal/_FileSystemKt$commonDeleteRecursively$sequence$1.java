package okio.internal;

import h4.l;
import h4.q;
import j4.a;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.jvm.internal.e;
import kotlin.coroutines.jvm.internal.j;
import okio.FileSystem;
import okio.Path;
import p4.p;
import t4.f;
/* JADX INFO: Access modifiers changed from: package-private */
@e(c = "okio.internal._FileSystemKt$commonDeleteRecursively$sequence$1", f = "-FileSystem.kt", l = {72}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class _FileSystemKt$commonDeleteRecursively$sequence$1 extends j implements p {
    final /* synthetic */ Path $fileOrDirectory;
    final /* synthetic */ FileSystem $this_commonDeleteRecursively;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _FileSystemKt$commonDeleteRecursively$sequence$1(FileSystem fileSystem, Path path, a aVar) {
        super(2, aVar);
        this.$this_commonDeleteRecursively = fileSystem;
        this.$fileOrDirectory = path;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final a create(Object obj, a aVar) {
        _FileSystemKt$commonDeleteRecursively$sequence$1 _filesystemkt_commondeleterecursively_sequence_1 = new _FileSystemKt$commonDeleteRecursively$sequence$1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, aVar);
        _filesystemkt_commondeleterecursively_sequence_1.L$0 = obj;
        return _filesystemkt_commondeleterecursively_sequence_1;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object b6;
        b6 = d.b();
        int i6 = this.label;
        if (i6 == 0) {
            l.b(obj);
            FileSystem fileSystem = this.$this_commonDeleteRecursively;
            kotlin.collections.e eVar = new kotlin.collections.e();
            Path path = this.$fileOrDirectory;
            this.label = 1;
            if (_FileSystemKt.collectRecursively((f) this.L$0, fileSystem, eVar, path, false, true, this) == b6) {
                return b6;
            }
        } else if (i6 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            l.b(obj);
        }
        return q.f10774a;
    }

    @Override // p4.p
    public final Object invoke(f fVar, a aVar) {
        return ((_FileSystemKt$commonDeleteRecursively$sequence$1) create(fVar, aVar)).invokeSuspend(q.f10774a);
    }
}
