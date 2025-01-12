package com.secret.prettyhezi;

import com.secret.prettyhezi.View.f0;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.secret.prettyhezi.View.t {
    boolean Q;
    int R;

    public w(ZZcINlcxH zZcINlcxH, ArrayList arrayList, int i6, boolean z5) {
        super(zZcINlcxH, com.secret.prettyhezi.Server.n.class);
        String str;
        this.Q = z5;
        this.R = i6;
        if (i6 != 4) {
            str = i6 == 5 ? "兑换年精华权限和永久精华权限的用户可以下载精华区视频" : "兑换年精华权限和永久精华权限的用户可以下载精华区视频";
            setItems((com.secret.prettyhezi.Cache.g[]) arrayList.toArray(new com.secret.prettyhezi.Cache.g[arrayList.size()]));
        }
        str = "兑换年热门权限和永久热门权限的用户可以下载影视内容";
        f(str);
        setItems((com.secret.prettyhezi.Cache.g[]) arrayList.toArray(new com.secret.prettyhezi.Cache.g[arrayList.size()]));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.t
    /* renamed from: N */
    public f0 l(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.Cache.g gVar, int i6) {
        return new f0(zZcINlcxH, i6);
    }

    @Override // com.secret.prettyhezi.View.t
    /* renamed from: O */
    public void z(com.secret.prettyhezi.Cache.g gVar, f0 f0Var) {
        super.z(gVar, f0Var);
        MainApplication.f6711r.l().h(gVar, this.Q);
    }
}
