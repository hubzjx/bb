package n0;

import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class k {
    public static k a(ViewGroup viewGroup) {
        android.support.v4.media.a.a(viewGroup.getTag(i.transition_current_scene));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(ViewGroup viewGroup, k kVar) {
        viewGroup.setTag(i.transition_current_scene, kVar);
    }
}
