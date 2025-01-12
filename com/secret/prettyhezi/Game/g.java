package com.secret.prettyhezi.Game;
/* loaded from: classes.dex */
class g extends com.secret.prettyhezi.Server.n {
    long created_at;
    int overvalue;

    /* renamed from: t  reason: collision with root package name */
    int f6591t;
    int value;

    g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String GetType() {
        int i6 = this.f6591t;
        if (i6 != 98) {
            if (i6 != 99) {
                switch (i6) {
                    case 1:
                        return "积分兑换金币转入";
                    case 2:
                        return "金币兑换积分转出";
                    case 3:
                        return "游戏支出";
                    case 4:
                        return "游戏收入";
                    case 5:
                        return "系统扣除";
                    case 6:
                        return "夺宝支出";
                    case 7:
                        return "夺宝收入";
                    case 8:
                        return "猜大小撤单返回积分";
                    case 9:
                        return "夺宝取消退回";
                    case 10:
                        return "投注返点";
                    case 11:
                        return "试玩奖励";
                    case 12:
                        return "购买试玩币";
                    default:
                        return "未知";
                }
            }
            return "系统退回";
        }
        return "系统赠送";
    }

    public boolean isAdd() {
        int i6 = this.f6591t;
        return i6 == 1 || i6 == 4 || i6 == 7 || i6 == 8 || i6 == 9 || i6 == 10 || i6 == 11;
    }
}
