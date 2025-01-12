package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;
/* loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {

    /* loaded from: classes.dex */
    private static class a extends MediaBrowserCompat.b {

        /* renamed from: c  reason: collision with root package name */
        private final Context f2117c;

        /* renamed from: d  reason: collision with root package name */
        private final Intent f2118d;

        /* renamed from: e  reason: collision with root package name */
        private final BroadcastReceiver.PendingResult f2119e;

        /* renamed from: f  reason: collision with root package name */
        private MediaBrowserCompat f2120f;

        a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f2117c = context;
            this.f2118d = intent;
            this.f2119e = pendingResult;
        }

        private void e() {
            this.f2120f.b();
            this.f2119e.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void a() {
            try {
                new MediaControllerCompat(this.f2117c, this.f2120f.c()).a((KeyEvent) this.f2118d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e6) {
                Log.e("MediaButtonReceiver", "Failed to create a media controller", e6);
            }
            e();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void b() {
            e();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void c() {
            e();
        }

        void f(MediaBrowserCompat mediaBrowserCompat) {
            this.f2120f = mediaBrowserCompat;
        }
    }

    private static ComponentName a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }

    private static void b(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName a6 = a(context, "android.intent.action.MEDIA_BUTTON");
        if (a6 != null) {
            intent.setComponent(a6);
            b(context, intent);
            return;
        }
        ComponentName a7 = a(context, "android.media.browse.MediaBrowserService");
        if (a7 == null) {
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        BroadcastReceiver.PendingResult goAsync = goAsync();
        Context applicationContext = context.getApplicationContext();
        a aVar = new a(applicationContext, intent, goAsync);
        MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, a7, aVar, null);
        aVar.f(mediaBrowserCompat);
        mediaBrowserCompat.a();
    }
}
