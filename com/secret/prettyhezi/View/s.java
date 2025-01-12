package com.secret.prettyhezi.View;

import com.secret.prettyhezi.MainApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {

    /* renamed from: f  reason: collision with root package name */
    private static r0.a f7995f;

    /* renamed from: g  reason: collision with root package name */
    public static s f7996g;

    /* renamed from: a  reason: collision with root package name */
    a f7997a;

    /* renamed from: b  reason: collision with root package name */
    a f7998b;

    /* renamed from: c  reason: collision with root package name */
    a f7999c;

    /* renamed from: d  reason: collision with root package name */
    b f8000d;

    /* renamed from: e  reason: collision with root package name */
    String f8001e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends c {

        /* renamed from: c  reason: collision with root package name */
        long f8002c;

        public a(long j6) {
            super();
            this.f8006a = 1;
            this.f8002c = j6;
        }

        @Override // com.secret.prettyhezi.View.s.c
        public long a() {
            return (System.currentTimeMillis() / 1000) + this.f8002c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends c {

        /* renamed from: c  reason: collision with root package name */
        long f8004c;

        public b(long j6) {
            super();
            this.f8006a = 2;
            this.f8004c = j6;
        }

        @Override // com.secret.prettyhezi.View.s.c
        public long a() {
            long j6 = this.f8004c;
            return ((((((System.currentTimeMillis() / 1000) + 86400) - 1) - j6) / 86400) * 86400) + j6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        int f8006a;

        c() {
        }

        public abstract long a();
    }

    public s() {
        this.f7997a = null;
        this.f7998b = null;
        this.f7999c = null;
        this.f8000d = null;
        f7996g = this;
        this.f8001e = h();
        File file = new File(this.f8001e);
        if (!file.exists()) {
            file.mkdir();
        }
        f7995f = new r0.a();
        this.f8000d = new b(28800L);
        this.f7997a = new a(600L);
        this.f7998b = new a(3600L);
        this.f7999c = new a(864000L);
    }

    public static void c() {
        g4.c.a(h(), false);
    }

    public static String h() {
        return g4.i.j().getFilesDir().getAbsolutePath() + File.separator + "itemListCache4";
    }

    static long i(String str, String str2) {
        long j6;
        long parseInt = Integer.parseInt(str);
        if (str2.equals("h")) {
            j6 = 3600;
        } else if (!str2.equals("m")) {
            return parseInt;
        } else {
            j6 = 60;
        }
        return parseInt * j6;
    }

    protected static String[] m(String str) {
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        char charAt = str.charAt(0);
        if (charAt < '1' || charAt > '9') {
            arrayList.add(str.substring(0, 1));
            i6 = 1;
        }
        int i7 = i6;
        int i8 = i7;
        while (i7 < str.length()) {
            char charAt2 = str.charAt(i7);
            if (charAt2 >= '0' && charAt2 <= '9') {
                i8 = i7;
            }
            i7++;
        }
        int i9 = i8 + 1;
        arrayList.add(str.substring(i6, i9));
        if (str.length() > i8) {
            arrayList.add(str.substring(i9));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void a(String str, long j6) {
        if (str != null && !str.isEmpty()) {
            for (String str2 : str.split(",")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    String str3 = split[0];
                    String[] m5 = m(split[1]);
                    if (str3.equals("alltop") && m5.length == 3 && m5[0].equals("a")) {
                        this.f8000d = new b(i(m5[1], m5[2]));
                    } else if (str3.equals("latest") && m5.length == 2) {
                        this.f7997a = new a(i(m5[0], m5[1]));
                    } else if (str3.equals("default") && m5.length == 2) {
                        this.f7998b = new a(i(m5[0], m5[1]));
                    }
                }
            }
        }
        d();
    }

    public c b(String str) {
        if (str.startsWith("photo/top/json?page=999&by=1") || str.startsWith("video/top/json?page=999&by=1") || str.startsWith("film/top/json?page=999&by=1") || str.startsWith("book/top/json?page=999&by=1") || str.startsWith("box/top/json?page=999&by=1")) {
            return this.f7997a;
        }
        if (str.startsWith("photo/top/json?") || str.startsWith("video/top/json?") || str.startsWith("film/top/json?") || str.startsWith("book/top/json?") || str.startsWith("box/top/json?")) {
            return this.f8000d;
        }
        if (str.startsWith("user/explore/json?")) {
            return this.f7998b;
        }
        if (str.startsWith("photo/json?") || str.startsWith("gallery/json?") || str.startsWith("audio/json?") || str.startsWith("video/json?") || str.startsWith("film/json?") || str.startsWith("book/json?") || str.startsWith("box/json?") || str.startsWith("rrvideo/json?") || str.startsWith("photo/explore/json?") || str.startsWith("video/explore/json?")) {
            return this.f7997a;
        }
        if (str.startsWith("gallery/myunlock/json?") || str.startsWith("audio/myunlock/json?") || str.startsWith("rrvideo/myunlock/json?") || str.startsWith("user/follows/json?id=")) {
            return this.f7999c;
        }
        if (str.startsWith("film/node/json?id=") || str.startsWith("film/tag/json?id=") || str.startsWith("film/person/json?id=") || str.startsWith("film/location/json?id=")) {
            return this.f8000d;
        }
        return null;
    }

    public void d() {
        int[] iArr = {5, 6, 7};
        for (int i6 = 0; i6 < 3; i6++) {
            f(iArr[i6]);
        }
    }

    public void e() {
        int f6 = MainApplication.f();
        if (f6 <= 0) {
            return;
        }
        g(new String[]{com.secret.prettyhezi.Server.v.f(f6, 999)});
    }

    public void f(int i6) {
        g(new String[]{com.secret.prettyhezi.g.b(i6) + "/myunlock/json?page=999"});
    }

    public void g(String[] strArr) {
        for (String str : strArr) {
            String str2 = this.f8001e + File.separator + j(str);
            File file = new File(str2 + "_info.json");
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str2 + "_items.json");
            if (file2.exists()) {
                file2.delete();
            }
        }
    }

    String j(String str) {
        return f7995f.a(str);
    }

    public boolean k(String str, t tVar) {
        String absolutePath;
        String str2 = this.f8001e + File.separator + j(str);
        File file = new File(str2 + "_info.json");
        if (file.exists()) {
            r rVar = (r) com.secret.prettyhezi.f.d(g4.c.g(file.getAbsolutePath()), r.class);
            if (rVar == null || rVar.expire <= System.currentTimeMillis() / 1000) {
                absolutePath = file.getAbsolutePath();
            } else if (rVar.itemCount == 0) {
                tVar.x(rVar.totalPage, rVar.nextPage, rVar.expire, rVar.total, new ArrayList());
                return true;
            } else {
                try {
                    FileInputStream fileInputStream = new FileInputStream(str2 + "_items.json");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    ArrayList arrayList = (ArrayList) objectInputStream.readObject();
                    objectInputStream.close();
                    fileInputStream.close();
                    if (arrayList.size() == rVar.itemCount) {
                        if (rVar.total == 0) {
                            rVar.total = rVar.totalPage * 60;
                        }
                        tVar.x(rVar.totalPage, rVar.nextPage, rVar.expire, rVar.total, arrayList);
                        return true;
                    }
                    g4.c.c(file.getAbsolutePath());
                    g4.c.c(str2 + "_items.json");
                    return false;
                } catch (Exception unused) {
                    g4.c.c(file.getAbsolutePath());
                    absolutePath = str2 + "_items.json";
                }
            }
            g4.c.c(absolutePath);
            return false;
        }
        return false;
    }

    public void l() {
        g(new String[]{"user/explore/json?page=999", "gallery/myunlock/json?page=999", "audio/myunlock/json?page=999", "rrvideo/myunlock/json?page=999"});
    }

    public void n(String str, int i6, int i7, long j6, long j7, ArrayList arrayList) {
        r rVar = new r(i6, i7, arrayList.size(), j6, j7);
        String str2 = this.f8001e + File.separator + j(str);
        g4.c.k(str2 + "_info.json", com.secret.prettyhezi.f.e(rVar));
        if (arrayList.size() > 0) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str2 + "_items.json");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(arrayList);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }
}
