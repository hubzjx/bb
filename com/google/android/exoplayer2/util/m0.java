package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class m0 {
    private static int[] a(String str) {
        int i6;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i7 = indexOf4 + 2;
        if (i7 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i7) == '/') {
            i6 = str.indexOf(47, indexOf4 + 3);
            if (i6 == -1 || i6 > indexOf2) {
                i6 = indexOf2;
            }
        } else {
            i6 = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i6;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    private static String b(StringBuilder sb, int i6, int i7) {
        int i8;
        int i9;
        if (i6 >= i7) {
            return sb.toString();
        }
        if (sb.charAt(i6) == '/') {
            i6++;
        }
        int i10 = i6;
        int i11 = i10;
        while (i10 <= i7) {
            if (i10 == i7) {
                i8 = i10;
            } else if (sb.charAt(i10) == '/') {
                i8 = i10 + 1;
            } else {
                i10++;
            }
            int i12 = i11 + 1;
            if (i10 == i12 && sb.charAt(i11) == '.') {
                sb.delete(i11, i8);
                i7 -= i8 - i11;
            } else {
                if (i10 == i11 + 2 && sb.charAt(i11) == '.' && sb.charAt(i12) == '.') {
                    i9 = sb.lastIndexOf("/", i11 - 2) + 1;
                    int i13 = i9 > i6 ? i9 : i6;
                    sb.delete(i13, i8);
                    i7 -= i8 - i13;
                } else {
                    i9 = i10 + 1;
                }
                i11 = i9;
            }
            i10 = i11;
        }
        return sb.toString();
    }

    public static String c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (str2 == null) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        int[] a6 = a(str2);
        if (a6[0] != -1) {
            sb.append(str2);
            b(sb, a6[1], a6[2]);
            return sb.toString();
        }
        int[] a7 = a(str);
        if (a6[3] == 0) {
            sb.append((CharSequence) str, 0, a7[3]);
            sb.append(str2);
            return sb.toString();
        } else if (a6[2] == 0) {
            sb.append((CharSequence) str, 0, a7[2]);
            sb.append(str2);
            return sb.toString();
        } else {
            int i6 = a6[1];
            if (i6 != 0) {
                int i7 = a7[0] + 1;
                sb.append((CharSequence) str, 0, i7);
                sb.append(str2);
                return b(sb, a6[1] + i7, i7 + a6[2]);
            } else if (str2.charAt(i6) == '/') {
                sb.append((CharSequence) str, 0, a7[1]);
                sb.append(str2);
                int i8 = a7[1];
                return b(sb, i8, a6[2] + i8);
            } else {
                int i9 = a7[0] + 2;
                int i10 = a7[1];
                if (i9 >= i10 || i10 != a7[2]) {
                    int lastIndexOf = str.lastIndexOf(47, a7[2] - 1);
                    int i11 = lastIndexOf == -1 ? a7[1] : lastIndexOf + 1;
                    sb.append((CharSequence) str, 0, i11);
                    sb.append(str2);
                    return b(sb, a7[1], i11 + a6[2]);
                }
                sb.append((CharSequence) str, 0, i10);
                sb.append('/');
                sb.append(str2);
                int i12 = a7[1];
                return b(sb, i12, a6[2] + i12 + 1);
            }
        }
    }

    public static Uri d(String str, String str2) {
        return Uri.parse(c(str, str2));
    }
}
