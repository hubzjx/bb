package r2;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f12980a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12981b;

    /* renamed from: c  reason: collision with root package name */
    private final TreeSet f12982c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList f12983d;

    /* renamed from: e  reason: collision with root package name */
    private p f12984e;

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f12985a;

        /* renamed from: b  reason: collision with root package name */
        public final long f12986b;

        public a(long j6, long j7) {
            this.f12985a = j6;
            this.f12986b = j7;
        }

        public boolean a(long j6, long j7) {
            long j8 = this.f12986b;
            if (j8 == -1) {
                return j6 >= this.f12985a;
            } else if (j7 == -1) {
                return false;
            } else {
                long j9 = this.f12985a;
                return j9 <= j6 && j6 + j7 <= j9 + j8;
            }
        }

        public boolean b(long j6, long j7) {
            long j8 = this.f12985a;
            if (j8 > j6) {
                return j7 == -1 || j6 + j7 > j8;
            }
            long j9 = this.f12986b;
            return j9 == -1 || j8 + j9 > j6;
        }
    }

    public k(int i6, String str) {
        this(i6, str, p.f13007c);
    }

    public void a(t tVar) {
        this.f12982c.add(tVar);
    }

    public boolean b(o oVar) {
        p pVar = this.f12984e;
        p e6 = pVar.e(oVar);
        this.f12984e = e6;
        return !e6.equals(pVar);
    }

    public p c() {
        return this.f12984e;
    }

    public t d(long j6, long j7) {
        t h6 = t.h(this.f12981b, j6);
        t tVar = (t) this.f12982c.floor(h6);
        if (tVar == null || tVar.f12975b + tVar.f12976c <= j6) {
            t tVar2 = (t) this.f12982c.ceiling(h6);
            if (tVar2 != null) {
                long j8 = tVar2.f12975b - j6;
                j7 = j7 == -1 ? j8 : Math.min(j8, j7);
            }
            return t.g(this.f12981b, j6, j7);
        }
        return tVar;
    }

    public TreeSet e() {
        return this.f12982c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f12980a == kVar.f12980a && this.f12981b.equals(kVar.f12981b) && this.f12982c.equals(kVar.f12982c) && this.f12984e.equals(kVar.f12984e);
    }

    public boolean f() {
        return this.f12982c.isEmpty();
    }

    public boolean g(long j6, long j7) {
        for (int i6 = 0; i6 < this.f12983d.size(); i6++) {
            if (((a) this.f12983d.get(i6)).a(j6, j7)) {
                return true;
            }
        }
        return false;
    }

    public boolean h() {
        return this.f12983d.isEmpty();
    }

    public int hashCode() {
        return (((this.f12980a * 31) + this.f12981b.hashCode()) * 31) + this.f12984e.hashCode();
    }

    public boolean i(long j6, long j7) {
        for (int i6 = 0; i6 < this.f12983d.size(); i6++) {
            if (((a) this.f12983d.get(i6)).b(j6, j7)) {
                return false;
            }
        }
        this.f12983d.add(new a(j6, j7));
        return true;
    }

    public boolean j(j jVar) {
        if (this.f12982c.remove(jVar)) {
            File file = jVar.f12978e;
            if (file != null) {
                file.delete();
                return true;
            }
            return true;
        }
        return false;
    }

    public t k(t tVar, long j6, boolean z5) {
        com.google.android.exoplayer2.util.a.g(this.f12982c.remove(tVar));
        File file = (File) com.google.android.exoplayer2.util.a.e(tVar.f12978e);
        if (z5) {
            File i6 = t.i((File) com.google.android.exoplayer2.util.a.e(file.getParentFile()), this.f12980a, tVar.f12975b, j6);
            if (file.renameTo(i6)) {
                file = i6;
            } else {
                String valueOf = String.valueOf(file);
                String valueOf2 = String.valueOf(i6);
                StringBuilder sb = new StringBuilder(valueOf.length() + 21 + valueOf2.length());
                sb.append("Failed to rename ");
                sb.append(valueOf);
                sb.append(" to ");
                sb.append(valueOf2);
                com.google.android.exoplayer2.util.n.h("CachedContent", sb.toString());
            }
        }
        t d6 = tVar.d(file, j6);
        this.f12982c.add(d6);
        return d6;
    }

    public void l(long j6) {
        for (int i6 = 0; i6 < this.f12983d.size(); i6++) {
            if (((a) this.f12983d.get(i6)).f12985a == j6) {
                this.f12983d.remove(i6);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public k(int i6, String str, p pVar) {
        this.f12980a = i6;
        this.f12981b = str;
        this.f12984e = pVar;
        this.f12982c = new TreeSet();
        this.f12983d = new ArrayList();
    }
}
