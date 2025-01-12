package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes.dex */
public class h implements k5.a {

    /* renamed from: a  reason: collision with root package name */
    boolean f12501a = false;

    /* renamed from: b  reason: collision with root package name */
    final Map f12502b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final LinkedBlockingQueue f12503c = new LinkedBlockingQueue();

    @Override // k5.a
    public synchronized k5.b a(String str) {
        g gVar;
        gVar = (g) this.f12502b.get(str);
        if (gVar == null) {
            gVar = new g(str, this.f12503c, this.f12501a);
            this.f12502b.put(str, gVar);
        }
        return gVar;
    }

    public void b() {
        this.f12502b.clear();
        this.f12503c.clear();
    }

    public LinkedBlockingQueue c() {
        return this.f12503c;
    }

    public List d() {
        return new ArrayList(this.f12502b.values());
    }

    public void e() {
        this.f12501a = true;
    }
}
