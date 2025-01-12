package com.secret.prettyhezi.Upload;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Server.d0;
import com.secret.prettyhezi.Upload.u;
import com.secret.prettyhezi.Video.MSqCZ2mQ;
import com.secret.prettyhezi.WOqyeiK;
/* loaded from: classes.dex */
public class CnD1H53X extends CheckBaseActivity {
    RelativeLayout C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d0 f7267d;

        a(d0 d0Var) {
            this.f7267d = d0Var;
        }

        @Override // g4.f
        protected void a(View view) {
            d0 d0Var = this.f7267d;
            String[] strArr = d0Var.ps;
            if (strArr == null || strArr.length <= 0) {
                MSqCZ2mQ.T0(CnD1H53X.this, d0Var.f7110me.f7128p, 0, 0, 0L);
            } else {
                WOqyeiK.T0(CnD1H53X.this, strArr, d0Var.f7110me.f7128p);
            }
        }
    }

    @Override // com.secret.prettyhezi.Upload.CheckBaseActivity
    protected void V0() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.C = relativeLayout;
        this.f7246v.addView(relativeLayout, new LinearLayout.LayoutParams(-1, -2));
    }

    @Override // com.secret.prettyhezi.Upload.CheckBaseActivity
    protected void a1(String str) {
        u uVar = (u) com.secret.prettyhezi.f.d(str, u.class);
        if (uVar.code != 200) {
            com.secret.prettyhezi.s.d(this, uVar.err);
            return;
        }
        u.a aVar = uVar.data;
        d0 d0Var = aVar.data;
        d1(d0Var.id, aVar.label, aVar.content, d0Var.na, d0Var.mt);
        e1(d0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (r4 > r0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void e1(d0 d0Var) {
        int i6 = o().x;
        int Y0 = Y0();
        com.secret.prettyhezi.Server.l lVar = d0Var.co;
        int i7 = lVar.f7129w;
        int i8 = lVar.f7127h;
        int i9 = (i7 * Y0) / i8;
        int i10 = (i8 * i6) / i7;
        if (i10 <= Y0) {
            Y0 = i10;
        }
        i6 = i9;
        this.C.setLayoutParams(new LinearLayout.LayoutParams(i6, Y0));
        this.C.addView(new com.secret.prettyhezi.controls.r(this, d0Var.co.f7128p), new RelativeLayout.LayoutParams(i6, Y0));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(Color.parseColor("#33000000"));
        linearLayout.setPadding(g4.i.r(2.0f), 0, g4.i.r(2.0f), 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, g4.i.r(18.0f));
        layoutParams.addRule(11, -1);
        this.C.addView(linearLayout, layoutParams);
        linearLayout.addView(new com.secret.prettyhezi.controls.z(this, C0382R.drawable.ic_duration), new LinearLayout.LayoutParams(g4.i.r(18.0f), g4.i.r(18.0f)));
        linearLayout.addView(g4.d.b(this, 12.0f, -1, g4.i.G(d0Var.dur)), new LinearLayout.LayoutParams(-2, -2));
        com.secret.prettyhezi.controls.z zVar = new com.secret.prettyhezi.controls.z(this, C0382R.drawable.play_normal);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f));
        layoutParams2.addRule(13, -1);
        this.C.addView(zVar, layoutParams2);
        this.C.setOnClickListener(new a(d0Var));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.Upload.CheckBaseActivity, com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
