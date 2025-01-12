package e2;

import android.graphics.Bitmap;
import android.text.Layout;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: p  reason: collision with root package name */
    public static final b f9435p = new C0159b().m(HttpUrl.FRAGMENT_ENCODE_SET).a();

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f9436a;

    /* renamed from: b  reason: collision with root package name */
    public final Layout.Alignment f9437b;

    /* renamed from: c  reason: collision with root package name */
    public final Bitmap f9438c;

    /* renamed from: d  reason: collision with root package name */
    public final float f9439d;

    /* renamed from: e  reason: collision with root package name */
    public final int f9440e;

    /* renamed from: f  reason: collision with root package name */
    public final int f9441f;

    /* renamed from: g  reason: collision with root package name */
    public final float f9442g;

    /* renamed from: h  reason: collision with root package name */
    public final int f9443h;

    /* renamed from: i  reason: collision with root package name */
    public final float f9444i;

    /* renamed from: j  reason: collision with root package name */
    public final float f9445j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f9446k;

    /* renamed from: l  reason: collision with root package name */
    public final int f9447l;

    /* renamed from: m  reason: collision with root package name */
    public final int f9448m;

    /* renamed from: n  reason: collision with root package name */
    public final float f9449n;

    /* renamed from: o  reason: collision with root package name */
    public final int f9450o;

    /* renamed from: e2.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0159b {

        /* renamed from: a  reason: collision with root package name */
        private CharSequence f9451a;

        /* renamed from: b  reason: collision with root package name */
        private Bitmap f9452b;

        /* renamed from: c  reason: collision with root package name */
        private Layout.Alignment f9453c;

        /* renamed from: d  reason: collision with root package name */
        private float f9454d;

        /* renamed from: e  reason: collision with root package name */
        private int f9455e;

        /* renamed from: f  reason: collision with root package name */
        private int f9456f;

        /* renamed from: g  reason: collision with root package name */
        private float f9457g;

        /* renamed from: h  reason: collision with root package name */
        private int f9458h;

        /* renamed from: i  reason: collision with root package name */
        private int f9459i;

        /* renamed from: j  reason: collision with root package name */
        private float f9460j;

        /* renamed from: k  reason: collision with root package name */
        private float f9461k;

        /* renamed from: l  reason: collision with root package name */
        private float f9462l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f9463m;

        /* renamed from: n  reason: collision with root package name */
        private int f9464n;

        /* renamed from: o  reason: collision with root package name */
        private int f9465o;

        public C0159b() {
            this.f9451a = null;
            this.f9452b = null;
            this.f9453c = null;
            this.f9454d = -3.4028235E38f;
            this.f9455e = Integer.MIN_VALUE;
            this.f9456f = Integer.MIN_VALUE;
            this.f9457g = -3.4028235E38f;
            this.f9458h = Integer.MIN_VALUE;
            this.f9459i = Integer.MIN_VALUE;
            this.f9460j = -3.4028235E38f;
            this.f9461k = -3.4028235E38f;
            this.f9462l = -3.4028235E38f;
            this.f9463m = false;
            this.f9464n = -16777216;
            this.f9465o = Integer.MIN_VALUE;
        }

        public b a() {
            return new b(this.f9451a, this.f9453c, this.f9452b, this.f9454d, this.f9455e, this.f9456f, this.f9457g, this.f9458h, this.f9459i, this.f9460j, this.f9461k, this.f9462l, this.f9463m, this.f9464n, this.f9465o);
        }

        public C0159b b() {
            this.f9463m = false;
            return this;
        }

        public int c() {
            return this.f9456f;
        }

        public int d() {
            return this.f9458h;
        }

        public CharSequence e() {
            return this.f9451a;
        }

        public C0159b f(Bitmap bitmap) {
            this.f9452b = bitmap;
            return this;
        }

        public C0159b g(float f6) {
            this.f9462l = f6;
            return this;
        }

        public C0159b h(float f6, int i6) {
            this.f9454d = f6;
            this.f9455e = i6;
            return this;
        }

        public C0159b i(int i6) {
            this.f9456f = i6;
            return this;
        }

        public C0159b j(float f6) {
            this.f9457g = f6;
            return this;
        }

        public C0159b k(int i6) {
            this.f9458h = i6;
            return this;
        }

        public C0159b l(float f6) {
            this.f9461k = f6;
            return this;
        }

        public C0159b m(CharSequence charSequence) {
            this.f9451a = charSequence;
            return this;
        }

        public C0159b n(Layout.Alignment alignment) {
            this.f9453c = alignment;
            return this;
        }

        public C0159b o(float f6, int i6) {
            this.f9460j = f6;
            this.f9459i = i6;
            return this;
        }

        public C0159b p(int i6) {
            this.f9465o = i6;
            return this;
        }

        public C0159b q(int i6) {
            this.f9464n = i6;
            this.f9463m = true;
            return this;
        }

        private C0159b(b bVar) {
            this.f9451a = bVar.f9436a;
            this.f9452b = bVar.f9438c;
            this.f9453c = bVar.f9437b;
            this.f9454d = bVar.f9439d;
            this.f9455e = bVar.f9440e;
            this.f9456f = bVar.f9441f;
            this.f9457g = bVar.f9442g;
            this.f9458h = bVar.f9443h;
            this.f9459i = bVar.f9448m;
            this.f9460j = bVar.f9449n;
            this.f9461k = bVar.f9444i;
            this.f9462l = bVar.f9445j;
            this.f9463m = bVar.f9446k;
            this.f9464n = bVar.f9447l;
            this.f9465o = bVar.f9450o;
        }
    }

    private b(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f6, int i6, int i7, float f7, int i8, int i9, float f8, float f9, float f10, boolean z5, int i10, int i11) {
        if (charSequence == null) {
            com.google.android.exoplayer2.util.a.e(bitmap);
        } else {
            com.google.android.exoplayer2.util.a.a(bitmap == null);
        }
        this.f9436a = charSequence;
        this.f9437b = alignment;
        this.f9438c = bitmap;
        this.f9439d = f6;
        this.f9440e = i6;
        this.f9441f = i7;
        this.f9442g = f7;
        this.f9443h = i8;
        this.f9444i = f9;
        this.f9445j = f10;
        this.f9446k = z5;
        this.f9447l = i10;
        this.f9448m = i9;
        this.f9449n = f8;
        this.f9450o = i11;
    }

    public C0159b a() {
        return new C0159b();
    }
}
