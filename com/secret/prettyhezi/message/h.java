package com.secret.prettyhezi.message;

import android.view.View;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.View.t;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class h extends t {
    int Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ f f8713d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f8714e;

        a(f fVar, ZZcINlcxH zZcINlcxH) {
            this.f8713d = fVar;
            this.f8714e = zZcINlcxH;
        }

        @Override // g4.f
        public void a(View view) {
            String str;
            int f6 = MainApplication.f();
            e eVar = this.f8713d.f8711r;
            if (f6 <= 0) {
                f6 = eVar.notify.sender_share.equals(eVar.sender_share) ? eVar.notify.target : eVar.notify.sender;
            }
            e eVar2 = eVar.notify;
            int i6 = eVar2.sender;
            if (f6 == i6) {
                i6 = eVar2.target;
                str = eVar2.target_share;
            } else {
                str = eVar2.sender_share;
            }
            AWsQxAQ.U0(this.f8714e, eVar.id, i6, str);
        }
    }

    public h(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, e.class);
        String str;
        this.Q = i6;
        this.E = true;
        this.f8029w = false;
        if (i6 == 3) {
            str = "notify/announce/json?page=999";
        } else if (i6 == 2) {
            str = "notify/remind/json?page=999";
        } else if (i6 != 1) {
            return;
        } else {
            str = "notify/message/json?page=999";
        }
        g(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.View.t
    /* renamed from: N */
    public f l(ZZcINlcxH zZcINlcxH, e eVar, int i6) {
        f fVar = new f(zZcINlcxH);
        if (this.Q == 1) {
            fVar.setOnClickListener(new a(fVar, zZcINlcxH));
        }
        return fVar;
    }

    @Override // com.secret.prettyhezi.View.t
    protected int a() {
        return 1;
    }
}
