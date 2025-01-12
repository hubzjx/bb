package f4;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.secret.prettyhezi.MainApplication;
import g4.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    static int f9897a;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9898a;

        a(String str) {
            this.f9898a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f9898a, true);
        }
    }

    public static void a(String str, boolean z5) {
        int lastIndexOf = str.lastIndexOf(46);
        String str2 = "BeautyBox_" + f9897a + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ((lastIndexOf < 0 || lastIndexOf < str.length() + (-7)) ? ".mp4" : str.substring(lastIndexOf).toLowerCase());
        f9897a++;
        StringBuilder sb = new StringBuilder();
        String str3 = File.separator;
        sb.append(str3);
        sb.append("BeautyBox");
        String sb2 = sb.toString();
        String str4 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).toString() + sb2;
        String str5 = str4 + str3 + str2;
        boolean z6 = !str.startsWith(MainApplication.f6711r.getFilesDir().getAbsolutePath());
        if (Build.VERSION.SDK_INT >= 29) {
            ContentResolver contentResolver = i.j().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str2);
            contentValues.put("mime_type", "video/mp4");
            contentValues.put("relative_path", Environment.DIRECTORY_MOVIES + sb2);
            try {
                OutputStream openOutputStream = contentResolver.openOutputStream(contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues));
                if (z6) {
                    b.d(str, openOutputStream);
                } else {
                    FileInputStream fileInputStream = new FileInputStream(str);
                    byte[] bArr = new byte[40960];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        openOutputStream.write(bArr, 0, read);
                    }
                    openOutputStream.flush();
                    fileInputStream.close();
                    openOutputStream.close();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } else {
            File file = new File(str4);
            if (!file.exists()) {
                file.mkdir();
            }
            if (z6) {
                b.e(str, str5);
            } else {
                g4.c.b(str, str5);
            }
            i.j().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + str5)));
        }
        if (z5) {
            i.j().H("Saved to " + str5.substring(Environment.getExternalStorageDirectory().getAbsolutePath().length()));
        }
    }

    public static void b(String str) {
        i.j().r(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, new a(str));
    }
}
