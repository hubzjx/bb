package com.secret.prettyhezi.Server;

import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class s extends w {
    static final String keySavedPages = "keySavedPages";
    public a[] data;
    static final String keySavedPagesVersion = "keySavedPagesVersion";
    public static int savedPageVersion = g4.g.a().d(keySavedPagesVersion, 0);
    public static s pages = null;

    /* loaded from: classes.dex */
    public static class a implements Serializable {
        public String content;
        public int id;
        public String name;
    }

    public static a GetItem(int i6) {
        s sVar = pages;
        if (sVar != null) {
            a[] aVarArr = sVar.data;
            if (aVarArr.length != 0) {
                for (a aVar : aVarArr) {
                    if (aVar.id == i6) {
                        return aVar;
                    }
                }
            }
        }
        return null;
    }

    public static int GetPageVersion() {
        if (savedPageVersion == 0) {
            savedPageVersion = g4.g.a().d(keySavedPagesVersion, 0);
        }
        return savedPageVersion;
    }

    public static void LoadPrevious() {
        SetPages(g4.g.a().h(keySavedPages, HttpUrl.FRAGMENT_ENCODE_SET));
    }

    public static void SavePages(int i6, String str) {
        SetPages(str);
        g4.g.a().n(keySavedPagesVersion, i6);
        g4.g.a().o(keySavedPages, str);
    }

    public static void SetPages(String str) {
        if (str.length() > 0) {
            pages = (s) com.secret.prettyhezi.f.d(str, s.class);
        }
    }
}
