package com.secret.prettyhezi.share;

import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Server.n;
/* loaded from: classes.dex */
public class e extends n {
    public long created_at;

    /* renamed from: t  reason: collision with root package name */
    public int f9027t;
    public int user_id;
    public double value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String GetType() {
        int i6 = this.f9027t;
        switch (i6) {
            case 1:
                return g4.i.j().s0(C0382R.string.sign_in);
            case 2:
                return "推广";
            case 3:
                return "被关注";
            case 4:
                return "盒子被关注";
            case 5:
                return "账户被取消关注";
            case 6:
                return "盒子被取消关注";
            case 7:
                return "开通一天热门视频权限";
            case 8:
                return "开通一月热门视频权限";
            case 9:
                return "开通永久热门视频权限";
            case 10:
                return "卖出";
            case 11:
                return "买入";
            case 12:
                return "卖出未成交返还";
            case 13:
                return "关注用户支出";
            case 14:
                return "关注盒子支出";
            case 15:
                return "收藏优质资源奖励";
            case 16:
                return "收藏劣质资源扣除";
            case 17:
                return "取消卖出积分返还";
            case 18:
                return "系统赠送";
            case 19:
                return "系统冻结";
            case 20:
                return "解锁扣除";
            default:
                switch (i6) {
                    case 22:
                        return "解锁收益";
                    case 23:
                        return "精华分成";
                    case 24:
                        return "举报奖励";
                    case 25:
                        return "举报扣除";
                    case 26:
                        return "永久热门权限用户登陆";
                    case 27:
                        return "永久精华权限用户登陆";
                    case 28:
                        return "手机注册赠送";
                    case 29:
                        return "兑换1月精华权限";
                    case 30:
                        return "兑换1年精华权限";
                    case 31:
                        return "兑换永久精华权限";
                    case 32:
                        return "1年热门权限用户登录";
                    case 33:
                        return "1年精华权限用户登录";
                    case 34:
                        return "积分和推广贡献值兑换永久热门权限";
                    case 35:
                        return "积分和推广贡献值兑换永久精华权限";
                    case 36:
                        return "举报失败";
                    case 37:
                        return "兑换一月热门权限";
                    case 38:
                        return "兑换一年热门权限";
                    default:
                        switch (i6) {
                            case 46:
                                return "解锁退回";
                            case 47:
                                return "举报退回";
                            case 48:
                                return "资源违规";
                            case 49:
                                return "贡献值和分享值兑换";
                            case 50:
                                return "兑换24小时视频加速权限";
                            case 51:
                                return "申请数字货币兑换积分权限";
                            case 52:
                                return "数字货币兑换积分";
                            case 53:
                                return "删除盒子扣除关注积分";
                            case 54:
                                return "系统扣除";
                            case 55:
                                return "兑换注册码";
                            case 56:
                                return "登录次数兑换注册码";
                            case 57:
                                return "短视频违规";
                            case 58:
                                return "资源违规申诉";
                            case 59:
                                return "审核成功奖励";
                            case 60:
                                return "审核失败扣除";
                            case 61:
                                return "资源申诉成功退回";
                            case 62:
                                return "积分兑换金币";
                            case 63:
                                return "金币兑换积分";
                            case 64:
                                return "积分转USDT提现";
                            case 65:
                                return "积分转USDT退回";
                            case 66:
                                return "金币游戏分成";
                            case 67:
                                return "申请专属包";
                            case 68:
                                return "邀请用户注册收益";
                            case 69:
                                return "创建盒子";
                            default:
                                return "未知" + this.f9027t;
                        }
                }
        }
    }
}
