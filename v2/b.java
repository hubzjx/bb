package v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    public static void a(AnimatorSet animatorSet, List list) {
        int size = list.size();
        long j6 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Animator animator = (Animator) list.get(i6);
            j6 = Math.max(j6, animator.getStartDelay() + animator.getDuration());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j6);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }
}
