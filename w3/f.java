package w3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements g {
    private static void b(char c6, StringBuilder sb) {
        if (c6 >= ' ' && c6 <= '?') {
            sb.append(c6);
        } else if (c6 < '@' || c6 > '^') {
            j.e(c6);
        } else {
            sb.append((char) (c6 - '@'));
        }
    }

    private static String c(CharSequence charSequence, int i6) {
        int length = charSequence.length() - i6;
        if (length != 0) {
            int charAt = (charSequence.charAt(i6) << 18) + ((length >= 2 ? charSequence.charAt(i6 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i6 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i6 + 3) : (char) 0);
            char c6 = (char) ((charAt >> 8) & 255);
            char c7 = (char) (charAt & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((charAt >> 16) & 255));
            if (length >= 2) {
                sb.append(c6);
            }
            if (length >= 3) {
                sb.append(c7);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    private static void e(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z5 = true;
            if (length == 1) {
                hVar.p();
                int a6 = hVar.g().a() - hVar.a();
                if (hVar.f() <= a6 && a6 <= 2) {
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i6 = length - 1;
            String c6 = c(charSequence, 0);
            if (!(!hVar.i()) || i6 > 2) {
                z5 = false;
            }
            if (i6 <= 2) {
                hVar.q(hVar.a() + i6);
                if (hVar.g().a() - hVar.a() >= 3) {
                    hVar.q(hVar.a() + c6.length());
                    z5 = false;
                }
            }
            if (z5) {
                hVar.k();
                hVar.f14114d -= i6;
            } else {
                hVar.s(c6);
            }
        } finally {
            hVar.o(0);
        }
    }

    @Override // w3.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            b(hVar.c(), sb);
            hVar.f14114d++;
            if (sb.length() >= 4) {
                hVar.s(c(sb, 0));
                sb.delete(0, 4);
                if (j.n(hVar.d(), hVar.f14114d, d()) != d()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        e(hVar, sb);
    }

    public int d() {
        return 4;
    }
}
