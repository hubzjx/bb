package h3;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f10648a;

    public a(float f6) {
        this.f10648a = f6;
    }

    @Override // h3.c
    public float a(RectF rectF) {
        return this.f10648a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f10648a == ((a) obj).f10648a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f10648a)});
    }
}
