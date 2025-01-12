package com.secret.prettyhezi.controls;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    ZZcINlcxH f8318a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f8319b;

    /* renamed from: c  reason: collision with root package name */
    String f8320c = HttpUrl.FRAGMENT_ENCODE_SET;

    /* renamed from: d  reason: collision with root package name */
    public SpannableStringBuilder f8321d;

    public f() {
    }

    public f a(String str, int i6, float f6) {
        int length = this.f8320c.length();
        int length2 = str.length() + length;
        this.f8320c += str;
        if (length == 0) {
            this.f8321d = new SpannableStringBuilder(str);
        } else {
            this.f8321d.insert(length, (CharSequence) str);
        }
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(g4.i.r(f6));
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i6);
        this.f8321d.setSpan(absoluteSizeSpan, length, length2, 17);
        this.f8321d.setSpan(foregroundColorSpan, length, length2, 17);
        return this;
    }

    public void b() {
        this.f8319b.setText(this.f8321d);
    }

    public f(ZZcINlcxH zZcINlcxH) {
        this.f8318a = zZcINlcxH;
        this.f8319b = new TextView(zZcINlcxH);
    }
}
