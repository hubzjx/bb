package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.ui.SubtitleView;
import e2.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
final class a extends View implements SubtitleView.a {

    /* renamed from: b  reason: collision with root package name */
    private final List f4526b;

    /* renamed from: c  reason: collision with root package name */
    private List f4527c;

    /* renamed from: d  reason: collision with root package name */
    private int f4528d;

    /* renamed from: e  reason: collision with root package name */
    private float f4529e;

    /* renamed from: f  reason: collision with root package name */
    private e2.a f4530f;

    /* renamed from: g  reason: collision with root package name */
    private float f4531g;

    public a(Context context) {
        this(context, null);
    }

    private static e2.b b(e2.b bVar) {
        b.C0159b n5 = bVar.a().j(-3.4028235E38f).k(Integer.MIN_VALUE).n(null);
        if (bVar.f9440e == 0) {
            n5.h(1.0f - bVar.f9439d, 0);
        } else {
            n5.h((-bVar.f9439d) - 1.0f, 1);
        }
        int i6 = bVar.f9441f;
        if (i6 == 0) {
            n5.i(2);
        } else if (i6 == 2) {
            n5.i(0);
        }
        return n5.a();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List list, e2.a aVar, float f6, int i6, float f7) {
        this.f4527c = list;
        this.f4530f = aVar;
        this.f4529e = f6;
        this.f4528d = i6;
        this.f4531g = f7;
        while (this.f4526b.size() < list.size()) {
            this.f4526b.add(new f(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List list = this.f4527c;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i6 = paddingBottom - paddingTop;
        float a6 = g.a(this.f4528d, this.f4529e, height, i6);
        if (a6 <= 0.0f) {
            return;
        }
        int size = list.size();
        int i7 = 0;
        while (i7 < size) {
            e2.b bVar = (e2.b) list.get(i7);
            if (bVar.f9450o != Integer.MIN_VALUE) {
                bVar = b(bVar);
            }
            e2.b bVar2 = bVar;
            int i8 = paddingBottom;
            ((f) this.f4526b.get(i7)).b(bVar2, this.f4530f, a6, g.a(bVar2.f9448m, bVar2.f9449n, height, i6), this.f4531g, canvas, paddingLeft, paddingTop, width, i8);
            i7++;
            size = size;
            i6 = i6;
            paddingBottom = i8;
            width = width;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4526b = new ArrayList();
        this.f4527c = Collections.emptyList();
        this.f4528d = 0;
        this.f4529e = 0.0533f;
        this.f4530f = e2.a.f9428g;
        this.f4531g = 0.08f;
    }
}
