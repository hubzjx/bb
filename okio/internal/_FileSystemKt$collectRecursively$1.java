package okio.internal;

import j4.a;
import kotlin.coroutines.jvm.internal.c;
import kotlin.coroutines.jvm.internal.e;
/* JADX INFO: Access modifiers changed from: package-private */
@e(c = "okio.internal._FileSystemKt", f = "-FileSystem.kt", l = {113, 132, 142}, m = "collectRecursively")
/* loaded from: classes.dex */
public final class _FileSystemKt$collectRecursively$1 extends c {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _FileSystemKt$collectRecursively$1(a aVar) {
        super(aVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return _FileSystemKt.collectRecursively(null, null, null, null, false, false, this);
    }
}
