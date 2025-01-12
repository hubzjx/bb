package com.secret.prettyhezi.Registration;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.secret.prettyhezi.UoWMF;
/* loaded from: classes.dex */
public class EXLrpMw8U extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6870r;

    /* renamed from: s  reason: collision with root package name */
    e f6871s;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6870r = C0;
        M(C0, "已使用注册码");
        e eVar = new e(this, 0);
        this.f6871s = eVar;
        this.f6870r.addView(eVar, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }
}
