package g4;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.a0;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    static g f10502c;

    /* renamed from: d  reason: collision with root package name */
    public static String f10503d;

    /* renamed from: e  reason: collision with root package name */
    public static String f10504e;

    /* renamed from: f  reason: collision with root package name */
    public static String f10505f;

    /* renamed from: g  reason: collision with root package name */
    public static String f10506g;

    /* renamed from: h  reason: collision with root package name */
    public static String f10507h;

    /* renamed from: i  reason: collision with root package name */
    public static String f10508i;

    /* renamed from: a  reason: collision with root package name */
    Context f10509a;

    /* renamed from: b  reason: collision with root package name */
    SharedPreferences f10510b;

    static {
        if (i.j() != null) {
            new g(MainApplication.f6711r);
        }
        f10503d = "keyUseCount";
        f10504e = "keyAccount";
        f10505f = "keyPassword";
        f10506g = "keyTel";
        f10507h = "keyToken";
        f10508i = "keyTokenExpire";
    }

    public g(Context context) {
        this.f10509a = context;
        this.f10510b = PreferenceManager.getDefaultSharedPreferences(context);
        f10502c = this;
    }

    public static g a() {
        if (f10502c == null) {
            new g(MainApplication.f6711r);
        }
        return f10502c;
    }

    public boolean b(String str) {
        return this.f10510b.getBoolean(str, false);
    }

    public String c() {
        return h("keyGesturePassword", HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public int d(String str, int i6) {
        return this.f10510b.getInt(str, i6);
    }

    public String e() {
        String h6 = h(f10504e, HttpUrl.FRAGMENT_ENCODE_SET);
        return h6.isEmpty() ? h(f10506g, HttpUrl.FRAGMENT_ENCODE_SET) : h6;
    }

    public String f() {
        return h(f10505f, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public String g() {
        if (this.f10510b.getLong(f10508i, 0L) > System.currentTimeMillis()) {
            return h(f10507h, null);
        }
        return null;
    }

    public String h(String str, String str2) {
        return this.f10510b.getString(str, str2);
    }

    public int i() {
        return d(f10503d, 0);
    }

    public void j(String str) {
        SharedPreferences.Editor edit = this.f10510b.edit();
        edit.remove(str);
        edit.commit();
    }

    public void k(String str, String str2, a0.h hVar) {
        SharedPreferences.Editor edit = this.f10510b.edit();
        edit.putString(f10504e, str);
        edit.putString(f10505f, str2);
        edit.commit();
        q(hVar);
        com.secret.prettyhezi.i iVar = com.secret.prettyhezi.i.f8489j;
        if (iVar != null) {
            iVar.f();
        }
    }

    public void l(String str, boolean z5) {
        SharedPreferences.Editor edit = this.f10510b.edit();
        edit.putBoolean(str, z5);
        edit.commit();
    }

    public void m(String str) {
        o("keyGesturePassword", str);
    }

    public void n(String str, int i6) {
        SharedPreferences.Editor edit = this.f10510b.edit();
        edit.putInt(str, i6);
        edit.commit();
    }

    public void o(String str, String str2) {
        SharedPreferences.Editor edit = this.f10510b.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public void p() {
        n(f10503d, i() + 1);
    }

    public void q(a0.h hVar) {
        String str;
        long j6;
        String str2;
        SharedPreferences.Editor edit = this.f10510b.edit();
        if (hVar == null || (str2 = hVar.token) == null || str2.length() <= 0) {
            edit.putString(f10507h, HttpUrl.FRAGMENT_ENCODE_SET);
            str = f10508i;
            j6 = 0;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            edit.putString(f10507h, hVar.token);
            str = f10508i;
            j6 = currentTimeMillis + (((hVar.expires - hVar.timestamp) - 600) * 1000);
        }
        edit.putLong(str, j6);
        edit.commit();
    }
}
