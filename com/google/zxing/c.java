package com.google.zxing;

import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f5831a;

    /* renamed from: b  reason: collision with root package name */
    private s3.b f5832b;

    public c(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f5831a = bVar;
    }

    public s3.b a() {
        if (this.f5832b == null) {
            this.f5832b = this.f5831a.a();
        }
        return this.f5832b;
    }

    public String toString() {
        try {
            return a().toString();
        } catch (k unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }
}
