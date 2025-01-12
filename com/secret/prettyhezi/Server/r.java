package com.secret.prettyhezi.Server;

import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class r extends w {
    public static final String keyCheckedNoticeVersion = "keyCheckedNoticeVersion";
    static final String keySavedNotices = "keySavedNotices";
    public a data;
    static final String keySavedNoticeVersion = "keySavedNoticeVersion";
    public static int savedNoticeVersion = g4.g.a().d(keySavedNoticeVersion, 0);
    public static r notices = null;

    /* loaded from: classes.dex */
    public static class a implements Serializable {
        public q[] items;
        public int pages;
    }

    public static q GetItem(int i6) {
        r rVar = notices;
        if (rVar != null) {
            q[] qVarArr = rVar.data.items;
            if (qVarArr.length != 0) {
                for (q qVar : qVarArr) {
                    if (qVar.id == i6) {
                        return qVar;
                    }
                }
            }
        }
        return null;
    }

    public static int GetNoticeVersion() {
        if (savedNoticeVersion == 0) {
            savedNoticeVersion = g4.g.a().d(keySavedNoticeVersion, 0);
        }
        return savedNoticeVersion;
    }

    public static q GetPopItem() {
        r rVar = notices;
        if (rVar != null) {
            q[] qVarArr = rVar.data.items;
            if (qVarArr.length != 0) {
                for (q qVar : qVarArr) {
                    if (qVar.pop) {
                        return qVar;
                    }
                }
            }
        }
        return null;
    }

    public static void LoadPrevious() {
        SetNotices(g4.g.a().h(keySavedNotices, HttpUrl.FRAGMENT_ENCODE_SET));
    }

    public static void SaveNotices(int i6, String str) {
        SetNotices(str);
        g4.g.a().n(keySavedNoticeVersion, i6);
        g4.g.a().o(keySavedNotices, str);
    }

    public static void SetNotices(String str) {
        if (str.length() > 0) {
            notices = (r) com.secret.prettyhezi.f.d(str, r.class);
        }
    }
}
