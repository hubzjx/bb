package com.secret.prettyhezi.User.Ticket;

import com.secret.prettyhezi.Server.n;
/* loaded from: classes.dex */
public class b extends n {
    public long created_at;
    public int source;

    /* renamed from: t  reason: collision with root package name */
    public int f7702t;
    public int user_id;
    public int value;

    public String GetName() {
        return "全站免费观看";
    }

    public String GetSource() {
        int i6 = this.source;
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? "未知原因" : "系统赠送" : "绑定手机号" : "邀请用户注册" : "新用户注册";
    }
}
