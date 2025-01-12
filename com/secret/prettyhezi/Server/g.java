package com.secret.prettyhezi.Server;

import android.os.Build;
import android.provider.Settings;
import com.secret.prettyhezi.MainApplication;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class g extends w {
    public static String keyLastConfigure = "keyLastConfigure";
    public a[] ads;
    public b[] apiserves;
    public d sys;

    /* loaded from: classes.dex */
    public static class a implements Serializable {
        public int height;
        public int id;
        public String img;
        public int loading;
        public int type;
        public String url;
        public int width;
    }

    /* loaded from: classes.dex */
    public static class b implements Serializable {
        public String api_url;
        public c[] cdns;
        public long delay;
        public boolean detected;
        public long disableTime;
        public int sort;
        public int type;

        public boolean IsSameHost(String str) {
            c[] cVarArr = this.cdns;
            if (cVarArr != null) {
                for (c cVar : cVarArr) {
                    if (str.contains(cVar.api_url)) {
                        return true;
                    }
                }
            }
            return str.contains(this.api_url);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Serializable {
        public String api_url;
        public int type;
    }

    /* loaded from: classes.dex */
    public static class d implements Serializable {
        public int about;
        public String app_apk;
        public String app_version;
        public int box_follow;
        public String cache;
        public int id;
        public String max_box;
        public int max_score;
        public int mboptb;
        public int min_score;
        public int msoapt;
        public int msoarct;
        public int msopt;
        public int msorct;
        public int notice;
        public int page;
        public boolean proxy;
        public boolean share;
        public boolean sharecode;
        public boolean sign_in;
        public boolean sign_up;
        public boolean status;
        public long systime;
        public boolean trade;
        public String trade_type;
        public int upload_min_score;
        public int version;

        public int[] ScoreTradeTypes() {
            String[] split = this.trade_type.split("\\|");
            int length = split.length;
            int[] iArr = new int[length];
            for (int i6 = 0; i6 < length; i6++) {
                iArr[i6] = Integer.parseInt(split[i6]);
            }
            return iArr;
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Serializable {
        public String device = Settings.Secure.getString(g4.i.j().getContentResolver(), "android_id");
        public String os_version = g4.i.m();
        public String company = Build.MANUFACTURER + "(" + Build.MODEL + ")";
        public String app_version = g4.a.c();
    }

    public static String latestApk() {
        return (MainApplication.f6711r.k() == null || MainApplication.f6711r.k().sys == null) ? HttpUrl.FRAGMENT_ENCODE_SET : MainApplication.f6711r.k().sys.app_apk;
    }
}
