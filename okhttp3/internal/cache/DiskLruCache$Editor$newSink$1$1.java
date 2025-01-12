package okhttp3.internal.cache;

import h4.q;
import java.io.IOException;
import kotlin.jvm.internal.m;
import okhttp3.internal.cache.DiskLruCache;
import p4.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class DiskLruCache$Editor$newSink$1$1 extends m implements l {
    final /* synthetic */ DiskLruCache this$0;
    final /* synthetic */ DiskLruCache.Editor this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Editor$newSink$1$1(DiskLruCache diskLruCache, DiskLruCache.Editor editor) {
        super(1);
        this.this$0 = diskLruCache;
        this.this$1 = editor;
    }

    @Override // p4.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IOException) obj);
        return q.f10774a;
    }

    public final void invoke(IOException iOException) {
        kotlin.jvm.internal.l.d(iOException, "it");
        DiskLruCache diskLruCache = this.this$0;
        DiskLruCache.Editor editor = this.this$1;
        synchronized (diskLruCache) {
            editor.detach$okhttp();
            q qVar = q.f10774a;
        }
    }
}
