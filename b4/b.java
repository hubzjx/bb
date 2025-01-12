package b4;

import java.lang.reflect.Array;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final byte[][] f3023a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3024b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3025c;

    public b(int i6, int i7) {
        this.f3023a = (byte[][]) Array.newInstance(Byte.TYPE, i7, i6);
        this.f3024b = i6;
        this.f3025c = i7;
    }

    public void a(byte b6) {
        for (byte[] bArr : this.f3023a) {
            Arrays.fill(bArr, b6);
        }
    }

    public byte b(int i6, int i7) {
        return this.f3023a[i7][i6];
    }

    public byte[][] c() {
        return this.f3023a;
    }

    public int d() {
        return this.f3025c;
    }

    public int e() {
        return this.f3024b;
    }

    public void f(int i6, int i7, int i8) {
        this.f3023a[i7][i6] = (byte) i8;
    }

    public void g(int i6, int i7, boolean z5) {
        this.f3023a[i7][i6] = z5 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f3024b * 2 * this.f3025c) + 2);
        for (int i6 = 0; i6 < this.f3025c; i6++) {
            byte[] bArr = this.f3023a[i6];
            for (int i7 = 0; i7 < this.f3024b; i7++) {
                byte b6 = bArr[i7];
                sb.append(b6 != 0 ? b6 != 1 ? "  " : " 1" : " 0");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
