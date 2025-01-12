package com.secret.prettyhezi.controls;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.LinearLayout;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.h;
import com.secret.prettyhezi.s;
import java.io.Serializable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class r extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public static final Executor f8438e;

    /* renamed from: f  reason: collision with root package name */
    public static final Executor f8439f;

    /* renamed from: g  reason: collision with root package name */
    private static final int f8440g;

    /* renamed from: h  reason: collision with root package name */
    private static final int f8441h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f8442i;

    /* renamed from: j  reason: collision with root package name */
    static long[] f8443j;

    /* renamed from: b  reason: collision with root package name */
    public String f8444b;

    /* renamed from: c  reason: collision with root package name */
    h f8445c;

    /* renamed from: d  reason: collision with root package name */
    h.b f8446d;

    /* loaded from: classes.dex */
    class a implements RejectedExecutionHandler {
        a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Executors.newSingleThreadExecutor().execute(runnable);
        }
    }

    /* loaded from: classes.dex */
    class b implements RejectedExecutionHandler {
        b() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Executors.newSingleThreadExecutor().execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends h {
        c(String str) {
            super(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public void onPostExecute(Bitmap bitmap) {
            if (r.this.f8444b == null || isCancelled()) {
                return;
            }
            r.this.d(bitmap);
        }
    }

    /* loaded from: classes.dex */
    class d extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8448d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f8449e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f8450f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f8451g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f8452h;

        d(int i6, int i7, int i8, String str, String str2) {
            this.f8448d = i6;
            this.f8449e = i7;
            this.f8450f = i8;
            this.f8451g = str;
            this.f8452h = str2;
        }

        @Override // g4.f
        protected void a(View view) {
            r.e(this.f8448d, this.f8449e, this.f8450f, this.f8451g, this.f8452h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8454b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f8455c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(ZZcINlcxH zZcINlcxH, int i6, String str) {
            super(zZcINlcxH);
            this.f8454b = i6;
            this.f8455c = str;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            ZZcINlcxH j6;
            String str2;
            com.secret.prettyhezi.Server.y yVar = (com.secret.prettyhezi.Server.y) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.y.class);
            if (yVar.code != 200) {
                f(yVar.err);
                return;
            }
            if (yVar.data) {
                MainApplication.f6711r.h(this.f8454b, this.f8455c);
                j6 = g4.i.j();
                str2 = "提交成功，已重新选择网络，请试试板块内其他内容";
            } else {
                j6 = g4.i.j();
                str2 = "提交成功";
            }
            j6.z(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f implements Serializable {
        public int code;
        public int id;
        public String ns;

        /* renamed from: t  reason: collision with root package name */
        public int f8456t;
        public String url;

        public f(int i6, int i7, int i8, String str, String str2) {
            this.code = i6;
            this.f8456t = i7;
            this.id = i8;
            this.ns = str2;
            this.url = str;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f8440g = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        f8441h = max;
        int i6 = (availableProcessors * 2) + 1;
        f8442i = i6;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, i6 + 2, 30L, timeUnit, new LinkedBlockingQueue(256));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f8438e = threadPoolExecutor;
        threadPoolExecutor.setRejectedExecutionHandler(new a());
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(max, i6 + 2, 30L, timeUnit, new LinkedBlockingQueue(256));
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        f8439f = threadPoolExecutor2;
        threadPoolExecutor2.setRejectedExecutionHandler(new b());
        f8443j = null;
        f8443j = new long[21];
    }

    public r(Context context, String str) {
        super(context);
        this.f8445c = null;
        this.f8446d = null;
        setOrientation(1);
        setGravity(17);
        if (str == null || str.length() <= 0) {
            return;
        }
        b(str);
    }

    public static boolean c(String str) {
        if ((System.currentTimeMillis() - f8443j[MainApplication.f6711r.o(MainApplication.q(str))]) / 1000 < 3600) {
            g4.i.j().q("一小时内只能提交一次");
            return false;
        }
        return true;
    }

    public static void e(int i6, int i7, int i8, String str, String str2) {
        ZZcINlcxH j6 = g4.i.j();
        if (c(str)) {
            String q5 = MainApplication.q(str);
            int o5 = MainApplication.f6711r.o(q5);
            f8443j[o5] = System.currentTimeMillis();
            if (!j6.L0()) {
                j6.I0();
            }
            com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "user/feedback/json", new f(i6, i7, i8, str, str2), true, new e(j6, o5, q5));
        }
    }

    public void a(h.b bVar) {
        this.f8446d = bVar;
    }

    public void b(String str) {
        String str2 = this.f8444b;
        if (str == str2) {
            return;
        }
        if (str == null || str2 == null || !str.equals(str2)) {
            removeAllViews();
            h hVar = this.f8445c;
            if (hVar != null) {
                hVar.cancel(false);
                this.f8445c = null;
            }
            this.f8444b = str;
            if (str == null || str.length() <= 0) {
                setBackground(null);
                return;
            }
            String d6 = h.f8343e.d(str);
            c cVar = new c(d6);
            this.f8445c = cVar;
            cVar.a(this.f8446d);
            this.f8445c.executeOnExecutor(d6 == null ? f8438e : f8439f, str);
        }
    }

    protected void d(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        String str = this.f8444b;
        if (str == null || str.length() <= 0) {
            bitmap.recycle();
        } else {
            setBackground(new BitmapDrawable(bitmap));
        }
    }

    public void f(int i6, int i7, int i8, String str, String str2) {
        int i9;
        removeAllViews();
        int height = getHeight() - g4.i.r(96.0f);
        if (height > g4.i.r(50.0f)) {
            height = g4.i.r(50.0f);
        } else if (height < 0) {
            i9 = 0;
            View c6 = g4.d.c(getContext(), 12, -65536, "提交反馈", 17);
            c6.setBackground(g4.i.d(g4.i.b(-16777216, 5.0f), g4.i.b(Color.parseColor("#333333"), 5.0f)));
            c6.setOnClickListener(new d(i6, i7, i8, str, str2));
            addView(c6, new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(40.0f)));
            Context context = getContext();
            View c7 = g4.d.c(context, 12, -65536, "图片加载失败:" + i6, 17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = i9;
            addView(c7, layoutParams);
        }
        i9 = height;
        View c62 = g4.d.c(getContext(), 12, -65536, "提交反馈", 17);
        c62.setBackground(g4.i.d(g4.i.b(-16777216, 5.0f), g4.i.b(Color.parseColor("#333333"), 5.0f)));
        c62.setOnClickListener(new d(i6, i7, i8, str, str2));
        addView(c62, new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(40.0f)));
        Context context2 = getContext();
        View c72 = g4.d.c(context2, 12, -65536, "图片加载失败:" + i6, 17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = i9;
        addView(c72, layoutParams2);
    }
}
