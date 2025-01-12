package n2;

import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f12248a = Pattern.compile("^NOTE([ \t].*)?$");

    public static Matcher a(y yVar) {
        String m5;
        while (true) {
            String m6 = yVar.m();
            if (m6 == null) {
                return null;
            }
            if (f12248a.matcher(m6).matches()) {
                do {
                    m5 = yVar.m();
                    if (m5 != null) {
                    }
                } while (!m5.isEmpty());
            } else {
                Matcher matcher = f.f12222a.matcher(m6);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(y yVar) {
        String m5 = yVar.m();
        return m5 != null && m5.startsWith("WEBVTT");
    }

    public static float c(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) {
        String[] L0 = s0.L0(str, "\\.");
        long j6 = 0;
        for (String str2 : s0.K0(L0[0], ":")) {
            j6 = (j6 * 60) + Long.parseLong(str2);
        }
        long j7 = j6 * 1000;
        if (L0.length == 2) {
            j7 += Long.parseLong(L0[1]);
        }
        return j7 * 1000;
    }

    public static void e(y yVar) {
        int d6 = yVar.d();
        if (b(yVar)) {
            return;
        }
        yVar.M(d6);
        String valueOf = String.valueOf(yVar.m());
        throw new f1(valueOf.length() != 0 ? "Expected WEBVTT. Got ".concat(valueOf) : new String("Expected WEBVTT. Got "));
    }
}
