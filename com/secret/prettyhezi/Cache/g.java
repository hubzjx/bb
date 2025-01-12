package com.secret.prettyhezi.Cache;

import android.net.Uri;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.d0;
import com.secret.prettyhezi.Server.e0;
import com.secret.prettyhezi.Server.l;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import q2.o;
import r2.b;
import r2.c;
import r2.i;
import r2.s;
/* loaded from: classes.dex */
public class g extends n {
    static OkHttpClient downloadClient;
    public l co;
    public long downloadPos = 0;
    public int dur;
    public long fileSize;
    public String m3u8File;
    public String m3u8Folder;

    /* renamed from: me  reason: collision with root package name */
    public e0 f6040me;
    public String mp4File;
    public int navMode;
    public int status;
    public boolean stop;
    public int totalFiles;
    public ArrayList<String> tsFiles;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements i {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f6041b;

        a(String str) {
            this.f6041b = str;
        }

        @Override // r2.i
        public String a(o oVar) {
            String str = oVar.f12802i;
            return str != null ? str : this.f6041b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements i {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f6043b;

        b(String str) {
            this.f6043b = str;
        }

        private String b(Uri uri) {
            String uri2 = uri.toString();
            return this.f6043b + uri2.substring(uri2.lastIndexOf(47));
        }

        @Override // r2.i
        public String a(o oVar) {
            String str = oVar.f12802i;
            return str != null ? str : b(oVar.f12794a);
        }
    }

    public g() {
    }

    public static OkHttpClient DownloadClient() {
        if (downloadClient == null) {
            downloadClient = j.l(2000, 5000, true);
        }
        return downloadClient;
    }

    public void DoDownload() {
        if (isMp4()) {
            doDownloadMp4();
        } else {
            doDownloadM3U8();
        }
    }

    public String GetDownloadedPath() {
        return isMp4() ? this.mp4File : this.m3u8File;
    }

    public boolean IsRetry() {
        int i6 = this.status;
        return i6 == 4 || i6 == 3;
    }

    public void OnDelete() {
        if (isMp4()) {
            g4.c.c(this.mp4File);
        } else {
            g4.c.a(this.m3u8Folder, true);
        }
    }

    void doDownloadM3U8() {
        String s5 = MainApplication.f6711r.s(this.f6040me.downloadUrl());
        if (s5.indexOf(9) >= 0) {
            s5 = s5.replace("\t", HttpUrl.FRAGMENT_ENCODE_SET);
        }
        this.status = 1;
        ArrayList<String> arrayList = this.tsFiles;
        if (arrayList == null || arrayList.size() == 0) {
            if (!downloadUrlToFile(s5, this.m3u8File)) {
                if (this.stop) {
                    return;
                }
                this.status = 3;
                return;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(this.m3u8File);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                this.tsFiles = new ArrayList<>();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.startsWith("#") && readLine.length() > 0 && readLine.endsWith(".ts")) {
                        this.tsFiles.add(readLine);
                    }
                }
                this.totalFiles = this.tsFiles.size() + 1;
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();
                MainApplication.f6711r.l().i(this.navMode, false);
            } catch (Exception unused) {
                this.status = 3;
                return;
            }
        }
        while (this.tsFiles.size() > 0) {
            String str = this.tsFiles.get(0);
            if (!downloadUrlToFile(s5.substring(0, s5.lastIndexOf("/") + 1) + str, str)) {
                if (this.stop) {
                    return;
                }
                this.status = 3;
                return;
            }
            this.tsFiles.remove(0);
            MainApplication.f6711r.l().i(this.navMode, false);
        }
        this.fileSize = g4.c.d(this.m3u8Folder);
        this.status = 2;
    }

