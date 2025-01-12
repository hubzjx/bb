package kotlin.jvm.internal;
/* loaded from: classes.dex */
public class i extends c implements h, s4.f {
    private final int arity;
    private final int flags;

    public i(int i6) {
        this(i6, c.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.c
    protected s4.b computeReflected() {
        return s.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return getName().equals(iVar.getName()) && getSignature().equals(iVar.getSignature()) && this.flags == iVar.flags && this.arity == iVar.arity && l.a(getBoundReceiver(), iVar.getBoundReceiver()) && l.a(getOwner(), iVar.getOwner());
        } else if (obj instanceof s4.f) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // s4.f
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // s4.f
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // s4.f
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // s4.f
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.c, s4.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        s4.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public i(int i6, Object obj) {
        this(i6, obj, null, null, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c
    public s4.f getReflected() {
        return (s4.f) super.getReflected();
    }

    public i(int i6, Object obj, Class cls, String str, String str2, int i7) {
        super(obj, cls, str, str2, (i7 & 1) == 1);
        this.arity = i6;
        this.flags = i7 >> 1;
    }
}
