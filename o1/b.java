package o1;

import com.google.android.exoplayer2.util.x;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import n1.e;
import n1.h;
/* loaded from: classes.dex */
public final class b extends h {
    private static n1.a c(x xVar) {
        xVar.r(12);
        int d6 = (xVar.d() + xVar.h(12)) - 4;
        xVar.r(44);
        xVar.s(xVar.h(12));
        xVar.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String str = null;
            if (xVar.d() >= d6) {
                break;
            }
            xVar.r(48);
            int h6 = xVar.h(8);
            xVar.r(4);
            int d7 = xVar.d() + xVar.h(12);
            String str2 = null;
            while (xVar.d() < d7) {
                int h7 = xVar.h(8);
                int h8 = xVar.h(8);
                int d8 = xVar.d() + h8;
                if (h7 == 2) {
                    int h9 = xVar.h(16);
                    xVar.r(8);
                    if (h9 != 3) {
                    }
                    while (xVar.d() < d8) {
                        str = xVar.l(xVar.h(8), com.google.common.base.b.f5583a);
                        int h10 = xVar.h(8);
                        for (int i6 = 0; i6 < h10; i6++) {
                            xVar.s(xVar.h(8));
                        }
                    }
                } else if (h7 == 21) {
                    str2 = xVar.l(h8, com.google.common.base.b.f5583a);
                }
                xVar.p(d8 * 8);
            }
            xVar.p(d7 * 8);
            if (str != null && str2 != null) {
                arrayList.add(new a(h6, str2.length() != 0 ? str.concat(str2) : new String(str)));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new n1.a(arrayList);
    }

    @Override // n1.h
    protected n1.a b(e eVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new x(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
