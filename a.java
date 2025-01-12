package com.flask.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import s0.e;
import s0.g;
import s0.h;
import t0.d;
/* loaded from: classes.dex */
public class a extends View {
    private int A;
    private int B;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f3274b;

    /* renamed from: c  reason: collision with root package name */
    private Canvas f3275c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f3276d;

    /* renamed from: e  reason: collision with root package name */
    private Canvas f3277e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3278f;

    /* renamed from: g  reason: collision with root package name */
    private int f3279g;

    /* renamed from: h  reason: collision with root package name */
    private float f3280h;

    /* renamed from: i  reason: collision with root package name */
    private float f3281i;

    /* renamed from: j  reason: collision with root package name */
    private int f3282j;

    /* renamed from: k  reason: collision with root package name */
    private Integer[] f3283k;

    /* renamed from: l  reason: collision with root package name */
    private int f3284l;

    /* renamed from: m  reason: collision with root package name */
    private Integer f3285m;

    /* renamed from: n  reason: collision with root package name */
    private Integer f3286n;

    /* renamed from: o  reason: collision with root package name */
    private Paint f3287o;

    /* renamed from: p  reason: collision with root package name */
    private Paint f3288p;

    /* renamed from: q  reason: collision with root package name */
    private Paint f3289q;

    /* renamed from: r  reason: collision with root package name */
    private s0.a f3290r;

    /* renamed from: s  reason: collision with root package name */
    private ArrayList f3291s;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList f3292t;

    /* renamed from: u  reason: collision with root package name */
    private v0.c f3293u;

    /* renamed from: v  reason: collision with root package name */
    private v0.b f3294v;

    /* renamed from: w  reason: collision with root package name */
    private EditText f3295w;

    /* renamed from: x  reason: collision with root package name */
    private TextWatcher f3296x;

    /* renamed from: y  reason: collision with root package name */
    private LinearLayout f3297y;

    /* renamed from: z  reason: collision with root package name */
    private u0.c f3298z;

