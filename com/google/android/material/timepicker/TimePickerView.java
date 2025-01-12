package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import e0.b0;
import java.util.Locale;
/* loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {
    private final ClockHandView A;
    private final ClockFaceView B;
    private final MaterialButtonToggleGroup C;
    private final View.OnClickListener D;
    private f E;
    private g F;
    private e G;

    /* renamed from: y  reason: collision with root package name */
    private final Chip f5531y;

    /* renamed from: z  reason: collision with root package name */
    private final Chip f5532z;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TimePickerView.this.F != null) {
                TimePickerView.this.F.f(((Integer) view.getTag(u2.e.selection_type)).intValue());
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements MaterialButtonToggleGroup.e {
        b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i6, boolean z5) {
            int i7 = i6 == u2.e.material_clock_period_pm_button ? 1 : 0;
            if (TimePickerView.this.E == null || !z5) {
                return;
            }
            TimePickerView.this.E.d(i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            if (TimePickerView.this.G != null) {
                TimePickerView.this.G.a();
            }
            return onDoubleTap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GestureDetector f5536b;

        d(GestureDetector gestureDetector) {
            this.f5536b = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f5536b.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    interface e {
        void a();
    }

    /* loaded from: classes.dex */
    interface f {
        void d(int i6);
    }

    /* loaded from: classes.dex */
    interface g {
        void f(int i6);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void G() {
        Chip chip = this.f5531y;
        int i6 = u2.e.selection_type;
        chip.setTag(i6, 12);
        this.f5532z.setTag(i6, 10);
        this.f5531y.setOnClickListener(this.D);
        this.f5532z.setOnClickListener(this.D);
    }

    private void I() {
        d dVar = new d(new GestureDetector(getContext(), new c()));
        this.f5531y.setOnTouchListener(dVar);
        this.f5532z.setOnTouchListener(dVar);
    }

    private void L() {
        if (this.C.getVisibility() == 0) {
            androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
            dVar.g(this);
            dVar.e(u2.e.material_clock_display, b0.B(this) == 0 ? 2 : 1);
            dVar.c(this);
        }
    }

    public void A(e0.a aVar) {
        b0.l0(this.f5531y, aVar);
    }

    public void B(e0.a aVar) {
        b0.l0(this.f5532z, aVar);
    }

    public void C(ClockHandView.c cVar) {
        this.A.o(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(e eVar) {
        this.G = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(f fVar) {
        this.E = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(g gVar) {
        this.F = gVar;
    }

    public void H(String[] strArr, int i6) {
        this.B.F(strArr, i6);
    }

    public void J() {
        this.C.setVisibility(0);
    }

    public void K(int i6, int i7, int i8) {
        this.C.j(i6 == 1 ? u2.e.material_clock_period_pm_button : u2.e.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", Integer.valueOf(i8));
        String format2 = String.format(locale, "%02d", Integer.valueOf(i7));
        this.f5531y.setText(format);
        this.f5532z.setText(format2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        L();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i6) {
        super.onVisibilityChanged(view, i6);
        if (view == this && i6 == 0) {
            L();
        }
    }

    public void w(ClockHandView.d dVar) {
        this.A.b(dVar);
    }

    public void x(int i6) {
        this.f5531y.setChecked(i6 == 12);
        this.f5532z.setChecked(i6 == 10);
    }

    public void y(boolean z5) {
        this.A.j(z5);
    }

    public void z(float f6, boolean z5) {
        this.A.m(f6, z5);
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.D = new a();
        LayoutInflater.from(context).inflate(u2.g.material_timepicker, this);
        this.B = (ClockFaceView) findViewById(u2.e.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(u2.e.material_clock_period_toggle);
        this.C = materialButtonToggleGroup;
        materialButtonToggleGroup.g(new b());
        this.f5531y = (Chip) findViewById(u2.e.material_minute_tv);
        this.f5532z = (Chip) findViewById(u2.e.material_hour_tv);
        this.A = (ClockHandView) findViewById(u2.e.material_clock_hand);
        I();
        G();
    }
}
