package f2;

import com.google.android.exoplayer2.decoder.k;
import com.google.android.exoplayer2.util.s0;
import e2.g;
import e2.j;
import e2.k;
import f2.e;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class e implements g {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque f9871a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque f9872b;

    /* renamed from: c  reason: collision with root package name */
    private final PriorityQueue f9873c;

    /* renamed from: d  reason: collision with root package name */
    private b f9874d;

    /* renamed from: e  reason: collision with root package name */
    private long f9875e;

    /* renamed from: f  reason: collision with root package name */
    private long f9876f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends j implements Comparable {

        /* renamed from: k  reason: collision with root package name */
        private long f9877k;

        private b() {
        }

        @Override // java.lang.Comparable
        /* renamed from: m */
        public int compareTo(b bVar) {
            if (isEndOfStream() != bVar.isEndOfStream()) {
                return isEndOfStream() ? 1 : -1;
            }
            long j6 = this.f3602d - bVar.f3602d;
            if (j6 == 0) {
                j6 = this.f9877k - bVar.f9877k;
                if (j6 == 0) {
                    return 0;
                }
            }
            return j6 > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends k {

        /* renamed from: c  reason: collision with root package name */
        private k.a f9878c;

        public c(k.a aVar) {
            this.f9878c = aVar;
        }

        @Override // com.google.android.exoplayer2.decoder.k
        public final void release() {
            this.f9878c.a(this);
        }
    }

    public e() {
        for (int i6 = 0; i6 < 10; i6++) {
            this.f9871a.add(new b());
        }
        this.f9872b = new ArrayDeque();
        for (int i7 = 0; i7 < 2; i7++) {
            this.f9872b.add(new c(new k.a() { // from class: f2.d
                @Override // com.google.android.exoplayer2.decoder.k.a
                public final void a(com.google.android.exoplayer2.decoder.k kVar) {
                    e.this.o((e.c) kVar);
                }
            }));
        }
        this.f9873c = new PriorityQueue();
    }

    private void n(b bVar) {
        bVar.clear();
        this.f9871a.add(bVar);
    }

    @Override // com.google.android.exoplayer2.decoder.g
    public void a() {
    }

    @Override // e2.g
    public void b(long j6) {
        this.f9875e = j6;
    }

    protected abstract e2.f f();

    @Override // com.google.android.exoplayer2.decoder.g
    public void flush() {
        this.f9876f = 0L;
        this.f9875e = 0L;
        while (!this.f9873c.isEmpty()) {
            n((b) s0.j((b) this.f9873c.poll()));
        }
        b bVar = this.f9874d;
        if (bVar != null) {
            n(bVar);
            this.f9874d = null;
        }
    }

    protected abstract void g(j jVar);

    @Override // com.google.android.exoplayer2.decoder.g
    /* renamed from: h */
    public j e() {
        com.google.android.exoplayer2.util.a.g(this.f9874d == null);
        if (this.f9871a.isEmpty()) {
            return null;
        }
        b bVar = (b) this.f9871a.pollFirst();
        this.f9874d = bVar;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.decoder.g
    /* renamed from: i */
    public e2.k d() {
        e2.k kVar;
        if (this.f9872b.isEmpty()) {
            return null;
        }
        while (!this.f9873c.isEmpty() && ((b) s0.j((b) this.f9873c.peek())).f3602d <= this.f9875e) {
            b bVar = (b) s0.j((b) this.f9873c.poll());
            if (bVar.isEndOfStream()) {
                kVar = (e2.k) s0.j((e2.k) this.f9872b.pollFirst());
                kVar.addFlag(4);
            } else {
                g(bVar);
                if (l()) {
                    e2.f f6 = f();
                    kVar = (e2.k) s0.j((e2.k) this.f9872b.pollFirst());
                    kVar.e(bVar.f3602d, f6, Long.MAX_VALUE);
                } else {
                    n(bVar);
                }
            }
            n(bVar);
            return kVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final e2.k j() {
        return (e2.k) this.f9872b.pollFirst();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long k() {
        return this.f9875e;
    }

    protected abstract boolean l();

    @Override // com.google.android.exoplayer2.decoder.g
    /* renamed from: m */
    public void c(j jVar) {
        com.google.android.exoplayer2.util.a.a(jVar == this.f9874d);
        b bVar = (b) jVar;
        if (bVar.isDecodeOnly()) {
            n(bVar);
        } else {
            long j6 = this.f9876f;
            this.f9876f = 1 + j6;
            bVar.f9877k = j6;
            this.f9873c.add(bVar);
        }
        this.f9874d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(e2.k kVar) {
        kVar.clear();
        this.f9872b.add(kVar);
    }
}
