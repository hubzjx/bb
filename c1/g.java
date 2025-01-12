package c1;

import android.net.Uri;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l1.h0;
/* loaded from: classes.dex */
public final class g implements o {

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f3205m = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7};

    /* renamed from: n  reason: collision with root package name */
    private static final Constructor f3206n;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3207b;

    /* renamed from: c  reason: collision with root package name */
    private int f3208c;

    /* renamed from: d  reason: collision with root package name */
    private int f3209d;

    /* renamed from: e  reason: collision with root package name */
    private int f3210e;

    /* renamed from: f  reason: collision with root package name */
    private int f3211f;

    /* renamed from: g  reason: collision with root package name */
    private int f3212g;

    /* renamed from: h  reason: collision with root package name */
    private int f3213h;

    /* renamed from: i  reason: collision with root package name */
    private int f3214i;

    /* renamed from: k  reason: collision with root package name */
    private int f3216k;

    /* renamed from: j  reason: collision with root package name */
    private int f3215j = 1;

    /* renamed from: l  reason: collision with root package name */
    private int f3217l = 112800;

    static {
        Constructor constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(i.class).getConstructor(Integer.TYPE);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e6) {
            throw new RuntimeException("Error instantiating FLAC extension", e6);
        }
        f3206n = constructor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [f1.c] */
    /* JADX WARN: Type inference failed for: r4v11, types: [g1.e] */
    /* JADX WARN: Type inference failed for: r4v12, types: [h1.f] */
    /* JADX WARN: Type inference failed for: r4v14, types: [i1.l] */
    /* JADX WARN: Type inference failed for: r4v15, types: [j1.d] */
    /* JADX WARN: Type inference failed for: r4v16, types: [l1.a0] */
    /* JADX WARN: Type inference failed for: r4v17, types: [l1.h0] */
    /* JADX WARN: Type inference failed for: r4v19, types: [m1.b] */
    /* JADX WARN: Type inference failed for: r4v2, types: [l1.e] */
    /* JADX WARN: Type inference failed for: r4v3, types: [l1.h] */
    /* JADX WARN: Type inference failed for: r4v4, types: [d1.b] */
    /* JADX WARN: Type inference failed for: r4v6, types: [e1.d] */
    private void c(int i6, List list) {
        l1.b bVar;
        switch (i6) {
            case 0:
                bVar = new l1.b();
                break;
            case 1:
                bVar = new l1.e();
                break;
            case 2:
                bVar = new l1.h(this.f3208c | (this.f3207b ? 1 : 0));
                break;
            case 3:
                bVar = new d1.b(this.f3209d | (this.f3207b ? 1 : 0));
                break;
            case 4:
                Constructor constructor = f3206n;
                if (constructor == null) {
                    bVar = new e1.d(this.f3210e);
                    break;
                } else {
                    try {
                        list.add((i) constructor.newInstance(Integer.valueOf(this.f3210e)));
                        return;
                    } catch (Exception e6) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e6);
                    }
                }
            case 5:
                bVar = new f1.c();
                break;
            case 6:
                bVar = new g1.e(this.f3211f);
                break;
            case 7:
                bVar = new h1.f(this.f3214i | (this.f3207b ? 1 : 0));
                break;
            case 8:
                list.add(new i1.g(this.f3213h));
                bVar = new i1.l(this.f3212g);
                break;
            case 9:
                bVar = new j1.d();
                break;
            case 10:
                bVar = new l1.a0();
                break;
            case 11:
                bVar = new h0(this.f3215j, this.f3216k, this.f3217l);
                break;
            case 12:
                bVar = new m1.b();
                break;
            default:
                return;
        }
        list.add(bVar);
    }

    @Override // c1.o
    public synchronized i[] a() {
        return b(Uri.EMPTY, new HashMap());
    }

    @Override // c1.o
    public synchronized i[] b(Uri uri, Map map) {
        ArrayList arrayList;
        int[] iArr;
        arrayList = new ArrayList(14);
        int b6 = com.google.android.exoplayer2.util.j.b(map);
        if (b6 != -1) {
            c(b6, arrayList);
        }
        int c6 = com.google.android.exoplayer2.util.j.c(uri);
        if (c6 != -1 && c6 != b6) {
            c(c6, arrayList);
        }
        for (int i6 : f3205m) {
            if (i6 != b6 && i6 != c6) {
                c(i6, arrayList);
            }
        }
        return (i[]) arrayList.toArray(new i[arrayList.size()]);
    }
}
