package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import q2.i0;
/* loaded from: classes.dex */
class a implements q2.l {

    /* renamed from: a  reason: collision with root package name */
    private final q2.l f4252a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f4253b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f4254c;

    /* renamed from: d  reason: collision with root package name */
    private CipherInputStream f4255d;

    public a(q2.l lVar, byte[] bArr, byte[] bArr2) {
        this.f4252a = lVar;
        this.f4253b = bArr;
        this.f4254c = bArr2;
    }

    @Override // q2.l
    public final long b(q2.o oVar) {
        try {
            Cipher q5 = q();
            try {
                q5.init(2, new SecretKeySpec(this.f4253b, "AES"), new IvParameterSpec(this.f4254c));
                q2.n nVar = new q2.n(this.f4252a, oVar);
                this.f4255d = new CipherInputStream(nVar, q5);
                nVar.b();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e6) {
                throw new RuntimeException(e6);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e7) {
            throw new RuntimeException(e7);
        }
    }

    @Override // q2.l
    public void close() {
        if (this.f4255d != null) {
            this.f4255d = null;
            this.f4252a.close();
        }
    }

    @Override // q2.l
    public final Map f() {
        return this.f4252a.f();
    }

    @Override // q2.l
    public final void i(i0 i0Var) {
        com.google.android.exoplayer2.util.a.e(i0Var);
        this.f4252a.i(i0Var);
    }

    @Override // q2.l
    public final Uri k() {
        return this.f4252a.k();
    }

    protected Cipher q() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // q2.h
    public final int read(byte[] bArr, int i6, int i7) {
        com.google.android.exoplayer2.util.a.e(this.f4255d);
        int read = this.f4255d.read(bArr, i6, i7);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
