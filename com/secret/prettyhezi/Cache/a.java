package com.secret.prettyhezi.Cache;

import g4.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes.dex */
public class a extends b {
    public static a lastItem;
    static long lastSaveTime;
    public int pageIndex;
    public int position;
    public String title;

    static {
        Load();
        lastSaveTime = 0L;
    }

    public static a GetLastItem() {
        if (lastItem == null) {
            Load();
        }
        return lastItem;
    }

    public static void Load() {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            String str = (String) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            if (str == null || str.length() <= 0) {
                return;
            }
            lastItem = (a) com.secret.prettyhezi.f.d(str, a.class);
        } catch (Exception unused) {
        }
    }

    public static void Save() {
        a aVar = lastItem;
        if (aVar != null) {
            String e6 = com.secret.prettyhezi.f.e(aVar);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(filePath());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(e6);
                objectOutputStream.close();
                fileOutputStream.close();
                lastSaveTime = System.currentTimeMillis();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
    }

    public static void SetBook(int i6, String str) {
        a aVar = new a();
        lastItem = aVar;
        aVar.id = i6;
        aVar.title = str;
        aVar.pageIndex = 0;
        aVar.position = 0;
        Save();
    }

    public static void SetPage(int i6) {
        a aVar = lastItem;
        if (aVar != null) {
            aVar.pageIndex = i6;
            Save();
        }
    }

    public static void SetPosition(int i6) {
        SetPosition(i6, false);
        if (lastItem == null || System.currentTimeMillis() - lastSaveTime <= 5000) {
            return;
        }
        lastItem.position = i6;
        Save();
    }

    public static String filePath() {
        return i.j().getFilesDir().getAbsolutePath() + File.separator + "lastBookPosition";
    }

    public static void SetPosition(int i6, boolean z5) {
        if (lastItem != null) {
            if (z5 || System.currentTimeMillis() - lastSaveTime > 5000) {
                lastItem.position = i6;
                Save();
            }
        }
    }
}
