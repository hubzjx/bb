package c5;

import f5.f;
import i5.f0;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a extends RandomAccessFile {

    /* renamed from: a  reason: collision with root package name */
    private long f3256a;

    /* renamed from: b  reason: collision with root package name */
    private File[] f3257b;

    /* renamed from: c  reason: collision with root package name */
    private RandomAccessFile f3258c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f3259d;

    /* renamed from: e  reason: collision with root package name */
    private int f3260e;

    /* renamed from: f  reason: collision with root package name */
    private String f3261f;

    public a(File file, String str, File[] fileArr) {
        super(file, str);
        this.f3259d = new byte[1];
        this.f3260e = 0;
        super.close();
        if (f.WRITE.getValue().equals(str)) {
            throw new IllegalArgumentException("write mode is not allowed for NumberedSplitRandomAccessFile");
        }
        a(fileArr);
        this.f3258c = new RandomAccessFile(file, str);
        this.f3257b = fileArr;
        this.f3256a = file.length();
        this.f3261f = str;
    }

    private void a(File[] fileArr) {
        int i6 = 1;
        for (File file : fileArr) {
            String h6 = f0.h(file);
            try {
                if (i6 != Integer.parseInt(h6)) {
                    throw new IOException("Split file number " + i6 + " does not exist");
                }
                i6++;
            } catch (NumberFormatException unused) {
                throw new IOException("Split file extension not in expected format. Found: " + h6 + " expected of format: .001, .002, etc");
            }
        }
    }

    private void c(int i6) {
        if (this.f3260e == i6) {
            return;
        }
        if (i6 > this.f3257b.length - 1) {
            throw new IOException("split counter greater than number of split files");
        }
        RandomAccessFile randomAccessFile = this.f3258c;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        this.f3258c = new RandomAccessFile(this.f3257b[i6], this.f3261f);
        this.f3260e = i6;
    }

    public void b() {
        c(this.f3257b.length - 1);
    }

    public void d(long j6) {
        this.f3258c.seek(j6);
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() {
        return this.f3258c.getFilePointer();
    }

    @Override // java.io.RandomAccessFile
    public long length() {
        return this.f3258c.length();
    }

    @Override // java.io.RandomAccessFile
    public int read() {
        if (read(this.f3259d) == -1) {
            return -1;
        }
        return this.f3259d[0] & 255;
    }

    @Override // java.io.RandomAccessFile
    public void seek(long j6) {
        int i6 = (int) (j6 / this.f3256a);
        if (i6 != this.f3260e) {
            c(i6);
        }
        this.f3258c.seek(j6 - (i6 * this.f3256a));
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i6, int i7) {
        int read = this.f3258c.read(bArr, i6, i7);
        if (read == -1) {
            int i8 = this.f3260e;
            if (i8 == this.f3257b.length - 1) {
                return -1;
            }
            c(i8 + 1);
            return read(bArr, i6, i7);
        }
        return read;
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr, int i6, int i7) {
        throw new UnsupportedOperationException();
    }
}