    /* renamed from: com.flask.colorpicker.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0034a implements TextWatcher {
        C0034a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            try {
                a.this.g(Color.parseColor(charSequence.toString()), false);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (view == null || (tag = view.getTag()) == null || !(tag instanceof Integer)) {
                return;
            }
            a.this.setSelectedColor(((Integer) tag).intValue());
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        FLOWER,
        CIRCLE;

        public static c indexOf(int i6) {
            if (i6 != 0 && i6 == 1) {
                return CIRCLE;
            }
            return FLOWER;
        }
    }

    public a(Context context) {
        super(context);
        this.f3279g = 8;
        this.f3280h = 1.0f;
        this.f3281i = 1.0f;
        this.f3282j = 0;
        this.f3283k = new Integer[]{null, null, null, null, null};
        this.f3284l = 0;
        this.f3287o = d.c().b(0).a();
        this.f3288p = d.c().b(0).a();
        this.f3289q = d.c().a();
        this.f3291s = new ArrayList();
        this.f3292t = new ArrayList();
        this.f3296x = new C0034a();
        f(context, null);
    }

    private void c() {
        this.f3275c.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f3277e.drawColor(0, PorterDuff.Mode.CLEAR);
        if (this.f3298z == null) {
            return;
        }
        float width = this.f3275c.getWidth() / 2.0f;
        int i6 = this.f3279g;
        float f6 = (width - 1.5374999f) - (width / i6);
        u0.b a6 = this.f3298z.a();
        a6.f13407a = this.f3279g;
        a6.f13408b = f6;
        a6.f13409c = (f6 / (i6 - 1)) / 2.0f;
        a6.f13410d = 1.5374999f;
        a6.f13411e = this.f3281i;
        a6.f13412f = this.f3280h;
        a6.f13413g = this.f3275c;
        this.f3298z.c(a6);
        this.f3298z.d();
    }

    private s0.a d(int i6) {
        float[] fArr = new float[3];
        Color.colorToHSV(i6, fArr);
        char c6 = 1;
        char c7 = 0;
        double cos = fArr[1] * Math.cos((fArr[0] * 3.141592653589793d) / 180.0d);
        double sin = fArr[1] * Math.sin((fArr[0] * 3.141592653589793d) / 180.0d);
        s0.a aVar = null;
        double d6 = Double.MAX_VALUE;
        for (s0.a aVar2 : this.f3298z.b()) {
            float[] b6 = aVar2.b();
            double d7 = sin;
            double cos2 = b6[c6] * Math.cos((b6[c7] * 3.141592653589793d) / 180.0d);
            double d8 = cos - cos2;
            double sin2 = d7 - (b6[1] * Math.sin((b6[0] * 3.141592653589793d) / 180.0d));
            double d9 = (d8 * d8) + (sin2 * sin2);
            if (d9 < d6) {
                d6 = d9;
                aVar = aVar2;
            }
            sin = d7;
            c6 = 1;
            c7 = 0;
        }
        return aVar;
    }

    private s0.a e(float f6, float f7) {
        s0.a aVar = null;
        double d6 = Double.MAX_VALUE;
        for (s0.a aVar2 : this.f3298z.b()) {
            double g6 = aVar2.g(f6, f7);
            if (d6 > g6) {
                aVar = aVar2;
                d6 = g6;
            }
        }
        return aVar;
    }

    private void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f13116s);
        this.f3279g = obtainStyledAttributes.getInt(g.f13118u, 10);
        this.f3285m = Integer.valueOf(obtainStyledAttributes.getInt(g.f13119v, -1));
        this.f3286n = Integer.valueOf(obtainStyledAttributes.getInt(g.f13121x, -1));
        u0.c a6 = t0.c.a(c.indexOf(obtainStyledAttributes.getInt(g.f13122y, 0)));
        this.A = obtainStyledAttributes.getResourceId(g.f13117t, 0);
        this.B = obtainStyledAttributes.getResourceId(g.f13120w, 0);
        setRenderer(a6);
        setDensity(this.f3279g);
        i(this.f3285m.intValue(), true);
        obtainStyledAttributes.recycle();
    }

    private void k() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight < measuredWidth) {
            measuredWidth = measuredHeight;
        }
        if (measuredWidth <= 0) {
            return;
        }
        Bitmap bitmap = this.f3274b;
        if (bitmap == null || bitmap.getWidth() != measuredWidth) {
            this.f3274b = Bitmap.createBitmap(measuredWidth, measuredWidth, Bitmap.Config.ARGB_8888);
            this.f3275c = new Canvas(this.f3274b);
            this.f3289q.setShader(d.b(26));
        }
        Bitmap bitmap2 = this.f3276d;
        if (bitmap2 == null || bitmap2.getWidth() != measuredWidth) {
            this.f3276d = Bitmap.createBitmap(measuredWidth, measuredWidth, Bitmap.Config.ARGB_8888);
            this.f3277e = new Canvas(this.f3276d);
        }
        c();
        invalidate();
    }

    private void setColorPreviewColor(int i6) {
        Integer[] numArr;
        int i7;
        LinearLayout linearLayout = this.f3297y;
        if (linearLayout == null || (numArr = this.f3283k) == null || (i7 = this.f3284l) > numArr.length || numArr[i7] == null || linearLayout.getChildCount() == 0 || this.f3297y.getVisibility() != 0) {
            return;
        }
        View childAt = this.f3297y.getChildAt(this.f3284l);
        if (childAt instanceof LinearLayout) {
            ((ImageView) ((LinearLayout) childAt).findViewById(e.image_preview)).setImageDrawable(new s0.b(i6));
        }
    }

    private void setColorText(int i6) {
        EditText editText = this.f3295w;
        if (editText == null) {
            return;
        }
        editText.setText(h.e(i6, this.f3294v != null));
    }

    private void setColorToSliders(int i6) {
        v0.c cVar = this.f3293u;
        if (cVar != null) {
            cVar.setColor(i6);
        }
        v0.b bVar = this.f3294v;
        if (bVar != null) {
            bVar.setColor(i6);
        }
    }

    private void setHighlightedColor(int i6) {
        int childCount = this.f3297y.getChildCount();
        if (childCount == 0 || this.f3297y.getVisibility() != 0) {
            return;
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = this.f3297y.getChildAt(i7);
            if (childAt instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) childAt;
                if (i7 == i6) {
                    linearLayout.setBackgroundColor(-1);
                } else {
                    linearLayout.setBackgroundColor(0);
                }
            }
        }
    }

    public void a(s0.c cVar) {
        this.f3292t.add(cVar);
    }

    protected void b(int i6, int i7) {
        ArrayList arrayList = this.f3291s;
        if (arrayList == null || i6 == i7) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            try {
                throw null;
                break;
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public void g(int i6, boolean z5) {
        i(i6, z5);
        k();
        invalidate();
    }

    public Integer[] getAllColors() {
        return this.f3283k;
    }

    public int getSelectedColor() {
        s0.a aVar = this.f3290r;
        return h.a(this.f3281i, aVar != null ? h.c(aVar.a(), this.f3280h) : 0);
    }

    public void h(LinearLayout linearLayout, Integer num) {
        if (linearLayout == null) {
            return;
        }
        this.f3297y = linearLayout;
        if (num == null) {
            num = 0;
        }
        int childCount = linearLayout.getChildCount();
        if (childCount == 0 || linearLayout.getVisibility() != 0) {
            return;
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = linearLayout.getChildAt(i6);
            if (childAt instanceof LinearLayout) {
                LinearLayout linearLayout2 = (LinearLayout) childAt;
                if (i6 == num.intValue()) {
                    linearLayout2.setBackgroundColor(-1);
                }
                ImageView imageView = (ImageView) linearLayout2.findViewById(e.image_preview);
                imageView.setClickable(true);
                imageView.setTag(Integer.valueOf(i6));
                imageView.setOnClickListener(new b());
            }
        }
    }

    public void i(int i6, boolean z5) {
        float[] fArr = new float[3];
        Color.colorToHSV(i6, fArr);
        this.f3281i = h.d(i6);
        this.f3280h = fArr[2];
        this.f3283k[this.f3284l] = Integer.valueOf(i6);
        this.f3285m = Integer.valueOf(i6);
        setColorPreviewColor(i6);
        setColorToSliders(i6);
        if (this.f3295w != null && z5) {
            setColorText(i6);
        }
        this.f3290r = d(i6);
    }

    public void j(Integer[] numArr, int i6) {
        this.f3283k = numArr;
        this.f3284l = i6;
        Integer num = numArr[i6];
        if (num == null) {
            num = -1;
        }
        i(num.intValue(), true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        s0.a aVar;
        super.onDraw(canvas);
        canvas.drawColor(this.f3282j);
        float width = ((canvas.getWidth() / 1.025f) / this.f3279g) / 2.0f;
        if (this.f3274b == null || (aVar = this.f3290r) == null) {
            return;
        }
        this.f3287o.setColor(Color.HSVToColor(aVar.c(this.f3280h)));
        this.f3287o.setAlpha((int) (this.f3281i * 255.0f));
        float f6 = 4.0f + width;
        this.f3277e.drawCircle(this.f3290r.d(), this.f3290r.e(), f6, this.f3289q);
        this.f3277e.drawCircle(this.f3290r.d(), this.f3290r.e(), f6, this.f3287o);
        this.f3288p = d.c().b(-1).e(Paint.Style.STROKE).d(0.5f * width).f(PorterDuff.Mode.CLEAR).a();
        if (this.f3278f) {
            this.f3275c.drawCircle(this.f3290r.d(), this.f3290r.e(), (this.f3288p.getStrokeWidth() / 2.0f) + width, this.f3288p);
        }
        canvas.drawBitmap(this.f3274b, 0.0f, 0.0f, (Paint) null);
        this.f3277e.drawCircle(this.f3290r.d(), this.f3290r.e(), width + (this.f3288p.getStrokeWidth() / 2.0f), this.f3288p);
        canvas.drawBitmap(this.f3276d, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (this.A != 0) {
            setAlphaSlider((v0.b) getRootView().findViewById(this.A));
        }
        if (this.B != 0) {
            setLightnessSlider((v0.c) getRootView().findViewById(this.B));
        }
        k();
        this.f3290r = d(this.f3285m.intValue());
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int mode = View.MeasureSpec.getMode(i6);
        if (mode != 0) {
            i6 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.getSize(i6) : 0;
        }
        int mode2 = View.MeasureSpec.getMode(i7);
        if (mode2 != 0) {
            i7 = (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) ? View.MeasureSpec.getSize(i7) : 0;
        }
        if (i7 < i6) {
            i6 = i7;
        }
        setMeasuredDimension(i6, i6);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        k();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000a, code lost:
        if (r0 != 2) goto L6;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                int selectedColor = getSelectedColor();
                ArrayList arrayList = this.f3292t;
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        try {
                            ((s0.c) it.next()).a(selectedColor);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                }
                setColorToSliders(selectedColor);
                setColorText(selectedColor);
                setColorPreviewColor(selectedColor);
                invalidate();
                return true;
            }
        }
        int selectedColor2 = getSelectedColor();
        this.f3290r = e(motionEvent.getX(), motionEvent.getY());
        int selectedColor3 = getSelectedColor();
        b(selectedColor2, selectedColor3);
        this.f3285m = Integer.valueOf(selectedColor3);
        setColorToSliders(selectedColor3);
        k();
        invalidate();
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        k();
        this.f3290r = d(this.f3285m.intValue());
    }

    public void setAlphaSlider(v0.b bVar) {
        this.f3294v = bVar;
        if (bVar != null) {
            bVar.setColorPicker(this);
            this.f3294v.setColor(getSelectedColor());
        }
    }

    public void setAlphaValue(float f6) {
        Integer num;
        int selectedColor = getSelectedColor();
        this.f3281i = f6;
        Integer valueOf = Integer.valueOf(Color.HSVToColor(h.b(f6), this.f3290r.c(this.f3280h)));
        this.f3285m = valueOf;
        EditText editText = this.f3295w;
        if (editText != null) {
            editText.setText(h.e(valueOf.intValue(), this.f3294v != null));
        }
        v0.c cVar = this.f3293u;
        if (cVar != null && (num = this.f3285m) != null) {
            cVar.setColor(num.intValue());
        }
        b(selectedColor, this.f3285m.intValue());
        k();
        invalidate();
    }

    public void setColorEdit(EditText editText) {
        this.f3295w = editText;
        if (editText != null) {
            editText.setVisibility(0);
            this.f3295w.addTextChangedListener(this.f3296x);
            setColorEditTextColor(this.f3286n.intValue());
        }
    }

    public void setColorEditTextColor(int i6) {
        this.f3286n = Integer.valueOf(i6);
        EditText editText = this.f3295w;
        if (editText != null) {
            editText.setTextColor(i6);
        }
    }

    public void setDensity(int i6) {
        this.f3279g = Math.max(2, i6);
        invalidate();
    }

    public void setLightness(float f6) {
        Integer num;
        int selectedColor = getSelectedColor();
        this.f3280h = f6;
        if (this.f3290r != null) {
            Integer valueOf = Integer.valueOf(Color.HSVToColor(h.b(this.f3281i), this.f3290r.c(f6)));
            this.f3285m = valueOf;
            EditText editText = this.f3295w;
            if (editText != null) {
                editText.setText(h.e(valueOf.intValue(), this.f3294v != null));
            }
            v0.b bVar = this.f3294v;
            if (bVar != null && (num = this.f3285m) != null) {
                bVar.setColor(num.intValue());
            }
            b(selectedColor, this.f3285m.intValue());
            k();
            invalidate();
        }
    }

    public void setLightnessSlider(v0.c cVar) {
        this.f3293u = cVar;
        if (cVar != null) {
            cVar.setColorPicker(this);
            this.f3293u.setColor(getSelectedColor());
        }
    }

    public void setRenderer(u0.c cVar) {
        this.f3298z = cVar;
        invalidate();
    }

    public void setSelectedColor(int i6) {
        Integer[] numArr = this.f3283k;
        if (numArr == null || numArr.length < i6) {
            return;
        }
        this.f3284l = i6;
        setHighlightedColor(i6);
        Integer num = this.f3283k[i6];
        if (num == null) {
            return;
        }
        g(num.intValue(), true);
    }

    public void setShowBorder(boolean z5) {
        this.f3278f = z5;
    }
}
