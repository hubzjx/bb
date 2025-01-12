package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
abstract class b {

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final String f2106a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f2107b;
    }

    /* renamed from: androidx.media.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0019b extends MediaBrowserService {

        /* renamed from: b  reason: collision with root package name */
        final d f2108b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019b(Context context, d dVar) {
            attachBaseContext(context);
            this.f2108b = dVar;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i6, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            a f6 = this.f2108b.f(str, i6, bundle == null ? null : new Bundle(bundle));
            if (f6 == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(f6.f2106a, f6.f2107b);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result result) {
            this.f2108b.b(str, new c(result));
        }
    }

    /* loaded from: classes.dex */
    static class c {

        /* renamed from: a  reason: collision with root package name */
        MediaBrowserService.Result f2109a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(MediaBrowserService.Result result) {
            this.f2109a = result;
        }

        List a(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Parcel parcel = (Parcel) it.next();
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        public void b(Object obj) {
            if (obj instanceof List) {
                this.f2109a.sendResult(a((List) obj));
            } else if (!(obj instanceof Parcel)) {
                this.f2109a.sendResult(null);
            } else {
                Parcel parcel = (Parcel) obj;
                parcel.setDataPosition(0);
                this.f2109a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void b(String str, c cVar);

        a f(String str, int i6, Bundle bundle);
    }

    public static Object a(Context context, d dVar) {
        return new C0019b(context, dVar);
    }

    public static IBinder b(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    public static void c(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }
}
