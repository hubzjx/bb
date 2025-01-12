package com.secret.prettyhezi;

import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class VpEEnM extends UoWMF {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        M(C0, s0(C0382R.string.Bulletin));
        V(C0, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        LinearLayout e6 = e(C0);
        Bundle extras = getIntent().getExtras();
        int i6 = extras != null ? extras.getInt("id") : 0;
        e6.setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(20.0f));
        com.secret.prettyhezi.Server.q GetItem = com.secret.prettyhezi.Server.r.GetItem(i6);
        TextView b6 = g4.d.b(this, 16.0f, -16777216, GetItem.name);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = g4.i.r(12.0f);
        e6.addView(b6, layoutParams);
        if (!GetItem.content.contains("<a")) {
            e6.addView(g4.d.b(this, 14.0f, Color.parseColor("#333333"), GetItem.content), new LinearLayout.LayoutParams(-1, -2));
            return;
        }
        WebView webView = new WebView(this);
        webView.loadData(GetItem.content, "text/html; charset=UTF-8", null);
        e6.addView(webView, new LinearLayout.LayoutParams(-1, -2));
    }
}
