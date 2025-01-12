package f0;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;
/* loaded from: classes.dex */
public abstract class a0 {
    public static void a(AccessibilityRecord accessibilityRecord, int i6) {
        accessibilityRecord.setMaxScrollX(i6);
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i6) {
        accessibilityRecord.setMaxScrollY(i6);
    }

    public static void c(AccessibilityRecord accessibilityRecord, View view, int i6) {
        accessibilityRecord.setSource(view, i6);
    }
}
