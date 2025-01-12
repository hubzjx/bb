package a2;

import a2.j;
import android.net.Uri;
import com.google.android.exoplayer2.s0;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public final long f97a;

    /* renamed from: b  reason: collision with root package name */
    public final s0 f98b;

    /* renamed from: c  reason: collision with root package name */
    public final String f99c;

    /* renamed from: d  reason: collision with root package name */
    public final long f100d;

    /* renamed from: e  reason: collision with root package name */
    public final List f101e;

    /* renamed from: f  reason: collision with root package name */
    private final h f102f;

    /* loaded from: classes.dex */
    public static class b extends i implements z1.d {

        /* renamed from: g  reason: collision with root package name */
        private final j.a f103g;

        public b(long j6, s0 s0Var, String str, j.a aVar, List list) {
            super(j6, s0Var, str, aVar, list);
            this.f103g = aVar;
        }

        @Override // z1.d
        public long a(long j6, long j7) {
            return this.f103g.f(j6, j7);
        }

        @Override // z1.d
        public long b(long j6) {
            return this.f103g.g(j6);
        }

        @Override // z1.d
        public long c(long j6, long j7) {
            return this.f103g.e(j6, j7);
        }

        @Override // z1.d
        public h d(long j6) {
            return this.f103g.h(this, j6);
        }

        @Override // z1.d
        public boolean e() {
            return this.f103g.i();
        }

        @Override // z1.d
        public long f() {
            return this.f103g.c();
        }

        @Override // z1.d
        public int g(long j6) {
            return this.f103g.d(j6);
        }

        @Override // a2.i
        public String h() {
            return null;
        }

        @Override // a2.i
        public z1.d i() {
            return this;
        }

        @Override // a2.i
        public h j() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends i {

        /* renamed from: g  reason: collision with root package name */
        public final Uri f104g;

        /* renamed from: h  reason: collision with root package name */
        public final long f105h;

        /* renamed from: i  reason: collision with root package name */
        private final String f106i;

        /* renamed from: j  reason: collision with root package name */
        private final h f107j;

        /* renamed from: k  reason: collision with root package name */
        private final k f108k;

        public c(long j6, s0 s0Var, String str, j.e eVar, List list, String str2, long j7) {
            super(j6, s0Var, str, eVar, list);
            this.f104g = Uri.parse(str);
            h c6 = eVar.c();
            this.f107j = c6;
            this.f106i = str2;
            this.f105h = j7;
            this.f108k = c6 != null ? null : new k(new h(null, 0L, j7));
        }

        @Override // a2.i
        public String h() {
            return this.f106i;
        }

        @Override // a2.i
        public z1.d i() {
            return this.f108k;
        }

        @Override // a2.i
        public h j() {
            return this.f107j;
        }
    }

    private i(long j6, s0 s0Var, String str, j jVar, List list) {
        this.f97a = j6;
        this.f98b = s0Var;
        this.f99c = str;
        this.f101e = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f102f = jVar.a(this);
        this.f100d = jVar.b();
    }

    public static i l(long j6, s0 s0Var, String str, j jVar, List list) {
        return m(j6, s0Var, str, jVar, list, null);
    }

    public static i m(long j6, s0 s0Var, String str, j jVar, List list, String str2) {
        if (jVar instanceof j.e) {
            return new c(j6, s0Var, str, (j.e) jVar, list, str2, -1L);
        }
        if (jVar instanceof j.a) {
            return new b(j6, s0Var, str, (j.a) jVar, list);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    public abstract String h();

    public abstract z1.d i();

    public abstract h j();

    public h k() {
        return this.f102f;
    }
}
