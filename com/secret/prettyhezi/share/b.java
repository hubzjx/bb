package com.secret.prettyhezi.share;

import android.graphics.Bitmap;
import com.secret.prettyhezi.ZZcINlcxH;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes.dex */
public abstract class b {
    public static String a(Bitmap bitmap) {
        ZZcINlcxH j6 = g4.i.j();
        File file = new File(g4.i.j().getFilesDir() + File.separator + "tmpUploadFile" + System.currentTimeMillis() + ".jpg");
        String str = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
                str = g4.i.t(file);
            }
        } catch (Exception e6) {
            j6.q("未知错误: " + e6.getMessage());
        }
        file.delete();
        return str;
    }
}
