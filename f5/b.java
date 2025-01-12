package f5;
/* loaded from: classes.dex */
public enum b {
    ONE(1),
    TWO(2);
    
    private int versionNumber;

    b(int i6) {
        this.versionNumber = i6;
    }

    public static b getFromVersionNumber(int i6) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.versionNumber == i6) {
                return bVar;
            }
        }
        throw new IllegalArgumentException("Unsupported Aes version");
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }
}