    public void doDownloadMp4() {
        String downloadUrl = this.f6040me.downloadUrl();
        String Q = g4.i.Q(this.f6040me.f7128p);
        String s5 = MainApplication.f6711r.s(downloadUrl);
        s a6 = f4.b.a(MainApplication.f6711r);
        r2.c a7 = new c.C0212c().d(a6).g(new b1.b(DownloadClient(), "ExoplayerDownload")).f(new b.C0211b().c(a6).b(1048576).d(Long.MAX_VALUE)).e(new a(Q)).a();
        this.status = 1;
        RandomAccessFile randomAccessFile = null;
        try {
            Uri parse = Uri.parse(s5);
            long j6 = this.downloadPos;
            long b6 = a7.b(new o(parse, j6 > 0 ? j6 : 0L, j6 > 0 ? this.fileSize - j6 : -1L));
            if (b6 < 0) {
                this.status = 4;
                return;
            }
            if (this.fileSize <= 0) {
                this.fileSize = b6 + this.downloadPos;
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.mp4File, "rwd");
            try {
                long j7 = this.downloadPos;
                if (j7 > 0) {
                    randomAccessFile2.seek(j7);
                }
                byte[] bArr = new byte[20480];
                do {
                    int read = a7.read(bArr, 0, 20480);
                    if (read == -1) {
                        a7.close();
                        randomAccessFile2.close();
                        if (this.downloadPos == this.fileSize) {
                            this.status = 2;
                            return;
                        } else {
                            this.status = 3;
                            return;
                        }
                    }
                    randomAccessFile2.write(bArr, 0, read);
                    this.downloadPos += read;
                    MainApplication.f6711r.l().i(this.navMode, false);
                } while (!this.stop);
                a7.close();
                randomAccessFile2.close();
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = randomAccessFile2;
                this.status = 3;
                e.printStackTrace();
                try {
                    a7.close();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (Exception unused) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    boolean downloadUrlToFile(String str, String str2) {
        s a6 = f4.b.a(MainApplication.f6711r);
        String s5 = MainApplication.f6711r.s(str);
        String str3 = this.f6040me.f7128p;
        r2.c a7 = new c.C0212c().d(a6).g(new b1.b(DownloadClient(), "ExoplayerDownload")).f(new b.C0211b().c(a6).b(1048576).d(Long.MAX_VALUE)).e(new b(g4.i.Q(str3.substring(0, str3.lastIndexOf(47))))).a();
        RandomAccessFile randomAccessFile = null;
        try {
            if (a7.b(new o(Uri.parse(s5))) < 0) {
                return false;
            }
            if (!str2.startsWith(this.m3u8Folder)) {
                str2 = this.m3u8Folder + File.separator + str2;
            }
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            String str4 = str2 + ".tmp";
            File file2 = new File(str4);
            if (file2.exists()) {
                file2.delete();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str4, "rwd");
            try {
                byte[] bArr = new byte[20480];
                do {
                    int read = a7.read(bArr, 0, 20480);
                    if (read == -1) {
                        a7.close();
                        randomAccessFile2.close();
                        g4.c.i(str4, str2);
                        return true;
                    }
                    randomAccessFile2.write(bArr, 0, read);
                } while (!this.stop);
                a7.close();
                randomAccessFile2.close();
                if (file2.exists()) {
                    file2.delete();
                }
                return false;
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = randomAccessFile2;
                try {
                    a7.close();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (Exception unused) {
                    e.printStackTrace();
                }
                return false;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    public boolean isMp4() {
        String str = this.mp4File;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public String percent() {
        if (isMp4()) {
            if (this.downloadPos > 0) {
                return ((this.downloadPos * 100) / this.fileSize) + "%";
            }
            return HttpUrl.FRAGMENT_ENCODE_SET;
        } else if (this.totalFiles > 0) {
            return (((this.totalFiles - this.tsFiles.size()) * 100) / this.totalFiles) + "%";
        } else {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public int percentValue() {
        if (isMp4()) {
            long j6 = this.downloadPos;
            if (j6 > 0) {
                return (int) ((j6 * 100) / this.fileSize);
            }
            return 0;
        }
        int i6 = this.totalFiles;
        if (i6 > 0) {
            return ((i6 - this.tsFiles.size()) * 100) / this.totalFiles;
        }
        return 0;
    }

    public g(int i6, d0 d0Var) {
        this.navMode = i6;
        this.id = d0Var.id;
        this.co = d0Var.co;
        this.dur = d0Var.dur;
        this.status = 0;
        this.stop = false;
        this.fileSize = 0L;
        this.f6040me = (i6 == 2 || i6 == 5) ? d0Var.f7110me : d0Var.vs[0];
        if (this.f6040me.f7128p.endsWith(".mp4")) {
            this.mp4File = c.p().f() + File.separator + this.id + "_video.mp4";
            return;
        }
        String downloadUrl = this.f6040me.downloadUrl();
        String substring = downloadUrl.substring(0, downloadUrl.lastIndexOf("/"));
        this.m3u8Folder = c.p().f() + substring.substring(substring.lastIndexOf("/"));
        new File(this.m3u8Folder).mkdirs();
        this.m3u8File = this.m3u8Folder + downloadUrl.substring(downloadUrl.lastIndexOf("/"));
    }
}
