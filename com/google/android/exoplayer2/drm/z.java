package com.google.android.exoplayer2.drm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public interface z {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f3730a;

        /* renamed from: b  reason: collision with root package name */
        private final String f3731b;

        public a(byte[] bArr, String str) {
            this.f3730a = bArr;
            this.f3731b = str;
        }

        public byte[] a() {
            return this.f3730a;
        }

        public String b() {
            return this.f3731b;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(z zVar, byte[] bArr, int i6, int i7, byte[] bArr2);
    }

    /* loaded from: classes.dex */
    public interface c {
        z a(UUID uuid);
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f3732a;

        /* renamed from: b  reason: collision with root package name */
        private final String f3733b;

        public d(byte[] bArr, String str) {
            this.f3732a = bArr;
            this.f3733b = str;
        }

        public byte[] a() {
            return this.f3732a;
        }

        public String b() {
            return this.f3733b;
        }
    }

    void a();

    Class b();

    void c(byte[] bArr, byte[] bArr2);

    Map d(byte[] bArr);

    void e(byte[] bArr);

    void f(b bVar);

    byte[] g(byte[] bArr, byte[] bArr2);

    y h(byte[] bArr);

    d i();

    void j(byte[] bArr);

    a k(byte[] bArr, List list, int i6, HashMap hashMap);

    byte[] l();
}
