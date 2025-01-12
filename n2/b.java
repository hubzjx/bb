package n2;

import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import e2.b;
import java.util.ArrayList;
import java.util.Collections;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class b extends e2.d {

    /* renamed from: o  reason: collision with root package name */
    private final y f12200o;

    public b() {
        super("Mp4WebvttDecoder");
        this.f12200o = new y();
    }

    private static e2.b C(y yVar, int i6) {
        CharSequence charSequence = null;
        b.C0159b c0159b = null;
        while (i6 > 0) {
            if (i6 < 8) {
                throw new e2.h("Incomplete vtt cue box header found.");
            }
            int k6 = yVar.k();
            int k7 = yVar.k();
            int i7 = k6 - 8;
            String F = s0.F(yVar.c(), yVar.d(), i7);
            yVar.N(i7);
            i6 = (i6 - 8) - i7;
            if (k7 == 1937011815) {
                c0159b = f.o(F);
            } else if (k7 == 1885436268) {
                charSequence = f.q(null, F.trim(), Collections.emptyList());
            }
        }
        if (charSequence == null) {
            charSequence = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return c0159b != null ? c0159b.m(charSequence).a() : f.l(charSequence);
    }

    @Override // e2.d
    protected e2.f A(byte[] bArr, int i6, boolean z5) {
        this.f12200o.K(bArr, i6);
        ArrayList arrayList = new ArrayList();
        while (this.f12200o.a() > 0) {
            if (this.f12200o.a() < 8) {
                throw new e2.h("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int k6 = this.f12200o.k();
            if (this.f12200o.k() == 1987343459) {
                arrayList.add(C(this.f12200o, k6 - 8));
            } else {
                this.f12200o.N(k6 - 8);
            }
        }
        return new c(arrayList);
    }
}
