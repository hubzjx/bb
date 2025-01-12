package androidx.recyclerview.widget;

import android.view.View;
/* loaded from: classes.dex */
class o {

    /* renamed from: a  reason: collision with root package name */
    final b f2519a;

    /* renamed from: b  reason: collision with root package name */
    a f2520b = new a();

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2521a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f2522b;

        /* renamed from: c  reason: collision with root package name */
        int f2523c;

        /* renamed from: d  reason: collision with root package name */
        int f2524d;

        /* renamed from: e  reason: collision with root package name */
        int f2525e;

        a() {
        }

        void a(int i6) {
            this.f2521a = i6 | this.f2521a;
        }

        boolean b() {
            int i6 = this.f2521a;
            if ((i6 & 7) == 0 || (i6 & (c(this.f2524d, this.f2522b) << 0)) != 0) {
                int i7 = this.f2521a;
                if ((i7 & 112) == 0 || (i7 & (c(this.f2524d, this.f2523c) << 4)) != 0) {
                    int i8 = this.f2521a;
                    if ((i8 & 1792) == 0 || (i8 & (c(this.f2525e, this.f2522b) << 8)) != 0) {
                        int i9 = this.f2521a;
                        return (i9 & 28672) == 0 || (i9 & (c(this.f2525e, this.f2523c) << 12)) != 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        int c(int i6, int i7) {
            if (i6 > i7) {
                return 1;
            }
            return i6 == i7 ? 2 : 4;
        }

        void d() {
            this.f2521a = 0;
        }

        void e(int i6, int i7, int i8, int i9) {
            this.f2522b = i6;
            this.f2523c = i7;
            this.f2524d = i8;
            this.f2525e = i9;
        }
    }

    /* loaded from: classes.dex */
    interface b {
        View a(int i6);

        int b();

        int c(View view);

        int d();

        int e(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar) {
        this.f2519a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i6, int i7, int i8, int i9) {
        int d6 = this.f2519a.d();
        int b6 = this.f2519a.b();
        int i10 = i7 > i6 ? 1 : -1;
        View view = null;
        while (i6 != i7) {
            View a6 = this.f2519a.a(i6);
            this.f2520b.e(d6, b6, this.f2519a.c(a6), this.f2519a.e(a6));
            if (i8 != 0) {
                this.f2520b.d();
                this.f2520b.a(i8);
                if (this.f2520b.b()) {
                    return a6;
                }
            }
            if (i9 != 0) {
                this.f2520b.d();
                this.f2520b.a(i9);
                if (this.f2520b.b()) {
                    view = a6;
                }
            }
            i6 += i10;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(View view, int i6) {
        this.f2520b.e(this.f2519a.d(), this.f2519a.b(), this.f2519a.c(view), this.f2519a.e(view));
        if (i6 != 0) {
            this.f2520b.d();
            this.f2520b.a(i6);
            return this.f2520b.b();
        }
        return false;
    }
}
