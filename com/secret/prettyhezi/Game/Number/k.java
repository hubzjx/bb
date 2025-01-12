package com.secret.prettyhezi.Game.Number;

import com.secret.prettyhezi.Server.w;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public static a[] f6403a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f6404a;

        /* renamed from: b  reason: collision with root package name */
        public String f6405b;

        /* renamed from: c  reason: collision with root package name */
        public String f6406c;

        /* renamed from: d  reason: collision with root package name */
        public String[] f6407d;

        /* renamed from: e  reason: collision with root package name */
        public int[] f6408e;

        public a(int i6, String str, String str2, String[] strArr, int[] iArr) {
            this.f6404a = i6;
            this.f6405b = str;
            this.f6406c = str2;
            this.f6407d = strArr;
            this.f6408e = iArr;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c {
        int integralSum;
        int num = 1;
        int is_bonus_stop = 1;
        String passwd = com.secret.prettyhezi.Device.a.a();
    }

    /* loaded from: classes.dex */
    public static class c implements Serializable {
        public int id;
        public int integral_1;
        public int integral_2;
        public int integral_3;
        public int integral_4;
        public int integral_5;
        public int integral_6;
        public int integral_7;
        public int integral_8;
        public String vote_con;
        public int vote_integral;
        public int vote_multiple;
        public int vote_number;
        public int vote_type;

        public void CopyFrom(c cVar) {
            this.vote_type = cVar.vote_type;
            if (!isDXType()) {
                this.vote_con = cVar.vote_con;
                this.vote_number = cVar.vote_number;
                this.vote_multiple = cVar.vote_multiple;
                this.vote_integral = cVar.vote_integral;
                return;
            }
            this.integral_1 = cVar.integral_1;
            this.integral_2 = cVar.integral_2;
            this.integral_3 = cVar.integral_3;
            this.integral_4 = cVar.integral_4;
            this.integral_5 = cVar.integral_5;
            this.integral_6 = cVar.integral_6;
            this.integral_7 = cVar.integral_7;
            this.integral_8 = cVar.integral_8;
        }

        public String Name() {
            a aVar;
            if (isDXType()) {
                return this.integral_1 > 0 ? "大" : this.integral_2 > 0 ? "小" : this.integral_3 > 0 ? "单" : this.integral_4 > 0 ? "双" : this.integral_5 > 0 ? "大单" : this.integral_6 > 0 ? "大双" : this.integral_7 > 0 ? "小单" : this.integral_8 > 0 ? "小双" : HttpUrl.FRAGMENT_ENCODE_SET;
            }
            int i6 = 0;
            while (true) {
                a[] aVarArr = k.f6403a;
                if (i6 >= aVarArr.length) {
                    return HttpUrl.FRAGMENT_ENCODE_SET;
                }
                if (this.vote_type == aVarArr[i6].f6404a) {
                    String str = aVar.f6405b + "(" + this.vote_con + ")";
                    if (this.vote_multiple > 1) {
                        return str + "(" + this.vote_multiple + "倍)";
                    }
                    return str;
                }
                i6++;
            }
        }

        public int Value() {
            return isDXType() ? this.integral_1 + this.integral_2 + this.integral_3 + this.integral_4 + this.integral_5 + this.integral_6 + this.integral_7 + this.integral_8 : this.vote_integral;
        }

        public int calcDXType() {
            if (this.integral_1 > 0 || this.integral_2 > 0 || this.integral_3 > 0 || this.integral_4 > 0) {
                return 8;
            }
            return (this.integral_5 > 0 || this.integral_6 > 0 || this.integral_7 > 0 || this.integral_8 > 0) ? 9 : 0;
        }

        public boolean isDXType() {
            int i6 = this.vote_type;
            return i6 == 8 || i6 == 9;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends w {
        public c[] data;
    }

    /* loaded from: classes.dex */
    public static class e extends w {
        public a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {
            public int[] buttons;
            public int[] day_bonus;
            public String day_show;
            public long end_value;
            public int open;
            public int[] week_bonus;
            public String week_show;
            public int z_num;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends w {
        public a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {
            public int buy_num;
            public int end_num;
            public long expired_at;
            public int id;
            public String number_no;
            public int open_time;
            public b pl;
            public int stop_time;
        }

        /* loaded from: classes.dex */
        public static class b implements Serializable {
            public int one_number_integral;
            public int vote_type1;
            public int vote_type1_m;
            public int vote_type2;
            public int vote_type2_m;
            public int vote_type3;
            public int vote_type3_m;
            public int vote_type4;
            public int vote_type4_m;
            public int vote_type5;
            public int vote_type5_m;
            public int vote_type6;
            public int vote_type6_m;
            public int vote_type7;
            public int vote_type7_m;
            public double vote_type8;
            public double vote_type9;

            public int GetBetLimit(int i6) {
                switch (i6) {
                    case 0:
                        return this.vote_type1_m;
                    case 1:
                        return this.vote_type2_m;
                    case 2:
                        return this.vote_type3_m;
                    case 3:
                        return this.vote_type4_m;
                    case 4:
                        return this.vote_type5_m;
                    case 5:
                        return this.vote_type6_m;
                    case 6:
                        return this.vote_type7_m;
                    default:
                        return 0;
                }
            }

            public int GetWinGold(int i6) {
                switch (i6) {
                    case 0:
                        return this.vote_type1;
                    case 1:
                        return this.vote_type2;
                    case 2:
                        return this.vote_type3;
                    case 3:
                        return this.vote_type4;
                    case 4:
                        return this.vote_type5;
                    case 5:
                        return this.vote_type6;
                    case 6:
                        return this.vote_type7;
                    default:
                        return 0;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g extends w {
        a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {
            public int id;
            public int integral1Sum;
            public int integral2Sum;
            public int integral3Sum;
            public int integral4Sum;
            public int integral5Sum;
            public int integral6Sum;
            public int integral7Sum;
            public int integral8Sum;
        }
    }

    /* loaded from: classes.dex */
    public static class h extends w {
        public a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {
            public int quota_integral;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends w {
        public a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {
            public int id;
            public String open_num;
        }
    }

    static {
        a[] aVarArr = new a[8];
        f6403a = aVarArr;
        aVarArr[0] = new a(1, "直选3", "所选号码与开奖号码按位数全部相同即中奖", new String[]{"百位", "十位", "个位"}, new int[]{10, 10, 10});
        f6403a[1] = new a(2, "直选3-和值", "所选的和值与开奖号码之和的值相同即中奖", new String[]{"直选3-和值"}, new int[]{28});
        f6403a[2] = new a(3, "直选2", "所选号码与开奖号码按位数全部相同即中奖", new String[]{"十位", "个位"}, new int[]{10, 10});
        f6403a[3] = new a(4, "直选2-和值", "所选的和值与开奖号码之和的值相同即中奖", new String[]{"直选2-和值"}, new int[]{19});
        f6403a[4] = new a(5, "直选1", "所选号码与开奖号码个位数相同即中奖", new String[]{"个位"}, new int[]{10});
        f6403a[5] = new a(6, "组选3", "所选号码与开奖号相同，顺序不限，且任意两位号码相同", new String[]{"组选3"}, new int[]{10});
        f6403a[6] = new a(7, "组选6", "所选号码与开奖号码相同(顺序不限)即中奖", new String[]{"组选6"}, new int[]{10});
        f6403a[7] = new a(8, "大小单双", HttpUrl.FRAGMENT_ENCODE_SET, null, null);
    }

    public static String a(int i6) {
        switch (i6) {
            case 1:
                return "直选3";
            case 2:
                return "直选3-和值";
            case 3:
                return "直选2";
            case 4:
                return "直选2-和值";
            case 5:
                return "直选1";
            case 6:
                return "组选3";
            case 7:
                return "组选6";
            case 8:
                return "大小单双";
            case 9:
                return "大小单双组合";
            default:
                return "未知";
        }
    }
}
