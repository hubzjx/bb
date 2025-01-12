package com.google.common.base;

import java.util.Arrays;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class g {

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f5589a;

        /* renamed from: b  reason: collision with root package name */
        private final a f5590b;

        /* renamed from: c  reason: collision with root package name */
        private a f5591c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f5592d;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            String f5593a;

            /* renamed from: b  reason: collision with root package name */
            Object f5594b;

            /* renamed from: c  reason: collision with root package name */
            a f5595c;

            private a() {
            }
        }

        private b(String str) {
            a aVar = new a();
            this.f5590b = aVar;
            this.f5591c = aVar;
            this.f5592d = false;
            this.f5589a = (String) j.j(str);
        }

        private a c() {
            a aVar = new a();
            this.f5591c.f5595c = aVar;
            this.f5591c = aVar;
            return aVar;
        }

        private b d(Object obj) {
            c().f5594b = obj;
            return this;
        }

        private b e(String str, Object obj) {
            a c6 = c();
            c6.f5594b = obj;
            c6.f5593a = (String) j.j(str);
            return this;
        }

        public b a(String str, int i6) {
            return e(str, String.valueOf(i6));
        }

        public b b(String str, Object obj) {
            return e(str, obj);
        }

        public b f(Object obj) {
            return d(obj);
        }

        public String toString() {
            boolean z5 = this.f5592d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f5589a);
            sb.append('{');
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            for (a aVar = this.f5590b.f5595c; aVar != null; aVar = aVar.f5595c) {
                Object obj = aVar.f5594b;
                if (!z5 || obj != null) {
                    sb.append(str);
                    String str2 = aVar.f5593a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static Object a(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        if (obj2 != null) {
            return obj2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
