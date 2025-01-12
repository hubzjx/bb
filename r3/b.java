package r3;
/* loaded from: classes.dex */
final class b extends g {

    /* renamed from: c  reason: collision with root package name */
    private final short f13035c;

    /* renamed from: d  reason: collision with root package name */
    private final short f13036d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g gVar, int i6, int i7) {
        super(gVar);
        this.f13035c = (short) i6;
        this.f13036d = (short) i7;
    }

    @Override // r3.g
    public void c(s3.a aVar, byte[] bArr) {
        int i6;
        int i7 = 0;
        while (true) {
            short s5 = this.f13036d;
            if (i7 >= s5) {
                return;
            }
            if (i7 == 0 || (i7 == 31 && s5 <= 62)) {
                int i8 = 5;
                aVar.c(31, 5);
                short s6 = this.f13036d;
                if (s6 > 62) {
                    i6 = s6 - 31;
                    i8 = 16;
                } else if (i7 == 0) {
                    aVar.c(Math.min((int) s6, 31), 5);
                } else {
                    i6 = s6 - 31;
                }
                aVar.c(i6, i8);
            }
            aVar.c(bArr[this.f13035c + i7], 8);
            i7++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.f13035c);
        sb.append("::");
        sb.append((this.f13035c + this.f13036d) - 1);
        sb.append('>');
        return sb.toString();
    }
}
