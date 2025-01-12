package j1;

import com.google.android.exoplayer2.util.y;
import java.util.Arrays;
/* loaded from: classes.dex */
final class e {

    /* renamed from: a  reason: collision with root package name */
    private final f f11173a = new f();

    /* renamed from: b  reason: collision with root package name */
    private final y f11174b = new y(new byte[65025], 0);

    /* renamed from: c  reason: collision with root package name */
    private int f11175c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f11176d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11177e;

    private int a(int i6) {
        int i7;
        int i8 = 0;
        this.f11176d = 0;
        do {
            int i9 = this.f11176d;
            int i10 = i6 + i9;
            f fVar = this.f11173a;
            if (i10 >= fVar.f11184g) {
                break;
            }
            int[] iArr = fVar.f11187j;
            this.f11176d = i9 + 1;
            i7 = iArr[i9 + i6];
            i8 += i7;
        } while (i7 == 255);
        return i8;
    }

    public f b() {
        return this.f11173a;
    }

    public y c() {
        return this.f11174b;
    }

    public boolean d(c1.j jVar) {
        int i6;
        com.google.android.exoplayer2.util.a.g(jVar != null);
        if (this.f11177e) {
            this.f11177e = false;
            this.f11174b.I(0);
        }
        while (!this.f11177e) {
            if (this.f11175c < 0) {
                if (!this.f11173a.d(jVar) || !this.f11173a.b(jVar, true)) {
                    return false;
                }
                f fVar = this.f11173a;
                int i7 = fVar.f11185h;
                if ((fVar.f11179b & 1) == 1 && this.f11174b.e() == 0) {
                    i7 += a(0);
                    i6 = this.f11176d + 0;
                } else {
                    i6 = 0;
                }
                jVar.h(i7);
                this.f11175c = i6;
            }
            int a6 = a(this.f11175c);
            int i8 = this.f11175c + this.f11176d;
            if (a6 > 0) {
                if (this.f11174b.b() < this.f11174b.e() + a6) {
                    y yVar = this.f11174b;
                    yVar.K(Arrays.copyOf(yVar.c(), this.f11174b.e() + a6), this.f11174b.e());
                }
                jVar.readFully(this.f11174b.c(), this.f11174b.e(), a6);
                y yVar2 = this.f11174b;
                yVar2.L(yVar2.e() + a6);
                this.f11177e = this.f11173a.f11187j[i8 + (-1)] != 255;
            }
            if (i8 == this.f11173a.f11184g) {
                i8 = -1;
            }
            this.f11175c = i8;
        }
        return true;
    }

    public void e() {
        this.f11173a.c();
        this.f11174b.I(0);
        this.f11175c = -1;
        this.f11177e = false;
    }

    public void f() {
        if (this.f11174b.c().length == 65025) {
            return;
        }
        y yVar = this.f11174b;
        yVar.K(Arrays.copyOf(yVar.c(), Math.max(65025, this.f11174b.e())), this.f11174b.e());
    }
}
