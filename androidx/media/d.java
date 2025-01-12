package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
abstract class d {

    /* renamed from: a  reason: collision with root package name */
    static Field f2110a;

    /* loaded from: classes.dex */
    static class a extends c.a {
        a(Context context, c cVar) {
            super(context, cVar);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((c) this.f2108b).e(str, new b(result), bundle);
        }
    }

    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        MediaBrowserService.Result f2111a;

        b(MediaBrowserService.Result result) {
            this.f2111a = result;
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

        public void b(List list, int i6) {
            try {
                d.f2110a.setInt(this.f2111a, i6);
            } catch (IllegalAccessException e6) {
                Log.w("MBSCompatApi26", e6);
            }
            this.f2111a.sendResult(a(list));
        }
    }

    /* loaded from: classes.dex */
    public interface c extends c.b {
        void e(String str, b bVar, Bundle bundle);
    }

    static {
        try {
            Field declaredField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            f2110a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e6) {
            Log.w("MBSCompatApi26", e6);
        }
    }

    public static Object a(Context context, c cVar) {
        return new a(context, cVar);
    }
}
