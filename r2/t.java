package r2;

import com.google.android.exoplayer2.util.s0;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
final class t extends j {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f13027g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f13028h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f13029k = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    private t(String str, long j6, long j7, long j8, File file) {
        super(str, j6, j7, j8, file);
    }

    public static t e(File file, long j6, long j7, l lVar) {
        File file2;
        String k6;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            File j8 = j(file, lVar);
            if (j8 == null) {
                return null;
            }
            file2 = j8;
            name = j8.getName();
        }
        Matcher matcher = f13029k.matcher(name);
        if (matcher.matches() && (k6 = lVar.k(Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))))) != null) {
            long length = j6 == -1 ? file2.length() : j6;
            if (length == 0) {
                return null;
            }
            return new t(k6, Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))), length, j7 == -9223372036854775807L ? Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(3))) : j7, file2);
        }
        return null;
    }

    public static t f(File file, long j6, l lVar) {
        return e(file, j6, -9223372036854775807L, lVar);
    }

    public static t g(String str, long j6, long j7) {
        return new t(str, j6, j7, -9223372036854775807L, null);
    }

    public static t h(String str, long j6) {
        return new t(str, j6, -1L, -9223372036854775807L, null);
    }

    public static File i(File file, int i6, long j6, long j7) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(i6);
        sb.append(".");
        sb.append(j6);
        sb.append(".");
        sb.append(j7);
        sb.append(".v3.exo");
        return new File(file, sb.toString());
    }

    private static File j(File file, l lVar) {
        String str;
        String name = file.getName();
        Matcher matcher = f13028h.matcher(name);
        if (matcher.matches()) {
            str = s0.W0((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
        } else {
            matcher = f13027g.matcher(name);
            str = matcher.matches() ? (String) com.google.android.exoplayer2.util.a.e(matcher.group(1)) : null;
        }
        if (str == null) {
            return null;
        }
        File i6 = i((File) com.google.android.exoplayer2.util.a.i(file.getParentFile()), lVar.f(str), Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))), Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(3))));
        if (file.renameTo(i6)) {
            return i6;
        }
        return null;
    }

    public t d(File file, long j6) {
        com.google.android.exoplayer2.util.a.g(this.f12977d);
        return new t(this.f12974a, this.f12975b, this.f12976c, j6, file);
    }
}
