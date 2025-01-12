package v1;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f13672a;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public c[] newArray(int i6) {
            return new c[i6];
        }
    }

    public c(int i6) {
        this.f13672a = (i6 & 2) != 0 ? i6 | 1 : i6;
    }

    private int e(Context context) {
        if (l()) {
            ConnectivityManager connectivityManager = (ConnectivityManager) com.google.android.exoplayer2.util.a.e(context.getSystemService("connectivity"));
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return (activeNetworkInfo != null && activeNetworkInfo.isConnected() && k(connectivityManager)) ? (o() && connectivityManager.isActiveNetworkMetered()) ? 2 : 0 : this.f13672a & 3;
        }
        return 0;
    }

    private boolean h(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    private boolean i(Context context) {
        boolean isDeviceIdleMode;
        PowerManager powerManager = (PowerManager) com.google.android.exoplayer2.util.a.e(context.getSystemService("power"));
        int i6 = s0.f4673a;
        if (i6 < 23) {
            return i6 < 20 ? !powerManager.isScreenOn() : !powerManager.isInteractive();
        }
        isDeviceIdleMode = powerManager.isDeviceIdleMode();
        return isDeviceIdleMode;
    }

    private static boolean k(ConnectivityManager connectivityManager) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (s0.f4673a < 24) {
            return true;
        }
        activeNetwork = connectivityManager.getActiveNetwork();
        return (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(16)) ? false : true;
    }

    private boolean m(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && c.class == obj.getClass() && this.f13672a == ((c) obj).f13672a;
    }

    public int f(Context context) {
        int e6 = e(context);
        if (g() && !h(context)) {
            e6 |= 8;
        }
        if (j() && !i(context)) {
            e6 |= 4;
        }
        return (!n() || m(context)) ? e6 : e6 | 16;
    }

    public boolean g() {
        return (this.f13672a & 8) != 0;
    }

    public int hashCode() {
        return this.f13672a;
    }

    public boolean j() {
        return (this.f13672a & 4) != 0;
    }

    public boolean l() {
        return (this.f13672a & 1) != 0;
    }

    public boolean n() {
        return (this.f13672a & 16) != 0;
    }

    public boolean o() {
        return (this.f13672a & 2) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f13672a);
    }
}
