package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Matcher f11347a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f11348b;

    /* renamed from: c  reason: collision with root package name */
    private final h f11349c;

    /* loaded from: classes.dex */
    public static final class a extends kotlin.collections.a implements h {

        /* renamed from: kotlin.text.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0187a extends kotlin.jvm.internal.m implements p4.l {
            C0187a() {
                super(1);
            }

            @Override // p4.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final g invoke(int i6) {
                return a.this.b(i6);
            }
        }

        a() {
        }

        public /* bridge */ boolean a(g gVar) {
            return super.contains(gVar);
        }

        public g b(int i6) {
            r4.c i7;
            i7 = l.i(j.this.c(), i6);
            if (i7.h().intValue() >= 0) {
                String group = j.this.c().group(i6);
                kotlin.jvm.internal.l.c(group, "matchResult.group(index)");
                return new g(group, i7);
            }
            return null;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof g) {
                return a((g) obj);
            }
            return false;
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return j.this.c().groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            r4.c g6;
            t4.d x5;
            t4.d i6;
            g6 = kotlin.collections.n.g(this);
            x5 = kotlin.collections.v.x(g6);
            i6 = t4.l.i(x5, new C0187a());
            return i6.iterator();
        }
    }

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.l.d(matcher, "matcher");
        kotlin.jvm.internal.l.d(charSequence, "input");
        this.f11347a = matcher;
        this.f11348b = charSequence;
        this.f11349c = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult c() {
        return this.f11347a;
    }

    @Override // kotlin.text.i
    public r4.c a() {
        r4.c h6;
        h6 = l.h(c());
        return h6;
    }

    @Override // kotlin.text.i
    public i next() {
        i f6;
        int end = c().end() + (c().end() == c().start() ? 1 : 0);
        if (end <= this.f11348b.length()) {
            Matcher matcher = this.f11347a.pattern().matcher(this.f11348b);
            kotlin.jvm.internal.l.c(matcher, "matcher.pattern().matcher(input)");
            f6 = l.f(matcher, end, this.f11348b);
            return f6;
        }
        return null;
    }
}
