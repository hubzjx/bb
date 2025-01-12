package com.secret.prettyhezi.Upload;

import java.io.Serializable;
/* loaded from: classes.dex */
public class w extends com.secret.prettyhezi.Server.n {
    public static final int APPEALED = -8;
    public static final int FAILED = -3;
    public static final int HANDLING = 0;
    public static final int HOT = 3;
    public static final int NORMAL = 2;
    public static final int REJECTED = -6;
    public static final int REMOVED = -1;
    public static final int TIME_OUT = -2;
    public static final int UNLOCKED = 100;
    public long ct;
    public String na;
    public a rp;
    public int st;

    /* renamed from: t  reason: collision with root package name */
    public int f7515t;

    /* loaded from: classes.dex */
    public static class a implements Serializable {
        public String la;
    }

    public String Status() {
        int i6 = this.st;
        if (i6 != -8) {
            if (i6 != -6) {
                if (i6 != 0) {
                    if (i6 != -3) {
                        if (i6 != -2) {
                            return "未知状态:" + this.st;
                        }
                        return "上传超时";
                    }
                    return "上传失败";
                }
                return "上传或处理中";
            }
            return "资源违规(点击申诉)";
        }
        return "已申诉";
    }
}
