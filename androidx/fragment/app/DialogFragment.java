package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private Handler Z;

    /* renamed from: a0  reason: collision with root package name */
    private Runnable f1679a0 = new a();

    /* renamed from: b0  reason: collision with root package name */
    int f1680b0 = 0;

    /* renamed from: c0  reason: collision with root package name */
    int f1681c0 = 0;

    /* renamed from: d0  reason: collision with root package name */
    boolean f1682d0 = true;

    /* renamed from: e0  reason: collision with root package name */
    boolean f1683e0 = true;

    /* renamed from: f0  reason: collision with root package name */
    int f1684f0 = -1;

    /* renamed from: g0  reason: collision with root package name */
    Dialog f1685g0;

    /* renamed from: h0  reason: collision with root package name */
    boolean f1686h0;

    /* renamed from: i0  reason: collision with root package name */
    boolean f1687i0;

    /* renamed from: j0  reason: collision with root package name */
    boolean f1688j0;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DialogFragment dialogFragment = DialogFragment.this;
            Dialog dialog = dialogFragment.f1685g0;
            if (dialog != null) {
                dialogFragment.onDismiss(dialog);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void T(Bundle bundle) {
        Bundle bundle2;
        super.T(bundle);
        if (this.f1683e0) {
            View K = K();
            if (K != null) {
                if (K.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f1685g0.setContentView(K);
            }
            FragmentActivity i6 = i();
            if (i6 != null) {
                this.f1685g0.setOwnerActivity(i6);
            }
            this.f1685g0.setCancelable(this.f1682d0);
            this.f1685g0.setOnCancelListener(this);
            this.f1685g0.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.f1685g0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void W(Context context) {
        super.W(context);
        if (this.f1688j0) {
            return;
        }
        this.f1687i0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void Z(Bundle bundle) {
        super.Z(bundle);
        this.Z = new Handler();
        this.f1683e0 = this.f1712x == 0;
        if (bundle != null) {
            this.f1680b0 = bundle.getInt("android:style", 0);
            this.f1681c0 = bundle.getInt("android:theme", 0);
            this.f1682d0 = bundle.getBoolean("android:cancelable", true);
            this.f1683e0 = bundle.getBoolean("android:showsDialog", this.f1683e0);
            this.f1684f0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void g0() {
        super.g0();
        Dialog dialog = this.f1685g0;
        if (dialog != null) {
            this.f1686h0 = true;
            dialog.setOnDismissListener(null);
            this.f1685g0.dismiss();
            if (!this.f1687i0) {
                onDismiss(this.f1685g0);
            }
            this.f1685g0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void h0() {
        super.h0();
        if (this.f1688j0 || this.f1687i0) {
            return;
        }
        this.f1687i0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater i0(Bundle bundle) {
        Context i6;
        if (this.f1683e0) {
            Dialog q12 = q1(bundle);
            this.f1685g0 = q12;
            if (q12 != null) {
                s1(q12, this.f1680b0);
                i6 = this.f1685g0.getContext();
            } else {
                i6 = this.f1708t.i();
            }
            return (LayoutInflater) i6.getSystemService("layout_inflater");
        }
        return super.i0(bundle);
    }

    public void m1() {
        n1(false, false);
    }

    void n1(boolean z5, boolean z6) {
        if (this.f1687i0) {
            return;
        }
        this.f1687i0 = true;
        this.f1688j0 = false;
        Dialog dialog = this.f1685g0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f1685g0.dismiss();
            if (!z6) {
                if (Looper.myLooper() == this.Z.getLooper()) {
                    onDismiss(this.f1685g0);
                } else {
                    this.Z.post(this.f1679a0);
                }
            }
        }
        this.f1686h0 = true;
        if (this.f1684f0 >= 0) {
            Z0().e(this.f1684f0, 1);
            this.f1684f0 = -1;
            return;
        }
        l a6 = Z0().a();
        a6.h(this);
        if (z5) {
            a6.d();
        } else {
            a6.c();
        }
    }

    public Dialog o1() {
        return this.f1685g0;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f1686h0) {
            return;
        }
        n1(true, true);
    }

    public int p1() {
        return this.f1681c0;
    }

    public Dialog q1(Bundle bundle) {
        return new Dialog(Y0(), p1());
    }

    public final Dialog r1() {
        Dialog o12 = o1();
        if (o12 != null) {
            return o12;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void s1(Dialog dialog, int i6) {
        if (i6 != 1 && i6 != 2) {
            if (i6 != 3) {
                return;
            }
            dialog.getWindow().addFlags(24);
        }
        dialog.requestWindowFeature(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.v0(bundle);
        Dialog dialog = this.f1685g0;
        if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i6 = this.f1680b0;
        if (i6 != 0) {
            bundle.putInt("android:style", i6);
        }
        int i7 = this.f1681c0;
        if (i7 != 0) {
            bundle.putInt("android:theme", i7);
        }
        boolean z5 = this.f1682d0;
        if (!z5) {
            bundle.putBoolean("android:cancelable", z5);
        }
        boolean z6 = this.f1683e0;
        if (!z6) {
            bundle.putBoolean("android:showsDialog", z6);
        }
        int i8 = this.f1684f0;
        if (i8 != -1) {
            bundle.putInt("android:backStackId", i8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w0() {
        super.w0();
        Dialog dialog = this.f1685g0;
        if (dialog != null) {
            this.f1686h0 = false;
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void x0() {
        super.x0();
        Dialog dialog = this.f1685g0;
        if (dialog != null) {
            dialog.hide();
        }
    }
}
