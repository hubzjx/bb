package com.google.android.exoplayer2;

import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.y1;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class n implements j1 {

    /* renamed from: a  reason: collision with root package name */
    protected final y1.c f3922a = new y1.c();

    /* loaded from: classes.dex */
    protected static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final j1.a f3923a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3924b;

        public a(j1.a aVar) {
            this.f3923a = aVar;
        }

        public void a(b bVar) {
            if (this.f3924b) {
                return;
            }
            bVar.a(this.f3923a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            return this.f3923a.equals(((a) obj).f3923a);
        }

        public int hashCode() {
            return this.f3923a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface b {
        void a(j1.a aVar);
    }

    public final long l() {
        y1 i6 = i();
        if (i6.p()) {
            return -9223372036854775807L;
        }
        return i6.m(j(), this.f3922a).c();
    }

    public final void m(long j6) {
        d(j(), j6);
    }

    public void n(w0 w0Var) {
        o(Collections.singletonList(w0Var));
    }

    public void o(List list) {
        g(list, true);
    }
}
