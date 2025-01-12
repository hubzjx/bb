package com.google.android.exoplayer2;
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f4760a;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f4761a;

        public x0 a() {
            return new x0(this.f4761a);
        }
    }

    private x0(String str) {
        this.f4760a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x0.class != obj.getClass()) {
            return false;
        }
        return com.google.android.exoplayer2.util.s0.c(this.f4760a, ((x0) obj).f4760a);
    }

    public int hashCode() {
        String str = this.f4760a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }
}
