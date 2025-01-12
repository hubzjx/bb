package com.secret.prettyhezi.Upload;

import com.secret.prettyhezi.Server.d0;
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    public static a f7505a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static a f7506b = new a();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public d0 f7508b = null;

        /* renamed from: a  reason: collision with root package name */
        public d0 f7507a = null;

        public void a(d0 d0Var) {
            if (this.f7507a != null && this.f7508b != null) {
                this.f7508b = null;
                this.f7507a = null;
            }
            if (this.f7507a == null) {
                this.f7507a = d0Var;
            } else if (this.f7508b == null) {
                this.f7508b = d0Var;
            }
        }

        public void b() {
            this.f7508b = null;
            this.f7507a = null;
        }
    }
}
