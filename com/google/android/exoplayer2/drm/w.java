package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import com.google.android.exoplayer2.drm.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class w implements z {
    @Override // com.google.android.exoplayer2.drm.z
    public void a() {
    }

    @Override // com.google.android.exoplayer2.drm.z
    public Class b() {
        return j0.class;
    }

    @Override // com.google.android.exoplayer2.drm.z
    public void c(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.z
    public Map d(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.z
    public void e(byte[] bArr) {
    }

    @Override // com.google.android.exoplayer2.drm.z
    public void f(z.b bVar) {
    }

    @Override // com.google.android.exoplayer2.drm.z
    public byte[] g(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.z
    public y h(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.z
    public z.d i() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.z
    public void j(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.z
    public z.a k(byte[] bArr, List list, int i6, HashMap hashMap) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.z
    public byte[] l() {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }
}
