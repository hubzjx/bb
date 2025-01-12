package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import f0.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.y.b {
    private BitSet B;
    private boolean G;
    private boolean H;
    private e I;
    private int J;
    private int[] O;

    /* renamed from: t  reason: collision with root package name */
    f[] f2332t;

    /* renamed from: u  reason: collision with root package name */
    i f2333u;

    /* renamed from: v  reason: collision with root package name */
    i f2334v;

    /* renamed from: w  reason: collision with root package name */
    private int f2335w;

    /* renamed from: x  reason: collision with root package name */
    private int f2336x;

    /* renamed from: y  reason: collision with root package name */
    private final androidx.recyclerview.widget.f f2337y;

    /* renamed from: s  reason: collision with root package name */
    private int f2331s = -1;

    /* renamed from: z  reason: collision with root package name */
    boolean f2338z = false;
    boolean A = false;
    int C = -1;
    int D = Integer.MIN_VALUE;
    d E = new d();
    private int F = 2;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new a();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.S1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        int f2340a;

        /* renamed from: b  reason: collision with root package name */
        int f2341b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2342c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2343d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2344e;

        /* renamed from: f  reason: collision with root package name */
        int[] f2345f;

        b() {
            c();
        }

        void a() {
            this.f2341b = this.f2342c ? StaggeredGridLayoutManager.this.f2333u.i() : StaggeredGridLayoutManager.this.f2333u.m();
        }

        void b(int i6) {
            this.f2341b = this.f2342c ? StaggeredGridLayoutManager.this.f2333u.i() - i6 : StaggeredGridLayoutManager.this.f2333u.m() + i6;
        }

        void c() {
            this.f2340a = -1;
            this.f2341b = Integer.MIN_VALUE;
            this.f2342c = false;
            this.f2343d = false;
            this.f2344e = false;
            int[] iArr = this.f2345f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f2345f;
            if (iArr == null || iArr.length < length) {
                this.f2345f = new int[StaggeredGridLayoutManager.this.f2332t.length];
            }
            for (int i6 = 0; i6 < length; i6++) {
                this.f2345f[i6] = fVarArr[i6].p(Integer.MIN_VALUE);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        f f2347e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2348f;

        public c(int i6, int i7) {
            super(i6, i7);
        }

        public final int e() {
            f fVar = this.f2347e;
            if (fVar == null) {
                return -1;
            }
            return fVar.f2369e;
        }

        public boolean f() {
            return this.f2348f;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        int[] f2349a;

        /* renamed from: b  reason: collision with root package name */
        List f2350b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0020a();

            /* renamed from: a  reason: collision with root package name */
            int f2351a;

            /* renamed from: b  reason: collision with root package name */
            int f2352b;

            /* renamed from: c  reason: collision with root package name */
            int[] f2353c;

            /* renamed from: d  reason: collision with root package name */
            boolean f2354d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static class C0020a implements Parcelable.Creator {
                C0020a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b */
                public a[] newArray(int i6) {
                    return new a[i6];
                }
            }

            a() {
            }

            a(Parcel parcel) {
                this.f2351a = parcel.readInt();
                this.f2352b = parcel.readInt();
                this.f2354d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f2353c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            int e(int i6) {
                int[] iArr = this.f2353c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i6];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f2351a + ", mGapDir=" + this.f2352b + ", mHasUnwantedGapAfter=" + this.f2354d + ", mGapPerSpan=" + Arrays.toString(this.f2353c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i6) {
                parcel.writeInt(this.f2351a);
                parcel.writeInt(this.f2352b);
                parcel.writeInt(this.f2354d ? 1 : 0);
                int[] iArr = this.f2353c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f2353c);
            }
        }

        d() {
        }

        private int i(int i6) {
            if (this.f2350b == null) {
                return -1;
            }
            a f6 = f(i6);
            if (f6 != null) {
                this.f2350b.remove(f6);
            }
            int size = this.f2350b.size();
            int i7 = 0;
            while (true) {
                if (i7 >= size) {
                    i7 = -1;
                    break;
                } else if (((a) this.f2350b.get(i7)).f2351a >= i6) {
                    break;
                } else {
                    i7++;
                }
            }
            if (i7 != -1) {
                this.f2350b.remove(i7);
                return ((a) this.f2350b.get(i7)).f2351a;
            }
            return -1;
        }

        private void l(int i6, int i7) {
            List list = this.f2350b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f2350b.get(size);
                int i8 = aVar.f2351a;
                if (i8 >= i6) {
                    aVar.f2351a = i8 + i7;
                }
            }
        }

        private void m(int i6, int i7) {
            List list = this.f2350b;
            if (list == null) {
                return;
            }
            int i8 = i6 + i7;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f2350b.get(size);
                int i9 = aVar.f2351a;
                if (i9 >= i6) {
                    if (i9 < i8) {
                        this.f2350b.remove(size);
                    } else {
                        aVar.f2351a = i9 - i7;
                    }
                }
            }
        }

        public void a(a aVar) {
            if (this.f2350b == null) {
                this.f2350b = new ArrayList();
            }
            int size = this.f2350b.size();
            for (int i6 = 0; i6 < size; i6++) {
                a aVar2 = (a) this.f2350b.get(i6);
                if (aVar2.f2351a == aVar.f2351a) {
                    this.f2350b.remove(i6);
                }
                if (aVar2.f2351a >= aVar.f2351a) {
                    this.f2350b.add(i6, aVar);
                    return;
                }
            }
            this.f2350b.add(aVar);
        }

        void b() {
            int[] iArr = this.f2349a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2350b = null;
        }

        void c(int i6) {
            int[] iArr = this.f2349a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i6, 10) + 1];
                this.f2349a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i6 >= iArr.length) {
                int[] iArr3 = new int[o(i6)];
                this.f2349a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f2349a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i6) {
            List list = this.f2350b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((a) this.f2350b.get(size)).f2351a >= i6) {
                        this.f2350b.remove(size);
                    }
                }
            }
            return h(i6);
        }

        public a e(int i6, int i7, int i8, boolean z5) {
            List list = this.f2350b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i9 = 0; i9 < size; i9++) {
                a aVar = (a) this.f2350b.get(i9);
                int i10 = aVar.f2351a;
                if (i10 >= i7) {
                    return null;
                }
                if (i10 >= i6 && (i8 == 0 || aVar.f2352b == i8 || (z5 && aVar.f2354d))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i6) {
            List list = this.f2350b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f2350b.get(size);
                if (aVar.f2351a == i6) {
                    return aVar;
                }
            }
            return null;
        }

        int g(int i6) {
            int[] iArr = this.f2349a;
            if (iArr == null || i6 >= iArr.length) {
                return -1;
            }
            return iArr[i6];
        }

        int h(int i6) {
            int[] iArr = this.f2349a;
            if (iArr != null && i6 < iArr.length) {
                int i7 = i(i6);
                if (i7 == -1) {
                    int[] iArr2 = this.f2349a;
                    Arrays.fill(iArr2, i6, iArr2.length, -1);
                    return this.f2349a.length;
                }
                int i8 = i7 + 1;
                Arrays.fill(this.f2349a, i6, i8, -1);
                return i8;
            }
            return -1;
        }

        void j(int i6, int i7) {
            int[] iArr = this.f2349a;
            if (iArr == null || i6 >= iArr.length) {
                return;
            }
            int i8 = i6 + i7;
            c(i8);
            int[] iArr2 = this.f2349a;
            System.arraycopy(iArr2, i6, iArr2, i8, (iArr2.length - i6) - i7);
            Arrays.fill(this.f2349a, i6, i8, -1);
            l(i6, i7);
        }

        void k(int i6, int i7) {
            int[] iArr = this.f2349a;
            if (iArr == null || i6 >= iArr.length) {
                return;
            }
            int i8 = i6 + i7;
            c(i8);
            int[] iArr2 = this.f2349a;
            System.arraycopy(iArr2, i8, iArr2, i6, (iArr2.length - i6) - i7);
            int[] iArr3 = this.f2349a;
            Arrays.fill(iArr3, iArr3.length - i7, iArr3.length, -1);
            m(i6, i7);
        }

        void n(int i6, f fVar) {
            c(i6);
            this.f2349a[i6] = fVar.f2369e;
        }

        int o(int i6) {
            int length = this.f2349a.length;
            while (length <= i6) {
                length *= 2;
            }
            return length;
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f2355a;

        /* renamed from: b  reason: collision with root package name */
        int f2356b;

        /* renamed from: c  reason: collision with root package name */
        int f2357c;

        /* renamed from: d  reason: collision with root package name */
        int[] f2358d;

        /* renamed from: e  reason: collision with root package name */
        int f2359e;

        /* renamed from: f  reason: collision with root package name */
        int[] f2360f;

        /* renamed from: g  reason: collision with root package name */
        List f2361g;

        /* renamed from: h  reason: collision with root package name */
        boolean f2362h;

        /* renamed from: k  reason: collision with root package name */
        boolean f2363k;

        /* renamed from: l  reason: collision with root package name */
        boolean f2364l;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public e[] newArray(int i6) {
                return new e[i6];
            }
        }

        public e() {
        }

        e(Parcel parcel) {
            this.f2355a = parcel.readInt();
            this.f2356b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f2357c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f2358d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f2359e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f2360f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f2362h = parcel.readInt() == 1;
            this.f2363k = parcel.readInt() == 1;
            this.f2364l = parcel.readInt() == 1;
            this.f2361g = parcel.readArrayList(d.a.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        void e() {
            this.f2358d = null;
            this.f2357c = 0;
            this.f2355a = -1;
            this.f2356b = -1;
        }

        void f() {
            this.f2358d = null;
            this.f2357c = 0;
            this.f2359e = 0;
            this.f2360f = null;
            this.f2361g = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f2355a);
            parcel.writeInt(this.f2356b);
            parcel.writeInt(this.f2357c);
            if (this.f2357c > 0) {
                parcel.writeIntArray(this.f2358d);
            }
            parcel.writeInt(this.f2359e);
            if (this.f2359e > 0) {
                parcel.writeIntArray(this.f2360f);
            }
            parcel.writeInt(this.f2362h ? 1 : 0);
            parcel.writeInt(this.f2363k ? 1 : 0);
            parcel.writeInt(this.f2364l ? 1 : 0);
            parcel.writeList(this.f2361g);
        }

        public e(e eVar) {
            this.f2357c = eVar.f2357c;
            this.f2355a = eVar.f2355a;
            this.f2356b = eVar.f2356b;
            this.f2358d = eVar.f2358d;
            this.f2359e = eVar.f2359e;
            this.f2360f = eVar.f2360f;
            this.f2362h = eVar.f2362h;
            this.f2363k = eVar.f2363k;
            this.f2364l = eVar.f2364l;
            this.f2361g = eVar.f2361g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        ArrayList f2365a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        int f2366b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f2367c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f2368d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f2369e;

        f(int i6) {
            this.f2369e = i6;
        }

        void a(View view) {
            c n5 = n(view);
            n5.f2347e = this;
            this.f2365a.add(view);
            this.f2367c = Integer.MIN_VALUE;
            if (this.f2365a.size() == 1) {
                this.f2366b = Integer.MIN_VALUE;
            }
            if (n5.c() || n5.b()) {
                this.f2368d += StaggeredGridLayoutManager.this.f2333u.e(view);
            }
        }

        void b(boolean z5, int i6) {
            int l6 = z5 ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (l6 == Integer.MIN_VALUE) {
                return;
            }
            if (!z5 || l6 >= StaggeredGridLayoutManager.this.f2333u.i()) {
                if (z5 || l6 <= StaggeredGridLayoutManager.this.f2333u.m()) {
                    if (i6 != Integer.MIN_VALUE) {
                        l6 += i6;
                    }
                    this.f2367c = l6;
                    this.f2366b = l6;
                }
            }
        }

        void c() {
            d.a f6;
            ArrayList arrayList = this.f2365a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c n5 = n(view);
            this.f2367c = StaggeredGridLayoutManager.this.f2333u.d(view);
            if (n5.f2348f && (f6 = StaggeredGridLayoutManager.this.E.f(n5.a())) != null && f6.f2352b == 1) {
                this.f2367c += f6.e(this.f2369e);
            }
        }

        void d() {
            d.a f6;
            View view = (View) this.f2365a.get(0);
            c n5 = n(view);
            this.f2366b = StaggeredGridLayoutManager.this.f2333u.g(view);
            if (n5.f2348f && (f6 = StaggeredGridLayoutManager.this.E.f(n5.a())) != null && f6.f2352b == -1) {
                this.f2366b -= f6.e(this.f2369e);
            }
        }

        void e() {
            this.f2365a.clear();
            q();
            this.f2368d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f2338z ? i(this.f2365a.size() - 1, -1, true) : i(0, this.f2365a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f2338z ? i(0, this.f2365a.size(), true) : i(this.f2365a.size() - 1, -1, true);
        }

        int h(int i6, int i7, boolean z5, boolean z6, boolean z7) {
            int m5 = StaggeredGridLayoutManager.this.f2333u.m();
            int i8 = StaggeredGridLayoutManager.this.f2333u.i();
            int i9 = i7 > i6 ? 1 : -1;
            while (i6 != i7) {
                View view = (View) this.f2365a.get(i6);
                int g6 = StaggeredGridLayoutManager.this.f2333u.g(view);
                int d6 = StaggeredGridLayoutManager.this.f2333u.d(view);
                boolean z8 = false;
                boolean z9 = !z7 ? g6 >= i8 : g6 > i8;
                if (!z7 ? d6 > m5 : d6 >= m5) {
                    z8 = true;
                }
                if (z9 && z8) {
                    if (!z5 || !z6) {
                        if (!z6 && g6 >= m5 && d6 <= i8) {
                        }
                        return StaggeredGridLayoutManager.this.h0(view);
                    } else if (g6 >= m5 && d6 <= i8) {
                        return StaggeredGridLayoutManager.this.h0(view);
                    }
                }
                i6 += i9;
            }
            return -1;
        }

        int i(int i6, int i7, boolean z5) {
            return h(i6, i7, false, false, z5);
        }

        public int j() {
            return this.f2368d;
        }

        int k() {
            int i6 = this.f2367c;
            if (i6 != Integer.MIN_VALUE) {
                return i6;
            }
            c();
            return this.f2367c;
        }

        int l(int i6) {
            int i7 = this.f2367c;
            if (i7 != Integer.MIN_VALUE) {
                return i7;
            }
            if (this.f2365a.size() == 0) {
                return i6;
            }
            c();
            return this.f2367c;
        }

        public View m(int i6, int i7) {
            View view = null;
            if (i7 != -1) {
                int size = this.f2365a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f2365a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f2338z && staggeredGridLayoutManager.h0(view2) >= i6) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f2338z && staggeredGridLayoutManager2.h0(view2) <= i6) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f2365a.size();
                int i8 = 0;
                while (i8 < size2) {
                    View view3 = (View) this.f2365a.get(i8);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f2338z && staggeredGridLayoutManager3.h0(view3) <= i6) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f2338z && staggeredGridLayoutManager4.h0(view3) >= i6) || !view3.hasFocusable()) {
                        break;
                    }
                    i8++;
                    view = view3;
                }
            }
            return view;
        }

        c n(View view) {
            return (c) view.getLayoutParams();
        }

        int o() {
            int i6 = this.f2366b;
            if (i6 != Integer.MIN_VALUE) {
                return i6;
            }
            d();
            return this.f2366b;
        }

        int p(int i6) {
            int i7 = this.f2366b;
            if (i7 != Integer.MIN_VALUE) {
                return i7;
            }
            if (this.f2365a.size() == 0) {
                return i6;
            }
            d();
            return this.f2366b;
        }

        void q() {
            this.f2366b = Integer.MIN_VALUE;
            this.f2367c = Integer.MIN_VALUE;
        }

        void r(int i6) {
            int i7 = this.f2366b;
            if (i7 != Integer.MIN_VALUE) {
                this.f2366b = i7 + i6;
            }
            int i8 = this.f2367c;
            if (i8 != Integer.MIN_VALUE) {
                this.f2367c = i8 + i6;
            }
        }

        void s() {
            int size = this.f2365a.size();
            View view = (View) this.f2365a.remove(size - 1);
            c n5 = n(view);
            n5.f2347e = null;
            if (n5.c() || n5.b()) {
                this.f2368d -= StaggeredGridLayoutManager.this.f2333u.e(view);
            }
            if (size == 1) {
                this.f2366b = Integer.MIN_VALUE;
            }
            this.f2367c = Integer.MIN_VALUE;
        }

        void t() {
            View view = (View) this.f2365a.remove(0);
            c n5 = n(view);
            n5.f2347e = null;
            if (this.f2365a.size() == 0) {
                this.f2367c = Integer.MIN_VALUE;
            }
            if (n5.c() || n5.b()) {
                this.f2368d -= StaggeredGridLayoutManager.this.f2333u.e(view);
            }
            this.f2366b = Integer.MIN_VALUE;
        }

        void u(View view) {
            c n5 = n(view);
            n5.f2347e = this;
            this.f2365a.add(0, view);
            this.f2366b = Integer.MIN_VALUE;
            if (this.f2365a.size() == 1) {
                this.f2367c = Integer.MIN_VALUE;
            }
            if (n5.c() || n5.b()) {
                this.f2368d += StaggeredGridLayoutManager.this.f2333u.e(view);
            }
        }

        void v(int i6) {
            this.f2366b = i6;
            this.f2367c = i6;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i6, int i7) {
        RecyclerView.o.d i02 = RecyclerView.o.i0(context, attributeSet, i6, i7);
        H2(i02.f2275a);
        J2(i02.f2276b);
        I2(i02.f2277c);
        this.f2337y = new androidx.recyclerview.widget.f();
        a2();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0010, code lost:
        if (r4.f2489e == (-1)) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A2(RecyclerView.u uVar, androidx.recyclerview.widget.f fVar) {
        int min;
        int min2;
        if (!fVar.f2485a || fVar.f2493i) {
            return;
        }
        if (fVar.f2486b != 0) {
            if (fVar.f2489e == -1) {
                int i6 = fVar.f2490f;
                int m22 = i6 - m2(i6);
                if (m22 >= 0) {
                    min2 = fVar.f2491g - Math.min(m22, fVar.f2486b);
                    B2(uVar, min2);
                    return;
                }
                min2 = fVar.f2491g;
                B2(uVar, min2);
                return;
            }
            int n22 = n2(fVar.f2491g) - fVar.f2491g;
            if (n22 >= 0) {
                min = Math.min(n22, fVar.f2486b) + fVar.f2490f;
                C2(uVar, min);
            }
            min = fVar.f2490f;
            C2(uVar, min);
        }
    }

    private void B2(RecyclerView.u uVar, int i6) {
        for (int J = J() - 1; J >= 0; J--) {
            View I = I(J);
            if (this.f2333u.g(I) < i6 || this.f2333u.q(I) < i6) {
                return;
            }
            c cVar = (c) I.getLayoutParams();
            if (cVar.f2348f) {
                for (int i7 = 0; i7 < this.f2331s; i7++) {
                    if (this.f2332t[i7].f2365a.size() == 1) {
                        return;
                    }
                }
                for (int i8 = 0; i8 < this.f2331s; i8++) {
                    this.f2332t[i8].s();
                }
            } else if (cVar.f2347e.f2365a.size() == 1) {
                return;
            } else {
                cVar.f2347e.s();
            }
            m1(I, uVar);
        }
    }

    private void C2(RecyclerView.u uVar, int i6) {
        while (J() > 0) {
            View I = I(0);
            if (this.f2333u.d(I) > i6 || this.f2333u.p(I) > i6) {
                return;
            }
            c cVar = (c) I.getLayoutParams();
            if (cVar.f2348f) {
                for (int i7 = 0; i7 < this.f2331s; i7++) {
                    if (this.f2332t[i7].f2365a.size() == 1) {
                        return;
                    }
                }
                for (int i8 = 0; i8 < this.f2331s; i8++) {
                    this.f2332t[i8].t();
                }
            } else if (cVar.f2347e.f2365a.size() == 1) {
                return;
            } else {
                cVar.f2347e.t();
            }
            m1(I, uVar);
        }
    }

    private void D2() {
        if (this.f2334v.k() == 1073741824) {
            return;
        }
        int J = J();
        float f6 = 0.0f;
        for (int i6 = 0; i6 < J; i6++) {
            View I = I(i6);
            float e6 = this.f2334v.e(I);
            if (e6 >= f6) {
                if (((c) I.getLayoutParams()).f()) {
                    e6 = (e6 * 1.0f) / this.f2331s;
                }
                f6 = Math.max(f6, e6);
            }
        }
        int i7 = this.f2336x;
        int round = Math.round(f6 * this.f2331s);
        if (this.f2334v.k() == Integer.MIN_VALUE) {
            round = Math.min(round, this.f2334v.n());
        }
        P2(round);
        if (this.f2336x == i7) {
            return;
        }
        for (int i8 = 0; i8 < J; i8++) {
            View I2 = I(i8);
            c cVar = (c) I2.getLayoutParams();
            if (!cVar.f2348f) {
                if (t2() && this.f2335w == 1) {
                    int i9 = this.f2331s;
                    int i10 = cVar.f2347e.f2369e;
                    I2.offsetLeftAndRight(((-((i9 - 1) - i10)) * this.f2336x) - ((-((i9 - 1) - i10)) * i7));
                } else {
                    int i11 = cVar.f2347e.f2369e;
                    int i12 = this.f2335w;
                    int i13 = (this.f2336x * i11) - (i11 * i7);
                    if (i12 == 1) {
                        I2.offsetLeftAndRight(i13);
                    } else {
                        I2.offsetTopAndBottom(i13);
                    }
                }
            }
        }
    }

    private void E2() {
        this.A = (this.f2335w == 1 || !t2()) ? this.f2338z : !this.f2338z;
    }

    private void G2(int i6) {
        androidx.recyclerview.widget.f fVar = this.f2337y;
        fVar.f2489e = i6;
        fVar.f2488d = this.A != (i6 == -1) ? -1 : 1;
    }

    private void K2(int i6, int i7) {
        for (int i8 = 0; i8 < this.f2331s; i8++) {
            if (!this.f2332t[i8].f2365a.isEmpty()) {
                Q2(this.f2332t[i8], i6, i7);
            }
        }
    }

    private boolean L2(RecyclerView.z zVar, b bVar) {
        boolean z5 = this.G;
        int b6 = zVar.b();
        bVar.f2340a = z5 ? g2(b6) : c2(b6);
        bVar.f2341b = Integer.MIN_VALUE;
        return true;
    }

    private void M1(View view) {
        for (int i6 = this.f2331s - 1; i6 >= 0; i6--) {
            this.f2332t[i6].a(view);
        }
    }

    private void N1(b bVar) {
        boolean z5;
        e eVar = this.I;
        int i6 = eVar.f2357c;
        if (i6 > 0) {
            if (i6 == this.f2331s) {
                for (int i7 = 0; i7 < this.f2331s; i7++) {
                    this.f2332t[i7].e();
                    e eVar2 = this.I;
                    int i8 = eVar2.f2358d[i7];
                    if (i8 != Integer.MIN_VALUE) {
                        i8 += eVar2.f2363k ? this.f2333u.i() : this.f2333u.m();
                    }
                    this.f2332t[i7].v(i8);
                }
            } else {
                eVar.f();
                e eVar3 = this.I;
                eVar3.f2355a = eVar3.f2356b;
            }
        }
        e eVar4 = this.I;
        this.H = eVar4.f2364l;
        I2(eVar4.f2362h);
        E2();
        e eVar5 = this.I;
        int i9 = eVar5.f2355a;
        if (i9 != -1) {
            this.C = i9;
            z5 = eVar5.f2363k;
        } else {
            z5 = this.A;
        }
        bVar.f2342c = z5;
        if (eVar5.f2359e > 1) {
            d dVar = this.E;
            dVar.f2349a = eVar5.f2360f;
            dVar.f2350b = eVar5.f2361g;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void O2(int i6, RecyclerView.z zVar) {
        int i7;
        int i8;
        int c6;
        androidx.recyclerview.widget.f fVar = this.f2337y;
        boolean z5 = false;
        fVar.f2486b = 0;
        fVar.f2487c = i6;
        if (!x0() || (c6 = zVar.c()) == -1) {
            i7 = 0;
        } else {
            if (this.A != (c6 < i6)) {
                i8 = this.f2333u.n();
                i7 = 0;
                if (M()) {
                    this.f2337y.f2491g = this.f2333u.h() + i7;
                    this.f2337y.f2490f = -i8;
                } else {
                    this.f2337y.f2490f = this.f2333u.m() - i8;
                    this.f2337y.f2491g = this.f2333u.i() + i7;
                }
                androidx.recyclerview.widget.f fVar2 = this.f2337y;
                fVar2.f2492h = false;
                fVar2.f2485a = true;
                if (this.f2333u.k() == 0 && this.f2333u.h() == 0) {
                    z5 = true;
                }
                fVar2.f2493i = z5;
            }
            i7 = this.f2333u.n();
        }
        i8 = 0;
        if (M()) {
        }
        androidx.recyclerview.widget.f fVar22 = this.f2337y;
        fVar22.f2492h = false;
        fVar22.f2485a = true;
        if (this.f2333u.k() == 0) {
            z5 = true;
        }
        fVar22.f2493i = z5;
    }

    private void Q1(View view, c cVar, androidx.recyclerview.widget.f fVar) {
        if (fVar.f2489e == 1) {
            if (cVar.f2348f) {
                M1(view);
            } else {
                cVar.f2347e.a(view);
            }
        } else if (cVar.f2348f) {
            z2(view);
        } else {
            cVar.f2347e.u(view);
        }
    }

    private void Q2(f fVar, int i6, int i7) {
        int j6 = fVar.j();
        if (i6 == -1) {
            if (fVar.o() + j6 > i7) {
                return;
            }
        } else if (fVar.k() - j6 < i7) {
            return;
        }
        this.B.set(fVar.f2369e, false);
    }

    private int R1(int i6) {
        if (J() == 0) {
            return this.A ? 1 : -1;
        }
        return (i6 < j2()) != this.A ? -1 : 1;
    }

    private int R2(int i6, int i7, int i8) {
        if (i7 == 0 && i8 == 0) {
            return i6;
        }
        int mode = View.MeasureSpec.getMode(i6);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i6) - i7) - i8), mode) : i6;
    }

    private boolean T1(f fVar) {
        if (this.A) {
            if (fVar.k() < this.f2333u.i()) {
                ArrayList arrayList = fVar.f2365a;
                return !fVar.n((View) arrayList.get(arrayList.size() - 1)).f2348f;
            }
        } else if (fVar.o() > this.f2333u.m()) {
            return !fVar.n((View) fVar.f2365a.get(0)).f2348f;
        }
        return false;
    }

    private int U1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        return l.a(zVar, this.f2333u, e2(!this.N), d2(!this.N), this, this.N);
    }

    private int V1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        return l.b(zVar, this.f2333u, e2(!this.N), d2(!this.N), this, this.N, this.A);
    }

    private int W1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        return l.c(zVar, this.f2333u, e2(!this.N), d2(!this.N), this, this.N);
    }

    private int X1(int i6) {
        return i6 != 1 ? i6 != 2 ? i6 != 17 ? i6 != 33 ? i6 != 66 ? (i6 == 130 && this.f2335w == 1) ? 1 : Integer.MIN_VALUE : this.f2335w == 0 ? 1 : Integer.MIN_VALUE : this.f2335w == 1 ? -1 : Integer.MIN_VALUE : this.f2335w == 0 ? -1 : Integer.MIN_VALUE : (this.f2335w != 1 && t2()) ? -1 : 1 : (this.f2335w != 1 && t2()) ? 1 : -1;
    }

    private d.a Y1(int i6) {
        d.a aVar = new d.a();
        aVar.f2353c = new int[this.f2331s];
        for (int i7 = 0; i7 < this.f2331s; i7++) {
            aVar.f2353c[i7] = i6 - this.f2332t[i7].l(i6);
        }
        return aVar;
    }

    private d.a Z1(int i6) {
        d.a aVar = new d.a();
        aVar.f2353c = new int[this.f2331s];
        for (int i7 = 0; i7 < this.f2331s; i7++) {
            aVar.f2353c[i7] = this.f2332t[i7].p(i6) - i6;
        }
        return aVar;
    }

    private void a2() {
        this.f2333u = i.b(this, this.f2335w);
        this.f2334v = i.b(this, 1 - this.f2335w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int b2(RecyclerView.u uVar, androidx.recyclerview.widget.f fVar, RecyclerView.z zVar) {
        int i6;
        f fVar2;
        int e6;
        int i7;
        int i8;
        int e7;
        RecyclerView.o oVar;
        View view;
        int i9;
        int i10;
        ?? r9 = 0;
        this.B.set(0, this.f2331s, true);
        if (this.f2337y.f2493i) {
            i6 = fVar.f2489e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i6 = fVar.f2489e == 1 ? fVar.f2491g + fVar.f2486b : fVar.f2490f - fVar.f2486b;
        }
        K2(fVar.f2489e, i6);
        int i11 = this.A ? this.f2333u.i() : this.f2333u.m();
        boolean z5 = false;
        while (fVar.a(zVar) && (this.f2337y.f2493i || !this.B.isEmpty())) {
            View b6 = fVar.b(uVar);
            c cVar = (c) b6.getLayoutParams();
            int a6 = cVar.a();
            int g6 = this.E.g(a6);
            boolean z6 = g6 == -1;
            if (z6) {
                fVar2 = cVar.f2348f ? this.f2332t[r9] : p2(fVar);
                this.E.n(a6, fVar2);
            } else {
                fVar2 = this.f2332t[g6];
            }
            f fVar3 = fVar2;
            cVar.f2347e = fVar3;
            if (fVar.f2489e == 1) {
                d(b6);
            } else {
                e(b6, r9);
            }
            v2(b6, cVar, r9);
            if (fVar.f2489e == 1) {
                int l22 = cVar.f2348f ? l2(i11) : fVar3.l(i11);
                int e8 = this.f2333u.e(b6) + l22;
                if (z6 && cVar.f2348f) {
                    d.a Y1 = Y1(l22);
                    Y1.f2352b = -1;
                    Y1.f2351a = a6;
                    this.E.a(Y1);
                }
                i7 = e8;
                e6 = l22;
            } else {
                int o22 = cVar.f2348f ? o2(i11) : fVar3.p(i11);
                e6 = o22 - this.f2333u.e(b6);
                if (z6 && cVar.f2348f) {
                    d.a Z1 = Z1(o22);
                    Z1.f2352b = 1;
                    Z1.f2351a = a6;
                    this.E.a(Z1);
                }
                i7 = o22;
            }
            if (cVar.f2348f && fVar.f2488d == -1) {
                if (!z6) {
                    if (!(fVar.f2489e == 1 ? O1() : P1())) {
                        d.a f6 = this.E.f(a6);
                        if (f6 != null) {
                            f6.f2354d = true;
                        }
                    }
                }
                this.M = true;
            }
            Q1(b6, cVar, fVar);
            if (t2() && this.f2335w == 1) {
                int i12 = cVar.f2348f ? this.f2334v.i() : this.f2334v.i() - (((this.f2331s - 1) - fVar3.f2369e) * this.f2336x);
                e7 = i12;
                i8 = i12 - this.f2334v.e(b6);
            } else {
                int m5 = cVar.f2348f ? this.f2334v.m() : (fVar3.f2369e * this.f2336x) + this.f2334v.m();
                i8 = m5;
                e7 = this.f2334v.e(b6) + m5;
            }
            if (this.f2335w == 1) {
                oVar = this;
                view = b6;
                i9 = i8;
                i8 = e6;
                i10 = e7;
            } else {
                oVar = this;
                view = b6;
                i9 = e6;
                i10 = i7;
                i7 = e7;
            }
            oVar.z0(view, i9, i8, i10, i7);
            if (cVar.f2348f) {
                K2(this.f2337y.f2489e, i6);
            } else {
                Q2(fVar3, this.f2337y.f2489e, i6);
            }
            A2(uVar, this.f2337y);
            if (this.f2337y.f2492h && b6.hasFocusable()) {
                if (cVar.f2348f) {
                    this.B.clear();
                } else {
                    this.B.set(fVar3.f2369e, false);
                    z5 = true;
                    r9 = 0;
                }
            }
            z5 = true;
            r9 = 0;
        }
        if (!z5) {
            A2(uVar, this.f2337y);
        }
        int m6 = this.f2337y.f2489e == -1 ? this.f2333u.m() - o2(this.f2333u.m()) : l2(this.f2333u.i()) - this.f2333u.i();
        if (m6 > 0) {
            return Math.min(fVar.f2486b, m6);
        }
        return 0;
    }

    private int c2(int i6) {
        int J = J();
        for (int i7 = 0; i7 < J; i7++) {
            int h02 = h0(I(i7));
            if (h02 >= 0 && h02 < i6) {
                return h02;
            }
        }
        return 0;
    }

    private int g2(int i6) {
        for (int J = J() - 1; J >= 0; J--) {
            int h02 = h0(I(J));
            if (h02 >= 0 && h02 < i6) {
                return h02;
            }
        }
        return 0;
    }

    private void h2(RecyclerView.u uVar, RecyclerView.z zVar, boolean z5) {
        int i6;
        int l22 = l2(Integer.MIN_VALUE);
        if (l22 != Integer.MIN_VALUE && (i6 = this.f2333u.i() - l22) > 0) {
            int i7 = i6 - (-F2(-i6, uVar, zVar));
            if (!z5 || i7 <= 0) {
                return;
            }
            this.f2333u.r(i7);
        }
    }

    private void i2(RecyclerView.u uVar, RecyclerView.z zVar, boolean z5) {
        int m5;
        int o22 = o2(Integer.MAX_VALUE);
        if (o22 != Integer.MAX_VALUE && (m5 = o22 - this.f2333u.m()) > 0) {
            int F2 = m5 - F2(m5, uVar, zVar);
            if (!z5 || F2 <= 0) {
                return;
            }
            this.f2333u.r(-F2);
        }
    }

    private int l2(int i6) {
        int l6 = this.f2332t[0].l(i6);
        for (int i7 = 1; i7 < this.f2331s; i7++) {
            int l7 = this.f2332t[i7].l(i6);
            if (l7 > l6) {
                l6 = l7;
            }
        }
        return l6;
    }

    private int m2(int i6) {
        int p5 = this.f2332t[0].p(i6);
        for (int i7 = 1; i7 < this.f2331s; i7++) {
            int p6 = this.f2332t[i7].p(i6);
            if (p6 > p5) {
                p5 = p6;
            }
        }
        return p5;
    }

    private int n2(int i6) {
        int l6 = this.f2332t[0].l(i6);
        for (int i7 = 1; i7 < this.f2331s; i7++) {
            int l7 = this.f2332t[i7].l(i6);
            if (l7 < l6) {
                l6 = l7;
            }
        }
        return l6;
    }

    private int o2(int i6) {
        int p5 = this.f2332t[0].p(i6);
        for (int i7 = 1; i7 < this.f2331s; i7++) {
            int p6 = this.f2332t[i7].p(i6);
            if (p6 < p5) {
                p5 = p6;
            }
        }
        return p5;
    }

    private f p2(androidx.recyclerview.widget.f fVar) {
        int i6;
        int i7;
        int i8;
        if (x2(fVar.f2489e)) {
            i7 = this.f2331s - 1;
            i6 = -1;
            i8 = -1;
        } else {
            i6 = this.f2331s;
            i7 = 0;
            i8 = 1;
        }
        f fVar2 = null;
        if (fVar.f2489e == 1) {
            int m5 = this.f2333u.m();
            int i9 = Integer.MAX_VALUE;
            while (i7 != i6) {
                f fVar3 = this.f2332t[i7];
                int l6 = fVar3.l(m5);
                if (l6 < i9) {
                    fVar2 = fVar3;
                    i9 = l6;
                }
                i7 += i8;
            }
            return fVar2;
        }
        int i10 = this.f2333u.i();
        int i11 = Integer.MIN_VALUE;
        while (i7 != i6) {
            f fVar4 = this.f2332t[i7];
            int p5 = fVar4.p(i10);
            if (p5 > i11) {
                fVar2 = fVar4;
                i11 = p5;
            }
            i7 += i8;
        }
        return fVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void q2(int i6, int i7, int i8) {
        int i9;
        int i10;
        int k22 = this.A ? k2() : j2();
        if (i8 != 8) {
            i9 = i6 + i7;
        } else if (i6 >= i7) {
            i9 = i6 + 1;
            i10 = i7;
            this.E.h(i10);
            if (i8 != 1) {
                this.E.j(i6, i7);
            } else if (i8 == 2) {
                this.E.k(i6, i7);
            } else if (i8 == 8) {
                this.E.k(i6, 1);
                this.E.j(i7, 1);
            }
            if (i9 > k22) {
                return;
            }
            if (i10 <= (this.A ? j2() : k2())) {
                t1();
                return;
            }
            return;
        } else {
            i9 = i7 + 1;
        }
        i10 = i6;
        this.E.h(i10);
        if (i8 != 1) {
        }
        if (i9 > k22) {
        }
    }

    private void u2(View view, int i6, int i7, boolean z5) {
        j(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i8 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int R2 = R2(i6, i8 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i9 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int R22 = R2(i7, i9 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z5 ? H1(view, R2, R22, cVar) : F1(view, R2, R22, cVar)) {
            view.measure(R2, R22);
        }
    }

    private void v2(View view, c cVar, boolean z5) {
        int K;
        int K2;
        if (cVar.f2348f) {
            if (this.f2335w != 1) {
                u2(view, RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z5);
                return;
            }
            K = this.J;
        } else if (this.f2335w != 1) {
            K = RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) cVar).width, true);
            K2 = RecyclerView.o.K(this.f2336x, X(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false);
            u2(view, K, K2, z5);
        } else {
            K = RecyclerView.o.K(this.f2336x, p0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false);
        }
        K2 = RecyclerView.o.K(W(), X(), g0() + d0(), ((ViewGroup.MarginLayoutParams) cVar).height, true);
        u2(view, K, K2, z5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x014b, code lost:
        if (S1() != false) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void w2(RecyclerView.u uVar, RecyclerView.z zVar, boolean z5) {
        e eVar;
        b bVar = this.L;
        if (!(this.I == null && this.C == -1) && zVar.b() == 0) {
            k1(uVar);
            bVar.c();
            return;
        }
        boolean z6 = true;
        boolean z7 = (bVar.f2344e && this.C == -1 && this.I == null) ? false : true;
        if (z7) {
            bVar.c();
            if (this.I != null) {
                N1(bVar);
            } else {
                E2();
                bVar.f2342c = this.A;
            }
            N2(zVar, bVar);
            bVar.f2344e = true;
        }
        if (this.I == null && this.C == -1 && (bVar.f2342c != this.G || t2() != this.H)) {
            this.E.b();
            bVar.f2343d = true;
        }
        if (J() > 0 && ((eVar = this.I) == null || eVar.f2357c < 1)) {
            if (bVar.f2343d) {
                for (int i6 = 0; i6 < this.f2331s; i6++) {
                    this.f2332t[i6].e();
                    int i7 = bVar.f2341b;
                    if (i7 != Integer.MIN_VALUE) {
                        this.f2332t[i6].v(i7);
                    }
                }
            } else if (z7 || this.L.f2345f == null) {
                for (int i8 = 0; i8 < this.f2331s; i8++) {
                    this.f2332t[i8].b(this.A, bVar.f2341b);
                }
                this.L.d(this.f2332t);
            } else {
                for (int i9 = 0; i9 < this.f2331s; i9++) {
                    f fVar = this.f2332t[i9];
                    fVar.e();
                    fVar.v(this.L.f2345f[i9]);
                }
            }
        }
        w(uVar);
        this.f2337y.f2485a = false;
        this.M = false;
        P2(this.f2334v.n());
        O2(bVar.f2340a, zVar);
        if (bVar.f2342c) {
            G2(-1);
            b2(uVar, this.f2337y, zVar);
            G2(1);
        } else {
            G2(1);
            b2(uVar, this.f2337y, zVar);
            G2(-1);
        }
        androidx.recyclerview.widget.f fVar2 = this.f2337y;
        fVar2.f2487c = bVar.f2340a + fVar2.f2488d;
        b2(uVar, fVar2, zVar);
        D2();
        if (J() > 0) {
            if (this.A) {
                h2(uVar, zVar, true);
                i2(uVar, zVar, false);
            } else {
                i2(uVar, zVar, true);
                h2(uVar, zVar, false);
            }
        }
        if (z5 && !zVar.e()) {
            if (this.F != 0 && J() > 0 && (this.M || r2() != null)) {
                o1(this.P);
            }
        }
        z6 = false;
        if (zVar.e()) {
            this.L.c();
        }
        this.G = bVar.f2342c;
        this.H = t2();
        if (z6) {
            this.L.c();
            w2(uVar, zVar, false);
        }
    }

    private boolean x2(int i6) {
        if (this.f2335w == 0) {
            return (i6 == -1) != this.A;
        }
        return ((i6 == -1) == this.A) == t2();
    }

    private void z2(View view) {
        for (int i6 = this.f2331s - 1; i6 >= 0; i6--) {
            this.f2332t[i6].u(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C0(int i6) {
        super.C0(i6);
        for (int i7 = 0; i7 < this.f2331s; i7++) {
            this.f2332t[i7].r(i6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(Rect rect, int i6, int i7) {
        int n5;
        int n6;
        int e02 = e0() + f0();
        int g02 = g0() + d0();
        if (this.f2335w == 1) {
            n6 = RecyclerView.o.n(i7, rect.height() + g02, b0());
            n5 = RecyclerView.o.n(i6, (this.f2336x * this.f2331s) + e02, c0());
        } else {
            n5 = RecyclerView.o.n(i6, rect.width() + e02, c0());
            n6 = RecyclerView.o.n(i7, (this.f2336x * this.f2331s) + g02, b0());
        }
        B1(n5, n6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.f2335w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D0(int i6) {
        super.D0(i6);
        for (int i7 = 0; i7 < this.f2331s; i7++) {
            this.f2332t[i7].r(i6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    int F2(int i6, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (J() == 0 || i6 == 0) {
            return 0;
        }
        y2(i6, zVar);
        int b22 = b2(uVar, this.f2337y, zVar);
        if (this.f2337y.f2486b >= b22) {
            i6 = i6 < 0 ? -b22 : b22;
        }
        this.f2333u.r(-i6);
        this.G = this.A;
        androidx.recyclerview.widget.f fVar = this.f2337y;
        fVar.f2486b = 0;
        A2(uVar, fVar);
        return i6;
    }

    public void H2(int i6) {
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        g(null);
        if (i6 == this.f2335w) {
            return;
        }
        this.f2335w = i6;
        i iVar = this.f2333u;
        this.f2333u = this.f2334v;
        this.f2334v = iVar;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.u uVar) {
        super.I0(recyclerView, uVar);
        o1(this.P);
        for (int i6 = 0; i6 < this.f2331s; i6++) {
            this.f2332t[i6].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.z zVar, int i6) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i6);
        J1(gVar);
    }

    public void I2(boolean z5) {
        g(null);
        e eVar = this.I;
        if (eVar != null && eVar.f2362h != z5) {
            eVar.f2362h = z5;
        }
        this.f2338z = z5;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i6, RecyclerView.u uVar, RecyclerView.z zVar) {
        View B;
        View m5;
        if (J() == 0 || (B = B(view)) == null) {
            return null;
        }
        E2();
        int X1 = X1(i6);
        if (X1 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) B.getLayoutParams();
        boolean z5 = cVar.f2348f;
        f fVar = cVar.f2347e;
        int k22 = X1 == 1 ? k2() : j2();
        O2(k22, zVar);
        G2(X1);
        androidx.recyclerview.widget.f fVar2 = this.f2337y;
        fVar2.f2487c = fVar2.f2488d + k22;
        fVar2.f2486b = (int) (this.f2333u.n() * 0.33333334f);
        androidx.recyclerview.widget.f fVar3 = this.f2337y;
        fVar3.f2492h = true;
        fVar3.f2485a = false;
        b2(uVar, fVar3, zVar);
        this.G = this.A;
        if (z5 || (m5 = fVar.m(k22, X1)) == null || m5 == B) {
            if (x2(X1)) {
                for (int i7 = this.f2331s - 1; i7 >= 0; i7--) {
                    View m6 = this.f2332t[i7].m(k22, X1);
                    if (m6 != null && m6 != B) {
                        return m6;
                    }
                }
            } else {
                for (int i8 = 0; i8 < this.f2331s; i8++) {
                    View m7 = this.f2332t[i8].m(k22, X1);
                    if (m7 != null && m7 != B) {
                        return m7;
                    }
                }
            }
            boolean z6 = (this.f2338z ^ true) == (X1 == -1);
            if (!z5) {
                View C = C(z6 ? fVar.f() : fVar.g());
                if (C != null && C != B) {
                    return C;
                }
            }
            if (x2(X1)) {
                for (int i9 = this.f2331s - 1; i9 >= 0; i9--) {
                    if (i9 != fVar.f2369e) {
                        f[] fVarArr = this.f2332t;
                        View C2 = C(z6 ? fVarArr[i9].f() : fVarArr[i9].g());
                        if (C2 != null && C2 != B) {
                            return C2;
                        }
                    }
                }
            } else {
                for (int i10 = 0; i10 < this.f2331s; i10++) {
                    f[] fVarArr2 = this.f2332t;
                    View C3 = C(z6 ? fVarArr2[i10].f() : fVarArr2[i10].g());
                    if (C3 != null && C3 != B) {
                        return C3;
                    }
                }
            }
            return null;
        }
        return m5;
    }

    public void J2(int i6) {
        g(null);
        if (i6 != this.f2331s) {
            s2();
            this.f2331s = i6;
            this.B = new BitSet(this.f2331s);
            this.f2332t = new f[this.f2331s];
            for (int i7 = 0; i7 < this.f2331s; i7++) {
                this.f2332t[i7] = new f(i7);
            }
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            View e22 = e2(false);
            View d22 = d2(false);
            if (e22 == null || d22 == null) {
                return;
            }
            int h02 = h0(e22);
            int h03 = h0(d22);
            if (h02 < h03) {
                accessibilityEvent.setFromIndex(h02);
                accessibilityEvent.setToIndex(h03);
                return;
            }
            accessibilityEvent.setFromIndex(h03);
            accessibilityEvent.setToIndex(h02);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.I == null;
    }

    boolean M2(RecyclerView.z zVar, b bVar) {
        int i6;
        int m5;
        int g6;
        if (!zVar.e() && (i6 = this.C) != -1) {
            if (i6 >= 0 && i6 < zVar.b()) {
                e eVar = this.I;
                if (eVar == null || eVar.f2355a == -1 || eVar.f2357c < 1) {
                    View C = C(this.C);
                    if (C != null) {
                        bVar.f2340a = this.A ? k2() : j2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f2342c) {
                                m5 = this.f2333u.i() - this.D;
                                g6 = this.f2333u.d(C);
                            } else {
                                m5 = this.f2333u.m() + this.D;
                                g6 = this.f2333u.g(C);
                            }
                            bVar.f2341b = m5 - g6;
                            return true;
                        } else if (this.f2333u.e(C) > this.f2333u.n()) {
                            bVar.f2341b = bVar.f2342c ? this.f2333u.i() : this.f2333u.m();
                            return true;
                        } else {
                            int g7 = this.f2333u.g(C) - this.f2333u.m();
                            if (g7 < 0) {
                                bVar.f2341b = -g7;
                                return true;
                            }
                            int i7 = this.f2333u.i() - this.f2333u.d(C);
                            if (i7 < 0) {
                                bVar.f2341b = i7;
                                return true;
                            }
                            bVar.f2341b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i8 = this.C;
                        bVar.f2340a = i8;
                        int i9 = this.D;
                        if (i9 == Integer.MIN_VALUE) {
                            bVar.f2342c = R1(i8) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i9);
                        }
                        bVar.f2343d = true;
                    }
                } else {
                    bVar.f2341b = Integer.MIN_VALUE;
                    bVar.f2340a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.u uVar, RecyclerView.z zVar) {
        return this.f2335w == 1 ? this.f2331s : super.N(uVar, zVar);
    }

    void N2(RecyclerView.z zVar, b bVar) {
        if (M2(zVar, bVar) || L2(zVar, bVar)) {
            return;
        }
        bVar.a();
        bVar.f2340a = 0;
    }

    boolean O1() {
        int l6 = this.f2332t[0].l(Integer.MIN_VALUE);
        for (int i6 = 1; i6 < this.f2331s; i6++) {
            if (this.f2332t[i6].l(Integer.MIN_VALUE) != l6) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P0(RecyclerView.u uVar, RecyclerView.z zVar, View view, y yVar) {
        int i6;
        int i7;
        int e6;
        int i8;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.O0(view, yVar);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.f2335w == 0) {
            i6 = cVar.e();
            i7 = cVar.f2348f ? this.f2331s : 1;
            e6 = -1;
            i8 = -1;
        } else {
            i6 = -1;
            i7 = -1;
            e6 = cVar.e();
            i8 = cVar.f2348f ? this.f2331s : 1;
        }
        yVar.Z(y.c.a(i6, i7, e6, i8, false, false));
    }

    boolean P1() {
        int p5 = this.f2332t[0].p(Integer.MIN_VALUE);
        for (int i6 = 1; i6 < this.f2331s; i6++) {
            if (this.f2332t[i6].p(Integer.MIN_VALUE) != p5) {
                return false;
            }
        }
        return true;
    }

    void P2(int i6) {
        this.f2336x = i6 / this.f2331s;
        this.J = View.MeasureSpec.makeMeasureSpec(i6, this.f2334v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView, int i6, int i7) {
        q2(i6, i7, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView) {
        this.E.b();
        t1();
    }

    boolean S1() {
        int j22;
        int k22;
        if (J() == 0 || this.F == 0 || !r0()) {
            return false;
        }
        if (this.A) {
            j22 = k2();
            k22 = j2();
        } else {
            j22 = j2();
            k22 = k2();
        }
        if (j22 == 0 && r2() != null) {
            this.E.b();
        } else if (!this.M) {
            return false;
        } else {
            int i6 = this.A ? -1 : 1;
            int i7 = k22 + 1;
            d.a e6 = this.E.e(j22, i7, i6, true);
            if (e6 == null) {
                this.M = false;
                this.E.d(i7);
                return false;
            }
            d.a e7 = this.E.e(j22, e6.f2351a, i6 * (-1), true);
            if (e7 == null) {
                this.E.d(e6.f2351a);
            } else {
                this.E.d(e7.f2351a + 1);
            }
        }
        u1();
        t1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i6, int i7, int i8) {
        q2(i6, i7, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i6, int i7) {
        q2(i6, i7, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView, int i6, int i7, Object obj) {
        q2(i6, i7, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.u uVar, RecyclerView.z zVar) {
        w2(uVar, zVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.z zVar) {
        super.Y0(zVar);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF a(int i6) {
        int R1 = R1(i6);
        PointF pointF = new PointF();
        if (R1 == 0) {
            return null;
        }
        if (this.f2335w == 0) {
            pointF.x = R1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = R1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.I = (e) parcelable;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        int p5;
        int m5;
        int[] iArr;
        if (this.I != null) {
            return new e(this.I);
        }
        e eVar = new e();
        eVar.f2362h = this.f2338z;
        eVar.f2363k = this.G;
        eVar.f2364l = this.H;
        d dVar = this.E;
        if (dVar == null || (iArr = dVar.f2349a) == null) {
            eVar.f2359e = 0;
        } else {
            eVar.f2360f = iArr;
            eVar.f2359e = iArr.length;
            eVar.f2361g = dVar.f2350b;
        }
        if (J() > 0) {
            eVar.f2355a = this.G ? k2() : j2();
            eVar.f2356b = f2();
            int i6 = this.f2331s;
            eVar.f2357c = i6;
            eVar.f2358d = new int[i6];
            for (int i7 = 0; i7 < this.f2331s; i7++) {
                if (this.G) {
                    p5 = this.f2332t[i7].l(Integer.MIN_VALUE);
                    if (p5 != Integer.MIN_VALUE) {
                        m5 = this.f2333u.i();
                        p5 -= m5;
                        eVar.f2358d[i7] = p5;
                    } else {
                        eVar.f2358d[i7] = p5;
                    }
                } else {
                    p5 = this.f2332t[i7].p(Integer.MIN_VALUE);
                    if (p5 != Integer.MIN_VALUE) {
                        m5 = this.f2333u.m();
                        p5 -= m5;
                        eVar.f2358d[i7] = p5;
                    } else {
                        eVar.f2358d[i7] = p5;
                    }
                }
            }
        } else {
            eVar.f2355a = -1;
            eVar.f2356b = -1;
            eVar.f2357c = 0;
        }
        return eVar;
    }

    View d2(boolean z5) {
        int m5 = this.f2333u.m();
        int i6 = this.f2333u.i();
        View view = null;
        for (int J = J() - 1; J >= 0; J--) {
            View I = I(J);
            int g6 = this.f2333u.g(I);
            int d6 = this.f2333u.d(I);
            if (d6 > m5 && g6 < i6) {
                if (d6 <= i6 || !z5) {
                    return I;
                }
                if (view == null) {
                    view = I;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(int i6) {
        if (i6 == 0) {
            S1();
        }
    }

    View e2(boolean z5) {
        int m5 = this.f2333u.m();
        int i6 = this.f2333u.i();
        int J = J();
        View view = null;
        for (int i7 = 0; i7 < J; i7++) {
            View I = I(i7);
            int g6 = this.f2333u.g(I);
            if (this.f2333u.d(I) > m5 && g6 < i6) {
                if (g6 >= m5 || !z5) {
                    return I;
                }
                if (view == null) {
                    view = I;
                }
            }
        }
        return view;
    }

    int f2() {
        View d22 = this.A ? d2(true) : e2(true);
        if (d22 == null) {
            return -1;
        }
        return h0(d22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.I == null) {
            super.g(str);
        }
    }

    int j2() {
        if (J() == 0) {
            return 0;
        }
        return h0(I(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.f2335w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k0(RecyclerView.u uVar, RecyclerView.z zVar) {
        return this.f2335w == 0 ? this.f2331s : super.k0(uVar, zVar);
    }

    int k2() {
        int J = J();
        if (J == 0) {
            return 0;
        }
        return h0(I(J - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f2335w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i6, int i7, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        int l6;
        int i8;
        if (this.f2335w != 0) {
            i6 = i7;
        }
        if (J() == 0 || i6 == 0) {
            return;
        }
        y2(i6, zVar);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.f2331s) {
            this.O = new int[this.f2331s];
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.f2331s; i10++) {
            androidx.recyclerview.widget.f fVar = this.f2337y;
            if (fVar.f2488d == -1) {
                l6 = fVar.f2490f;
                i8 = this.f2332t[i10].p(l6);
            } else {
                l6 = this.f2332t[i10].l(fVar.f2491g);
                i8 = this.f2337y.f2491g;
            }
            int i11 = l6 - i8;
            if (i11 >= 0) {
                this.O[i9] = i11;
                i9++;
            }
        }
        Arrays.sort(this.O, 0, i9);
        for (int i12 = 0; i12 < i9 && this.f2337y.a(zVar); i12++) {
            cVar.a(this.f2337y.f2487c, this.O[i12]);
            androidx.recyclerview.widget.f fVar2 = this.f2337y;
            fVar2.f2487c += fVar2.f2488d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.z zVar) {
        return U1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.z zVar) {
        return V1(zVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    View r2() {
        int i6;
        int i7;
        boolean z5;
        int J = J() - 1;
        BitSet bitSet = new BitSet(this.f2331s);
        bitSet.set(0, this.f2331s, true);
        char c6 = (this.f2335w == 1 && t2()) ? (char) 1 : (char) 65535;
        if (this.A) {
            i6 = -1;
        } else {
            i6 = J + 1;
            J = 0;
        }
        int i8 = J < i6 ? 1 : -1;
        while (J != i6) {
            View I = I(J);
            c cVar = (c) I.getLayoutParams();
            if (bitSet.get(cVar.f2347e.f2369e)) {
                if (T1(cVar.f2347e)) {
                    return I;
                }
                bitSet.clear(cVar.f2347e.f2369e);
            }
            if (!cVar.f2348f && (i7 = J + i8) != i6) {
                View I2 = I(i7);
                if (this.A) {
                    int d6 = this.f2333u.d(I);
                    int d7 = this.f2333u.d(I2);
                    if (d6 < d7) {
                        return I;
                    }
                } else {
                    int g6 = this.f2333u.g(I);
                    int g7 = this.f2333u.g(I2);
                    if (g6 > g7) {
                        return I;
                    }
                }
                if (z5) {
                    if ((cVar.f2347e.f2369e - ((c) I2.getLayoutParams()).f2347e.f2369e < 0) != (c6 < 0)) {
                        return I;
                    }
                } else {
                    continue;
                }
            }
            J += i8;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z zVar) {
        return W1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return this.F != 0;
    }

    public void s2() {
        this.E.b();
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.z zVar) {
        return U1(zVar);
    }

    boolean t2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.z zVar) {
        return V1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z zVar) {
        return W1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i6, RecyclerView.u uVar, RecyclerView.z zVar) {
        return F2(i6, uVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i6) {
        e eVar = this.I;
        if (eVar != null && eVar.f2355a != i6) {
            eVar.e();
        }
        this.C = i6;
        this.D = Integer.MIN_VALUE;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i6, RecyclerView.u uVar, RecyclerView.z zVar) {
        return F2(i6, uVar, zVar);
    }

    void y2(int i6, RecyclerView.z zVar) {
        int j22;
        int i7;
        if (i6 > 0) {
            j22 = k2();
            i7 = 1;
        } else {
            j22 = j2();
            i7 = -1;
        }
        this.f2337y.f2485a = true;
        O2(j22, zVar);
        G2(i7);
        androidx.recyclerview.widget.f fVar = this.f2337y;
        fVar.f2487c = j22 + fVar.f2488d;
        fVar.f2486b = Math.abs(i6);
    }
}
