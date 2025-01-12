package f0;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private final Object f9764a;

    /* loaded from: classes.dex */
    static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final z f9765a;

        a(z zVar) {
            this.f9765a = zVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i6) {
            y b6 = this.f9765a.b(i6);
            if (b6 == null) {
                return null;
            }
            return b6.v0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List findAccessibilityNodeInfosByText(String str, int i6) {
            List c6 = this.f9765a.c(str, i6);
            if (c6 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c6.size();
            for (int i7 = 0; i7 < size; i7++) {
                arrayList.add(((y) c6.get(i7)).v0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i6, int i7, Bundle bundle) {
            return this.f9765a.f(i6, i7, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class b extends a {
        b(z zVar) {
            super(zVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i6) {
            y d6 = this.f9765a.d(i6);
            if (d6 == null) {
                return null;
            }
            return d6.v0();
        }
    }

    /* loaded from: classes.dex */
    static class c extends b {
        c(z zVar) {
            super(zVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i6, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f9765a.a(i6, y.w0(accessibilityNodeInfo), str, bundle);
        }
    }

    public z() {
        this.f9764a = Build.VERSION.SDK_INT >= 26 ? new c(this) : new b(this);
    }

    public void a(int i6, y yVar, String str, Bundle bundle) {
    }

    public y b(int i6) {
        return null;
    }

    public List c(String str, int i6) {
        return null;
    }

    public y d(int i6) {
        return null;
    }

    public Object e() {
        return this.f9764a;
    }

    public boolean f(int i6, int i7, Bundle bundle) {
        return false;
    }

    public z(Object obj) {
        this.f9764a = obj;
    }
}
