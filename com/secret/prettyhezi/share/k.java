package com.secret.prettyhezi.share;

import com.secret.prettyhezi.Server.n;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class k extends n {
    public int contribution;
    public boolean download;
    public String name;
    public int num;
    public float signin;
    public transient int type;
    public float value;

    k() {
    }

    public String GetPrice() {
        String str;
        if (this.value > 0.0f) {
            str = g4.i.F(this.value) + "积分";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (this.contribution != 0) {
            if (str.length() > 0) {
                str = str + k5.d.ANY_NON_NULL_MARKER;
            }
            str = str + Integer.toString(this.contribution) + "推广贡献值";
        }
        if (this.num > 0) {
            if (str.length() > 0) {
                str = str + k5.d.ANY_NON_NULL_MARKER;
            }
            return str + Integer.toString(this.num) + "分享值";
        }
        return str;
    }
}
