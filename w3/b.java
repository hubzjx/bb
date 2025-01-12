package w3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements g {
    private static char c(char c6, int i6) {
        int i7 = c6 + ((i6 * 149) % 255) + 1;
        return i7 <= 255 ? (char) i7 : (char) (i7 - 256);
    }

    @Override // w3.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!hVar.i()) {
                break;
            }
            sb.append(hVar.c());
            hVar.f14114d++;
            if (j.n(hVar.d(), hVar.f14114d, b()) != b()) {
                hVar.o(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int a6 = hVar.a() + length + 1;
        hVar.q(a6);
        boolean z5 = hVar.g().a() - a6 > 0;
        if (hVar.i() || z5) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length > 1555) {
                throw new IllegalStateException("Message length not in valid ranges: " + length);
            } else {
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i6 = 0; i6 < length2; i6++) {
            hVar.r(c(sb.charAt(i6), hVar.a() + 1));
        }
    }

    public int b() {
        return 5;
    }
}
