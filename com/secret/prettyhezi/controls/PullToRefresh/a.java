package com.secret.prettyhezi.controls.PullToRefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f8205e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f8206f;

    public a(Context context) {
        super(context);
        k(context);
    }

    private void k(Context context) {
        this.f8205e = (ProgressBar) findViewById(C0382R.id.pull_to_load_footer_progressbar);
        this.f8206f = (TextView) findViewById(C0382R.id.pull_to_load_footer_hint_textview);
        setState(d.RESET);
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    protected View a(Context context, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(C0382R.layout.pull_to_load_footer, (ViewGroup) null);
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    protected void c() {
        this.f8206f.setVisibility(0);
        this.f8206f.setText("- 到底了 -");
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    protected void e() {
        this.f8206f.setVisibility(0);
        this.f8206f.setText("上拉可以加载");
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    protected void f() {
        this.f8205e.setVisibility(0);
        this.f8206f.setVisibility(0);
        this.f8206f.setText("加载中");
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    protected void g() {
        this.f8206f.setVisibility(0);
        this.f8206f.setText("松开后加载");
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    public int getContentSize() {
        View findViewById = findViewById(C0382R.id.pull_to_load_footer_content);
        return findViewById != null ? findViewById.getHeight() : (int) (getResources().getDisplayMetrics().density * 40.0f);
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    protected void h() {
        this.f8206f.setText("加载中");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    public void i(d dVar, d dVar2) {
        this.f8205e.setVisibility(8);
        this.f8206f.setVisibility(4);
        super.i(dVar, dVar2);
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    public void setLastUpdatedLabel(CharSequence charSequence) {
    }
}
