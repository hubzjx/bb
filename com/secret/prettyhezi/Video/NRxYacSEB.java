package com.secret.prettyhezi.Video;

import android.content.Intent;
import android.os.Bundle;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class NRxYacSEB extends MSqCZ2mQ {
    public static void z1(ZZcINlcxH zZcINlcxH, String str, int i6, int i7, long j6) {
        if (MSqCZ2mQ.c1(zZcINlcxH, str, i6, i7) && !str.startsWith(MainApplication.f6711r.getFilesDir().getAbsolutePath())) {
            zZcINlcxH.y(zZcINlcxH.s0(C0382R.string.DownloadingHint));
            return;
        }
        Intent intent = new Intent();
        intent.setClass(zZcINlcxH, NRxYacSEB.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putInt("id", i7);
        bundle.putInt("type", i6);
        bundle.putLong("pos", j6);
        intent.putExtras(bundle);
        zZcINlcxH.startActivity(intent);
    }
}
