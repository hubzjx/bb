package t0;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.b;
import com.flask.colorpicker.a;
import s0.e;
import s0.f;
import s0.h;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private b.a f13322a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f13323b;

    /* renamed from: c  reason: collision with root package name */
    private com.flask.colorpicker.a f13324c;

    /* renamed from: d  reason: collision with root package name */
    private v0.c f13325d;

    /* renamed from: e  reason: collision with root package name */
    private v0.b f13326e;

    /* renamed from: f  reason: collision with root package name */
    private EditText f13327f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f13328g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13329h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13330i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f13331j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13332k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13333l;

    /* renamed from: m  reason: collision with root package name */
    private int f13334m;

    /* renamed from: n  reason: collision with root package name */
    private int f13335n;

    /* renamed from: o  reason: collision with root package name */
    private int f13336o;

    /* renamed from: p  reason: collision with root package name */
    private Integer[] f13337p;

    /* loaded from: classes.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ t0.a f13338b;

        a(t0.a aVar) {
            this.f13338b = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            b.this.k(dialogInterface, this.f13338b);
        }
    }

    private b(Context context) {
        this(context, 0);
    }

    private static int e(Context context, int i6) {
        return (int) (context.getResources().getDimension(i6) + 0.5f);
    }

    private int f(Integer[] numArr) {
        Integer g6 = g(numArr);
        if (g6 == null) {
            return -1;
        }
        return numArr[g6.intValue()].intValue();
    }

    private Integer g(Integer[] numArr) {
        int i6 = 0;
        int i7 = 0;
        while (i6 < numArr.length && numArr[i6] != null) {
            i6++;
            i7 = Integer.valueOf(i6 / 2);
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(DialogInterface dialogInterface, t0.a aVar) {
        aVar.a(dialogInterface, this.f13324c.getSelectedColor(), this.f13324c.getAllColors());
    }

    public static b s(Context context) {
        return new b(context);
    }

    public b b() {
        this.f13329h = false;
        this.f13330i = true;
        return this;
    }

    public androidx.appcompat.app.b c() {
        Context context = this.f13322a.getContext();
        com.flask.colorpicker.a aVar = this.f13324c;
        Integer[] numArr = this.f13337p;
        aVar.j(numArr, g(numArr).intValue());
        this.f13324c.setShowBorder(this.f13331j);
        if (this.f13329h) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, e(context, s0.d.default_slider_height));
            v0.c cVar = new v0.c(context);
            this.f13325d = cVar;
            cVar.setLayoutParams(layoutParams);
            this.f13323b.addView(this.f13325d);
            this.f13324c.setLightnessSlider(this.f13325d);
            this.f13325d.setColor(f(this.f13337p));
            this.f13325d.setShowBorder(this.f13331j);
        }
        if (this.f13330i) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, e(context, s0.d.default_slider_height));
            v0.b bVar = new v0.b(context);
            this.f13326e = bVar;
            bVar.setLayoutParams(layoutParams2);
            this.f13323b.addView(this.f13326e);
            this.f13324c.setAlphaSlider(this.f13326e);
            this.f13326e.setColor(f(this.f13337p));
            this.f13326e.setShowBorder(this.f13331j);
        }
        if (this.f13332k) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            EditText editText = (EditText) View.inflate(context, f.color_edit, null);
            this.f13327f = editText;
            editText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
            this.f13327f.setSingleLine();
            this.f13327f.setVisibility(8);
            this.f13327f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f13330i ? 9 : 7)});
            this.f13323b.addView(this.f13327f, layoutParams3);
            this.f13327f.setText(h.e(f(this.f13337p), this.f13330i));
            this.f13324c.setColorEdit(this.f13327f);
        }
        if (this.f13333l) {
            LinearLayout linearLayout = (LinearLayout) View.inflate(context, f.color_preview, null);
            this.f13328g = linearLayout;
            linearLayout.setVisibility(8);
            this.f13323b.addView(this.f13328g);
            if (this.f13337p.length != 0) {
                int i6 = 0;
                while (true) {
                    Integer[] numArr2 = this.f13337p;
                    if (i6 >= numArr2.length || i6 >= this.f13334m || numArr2[i6] == null) {
                        break;
                    }
                    LinearLayout linearLayout2 = (LinearLayout) View.inflate(context, f.color_selector, null);
                    ((ImageView) linearLayout2.findViewById(e.image_preview)).setImageDrawable(new ColorDrawable(this.f13337p[i6].intValue()));
                    this.f13328g.addView(linearLayout2);
                    i6++;
                }
            } else {
                ((ImageView) View.inflate(context, f.color_selector, null)).setImageDrawable(new ColorDrawable(-1));
            }
            this.f13328g.setVisibility(0);
            this.f13324c.h(this.f13328g, g(this.f13337p));
        }
        return this.f13322a.create();
    }

    public b d(int i6) {
        this.f13324c.setDensity(i6);
        return this;
    }

    public b h(int i6) {
        this.f13337p[0] = Integer.valueOf(i6);
        return this;
    }

    public b i() {
        this.f13329h = true;
        this.f13330i = false;
        return this;
    }

    public b j() {
        this.f13329h = false;
        this.f13330i = false;
        return this;
    }

    public b l(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f13322a.d(charSequence, onClickListener);
        return this;
    }

    public b m(s0.c cVar) {
        this.f13324c.a(cVar);
        return this;
    }

    public b n(CharSequence charSequence, t0.a aVar) {
        this.f13322a.f(charSequence, new a(aVar));
        return this;
    }

    public b o(String str) {
        this.f13322a.setTitle(str);
        return this;
    }

    public b p(boolean z5) {
        this.f13331j = z5;
        return this;
    }

    public b q(boolean z5) {
        this.f13332k = z5;
        return this;
    }

    public b r(a.c cVar) {
        this.f13324c.setRenderer(c.a(cVar));
        return this;
    }

    private b(Context context, int i6) {
        this.f13329h = true;
        this.f13330i = true;
        this.f13331j = true;
        this.f13332k = false;
        this.f13333l = false;
        this.f13334m = 1;
        this.f13335n = 0;
        this.f13336o = 0;
        this.f13337p = new Integer[]{null, null, null, null, null};
        this.f13335n = e(context, s0.d.default_slider_margin);
        this.f13336o = e(context, s0.d.default_margin_top);
        this.f13322a = new b.a(context, i6);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f13323b = linearLayout;
        linearLayout.setOrientation(1);
        this.f13323b.setGravity(1);
        LinearLayout linearLayout2 = this.f13323b;
        int i7 = this.f13335n;
        linearLayout2.setPadding(i7, this.f13336o, i7, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        com.flask.colorpicker.a aVar = new com.flask.colorpicker.a(context);
        this.f13324c = aVar;
        this.f13323b.addView(aVar, layoutParams);
        this.f13322a.setView(this.f13323b);
    }
}
