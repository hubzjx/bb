package com.secret.prettyhezi.View;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Video.MSqCZ2mQ;
import com.secret.prettyhezi.Video.NRxYacSEB;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
import okhttp3.internal.ws.RealWebSocket;
/* loaded from: classes.dex */
public class f0 extends u {

    /* renamed from: m  reason: collision with root package name */
    private com.secret.prettyhezi.Cache.g f7924m;

    /* renamed from: n  reason: collision with root package name */
    ZZcINlcxH f7925n;

    /* renamed from: o  reason: collision with root package name */
    private RelativeLayout f7926o;

    /* renamed from: p  reason: collision with root package name */
    private com.secret.prettyhezi.controls.r f7927p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f7928q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f7929r;

    /* renamed from: s  reason: collision with root package name */
    private com.secret.prettyhezi.controls.z f7930s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f7931t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f7932u;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7933d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f7933d = zZcINlcxH;
        }

        @Override // g4.f
        public void a(View view) {
            if (f0.this.f7930s.getVisibility() != 0) {
                ZZcINlcxH zZcINlcxH = f0.this.f7925n;
                zZcINlcxH.q(zZcINlcxH.s0(C0382R.string.DownloadingNotPlayableHint));
            } else if (!g4.g.a().b("keyVideoAutoLandscape") || f0.this.f7924m.f6040me.f7129w <= f0.this.f7924m.f6040me.f7127h) {
                MSqCZ2mQ.T0(this.f7933d, f0.this.f7924m.GetDownloadedPath(), f0.this.f7924m.navMode, f0.this.f7924m.id, 0L);
            } else {
                NRxYacSEB.z1(this.f7933d, f0.this.f7924m.GetDownloadedPath(), f0.this.f7924m.navMode, f0.this.f7924m.id, 0L);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            f4.c.b(f0.this.f7924m.mp4File);
        }
    }

    public f0(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, i6);
        this.f7925n = zZcINlcxH;
        RelativeLayout relativeLayout = new RelativeLayout(zZcINlcxH);
        this.f7926o = relativeLayout;
        addView(relativeLayout, new LinearLayout.LayoutParams(i6, 100));
        com.secret.prettyhezi.controls.r rVar = new com.secret.prettyhezi.controls.r(zZcINlcxH, HttpUrl.FRAGMENT_ENCODE_SET);
        this.f7927p = rVar;
        this.f7926o.addView(rVar, new RelativeLayout.LayoutParams(-1, -1));
        TextView c6 = g4.d.c(zZcINlcxH, 12, -1, HttpUrl.FRAGMENT_ENCODE_SET, 16);
        this.f7929r = c6;
        c6.setBackgroundColor(Color.parseColor("#55000000"));
        this.f7929r.setPadding(g4.i.r(4.0f), g4.i.r(2.0f), g4.i.r(4.0f), g4.i.r(2.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10, -1);
        this.f7926o.addView(this.f7929r, layoutParams);
        TextView c7 = g4.d.c(zZcINlcxH, 12, -1, HttpUrl.FRAGMENT_ENCODE_SET, 16);
        this.f7928q = c7;
        c7.setBackgroundColor(Color.parseColor("#55000000"));
        this.f7928q.setPadding(g4.i.r(4.0f), g4.i.r(2.0f), g4.i.r(4.0f), g4.i.r(2.0f));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(10, -1);
        layoutParams2.topMargin = g4.i.r(22.0f);
        this.f7926o.addView(this.f7928q, layoutParams2);
        TextView c8 = g4.d.c(zZcINlcxH, 16, -1, HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f7932u = c8;
        c8.setBackground(g4.i.b(Color.parseColor("#aa555555"), 5.0f));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(g4.i.r(100.0f), g4.i.r(30.0f));
        layoutParams3.bottomMargin = g4.i.r(15.0f);
        layoutParams3.addRule(12, -1);
        layoutParams3.addRule(14, -1);
        this.f7926o.addView(this.f7932u, 1, layoutParams3);
        this.f7930s = new com.secret.prettyhezi.controls.z(zZcINlcxH, C0382R.drawable.play_normal);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f));
        layoutParams4.addRule(13, -1);
        this.f7926o.addView(this.f7930s, layoutParams4);
        setOnClickListener(new a(zZcINlcxH));
        TextView c9 = g4.d.c(zZcINlcxH, 14, -1, zZcINlcxH.s0(C0382R.string.SaveToAlbum), 17);
        this.f7931t = c9;
        c9.setBackgroundColor(Color.parseColor("#77000000"));
        this.f7931t.setPadding(g4.i.r(6.0f), 0, g4.i.r(6.0f), 0);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, g4.i.r(32.0f));
        layoutParams5.addRule(11, -1);
        layoutParams5.addRule(12, -1);
        this.f7926o.addView(this.f7931t, layoutParams5);
        this.f7931t.setOnClickListener(new b());
        c();
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        ZZcINlcxH zZcINlcxH;
        int i6;
        com.secret.prettyhezi.Cache.g gVar = (com.secret.prettyhezi.Cache.g) nVar;
        this.f7924m = gVar;
        com.secret.prettyhezi.Server.l lVar = gVar.co;
        this.f7927p.setBackgroundColor(Color.parseColor("#cccccc"));
        this.f7927p.b(lVar.f7128p);
        this.f8037b = (lVar.f7127h * this.f8039d) / lVar.f7129w;
        this.f7926o.setLayoutParams(new LinearLayout.LayoutParams(this.f8039d, this.f8037b));
        this.f7929r.setText(((((this.f7924m.fileSize + 1048576) - 1) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) + "M");
        this.f7928q.setText(g4.i.G(this.f7924m.dur));
        com.secret.prettyhezi.Cache.g gVar2 = this.f7924m;
        boolean z5 = true;
        if (gVar2.status == 2) {
            this.f7930s.setVisibility(0);
            String str = this.f7924m.mp4File;
            this.f7931t.setVisibility((str == null || str.isEmpty()) ? false : false ? 0 : 8);
            this.f7932u.setVisibility(8);
            return;
        }
        this.f7930s.setVisibility((gVar2.f6040me.f7128p.endsWith(".m3u8") ? this.f7924m.percentValue() * this.f7924m.dur : 0) > 30 ? 0 : 8);
        this.f7931t.setVisibility(8);
        this.f7932u.setVisibility(0);
        String percent = this.f7924m.percent();
        int i7 = this.f7924m.status;
        if (i7 == 1) {
            if (percent == null || percent.isEmpty()) {
                zZcINlcxH = this.f7925n;
                i6 = C0382R.string.Downloading;
                percent = zZcINlcxH.s0(i6);
            }
            this.f7932u.setText(percent);
        } else if (i7 == 0) {
            zZcINlcxH = this.f7925n;
            i6 = C0382R.string.Waiting;
            percent = zZcINlcxH.s0(i6);
            this.f7932u.setText(percent);
        } else {
            if (i7 == 3 || i7 == 4) {
                if (percent.isEmpty()) {
                    percent = this.f7925n.s0(C0382R.string.Failed);
                } else {
                    percent = this.f7925n.s0(C0382R.string.Failed) + "(" + percent + ")";
                }
            }
            this.f7932u.setText(percent);
        }
    }

    @Override // com.secret.prettyhezi.View.u
    public RelativeLayout getTopRelativeLayout() {
        return this.f7926o;
    }

    @Override // com.secret.prettyhezi.View.u
    public void k() {
        j().z(this.f7924m, this);
    }
}
