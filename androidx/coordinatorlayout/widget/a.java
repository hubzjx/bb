package androidx.coordinatorlayout.widget;

import d0.f;
import d0.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final f f1550a = new g(10);

    /* renamed from: b  reason: collision with root package name */
    private final l.g f1551b = new l.g();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList f1552c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet f1553d = new HashSet();

    private void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f1551b.get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i6 = 0; i6 < size; i6++) {
                e(arrayList2.get(i6), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    private ArrayList f() {
        ArrayList arrayList = (ArrayList) this.f1550a.b();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    private void j(ArrayList arrayList) {
        arrayList.clear();
        this.f1550a.a(arrayList);
    }

    public void a(Object obj, Object obj2) {
        if (!this.f1551b.containsKey(obj) || !this.f1551b.containsKey(obj2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = (ArrayList) this.f1551b.get(obj);
        if (arrayList == null) {
            arrayList = f();
            this.f1551b.put(obj, arrayList);
        }
        arrayList.add(obj2);
    }

    public void b(Object obj) {
        if (this.f1551b.containsKey(obj)) {
            return;
        }
        this.f1551b.put(obj, null);
    }

    public void c() {
        int size = this.f1551b.size();
        for (int i6 = 0; i6 < size; i6++) {
            ArrayList arrayList = (ArrayList) this.f1551b.m(i6);
            if (arrayList != null) {
                j(arrayList);
            }
        }
        this.f1551b.clear();
    }

    public boolean d(Object obj) {
        return this.f1551b.containsKey(obj);
    }

    public List g(Object obj) {
        int size = this.f1551b.size();
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < size; i6++) {
            ArrayList arrayList2 = (ArrayList) this.f1551b.m(i6);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1551b.i(i6));
            }
        }
        return arrayList;
    }

    public ArrayList h() {
        this.f1552c.clear();
        this.f1553d.clear();
        int size = this.f1551b.size();
        for (int i6 = 0; i6 < size; i6++) {
            e(this.f1551b.i(i6), this.f1552c, this.f1553d);
        }
        return this.f1552c;
    }

    public boolean i(Object obj) {
        int size = this.f1551b.size();
        for (int i6 = 0; i6 < size; i6++) {
            ArrayList arrayList = (ArrayList) this.f1551b.m(i6);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }
}
