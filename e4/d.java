package e4;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private final b f9528b;

    /* renamed from: c  reason: collision with root package name */
    private int f9529c;

    /* renamed from: d  reason: collision with root package name */
    private int f9530d;

    /* renamed from: a  reason: collision with root package name */
    private final List f9527a = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private int f9531e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f9532f = 0;

    public d(b bVar) {
        this.f9528b = bVar;
    }

    public void a(int i6, e eVar) {
        this.f9527a.add(i6, eVar);
        this.f9529c = this.f9529c + eVar.f() + eVar.g();
        this.f9530d = Math.max(this.f9530d, eVar.i() + eVar.h());
    }

    public void b(e eVar) {
        a(this.f9527a.size(), eVar);
    }

    public boolean c(e eVar) {
        return (this.f9529c + eVar.f()) + eVar.g() <= this.f9528b.d();
    }

    public int d() {
        return this.f9529c;
    }

    public int e() {
        return this.f9532f;
    }

    public int f() {
        return this.f9531e;
    }

    public int g() {
        return this.f9530d;
    }

    public List h() {
        return this.f9527a;
    }

    public int i() {
        return this.f9528b.f() == 0 ? this.f9532f : this.f9531e;
    }

    public int j() {
        return this.f9528b.f() == 0 ? this.f9531e : this.f9532f;
    }

    public void k(int i6) {
        this.f9529c = i6;
    }

    public void l(int i6) {
        this.f9532f = i6;
    }

    public void m(int i6) {
        this.f9531e = i6;
    }

    public void n(int i6) {
        this.f9530d = i6;
    }
}
