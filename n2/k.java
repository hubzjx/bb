package n2;

import com.google.android.exoplayer2.util.s0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
final class k implements e2.f {

    /* renamed from: a  reason: collision with root package name */
    private final List f12249a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f12250b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f12251c;

    public k(List list) {
        this.f12249a = Collections.unmodifiableList(new ArrayList(list));
        this.f12250b = new long[list.size() * 2];
        for (int i6 = 0; i6 < list.size(); i6++) {
            e eVar = (e) list.get(i6);
            int i7 = i6 * 2;
            long[] jArr = this.f12250b;
            jArr[i7] = eVar.f12220b;
            jArr[i7 + 1] = eVar.f12221c;
        }
        long[] jArr2 = this.f12250b;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f12251c = copyOf;
        Arrays.sort(copyOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int f(e eVar, e eVar2) {
        return Long.compare(eVar.f12220b, eVar2.f12220b);
    }

    @Override // e2.f
    public int a(long j6) {
        int e6 = s0.e(this.f12251c, j6, false, false);
        if (e6 < this.f12251c.length) {
            return e6;
        }
        return -1;
    }

    @Override // e2.f
    public long b(int i6) {
        com.google.android.exoplayer2.util.a.a(i6 >= 0);
        com.google.android.exoplayer2.util.a.a(i6 < this.f12251c.length);
        return this.f12251c[i6];
    }

    @Override // e2.f
    public List c(long j6) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i6 = 0; i6 < this.f12249a.size(); i6++) {
            long[] jArr = this.f12250b;
            int i7 = i6 * 2;
            if (jArr[i7] <= j6 && j6 < jArr[i7 + 1]) {
                e eVar = (e) this.f12249a.get(i6);
                e2.b bVar = eVar.f12219a;
                if (bVar.f9439d == -3.4028235E38f) {
                    arrayList2.add(eVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: n2.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int f6;
                f6 = k.f((e) obj, (e) obj2);
                return f6;
            }
        });
        for (int i8 = 0; i8 < arrayList2.size(); i8++) {
            arrayList.add(((e) arrayList2.get(i8)).f12219a.a().h((-1) - i8, 1).a());
        }
        return arrayList;
    }

    @Override // e2.f
    public int d() {
        return this.f12251c.length;
    }
}
