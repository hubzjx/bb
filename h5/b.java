package h5;

import e5.i;
import e5.p;
import h5.e;
import i5.f0;
import java.io.File;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class b extends e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(i iVar, i iVar2) {
            if (iVar.j().equals(iVar2.j())) {
                return 0;
            }
            return iVar.P() < iVar2.P() ? -1 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e.b bVar) {
        super(bVar);
    }

    private int n(List list, i iVar) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (((i) list.get(i6)).equals(iVar)) {
                return i6;
            }
        }
        throw new a5.a("Could not find file header in list of central directory file headers");
    }

    private void q(File file, File file2) {
        if (!file.delete()) {
            throw new a5.a("cannot delete old zip file");
        }
        if (!file2.renameTo(file)) {
            throw new a5.a("cannot rename modified zip file");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(boolean z5, File file, File file2) {
        if (z5) {
            q(file, file2);
        } else if (!file2.delete()) {
            throw new a5.a("Could not delete temporary file");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List l(List list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long m(RandomAccessFile randomAccessFile, OutputStream outputStream, long j6, long j7, g5.a aVar, int i6) {
        f0.d(randomAccessFile, outputStream, j6, j6 + j7, aVar, i6);
        return j7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long o(List list, i iVar, p pVar) {
        int n5 = n(list, iVar);
        return n5 == list.size() + (-1) ? b5.d.e(pVar) : ((i) list.get(n5 + 1)).P();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File p(String str) {
        Random random = new Random();
        File file = new File(str + random.nextInt(10000));
        while (file.exists()) {
            file = new File(str + random.nextInt(10000));
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(List list, p pVar, i iVar, long j6) {
        int n5 = n(list, iVar);
        if (n5 == -1) {
            throw new a5.a("Could not locate modified file header in zipModel");
        }
        while (true) {
            n5++;
            if (n5 >= list.size()) {
                return;
            }
            i iVar2 = (i) list.get(n5);
            iVar2.W(iVar2.P() + j6);
            if (pVar.i() && iVar2.p() != null && iVar2.p().e() != -1) {
                iVar2.p().i(iVar2.p().e() + j6);
            }
        }
    }
}
