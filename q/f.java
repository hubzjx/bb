package q;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements d {

    /* renamed from: d  reason: collision with root package name */
    m f12663d;

    /* renamed from: f  reason: collision with root package name */
    int f12665f;

    /* renamed from: g  reason: collision with root package name */
    public int f12666g;

    /* renamed from: a  reason: collision with root package name */
    public d f12660a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12661b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12662c = false;

    /* renamed from: e  reason: collision with root package name */
    a f12664e = a.UNKNOWN;

    /* renamed from: h  reason: collision with root package name */
    int f12667h = 1;

    /* renamed from: i  reason: collision with root package name */
    g f12668i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12669j = false;

    /* renamed from: k  reason: collision with root package name */
    List f12670k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    List f12671l = new ArrayList();

    /* loaded from: classes.dex */
    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(m mVar) {
        this.f12663d = mVar;
    }

    @Override // q.d
    public void a(d dVar) {
        for (f fVar : this.f12671l) {
            if (!fVar.f12669j) {
                return;
            }
        }
        this.f12662c = true;
        d dVar2 = this.f12660a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f12661b) {
            this.f12663d.a(this);
            return;
        }
        f fVar2 = null;
        int i6 = 0;
        for (f fVar3 : this.f12671l) {
            if (!(fVar3 instanceof g)) {
                i6++;
                fVar2 = fVar3;
            }
        }
        if (fVar2 != null && i6 == 1 && fVar2.f12669j) {
            g gVar = this.f12668i;
            if (gVar != null) {
                if (!gVar.f12669j) {
                    return;
                }
                this.f12665f = this.f12667h * gVar.f12666g;
            }
            d(fVar2.f12666g + this.f12665f);
        }
        d dVar3 = this.f12660a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f12670k.add(dVar);
        if (this.f12669j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f12671l.clear();
        this.f12670k.clear();
        this.f12669j = false;
        this.f12666g = 0;
        this.f12662c = false;
        this.f12661b = false;
    }

    public void d(int i6) {
        if (this.f12669j) {
            return;
        }
        this.f12669j = true;
        this.f12666g = i6;
        for (d dVar : this.f12670k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12663d.f12687b.p());
        sb.append(":");
        sb.append(this.f12664e);
        sb.append("(");
        sb.append(this.f12669j ? Integer.valueOf(this.f12666g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f12671l.size());
        sb.append(":d=");
        sb.append(this.f12670k.size());
        sb.append(">");
        return sb.toString();
    }
}
