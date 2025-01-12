package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import e0.b0;
import f0.y;
/* loaded from: classes.dex */
public class CheckableImageButton extends androidx.appcompat.widget.m implements Checkable {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f5224g = {16842912};

    /* renamed from: d  reason: collision with root package name */
    private boolean f5225d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5226e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5227f;

    /* loaded from: classes.dex */
    class a extends e0.a {
        a() {
        }

        @Override // e0.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // e0.a
        public void g(View view, y yVar) {
            super.g(view, yVar);
            yVar.U(CheckableImageButton.this.a());
            yVar.V(CheckableImageButton.this.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends h0.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        boolean f5229c;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public b[] newArray(int i6) {
                return new b[i6];
            }
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            f(parcel);
        }

        private void f(Parcel parcel) {
            this.f5229c = parcel.readInt() == 1;
        }

        @Override // h0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f5229c ? 1 : 0);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.imageButtonStyle);
    }

    public boolean a() {
        return this.f5226e;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f5225d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i6) {
        if (this.f5225d) {
            int[] iArr = f5224g;
            return View.mergeDrawableStates(super.onCreateDrawableState(i6 + iArr.length), iArr);
        }
        return super.onCreateDrawableState(i6);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.e());
        setChecked(bVar.f5229c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f5229c = this.f5225d;
        return bVar;
    }

    public void setCheckable(boolean z5) {
        if (this.f5226e != z5) {
            this.f5226e = z5;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        if (!this.f5226e || this.f5225d == z5) {
            return;
        }
        this.f5225d = z5;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z5) {
        this.f5227f = z5;
    }

    @Override // android.view.View
    public void setPressed(boolean z5) {
        if (this.f5227f) {
            super.setPressed(z5);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f5225d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f5226e = true;
        this.f5227f = true;
        b0.l0(this, new a());
    }
}
