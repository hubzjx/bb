package q;

import p.d;
import p.e;
/* loaded from: classes.dex */
public abstract class m implements d {

    /* renamed from: a  reason: collision with root package name */
    public int f12686a;

    /* renamed from: b  reason: collision with root package name */
    p.e f12687b;

    /* renamed from: c  reason: collision with root package name */
    k f12688c;

    /* renamed from: d  reason: collision with root package name */
    protected e.b f12689d;

    /* renamed from: e  reason: collision with root package name */
    g f12690e = new g(this);

    /* renamed from: f  reason: collision with root package name */
    public int f12691f = 0;

    /* renamed from: g  reason: collision with root package name */
    boolean f12692g = false;

    /* renamed from: h  reason: collision with root package name */
    public f f12693h = new f(this);

    /* renamed from: i  reason: collision with root package name */
    public f f12694i = new f(this);

    /* renamed from: j  reason: collision with root package name */
    protected b f12695j = b.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12696a;

        static {
            int[] iArr = new int[d.b.values().length];
            f12696a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12696a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12696a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12696a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12696a[d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public m(p.e eVar) {
        this.f12687b = eVar;
    }

    private void l(int i6, int i7) {
        g gVar;
        int g6;
        int i8 = this.f12686a;
        if (i8 != 0) {
            if (i8 == 1) {
                int g7 = g(this.f12690e.f12672m, i6);
                gVar = this.f12690e;
                g6 = Math.min(g7, i7);
                gVar.d(g6);
            } else if (i8 != 2) {
                if (i8 != 3) {
                    return;
                }
                p.e eVar = this.f12687b;
                m mVar = eVar.f12550e;
                e.b bVar = mVar.f12689d;
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (bVar == bVar2 && mVar.f12686a == 3) {
                    l lVar = eVar.f12552f;
                    if (lVar.f12689d == bVar2 && lVar.f12686a == 3) {
                        return;
                    }
                }
                if (i6 == 0) {
                    mVar = eVar.f12552f;
                }
                if (mVar.f12690e.f12669j) {
                    float r5 = eVar.r();
                    this.f12690e.d(i6 == 1 ? (int) ((mVar.f12690e.f12666g / r5) + 0.5f) : (int) ((r5 * mVar.f12690e.f12666g) + 0.5f));
                    return;
                }
                return;
            } else {
                p.e E = this.f12687b.E();
                if (E == null) {
                    return;
                }
                g gVar2 = (i6 == 0 ? E.f12550e : E.f12552f).f12690e;
                if (!gVar2.f12669j) {
                    return;
                }
                p.e eVar2 = this.f12687b;
                i7 = (int) ((gVar2.f12666g * (i6 == 0 ? eVar2.f12574q : eVar2.f12580t)) + 0.5f);
            }
        }
        gVar = this.f12690e;
        g6 = g(i7, i6);
        gVar.d(g6);
    }

    @Override // q.d
    public abstract void a(d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(f fVar, f fVar2, int i6) {
        fVar.f12671l.add(fVar2);
        fVar.f12665f = i6;
        fVar2.f12670k.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(f fVar, f fVar2, int i6, g gVar) {
        fVar.f12671l.add(fVar2);
        fVar.f12671l.add(this.f12690e);
        fVar.f12667h = i6;
        fVar.f12668i = gVar;
        fVar2.f12670k.add(fVar);
        gVar.f12670k.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g(int i6, int i7) {
        int max;
        if (i7 == 0) {
            p.e eVar = this.f12687b;
            int i8 = eVar.f12572p;
            max = Math.max(eVar.f12570o, i6);
            if (i8 > 0) {
                max = Math.min(i8, i6);
            }
            if (max == i6) {
                return i6;
            }
        } else {
            p.e eVar2 = this.f12687b;
            int i9 = eVar2.f12578s;
            max = Math.max(eVar2.f12576r, i6);
            if (i9 > 0) {
                max = Math.min(i9, i6);
            }
            if (max == i6) {
                return i6;
            }
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f h(p.d dVar) {
        m mVar;
        m mVar2;
        p.d dVar2 = dVar.f12536d;
        if (dVar2 == null) {
            return null;
        }
        p.e eVar = dVar2.f12534b;
        int i6 = a.f12696a[dVar2.f12535c.ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                mVar2 = eVar.f12550e;
            } else if (i6 == 3) {
                mVar = eVar.f12552f;
            } else if (i6 == 4) {
                return eVar.f12552f.f12683k;
            } else {
                if (i6 != 5) {
                    return null;
                }
                mVar2 = eVar.f12552f;
            }
            return mVar2.f12694i;
        }
        mVar = eVar.f12550e;
        return mVar.f12693h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f i(p.d dVar, int i6) {
        p.d dVar2 = dVar.f12536d;
        if (dVar2 == null) {
            return null;
        }
        p.e eVar = dVar2.f12534b;
        m mVar = i6 == 0 ? eVar.f12550e : eVar.f12552f;
        int i7 = a.f12696a[dVar2.f12535c.ordinal()];
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 != 3) {
                    if (i7 != 5) {
                        return null;
                    }
                }
            }
            return mVar.f12694i;
        }
        return mVar.f12693h;
    }

    public long j() {
        g gVar = this.f12690e;
        if (gVar.f12669j) {
            return gVar.f12666g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f12692g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean m();

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(d dVar, p.d dVar2, p.d dVar3, int i6) {
        f fVar;
        f h6 = h(dVar2);
        f h7 = h(dVar3);
        if (h6.f12669j && h7.f12669j) {
            int b6 = h6.f12666g + dVar2.b();
            int b7 = h7.f12666g - dVar3.b();
            int i7 = b7 - b6;
            if (!this.f12690e.f12669j && this.f12689d == e.b.MATCH_CONSTRAINT) {
                l(i6, i7);
            }
            g gVar = this.f12690e;
            if (gVar.f12669j) {
                if (gVar.f12666g == i7) {
                    this.f12693h.d(b6);
                    fVar = this.f12694i;
                } else {
                    p.e eVar = this.f12687b;
                    float u5 = i6 == 0 ? eVar.u() : eVar.I();
                    if (h6 == h7) {
                        b6 = h6.f12666g;
                        b7 = h7.f12666g;
                        u5 = 0.5f;
                    }
                    this.f12693h.d((int) (b6 + 0.5f + (((b7 - b6) - this.f12690e.f12666g) * u5)));
                    fVar = this.f12694i;
                    b7 = this.f12693h.f12666g + this.f12690e.f12666g;
                }
                fVar.d(b7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(d dVar) {
    }
}
