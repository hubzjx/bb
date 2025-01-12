package com.secret.prettyhezi;

import com.secret.prettyhezi.Server.d0;
import java.io.Serializable;
/* loaded from: classes.dex */
class v extends com.secret.prettyhezi.Server.w {
    public a data;

    /* loaded from: classes.dex */
    public static class a implements Serializable {
        public boolean st;
        public d0 vv;
    }

    v() {
    }

    public d0 detail() {
        a aVar = this.data;
        if (aVar != null) {
            return aVar.vv;
        }
        return null;
    }
}
