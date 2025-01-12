package u0;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    protected b f13405a;

    /* renamed from: b  reason: collision with root package name */
    protected List f13406b = new ArrayList();

    @Override // u0.c
    public b a() {
        if (this.f13405a == null) {
            this.f13405a = new b();
        }
        return this.f13405a;
    }

    @Override // u0.c
    public List b() {
        return this.f13406b;
    }

    @Override // u0.c
    public void c(b bVar) {
        this.f13405a = bVar;
        this.f13406b.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(float f6, float f7) {
        return Math.max(1, (int) ((3.063052912151454d / Math.asin(f7 / f6)) + 0.5d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        return Math.round(this.f13405a.f13411e * 255.0f);
    }
}
