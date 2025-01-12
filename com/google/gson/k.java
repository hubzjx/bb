package com.google.gson;

import java.math.BigInteger;
/* loaded from: classes.dex */
public final class k extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f5828a;

    public k(Boolean bool) {
        this.f5828a = com.google.gson.internal.a.b(bool);
    }

    private static boolean l(k kVar) {
        Object obj = kVar.f5828a;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f5828a == null) {
            return kVar.f5828a == null;
        } else if (l(this) && l(kVar)) {
            return i().longValue() == kVar.i().longValue();
        } else {
            Object obj2 = this.f5828a;
            if ((obj2 instanceof Number) && (kVar.f5828a instanceof Number)) {
                double doubleValue = i().doubleValue();
                double doubleValue2 = kVar.i().doubleValue();
                if (doubleValue != doubleValue2) {
                    return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
                }
                return true;
            }
            return obj2.equals(kVar.f5828a);
        }
    }

    public boolean h() {
        return k() ? ((Boolean) this.f5828a).booleanValue() : Boolean.parseBoolean(j());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f5828a == null) {
            return 31;
        }
        if (l(this)) {
            doubleToLongBits = i().longValue();
        } else {
            Object obj = this.f5828a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(i().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public Number i() {
        Object obj = this.f5828a;
        return obj instanceof String ? new com.google.gson.internal.g((String) obj) : (Number) obj;
    }

    public String j() {
        return m() ? i().toString() : k() ? ((Boolean) this.f5828a).toString() : (String) this.f5828a;
    }

    public boolean k() {
        return this.f5828a instanceof Boolean;
    }

    public boolean m() {
        return this.f5828a instanceof Number;
    }

    public boolean n() {
        return this.f5828a instanceof String;
    }

    public k(Number number) {
        this.f5828a = com.google.gson.internal.a.b(number);
    }

    public k(String str) {
        this.f5828a = com.google.gson.internal.a.b(str);
    }
}
