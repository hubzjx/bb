package com.google.android.exoplayer2.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
/* loaded from: classes.dex */
public abstract class w {
    public static void a(Context context, String str, int i6, int i7, int i8) {
        if (s0.f4673a >= 26) {
            NotificationManager notificationManager = (NotificationManager) a.e((NotificationManager) context.getSystemService("notification"));
            v.a();
            NotificationChannel a6 = u.a(str, context.getString(i6), i8);
            if (i7 != 0) {
                a6.setDescription(context.getString(i7));
            }
            notificationManager.createNotificationChannel(a6);
        }
    }
}
