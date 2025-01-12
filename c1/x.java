package c1;

import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public interface x {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final y f3248a;

        /* renamed from: b  reason: collision with root package name */
        public final y f3249b;

        public a(y yVar) {
            this(yVar, yVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3248a.equals(aVar.f3248a) && this.f3249b.equals(aVar.f3249b);
        }

        public int hashCode() {
            return (this.f3248a.hashCode() * 31) + this.f3249b.hashCode();
        }

        public String toString() {
            String sb;
            String valueOf = String.valueOf(this.f3248a);
            if (this.f3248a.equals(this.f3249b)) {
                sb = HttpUrl.FRAGMENT_ENCODE_SET;
            } else {
                String valueOf2 = String.valueOf(this.f3249b);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 2);
                sb2.append(", ");
                sb2.append(valueOf2);
                sb = sb2.toString();
            }
            StringBuilder sb3 = new StringBuilder(valueOf.length() + 2 + String.valueOf(sb).length());
            sb3.append("[");
            sb3.append(valueOf);
            sb3.append(sb);
            sb3.append("]");
            return sb3.toString();
        }

        public a(y yVar, y yVar2) {
            this.f3248a = (y) com.google.android.exoplayer2.util.a.e(yVar);
            this.f3249b = (y) com.google.android.exoplayer2.util.a.e(yVar2);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements x {

        /* renamed from: a  reason: collision with root package name */
        private final long f3250a;

        /* renamed from: b  reason: collision with root package name */
        private final a f3251b;

        public b(long j6) {
            this(j6, 0L);
        }

        @Override // c1.x
        public boolean f() {
            return false;
        }

        @Override // c1.x
        public a i(long j6) {
            return this.f3251b;
        }

        @Override // c1.x
        public long j() {
            return this.f3250a;
        }

        public b(long j6, long j7) {
            this.f3250a = j6;
            this.f3251b = new a(j7 == 0 ? y.f3252c : new y(0L, j7));
        }
    }

    boolean f();

    a i(long j6);

    long j();
}
