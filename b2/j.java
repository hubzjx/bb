package b2;

import android.net.Uri;
import java.io.IOException;
import q2.c0;
import w1.e0;
/* loaded from: classes.dex */
public interface j {

    /* loaded from: classes.dex */
    public interface a {
        j a(com.google.android.exoplayer2.source.hls.g gVar, c0 c0Var, i iVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        void e();

        boolean k(Uri uri, long j6);
    }

    /* loaded from: classes.dex */
    public static final class c extends IOException {
        public final Uri url;

        public c(Uri uri) {
            this.url = uri;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends IOException {
        public final Uri url;

        public d(Uri uri) {
            this.url = uri;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void h(f fVar);
    }

    boolean a();

    void b(b bVar);

    b2.e c();

    boolean d(Uri uri);

    void e();

    void f(Uri uri);

    void g(Uri uri);

    void h(b bVar);

    f i(Uri uri, boolean z5);

    long j();

    void l(Uri uri, e0.a aVar, e eVar);

    void stop();
}
