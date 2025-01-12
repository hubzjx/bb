package com.secret.prettyhezi.Upload;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.UoWMF;
/* loaded from: classes.dex */
public class YLgGyeY extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7424r;

    /* renamed from: s  reason: collision with root package name */
    public LinearLayout f7425s;

    /* renamed from: t  reason: collision with root package name */
    public RelativeLayout f7426t;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7424r = C0;
        this.f7426t = M(C0, "审核规则");
        LinearLayout e6 = e(this.f7424r);
        this.f7425s = e6;
        e6.setGravity(1);
        TextView b6 = g4.d.b(this, 14.0f, -16777216, "审核原则：\n1. 政治，血腥，幼幼内容不允许\n2. 长视频不允许转录，截取片段等垃圾重复内容\n3. 短视频不允许转录，下载BeautyBox内容二次上传的恶劣行为\n4. 图片，动漫不允许重新二次压制产生重复垃圾文件的行为\n\n\n允许的水印：\n1. wuwubox svip系列 F218 98堂 海角社区 糖\n2. 原创发布网站的水印，作者的水印\n3. 三级等远古作品上已经失效的水印\n\n不允许的水印：\n除了上面允许之外的一些垃圾站二次压制的水印，例如：博彩站二次压制的水印，各种绅士群二次压制的水印 电报群二次压制的水印");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int r5 = g4.i.r(10.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        layoutParams.topMargin = g4.i.r(6.0f);
        layoutParams.bottomMargin = g4.i.r(20.0f);
        this.f7425s.addView(b6, layoutParams);
    }
}
