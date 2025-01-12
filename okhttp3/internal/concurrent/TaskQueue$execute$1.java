package okhttp3.internal.concurrent;

import p4.a;
/* loaded from: classes.dex */
public final class TaskQueue$execute$1 extends Task {
    final /* synthetic */ a $block;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ String $name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(String str, boolean z5, a aVar) {
        super(str, z5);
        this.$name = str;
        this.$cancelable = z5;
        this.$block = aVar;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        this.$block.invoke();
        return -1L;
    }
}
