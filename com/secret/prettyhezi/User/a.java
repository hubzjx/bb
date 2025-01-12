package com.secret.prettyhezi.User;

import java.io.Serializable;
/* loaded from: classes.dex */
public class a implements Serializable {
    public transient long delay;
    public long expired_at;
    public int id;
    public String name;
    public long price;
    public String url;

    public String GetExpire() {
        return g4.i.v(this.expired_at + g4.i.o());
    }

    public boolean isExpired() {
        return (System.currentTimeMillis() / 1000) - ((this.expired_at + ((long) g4.i.o())) + 100) > 0;
    }
}
