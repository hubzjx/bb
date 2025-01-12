package com.secret.prettyhezi.Cache;

import g4.i;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends b {
    static String rootFolder = i.j().getFilesDir().getAbsolutePath() + File.separator + "VideoDownload";
    public int duration;
    public long fileSize;
    public String folder;
    public int height;
    public String img;
    public String m3u8File;
    public String m3u8Url;
    public int navMode;
    public String playUrl;
    public int totalFiles;
    public ArrayList<String> tsFiles;
    public int vheight;
    public int vwidth;
    public int width;
    public long downloadPos = 0;
    public int states = 0;
    public boolean stop = false;

    public int videoHeight() {
        int i6 = this.vheight;
        return i6 > 0 ? i6 : this.height;
    }

    public int videoWidth() {
        int i6 = this.vwidth;
        return i6 > 0 ? i6 : this.width;
    }
}
