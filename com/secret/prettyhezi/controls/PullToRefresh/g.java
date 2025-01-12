package com.secret.prettyhezi.controls.PullToRefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes.dex */
public abstract class g extends f implements AbsListView.OnScrollListener {

    /* renamed from: t  reason: collision with root package name */
    private ListView f8257t;

    /* renamed from: u  reason: collision with root package name */
    private e f8258u;

    /* renamed from: v  reason: collision with root package name */
    private AbsListView.OnScrollListener f8259v;

    /* renamed from: w  reason: collision with root package name */
    boolean f8260w;

    public g(Context context) {
        this(context, null);
    }

    private boolean P() {
        return this.f8260w;
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.f
    public void A() {
        super.A();
        e eVar = this.f8258u;
        if (eVar != null) {
            eVar.setState(d.RESET);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.controls.PullToRefresh.f
    public void M() {
        super.M();
        e eVar = this.f8258u;
        if (eVar != null) {
            eVar.setState(d.REFRESHING);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.controls.PullToRefresh.f
    /* renamed from: O */
    public ListView o(Context context, AttributeSet attributeSet) {
        ListView listView = new ListView(context);
        this.f8257t = listView;
        listView.setOnScrollListener(this);
        return listView;
    }

    public boolean Q() {
        this.f8257t.getAdapter();
        return (this.f8257t.getChildCount() > 0 ? this.f8257t.getChildAt(0).getTop() : 0) >= 0;
    }

    public boolean R() {
        ListAdapter adapter = this.f8257t.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = this.f8257t.getLastVisiblePosition();
        if (lastVisiblePosition >= (adapter.getCount() - 1) - 1) {
            View childAt = this.f8257t.getChildAt(Math.min(lastVisiblePosition - this.f8257t.getFirstVisiblePosition(), this.f8257t.getChildCount() - 1));
            return childAt != null && childAt.getBottom() <= this.f8257t.getBottom();
        }
        return false;
    }

    public boolean S() {
        return (R() && Q()) ? false : true;
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.f
    public e getFooterLoadingLayout() {
        return y() ? this.f8258u : super.getFooterLoadingLayout();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i6, int i7, int i8) {
        AbsListView.OnScrollListener onScrollListener = this.f8259v;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i6, i7, i8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i6) {
        if (y() && P() && ((i6 == 0 || i6 == 2) && x())) {
            M();
        }
        AbsListView.OnScrollListener onScrollListener = this.f8259v;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i6);
        }
    }

    public void setHasMoreData(boolean z5) {
        e footerLoadingLayout;
        d dVar;
        e eVar = this.f8258u;
        if (z5) {
            if (eVar != null) {
                eVar.setState(d.RESET);
            }
            footerLoadingLayout = getFooterLoadingLayout();
            if (footerLoadingLayout != null) {
                dVar = d.RESET;
                footerLoadingLayout.setState(dVar);
            }
        } else {
            if (eVar != null) {
                eVar.setState(d.NO_MORE_DATA);
            }
            footerLoadingLayout = getFooterLoadingLayout();
            if (footerLoadingLayout != null) {
                dVar = d.NO_MORE_DATA;
                footerLoadingLayout.setState(dVar);
            }
        }
        this.f8260w = z5;
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f8259v = onScrollListener;
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.f
    public void setScrollLoadEnabled(boolean z5) {
        super.setScrollLoadEnabled(z5);
        if (z5) {
            if (this.f8258u == null) {
                this.f8258u = new a(getContext());
            }
            if (this.f8258u.getParent() == null) {
                this.f8257t.addFooterView(this.f8258u, null, false);
            }
            this.f8258u.j(true);
            return;
        }
        e eVar = this.f8258u;
        if (eVar != null) {
            eVar.j(false);
            this.f8257t.removeFooterView(this.f8258u);
        }
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.f
    protected boolean w() {
        return Q();
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.f
    protected boolean x() {
        return R();
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        setBackgroundColor(0);
        this.f8257t.setVerticalScrollBarEnabled(false);
        this.f8257t.setScrollBarSize(0);
    }

    public g(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f8260w = true;
        setPullLoadEnabled(false);
    }
}
