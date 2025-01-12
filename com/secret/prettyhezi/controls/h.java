package com.secret.prettyhezi.controls;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.MainApplication;
/* loaded from: classes.dex */
public abstract class h extends AsyncTask {

    /* renamed from: e  reason: collision with root package name */
    public static g4.b f8343e = g4.b.g();

    /* renamed from: f  reason: collision with root package name */
    public static StringBuilder f8344f = new StringBuilder("DownloadImageTask \r\n");

    /* renamed from: a  reason: collision with root package name */
    protected String f8345a;

    /* renamed from: b  reason: collision with root package name */
    protected String f8346b;

    /* renamed from: c  reason: collision with root package name */
    protected String f8347c;

    /* renamed from: d  reason: collision with root package name */
    b f8348d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8349a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f8350b;

        a(int i6, String str) {
            this.f8349a = i6;
            this.f8350b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i6 = this.f8349a;
            if (i6 != 404) {
                MainApplication.f6711r.v(i6, h.this.f8346b);
            }
            h hVar = h.this;
            b bVar = hVar.f8348d;
            if (bVar != null) {
                bVar.a(this.f8349a, hVar.f8346b, hVar.f8347c, this.f8350b);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i6, String str, String str2, String str3);
    }

    public h(String str) {
        this.f8345a = str;
    }

    public void a(b bVar) {
        this.f8348d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        this.f8346b = str;
        if (str.indexOf("static.allsexbox.com/images/absolute.png") >= 0 || str.indexOf("/static/img/absolute.png") >= 0) {
            return BitmapFactory.decodeResource(g4.i.j().getResources(), C0382R.drawable.absolute);
        }
        String str2 = this.f8345a;
        Bitmap decodeFile = str2 != null ? BitmapFactory.decodeFile(str2) : (str.startsWith(Environment.getExternalStorageDirectory().getPath()) || (str.startsWith("/") && str.startsWith(g4.i.j().getFilesDir().getAbsolutePath()))) ? BitmapFactory.decodeFile(str) : null;
        if (decodeFile != null) {
            return decodeFile;
        }
        this.f8347c = MainApplication.f6711r.s(str);
        String n5 = g4.c.n();
        int e6 = com.secret.prettyhezi.j.e(this.f8347c, n5);
        if (e6 != 200) {
            c(e6);
            return null;
        }
        if (str.endsWith(".pd")) {
            g4.i.R(n5);
        }
        if (isCancelled()) {
            f8343e.a(this.f8346b, n5, true);
            return null;
        }
        Bitmap decodeFile2 = BitmapFactory.decodeFile(n5);
        if (decodeFile2 != null) {
            f8343e.a(this.f8346b, n5, true);
        }
        return decodeFile2;
    }

    void c(int i6) {
        if (isCancelled()) {
            return;
        }
        String J = this.f8348d != null ? g4.i.J(this.f8347c) : null;
        if (g4.i.j() != null) {
            g4.i.j().runOnUiThread(new a(i6, J));
        }
    }
}
