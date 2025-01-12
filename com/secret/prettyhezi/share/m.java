package com.secret.prettyhezi.share;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.a0;
import java.io.File;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public static String f9048a;

    /* renamed from: b  reason: collision with root package name */
    public static String f9049b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends com.secret.prettyhezi.controls.h {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f9050g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f9051h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, int i6, String str2) {
            super(str);
            this.f9050g = i6;
            this.f9051h = str2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                bitmap.recycle();
                g4.g.a().o(this.f9050g == 1 ? "keyPMasker" : "keyVMasker", this.f9051h);
                g4.c.b(g4.b.g().d(this.f9051h), this.f9050g == 1 ? m.f9048a : m.f9049b);
            }
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(g4.i.j().getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("photoMask.png");
        f9048a = sb.toString();
        f9049b = g4.i.j().getFilesDir().getAbsolutePath() + str + "videoMask.png";
    }

    public static void a() {
        String h6 = g4.g.a().h("keyPMasker", HttpUrl.FRAGMENT_ENCODE_SET);
        String h7 = g4.g.a().h("keyVMasker", HttpUrl.FRAGMENT_ENCODE_SET);
        a0 r5 = MainApplication.f6711r.r();
        if (r5 != null) {
            if (!r5.photomask.equals(h6)) {
                b(1);
            }
            if (r5.videomask.equals(h7)) {
                return;
            }
            b(2);
        }
    }

    public static void b(int i6) {
        a0 r5 = MainApplication.f6711r.r();
        String str = i6 == 1 ? r5.photomask : r5.videomask;
        new a(com.secret.prettyhezi.controls.h.f8343e.d(str), i6, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str);
    }
}
