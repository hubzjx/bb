package n0;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import n0.l;
/* loaded from: classes.dex */
public class p extends l {
    int N;
    private ArrayList L = new ArrayList();
    private boolean M = true;
    boolean O = false;
    private int P = 0;

    /* loaded from: classes.dex */
    class a extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f12167a;

        a(l lVar) {
            this.f12167a = lVar;
        }

        @Override // n0.l.f
        public void b(l lVar) {
            this.f12167a.S();
            lVar.O(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends m {

        /* renamed from: a  reason: collision with root package name */
        p f12169a;

        b(p pVar) {
            this.f12169a = pVar;
        }

        @Override // n0.l.f
        public void b(l lVar) {
            p pVar = this.f12169a;
            int i6 = pVar.N - 1;
            pVar.N = i6;
            if (i6 == 0) {
                pVar.O = false;
                pVar.o();
            }
            lVar.O(this);
        }

        @Override // n0.m, n0.l.f
        public void d(l lVar) {
            p pVar = this.f12169a;
            if (pVar.O) {
                return;
            }
            pVar.Z();
            this.f12169a.O = true;
        }
    }

    private void e0(l lVar) {
        this.L.add(lVar);
        lVar.f12124t = this;
    }

    private void n0() {
        b bVar = new b(this);
        Iterator it = this.L.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(bVar);
        }
        this.N = this.L.size();
    }

    @Override // n0.l
    public void M(View view) {
        super.M(view);
        int size = this.L.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((l) this.L.get(i6)).M(view);
        }
    }

    @Override // n0.l
    public void Q(View view) {
        super.Q(view);
        int size = this.L.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((l) this.L.get(i6)).Q(view);
        }
    }

    @Override // n0.l
    protected void S() {
        if (this.L.isEmpty()) {
            Z();
            o();
            return;
        }
        n0();
        if (this.M) {
            Iterator it = this.L.iterator();
            while (it.hasNext()) {
                ((l) it.next()).S();
            }
            return;
        }
        for (int i6 = 1; i6 < this.L.size(); i6++) {
            ((l) this.L.get(i6 - 1)).a(new a((l) this.L.get(i6)));
        }
        l lVar = (l) this.L.get(0);
        if (lVar != null) {
            lVar.S();
        }
    }

    @Override // n0.l
    public void U(l.e eVar) {
        super.U(eVar);
        this.P |= 8;
        int size = this.L.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((l) this.L.get(i6)).U(eVar);
        }
    }

    @Override // n0.l
    public void W(g gVar) {
        super.W(gVar);
        this.P |= 4;
        if (this.L != null) {
            for (int i6 = 0; i6 < this.L.size(); i6++) {
                ((l) this.L.get(i6)).W(gVar);
            }
        }
    }

    @Override // n0.l
    public void X(o oVar) {
        super.X(oVar);
        this.P |= 2;
        int size = this.L.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((l) this.L.get(i6)).X(oVar);
        }
    }

    @Override // n0.l
    String a0(String str) {
        String a02 = super.a0(str);
        for (int i6 = 0; i6 < this.L.size(); i6++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a02);
            sb.append("\n");
            sb.append(((l) this.L.get(i6)).a0(str + "  "));
            a02 = sb.toString();
        }
        return a02;
    }

    @Override // n0.l
    /* renamed from: b0 */
    public p a(l.f fVar) {
        return (p) super.a(fVar);
    }

    @Override // n0.l
    /* renamed from: c0 */
    public p b(View view) {
        for (int i6 = 0; i6 < this.L.size(); i6++) {
            ((l) this.L.get(i6)).b(view);
        }
        return (p) super.b(view);
    }

    public p d0(l lVar) {
        e0(lVar);
        long j6 = this.f12109c;
        if (j6 >= 0) {
            lVar.T(j6);
        }
        if ((this.P & 1) != 0) {
            lVar.V(r());
        }
        if ((this.P & 2) != 0) {
            v();
            lVar.X(null);
        }
        if ((this.P & 4) != 0) {
            lVar.W(u());
        }
        if ((this.P & 8) != 0) {
            lVar.U(q());
        }
        return this;
    }

    @Override // n0.l
    public void f(s sVar) {
        if (F(sVar.f12174b)) {
            Iterator it = this.L.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar.F(sVar.f12174b)) {
                    lVar.f(sVar);
                    sVar.f12175c.add(lVar);
                }
            }
        }
    }

    public l f0(int i6) {
        if (i6 < 0 || i6 >= this.L.size()) {
            return null;
        }
        return (l) this.L.get(i6);
    }

    public int g0() {
        return this.L.size();
    }

    @Override // n0.l
    void h(s sVar) {
        super.h(sVar);
        int size = this.L.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((l) this.L.get(i6)).h(sVar);
        }
    }

    @Override // n0.l
    /* renamed from: h0 */
    public p O(l.f fVar) {
        return (p) super.O(fVar);
    }

    @Override // n0.l
    public void i(s sVar) {
        if (F(sVar.f12174b)) {
            Iterator it = this.L.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar.F(sVar.f12174b)) {
                    lVar.i(sVar);
                    sVar.f12175c.add(lVar);
                }
            }
        }
    }

    @Override // n0.l
    /* renamed from: i0 */
    public p P(View view) {
        for (int i6 = 0; i6 < this.L.size(); i6++) {
            ((l) this.L.get(i6)).P(view);
        }
        return (p) super.P(view);
    }

    @Override // n0.l
    /* renamed from: j0 */
    public p T(long j6) {
        ArrayList arrayList;
        super.T(j6);
        if (this.f12109c >= 0 && (arrayList = this.L) != null) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((l) this.L.get(i6)).T(j6);
            }
        }
        return this;
    }

    @Override // n0.l
    /* renamed from: k0 */
    public p V(TimeInterpolator timeInterpolator) {
        this.P |= 1;
        ArrayList arrayList = this.L;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((l) this.L.get(i6)).V(timeInterpolator);
            }
        }
        return (p) super.V(timeInterpolator);
    }

    @Override // n0.l
    /* renamed from: l */
    public l clone() {
        p pVar = (p) super.clone();
        pVar.L = new ArrayList();
        int size = this.L.size();
        for (int i6 = 0; i6 < size; i6++) {
            pVar.e0(((l) this.L.get(i6)).clone());
        }
        return pVar;
    }

    public p l0(int i6) {
        if (i6 == 0) {
            this.M = true;
        } else if (i6 != 1) {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i6);
        } else {
            this.M = false;
        }
        return this;
    }

    @Override // n0.l
    /* renamed from: m0 */
    public p Y(long j6) {
        return (p) super.Y(j6);
    }

    @Override // n0.l
    protected void n(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        long x5 = x();
        int size = this.L.size();
        for (int i6 = 0; i6 < size; i6++) {
            l lVar = (l) this.L.get(i6);
            if (x5 > 0 && (this.M || i6 == 0)) {
                long x6 = lVar.x();
                if (x6 > 0) {
                    lVar.Y(x6 + x5);
                } else {
                    lVar.Y(x5);
                }
            }
            lVar.n(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }
}
