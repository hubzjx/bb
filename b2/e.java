package b2;

import android.net.Uri;
import com.google.android.exoplayer2.s0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class e extends g {

    /* renamed from: n  reason: collision with root package name */
    public static final e f2939n = new e(HttpUrl.FRAGMENT_ENCODE_SET, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: d  reason: collision with root package name */
    public final List f2940d;

    /* renamed from: e  reason: collision with root package name */
    public final List f2941e;

    /* renamed from: f  reason: collision with root package name */
    public final List f2942f;

    /* renamed from: g  reason: collision with root package name */
    public final List f2943g;

    /* renamed from: h  reason: collision with root package name */
    public final List f2944h;

    /* renamed from: i  reason: collision with root package name */
    public final List f2945i;

    /* renamed from: j  reason: collision with root package name */
    public final s0 f2946j;

    /* renamed from: k  reason: collision with root package name */
    public final List f2947k;

    /* renamed from: l  reason: collision with root package name */
    public final Map f2948l;

    /* renamed from: m  reason: collision with root package name */
    public final List f2949m;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f2950a;

        /* renamed from: b  reason: collision with root package name */
        public final s0 f2951b;

        /* renamed from: c  reason: collision with root package name */
        public final String f2952c;

        /* renamed from: d  reason: collision with root package name */
        public final String f2953d;

        public a(Uri uri, s0 s0Var, String str, String str2) {
            this.f2950a = uri;
            this.f2951b = s0Var;
            this.f2952c = str;
            this.f2953d = str2;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f2954a;

        /* renamed from: b  reason: collision with root package name */
        public final s0 f2955b;

        /* renamed from: c  reason: collision with root package name */
        public final String f2956c;

        /* renamed from: d  reason: collision with root package name */
        public final String f2957d;

        /* renamed from: e  reason: collision with root package name */
        public final String f2958e;

        /* renamed from: f  reason: collision with root package name */
        public final String f2959f;

        public b(Uri uri, s0 s0Var, String str, String str2, String str3, String str4) {
            this.f2954a = uri;
            this.f2955b = s0Var;
            this.f2956c = str;
            this.f2957d = str2;
            this.f2958e = str3;
            this.f2959f = str4;
        }

        public static b b(Uri uri) {
            return new b(uri, new s0.b().S("0").K("application/x-mpegURL").E(), null, null, null, null);
        }

        public b a(s0 s0Var) {
            return new b(this.f2954a, s0Var, this.f2956c, this.f2957d, this.f2958e, this.f2959f);
        }
    }

    public e(String str, List list, List list2, List list3, List list4, List list5, List list6, s0 s0Var, List list7, boolean z5, Map map, List list8) {
        super(str, list, z5);
        this.f2940d = Collections.unmodifiableList(f(list2, list3, list4, list5, list6));
        this.f2941e = Collections.unmodifiableList(list2);
        this.f2942f = Collections.unmodifiableList(list3);
        this.f2943g = Collections.unmodifiableList(list4);
        this.f2944h = Collections.unmodifiableList(list5);
        this.f2945i = Collections.unmodifiableList(list6);
        this.f2946j = s0Var;
        this.f2947k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f2948l = Collections.unmodifiableMap(map);
        this.f2949m = Collections.unmodifiableList(list8);
    }

    private static void b(List list, List list2) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            Uri uri = ((a) list.get(i6)).f2950a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    private static List d(List list, int i6, List list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i7 = 0; i7 < list.size(); i7++) {
            Object obj = list.get(i7);
            int i8 = 0;
            while (true) {
                if (i8 < list2.size()) {
                    u1.e eVar = (u1.e) list2.get(i8);
                    if (eVar.f13429b == i6 && eVar.f13430c == i7) {
                        arrayList.add(obj);
                        break;
                    }
                    i8++;
                }
            }
        }
        return arrayList;
    }

    public static e e(String str) {
        return new e(HttpUrl.FRAGMENT_ENCODE_SET, Collections.emptyList(), Collections.singletonList(b.b(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    private static List f(List list, List list2, List list3, List list4, List list5) {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            Uri uri = ((b) list.get(i6)).f2954a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list2, arrayList);
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        return arrayList;
    }

    @Override // u1.c
    /* renamed from: c */
    public e a(List list) {
        return new e(this.f2985a, this.f2986b, d(this.f2941e, 0, list), Collections.emptyList(), d(this.f2943g, 1, list), d(this.f2944h, 2, list), Collections.emptyList(), this.f2946j, this.f2947k, this.f2987c, this.f2948l, this.f2949m);
    }
}
