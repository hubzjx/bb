package n2;

import android.text.TextUtils;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class h extends e2.d {

    /* renamed from: o  reason: collision with root package name */
    private final y f12246o;

    /* renamed from: p  reason: collision with root package name */
    private final a f12247p;

    public h() {
        super("WebvttDecoder");
        this.f12246o = new y();
        this.f12247p = new a();
    }

    private static int C(y yVar) {
        int i6 = -1;
        int i7 = 0;
        while (i6 == -1) {
            i7 = yVar.d();
            String m5 = yVar.m();
            i6 = m5 == null ? 0 : "STYLE".equals(m5) ? 2 : m5.startsWith("NOTE") ? 1 : 3;
        }
        yVar.M(i7);
        return i6;
    }

    private static void D(y yVar) {
        do {
        } while (!TextUtils.isEmpty(yVar.m()));
    }

    @Override // e2.d
    protected e2.f A(byte[] bArr, int i6, boolean z5) {
        e m5;
        this.f12246o.K(bArr, i6);
        ArrayList arrayList = new ArrayList();
        try {
            i.e(this.f12246o);
            do {
            } while (!TextUtils.isEmpty(this.f12246o.m()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int C = C(this.f12246o);
                if (C == 0) {
                    return new k(arrayList2);
                }
                if (C == 1) {
                    D(this.f12246o);
                } else if (C == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new e2.h("A style block was found after the first cue.");
                    }
                    this.f12246o.m();
                    arrayList.addAll(this.f12247p.d(this.f12246o));
                } else if (C == 3 && (m5 = f.m(this.f12246o, arrayList)) != null) {
                    arrayList2.add(m5);
                }
            }
        } catch (f1 e6) {
            throw new e2.h(e6);
        }
    }
}
