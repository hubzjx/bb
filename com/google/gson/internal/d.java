package com.google.gson.internal;

import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class d implements q, Cloneable {

    /* renamed from: g  reason: collision with root package name */
    public static final d f5790g = new d();

    /* renamed from: d  reason: collision with root package name */
    private boolean f5794d;

    /* renamed from: a  reason: collision with root package name */
    private double f5791a = -1.0d;

    /* renamed from: b  reason: collision with root package name */
    private int f5792b = 136;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5793c = true;

    /* renamed from: e  reason: collision with root package name */
    private List f5795e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    private List f5796f = Collections.emptyList();

    /* loaded from: classes.dex */
    class a extends p {

        /* renamed from: a  reason: collision with root package name */
        private p f5797a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f5798b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f5799c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.gson.d f5800d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ p3.a f5801e;

        a(boolean z5, boolean z6, com.google.gson.d dVar, p3.a aVar) {
            this.f5798b = z5;
            this.f5799c = z6;
            this.f5800d = dVar;
            this.f5801e = aVar;
        }

        private p e() {
            p pVar = this.f5797a;
            if (pVar != null) {
                return pVar;
            }
            p m5 = this.f5800d.m(d.this, this.f5801e);
            this.f5797a = m5;
            return m5;
        }

        @Override // com.google.gson.p
        public Object b(JsonReader jsonReader) {
            if (this.f5798b) {
                jsonReader.skipValue();
                return null;
            }
            return e().b(jsonReader);
        }

        @Override // com.google.gson.p
        public void d(JsonWriter jsonWriter, Object obj) {
            if (this.f5799c) {
                jsonWriter.nullValue();
            } else {
                e().d(jsonWriter, obj);
            }
        }
    }

    private boolean d(Class cls) {
        if (this.f5791a == -1.0d || l((k3.d) cls.getAnnotation(k3.d.class), (k3.e) cls.getAnnotation(k3.e.class))) {
            return (!this.f5793c && h(cls)) || g(cls);
        }
        return true;
    }

    private boolean e(Class cls, boolean z5) {
        Iterator it = (z5 ? this.f5795e : this.f5796f).iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
        return false;
    }

    private boolean g(Class cls) {
        return (Enum.class.isAssignableFrom(cls) || i(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    private boolean h(Class cls) {
        return cls.isMemberClass() && !i(cls);
    }

    private boolean i(Class cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean j(k3.d dVar) {
        return dVar == null || dVar.value() <= this.f5791a;
    }

    private boolean k(k3.e eVar) {
        return eVar == null || eVar.value() > this.f5791a;
    }

    private boolean l(k3.d dVar, k3.e eVar) {
        return j(dVar) && k(eVar);
    }

    @Override // com.google.gson.q
    public p a(com.google.gson.d dVar, p3.a aVar) {
        Class c6 = aVar.c();
        boolean d6 = d(c6);
        boolean z5 = d6 || e(c6, true);
        boolean z6 = d6 || e(c6, false);
        if (z5 || z6) {
            return new a(z6, z5, dVar, aVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e6) {
            throw new AssertionError(e6);
        }
    }

    public boolean c(Class cls, boolean z5) {
        return d(cls) || e(cls, z5);
    }

    public boolean f(Field field, boolean z5) {
        k3.a aVar;
        if ((this.f5792b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f5791a == -1.0d || l((k3.d) field.getAnnotation(k3.d.class), (k3.e) field.getAnnotation(k3.e.class))) && !field.isSynthetic()) {
            if (!this.f5794d || ((aVar = (k3.a) field.getAnnotation(k3.a.class)) != null && (!z5 ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.f5793c || !h(field.getType())) && !g(field.getType())) {
                    List list = z5 ? this.f5795e : this.f5796f;
                    if (list.isEmpty()) {
                        return false;
                    }
                    new com.google.gson.a(field);
                    Iterator it = list.iterator();
                    if (it.hasNext()) {
                        android.support.v4.media.a.a(it.next());
                        throw null;
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }
}
