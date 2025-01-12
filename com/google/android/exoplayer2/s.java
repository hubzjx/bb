package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.m0;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s implements r1 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4035a;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4038d;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4042h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4043i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4044j;

    /* renamed from: b  reason: collision with root package name */
    private int f4036b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f4037c = 5000;

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.exoplayer2.mediacodec.o f4039e = com.google.android.exoplayer2.mediacodec.o.f3910a;

    /* renamed from: f  reason: collision with root package name */
    private int f4040f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f4041g = 0;

    public s(Context context) {
        this.f4035a = context;
    }

    @Override // com.google.android.exoplayer2.r1
    public n1[] a(Handler handler, s2.u uVar, com.google.android.exoplayer2.audio.q qVar, e2.l lVar, n1.f fVar) {
        ArrayList arrayList = new ArrayList();
        h(this.f4035a, this.f4036b, this.f4039e, this.f4038d, handler, uVar, this.f4037c, arrayList);
        com.google.android.exoplayer2.audio.r c6 = c(this.f4035a, this.f4042h, this.f4043i, this.f4044j);
        if (c6 != null) {
            b(this.f4035a, this.f4036b, this.f4039e, this.f4038d, c6, handler, qVar, arrayList);
        }
        g(this.f4035a, lVar, handler.getLooper(), this.f4036b, arrayList);
        e(this.f4035a, fVar, handler.getLooper(), this.f4036b, arrayList);
        d(this.f4035a, this.f4036b, arrayList);
        f(this.f4035a, handler, this.f4036b, arrayList);
        return (n1[]) arrayList.toArray(new n1[0]);
    }

    protected void b(Context context, int i6, com.google.android.exoplayer2.mediacodec.o oVar, boolean z5, com.google.android.exoplayer2.audio.r rVar, Handler handler, com.google.android.exoplayer2.audio.q qVar, ArrayList arrayList) {
        int i7;
        int i8;
        com.google.android.exoplayer2.audio.b1 b1Var = new com.google.android.exoplayer2.audio.b1(context, oVar, z5, handler, qVar, rVar);
        b1Var.h0(this.f4040f);
        arrayList.add(b1Var);
        if (i6 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i6 == 2) {
            size--;
        }
        try {
            try {
                i7 = size + 1;
                try {
                    arrayList.add(size, (n1) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.q.class, com.google.android.exoplayer2.audio.r.class).newInstance(handler, qVar, rVar));
                    com.google.android.exoplayer2.util.n.f("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i7;
                    i7 = size;
                    try {
                        i8 = i7 + 1;
                        try {
                            arrayList.add(i7, (n1) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.q.class, com.google.android.exoplayer2.audio.r.class).newInstance(handler, qVar, rVar));
                            com.google.android.exoplayer2.util.n.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                        } catch (ClassNotFoundException unused2) {
                            i7 = i8;
                            i8 = i7;
                            arrayList.add(i8, (n1) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.q.class, com.google.android.exoplayer2.audio.r.class).newInstance(handler, qVar, rVar));
                            com.google.android.exoplayer2.util.n.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                        }
                    } catch (ClassNotFoundException unused3) {
                    }
                    arrayList.add(i8, (n1) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.q.class, com.google.android.exoplayer2.audio.r.class).newInstance(handler, qVar, rVar));
                    com.google.android.exoplayer2.util.n.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                }
            } catch (ClassNotFoundException unused4) {
            }
            try {
                i8 = i7 + 1;
                arrayList.add(i7, (n1) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.q.class, com.google.android.exoplayer2.audio.r.class).newInstance(handler, qVar, rVar));
                com.google.android.exoplayer2.util.n.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                try {
                    arrayList.add(i8, (n1) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.q.class, com.google.android.exoplayer2.audio.r.class).newInstance(handler, qVar, rVar));
                    com.google.android.exoplayer2.util.n.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                } catch (ClassNotFoundException unused5) {
                } catch (Exception e6) {
                    throw new RuntimeException("Error instantiating FFmpeg extension", e6);
                }
            } catch (Exception e7) {
                throw new RuntimeException("Error instantiating FLAC extension", e7);
            }
        } catch (Exception e8) {
            throw new RuntimeException("Error instantiating Opus extension", e8);
        }
    }

    protected com.google.android.exoplayer2.audio.r c(Context context, boolean z5, boolean z6, boolean z7) {
        return new com.google.android.exoplayer2.audio.m0(com.google.android.exoplayer2.audio.f.b(context), new m0.e(new com.google.android.exoplayer2.audio.h[0]), z5, z6, z7);
    }

    protected void d(Context context, int i6, ArrayList arrayList) {
        arrayList.add(new t2.a());
    }

    protected void e(Context context, n1.f fVar, Looper looper, int i6, ArrayList arrayList) {
        arrayList.add(new n1.g(fVar, looper));
    }

    protected void f(Context context, Handler handler, int i6, ArrayList arrayList) {
    }

    protected void g(Context context, e2.l lVar, Looper looper, int i6, ArrayList arrayList) {
        arrayList.add(new e2.m(lVar, looper));
    }

    protected void h(Context context, int i6, com.google.android.exoplayer2.mediacodec.o oVar, boolean z5, Handler handler, s2.u uVar, long j6, ArrayList arrayList) {
        int i7;
        s2.h hVar = new s2.h(context, oVar, j6, z5, handler, uVar, 50);
        hVar.h0(this.f4041g);
        arrayList.add(hVar);
        if (i6 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i6 == 2) {
            size--;
        }
        try {
            try {
                i7 = size + 1;
                try {
                    arrayList.add(size, (n1) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, s2.u.class, Integer.TYPE).newInstance(Long.valueOf(j6), handler, uVar, 50));
                    com.google.android.exoplayer2.util.n.f("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i7;
                    i7 = size;
                    arrayList.add(i7, (n1) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, s2.u.class, Integer.TYPE).newInstance(Long.valueOf(j6), handler, uVar, 50));
                    com.google.android.exoplayer2.util.n.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
                }
            } catch (ClassNotFoundException unused2) {
            }
            try {
                arrayList.add(i7, (n1) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, s2.u.class, Integer.TYPE).newInstance(Long.valueOf(j6), handler, uVar, 50));
                com.google.android.exoplayer2.util.n.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
            } catch (ClassNotFoundException unused3) {
            } catch (Exception e6) {
                throw new RuntimeException("Error instantiating AV1 extension", e6);
            }
        } catch (Exception e7) {
            throw new RuntimeException("Error instantiating VP9 extension", e7);
        }
    }
}
