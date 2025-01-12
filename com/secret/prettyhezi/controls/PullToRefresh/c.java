package com.secret.prettyhezi.controls.PullToRefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
/* loaded from: classes.dex */
public class c extends e {

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f8213e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f8214f;

    /* renamed from: g  reason: collision with root package name */
    private ProgressBar f8215g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f8216h;

    /* renamed from: i  reason: collision with root package name */
    private Animation f8217i;

    /* renamed from: j  reason: collision with root package name */
    private Animation f8218j;

    public c(Context context) {
        super(context);
        k(context);
    }

    private void k(Context context) {
        this.f8213e = (RelativeLayout) findViewById(C0382R.id.pull_to_refresh_header_content);
        this.f8214f = (ImageView) findViewById(C0382R.id.pull_to_refresh_header_arrow);
        this.f8216h = (TextView) findViewById(C0382R.id.pull_to_refresh_header_hint_textview);
        this.f8215g = (ProgressBar) findViewById(C0382R.id.pull_to_refresh_header_progressbar);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f8217i = rotateAnimation;
        rotateAnimation.setDuration(200L);
        this.f8217i.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f8218j = rotateAnimation2;
        rotateAnimation2.setDuration(200L);
        this.f8218j.setFillAfter(true);
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    protected View a(Context context, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(C0382R.layout.pull_to_refresh_header, (ViewGroup) null);
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    protected void e() {
        if (d.RELEASE_TO_REFRESH == getPreState()) {
            this.f8214f.clearAnimation();
            this.f8214f.startAnimation(this.f8218j);
        }
        this.f8216h.setText("下拉即可刷新");
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    protected void f() {
        this.f8214f.clearAnimation();
        this.f8214f.setVisibility(4);
        this.f8215g.setVisibility(0);
        this.f8216h.setText("加载中");
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    protected void g() {
        this.f8214f.clearAnimation();
        this.f8214f.startAnimation(this.f8217i);
        this.f8216h.setText("松开即可刷新");
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    public int getContentSize() {
        int height;
        RelativeLayout relativeLayout = this.f8213e;
        return (relativeLayout == null || (height = relativeLayout.getHeight()) <= 0) ? (int) (getResources().getDisplayMetrics().density * 60.0f) : height;
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    protected void h() {
        this.f8214f.clearAnimation();
        this.f8216h.setText("下拉即可刷新");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.controls.PullToRefresh.e
    public void i(d dVar, d dVar2) {
        this.f8214f.setVisibility(0);
        this.f8215g.setVisibility(4);
        super.i(dVar, dVar2);
    }
}
