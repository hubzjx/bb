package v;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f13639a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f13640b;

        a(int i6, int i7) {
            this.f13639a = new int[]{i6, i7};
            this.f13640b = new float[]{0.0f, 1.0f};
        }

        a(int i6, int i7, int i8) {
            this.f13639a = new int[]{i6, i7, i8};
            this.f13640b = new float[]{0.0f, 0.5f, 1.0f};
        }

        a(List list, List list2) {
            int size = list.size();
            this.f13639a = new int[size];
            this.f13640b = new float[size];
            for (int i6 = 0; i6 < size; i6++) {
                this.f13639a[i6] = ((Integer) list.get(i6)).intValue();
                this.f13640b[i6] = ((Float) list2.get(i6)).floatValue();
            }
        }
    }

    private static a a(a aVar, int i6, int i7, boolean z5, int i8) {
        return aVar != null ? aVar : z5 ? new a(i6, i8, i7) : new a(i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray k6 = h.k(resources, theme, attributeSet, s.c.f13086x);
        float f6 = h.f(k6, xmlPullParser, "startX", s.c.G, 0.0f);
        float f7 = h.f(k6, xmlPullParser, "startY", s.c.H, 0.0f);
        float f8 = h.f(k6, xmlPullParser, "endX", s.c.I, 0.0f);
        float f9 = h.f(k6, xmlPullParser, "endY", s.c.J, 0.0f);
        float f10 = h.f(k6, xmlPullParser, "centerX", s.c.B, 0.0f);
        float f11 = h.f(k6, xmlPullParser, "centerY", s.c.C, 0.0f);
        int g6 = h.g(k6, xmlPullParser, "type", s.c.A, 0);
        int b6 = h.b(k6, xmlPullParser, "startColor", s.c.f13087y, 0);
        boolean j6 = h.j(xmlPullParser, "centerColor");
        int b7 = h.b(k6, xmlPullParser, "centerColor", s.c.F, 0);
        int b8 = h.b(k6, xmlPullParser, "endColor", s.c.f13088z, 0);
        int g7 = h.g(k6, xmlPullParser, "tileMode", s.c.E, 0);
        float f12 = h.f(k6, xmlPullParser, "gradientRadius", s.c.D, 0.0f);
        k6.recycle();
        a a6 = a(c(resources, xmlPullParser, attributeSet, theme), b6, b8, j6, b7);
        if (g6 != 1) {
            return g6 != 2 ? new LinearGradient(f6, f7, f8, f9, a6.f13639a, a6.f13640b, d(g7)) : new SweepGradient(f10, f11, a6.f13639a, a6.f13640b);
        } else if (f12 > 0.0f) {
            return new RadialGradient(f10, f11, f12, a6.f13639a, a6.f13640b, d(g7));
        } else {
            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0080, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray k6 = h.k(resources, theme, attributeSet, s.c.K);
                int i6 = s.c.L;
                boolean hasValue = k6.hasValue(i6);
                int i7 = s.c.M;
                boolean hasValue2 = k6.hasValue(i7);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = k6.getColor(i6, 0);
                float f6 = k6.getFloat(i7, 0.0f);
                k6.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f6));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode d(int i6) {
        return i6 != 1 ? i6 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }
}
