package androidx.lifecycle;

import androidx.lifecycle.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import k.b;
/* loaded from: classes.dex */
public class g extends c {

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference f1988d;

    /* renamed from: b  reason: collision with root package name */
    private k.a f1986b = new k.a();

    /* renamed from: e  reason: collision with root package name */
    private int f1989e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1990f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1991g = false;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList f1992h = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private c.b f1987c = c.b.INITIALIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1993a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1994b;

        static {
            int[] iArr = new int[c.b.values().length];
            f1994b = iArr;
            try {
                iArr[c.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1994b[c.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1994b[c.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1994b[c.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1994b[c.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[c.a.values().length];
            f1993a = iArr2;
            try {
                iArr2[c.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1993a[c.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1993a[c.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1993a[c.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1993a[c.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1993a[c.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1993a[c.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        c.b f1995a;

        /* renamed from: b  reason: collision with root package name */
        d f1996b;

        b(e eVar, c.b bVar) {
            this.f1996b = h.f(eVar);
            this.f1995a = bVar;
        }

        void a(f fVar, c.a aVar) {
            c.b h6 = g.h(aVar);
            this.f1995a = g.l(this.f1995a, h6);
            this.f1996b.a(fVar, aVar);
            this.f1995a = h6;
        }
    }

    public g(f fVar) {
        this.f1988d = new WeakReference(fVar);
    }

    private void d(f fVar) {
        Iterator descendingIterator = this.f1986b.descendingIterator();
        while (descendingIterator.hasNext() && !this.f1991g) {
            Map.Entry entry = (Map.Entry) descendingIterator.next();
            b bVar = (b) entry.getValue();
            while (bVar.f1995a.compareTo(this.f1987c) > 0 && !this.f1991g && this.f1986b.contains(entry.getKey())) {
                c.a f6 = f(bVar.f1995a);
                o(h(f6));
                bVar.a(fVar, f6);
                n();
            }
        }
    }

    private c.b e(e eVar) {
        Map.Entry g6 = this.f1986b.g(eVar);
        c.b bVar = null;
        c.b bVar2 = g6 != null ? ((b) g6.getValue()).f1995a : null;
        if (!this.f1992h.isEmpty()) {
            ArrayList arrayList = this.f1992h;
            bVar = (c.b) arrayList.get(arrayList.size() - 1);
        }
        return l(l(this.f1987c, bVar2), bVar);
    }

    private static c.a f(c.b bVar) {
        int i6 = a.f1994b[bVar.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 4) {
                        if (i6 != 5) {
                            throw new IllegalArgumentException("Unexpected state value " + bVar);
                        }
                        throw new IllegalArgumentException();
                    }
                    return c.a.ON_PAUSE;
                }
                return c.a.ON_STOP;
            }
            return c.a.ON_DESTROY;
        }
        throw new IllegalArgumentException();
    }

    private void g(f fVar) {
        b.d c6 = this.f1986b.c();
        while (c6.hasNext() && !this.f1991g) {
            Map.Entry entry = (Map.Entry) c6.next();
            b bVar = (b) entry.getValue();
            while (bVar.f1995a.compareTo(this.f1987c) < 0 && !this.f1991g && this.f1986b.contains(entry.getKey())) {
                o(bVar.f1995a);
                bVar.a(fVar, r(bVar.f1995a));
                n();
            }
        }
    }

    static c.b h(c.a aVar) {
        switch (a.f1993a[aVar.ordinal()]) {
            case 1:
            case 2:
                return c.b.CREATED;
            case 3:
            case 4:
                return c.b.STARTED;
            case 5:
                return c.b.RESUMED;
            case 6:
                return c.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private boolean j() {
        if (this.f1986b.size() == 0) {
            return true;
        }
        c.b bVar = ((b) this.f1986b.a().getValue()).f1995a;
        c.b bVar2 = ((b) this.f1986b.d().getValue()).f1995a;
        return bVar == bVar2 && this.f1987c == bVar2;
    }

    static c.b l(c.b bVar, c.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void m(c.b bVar) {
        if (this.f1987c == bVar) {
            return;
        }
        this.f1987c = bVar;
        if (this.f1990f || this.f1989e != 0) {
            this.f1991g = true;
            return;
        }
        this.f1990f = true;
        q();
        this.f1990f = false;
    }

    private void n() {
        ArrayList arrayList = this.f1992h;
        arrayList.remove(arrayList.size() - 1);
    }

    private void o(c.b bVar) {
        this.f1992h.add(bVar);
    }

    private void q() {
        f fVar = (f) this.f1988d.get();
        if (fVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean j6 = j();
            this.f1991g = false;
            if (j6) {
                return;
            }
            if (this.f1987c.compareTo(((b) this.f1986b.a().getValue()).f1995a) < 0) {
                d(fVar);
            }
            Map.Entry d6 = this.f1986b.d();
            if (!this.f1991g && d6 != null && this.f1987c.compareTo(((b) d6.getValue()).f1995a) > 0) {
                g(fVar);
            }
        }
    }

    private static c.a r(c.b bVar) {
        int i6 = a.f1994b[bVar.ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                return c.a.ON_START;
            }
            if (i6 == 3) {
                return c.a.ON_RESUME;
            }
            if (i6 == 4) {
                throw new IllegalArgumentException();
            }
            if (i6 != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return c.a.ON_CREATE;
    }

    @Override // androidx.lifecycle.c
    public void a(e eVar) {
        f fVar;
        c.b bVar = this.f1987c;
        c.b bVar2 = c.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = c.b.INITIALIZED;
        }
        b bVar3 = new b(eVar, bVar2);
        if (((b) this.f1986b.h(eVar, bVar3)) == null && (fVar = (f) this.f1988d.get()) != null) {
            boolean z5 = this.f1989e != 0 || this.f1990f;
            c.b e6 = e(eVar);
            this.f1989e++;
            while (bVar3.f1995a.compareTo(e6) < 0 && this.f1986b.contains(eVar)) {
                o(bVar3.f1995a);
                bVar3.a(fVar, r(bVar3.f1995a));
                n();
                e6 = e(eVar);
            }
            if (!z5) {
                q();
            }
            this.f1989e--;
        }
    }

    @Override // androidx.lifecycle.c
    public c.b b() {
        return this.f1987c;
    }

    @Override // androidx.lifecycle.c
    public void c(e eVar) {
        this.f1986b.f(eVar);
    }

    public void i(c.a aVar) {
        m(h(aVar));
    }

    public void k(c.b bVar) {
        p(bVar);
    }

    public void p(c.b bVar) {
        m(bVar);
    }
}
