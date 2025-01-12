package com.google.android.exoplayer2.offline;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.w;
import java.util.HashMap;
import u1.b;
import v1.c;
import v1.d;
/* loaded from: classes.dex */
public abstract class DownloadService extends Service {

    /* renamed from: j  reason: collision with root package name */
    private static final HashMap f3939j = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final String f3940b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3941c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3942d;

    /* renamed from: e  reason: collision with root package name */
    private int f3943e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3944f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3945g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3946h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3947i;

    /* loaded from: classes.dex */
    private static final class a {
        public abstract void b(DownloadService downloadService);

        public abstract void c(DownloadService downloadService);
    }

    protected abstract u1.a a();

    protected abstract d b();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        String str = this.f3940b;
        if (str != null) {
            w.a(this, str, this.f3941c, this.f3942d, 2);
        }
        a aVar = (a) f3939j.get(getClass());
        if (aVar == null) {
            a();
            throw null;
        }
        aVar.getClass();
        aVar.b(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f3947i = true;
        ((a) com.google.android.exoplayer2.util.a.e((a) f3939j.get(getClass()))).c(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0096, code lost:
        if (r2.equals("com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS") == false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010b  */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(Intent intent, int i6, int i7) {
        String str;
        String str2;
        String str3;
        this.f3943e = i7;
        this.f3945g = false;
        char c6 = 1;
        if (intent != null) {
            str = intent.getAction();
            str2 = intent.getStringExtra("content_id");
            this.f3944f |= intent.getBooleanExtra("foreground", false) || "com.google.android.exoplayer.downloadService.action.RESTART".equals(str);
        } else {
            str = null;
            str2 = null;
        }
        if (str == null) {
            str = "com.google.android.exoplayer.downloadService.action.INIT";
        }
        android.support.v4.media.a.a(com.google.android.exoplayer2.util.a.e(null));
        switch (str.hashCode()) {
            case -1931239035:
                if (str.equals("com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case -932047176:
                break;
            case -871181424:
                if (str.equals("com.google.android.exoplayer.downloadService.action.RESTART")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            case -650547439:
                if (str.equals("com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS")) {
                    c6 = 3;
                    break;
                }
                c6 = 65535;
                break;
            case -119057172:
                if (str.equals("com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS")) {
                    c6 = 4;
                    break;
                }
                c6 = 65535;
                break;
            case 191112771:
                if (str.equals("com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS")) {
                    c6 = 5;
                    break;
                }
                c6 = 65535;
                break;
            case 671523141:
                if (str.equals("com.google.android.exoplayer.downloadService.action.SET_STOP_REASON")) {
                    c6 = 6;
                    break;
                }
                c6 = 65535;
                break;
            case 1015676687:
                if (str.equals("com.google.android.exoplayer.downloadService.action.INIT")) {
                    c6 = 7;
                    break;
                }
                c6 = 65535;
                break;
            case 1547520644:
                if (str.equals("com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD")) {
                    c6 = '\b';
                    break;
                }
                c6 = 65535;
                break;
            default:
                c6 = 65535;
                break;
        }
        switch (c6) {
            case 0:
                if (((b) ((Intent) com.google.android.exoplayer2.util.a.e(intent)).getParcelableExtra("download_request")) != null) {
                    intent.getIntExtra("stop_reason", 0);
                    throw null;
                }
                str3 = "Ignored ADD_DOWNLOAD: Missing download_request extra";
                n.c("DownloadService", str3);
                if (s0.f4673a >= 26) {
                    boolean z5 = this.f3944f;
                }
                this.f3946h = false;
                throw null;
            case 1:
                throw null;
            case 2:
            case 7:
                if (s0.f4673a >= 26) {
                }
                this.f3946h = false;
                throw null;
            case 3:
                throw null;
            case 4:
                if (((c) ((Intent) com.google.android.exoplayer2.util.a.e(intent)).getParcelableExtra("requirements")) != null) {
                    b();
                    throw null;
                }
                str3 = "Ignored SET_REQUIREMENTS: Missing requirements extra";
                n.c("DownloadService", str3);
                if (s0.f4673a >= 26) {
                }
                this.f3946h = false;
                throw null;
            case 5:
                throw null;
            case 6:
                if (((Intent) com.google.android.exoplayer2.util.a.e(intent)).hasExtra("stop_reason")) {
                    intent.getIntExtra("stop_reason", 0);
                    throw null;
                }
                str3 = "Ignored SET_STOP_REASON: Missing stop_reason extra";
                n.c("DownloadService", str3);
                if (s0.f4673a >= 26) {
                }
                this.f3946h = false;
                throw null;
            case '\b':
                if (str2 == null) {
                    str3 = "Ignored REMOVE_DOWNLOAD: Missing content_id extra";
                    n.c("DownloadService", str3);
                    if (s0.f4673a >= 26) {
                    }
                    this.f3946h = false;
                    throw null;
                }
                throw null;
            default:
                str3 = str.length() != 0 ? "Ignored unrecognized action: ".concat(str) : new String("Ignored unrecognized action: ");
                n.c("DownloadService", str3);
                if (s0.f4673a >= 26) {
                }
                this.f3946h = false;
                throw null;
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.f3945g = true;
    }
}
