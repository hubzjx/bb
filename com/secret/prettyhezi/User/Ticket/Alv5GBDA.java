package com.secret.prettyhezi.User.Ticket;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.share.KQHNLjV;
import g4.i;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class Alv5GBDA extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7697r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f7698s;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            Alv5GBDA.this.M0(KQHNLjV.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout B0 = B0(3, 4);
        this.f7697r = B0;
        M(B0, s0(C0382R.string.MyTickets));
        TextView c6 = g4.d.c(this, 16, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f7698s = c6;
        c6.setText(Html.fromHtml("<u><font color=\"#000000\"><font color=\"#ff0000\"><b>邀请他人</b></font>使用BeautyBox可获得更多超级权限卡</font></u>"));
        this.f7697r.addView(this.f7698s, new LinearLayout.LayoutParams(-1, i.r(32.0f)));
        this.f7698s.setOnClickListener(new a());
        this.f7697r.addView(new e(this), new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }
}
