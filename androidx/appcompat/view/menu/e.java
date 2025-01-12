package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.internal.http2.Settings;
/* loaded from: classes.dex */
public class e implements y.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    private final Context f552a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f553b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f554c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f555d;

    /* renamed from: e  reason: collision with root package name */
    private a f556e;

    /* renamed from: m  reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f564m;

    /* renamed from: n  reason: collision with root package name */
    CharSequence f565n;

    /* renamed from: o  reason: collision with root package name */
    Drawable f566o;

    /* renamed from: p  reason: collision with root package name */
    View f567p;

    /* renamed from: x  reason: collision with root package name */
    private g f575x;

    /* renamed from: z  reason: collision with root package name */
    private boolean f577z;

    /* renamed from: l  reason: collision with root package name */
    private int f563l = 0;

    /* renamed from: q  reason: collision with root package name */
    private boolean f568q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f569r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f570s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f571t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f572u = false;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList f573v = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    private CopyOnWriteArrayList f574w = new CopyOnWriteArrayList();

    /* renamed from: y  reason: collision with root package name */
    private boolean f576y = false;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList f557f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList f558g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private boolean f559h = true;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList f560i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList f561j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private boolean f562k = true;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.f552a = context;
        this.f553b = context.getResources();
        b0(true);
    }

    private static int B(int i6) {
        int i7 = ((-65536) & i6) >> 16;
        if (i7 >= 0) {
            int[] iArr = A;
            if (i7 < iArr.length) {
                return (i6 & Settings.DEFAULT_INITIAL_WINDOW_SIZE) | (iArr[i7] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void N(int i6, boolean z5) {
        if (i6 < 0 || i6 >= this.f557f.size()) {
            return;
        }
        this.f557f.remove(i6);
        if (z5) {
            K(true);
        }
    }

    private void W(int i6, CharSequence charSequence, int i7, Drawable drawable, View view) {
        Resources C = C();
        if (view != null) {
            this.f567p = view;
            this.f565n = null;
            this.f566o = null;
        } else {
            if (i6 > 0) {
                this.f565n = C.getText(i6);
            } else if (charSequence != null) {
                this.f565n = charSequence;
            }
            if (i7 > 0) {
                this.f566o = u.c.c(u(), i7);
            } else if (drawable != null) {
                this.f566o = drawable;
            }
            this.f567p = null;
        }
        K(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (e0.o0.e(android.view.ViewConfiguration.get(r2.f552a), r2.f552a) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b0(boolean z5) {
        boolean z6;
        if (z5) {
            z6 = true;
            if (this.f553b.getConfiguration().keyboard != 1) {
            }
        }
        z6 = false;
        this.f555d = z6;
    }

    private g g(int i6, int i7, int i8, int i9, CharSequence charSequence, int i10) {
        return new g(this, i6, i7, i8, i9, charSequence, i10);
    }

    private void i(boolean z5) {
        if (this.f574w.isEmpty()) {
            return;
        }
        d0();
        Iterator it = this.f574w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.f574w.remove(weakReference);
            } else {
                jVar.f(z5);
            }
        }
        c0();
    }

    private boolean j(m mVar, j jVar) {
        if (this.f574w.isEmpty()) {
            return false;
        }
        boolean e6 = jVar != null ? jVar.e(mVar) : false;
        Iterator it = this.f574w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar2 = (j) weakReference.get();
            if (jVar2 == null) {
                this.f574w.remove(weakReference);
            } else if (!e6) {
                e6 = jVar2.e(mVar);
            }
        }
        return e6;
    }

    private static int n(ArrayList arrayList, int i6) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((g) arrayList.get(size)).f() <= i6) {
                return size + 1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f571t;
    }

    Resources C() {
        return this.f553b;
    }

    public e D() {
        return this;
    }

    public ArrayList E() {
        if (this.f559h) {
            this.f558g.clear();
            int size = this.f557f.size();
            for (int i6 = 0; i6 < size; i6++) {
                g gVar = (g) this.f557f.get(i6);
                if (gVar.isVisible()) {
                    this.f558g.add(gVar);
                }
            }
            this.f559h = false;
            this.f562k = true;
            return this.f558g;
        }
        return this.f558g;
    }

    public boolean F() {
        return this.f576y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G() {
        return this.f554c;
    }

    public boolean H() {
        return this.f555d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(g gVar) {
        this.f562k = true;
        K(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(g gVar) {
        this.f559h = true;
        K(true);
    }

    public void K(boolean z5) {
        if (this.f568q) {
            this.f569r = true;
            if (z5) {
                this.f570s = true;
                return;
            }
            return;
        }
        if (z5) {
            this.f559h = true;
            this.f562k = true;
        }
        i(z5);
    }

    public boolean L(MenuItem menuItem, int i6) {
        return M(menuItem, null, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r1 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
        e(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
        if ((r9 & 1) == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (r1 == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean M(MenuItem menuItem, j jVar, int i6) {
        g gVar = (g) menuItem;
        if (gVar == null || !gVar.isEnabled()) {
            return false;
        }
        boolean k6 = gVar.k();
        e0.b b6 = gVar.b();
        boolean z5 = b6 != null && b6.a();
        if (gVar.j()) {
            k6 |= gVar.expandActionView();
        } else if (gVar.hasSubMenu() || z5) {
            if ((i6 & 4) == 0) {
                e(false);
            }
            if (!gVar.hasSubMenu()) {
                gVar.x(new m(u(), this, gVar));
            }
            m mVar = (m) gVar.getSubMenu();
            if (z5) {
                b6.e(mVar);
            }
            k6 |= j(mVar, jVar);
        }
    }

    public void O(j jVar) {
        Iterator it = this.f574w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar2 = (j) weakReference.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.f574w.remove(weakReference);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            MenuItem item = getItem(i6);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).P(bundle);
            }
        }
        int i7 = bundle.getInt("android:menu:expandedactionview");
        if (i7 <= 0 || (findItem = findItem(i7)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i6 = 0; i6 < size; i6++) {
            MenuItem item = getItem(i6);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(a aVar) {
        this.f556e = aVar;
    }

    public e S(int i6) {
        this.f563l = i6;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f557f.size();
        d0();
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = (g) this.f557f.get(i6);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        c0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e U(int i6) {
        W(0, null, i6, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e V(Drawable drawable) {
        W(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e X(int i6) {
        W(i6, null, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e Y(CharSequence charSequence) {
        W(0, charSequence, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e Z(View view) {
        W(0, null, 0, null, view);
        return this;
    }

    protected MenuItem a(int i6, int i7, int i8, CharSequence charSequence) {
        int B = B(i8);
        g g6 = g(i6, i7, i8, B, charSequence, this.f563l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f564m;
        if (contextMenuInfo != null) {
            g6.v(contextMenuInfo);
        }
        ArrayList arrayList = this.f557f;
        arrayList.add(n(arrayList, B), g6);
        K(true);
        return g6;
    }

    public void a0(boolean z5) {
        this.f577z = z5;
    }

    @Override // android.view.Menu
    public MenuItem add(int i6) {
        return a(0, 0, 0, this.f553b.getString(i6));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i6, int i7, int i8, ComponentName componentName, Intent[] intentArr, Intent intent, int i9, MenuItem[] menuItemArr) {
        int i10;
        PackageManager packageManager = this.f552a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i9 & 1) == 0) {
            removeGroup(i6);
        }
        for (int i11 = 0; i11 < size; i11++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i11);
            int i12 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i12 < 0 ? intent : intentArr[i12]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i6, i7, i8, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i10 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i10] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i6) {
        return addSubMenu(0, 0, 0, this.f553b.getString(i6));
    }

    public void b(j jVar) {
        c(jVar, this.f552a);
    }

    public void c(j jVar, Context context) {
        this.f574w.add(new WeakReference(jVar));
        jVar.d(context, this);
        this.f562k = true;
    }

    public void c0() {
        this.f568q = false;
        if (this.f569r) {
            this.f569r = false;
            K(this.f570s);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.f575x;
        if (gVar != null) {
            f(gVar);
        }
        this.f557f.clear();
        K(true);
    }

    public void clearHeader() {
        this.f566o = null;
        this.f565n = null;
        this.f567p = null;
        K(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f556e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        if (this.f568q) {
            return;
        }
        this.f568q = true;
        this.f569r = false;
        this.f570s = false;
    }

    public final void e(boolean z5) {
        if (this.f572u) {
            return;
        }
        this.f572u = true;
        Iterator it = this.f574w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.f574w.remove(weakReference);
            } else {
                jVar.b(this, z5);
            }
        }
        this.f572u = false;
    }

    public boolean f(g gVar) {
        boolean z5 = false;
        if (!this.f574w.isEmpty() && this.f575x == gVar) {
            d0();
            Iterator it = this.f574w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                j jVar = (j) weakReference.get();
                if (jVar == null) {
                    this.f574w.remove(weakReference);
                } else {
                    z5 = jVar.i(this, gVar);
                    if (z5) {
                        break;
                    }
                }
            }
            c0();
            if (z5) {
                this.f575x = null;
            }
        }
        return z5;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i6) {
        MenuItem findItem;
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            g gVar = (g) this.f557f.get(i7);
            if (gVar.getItemId() == i6) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (findItem = gVar.getSubMenu().findItem(i6)) != null) {
                return findItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i6) {
        return (MenuItem) this.f557f.get(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.f556e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f577z) {
            return true;
        }
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            if (((g) this.f557f.get(i6)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i6, KeyEvent keyEvent) {
        return p(i6, keyEvent) != null;
    }

    public boolean k(g gVar) {
        boolean z5 = false;
        if (this.f574w.isEmpty()) {
            return false;
        }
        d0();
        Iterator it = this.f574w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.f574w.remove(weakReference);
            } else {
                z5 = jVar.j(this, gVar);
                if (z5) {
                    break;
                }
            }
        }
        c0();
        if (z5) {
            this.f575x = gVar;
        }
        return z5;
    }

    public int l(int i6) {
        return m(i6, 0);
    }

    public int m(int i6, int i7) {
        int size = size();
        if (i7 < 0) {
            i7 = 0;
        }
        while (i7 < size) {
            if (((g) this.f557f.get(i7)).getGroupId() == i6) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public int o(int i6) {
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            if (((g) this.f557f.get(i7)).getItemId() == i6) {
                return i7;
            }
        }
        return -1;
    }

    g p(int i6, KeyEvent keyEvent) {
        ArrayList arrayList = this.f573v;
        arrayList.clear();
        q(arrayList, i6, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (g) arrayList.get(0);
        }
        boolean G = G();
        for (int i7 = 0; i7 < size; i7++) {
            g gVar = (g) arrayList.get(i7);
            char alphabeticShortcut = G ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (G && alphabeticShortcut == '\b' && i6 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i6, int i7) {
        return L(findItem(i6), i7);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i6, KeyEvent keyEvent, int i7) {
        g p5 = p(i6, keyEvent);
        boolean L = p5 != null ? L(p5, i7) : false;
        if ((i7 & 2) != 0) {
            e(true);
        }
        return L;
    }

    void q(List list, int i6, KeyEvent keyEvent) {
        boolean G = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i6 == 67) {
            int size = this.f557f.size();
            for (int i7 = 0; i7 < size; i7++) {
                g gVar = (g) this.f557f.get(i7);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).q(list, i6, keyEvent);
                }
                char alphabeticShortcut = G ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if (((modifiers & 69647) == ((G ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (G && alphabeticShortcut == '\b' && i6 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList E = E();
        if (this.f562k) {
            Iterator it = this.f574w.iterator();
            boolean z5 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                j jVar = (j) weakReference.get();
                if (jVar == null) {
                    this.f574w.remove(weakReference);
                } else {
                    z5 |= jVar.h();
                }
            }
            if (z5) {
                this.f560i.clear();
                this.f561j.clear();
                int size = E.size();
                for (int i6 = 0; i6 < size; i6++) {
                    g gVar = (g) E.get(i6);
                    (gVar.l() ? this.f560i : this.f561j).add(gVar);
                }
            } else {
                this.f560i.clear();
                this.f561j.clear();
                this.f561j.addAll(E());
            }
            this.f562k = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i6) {
        int l6 = l(i6);
        if (l6 >= 0) {
            int size = this.f557f.size() - l6;
            int i7 = 0;
            while (true) {
                int i8 = i7 + 1;
                if (i7 >= size || ((g) this.f557f.get(l6)).getGroupId() != i6) {
                    break;
                }
                N(l6, false);
                i7 = i8;
            }
            K(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i6) {
        N(o(i6), true);
    }

    public ArrayList s() {
        r();
        return this.f560i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i6, boolean z5, boolean z6) {
        int size = this.f557f.size();
        for (int i7 = 0; i7 < size; i7++) {
            g gVar = (g) this.f557f.get(i7);
            if (gVar.getGroupId() == i6) {
                gVar.t(z6);
                gVar.setCheckable(z5);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z5) {
        this.f576y = z5;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i6, boolean z5) {
        int size = this.f557f.size();
        for (int i7 = 0; i7 < size; i7++) {
            g gVar = (g) this.f557f.get(i7);
            if (gVar.getGroupId() == i6) {
                gVar.setEnabled(z5);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i6, boolean z5) {
        int size = this.f557f.size();
        boolean z6 = false;
        for (int i7 = 0; i7 < size; i7++) {
            g gVar = (g) this.f557f.get(i7);
            if (gVar.getGroupId() == i6 && gVar.y(z5)) {
                z6 = true;
            }
        }
        if (z6) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z5) {
        this.f554c = z5;
        K(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f557f.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f552a;
    }

    public g v() {
        return this.f575x;
    }

    public Drawable w() {
        return this.f566o;
    }

    public CharSequence x() {
        return this.f565n;
    }

    public View y() {
        return this.f567p;
    }

    public ArrayList z() {
        r();
        return this.f561j;
    }

    @Override // android.view.Menu
    public MenuItem add(int i6, int i7, int i8, int i9) {
        return a(i6, i7, i8, this.f553b.getString(i9));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i6, int i7, int i8, int i9) {
        return addSubMenu(i6, i7, i8, this.f553b.getString(i9));
    }

    @Override // android.view.Menu
    public MenuItem add(int i6, int i7, int i8, CharSequence charSequence) {
        return a(i6, i7, i8, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i6, int i7, int i8, CharSequence charSequence) {
        g gVar = (g) a(i6, i7, i8, charSequence);
        m mVar = new m(this.f552a, this, gVar);
        gVar.x(mVar);
        return mVar;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }
}
