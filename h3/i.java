package h3;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class i implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f10701a;

    public i(float f6) {
        this.f10701a = f6;
    }

    @Override // h3.c
    public float a(RectF rectF) {
        return this.f10701a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f10701a == ((i) obj).f10701a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f10701a)});
    }
}
