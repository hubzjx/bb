package p0;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class b {

    /* renamed from: p0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0204b {

        /* renamed from: a  reason: collision with root package name */
        private static final b f12606a = new b();
    }

    private b() {
    }

    public static final b c() {
        return C0204b.f12606a;
    }

    private static String d(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } while (read >= 512);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str) {
        Process process;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream;
        OutputStream outputStream = null;
        try {
            process = Runtime.getRuntime().exec("sh");
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(process.getOutputStream());
                try {
                    bufferedInputStream = new BufferedInputStream(process.getInputStream());
                    try {
                        bufferedOutputStream2.write(str.getBytes());
                        bufferedOutputStream2.write(10);
                        bufferedOutputStream2.flush();
                        bufferedOutputStream2.close();
                        process.waitFor();
                        String d6 = d(bufferedInputStream);
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                        process.destroy();
                        return d6;
                    } catch (Exception unused) {
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != 0) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        outputStream = bufferedOutputStream2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                    bufferedInputStream = null;
                    bufferedOutputStream = bufferedOutputStream2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                }
            } catch (Exception unused3) {
                bufferedInputStream2 = null;
                bufferedInputStream = bufferedInputStream2;
                bufferedOutputStream = bufferedInputStream2;
                if (bufferedOutputStream != 0) {
                }
                if (bufferedInputStream != null) {
                }
                if (process != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (Exception unused4) {
            process = null;
            bufferedInputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            process = null;
            bufferedInputStream = null;
        }
    }

    public String b(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
