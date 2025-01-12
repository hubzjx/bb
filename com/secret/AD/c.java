package com.secret.AD;

import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.g;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f5903a;

    public static ArrayList a(int i6) {
        g.a[] aVarArr;
        ArrayList arrayList = new ArrayList();
        if (b(i6)) {
            for (g.a aVar : MainApplication.f6711r.k().ads) {
                if (aVar.type == i6) {
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static boolean b(int i6) {
        MainApplication mainApplication = MainApplication.f6711r;
        if (mainApplication == null || mainApplication.k() == null || MainApplication.f6711r.k().ads == null) {
            return false;
        }
        if (f5903a == null) {
            f5903a = new boolean[10];
            for (g.a aVar : MainApplication.f6711r.k().ads) {
                f5903a[aVar.type] = true;
            }
        }
        return f5903a[i6];
    }
}
