package com.secret.prettyhezi.Server;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends j {
    public int am;
    public a[] ts;

    /* loaded from: classes.dex */
    public static class a extends l {

        /* renamed from: m  reason: collision with root package name */
        public String f7131m;
    }

    public String[] images() {
        a[] aVarArr;
        if (this.ts == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(this.ts.length);
        for (a aVar : this.ts) {
            if (aVar.f7128p.isEmpty()) {
                break;
            }
            arrayList.add(aVar.f7128p);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
