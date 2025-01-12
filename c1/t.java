package c1;

import com.google.android.exoplayer2.util.s0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n1.a;
/* loaded from: classes.dex */
public final class t {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f3239c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a  reason: collision with root package name */
    public int f3240a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f3241b = -1;

    private boolean b(String str) {
        Matcher matcher = f3239c.matcher(str);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt((String) s0.j(matcher.group(1)), 16);
                int parseInt2 = Integer.parseInt((String) s0.j(matcher.group(2)), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.f3240a = parseInt;
                    this.f3241b = parseInt2;
                    return true;
                }
                return false;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean a() {
        return (this.f3240a == -1 || this.f3241b == -1) ? false : true;
    }

    public boolean c(n1.a aVar) {
        for (int i6 = 0; i6 < aVar.h(); i6++) {
            a.b g6 = aVar.g(i6);
            if (g6 instanceof s1.e) {
                s1.e eVar = (s1.e) g6;
                if ("iTunSMPB".equals(eVar.f13141c) && b(eVar.f13142d)) {
                    return true;
                }
            } else if (g6 instanceof s1.j) {
                s1.j jVar = (s1.j) g6;
                if ("com.apple.iTunes".equals(jVar.f13153b) && "iTunSMPB".equals(jVar.f13154c) && b(jVar.f13155d)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean d(int i6) {
        int i7 = i6 >> 12;
        int i8 = i6 & 4095;
        if (i7 > 0 || i8 > 0) {
            this.f3240a = i7;
            this.f3241b = i8;
            return true;
        }
        return false;
    }
}
