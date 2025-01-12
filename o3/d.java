package o3;

import com.google.gson.q;
import java.sql.Date;
import java.sql.Timestamp;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f12487a;

    /* renamed from: b  reason: collision with root package name */
    public static final l3.d f12488b;

    /* renamed from: c  reason: collision with root package name */
    public static final l3.d f12489c;

    /* renamed from: d  reason: collision with root package name */
    public static final q f12490d;

    /* renamed from: e  reason: collision with root package name */
    public static final q f12491e;

    /* renamed from: f  reason: collision with root package name */
    public static final q f12492f;

    /* loaded from: classes.dex */
    class a extends l3.d {
        a(Class cls) {
            super(cls);
        }
    }

    /* loaded from: classes.dex */
    class b extends l3.d {
        b(Class cls) {
            super(cls);
        }
    }

    static {
        boolean z5;
        q qVar;
        try {
            Class.forName("java.sql.Date");
            z5 = true;
        } catch (ClassNotFoundException unused) {
            z5 = false;
        }
        f12487a = z5;
        if (z5) {
            f12488b = new a(Date.class);
            f12489c = new b(Timestamp.class);
            f12490d = o3.a.f12481b;
            f12491e = o3.b.f12483b;
            qVar = c.f12485b;
        } else {
            qVar = null;
            f12488b = null;
            f12489c = null;
            f12490d = null;
            f12491e = null;
        }
        f12492f = qVar;
    }
}
