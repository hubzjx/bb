package e0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import f0.y;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final View.AccessibilityDelegate f9322c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    private final View.AccessibilityDelegate f9323a;

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f9324b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0156a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final a f9325a;

        C0156a(a aVar) {
            this.f9325a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f9325a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            f0.z b6 = this.f9325a.b(view);
            if (b6 != null) {
                return (AccessibilityNodeProvider) b6.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f9325a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            f0.y w02 = f0.y.w0(accessibilityNodeInfo);
            w02.n0(b0.U(view));
            w02.g0(b0.P(view));
            w02.k0(b0.p(view));
            w02.r0(b0.I(view));
            this.f9325a.g(view, w02);
            w02.e(accessibilityNodeInfo.getText(), view);
            List c6 = a.c(view);
            for (int i6 = 0; i6 < c6.size(); i6++) {
                w02.b((y.a) c6.get(i6));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f9325a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f9325a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i6, Bundle bundle) {
            return this.f9325a.j(view, i6, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i6) {
            this.f9325a.l(view, i6);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f9325a.m(view, accessibilityEvent);
        }
    }

    public a() {
        this(f9322c);
    }

    static List c(View view) {
        List list = (List) view.getTag(s.b.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] p5 = f0.y.p(view.createAccessibilityNodeInfo().getText());
            for (int i6 = 0; p5 != null && i6 < p5.length; i6++) {
                if (clickableSpan.equals(p5[i6])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i6, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(s.b.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i6)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (e(clickableSpan, view)) {
            clickableSpan.onClick(view);
            return true;
        }
        return false;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f9323a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public f0.z b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f9323a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new f0.z(accessibilityNodeProvider);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate d() {
        return this.f9324b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f9323a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, f0.y yVar) {
        this.f9323a.onInitializeAccessibilityNodeInfo(view, yVar.v0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f9323a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f9323a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i6, Bundle bundle) {
        List c6 = c(view);
        boolean z5 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= c6.size()) {
                break;
            }
            y.a aVar = (y.a) c6.get(i7);
            if (aVar.b() == i6) {
                z5 = aVar.d(view, bundle);
                break;
            }
            i7++;
        }
        if (!z5) {
            z5 = this.f9323a.performAccessibilityAction(view, i6, bundle);
        }
        return (z5 || i6 != s.b.accessibility_action_clickable_span) ? z5 : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i6) {
        this.f9323a.sendAccessibilityEvent(view, i6);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f9323a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f9323a = accessibilityDelegate;
        this.f9324b = new C0156a(this);
    }
}
