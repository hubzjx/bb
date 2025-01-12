package m3;

import io.jsonwebtoken.JwtParser;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeZone f12008a = TimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i6, char c6) {
        return i6 < str.length() && str.charAt(i6) == c6;
    }

    private static int b(String str, int i6) {
        while (i6 < str.length()) {
            char charAt = str.charAt(i6);
            if (charAt < '0' || charAt > '9') {
                return i6;
            }
            i6++;
        }
        return str.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00cf A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b4 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date c(String str, ParsePosition parsePosition) {
        String str2;
        int i6;
        int i7;
        int i8;
        int i9;
        int length;
        TimeZone timeZone;
        char charAt;
        try {
            int index = parsePosition.getIndex();
            int i10 = index + 4;
            int d6 = d(str, index, i10);
            if (a(str, i10, '-')) {
                i10++;
            }
            int i11 = i10 + 2;
            int d7 = d(str, i10, i11);
            if (a(str, i11, '-')) {
                i11++;
            }
            int i12 = i11 + 2;
            int d8 = d(str, i11, i12);
            boolean a6 = a(str, i12, 'T');
            if (!a6 && str.length() <= i12) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(d6, d7 - 1, d8);
                parsePosition.setIndex(i12);
                return gregorianCalendar.getTime();
            }
            if (a6) {
                int i13 = i12 + 1;
                int i14 = i13 + 2;
                int d9 = d(str, i13, i14);
                if (a(str, i14, ':')) {
                    i14++;
                }
                int i15 = i14 + 2;
                int d10 = d(str, i14, i15);
                if (a(str, i15, ':')) {
                    i15++;
                }
                if (str.length() > i15 && (charAt = str.charAt(i15)) != 'Z' && charAt != '+' && charAt != '-') {
                    int i16 = i15 + 2;
                    i9 = d(str, i15, i16);
                    if (i9 > 59 && i9 < 63) {
                        i9 = 59;
                    }
                    if (a(str, i16, JwtParser.SEPARATOR_CHAR)) {
                        int i17 = i16 + 1;
                        int b6 = b(str, i17 + 1);
                        int min = Math.min(b6, i17 + 3);
                        int d11 = d(str, i17, min);
                        int i18 = min - i17;
                        if (i18 == 1) {
                            d11 *= 100;
                        } else if (i18 == 2) {
                            d11 *= 10;
                        }
                        i7 = d10;
                        i8 = d11;
                        i6 = d9;
                        i12 = b6;
                    } else {
                        i7 = d10;
                        i6 = d9;
                        i12 = i16;
                        i8 = 0;
                    }
                    if (str.length() <= i12) {
                        char charAt2 = str.charAt(i12);
                        if (charAt2 == 'Z') {
                            timeZone = f12008a;
                            length = i12 + 1;
                        } else {
                            if (charAt2 != '+' && charAt2 != '-') {
                                throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                            }
                            String substring = str.substring(i12);
                            if (substring.length() < 5) {
                                substring = substring + "00";
                            }
                            length = i12 + substring.length();
                            if (!"+0000".equals(substring) && !"+00:00".equals(substring)) {
                                String str3 = "GMT" + substring;
                                TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                                String id = timeZone2.getID();
                                if (!id.equals(str3) && !id.replace(":", HttpUrl.FRAGMENT_ENCODE_SET).equals(str3)) {
                                    throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                                }
                                timeZone = timeZone2;
                            }
                            timeZone = f12008a;
                        }
                        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                        gregorianCalendar2.setLenient(false);
                        gregorianCalendar2.set(1, d6);
                        gregorianCalendar2.set(2, d7 - 1);
                        gregorianCalendar2.set(5, d8);
                        gregorianCalendar2.set(11, i6);
                        gregorianCalendar2.set(12, i7);
                        gregorianCalendar2.set(13, i9);
                        gregorianCalendar2.set(14, i8);
                        parsePosition.setIndex(length);
                        return gregorianCalendar2.getTime();
                    }
                    throw new IllegalArgumentException("No time zone indicator");
                }
                i7 = d10;
                i8 = 0;
                i6 = d9;
                i12 = i15;
            } else {
                i6 = 0;
                i7 = 0;
                i8 = 0;
            }
            i9 = 0;
            if (str.length() <= i12) {
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException e6) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            String message = e6.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e6.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e6);
            throw parseException;
        }
    }

    private static int d(String str, int i6, int i7) {
        int i8;
        int i9;
        if (i6 < 0 || i7 > str.length() || i6 > i7) {
            throw new NumberFormatException(str);
        }
        if (i6 < i7) {
            i9 = i6 + 1;
            int digit = Character.digit(str.charAt(i6), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i6, i7));
            }
            i8 = -digit;
        } else {
            i8 = 0;
            i9 = i6;
        }
        while (i9 < i7) {
            int i10 = i9 + 1;
            int digit2 = Character.digit(str.charAt(i9), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i6, i7));
            }
            i8 = (i8 * 10) - digit2;
            i9 = i10;
        }
        return -i8;
    }
}
