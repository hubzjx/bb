package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import okhttp3.internal.http2.Settings;
/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity {

    /* renamed from: k  reason: collision with root package name */
    boolean f1738k;

    /* renamed from: l  reason: collision with root package name */
    boolean f1739l;

    /* renamed from: n  reason: collision with root package name */
    boolean f1741n;

    /* renamed from: o  reason: collision with root package name */
    boolean f1742o;

    /* renamed from: p  reason: collision with root package name */
    int f1743p;

    /* renamed from: q  reason: collision with root package name */
    l.h f1744q;

    /* renamed from: i  reason: collision with root package name */
    final d f1736i = d.b(new a());

    /* renamed from: j  reason: collision with root package name */
    final androidx.lifecycle.g f1737j = new androidx.lifecycle.g(this);

    /* renamed from: m  reason: collision with root package name */
    boolean f1740m = true;

    /* loaded from: classes.dex */
    class a extends f implements androidx.lifecycle.p, androidx.activity.c {
        public a() {
            super(FragmentActivity.this);
        }

        @Override // androidx.activity.c
        public OnBackPressedDispatcher a() {
            return FragmentActivity.this.a();
        }

        @Override // androidx.fragment.app.c
        public View d(int i6) {
            return FragmentActivity.this.findViewById(i6);
        }

        @Override // androidx.fragment.app.c
        public boolean e() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.lifecycle.p
        public androidx.lifecycle.o g() {
            return FragmentActivity.this.g();
        }

        @Override // androidx.lifecycle.f
        public androidx.lifecycle.c h() {
            return FragmentActivity.this.f1737j;
        }

        @Override // androidx.fragment.app.f
        public void k(Fragment fragment) {
            FragmentActivity.this.q(fragment);
        }

        @Override // androidx.fragment.app.f
        public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.f
        public LayoutInflater n() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.f
        public int o() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.f
        public boolean p() {
            return FragmentActivity.this.getWindow() != null;
        }

        @Override // androidx.fragment.app.f
        public boolean q(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // androidx.fragment.app.f
        public void r() {
            FragmentActivity.this.t();
        }

        @Override // androidx.fragment.app.f
        /* renamed from: s */
        public FragmentActivity m() {
            return FragmentActivity.this;
        }
    }

    static void l(int i6) {
        if ((i6 & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void o() {
        do {
        } while (p(n(), c.b.CREATED));
    }

    private static boolean p(g gVar, c.b bVar) {
        boolean z5 = false;
        for (Fragment fragment : gVar.d()) {
            if (fragment != null) {
                if (fragment.h().b().isAtLeast(c.b.STARTED)) {
                    fragment.T.p(bVar);
                    z5 = true;
                }
                if (fragment.v() != null) {
                    z5 |= p(fragment.o(), bVar);
                }
            }
        }
        return z5;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f1738k);
        printWriter.print(" mResumed=");
        printWriter.print(this.f1739l);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1740m);
        if (getApplication() != null) {
            androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f1736i.u().b(str, fileDescriptor, printWriter, strArr);
    }

    final View m(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1736i.w(view, str, context, attributeSet);
    }

    public g n() {
        return this.f1736i.u();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i6, int i7, Intent intent) {
        this.f1736i.v();
        int i8 = i6 >> 16;
        if (i8 == 0) {
            t.a.j();
            super.onActivityResult(i6, i7, intent);
            return;
        }
        int i9 = i8 - 1;
        String str = (String) this.f1744q.e(i9);
        this.f1744q.j(i9);
        if (str == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            return;
        }
        Fragment t5 = this.f1736i.t(str);
        if (t5 != null) {
            t5.U(i6 & Settings.DEFAULT_INITIAL_WINDOW_SIZE, i7, intent);
            return;
        }
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1736i.v();
        this.f1736i.d(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f1736i.a(null);
        if (bundle != null) {
            this.f1736i.x(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f1743p = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f1744q = new l.h(intArray.length);
                    for (int i6 = 0; i6 < intArray.length; i6++) {
                        this.f1744q.i(intArray[i6], stringArray[i6]);
                    }
                }
            }
        }
        if (this.f1744q == null) {
            this.f1744q = new l.h();
            this.f1743p = 0;
        }
        super.onCreate(bundle);
        this.f1737j.i(c.a.ON_CREATE);
        this.f1736i.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i6, Menu menu) {
        return i6 == 0 ? super.onCreatePanelMenu(i6, menu) | this.f1736i.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i6, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View m5 = m(view, str, context, attributeSet);
        return m5 == null ? super.onCreateView(view, str, context, attributeSet) : m5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f1736i.h();
        this.f1737j.i(c.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f1736i.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i6, MenuItem menuItem) {
        if (super.onMenuItemSelected(i6, menuItem)) {
            return true;
        }
        if (i6 != 0) {
            if (i6 != 6) {
                return false;
            }
            return this.f1736i.e(menuItem);
        }
        return this.f1736i.k(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z5) {
        this.f1736i.j(z5);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f1736i.v();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i6, Menu menu) {
        if (i6 == 0) {
            this.f1736i.l(menu);
        }
        super.onPanelClosed(i6, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f1739l = false;
        this.f1736i.m();
        this.f1737j.i(c.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z5) {
        this.f1736i.n(z5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        s();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i6, View view, Menu menu) {
        return i6 == 0 ? r(view, menu) | this.f1736i.o(menu) : super.onPreparePanel(i6, view, menu);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        this.f1736i.v();
        int i7 = (i6 >> 16) & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        if (i7 != 0) {
            int i8 = i7 - 1;
            String str = (String) this.f1744q.e(i8);
            this.f1744q.j(i8);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment t5 = this.f1736i.t(str);
            if (t5 != null) {
                t5.t0(i6 & Settings.DEFAULT_INITIAL_WINDOW_SIZE, strArr, iArr);
                return;
            }
            Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f1739l = true;
        this.f1736i.v();
        this.f1736i.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        o();
        this.f1737j.i(c.a.ON_STOP);
        Parcelable y5 = this.f1736i.y();
        if (y5 != null) {
            bundle.putParcelable("android:support:fragments", y5);
        }
        if (this.f1744q.k() > 0) {
            bundle.putInt("android:support:next_request_index", this.f1743p);
            int[] iArr = new int[this.f1744q.k()];
            String[] strArr = new String[this.f1744q.k()];
            for (int i6 = 0; i6 < this.f1744q.k(); i6++) {
                iArr[i6] = this.f1744q.h(i6);
                strArr[i6] = (String) this.f1744q.l(i6);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f1740m = false;
        if (!this.f1738k) {
            this.f1738k = true;
            this.f1736i.c();
        }
        this.f1736i.v();
        this.f1736i.s();
        this.f1737j.i(c.a.ON_START);
        this.f1736i.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f1736i.v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f1740m = true;
        o();
        this.f1736i.r();
        this.f1737j.i(c.a.ON_STOP);
    }

    public void q(Fragment fragment) {
    }

    protected boolean r(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    protected void s() {
        this.f1737j.i(c.a.ON_RESUME);
        this.f1736i.p();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i6) {
        if (!this.f1742o && i6 != -1) {
            l(i6);
        }
        super.startActivityForResult(intent, i6);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9) {
        if (!this.f1741n && i6 != -1) {
            l(i6);
        }
        super.startIntentSenderForResult(intentSender, i6, intent, i7, i8, i9);
    }

    public void t() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View m5 = m(null, str, context, attributeSet);
        return m5 == null ? super.onCreateView(str, context, attributeSet) : m5;
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i6, Bundle bundle) {
        if (!this.f1742o && i6 != -1) {
            l(i6);
        }
        super.startActivityForResult(intent, i6, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9, Bundle bundle) {
        if (!this.f1741n && i6 != -1) {
            l(i6);
        }
        super.startIntentSenderForResult(intentSender, i6, intent, i7, i8, i9, bundle);
    }
}
