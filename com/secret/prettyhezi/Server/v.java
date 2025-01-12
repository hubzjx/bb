package com.secret.prettyhezi.Server;

import c.abc;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.j;
import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    public static String f7132a = g4.g.a().h("keyLastServer4", abc.c(1));

    /* renamed from: b  reason: collision with root package name */
    public static String f7133b = abc.c(2);

    /* renamed from: c  reason: collision with root package name */
    public static String f7134c = "v12/1";

    /* renamed from: d  reason: collision with root package name */
    public static String f7135d = "comment/new";

    /* loaded from: classes.dex */
    static class a implements Serializable {
        public int id;
        public String[] post_ids;
        public int type;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends f {
        public int id;
        public int post_id;
        public int type;

        b() {
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Serializable {
        public String op = com.secret.prettyhezi.Device.a.a();

        /* renamed from: p  reason: collision with root package name */
        public String f7136p;

        public c(String str) {
            this.f7136p = str;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends f {
        public String password;
    }

    /* loaded from: classes.dex */
    public static class e implements Serializable {
        public String name;
    }

    /* loaded from: classes.dex */
    public static class f implements Serializable {

        /* renamed from: p  reason: collision with root package name */
        public String f7137p;

        public f() {
            this.f7137p = com.secret.prettyhezi.Device.a.a();
        }

        public f(String str) {
            this.f7137p = str;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends f {
        public int id;

        public g(int i6) {
            this.id = i6;
        }
    }

    /* loaded from: classes.dex */
    static class h implements Serializable {
        public int post_id;
        public int type;

        h() {
        }
    }

    public static void A(String str, j.e eVar) {
        com.secret.prettyhezi.j.s(f7132a + "user/edit/json?query=nickname", "{\"nickname\": \"" + str + "\"}", true, eVar);
    }

    public static void B(int i6, j.e eVar) {
        com.secret.prettyhezi.j.o(f7132a + "box/unfollow/json?id=" + i6, true, eVar);
    }

    public static void C(int i6, j.e eVar) {
        com.secret.prettyhezi.j.o(f7132a + "user/unfollow/json?id=" + i6, true, eVar);
    }

    public static String a() {
        return "box/new/json";
    }

    public static String b() {
        String c6 = abc.c(2);
        if (c6.equals(f7133b)) {
            c6 = abc.c(3);
        }
        f7133b = c6;
        return c6;
    }

    public static String c(int i6, int i7) {
        return "box/follows/json?id=" + i6 + "&page=" + i7;
    }

    public static String d(int i6) {
        return "box/info/json?id=" + i6;
    }

    public static String e(int i6) {
        return "box/json?page=" + i6;
    }

    public static String f(int i6, int i7) {
        return "user/follows/json?id=" + i6 + "&page=" + i7;
    }

    public static String g(int i6) {
        return "user/explore/json?page=" + i6;
    }

    public static String h(int i6, int i7) {
        return "user/follows/json?id=" + i6 + "&page=" + i7 + "&t=1";
    }

    public static String i(int i6, int i7) {
        return "box/top/json?page=" + i6 + "&by=" + i7;
    }

    public static String j(int i6, int i7) {
        return "user/fans/json?id=" + i6 + "&page=" + i7;
    }

    public static String k(int i6, int i7) {
        return "user/box/json?id=" + i6 + "&page=" + i7;
    }

    public static String l(int i6) {
        StringBuilder sb;
        String str;
        if (MainApplication.f6711r.r() != null) {
            sb = new StringBuilder();
            str = "user/uinfo/json?id=";
        } else {
            sb = new StringBuilder();
            str = "user/info/json?id=";
        }
        sb.append(str);
        sb.append(i6);
        return sb.toString();
    }

    public static void m(String str) {
        f7133b = str;
    }

    public static void n(String str) {
        g4.g.a().o("keyLastServer4", str);
        f7132a = str;
    }

    public static void o(String[] strArr, int i6, int i7, j.e eVar) {
        a aVar = new a();
        aVar.id = i7;
        aVar.post_ids = strArr;
        aVar.type = i6;
        com.secret.prettyhezi.j.s(f7132a + "box/collection/many/json", com.secret.prettyhezi.f.e(aVar), true, eVar);
    }

    public static void p(int i6, int i7, int i8, j.e eVar) {
        b bVar = new b();
        bVar.id = i8;
        bVar.post_id = i6;
        bVar.type = i7;
        com.secret.prettyhezi.j.s(f7132a + "box/collection/json", com.secret.prettyhezi.f.e(bVar), true, eVar);
    }

    public static void q(String str, j.e eVar) {
        c cVar = new c(str);
        com.secret.prettyhezi.j.s(f7132a + "user/edit/json?query=payment", com.secret.prettyhezi.f.e(cVar), true, eVar);
    }

    public static void r(String str, j.e eVar) {
        d dVar = new d();
        dVar.password = str;
        com.secret.prettyhezi.j.s(f7132a + "user/edit/json?query=password", com.secret.prettyhezi.f.e(dVar), true, eVar);
    }

    public static void s(int i6, j.e eVar) {
        com.secret.prettyhezi.j.r(f7132a + "box/delete/json?id=" + i6, new g(i6), true, eVar);
    }

    public static void t(int i6, String str, j.e eVar) {
        e eVar2 = new e();
        eVar2.name = str;
        com.secret.prettyhezi.j.s(f7132a + "box/edit/json?id=" + i6, com.secret.prettyhezi.f.e(eVar2), true, eVar);
    }

    public static void u(int i6, j.e eVar) {
        com.secret.prettyhezi.j.o(f7132a + "box/follow/json?id=" + i6, true, eVar);
    }

    public static void v(int i6, j.e eVar) {
        com.secret.prettyhezi.j.o(f7132a + "user/follow/json?id=" + i6, true, eVar);
    }

    public static void w(String str, j.e eVar) {
        com.secret.prettyhezi.j.n(f7132a + "user/reset/token/json", str, eVar);
    }

    public static void x(int i6, int i7, j.e eVar) {
        h hVar = new h();
        hVar.post_id = i6;
        hVar.type = i7;
        com.secret.prettyhezi.j.s(f7132a + "box/items/json", com.secret.prettyhezi.f.e(hVar), true, eVar);
    }

    public static void y(int i6, int i7, int i8, j.e eVar) {
        b bVar = new b();
        bVar.id = i8;
        bVar.post_id = i6;
        bVar.type = i7;
        com.secret.prettyhezi.j.s(f7132a + "box/uncollection/json", com.secret.prettyhezi.f.e(bVar), true, eVar);
    }

    public static void z(String[] strArr, int i6, int i7, j.e eVar) {
        a aVar = new a();
        aVar.id = i7;
        aVar.post_ids = strArr;
        aVar.type = i6;
        com.secret.prettyhezi.j.s(f7132a + "box/uncollection/many/json", com.secret.prettyhezi.f.e(aVar), true, eVar);
    }
}
