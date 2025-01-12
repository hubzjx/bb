package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.util.s0;
import e2.b;
import e2.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class SubtitleView extends FrameLayout implements l {

    /* renamed from: b  reason: collision with root package name */
    private List f4497b;

    /* renamed from: c  reason: collision with root package name */
    private e2.a f4498c;

    /* renamed from: d  reason: collision with root package name */
    private int f4499d;

    /* renamed from: e  reason: collision with root package name */
    private float f4500e;

    /* renamed from: f  reason: collision with root package name */
    private float f4501f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4502g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4503h;

    /* renamed from: i  reason: collision with root package name */
    private int f4504i;

    /* renamed from: j  reason: collision with root package name */
    private a f4505j;

    /* renamed from: k  reason: collision with root package name */
    private View f4506k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(List list, e2.a aVar, float f6, int i6, float f7);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4497b = Collections.emptyList();
        this.f4498c = e2.a.f9428g;
        this.f4499d = 0;
        this.f4500e = 0.0533f;
        this.f4501f = 0.08f;
        this.f4502g = true;
        this.f4503h = true;
        com.google.android.exoplayer2.ui.a aVar = new com.google.android.exoplayer2.ui.a(context, attributeSet);
        this.f4505j = aVar;
        this.f4506k = aVar;
        addView(aVar);
        this.f4504i = 1;
    }

    private e2.b a(e2.b bVar) {
        CharSequence charSequence = bVar.f9436a;
        if (!this.f4502g) {
            b.C0159b b6 = bVar.a().o(-3.4028235E38f, Integer.MIN_VALUE).b();
            if (charSequence != null) {
                b6.m(charSequence.toString());
            }
            return b6.a();
        } else if (this.f4503h || charSequence == null) {
            return bVar;
        } else {
            b.C0159b o5 = bVar.a().o(-3.4028235E38f, Integer.MIN_VALUE);
            if (charSequence instanceof Spanned) {
                SpannableString valueOf = SpannableString.valueOf(charSequence);
                for (AbsoluteSizeSpan absoluteSizeSpan : (AbsoluteSizeSpan[]) valueOf.getSpans(0, valueOf.length(), AbsoluteSizeSpan.class)) {
                    valueOf.removeSpan(absoluteSizeSpan);
                }
                for (RelativeSizeSpan relativeSizeSpan : (RelativeSizeSpan[]) valueOf.getSpans(0, valueOf.length(), RelativeSizeSpan.class)) {
                    valueOf.removeSpan(relativeSizeSpan);
                }
                o5.m(valueOf);
            }
            return o5.a();
        }
    }

    private void c(int i6, float f6) {
        this.f4499d = i6;
        this.f4500e = f6;
        d();
    }

    private void d() {
        this.f4505j.a(getCuesWithStylingPreferencesApplied(), this.f4498c, this.f4500e, this.f4499d, this.f4501f);
    }

    private List<e2.b> getCuesWithStylingPreferencesApplied() {
        if (this.f4502g && this.f4503h) {
            return this.f4497b;
        }
        ArrayList arrayList = new ArrayList(this.f4497b.size());
        for (int i6 = 0; i6 < this.f4497b.size(); i6++) {
            arrayList.add(a((e2.b) this.f4497b.get(i6)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (s0.f4673a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private e2.a getUserCaptionStyle() {
        if (s0.f4673a < 19 || isInEditMode()) {
            return e2.a.f9428g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? e2.a.f9428g : e2.a.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t5) {
        removeView(this.f4506k);
        View view = this.f4506k;
        if (view instanceof h) {
            ((h) view).g();
        }
        this.f4506k = t5;
        this.f4505j = t5;
        addView(t5);
    }

    public void b(float f6, boolean z5) {
        c(z5 ? 1 : 0, f6);
    }

    @Override // e2.l
    public void n(List list) {
        setCues(list);
    }

    public void setApplyEmbeddedFontSizes(boolean z5) {
        this.f4503h = z5;
        d();
    }

    public void setApplyEmbeddedStyles(boolean z5) {
        this.f4502g = z5;
        d();
    }

    public void setBottomPaddingFraction(float f6) {
        this.f4501f = f6;
        d();
    }

    public void setCues(List<e2.b> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f4497b = list;
        d();
    }

    public void setFractionalTextSize(float f6) {
        b(f6, false);
    }

    public void setStyle(e2.a aVar) {
        this.f4498c = aVar;
        d();
    }

    public void setViewType(int i6) {
        KeyEvent.Callback aVar;
        if (this.f4504i == i6) {
            return;
        }
        if (i6 == 1) {
            aVar = new com.google.android.exoplayer2.ui.a(getContext());
        } else if (i6 != 2) {
            throw new IllegalArgumentException();
        } else {
            aVar = new h(getContext());
        }
        setView(aVar);
        this.f4504i = i6;
    }
}
