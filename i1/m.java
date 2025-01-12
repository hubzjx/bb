package i1;

import com.google.android.exoplayer2.util.y;
import java.nio.ByteBuffer;
import java.util.UUID;
import okhttp3.internal.http2.Http2Connection;
/* loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final UUID f10982a;

        /* renamed from: b  reason: collision with root package name */
        private final int f10983b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f10984c;

        public a(UUID uuid, int i6, byte[] bArr) {
            this.f10982a = uuid;
            this.f10983b = i6;
            this.f10984c = bArr;
        }
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(uuidArr != null ? Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    private static a d(byte[] bArr) {
        y yVar = new y(bArr);
        if (yVar.e() < 32) {
            return null;
        }
        yVar.M(0);
        if (yVar.k() == yVar.a() + 4 && yVar.k() == 1886614376) {
            int c6 = i1.a.c(yVar.k());
            if (c6 > 1) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unsupported pssh version: ");
                sb.append(c6);
                com.google.android.exoplayer2.util.n.h("PsshAtomUtil", sb.toString());
                return null;
            }
            UUID uuid = new UUID(yVar.t(), yVar.t());
            if (c6 == 1) {
                yVar.N(yVar.E() * 16);
            }
            int E = yVar.E();
            if (E != yVar.a()) {
                return null;
            }
            byte[] bArr2 = new byte[E];
            yVar.i(bArr2, 0, E);
            return new a(uuid, c6, bArr2);
        }
        return null;
    }

    public static byte[] e(byte[] bArr, UUID uuid) {
        a d6 = d(bArr);
        if (d6 == null) {
            return null;
        }
        if (uuid == null || uuid.equals(d6.f10982a)) {
            return d6.f10984c;
        }
        String valueOf = String.valueOf(uuid);
        String valueOf2 = String.valueOf(d6.f10982a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 33 + valueOf2.length());
        sb.append("UUID mismatch. Expected: ");
        sb.append(valueOf);
        sb.append(", got: ");
        sb.append(valueOf2);
        sb.append(".");
        com.google.android.exoplayer2.util.n.h("PsshAtomUtil", sb.toString());
        return null;
    }

    public static UUID f(byte[] bArr) {
        a d6 = d(bArr);
        if (d6 == null) {
            return null;
        }
        return d6.f10982a;
    }

    public static int g(byte[] bArr) {
        a d6 = d(bArr);
        if (d6 == null) {
            return -1;
        }
        return d6.f10983b;
    }
}
