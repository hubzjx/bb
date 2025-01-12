package com.secret.prettyhezi.View;

import java.io.Serializable;
/* loaded from: classes.dex */
class r implements Serializable {
    public long expire;
    public long itemCount;
    public int nextPage;
    public long total;
    public int totalPage;

    public r(int i6, int i7, long j6, long j7, long j8) {
        this.totalPage = i6;
        this.nextPage = i7;
        this.itemCount = j6;
        this.expire = j7;
        this.total = j8;
    }
}
