package com.secret.prettyhezi.controls;

import android.content.Context;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class z extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    private int f8487b;

    public z(Context context, int i6) {
        super(context);
        this.f8487b = 0;
        setImageResource(i6);
    }

    public void a(int i6) {
        if (this.f8487b != i6) {
            this.f8487b = i6;
            setImageResource(i6);
        }
    }
}
