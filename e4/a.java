package e4;

import android.graphics.Rect;
import android.view.Gravity;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    public static void a(d dVar, b bVar) {
        List h6 = dVar.h();
        int size = h6.size();
        if (size <= 0) {
            return;
        }
        float f6 = 0.0f;
        for (int i6 = 0; i6 < size; i6++) {
            f6 += h((e) h6.get(i6), bVar);
        }
        e eVar = (e) h6.get(size - 1);
        int d6 = dVar.d() - ((eVar.f() + eVar.g()) + eVar.c());
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            e eVar2 = (e) h6.get(i8);
            float h7 = h(eVar2, bVar);
            int f7 = f(eVar2, bVar);
            int round = f6 == 0.0f ? d6 / size : Math.round((d6 * h7) / f6);
            int f8 = eVar2.f() + eVar2.g();
            int i9 = eVar2.i() + eVar2.h();
            Rect rect = new Rect();
            rect.top = 0;
            rect.left = i7;
            rect.right = f8 + round + i7;
            rect.bottom = dVar.g();
            Rect rect2 = new Rect();
            Gravity.apply(f7, f8, i9, rect, rect2);
            i7 += round;
            eVar2.q(rect2.left + eVar2.c());
            eVar2.r(rect2.top);
            eVar2.s(rect2.width() - eVar2.g());
            eVar2.v(rect2.height() - eVar2.h());
        }
    }

    public static void b(List list, int i6, int i7, b bVar) {
        int size = list.size();
        if (size <= 0) {
            return;
        }
        d dVar = (d) list.get(size - 1);
        int g6 = i7 - (dVar.g() + dVar.f());
        if (g6 < 0) {
            g6 = 0;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            d dVar2 = (d) list.get(i9);
            int f6 = f(null, bVar);
            int round = Math.round((g6 * 1) / size);
            int d6 = dVar2.d();
            int g7 = dVar2.g();
            Rect rect = new Rect();
            rect.top = i8;
            rect.left = 0;
            rect.right = i6;
            rect.bottom = g7 + round + i8;
            Rect rect2 = new Rect();
            Gravity.apply(f6, d6, g7, rect, rect2);
            i8 += round;
            dVar2.l(dVar2.e() + rect2.left);
            dVar2.m(dVar2.f() + rect2.top);
            dVar2.k(rect2.width());
            dVar2.n(rect2.height());
            a(dVar2, bVar);
        }
    }

    public static void c(List list) {
        int size = list.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            d dVar = (d) list.get(i7);
            dVar.m(i6);
            i6 += dVar.g();
            List h6 = dVar.h();
            int size2 = h6.size();
            int i8 = 0;
            for (int i9 = 0; i9 < size2; i9++) {
                e eVar = (e) h6.get(i9);
                eVar.q(i8);
                i8 += eVar.f() + eVar.g();
            }
        }
    }

    public static void d(List list, List list2, b bVar) {
        d dVar = new d(bVar);
        list2.add(dVar);
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            e eVar = (e) list.get(i6);
            if (eVar.n() || (bVar.i() && !dVar.c(eVar))) {
                dVar = new d(bVar);
                if (bVar.f() == 1 && bVar.b() == 1) {
                    list2.add(0, dVar);
                } else {
                    list2.add(dVar);
                }
            }
            if (bVar.f() == 0 && bVar.b() == 1) {
                dVar.a(0, eVar);
            } else {
                dVar.b(eVar);
            }
        }
    }

    public static int e(int i6, int i7, int i8) {
        return i6 != Integer.MIN_VALUE ? i6 != 1073741824 ? i8 : i7 : Math.min(i8, i7);
    }

    private static int f(e eVar, b bVar) {
        int a6 = bVar.a();
        int g6 = g((eVar == null || !eVar.m()) ? a6 : eVar.a(), bVar);
        int g7 = g(a6, bVar);
        if ((g6 & 7) == 0) {
            g6 |= g7 & 7;
        }
        if ((g6 & 112) == 0) {
            g6 |= g7 & 112;
        }
        if ((g6 & 7) == 0) {
            g6 |= 3;
        }
        return (g6 & 112) == 0 ? g6 | 48 : g6;
    }

    public static int g(int i6, b bVar) {
        if (bVar.f() == 1 && (i6 & 8388608) == 0) {
            i6 = (((i6 & 112) >> 4) << 0) | (((i6 & 7) >> 0) << 4) | 0;
        }
        if (bVar.b() != 1 || (i6 & 8388608) == 0) {
            return i6;
        }
        return ((i6 & 3) == 3 ? 5 : 0) | 0 | ((i6 & 5) == 5 ? 3 : 0);
    }

    private static float h(e eVar, b bVar) {
        return eVar.y() ? eVar.k() : bVar.h();
    }
}
