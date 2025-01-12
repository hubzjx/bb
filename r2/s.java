package r2;

import android.os.ConditionVariable;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;
import r2.a;
/* loaded from: classes.dex */
public final class s implements r2.a {

    /* renamed from: l  reason: collision with root package name */
    private static final HashSet f13013l = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    private final File f13014a;

    /* renamed from: b  reason: collision with root package name */
    private final d f13015b;

    /* renamed from: c  reason: collision with root package name */
    private final l f13016c;

    /* renamed from: d  reason: collision with root package name */
    private final f f13017d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap f13018e;

    /* renamed from: f  reason: collision with root package name */
    private final Random f13019f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f13020g;

    /* renamed from: h  reason: collision with root package name */
    private long f13021h;

    /* renamed from: i  reason: collision with root package name */
    private long f13022i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f13023j;

    /* renamed from: k  reason: collision with root package name */
    private a.C0210a f13024k;

    /* loaded from: classes.dex */
    class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConditionVariable f13025a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.f13025a = conditionVariable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (s.this) {
                this.f13025a.open();
                s.this.p();
                s.this.f13015b.c();
            }
        }
    }

    s(File file, d dVar, l lVar, f fVar) {
        if (!s(file)) {
            String valueOf = String.valueOf(file);
            StringBuilder sb = new StringBuilder(valueOf.length() + 46);
            sb.append("Another SimpleCache instance uses the folder: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
        this.f13014a = file;
        this.f13015b = dVar;
        this.f13016c = lVar;
        this.f13017d = fVar;
        this.f13018e = new HashMap();
        this.f13019f = new Random();
        this.f13020g = dVar.d();
        this.f13021h = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new a("ExoPlayer:SimpleCacheInit", conditionVariable).start();
        conditionVariable.block();
    }

    private void k(t tVar) {
        this.f13016c.m(tVar.f12974a).a(tVar);
        this.f13022i += tVar.f12976c;
        t(tVar);
    }

    private static long m(File file) {
        long nextLong = new SecureRandom().nextLong();
        long abs = nextLong == Long.MIN_VALUE ? 0L : Math.abs(nextLong);
        String valueOf = String.valueOf(Long.toString(abs, 16));
        File file2 = new File(file, ".uid".length() != 0 ? valueOf.concat(".uid") : new String(valueOf));
        if (file2.createNewFile()) {
            return abs;
        }
        String valueOf2 = String.valueOf(file2);
        StringBuilder sb = new StringBuilder(valueOf2.length() + 27);
        sb.append("Failed to create UID file: ");
        sb.append(valueOf2);
        throw new IOException(sb.toString());
    }

    private t o(String str, long j6, long j7) {
        t d6;
        k g6 = this.f13016c.g(str);
        if (g6 == null) {
            return t.g(str, j6, j7);
        }
        while (true) {
            d6 = g6.d(j6, j7);
            if (!d6.f12977d || d6.f12978e.length() == d6.f12976c) {
                break;
            }
            y();
        }
        return d6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        a.C0210a c0210a;
        if (this.f13014a.exists() || this.f13014a.mkdirs()) {
            File[] listFiles = this.f13014a.listFiles();
            if (listFiles == null) {
                String valueOf = String.valueOf(this.f13014a);
                StringBuilder sb = new StringBuilder(valueOf.length() + 38);
                sb.append("Failed to list cache directory files: ");
                sb.append(valueOf);
                String sb2 = sb.toString();
                com.google.android.exoplayer2.util.n.c("SimpleCache", sb2);
                c0210a = new a.C0210a(sb2);
            } else {
                long r5 = r(listFiles);
                this.f13021h = r5;
                if (r5 == -1) {
                    try {
                        this.f13021h = m(this.f13014a);
                    } catch (IOException e6) {
                        String valueOf2 = String.valueOf(this.f13014a);
                        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 28);
                        sb3.append("Failed to create cache UID: ");
                        sb3.append(valueOf2);
                        String sb4 = sb3.toString();
                        com.google.android.exoplayer2.util.n.d("SimpleCache", sb4, e6);
                        c0210a = new a.C0210a(sb4, e6);
                    }
                }
                try {
                    this.f13016c.n(this.f13021h);
                    f fVar = this.f13017d;
                    if (fVar != null) {
                        fVar.e(this.f13021h);
                        Map b6 = this.f13017d.b();
                        q(this.f13014a, true, listFiles, b6);
                        this.f13017d.g(b6.keySet());
                    } else {
                        q(this.f13014a, true, listFiles, null);
                    }
                    this.f13016c.r();
                    try {
                        this.f13016c.s();
                        return;
                    } catch (IOException e7) {
                        com.google.android.exoplayer2.util.n.d("SimpleCache", "Storing index file failed", e7);
                        return;
                    }
                } catch (IOException e8) {
                    String valueOf3 = String.valueOf(this.f13014a);
                    StringBuilder sb5 = new StringBuilder(valueOf3.length() + 36);
                    sb5.append("Failed to initialize cache indices: ");
                    sb5.append(valueOf3);
                    String sb6 = sb5.toString();
                    com.google.android.exoplayer2.util.n.d("SimpleCache", sb6, e8);
                    c0210a = new a.C0210a(sb6, e8);
                }
            }
        } else {
            String valueOf4 = String.valueOf(this.f13014a);
            StringBuilder sb7 = new StringBuilder(valueOf4.length() + 34);
            sb7.append("Failed to create cache directory: ");
            sb7.append(valueOf4);
            String sb8 = sb7.toString();
            com.google.android.exoplayer2.util.n.c("SimpleCache", sb8);
            c0210a = new a.C0210a(sb8);
        }
        this.f13024k = c0210a;
    }

    private void q(File file, boolean z5, File[] fileArr, Map map) {
        long j6;
        long j7;
        if (fileArr == null || fileArr.length == 0) {
            if (z5) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z5 && name.indexOf(46) == -1) {
                q(file2, false, file2.listFiles(), map);
            } else if (!z5 || (!l.o(name) && !name.endsWith(".uid"))) {
                e eVar = map != null ? (e) map.remove(name) : null;
                if (eVar != null) {
                    j7 = eVar.f12968a;
                    j6 = eVar.f12969b;
                } else {
                    j6 = -9223372036854775807L;
                    j7 = -1;
                }
                t e6 = t.e(file2, j7, j6, this.f13016c);
                if (e6 != null) {
                    k(e6);
                } else {
                    file2.delete();
                }
            }
        }
    }

    private static long r(File[] fileArr) {
        int length = fileArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            File file = fileArr[i6];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return w(name);
                } catch (NumberFormatException unused) {
                    String valueOf = String.valueOf(file);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 20);
                    sb.append("Malformed UID file: ");
                    sb.append(valueOf);
                    com.google.android.exoplayer2.util.n.c("SimpleCache", sb.toString());
                    file.delete();
                }
            }
        }
        return -1L;
    }

    private static synchronized boolean s(File file) {
        boolean add;
        synchronized (s.class) {
            add = f13013l.add(file.getAbsoluteFile());
        }
        return add;
    }

    private void t(t tVar) {
        ArrayList arrayList = (ArrayList) this.f13018e.get(tVar.f12974a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a.b) arrayList.get(size)).a(this, tVar);
            }
        }
        this.f13015b.a(this, tVar);
    }

    private void u(j jVar) {
        ArrayList arrayList = (ArrayList) this.f13018e.get(jVar.f12974a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a.b) arrayList.get(size)).b(this, jVar);
            }
        }
        this.f13015b.b(this, jVar);
    }

    private void v(t tVar, j jVar) {
        ArrayList arrayList = (ArrayList) this.f13018e.get(tVar.f12974a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a.b) arrayList.get(size)).e(this, tVar, jVar);
            }
        }
        this.f13015b.e(this, tVar, jVar);
    }

    private static long w(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    private void x(j jVar) {
        k g6 = this.f13016c.g(jVar.f12974a);
        if (g6 == null || !g6.j(jVar)) {
            return;
        }
        this.f13022i -= jVar.f12976c;
        if (this.f13017d != null) {
            String name = jVar.f12978e.getName();
            try {
                this.f13017d.f(name);
            } catch (IOException unused) {
                String valueOf = String.valueOf(name);
                com.google.android.exoplayer2.util.n.h("SimpleCache", valueOf.length() != 0 ? "Failed to remove file index entry for: ".concat(valueOf) : new String("Failed to remove file index entry for: "));
            }
        }
        this.f13016c.p(g6.f12981b);
        u(jVar);
    }

    private void y() {
        ArrayList arrayList = new ArrayList();
        for (k kVar : this.f13016c.h()) {
            Iterator it = kVar.e().iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                if (jVar.f12978e.length() != jVar.f12976c) {
                    arrayList.add(jVar);
                }
            }
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            x((j) arrayList.get(i6));
        }
    }

    private t z(String str, t tVar) {
        boolean z5;
        if (this.f13020g) {
            String name = ((File) com.google.android.exoplayer2.util.a.e(tVar.f12978e)).getName();
            long j6 = tVar.f12976c;
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = this.f13017d;
            if (fVar != null) {
                try {
                    fVar.h(name, j6, currentTimeMillis);
                } catch (IOException unused) {
                    com.google.android.exoplayer2.util.n.h("SimpleCache", "Failed to update index with new touch timestamp.");
                }
                z5 = false;
            } else {
                z5 = true;
            }
            t k6 = this.f13016c.g(str).k(tVar, currentTimeMillis, z5);
            v(tVar, k6);
            return k6;
        }
        return tVar;
    }

    @Override // r2.a
    public synchronized File a(String str, long j6, long j7) {
        k g6;
        File file;
        com.google.android.exoplayer2.util.a.g(!this.f13023j);
        l();
        g6 = this.f13016c.g(str);
        com.google.android.exoplayer2.util.a.e(g6);
        com.google.android.exoplayer2.util.a.g(g6.g(j6, j7));
        if (!this.f13014a.exists()) {
            this.f13014a.mkdirs();
            y();
        }
        this.f13015b.f(this, str, j6, j7);
        file = new File(this.f13014a, Integer.toString(this.f13019f.nextInt(10)));
        if (!file.exists()) {
            file.mkdir();
        }
        return t.i(file, g6.f12980a, j6, System.currentTimeMillis());
    }

    @Override // r2.a
    public synchronized void b(File file, long j6) {
        boolean z5 = true;
        com.google.android.exoplayer2.util.a.g(!this.f13023j);
        if (file.exists()) {
            if (j6 == 0) {
                file.delete();
                return;
            }
            t tVar = (t) com.google.android.exoplayer2.util.a.e(t.f(file, j6, this.f13016c));
            k kVar = (k) com.google.android.exoplayer2.util.a.e(this.f13016c.g(tVar.f12974a));
            com.google.android.exoplayer2.util.a.g(kVar.g(tVar.f12975b, tVar.f12976c));
            long a6 = m.a(kVar.c());
            if (a6 != -1) {
                if (tVar.f12975b + tVar.f12976c > a6) {
                    z5 = false;
                }
                com.google.android.exoplayer2.util.a.g(z5);
            }
            if (this.f13017d != null) {
                try {
                    this.f13017d.h(file.getName(), tVar.f12976c, tVar.f12979f);
                } catch (IOException e6) {
                    throw new a.C0210a(e6);
                }
            }
            k(tVar);
            try {
                this.f13016c.s();
                notifyAll();
            } catch (IOException e7) {
                throw new a.C0210a(e7);
            }
        }
    }

    @Override // r2.a
    public synchronized void c(j jVar) {
        com.google.android.exoplayer2.util.a.g(!this.f13023j);
        k kVar = (k) com.google.android.exoplayer2.util.a.e(this.f13016c.g(jVar.f12974a));
        kVar.l(jVar.f12975b);
        this.f13016c.p(kVar.f12981b);
        notifyAll();
    }

    @Override // r2.a
    public synchronized n d(String str) {
        com.google.android.exoplayer2.util.a.g(!this.f13023j);
        return this.f13016c.j(str);
    }

    @Override // r2.a
    public synchronized j e(String str, long j6, long j7) {
        com.google.android.exoplayer2.util.a.g(!this.f13023j);
        l();
        t o5 = o(str, j6, j7);
        if (o5.f12977d) {
            return z(str, o5);
        }
        if (this.f13016c.m(str).i(j6, o5.f12976c)) {
            return o5;
        }
        return null;
    }

    @Override // r2.a
    public synchronized void f(j jVar) {
        com.google.android.exoplayer2.util.a.g(!this.f13023j);
        x(jVar);
    }

    @Override // r2.a
    public synchronized void g(String str, o oVar) {
        com.google.android.exoplayer2.util.a.g(!this.f13023j);
        l();
        this.f13016c.e(str, oVar);
        try {
            this.f13016c.s();
        } catch (IOException e6) {
            throw new a.C0210a(e6);
        }
    }

    @Override // r2.a
    public synchronized j h(String str, long j6, long j7) {
        j e6;
        com.google.android.exoplayer2.util.a.g(!this.f13023j);
        l();
        while (true) {
            e6 = e(str, j6, j7);
            if (e6 == null) {
                wait();
            }
        }
        return e6;
    }

    public synchronized void l() {
        a.C0210a c0210a = this.f13024k;
        if (c0210a != null) {
            throw c0210a;
        }
    }

    public synchronized NavigableSet n(String str) {
        TreeSet treeSet;
        com.google.android.exoplayer2.util.a.g(!this.f13023j);
        k g6 = this.f13016c.g(str);
        if (g6 != null && !g6.f()) {
            treeSet = new TreeSet((Collection) g6.e());
        }
        treeSet = new TreeSet();
        return treeSet;
    }

    public s(File file, d dVar, z0.b bVar) {
        this(file, dVar, bVar, null, false, false);
    }

    public s(File file, d dVar, z0.b bVar, byte[] bArr, boolean z5, boolean z6) {
        this(file, dVar, new l(bVar, file, bArr, z5, z6), (bVar == null || z6) ? null : new f(bVar));
    }
}
