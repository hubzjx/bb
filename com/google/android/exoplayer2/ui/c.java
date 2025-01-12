package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.google.android.exoplayer2.ui.c;
import com.google.android.exoplayer2.util.s0;
import com.google.common.collect.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f4532a = Pattern.compile("(&#13;)?&#10;");

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f4533a;

        /* renamed from: b  reason: collision with root package name */
        public final Map f4534b;

        private b(String str, Map map) {
            this.f4533a = str;
            this.f4534b = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.ui.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0043c {

        /* renamed from: e  reason: collision with root package name */
        private static final Comparator f4535e = new Comparator() { // from class: com.google.android.exoplayer2.ui.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e6;
                e6 = c.C0043c.e((c.C0043c) obj, (c.C0043c) obj2);
                return e6;
            }
        };

        /* renamed from: f  reason: collision with root package name */
        private static final Comparator f4536f = new Comparator() { // from class: com.google.android.exoplayer2.ui.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int f6;
                f6 = c.C0043c.f((c.C0043c) obj, (c.C0043c) obj2);
                return f6;
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public final int f4537a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4538b;

        /* renamed from: c  reason: collision with root package name */
        public final String f4539c;

        /* renamed from: d  reason: collision with root package name */
        public final String f4540d;

        private C0043c(int i6, int i7, String str, String str2) {
            this.f4537a = i6;
            this.f4538b = i7;
            this.f4539c = str;
            this.f4540d = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int e(C0043c c0043c, C0043c c0043c2) {
            int compare = Integer.compare(c0043c2.f4538b, c0043c.f4538b);
            if (compare != 0) {
                return compare;
            }
            int compareTo = c0043c.f4539c.compareTo(c0043c2.f4539c);
            return compareTo != 0 ? compareTo : c0043c.f4540d.compareTo(c0043c2.f4540d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int f(C0043c c0043c, C0043c c0043c2) {
            int compare = Integer.compare(c0043c2.f4537a, c0043c.f4537a);
            if (compare != 0) {
                return compare;
            }
            int compareTo = c0043c2.f4539c.compareTo(c0043c.f4539c);
            return compareTo != 0 ? compareTo : c0043c2.f4540d.compareTo(c0043c.f4540d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final List f4541a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List f4542b = new ArrayList();
    }

    public static b a(CharSequence charSequence, float f6) {
        if (charSequence == null) {
            return new b(HttpUrl.FRAGMENT_ENCODE_SET, a0.of());
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            HashSet<Integer> hashSet = new HashSet();
            int i6 = 0;
            for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
                hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
            }
            HashMap hashMap = new HashMap();
            for (Integer num : hashSet) {
                int intValue = num.intValue();
                StringBuilder sb = new StringBuilder(14);
                sb.append("bg_");
                sb.append(intValue);
                hashMap.put(com.google.android.exoplayer2.ui.b.a(sb.toString()), s0.D("background-color:%s;", com.google.android.exoplayer2.ui.b.b(intValue)));
            }
            SparseArray c6 = c(spanned, f6);
            StringBuilder sb2 = new StringBuilder(spanned.length());
            int i7 = 0;
            while (i6 < c6.size()) {
                int keyAt = c6.keyAt(i6);
                sb2.append(b(spanned.subSequence(i7, keyAt)));
                d dVar = (d) c6.get(keyAt);
                Collections.sort(dVar.f4542b, C0043c.f4536f);
                for (C0043c c0043c : dVar.f4542b) {
                    sb2.append(c0043c.f4540d);
                }
                Collections.sort(dVar.f4541a, C0043c.f4535e);
                for (C0043c c0043c2 : dVar.f4541a) {
                    sb2.append(c0043c2.f4539c);
                }
                i6++;
                i7 = keyAt;
            }
            sb2.append(b(spanned.subSequence(i7, spanned.length())));
            return new b(sb2.toString(), hashMap);
        }
        return new b(b(charSequence), a0.of());
    }

    private static String b(CharSequence charSequence) {
        return f4532a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    private static SparseArray c(Spanned spanned, float f6) {
        Object[] spans;
        SparseArray sparseArray = new SparseArray();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String e6 = e(obj, f6);
            String d6 = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (e6 != null) {
                com.google.android.exoplayer2.util.a.e(d6);
                C0043c c0043c = new C0043c(spanStart, spanEnd, e6, d6);
                f(sparseArray, spanStart).f4541a.add(c0043c);
                f(sparseArray, spanEnd).f4542b.add(c0043c);
            }
        }
        return sparseArray;
    }

    private static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof i2.a) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else if (obj instanceof i2.b) {
            String b6 = b(((i2.b) obj).f11029a);
            StringBuilder sb = new StringBuilder(String.valueOf(b6).length() + 16);
            sb.append("<rt>");
            sb.append(b6);
            sb.append("</rt></ruby>");
            return sb.toString();
        } else if (obj instanceof UnderlineSpan) {
            return "</u>";
        }
        return null;
    }

    private static String e(Object obj, float f6) {
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return s0.D("<span style='color:%s;'>", com.google.android.exoplayer2.ui.b.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return s0.D("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof i2.a) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
            boolean dip = absoluteSizeSpan.getDip();
            float size = absoluteSizeSpan.getSize();
            if (!dip) {
                size /= f6;
            }
            return s0.D("<span style='font-size:%.2fpx;'>", Float.valueOf(size));
        } else if (obj instanceof RelativeSizeSpan) {
            return s0.D("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        } else {
            if (obj instanceof TypefaceSpan) {
                String family = ((TypefaceSpan) obj).getFamily();
                if (family != null) {
                    return s0.D("<span style='font-family:\"%s\";'>", family);
                }
                return null;
            } else if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style != 1) {
                    if (style != 2) {
                        if (style != 3) {
                            return null;
                        }
                        return "<b><i>";
                    }
                    return "<i>";
                }
                return "<b>";
            } else if (!(obj instanceof i2.b)) {
                if (obj instanceof UnderlineSpan) {
                    return "<u>";
                }
                return null;
            } else {
                int i6 = ((i2.b) obj).f11030b;
                if (i6 != -1) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            return null;
                        }
                        return "<ruby style='ruby-position:under;'>";
                    }
                    return "<ruby style='ruby-position:over;'>";
                }
                return "<ruby style='ruby-position:unset;'>";
            }
        }
    }

    private static d f(SparseArray sparseArray, int i6) {
        d dVar = (d) sparseArray.get(i6);
        if (dVar == null) {
            d dVar2 = new d();
            sparseArray.put(i6, dVar2);
            return dVar2;
        }
        return dVar;
    }
}
