package c0;

import android.os.Build;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
/* loaded from: classes.dex */
public abstract class n implements Spannable {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f3111a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f3112b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3113c;

        /* renamed from: d  reason: collision with root package name */
        private final int f3114d;

        /* renamed from: e  reason: collision with root package name */
        final PrecomputedText.Params f3115e;

        /* renamed from: c0.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0032a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f3116a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f3117b;

            /* renamed from: c  reason: collision with root package name */
            private int f3118c;

            /* renamed from: d  reason: collision with root package name */
            private int f3119d;

            public C0032a(TextPaint textPaint) {
                this.f3116a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f3118c = 1;
                    this.f3119d = 1;
                } else {
                    this.f3119d = 0;
                    this.f3118c = 0;
                }
                this.f3117b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public a a() {
                return new a(this.f3116a, this.f3117b, this.f3118c, this.f3119d);
            }

            public C0032a b(int i6) {
                this.f3118c = i6;
                return this;
            }

            public C0032a c(int i6) {
                this.f3119d = i6;
                return this;
            }

            public C0032a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f3117b = textDirectionHeuristic;
                return this;
            }
        }

        public a(PrecomputedText.Params params) {
            TextPaint textPaint;
            TextDirectionHeuristic textDirection;
            int breakStrategy;
            int hyphenationFrequency;
            textPaint = params.getTextPaint();
            this.f3111a = textPaint;
            textDirection = params.getTextDirection();
            this.f3112b = textDirection;
            breakStrategy = params.getBreakStrategy();
            this.f3113c = breakStrategy;
            hyphenationFrequency = params.getHyphenationFrequency();
            this.f3114d = hyphenationFrequency;
            this.f3115e = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public boolean a(a aVar) {
            LocaleList textLocales;
            LocaleList textLocales2;
            boolean equals;
            int i6 = Build.VERSION.SDK_INT;
            if ((i6 < 23 || (this.f3113c == aVar.b() && this.f3114d == aVar.c())) && this.f3111a.getTextSize() == aVar.e().getTextSize() && this.f3111a.getTextScaleX() == aVar.e().getTextScaleX() && this.f3111a.getTextSkewX() == aVar.e().getTextSkewX() && this.f3111a.getLetterSpacing() == aVar.e().getLetterSpacing() && TextUtils.equals(this.f3111a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) && this.f3111a.getFlags() == aVar.e().getFlags()) {
                if (i6 >= 24) {
                    textLocales = this.f3111a.getTextLocales();
                    textLocales2 = aVar.e().getTextLocales();
                    equals = textLocales.equals(textLocales2);
                    if (!equals) {
                        return false;
                    }
                } else if (!this.f3111a.getTextLocale().equals(aVar.e().getTextLocale())) {
                    return false;
                }
                return this.f3111a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f3111a.getTypeface().equals(aVar.e().getTypeface());
            }
            return false;
        }

        public int b() {
            return this.f3113c;
        }

        public int c() {
            return this.f3114d;
        }

        public TextDirectionHeuristic d() {
            return this.f3112b;
        }

        public TextPaint e() {
            return this.f3111a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return a(aVar) && this.f3112b == aVar.d();
            }
            return false;
        }

        public int hashCode() {
            LocaleList textLocales;
            if (Build.VERSION.SDK_INT >= 24) {
                textLocales = this.f3111a.getTextLocales();
                return d0.d.b(Float.valueOf(this.f3111a.getTextSize()), Float.valueOf(this.f3111a.getTextScaleX()), Float.valueOf(this.f3111a.getTextSkewX()), Float.valueOf(this.f3111a.getLetterSpacing()), Integer.valueOf(this.f3111a.getFlags()), textLocales, this.f3111a.getTypeface(), Boolean.valueOf(this.f3111a.isElegantTextHeight()), this.f3112b, Integer.valueOf(this.f3113c), Integer.valueOf(this.f3114d));
            }
            return d0.d.b(Float.valueOf(this.f3111a.getTextSize()), Float.valueOf(this.f3111a.getTextScaleX()), Float.valueOf(this.f3111a.getTextSkewX()), Float.valueOf(this.f3111a.getLetterSpacing()), Integer.valueOf(this.f3111a.getFlags()), this.f3111a.getTextLocale(), this.f3111a.getTypeface(), Boolean.valueOf(this.f3111a.isElegantTextHeight()), this.f3112b, Integer.valueOf(this.f3113c), Integer.valueOf(this.f3114d));
        }

        public String toString() {
            StringBuilder sb;
            Object textLocale;
            String fontVariationSettings;
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.f3111a.getTextSize());
            sb2.append(", textScaleX=" + this.f3111a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f3111a.getTextSkewX());
            int i6 = Build.VERSION.SDK_INT;
            sb2.append(", letterSpacing=" + this.f3111a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f3111a.isElegantTextHeight());
            if (i6 >= 24) {
                sb = new StringBuilder();
                sb.append(", textLocale=");
                textLocale = this.f3111a.getTextLocales();
            } else {
                sb = new StringBuilder();
                sb.append(", textLocale=");
                textLocale = this.f3111a.getTextLocale();
            }
            sb.append(textLocale);
            sb2.append(sb.toString());
            sb2.append(", typeface=" + this.f3111a.getTypeface());
            if (i6 >= 26) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(", variationSettings=");
                fontVariationSettings = this.f3111a.getFontVariationSettings();
                sb3.append(fontVariationSettings);
                sb2.append(sb3.toString());
            }
            sb2.append(", textDir=" + this.f3112b);
            sb2.append(", breakStrategy=" + this.f3113c);
            sb2.append(", hyphenationFrequency=" + this.f3114d);
            sb2.append("}");
            return sb2.toString();
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i6, int i7) {
            PrecomputedText.Params params;
            PrecomputedText.Params.Builder breakStrategy;
            PrecomputedText.Params.Builder hyphenationFrequency;
            PrecomputedText.Params.Builder textDirection;
            if (Build.VERSION.SDK_INT >= 29) {
                d.a();
                breakStrategy = c.a(textPaint).setBreakStrategy(i6);
                hyphenationFrequency = breakStrategy.setHyphenationFrequency(i7);
                textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
                params = textDirection.build();
            } else {
                params = null;
            }
            this.f3115e = params;
            this.f3111a = textPaint;
            this.f3112b = textDirectionHeuristic;
            this.f3113c = i6;
            this.f3114d = i7;
        }
    }
}
