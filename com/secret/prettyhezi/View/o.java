package com.secret.prettyhezi.View;

import android.widget.LinearLayout;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
/* loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7966a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f7967b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.c f7968c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f7969d;

        a(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.controls.x xVar, com.secret.prettyhezi.controls.c cVar, int i6) {
            this.f7966a = zZcINlcxH;
            this.f7967b = xVar;
            this.f7968c = cVar;
            this.f7969d = i6;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            this.f7966a.j(this.f7967b);
            if (this.f7968c.isSelected()) {
                g4.g a6 = g4.g.a();
                a6.l("HintDlgHelper" + this.f7969d, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7970a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f7971b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.c f7972c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f7973d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f7974e;

        b(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.controls.x xVar, com.secret.prettyhezi.controls.c cVar, int i6, c cVar2) {
            this.f7970a = zZcINlcxH;
            this.f7971b = xVar;
            this.f7972c = cVar;
            this.f7973d = i6;
            this.f7974e = cVar2;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            if (this.f7970a.j(this.f7971b) && i6 == 1) {
                if (this.f7972c.isSelected()) {
                    g4.g a6 = g4.g.a();
                    a6.l("HintDlgHelper" + this.f7973d, true);
                }
                this.f7974e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    public static void a(int i6, c cVar) {
        g4.g a6 = g4.g.a();
        if (a6.b("HintDlgHelper" + i6)) {
            cVar.a();
            return;
        }
        ZZcINlcxH j6 = g4.i.j();
        com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(j6);
        xVar.f(b(i6));
        com.secret.prettyhezi.controls.c cVar2 = new com.secret.prettyhezi.controls.c(j6, j6.s0(C0382R.string.NoMorePromptNextTime));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = g4.i.r(12.0f);
        xVar.f8475b.addView(cVar2, layoutParams);
        if (cVar == null) {
            xVar.d(new String[]{j6.s0(C0382R.string.ok)}, new a(j6, xVar, cVar2, i6));
        } else {
            xVar.d(new String[]{j6.s0(C0382R.string.cancel), j6.s0(C0382R.string.ok)}, new b(j6, xVar, cVar2, i6, cVar));
        }
        j6.x(xVar, null, false);
    }

    public static String b(int i6) {
        if (i6 != 2) {
            if (i6 != 5) {
                return "Unknown " + i6;
            }
            return String.format(g4.i.j().s0(C0382R.string.FollowUserHint), Integer.valueOf(MainApplication.f6711r.j()));
        }
        return g4.i.j().s0(C0382R.string.CollectScoreHint);
    }
}
