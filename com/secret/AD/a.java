package com.secret.AD;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.Server.g;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.k;
import com.secret.prettyhezi.controls.r;
/* loaded from: classes.dex */
public abstract class a extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    protected ZZcINlcxH f5892b;

    /* renamed from: c  reason: collision with root package name */
    public g.a f5893c;

    /* renamed from: d  reason: collision with root package name */
    boolean f5894d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f5895e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.secret.AD.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0063a extends g4.f {
        C0063a() {
        }

        @Override // g4.f
        public void a(View view) {
            String str;
            g.a aVar = a.this.f5893c;
            if (aVar == null || (str = aVar.url) == null || str.length() <= 0) {
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(a.this.f5893c.url));
                a.this.f5892b.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends d4.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RelativeLayout.LayoutParams f5897b;

        b(RelativeLayout.LayoutParams layoutParams) {
            this.f5897b = layoutParams;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            if (str == null) {
                return;
            }
            a.this.e();
            k kVar = new k(a.this.f5892b);
            kVar.setGifPath(str);
            a.this.addView(kVar, 0, this.f5897b);
            a aVar = a.this;
            if (aVar.f5894d) {
                return;
            }
            aVar.setClickListener(kVar);
        }
    }

    public a(ZZcINlcxH zZcINlcxH) {
        this(zZcINlcxH, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if ((childAt instanceof r) || (childAt instanceof k)) {
                removeViewAt(i6);
                return;
            }
        }
    }

    public abstract RelativeLayout.LayoutParams a();

    public void b() {
        this.f5895e = true;
    }

    public void c(g.a aVar) {
        this.f5893c = aVar;
        String str = aVar.img;
        String lowerCase = str.toLowerCase();
        RelativeLayout.LayoutParams a6 = a();
        if (!lowerCase.endsWith(".png") && !lowerCase.endsWith(".jpg") && !lowerCase.endsWith(".jpeg")) {
            if (lowerCase.toLowerCase().endsWith(".gif")) {
                new b(a6).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str);
                return;
            }
            return;
        }
        e();
        View rVar = new r(this.f5892b, str);
        addView(rVar, 0, a6);
        if (this.f5894d) {
            return;
        }
        setClickListener(rVar);
    }

    void setClickListener(View view) {
        view.setOnClickListener(new C0063a());
    }

    public a(ZZcINlcxH zZcINlcxH, boolean z5) {
        super(zZcINlcxH);
        this.f5893c = null;
        this.f5895e = false;
        this.f5892b = zZcINlcxH;
        this.f5894d = z5;
        if (z5) {
            setClickListener(this);
        }
    }
}
