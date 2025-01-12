package android.support.v4.media.session;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import t.f;
/* loaded from: classes.dex */
public final class MediaControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final b f176a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaSessionCompat.Token f177b;

    /* renamed from: c  reason: collision with root package name */
    private final HashSet f178c = new HashSet();

    /* loaded from: classes.dex */
    static class MediaControllerImplApi21 implements b {

        /* renamed from: a  reason: collision with root package name */
        protected final Object f179a;

        /* renamed from: b  reason: collision with root package name */
        final Object f180b = new Object();

        /* renamed from: c  reason: collision with root package name */
        private final List f181c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private HashMap f182d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        final MediaSessionCompat.Token f183e;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a  reason: collision with root package name */
            private WeakReference f184a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.f184a = new WeakReference(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i6, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f184a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.f180b) {
                    mediaControllerImplApi21.f183e.i(b.a.o(f.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerImplApi21.f183e.j(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                    mediaControllerImplApi21.b();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a extends a.BinderC0005a {
            a(a aVar) {
                super(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void b(CharSequence charSequence) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void c() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void d(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void h(Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void i(List list) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void n(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f183e = token;
            Object b6 = android.support.v4.media.session.c.b(context, token.h());
            this.f179a = b6;
            if (b6 == null) {
                throw new RemoteException();
            }
            if (token.g() == null) {
                c();
            }
        }

        private void c() {
            d("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean a(KeyEvent keyEvent) {
            return android.support.v4.media.session.c.a(this.f179a, keyEvent);
        }

        void b() {
            if (this.f183e.g() == null) {
                return;
            }
            Iterator it = this.f181c.iterator();
            if (!it.hasNext()) {
                this.f181c.clear();
                return;
            }
            android.support.v4.media.a.a(it.next());
            this.f182d.put(null, new a(null));
            throw null;
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
            android.support.v4.media.session.c.c(this.f179a, str, bundle, resultReceiver);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a implements IBinder.DeathRecipient {

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class BinderC0005a extends a.AbstractBinderC0006a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference f185a;

            BinderC0005a(a aVar) {
                this.f185a = new WeakReference(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void a(boolean z5) {
            }

            @Override // android.support.v4.media.session.a
            public void e(int i6) {
                android.support.v4.media.a.a(this.f185a.get());
            }

            @Override // android.support.v4.media.session.a
            public void f(int i6) {
                android.support.v4.media.a.a(this.f185a.get());
            }

            @Override // android.support.v4.media.session.a
            public void g() {
                android.support.v4.media.a.a(this.f185a.get());
            }

            @Override // android.support.v4.media.session.a
            public void j(boolean z5) {
                android.support.v4.media.a.a(this.f185a.get());
            }

            @Override // android.support.v4.media.session.a
            public void k(PlaybackStateCompat playbackStateCompat) {
                android.support.v4.media.a.a(this.f185a.get());
            }

            @Override // android.support.v4.media.session.a
            public void l(String str, Bundle bundle) {
                android.support.v4.media.a.a(this.f185a.get());
            }
        }
    }

    /* loaded from: classes.dex */
    interface b {
        boolean a(KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    static class c extends MediaControllerImplApi21 {
        public c(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    /* loaded from: classes.dex */
    static class d extends c {
        public d(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.f177b = token;
        int i6 = Build.VERSION.SDK_INT;
        this.f176a = i6 >= 24 ? new d(context, token) : i6 >= 23 ? new c(context, token) : new MediaControllerImplApi21(context, token);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f176a.a(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }
}
