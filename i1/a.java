package i1;

import com.google.android.exoplayer2.util.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f10870a;

    /* renamed from: i1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0178a extends a {

        /* renamed from: b  reason: collision with root package name */
        public final long f10871b;

        /* renamed from: c  reason: collision with root package name */
        public final List f10872c;

        /* renamed from: d  reason: collision with root package name */
        public final List f10873d;

        public C0178a(int i6, long j6) {
            super(i6);
            this.f10871b = j6;
            this.f10872c = new ArrayList();
            this.f10873d = new ArrayList();
        }

        public void d(C0178a c0178a) {
            this.f10873d.add(c0178a);
        }

        public void e(b bVar) {
            this.f10872c.add(bVar);
        }

        public C0178a f(int i6) {
            int size = this.f10873d.size();
            for (int i7 = 0; i7 < size; i7++) {
                C0178a c0178a = (C0178a) this.f10873d.get(i7);
                if (c0178a.f10870a == i6) {
                    return c0178a;
                }
            }
            return null;
        }

        public b g(int i6) {
            int size = this.f10872c.size();
            for (int i7 = 0; i7 < size; i7++) {
                b bVar = (b) this.f10872c.get(i7);
                if (bVar.f10870a == i6) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // i1.a
        public String toString() {
            String a6 = a.a(this.f10870a);
            String arrays = Arrays.toString(this.f10872c.toArray());
            String arrays2 = Arrays.toString(this.f10873d.toArray());
            StringBuilder sb = new StringBuilder(String.valueOf(a6).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
            sb.append(a6);
            sb.append(" leaves: ");
            sb.append(arrays);
            sb.append(" containers: ");
            sb.append(arrays2);
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    static final class b extends a {

        /* renamed from: b  reason: collision with root package name */
        public final y f10874b;

        public b(int i6, y yVar) {
            super(i6);
            this.f10874b = yVar;
        }
    }

    public a(int i6) {
        this.f10870a = i6;
    }

    public static String a(int i6) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) ((i6 >> 24) & 255));
        sb.append((char) ((i6 >> 16) & 255));
        sb.append((char) ((i6 >> 8) & 255));
        sb.append((char) (i6 & 255));
        return sb.toString();
    }

    public static int b(int i6) {
        return i6 & 16777215;
    }

    public static int c(int i6) {
        return (i6 >> 24) & 255;
    }

    public String toString() {
        return a(this.f10870a);
    }
}
