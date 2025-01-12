package c0;

import java.util.Locale;
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    public static final o f3120a = new e(null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final o f3121b = new e(null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final o f3122c;

    /* renamed from: d  reason: collision with root package name */
    public static final o f3123d;

    /* renamed from: e  reason: collision with root package name */
    public static final o f3124e;

    /* renamed from: f  reason: collision with root package name */
    public static final o f3125f;

    /* loaded from: classes.dex */
    private static class a implements c {

        /* renamed from: b  reason: collision with root package name */
        static final a f3126b = new a(true);

        /* renamed from: a  reason: collision with root package name */
        private final boolean f3127a;

        private a(boolean z5) {
            this.f3127a = z5;
        }

        @Override // c0.p.c
        public int a(CharSequence charSequence, int i6, int i7) {
            int i8 = i7 + i6;
            boolean z5 = false;
            while (i6 < i8) {
                int a6 = p.a(Character.getDirectionality(charSequence.charAt(i6)));
                if (a6 != 0) {
                    if (a6 != 1) {
                        continue;
                        i6++;
                    } else if (!this.f3127a) {
                        return 1;
                    }
                } else if (this.f3127a) {
                    return 0;
                }
                z5 = true;
                i6++;
            }
            if (z5) {
                return this.f3127a ? 1 : 0;
            }
            return 2;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f3128a = new b();

        private b() {
        }

        @Override // c0.p.c
        public int a(CharSequence charSequence, int i6, int i7) {
            int i8 = i7 + i6;
            int i9 = 2;
            while (i6 < i8 && i9 == 2) {
                i9 = p.b(Character.getDirectionality(charSequence.charAt(i6)));
                i6++;
            }
            return i9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i6, int i7);
    }

    /* loaded from: classes.dex */
    private static abstract class d implements o {

        /* renamed from: a  reason: collision with root package name */
        private final c f3129a;

        d(c cVar) {
            this.f3129a = cVar;
        }

        private boolean c(CharSequence charSequence, int i6, int i7) {
            int a6 = this.f3129a.a(charSequence, i6, i7);
            if (a6 != 0) {
                if (a6 != 1) {
                    return b();
                }
                return false;
            }
            return true;
        }

        @Override // c0.o
        public boolean a(CharSequence charSequence, int i6, int i7) {
            if (charSequence == null || i6 < 0 || i7 < 0 || charSequence.length() - i7 < i6) {
                throw new IllegalArgumentException();
            }
            return this.f3129a == null ? b() : c(charSequence, i6, i7);
        }

        protected abstract boolean b();
    }

    /* loaded from: classes.dex */
    private static class e extends d {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f3130b;

        e(c cVar, boolean z5) {
            super(cVar);
            this.f3130b = z5;
        }

        @Override // c0.p.d
        protected boolean b() {
            return this.f3130b;
        }
    }

    /* loaded from: classes.dex */
    private static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        static final f f3131b = new f();

        f() {
            super(null);
        }

        @Override // c0.p.d
        protected boolean b() {
            return q.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f3128a;
        f3122c = new e(bVar, false);
        f3123d = new e(bVar, true);
        f3124e = new e(a.f3126b, false);
        f3125f = f.f3131b;
    }

    static int a(int i6) {
        if (i6 != 0) {
            return (i6 == 1 || i6 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i6) {
        if (i6 != 0) {
            if (i6 == 1 || i6 == 2) {
                return 0;
            }
            switch (i6) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
