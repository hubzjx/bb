package f5;

import a5.a;
/* loaded from: classes.dex */
public enum d {
    STORE(0),
    DEFLATE(8),
    AES_INTERNAL_ONLY(99);
    
    private int code;

    d(int i6) {
        this.code = i6;
    }

    public static d getCompressionMethodFromCode(int i6) {
        d[] values;
        for (d dVar : values()) {
            if (dVar.getCode() == i6) {
                return dVar;
            }
        }
        throw new a5.a("Unknown compression method", a.EnumC0003a.UNKNOWN_COMPRESSION_METHOD);
    }

    public int getCode() {
        return this.code;
    }
}
