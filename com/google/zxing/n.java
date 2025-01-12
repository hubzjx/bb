package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final String f5841a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f5842b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5843c;

    /* renamed from: d  reason: collision with root package name */
    private p[] f5844d;

    /* renamed from: e  reason: collision with root package name */
    private final a f5845e;

    /* renamed from: f  reason: collision with root package name */
    private Map f5846f;

    /* renamed from: g  reason: collision with root package name */
    private final long f5847g;

    public n(String str, byte[] bArr, int i6, p[] pVarArr, a aVar, long j6) {
        this.f5841a = str;
        this.f5842b = bArr;
        this.f5843c = i6;
        this.f5844d = pVarArr;
        this.f5845e = aVar;
        this.f5846f = null;
        this.f5847g = j6;
    }

    public String a() {
        return this.f5841a;
    }

    public void b(o oVar, Object obj) {
        if (this.f5846f == null) {
            this.f5846f = new EnumMap(o.class);
        }
        this.f5846f.put(oVar, obj);
    }

    public String toString() {
        return this.f5841a;
    }

    public n(String str, byte[] bArr, p[] pVarArr, a aVar) {
        this(str, bArr, pVarArr, aVar, System.currentTimeMillis());
    }

    public n(String str, byte[] bArr, p[] pVarArr, a aVar, long j6) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, pVarArr, aVar, j6);
    }
}
