package org.slf4j.helpers;
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f12493d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private String f12494a;

    /* renamed from: b  reason: collision with root package name */
    private Throwable f12495b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f12496c;

    public a(String str) {
        this(str, null, null);
    }

    public String a() {
        return this.f12494a;
    }

    public Throwable b() {
        return this.f12495b;
    }

    public a(String str, Object[] objArr, Throwable th) {
        this.f12494a = str;
        this.f12495b = th;
        this.f12496c = objArr;
    }
}
