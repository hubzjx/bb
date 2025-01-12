package com.secret.prettyhezi.Upload;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Upload.y;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class z extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    TextView f7531b;

    /* renamed from: c  reason: collision with root package name */
    TextView f7532c;

    /* renamed from: d  reason: collision with root package name */
    TextView f7533d;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7534d;

        /* renamed from: com.secret.prettyhezi.Upload.z$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0116a extends ZZcINlcxH.q {
            C0116a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                y.c();
            }
        }

        a(ZZcINlcxH zZcINlcxH) {
            this.f7534d = zZcINlcxH;
        }

        @Override // g4.f
        public void a(View view) {
            this.f7534d.B("取消上传此内容？", new C0116a(), true);
        }
    }

    public z(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        setOrientation(0);
        setGravity(16);
        setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        addView(linearLayout, new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.f7531b = g4.d.a(zZcINlcxH, 16.0f, -16777216);
        this.f7532c = g4.d.a(zZcINlcxH, 14.0f, -65536);
        linearLayout.addView(this.f7531b, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(10.0f);
        linearLayout.addView(this.f7532c, layoutParams);
        TextView c6 = g4.d.c(zZcINlcxH, 16, -1, zZcINlcxH.s0(C0382R.string.cancel), 17);
        this.f7533d = c6;
        c6.setBackground(g4.i.d(g4.i.b(-16777216, 5.0f), g4.i.b(Color.parseColor("#333333"), 5.0f)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(40.0f));
        layoutParams2.leftMargin = g4.i.r(12.0f);
        addView(this.f7533d, layoutParams2);
        this.f7533d.setOnClickListener(new a(zZcINlcxH));
    }

    static String b(String str) {
        return str.equals("ErrNameFormat") ? "标题格式不对" : str.equals("RRVideoContentFormat") ? "简介格式不对" : str.equals("RRVideoVideoSizeFormat") ? "视频文件大小不符合要求" : str.equals("RRVideoVideoDurationFormat") ? "视频时长不符合要求" : str.equals("RRVideoVideoHeigtOrWidthFormat") ? "视频分辨率太高或太低" : str.equals("RRVideoNameIsEXits") ? "内容重复冲突，操作失败" : str.equals("RRVideoVhashIsEXits") ? "视频已被上传过" : str.equals("RRVideoPhashIsEXits") ? "缩略图重复，请重新选择缩略图" : str.equals("NotPermission") ? "没有上传权限" : (str.equals("InvalidAccountOrPassword") || str.equals("InvalidCredentials")) ? "账号或密码错误" : str.equals("InsufficientAmount") ? "已超过上传限额，请明天再试" : str.equals("IsExits") ? "已被上传过" : str.equals("ErrBoxNotFound") ? "盒子不存在" : str;
    }

    public void a() {
        String str;
        y.k kVar = y.f7517b;
        if (kVar == null) {
            return;
        }
        this.f7531b.setText(kVar.title);
        if (kVar.deleted) {
            str = "等待删除";
        } else {
            String str2 = kVar.err;
            if (str2 != null) {
                str = b(str2);
            } else {
                int i6 = kVar.status;
                if (i6 == 0) {
                    str = "等待上传";
                } else if (i6 == 1) {
                    str = "正在处理";
                } else if (i6 != 206) {
                    str = (i6 == 210 || i6 == 300) ? "上传失败" : i6 != 304 ? HttpUrl.FRAGMENT_ENCODE_SET : "网络超时，下次登陆app会重试...";
                } else {
                    y.i iVar = kVar.zip;
                    if (iVar == null) {
                        iVar = kVar.audio;
                    }
                    str = "正在上传 " + ((iVar.offset * 100) / iVar.encryptedSize) + "%";
                }
            }
        }
        this.f7532c.setText(str);
    }
}
