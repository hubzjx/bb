package a2;

import java.util.Locale;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f124a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f125b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f126c;

    /* renamed from: d  reason: collision with root package name */
    private final int f127d;

    private l(String[] strArr, int[] iArr, String[] strArr2, int i6) {
        this.f124a = strArr;
        this.f125b = iArr;
        this.f126c = strArr2;
        this.f127d = i6;
    }

    public static l b(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new l(strArr, iArr, strArr2, c(str, strArr, iArr, strArr2));
    }

    private static int c(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String str2;
        strArr[0] = HttpUrl.FRAGMENT_ENCODE_SET;
        int i6 = 0;
        int i7 = 0;
        while (i6 < str.length()) {
            int indexOf = str.indexOf("$", i6);
            char c6 = 65535;
            if (indexOf == -1) {
                String valueOf = String.valueOf(strArr[i7]);
                String valueOf2 = String.valueOf(str.substring(i6));
                strArr[i7] = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                i6 = str.length();
            } else if (indexOf != i6) {
                String valueOf3 = String.valueOf(strArr[i7]);
                String valueOf4 = String.valueOf(str.substring(i6, indexOf));
                strArr[i7] = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                i6 = indexOf;
            } else if (str.startsWith("$$", i6)) {
                strArr[i7] = String.valueOf(strArr[i7]).concat("$");
                i6 += 2;
            } else {
                int i8 = i6 + 1;
                int indexOf2 = str.indexOf("$", i8);
                String substring = str.substring(i8, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i7] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d") && !str2.endsWith("x")) {
                            str2 = str2.concat("d");
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    substring.hashCode();
                    switch (substring.hashCode()) {
                        case -1950496919:
                            if (substring.equals("Number")) {
                                c6 = 0;
                                break;
                            }
                            break;
                        case 2606829:
                            if (substring.equals("Time")) {
                                c6 = 1;
                                break;
                            }
                            break;
                        case 38199441:
                            if (substring.equals("Bandwidth")) {
                                c6 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c6) {
                        case 0:
                            iArr[i7] = 2;
                            break;
                        case 1:
                            iArr[i7] = 4;
                            break;
                        case 2:
                            iArr[i7] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException(str.length() != 0 ? "Invalid template: ".concat(str) : new String("Invalid template: "));
                    }
                    strArr2[i7] = str2;
                }
                i7++;
                strArr[i7] = HttpUrl.FRAGMENT_ENCODE_SET;
                i6 = indexOf2 + 1;
            }
        }
        return i7;
    }

    public String a(String str, long j6, int i6, long j7) {
        String format;
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        while (true) {
            int i8 = this.f127d;
            if (i7 >= i8) {
                sb.append(this.f124a[i8]);
                return sb.toString();
            }
            sb.append(this.f124a[i7]);
            int i9 = this.f125b[i7];
            if (i9 == 1) {
                sb.append(str);
            } else {
                if (i9 == 2) {
                    format = String.format(Locale.US, this.f126c[i7], Long.valueOf(j6));
                } else if (i9 == 3) {
                    format = String.format(Locale.US, this.f126c[i7], Integer.valueOf(i6));
                } else if (i9 == 4) {
                    format = String.format(Locale.US, this.f126c[i7], Long.valueOf(j7));
                }
                sb.append(format);
            }
            i7++;
        }
    }
}
