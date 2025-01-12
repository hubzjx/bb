package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class s1 extends n1 implements o1 {
    private static Method L;
    private o1 K;

    /* loaded from: classes.dex */
    public static class a extends g1 {

        /* renamed from: p  reason: collision with root package name */
        final int f1062p;

        /* renamed from: q  reason: collision with root package name */
        final int f1063q;

        /* renamed from: r  reason: collision with root package name */
        private o1 f1064r;

        /* renamed from: s  reason: collision with root package name */
        private MenuItem f1065s;

        public a(Context context, boolean z5) {
            super(context, z5);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f1062p = 21;
                this.f1063q = 22;
                return;
            }
            this.f1062p = 22;
            this.f1063q = 21;
        }

        @Override // androidx.appcompat.widget.g1
        public /* bridge */ /* synthetic */ int d(int i6, int i7, int i8, int i9, int i10) {
            return super.d(i6, i7, i8, i9, i10);
        }

        @Override // androidx.appcompat.widget.g1
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i6) {
            return super.e(motionEvent, i6);
        }

        @Override // androidx.appcompat.widget.g1, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.g1, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.g1, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.g1, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.g1, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.d dVar;
            int i6;
            int pointToPosition;
            int i7;
            if (this.f1064r != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i6 = headerViewListAdapter.getHeadersCount();
                    dVar = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
                } else {
                    dVar = (androidx.appcompat.view.menu.d) adapter;
                    i6 = 0;
                }
                androidx.appcompat.view.menu.g item = (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i7 = pointToPosition - i6) < 0 || i7 >= dVar.getCount()) ? null : dVar.getItem(i7);
                MenuItem menuItem = this.f1065s;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.e b6 = dVar.b();
                    if (menuItem != null) {
                        this.f1064r.e(b6, menuItem);
                    }
                    this.f1065s = item;
                    if (item != null) {
                        this.f1064r.b(b6, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i6, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i6 == this.f1062p) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i6 != this.f1063q) {
                return super.onKeyDown(i6, keyEvent);
            } else {
                setSelection(-1);
                ((androidx.appcompat.view.menu.d) getAdapter()).b().e(false);
                return true;
            }
        }

        @Override // androidx.appcompat.widget.g1, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(o1 o1Var) {
            this.f1064r = o1Var;
        }

        @Override // androidx.appcompat.widget.g1, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                L = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public s1(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
    }

    public void R(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.G.setEnterTransition((Transition) obj);
        }
    }

    public void S(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.G.setExitTransition((Transition) obj);
        }
    }

    public void T(o1 o1Var) {
        this.K = o1Var;
    }

    public void U(boolean z5) {
        if (Build.VERSION.SDK_INT > 28) {
            this.G.setTouchModal(z5);
            return;
        }
        Method method = L;
        if (method != null) {
            try {
                method.invoke(this.G, Boolean.valueOf(z5));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // androidx.appcompat.widget.o1
    public void b(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        o1 o1Var = this.K;
        if (o1Var != null) {
            o1Var.b(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.o1
    public void e(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        o1 o1Var = this.K;
        if (o1Var != null) {
            o1Var.e(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.n1
    g1 s(Context context, boolean z5) {
        a aVar = new a(context, z5);
        aVar.setHoverListener(this);
        return aVar;
    }
}
