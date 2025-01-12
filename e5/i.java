package e5;

import java.util.Objects;
/* loaded from: classes.dex */
public class i extends b {

    /* renamed from: t  reason: collision with root package name */
    private int f9584t;

    /* renamed from: u  reason: collision with root package name */
    private int f9585u = 0;

    /* renamed from: v  reason: collision with root package name */
    private int f9586v;

    /* renamed from: w  reason: collision with root package name */
    private byte[] f9587w;

    /* renamed from: x  reason: collision with root package name */
    private byte[] f9588x;

    /* renamed from: y  reason: collision with root package name */
    private long f9589y;

    /* renamed from: z  reason: collision with root package name */
    private String f9590z;

    public i() {
        b(b5.c.CENTRAL_DIRECTORY);
    }

    private long L(i iVar) {
        return iVar.p() != null ? iVar.p().e() : iVar.P();
    }

    public int M() {
        return this.f9586v;
    }

    public byte[] N() {
        return this.f9588x;
    }

    public String O() {
        return this.f9590z;
    }

    public long P() {
        return this.f9589y;
    }

    public int Q() {
        return this.f9584t;
    }

    public void R(int i6) {
        this.f9586v = i6;
    }

    public void S(byte[] bArr) {
        this.f9588x = bArr;
    }

    public void T(String str) {
        this.f9590z = str;
    }

    public void U(int i6) {
        this.f9585u = i6;
    }

    public void V(byte[] bArr) {
        this.f9587w = bArr;
    }

    public void W(long j6) {
        this.f9589y = j6;
    }

    public void X(int i6) {
        this.f9584t = i6;
    }

    @Override // e5.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && super.equals(obj) && L(this) == L((i) obj);
    }

    public int hashCode() {
        return Objects.hash(j(), Long.valueOf(L(this)));
    }

    public String toString() {
        return j();
    }
}
