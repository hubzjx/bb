package com.secret.prettyhezi.share;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.secret.prettyhezi.UoWMF;
/* loaded from: classes.dex */
public class NbDOwgfTQ extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8912r;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout B0 = B0(3, 4);
        this.f8912r = B0;
        M(B0, "积分记录");
        this.f8912r.addView(new h(this), new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }
}
