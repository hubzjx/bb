package q2;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.s0;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import q2.l;
/* loaded from: classes.dex */
public final class z extends f {

    /* renamed from: e  reason: collision with root package name */
    private RandomAccessFile f12895e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f12896f;

    /* renamed from: g  reason: collision with root package name */
    private long f12897g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12898h;

    /* loaded from: classes.dex */
    public static final class a implements l.a {

        /* renamed from: a  reason: collision with root package name */
        private i0 f12899a;

        @Override // q2.l.a
        /* renamed from: b */
        public z a() {
            z zVar = new z();
            i0 i0Var = this.f12899a;
            if (i0Var != null) {
                zVar.i(i0Var);
            }
            return zVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends IOException {
        public b(IOException iOException) {
            super(iOException);
        }

        public b(String str, IOException iOException) {
            super(str, iOException);
        }
    }

    public z() {
        super(false);
    }

    private static RandomAccessFile u(Uri uri) {
        try {
            return new RandomAccessFile((String) com.google.android.exoplayer2.util.a.e(uri.getPath()), "r");
        } catch (FileNotFoundException e6) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new b(e6);
            }
            throw new b(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e6);
        }
    }

    @Override // q2.l
    public long b(o oVar) {
        try {
            Uri uri = oVar.f12794a;
            this.f12896f = uri;
            s(oVar);
            RandomAccessFile u5 = u(uri);
            this.f12895e = u5;
            u5.seek(oVar.f12800g);
            long j6 = oVar.f12801h;
            if (j6 == -1) {
                j6 = this.f12895e.length() - oVar.f12800g;
            }
            this.f12897g = j6;
            if (j6 < 0) {
                throw new EOFException();
            }
            this.f12898h = true;
            t(oVar);
            return this.f12897g;
        } catch (IOException e6) {
            throw new b(e6);
        }
    }

    @Override // q2.l
    public void close() {
        this.f12896f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f12895e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e6) {
                throw new b(e6);
            }
        } finally {
            this.f12895e = null;
            if (this.f12898h) {
                this.f12898h = false;
                r();
            }
        }
    }

    @Override // q2.l
    public Uri k() {
        return this.f12896f;
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        if (this.f12897g == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) s0.j(this.f12895e)).read(bArr, i6, (int) Math.min(this.f12897g, i7));
            if (read > 0) {
                this.f12897g -= read;
                q(read);
            }
            return read;
        } catch (IOException e6) {
            throw new b(e6);
        }
    }
}
