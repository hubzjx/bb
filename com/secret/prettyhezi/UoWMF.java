package com.secret.prettyhezi;

import android.os.Bundle;
import android.view.View;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
/* loaded from: classes.dex */
public class UoWMF extends ZZcINlcxH {

    /* renamed from: q  reason: collision with root package name */
    private v4.a f7205q;

    public SwipeBackLayout R0() {
        return this.f7205q.b();
    }

    @Override // android.app.Activity
    public View findViewById(int i6) {
        v4.a aVar;
        View findViewById = super.findViewById(i6);
        return (findViewById != null || (aVar = this.f7205q) == null) ? findViewById : aVar.a(i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v4.a aVar = new v4.a(this);
        this.f7205q = aVar;
        aVar.c();
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f7205q.d();
    }
}
