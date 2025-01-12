package com.secret.prettyhezi.User;

import com.secret.prettyhezi.Server.n;
/* loaded from: classes.dex */
class g extends n {
    public long created_at;
    public double exp;

    /* renamed from: t  reason: collision with root package name */
    public int f7738t;

    g() {
    }

    public String GetType() {
        switch (this.f7738t) {
            case 0:
                return "登陆";
            case 1:
                return "解锁";
            case 2:
                return "购买权限";
            case 3:
                return "购买注册码";
            case 4:
                return "购买加速";
            case 5:
                return "关注盒子";
            case 6:
                return "新建盒子";
            default:
                return "未知";
        }
    }
}
