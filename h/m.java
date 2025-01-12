package h;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;
/* loaded from: classes.dex */
public abstract class m implements Window.Callback {

    /* renamed from: b  reason: collision with root package name */
    final Window.Callback f10592b;

    public m(Window.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f10592b = callback;
    }

    public final Window.Callback a() {
        return this.f10592b;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f10592b.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f10592b.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f10592b.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f10592b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f10592b.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f10592b.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.f10592b.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.f10592b.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f10592b.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i6, Menu menu) {
        return this.f10592b.onCreatePanelMenu(i6, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i6) {
        return this.f10592b.onCreatePanelView(i6);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f10592b.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i6, MenuItem menuItem) {
        return this.f10592b.onMenuItemSelected(i6, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i6, Menu menu) {
        return this.f10592b.onMenuOpened(i6, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i6, Menu menu) {
        this.f10592b.onPanelClosed(i6, menu);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z5) {
        this.f10592b.onPointerCaptureChanged(z5);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i6, View view, Menu menu) {
        return this.f10592b.onPreparePanel(i6, view, menu);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List list, Menu menu, int i6) {
        this.f10592b.onProvideKeyboardShortcuts(list, menu, i6);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f10592b.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f10592b.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z5) {
        this.f10592b.onWindowFocusChanged(z5);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f10592b.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        boolean onSearchRequested;
        onSearchRequested = this.f10592b.onSearchRequested(searchEvent);
        return onSearchRequested;
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i6) {
        ActionMode onWindowStartingActionMode;
        onWindowStartingActionMode = this.f10592b.onWindowStartingActionMode(callback, i6);
        return onWindowStartingActionMode;
    }
}
