package i5;

import java.io.File;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11038a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f11039b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f11040c;

    static {
        Charset forName = Charset.forName("UTF-8");
        f11039b = forName;
        f11040c = forName;
    }
}
