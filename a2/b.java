package a2;

import android.net.Uri;
import com.google.android.exoplayer2.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements u1.c {

    /* renamed from: a  reason: collision with root package name */
    public final long f51a;

    /* renamed from: b  reason: collision with root package name */
    public final long f52b;

    /* renamed from: c  reason: collision with root package name */
    public final long f53c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f54d;

    /* renamed from: e  reason: collision with root package name */
    public final long f55e;

    /* renamed from: f  reason: collision with root package name */
    public final long f56f;

    /* renamed from: g  reason: collision with root package name */
    public final long f57g;

    /* renamed from: h  reason: collision with root package name */
    public final long f58h;

    /* renamed from: i  reason: collision with root package name */
    public final m f59i;

    /* renamed from: j  reason: collision with root package name */
    public final Uri f60j;

    /* renamed from: k  reason: collision with root package name */
    public final g f61k;

    /* renamed from: l  reason: collision with root package name */
    private final List f62l;

    public b(long j6, long j7, long j8, boolean z5, long j9, long j10, long j11, long j12, g gVar, m mVar, Uri uri, List list) {
        this.f51a = j6;
        this.f52b = j7;
        this.f53c = j8;
        this.f54d = z5;
        this.f55e = j9;
        this.f56f = j10;
        this.f57g = j11;
        this.f58h = j12;
        this.f61k = gVar;
        this.f59i = mVar;
        this.f60j = uri;
        this.f62l = list == null ? Collections.emptyList() : list;
    }

    private static ArrayList c(List list, LinkedList linkedList) {
        u1.e eVar = (u1.e) linkedList.poll();
        int i6 = eVar.f13428a;
        ArrayList arrayList = new ArrayList();
        do {
            int i7 = eVar.f13429b;
            a aVar = (a) list.get(i7);
            List list2 = aVar.f47c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add((i) list2.get(eVar.f13430c));
                eVar = (u1.e) linkedList.poll();
                if (eVar.f13428a != i6) {
                    break;
                }
            } while (eVar.f13429b == i7);
            arrayList.add(new a(aVar.f45a, aVar.f46b, arrayList2, aVar.f48d, aVar.f49e, aVar.f50f));
        } while (eVar.f13428a == i6);
        linkedList.addFirst(eVar);
        return arrayList;
    }

    @Override // u1.c
    /* renamed from: b */
    public final b a(List list) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new u1.e(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j6 = 0;
        int i6 = 0;
        while (true) {
            if (i6 >= e()) {
                break;
            }
            if (((u1.e) linkedList.peek()).f13428a != i6) {
                long f6 = f(i6);
                if (f6 != -9223372036854775807L) {
                    j6 += f6;
                }
            } else {
                f d6 = d(i6);
                arrayList.add(new f(d6.f83a, d6.f84b - j6, c(d6.f85c, linkedList), d6.f86d));
            }
            i6++;
        }
        long j7 = this.f52b;
        return new b(this.f51a, j7 != -9223372036854775807L ? j7 - j6 : -9223372036854775807L, this.f53c, this.f54d, this.f55e, this.f56f, this.f57g, this.f58h, this.f61k, this.f59i, this.f60j, arrayList);
    }

    public final f d(int i6) {
        return (f) this.f62l.get(i6);
    }

    public final int e() {
        return this.f62l.size();
    }

    public final long f(int i6) {
        long j6;
        if (i6 == this.f62l.size() - 1) {
            j6 = this.f52b;
            if (j6 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
        } else {
            j6 = ((f) this.f62l.get(i6 + 1)).f84b;
        }
        return j6 - ((f) this.f62l.get(i6)).f84b;
    }

    public final long g(int i6) {
        return p.a(f(i6));
    }
}
