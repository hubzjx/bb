package b0;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import d0.i;
/* loaded from: classes.dex */
public abstract class f {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f2874a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f2875b;

        public a(int i6, b[] bVarArr) {
            this.f2874a = i6;
            this.f2875b = bVarArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(int i6, b[] bVarArr) {
            return new a(i6, bVarArr);
        }

        public b[] b() {
            return this.f2875b;
        }

        public int c() {
            return this.f2874a;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f2876a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2877b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2878c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f2879d;

        /* renamed from: e  reason: collision with root package name */
        private final int f2880e;

        public b(Uri uri, int i6, int i7, boolean z5, int i8) {
            this.f2876a = (Uri) i.c(uri);
            this.f2877b = i6;
            this.f2878c = i7;
            this.f2879d = z5;
            this.f2880e = i8;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(Uri uri, int i6, int i7, boolean z5, int i8) {
            return new b(uri, i6, i7, z5, i8);
        }

        public int b() {
            return this.f2880e;
        }

        public int c() {
            return this.f2877b;
        }

        public Uri d() {
            return this.f2876a;
        }

        public int e() {
            return this.f2878c;
        }

        public boolean f() {
            return this.f2879d;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public abstract void a(int i6);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, d dVar, int i6, boolean z5, int i7, Handler handler, c cVar) {
        b0.a aVar = new b0.a(cVar, handler);
        return z5 ? e.e(context, dVar, aVar, i6, i7) : e.d(context, dVar, i6, null, aVar);
    }
}
