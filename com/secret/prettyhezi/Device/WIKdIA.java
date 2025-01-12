package com.secret.prettyhezi.Device;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.d;
import g4.f;
import g4.i;
/* loaded from: classes.dex */
public class WIKdIA extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6136r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6137s;

    /* loaded from: classes.dex */
    class a extends f {

        /* renamed from: com.secret.prettyhezi.Device.WIKdIA$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0075a implements s.f {

            /* renamed from: com.secret.prettyhezi.Device.WIKdIA$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0076a extends ZZcINlcxH.q {
                C0076a() {
                }

                @Override // com.secret.prettyhezi.ZZcINlcxH.q
                public void b() {
                    WIKdIA.this.finish();
                }
            }

            C0075a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                WIKdIA.this.D("申请成功，请每日留意系统消息", new C0076a(), false);
            }
        }

        a() {
        }

        @Override // g4.f
        protected void a(View view) {
            WIKdIA.this.I0();
            j.o(v.f7132a + "user/loss/cert/json", true, new s.e(WIKdIA.this, new C0075a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6136r = C0;
        M(C0, "已经绑定其他账号");
        LinearLayout e6 = e(this.f6136r);
        this.f6137s = e6;
        e6.setGravity(1);
        this.f6137s.setPadding(i.r(12.0f), i.r(20.0f), i.r(12.0f), i.r(20.0f));
        this.f6137s.addView(d.c(this, 14, -16777216, "每个设备只支持绑定一个账户，如果你的设备曾经绑定过别的账号，首先要先解绑那个账号才能绑定新的账号。\n\n如果你无法登陆绑定的账号，有两种方案可以尝试：\n1. 设置->注销登录->登录页面->忘记密码, 可以在修改密码页面补充完整账号，设置新的登录密码，你就可以找回丢失的账号信息。\n2. 如果无法找回以前的绑定账号，可以点击下方的按钮申请解除本设备的绑定关系。系统经过一段时间分析，如果认为已绑定的账号不再使用本设备，则解除绑定关系。", 3), new LinearLayout.LayoutParams(-1, -2));
        U(this.f6137s, "申请解除本设备的绑定账号", 40, 40).setOnClickListener(new a());
    }
}
