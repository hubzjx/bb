package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1586a = (IconCompat) aVar.v(remoteActionCompat.f1586a, 1);
        remoteActionCompat.f1587b = aVar.l(remoteActionCompat.f1587b, 2);
        remoteActionCompat.f1588c = aVar.l(remoteActionCompat.f1588c, 3);
        remoteActionCompat.f1589d = (PendingIntent) aVar.r(remoteActionCompat.f1589d, 4);
        remoteActionCompat.f1590e = aVar.h(remoteActionCompat.f1590e, 5);
        remoteActionCompat.f1591f = aVar.h(remoteActionCompat.f1591f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f1586a, 1);
        aVar.D(remoteActionCompat.f1587b, 2);
        aVar.D(remoteActionCompat.f1588c, 3);
        aVar.H(remoteActionCompat.f1589d, 4);
        aVar.z(remoteActionCompat.f1590e, 5);
        aVar.z(remoteActionCompat.f1591f, 6);
    }
}
