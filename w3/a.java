package w3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements g {
    private static char b(char c6, char c7) {
        if (j.f(c6) && j.f(c7)) {
            return (char) (((c6 - '0') * 10) + (c7 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c6 + c7);
    }

    @Override // w3.g
    public void a(h hVar) {
        if (j.a(hVar.d(), hVar.f14114d) >= 2) {
            hVar.r(b(hVar.d().charAt(hVar.f14114d), hVar.d().charAt(hVar.f14114d + 1)));
            hVar.f14114d += 2;
            return;
        }
        char c6 = hVar.c();
        int n5 = j.n(hVar.d(), hVar.f14114d, c());
        if (n5 == c()) {
            if (!j.g(c6)) {
                hVar.r((char) (c6 + 1));
                hVar.f14114d++;
                return;
            }
            hVar.r((char) 235);
            hVar.r((char) ((c6 - 128) + 1));
            hVar.f14114d++;
        } else if (n5 == 1) {
            hVar.r((char) 230);
            hVar.o(1);
        } else if (n5 == 2) {
            hVar.r((char) 239);
            hVar.o(2);
        } else if (n5 == 3) {
            hVar.r((char) 238);
            hVar.o(3);
        } else if (n5 == 4) {
            hVar.r((char) 240);
            hVar.o(4);
        } else if (n5 == 5) {
            hVar.r((char) 231);
            hVar.o(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + n5);
        }
    }

    public int c() {
        return 0;
    }
}
