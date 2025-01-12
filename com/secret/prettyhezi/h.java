package com.secret.prettyhezi;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes.dex */
public abstract class h {
    public static boolean a() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) g4.i.j().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
        } catch (Exception unused) {
            return false;
        }
    }
}
