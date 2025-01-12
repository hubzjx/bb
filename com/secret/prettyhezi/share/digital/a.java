package com.secret.prettyhezi.share.digital;

import java.io.Serializable;
/* loaded from: classes.dex */
class a implements Serializable {
    public double actual_amount;
    public String address;
    public int amount;
    public double cny1;
    public double cny2;
    public long created_at;
    public double fee;
    public int id;
    public double score1;
    public double score2;
    public int status;
    public String txid;
    public long updated_at;

    a() {
    }

    void SetFinished() {
        this.status = 2;
        this.updated_at = this.created_at + 108000;
        double d6 = this.cny1 + 0.12d;
        this.cny2 = d6;
        this.score2 = (this.amount / d6) * 100.0d;
        this.txid = "TTTTTT12341241234124312413424";
    }

    public String Status() {
        int i6 = this.status;
        if (i6 != -2) {
            if (i6 != -1) {
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            return "未知" + this.status;
                        }
                        return "已经完成";
                    }
                    return "审核通过";
                }
                return "等待审核";
            }
            return "已取消";
        }
        return "转账失败";
    }
}
