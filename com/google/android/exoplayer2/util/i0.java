package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
final class i0 implements l {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f4631a;

    public i0(Handler handler) {
        this.f4631a = handler;
    }

    @Override // com.google.android.exoplayer2.util.l
    public Message a(int i6, int i7, int i8) {
        return this.f4631a.obtainMessage(i6, i7, i8);
    }

    @Override // com.google.android.exoplayer2.util.l
    public boolean b(int i6) {
        return this.f4631a.sendEmptyMessage(i6);
    }

    @Override // com.google.android.exoplayer2.util.l
    public Message c(int i6, int i7, int i8, Object obj) {
        return this.f4631a.obtainMessage(i6, i7, i8, obj);
    }

    @Override // com.google.android.exoplayer2.util.l
    public boolean d(int i6, long j6) {
        return this.f4631a.sendEmptyMessageAtTime(i6, j6);
    }

    @Override // com.google.android.exoplayer2.util.l
    public void e(int i6) {
        this.f4631a.removeMessages(i6);
    }

    @Override // com.google.android.exoplayer2.util.l
    public Message f(int i6, Object obj) {
        return this.f4631a.obtainMessage(i6, obj);
    }

    @Override // com.google.android.exoplayer2.util.l
    public Message g(int i6) {
        return this.f4631a.obtainMessage(i6);
    }
}
