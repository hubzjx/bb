package okio;
/* loaded from: classes.dex */
final class ForwardingFileSystem$listRecursively$1 extends kotlin.jvm.internal.m implements p4.l {
    final /* synthetic */ ForwardingFileSystem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForwardingFileSystem$listRecursively$1(ForwardingFileSystem forwardingFileSystem) {
        super(1);
        this.this$0 = forwardingFileSystem;
    }

    @Override // p4.l
    public final Path invoke(Path path) {
        kotlin.jvm.internal.l.d(path, "it");
        return this.this$0.onPathResult(path, "listRecursively");
    }
}
