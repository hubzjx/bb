package androidx.media;

import android.text.TextUtils;
/* loaded from: classes.dex */
class k implements f {

    /* renamed from: a  reason: collision with root package name */
    private String f2114a;

    /* renamed from: b  reason: collision with root package name */
    private int f2115b;

    /* renamed from: c  reason: collision with root package name */
    private int f2116c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(String str, int i6, int i7) {
        this.f2114a = str;
        this.f2115b = i6;
        this.f2116c = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            return TextUtils.equals(this.f2114a, kVar.f2114a) && this.f2115b == kVar.f2115b && this.f2116c == kVar.f2116c;
        }
        return false;
    }

    public int hashCode() {
        return d0.d.b(this.f2114a, Integer.valueOf(this.f2115b), Integer.valueOf(this.f2116c));
    }
}
