package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1599a = aVar.p(iconCompat.f1599a, 1);
        iconCompat.f1601c = aVar.j(iconCompat.f1601c, 2);
        iconCompat.f1602d = aVar.r(iconCompat.f1602d, 3);
        iconCompat.f1603e = aVar.p(iconCompat.f1603e, 4);
        iconCompat.f1604f = aVar.p(iconCompat.f1604f, 5);
        iconCompat.f1605g = (ColorStateList) aVar.r(iconCompat.f1605g, 6);
        iconCompat.f1607i = aVar.t(iconCompat.f1607i, 7);
        iconCompat.f1608j = aVar.t(iconCompat.f1608j, 8);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.d(aVar.f());
        int i6 = iconCompat.f1599a;
        if (-1 != i6) {
            aVar.F(i6, 1);
        }
        byte[] bArr = iconCompat.f1601c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f1602d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i7 = iconCompat.f1603e;
        if (i7 != 0) {
            aVar.F(i7, 4);
        }
        int i8 = iconCompat.f1604f;
        if (i8 != 0) {
            aVar.F(i8, 5);
        }
        ColorStateList colorStateList = iconCompat.f1605g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f1607i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f1608j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
