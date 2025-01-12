package d5;

import e5.q;
import java.io.OutputStream;
/* loaded from: classes.dex */
class a extends b {

    /* renamed from: c  reason: collision with root package name */
    private byte[] f9201c;

    /* renamed from: d  reason: collision with root package name */
    private int f9202d;

    public a(j jVar, q qVar, char[] cArr) {
        super(jVar, qVar, cArr);
        this.f9201c = new byte[16];
        this.f9202d = 0;
    }

    private void g(x4.a aVar) {
        e(aVar.e());
        e(aVar.c());
    }

    @Override // d5.b
    public void a() {
        int i6 = this.f9202d;
        if (i6 != 0) {
            super.write(this.f9201c, 0, i6);
            this.f9202d = 0;
        }
        e(((x4.a) b()).d());
        super.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // d5.b
    /* renamed from: f */
    public x4.a d(OutputStream outputStream, q qVar, char[] cArr) {
        x4.a aVar = new x4.a(cArr, qVar.a());
        g(aVar);
        return aVar;
    }

    @Override // d5.b, java.io.OutputStream
    public void write(int i6) {
        write(new byte[]{(byte) i6});
    }

    @Override // d5.b, java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // d5.b, java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) {
        int i8;
        int i9 = this.f9202d;
        if (i7 < 16 - i9) {
            System.arraycopy(bArr, i6, this.f9201c, i9, i7);
            this.f9202d += i7;
            return;
        }
        System.arraycopy(bArr, i6, this.f9201c, i9, 16 - i9);
        byte[] bArr2 = this.f9201c;
        super.write(bArr2, 0, bArr2.length);
        int i10 = 16 - this.f9202d;
        int i11 = i7 - i10;
        this.f9202d = 0;
        if (i11 != 0 && (i8 = i11 % 16) != 0) {
            System.arraycopy(bArr, (i11 + i10) - i8, this.f9201c, 0, i8);
            this.f9202d = i8;
            i11 -= i8;
        }
        super.write(bArr, i10, i11);
    }
}
