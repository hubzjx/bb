package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final f f1776a;

    private d(f fVar) {
        this.f1776a = fVar;
    }

    public static d b(f fVar) {
        return new d((f) d0.i.d(fVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        f fVar = this.f1776a;
        fVar.f1782f.n(fVar, fVar, fragment);
    }

    public void c() {
        this.f1776a.f1782f.w();
    }

    public void d(Configuration configuration) {
        this.f1776a.f1782f.x(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f1776a.f1782f.y(menuItem);
    }

    public void f() {
        this.f1776a.f1782f.z();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f1776a.f1782f.A(menu, menuInflater);
    }

    public void h() {
        this.f1776a.f1782f.B();
    }

    public void i() {
        this.f1776a.f1782f.D();
    }

    public void j(boolean z5) {
        this.f1776a.f1782f.E(z5);
    }

    public boolean k(MenuItem menuItem) {
        return this.f1776a.f1782f.T(menuItem);
    }

    public void l(Menu menu) {
        this.f1776a.f1782f.U(menu);
    }

    public void m() {
        this.f1776a.f1782f.W();
    }

    public void n(boolean z5) {
        this.f1776a.f1782f.X(z5);
    }

    public boolean o(Menu menu) {
        return this.f1776a.f1782f.Y(menu);
    }

    public void p() {
        this.f1776a.f1782f.a0();
    }

    public void q() {
        this.f1776a.f1782f.b0();
    }

    public void r() {
        this.f1776a.f1782f.d0();
    }

    public boolean s() {
        return this.f1776a.f1782f.j0();
    }

    public Fragment t(String str) {
        return this.f1776a.f1782f.q0(str);
    }

    public g u() {
        return this.f1776a.f1782f;
    }

    public void v() {
        this.f1776a.f1782f.S0();
    }

    public View w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1776a.f1782f.onCreateView(view, str, context, attributeSet);
    }

    public void x(Parcelable parcelable) {
        f fVar = this.f1776a;
        if (!(fVar instanceof androidx.lifecycle.p)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        fVar.f1782f.c1(parcelable);
    }

    public Parcelable y() {
        return this.f1776a.f1782f.e1();
    }
}
