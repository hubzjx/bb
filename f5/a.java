package f5;
/* loaded from: classes.dex */
public enum a {
    KEY_STRENGTH_128(1, 8, 16, 16),
    KEY_STRENGTH_192(2, 12, 24, 24),
    KEY_STRENGTH_256(3, 16, 32, 32);
    
    private int keyLength;
    private int macLength;
    private int rawCode;
    private int saltLength;

    a(int i6, int i7, int i8, int i9) {
        this.rawCode = i6;
        this.saltLength = i7;
        this.macLength = i8;
        this.keyLength = i9;
    }

    public static a getAesKeyStrengthFromRawCode(int i6) {
        a[] values;
        for (a aVar : values()) {
            if (aVar.getRawCode() == i6) {
                return aVar;
            }
        }
        return null;
    }

    public int getKeyLength() {
        return this.keyLength;
    }

    public int getMacLength() {
        return this.macLength;
    }

    public int getRawCode() {
        return this.rawCode;
    }

    public int getSaltLength() {
        return this.saltLength;
    }
}
