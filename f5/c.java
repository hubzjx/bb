package f5;
/* loaded from: classes.dex */
public enum c {
    FASTEST(1),
    FASTER(2),
    FAST(3),
    MEDIUM_FAST(4),
    NORMAL(5),
    HIGHER(6),
    MAXIMUM(7),
    PRE_ULTRA(8),
    ULTRA(9);
    
    private int level;

    c(int i6) {
        this.level = i6;
    }

    public int getLevel() {
        return this.level;
    }
}
