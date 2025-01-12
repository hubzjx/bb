package com.secret.prettyhezi.share;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.FCCERA;
import com.secret.prettyhezi.View.t;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class E7e4N7RM extends FCCERA {

    /* loaded from: classes.dex */
    public class a extends t {
        public a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH, i.class);
            this.E = true;
            this.f8029w = false;
            g("user/invite/show/json?page=999");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.secret.prettyhezi.View.t
        /* renamed from: N */
        public j l(ZZcINlcxH zZcINlcxH, i iVar, int i6) {
            return new j(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.View.t
        protected int a() {
            return 1;
        }
    }

    @Override // com.secret.prettyhezi.FCCERA
    public RelativeLayout S0() {
        return M(this.f6200r, s0(C0382R.string.InviteRecord));
    }

    @Override // com.secret.prettyhezi.FCCERA
    public View U0() {
        return new a(this);
    }

    @Override // com.secret.prettyhezi.FCCERA
    public void V0(int i6) {
        if (this.f6201s.getChildCount() > 0) {
            View childAt = this.f6201s.getChildAt(0);
            if (childAt instanceof t) {
                ((t) childAt).D(i6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.FCCERA, com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
