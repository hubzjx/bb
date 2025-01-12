package com.secret.prettyhezi.ScoreExchange;

import com.secret.prettyhezi.Server.n;
/* loaded from: classes.dex */
public class b extends n {
    public static final int APPEAL = 4;
    public static final int AVAILABLE = 0;
    public static final int BUY_CANCEL_CANNOT_PAY = -3;
    public static final int BUY_CANCEL_CANNOT_PRICE = -4;
    public static final int BUY_CANCEL_NORMAL = -2;
    public static final int CANCEL_BUY_TIME_OUT = -7;
    public static final int CANCEL_NOT_PAY = -8;
    public static final int CANCEL_SYS = -5;
    public static final int CANCEL_TIME_OUT = -6;
    public static final int OCCUPIED = 1;
    public static final int PAYED = 2;
    public static final int PAY_SUCCESS = 3;
    public static final int SELL_CANCEL = -1;
    public int amount;
    public int chat_id;
    public long create_time;
    public String[] paycode;
    public String payment;
    public double price;
    public int seller_id;
    public int status;
    public long update_time;

    public String Status() {
        switch (this.status) {
            case -8:
                return "未支付";
            case CANCEL_BUY_TIME_OUT /* -7 */:
                return "支付超时";
            case -6:
                return "超时";
            case CANCEL_SYS /* -5 */:
                return "系统取消";
            case BUY_CANCEL_CANNOT_PRICE /* -4 */:
                return "金额不符";
            case -3:
                return "无法支付";
            case -2:
                return "买家取消";
            case -1:
                return "卖家取消";
            case 0:
                return "买入";
            case 1:
                return "已下单";
            case 2:
                return "已支付";
            case 3:
                return "已完成";
            case 4:
                return "申诉中";
            default:
                return "未知";
        }
    }

    public boolean canTalk() {
        int i6 = this.status;
        return i6 == 1 || i6 == 2 || i6 == 4;
    }

    public boolean inProgress() {
        return this.status == 1;
    }
}
