package com.secret.prettyhezi.Server;

import android.util.Log;
/* loaded from: classes.dex */
public class m extends n {
    public int amount;
    public String content;
    public long created_at;
    public String download;
    public int duration;
    public int follow_count;
    public int height;
    public String img;
    public boolean is_report;
    public String name;
    public String nickname;
    public int pheight;
    public String[] preview;
    public int pwidth;

    /* renamed from: t  reason: collision with root package name */
    public int f7130t;
    public int unlock_count;
    public int userid;
    public int vheight;
    public String video;
    public String vod;
    public int vwidth;
    public int width;

    public int thumbHeight() {
        int i6 = this.pheight;
        if (i6 > 0) {
            return i6;
        }
        int i7 = this.height;
        if (i7 > 0) {
            return i7;
        }
        Log.e("VideoItem", "no thumbHeight");
        return 50;
    }

    public int thumbWidth() {
        int i6 = this.pwidth;
        if (i6 > 0) {
            return i6;
        }
        int i7 = this.width;
        if (i7 > 0) {
            return i7;
        }
        Log.e("VideoItem", "no thumbWidth");
        return 50;
    }

    public int videoHeight() {
        int i6 = this.vheight;
        if (i6 > 0) {
            return i6;
        }
        int i7 = this.pheight;
        if (i7 > 0) {
            return i7;
        }
        int i8 = this.height;
        if (i8 > 0) {
            return i8;
        }
        Log.e("VideoItem", "no videoHeight");
        return 50;
    }

    public int videoWidth() {
        int i6 = this.vwidth;
        if (i6 > 0) {
            return i6;
        }
        int i7 = this.pwidth;
        if (i7 > 0) {
            return i7;
        }
        int i8 = this.width;
        if (i8 > 0) {
            return i8;
        }
        Log.e("VideoItem", "no videoWidth");
        return 50;
    }
}
