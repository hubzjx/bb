package g4;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static a[] f10496a = new a[100];

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public float f10497a;

        /* renamed from: b  reason: collision with root package name */
        public int f10498b;

        /* renamed from: c  reason: collision with root package name */
        public float f10499c;
    }

    static {
        int i6 = 0;
        while (true) {
            a[] aVarArr = f10496a;
            if (i6 >= aVarArr.length) {
                a aVar = aVarArr[0];
                aVar.f10497a = 18.0f;
                aVar.f10498b = -1;
                a aVar2 = aVarArr[1];
                aVar2.f10497a = 18.0f;
                aVar2.f10498b = -1;
                a aVar3 = aVarArr[2];
                aVar3.f10497a = 16.0f;
                aVar3.f10498b = -1;
                a aVar4 = aVarArr[3];
                aVar4.f10497a = 16.0f;
                aVar4.f10498b = Color.parseColor("#999999");
                a aVar5 = f10496a[4];
                aVar5.f10497a = 16.0f;
                aVar5.f10498b = Color.parseColor("#333333");
                a aVar6 = f10496a[5];
                aVar6.f10497a = 12.0f;
                aVar6.f10498b = Color.parseColor("#999999");
                f10496a[5].f10499c = 1.3333334f;
                return;
            }
            aVarArr[i6] = new a();
            a aVar7 = f10496a[i6];
            aVar7.f10498b = -65536;
            aVar7.f10497a = 20.0f;
            i6++;
        }
    }

    public static TextView a(Context context, float f6, int i6) {
        TextView textView = new TextView(context);
        textView.setTextSize(f6);
        textView.setTextColor(i6);
        return textView;
    }

    public static TextView b(Context context, float f6, int i6, String str) {
        TextView textView = new TextView(context);
        textView.setTextSize(f6);
        textView.setTextColor(i6);
        textView.setText(str);
        return textView;
    }

    public static TextView c(Context context, int i6, int i7, String str, int i8) {
        TextView textView = new TextView(context);
        textView.setTextSize(i6);
        textView.setTextColor(i7);
        textView.setText(str);
        textView.setGravity(i8);
        textView.setPadding(0, 0, 0, 0);
        return textView;
    }

    public static void d(TextView textView, float f6, int i6) {
        textView.setTextSize(f6);
        textView.setTextColor(i6);
    }
}
