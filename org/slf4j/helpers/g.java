package org.slf4j.helpers;

import java.util.Queue;
/* loaded from: classes.dex */
public class g implements k5.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f12497a;

    /* renamed from: b  reason: collision with root package name */
    private volatile k5.b f12498b;

    /* renamed from: c  reason: collision with root package name */
    private Queue f12499c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f12500d;

    public g(String str, Queue queue, boolean z5) {
        this.f12497a = str;
        this.f12499c = queue;
        this.f12500d = z5;
    }

    public String a() {
        return this.f12497a;
    }

    public void b(k5.b bVar) {
        this.f12498b = bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f12497a.equals(((g) obj).f12497a);
    }

    public int hashCode() {
        return this.f12497a.hashCode();
    }
}
