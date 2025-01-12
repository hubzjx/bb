package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* renamed from: b  reason: collision with root package name */
    static final boolean f132b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a  reason: collision with root package name */
    private final c f133a;

    /* loaded from: classes.dex */
    private static class CustomActionResultReceiver extends a.b {
        @Override // a.b
        protected void e(int i6, Bundle bundle) {
        }
    }

    /* loaded from: classes.dex */
    private static class ItemReceiver extends a.b {
        @Override // a.b
        protected void e(int i6, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i6 != 0 || bundle == null || !bundle.containsKey("media_item")) {
                throw null;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable != null && !(parcelable instanceof MediaItem)) {
                throw null;
            }
            MediaItem mediaItem = (MediaItem) parcelable;
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final int f134a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaDescriptionCompat f135b;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public MediaItem[] newArray(int i6) {
                return new MediaItem[i6];
            }
        }

        MediaItem(Parcel parcel) {
            this.f134a = parcel.readInt();
            this.f135b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.f134a + ", mDescription=" + this.f135b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f134a);
            this.f135b.writeToParcel(parcel, i6);
        }
    }

    /* loaded from: classes.dex */
    private static class SearchResultReceiver extends a.b {
        @Override // a.b
        protected void e(int i6, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i6 != 0 || bundle == null || !bundle.containsKey("search_results")) {
                throw null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            if (parcelableArray != null) {
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            throw null;
        }
    }

    /* loaded from: classes.dex */
    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f136a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference f137b;

        a(g gVar) {
            this.f136a = new WeakReference(gVar);
        }

        void a(Messenger messenger) {
            this.f137b = new WeakReference(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference weakReference = this.f137b;
            if (weakReference == null || weakReference.get() == null || this.f136a.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.a(data);
            g gVar = (g) this.f136a.get();
            Messenger messenger = (Messenger) this.f137b.get();
            try {
                int i6 = message.what;
                if (i6 == 1) {
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    gVar.c(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle);
                } else if (i6 == 2) {
                    gVar.a(messenger);
                } else if (i6 != 3) {
                    Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                } else {
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    Bundle bundle3 = data.getBundle("data_notify_children_changed_options");
                    MediaSessionCompat.a(bundle3);
                    gVar.f(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle2, bundle3);
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                if (message.what == 1) {
                    gVar.a(messenger);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final MediaBrowser.ConnectionCallback f138a = new a();

        /* renamed from: b  reason: collision with root package name */
        InterfaceC0004b f139b;

        /* loaded from: classes.dex */
        private class a extends MediaBrowser.ConnectionCallback {
            a() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                InterfaceC0004b interfaceC0004b = b.this.f139b;
                if (interfaceC0004b != null) {
                    interfaceC0004b.d();
                }
                b.this.a();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                InterfaceC0004b interfaceC0004b = b.this.f139b;
                if (interfaceC0004b != null) {
                    interfaceC0004b.e();
                }
                b.this.b();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                InterfaceC0004b interfaceC0004b = b.this.f139b;
                if (interfaceC0004b != null) {
                    interfaceC0004b.g();
                }
                b.this.c();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: android.support.v4.media.MediaBrowserCompat$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0004b {
            void d();

            void e();

            void g();
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        void d(InterfaceC0004b interfaceC0004b) {
            this.f139b = interfaceC0004b;
        }
    }

    /* loaded from: classes.dex */
    interface c {
        MediaSessionCompat.Token b();

        void h();

        void i();
    }

    /* loaded from: classes.dex */
    static class d implements c, g, b.InterfaceC0004b {

        /* renamed from: a  reason: collision with root package name */
        final Context f141a;

        /* renamed from: b  reason: collision with root package name */
        protected final MediaBrowser f142b;

        /* renamed from: c  reason: collision with root package name */
        protected final Bundle f143c;

        /* renamed from: d  reason: collision with root package name */
        protected final a f144d = new a(this);

        /* renamed from: e  reason: collision with root package name */
        private final l.a f145e = new l.a();

        /* renamed from: f  reason: collision with root package name */
        protected int f146f;

        /* renamed from: g  reason: collision with root package name */
        protected h f147g;

        /* renamed from: h  reason: collision with root package name */
        protected Messenger f148h;

        /* renamed from: i  reason: collision with root package name */
        private MediaSessionCompat.Token f149i;

        d(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            this.f141a = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.f143c = bundle2;
            bundle2.putInt("extra_client_version", 1);
            bVar.d(this);
            this.f142b = new MediaBrowser(context, componentName, bVar.f138a, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void a(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public MediaSessionCompat.Token b() {
            if (this.f149i == null) {
                this.f149i = MediaSessionCompat.Token.e(this.f142b.getSessionToken());
            }
            return this.f149i;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void c(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.InterfaceC0004b
        public void d() {
            try {
                Bundle extras = this.f142b.getExtras();
                if (extras == null) {
                    return;
                }
                this.f146f = extras.getInt("extra_service_version", 0);
                IBinder a6 = t.f.a(extras, "extra_messenger");
                if (a6 != null) {
                    this.f147g = new h(a6, this.f143c);
                    Messenger messenger = new Messenger(this.f144d);
                    this.f148h = messenger;
                    this.f144d.a(messenger);
                    try {
                        this.f147g.a(this.f141a, this.f148h);
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                android.support.v4.media.session.b o5 = b.a.o(t.f.a(extras, "extra_session_binder"));
                if (o5 != null) {
                    this.f149i = MediaSessionCompat.Token.f(this.f142b.getSessionToken(), o5);
                }
            } catch (IllegalStateException e6) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e6);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.InterfaceC0004b
        public void e() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void f(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.f148h != messenger) {
                return;
            }
            android.support.v4.media.a.a(this.f145e.get(str));
            if (MediaBrowserCompat.f132b) {
                Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.InterfaceC0004b
        public void g() {
            this.f147g = null;
            this.f148h = null;
            this.f149i = null;
            this.f144d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void h() {
            Messenger messenger;
            h hVar = this.f147g;
            if (hVar != null && (messenger = this.f148h) != null) {
                try {
                    hVar.c(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            this.f142b.disconnect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void i() {
            this.f142b.connect();
        }
    }

    /* loaded from: classes.dex */
    static class e extends d {
        e(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class f extends e {
        f(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    /* loaded from: classes.dex */
    interface g {
        void a(Messenger messenger);

        void c(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void f(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);
    }

    /* loaded from: classes.dex */
    private static class h {

        /* renamed from: a  reason: collision with root package name */
        private Messenger f150a;

        /* renamed from: b  reason: collision with root package name */
        private Bundle f151b;

        public h(IBinder iBinder, Bundle bundle) {
            this.f150a = new Messenger(iBinder);
            this.f151b = bundle;
        }

        private void b(int i6, Bundle bundle, Messenger messenger) {
            Message obtain = Message.obtain();
            obtain.what = i6;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f150a.send(obtain);
        }

        void a(Context context, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.f151b);
            b(6, bundle, messenger);
        }

        void c(Messenger messenger) {
            b(7, null, messenger);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar, Bundle bundle) {
        int i6 = Build.VERSION.SDK_INT;
        this.f133a = i6 >= 26 ? new f(context, componentName, bVar, bundle) : i6 >= 23 ? new e(context, componentName, bVar, bundle) : new d(context, componentName, bVar, bundle);
    }

    public void a() {
        Log.d("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
        this.f133a.i();
    }

    public void b() {
        this.f133a.h();
    }

    public MediaSessionCompat.Token c() {
        return this.f133a.b();
    }
}
