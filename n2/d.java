package n2;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: f  reason: collision with root package name */
    private int f12207f;

    /* renamed from: h  reason: collision with root package name */
    private int f12209h;

    /* renamed from: o  reason: collision with root package name */
    private float f12216o;

    /* renamed from: a  reason: collision with root package name */
    private String f12202a = HttpUrl.FRAGMENT_ENCODE_SET;

    /* renamed from: b  reason: collision with root package name */
    private String f12203b = HttpUrl.FRAGMENT_ENCODE_SET;

    /* renamed from: c  reason: collision with root package name */
    private Set f12204c = Collections.emptySet();

    /* renamed from: d  reason: collision with root package name */
    private String f12205d = HttpUrl.FRAGMENT_ENCODE_SET;

    /* renamed from: e  reason: collision with root package name */
    private String f12206e = null;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12208g = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12210i = false;

    /* renamed from: j  reason: collision with root package name */
    private int f12211j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f12212k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f12213l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f12214m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f12215n = -1;

    /* renamed from: p  reason: collision with root package name */
    private int f12217p = -1;

    /* renamed from: q  reason: collision with root package name */
    private boolean f12218q = false;

    private static int z(int i6, String str, String str2, int i7) {
        if (str.isEmpty() || i6 == -1) {
            return i6;
        }
        if (str.equals(str2)) {
            return i6 + i7;
        }
        return -1;
    }

    public int a() {
        if (this.f12210i) {
            return this.f12209h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f12218q;
    }

    public int c() {
        if (this.f12208g) {
            return this.f12207f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public String d() {
        return this.f12206e;
    }

    public float e() {
        return this.f12216o;
    }

    public int f() {
        return this.f12215n;
    }

    public int g() {
        return this.f12217p;
    }

    public int h(String str, String str2, Set set, String str3) {
        if (this.f12202a.isEmpty() && this.f12203b.isEmpty() && this.f12204c.isEmpty() && this.f12205d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int z5 = z(z(z(0, this.f12202a, str, 1073741824), this.f12203b, str2, 2), this.f12205d, str3, 4);
        if (z5 == -1 || !set.containsAll(this.f12204c)) {
            return 0;
        }
        return z5 + (this.f12204c.size() * 4);
    }

    public int i() {
        int i6 = this.f12213l;
        if (i6 == -1 && this.f12214m == -1) {
            return -1;
        }
        return (i6 == 1 ? 1 : 0) | (this.f12214m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f12210i;
    }

    public boolean k() {
        return this.f12208g;
    }

    public boolean l() {
        return this.f12211j == 1;
    }

    public boolean m() {
        return this.f12212k == 1;
    }

    public d n(int i6) {
        this.f12209h = i6;
        this.f12210i = true;
        return this;
    }

    public d o(boolean z5) {
        this.f12213l = z5 ? 1 : 0;
        return this;
    }

    public d p(boolean z5) {
        this.f12218q = z5;
        return this;
    }

    public d q(int i6) {
        this.f12207f = i6;
        this.f12208g = true;
        return this;
    }

    public d r(String str) {
        this.f12206e = s0.S0(str);
        return this;
    }

    public d s(boolean z5) {
        this.f12214m = z5 ? 1 : 0;
        return this;
    }

    public d t(int i6) {
        this.f12217p = i6;
        return this;
    }

    public void u(String[] strArr) {
        this.f12204c = new HashSet(Arrays.asList(strArr));
    }

    public void v(String str) {
        this.f12202a = str;
    }

    public void w(String str) {
        this.f12203b = str;
    }

    public void x(String str) {
        this.f12205d = str;
    }

    public d y(boolean z5) {
        this.f12212k = z5 ? 1 : 0;
        return this;
    }
}
