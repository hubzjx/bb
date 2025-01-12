package h5;

import d5.h;
import e5.i;
import e5.k;
import e5.p;
import g5.a;
import h5.e;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class f extends b {

    /* renamed from: d  reason: collision with root package name */
    private final p f10790d;

    /* renamed from: e  reason: collision with root package name */
    private final b5.e f10791e;

    /* loaded from: classes.dex */
    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        private final List f10792b;

        public a(List list, k kVar) {
            super(kVar);
            this.f10792b = list;
        }
    }

    public f(p pVar, b5.e eVar, e.b bVar) {
        super(bVar);
        this.f10790d = pVar;
        this.f10791e = eVar;
    }

    private List u(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (b5.d.c(this.f10790d, str) != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private long v(long j6) {
        if (j6 != Long.MIN_VALUE) {
            return -j6;
        }
        throw new ArithmeticException("long overflow");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean w(i iVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if ((str.endsWith("/") && iVar.j().startsWith(str)) || iVar.j().equals(str)) {
                return true;
            }
            while (it.hasNext()) {
            }
        }
        return false;
    }

    private void x(List list, i iVar, long j6) {
        r(list, this.f10790d, iVar, v(j6));
        e5.f b6 = this.f10790d.b();
        b6.n(b6.g() - j6);
        b6.p(b6.h() - 1);
        if (b6.i() > 0) {
            b6.q(b6.i() - 1);
        }
        if (this.f10790d.i()) {
            this.f10790d.f().o(this.f10790d.f().e() - j6);
            this.f10790d.f().s(this.f10790d.f().h() - 1);
            this.f10790d.e().g(this.f10790d.e().d() - j6);
        }
    }

    @Override // h5.e
    protected a.c g() {
        return a.c.REMOVE_ENTRY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h5.e
    /* renamed from: s */
    public long d(a aVar) {
        return this.f10790d.g().length();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h5.e
    /* renamed from: t */
    public void f(a aVar, g5.a aVar2) {
        List list;
        if (this.f10790d.h()) {
            throw new a5.a("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
        List u5 = u(aVar.f10792b);
        if (u5.isEmpty()) {
            return;
        }
        File p5 = p(this.f10790d.g().getPath());
        try {
            h hVar = new h(p5);
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.f10790d.g(), f5.f.READ.getValue());
            try {
                List<i> l6 = l(this.f10790d.a().a());
                long j6 = 0;
                for (i iVar : l6) {
                    long o5 = o(l6, iVar, this.f10790d) - hVar.b();
                    if (w(iVar, u5)) {
                        x(l6, iVar, o5);
                        if (!this.f10790d.a().a().remove(iVar)) {
                            throw new a5.a("Could not remove entry from list of central directory headers");
                        }
                        j6 += o5;
                        list = l6;
                    } else {
                        list = l6;
                        j6 += super.m(randomAccessFile, hVar, j6, o5, aVar2, aVar.f10779a.a());
                    }
                    j();
                    l6 = list;
                }
                this.f10791e.d(this.f10790d, hVar, aVar.f10779a.b());
                randomAccessFile.close();
                hVar.close();
                k(true, this.f10790d.g(), p5);
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            k(false, this.f10790d.g(), p5);
            throw th3;
        }
    }
}
