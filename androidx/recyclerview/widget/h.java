package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    final a f2502a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(a.b bVar);

        a.b b(int i6, int i7, int i8, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.f2502a = aVar;
    }

    private int a(List list) {
        boolean z5 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((a.b) list.get(size)).f2379a != 8) {
                z5 = true;
            } else if (z5) {
                return size;
            }
        }
        return -1;
    }

    private void c(List list, int i6, a.b bVar, int i7, a.b bVar2) {
        int i8 = bVar.f2382d;
        int i9 = bVar2.f2380b;
        int i10 = i8 < i9 ? -1 : 0;
        int i11 = bVar.f2380b;
        if (i11 < i9) {
            i10++;
        }
        if (i9 <= i11) {
            bVar.f2380b = i11 + bVar2.f2382d;
        }
        int i12 = bVar2.f2380b;
        if (i12 <= i8) {
            bVar.f2382d = i8 + bVar2.f2382d;
        }
        bVar2.f2380b = i12 + i10;
        list.set(i6, bVar2);
        list.set(i7, bVar);
    }

    private void d(List list, int i6, int i7) {
        a.b bVar = (a.b) list.get(i6);
        a.b bVar2 = (a.b) list.get(i7);
        int i8 = bVar2.f2379a;
        if (i8 == 1) {
            c(list, i6, bVar, i7, bVar2);
        } else if (i8 == 2) {
            e(list, i6, bVar, i7, bVar2);
        } else if (i8 != 4) {
        } else {
            f(list, i6, bVar, i7, bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(List list) {
        while (true) {
            int a6 = a(list);
            if (a6 == -1) {
                return;
            }
            d(list, a6, a6 + 1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x009d, code lost:
        if (r0 > r14.f2380b) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c7, code lost:
        if (r0 >= r14.f2380b) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c9, code lost:
        r12.f2382d = r0 - r14.f2382d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void e(List list, int i6, a.b bVar, int i7, a.b bVar2) {
        boolean z5;
        int i8;
        int i9 = bVar.f2380b;
        int i10 = bVar.f2382d;
        boolean z6 = false;
        int i11 = bVar2.f2380b;
        if (i9 < i10) {
            if (i11 == i9 && bVar2.f2382d == i10 - i9) {
                z5 = false;
                z6 = true;
            } else {
                z5 = false;
            }
        } else if (i11 == i10 + 1 && bVar2.f2382d == i9 - i10) {
            z5 = true;
            z6 = true;
        } else {
            z5 = true;
        }
        int i12 = bVar2.f2380b;
        if (i10 < i12) {
            bVar2.f2380b = i12 - 1;
        } else {
            int i13 = bVar2.f2382d;
            if (i10 < i12 + i13) {
                bVar2.f2382d = i13 - 1;
                bVar.f2379a = 2;
                bVar.f2382d = 1;
                if (bVar2.f2382d == 0) {
                    list.remove(i7);
                    this.f2502a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i14 = bVar.f2380b;
        int i15 = bVar2.f2380b;
        a.b bVar3 = null;
        if (i14 <= i15) {
            bVar2.f2380b = i15 + 1;
        } else {
            int i16 = bVar2.f2382d;
            if (i14 < i15 + i16) {
                bVar3 = this.f2502a.b(2, i14 + 1, (i15 + i16) - i14, null);
                bVar2.f2382d = bVar.f2380b - bVar2.f2380b;
            }
        }
        if (z6) {
            list.set(i6, bVar2);
            list.remove(i7);
            this.f2502a.a(bVar);
            return;
        }
        if (z5) {
            if (bVar3 != null) {
                int i17 = bVar.f2380b;
                if (i17 > bVar3.f2380b) {
                    bVar.f2380b = i17 - bVar3.f2382d;
                }
                int i18 = bVar.f2382d;
                if (i18 > bVar3.f2380b) {
                    bVar.f2382d = i18 - bVar3.f2382d;
                }
            }
            int i19 = bVar.f2380b;
            if (i19 > bVar2.f2380b) {
                bVar.f2380b = i19 - bVar2.f2382d;
            }
            i8 = bVar.f2382d;
        } else {
            if (bVar3 != null) {
                int i20 = bVar.f2380b;
                if (i20 >= bVar3.f2380b) {
                    bVar.f2380b = i20 - bVar3.f2382d;
                }
                int i21 = bVar.f2382d;
                if (i21 >= bVar3.f2380b) {
                    bVar.f2382d = i21 - bVar3.f2382d;
                }
            }
            int i22 = bVar.f2380b;
            if (i22 >= bVar2.f2380b) {
                bVar.f2380b = i22 - bVar2.f2382d;
            }
            i8 = bVar.f2382d;
        }
        list.set(i6, bVar2);
        if (bVar.f2380b != bVar.f2382d) {
            list.set(i7, bVar);
        } else {
            list.remove(i7);
        }
        if (bVar3 != null) {
            list.add(i6, bVar3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void f(List list, int i6, a.b bVar, int i7, a.b bVar2) {
        a.b b6;
        int i8;
        int i9;
        int i10 = bVar.f2382d;
        int i11 = bVar2.f2380b;
        a.b bVar3 = null;
        if (i10 < i11) {
            bVar2.f2380b = i11 - 1;
        } else {
            int i12 = bVar2.f2382d;
            if (i10 < i11 + i12) {
                bVar2.f2382d = i12 - 1;
                b6 = this.f2502a.b(4, bVar.f2380b, 1, bVar2.f2381c);
                i8 = bVar.f2380b;
                i9 = bVar2.f2380b;
                if (i8 > i9) {
                    bVar2.f2380b = i9 + 1;
                } else {
                    int i13 = bVar2.f2382d;
                    if (i8 < i9 + i13) {
                        int i14 = (i9 + i13) - i8;
                        bVar3 = this.f2502a.b(4, i8 + 1, i14, bVar2.f2381c);
                        bVar2.f2382d -= i14;
                    }
                }
                list.set(i7, bVar);
                if (bVar2.f2382d <= 0) {
                    list.set(i6, bVar2);
                } else {
                    list.remove(i6);
                    this.f2502a.a(bVar2);
                }
                if (b6 != null) {
                    list.add(i6, b6);
                }
                if (bVar3 == null) {
                    list.add(i6, bVar3);
                    return;
                }
                return;
            }
        }
        b6 = null;
        i8 = bVar.f2380b;
        i9 = bVar2.f2380b;
        if (i8 > i9) {
        }
        list.set(i7, bVar);
        if (bVar2.f2382d <= 0) {
        }
        if (b6 != null) {
        }
        if (bVar3 == null) {
        }
    }
}
