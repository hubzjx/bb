package com.secret.prettyhezi.Registration;

import android.os.Build;
import android.provider.Settings;
import java.io.Serializable;
/* loaded from: classes.dex */
public class g implements Serializable {

    /* renamed from: x0  reason: collision with root package name */
    public String f6980x0;

    /* renamed from: x2  reason: collision with root package name */
    public String f6981x2 = Settings.Secure.getString(g4.i.j().getContentResolver(), "android_id");

    /* renamed from: x3  reason: collision with root package name */
    public String f6982x3 = g4.i.m();

    /* renamed from: x4  reason: collision with root package name */
    public String f6983x4 = Build.MANUFACTURER + "(" + Build.MODEL + ")";

    public g(String str) {
        this.f6980x0 = str;
    }
}
