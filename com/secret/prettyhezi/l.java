package com.secret.prettyhezi;

import java.io.Serializable;
/* loaded from: classes.dex */
class l extends com.secret.prettyhezi.Server.w {
    public a data;

    /* loaded from: classes.dex */
    public static class a implements Serializable {
        public boolean st;
        public com.secret.prettyhezi.Server.t vv;
    }

    l() {
    }

    public com.secret.prettyhezi.Server.t detail() {
        a aVar = this.data;
        if (aVar != null) {
            return aVar.vv;
        }
        return null;
    }
}
