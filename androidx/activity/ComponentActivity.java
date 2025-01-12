package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.c;
import androidx.lifecycle.d;
import androidx.lifecycle.f;
import androidx.lifecycle.g;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.savedstate.SavedStateRegistry;
/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements p, androidx.savedstate.b, c {

    /* renamed from: f  reason: collision with root package name */
    private o f215f;

    /* renamed from: h  reason: collision with root package name */
    private int f217h;

    /* renamed from: d  reason: collision with root package name */
    private final g f213d = new g(this);

    /* renamed from: e  reason: collision with root package name */
    private final androidx.savedstate.a f214e = androidx.savedstate.a.a(this);

    /* renamed from: g  reason: collision with root package name */
    private final OnBackPressedDispatcher f216g = new OnBackPressedDispatcher(new a());

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        Object f221a;

        /* renamed from: b  reason: collision with root package name */
        o f222b;

        b() {
        }
    }

    public ComponentActivity() {
        if (h() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i6 = Build.VERSION.SDK_INT;
        h().a(new d() { // from class: androidx.activity.ComponentActivity.2
            @Override // androidx.lifecycle.d
            public void a(f fVar, c.a aVar) {
                if (aVar == c.a.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View peekDecorView = window != null ? window.peekDecorView() : null;
                    if (peekDecorView != null) {
                        peekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        h().a(new d() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.d
            public void a(f fVar, c.a aVar) {
                if (aVar != c.a.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.g().a();
            }
        });
        if (i6 <= 23) {
            h().a(new ImmLeaksCleaner(this));
        }
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher a() {
        return this.f216g;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry b() {
        return this.f214e.b();
    }

    @Override // androidx.lifecycle.p
    public o g() {
        if (getApplication() != null) {
            if (this.f215f == null) {
                b bVar = (b) getLastNonConfigurationInstance();
                if (bVar != null) {
                    this.f215f = bVar.f222b;
                }
                if (this.f215f == null) {
                    this.f215f = new o();
                }
            }
            return this.f215f;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.f
    public androidx.lifecycle.c h() {
        return this.f213d;
    }

    public Object k() {
        return null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f216g.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f214e.c(bundle);
        ReportFragment.e(this);
        int i6 = this.f217h;
        if (i6 != 0) {
            setContentView(i6);
        }
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        b bVar;
        Object k6 = k();
        o oVar = this.f215f;
        if (oVar == null && (bVar = (b) getLastNonConfigurationInstance()) != null) {
            oVar = bVar.f222b;
        }
        if (oVar == null && k6 == null) {
            return null;
        }
        b bVar2 = new b();
        bVar2.f221a = k6;
        bVar2.f222b = oVar;
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.c h6 = h();
        if (h6 instanceof g) {
            ((g) h6).p(c.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f214e.d(bundle);
    }
}
