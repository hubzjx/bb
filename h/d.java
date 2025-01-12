package h;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f10530a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f10531b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f10532c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f10533d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f10534e;

    public d(Context context, int i6) {
        super(context);
        this.f10530a = i6;
    }

    private Resources b() {
        if (this.f10534e == null) {
            Configuration configuration = this.f10533d;
            this.f10534e = configuration == null ? super.getResources() : createConfigurationContext(configuration).getResources();
        }
        return this.f10534e;
    }

    private void d() {
        boolean z5 = this.f10531b == null;
        if (z5) {
            this.f10531b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f10531b.setTo(theme);
            }
        }
        e(this.f10531b, this.f10530a, z5);
    }

    public void a(Configuration configuration) {
        if (this.f10534e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f10533d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f10533d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f10530a;
    }

    protected void e(Resources.Theme theme, int i6, boolean z5) {
        theme.applyStyle(i6, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f10532c == null) {
                this.f10532c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f10532c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f10531b;
        if (theme != null) {
            return theme;
        }
        if (this.f10530a == 0) {
            this.f10530a = b.i.Theme_AppCompat_Light;
        }
        d();
        return this.f10531b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i6) {
        if (this.f10530a != i6) {
            this.f10530a = i6;
            d();
        }
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f10531b = theme;
    }
}
