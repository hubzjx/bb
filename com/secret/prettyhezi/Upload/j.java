package com.secret.prettyhezi.Upload;

import java.io.Serializable;
/* loaded from: classes.dex */
class j implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    int f7472d;
    int id;
    a[] items;

    /* renamed from: t  reason: collision with root package name */
    int f7473t;

    /* loaded from: classes.dex */
    static class a implements Serializable {
        int id;
        String res;
    }

    public j(int i6, boolean z5, int i7) {
        this.id = i6;
        this.f7472d = z5 ? 1 : 0;
        this.f7473t = i7;
    }
}
