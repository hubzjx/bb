package v;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public abstract class a {
    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return d(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    public static ColorStateList c(Resources resources, int i6, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i6), theme);
        } catch (Exception e6) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e6);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
        if (r7.hasValue(r11) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ColorStateList d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int i6 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int[] iArr2 = new int[20];
        int i7 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i6 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray f6 = f(resources, theme, attributeSet, s.c.f13063a);
                int color = f6.getColor(s.c.f13064b, -65281);
                int i8 = s.c.f13065c;
                float f7 = 1.0f;
                if (!f6.hasValue(i8)) {
                    i8 = s.c.f13066d;
                }
                f7 = f6.getFloat(i8, 1.0f);
                f6.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i9 = 0;
                for (int i10 = 0; i10 < attributeCount; i10++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i10);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != s.a.alpha) {
                        int i11 = i9 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i10, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i9] = attributeNameResource;
                        i9 = i11;
                    }
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i9);
                iArr2 = e.a(iArr2, i7, e(color, f7));
                iArr = (int[][]) e.b(iArr, i7, trimStateSet);
                i7++;
            }
            i6 = 1;
        }
        int[] iArr4 = new int[i7];
        int[][] iArr5 = new int[i7];
        System.arraycopy(iArr2, 0, iArr4, 0, i7);
        System.arraycopy(iArr, 0, iArr5, 0, i7);
        return new ColorStateList(iArr5, iArr4);
    }

    private static int e(int i6, float f6) {
        return (i6 & 16777215) | (Math.round(Color.alpha(i6) * f6) << 24);
    }

    private static TypedArray f(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
