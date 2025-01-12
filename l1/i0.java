package l1;

import android.util.SparseArray;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public interface i0 {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f11554a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11555b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f11556c;

        public a(String str, int i6, byte[] bArr) {
            this.f11554a = str;
            this.f11555b = i6;
            this.f11556c = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f11557a;

        /* renamed from: b  reason: collision with root package name */
        public final String f11558b;

        /* renamed from: c  reason: collision with root package name */
        public final List f11559c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f11560d;

        public b(int i6, String str, List list, byte[] bArr) {
            this.f11557a = i6;
            this.f11558b = str;
            this.f11559c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f11560d = bArr;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        SparseArray a();

        i0 b(int i6, b bVar);
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f11561a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11562b;

        /* renamed from: c  reason: collision with root package name */
        private final int f11563c;

        /* renamed from: d  reason: collision with root package name */
        private int f11564d;

        /* renamed from: e  reason: collision with root package name */
        private String f11565e;

        public d(int i6, int i7) {
            this(Integer.MIN_VALUE, i6, i7);
        }

        private void d() {
            if (this.f11564d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i6 = this.f11564d;
            int i7 = i6 == Integer.MIN_VALUE ? this.f11562b : i6 + this.f11563c;
            this.f11564d = i7;
            String str = this.f11561a;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11);
            sb.append(str);
            sb.append(i7);
            this.f11565e = sb.toString();
        }

        public String b() {
            d();
            return this.f11565e;
        }

        public int c() {
            d();
            return this.f11564d;
        }

        public d(int i6, int i7, int i8) {
            String str;
            if (i6 != Integer.MIN_VALUE) {
                StringBuilder sb = new StringBuilder(12);
                sb.append(i6);
                sb.append("/");
                str = sb.toString();
            } else {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            this.f11561a = str;
            this.f11562b = i7;
            this.f11563c = i8;
            this.f11564d = Integer.MIN_VALUE;
            this.f11565e = HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    void a();

    void b(com.google.android.exoplayer2.util.k0 k0Var, c1.k kVar, d dVar);

    void c(com.google.android.exoplayer2.util.y yVar, int i6);
}
