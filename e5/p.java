package e5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p implements Cloneable {

    /* renamed from: h  reason: collision with root package name */
    private boolean f9619h;

    /* renamed from: l  reason: collision with root package name */
    private File f9621l;

    /* renamed from: a  reason: collision with root package name */
    private List f9612a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private List f9613b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private c f9614c = new c();

    /* renamed from: d  reason: collision with root package name */
    private d f9615d = new d();

    /* renamed from: e  reason: collision with root package name */
    private f f9616e = new f();

    /* renamed from: f  reason: collision with root package name */
    private l f9617f = new l();

    /* renamed from: g  reason: collision with root package name */
    private m f9618g = new m();

    /* renamed from: m  reason: collision with root package name */
    private boolean f9622m = false;

    /* renamed from: k  reason: collision with root package name */
    private long f9620k = -1;

    public d a() {
        return this.f9615d;
    }

    public f b() {
        return this.f9616e;
    }

    public List c() {
        return this.f9612a;
    }

    public Object clone() {
        return super.clone();
    }

    public long d() {
        return this.f9620k;
    }

    public l e() {
        return this.f9617f;
    }

    public m f() {
        return this.f9618g;
    }

    public File g() {
        return this.f9621l;
    }

    public boolean h() {
        return this.f9619h;
    }

    public boolean i() {
        return this.f9622m;
    }

    public void j(d dVar) {
        this.f9615d = dVar;
    }

    public void k(f fVar) {
        this.f9616e = fVar;
    }

    public void l(boolean z5) {
        this.f9619h = z5;
    }

    public void m(long j6) {
        this.f9620k = j6;
    }

    public void n(l lVar) {
        this.f9617f = lVar;
    }

    public void o(m mVar) {
        this.f9618g = mVar;
    }

    public void p(boolean z5) {
        this.f9622m = z5;
    }

    public void q(File file) {
        this.f9621l = file;
    }
}
