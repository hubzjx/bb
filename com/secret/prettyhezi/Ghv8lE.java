package com.secret.prettyhezi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class Ghv8lE extends UoWMF {

    /* renamed from: s  reason: collision with root package name */
    static String f6684s = "测试";

    /* renamed from: t  reason: collision with root package name */
    static String f6685t = "test.html";

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6686r;

    public static void S0(Context context, String str, String str2) {
        f6684s = str;
        f6685t = str2;
        context.startActivity(new Intent(context, Ghv8lE.class));
    }

    public static void T0(Context context, String str, String str2) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6686r = C0;
        M(C0, f6684s);
        WebView webView = new WebView(this);
        if (f6685t.startsWith("http")) {
            str = f6685t;
        } else {
            str = "file:///android_asset/html/" + f6685t;
        }
        webView.loadUrl(str);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(false);
        webView.getSettings().setCacheMode(2);
        this.f6686r.addView(webView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }
}
