package com.secret.prettyhezi.message;

import com.secret.prettyhezi.Server.n;
/* loaded from: classes.dex */
public class a extends n {
    public static final int STATUS_APPLY = 1;
    public static final int STATUS_TALK = 0;
    public static final int TYPE_CHAT = 2;
    public static final int TYPE_CODE = 1;
    public static final int TYPE_SCORE = 0;
    public long created_at;
    public String description;
    public int msgs;
    public String name;

    /* renamed from: o  reason: collision with root package name */
    public int f8690o;

    /* renamed from: t  reason: collision with root package name */
    public int f8691t;
    public int user_id;

    public String getStatus() {
        int i6 = this.f8691t;
        return i6 != 0 ? i6 != 1 ? "未知" : "申诉中" : "协商中";
    }

    public String getTypeAndStatus() {
        return getTypeName() + " | " + getStatus();
    }

    public String getTypeName() {
        int i6 = this.f8690o;
        return i6 != 0 ? i6 != 1 ? i6 != 2 ? "未知" : "普通聊天" : "注册码交易" : "积分交易";
    }
}
