package r4;

import io.jsonwebtoken.JwtParser;
import kotlin.jvm.internal.l;
import r4.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f extends e {
    public static int b(int i6, int i7) {
        return i6 < i7 ? i7 : i6;
    }

    public static int c(int i6, int i7) {
        return i6 > i7 ? i7 : i6;
    }

    public static int d(int i6, int i7, int i8) {
        if (i7 <= i8) {
            return i6 < i7 ? i7 : i6 > i8 ? i8 : i6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i8 + " is less than minimum " + i7 + JwtParser.SEPARATOR_CHAR);
    }

    public static a e(int i6, int i7) {
        return a.f13053d.a(i6, i7, -1);
    }

    public static a f(a aVar, int i6) {
        l.d(aVar, "<this>");
        e.a(i6 > 0, Integer.valueOf(i6));
        a.C0213a c0213a = a.f13053d;
        int a6 = aVar.a();
        int b6 = aVar.b();
        if (aVar.c() <= 0) {
            i6 = -i6;
        }
        return c0213a.a(a6, b6, i6);
    }

    public static c g(int i6, int i7) {
        return i7 <= Integer.MIN_VALUE ? c.f13061e.a() : new c(i6, i7 - 1);
    }
}
