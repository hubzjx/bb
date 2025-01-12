package w3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends c {
    @Override // w3.c
    int c(char c6, StringBuilder sb) {
        int i6;
        int i7;
        char c7;
        if (c6 == ' ') {
            c7 = 3;
        } else {
            if (c6 >= '0' && c6 <= '9') {
                i7 = (c6 - '0') + 4;
            } else if (c6 < 'a' || c6 > 'z') {
                if (c6 < 0 || c6 > 31) {
                    char c8 = '!';
                    if (c6 < '!' || c6 > '/') {
                        if (c6 >= ':' && c6 <= '@') {
                            sb.append((char) 1);
                            i6 = (c6 - ':') + 15;
                        } else if (c6 < '[' || c6 > '_') {
                            c8 = '`';
                            if (c6 == '`') {
                                sb.append((char) 2);
                            } else if (c6 >= 'A' && c6 <= 'Z') {
                                sb.append((char) 2);
                                i6 = (c6 - 'A') + 1;
                            } else if (c6 < '{' || c6 > 127) {
                                if (c6 >= 128) {
                                    sb.append("\u0001\u001e");
                                    return c((char) (c6 - 128), sb) + 2;
                                }
                                j.e(c6);
                                return -1;
                            } else {
                                sb.append((char) 2);
                                i6 = (c6 - b.j.M0) + 27;
                            }
                        } else {
                            sb.append((char) 1);
                            i6 = (c6 - '[') + 22;
                        }
                        c6 = (char) i6;
                    } else {
                        sb.append((char) 1);
                    }
                    i6 = c6 - c8;
                    c6 = (char) i6;
                } else {
                    sb.append((char) 0);
                }
                sb.append(c6);
                return 2;
            } else {
                i7 = (c6 - 'a') + 14;
            }
            c7 = (char) i7;
        }
        sb.append(c7);
        return 1;
    }

    @Override // w3.c
    public int e() {
        return 2;
    }
}
