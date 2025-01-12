package z3;

import java.lang.reflect.Array;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b[] f14355a;

    /* renamed from: b  reason: collision with root package name */
    private int f14356b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14357c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14358d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i6, int i7) {
        b[] bVarArr = new b[i6];
        this.f14355a = bVarArr;
        int length = bVarArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            this.f14355a[i8] = new b(((i7 + 4) * 17) + 1);
        }
        this.f14358d = i7 * 17;
        this.f14357c = i6;
        this.f14356b = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a() {
        return this.f14355a[this.f14356b];
    }

    public byte[][] b(int i6, int i7) {
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, this.f14357c * i7, this.f14358d * i6);
        int i8 = this.f14357c * i7;
        for (int i9 = 0; i9 < i8; i9++) {
            bArr[(i8 - i9) - 1] = this.f14355a[i9 / i7].b(i6);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f14356b++;
    }
}
