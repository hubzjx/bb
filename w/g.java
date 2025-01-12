package w;

import android.graphics.Insets;
import android.graphics.Rect;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: e  reason: collision with root package name */
    public static final g f13689e = new g(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f13690a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13691b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13692c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13693d;

    private g(int i6, int i7, int i8, int i9) {
        this.f13690a = i6;
        this.f13691b = i7;
        this.f13692c = i8;
        this.f13693d = i9;
    }

    public static g a(g gVar, g gVar2) {
        return b(Math.max(gVar.f13690a, gVar2.f13690a), Math.max(gVar.f13691b, gVar2.f13691b), Math.max(gVar.f13692c, gVar2.f13692c), Math.max(gVar.f13693d, gVar2.f13693d));
    }

    public static g b(int i6, int i7, int i8, int i9) {
        return (i6 == 0 && i7 == 0 && i8 == 0 && i9 == 0) ? f13689e : new g(i6, i7, i8, i9);
    }

    public static g c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static g d(Insets insets) {
        int i6;
        int i7;
        int i8;
        int i9;
        i6 = insets.left;
        i7 = insets.top;
        i8 = insets.right;
        i9 = insets.bottom;
        return b(i6, i7, i8, i9);
    }

    public Insets e() {
        Insets of;
        of = Insets.of(this.f13690a, this.f13691b, this.f13692c, this.f13693d);
        return of;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f13693d == gVar.f13693d && this.f13690a == gVar.f13690a && this.f13692c == gVar.f13692c && this.f13691b == gVar.f13691b;
    }

    public int hashCode() {
        return (((((this.f13690a * 31) + this.f13691b) * 31) + this.f13692c) * 31) + this.f13693d;
    }

    public String toString() {
        return "Insets{left=" + this.f13690a + ", top=" + this.f13691b + ", right=" + this.f13692c + ", bottom=" + this.f13693d + '}';
    }
}
