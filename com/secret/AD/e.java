package com.secret.AD;

import android.graphics.Point;
import android.util.ArrayMap;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.Server.g;
import com.secret.prettyhezi.ZZcINlcxH;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a {

    /* renamed from: f  reason: collision with root package name */
    static ArrayMap f5910f;

    static {
        ArrayMap arrayMap = new ArrayMap();
        f5910f = arrayMap;
        arrayMap.put(6, 0);
        f5910f.put(7, 0);
        f5910f.put(8, 0);
    }

    public e(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, false);
        ArrayList a6 = c.a(i6);
        if (a6.size() == 0) {
            setVisibility(8);
            return;
        }
        int intValue = ((Integer) f5910f.get(Integer.valueOf(i6))).intValue();
        c((g.a) a6.get(intValue));
        int i7 = intValue + 1;
        f5910f.put(Integer.valueOf(i6), Integer.valueOf(i7 != a6.size() ? i7 : 0));
    }

    @Override // com.secret.AD.a
    public RelativeLayout.LayoutParams a() {
        int i6;
        Point o5 = this.f5892b.o();
        g.a aVar = this.f5893c;
        int i7 = aVar.width;
        if (i7 <= 0 || (i6 = aVar.height) <= 0) {
            return new RelativeLayout.LayoutParams(o5.x, o5.y);
        }
        float min = Math.min(o5.x / i7, o5.y / i6);
        g.a aVar2 = this.f5893c;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (aVar2.width * min), (int) (min * aVar2.height));
        layoutParams.addRule(13, -1);
        return layoutParams;
    }
}
