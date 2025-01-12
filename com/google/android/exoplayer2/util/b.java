package com.google.android.exoplayer2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final File f4584a;

    /* renamed from: b  reason: collision with root package name */
    private final File f4585b;

    /* loaded from: classes.dex */
    private static final class a extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final FileOutputStream f4586a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4587b = false;

        public a(File file) {
            this.f4586a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f4587b) {
                return;
            }
            this.f4587b = true;
            flush();
            try {
                this.f4586a.getFD().sync();
            } catch (IOException e6) {
                n.i("AtomicFile", "Failed to sync file descriptor:", e6);
            }
            this.f4586a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            this.f4586a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i6) {
            this.f4586a.write(i6);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f4586a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i6, int i7) {
            this.f4586a.write(bArr, i6, i7);
        }
    }

    public b(File file) {
        this.f4584a = file;
        this.f4585b = new File(String.valueOf(file.getPath()).concat(".bak"));
    }

    private void e() {
        if (this.f4585b.exists()) {
            this.f4584a.delete();
            this.f4585b.renameTo(this.f4584a);
        }
    }

    public void a() {
        this.f4584a.delete();
        this.f4585b.delete();
    }

    public void b(OutputStream outputStream) {
        outputStream.close();
        this.f4585b.delete();
    }

    public boolean c() {
        return this.f4584a.exists() || this.f4585b.exists();
    }

    public InputStream d() {
        e();
        return new FileInputStream(this.f4584a);
    }

    public OutputStream f() {
        if (this.f4584a.exists()) {
            if (this.f4585b.exists()) {
                this.f4584a.delete();
            } else if (!this.f4584a.renameTo(this.f4585b)) {
                String valueOf = String.valueOf(this.f4584a);
                String valueOf2 = String.valueOf(this.f4585b);
                StringBuilder sb = new StringBuilder(valueOf.length() + 37 + valueOf2.length());
                sb.append("Couldn't rename file ");
                sb.append(valueOf);
                sb.append(" to backup file ");
                sb.append(valueOf2);
                n.h("AtomicFile", sb.toString());
            }
        }
        try {
            return new a(this.f4584a);
        } catch (FileNotFoundException e6) {
            File parentFile = this.f4584a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                String valueOf3 = String.valueOf(this.f4584a);
                StringBuilder sb2 = new StringBuilder(valueOf3.length() + 16);
                sb2.append("Couldn't create ");
                sb2.append(valueOf3);
                throw new IOException(sb2.toString(), e6);
            }
            try {
                return new a(this.f4584a);
            } catch (FileNotFoundException e7) {
                String valueOf4 = String.valueOf(this.f4584a);
                StringBuilder sb3 = new StringBuilder(valueOf4.length() + 16);
                sb3.append("Couldn't create ");
                sb3.append(valueOf4);
                throw new IOException(sb3.toString(), e7);
            }
        }
    }
}
