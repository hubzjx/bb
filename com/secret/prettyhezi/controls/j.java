package com.secret.prettyhezi.controls;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;
import java.util.ArrayList;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class j {

    /* loaded from: classes.dex */
    public static class a implements InputFilter {

        /* renamed from: a  reason: collision with root package name */
        int f8357a;

        public a(int i6) {
            this.f8357a = i6;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i6, int i7, Spanned spanned, int i8, int i9) {
            if (charSequence.length() > 0) {
                for (int i10 = 0; i10 < charSequence.length(); i10++) {
                    char charAt = charSequence.charAt(i10);
                    if ((this.f8357a & 1) <= 0 || !g4.i.O(charAt)) {
                        int i11 = this.f8357a;
                        if (((i11 & 4) <= 0 || ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z'))) && (((i11 & 2) <= 0 || charAt < '0' || charAt > '9') && (((i11 & 8) <= 0 || ",;.?!()[]\"、，。；“”（）！?？【】<>《》-=+".indexOf(charAt) < 0) && ((this.f8357a & 16) <= 0 || "-_ ".indexOf(charAt) < 0)))) {
                            return HttpUrl.FRAGMENT_ENCODE_SET;
                        }
                    }
                }
            }
            return null;
        }
    }

    public static void a(EditText editText, int i6, int i7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(i7));
        if (i6 > 0) {
            arrayList.add(new InputFilter.LengthFilter(i6));
        }
        editText.setFilters((InputFilter[]) arrayList.toArray(new InputFilter[arrayList.size()]));
    }

    public static void b(EditText editText, int i6) {
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i6)});
    }
}
