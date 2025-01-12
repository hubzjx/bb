package c0;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    static final o f3094d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f3095e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f3096f;

    /* renamed from: g  reason: collision with root package name */
    static final a f3097g;

    /* renamed from: h  reason: collision with root package name */
    static final a f3098h;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3099a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3100b;

    /* renamed from: c  reason: collision with root package name */
    private final o f3101c;

    /* renamed from: c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0031a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3102a;

        /* renamed from: b  reason: collision with root package name */
        private int f3103b;

        /* renamed from: c  reason: collision with root package name */
        private o f3104c;

        public C0031a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z5) {
            return z5 ? a.f3098h : a.f3097g;
        }

        private void c(boolean z5) {
            this.f3102a = z5;
            this.f3104c = a.f3094d;
            this.f3103b = 2;
        }

        public a a() {
            return (this.f3103b == 2 && this.f3104c == a.f3094d) ? b(this.f3102a) : new a(this.f3102a, this.f3103b, this.f3104c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f3105f = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        private final CharSequence f3106a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f3107b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3108c;

        /* renamed from: d  reason: collision with root package name */
        private int f3109d;

        /* renamed from: e  reason: collision with root package name */
        private char f3110e;

        static {
            for (int i6 = 0; i6 < 1792; i6++) {
                f3105f[i6] = Character.getDirectionality(i6);
            }
        }

        b(CharSequence charSequence, boolean z5) {
            this.f3106a = charSequence;
            this.f3107b = z5;
            this.f3108c = charSequence.length();
        }

        private static byte c(char c6) {
            return c6 < 1792 ? f3105f[c6] : Character.getDirectionality(c6);
        }

        private byte f() {
            char charAt;
            int i6 = this.f3109d;
            do {
                int i7 = this.f3109d;
                if (i7 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f3106a;
                int i8 = i7 - 1;
                this.f3109d = i8;
                charAt = charSequence.charAt(i8);
                this.f3110e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f3109d = i6;
            this.f3110e = ';';
            return (byte) 13;
        }

        private byte g() {
            char charAt;
            do {
                int i6 = this.f3109d;
                if (i6 >= this.f3108c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f3106a;
                this.f3109d = i6 + 1;
                charAt = charSequence.charAt(i6);
                this.f3110e = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i6 = this.f3109d;
            while (true) {
                int i7 = this.f3109d;
                if (i7 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f3106a;
                int i8 = i7 - 1;
                this.f3109d = i8;
                char charAt2 = charSequence.charAt(i8);
                this.f3110e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i9 = this.f3109d;
                        if (i9 > 0) {
                            CharSequence charSequence2 = this.f3106a;
                            int i10 = i9 - 1;
                            this.f3109d = i10;
                            charAt = charSequence2.charAt(i10);
                            this.f3110e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.f3109d = i6;
            this.f3110e = '>';
            return (byte) 13;
        }

        private byte i() {
            char charAt;
            int i6 = this.f3109d;
            while (true) {
                int i7 = this.f3109d;
                if (i7 >= this.f3108c) {
                    this.f3109d = i6;
                    this.f3110e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f3106a;
                this.f3109d = i7 + 1;
                char charAt2 = charSequence.charAt(i7);
                this.f3110e = charAt2;
                if (charAt2 == '>') {
                    return (byte) 12;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i8 = this.f3109d;
                        if (i8 < this.f3108c) {
                            CharSequence charSequence2 = this.f3106a;
                            this.f3109d = i8 + 1;
                            charAt = charSequence2.charAt(i8);
                            this.f3110e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
        }

        byte a() {
            char charAt = this.f3106a.charAt(this.f3109d - 1);
            this.f3110e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f3106a, this.f3109d);
                this.f3109d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f3109d--;
            byte c6 = c(this.f3110e);
            if (this.f3107b) {
                char c7 = this.f3110e;
                return c7 == '>' ? h() : c7 == ';' ? f() : c6;
            }
            return c6;
        }

        byte b() {
            char charAt = this.f3106a.charAt(this.f3109d);
            this.f3110e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f3106a, this.f3109d);
                this.f3109d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f3109d++;
            byte c6 = c(this.f3110e);
            if (this.f3107b) {
                char c7 = this.f3110e;
                return c7 == '<' ? i() : c7 == '&' ? g() : c6;
            }
            return c6;
        }

        int d() {
            this.f3109d = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (this.f3109d < this.f3108c && i6 == 0) {
                byte b6 = b();
                if (b6 != 0) {
                    if (b6 == 1 || b6 == 2) {
                        if (i8 == 0) {
                            return 1;
                        }
                    } else if (b6 != 9) {
                        switch (b6) {
                            case 14:
                            case 15:
                                i8++;
                                i7 = -1;
                                break;
                            case 16:
                            case 17:
                                i8++;
                                i7 = 1;
                                break;
                            case 18:
                                i8--;
                                i7 = 0;
                                break;
                        }
                    }
                } else if (i8 == 0) {
                    return -1;
                }
                i6 = i8;
            }
            if (i6 == 0) {
                return 0;
            }
            if (i7 != 0) {
                return i7;
            }
            while (this.f3109d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i6 == i8) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i6 == i8) {
                            return 1;
                        }
                        break;
                    case 18:
                        i8++;
                        continue;
                }
                i8--;
            }
            return 0;
        }

        int e() {
            this.f3109d = this.f3108c;
            int i6 = 0;
            int i7 = 0;
            while (this.f3109d > 0) {
                byte a6 = a();
                if (a6 != 0) {
                    if (a6 == 1 || a6 == 2) {
                        if (i6 == 0) {
                            return 1;
                        }
                        if (i7 == 0) {
                            i7 = i6;
                        }
                    } else if (a6 != 9) {
                        switch (a6) {
                            case 14:
                            case 15:
                                if (i7 == i6) {
                                    return -1;
                                }
                                i6--;
                                break;
                            case 16:
                            case 17:
                                if (i7 == i6) {
                                    return 1;
                                }
                                i6--;
                                break;
                            case 18:
                                i6++;
                                break;
                            default:
                                if (i7 != 0) {
                                    break;
                                } else {
                                    i7 = i6;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else if (i6 == 0) {
                    return -1;
                } else {
                    if (i7 == 0) {
                        i7 = i6;
                    }
                }
            }
            return 0;
        }
    }

    static {
        o oVar = p.f3122c;
        f3094d = oVar;
        f3095e = Character.toString((char) 8206);
        f3096f = Character.toString((char) 8207);
        f3097g = new a(false, 2, oVar);
        f3098h = new a(true, 2, oVar);
    }

    a(boolean z5, int i6, o oVar) {
        this.f3099a = z5;
        this.f3100b = i6;
        this.f3101c = oVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0031a().a();
    }

    static boolean e(Locale locale) {
        return q.a(locale) == 1;
    }

    private String f(CharSequence charSequence, o oVar) {
        boolean a6 = oVar.a(charSequence, 0, charSequence.length());
        return (this.f3099a || !(a6 || b(charSequence) == 1)) ? this.f3099a ? (!a6 || b(charSequence) == -1) ? f3096f : HttpUrl.FRAGMENT_ENCODE_SET : HttpUrl.FRAGMENT_ENCODE_SET : f3095e;
    }

    private String g(CharSequence charSequence, o oVar) {
        boolean a6 = oVar.a(charSequence, 0, charSequence.length());
        return (this.f3099a || !(a6 || a(charSequence) == 1)) ? this.f3099a ? (!a6 || a(charSequence) == -1) ? f3096f : HttpUrl.FRAGMENT_ENCODE_SET : HttpUrl.FRAGMENT_ENCODE_SET : f3095e;
    }

    public boolean d() {
        return (this.f3100b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f3101c, true);
    }

    public CharSequence i(CharSequence charSequence, o oVar, boolean z5) {
        if (charSequence == null) {
            return null;
        }
        boolean a6 = oVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z5) {
            spannableStringBuilder.append((CharSequence) g(charSequence, a6 ? p.f3121b : p.f3120a));
        }
        if (a6 != this.f3099a) {
            spannableStringBuilder.append(a6 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z5) {
            spannableStringBuilder.append((CharSequence) f(charSequence, a6 ? p.f3121b : p.f3120a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f3101c, true);
    }

    public String k(String str, o oVar, boolean z5) {
        if (str == null) {
            return null;
        }
        return i(str, oVar, z5).toString();
    }
}
