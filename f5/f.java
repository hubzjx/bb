package f5;
/* loaded from: classes.dex */
public enum f {
    READ("r"),
    WRITE("rw");
    
    private String value;

    f(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
