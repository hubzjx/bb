package a2;

import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f83a;

    /* renamed from: b  reason: collision with root package name */
    public final long f84b;

    /* renamed from: c  reason: collision with root package name */
    public final List f85c;

    /* renamed from: d  reason: collision with root package name */
    public final List f86d;

    /* renamed from: e  reason: collision with root package name */
    public final d f87e;

    public f(String str, long j6, List list, List list2) {
        this(str, j6, list, list2, null);
    }

    public int a(int i6) {
        int size = this.f85c.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (((a) this.f85c.get(i7)).f46b == i6) {
                return i7;
            }
        }
        return -1;
    }

    public f(String str, long j6, List list, List list2, d dVar) {
        this.f83a = str;
        this.f84b = j6;
        this.f85c = Collections.unmodifiableList(list);
        this.f86d = Collections.unmodifiableList(list2);
        this.f87e = dVar;
    }
}
