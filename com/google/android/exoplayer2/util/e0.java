package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.e0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes.dex */
public class e0 {

    /* renamed from: h  reason: collision with root package name */
    private static final Comparator f4595h = new Comparator() { // from class: com.google.android.exoplayer2.util.c0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int g6;
            g6 = e0.g((e0.b) obj, (e0.b) obj2);
            return g6;
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator f4596i = new Comparator() { // from class: com.google.android.exoplayer2.util.d0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int h6;
            h6 = e0.h((e0.b) obj, (e0.b) obj2);
            return h6;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f4597a;

    /* renamed from: e  reason: collision with root package name */
    private int f4601e;

    /* renamed from: f  reason: collision with root package name */
    private int f4602f;

    /* renamed from: g  reason: collision with root package name */
    private int f4603g;

    /* renamed from: c  reason: collision with root package name */
    private final b[] f4599c = new b[5];

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f4598b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private int f4600d = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f4604a;

        /* renamed from: b  reason: collision with root package name */
        public int f4605b;

        /* renamed from: c  reason: collision with root package name */
        public float f4606c;

        private b() {
        }
    }

    public e0(int i6) {
        this.f4597a = i6;
    }

    private void d() {
        if (this.f4600d != 1) {
            Collections.sort(this.f4598b, f4595h);
            this.f4600d = 1;
        }
    }

    private void e() {
        if (this.f4600d != 0) {
            Collections.sort(this.f4598b, f4596i);
            this.f4600d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f4604a - bVar2.f4604a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.f4606c, bVar2.f4606c);
    }

    public void c(int i6, float f6) {
        b bVar;
        int i7;
        b bVar2;
        int i8;
        d();
        int i9 = this.f4603g;
        if (i9 > 0) {
            b[] bVarArr = this.f4599c;
            int i10 = i9 - 1;
            this.f4603g = i10;
            bVar = bVarArr[i10];
        } else {
            bVar = new b();
        }
        int i11 = this.f4601e;
        this.f4601e = i11 + 1;
        bVar.f4604a = i11;
        bVar.f4605b = i6;
        bVar.f4606c = f6;
        this.f4598b.add(bVar);
        int i12 = this.f4602f + i6;
        while (true) {
            this.f4602f = i12;
            while (true) {
                int i13 = this.f4602f;
                int i14 = this.f4597a;
                if (i13 <= i14) {
                    return;
                }
                i7 = i13 - i14;
                bVar2 = (b) this.f4598b.get(0);
                i8 = bVar2.f4605b;
                if (i8 <= i7) {
                    this.f4602f -= i8;
                    this.f4598b.remove(0);
                    int i15 = this.f4603g;
                    if (i15 < 5) {
                        b[] bVarArr2 = this.f4599c;
                        this.f4603g = i15 + 1;
                        bVarArr2[i15] = bVar2;
                    }
                }
            }
            bVar2.f4605b = i8 - i7;
            i12 = this.f4602f - i7;
        }
    }

    public float f(float f6) {
        e();
        float f7 = f6 * this.f4602f;
        int i6 = 0;
        for (int i7 = 0; i7 < this.f4598b.size(); i7++) {
            b bVar = (b) this.f4598b.get(i7);
            i6 += bVar.f4605b;
            if (i6 >= f7) {
                return bVar.f4606c;
            }
        }
        if (this.f4598b.isEmpty()) {
            return Float.NaN;
        }
        ArrayList arrayList = this.f4598b;
        return ((b) arrayList.get(arrayList.size() - 1)).f4606c;
    }

    public void i() {
        this.f4598b.clear();
        this.f4600d = -1;
        this.f4601e = 0;
        this.f4602f = 0;
    }
}
