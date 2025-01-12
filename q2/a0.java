package q2;

import com.google.android.exoplayer2.util.s0;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import q2.l;
/* loaded from: classes.dex */
public interface a0 extends l {

    /* loaded from: classes.dex */
    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final f f12710a = new f();

        protected abstract a0 b(f fVar);

        @Override // q2.a0.b, q2.l.a
        public final a0 a() {
            return b(this.f12710a);
        }
    }

    /* loaded from: classes.dex */
    public interface b extends l.a {
        @Override // q2.l.a
        a0 a();
    }

    /* loaded from: classes.dex */
    public static class c extends IOException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final o dataSpec;
        public final int type;

        public c(IOException iOException, o oVar, int i6) {
            super(iOException);
            this.dataSpec = oVar;
            this.type = i6;
        }

        public c(String str, IOException iOException, o oVar, int i6) {
            super(str, iOException);
            this.dataSpec = oVar;
            this.type = i6;
        }

        public c(String str, o oVar, int i6) {
            super(str);
            this.dataSpec = oVar;
            this.type = i6;
        }

        public c(o oVar, int i6) {
            this.dataSpec = oVar;
            this.type = i6;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends c {
        public final String contentType;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d(String str, o oVar) {
            super(r0.length() != 0 ? "Invalid content type: ".concat(r0) : new String("Invalid content type: "), oVar, 1);
            String valueOf = String.valueOf(str);
            this.contentType = str;
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends c {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;
        public final String responseMessage;

        @Deprecated
        public e(int i6, String str, Map<String, List<String>> map, o oVar) {
            this(i6, str, map, oVar, s0.f4678f);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public e(int i6, String str, Map<String, List<String>> map, o oVar, byte[] bArr) {
            super(r0.toString(), oVar, 1);
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response code: ");
            sb.append(i6);
            this.responseCode = i6;
            this.responseMessage = str;
            this.headerFields = map;
            this.responseBody = bArr;
        }

        @Deprecated
        public e(int i6, Map<String, List<String>> map, o oVar) {
            this(i6, null, map, oVar, s0.f4678f);
        }
    }

    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final Map f12711a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private Map f12712b;

        public synchronized Map a() {
            if (this.f12712b == null) {
                this.f12712b = Collections.unmodifiableMap(new HashMap(this.f12711a));
            }
            return this.f12712b;
        }
    }
}
