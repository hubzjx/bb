package u3;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final a f13623a;

    /* renamed from: b  reason: collision with root package name */
    private final List f13624b;

    public d(a aVar) {
        this.f13623a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f13624b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }

    private b a(int i6) {
        if (i6 >= this.f13624b.size()) {
            List list = this.f13624b;
            b bVar = (b) list.get(list.size() - 1);
            for (int size = this.f13624b.size(); size <= i6; size++) {
                a aVar = this.f13623a;
                bVar = bVar.i(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.f13624b.add(bVar);
            }
        }
        return (b) this.f13624b.get(i6);
    }

    public void b(int[] iArr, int i6) {
        if (i6 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i6;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b a6 = a(i6);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] e6 = new b(this.f13623a, iArr2).j(i6, 1).b(a6)[1].e();
        int length2 = i6 - e6.length;
        for (int i7 = 0; i7 < length2; i7++) {
            iArr[length + i7] = 0;
        }
        System.arraycopy(e6, 0, iArr, length + length2, e6.length);
    }
}
