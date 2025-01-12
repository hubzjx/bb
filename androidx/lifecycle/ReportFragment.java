package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.c;
/* loaded from: classes.dex */
public class ReportFragment extends Fragment {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    private void a(c.a aVar) {
        Activity activity = getActivity();
        if (activity instanceof f) {
            c h6 = ((f) activity).h();
            if (h6 instanceof g) {
                ((g) h6).i(aVar);
            }
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    public static void e(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(null);
        a(c.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(c.a.ON_DESTROY);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(c.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(null);
        a(c.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d(null);
        a(c.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(c.a.ON_STOP);
    }
}
