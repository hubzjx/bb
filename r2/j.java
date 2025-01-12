package r2;

import java.io.File;
/* loaded from: classes.dex */
public abstract class j implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    public final String f12974a;

    /* renamed from: b  reason: collision with root package name */
    public final long f12975b;

    /* renamed from: c  reason: collision with root package name */
    public final long f12976c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f12977d;

    /* renamed from: e  reason: collision with root package name */
    public final File f12978e;

    /* renamed from: f  reason: collision with root package name */
    public final long f12979f;

    public j(String str, long j6, long j7, long j8, File file) {
        this.f12974a = str;
        this.f12975b = j6;
        this.f12976c = j7;
        this.f12977d = file != null;
        this.f12978e = file;
        this.f12979f = j8;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(j jVar) {
        if (this.f12974a.equals(jVar.f12974a)) {
            int i6 = ((this.f12975b - jVar.f12975b) > 0L ? 1 : ((this.f12975b - jVar.f12975b) == 0L ? 0 : -1));
            if (i6 == 0) {
                return 0;
            }
            return i6 < 0 ? -1 : 1;
        }
        return this.f12974a.compareTo(jVar.f12974a);
    }

    public boolean b() {
        return !this.f12977d;
    }

    public boolean c() {
        return this.f12976c == -1;
    }

    public String toString() {
        long j6 = this.f12975b;
        long j7 = this.f12976c;
        StringBuilder sb = new StringBuilder(44);
        sb.append("[");
        sb.append(j6);
        sb.append(", ");
        sb.append(j7);
        sb.append("]");
        return sb.toString();
    }
}
