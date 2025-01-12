package com.secret.prettyhezi.Upload;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.DHwJuV;
import com.secret.prettyhezi.LQS1CVD;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.RcB8ALaRS;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.Upload.y;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.e0;
import com.secret.prettyhezi.s;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import okhttp3.HttpUrl;
import okhttp3.internal.ws.RealWebSocket;
/* loaded from: classes.dex */
public class QwjwwM extends UoWMF {
    static HashMap N = new HashMap();
    EditText A;
    EditText B;
    Bitmap C;
    ImageView D;
    LinearLayout M;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7351r;

    /* renamed from: s  reason: collision with root package name */
    String f7352s;

    /* renamed from: t  reason: collision with root package name */
    int f7353t;

    /* renamed from: w  reason: collision with root package name */
    Spinner f7356w;

    /* renamed from: x  reason: collision with root package name */
    ArrayAdapter f7357x;

    /* renamed from: y  reason: collision with root package name */
    Spinner f7358y;

    /* renamed from: z  reason: collision with root package name */
    EditText f7359z;

    /* renamed from: u  reason: collision with root package name */
    com.secret.prettyhezi.Upload.q[] f7354u = null;

    /* renamed from: v  reason: collision with root package name */
    String[] f7355v = null;
    String E = HttpUrl.FRAGMENT_ENCODE_SET;
    String F = HttpUrl.FRAGMENT_ENCODE_SET;
    int G = 0;
    int H = 0;
    long I = 0;
    long J = 0;
    MediaMetadataRetriever K = null;
    String L = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends e0 {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            QwjwwM qwjwwM = QwjwwM.this;
            qwjwwM.B.setText(qwjwwM.a1());
            QwjwwM.this.L = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QwjwwM.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements ZZcINlcxH.p {
        c() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.p
        public void a() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.p
        public void b(Bitmap bitmap) {
            float height = bitmap.getHeight() / bitmap.getWidth();
            if (height > 2.0f || height < 0.5d) {
                QwjwwM qwjwwM = QwjwwM.this;
                float f6 = qwjwwM.H / qwjwwM.G;
                if (f6 < 1.0f) {
                    f6 = 1.0f / f6;
                }
                if (height < 1.0f) {
                    height = 1.0f / height;
                }
                if (height / f6 > 1.2d) {
                    qwjwwM.y("封面图比例跟视频比例不匹配");
                    return;
                }
            }
            QwjwwM qwjwwM2 = QwjwwM.this;
            qwjwwM2.C = bitmap;
            qwjwwM2.D.setImageBitmap(bitmap);
            QwjwwM.this.D.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ p f7363d;

        d(p pVar) {
            this.f7363d = pVar;
        }

        @Override // g4.f
        protected void a(View view) {
            int i6;
            Class cls;
            QwjwwM qwjwwM = QwjwwM.this;
            int i7 = 7;
            if (qwjwwM.f7353t == 7) {
                i6 = this.f7363d.id;
                cls = RcB8ALaRS.class;
            } else if (qwjwwM.f1()) {
                qwjwwM = QwjwwM.this;
                i6 = this.f7363d.id;
                i7 = 2;
                cls = LQS1CVD.class;
            } else {
                qwjwwM = QwjwwM.this;
                i6 = this.f7363d.id;
                i7 = 5;
                cls = DHwJuV.class;
            }
            qwjwwM.O0(cls, i6, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends s.g {
        e(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            if (QwjwwM.this.isDestroyed() || QwjwwM.this.isFinishing()) {
                return;
            }
            q qVar = (q) com.secret.prettyhezi.f.d(str, q.class);
            if (qVar.code != 200) {
                f(qVar.err);
                return;
            }
            QwjwwM.this.M.removeAllViews();
            p[] pVarArr = qVar.data;
            int length = pVarArr == null ? 0 : pVarArr.length;
            if (length <= 0) {
                QwjwwM qwjwwM = QwjwwM.this;
                qwjwwM.M.addView(g4.d.c(qwjwwM, 18, -16777216, "没有相关内容", 17), new LinearLayout.LayoutParams(-1, g4.i.r(80.0f)));
                return;
            }
            TextView b6 = g4.d.b(QwjwwM.this, 12.0f, Color.parseColor("#333333"), "有如下内容标题相似：");
            b6.setPadding(0, 0, 0, g4.i.r(4.0f));
            QwjwwM.this.M.addView(b6);
            for (int i6 = 0; i6 < length; i6++) {
                LinearLayout X0 = QwjwwM.this.X0(qVar.data[i6]);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = g4.i.r(4.0f);
                QwjwwM.this.M.addView(X0, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7366b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            this.f7366b = i6;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            String str2;
            if (QwjwwM.this.isDestroyed() || QwjwwM.this.isFinishing()) {
                return;
            }
            t tVar = (t) com.secret.prettyhezi.f.d(str, t.class);
            if (tVar.code == 200) {
                tVar.timeStamp = System.currentTimeMillis();
                QwjwwM.N.put(Integer.valueOf(this.f7366b), tVar);
                r[] rVarArr = tVar.data;
                if (rVarArr != null && rVarArr.length != 0) {
                    QwjwwM.this.i1();
                    return;
                }
                str2 = "没有可用的盒子";
            } else {
                str2 = tVar.err;
            }
            f(str2);
        }
    }

    /* loaded from: classes.dex */
    class g extends ZZcINlcxH.q {
        g() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void a() {
            QwjwwM.this.d1();
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            BNyrYM5KT.S0(QwjwwM.this);
            QwjwwM.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class h extends ZZcINlcxH.q {
        h() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            QwjwwM.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends ZZcINlcxH.q {
        i() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            QwjwwM.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i6, long j6) {
            QwjwwM.this.j1();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
            QwjwwM.this.j1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends g4.f {
        k() {
        }

        @Override // g4.f
        public void a(View view) {
            QwjwwM.this.S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends g4.f {
        l() {
        }

        @Override // g4.f
        public void a(View view) {
            QwjwwM.this.Z0(-1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QwjwwM.this.Z0(2L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n extends g4.f {
        n() {
        }

        @Override // g4.f
        public void a(View view) {
            QwjwwM.this.g1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o extends g4.f {
        o() {
        }

        @Override // g4.f
        public void a(View view) {
            QwjwwM.this.U0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class p implements Serializable {
        public int am;
        public long at;
        public int dur;
        public int id;
        public String na;
        public long size;
        int st;

        p() {
        }
    }

    /* loaded from: classes.dex */
    static class q extends com.secret.prettyhezi.Server.w {
        public p[] data;

        q() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class r implements Serializable {
        public long id;
        public String name;
        public int total;

        r() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class s implements Serializable {

        /* renamed from: t  reason: collision with root package name */
        public int f7377t;

        public s(int i6) {
            this.f7377t = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class t extends com.secret.prettyhezi.Server.w {
        public r[] data;
        public long timeStamp;

        t() {
        }
    }

    void S0() {
        v(new c());
    }

    void T0(int i6) {
        t tVar = (t) N.get(Integer.valueOf(this.f7353t));
        if (tVar != null && System.currentTimeMillis() - tVar.timeStamp < 60000) {
            i1();
            return;
        }
        y.v(com.secret.prettyhezi.Server.v.f7132a + "api/boxlist?t=" + i6, com.secret.prettyhezi.f.e(new s(i6)), true, new f(this, i6));
    }

    void U0() {
        String trim = this.B.getText().toString().trim();
        String str = this.L;
        if (str == null || !str.equals(trim)) {
            this.L = trim;
            I0();
            int i6 = this.f7353t;
            if (i6 == 2 && !f1()) {
                i6 = 5;
            }
            y.q(com.secret.prettyhezi.Server.v.f7132a + "api/search?name=" + trim + "&t=" + i6, new e(this));
        }
    }

    public String V0() {
        if (this.f7353t == 7) {
            if (this.I < 60) {
                return "必须是1分钟以上的语音 ";
            }
            return null;
        }
        int i6 = this.G;
        if (i6 >= 900 || this.H >= 900) {
            long j6 = this.I;
            if (j6 < 10) {
                return "必须是10秒以上的视频 ";
            }
            int i7 = this.H;
            if (i6 > i7 * 4 || i7 > i6 * 4) {
                return "视频比例不符合要求 ";
            }
            if ((this.J * 60) / j6 < 2097152) {
                return "视频质量过差";
            }
            return null;
        }
        return "视频分辨率太低";
    }

    TextView W0(String str) {
        TextView c6 = g4.d.c(this, 16, -16777216, str, 17);
        c6.setBackground(g4.i.d(g4.i.c(-1, 6.0f, -16777216, 1.0f), g4.i.c(-7829368, 6.0f, -16777216, 1.0f)));
        return c6;
    }

    LinearLayout X0(p pVar) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(g4.i.d(g4.i.b(-1, 3.0f), g4.i.b(Color.parseColor("#e0e0e0"), 3.0f)));
        linearLayout.setPadding(g4.i.r(4.0f), g4.i.r(4.0f), g4.i.r(4.0f), g4.i.r(4.0f));
        linearLayout.addView(g4.d.b(this, 14.0f, Color.parseColor("#333333"), pVar.na), new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(4.0f);
        linearLayout.addView(linearLayout2, layoutParams);
        int parseColor = Color.parseColor("#333333");
        linearLayout2.addView(g4.d.b(this, 12.0f, parseColor, "时长：" + g4.i.G(pVar.dur)), new LinearLayout.LayoutParams(g4.i.r(110.0f), -2));
        linearLayout2.addView(g4.d.b(this, 12.0f, Color.parseColor("#333333"), Y0(pVar.size)), new LinearLayout.LayoutParams(-2, -2));
        int parseColor2 = Color.parseColor("#555555");
        linearLayout2.addView(g4.d.c(this, 12, parseColor2, "上传时间：" + g4.i.v(pVar.at), 5), new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.setOnClickListener(new d(pVar));
        return linearLayout;
    }

    String Y0(long j6) {
        StringBuilder sb;
        String str;
        if (j6 > 1048576) {
            sb = new StringBuilder();
            sb.append((j6 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
            str = "M";
        } else {
            sb = new StringBuilder();
            sb.append(j6 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
            str = "K";
        }
        sb.append(str);
        return sb.toString();
    }

    void Z0(long j6) {
        if (j6 < 0) {
            j6 = ((int) (Math.random() * (this.I - 3))) + 2;
        }
        Bitmap frameAtTime = this.K.getFrameAtTime(j6 * 1000000);
        this.C = frameAtTime;
        this.D.setImageBitmap(frameAtTime);
        this.D.invalidate();
    }

    String a1() {
        String trim = this.f7359z.getText().toString().trim();
        if (trim.length() > 0) {
            if (this.f7355v != null) {
                int indexOf = trim.indexOf(91);
                int lastIndexOf = trim.lastIndexOf(93);
                if (indexOf < 0 || lastIndexOf <= indexOf) {
                    return trim;
                }
                String substring = trim.substring(indexOf + 1, lastIndexOf);
                boolean z5 = false;
                int i6 = 0;
                while (true) {
                    String[] strArr = this.f7355v;
                    if (i6 >= strArr.length) {
                        break;
                    } else if (strArr[i6].equals(substring)) {
                        z5 = true;
                        break;
                    } else {
                        i6++;
                    }
                }
                return z5 ? trim.substring(lastIndexOf + 1) : trim;
            }
            return trim;
        }
        return this.F;
    }

    r b1(int i6) {
        return ((t) N.get(Integer.valueOf(this.f7353t))).data[i6 - 1];
    }

    void c1() {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        this.K = mediaMetadataRetriever;
        mediaMetadataRetriever.setDataSource(this.f7352s);
        String str = this.f7352s;
        String substring = str.substring(str.lastIndexOf(47) + 1);
        this.E = substring;
        this.F = substring.substring(0, substring.lastIndexOf(46));
        if (this.f7353t != 7) {
            this.G = Integer.parseInt(this.K.extractMetadata(18));
            this.H = Integer.parseInt(this.K.extractMetadata(19));
            String extractMetadata = this.K.extractMetadata(24);
            if (extractMetadata.equals("90") || extractMetadata.equals(270)) {
                int i6 = this.G;
                this.G = this.H;
                this.H = i6;
            }
        }
        long parseLong = (Long.parseLong(this.K.extractMetadata(9)) + 500) / 1000;
        this.I = parseLong;
        String format = String.format("%02d:%02d:%02d", Long.valueOf(parseLong / 3600), Long.valueOf((this.I % 3600) / 60), Long.valueOf(this.I % 60));
        this.f7351r.addView(g4.d.b(this, 16.0f, -16777216, "文件名：" + this.E), new LinearLayout.LayoutParams(-1, -2));
        if (this.f7353t != 7) {
            format = format + "  " + this.G + "x" + this.H;
        }
        TextView b6 = g4.d.b(this, 14.0f, -16777216, format + "  " + Y0(this.J));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int r5 = g4.i.r(6.0f);
        layoutParams.bottomMargin = r5;
        layoutParams.topMargin = r5;
        this.f7351r.addView(b6, layoutParams);
        if (this.f7353t == 7 || !f1()) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            int r6 = g4.i.r(4.0f);
            layoutParams2.bottomMargin = r6;
            layoutParams2.topMargin = r6;
            this.f7351r.addView(linearLayout, layoutParams2);
            linearLayout.addView(g4.d.b(this, 16.0f, -16777216, "类型："), new LinearLayout.LayoutParams(-2, -2));
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(0, -2, 1.0f));
            linearLayout2.setBackground(g4.i.d(g4.i.c(-1, 5.0f, -7829368, 1.0f), g4.i.c(-7829368, 5.0f, -7829368, 1.0f)));
            this.f7356w = new Spinner(this);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, g4.i.r(40.0f));
            layoutParams3.leftMargin = g4.i.r(4.0f);
            linearLayout2.addView(this.f7356w, layoutParams3);
            this.f7356w.setOnItemSelectedListener(new j());
        }
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        int r7 = g4.i.r(4.0f);
        layoutParams4.bottomMargin = r7;
        layoutParams4.topMargin = r7;
        this.f7351r.addView(linearLayout3, layoutParams4);
        linearLayout3.addView(g4.d.b(this, 16.0f, -16777216, "盒子："), new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout3.addView(linearLayout4, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout4.setBackground(g4.i.d(g4.i.c(-1, 5.0f, -7829368, 1.0f), g4.i.c(-7829368, 5.0f, -7829368, 1.0f)));
        this.f7358y = new Spinner(this);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, g4.i.r(40.0f));
        layoutParams5.leftMargin = g4.i.r(4.0f);
        linearLayout4.addView(this.f7358y, layoutParams5);
        T0(this.f7353t);
        LinearLayout linearLayout5 = new LinearLayout(this);
        linearLayout5.setGravity(16);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.bottomMargin = g4.i.r(6.0f);
        this.f7351r.addView(linearLayout5, layoutParams6);
        linearLayout5.addView(g4.d.b(this, 16.0f, -16777216, "标题："));
        linearLayout5.addView(g4.d.b(this, 14.0f, -7829368, this.f7353t == 7 ? "格式：类型-标题" : f1() ? "格式：标题[番号,演员,内容]" : "格式：类型-标题[番号,演员,内容]"));
        EditText editText = new EditText(this);
        this.f7359z = editText;
        editText.setBackground(g4.i.b(Color.parseColor("#ffffff"), 4.0f));
        this.f7359z.setTextColor(-16777216);
        this.f7359z.setTextSize(16.0f);
        this.f7359z.setHintTextColor(-7829368);
        this.f7359z.setGravity(51);
        this.f7359z.setHint(this.f7353t == 7 ? "标题，例如:[有声小说]老鼠爱上猫" : "标题，例如：[自拍]ppnd-535 游泳比赛");
        this.f7359z.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        com.secret.prettyhezi.controls.j.b(this.f7359z, 256);
        this.f7351r.addView(this.f7359z, new LinearLayout.LayoutParams(-1, g4.i.r(80.0f)));
        LinearLayout linearLayout6 = new LinearLayout(this);
        linearLayout6.setGravity(16);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        int r8 = g4.i.r(6.0f);
        layoutParams7.topMargin = r8;
        layoutParams7.bottomMargin = r8;
        this.f7351r.addView(linearLayout6, layoutParams7);
        linearLayout6.addView(g4.d.b(this, 16.0f, -16777216, "简介："));
        linearLayout6.addView(g4.d.b(this, 14.0f, -7829368, "（不超过200个字）"));
        EditText editText2 = new EditText(this);
        this.A = editText2;
        editText2.setBackground(g4.i.b(Color.parseColor("#ffffff"), 4.0f));
        this.A.setTextColor(-16777216);
        this.A.setTextSize(16.0f);
        this.A.setHintTextColor(-7829368);
        this.A.setGravity(51);
        this.A.setHint("简介");
        this.A.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        com.secret.prettyhezi.controls.j.b(this.A, 256);
        this.f7351r.addView(this.A, new LinearLayout.LayoutParams(-1, g4.i.r(80.0f)));
        if (this.f7353t == 2) {
            LinearLayout linearLayout7 = new LinearLayout(this);
            linearLayout7.setGravity(17);
            this.f7351r.addView(linearLayout7, new LinearLayout.LayoutParams(-1, g4.i.r(56.0f)));
            TextView W0 = W0("选择封面图");
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(g4.i.r(120.0f), g4.i.r(40.0f));
            layoutParams8.rightMargin = g4.i.r(40.0f);
            linearLayout7.addView(W0, layoutParams8);
            W0.setOnClickListener(new k());
            TextView W02 = W0("换一张封面");
            linearLayout7.addView(W02, new LinearLayout.LayoutParams(g4.i.r(120.0f), g4.i.r(40.0f)));
            W02.setOnClickListener(new l());
            ImageView imageView = new ImageView(this);
            this.D = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f7351r.addView(this.D, new LinearLayout.LayoutParams(-1, g4.i.r(300.0f)));
            this.D.postDelayed(new m(), 100L);
        }
        U(this.f7351r, "上传", 20, 20).setOnClickListener(new n());
        TextView b7 = g4.d.b(this, 16.0f, -16777216, "搜索已有上传内容标题查重：");
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.topMargin = g4.i.r(30.0f);
        this.f7351r.addView(b7, layoutParams9);
        EditText editText3 = new EditText(this);
        this.B = editText3;
        editText3.setBackground(g4.i.b(Color.parseColor("#ffffff"), 4.0f));
        this.B.setTextColor(-16777216);
        this.B.setTextSize(14.0f);
        this.B.setHintTextColor(-7829368);
        this.B.setGravity(51);
        this.B.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        com.secret.prettyhezi.controls.j.b(this.B, 130);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, g4.i.r(80.0f));
        layoutParams10.topMargin = g4.i.r(4.0f);
        this.f7351r.addView(this.B, layoutParams10);
        U(this.f7351r, "查重", 10, 10).setOnClickListener(new o());
        LinearLayout linearLayout8 = new LinearLayout(this);
        this.M = linearLayout8;
        linearLayout8.setOrientation(1);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams11.topMargin = g4.i.r(20.0f);
        layoutParams11.bottomMargin = g4.i.r(20.0f);
        this.f7351r.addView(this.M, layoutParams11);
        j1();
        this.f7359z.addTextChangedListener(new a());
        this.B.setText(a1());
    }

    void d1() {
        String str;
        i iVar = null;
        try {
            c1();
            str = null;
        } catch (Exception unused) {
            str = "加载出错";
        }
        if (str == null) {
            str = V0();
        }
        if (str != null) {
            iVar = new i();
        } else if (this.f7353t != 2 || !f1()) {
            a0 r5 = MainApplication.f6711r.r();
            com.secret.prettyhezi.Upload.q[] qVarArr = this.f7353t == 7 ? r5.mns : r5.rns;
            if (qVarArr == null || qVarArr.length <= 0) {
                return;
            }
            e1(qVarArr);
            h1();
            return;
        } else {
            str = "时长少于5分钟的视频将上传到短视频，不消耗上传额度";
        }
        D(str, iVar, false);
    }

    public void e1(com.secret.prettyhezi.Upload.q[] qVarArr) {
        this.f7354u = qVarArr;
        String[] strArr = new String[qVarArr.length + 1];
        this.f7355v = strArr;
        int i6 = 0;
        strArr[0] = HttpUrl.FRAGMENT_ENCODE_SET;
        while (true) {
            com.secret.prettyhezi.Upload.q[] qVarArr2 = this.f7354u;
            if (i6 >= qVarArr2.length) {
                return;
            }
            int i7 = i6 + 1;
            this.f7355v[i7] = qVarArr2[i6].name;
            i6 = i7;
        }
    }

    boolean f1() {
        return this.f7353t == 2 && this.I < 300;
    }

    void g1() {
        int selectedItemPosition;
        String str;
        if (this.f7353t == 7 || !f1()) {
            selectedItemPosition = this.f7356w.getSelectedItemPosition();
            if (selectedItemPosition > 0) {
                selectedItemPosition = this.f7354u[selectedItemPosition - 1].id;
            }
        } else {
            selectedItemPosition = 1000;
        }
        int selectedItemPosition2 = this.f7358y.getSelectedItemPosition();
        if (selectedItemPosition2 <= 0) {
            q("请选择要上传到的盒子");
            return;
        }
        String trim = this.f7359z.getText().toString().trim();
        String trim2 = this.A.getText().toString().trim();
        int length = trim.length();
        if (f1()) {
            if (length < 4) {
                str = "标题至少4个字";
            }
            str = null;
        } else if (selectedItemPosition <= 0) {
            str = "请选择类型";
        } else if (length < 8) {
            str = "标题至少8个字";
        } else {
            if (!f1()) {
                int indexOf = trim.indexOf(93);
                boolean z5 = false;
                if (trim.charAt(0) != '[' || indexOf <= 1) {
                    str = "标题格式不对";
                } else {
                    String substring = trim.substring(1, indexOf);
                    int i6 = 0;
                    while (true) {
                        String[] strArr = this.f7355v;
                        if (i6 >= strArr.length) {
                            break;
                        } else if (strArr[i6].equals(substring)) {
                            z5 = true;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    if (!z5) {
                        str = "标题中类型与选择的类型不同";
                    }
                }
            }
            str = null;
        }
        if (str == null) {
            if (y.f7523h == null) {
                str = "正在登陆上传服务器，请稍后...";
            } else if (this.f7353t == 2 && !f1() && y.f7523h.user.amount < 1) {
                str = "你的上传额度已用完，请明天再试...";
            }
        }
        if (str != null) {
            q(str);
            return;
        }
        y.k kVar = new y.k();
        kVar.fid = selectedItemPosition;
        kVar.duration = (int) this.I;
        kVar.title = trim;
        kVar.content = trim2;
        kVar.boxId = b1(selectedItemPosition2).id;
        if (this.f7353t == 7) {
            y.i iVar = new y.i();
            kVar.audio = iVar;
            iVar.path = this.f7352s;
            iVar.size = this.J;
        } else {
            kVar.zip = new y.i();
            kVar.width = this.G;
            kVar.height = this.H;
            kVar.videoPath = this.f7352s;
            kVar.videoSize = this.J;
            kVar.thumbWidth = this.C.getWidth();
            kVar.thumbHeight = this.C.getHeight();
            kVar.thumbPath = y.b() + File.separator + "thumb_" + System.currentTimeMillis() + ".jpeg";
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(kVar.thumbPath);
                if (this.C.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        y.a(kVar);
        this.f7351r.postDelayed(new b(), 100L);
    }

    void h1() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, (int) C0382R.layout.upload_type_spinner_layout, this.f7355v);
        this.f7357x = arrayAdapter;
        this.f7356w.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f7356w.setSelection(this.f7353t == 7 ? 2 : 0);
    }

    void i1() {
        r[] rVarArr;
        t tVar = (t) N.get(Integer.valueOf(this.f7353t));
        if (tVar == null || (rVarArr = tVar.data) == null || rVarArr.length == 0) {
            return;
        }
        String[] strArr = new String[rVarArr.length + 1];
        int i6 = 0;
        strArr[0] = HttpUrl.FRAGMENT_ENCODE_SET;
        while (i6 < rVarArr.length) {
            int i7 = i6 + 1;
            strArr[i7] = rVarArr[i6].name + "(" + rVarArr[i6].total + "/2000)";
            i6 = i7;
        }
        this.f7358y.setAdapter((SpinnerAdapter) new ArrayAdapter(this, (int) C0382R.layout.upload_type_spinner_layout, strArr));
    }

    void j1() {
        String a12 = a1();
        int selectedItemPosition = !f1() ? this.f7356w.getSelectedItemPosition() : 0;
        if (selectedItemPosition > 0) {
            a12 = "[" + this.f7355v[selectedItemPosition] + "]" + a12;
        }
        this.f7359z.setText(a12);
        this.A.setText(a12);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7352s = extras.getString("path");
            this.f7353t = extras.getInt("type");
        }
        LinearLayout C0 = C0();
        M(C0, this.f7353t == 7 ? "语音上传" : "视频上传");
        LinearLayout e6 = e(C0);
        this.f7351r = e6;
        e6.setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        try {
            long length = new File(this.f7352s).length();
            this.J = length;
            if (this.f7353t == 7 || length <= 524288000) {
                d1();
            } else {
                C("大于500M的视频建议使用windows上传工具上传", new String[]{"坚持使用手机上传", "下载工具"}, new g(), false);
            }
        } catch (Exception unused) {
            D("加载出错", new h(), false);
        }
    }
}
