package d5;

import i5.f0;
import i5.h0;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class h extends OutputStream implements g {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f9210a;

    /* renamed from: b  reason: collision with root package name */
    private long f9211b;

    /* renamed from: c  reason: collision with root package name */
    private File f9212c;

    /* renamed from: d  reason: collision with root package name */
    private int f9213d;

    /* renamed from: e  reason: collision with root package name */
    private long f9214e;

    /* renamed from: f  reason: collision with root package name */
    private h0 f9215f;

    public h(File file) {
        this(file, -1L);
    }

    private boolean e(int i6) {
        long j6 = this.f9211b;
        return j6 < 65536 || this.f9214e + ((long) i6) <= j6;
    }

    private boolean f(byte[] bArr) {
        b5.c[] values;
        int b6 = this.f9215f.b(bArr);
        for (b5.c cVar : b5.c.values()) {
            if (cVar != b5.c.SPLIT_ZIP && cVar.getValue() == b6) {
                return true;
            }
        }
        return false;
    }

    private void j() {
        String str;
        String n5 = f0.n(this.f9212c.getName());
        String absolutePath = this.f9212c.getAbsolutePath();
        if (this.f9212c.getParent() == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            str = this.f9212c.getParent() + System.getProperty("file.separator");
        }
        String str2 = ".z0" + (this.f9213d + 1);
        if (this.f9213d >= 9) {
            str2 = ".z" + (this.f9213d + 1);
        }
        File file = new File(str + n5 + str2);
        this.f9210a.close();
        if (file.exists()) {
            throw new IOException("split file: " + file.getName() + " already exists in the current directory, cannot rename this file");
        } else if (!this.f9212c.renameTo(file)) {
            throw new IOException("cannot rename newly created split file");
        } else {
            this.f9212c = new File(absolutePath);
            this.f9210a = new RandomAccessFile(this.f9212c, f5.f.WRITE.getValue());
            this.f9213d++;
        }
    }

    @Override // d5.g
    public int a() {
        return this.f9213d;
    }

    @Override // d5.g
    public long b() {
        return this.f9210a.getFilePointer();
    }

    public boolean c(int i6) {
        if (i6 >= 0) {
            if (e(i6)) {
                return false;
            }
            try {
                j();
                this.f9214e = 0L;
                return true;
            } catch (IOException e6) {
                throw new a5.a(e6);
            }
        }
        throw new a5.a("negative buffersize for checkBufferSizeAndStartNextSplitFile");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9210a.close();
    }

    public long d() {
        return this.f9211b;
    }

    public boolean g() {
        return this.f9211b != -1;
    }

    public void h(long j6) {
        this.f9210a.seek(j6);
    }

    public int i(int i6) {
        return this.f9210a.skipBytes(i6);
    }

    @Override // java.io.OutputStream
    public void write(int i6) {
        write(new byte[]{(byte) i6});
    }

    public h(File file, long j6) {
        this.f9215f = new h0();
        if (j6 >= 0 && j6 < 65536) {
            throw new a5.a("split length less than minimum allowed split length of 65536 Bytes");
        }
        this.f9210a = new RandomAccessFile(file, f5.f.WRITE.getValue());
        this.f9211b = j6;
        this.f9212c = file;
        this.f9213d = 0;
        this.f9214e = 0L;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) {
        long j6;
        if (i7 <= 0) {
            return;
        }
        long j7 = this.f9211b;
        if (j7 == -1) {
            this.f9210a.write(bArr, i6, i7);
            this.f9214e += i7;
            return;
        }
        long j8 = this.f9214e;
        if (j8 >= j7) {
            j();
            this.f9210a.write(bArr, i6, i7);
            j6 = i7;
        } else {
            long j9 = i7;
            if (j8 + j9 > j7) {
                if (f(bArr)) {
                    j();
                    this.f9210a.write(bArr, i6, i7);
                } else {
                    this.f9210a.write(bArr, i6, (int) (this.f9211b - this.f9214e));
                    j();
                    RandomAccessFile randomAccessFile = this.f9210a;
                    long j10 = this.f9211b;
                    long j11 = this.f9214e;
                    randomAccessFile.write(bArr, i6 + ((int) (j10 - j11)), (int) (j9 - (j10 - j11)));
                    j9 -= this.f9211b - this.f9214e;
                }
                this.f9214e = j9;
                return;
            }
            this.f9210a.write(bArr, i6, i7);
            j6 = this.f9214e + j9;
        }
        this.f9214e = j6;
    }
}
