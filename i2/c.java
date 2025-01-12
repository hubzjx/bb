package i2;

import android.text.Spannable;
/* loaded from: classes.dex */
public abstract class c {
    public static void a(Spannable spannable, Object obj, int i6, int i7, int i8) {
        Object[] spans;
        for (Object obj2 : spannable.getSpans(i6, i7, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i6 && spannable.getSpanEnd(obj2) == i7 && spannable.getSpanFlags(obj2) == i8) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i6, i7, i8);
    }
}
