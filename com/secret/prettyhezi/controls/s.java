package com.secret.prettyhezi.controls;

import android.content.Context;
import android.graphics.Bitmap;
import com.secret.prettyhezi.controls.h;
/* loaded from: classes.dex */
public abstract class s extends w0.l {

    /* renamed from: f  reason: collision with root package name */
    public String f8457f;

    /* renamed from: g  reason: collision with root package name */
    h f8458g;

    /* renamed from: h  reason: collision with root package name */
    h.b f8459h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends h {
        a(String str) {
            super(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public void onPostExecute(Bitmap bitmap) {
            if (s.this.f8457f == null || isCancelled()) {
                return;
            }
            s.this.f(bitmap);
        }
    }

    public s(Context context, String str) {
        super(context);
        this.f8458g = null;
        this.f8459h = null;
        if (str != null) {
            e(str);
        }
    }

    public void d(h.b bVar) {
        this.f8459h = bVar;
    }

    public void e(String str) {
        String str2 = this.f8457f;
        if (str == str2) {
            return;
        }
        if (str == null || str2 == null || !str.equals(str2)) {
            h hVar = this.f8458g;
            if (hVar != null) {
                hVar.cancel(false);
                this.f8458g = null;
            }
            this.f8457f = str;
            if (str == null || str.length() <= 0) {
                f(null);
                return;
            }
            String d6 = h.f8343e.d(str);
            a aVar = new a(d6);
            this.f8458g = aVar;
            aVar.a(this.f8459h);
            this.f8458g.executeOnExecutor(d6 == null ? r.f8438e : r.f8439f, str);
        }
    }

    protected abstract void f(Bitmap bitmap);
}
