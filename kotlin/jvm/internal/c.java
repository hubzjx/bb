package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class c implements s4.b, Serializable {
    public static final Object NO_RECEIVER = a.INSTANCE;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient s4.b reflected;
    private final String signature;

    /* loaded from: classes.dex */
    private static class a implements Serializable {
        private static final a INSTANCE = new a();

        private a() {
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public c() {
        this(NO_RECEIVER);
    }

    @Override // s4.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // s4.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public s4.b compute() {
        s4.b bVar = this.reflected;
        if (bVar == null) {
            s4.b computeReflected = computeReflected();
            this.reflected = computeReflected;
            return computeReflected;
        }
        return bVar;
    }

    protected abstract s4.b computeReflected();

    @Override // s4.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public s4.e getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? s.c(cls) : s.b(cls);
    }

    @Override // s4.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s4.b getReflected() {
        s4.b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new o4.b();
    }

    @Override // s4.b
    public s4.g getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // s4.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // s4.b
    public s4.h getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // s4.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // s4.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // s4.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // s4.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    protected c(Object obj) {
        this(obj, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Object obj, Class cls, String str, String str2, boolean z5) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z5;
    }
}
