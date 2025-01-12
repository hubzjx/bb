package e2;

import com.google.android.exoplayer2.s0;
/* loaded from: classes.dex */
public interface i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f9469a = new a();

    /* loaded from: classes.dex */
    class a implements i {
        a() {
        }

        @Override // e2.i
        public boolean a(s0 s0Var) {
            String str = s0Var.f4056n;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str);
        }

        @Override // e2.i
        public g b(s0 s0Var) {
            String str = s0Var.f4056n;
            if (str != null) {
                char c6 = 65535;
                switch (str.hashCode()) {
                    case -1351681404:
                        if (str.equals("application/dvbsubs")) {
                            c6 = 0;
                            break;
                        }
                        break;
                    case -1248334819:
                        if (str.equals("application/pgs")) {
                            c6 = 1;
                            break;
                        }
                        break;
                    case -1026075066:
                        if (str.equals("application/x-mp4-vtt")) {
                            c6 = 2;
                            break;
                        }
                        break;
                    case -1004728940:
                        if (str.equals("text/vtt")) {
                            c6 = 3;
                            break;
                        }
                        break;
                    case 691401887:
                        if (str.equals("application/x-quicktime-tx3g")) {
                            c6 = 4;
                            break;
                        }
                        break;
                    case 822864842:
                        if (str.equals("text/x-ssa")) {
                            c6 = 5;
                            break;
                        }
                        break;
                    case 930165504:
                        if (str.equals("application/x-mp4-cea-608")) {
                            c6 = 6;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            c6 = 7;
                            break;
                        }
                        break;
                    case 1566016562:
                        if (str.equals("application/cea-708")) {
                            c6 = '\b';
                            break;
                        }
                        break;
                    case 1668750253:
                        if (str.equals("application/x-subrip")) {
                            c6 = '\t';
                            break;
                        }
                        break;
                    case 1693976202:
                        if (str.equals("application/ttml+xml")) {
                            c6 = '\n';
                            break;
                        }
                        break;
                }
                switch (c6) {
                    case 0:
                        return new g2.a(s0Var.f4058p);
                    case 1:
                        return new h2.a();
                    case 2:
                        return new n2.b();
                    case 3:
                        return new n2.h();
                    case 4:
                        return new m2.a(s0Var.f4058p);
                    case 5:
                        return new j2.a(s0Var.f4058p);
                    case 6:
                    case 7:
                        return new f2.a(str, s0Var.F, 16000L);
                    case '\b':
                        return new f2.c(s0Var.F, s0Var.f4058p);
                    case '\t':
                        return new k2.a();
                    case '\n':
                        return new l2.b();
                }
            }
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(valueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
        }
    }

    boolean a(s0 s0Var);

    g b(s0 s0Var);
}
