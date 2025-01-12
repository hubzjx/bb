package v;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public abstract class h {
    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i6, boolean z5) {
        return !j(xmlPullParser, str) ? z5 : typedArray.getBoolean(i6, z5);
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i6, int i7) {
        return !j(xmlPullParser, str) ? i7 : typedArray.getColor(i6, i7);
    }

    public static ColorStateList c(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i6) {
        if (j(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i6, typedValue);
            int i7 = typedValue.type;
            if (i7 != 2) {
                return (i7 < 28 || i7 > 31) ? a.c(typedArray.getResources(), typedArray.getResourceId(i6, 0), theme) : d(typedValue);
            }
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i6 + ": " + typedValue);
        }
        return null;
    }

    private static ColorStateList d(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static b e(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i6, int i7) {
        if (j(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i6, typedValue);
            int i8 = typedValue.type;
            if (i8 >= 28 && i8 <= 31) {
                return b.b(typedValue.data);
            }
            b g6 = b.g(typedArray.getResources(), typedArray.getResourceId(i6, 0), theme);
            if (g6 != null) {
                return g6;
            }
        }
        return b.b(i7);
    }

    public static float f(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i6, float f6) {
        return !j(xmlPullParser, str) ? f6 : typedArray.getFloat(i6, f6);
    }

    public static int g(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i6, int i7) {
        return !j(xmlPullParser, str) ? i7 : typedArray.getInt(i6, i7);
    }

    public static int h(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i6, int i7) {
        return !j(xmlPullParser, str) ? i7 : typedArray.getResourceId(i6, i7);
    }

    public static String i(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i6) {
        if (j(xmlPullParser, str)) {
            return typedArray.getString(i6);
        }
        return null;
    }

    public static boolean j(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray k(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static TypedValue l(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i6) {
        if (j(xmlPullParser, str)) {
            return typedArray.peekValue(i6);
        }
        return null;
    }
}
