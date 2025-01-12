package b5;
/* loaded from: classes.dex */
public enum g {
    DEFAULT(10),
    DEFLATE_COMPRESSED(20),
    ZIP_64_FORMAT(45),
    AES_ENCRYPTED(51);
    
    private final int code;

    g(int i6) {
        this.code = i6;
    }

    public int getCode() {
        return this.code;
    }
}
