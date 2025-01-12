package h3;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c f10649a;

    /* renamed from: b  reason: collision with root package name */
    private final float f10650b;

    public b(float f6, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f10649a;
            f6 += ((b) cVar).f10650b;
        }
        this.f10649a = cVar;
        this.f10650b = f6;
    }

    @Override // h3.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f10649a.a(rectF) + this.f10650b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f10649a.equals(bVar.f10649a) && this.f10650b == bVar.f10650b;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10649a, Float.valueOf(this.f10650b)});
    }
}
