package okio.internal;

import androidx.constraintlayout.widget.g;
import h4.l;
import h4.q;
import j4.a;
import java.util.Iterator;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.jvm.internal.e;
import kotlin.coroutines.jvm.internal.j;
import okio.FileSystem;
import okio.Path;
import p4.p;
import t4.f;
/* JADX INFO: Access modifiers changed from: package-private */
@e(c = "okio.internal._FileSystemKt$commonListRecursively$1", f = "-FileSystem.kt", l = {g.L0}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class _FileSystemKt$commonListRecursively$1 extends j implements p {
    final /* synthetic */ Path $dir;
    final /* synthetic */ boolean $followSymlinks;
    final /* synthetic */ FileSystem $this_commonListRecursively;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _FileSystemKt$commonListRecursively$1(Path path, FileSystem fileSystem, boolean z5, a aVar) {
        super(2, aVar);
        this.$dir = path;
        this.$this_commonListRecursively = fileSystem;
        this.$followSymlinks = z5;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final a create(Object obj, a aVar) {
        _FileSystemKt$commonListRecursively$1 _filesystemkt_commonlistrecursively_1 = new _FileSystemKt$commonListRecursively$1(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, aVar);
        _filesystemkt_commonlistrecursively_1.L$0 = obj;
        return _filesystemkt_commonlistrecursively_1;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object b6;
        _FileSystemKt$commonListRecursively$1 _filesystemkt_commonlistrecursively_1;
        f fVar;
        kotlin.collections.e eVar;
        Iterator<Path> it;
        b6 = d.b();
        int i6 = this.label;
        if (i6 == 0) {
            l.b(obj);
            kotlin.collections.e eVar2 = new kotlin.collections.e();
            eVar2.d(this.$dir);
            _filesystemkt_commonlistrecursively_1 = this;
            fVar = (f) this.L$0;
            eVar = eVar2;
            it = this.$this_commonListRecursively.list(this.$dir).iterator();
        } else if (i6 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            it = (Iterator) this.L$2;
            l.b(obj);
            _filesystemkt_commonlistrecursively_1 = this;
            eVar = (kotlin.collections.e) this.L$1;
            fVar = (f) this.L$0;
        }
        while (it.hasNext()) {
            Path next = it.next();
            FileSystem fileSystem = _filesystemkt_commonlistrecursively_1.$this_commonListRecursively;
            boolean z5 = _filesystemkt_commonlistrecursively_1.$followSymlinks;
            _filesystemkt_commonlistrecursively_1.L$0 = fVar;
            _filesystemkt_commonlistrecursively_1.L$1 = eVar;
            _filesystemkt_commonlistrecursively_1.L$2 = it;
            _filesystemkt_commonlistrecursively_1.label = 1;
            if (_FileSystemKt.collectRecursively(fVar, fileSystem, eVar, next, z5, false, _filesystemkt_commonlistrecursively_1) == b6) {
                return b6;
            }
        }
        return q.f10774a;
    }

    @Override // p4.p
    public final Object invoke(f fVar, a aVar) {
        return ((_FileSystemKt$commonListRecursively$1) create(fVar, aVar)).invokeSuspend(q.f10774a);
    }
}
