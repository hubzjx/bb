package h;

import android.content.Context;
import android.content.res.Configuration;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f10527a;

    private a(Context context) {
        this.f10527a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f10527a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f10527a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f10527a.getResources().getConfiguration();
        int i6 = configuration.screenWidthDp;
        int i7 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i6 > 600) {
            return 5;
        }
        if (i6 <= 960 || i7 <= 720) {
            if (i6 <= 720 || i7 <= 960) {
                if (i6 < 500) {
                    if (i6 <= 640 || i7 <= 480) {
                        if (i6 <= 480 || i7 <= 640) {
                            return i6 >= 360 ? 3 : 2;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 4;
            }
            return 5;
        }
        return 5;
    }

    public boolean e() {
        return this.f10527a.getResources().getBoolean(b.b.abc_action_bar_embed_tabs);
    }

    public boolean f() {
        return true;
    }
}
