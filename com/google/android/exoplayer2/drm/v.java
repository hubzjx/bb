package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.drm.m;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.s0;
/* loaded from: classes.dex */
public interface v {

    /* renamed from: a  reason: collision with root package name */
    public static final v f3728a = new a();

    /* loaded from: classes.dex */
    class a implements v {
        a() {
        }

        @Override // com.google.android.exoplayer2.drm.v
        public /* synthetic */ void a() {
            u.b(this);
        }

        @Override // com.google.android.exoplayer2.drm.v
        public /* synthetic */ void b() {
            u.a(this);
        }

        @Override // com.google.android.exoplayer2.drm.v
        public m c(Looper looper, t.a aVar, s0 s0Var) {
            if (s0Var.f4059q == null) {
                return null;
            }
            return new x(new m.a(new i0(1)));
        }

        @Override // com.google.android.exoplayer2.drm.v
        public Class d(s0 s0Var) {
            if (s0Var.f4059q != null) {
                return j0.class;
            }
            return null;
        }
    }

    void a();

    void b();

    m c(Looper looper, t.a aVar, s0 s0Var);

    Class d(s0 s0Var);
}
