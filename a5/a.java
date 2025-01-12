package a5;

import java.io.IOException;
/* loaded from: classes.dex */
public class a extends IOException {
    private static final long serialVersionUID = 1;
    private EnumC0003a type;

    /* renamed from: a5.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0003a {
        WRONG_PASSWORD,
        TASK_CANCELLED_EXCEPTION,
        CHECKSUM_MISMATCH,
        UNKNOWN_COMPRESSION_METHOD,
        FILE_NOT_FOUND,
        UNSUPPORTED_ENCRYPTION,
        UNKNOWN
    }

    public a(Exception exc) {
        super(exc);
        this.type = EnumC0003a.UNKNOWN;
    }

    public EnumC0003a getType() {
        return this.type;
    }

    public a(String str) {
        super(str);
        this.type = EnumC0003a.UNKNOWN;
    }

    public a(String str, EnumC0003a enumC0003a) {
        super(str);
        EnumC0003a enumC0003a2 = EnumC0003a.WRONG_PASSWORD;
        this.type = enumC0003a;
    }

    public a(String str, Exception exc) {
        super(str, exc);
        this.type = EnumC0003a.UNKNOWN;
    }

    public a(String str, Throwable th, EnumC0003a enumC0003a) {
        super(str, th);
        EnumC0003a enumC0003a2 = EnumC0003a.WRONG_PASSWORD;
        this.type = enumC0003a;
    }
}
