package w3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g {
    private int b(h hVar, StringBuilder sb, StringBuilder sb2, int i6) {
        int length = sb.length();
        sb.delete(length - i6, length);
        hVar.f14114d--;
        int c6 = c(hVar.c(), sb2);
        hVar.k();
        return c6;
    }

    private static String d(CharSequence charSequence, int i6) {
        int charAt = (charSequence.charAt(i6) * 1600) + (charSequence.charAt(i6 + 1) * '(') + charSequence.charAt(i6 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(h hVar, StringBuilder sb) {
        hVar.s(d(sb, 0));
        sb.delete(0, 3);
    }

    @Override // w3.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            char c6 = hVar.c();
            hVar.f14114d++;
            int c7 = c(c6, sb);
            int a6 = hVar.a() + ((sb.length() / 3) << 1);
            hVar.q(a6);
            int a7 = hVar.g().a() - a6;
            if (!hVar.i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (a7 < 2 || a7 > 2)) {
                    c7 = b(hVar, sb, sb2, c7);
                }
                while (sb.length() % 3 == 1) {
                    if (c7 <= 3 && a7 != 1) {
                        c7 = b(hVar, sb, sb2, c7);
                    } else if (c7 <= 3) {
                        break;
                    } else {
                        c7 = b(hVar, sb, sb2, c7);
                    }
                }
            } else if (sb.length() % 3 == 0 && j.n(hVar.d(), hVar.f14114d, e()) != e()) {
                hVar.o(0);
                break;
            }
        }
        f(hVar, sb);
    }

    int c(char c6, StringBuilder sb) {
        int i6;
        int i7;
        char c7;
        if (c6 == ' ') {
            c7 = 3;
        } else {
            if (c6 >= '0' && c6 <= '9') {
                i7 = (c6 - '0') + 4;
            } else if (c6 < 'A' || c6 > 'Z') {
                if (c6 < 0 || c6 > 31) {
                    if (c6 >= '!' && c6 <= '/') {
                        sb.append((char) 1);
                        i6 = c6 - '!';
                    } else if (c6 >= ':' && c6 <= '@') {
                        sb.append((char) 1);
                        i6 = (c6 - ':') + 15;
                    } else if (c6 >= '[' && c6 <= '_') {
                        sb.append((char) 1);
                        i6 = (c6 - '[') + 22;
                    } else if (c6 < '`' || c6 > 127) {
                        if (c6 >= 128) {
                            sb.append("\u0001\u001e");
                            return c((char) (c6 - 128), sb) + 2;
                        }
                        throw new IllegalArgumentException("Illegal character: " + c6);
                    } else {
                        sb.append((char) 2);
                        i6 = c6 - '`';
                    }
                    c6 = (char) i6;
                } else {
                    sb.append((char) 0);
                }
                sb.append(c6);
                return 2;
            } else {
                i7 = (c6 - 'A') + 14;
            }
            c7 = (char) i7;
        }
        sb.append(c7);
        return 1;
    }

    public int e() {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        if (r8.i() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
        if (r8.i() != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void f(h hVar, StringBuilder sb) {
        int length = sb.length() % 3;
        int a6 = hVar.a() + ((sb.length() / 3) << 1);
        hVar.q(a6);
        int a7 = hVar.g().a() - a6;
        if (length != 2) {
            if (a7 == 1 && length == 1) {
                while (sb.length() >= 3) {
                    g(hVar, sb);
                }
                if (hVar.i()) {
                    hVar.r((char) 254);
                }
                hVar.f14114d--;
            } else if (length != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            } else {
                while (sb.length() >= 3) {
                    g(hVar, sb);
                }
                if (a7 <= 0) {
                }
                hVar.r((char) 254);
            }
            hVar.o(0);
            return;
        }
        sb.append((char) 0);
        while (sb.length() >= 3) {
            g(hVar, sb);
        }
    }
}
