package com.secret.prettyhezi.controls.PullToRefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class i extends f {
    public i(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.controls.PullToRefresh.f
    /* renamed from: O */
    public ScrollView o(Context context, AttributeSet attributeSet) {
        return new ScrollView(context);
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.f
    protected boolean w() {
        return ((ScrollView) this.f8237p).getScrollY() == 0;
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.f
    protected boolean x() {
        View childAt = ((ScrollView) this.f8237p).getChildAt(0);
        return childAt != null && ((ScrollView) this.f8237p).getScrollY() >= childAt.getHeight() - getHeight();
    }

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }
}
