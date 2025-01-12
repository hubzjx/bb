package w4;

import b5.b;
import b5.e;
import e5.k;
import e5.p;
import e5.q;
import f5.f;
import h5.d;
import h5.e;
import i5.f0;
import i5.i0;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private File f14132a;

    /* renamed from: b  reason: collision with root package name */
    private p f14133b;

    /* renamed from: c  reason: collision with root package name */
    private g5.a f14134c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14135d;

    /* renamed from: e  reason: collision with root package name */
    private char[] f14136e;

    /* renamed from: f  reason: collision with root package name */
    private e f14137f;

    /* renamed from: g  reason: collision with root package name */
    private Charset f14138g;

    /* renamed from: h  reason: collision with root package name */
    private ThreadFactory f14139h;

    /* renamed from: k  reason: collision with root package name */
    private ExecutorService f14140k;

    /* renamed from: l  reason: collision with root package name */
    private int f14141l;

    /* renamed from: m  reason: collision with root package name */
    private List f14142m;

    public a(File file, char[] cArr) {
        this.f14137f = new e();
        this.f14138g = null;
        this.f14141l = _BufferKt.SEGMENTING_THRESHOLD;
        this.f14142m = new ArrayList();
        if (file == null) {
            throw new IllegalArgumentException("input zip file parameter is null");
        }
        this.f14132a = file;
        this.f14136e = cArr;
        this.f14135d = false;
        this.f14134c = new g5.a();
    }

    private e.b c() {
        if (this.f14135d) {
            if (this.f14139h == null) {
                this.f14139h = Executors.defaultThreadFactory();
            }
            this.f14140k = Executors.newSingleThreadExecutor(this.f14139h);
        }
        return new e.b(this.f14140k, this.f14135d, this.f14134c);
    }

    private k d() {
        return new k(this.f14138g, this.f14141l);
    }

    private void e() {
        p pVar = new p();
        this.f14133b = pVar;
        pVar.q(this.f14132a);
    }

    private RandomAccessFile f() {
        if (f0.p(this.f14132a)) {
            c5.a aVar = new c5.a(this.f14132a, f.READ.getValue(), f0.e(this.f14132a));
            aVar.b();
            return aVar;
        }
        return new RandomAccessFile(this.f14132a, f.READ.getValue());
    }

    private void g() {
        if (this.f14133b != null) {
            return;
        }
        if (!this.f14132a.exists()) {
            e();
        } else if (!this.f14132a.canRead()) {
            throw new a5.a("no read access for the input zip file");
        } else {
            try {
                RandomAccessFile f6 = f();
                p h6 = new b().h(f6, d());
                this.f14133b = h6;
                h6.q(this.f14132a);
                if (f6 != null) {
                    f6.close();
                }
            } catch (a5.a e6) {
                throw e6;
            } catch (IOException e7) {
                throw new a5.a(e7);
            }
        }
    }

    public void a(String str, q qVar) {
        if (!i0.d(str)) {
            throw new a5.a("file to add is null or empty");
        }
        b(Collections.singletonList(new File(str)), qVar);
    }

    public void b(List list, q qVar) {
        if (list == null || list.size() == 0) {
            throw new a5.a("input file List is null or empty");
        }
        if (qVar == null) {
            throw new a5.a("input parameters are null");
        }
        g();
        if (this.f14133b == null) {
            throw new a5.a("internal error: zip model is null");
        }
        if (this.f14132a.exists() && this.f14133b.h()) {
            throw new a5.a("Zip file already exists. Zip file format does not allow updating split/spanned files");
        }
        new d(this.f14133b, this.f14136e, this.f14137f, c()).e(new d.a(list, qVar, d()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        for (InputStream inputStream : this.f14142m) {
            inputStream.close();
        }
        this.f14142m.clear();
    }

    public String toString() {
        return this.f14132a.toString();
    }

    public a(String str, char[] cArr) {
        this(new File(str), cArr);
    }
}
