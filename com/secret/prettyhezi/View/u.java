package com.secret.prettyhezi.View;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.LpyhZ;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.SLUjG;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.d;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public abstract class u extends LinearLayout {

    /* renamed from: l  reason: collision with root package name */
    public static int f8036l = 4;

    /* renamed from: b  reason: collision with root package name */
    protected int f8037b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8038c;

    /* renamed from: d  reason: collision with root package name */
    protected int f8039d;

    /* renamed from: e  reason: collision with root package name */
    View f8040e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f8041f;

    /* renamed from: g  reason: collision with root package name */
    public String f8042g;

    /* renamed from: h  reason: collision with root package name */
    View f8043h;

    /* renamed from: i  reason: collision with root package name */
    protected com.secret.prettyhezi.Server.n f8044i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f8045j;

    /* renamed from: k  reason: collision with root package name */
    com.secret.prettyhezi.controls.c f8046k;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            u.this.k();
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            u.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            u.this.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {
        d() {
        }

        @Override // g4.f
        public void a(View view) {
            u.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {
        e() {
        }

        @Override // g4.f
        public void a(View view) {
            u.this.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SLUjG f8052b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(ZZcINlcxH zZcINlcxH, SLUjG sLUjG) {
            super(zZcINlcxH);
            this.f8052b = sLUjG;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            this.f8052b.z("设置成功，重新进入盒子列表的时候会显示新封面");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SLUjG f8054a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8055b;

        /* loaded from: classes.dex */
        class a implements s.f {
            a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                t j6 = u.this.j();
                u uVar = u.this;
                j6.z(uVar.f8044i, uVar);
            }
        }

        g(SLUjG sLUjG, int i6) {
            this.f8054a = sLUjG;
            this.f8055b = i6;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            this.f8054a.I0();
            int i6 = u.this.f8044i.id;
            int i7 = this.f8055b;
            SLUjG sLUjG = this.f8054a;
            com.secret.prettyhezi.Server.v.y(i6, i7, sLUjG.f6987s, new s.e(sLUjG, new a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends g4.f {
        h() {
        }

        @Override // g4.f
        public void a(View view) {
            u uVar = u.this;
            com.secret.prettyhezi.Server.n nVar = uVar.f8044i;
            if (nVar != null) {
                boolean z5 = !nVar.selected;
                nVar.selected = z5;
                uVar.f8046k.setSelected(z5);
            }
        }
    }

    public u(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH);
        this.f8037b = 0;
        this.f8038c = false;
        this.f8040e = null;
        this.f8041f = true;
        this.f8043h = null;
        this.f8044i = null;
        this.f8045j = true;
        this.f8046k = null;
        this.f8039d = i6;
        setOrientation(1);
        setBackground(g4.i.b(-1, f8036l));
    }

    public abstract void a(com.secret.prettyhezi.Server.n nVar);

    public final void b(com.secret.prettyhezi.Server.n nVar) {
        if (nVar != this.f8044i) {
            this.f8044i = nVar;
            a(nVar);
        }
    }

    public View c() {
        View view = this.f8043h;
        if (view != null) {
            return view;
        }
        String str = this.f8042g;
        if (str == null) {
            str = ((ZZcINlcxH) getContext()).s0(C0382R.string.Delete);
        }
        TextView h6 = h(str);
        this.f8043h = h6;
        h6.setPadding(g4.i.r(6.0f), 0, g4.i.r(6.0f), 0);
        ((TextView) this.f8043h).setMinWidth(g4.i.r(46.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, g4.i.r(30.0f));
        layoutParams.addRule(11, -1);
        getTopRelativeLayout().addView(this.f8043h, layoutParams);
        this.f8043h.setOnClickListener(new e());
        return this.f8043h;
    }

    public LinearLayout d() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11, -1);
        getTopRelativeLayout().addView(linearLayout, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(46.0f), g4.i.r(30.0f));
        layoutParams2.rightMargin = g4.i.r(12.0f);
        TextView h6 = h(((ZZcINlcxH) getContext()).s0(C0382R.string.edit));
        linearLayout.addView(h6, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(46.0f), g4.i.r(30.0f));
        layoutParams3.rightMargin = g4.i.r(2.0f);
        TextView h7 = h(((ZZcINlcxH) getContext()).s0(C0382R.string.Delete));
        linearLayout.addView(h7, layoutParams3);
        h7.setOnClickListener(new a());
        h6.setOnClickListener(new b());
        return linearLayout;
    }

    public RelativeLayout e() {
        return f(false);
    }

    public RelativeLayout f(boolean z5) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        getTopRelativeLayout().addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        if (z5) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(46.0f), g4.i.r(30.0f));
            layoutParams.rightMargin = g4.i.r(12.0f);
            layoutParams.addRule(11, -1);
            TextView h6 = h(((ZZcINlcxH) getContext()).s0(C0382R.string.Delete));
            relativeLayout.addView(h6, layoutParams);
            h6.setOnClickListener(new c());
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        TextView h7 = h(((ZZcINlcxH) getContext()).s0(C0382R.string.setAsCover));
        h7.setTextSize(12.0f);
        h7.setPadding(g4.i.r(8.0f), g4.i.r(8.0f), g4.i.r(8.0f), g4.i.r(8.0f));
        relativeLayout.addView(h7, layoutParams2);
        h7.setOnClickListener(new d());
        return relativeLayout;
    }

    public View g() {
        com.secret.prettyhezi.controls.c cVar = this.f8046k;
        if (cVar != null) {
            return cVar;
        }
        com.secret.prettyhezi.controls.c cVar2 = new com.secret.prettyhezi.controls.c(getContext(), null);
        this.f8046k = cVar2;
        cVar2.setBackgroundColor(Color.parseColor("#aaffffff"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11, -1);
        getTopRelativeLayout().addView(this.f8046k, layoutParams);
        this.f8046k.setOnClickListener(new h());
        return this.f8046k;
    }

    int getBoxType() {
        if (this instanceof com.secret.prettyhezi.View.h) {
            return ((com.secret.prettyhezi.Server.h) this.f8044i).f7112t;
        }
        return 0;
    }

    public int getItemHeight() {
        return this.f8037b;
    }

    public RelativeLayout getTopRelativeLayout() {
        return null;
    }

    TextView h(String str) {
        TextView c6 = g4.d.c(getContext(), 12, -1, str, 17);
        c6.setBackground(g4.i.b(-65536, 4.0f));
        return c6;
    }

    public View i() {
        if (getTopRelativeLayout() != null) {
            return c();
        }
        return null;
    }

    public t j() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof t) {
                return (t) parent;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k() {
        com.secret.prettyhezi.Server.h hVar;
        i iVar;
        d.a GetModeItems;
        Context context = getContext();
        if (this.f8044i == null || MainApplication.f6711r.r() == null) {
            return;
        }
        if (context instanceof SLUjG) {
            int boxType = getBoxType();
            if (boxType > 0) {
                SLUjG sLUjG = (SLUjG) context;
                sLUjG.B(sLUjG.s0(C0382R.string.RemoveResourceFromBox), new g(sLUjG, boxType), true);
            }
        } else if (context instanceof LpyhZ) {
            if (this instanceof com.secret.prettyhezi.View.e) {
                GetModeItems = com.secret.prettyhezi.d.Box;
            } else {
                if (this instanceof com.secret.prettyhezi.View.h) {
                    iVar = (com.secret.prettyhezi.View.h) this;
                } else if (this instanceof l) {
                    iVar = (l) this;
                } else {
                    hVar = null;
                    GetModeItems = hVar == null ? com.secret.prettyhezi.d.GetModeItems(hVar.f7112t) : null;
                }
                hVar = iVar.f7945m;
                if (hVar == null) {
                }
            }
            if (GetModeItems != null) {
                GetModeItems.removeItem(this.f8044i);
                j().z(this.f8044i, this);
            }
        }
    }

    public void l() {
    }

    public void m() {
        Context context = getContext();
        if (context instanceof SLUjG) {
            SLUjG sLUjG = (SLUjG) context;
            sLUjG.I0();
            String format = String.format("{\"post_id\":%d,\"type\":%d}", Integer.valueOf(this.f8044i.id), Integer.valueOf(getBoxType()));
            com.secret.prettyhezi.j.s(com.secret.prettyhezi.Server.v.f7132a + "box/show/edit/json?id=" + sLUjG.f6987s, format, true, new f(sLUjG, sLUjG));
        }
    }

    public void n(boolean z5) {
        if (!this.f8041f) {
            View view = this.f8040e;
            if (view != null) {
                view.setVisibility(8);
            }
        } else if (z5) {
            if (this.f8040e == null) {
                this.f8040e = i();
            }
            this.f8040e.setVisibility(0);
        } else {
            View view2 = this.f8040e;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void o(boolean z5) {
        if (this.f8045j) {
            if (z5) {
                if (this.f8046k == null) {
                    g();
                }
                this.f8046k.setVisibility(0);
                this.f8046k.setSelected(this.f8044i.selected);
                return;
            }
            com.secret.prettyhezi.controls.c cVar = this.f8046k;
            if (cVar != null) {
                cVar.setVisibility(8);
            }
        }
    }

    public void setItemVisible(boolean z5) {
    }
}
