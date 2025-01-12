package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
/* loaded from: classes.dex */
class h2 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f934a;

    /* renamed from: b  reason: collision with root package name */
    private final View f935b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f936c;

    /* renamed from: d  reason: collision with root package name */
    private final WindowManager.LayoutParams f937d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f938e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f939f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f940g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h2(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f937d = layoutParams;
        this.f938e = new Rect();
        this.f939f = new int[2];
        this.f940g = new int[2];
        this.f934a = context;
        View inflate = LayoutInflater.from(context).inflate(b.g.abc_tooltip, (ViewGroup) null);
        this.f935b = inflate;
        this.f936c = (TextView) inflate.findViewById(b.f.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = b.i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private void a(View view, int i6, int i7, boolean z5, WindowManager.LayoutParams layoutParams) {
        int height;
        int i8;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f934a.getResources().getDimensionPixelOffset(b.d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i6 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f934a.getResources().getDimensionPixelOffset(b.d.tooltip_precise_anchor_extra_offset);
            height = i7 + dimensionPixelOffset2;
            i8 = i7 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i8 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f934a.getResources().getDimensionPixelOffset(z5 ? b.d.tooltip_y_offset_touch : b.d.tooltip_y_offset_non_touch);
        View b6 = b(view);
        if (b6 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b6.getWindowVisibleDisplayFrame(this.f938e);
        Rect rect = this.f938e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f934a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f938e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b6.getLocationOnScreen(this.f940g);
        view.getLocationOnScreen(this.f939f);
        int[] iArr = this.f939f;
        int i9 = iArr[0];
        int[] iArr2 = this.f940g;
        int i10 = i9 - iArr2[0];
        iArr[0] = i10;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i10 + i6) - (b6.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f935b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f935b.getMeasuredHeight();
        int i11 = this.f939f[1];
        int i12 = ((i8 + i11) - dimensionPixelOffset3) - measuredHeight;
        int i13 = i11 + height + dimensionPixelOffset3;
        if (!z5 ? measuredHeight + i13 <= this.f938e.height() : i12 < 0) {
            layoutParams.y = i12;
        } else {
            layoutParams.y = i13;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (d()) {
            ((WindowManager) this.f934a.getSystemService("window")).removeView(this.f935b);
        }
    }

    boolean d() {
        return this.f935b.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(View view, int i6, int i7, boolean z5, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f936c.setText(charSequence);
        a(view, i6, i7, z5, this.f937d);
        ((WindowManager) this.f934a.getSystemService("window")).addView(this.f935b, this.f937d);
    }
}
