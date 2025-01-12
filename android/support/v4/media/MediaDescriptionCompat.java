package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.support.v4.media.e;
import android.support.v4.media.session.MediaSessionCompat;
/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f152a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f153b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f154c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f155d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f156e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f157f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f158g;

    /* renamed from: h  reason: collision with root package name */
    private final Uri f159h;

    /* renamed from: k  reason: collision with root package name */
    private Object f160k;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.e(android.support.v4.media.b.a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i6) {
            return new MediaDescriptionCompat[i6];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f161a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f162b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f163c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f164d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f165e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f166f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f167g;

        /* renamed from: h  reason: collision with root package name */
        private Uri f168h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f161a, this.f162b, this.f163c, this.f164d, this.f165e, this.f166f, this.f167g, this.f168h);
        }

        public b b(CharSequence charSequence) {
            this.f164d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f167g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f165e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f166f = uri;
            return this;
        }

        public b f(String str) {
            this.f161a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f168h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f163c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f162b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f152a = str;
        this.f153b = charSequence;
        this.f154c = charSequence2;
        this.f155d = charSequence3;
        this.f156e = bitmap;
        this.f157f = uri;
        this.f158g = bundle;
        this.f159h = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaDescriptionCompat e(Object obj) {
        Uri uri;
        Bundle bundle = null;
        if (obj != null) {
            int i6 = Build.VERSION.SDK_INT;
            b bVar = new b();
            bVar.f(android.support.v4.media.b.f(obj));
            bVar.i(android.support.v4.media.b.h(obj));
            bVar.h(android.support.v4.media.b.g(obj));
            bVar.b(android.support.v4.media.b.b(obj));
            bVar.d(android.support.v4.media.b.d(obj));
            bVar.e(android.support.v4.media.b.e(obj));
            Bundle c6 = android.support.v4.media.b.c(obj);
            if (c6 != null) {
                MediaSessionCompat.a(c6);
                uri = (Uri) c6.getParcelable("android.support.v4.media.description.MEDIA_URI");
            } else {
                uri = null;
            }
            if (uri != null) {
                if (!c6.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || c6.size() != 2) {
                    c6.remove("android.support.v4.media.description.MEDIA_URI");
                    c6.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                }
                bVar.c(bundle);
                if (uri == null) {
                    bVar.g(uri);
                } else if (i6 >= 23) {
                    bVar.g(e.a(obj));
                }
                MediaDescriptionCompat a6 = bVar.a();
                a6.f160k = obj;
                return a6;
            }
            bundle = c6;
            bVar.c(bundle);
            if (uri == null) {
            }
            MediaDescriptionCompat a62 = bVar.a();
            a62.f160k = obj;
            return a62;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object f() {
        Object obj = this.f160k;
        if (obj == null) {
            int i6 = Build.VERSION.SDK_INT;
            Object b6 = b.a.b();
            b.a.g(b6, this.f152a);
            b.a.i(b6, this.f153b);
            b.a.h(b6, this.f154c);
            b.a.c(b6, this.f155d);
            b.a.e(b6, this.f156e);
            b.a.f(b6, this.f157f);
            Bundle bundle = this.f158g;
            if (i6 < 23 && this.f159h != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                    bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f159h);
            }
            b.a.d(b6, bundle);
            if (i6 >= 23) {
                e.a.a(b6, this.f159h);
            }
            Object a6 = b.a.a(b6);
            this.f160k = a6;
            return a6;
        }
        return obj;
    }

    public String toString() {
        return ((Object) this.f153b) + ", " + ((Object) this.f154c) + ", " + ((Object) this.f155d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        android.support.v4.media.b.i(f(), parcel, i6);
    }
}
