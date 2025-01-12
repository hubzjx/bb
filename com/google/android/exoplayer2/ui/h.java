package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.ui.c;
import com.google.android.exoplayer2.util.s0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
final class h extends FrameLayout implements SubtitleView.a {

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.ui.a f4569b;

    /* renamed from: c  reason: collision with root package name */
    private final WebView f4570c;

    /* renamed from: d  reason: collision with root package name */
    private List f4571d;

    /* renamed from: e  reason: collision with root package name */
    private e2.a f4572e;

    /* renamed from: f  reason: collision with root package name */
    private float f4573f;

    /* renamed from: g  reason: collision with root package name */
    private int f4574g;

    /* renamed from: h  reason: collision with root package name */
    private float f4575h;

    /* loaded from: classes.dex */
    class a extends WebView {
        a(h hVar, Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4576a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f4576a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4576a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4576a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public h(Context context) {
        this(context, null);
    }

    private static int b(int i6) {
        if (i6 != 1) {
            return i6 != 2 ? 0 : -100;
        }
        return -50;
    }

    private static String c(Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i6 = b.f4576a[alignment.ordinal()];
        return i6 != 1 ? i6 != 2 ? "center" : "end" : "start";
    }

    private static String d(e2.a aVar) {
        int i6 = aVar.f9432d;
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? "unset" : s0.D("-0.05em -0.05em 0.15em %s", com.google.android.exoplayer2.ui.b.b(aVar.f9433e)) : s0.D("0.06em 0.08em 0.15em %s", com.google.android.exoplayer2.ui.b.b(aVar.f9433e)) : s0.D("0.1em 0.12em 0.15em %s", com.google.android.exoplayer2.ui.b.b(aVar.f9433e)) : s0.D("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", com.google.android.exoplayer2.ui.b.b(aVar.f9433e));
    }

    private String e(int i6, float f6) {
        float a6 = g.a(i6, f6, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return a6 == -3.4028235E38f ? "unset" : s0.D("%.2fpx", Float.valueOf(a6 / getContext().getResources().getDisplayMetrics().density));
    }

    private static String f(int i6) {
        return i6 != 1 ? i6 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0148, code lost:
        if (r13 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x014b, code lost:
        if (r13 != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x014d, code lost:
        r20 = "left";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x014f, code lost:
        r21 = "top";
        r13 = 2;
        r22 = r20;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h() {
        String D;
        int i6;
        boolean z5;
        float f6;
        String str;
        int i7;
        int i8;
        String str2;
        String str3;
        int i9;
        Iterator it;
        h hVar = this;
        StringBuilder sb = new StringBuilder();
        char c6 = 0;
        int i10 = 1;
        float f7 = 1.2f;
        sb.append(s0.D("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2fem;text-shadow:%s;'>", com.google.android.exoplayer2.ui.b.b(hVar.f4572e.f9429a), hVar.e(hVar.f4574g, hVar.f4573f), Float.valueOf(1.2f), d(hVar.f4572e)));
        HashMap hashMap = new HashMap();
        hashMap.put(com.google.android.exoplayer2.ui.b.a("default_bg"), s0.D("background-color:%s;", com.google.android.exoplayer2.ui.b.b(hVar.f4572e.f9430b)));
        int i11 = 0;
        while (i11 < hVar.f4571d.size()) {
            e2.b bVar = (e2.b) hVar.f4571d.get(i11);
            float f8 = bVar.f9442g;
            float f9 = f8 != -3.4028235E38f ? f8 * 100.0f : 50.0f;
            int b6 = b(bVar.f9443h);
            float f10 = bVar.f9439d;
            if (f10 == -3.4028235E38f) {
                Object[] objArr = new Object[i10];
                objArr[c6] = Float.valueOf((1.0f - hVar.f4575h) * 100.0f);
                D = s0.D("%.2f%%", objArr);
                i6 = -100;
            } else if (bVar.f9440e != i10) {
                Object[] objArr2 = new Object[i10];
                objArr2[c6] = Float.valueOf(f10 * 100.0f);
                D = s0.D("%.2f%%", objArr2);
                i6 = bVar.f9450o == i10 ? -b(bVar.f9441f) : b(bVar.f9441f);
            } else if (f10 >= 0.0f) {
                Object[] objArr3 = new Object[i10];
                objArr3[c6] = Float.valueOf(f10 * f7);
                D = s0.D("%.2fem", objArr3);
                i6 = 0;
            } else {
                Object[] objArr4 = new Object[i10];
                objArr4[c6] = Float.valueOf(((-f10) - 1.0f) * f7);
                D = s0.D("%.2fem", objArr4);
                i6 = 0;
                z5 = true;
                f6 = bVar.f9444i;
                if (f6 == -3.4028235E38f) {
                    Object[] objArr5 = new Object[i10];
                    objArr5[0] = Float.valueOf(f6 * 100.0f);
                    str = s0.D("%.2f%%", objArr5);
                } else {
                    str = "fit-content";
                }
                String c7 = c(bVar.f9437b);
                String f11 = f(bVar.f9450o);
                String e6 = hVar.e(bVar.f9448m, bVar.f9449n);
                String b7 = com.google.android.exoplayer2.ui.b.b(!bVar.f9446k ? bVar.f9447l : hVar.f4572e.f9431c);
                int i12 = i6;
                i7 = bVar.f9450o;
                String str4 = "right";
                String str5 = "left";
                if (i7 == 1) {
                    if (i7 != 2) {
                        str2 = z5 ? "bottom" : "top";
                        i8 = 2;
                    }
                }
                if (i7 != i8 || i7 == 1) {
                    str3 = "height";
                    i9 = i12;
                    i12 = b6;
                } else {
                    str3 = "width";
                    i9 = b6;
                }
                c.b a6 = c.a(bVar.f9436a, getContext().getResources().getDisplayMetrics().density);
                it = hashMap.keySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = it;
                    String str6 = (String) it.next();
                    String str7 = (String) hashMap.put(str6, (String) hashMap.get(str6));
                    com.google.android.exoplayer2.util.a.g(str7 == null || str7.equals(hashMap.get(str6)));
                    it = it2;
                }
                sb.append(s0.D("<div style='position:absolute;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%);'>", str5, Float.valueOf(f9), str2, D, str3, str, c7, f11, e6, b7, Integer.valueOf(i9), Integer.valueOf(i12)));
                sb.append(s0.D("<span class='%s'>", "default_bg"));
                sb.append(a6.f4533a);
                sb.append("</span>");
                sb.append("</div>");
                i11++;
                f7 = 1.2f;
                c6 = 0;
                hVar = this;
                i10 = 1;
            }
            z5 = false;
            f6 = bVar.f9444i;
            if (f6 == -3.4028235E38f) {
            }
            String c72 = c(bVar.f9437b);
            String f112 = f(bVar.f9450o);
            String e62 = hVar.e(bVar.f9448m, bVar.f9449n);
            String b72 = com.google.android.exoplayer2.ui.b.b(!bVar.f9446k ? bVar.f9447l : hVar.f4572e.f9431c);
            int i122 = i6;
            i7 = bVar.f9450o;
            String str42 = "right";
            String str52 = "left";
            if (i7 == 1) {
            }
            if (i7 != i8) {
            }
            str3 = "height";
            i9 = i122;
            i122 = b6;
            c.b a62 = c.a(bVar.f9436a, getContext().getResources().getDisplayMetrics().density);
            it = hashMap.keySet().iterator();
            while (it.hasNext()) {
            }
            sb.append(s0.D("<div style='position:absolute;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%);'>", str52, Float.valueOf(f9), str2, D, str3, str, c72, f112, e62, b72, Integer.valueOf(i9), Integer.valueOf(i122)));
            sb.append(s0.D("<span class='%s'>", "default_bg"));
            sb.append(a62.f4533a);
            sb.append("</span>");
            sb.append("</div>");
            i11++;
            f7 = 1.2f;
            c6 = 0;
            hVar = this;
            i10 = 1;
        }
        sb.append("</div></body></html>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<html><head><style>");
        for (String str8 : hashMap.keySet()) {
            sb2.append(str8);
            sb2.append("{");
            sb2.append((String) hashMap.get(str8));
            sb2.append("}");
        }
        sb2.append("</style></head>");
        sb.insert(0, sb2.toString());
        this.f4570c.loadData(Base64.encodeToString(sb.toString().getBytes(com.google.common.base.b.f5585c), 1), "text/html", "base64");
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List list, e2.a aVar, float f6, int i6, float f7) {
        this.f4572e = aVar;
        this.f4573f = f6;
        this.f4574g = i6;
        this.f4575h = f7;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i7 = 0; i7 < list.size(); i7++) {
            e2.b bVar = (e2.b) list.get(i7);
            if (bVar.f9438c != null) {
                arrayList.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        if (!this.f4571d.isEmpty() || !arrayList2.isEmpty()) {
            this.f4571d = arrayList2;
            h();
        }
        this.f4569b.a(arrayList, aVar, f6, i6, f7);
        invalidate();
    }

    public void g() {
        this.f4570c.destroy();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (!z5 || this.f4571d.isEmpty()) {
            return;
        }
        h();
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4571d = Collections.emptyList();
        this.f4572e = e2.a.f9428g;
        this.f4573f = 0.0533f;
        this.f4574g = 0;
        this.f4575h = 0.08f;
        com.google.android.exoplayer2.ui.a aVar = new com.google.android.exoplayer2.ui.a(context, attributeSet);
        this.f4569b = aVar;
        a aVar2 = new a(this, context, attributeSet);
        this.f4570c = aVar2;
        aVar2.setBackgroundColor(0);
        addView(aVar);
        addView(aVar2);
    }
}
