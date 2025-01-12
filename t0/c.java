package t0;

import com.flask.colorpicker.a;
import u0.e;
/* loaded from: classes.dex */
public abstract class c {

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13340a;

        static {
            int[] iArr = new int[a.c.values().length];
            f13340a = iArr;
            try {
                iArr[a.c.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13340a[a.c.FLOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static u0.c a(a.c cVar) {
        int i6 = a.f13340a[cVar.ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                return new u0.d();
            }
            throw new IllegalArgumentException("wrong WHEEL_TYPE");
        }
        return new e();
    }
}
