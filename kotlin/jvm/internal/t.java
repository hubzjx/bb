package kotlin.jvm.internal;
/* loaded from: classes.dex */
public class t {
    public s4.f a(i iVar) {
        return iVar;
    }

    public s4.c b(Class cls) {
        return new e(cls);
    }

    public s4.e c(Class cls, String str) {
        return new n(cls, str);
    }

    public String d(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String e(m mVar) {
        return d(mVar);
    }
}
