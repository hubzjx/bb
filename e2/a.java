package e2;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final a f9428g = new a(-1, -16777216, 0, 0, -1, null);

    /* renamed from: a  reason: collision with root package name */
    public final int f9429a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9430b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9431c;

    /* renamed from: d  reason: collision with root package name */
    public final int f9432d;

    /* renamed from: e  reason: collision with root package name */
    public final int f9433e;

    /* renamed from: f  reason: collision with root package name */
    public final Typeface f9434f;

    public a(int i6, int i7, int i8, int i9, int i10, Typeface typeface) {
        this.f9429a = i6;
        this.f9430b = i7;
        this.f9431c = i8;
        this.f9432d = i9;
        this.f9433e = i10;
        this.f9434f = typeface;
    }

    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        return s0.f4673a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    private static a b(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static a c(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f9428g.f9429a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f9428g.f9430b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f9428g.f9431c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f9428g.f9432d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f9428g.f9433e, captionStyle.getTypeface());
    }
}
