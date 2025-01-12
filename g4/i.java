package g4;

import android.app.ActivityManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import com.secret.prettyhezi.ZZcINlcxH;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import okhttp3.HttpUrl;
import okio.Segment;
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    static ZZcINlcxH f10511a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f10512b = 999999;

    /* renamed from: c  reason: collision with root package name */
    public static final char[] f10513c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: d  reason: collision with root package name */
    public static Paint f10514d = null;

    public static String A(double d6) {
        long j6 = (long) ((d6 * 10.0d) + 0.02d);
        long j7 = j6 % 10;
        if (j7 == 0) {
            return Long.toString(j6 / 10);
        }
        return Long.toString(j6 / 10) + "." + j7;
    }

    public static String B(double d6) {
        long j6 = (long) ((d6 * 100.0d) + 0.002d);
        long j7 = j6 % 100;
        if (j7 == 0) {
            return Long.toString(j6 / 100);
        }
        String str = (Long.toString(j6 / 100) + ".") + (j7 / 10);
        long j8 = j7 % 10;
        if (j8 > 0) {
            return str + j8;
        }
        return str;
    }

    public static String C(double d6) {
        long j6 = (long) ((d6 * 1000.0d) + 2.0E-4d);
        long j7 = j6 % 1000;
        if (j7 == 0) {
            return Long.toString(j6 / 1000);
        }
        String str = ((j6 / 1000) + ".") + (j7 / 100);
        long j8 = j7 % 100;
        if (j8 > 0) {
            String str2 = str + (j8 / 10);
            long j9 = j8 % 10;
            if (j9 > 0) {
                return str2 + j9;
            }
            return str2;
        }
        return str;
    }

    public static String D(long j6) {
        int i6;
        StringBuilder sb;
        String format;
        String format2 = String.format("%.1fMB", Double.valueOf(j6 / 1048576.0d));
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        do {
            long j7 = j6 % 1000;
            j6 /= 1000;
            i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
            if (i6 > 0) {
                sb = new StringBuilder();
                format = String.format(",%03d", Long.valueOf(j7));
            } else {
                sb = new StringBuilder();
                format = String.format("%d", Long.valueOf(j7));
            }
            sb.append(format);
            sb.append(str);
            str = sb.toString();
        } while (i6 != 0);
        return format2 + " (" + str + ")";
    }

    public static String E(byte[] bArr) {
        char[] cArr = new char[32];
        int i6 = 0;
        for (int i7 = 0; i7 < 16; i7++) {
            byte b6 = bArr[i7];
            int i8 = i6 + 1;
            char[] cArr2 = f10513c;
            cArr[i6] = cArr2[(b6 >>> 4) & 15];
            i6 = i8 + 1;
            cArr[i8] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }

    public static String F(double d6) {
        return B(d6);
    }

    public static String G(int i6) {
        String str = HttpUrl.FRAGMENT_ENCODE_SET + String.format("%02d:", Integer.valueOf(i6 / 3600));
        int i7 = i6 % 3600;
        return (str + String.format("%02d:", Integer.valueOf(i7 / 60))) + String.format("%02d", Integer.valueOf(i7 % 60));
    }

    public static String H(String str) {
        byte[] bArr = new byte[Segment.SIZE];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(str);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    return E(messageDigest.digest());
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static String I(String str) {
        int indexOf;
        int indexOf2 = str.indexOf("://");
        return (indexOf2 >= 0 && (indexOf = str.indexOf(47, indexOf2 + 3)) >= 0) ? str.substring(0, indexOf) : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public static String J(String str) {
        try {
            return InetAddress.getByName(Uri.parse(str).getHost()).getHostAddress();
        } catch (Exception e6) {
            e6.printStackTrace();
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static String K(String str) {
        return L(str);
    }

    public static String L(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return E(messageDigest.digest());
        } catch (Exception unused) {
            return str;
        }
    }

    public static final Bitmap M(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (f10514d == null) {
            f10514d = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            f10514d.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, f10514d);
        return createBitmap;
    }

    public static boolean N() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            runningAppProcesses = ((ActivityManager) f10511a.getSystemService("activity")).getRunningAppProcesses();
        } catch (Exception unused) {
        }
        if (runningAppProcesses == null) {
            return true;
        }
        String packageName = f10511a.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName)) {
                return runningAppProcessInfo.importance != 100;
            }
        }
        return false;
    }

    public static boolean O(char c6) {
        return c6 >= 19968 && c6 <= 40869;
    }

    public static boolean P(String str) {
        if (str.isEmpty()) {
            return false;
        }
        for (int i6 = 0; i6 < str.length(); i6++) {
            if (!Character.isDigit(str.charAt(i6))) {
                return false;
            }
        }
        return str.charAt(0) != '0';
    }

    public static String Q(String str) {
        int i6;
        int indexOf;
        int indexOf2 = str.indexOf("/cdn");
        if (indexOf2 >= 0 && (indexOf = str.indexOf(47, (i6 = indexOf2 + 4))) >= i6 && P(str.substring(i6, indexOf))) {
            return str.substring(0, indexOf2) + str.substring(indexOf);
        }
        return str;
    }

    public static void R(String str) {
        c.l(str, Base64.decode(c.g(str), 0));
    }

    public static void S(String str, String str2) {
        c.l(str2, Base64.decode(str, 0));
    }

    public static StateListDrawable a(int i6, int i7) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = f10511a.getResources().getDrawable(i6);
        stateListDrawable.addState(new int[]{16842913}, f10511a.getResources().getDrawable(i7));
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static GradientDrawable b(int i6, float f6) {
        return c(i6, f6, 0, 0.0f);
    }

    public static GradientDrawable c(int i6, float f6, int i7, float f7) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i6);
        gradientDrawable.setCornerRadius(r(f6));
        if (f7 > 0.0f) {
            gradientDrawable.setStroke(r(f7), i7);
        }
        return gradientDrawable;
    }

    public static StateListDrawable d(Drawable drawable, Drawable drawable2) {
        return e(drawable, drawable2, null);
    }

    public static StateListDrawable e(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, drawable2);
        if (drawable3 != null) {
            stateListDrawable.addState(new int[]{-16842910}, drawable3);
        }
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static StateListDrawable f(int i6, int i7) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, new ColorDrawable(i7));
        stateListDrawable.addState(new int[0], new ColorDrawable(i6));
        return stateListDrawable;
    }

    public static StateListDrawable g(int i6, int i7, int i8) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, new ColorDrawable(i7));
        stateListDrawable.addState(new int[]{-16842910}, new ColorDrawable(i8));
        stateListDrawable.addState(new int[0], new ColorDrawable(i6));
        return stateListDrawable;
    }

    public static StateListDrawable h(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842913}, drawable3);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static StateListDrawable i(int i6, int i7, int i8) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, new ColorDrawable(i7));
        stateListDrawable.addState(new int[]{16842910, 16842913}, new ColorDrawable(i8));
        stateListDrawable.addState(new int[0], new ColorDrawable(i6));
        return stateListDrawable;
    }

    public static ZZcINlcxH j() {
        return f10511a;
    }

    public static String k() {
        return Build.MANUFACTURER + "(" + Build.MODEL + ")";
    }

    public static String l() {
        return "Android" + m();
    }

    public static String m() {
        String str = Build.VERSION.RELEASE;
        if (str == null || str.isEmpty()) {
            return "SDK" + Build.VERSION.SDK_INT;
        }
        return str;
    }

    public static void n(ZZcINlcxH zZcINlcxH) {
        f10511a = zZcINlcxH;
    }

    public static int o() {
        if (f10512b == 999999) {
            f10512b = g.a().d("keySysDiffTime", 999999);
        }
        return f10512b;
    }

    public static ColorStateList p(int i6, int i7, int i8) {
        return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[]{16842913}, new int[0]}, new int[]{i7, i8, i6});
    }

    public static ColorStateList q(int i6, int i7, int i8, int i9) {
        return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[]{16842913}, new int[]{-16842910}, new int[0]}, new int[]{i7, i8, i9, i6});
    }

    public static int r(float f6) {
        return (int) ((f6 * f10511a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float s(float f6) {
        return f10511a.getResources().getDisplayMetrics().density * f6;
    }

    public static String t(File file) {
        FileInputStream fileInputStream;
        String str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        FileInputStream fileInputStream2 = null;
        try {
        } catch (Throwable th) {
            th = th;
            fileInputStream2 = fileInputStream;
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                str = Base64.encodeToString(bArr, 0, fileInputStream.read(bArr), 0);
                fileInputStream.close();
            } catch (FileNotFoundException e7) {
                e = e7;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str;
            } catch (IOException e8) {
                e = e8;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str;
            }
        } catch (FileNotFoundException e9) {
            e = e9;
            fileInputStream = null;
        } catch (IOException e10) {
            e = e10;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            throw th;
        }
        return str;
    }

    public static String u(long j6) {
        if (j6 == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        Date date = new Date(j6 * 1000);
        return String.format("%d-%02d-%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()));
    }

    public static String v(long j6) {
        if (j6 == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        Date date = new Date(j6 * 1000);
        return String.format("%02d-%02d %02d:%02d", Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()));
    }

    public static String w(long j6) {
        if (j6 == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        Date date = new Date(j6 * 1000);
        return String.format("%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    public static String x(long j6) {
        if (j6 == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        Date date = new Date(j6 * 1000);
        return String.format("%02d-%02d %02d:%02d:%02d", Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    public static String y(long j6) {
        if (j6 == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        Date date = new Date(j6 * 1000);
        return String.format("%d-%02d-%02d %02d:%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()));
    }

    public static String z(long j6) {
        if (j6 == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        Date date = new Date(j6 * 1000);
        return String.format("%02d日 %02d:%02d", Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()));
    }
}
