package com.secret.prettyhezi.Upload;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.secret.prettyhezi.Upload.s;
/* loaded from: classes.dex */
public class LNoFT extends CheckBaseActivity {
    LinearLayout C;
    com.secret.prettyhezi.controls.a D = null;

    @Override // com.secret.prettyhezi.Upload.CheckBaseActivity
    protected void V0() {
        LinearLayout linearLayout = new LinearLayout(this);
        this.C = linearLayout;
        this.f7246v.addView(linearLayout, new LinearLayout.LayoutParams(-1, Y0()));
    }

    @Override // com.secret.prettyhezi.Upload.CheckBaseActivity
    protected void a1(String str) {
        s sVar = (s) com.secret.prettyhezi.f.d(str, s.class);
        if (sVar.code != 200) {
            com.secret.prettyhezi.s.d(this, sVar.err);
            return;
        }
        s.a aVar = sVar.data;
        com.secret.prettyhezi.Server.t tVar = aVar.data;
        d1(tVar.id, aVar.label, aVar.content, tVar.na, tVar.mt);
        e1(tVar);
    }

    void e1(com.secret.prettyhezi.Server.t tVar) {
        com.secret.prettyhezi.controls.a aVar = this.D;
        if (aVar != null) {
            aVar.a();
        }
        this.C.removeAllViews();
        com.secret.prettyhezi.controls.a aVar2 = new com.secret.prettyhezi.controls.a(this, -1, -1, tVar.images(), null);
        this.D = aVar2;
        this.C.addView(aVar2, new LinearLayout.LayoutParams(-1, Y0()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.Upload.CheckBaseActivity, com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
