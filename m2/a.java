package m2;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import e2.b;
import e2.d;
import e2.f;
import e2.h;
import java.util.List;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: o  reason: collision with root package name */
    private final y f11999o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12000p;

    /* renamed from: q  reason: collision with root package name */
    private int f12001q;

    /* renamed from: r  reason: collision with root package name */
    private int f12002r;

    /* renamed from: s  reason: collision with root package name */
    private String f12003s;

    /* renamed from: t  reason: collision with root package name */
    private float f12004t;

    /* renamed from: u  reason: collision with root package name */
    private int f12005u;

    public a(List list) {
        super("Tx3gDecoder");
        this.f11999o = new y();
        if (list != null && list.size() == 1 && (((byte[]) list.get(0)).length == 48 || ((byte[]) list.get(0)).length == 53)) {
            byte[] bArr = (byte[]) list.get(0);
            this.f12001q = bArr[24];
            this.f12002r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.f12003s = "Serif".equals(s0.F(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
            int i6 = bArr[25] * 20;
            this.f12005u = i6;
            boolean z5 = (bArr[0] & 32) != 0;
            this.f12000p = z5;
            if (z5) {
                float f6 = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i6;
                this.f12004t = f6;
                this.f12004t = s0.q(f6, 0.0f, 0.95f);
                return;
            }
        } else {
            this.f12001q = 0;
            this.f12002r = -1;
            this.f12003s = "sans-serif";
            this.f12000p = false;
        }
        this.f12004t = 0.85f;
    }

    private void C(y yVar, SpannableStringBuilder spannableStringBuilder) {
        D(yVar.a() >= 12);
        int G = yVar.G();
        int G2 = yVar.G();
        yVar.N(2);
        int A = yVar.A();
        yVar.N(1);
        int k6 = yVar.k();
        F(spannableStringBuilder, A, this.f12001q, G, G2, 0);
        E(spannableStringBuilder, k6, this.f12002r, G, G2, 0);
    }

    private static void D(boolean z5) {
        if (!z5) {
            throw new h("Unexpected subtitle format.");
        }
    }

    private static void E(SpannableStringBuilder spannableStringBuilder, int i6, int i7, int i8, int i9, int i10) {
        if (i6 != i7) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i6 >>> 8) | ((i6 & 255) << 24)), i8, i9, i10 | 33);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void F(SpannableStringBuilder spannableStringBuilder, int i6, int i7, int i8, int i9, int i10) {
        StyleSpan styleSpan;
        boolean z5;
        if (i6 != i7) {
            int i11 = i10 | 33;
            boolean z6 = (i6 & 1) != 0;
            boolean z7 = (i6 & 2) != 0;
            if (!z6) {
                if (z7) {
                    styleSpan = new StyleSpan(2);
                }
                z5 = (i6 & 4) != 0;
                if (z5) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i8, i9, i11);
                }
                if (!z5 || z6 || z7) {
                    return;
                }
                spannableStringBuilder.setSpan(new StyleSpan(0), i8, i9, i11);
                return;
            }
            styleSpan = z7 ? new StyleSpan(3) : new StyleSpan(1);
            spannableStringBuilder.setSpan(styleSpan, i8, i9, i11);
            if ((i6 & 4) != 0) {
            }
            if (z5) {
            }
            if (z5) {
            }
        }
    }

    private static void G(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i6, int i7, int i8) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i6, i7, i8 | 33);
        }
    }

    private static String H(y yVar) {
        char f6;
        D(yVar.a() >= 2);
        int G = yVar.G();
        if (G == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return yVar.y(G, (yVar.a() < 2 || !((f6 = yVar.f()) == 65279 || f6 == 65534)) ? com.google.common.base.b.f5585c : com.google.common.base.b.f5588f);
    }

    @Override // e2.d
    protected f A(byte[] bArr, int i6, boolean z5) {
        this.f11999o.K(bArr, i6);
        String H = H(this.f11999o);
        if (H.isEmpty()) {
            return b.f12006b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(H);
        F(spannableStringBuilder, this.f12001q, 0, 0, spannableStringBuilder.length(), 16711680);
        E(spannableStringBuilder, this.f12002r, -1, 0, spannableStringBuilder.length(), 16711680);
        G(spannableStringBuilder, this.f12003s, "sans-serif", 0, spannableStringBuilder.length(), 16711680);
        float f6 = this.f12004t;
        while (true) {
            if (this.f11999o.a() < 8) {
                return new b(new b.C0159b().m(spannableStringBuilder).h(f6, 0).i(0).a());
            }
            int d6 = this.f11999o.d();
            int k6 = this.f11999o.k();
            int k7 = this.f11999o.k();
            if (k7 == 1937013100) {
                D(this.f11999o.a() >= 2);
                int G = this.f11999o.G();
                for (int i7 = 0; i7 < G; i7++) {
                    C(this.f11999o, spannableStringBuilder);
                }
            } else if (k7 == 1952608120 && this.f12000p) {
                D(this.f11999o.a() >= 2);
                f6 = s0.q(this.f11999o.G() / this.f12005u, 0.0f, 0.95f);
            }
            this.f11999o.M(d6 + k6);
        }
    }
}
