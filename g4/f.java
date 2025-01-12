package g4;

import android.view.View;
/* loaded from: classes.dex */
public abstract class f implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    static long f10500c;

    /* renamed from: b  reason: collision with root package name */
    private long f10501b = 0;

    protected abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f10501b <= 600 || currentTimeMillis - f10500c <= 400) {
            return;
        }
        this.f10501b = currentTimeMillis;
        f10500c = currentTimeMillis;
        a(view);
    }
}
