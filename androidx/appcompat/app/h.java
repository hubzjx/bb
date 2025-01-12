package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;
/* loaded from: classes.dex */
class h {

    /* renamed from: d  reason: collision with root package name */
    private static h f415d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f416a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f417b;

    /* renamed from: c  reason: collision with root package name */
    private final a f418c = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f419a;

        /* renamed from: b  reason: collision with root package name */
        long f420b;

        /* renamed from: c  reason: collision with root package name */
        long f421c;

        /* renamed from: d  reason: collision with root package name */
        long f422d;

        /* renamed from: e  reason: collision with root package name */
        long f423e;

        /* renamed from: f  reason: collision with root package name */
        long f424f;

        a() {
        }
    }

    h(Context context, LocationManager locationManager) {
        this.f416a = context;
        this.f417b = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(Context context) {
        if (f415d == null) {
            Context applicationContext = context.getApplicationContext();
            f415d = new h(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f415d;
    }

    private Location b() {
        Location c6 = u.d.b(this.f416a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location c7 = u.d.b(this.f416a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (c7 == null || c6 == null) ? c7 != null ? c7 : c6 : c7.getTime() > c6.getTime() ? c7 : c6;
    }

    private Location c(String str) {
        try {
            if (this.f417b.isProviderEnabled(str)) {
                return this.f417b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e6) {
            Log.d("TwilightManager", "Failed to get last known location", e6);
            return null;
        }
    }

    private boolean e() {
        return this.f418c.f424f > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j6;
        a aVar = this.f418c;
        long currentTimeMillis = System.currentTimeMillis();
        g b6 = g.b();
        b6.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j7 = b6.f412a;
        b6.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z5 = b6.f414c == 1;
        long j8 = b6.f413b;
        long j9 = b6.f412a;
        boolean z6 = z5;
        b6.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j10 = b6.f413b;
        if (j8 == -1 || j9 == -1) {
            j6 = 43200000 + currentTimeMillis;
        } else {
            j6 = (currentTimeMillis > j9 ? 0 + j10 : currentTimeMillis > j8 ? 0 + j9 : 0 + j8) + 60000;
        }
        aVar.f419a = z6;
        aVar.f420b = j7;
        aVar.f421c = j8;
        aVar.f422d = j9;
        aVar.f423e = j10;
        aVar.f424f = j6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f418c;
        if (e()) {
            return aVar.f419a;
        }
        Location b6 = b();
        if (b6 != null) {
            f(b6);
            return aVar.f419a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i6 = Calendar.getInstance().get(11);
        return i6 < 6 || i6 >= 22;
    }
}
