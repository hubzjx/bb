package com.google.android.exoplayer2.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
/* loaded from: classes.dex */
final class s {

    /* renamed from: a  reason: collision with root package name */
    private final a f3501a;

    /* renamed from: b  reason: collision with root package name */
    private int f3502b;

    /* renamed from: c  reason: collision with root package name */
    private long f3503c;

    /* renamed from: d  reason: collision with root package name */
    private long f3504d;

    /* renamed from: e  reason: collision with root package name */
    private long f3505e;

    /* renamed from: f  reason: collision with root package name */
    private long f3506f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final AudioTrack f3507a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioTimestamp f3508b = new AudioTimestamp();

        /* renamed from: c  reason: collision with root package name */
        private long f3509c;

        /* renamed from: d  reason: collision with root package name */
        private long f3510d;

        /* renamed from: e  reason: collision with root package name */
        private long f3511e;

        public a(AudioTrack audioTrack) {
            this.f3507a = audioTrack;
        }

        public long a() {
            return this.f3511e;
        }

        public long b() {
            return this.f3508b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f3507a.getTimestamp(this.f3508b);
            if (timestamp) {
                long j6 = this.f3508b.framePosition;
                if (this.f3510d > j6) {
                    this.f3509c++;
                }
                this.f3510d = j6;
                this.f3511e = j6 + (this.f3509c << 32);
            }
            return timestamp;
        }
    }

    public s(AudioTrack audioTrack) {
        if (com.google.android.exoplayer2.util.s0.f4673a >= 19) {
            this.f3501a = new a(audioTrack);
            g();
            return;
        }
        this.f3501a = null;
        h(3);
    }

    private void h(int i6) {
        this.f3502b = i6;
        long j6 = 10000;
        if (i6 == 0) {
            this.f3505e = 0L;
            this.f3506f = -1L;
            this.f3503c = System.nanoTime() / 1000;
        } else if (i6 != 1) {
            if (i6 == 2 || i6 == 3) {
                j6 = 10000000;
            } else if (i6 != 4) {
                throw new IllegalStateException();
            } else {
                j6 = 500000;
            }
        }
        this.f3504d = j6;
    }

    public void a() {
        if (this.f3502b == 4) {
            g();
        }
    }

    public long b() {
        a aVar = this.f3501a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    public long c() {
        a aVar = this.f3501a;
        if (aVar != null) {
            return aVar.b();
        }
        return -9223372036854775807L;
    }

    public boolean d() {
        return this.f3502b == 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
        if (r0 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
        if (r0 == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(long j6) {
        a aVar = this.f3501a;
        if (aVar == null || j6 - this.f3505e < this.f3504d) {
            return false;
        }
        this.f3505e = j6;
        boolean c6 = aVar.c();
        int i6 = this.f3502b;
        if (i6 != 0) {
            if (i6 == 1) {
                if (c6) {
                    if (this.f3501a.a() > this.f3506f) {
                        h(2);
                    }
                }
                g();
            } else if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 4) {
                        throw new IllegalStateException();
                    }
                }
            }
        } else if (c6) {
            if (this.f3501a.b() < this.f3503c) {
                return false;
            }
            this.f3506f = this.f3501a.a();
            h(1);
        } else if (j6 - this.f3503c > 500000) {
            h(3);
        }
        return c6;
    }

    public void f() {
        h(4);
    }

    public void g() {
        if (this.f3501a != null) {
            h(0);
        }
    }
}
