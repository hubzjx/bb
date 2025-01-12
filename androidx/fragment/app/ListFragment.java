package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ListFragment extends Fragment {
    private final Handler Z = new Handler();

    /* renamed from: a0  reason: collision with root package name */
    private final Runnable f1746a0 = new a();

    /* renamed from: b0  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f1747b0 = new b();

    /* renamed from: c0  reason: collision with root package name */
    ListAdapter f1748c0;

    /* renamed from: d0  reason: collision with root package name */
    ListView f1749d0;

    /* renamed from: e0  reason: collision with root package name */
    View f1750e0;

    /* renamed from: f0  reason: collision with root package name */
    TextView f1751f0;

    /* renamed from: g0  reason: collision with root package name */
    View f1752g0;

    /* renamed from: h0  reason: collision with root package name */
    View f1753h0;

    /* renamed from: i0  reason: collision with root package name */
    CharSequence f1754i0;

    /* renamed from: j0  reason: collision with root package name */
    boolean f1755j0;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListView listView = ListFragment.this.f1749d0;
            listView.focusableViewAvailable(listView);
        }
    }

    /* loaded from: classes.dex */
    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
            ListFragment.this.n1((ListView) adapterView, view, i6, j6);
        }
    }

    private void m1() {
        if (this.f1749d0 != null) {
            return;
        }
        View K = K();
        if (K == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (K instanceof ListView) {
            this.f1749d0 = (ListView) K;
        } else {
            TextView textView = (TextView) K.findViewById(16711681);
            this.f1751f0 = textView;
            if (textView == null) {
                this.f1750e0 = K.findViewById(16908292);
            } else {
                textView.setVisibility(8);
            }
            this.f1752g0 = K.findViewById(16711682);
            this.f1753h0 = K.findViewById(16711683);
            View findViewById = K.findViewById(16908298);
            if (!(findViewById instanceof ListView)) {
                if (findViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            ListView listView = (ListView) findViewById;
            this.f1749d0 = listView;
            View view = this.f1750e0;
            if (view == null) {
                CharSequence charSequence = this.f1754i0;
                if (charSequence != null) {
                    this.f1751f0.setText(charSequence);
                    listView = this.f1749d0;
                    view = this.f1751f0;
                }
            }
            listView.setEmptyView(view);
        }
        this.f1755j0 = true;
        this.f1749d0.setOnItemClickListener(this.f1747b0);
        ListAdapter listAdapter = this.f1748c0;
        if (listAdapter != null) {
            this.f1748c0 = null;
            o1(listAdapter);
        } else if (this.f1752g0 != null) {
            p1(false, false);
        }
        this.Z.post(this.f1746a0);
    }

    private void p1(boolean z5, boolean z6) {
        m1();
        View view = this.f1752g0;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.f1755j0 == z5) {
            return;
        }
        this.f1755j0 = z5;
        if (z5) {
            if (z6) {
                view.startAnimation(AnimationUtils.loadAnimation(p(), 17432577));
                this.f1753h0.startAnimation(AnimationUtils.loadAnimation(p(), 17432576));
            } else {
                view.clearAnimation();
                this.f1753h0.clearAnimation();
            }
            this.f1752g0.setVisibility(8);
            this.f1753h0.setVisibility(0);
            return;
        }
        if (z6) {
            view.startAnimation(AnimationUtils.loadAnimation(p(), 17432576));
            this.f1753h0.startAnimation(AnimationUtils.loadAnimation(p(), 17432577));
        } else {
            view.clearAnimation();
            this.f1753h0.clearAnimation();
        }
        this.f1752g0.setVisibility(0);
        this.f1753h0.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public View d0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context Y0 = Y0();
        FrameLayout frameLayout = new FrameLayout(Y0);
        LinearLayout linearLayout = new LinearLayout(Y0);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(Y0, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(Y0);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(Y0);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(Y0);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void g0() {
        this.Z.removeCallbacks(this.f1746a0);
        this.f1749d0 = null;
        this.f1755j0 = false;
        this.f1753h0 = null;
        this.f1752g0 = null;
        this.f1750e0 = null;
        this.f1751f0 = null;
        super.g0();
    }

    public void n1(ListView listView, View view, int i6, long j6) {
    }

    public void o1(ListAdapter listAdapter) {
        boolean z5 = this.f1748c0 != null;
        this.f1748c0 = listAdapter;
        ListView listView = this.f1749d0;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.f1755j0 || z5) {
                return;
            }
            p1(true, a1().getWindowToken() != null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y0(View view, Bundle bundle) {
        super.y0(view, bundle);
        m1();
    }
}
