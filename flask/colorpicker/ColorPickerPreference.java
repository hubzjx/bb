package com.flask.colorpicker;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.view.View;
import android.widget.ImageView;
import com.flask.colorpicker.a;
import s0.b;
import s0.e;
/* loaded from: classes.dex */
public class ColorPickerPreference extends Preference {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f3262a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f3263b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f3264c;

    /* renamed from: d  reason: collision with root package name */
    protected int f3265d;

    /* renamed from: e  reason: collision with root package name */
    protected a.c f3266e;

    /* renamed from: f  reason: collision with root package name */
    protected int f3267f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3268g;

    /* renamed from: h  reason: collision with root package name */
    private String f3269h;

    /* renamed from: k  reason: collision with root package name */
    private String f3270k;

    /* renamed from: l  reason: collision with root package name */
    private String f3271l;

    /* renamed from: m  reason: collision with root package name */
    protected ImageView f3272m;

    /* loaded from: classes.dex */
    class a implements t0.a {
        a() {
        }

        @Override // t0.a
        public void a(DialogInterface dialogInterface, int i6, Integer[] numArr) {
            ColorPickerPreference.this.b(i6);
        }
    }

    public static int a(int i6, float f6) {
        return Color.argb(Color.alpha(i6), Math.max((int) (Color.red(i6) * f6), 0), Math.max((int) (Color.green(i6) * f6), 0), Math.max((int) (Color.blue(i6) * f6), 0));
    }

    public void b(int i6) {
        if (callChangeListener(Integer.valueOf(i6))) {
            this.f3265d = i6;
            persistInt(i6);
            notifyChanged();
        }
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        int a6 = isEnabled() ? this.f3265d : a(this.f3265d, 0.5f);
        ImageView imageView = (ImageView) view.findViewById(e.color_indicator);
        this.f3272m = imageView;
        Drawable drawable = imageView.getDrawable();
        b bVar = (drawable == null || !(drawable instanceof b)) ? null : (b) drawable;
        if (bVar == null) {
            bVar = new b(a6);
        }
        this.f3272m.setImageDrawable(bVar);
    }

    @Override // android.preference.Preference
    protected void onClick() {
        t0.b l6 = t0.b.s(getContext()).o(this.f3269h).h(this.f3265d).p(this.f3264c).r(this.f3266e).d(this.f3267f).q(this.f3268g).n(this.f3271l, new a()).l(this.f3270k, null);
        boolean z5 = this.f3262a;
        if (!z5 && !this.f3263b) {
            l6.j();
        } else if (!z5) {
            l6.i();
        } else if (!this.f3263b) {
            l6.b();
        }
        l6.c().show();
    }

    @Override // android.preference.Preference
    protected void onSetInitialValue(boolean z5, Object obj) {
        b(z5 ? getPersistedInt(0) : ((Integer) obj).intValue());
    }
}
