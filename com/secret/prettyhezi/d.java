package com.secret.prettyhezi;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public class d implements Serializable {
    public static a Audio = null;
    public static a Book = null;
    public static a Box = null;
    public static a Film = null;
    public static a Gallery = null;
    public static int MAX_HISTORY_ITEMS = 0;
    public static a Photo = null;
    public static a Upload = null;
    public static a Video = null;
    public static String historyFolder = "history4";

    /* loaded from: classes.dex */
    public static class a implements Serializable {
        String filePathName;
        ArrayList<com.secret.prettyhezi.Server.n> items = new ArrayList<>();

        public a(String str, Class<com.secret.prettyhezi.Server.n[]> cls) {
            StringBuilder sb = new StringBuilder();
            sb.append(g4.i.j().getFilesDir().getAbsolutePath());
            String str2 = File.separator;
            sb.append(str2);
            sb.append(d.historyFolder);
            sb.append(str2);
            sb.append(str);
            this.filePathName = sb.toString();
            Load2(cls);
        }

        private void removeItem(int i6) {
            for (int i7 = 0; i7 < this.items.size(); i7++) {
                if (this.items.get(i7).id == i6) {
                    this.items.remove(i7);
                    return;
                }
            }
        }

        public boolean Load2(Class<com.secret.prettyhezi.Server.n[]> cls) {
            try {
                String g6 = g4.c.g(this.filePathName + ".json");
                if (g6.isEmpty()) {
                    return false;
                }
                this.items = new ArrayList<>(Arrays.asList((com.secret.prettyhezi.Server.n[]) f.b(g6, cls)));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public void Save() {
            try {
                g4.c.k(this.filePathName + ".json", f.e(this.items.toArray()));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        public void addItem(com.secret.prettyhezi.Server.n nVar) {
            removeItem(nVar.id);
            int size = this.items.size();
            int i6 = d.MAX_HISTORY_ITEMS;
            if (size >= i6) {
                this.items.remove(i6 - 1);
            }
            this.items.add(0, nVar);
            Save();
        }

        public void clear() {
            this.items.clear();
            Save();
        }

        public void removeItem(com.secret.prettyhezi.Server.n nVar) {
            removeItem(nVar.id);
            Save();
        }
    }

    static {
        File file = new File(g4.i.j().getFilesDir().getAbsolutePath() + File.separator + historyFolder);
        if (!file.exists()) {
            file.mkdir();
        }
        Box = new a("box", com.secret.prettyhezi.Server.d[].class);
        Photo = new a("photo", com.secret.prettyhezi.Server.h[].class);
        Gallery = new a("gallery", com.secret.prettyhezi.Server.h[].class);
        Audio = new a("audio", com.secret.prettyhezi.Server.h[].class);
        Video = new a("video", com.secret.prettyhezi.Server.h[].class);
        Film = new a("film", com.secret.prettyhezi.Server.h[].class);
        Upload = new a("uploadHis", com.secret.prettyhezi.Server.h[].class);
        Book = new a("book4", com.secret.prettyhezi.Server.h[].class);
        MAX_HISTORY_ITEMS = 200;
    }

    public static a GetModeItems(int i6) {
        switch (i6) {
            case 1:
                return Photo;
            case 2:
                return Video;
            case 3:
                return Book;
            case 4:
                return Film;
            case 5:
                return Upload;
            case 6:
                return Gallery;
            case 7:
                return Audio;
            default:
                return null;
        }
    }

    public static void clearAll() {
        Box.clear();
        Photo.clear();
        Gallery.clear();
        Audio.clear();
        Video.clear();
        Film.clear();
        Upload.clear();
        Book.clear();
    }
}
