package com.secret.prettyhezi.User;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.secret.prettyhezi.UoWMF;
/* loaded from: classes.dex */
public class SwSRMV extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7613r;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout B0 = B0(3, 4);
        this.f7613r = B0;
        M(B0, "经验值记录");
        this.f7613r.addView(new j(this), new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }
}
