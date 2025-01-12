package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import x.c;
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    static final PorterDuff.Mode f1598k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    Object f1600b;

    /* renamed from: j  reason: collision with root package name */
    public String f1608j;

    /* renamed from: a  reason: collision with root package name */
    public int f1599a = -1;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1601c = null;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f1602d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f1603e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f1604f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f1605g = null;

    /* renamed from: h  reason: collision with root package name */
    PorterDuff.Mode f1606h = f1598k;

    /* renamed from: i  reason: collision with root package name */
    public String f1607i = null;

    private static int b(Icon icon) {
        int resId;
        if (Build.VERSION.SDK_INT >= 28) {
            resId = icon.getResId();
            return resId;
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e6) {
            Log.e("IconCompat", "Unable to get icon resource", e6);
            return 0;
        } catch (NoSuchMethodException e7) {
            Log.e("IconCompat", "Unable to get icon resource", e7);
            return 0;
        } catch (InvocationTargetException e8) {
            Log.e("IconCompat", "Unable to get icon resource", e8);
            return 0;
        }
    }

    private static String e(int i6) {
        switch (i6) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int a() {
        int i6 = this.f1599a;
        if (i6 != -1 || Build.VERSION.SDK_INT < 23) {
            if (i6 == 2) {
                return this.f1603e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        return b(c.a(this.f1600b));
    }

    public void c() {
        Parcelable parcelable;
        this.f1606h = PorterDuff.Mode.valueOf(this.f1607i);
        switch (this.f1599a) {
            case -1:
                parcelable = this.f1602d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                parcelable = this.f1602d;
                if (parcelable == null) {
                    byte[] bArr = this.f1601c;
                    this.f1600b = bArr;
                    this.f1599a = 3;
                    this.f1603e = 0;
                    this.f1604f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f1601c, Charset.forName("UTF-16"));
                this.f1600b = str;
                if (this.f1599a == 2 && this.f1608j == null) {
                    this.f1608j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f1600b = this.f1601c;
                return;
        }
        this.f1600b = parcelable;
    }

    public void d(boolean z5) {
        this.f1607i = this.f1606h.name();
        switch (this.f1599a) {
            case -1:
                if (z5) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z5) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f1600b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f1601c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f1601c = ((String) this.f1600b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f1601c = (byte[]) this.f1600b;
                return;
            case 4:
            case 6:
                this.f1601c = this.f1600b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
        this.f1602d = (Parcelable) this.f1600b;
    }

    public String toString() {
        int height;
        if (this.f1599a == -1) {
            return String.valueOf(this.f1600b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(e(this.f1599a));
        switch (this.f1599a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1600b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f1600b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f1608j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(a())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f1603e);
                if (this.f1604f != 0) {
                    sb.append(" off=");
                    height = this.f1604f;
                    sb.append(height);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1600b);
                break;
        }
        if (this.f1605g != null) {
            sb.append(" tint=");
            sb.append(this.f1605g);
        }
        if (this.f1606h != f1598k) {
            sb.append(" mode=");
            sb.append(this.f1606h);
        }
        sb.append(")");
        return sb.toString();
    }
}
