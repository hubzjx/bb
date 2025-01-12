package com.secret.prettyhezi;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.View.e0;
/* loaded from: classes.dex */
public class PTnimM extends FCCERA {

    /* renamed from: x  reason: collision with root package name */
    int f6782x;

    /* renamed from: y  reason: collision with root package name */
    int f6783y;

    @Override // com.secret.prettyhezi.FCCERA
    public RelativeLayout S0() {
        return M(this.f6200r, s0(C0382R.string.followers));
    }

    @Override // com.secret.prettyhezi.FCCERA
    public View U0() {
        String c6;
        e0 e0Var = new e0(this);
        int i6 = this.f6783y;
        if (i6 != 2) {
            if (i6 == 1) {
                c6 = com.secret.prettyhezi.Server.v.c(this.f6782x, 999);
            }
            return e0Var;
        }
        c6 = com.secret.prettyhezi.Server.v.j(this.f6782x, 999);
        e0Var.g(c6);
        return e0Var;
    }

    @Override // com.secret.prettyhezi.FCCERA
    public void V0(int i6) {
        if (this.f6201s.getChildCount() > 0) {
            View childAt = this.f6201s.getChildAt(0);
            if (childAt instanceof com.secret.prettyhezi.View.t) {
                ((com.secret.prettyhezi.View.t) childAt).D(i6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.FCCERA
    public void W0() {
        super.W0();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6782x = extras.getInt("id");
            this.f6783y = extras.getInt("type");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.FCCERA, com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
