package r4;

import io.jsonwebtoken.JwtParser;
import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
abstract class e {
    public static final void a(boolean z5, Number number) {
        l.d(number, "step");
        if (z5) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + JwtParser.SEPARATOR_CHAR);
    }
}
