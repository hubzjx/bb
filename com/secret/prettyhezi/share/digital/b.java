package com.secret.prettyhezi.share.digital;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.Registration.l;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.f;
import g4.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    com.secret.prettyhezi.share.digital.a f9011b;

    /* renamed from: c  reason: collision with root package name */
    RZS12WA f9012c;

    /* loaded from: classes.dex */
    class a extends f {
        a() {
        }

        @Override // g4.f
        protected void a(View view) {
            b.this.a();
        }
    }

    /* renamed from: com.secret.prettyhezi.share.digital.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0150b extends f {
        C0150b() {
        }

        @Override // g4.f
        protected void a(View view) {
            Intent intent = new Intent(b.this.f9012c, VQqTfV.class);
            Bundle bundle = new Bundle();
            bundle.putString("extra", com.secret.prettyhezi.f.e(b.this.f9011b));
            intent.putExtras(bundle);
            b.this.f9012c.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends ZZcINlcxH.q {

        /* loaded from: classes.dex */
        class a implements a.f {

            /* renamed from: com.secret.prettyhezi.share.digital.b$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0151a implements s.f {
                C0151a() {
                }

                @Override // com.secret.prettyhezi.s.f
                public void a(String str) {
                    b.this.f9012c.z("取消成功");
                    b.this.f9012c.V0();
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                b.this.f9012c.I0();
                j.r(v.f7132a + "tron/json", new d(b.this.f9011b.id), true, new s.e(b.this.f9012c, new C0151a()));
            }
        }

        c() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            com.secret.prettyhezi.Device.a.e();
            com.secret.prettyhezi.Device.a.b(b.this.f9012c, new a());
        }
    }

    /* loaded from: classes.dex */
    static class d extends l {
        public long xb;

        public d(long j6) {
            super("i");
            this.xb = j6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r18v0, types: [android.widget.LinearLayout, android.view.View, com.secret.prettyhezi.share.digital.b, android.view.ViewGroup] */
    public b(RZS12WA rzs12wa, com.secret.prettyhezi.share.digital.a aVar) {
        super(rzs12wa);
        StringBuilder sb;
        double d6;
        LinearLayout linearLayout;
        String Status;
        this.f9011b = aVar;
        this.f9012c = rzs12wa;
        setPadding(i.r(6.0f), i.r(2.0f), i.r(6.0f), i.r(2.0f));
        setOrientation(0);
        setGravity(16);
        setBackground(i.d(i.b(-1, 5.0f), i.b(Color.parseColor("#dddddd"), 5.0f)));
        LinearLayout linearLayout2 = new LinearLayout(rzs12wa);
        addView(linearLayout2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.setOrientation(1);
        LinearLayout linearLayout3 = new LinearLayout(rzs12wa);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-1, i.r(30.0f)));
        TextView b6 = g4.d.b(rzs12wa, 12.0f, -16777216, "预兑 " + aVar.amount + "USDT");
        StringBuilder sb2 = new StringBuilder();
        if (aVar.status == 2) {
            sb = new StringBuilder();
            sb.append("消耗 ");
            d6 = aVar.score2;
        } else {
            sb = new StringBuilder();
            sb.append("冻结 ");
            d6 = aVar.score1;
        }
        sb.append(i.F(d6));
        sb2.append(sb.toString());
        sb2.append("积分");
        TextView b7 = g4.d.b(rzs12wa, 12.0f, -16777216, sb2.toString());
        linearLayout3.addView(b6, new LinearLayout.LayoutParams(i.r(120.0f), -2));
        linearLayout3.addView(b7, new LinearLayout.LayoutParams(i.r(130.0f), -2));
        if (aVar.fee > 0.0d) {
            LinearLayout linearLayout4 = new LinearLayout(rzs12wa);
            linearLayout4.setOrientation(0);
            linearLayout4.setGravity(16);
            linearLayout2.addView(linearLayout4, new LinearLayout.LayoutParams(-1, i.r(22.0f)));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(aVar.status == 2 ? "到账 " : "预到账 ");
            linearLayout = linearLayout2;
            sb3.append(i.C(aVar.actual_amount));
            sb3.append("USDT");
            TextView b8 = g4.d.b(rzs12wa, 12.0f, -65536, sb3.toString());
            TextView b9 = g4.d.b(rzs12wa, 12.0f, -65536, "手续费 " + i.C(aVar.fee) + "USDT");
            linearLayout4.addView(b8, new LinearLayout.LayoutParams(i.r(120.0f), -2));
            linearLayout4.addView(b9, new LinearLayout.LayoutParams(i.r(130.0f), -2));
        } else {
            linearLayout = linearLayout2;
        }
        LinearLayout linearLayout5 = new LinearLayout(rzs12wa);
        linearLayout5.setOrientation(0);
        linearLayout5.setGravity(16);
        linearLayout.addView(linearLayout5, new LinearLayout.LayoutParams(-1, i.r(30.0f)));
        linearLayout5.addView(g4.d.b(rzs12wa, 12.0f, Color.parseColor("#666666"), "申请: " + i.v(aVar.created_at)), new LinearLayout.LayoutParams(i.r(120.0f), -2));
        TextView a6 = g4.d.a(rzs12wa, 12.0f, Color.parseColor("#666666"));
        linearLayout5.addView(a6, new LinearLayout.LayoutParams(i.r(130.0f), -2));
        if (aVar.status != 0) {
            Status = "更新: " + i.v(aVar.updated_at);
        } else {
            Status = aVar.Status();
        }
        a6.setText(Status);
        TextView c6 = g4.d.c(rzs12wa, 14, -1, aVar.status != 0 ? aVar.Status() : "取消", 17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(70.0f), i.r(40.0f));
        layoutParams.rightMargin = i.r(6.0f);
        addView(c6, layoutParams);
        int i6 = aVar.status;
        if (i6 == 0) {
            c6.setBackground(i.d(i.b(Color.parseColor("#333333"), 5.0f), i.b(Color.parseColor("#aaaaaa"), 5.0f)));
            c6.setTextColor(-65536);
            c6.setOnClickListener(new a());
        } else if (i6 != 2) {
            c6.setTextColor(-1);
            c6.setBackground(i.b(Color.parseColor("#666666"), 5.0f));
        } else {
            c6.setBackground(i.d(i.b(Color.parseColor("#333333"), 5.0f), i.b(-1, 5.0f)));
            c6.setTextColor(-65536);
        }
        setOnClickListener(new C0150b());
    }

    void a() {
        int i6 = (((System.currentTimeMillis() / 1000) - this.f9011b.created_at) > 600L ? 1 : (((System.currentTimeMillis() / 1000) - this.f9011b.created_at) == 600L ? 0 : -1));
        RZS12WA rzs12wa = this.f9012c;
        if (i6 < 0) {
            rzs12wa.y("挂单10分钟后才能取消");
        } else {
            rzs12wa.C("取消会影响诚信值，多次取消可能导致取消数字货币权限", new String[]{"暂不取消", "取消兑换"}, new c(), true);
        }
    }
}
