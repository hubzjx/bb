package p;

import p.d;
import p.e;
/* loaded from: classes.dex */
public class g extends e {

    /* renamed from: w0  reason: collision with root package name */
    protected float f12594w0 = -1.0f;

    /* renamed from: x0  reason: collision with root package name */
    protected int f12595x0 = -1;

    /* renamed from: y0  reason: collision with root package name */
    protected int f12596y0 = -1;

    /* renamed from: z0  reason: collision with root package name */
    private d f12597z0 = this.C;
    private int A0 = 0;
    private int B0 = 0;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12598a;

        static {
            int[] iArr = new int[d.b.values().length];
            f12598a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12598a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12598a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12598a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12598a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12598a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12598a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12598a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12598a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public g() {
        this.K.clear();
        this.K.add(this.f12597z0);
        int length = this.J.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.J[i6] = this.f12597z0;
        }
    }

    @Override // p.e
    public void F0(o.d dVar) {
        if (E() == null) {
            return;
        }
        int x5 = dVar.x(this.f12597z0);
        if (this.A0 == 1) {
            B0(x5);
            C0(0);
            e0(E().t());
            A0(0);
            return;
        }
        B0(0);
        C0(x5);
        A0(E().N());
        e0(0);
    }

    public int G0() {
        return this.A0;
    }

    public int H0() {
        return this.f12595x0;
    }

    public int I0() {
        return this.f12596y0;
    }

    public float J0() {
        return this.f12594w0;
    }

    public void K0(int i6) {
        if (i6 > -1) {
            this.f12594w0 = -1.0f;
            this.f12595x0 = i6;
            this.f12596y0 = -1;
        }
    }

    public void L0(int i6) {
        if (i6 > -1) {
            this.f12594w0 = -1.0f;
            this.f12595x0 = -1;
            this.f12596y0 = i6;
        }
    }

    public void M0(float f6) {
        if (f6 > -1.0f) {
            this.f12594w0 = f6;
            this.f12595x0 = -1;
            this.f12596y0 = -1;
        }
    }

    public void N0(int i6) {
        if (this.A0 == i6) {
            return;
        }
        this.A0 = i6;
        this.K.clear();
        this.f12597z0 = this.A0 == 1 ? this.B : this.C;
        this.K.add(this.f12597z0);
        int length = this.J.length;
        for (int i7 = 0; i7 < length; i7++) {
            this.J[i7] = this.f12597z0;
        }
    }

    @Override // p.e
    public void f(o.d dVar) {
        f fVar = (f) E();
        if (fVar == null) {
            return;
        }
        d k6 = fVar.k(d.b.LEFT);
        d k7 = fVar.k(d.b.RIGHT);
        e eVar = this.N;
        boolean z5 = true;
        boolean z6 = eVar != null && eVar.M[0] == e.b.WRAP_CONTENT;
        if (this.A0 == 0) {
            k6 = fVar.k(d.b.TOP);
            k7 = fVar.k(d.b.BOTTOM);
            e eVar2 = this.N;
            z6 = (eVar2 == null || eVar2.M[1] != e.b.WRAP_CONTENT) ? false : false;
        }
        if (this.f12595x0 != -1) {
            o.i q5 = dVar.q(this.f12597z0);
            dVar.e(q5, dVar.q(k6), this.f12595x0, 8);
            if (z6) {
                dVar.h(dVar.q(k7), q5, 0, 5);
            }
        } else if (this.f12596y0 == -1) {
            if (this.f12594w0 != -1.0f) {
                dVar.d(o.d.s(dVar, dVar.q(this.f12597z0), dVar.q(k7), this.f12594w0));
            }
        } else {
            o.i q6 = dVar.q(this.f12597z0);
            o.i q7 = dVar.q(k7);
            dVar.e(q6, q7, -this.f12596y0, 8);
            if (z6) {
                dVar.h(q6, dVar.q(k6), 0, 5);
                dVar.h(q7, q6, 0, 5);
            }
        }
    }

    @Override // p.e
    public boolean g() {
        return true;
    }

    @Override // p.e
    public d k(d.b bVar) {
        switch (a.f12598a[bVar.ordinal()]) {
            case 1:
            case 2:
                if (this.A0 == 1) {
                    return this.f12597z0;
                }
                break;
            case 3:
            case 4:
                if (this.A0 == 0) {
                    return this.f12597z0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(bVar.name());
    }
}
