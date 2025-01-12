package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.b;
import androidx.media.c;
import androidx.media.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: g  reason: collision with root package name */
    static final boolean f2019g = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: b  reason: collision with root package name */
    private g f2020b;

    /* renamed from: d  reason: collision with root package name */
    f f2022d;

    /* renamed from: f  reason: collision with root package name */
    MediaSessionCompat.Token f2024f;

    /* renamed from: c  reason: collision with root package name */
    final l.a f2021c = new l.a();

    /* renamed from: e  reason: collision with root package name */
    final p f2023e = new p();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends l {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ f f2025f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f2026g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Bundle f2027h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ Bundle f2028i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, f fVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f2025f = fVar;
            this.f2026g = str;
            this.f2027h = bundle;
            this.f2028i = bundle2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h */
        public void d(List list) {
            if (MediaBrowserServiceCompat.this.f2021c.get(this.f2025f.f2041f.asBinder()) != this.f2025f) {
                if (MediaBrowserServiceCompat.f2019g) {
                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f2025f.f2036a + " id=" + this.f2026g);
                    return;
                }
                return;
            }
            if ((a() & 1) != 0) {
                list = MediaBrowserServiceCompat.this.b(list, this.f2027h);
            }
            try {
                this.f2025f.f2041f.b(this.f2026g, list, this.f2027h, this.f2028i);
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.f2026g + " package=" + this.f2025f.f2036a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends l {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ a.b f2030f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj, a.b bVar) {
            super(obj);
            this.f2030f = bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h */
        public void d(MediaBrowserCompat.MediaItem mediaItem) {
            if ((a() & 2) != 0) {
                this.f2030f.f(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", mediaItem);
            this.f2030f.f(0, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends l {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ a.b f2032f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object obj, a.b bVar) {
            super(obj);
            this.f2032f = bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h */
        public void d(List list) {
            if ((a() & 4) != 0 || list == null) {
                this.f2032f.f(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f2032f.f(0, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends l {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ a.b f2034f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Object obj, a.b bVar) {
            super(obj);
            this.f2034f = bVar;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.l
        void c(Bundle bundle) {
            this.f2034f.f(-1, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h */
        public void d(Bundle bundle) {
            this.f2034f.f(0, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static final class e {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        public final String f2036a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2037b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2038c;

        /* renamed from: d  reason: collision with root package name */
        public final androidx.media.e f2039d;

        /* renamed from: e  reason: collision with root package name */
        public final Bundle f2040e;

        /* renamed from: f  reason: collision with root package name */
        public final n f2041f;

        /* renamed from: g  reason: collision with root package name */
        public final HashMap f2042g = new HashMap();

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                MediaBrowserServiceCompat.this.f2021c.remove(fVar.f2041f.asBinder());
            }
        }

        f(String str, int i6, int i7, Bundle bundle, n nVar) {
            this.f2036a = str;
            this.f2037b = i6;
            this.f2038c = i7;
            this.f2039d = new androidx.media.e(str, i6, i7);
            this.f2040e = bundle;
            this.f2041f = nVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.f2023e.post(new a());
        }
    }

    /* loaded from: classes.dex */
    interface g {
        void a();

        IBinder d(Intent intent);
    }

    /* loaded from: classes.dex */
    class h implements g, b.d {

        /* renamed from: a  reason: collision with root package name */
        final List f2045a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        Object f2046b;

        /* renamed from: c  reason: collision with root package name */
        Messenger f2047c;

        /* loaded from: classes.dex */
        class a extends l {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ b.c f2049f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, b.c cVar) {
                super(obj);
                this.f2049f = cVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* renamed from: h */
            public void d(List list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Parcel obtain = Parcel.obtain();
                        ((MediaBrowserCompat.MediaItem) it.next()).writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f2049f.b(arrayList);
            }
        }

        h() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void a() {
            Object a6 = androidx.media.b.a(MediaBrowserServiceCompat.this, this);
            this.f2046b = a6;
            androidx.media.b.c(a6);
        }

        @Override // androidx.media.b.d
        public void b(String str, b.c cVar) {
            MediaBrowserServiceCompat.this.f(str, new a(str, cVar));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public IBinder d(Intent intent) {
            return androidx.media.b.b(this.f2046b, intent);
        }

        @Override // androidx.media.b.d
        public b.a f(String str, int i6, Bundle bundle) {
            if (bundle != null && bundle.getInt("extra_client_version", 0) != 0) {
                bundle.remove("extra_client_version");
                this.f2047c = new Messenger(MediaBrowserServiceCompat.this.f2023e);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                t.f.b(bundle2, "extra_messenger", this.f2047c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f2024f;
                if (token != null) {
                    android.support.v4.media.session.b g6 = token.g();
                    t.f.b(bundle2, "extra_session_binder", g6 == null ? null : g6.asBinder());
                } else {
                    this.f2045a.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f2022d = new f(str, -1, i6, bundle, null);
            MediaBrowserServiceCompat.this.e(str, i6, bundle);
            MediaBrowserServiceCompat.this.f2022d = null;
            return null;
        }
    }

    /* loaded from: classes.dex */
    class i extends h implements c.b {

        /* loaded from: classes.dex */
        class a extends l {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ b.c f2052f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, b.c cVar) {
                super(obj);
                this.f2052f = cVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* renamed from: h */
            public void d(MediaBrowserCompat.MediaItem mediaItem) {
                Parcel obtain;
                b.c cVar;
                if (mediaItem == null) {
                    cVar = this.f2052f;
                    obtain = null;
                } else {
                    obtain = Parcel.obtain();
                    mediaItem.writeToParcel(obtain, 0);
                    cVar = this.f2052f;
                }
                cVar.b(obtain);
            }
        }

        i() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.h, androidx.media.MediaBrowserServiceCompat.g
        public void a() {
            Object a6 = androidx.media.c.a(MediaBrowserServiceCompat.this, this);
            this.f2046b = a6;
            androidx.media.b.c(a6);
        }

        @Override // androidx.media.c.b
        public void c(String str, b.c cVar) {
            MediaBrowserServiceCompat.this.h(str, new a(str, cVar));
        }
    }

    /* loaded from: classes.dex */
    class j extends i implements d.c {

        /* loaded from: classes.dex */
        class a extends l {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ d.b f2055f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, d.b bVar) {
                super(obj);
                this.f2055f = bVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* renamed from: h */
            public void d(List list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Parcel obtain = Parcel.obtain();
                        ((MediaBrowserCompat.MediaItem) it.next()).writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f2055f.b(arrayList, a());
            }
        }

        j() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.i, androidx.media.MediaBrowserServiceCompat.h, androidx.media.MediaBrowserServiceCompat.g
        public void a() {
            Object a6 = androidx.media.d.a(MediaBrowserServiceCompat.this, this);
            this.f2046b = a6;
            androidx.media.b.c(a6);
        }

        @Override // androidx.media.d.c
        public void e(String str, d.b bVar, Bundle bundle) {
            MediaBrowserServiceCompat.this.g(str, new a(str, bVar), bundle);
        }
    }

    /* loaded from: classes.dex */
    class k extends j {
        k() {
            super();
        }
    }

    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a  reason: collision with root package name */
        private final Object f2058a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2059b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2060c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2061d;

        /* renamed from: e  reason: collision with root package name */
        private int f2062e;

        l(Object obj) {
            this.f2058a = obj;
        }

        int a() {
            return this.f2062e;
        }

        boolean b() {
            return this.f2059b || this.f2060c || this.f2061d;
        }

        void c(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f2058a);
        }

        abstract void d(Object obj);

        public void e(Bundle bundle) {
            if (!this.f2060c && !this.f2061d) {
                this.f2061d = true;
                c(bundle);
                return;
            }
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f2058a);
        }

        public void f(Object obj) {
            if (!this.f2060c && !this.f2061d) {
                this.f2060c = true;
                d(obj);
                return;
            }
            throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f2058a);
        }

        void g(int i6) {
            this.f2062e = i6;
        }
    }

    /* loaded from: classes.dex */
    private class m {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f2064a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f2065b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f2066c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f2067d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ Bundle f2068e;

            a(n nVar, String str, int i6, int i7, Bundle bundle) {
                this.f2064a = nVar;
                this.f2065b = str;
                this.f2066c = i6;
                this.f2067d = i7;
                this.f2068e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaBrowserServiceCompat.this.f2021c.remove(this.f2064a.asBinder());
                f fVar = new f(this.f2065b, this.f2066c, this.f2067d, this.f2068e, this.f2064a);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f2022d = fVar;
                mediaBrowserServiceCompat.e(this.f2065b, this.f2067d, this.f2068e);
                MediaBrowserServiceCompat.this.f2022d = null;
                Log.i("MBServiceCompat", "No root for client " + this.f2065b + " from service " + getClass().getName());
                try {
                    this.f2064a.a();
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.f2065b);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f2070a;

            b(n nVar) {
                this.f2070a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.f2021c.remove(this.f2070a.asBinder());
                if (fVar != null) {
                    fVar.f2041f.asBinder().unlinkToDeath(fVar, 0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f2072a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f2073b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ IBinder f2074c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Bundle f2075d;

            c(n nVar, String str, IBinder iBinder, Bundle bundle) {
                this.f2072a = nVar;
                this.f2073b = str;
                this.f2074c = iBinder;
                this.f2075d = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.f2021c.get(this.f2072a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.a(this.f2073b, fVar, this.f2074c, this.f2075d);
                    return;
                }
                Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.f2073b);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f2077a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f2078b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ IBinder f2079c;

            d(n nVar, String str, IBinder iBinder) {
                this.f2077a = nVar;
                this.f2078b = str;
                this.f2079c = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.f2021c.get(this.f2077a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.f2078b);
                } else if (MediaBrowserServiceCompat.this.p(this.f2078b, fVar, this.f2079c)) {
                } else {
                    Log.w("MBServiceCompat", "removeSubscription called for " + this.f2078b + " which is not subscribed");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class e implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f2081a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f2082b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ a.b f2083c;

            e(n nVar, String str, a.b bVar) {
                this.f2081a = nVar;
                this.f2082b = str;
                this.f2083c = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.f2021c.get(this.f2081a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.n(this.f2082b, fVar, this.f2083c);
                    return;
                }
                Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f2082b);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class f implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f2085a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f2086b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f2087c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f2088d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ Bundle f2089e;

            f(n nVar, String str, int i6, int i7, Bundle bundle) {
                this.f2085a = nVar;
                this.f2086b = str;
                this.f2087c = i6;
                this.f2088d = i7;
                this.f2089e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder asBinder = this.f2085a.asBinder();
                MediaBrowserServiceCompat.this.f2021c.remove(asBinder);
                f fVar = new f(this.f2086b, this.f2087c, this.f2088d, this.f2089e, this.f2085a);
                MediaBrowserServiceCompat.this.f2021c.put(asBinder, fVar);
                try {
                    asBinder.linkToDeath(fVar, 0);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "IBinder is already dead.");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class g implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f2091a;

            g(n nVar) {
                this.f2091a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder asBinder = this.f2091a.asBinder();
                f fVar = (f) MediaBrowserServiceCompat.this.f2021c.remove(asBinder);
                if (fVar != null) {
                    asBinder.unlinkToDeath(fVar, 0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class h implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f2093a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f2094b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f2095c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ a.b f2096d;

            h(n nVar, String str, Bundle bundle, a.b bVar) {
                this.f2093a = nVar;
                this.f2094b = str;
                this.f2095c = bundle;
                this.f2096d = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.f2021c.get(this.f2093a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.o(this.f2094b, this.f2095c, fVar, this.f2096d);
                    return;
                }
                Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f2094b);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class i implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f2098a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f2099b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f2100c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ a.b f2101d;

            i(n nVar, String str, Bundle bundle, a.b bVar) {
                this.f2098a = nVar;
                this.f2099b = str;
                this.f2100c = bundle;
                this.f2101d = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.f2021c.get(this.f2098a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.l(this.f2099b, this.f2100c, fVar, this.f2101d);
                    return;
                }
                Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.f2099b + ", extras=" + this.f2100c);
            }
        }

        m() {
        }

        public void a(String str, IBinder iBinder, Bundle bundle, n nVar) {
            MediaBrowserServiceCompat.this.f2023e.a(new c(nVar, str, iBinder, bundle));
        }

        public void b(String str, int i6, int i7, Bundle bundle, n nVar) {
            if (MediaBrowserServiceCompat.this.c(str, i7)) {
                MediaBrowserServiceCompat.this.f2023e.a(new a(nVar, str, i6, i7, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i7 + " package=" + str);
        }

        public void c(n nVar) {
            MediaBrowserServiceCompat.this.f2023e.a(new b(nVar));
        }

        public void d(String str, a.b bVar, n nVar) {
            if (TextUtils.isEmpty(str) || bVar == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f2023e.a(new e(nVar, str, bVar));
        }

        public void e(n nVar, String str, int i6, int i7, Bundle bundle) {
            MediaBrowserServiceCompat.this.f2023e.a(new f(nVar, str, i6, i7, bundle));
        }

        public void f(String str, IBinder iBinder, n nVar) {
            MediaBrowserServiceCompat.this.f2023e.a(new d(nVar, str, iBinder));
        }

        public void g(String str, Bundle bundle, a.b bVar, n nVar) {
            if (TextUtils.isEmpty(str) || bVar == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f2023e.a(new h(nVar, str, bundle, bVar));
        }

        public void h(String str, Bundle bundle, a.b bVar, n nVar) {
            if (TextUtils.isEmpty(str) || bVar == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f2023e.a(new i(nVar, str, bundle, bVar));
        }

        public void i(n nVar) {
            MediaBrowserServiceCompat.this.f2023e.a(new g(nVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface n {
        void a();

        IBinder asBinder();

        void b(String str, List list, Bundle bundle, Bundle bundle2);
    }

    /* loaded from: classes.dex */
    private static class o implements n {

        /* renamed from: a  reason: collision with root package name */
        final Messenger f2103a;

        o(Messenger messenger) {
            this.f2103a = messenger;
        }

        private void c(int i6, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i6;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f2103a.send(obtain);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.n
        public void a() {
            c(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.n
        public IBinder asBinder() {
            return this.f2103a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.n
        public void b(String str, List list, Bundle bundle, Bundle bundle2) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            c(3, bundle3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class p extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final m f2104a;

        p() {
            this.f2104a = new m();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    this.f2104a.b(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new o(message.replyTo));
                    return;
                case 2:
                    this.f2104a.c(new o(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    this.f2104a.a(data.getString("data_media_item_id"), t.f.a(data, "data_callback_token"), bundle2, new o(message.replyTo));
                    return;
                case 4:
                    this.f2104a.f(data.getString("data_media_item_id"), t.f.a(data, "data_callback_token"), new o(message.replyTo));
                    return;
                case 5:
                    this.f2104a.d(data.getString("data_media_item_id"), (a.b) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle3);
                    this.f2104a.e(new o(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    return;
                case 7:
                    this.f2104a.i(new o(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.a(bundle4);
                    this.f2104a.g(data.getString("data_search_query"), bundle4, (a.b) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.a(bundle5);
                    this.f2104a.h(data.getString("data_custom_action"), bundle5, (a.b) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    return;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j6) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j6);
        }
    }

    void a(String str, f fVar, IBinder iBinder, Bundle bundle) {
        List<d0.e> list = (List) fVar.f2042g.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        for (d0.e eVar : list) {
            if (iBinder == eVar.f9111a && androidx.media.a.a(bundle, (Bundle) eVar.f9112b)) {
                return;
            }
        }
        list.add(new d0.e(iBinder, bundle));
        fVar.f2042g.put(str, list);
        m(str, fVar, bundle, null);
        this.f2022d = fVar;
        j(str, bundle);
        this.f2022d = null;
    }

    List b(List list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i6 = bundle.getInt("android.media.browse.extra.PAGE", -1);
        int i7 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (i6 == -1 && i7 == -1) {
            return list;
        }
        int i8 = i7 * i6;
        int i9 = i8 + i7;
        if (i6 < 0 || i7 < 1 || i8 >= list.size()) {
            return Collections.emptyList();
        }
        if (i9 > list.size()) {
            i9 = list.size();
        }
        return list.subList(i8, i9);
    }

    boolean c(String str, int i6) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i6)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void d(String str, Bundle bundle, l lVar) {
        lVar.e(null);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract e e(String str, int i6, Bundle bundle);

    public abstract void f(String str, l lVar);

    public void g(String str, l lVar, Bundle bundle) {
        lVar.g(1);
        f(str, lVar);
    }

    public void h(String str, l lVar) {
        lVar.g(2);
        lVar.f(null);
    }

    public void i(String str, Bundle bundle, l lVar) {
        lVar.g(4);
        lVar.f(null);
    }

    public void j(String str, Bundle bundle) {
    }

    public void k(String str) {
    }

    void l(String str, Bundle bundle, f fVar, a.b bVar) {
        d dVar = new d(str, bVar);
        this.f2022d = fVar;
        d(str, bundle, dVar);
        this.f2022d = null;
        if (dVar.b()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    void m(String str, f fVar, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, fVar, str, bundle, bundle2);
        this.f2022d = fVar;
        if (bundle == null) {
            f(str, aVar);
        } else {
            g(str, aVar, bundle);
        }
        this.f2022d = null;
        if (aVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + fVar.f2036a + " id=" + str);
    }

    void n(String str, f fVar, a.b bVar) {
        b bVar2 = new b(str, bVar);
        this.f2022d = fVar;
        h(str, bVar2);
        this.f2022d = null;
        if (bVar2.b()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    void o(String str, Bundle bundle, f fVar, a.b bVar) {
        c cVar = new c(str, bVar);
        this.f2022d = fVar;
        i(str, bundle, cVar);
        this.f2022d = null;
        if (cVar.b()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2020b.d(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i6 = Build.VERSION.SDK_INT;
        this.f2020b = i6 >= 28 ? new k() : i6 >= 26 ? new j() : i6 >= 23 ? new i() : new h();
        this.f2020b.a();
    }

    boolean p(String str, f fVar, IBinder iBinder) {
        boolean z5 = false;
        try {
            if (iBinder == null) {
                return fVar.f2042g.remove(str) != null;
            }
            List list = (List) fVar.f2042g.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == ((d0.e) it.next()).f9111a) {
                        it.remove();
                        z5 = true;
                    }
                }
                if (list.size() == 0) {
                    fVar.f2042g.remove(str);
                }
            }
            return z5;
        } finally {
            this.f2022d = fVar;
            k(str);
            this.f2022d = null;
        }
    }
}
