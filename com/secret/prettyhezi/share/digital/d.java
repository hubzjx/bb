package com.secret.prettyhezi.share.digital;

import com.secret.prettyhezi.Server.n;
/* loaded from: classes.dex */
public class d extends n {
    public static final int CANCELED = -2;
    public static final int CREATED = 0;
    public static final int FAILED = -1;
    public static final int SUCCESSED = 1;
    public String address;
    public double amount0;
    public double amount1;
    public double cny0;
    public double cny1;
    public long created_at;
    public double score0;
    public double score1;
    public int status;
    public long updated_at;

    public String StatusName() {
        int i6 = this.status;
        return i6 != -2 ? i6 != -1 ? i6 != 0 ? i6 != 1 ? "未知错误" : "已成交" : "未付款" : "失败" : "已取消";
    }
}
