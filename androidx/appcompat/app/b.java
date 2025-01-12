package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
/* loaded from: classes.dex */
public class b extends d.h implements DialogInterface {

    /* renamed from: d  reason: collision with root package name */
    final AlertController f321d;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.f f322a;

        /* renamed from: b  reason: collision with root package name */
        private final int f323b;

        public a(Context context) {
            this(context, b.h(context, 0));
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f322a;
            fVar.f301w = listAdapter;
            fVar.f302x = onClickListener;
            return this;
        }

        public a b(View view) {
            this.f322a.f285g = view;
            return this;
        }

        public a c(Drawable drawable) {
            this.f322a.f282d = drawable;
            return this;
        }

        public b create() {
            b bVar = new b(this.f322a.f279a, this.f323b);
            this.f322a.a(bVar.f321d);
            bVar.setCancelable(this.f322a.f296r);
            if (this.f322a.f296r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f322a.f297s);
            bVar.setOnDismissListener(this.f322a.f298t);
            DialogInterface.OnKeyListener onKeyListener = this.f322a.f299u;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }

        public a d(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f322a;
            fVar.f290l = charSequence;
            fVar.f292n = onClickListener;
            return this;
        }

        public a e(DialogInterface.OnKeyListener onKeyListener) {
            this.f322a.f299u = onKeyListener;
            return this;
        }

        public a f(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f322a;
            fVar.f287i = charSequence;
            fVar.f289k = onClickListener;
            return this;
        }

        public a g(ListAdapter listAdapter, int i6, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f322a;
            fVar.f301w = listAdapter;
            fVar.f302x = onClickListener;
            fVar.I = i6;
            fVar.H = true;
            return this;
        }

        public Context getContext() {
            return this.f322a.f279a;
        }

        public a setNegativeButton(int i6, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f322a;
            fVar.f290l = fVar.f279a.getText(i6);
            this.f322a.f292n = onClickListener;
            return this;
        }

        public a setPositiveButton(int i6, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f322a;
            fVar.f287i = fVar.f279a.getText(i6);
            this.f322a.f289k = onClickListener;
            return this;
        }

        public a setTitle(CharSequence charSequence) {
            this.f322a.f284f = charSequence;
            return this;
        }

        public a setView(View view) {
            AlertController.f fVar = this.f322a;
            fVar.f304z = view;
            fVar.f303y = 0;
            fVar.E = false;
            return this;
        }

        public a(Context context, int i6) {
            this.f322a = new AlertController.f(new ContextThemeWrapper(context, b.h(context, i6)));
            this.f323b = i6;
        }
    }

    protected b(Context context, int i6) {
        super(context, h(context, i6));
        this.f321d = new AlertController(getContext(), this, getWindow());
    }

    static int h(Context context, int i6) {
        if (((i6 >>> 24) & 255) >= 1) {
            return i6;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView g() {
        return this.f321d.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // d.h, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f321d.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (this.f321d.g(i6, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i6, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i6, KeyEvent keyEvent) {
        if (this.f321d.h(i6, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i6, keyEvent);
    }

    @Override // d.h, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f321d.q(charSequence);
    }
}
