package kotlin.text;

import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f11326a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f11327b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f11328c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f11329d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f11330e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f11331f;

    /* renamed from: g  reason: collision with root package name */
    public static final Charset f11332g;

    /* renamed from: h  reason: collision with root package name */
    private static Charset f11333h;

    /* renamed from: i  reason: collision with root package name */
    private static Charset f11334i;

    static {
        Charset forName = Charset.forName("UTF-8");
        kotlin.jvm.internal.l.c(forName, "forName(\"UTF-8\")");
        f11327b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.l.c(forName2, "forName(\"UTF-16\")");
        f11328c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.l.c(forName3, "forName(\"UTF-16BE\")");
        f11329d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.l.c(forName4, "forName(\"UTF-16LE\")");
        f11330e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.l.c(forName5, "forName(\"US-ASCII\")");
        f11331f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.l.c(forName6, "forName(\"ISO-8859-1\")");
        f11332g = forName6;
    }

    private d() {
    }

    public final Charset a() {
        Charset charset = f11334i;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32BE");
            kotlin.jvm.internal.l.c(forName, "forName(\"UTF-32BE\")");
            f11334i = forName;
            return forName;
        }
        return charset;
    }

    public final Charset b() {
        Charset charset = f11333h;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32LE");
            kotlin.jvm.internal.l.c(forName, "forName(\"UTF-32LE\")");
            f11333h = forName;
            return forName;
        }
        return charset;
    }
}
