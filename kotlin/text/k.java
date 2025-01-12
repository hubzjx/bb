package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class k implements Serializable {
    public static final a Companion = new a(null);
    private Set<? extends m> _options;
    private final Pattern nativePattern;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i6) {
            return (i6 & 2) != 0 ? i6 | 64 : i6;
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public b(String str, int i6) {
            kotlin.jvm.internal.l.d(str, "pattern");
            this.pattern = str;
            this.flags = i6;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            kotlin.jvm.internal.l.c(compile, "compile(pattern, flags)");
            return new k(compile);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends kotlin.jvm.internal.m implements p4.a {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $startIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence, int i6) {
            super(0);
            this.$input = charSequence;
            this.$startIndex = i6;
        }

        @Override // p4.a
        public final i invoke() {
            return k.this.find(this.$input, this.$startIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class d extends kotlin.jvm.internal.j implements p4.l {
        public static final d INSTANCE = new d();

        d() {
            super(1, i.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // p4.l
        public final i invoke(i iVar) {
            kotlin.jvm.internal.l.d(iVar, "p0");
            return iVar.next();
        }
    }

    /* loaded from: classes.dex */
    static final class e extends kotlin.jvm.internal.m implements p4.l {
        final /* synthetic */ int $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i6) {
            super(1);
            this.$value = i6;
        }

        public final Boolean invoke(m mVar) {
            m mVar2 = mVar;
            return Boolean.valueOf((this.$value & mVar2.getMask()) == mVar2.getValue());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p4.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((m) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f extends kotlin.coroutines.jvm.internal.j implements p4.p {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(CharSequence charSequence, int i6, j4.a aVar) {
            super(2, aVar);
            this.$input = charSequence;
            this.$limit = i6;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final j4.a create(Object obj, j4.a aVar) {
            f fVar = new f(this.$input, this.$limit, aVar);
            fVar.L$0 = obj;
            return fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0072 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009e A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0070 -> B:21:0x0073). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object b6;
            f fVar;
            t4.f fVar2;
            Matcher matcher;
            int i6;
            String obj2;
            String obj3;
            b6 = kotlin.coroutines.intrinsics.d.b();
            int i7 = this.label;
            if (i7 == 0) {
                h4.l.b(obj);
                t4.f fVar3 = (t4.f) this.L$0;
                Matcher matcher2 = k.this.nativePattern.matcher(this.$input);
                if (this.$limit != 1 && matcher2.find()) {
                    int i8 = 0;
                    fVar = this;
                    fVar2 = fVar3;
                    matcher = matcher2;
                    i6 = 0;
                    obj2 = fVar.$input.subSequence(i8, matcher.start()).toString();
                    fVar.L$0 = fVar2;
                    fVar.L$1 = matcher;
                    fVar.I$0 = i6;
                    fVar.label = 2;
                    if (fVar2.a(obj2, fVar) == b6) {
                    }
                    i8 = matcher.end();
                    i6++;
                    if (i6 != fVar.$limit - 1) {
                    }
                    CharSequence charSequence = fVar.$input;
                    obj3 = charSequence.subSequence(i8, charSequence.length()).toString();
                    fVar.L$0 = null;
                    fVar.L$1 = null;
                    fVar.label = 3;
                    if (fVar2.a(obj3, fVar) == b6) {
                    }
                    return h4.q.f10774a;
                }
                String obj4 = this.$input.toString();
                this.label = 1;
                if (fVar3.a(obj4, this) == b6) {
                    return b6;
                }
            } else if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 == 3) {
                        h4.l.b(obj);
                        return h4.q.f10774a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i6 = this.I$0;
                fVar2 = (t4.f) this.L$0;
                h4.l.b(obj);
                fVar = this;
                matcher = (Matcher) this.L$1;
                i8 = matcher.end();
                i6++;
                if (i6 != fVar.$limit - 1 || !matcher.find()) {
                    CharSequence charSequence2 = fVar.$input;
                    obj3 = charSequence2.subSequence(i8, charSequence2.length()).toString();
                    fVar.L$0 = null;
                    fVar.L$1 = null;
                    fVar.label = 3;
                    if (fVar2.a(obj3, fVar) == b6) {
                        return b6;
                    }
                    return h4.q.f10774a;
                }
                obj2 = fVar.$input.subSequence(i8, matcher.start()).toString();
                fVar.L$0 = fVar2;
                fVar.L$1 = matcher;
                fVar.I$0 = i6;
                fVar.label = 2;
                if (fVar2.a(obj2, fVar) == b6) {
                    return b6;
                }
                i8 = matcher.end();
                i6++;
                if (i6 != fVar.$limit - 1) {
                }
                CharSequence charSequence22 = fVar.$input;
                obj3 = charSequence22.subSequence(i8, charSequence22.length()).toString();
                fVar.L$0 = null;
                fVar.L$1 = null;
                fVar.label = 3;
                if (fVar2.a(obj3, fVar) == b6) {
                }
                return h4.q.f10774a;
            } else {
                h4.l.b(obj);
            }
            return h4.q.f10774a;
        }

        @Override // p4.p
        public final Object invoke(t4.f fVar, j4.a aVar) {
            return ((f) create(fVar, aVar)).invokeSuspend(h4.q.f10774a);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k(String str) {
        this(r2);
        kotlin.jvm.internal.l.d(str, "pattern");
        Pattern compile = Pattern.compile(str);
        kotlin.jvm.internal.l.c(compile, "compile(pattern)");
    }

    public static /* synthetic */ i find$default(k kVar, CharSequence charSequence, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return kVar.find(charSequence, i6);
    }

    public static /* synthetic */ t4.d findAll$default(k kVar, CharSequence charSequence, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return kVar.findAll(charSequence, i6);
    }

    public static /* synthetic */ List split$default(k kVar, CharSequence charSequence, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return kVar.split(charSequence, i6);
    }

    public static /* synthetic */ t4.d splitToSequence$default(k kVar, CharSequence charSequence, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return kVar.splitToSequence(charSequence, i6);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.l.c(pattern, "nativePattern.pattern()");
        return new b(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        kotlin.jvm.internal.l.d(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    public final i find(CharSequence charSequence, int i6) {
        i f6;
        kotlin.jvm.internal.l.d(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        kotlin.jvm.internal.l.c(matcher, "nativePattern.matcher(input)");
        f6 = l.f(matcher, i6, charSequence);
        return f6;
    }

    public final t4.d findAll(CharSequence charSequence, int i6) {
        kotlin.jvm.internal.l.d(charSequence, "input");
        if (i6 < 0 || i6 > charSequence.length()) {
            throw new IndexOutOfBoundsException("Start index out of bounds: " + i6 + ", input length: " + charSequence.length());
        }
        return t4.g.c(new c(charSequence, i6), d.INSTANCE);
    }

    public final Set<m> getOptions() {
        Set set = this._options;
        if (set == null) {
            int flags = this.nativePattern.flags();
            EnumSet allOf = EnumSet.allOf(m.class);
            kotlin.jvm.internal.l.c(allOf, HttpUrl.FRAGMENT_ENCODE_SET);
            kotlin.collections.s.w(allOf, new e(flags));
            Set<m> unmodifiableSet = Collections.unmodifiableSet(allOf);
            kotlin.jvm.internal.l.c(unmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
            this._options = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.l.c(pattern, "nativePattern.pattern()");
        return pattern;
    }

    public final i matchAt(CharSequence charSequence, int i6) {
        kotlin.jvm.internal.l.d(charSequence, "input");
        Matcher region = this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i6, charSequence.length());
        if (region.lookingAt()) {
            kotlin.jvm.internal.l.c(region, "this");
            return new j(region, charSequence);
        }
        return null;
    }

    public final i matchEntire(CharSequence charSequence) {
        i g6;
        kotlin.jvm.internal.l.d(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        kotlin.jvm.internal.l.c(matcher, "nativePattern.matcher(input)");
        g6 = l.g(matcher, charSequence);
        return g6;
    }

    public final boolean matches(CharSequence charSequence) {
        kotlin.jvm.internal.l.d(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final boolean matchesAt(CharSequence charSequence, int i6) {
        kotlin.jvm.internal.l.d(charSequence, "input");
        return this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i6, charSequence.length()).lookingAt();
    }

    public final String replace(CharSequence charSequence, String str) {
        kotlin.jvm.internal.l.d(charSequence, "input");
        kotlin.jvm.internal.l.d(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        kotlin.jvm.internal.l.c(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String replaceFirst(CharSequence charSequence, String str) {
        kotlin.jvm.internal.l.d(charSequence, "input");
        kotlin.jvm.internal.l.d(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        kotlin.jvm.internal.l.c(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public final List<String> split(CharSequence charSequence, int i6) {
        List<String> b6;
        kotlin.jvm.internal.l.d(charSequence, "input");
        x.g0(i6);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (i6 == 1 || !matcher.find()) {
            b6 = kotlin.collections.m.b(charSequence.toString());
            return b6;
        }
        ArrayList arrayList = new ArrayList(i6 > 0 ? r4.f.c(i6, 10) : 10);
        int i7 = i6 - 1;
        int i8 = 0;
        do {
            arrayList.add(charSequence.subSequence(i8, matcher.start()).toString());
            i8 = matcher.end();
            if (i7 >= 0 && arrayList.size() == i7) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(i8, charSequence.length()).toString());
        return arrayList;
    }

    public final t4.d splitToSequence(CharSequence charSequence, int i6) {
        kotlin.jvm.internal.l.d(charSequence, "input");
        x.g0(i6);
        return t4.g.b(new f(charSequence, i6, null));
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        kotlin.jvm.internal.l.c(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k(String str, Set<? extends m> set) {
        this(r2);
        int j6;
        kotlin.jvm.internal.l.d(str, "pattern");
        kotlin.jvm.internal.l.d(set, "options");
        a aVar = Companion;
        j6 = l.j(set);
        Pattern compile = Pattern.compile(str, aVar.b(j6));
        kotlin.jvm.internal.l.c(compile, "compile(pattern, ensureU…odeCase(options.toInt()))");
    }

    public final String replace(CharSequence charSequence, p4.l lVar) {
        kotlin.jvm.internal.l.d(charSequence, "input");
        kotlin.jvm.internal.l.d(lVar, "transform");
        int i6 = 0;
        i find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(charSequence, i6, find$default.a().h().intValue());
            sb.append((CharSequence) lVar.invoke(find$default));
            i6 = find$default.a().g().intValue() + 1;
            find$default = find$default.next();
            if (i6 >= length) {
                break;
            }
        } while (find$default != null);
        if (i6 < length) {
            sb.append(charSequence, i6, length);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.l.c(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k(String str, m mVar) {
        this(r2);
        kotlin.jvm.internal.l.d(str, "pattern");
        kotlin.jvm.internal.l.d(mVar, "option");
        Pattern compile = Pattern.compile(str, Companion.b(mVar.getValue()));
        kotlin.jvm.internal.l.c(compile, "compile(pattern, ensureUnicodeCase(option.value))");
    }

    public k(Pattern pattern) {
        kotlin.jvm.internal.l.d(pattern, "nativePattern");
        this.nativePattern = pattern;
    }
}
