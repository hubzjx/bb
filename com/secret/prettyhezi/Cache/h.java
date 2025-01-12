package com.secret.prettyhezi.Cache;
/* loaded from: classes.dex */
public class h extends f {
    public static final int COMPLETED = 2;
    public static final int DOWNLOADING = 1;
    public static final int ERROR = 4;
    public static final int FAILED = 3;
    public static final int WAITING = 0;
    public long fileSize = 0;
    public long downloadPos = 0;
    public String downloadFile = null;
    public String url = null;
    public int states = 0;
    public boolean stop = false;
}
