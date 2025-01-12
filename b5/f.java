package b5;
/* loaded from: classes.dex */
public enum f {
    SPECIFICATION_VERSION((byte) 51),
    WINDOWS((byte) 0),
    UNIX((byte) 3);
    
    private final byte code;

    f(byte b6) {
        this.code = b6;
    }

    public byte getCode() {
        return this.code;
    }
}
