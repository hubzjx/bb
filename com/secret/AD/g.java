package com.secret.AD;

import android.widget.RelativeLayout;
import com.secret.prettyhezi.Server.g;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class g extends a {

    /* renamed from: f  reason: collision with root package name */
    public int f5916f;

    public g(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH);
        this.f5916f = i6;
    }

    public static int f(g.a aVar, int i6) {
        int i7;
        int i8 = aVar.width;
        return (i8 <= 0 || (i7 = aVar.height) <= 0) ? i6 : (i6 * i7) / i8;
    }

    @Override // com.secret.AD.a
    public RelativeLayout.LayoutParams a() {
        int i6 = this.f5916f;
        return new RelativeLayout.LayoutParams(i6, f(this.f5893c, i6));
    }
}
