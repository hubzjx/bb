package q2;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.exoplayer2.util.s0;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
/* loaded from: classes.dex */
public final class g extends f {

    /* renamed from: e  reason: collision with root package name */
    private final ContentResolver f12760e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f12761f;

    /* renamed from: g  reason: collision with root package name */
    private AssetFileDescriptor f12762g;

    /* renamed from: h  reason: collision with root package name */
    private FileInputStream f12763h;

    /* renamed from: i  reason: collision with root package name */
    private long f12764i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12765j;

    /* loaded from: classes.dex */
    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public g(Context context) {
        super(false);
        this.f12760e = context.getContentResolver();
    }

    @Override // q2.l
    public long b(o oVar) {
        try {
            Uri uri = oVar.f12794a;
            this.f12761f = uri;
            s(oVar);
            AssetFileDescriptor openAssetFileDescriptor = this.f12760e.openAssetFileDescriptor(uri, "r");
            this.f12762g = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                String valueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(valueOf.length() + 36);
                sb.append("Could not open file descriptor for: ");
                sb.append(valueOf);
                throw new FileNotFoundException(sb.toString());
            }
            FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
            this.f12763h = fileInputStream;
            long startOffset = openAssetFileDescriptor.getStartOffset();
            long skip = fileInputStream.skip(oVar.f12800g + startOffset) - startOffset;
            if (skip == oVar.f12800g) {
                long j6 = oVar.f12801h;
                if (j6 != -1) {
                    this.f12764i = j6;
                } else {
                    long length = openAssetFileDescriptor.getLength();
                    if (length == -1) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.f12764i = -1L;
                        } else {
                            long position = size - channel.position();
                            this.f12764i = position;
                            if (position < 0) {
                                throw new EOFException();
                            }
                        }
                    } else {
                        long j7 = length - skip;
                        this.f12764i = j7;
                        if (j7 < 0) {
                            throw new EOFException();
                        }
                    }
                }
                this.f12765j = true;
                t(oVar);
                return this.f12764i;
            }
            throw new EOFException();
        } catch (IOException e6) {
            throw new a(e6);
        }
    }

    @Override // q2.l
    public void close() {
        this.f12761f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f12763h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f12763h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f12762g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.f12762g = null;
                        if (this.f12765j) {
                            this.f12765j = false;
                            r();
                        }
                    }
                } catch (IOException e6) {
                    throw new a(e6);
                }
            } catch (IOException e7) {
                throw new a(e7);
            }
        } catch (Throwable th) {
            this.f12763h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f12762g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f12762g = null;
                    if (this.f12765j) {
                        this.f12765j = false;
                        r();
                    }
                    throw th;
                } catch (IOException e8) {
                    throw new a(e8);
                }
            } finally {
                this.f12762g = null;
                if (this.f12765j) {
                    this.f12765j = false;
                    r();
                }
            }
        }
    }

    @Override // q2.l
    public Uri k() {
        return this.f12761f;
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        long j6 = this.f12764i;
        if (j6 == 0) {
            return -1;
        }
        if (j6 != -1) {
            try {
                i7 = (int) Math.min(j6, i7);
            } catch (IOException e6) {
                throw new a(e6);
            }
        }
        int read = ((FileInputStream) s0.j(this.f12763h)).read(bArr, i6, i7);
        if (read == -1) {
            if (this.f12764i == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j7 = this.f12764i;
        if (j7 != -1) {
            this.f12764i = j7 - read;
        }
        q(read);
        return read;
    }
}
