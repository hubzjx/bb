package com.secret.prettyhezi.Cache;

import com.secret.prettyhezi.Server.d0;
import com.secret.prettyhezi.Server.e0;
import com.secret.prettyhezi.Server.l;
import com.secret.prettyhezi.Server.m;
import com.secret.prettyhezi.ZZcINlcxH;
import g4.i;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    static c f6022g;

    /* renamed from: a  reason: collision with root package name */
    String f6023a;

    /* renamed from: b  reason: collision with root package name */
    int[] f6024b = {2, 4, 5};

    /* renamed from: c  reason: collision with root package name */
    public Object f6025c = new Object();

    /* renamed from: d  reason: collision with root package name */
    ArrayList[][] f6026d = (ArrayList[][]) Array.newInstance(ArrayList.class, 8, 2);

    /* renamed from: e  reason: collision with root package name */
    volatile g f6027e = null;

    /* renamed from: f  reason: collision with root package name */
    boolean f6028f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            c cVar = c.this;
            cVar.f6027e = cVar.n();
            while (c.this.f6027e != null) {
                c cVar2 = c.this;
                if (cVar2.f6028f) {
                    return;
                }
                cVar2.f6027e.stop = false;
                c.this.f6027e.DoDownload();
                if (c.this.f6027e.status == 2) {
                    c cVar3 = c.this;
                    cVar3.g(cVar3.f6027e);
                } else {
                    c cVar4 = c.this;
                    cVar4.i(cVar4.f6027e.navMode, false);
                }
                c cVar5 = c.this;
                cVar5.f6027e = cVar5.n();
                if (c.this.f6027e != null && c.this.f6027e.IsRetry() && !c.this.f6028f) {
                    try {
                        Thread.sleep(5000L);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public c() {
        f6022g = this;
        this.f6023a = "VideoDownload";
        this.f6023a = i.j().getFilesDir().getAbsolutePath() + File.separator + this.f6023a;
        File file = new File(this.f6023a);
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    private g k(e eVar) {
        g gVar = new g();
        gVar.navMode = eVar.navMode == 3 ? 4 : 5;
        gVar.id = eVar.id;
        l lVar = new l();
        gVar.co = lVar;
        lVar.f7129w = eVar.width;
        lVar.f7127h = eVar.height;
        lVar.f7128p = eVar.img;
        e0 e0Var = new e0();
        gVar.f6040me = e0Var;
        e0Var.f7129w = eVar.videoWidth();
        gVar.f6040me.f7127h = eVar.videoHeight();
        e0 e0Var2 = gVar.f6040me;
        String str = eVar.playUrl;
        e0Var2.f7128p = str;
        e0Var2.f7111d = eVar.m3u8Url;
        gVar.dur = eVar.duration;
        gVar.status = eVar.states;
        gVar.fileSize = eVar.fileSize;
        gVar.downloadPos = eVar.downloadPos;
        gVar.tsFiles = eVar.tsFiles;
        gVar.totalFiles = eVar.totalFiles;
        if (str.endsWith(".mp4")) {
            gVar.mp4File = eVar.m3u8File;
        } else {
            gVar.m3u8File = eVar.m3u8File;
            gVar.m3u8Folder = eVar.folder;
        }
        gVar.stop = false;
        return gVar;
    }

    private g l(h hVar) {
        m mVar = hVar.video;
        g gVar = new g();
        gVar.navMode = 2;
        gVar.id = mVar.id;
        l lVar = new l();
        gVar.co = lVar;
        lVar.f7129w = mVar.thumbWidth();
        gVar.co.f7127h = mVar.thumbHeight();
        gVar.co.f7128p = mVar.img;
        e0 e0Var = new e0();
        gVar.f6040me = e0Var;
        e0Var.f7129w = mVar.videoWidth();
        gVar.f6040me.f7127h = mVar.videoHeight();
        e0 e0Var2 = gVar.f6040me;
        e0Var2.f7128p = mVar.vod;
        e0Var2.f7111d = mVar.download;
        gVar.dur = mVar.duration;
        gVar.status = hVar.states;
        gVar.fileSize = hVar.fileSize;
        gVar.downloadPos = hVar.downloadPos;
        gVar.mp4File = hVar.downloadFile;
        gVar.stop = false;
        return gVar;
    }

    public static c p() {
        return f6022g;
    }

    private ArrayList r(String str) {
        try {
            return new ArrayList(Arrays.asList((g[]) com.secret.prettyhezi.f.b(g4.c.g(this.f6023a + File.separator + str), g[].class)));
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    private void s(String str, ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        try {
            g4.c.k(this.f6023a + File.separator + str, com.secret.prettyhezi.f.e(arrayList.toArray()));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(int i6, d0 d0Var, String str) {
        g gVar = new g(i6, d0Var);
        synchronized (this.f6025c) {
            ArrayList q5 = q(i6, true);
            gVar.status = 2;
            gVar.fileSize = f4.b.e(str, gVar.mp4File);
            q5.add(0, gVar);
            s(o(i6, true), q5);
        }
    }

    public void b(int i6, d0 d0Var) {
        g gVar = new g(i6, d0Var);
        synchronized (this.f6025c) {
            ArrayList q5 = q(i6, false);
            q5.add(0, gVar);
            s(o(i6, false), q5);
        }
        t();
    }

    public boolean c(ZZcINlcxH zZcINlcxH) {
        boolean z5;
        synchronized (this.f6025c) {
            int i6 = 0;
            for (int i7 : this.f6024b) {
                i6 += q(i7, false).size();
            }
            z5 = i6 < 10;
        }
        if (!z5) {
            zZcINlcxH.q("最多允许同时下载10个视频，请等待其它的先下载完");
        }
        return z5;
    }

    public ArrayList d(int i6, boolean z5) {
        ArrayList arrayList;
        synchronized (this.f6025c) {
            arrayList = (ArrayList) q(i6, z5).clone();
        }
        return arrayList;
    }

    public g e(int i6, boolean z5, int i7) {
        synchronized (this.f6025c) {
            ArrayList q5 = q(i6, z5);
            for (int i8 = 0; i8 < q5.size(); i8++) {
                g gVar = (g) q5.get(i8);
                if (gVar.id == i7) {
                    return gVar;
                }
            }
            return null;
        }
    }

    public String f() {
        return this.f6023a;
    }

    public void g(g gVar) {
        synchronized (this.f6025c) {
            int i6 = gVar.navMode;
            ArrayList q5 = q(i6, false);
            ArrayList q6 = q(i6, true);
            q5.remove(gVar);
            q6.add(0, gVar);
            s(o(i6, false), q5);
            s(o(i6, true), q6);
        }
    }

    public void h(g gVar, boolean z5) {
        synchronized (this.f6025c) {
            int i6 = gVar.navMode;
            ArrayList q5 = q(i6, z5);
            q5.remove(gVar);
            s(o(i6, z5), q5);
        }
        gVar.OnDelete();
    }

    public void i(int i6, boolean z5) {
        synchronized (this.f6025c) {
            s(o(i6, z5), q(i6, z5));
        }
    }

    public void j() {
        d dVar = new d();
        if (dVar.f6036f.size() > 0) {
            ArrayList q5 = q(2, false);
            for (int i6 = 0; i6 < dVar.f6036f.size(); i6++) {
                q5.add(l((h) dVar.f6036f.get(i6)));
            }
            s(o(2, false), q5);
        }
        if (dVar.f6037g.size() > 0) {
            ArrayList q6 = q(2, true);
            for (int i7 = 0; i7 < dVar.f6037g.size(); i7++) {
                q6.add(l((h) dVar.f6037g.get(i7)));
            }
            s(o(2, true), q6);
        }
        if (dVar.f6038h.size() > 0) {
            ArrayList q7 = q(4, false);
            ArrayList q8 = q(5, false);
            for (int i8 = 0; i8 < dVar.f6038h.size(); i8++) {
                g k6 = k((e) dVar.f6038h.get(i8));
                if (k6.navMode == 4) {
                    q7.add(k6);
                } else {
                    q8.add(k6);
                }
            }
            s(o(4, false), q7);
            s(o(5, false), q8);
        }
        if (dVar.f6039i.size() > 0) {
            ArrayList q9 = q(4, true);
            ArrayList q10 = q(5, true);
            for (int i9 = 0; i9 < dVar.f6039i.size(); i9++) {
                g k7 = k((e) dVar.f6039i.get(i9));
                if (k7.navMode == 4) {
                    q9.add(k7);
                } else {
                    q10.add(k7);
                }
            }
            s(o(4, true), q9);
            s(o(5, true), q10);
        }
    }

    g m(int i6, int i7) {
        Iterator it = q(i6, false).iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (gVar.status == i7) {
                return gVar;
            }
        }
        return null;
    }

    g n() {
        synchronized (this.f6025c) {
            int[] iArr = {1, 0, 3, 4};
            for (int i6 = 0; i6 < 4; i6++) {
                int i7 = iArr[i6];
                for (int i8 : this.f6024b) {
                    g m5 = m(i8, i7);
                    if (m5 != null) {
                        return m5;
                    }
                }
            }
            return null;
        }
    }

    String o(int i6, boolean z5) {
        String str = i6 == 2 ? "videos" : i6 == 4 ? "films" : i6 == 5 ? "longVideos" : "unknown";
        if (z5) {
            return str + "_completed";
        }
        return str;
    }

    ArrayList q(int i6, boolean z5) {
        ArrayList arrayList = this.f6026d[i6][z5 ? 1 : 0];
        if (arrayList == null) {
            ArrayList r5 = r(o(i6, z5));
            this.f6026d[i6][z5 ? 1 : 0] = r5;
            return r5;
        }
        return arrayList;
    }

    public void t() {
        this.f6028f = false;
        if (this.f6027e == null) {
            new a().start();
        }
    }

    public void u() {
        if (this.f6027e != null) {
            this.f6027e.stop = true;
        }
        this.f6028f = true;
    }
}
