package v;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Shader f13625a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f13626b;

    /* renamed from: c  reason: collision with root package name */
    private int f13627c;

    private b(Shader shader, ColorStateList colorStateList, int i6) {
        this.f13625a = shader;
        this.f13626b = colorStateList;
        this.f13627c = i6;
    }

    private static b a(Resources resources, int i6, Resources.Theme theme) {
        int next;
        XmlResourceParser xml = resources.getXml(i6);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            name.hashCode();
            if (name.equals("gradient")) {
                return d(d.b(resources, xml, asAttributeSet, theme));
            }
            if (name.equals("selector")) {
                return c(a.b(resources, xml, asAttributeSet, theme));
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b b(int i6) {
        return new b(null, null, i6);
    }

    static b c(ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    static b d(Shader shader) {
        return new b(shader, null, 0);
    }

    public static b g(Resources resources, int i6, Resources.Theme theme) {
        try {
            return a(resources, i6, theme);
        } catch (Exception e6) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e6);
            return null;
        }
    }

    public int e() {
        return this.f13627c;
    }

    public Shader f() {
        return this.f13625a;
    }

    public boolean h() {
        return this.f13625a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f13625a == null && (colorStateList = this.f13626b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f13626b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f13627c) {
                this.f13627c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i6) {
        this.f13627c = i6;
    }

    public boolean l() {
        return h() || this.f13627c != 0;
    }
}
