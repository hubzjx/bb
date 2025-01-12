package androidx.media;

import android.content.Context;
import android.service.media.MediaBrowserService;
import androidx.media.b;
/* loaded from: classes.dex */
abstract class c {

    /* loaded from: classes.dex */
    static class a extends b.C0019b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Context context, b bVar) {
            super(context, bVar);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String str, MediaBrowserService.Result result) {
            ((b) this.f2108b).c(str, new b.c(result));
        }
    }

    /* loaded from: classes.dex */
    public interface b extends b.d {
        void c(String str, b.c cVar);
    }

    public static Object a(Context context, b bVar) {
        return new a(context, bVar);
    }
}
