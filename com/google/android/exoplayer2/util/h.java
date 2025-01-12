package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class h implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f4620a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Map f4621b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Set f4622c = Collections.emptySet();

    /* renamed from: d  reason: collision with root package name */
    private List f4623d = Collections.emptyList();

    public void a(Object obj) {
        synchronized (this.f4620a) {
            ArrayList arrayList = new ArrayList(this.f4623d);
            arrayList.add(obj);
            this.f4623d = Collections.unmodifiableList(arrayList);
            Integer num = (Integer) this.f4621b.get(obj);
            if (num == null) {
                HashSet hashSet = new HashSet(this.f4622c);
                hashSet.add(obj);
                this.f4622c = Collections.unmodifiableSet(hashSet);
            }
            this.f4621b.put(obj, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    public void b(Object obj) {
        synchronized (this.f4620a) {
            Integer num = (Integer) this.f4621b.get(obj);
            if (num == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f4623d);
            arrayList.remove(obj);
            this.f4623d = Collections.unmodifiableList(arrayList);
            if (num.intValue() == 1) {
                this.f4621b.remove(obj);
                HashSet hashSet = new HashSet(this.f4622c);
                hashSet.remove(obj);
                this.f4622c = Collections.unmodifiableSet(hashSet);
            } else {
                this.f4621b.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public Set elementSet() {
        Set set;
        synchronized (this.f4620a) {
            set = this.f4622c;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Iterator it;
        synchronized (this.f4620a) {
            it = this.f4623d.iterator();
        }
        return it;
    }
}
