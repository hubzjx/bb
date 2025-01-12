package p;

import java.util.HashSet;
import java.util.Iterator;
import o.i;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public final e f12534b;

    /* renamed from: c  reason: collision with root package name */
    public final b f12535c;

    /* renamed from: d  reason: collision with root package name */
    public d f12536d;

    /* renamed from: g  reason: collision with root package name */
    o.i f12539g;

    /* renamed from: a  reason: collision with root package name */
    private HashSet f12533a = null;

    /* renamed from: e  reason: collision with root package name */
    public int f12537e = 0;

    /* renamed from: f  reason: collision with root package name */
    int f12538f = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12540a;

        static {
            int[] iArr = new int[b.values().length];
            f12540a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12540a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12540a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12540a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12540a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12540a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12540a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12540a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12540a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f12534b = eVar;
        this.f12535c = bVar;
    }

    public boolean a(d dVar, int i6, int i7, boolean z5) {
        if (dVar == null) {
            k();
            return true;
        } else if (z5 || j(dVar)) {
            this.f12536d = dVar;
            if (dVar.f12533a == null) {
                dVar.f12533a = new HashSet();
            }
            this.f12536d.f12533a.add(this);
            if (i6 > 0) {
                this.f12537e = i6;
            } else {
                this.f12537e = 0;
            }
            this.f12538f = i7;
            return true;
        } else {
            return false;
        }
    }

    public int b() {
        d dVar;
        if (this.f12534b.M() == 8) {
            return 0;
        }
        return (this.f12538f <= -1 || (dVar = this.f12536d) == null || dVar.f12534b.M() != 8) ? this.f12537e : this.f12538f;
    }

    public final d c() {
        switch (a.f12540a[this.f12535c.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f12534b.D;
            case 3:
                return this.f12534b.B;
            case 4:
                return this.f12534b.E;
            case 5:
                return this.f12534b.C;
            default:
                throw new AssertionError(this.f12535c.name());
        }
    }

    public e d() {
        return this.f12534b;
    }

    public o.i e() {
        return this.f12539g;
    }

    public d f() {
        return this.f12536d;
    }

    public b g() {
        return this.f12535c;
    }

    public boolean h() {
        HashSet hashSet = this.f12533a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).c().i()) {
                return true;
            }
        }
        return false;
    }

    public boolean i() {
        return this.f12536d != null;
    }

    public boolean j(d dVar) {
        boolean z5 = false;
        if (dVar == null) {
            return false;
        }
        b g6 = dVar.g();
        b bVar = this.f12535c;
        if (g6 == bVar) {
            return bVar != b.BASELINE || (dVar.d().Q() && d().Q());
        }
        switch (a.f12540a[bVar.ordinal()]) {
            case 1:
                return (g6 == b.BASELINE || g6 == b.CENTER_X || g6 == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z6 = g6 == b.LEFT || g6 == b.RIGHT;
                if (dVar.d() instanceof g) {
                    return (z6 || g6 == b.CENTER_X) ? true : true;
                }
                return z6;
            case 4:
            case 5:
                boolean z7 = g6 == b.TOP || g6 == b.BOTTOM;
                if (dVar.d() instanceof g) {
                    return (z7 || g6 == b.CENTER_Y) ? true : true;
                }
                return z7;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f12535c.name());
        }
    }

    public void k() {
        HashSet hashSet;
        d dVar = this.f12536d;
        if (dVar != null && (hashSet = dVar.f12533a) != null) {
            hashSet.remove(this);
        }
        this.f12536d = null;
        this.f12537e = 0;
        this.f12538f = -1;
    }

    public void l(o.c cVar) {
        o.i iVar = this.f12539g;
        if (iVar == null) {
            this.f12539g = new o.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.d();
        }
    }

    public String toString() {
        return this.f12534b.p() + ":" + this.f12535c.toString();
    }
}
