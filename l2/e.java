package l2;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import java.util.ArrayDeque;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class e {
    public static void a(Spannable spannable, int i6, int i7, f fVar, c cVar, Map map) {
        c e6;
        Object bVar;
        Object absoluteSizeSpan;
        if (fVar.j() != -1) {
            spannable.setSpan(new StyleSpan(fVar.j()), i6, i7, 33);
        }
        if (fVar.p()) {
            spannable.setSpan(new StrikethroughSpan(), i6, i7, 33);
        }
        if (fVar.q()) {
            spannable.setSpan(new UnderlineSpan(), i6, i7, 33);
        }
        if (fVar.n()) {
            i2.c.a(spannable, new ForegroundColorSpan(fVar.c()), i6, i7, 33);
        }
        if (fVar.m()) {
            i2.c.a(spannable, new BackgroundColorSpan(fVar.b()), i6, i7, 33);
        }
        if (fVar.d() != null) {
            i2.c.a(spannable, new TypefaceSpan(fVar.d()), i6, i7, 33);
        }
        int i8 = fVar.i();
        if (i8 == 2) {
            c d6 = d(cVar, map);
            if (d6 != null && (e6 = e(d6, map)) != null) {
                if (e6.g() != 1 || e6.f(0).f11797b == null) {
                    n.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) s0.j(e6.f(0).f11797b);
                    f fVar2 = d6.f11801f;
                    bVar = new i2.b(str, fVar2 != null ? fVar2.h() : -1);
                    spannable.setSpan(bVar, i6, i7, 33);
                }
            }
        } else if (i8 == 3 || i8 == 4) {
            bVar = new a();
            spannable.setSpan(bVar, i6, i7, 33);
        }
        if (fVar.l()) {
            i2.c.a(spannable, new i2.a(), i6, i7, 33);
        }
        int f6 = fVar.f();
        if (f6 == 1) {
            absoluteSizeSpan = new AbsoluteSizeSpan((int) fVar.e(), true);
        } else if (f6 == 2) {
            absoluteSizeSpan = new RelativeSizeSpan(fVar.e());
        } else if (f6 != 3) {
            return;
        } else {
            absoluteSizeSpan = new RelativeSizeSpan(fVar.e() / 100.0f);
        }
        i2.c.a(spannable, absoluteSizeSpan, i6, i7, 33);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    private static c d(c cVar, Map map) {
        while (cVar != null) {
            f f6 = f(cVar.f11801f, cVar.l(), map);
            if (f6 != null && f6.i() == 1) {
                return cVar;
            }
            cVar = cVar.f11805j;
        }
        return null;
    }

    private static c e(c cVar, Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(cVar);
        while (!arrayDeque.isEmpty()) {
            c cVar2 = (c) arrayDeque.pop();
            f f6 = f(cVar2.f11801f, cVar2.l(), map);
            if (f6 != null && f6.i() == 3) {
                return cVar2;
            }
            for (int g6 = cVar2.g() - 1; g6 >= 0; g6--) {
                arrayDeque.push(cVar2.f(g6));
            }
        }
        return null;
    }

    public static f f(f fVar, String[] strArr, Map map) {
        int i6 = 0;
        if (fVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (f) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                f fVar2 = new f();
                int length = strArr.length;
                while (i6 < length) {
                    fVar2.a((f) map.get(strArr[i6]));
                    i6++;
                }
                return fVar2;
            }
        } else if (strArr != null && strArr.length == 1) {
            return fVar.a((f) map.get(strArr[0]));
        } else {
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i6 < length2) {
                    fVar.a((f) map.get(strArr[i6]));
                    i6++;
                }
            }
        }
        return fVar;
    }
}
