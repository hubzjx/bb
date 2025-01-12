package o;

import java.util.Arrays;
import java.util.HashSet;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class i {

    /* renamed from: o  reason: collision with root package name */
    private static int f12311o = 1;

    /* renamed from: a  reason: collision with root package name */
    public boolean f12312a;

    /* renamed from: b  reason: collision with root package name */
    private String f12313b;

    /* renamed from: f  reason: collision with root package name */
    public float f12317f;

    /* renamed from: j  reason: collision with root package name */
    a f12321j;

    /* renamed from: c  reason: collision with root package name */
    public int f12314c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f12315d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f12316e = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12318g = false;

    /* renamed from: h  reason: collision with root package name */
    float[] f12319h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    float[] f12320i = new float[9];

    /* renamed from: k  reason: collision with root package name */
    b[] f12322k = new b[16];

    /* renamed from: l  reason: collision with root package name */
    int f12323l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f12324m = 0;

    /* renamed from: n  reason: collision with root package name */
    HashSet f12325n = null;

    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f12321j = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        f12311o++;
    }

    public final void a(b bVar) {
        int i6 = 0;
        while (true) {
            int i7 = this.f12323l;
            if (i6 >= i7) {
                b[] bVarArr = this.f12322k;
                if (i7 >= bVarArr.length) {
                    this.f12322k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f12322k;
                int i8 = this.f12323l;
                bVarArr2[i8] = bVar;
                this.f12323l = i8 + 1;
                return;
            } else if (this.f12322k[i6] == bVar) {
                return;
            } else {
                i6++;
            }
        }
    }

    public final void c(b bVar) {
        int i6 = this.f12323l;
        int i7 = 0;
        while (i7 < i6) {
            if (this.f12322k[i7] == bVar) {
                while (i7 < i6 - 1) {
                    b[] bVarArr = this.f12322k;
                    int i8 = i7 + 1;
                    bVarArr[i7] = bVarArr[i8];
                    i7 = i8;
                }
                this.f12323l--;
                return;
            }
            i7++;
        }
    }

    public void d() {
        this.f12313b = null;
        this.f12321j = a.UNKNOWN;
        this.f12316e = 0;
        this.f12314c = -1;
        this.f12315d = -1;
        this.f12317f = 0.0f;
        this.f12318g = false;
        int i6 = this.f12323l;
        for (int i7 = 0; i7 < i6; i7++) {
            this.f12322k[i7] = null;
        }
        this.f12323l = 0;
        this.f12324m = 0;
        this.f12312a = false;
        Arrays.fill(this.f12320i, 0.0f);
    }

    public void e(d dVar, float f6) {
        this.f12317f = f6;
        this.f12318g = true;
        int i6 = this.f12323l;
        for (int i7 = 0; i7 < i6; i7++) {
            this.f12322k[i7].B(dVar, this, false);
        }
        this.f12323l = 0;
    }

    public void f(a aVar, String str) {
        this.f12321j = aVar;
    }

    public final void g(b bVar) {
        int i6 = this.f12323l;
        for (int i7 = 0; i7 < i6; i7++) {
            this.f12322k[i7].C(bVar, false);
        }
        this.f12323l = 0;
    }

    public String toString() {
        StringBuilder sb;
        if (this.f12313b != null) {
            sb = new StringBuilder();
            sb.append(HttpUrl.FRAGMENT_ENCODE_SET);
            sb.append(this.f12313b);
        } else {
            sb = new StringBuilder();
            sb.append(HttpUrl.FRAGMENT_ENCODE_SET);
            sb.append(this.f12314c);
        }
        return sb.toString();
    }
}
