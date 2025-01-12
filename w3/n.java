package w3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends c {
    @Override // w3.c, w3.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            char c6 = hVar.c();
            hVar.f14114d++;
            c(c6, sb);
            if (sb.length() % 3 == 0) {
                c.g(hVar, sb);
                if (j.n(hVar.d(), hVar.f14114d, e()) != e()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        f(hVar, sb);
    }

    @Override // w3.c
    int c(char c6, StringBuilder sb) {
        char c7;
        int i6;
        if (c6 == '\r') {
            c7 = 0;
        } else if (c6 != ' ') {
            if (c6 == '*') {
                sb.append((char) 1);
            } else if (c6 != '>') {
                if (c6 >= '0' && c6 <= '9') {
                    i6 = (c6 - '0') + 4;
                } else if (c6 < 'A' || c6 > 'Z') {
                    j.e(c6);
                } else {
                    i6 = (c6 - 'A') + 14;
                }
                c7 = (char) i6;
            } else {
                c7 = 2;
            }
            return 1;
        } else {
            c7 = 3;
        }
        sb.append(c7);
        return 1;
    }

    @Override // w3.c
    public int e() {
        return 3;
    }

    @Override // w3.c
    void f(h hVar, StringBuilder sb) {
        hVar.p();
        int a6 = hVar.g().a() - hVar.a();
        hVar.f14114d -= sb.length();
        if (hVar.f() > 1 || a6 > 1 || hVar.f() != a6) {
            hVar.r((char) 254);
        }
        if (hVar.e() < 0) {
            hVar.o(0);
        }
    }
}
