package g4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.util.UUID;
import okhttp3.HttpUrl;
import okio.Segment;
/* loaded from: classes.dex */
public abstract class c {

    /* loaded from: classes.dex */
    public interface a {
        boolean a(File file);
    }

    public static void a(String str, boolean z5) {
        String[] list;
        File file = new File(str);
        if (file.isDirectory()) {
            for (String str2 : file.list()) {
                a(str + File.separator + str2, true);
            }
            if (!z5) {
                return;
            }
        }
        file.delete();
    }

    public static boolean b(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            FileChannel channel = fileInputStream.getChannel();
            channel.size();
            channel.transferTo(0L, channel.size(), fileOutputStream.getChannel());
            fileOutputStream.flush();
            channel.close();
            fileInputStream.close();
            fileOutputStream.close();
            m(str2);
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static void c(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static long d(String str) {
        String[] list;
        File file = new File(str);
        if (file.isDirectory()) {
            long j6 = 0;
            for (String str2 : file.list()) {
                j6 += d(str + File.separator + str2);
            }
            return j6;
        }
        return file.length();
    }

    public static boolean e(String str) {
        return new File(str).exists();
    }

    public static String f(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(i.j().getResources().getAssets().open(str)));
            StringBuilder sb = new StringBuilder((int) Segment.SHARE_MINIMUM);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static String g(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder((int) Segment.SHARE_MINIMUM);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    inputStreamReader.close();
                    fileInputStream.close();
                    return sb.toString();
                }
                sb.append(readLine + "\n");
            }
        } catch (Exception unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static String h(String str) {
        try {
            int length = (int) new File(str).length();
            if (length == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            byte[] bArr = new byte[length];
            FileInputStream fileInputStream = new FileInputStream(str);
            fileInputStream.read(bArr, 0, length);
            fileInputStream.close();
            return new String(bArr);
        } catch (Exception unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static boolean i(String str, String str2) {
        if (b(str, str2)) {
            new File(str).delete();
            return true;
        }
        return false;
    }

    public static void j(String str, a aVar) {
        String[] list;
        File file = new File(str);
        if (!file.isDirectory()) {
            if (aVar == null || aVar.a(file)) {
                file.delete();
                return;
            }
            return;
        }
        for (String str2 : file.list()) {
            j(str + File.separator + str2, aVar);
        }
    }

    public static void k(String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void l(String str, byte[] bArr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void m(String str) {
        File file = new File(str);
        file.setReadable(true, false);
        file.setWritable(true, false);
    }

    public static String n() {
        return i.j().getFilesDir().getAbsolutePath() + File.separator + UUID.randomUUID().toString();
    }
}
