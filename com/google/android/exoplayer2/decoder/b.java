package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3576a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f3577b;

    /* renamed from: c  reason: collision with root package name */
    public int f3578c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f3579d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f3580e;

    /* renamed from: f  reason: collision with root package name */
    public int f3581f;

    /* renamed from: g  reason: collision with root package name */
    public int f3582g;

    /* renamed from: h  reason: collision with root package name */
    public int f3583h;

    /* renamed from: i  reason: collision with root package name */
    private final MediaCodec.CryptoInfo f3584i;

    /* renamed from: j  reason: collision with root package name */
    private final C0038b f3585j;

    /* renamed from: com.google.android.exoplayer2.decoder.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0038b {

        /* renamed from: a  reason: collision with root package name */
        private final MediaCodec.CryptoInfo f3586a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f3587b;

        private C0038b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f3586a = cryptoInfo;
            f.a();
            this.f3587b = e.a(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i6, int i7) {
            this.f3587b.set(i6, i7);
            this.f3586a.setPattern(this.f3587b);
        }
    }

    public b() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f3584i = cryptoInfo;
        this.f3585j = s0.f4673a >= 24 ? new C0038b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f3584i;
    }

    public void b(int i6) {
        if (i6 == 0) {
            return;
        }
        if (this.f3579d == null) {
            int[] iArr = new int[1];
            this.f3579d = iArr;
            this.f3584i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f3579d;
        iArr2[0] = iArr2[0] + i6;
    }

    public void c(int i6, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i7, int i8, int i9) {
        this.f3581f = i6;
        this.f3579d = iArr;
        this.f3580e = iArr2;
        this.f3577b = bArr;
        this.f3576a = bArr2;
        this.f3578c = i7;
        this.f3582g = i8;
        this.f3583h = i9;
        MediaCodec.CryptoInfo cryptoInfo = this.f3584i;
        cryptoInfo.numSubSamples = i6;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i7;
        if (s0.f4673a >= 24) {
            ((C0038b) com.google.android.exoplayer2.util.a.e(this.f3585j)).b(i8, i9);
        }
    }
}
