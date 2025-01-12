package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h {

    /* renamed from: c  reason: collision with root package name */
    private float f5304c;

    /* renamed from: f  reason: collision with root package name */
    private e3.d f5307f;

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f5302a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    private final e3.f f5303b = new a();

    /* renamed from: d  reason: collision with root package name */
    private boolean f5305d = true;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference f5306e = new WeakReference(null);

    /* loaded from: classes.dex */
    class a extends e3.f {
        a() {
        }

        @Override // e3.f
        public void a(int i6) {
            h.this.f5305d = true;
            b bVar = (b) h.this.f5306e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // e3.f
        public void b(Typeface typeface, boolean z5) {
            if (z5) {
                return;
            }
            h.this.f5305d = true;
            b bVar = (b) h.this.f5306e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public h(b bVar) {
        g(bVar);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f5302a.measureText(charSequence, 0, charSequence.length());
    }

    public e3.d d() {
        return this.f5307f;
    }

    public TextPaint e() {
        return this.f5302a;
    }

    public float f(String str) {
        if (this.f5305d) {
            float c6 = c(str);
            this.f5304c = c6;
            this.f5305d = false;
            return c6;
        }
        return this.f5304c;
    }

    public void g(b bVar) {
        this.f5306e = new WeakReference(bVar);
    }

    public void h(e3.d dVar, Context context) {
        if (this.f5307f != dVar) {
            this.f5307f = dVar;
            if (dVar != null) {
                dVar.k(context, this.f5302a, this.f5303b);
                b bVar = (b) this.f5306e.get();
                if (bVar != null) {
                    this.f5302a.drawableState = bVar.getState();
                }
                dVar.j(context, this.f5302a, this.f5303b);
                this.f5305d = true;
            }
            b bVar2 = (b) this.f5306e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z5) {
        this.f5305d = z5;
    }

    public void j(Context context) {
        this.f5307f.j(context, this.f5302a, this.f5303b);
    }
}
