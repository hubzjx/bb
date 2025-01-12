package androidx.media;

import java.util.Arrays;
/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public int f2015a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f2016b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f2017c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f2018d = -1;

    public int a() {
        return this.f2016b;
    }

    public int b() {
        int i6 = this.f2017c;
        int c6 = c();
        if (c6 == 6) {
            i6 |= 4;
        } else if (c6 == 7) {
            i6 |= 1;
        }
        return i6 & 273;
    }

    public int c() {
        int i6 = this.f2018d;
        return i6 != -1 ? i6 : AudioAttributesCompat.a(false, this.f2017c, this.f2015a);
    }

    public int d() {
        return this.f2015a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplBase) {
            AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
            return this.f2016b == audioAttributesImplBase.a() && this.f2017c == audioAttributesImplBase.b() && this.f2015a == audioAttributesImplBase.d() && this.f2018d == audioAttributesImplBase.f2018d;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2016b), Integer.valueOf(this.f2017c), Integer.valueOf(this.f2015a), Integer.valueOf(this.f2018d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f2018d != -1) {
            sb.append(" stream=");
            sb.append(this.f2018d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f2015a));
        sb.append(" content=");
        sb.append(this.f2016b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f2017c).toUpperCase());
        return sb.toString();
    }
}
