package com.secret.prettyhezi.message;

import com.secret.prettyhezi.Server.w;
import java.io.Serializable;
/* loaded from: classes.dex */
public class d extends w {
    public a data;

    /* loaded from: classes.dex */
    public static class a implements Serializable {
        public int announce;
        public long created_at;
        public int message;
        public int remind;

        public int GetTotalCount() {
            return this.announce + this.remind + this.message;
        }

        public int GetTotalKeyCount() {
            return this.announce + this.message;
        }
    }
}
