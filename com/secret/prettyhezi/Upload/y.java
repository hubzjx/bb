package com.secret.prettyhezi.Upload;

import android.provider.Settings;
import android.util.Log;
import c.abc;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    static String f7516a = "curItem2";

    /* renamed from: b  reason: collision with root package name */
    public static k f7517b;

    /* renamed from: c  reason: collision with root package name */
    static String f7518c;

    /* renamed from: d  reason: collision with root package name */
    static String f7519d = g4.i.j().getFilesDir().getAbsolutePath() + File.separator + "upload";

    /* renamed from: e  reason: collision with root package name */
    static String f7520e;

    /* renamed from: f  reason: collision with root package name */
    static boolean f7521f;

    /* renamed from: g  reason: collision with root package name */
    static boolean f7522g;

    /* renamed from: h  reason: collision with root package name */
    public static p f7523h;

    /* renamed from: i  reason: collision with root package name */
    static String f7524i;

    /* renamed from: j  reason: collision with root package name */
    static OkHttpClient f7525j;

    /* renamed from: k  reason: collision with root package name */
    static int f7526k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends j.e {
        a() {
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            Log.e("deleteCurItem", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends j.e {
        b() {
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            y.f7524i = "连接上传服务器失败";
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
            y.f7524i = "连接上传服务器失败";
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            o oVar = (o) com.secret.prettyhezi.f.d(str, o.class);
            if (oVar.code != 200) {
                y.f7524i = oVar.err;
                return;
            }
            p pVar = oVar.data;
            y.f7523h = pVar;
            y.f7518c = pVar.user.token;
            y.f7524i = null;
            if (y.f7517b != null) {
                y.C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j.e f7527a;

        c(j.e eVar) {
            this.f7527a = eVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f7527a.a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            if (response.code() != 200) {
                this.f7527a.b(response.code());
                return;
            }
            this.f7527a.c(y.h(response.body().bytes()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j.e f7528a;

        d(j.e eVar) {
            this.f7528a = eVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f7528a.a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            if (!response.isSuccessful()) {
                this.f7528a.b(response.code());
                return;
            }
            this.f7528a.c(y.h(response.body().bytes()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e implements Serializable {
        public int code;

        e() {
        }
    }

    /* loaded from: classes.dex */
    public static class f implements Serializable {
        public long box_id;
        public String content;
        public int duration;
        public int fid;
        public long filesize;
        public String host;
        public String name;
        public String pmd5;

        public f(k kVar) {
            this.fid = kVar.fid;
            this.box_id = kVar.boxId;
            this.name = kVar.title;
            this.content = kVar.content;
            this.host = kVar.host;
            i iVar = kVar.audio;
            this.pmd5 = iVar.md5;
            this.duration = kVar.duration;
            this.filesize = iVar.size;
        }
    }

    /* loaded from: classes.dex */
    public static class g implements Serializable {
        public int code;
        public String data;
        public String err;
    }

    /* loaded from: classes.dex */
    public static class h implements Serializable {
        public long box_id;
        public String content;
        public int duration;
        public int fid;
        public long filesize;
        public String host;
        public String name;
        public int ph;
        public String pmd5;
        public int pw;
        public int vh;
        public String vmd5;
        public int vw;

        public h(k kVar) {
            this.fid = kVar.fid;
            this.box_id = kVar.boxId;
            this.name = kVar.title;
            this.content = kVar.content;
            this.host = kVar.host;
            this.vmd5 = kVar.vMd5;
            this.pmd5 = kVar.pMd5;
            this.pw = kVar.thumbWidth;
            this.ph = kVar.thumbHeight;
            this.vw = kVar.width;
            this.vh = kVar.height;
            this.filesize = kVar.zip.size;
            this.duration = kVar.duration;
        }
    }

    /* loaded from: classes.dex */
    public static class i implements Serializable {
        public String encryptedMd5;
        public String encryptedPath;
        public String md5;
        public long offset;
        public String path;
        public long size = 0;
        public long encryptedSize = 0;
        public int status = 0;
        public boolean canceled = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class j implements Serializable {
        public String password;
        public String username;
        public String version;
        public String device = Settings.Secure.getString(g4.i.j().getContentResolver(), "android_id");
        public String os = g4.i.m();

        /* renamed from: t  reason: collision with root package name */
        public int f7529t = 1;
    }

    /* loaded from: classes.dex */
    public static class k implements Serializable {
        public String ID;
        i audio;
        public long boxId;
        public String content;
        public boolean deleted;
        public String err;
        public int fid;
        public String host;
        public String pMd5;
        public String thumbPath;
        public String title;
        public String vMd5;
        public String videoPath;
        public long videoSize;
        public i zip;
        public int thumbHeight = 0;
        public int thumbWidth = 0;
        public int duration = 0;
        public int height = 0;
        public int width = 0;
        public int status = 0;

        public boolean isShortVideo() {
            return this.fid == 1000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class l implements Serializable {
        public int code;
        public m data;

        l() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class m implements Serializable {
        public long offset;

        m() {
        }
    }

    /* loaded from: classes.dex */
    public static class n implements Serializable {
        static final int AUDIO = 7;
        static final int LONG_VIDEO = 5;
        static final int NOVEL = 3;
        static final int PHOTO = 1;
        static final int PHOTO_SET = 6;
        static final int SHORT_VIDEO = 2;
        public String host;

        /* renamed from: t  reason: collision with root package name */
        public int f7530t;
    }

    /* loaded from: classes.dex */
    static class o implements Serializable {
        public int code;
        public p data;
        public String err;

        o() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class p implements Serializable {
        public com.secret.prettyhezi.Upload.q[] gns;
        public n[] hosts;
        public com.secret.prettyhezi.Upload.q[] mns;
        public com.secret.prettyhezi.Upload.q[] rns;
        public r user;

        p() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class q extends Thread {
        q() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            k kVar;
            String str;
            super.run();
            y.f7522g = true;
            k kVar2 = y.f7517b;
            if (kVar2 == null) {
                y.f7522g = false;
                return;
            }
            i iVar = kVar2.zip;
            if (iVar != null && iVar.size == 0) {
                kVar2.status = 1;
                String str2 = kVar2.pMd5;
                if (str2 == null || str2.isEmpty()) {
                    k kVar3 = y.f7517b;
                    kVar3.pMd5 = g4.i.H(kVar3.thumbPath);
                    if (!y.f()) {
                        y.f7522g = false;
                        return;
                    }
                }
                String str3 = y.f7517b.vMd5;
                if (str3 == null || str3.isEmpty()) {
                    k kVar4 = y.f7517b;
                    kVar4.vMd5 = g4.i.H(kVar4.videoPath);
                    if (!y.f()) {
                        y.f7522g = false;
                        return;
                    }
                }
                if (y.f7517b.zip.size == 0) {
                    String str4 = y.f7520e + File.separator + "video_thumb.zip";
                    File file = new File(str4);
                    if (file.exists()) {
                        file.delete();
                    }
                    g4.j jVar = new g4.j(str4);
                    jVar.a("thumb", y.f7517b.thumbPath);
                    jVar.a("video", y.f7517b.videoPath);
                    jVar.b();
                    if (!jVar.f10516b) {
                        kVar = y.f7517b;
                        str = "Zip出错";
                        kVar.err = str;
                        y.y();
                        return;
                    }
                    File file2 = new File(str4);
                    i iVar2 = y.f7517b.zip;
                    iVar2.path = str4;
                    iVar2.size = file2.length();
                    if (!y.f()) {
                        y.f7522g = false;
                        return;
                    }
                }
            }
            k kVar5 = y.f7517b;
            i[] iVarArr = {kVar5.zip, kVar5.audio};
            if (kVar5.ID == null) {
                kVar5.status = 1;
                int i6 = 0;
                while (true) {
                    if (i6 >= 2) {
                        k kVar6 = y.f7517b;
                        if (kVar6.host == null) {
                            kVar6.host = y.m(kVar6);
                            if (!y.f()) {
                                y.f7522g = false;
                                return;
                            }
                        }
                        String g6 = y.g(y.f7517b);
                        if (g6 != null) {
                            g gVar = (g) com.secret.prettyhezi.f.d(g6, g.class);
                            if (gVar.code == 200) {
                                y.f7517b.ID = gVar.data;
                                if (!y.f()) {
                                    y.f7522g = false;
                                    return;
                                } else if (y.f7517b.status == 304) {
                                    y.f7522g = false;
                                    return;
                                }
                            } else {
                                kVar = y.f7517b;
                                str = gVar.err;
                            }
                        } else {
                            y.f7517b.status = 304;
                        }
                    } else {
                        i iVar3 = iVarArr[i6];
                        if (iVar3 != null) {
                            if (iVar3 != y.f7517b.zip && iVar3.md5 == null) {
                                iVar3.md5 = g4.i.H(iVar3.path);
                                if (!y.f()) {
                                    y.f7522g = false;
                                    return;
                                }
                            }
                            String str5 = iVar3.encryptedPath;
                            if (str5 == null || str5.isEmpty()) {
                                iVar3.encryptedPath = y.f7520e + File.separator + "encrypted_" + i6 + System.currentTimeMillis();
                            }
                            if (iVar3.encryptedSize == 0) {
                                String k6 = y.k(iVar3.path, iVar3.encryptedPath);
                                if (k6 != null) {
                                    y.f7517b.err = k6;
                                    break;
                                }
                                iVar3.encryptedSize = new File(iVar3.encryptedPath).length();
                                if (!y.f()) {
                                    y.f7522g = false;
                                    return;
                                }
                            }
                            if (iVar3.encryptedMd5 == null) {
                                iVar3.encryptedMd5 = g4.i.H(iVar3.encryptedPath);
                                if (!y.f()) {
                                    y.f7522g = false;
                                    return;
                                }
                            } else {
                                continue;
                            }
                        }
                        i6++;
                    }
                }
                y.y();
                return;
            }
            k kVar7 = y.f7517b;
            kVar7.status = 206;
            String str6 = kVar7.host;
            i iVar4 = kVar7.audio;
            if (iVar4 == null) {
                iVar4 = kVar7.zip;
            }
            int i7 = iVar4.status;
            if (i7 != 208 && i7 != 210) {
                String format = String.format("%s/upload?id=%s", str6, kVar7.ID);
                String format2 = String.format("%s/check?id=%s&md5=%s&size=%d", str6, y.f7517b.ID, iVar4.encryptedMd5, Long.valueOf(iVar4.encryptedSize));
                if (iVar4.status == 0) {
                    iVar4.status = 206;
                }
                i7 = y.D(y.f7517b, iVar4, format, format2);
            }
            if (!y.f()) {
                y.f7522g = false;
                return;
            }
            if (i7 == 208 || i7 == 405) {
                y.i();
            } else {
                y.f7517b.status = i7;
            }
            y.f7522g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class r implements Serializable {
        public int amount;
        public String token;

        public r(String str, int i6) {
            this.token = str;
            this.amount = i6;
        }
    }

    static {
        File file = new File(f7519d);
        if (!file.exists()) {
            file.mkdir();
        }
        f7521f = false;
        f7522g = false;
        f7523h = null;
        f7524i = null;
        f7525j = com.secret.prettyhezi.j.k(3000, 20000);
        f7526k = 128;
    }

    public static void A(a0 a0Var) {
        if (a0Var.upload) {
            z(a0Var.amount, a0Var.token.token, a0Var.rns, a0Var.gns, a0Var.mns, a0Var.hosts);
        }
    }

    public static void B() {
        if (MainApplication.f6711r.r() == null) {
            if (f7518c != null) {
                t();
                return;
            }
            return;
        }
        f7520e = f7519d + File.separator + MainApplication.f();
        File file = new File(f7520e);
        if (!file.exists()) {
            file.mkdir();
        }
        r();
        if (f7517b != null) {
            if (f7523h == null) {
                d();
            } else {
                C();
            }
        }
    }

    static void C() {
        new q().start();
    }

    static int D(k kVar, i iVar, String str, String str2) {
        int i6;
        int i7;
        int i8;
        if (f()) {
            byte[] bArr = new byte[1024000];
            int i9 = 0;
            int i10 = 0;
            while (iVar.status == 206 && i10 < 3) {
                kVar.status = 206;
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(iVar.encryptedPath, "r");
                    while (true) {
                        randomAccessFile.seek(iVar.offset);
                        long j6 = 1024000;
                        long j7 = iVar.offset;
                        long j8 = j6 + j7;
                        i6 = i10;
                        try {
                            long j9 = iVar.encryptedSize;
                            i7 = j8 >= j9 ? (int) (j9 - j7) : 1024000;
                            int i11 = 0;
                            while (true) {
                                if (i11 < i7) {
                                    int read = randomAccessFile.read(bArr, i11, i7 - i11);
                                    if (read <= 0) {
                                        randomAccessFile.close();
                                        i8 = 305;
                                        break;
                                    }
                                    i11 += read;
                                } else {
                                    i8 = i9;
                                    break;
                                }
                            }
                        } catch (Exception e6) {
                            e = e6;
                        }
                        try {
                            i9 = u(str, iVar.offset, i7, bArr, iVar);
                            if (i9 == 200 || i9 == 405 || i9 != 206) {
                                break;
                            }
                            if (f7521f) {
                                randomAccessFile.close();
                            }
                            if (!f()) {
                                return 206;
                            }
                            i10 = i6;
                        } catch (Exception e7) {
                            e = e7;
                            i9 = i8;
                            e.printStackTrace();
                            i10 = i6 + 1;
                        }
                    }
                } catch (Exception e8) {
                    e = e8;
                    i6 = i10;
                }
            }
            if (i9 == 200) {
                String p5 = p(str2);
                iVar.status = p5 != null ? ((e) com.secret.prettyhezi.f.d(p5, e.class)).code == 200 ? 208 : 210 : 304;
            }
            return iVar.status;
        }
        return 206;
    }

    public static void a(k kVar) {
        if (kVar.audio == null && !kVar.isShortVideo()) {
            r rVar = f7523h.user;
            rVar.amount--;
        }
        if (f7517b == null) {
            f7517b = kVar;
            kVar.status = 0;
            f7521f = false;
            x();
            if (f7518c != null) {
                C();
            }
        }
    }

    public static String b() {
        return f7520e;
    }

    public static void c() {
        k kVar = f7517b;
        if (kVar == null || kVar.deleted) {
            return;
        }
        kVar.deleted = true;
        f7521f = true;
        if (f7522g) {
            x();
        } else {
            i();
        }
    }

    static void d() {
        if (f7523h != null) {
            return;
        }
        f7524i = null;
        a0 r5 = MainApplication.f6711r.r();
        if (r5 != null) {
            A(r5);
            if (f7523h != null) {
                if (f7517b != null) {
                    C();
                    return;
                }
                return;
            }
        }
        j jVar = new j();
        jVar.username = g4.g.a().e();
        jVar.password = g4.g.a().f();
        v(com.secret.prettyhezi.Server.v.f7132a + "api/auth/sign_in/json", com.secret.prettyhezi.f.e(jVar), false, new b());
    }

    public static boolean e() {
        return f7517b != null;
    }

    static boolean f() {
        if (!f7521f) {
            x();
            return true;
        }
        k kVar = f7517b;
        if (kVar != null) {
            if (kVar.deleted) {
                i();
                return false;
            }
            x();
            return false;
        }
        return false;
    }

    static String g(k kVar) {
        Object hVar;
        StringBuilder sb;
        String str = kVar.audio != null ? "api/audio/new/json" : kVar.isShortVideo() ? "api/video/new/json" : "api/rrvideo/new/json";
        if (kVar.audio != null) {
            hVar = new f(f7517b);
            sb = new StringBuilder();
        } else {
            hVar = new h(f7517b);
            sb = new StringBuilder();
        }
        sb.append(com.secret.prettyhezi.Server.v.f7132a);
        sb.append(str);
        return w(sb.toString(), com.secret.prettyhezi.f.e(hVar));
    }

    public static String h(byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(o().getBytes("US-ASCII"), "AES");
            Cipher cipher = Cipher.getInstance(l());
            cipher.init(2, secretKeySpec, new GCMParameterSpec(f7526k, n().getBytes("US-ASCII")));
            return new String(cipher.doFinal(bArr), "UTF-8");
        } catch (Exception unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    static void i() {
        String str;
        k kVar = f7517b;
        if (kVar.deleted && (str = kVar.ID) != null && str.length() > 0) {
            k kVar2 = f7517b;
            String str2 = kVar2.audio != null ? "api/audio/destory/json?id=" : kVar2.isShortVideo() ? "api/video/destory/json?id=" : "api/rrvideo/destory/json?id=";
            q(com.secret.prettyhezi.Server.v.f7132a + str2 + f7517b.ID, new a());
        }
        g4.c.a(f7520e, false);
        f7517b = null;
    }

    public static byte[] j(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(o().getBytes("US-ASCII"), "AES");
            Cipher cipher = Cipher.getInstance(l());
            cipher.init(1, secretKeySpec, new GCMParameterSpec(f7526k, n().getBytes("US-ASCII")));
            return cipher.doFinal(str.getBytes("UTF-8"));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String k(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return "文件不存在";
        }
        File file2 = new File(str2);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(o().getBytes("US-ASCII"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(o().getBytes("US-ASCII"), 0, 16));
            CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
            byte[] bArr = new byte[_BufferKt.SEGMENTING_THRESHOLD];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    cipherOutputStream.close();
                    fileOutputStream.close();
                    fileInputStream.close();
                    return null;
                }
                cipherOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            return e6.getMessage();
        }
    }

    public static String l() {
        return abc.c(11);
    }

    public static String m(k kVar) {
        n[] nVarArr;
        int i6 = kVar.audio != null ? 7 : kVar.isShortVideo() ? 2 : 5;
        p pVar = f7523h;
        if (pVar != null) {
            for (n nVar : pVar.hosts) {
                if (nVar.f7530t == i6) {
                    return nVar.host;
                }
            }
            return null;
        }
        return null;
    }

    public static String n() {
        return abc.c(10);
    }

    public static String o() {
        return abc.c(4);
    }

    static String p(String str) {
        Request.Builder cacheControl = new Request.Builder().url(str).cacheControl(CacheControl.FORCE_NETWORK);
        String str2 = f7518c;
        if (str2 != null && str2.length() > 0) {
            cacheControl = cacheControl.addHeader("Authorization", "Bearer " + f7518c);
        }
        try {
            Response execute = f7525j.newCall(cacheControl.build()).execute();
            String string = execute.body().string();
            execute.close();
            return string;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void q(String str, j.e eVar) {
        Request.Builder cacheControl = new Request.Builder().url(str).cacheControl(CacheControl.FORCE_NETWORK);
        String str2 = f7518c;
        if (str2 != null && str2.length() > 0) {
            cacheControl = cacheControl.addHeader("Authorization", "Bearer " + f7518c);
        }
        f7525j.newCall(cacheControl.build()).enqueue(new d(eVar));
    }

    static void r() {
        try {
            String g6 = g4.c.g(b() + File.separator + f7516a);
            if (g6 != null && g6.length() > 0) {
                k kVar = (k) com.secret.prettyhezi.f.d(com.secret.prettyhezi.Server.e.a(g6), k.class);
                f7517b = kVar;
                if (kVar.zip == null && kVar.audio == null) {
                    i();
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        k kVar2 = f7517b;
        if (kVar2 == null || !kVar2.deleted) {
            return;
        }
        i();
    }

    public static void s() {
        if (f7523h == null) {
            d();
        }
    }

    public static void t() {
        if (f7517b != null) {
            f7517b = null;
            f7521f = true;
        }
        f7520e = null;
        f7518c = null;
        f7523h = null;
    }

    static int u(String str, long j6, int i6, byte[] bArr, i iVar) {
        Request.Builder addHeader = new Request.Builder().url(str).cacheControl(CacheControl.FORCE_NETWORK).post(RequestBody.create(com.secret.prettyhezi.j.f8525d, bArr, 0, i6)).addHeader("Content-Type", "application/json");
        Request.Builder addHeader2 = addHeader.addHeader("Authorization", "Bearer " + f7518c);
        Request.Builder addHeader3 = addHeader2.addHeader("offset", HttpUrl.FRAGMENT_ENCODE_SET + j6);
        try {
            Response execute = f7525j.newCall(addHeader3.addHeader("chunksize", HttpUrl.FRAGMENT_ENCODE_SET + i6).build()).execute();
            if (execute.code() != 200) {
                execute.close();
                return 300;
            }
            l lVar = (l) com.secret.prettyhezi.f.d(execute.body().string(), l.class);
            int i7 = lVar.code;
            if (i7 != 200 && i7 != 405) {
                if (i7 == 206) {
                    iVar.offset = lVar.data.offset;
                    execute.close();
                    return 206;
                }
                return 300;
            }
            iVar.status = i7;
            iVar.offset = iVar.encryptedSize;
            execute.close();
            return lVar.code;
        } catch (Exception unused) {
            return 304;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void v(String str, String str2, boolean z5, j.e eVar) {
        String str3;
        Request.Builder post = new Request.Builder().url(str).cacheControl(CacheControl.FORCE_NETWORK).post(RequestBody.create(com.secret.prettyhezi.j.f8525d, j(str2)));
        if (z5 && (str3 = f7518c) != null && str3.length() > 0) {
            post = post.addHeader("Authorization", "Bearer " + f7518c);
        }
        f7525j.newCall(post.build()).enqueue(new c(eVar));
    }

    public static String w(String str, String str2) {
        Request.Builder post = new Request.Builder().url(str).cacheControl(CacheControl.FORCE_NETWORK).post(RequestBody.create(com.secret.prettyhezi.j.f8525d, j(str2)));
        String str3 = f7518c;
        if (str3 != null && str3.length() > 0) {
            post = post.addHeader("Authorization", "Bearer " + f7518c);
        }
        try {
            Response execute = f7525j.newCall(post.build()).execute();
            if (execute.code() != 200) {
                execute.close();
                return null;
            }
            String h6 = h(execute.body().bytes());
            execute.close();
            return h6;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    static void x() {
        k kVar = f7517b;
        if (kVar != null) {
            try {
                String d6 = com.secret.prettyhezi.Server.e.d(com.secret.prettyhezi.f.e(kVar));
                g4.c.k(b() + File.separator + f7516a, d6);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    static void y() {
        f7522g = false;
        x();
    }

    public static void z(int i6, String str, com.secret.prettyhezi.Upload.q[] qVarArr, com.secret.prettyhezi.Upload.q[] qVarArr2, com.secret.prettyhezi.Upload.q[] qVarArr3, n[] nVarArr) {
        if (f7523h != null) {
            Log.e("setupSignInInfo", "user already exist!");
        }
        p pVar = new p();
        f7523h = pVar;
        pVar.hosts = nVarArr;
        pVar.rns = qVarArr;
        pVar.gns = qVarArr2;
        pVar.mns = qVarArr3;
        pVar.user = new r(str, i6);
        f7518c = str;
    }
}
