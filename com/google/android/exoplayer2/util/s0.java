package com.google.android.exoplayer2.util;

import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public abstract class s0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4673a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f4674b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f4675c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f4676d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f4677e;

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f4678f;

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f4679g;

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f4680h;

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f4681i;

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f4682j;

    /* renamed from: k  reason: collision with root package name */
    private static HashMap f4683k;

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f4684l;

    /* renamed from: m  reason: collision with root package name */
    private static final String[] f4685m;

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f4686n;

    /* renamed from: o  reason: collision with root package name */
    private static final int[] f4687o;

    static {
        int i6 = "R".equals(Build.VERSION.CODENAME) ? 30 : Build.VERSION.SDK_INT;
        f4673a = i6;
        String str = Build.DEVICE;
        f4674b = str;
        String str2 = Build.MANUFACTURER;
        f4675c = str2;
        String str3 = Build.MODEL;
        f4676d = str3;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 17 + String.valueOf(str3).length() + String.valueOf(str2).length());
        sb.append(str);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(i6);
        f4677e = sb.toString();
        f4678f = new byte[0];
        f4679g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f4680h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f4681i = Pattern.compile("%([A-Fa-f0-9]{2})");
        f4682j = Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        f4684l = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f4685m = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f4686n = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f4687o = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, b.j.I0, WebSocketProtocol.PAYLOAD_SHORT, b.j.K0, androidx.constraintlayout.widget.g.Z0, androidx.constraintlayout.widget.g.Y0, 98, androidx.constraintlayout.widget.g.T0, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, androidx.constraintlayout.widget.g.W0, 97, androidx.constraintlayout.widget.g.U0, b.j.E0, b.j.F0, 125, b.j.L0, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, androidx.constraintlayout.widget.g.V0, 96, b.j.G0, b.j.D0, b.j.M0, b.j.N0, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, b.j.H0, 113, b.j.J0, 127, androidx.constraintlayout.widget.g.X0, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static Handler A(Handler.Callback callback) {
        return w(O(), callback);
    }

    public static long A0(String str) {
        Matcher matcher = f4679g.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            throw new f1(valueOf.length() != 0 ? "Invalid date/time format: ".concat(valueOf) : new String("Invalid date/time format: "));
        }
        int i6 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i6 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if ("-".equals(matcher.group(11))) {
                i6 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            String valueOf2 = String.valueOf(matcher.group(8));
            gregorianCalendar.set(14, new BigDecimal(valueOf2.length() != 0 ? "0.".concat(valueOf2) : new String("0.")).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i6 != 0 ? timeInMillis - (i6 * 60000) : timeInMillis;
    }

    private static HashMap B() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap hashMap = new HashMap(iSOLanguages.length + f4684l.length);
        int i6 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = f4684l;
            if (i6 >= strArr.length) {
                return hashMap;
            }
            hashMap.put(strArr[i6], strArr[i6 + 1]);
            i6 += 2;
        }
    }

    public static long B0(String str) {
        Matcher matcher = f4680h.matcher(str);
        if (matcher.matches()) {
            boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
            String group = matcher.group(3);
            double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
            String group2 = matcher.group(5);
            double parseDouble2 = parseDouble + (group2 != null ? Double.parseDouble(group2) * 2629739.0d : 0.0d);
            String group3 = matcher.group(7);
            double parseDouble3 = parseDouble2 + (group3 != null ? Double.parseDouble(group3) * 86400.0d : 0.0d);
            String group4 = matcher.group(10);
            double parseDouble4 = parseDouble3 + (group4 != null ? Double.parseDouble(group4) * 3600.0d : 0.0d);
            String group5 = matcher.group(12);
            double parseDouble5 = parseDouble4 + (group5 != null ? Double.parseDouble(group5) * 60.0d : 0.0d);
            String group6 = matcher.group(14);
            long parseDouble6 = (long) ((parseDouble5 + (group6 != null ? Double.parseDouble(group6) : 0.0d)) * 1000.0d);
            return isEmpty ? -parseDouble6 : parseDouble6;
        }
        return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
    }

    public static Uri C(Uri uri) {
        String S0 = S0(uri.getPath());
        if (S0 == null) {
            return uri;
        }
        Matcher matcher = f4682j.matcher(S0);
        return (matcher.matches() && matcher.group(1) == null) ? Uri.withAppendedPath(uri, "Manifest") : uri;
    }

    public static boolean C0(Handler handler, Runnable runnable) {
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
            return true;
        }
        return handler.post(runnable);
    }

    public static String D(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static boolean D0(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static String E(byte[] bArr) {
        return new String(bArr, com.google.common.base.b.f5585c);
    }

    public static void E0(List list, int i6, int i7) {
        if (i6 < 0 || i7 > list.size() || i6 > i7) {
            throw new IllegalArgumentException();
        }
        if (i6 != i7) {
            list.subList(i6, i7).clear();
        }
    }

    public static String F(byte[] bArr, int i6, int i7) {
        return new String(bArr, i6, i7, com.google.common.base.b.f5585c);
    }

    public static long F0(long j6, long j7, long j8) {
        int i6 = (j8 > j7 ? 1 : (j8 == j7 ? 0 : -1));
        if (i6 < 0 || j8 % j7 != 0) {
            if (i6 >= 0 || j7 % j8 != 0) {
                return (long) (j6 * (j7 / j8));
            }
            return j6 * (j7 / j8);
        }
        return j6 / (j8 / j7);
    }

    public static int G(int i6) {
        switch (i6) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i7 = f4673a;
                return (i7 < 23 && i7 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static long[] G0(List list, long j6, long j7) {
        int size = list.size();
        long[] jArr = new long[size];
        int i6 = 0;
        int i7 = (j7 > j6 ? 1 : (j7 == j6 ? 0 : -1));
        if (i7 >= 0 && j7 % j6 == 0) {
            long j8 = j7 / j6;
            while (i6 < size) {
                jArr[i6] = ((Long) list.get(i6)).longValue() / j8;
                i6++;
            }
        } else if (i7 >= 0 || j6 % j7 != 0) {
            double d6 = j6 / j7;
            while (i6 < size) {
                jArr[i6] = (long) (((Long) list.get(i6)).longValue() * d6);
                i6++;
            }
        } else {
            long j9 = j6 / j7;
            while (i6 < size) {
                jArr[i6] = ((Long) list.get(i6)).longValue() * j9;
                i6++;
            }
        }
        return jArr;
    }

    public static int H(ByteBuffer byteBuffer, int i6) {
        int i7 = byteBuffer.getInt(i6);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i7 : Integer.reverseBytes(i7);
    }

    public static void H0(long[] jArr, long j6, long j7) {
        int i6 = 0;
        int i7 = (j7 > j6 ? 1 : (j7 == j6 ? 0 : -1));
        if (i7 >= 0 && j7 % j6 == 0) {
            long j8 = j7 / j6;
            while (i6 < jArr.length) {
                jArr[i6] = jArr[i6] / j8;
                i6++;
            }
        } else if (i7 >= 0 || j6 % j7 != 0) {
            double d6 = j6 / j7;
            while (i6 < jArr.length) {
                jArr[i6] = (long) (jArr[i6] * d6);
                i6++;
            }
        } else {
            long j9 = j6 / j7;
            while (i6 < jArr.length) {
                jArr[i6] = jArr[i6] * j9;
                i6++;
            }
        }
    }

    public static byte[] I(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * 2;
            bArr[i6] = (byte) ((Character.digit(str.charAt(i7), 16) << 4) + Character.digit(str.charAt(i7 + 1), 16));
        }
        return bArr;
    }

    public static void I0(Throwable th) {
        J0(th);
    }

    public static String J(String str, int i6) {
        String[] M0 = M0(str);
        if (M0.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : M0) {
            if (i6 == q.l(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    private static void J0(Throwable th) {
        throw th;
    }

    public static String K(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < objArr.length; i6++) {
            sb.append(objArr[i6].getClass().getSimpleName());
            if (i6 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static String[] K0(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String L(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return U0(networkCountryIso);
            }
        }
        return U0(Locale.getDefault().getCountry());
    }

    public static String[] L0(String str, String str2) {
        return str.split(str2, 2);
    }

    public static Point M(Context context) {
        return N(context, ((WindowManager) a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay());
    }

    public static String[] M0(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : K0(str.trim(), "(\\s*,\\s*)");
    }

    public static Point N(Context context, Display display) {
        int i6 = f4673a;
        if (i6 <= 29 && display.getDisplayId() == 0 && q0(context)) {
            if ("Sony".equals(f4675c) && f4676d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
            String g02 = g0(i6 < 28 ? "sys.display-size" : "vendor.display-size");
            if (!TextUtils.isEmpty(g02)) {
                try {
                    String[] K0 = K0(g02.trim(), "x");
                    if (K0.length == 2) {
                        int parseInt = Integer.parseInt(K0[0]);
                        int parseInt2 = Integer.parseInt(K0[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                String valueOf = String.valueOf(g02);
                n.c("Util", valueOf.length() != 0 ? "Invalid display size: ".concat(valueOf) : new String("Invalid display size: "));
            }
        }
        Point point = new Point();
        int i7 = f4673a;
        if (i7 >= 23) {
            R(display, point);
        } else if (i7 >= 17) {
            Q(display, point);
        } else {
            P(display, point);
        }
        return point;
    }

    public static ComponentName N0(Context context, Intent intent) {
        ComponentName startForegroundService;
        if (f4673a >= 26) {
            startForegroundService = context.startForegroundService(intent);
            return startForegroundService;
        }
        return context.startService(intent);
    }

    public static Looper O() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    public static long O0(long j6, long j7, long j8) {
        long j9 = j6 - j7;
        return ((j6 ^ j9) & (j7 ^ j6)) < 0 ? j8 : j9;
    }

    private static void P(Display display, Point point) {
        display.getSize(point);
    }

    public static boolean P0(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    private static void Q(Display display, Point point) {
        display.getRealSize(point);
    }

    public static byte[] Q0(InputStream inputStream) {
        byte[] bArr = new byte[_BufferKt.SEGMENTING_THRESHOLD];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static void R(Display display, Point point) {
        Display.Mode mode;
        int physicalWidth;
        int physicalHeight;
        mode = display.getMode();
        physicalWidth = mode.getPhysicalWidth();
        point.x = physicalWidth;
        physicalHeight = mode.getPhysicalHeight();
        point.y = physicalHeight;
    }

    public static long R0(int i6, int i7) {
        return T0(i7) | (T0(i6) << 32);
    }

    public static String S(Locale locale) {
        return f4673a >= 21 ? T(locale) : locale.toString();
    }

    public static String S0(String str) {
        return str == null ? str : str.toLowerCase(Locale.US);
    }

    private static String T(Locale locale) {
        return locale.toLanguageTag();
    }

    public static long T0(int i6) {
        return i6 & 4294967295L;
    }

    public static long U(long j6, float f6) {
        return f6 == 1.0f ? j6 : Math.round(j6 * f6);
    }

    public static String U0(String str) {
        return str == null ? str : str.toUpperCase(Locale.US);
    }

    private static int V(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return f4673a >= 29 ? 9 : 0;
        }
    }

    public static CharSequence V0(CharSequence charSequence, int i6) {
        return charSequence.length() <= i6 ? charSequence : charSequence.subSequence(0, i6);
    }

    public static int W(Context context) {
        ConnectivityManager connectivityManager;
        int i6 = 0;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i6 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return V(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i6;
    }

    public static String W0(String str) {
        int length = str.length();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            if (str.charAt(i8) == '%') {
                i7++;
            }
        }
        if (i7 == 0) {
            return str;
        }
        int i9 = length - (i7 * 2);
        StringBuilder sb = new StringBuilder(i9);
        Matcher matcher = f4681i.matcher(str);
        while (i7 > 0 && matcher.find()) {
            sb.append((CharSequence) str, i6, matcher.start());
            sb.append((char) Integer.parseInt((String) a.e(matcher.group(1)), 16));
            i6 = matcher.end();
            i7--;
        }
        if (i6 < length) {
            sb.append((CharSequence) str, i6, length);
        }
        if (sb.length() != i9) {
            return null;
        }
        return sb.toString();
    }

    public static long X(long j6) {
        return j6 == -9223372036854775807L ? System.currentTimeMillis() : j6 + SystemClock.elapsedRealtime();
    }

    public static void X0(Parcel parcel, boolean z5) {
        parcel.writeInt(z5 ? 1 : 0);
    }

    public static int Y(int i6) {
        if (i6 != 8) {
            if (i6 != 16) {
                if (i6 != 24) {
                    return i6 != 32 ? 0 : 805306368;
                }
                return 536870912;
            }
            return 2;
        }
        return 3;
    }

    public static com.google.android.exoplayer2.s0 Z(int i6, int i7, int i8) {
        return new s0.b().e0("audio/raw").H(i7).f0(i8).Y(i6).E();
    }

    public static int a0(int i6, int i7) {
        if (i6 != 2) {
            if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 268435456) {
                        if (i6 == 536870912) {
                            return i7 * 3;
                        }
                        if (i6 != 805306368) {
                            throw new IllegalArgumentException();
                        }
                    }
                }
                return i7 * 4;
            }
            return i7;
        }
        return i7 * 2;
    }

    public static long b(long j6, long j7, long j8) {
        long j9 = j6 + j7;
        return ((j6 ^ j9) & (j7 ^ j9)) < 0 ? j8 : j9;
    }

    public static long b0(long j6, float f6) {
        return f6 == 1.0f ? j6 : Math.round(j6 / f6);
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int c0(int i6) {
        if (i6 != 13) {
            switch (i6) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                default:
                    return 3;
            }
        }
        return 1;
    }

    public static int d(List list, Comparable comparable, boolean z5, boolean z6) {
        int i6;
        int binarySearch = Collections.binarySearch(list, comparable);
        if (binarySearch < 0) {
            i6 = ~binarySearch;
        } else {
            int size = list.size();
            do {
                binarySearch++;
                if (binarySearch >= size) {
                    break;
                }
            } while (((Comparable) list.get(binarySearch)).compareTo(comparable) == 0);
            i6 = z5 ? binarySearch - 1 : binarySearch;
        }
        return z6 ? Math.min(list.size() - 1, i6) : i6;
    }

    public static String[] d0() {
        String[] e02 = e0();
        for (int i6 = 0; i6 < e02.length; i6++) {
            e02[i6] = v0(e02[i6]);
        }
        return e02;
    }

    public static int e(long[] jArr, long j6, boolean z5, boolean z6) {
        int i6;
        int binarySearch = Arrays.binarySearch(jArr, j6);
        if (binarySearch < 0) {
            i6 = ~binarySearch;
        } else {
            do {
                binarySearch++;
                if (binarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[binarySearch] == j6);
            i6 = z5 ? binarySearch - 1 : binarySearch;
        }
        return z6 ? Math.min(jArr.length - 1, i6) : i6;
    }

    private static String[] e0() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return f4673a >= 24 ? f0(configuration) : new String[]{S(configuration.locale)};
    }

    public static int f(o oVar, long j6, boolean z5, boolean z6) {
        int i6;
        int c6 = oVar.c() - 1;
        int i7 = 0;
        while (i7 <= c6) {
            int i8 = (i7 + c6) >>> 1;
            if (oVar.b(i8) < j6) {
                i7 = i8 + 1;
            } else {
                c6 = i8 - 1;
            }
        }
        if (z5 && (i6 = c6 + 1) < oVar.c() && oVar.b(i6) == j6) {
            return i6;
        }
        if (z6 && c6 == -1) {
            return 0;
        }
        return c6;
    }

    private static String[] f0(Configuration configuration) {
        LocaleList locales;
        String languageTags;
        locales = configuration.getLocales();
        languageTags = locales.toLanguageTags();
        return K0(languageTags, ",");
    }

    public static int g(List list, Comparable comparable, boolean z5, boolean z6) {
        int i6;
        int binarySearch = Collections.binarySearch(list, comparable);
        if (binarySearch < 0) {
            i6 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (((Comparable) list.get(binarySearch)).compareTo(comparable) == 0);
            i6 = z5 ? binarySearch + 1 : binarySearch;
        }
        return z6 ? Math.max(0, i6) : i6;
    }

    private static String g0(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e6) {
            String valueOf = String.valueOf(str);
            n.d("Util", valueOf.length() != 0 ? "Failed to read system property ".concat(valueOf) : new String("Failed to read system property "), e6);
            return null;
        }
    }

    public static int h(int[] iArr, int i6, boolean z5, boolean z6) {
        int i7;
        int binarySearch = Arrays.binarySearch(iArr, i6);
        if (binarySearch < 0) {
            i7 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (iArr[binarySearch] == i6);
            i7 = z5 ? binarySearch + 1 : binarySearch;
        }
        return z6 ? Math.max(0, i7) : i7;
    }

    public static byte[] h0(String str) {
        return str.getBytes(com.google.common.base.b.f5585c);
    }

    public static int i(long[] jArr, long j6, boolean z5, boolean z6) {
        int i6;
        int binarySearch = Arrays.binarySearch(jArr, j6);
        if (binarySearch < 0) {
            i6 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (jArr[binarySearch] == j6);
            i6 = z5 ? binarySearch + 1 : binarySearch;
        }
        return z6 ? Math.max(0, i6) : i6;
    }

    public static int i0(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return j0(path);
    }

    public static Object j(Object obj) {
        return obj;
    }

    public static int j0(String str) {
        String S0 = S0(str);
        if (S0.endsWith(".mpd")) {
            return 0;
        }
        if (S0.endsWith(".m3u8")) {
            return 2;
        }
        Matcher matcher = f4682j.matcher(S0);
        if (matcher.matches()) {
            String group = matcher.group(2);
            if (group != null) {
                if (group.contains("format=mpd-time-csf")) {
                    return 0;
                }
                return group.contains("format=m3u8-aapl") ? 2 : 1;
            }
            return 1;
        }
        return 3;
    }

    public static Object[] k(Object[] objArr) {
        return objArr;
    }

    public static int k0(Uri uri, String str) {
        if (str == null) {
            return i0(uri);
        }
        char c6 = 65535;
        switch (str.hashCode()) {
            case -979127466:
                if (str.equals("application/x-mpegURL")) {
                    c6 = 0;
                    break;
                }
                break;
            case -156749520:
                if (str.equals("application/vnd.ms-sstr+xml")) {
                    c6 = 1;
                    break;
                }
                break;
            case 64194685:
                if (str.equals("application/dash+xml")) {
                    c6 = 2;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                return 2;
            case 1:
                return 1;
            case 2:
                return 0;
            default:
                return 3;
        }
    }

    public static int l(int i6, int i7) {
        return ((i6 + i7) - 1) / i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean l0(y yVar, y yVar2, Inflater inflater) {
        if (yVar.a() <= 0) {
            return false;
        }
        byte[] c6 = yVar2.c();
        if (c6.length < yVar.a()) {
            c6 = new byte[yVar.a() * 2];
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(yVar.c(), yVar.d(), yVar.a());
        int i6 = 0;
        while (true) {
            try {
                i6 += inflater.inflate(c6, i6, c6.length - i6);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    } else if (i6 == c6.length) {
                        c6 = Arrays.copyOf(c6, c6.length * 2);
                    }
                } else {
                    yVar2.K(c6, i6);
                    inflater.reset();
                    return true;
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
    }

    public static long m(long j6, long j7) {
        return ((j6 + j7) - 1) / j7;
    }

    public static boolean m0(int i6) {
        return i6 == 536870912 || i6 == 805306368 || i6 == 4;
    }

    public static void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean n0(int i6) {
        return i6 == 3 || i6 == 2 || i6 == 268435456 || i6 == 536870912 || i6 == 805306368 || i6 == 4;
    }

    public static void o(q2.l lVar) {
        if (lVar != null) {
            try {
                lVar.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean o0(int i6) {
        return i6 == 10 || i6 == 13;
    }

    public static int p(long j6, long j7) {
        int i6 = (j6 > j7 ? 1 : (j6 == j7 ? 0 : -1));
        if (i6 < 0) {
            return -1;
        }
        return i6 == 0 ? 0 : 1;
    }

    public static boolean p0(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static float q(float f6, float f7, float f8) {
        return Math.max(f7, Math.min(f6, f8));
    }

    public static boolean q0(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static int r(int i6, int i7, int i8) {
        return Math.max(i7, Math.min(i6, i8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread r0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static long s(long j6, long j7, long j8) {
        return Math.max(j7, Math.min(j6, j8));
    }

    public static int s0(int[] iArr, int i6) {
        for (int i7 = 0; i7 < iArr.length; i7++) {
            if (iArr[i7] == i6) {
                return i7;
            }
        }
        return -1;
    }

    public static boolean t(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (c(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    private static String t0(String str) {
        int i6 = 0;
        while (true) {
            String[] strArr = f4685m;
            if (i6 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i6])) {
                String valueOf = String.valueOf(strArr[i6 + 1]);
                String valueOf2 = String.valueOf(str.substring(strArr[i6].length()));
                return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            }
            i6 += 2;
        }
    }

    public static int u(byte[] bArr, int i6, int i7, int i8) {
        while (i6 < i7) {
            i8 = f4686n[((i8 >>> 24) ^ (bArr[i6] & 255)) & 255] ^ (i8 << 8);
            i6++;
        }
        return i8;
    }

    public static ExecutorService u0(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.google.android.exoplayer2.util.r0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread r02;
                r02 = s0.r0(str, runnable);
                return r02;
            }
        });
    }

    public static int v(byte[] bArr, int i6, int i7, int i8) {
        while (i6 < i7) {
            i8 = f4687o[i8 ^ (bArr[i6] & 255)];
            i6++;
        }
        return i8;
    }

    public static String v0(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !"und".equals(replace)) {
            str = replace;
        }
        String S0 = S0(str);
        String str2 = L0(S0, "-")[0];
        if (f4683k == null) {
            f4683k = B();
        }
        String str3 = (String) f4683k.get(str2);
        if (str3 != null) {
            String valueOf = String.valueOf(S0.substring(str2.length()));
            S0 = valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3);
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? t0(S0) : S0;
    }

    public static Handler w(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static Object[] w0(Object[] objArr, Object obj) {
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + 1);
        copyOf[objArr.length] = obj;
        return k(copyOf);
    }

    public static Handler x() {
        return y(null);
    }

    public static Object[] x0(Object[] objArr, Object[] objArr2) {
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + objArr2.length);
        System.arraycopy(objArr2, 0, copyOf, objArr.length, objArr2.length);
        return copyOf;
    }

    public static Handler y(Handler.Callback callback) {
        return w((Looper) a.i(Looper.myLooper()), callback);
    }

    public static Object[] y0(Object[] objArr, int i6) {
        a.a(i6 <= objArr.length);
        return Arrays.copyOf(objArr, i6);
    }

    public static Handler z() {
        return A(null);
    }

    public static Object[] z0(Object[] objArr, int i6, int i7) {
        a.a(i6 >= 0);
        a.a(i7 <= objArr.length);
        return Arrays.copyOfRange(objArr, i6, i7);
    }
}
