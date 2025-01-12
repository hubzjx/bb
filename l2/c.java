package l2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import e2.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f11796a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11797b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11798c;

    /* renamed from: d  reason: collision with root package name */
    public final long f11799d;

    /* renamed from: e  reason: collision with root package name */
    public final long f11800e;

    /* renamed from: f  reason: collision with root package name */
    public final f f11801f;

    /* renamed from: g  reason: collision with root package name */
    private final String[] f11802g;

    /* renamed from: h  reason: collision with root package name */
    public final String f11803h;

    /* renamed from: i  reason: collision with root package name */
    public final String f11804i;

    /* renamed from: j  reason: collision with root package name */
    public final c f11805j;

    /* renamed from: k  reason: collision with root package name */
    private final HashMap f11806k;

    /* renamed from: l  reason: collision with root package name */
    private final HashMap f11807l;

    /* renamed from: m  reason: collision with root package name */
    private List f11808m;

    private c(String str, String str2, long j6, long j7, f fVar, String[] strArr, String str3, String str4, c cVar) {
        this.f11796a = str;
        this.f11797b = str2;
        this.f11804i = str4;
        this.f11801f = fVar;
        this.f11802g = strArr;
        this.f11798c = str2 != null;
        this.f11799d = j6;
        this.f11800e = j7;
        this.f11803h = (String) com.google.android.exoplayer2.util.a.e(str3);
        this.f11805j = cVar;
        this.f11806k = new HashMap();
        this.f11807l = new HashMap();
    }

    private void b(Map map, b.C0159b c0159b, int i6, int i7) {
        f f6 = e.f(this.f11801f, this.f11802g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) c0159b.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            c0159b.m(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (f6 != null) {
            e.a(spannableStringBuilder2, i6, i7, f6, this.f11805j, map);
            c0159b.n(f6.k());
        }
    }

    public static c c(String str, long j6, long j7, f fVar, String[] strArr, String str2, String str3, c cVar) {
        return new c(str, null, j6, j7, fVar, strArr, str2, str3, cVar);
    }

    public static c d(String str) {
        return new c(null, e.b(str), -9223372036854775807L, -9223372036854775807L, null, null, HttpUrl.FRAGMENT_ENCODE_SET, null, null);
    }

    private static void e(SpannableStringBuilder spannableStringBuilder) {
        a[] aVarArr;
        for (a aVar : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), HttpUrl.FRAGMENT_ENCODE_SET);
        }
        for (int i6 = 0; i6 < spannableStringBuilder.length(); i6++) {
            if (spannableStringBuilder.charAt(i6) == ' ') {
                int i7 = i6 + 1;
                int i8 = i7;
                while (i8 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i8) == ' ') {
                    i8++;
                }
                int i9 = i8 - i7;
                if (i9 > 0) {
                    spannableStringBuilder.delete(i6, i9 + i6);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i10 = 0; i10 < spannableStringBuilder.length() - 1; i10++) {
            if (spannableStringBuilder.charAt(i10) == '\n') {
                int i11 = i10 + 1;
                if (spannableStringBuilder.charAt(i11) == ' ') {
                    spannableStringBuilder.delete(i11, i10 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i12 = 0; i12 < spannableStringBuilder.length() - 1; i12++) {
            if (spannableStringBuilder.charAt(i12) == ' ') {
                int i13 = i12 + 1;
                if (spannableStringBuilder.charAt(i13) == '\n') {
                    spannableStringBuilder.delete(i12, i13);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    private void i(TreeSet treeSet, boolean z5) {
        boolean equals = "p".equals(this.f11796a);
        boolean equals2 = "div".equals(this.f11796a);
        if (z5 || equals || (equals2 && this.f11804i != null)) {
            long j6 = this.f11799d;
            if (j6 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j6));
            }
            long j7 = this.f11800e;
            if (j7 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j7));
            }
        }
        if (this.f11808m == null) {
            return;
        }
        for (int i6 = 0; i6 < this.f11808m.size(); i6++) {
            ((c) this.f11808m.get(i6)).i(treeSet, z5 || equals);
        }
    }

    private static SpannableStringBuilder k(String str, Map map) {
        if (!map.containsKey(str)) {
            b.C0159b c0159b = new b.C0159b();
            c0159b.m(new SpannableStringBuilder());
            map.put(str, c0159b);
        }
        return (SpannableStringBuilder) com.google.android.exoplayer2.util.a.e(((b.C0159b) map.get(str)).e());
    }

    private void n(long j6, String str, List list) {
        if (!HttpUrl.FRAGMENT_ENCODE_SET.equals(this.f11803h)) {
            str = this.f11803h;
        }
        if (m(j6) && "div".equals(this.f11796a) && this.f11804i != null) {
            list.add(new Pair(str, this.f11804i));
            return;
        }
        for (int i6 = 0; i6 < g(); i6++) {
            f(i6).n(j6, str, list);
        }
    }

    private void o(long j6, Map map, Map map2) {
        int i6;
        if (m(j6)) {
            Iterator it = this.f11807l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                i6 = this.f11806k.containsKey(str) ? ((Integer) this.f11806k.get(str)).intValue() : 0;
                int intValue = ((Integer) entry.getValue()).intValue();
                if (i6 != intValue) {
                    b(map, (b.C0159b) com.google.android.exoplayer2.util.a.e((b.C0159b) map2.get(str)), i6, intValue);
                }
            }
            while (i6 < g()) {
                f(i6).o(j6, map, map2);
                i6++;
            }
        }
    }

    private void p(long j6, boolean z5, String str, Map map) {
        this.f11806k.clear();
        this.f11807l.clear();
        if ("metadata".equals(this.f11796a)) {
            return;
        }
        if (!HttpUrl.FRAGMENT_ENCODE_SET.equals(this.f11803h)) {
            str = this.f11803h;
        }
        if (this.f11798c && z5) {
            k(str, map).append((CharSequence) com.google.android.exoplayer2.util.a.e(this.f11797b));
        } else if ("br".equals(this.f11796a) && z5) {
            k(str, map).append('\n');
        } else if (m(j6)) {
            for (Map.Entry entry : map.entrySet()) {
                this.f11806k.put((String) entry.getKey(), Integer.valueOf(((CharSequence) com.google.android.exoplayer2.util.a.e(((b.C0159b) entry.getValue()).e())).length()));
            }
            boolean equals = "p".equals(this.f11796a);
            for (int i6 = 0; i6 < g(); i6++) {
                f(i6).p(j6, z5 || equals, str, map);
            }
            if (equals) {
                e.c(k(str, map));
            }
            for (Map.Entry entry2 : map.entrySet()) {
                this.f11807l.put((String) entry2.getKey(), Integer.valueOf(((CharSequence) com.google.android.exoplayer2.util.a.e(((b.C0159b) entry2.getValue()).e())).length()));
            }
        }
    }

    public void a(c cVar) {
        if (this.f11808m == null) {
            this.f11808m = new ArrayList();
        }
        this.f11808m.add(cVar);
    }

    public c f(int i6) {
        List list = this.f11808m;
        if (list != null) {
            return (c) list.get(i6);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List list = this.f11808m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List h(long j6, Map map, Map map2, Map map3) {
        List<Pair> arrayList = new ArrayList();
        n(j6, this.f11803h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j6, false, this.f11803h, treeMap);
        o(j6, map, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                d dVar = (d) com.google.android.exoplayer2.util.a.e((d) map2.get(pair.first));
                arrayList2.add(new b.C0159b().f(decodeByteArray).j(dVar.f11810b).k(0).h(dVar.f11811c, 0).i(dVar.f11813e).l(dVar.f11814f).g(dVar.f11815g).p(dVar.f11818j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            d dVar2 = (d) com.google.android.exoplayer2.util.a.e((d) map2.get(entry.getKey()));
            b.C0159b c0159b = (b.C0159b) entry.getValue();
            e((SpannableStringBuilder) com.google.android.exoplayer2.util.a.e(c0159b.e()));
            c0159b.h(dVar2.f11811c, dVar2.f11812d);
            c0159b.i(dVar2.f11813e);
            c0159b.j(dVar2.f11810b);
            c0159b.l(dVar2.f11814f);
            c0159b.o(dVar2.f11817i, dVar2.f11816h);
            c0159b.p(dVar2.f11818j);
            arrayList2.add(c0159b.a());
        }
        return arrayList2;
    }

    public long[] j() {
        TreeSet treeSet = new TreeSet();
        int i6 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i6] = ((Long) it.next()).longValue();
            i6++;
        }
        return jArr;
    }

    public String[] l() {
        return this.f11802g;
    }

    public boolean m(long j6) {
        long j7 = this.f11799d;
        return (j7 == -9223372036854775807L && this.f11800e == -9223372036854775807L) || (j7 <= j6 && this.f11800e == -9223372036854775807L) || ((j7 == -9223372036854775807L && j6 < this.f11800e) || (j7 <= j6 && j6 < this.f11800e));
    }
}
