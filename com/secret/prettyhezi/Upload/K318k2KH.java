package com.secret.prettyhezi.Upload;

import android.os.Bundle;
import android.widget.LinearLayout;
import c.abc;
import com.secret.prettyhezi.UoWMF;
/* loaded from: classes.dex */
public class K318k2KH extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7332r;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7332r = C0;
        M(C0, abc.ams("s7"));
        this.f7332r.addView(new d(this), new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }
}
