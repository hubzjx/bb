package n1;

import com.google.android.exoplayer2.s0;
/* loaded from: classes.dex */
public interface d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f12184a = new a();

    /* loaded from: classes.dex */
    class a implements d {
        a() {
        }

        @Override // n1.d
        public boolean a(s0 s0Var) {
            String str = s0Var.f4056n;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // n1.d
        public c b(s0 s0Var) {
            String str = s0Var.f4056n;
            if (str != null) {
                char c6 = 65535;
                switch (str.hashCode()) {
                    case -1354451219:
                        if (str.equals("application/vnd.dvb.ait")) {
                            c6 = 0;
                            break;
                        }
                        break;
                    case -1348231605:
                        if (str.equals("application/x-icy")) {
                            c6 = 1;
                            break;
                        }
                        break;
                    case -1248341703:
                        if (str.equals("application/id3")) {
                            c6 = 2;
                            break;
                        }
                        break;
                    case 1154383568:
                        if (str.equals("application/x-emsg")) {
                            c6 = 3;
                            break;
                        }
                        break;
                    case 1652648887:
                        if (str.equals("application/x-scte35")) {
                            c6 = 4;
                            break;
                        }
                        break;
                }
                switch (c6) {
                    case 0:
                        return new o1.b();
                    case 1:
                        return new r1.a();
                    case 2:
                        return new s1.h();
                    case 3:
                        return new p1.b();
                    case 4:
                        return new t1.c();
                }
            }
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(valueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
        }
    }

    boolean a(s0 s0Var);

    c b(s0 s0Var);
}
