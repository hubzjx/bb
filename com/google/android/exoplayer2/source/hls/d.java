package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.k0;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import l1.h0;
import n1.a;
/* loaded from: classes.dex */
public final class d implements h {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f4261d = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: b  reason: collision with root package name */
    private final int f4262b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4263c;

    public d() {
        this(0, true);
    }

    private static void b(int i6, List list) {
        if (i6 == -1 || list.contains(Integer.valueOf(i6))) {
            return;
        }
        list.add(Integer.valueOf(i6));
    }

    private c1.i d(int i6, s0 s0Var, List list, k0 k0Var) {
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 7) {
                        if (i6 != 8) {
                            if (i6 != 11) {
                                if (i6 != 13) {
                                    return null;
                                }
                                return new u(s0Var.f4047c, k0Var);
                            }
                            return f(this.f4262b, this.f4263c, s0Var, list, k0Var);
                        }
                        return e(k0Var, s0Var, list);
                    }
                    return new h1.f(0, 0L);
                }
                return new l1.h();
            }
            return new l1.e();
        }
        return new l1.b();
    }

    private static i1.g e(k0 k0Var, s0 s0Var, List list) {
        int i6 = g(s0Var) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new i1.g(i6, k0Var, null, list);
    }

    private static h0 f(int i6, boolean z5, s0 s0Var, List list, k0 k0Var) {
        int i7 = i6 | 16;
        if (list != null) {
            i7 |= 32;
        } else {
            list = z5 ? Collections.singletonList(new s0.b().e0("application/cea-608").E()) : Collections.emptyList();
        }
        String str = s0Var.f4053k;
        if (!TextUtils.isEmpty(str)) {
            if (!"audio/mp4a-latm".equals(com.google.android.exoplayer2.util.q.b(str))) {
                i7 |= 2;
            }
            if (!"video/avc".equals(com.google.android.exoplayer2.util.q.m(str))) {
                i7 |= 4;
            }
        }
        return new h0(2, k0Var, new l1.j(i7, list));
    }

    private static boolean g(s0 s0Var) {
        n1.a aVar = s0Var.f4054l;
        if (aVar == null) {
            return false;
        }
        for (int i6 = 0; i6 < aVar.h(); i6++) {
            a.b g6 = aVar.g(i6);
            if (g6 instanceof r) {
                return !((r) g6).f4371c.isEmpty();
            }
        }
        return false;
    }

    private static boolean h(c1.i iVar, c1.j jVar) {
        try {
            boolean h6 = iVar.h(jVar);
            jVar.g();
            return h6;
        } catch (EOFException unused) {
            jVar.g();
            return false;
        } catch (Throwable th) {
            jVar.g();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.h
    /* renamed from: c */
    public b a(Uri uri, s0 s0Var, List list, k0 k0Var, Map map, c1.j jVar) {
        int a6 = com.google.android.exoplayer2.util.j.a(s0Var.f4056n);
        int b6 = com.google.android.exoplayer2.util.j.b(map);
        int c6 = com.google.android.exoplayer2.util.j.c(uri);
        int[] iArr = f4261d;
        ArrayList arrayList = new ArrayList(iArr.length);
        b(a6, arrayList);
        b(b6, arrayList);
        b(c6, arrayList);
        for (int i6 : iArr) {
            b(i6, arrayList);
        }
        jVar.g();
        c1.i iVar = null;
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            int intValue = ((Integer) arrayList.get(i7)).intValue();
            c1.i iVar2 = (c1.i) com.google.android.exoplayer2.util.a.e(d(intValue, s0Var, list, k0Var));
            if (h(iVar2, jVar)) {
                return new b(iVar2, s0Var, k0Var);
            }
            if (intValue == 11) {
                iVar = iVar2;
            }
        }
        return new b((c1.i) com.google.android.exoplayer2.util.a.e(iVar), s0Var, k0Var);
    }

    public d(int i6, boolean z5) {
        this.f4262b = i6;
        this.f4263c = z5;
    }
}
