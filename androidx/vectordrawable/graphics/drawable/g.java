package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import w.h;
/* loaded from: classes.dex */
public class g extends androidx.vectordrawable.graphics.drawable.f {

    /* renamed from: l  reason: collision with root package name */
    static final PorterDuff.Mode f2568l = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private h f2569c;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuffColorFilter f2570d;

    /* renamed from: e  reason: collision with root package name */
    private ColorFilter f2571e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2572f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2573g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable.ConstantState f2574h;

    /* renamed from: i  reason: collision with root package name */
    private final float[] f2575i;

    /* renamed from: j  reason: collision with root package name */
    private final Matrix f2576j;

    /* renamed from: k  reason: collision with root package name */
    private final Rect f2577k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends f {
        b() {
        }

        b(b bVar) {
            super(bVar);
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2604b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f2603a = w.h.d(string2);
            }
            this.f2605c = v.h.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (v.h.j(xmlPullParser, "pathData")) {
                TypedArray k6 = v.h.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2543d);
                f(k6, xmlPullParser);
                k6.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private int[] f2578e;

        /* renamed from: f  reason: collision with root package name */
        v.b f2579f;

        /* renamed from: g  reason: collision with root package name */
        float f2580g;

        /* renamed from: h  reason: collision with root package name */
        v.b f2581h;

        /* renamed from: i  reason: collision with root package name */
        float f2582i;

        /* renamed from: j  reason: collision with root package name */
        float f2583j;

        /* renamed from: k  reason: collision with root package name */
        float f2584k;

        /* renamed from: l  reason: collision with root package name */
        float f2585l;

        /* renamed from: m  reason: collision with root package name */
        float f2586m;

        /* renamed from: n  reason: collision with root package name */
        Paint.Cap f2587n;

        /* renamed from: o  reason: collision with root package name */
        Paint.Join f2588o;

        /* renamed from: p  reason: collision with root package name */
        float f2589p;

        c() {
            this.f2580g = 0.0f;
            this.f2582i = 1.0f;
            this.f2583j = 1.0f;
            this.f2584k = 0.0f;
            this.f2585l = 1.0f;
            this.f2586m = 0.0f;
            this.f2587n = Paint.Cap.BUTT;
            this.f2588o = Paint.Join.MITER;
            this.f2589p = 4.0f;
        }

        private Paint.Cap e(int i6, Paint.Cap cap) {
            return i6 != 0 ? i6 != 1 ? i6 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i6, Paint.Join join) {
            return i6 != 0 ? i6 != 1 ? i6 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f2578e = null;
            if (v.h.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f2604b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f2603a = w.h.d(string2);
                }
                this.f2581h = v.h.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f2583j = v.h.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f2583j);
                this.f2587n = e(v.h.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f2587n);
                this.f2588o = f(v.h.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f2588o);
                this.f2589p = v.h.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f2589p);
                this.f2579f = v.h.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f2582i = v.h.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f2582i);
                this.f2580g = v.h.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f2580g);
                this.f2585l = v.h.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f2585l);
                this.f2586m = v.h.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f2586m);
                this.f2584k = v.h.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f2584k);
                this.f2605c = v.h.g(typedArray, xmlPullParser, "fillType", 13, this.f2605c);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.e
        public boolean a() {
            return this.f2581h.i() || this.f2579f.i();
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.e
        public boolean b(int[] iArr) {
            return this.f2579f.j(iArr) | this.f2581h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k6 = v.h.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2542c);
            h(k6, xmlPullParser, theme);
            k6.recycle();
        }

        float getFillAlpha() {
            return this.f2583j;
        }

        int getFillColor() {
            return this.f2581h.e();
        }

        float getStrokeAlpha() {
            return this.f2582i;
        }

        int getStrokeColor() {
            return this.f2579f.e();
        }

        float getStrokeWidth() {
            return this.f2580g;
        }

        float getTrimPathEnd() {
            return this.f2585l;
        }

        float getTrimPathOffset() {
            return this.f2586m;
        }

        float getTrimPathStart() {
            return this.f2584k;
        }

        void setFillAlpha(float f6) {
            this.f2583j = f6;
        }

        void setFillColor(int i6) {
            this.f2581h.k(i6);
        }

        void setStrokeAlpha(float f6) {
            this.f2582i = f6;
        }

        void setStrokeColor(int i6) {
            this.f2579f.k(i6);
        }

        void setStrokeWidth(float f6) {
            this.f2580g = f6;
        }

        void setTrimPathEnd(float f6) {
            this.f2585l = f6;
        }

        void setTrimPathOffset(float f6) {
            this.f2586m = f6;
        }

        void setTrimPathStart(float f6) {
            this.f2584k = f6;
        }

        c(c cVar) {
            super(cVar);
            this.f2580g = 0.0f;
            this.f2582i = 1.0f;
            this.f2583j = 1.0f;
            this.f2584k = 0.0f;
            this.f2585l = 1.0f;
            this.f2586m = 0.0f;
            this.f2587n = Paint.Cap.BUTT;
            this.f2588o = Paint.Join.MITER;
            this.f2589p = 4.0f;
            this.f2578e = cVar.f2578e;
            this.f2579f = cVar.f2579f;
            this.f2580g = cVar.f2580g;
            this.f2582i = cVar.f2582i;
            this.f2581h = cVar.f2581h;
            this.f2605c = cVar.f2605c;
            this.f2583j = cVar.f2583j;
            this.f2584k = cVar.f2584k;
            this.f2585l = cVar.f2585l;
            this.f2586m = cVar.f2586m;
            this.f2587n = cVar.f2587n;
            this.f2588o = cVar.f2588o;
            this.f2589p = cVar.f2589p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f2590a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList f2591b;

        /* renamed from: c  reason: collision with root package name */
        float f2592c;

        /* renamed from: d  reason: collision with root package name */
        private float f2593d;

        /* renamed from: e  reason: collision with root package name */
        private float f2594e;

        /* renamed from: f  reason: collision with root package name */
        private float f2595f;

        /* renamed from: g  reason: collision with root package name */
        private float f2596g;

        /* renamed from: h  reason: collision with root package name */
        private float f2597h;

        /* renamed from: i  reason: collision with root package name */
        private float f2598i;

        /* renamed from: j  reason: collision with root package name */
        final Matrix f2599j;

        /* renamed from: k  reason: collision with root package name */
        int f2600k;

        /* renamed from: l  reason: collision with root package name */
        private int[] f2601l;

        /* renamed from: m  reason: collision with root package name */
        private String f2602m;

        public d() {
            super();
            this.f2590a = new Matrix();
            this.f2591b = new ArrayList();
            this.f2592c = 0.0f;
            this.f2593d = 0.0f;
            this.f2594e = 0.0f;
            this.f2595f = 1.0f;
            this.f2596g = 1.0f;
            this.f2597h = 0.0f;
            this.f2598i = 0.0f;
            this.f2599j = new Matrix();
            this.f2602m = null;
        }

        private void d() {
            this.f2599j.reset();
            this.f2599j.postTranslate(-this.f2593d, -this.f2594e);
            this.f2599j.postScale(this.f2595f, this.f2596g);
            this.f2599j.postRotate(this.f2592c, 0.0f, 0.0f);
            this.f2599j.postTranslate(this.f2597h + this.f2593d, this.f2598i + this.f2594e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f2601l = null;
            this.f2592c = v.h.f(typedArray, xmlPullParser, "rotation", 5, this.f2592c);
            this.f2593d = typedArray.getFloat(1, this.f2593d);
            this.f2594e = typedArray.getFloat(2, this.f2594e);
            this.f2595f = v.h.f(typedArray, xmlPullParser, "scaleX", 3, this.f2595f);
            this.f2596g = v.h.f(typedArray, xmlPullParser, "scaleY", 4, this.f2596g);
            this.f2597h = v.h.f(typedArray, xmlPullParser, "translateX", 6, this.f2597h);
            this.f2598i = v.h.f(typedArray, xmlPullParser, "translateY", 7, this.f2598i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2602m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.e
        public boolean a() {
            for (int i6 = 0; i6 < this.f2591b.size(); i6++) {
                if (((e) this.f2591b.get(i6)).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.e
        public boolean b(int[] iArr) {
            boolean z5 = false;
            for (int i6 = 0; i6 < this.f2591b.size(); i6++) {
                z5 |= ((e) this.f2591b.get(i6)).b(iArr);
            }
            return z5;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k6 = v.h.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2541b);
            e(k6, xmlPullParser);
            k6.recycle();
        }

        public String getGroupName() {
            return this.f2602m;
        }

        public Matrix getLocalMatrix() {
            return this.f2599j;
        }

        public float getPivotX() {
            return this.f2593d;
        }

        public float getPivotY() {
            return this.f2594e;
        }

        public float getRotation() {
            return this.f2592c;
        }

        public float getScaleX() {
            return this.f2595f;
        }

        public float getScaleY() {
            return this.f2596g;
        }

        public float getTranslateX() {
            return this.f2597h;
        }

        public float getTranslateY() {
            return this.f2598i;
        }

        public void setPivotX(float f6) {
            if (f6 != this.f2593d) {
                this.f2593d = f6;
                d();
            }
        }

        public void setPivotY(float f6) {
            if (f6 != this.f2594e) {
                this.f2594e = f6;
                d();
            }
        }

        public void setRotation(float f6) {
            if (f6 != this.f2592c) {
                this.f2592c = f6;
                d();
            }
        }

        public void setScaleX(float f6) {
            if (f6 != this.f2595f) {
                this.f2595f = f6;
                d();
            }
        }

        public void setScaleY(float f6) {
            if (f6 != this.f2596g) {
                this.f2596g = f6;
                d();
            }
        }

        public void setTranslateX(float f6) {
            if (f6 != this.f2597h) {
                this.f2597h = f6;
                d();
            }
        }

        public void setTranslateY(float f6) {
            if (f6 != this.f2598i) {
                this.f2598i = f6;
                d();
            }
        }

        public d(d dVar, l.a aVar) {
            super();
            f bVar;
            this.f2590a = new Matrix();
            this.f2591b = new ArrayList();
            this.f2592c = 0.0f;
            this.f2593d = 0.0f;
            this.f2594e = 0.0f;
            this.f2595f = 1.0f;
            this.f2596g = 1.0f;
            this.f2597h = 0.0f;
            this.f2598i = 0.0f;
            Matrix matrix = new Matrix();
            this.f2599j = matrix;
            this.f2602m = null;
            this.f2592c = dVar.f2592c;
            this.f2593d = dVar.f2593d;
            this.f2594e = dVar.f2594e;
            this.f2595f = dVar.f2595f;
            this.f2596g = dVar.f2596g;
            this.f2597h = dVar.f2597h;
            this.f2598i = dVar.f2598i;
            this.f2601l = dVar.f2601l;
            String str = dVar.f2602m;
            this.f2602m = str;
            this.f2600k = dVar.f2600k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f2599j);
            ArrayList arrayList = dVar.f2591b;
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                Object obj = arrayList.get(i6);
                if (obj instanceof d) {
                    this.f2591b.add(new d((d) obj, aVar));
                } else {
                    if (obj instanceof c) {
                        bVar = new c((c) obj);
                    } else if (!(obj instanceof b)) {
                        throw new IllegalStateException("Unknown object in the tree!");
                    } else {
                        bVar = new b((b) obj);
                    }
                    this.f2591b.add(bVar);
                    Object obj2 = bVar.f2604b;
                    if (obj2 != null) {
                        aVar.put(obj2, bVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        protected h.b[] f2603a;

        /* renamed from: b  reason: collision with root package name */
        String f2604b;

        /* renamed from: c  reason: collision with root package name */
        int f2605c;

        /* renamed from: d  reason: collision with root package name */
        int f2606d;

        public f() {
            super();
            this.f2603a = null;
            this.f2605c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            h.b[] bVarArr = this.f2603a;
            if (bVarArr != null) {
                h.b.e(bVarArr, path);
            }
        }

        public h.b[] getPathData() {
            return this.f2603a;
        }

        public String getPathName() {
            return this.f2604b;
        }

        public void setPathData(h.b[] bVarArr) {
            if (w.h.b(this.f2603a, bVarArr)) {
                w.h.j(this.f2603a, bVarArr);
            } else {
                this.f2603a = w.h.f(bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f2603a = null;
            this.f2605c = 0;
            this.f2604b = fVar.f2604b;
            this.f2606d = fVar.f2606d;
            this.f2603a = w.h.f(fVar.f2603a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.vectordrawable.graphics.drawable.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0026g {

        /* renamed from: q  reason: collision with root package name */
        private static final Matrix f2607q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f2608a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f2609b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f2610c;

        /* renamed from: d  reason: collision with root package name */
        Paint f2611d;

        /* renamed from: e  reason: collision with root package name */
        Paint f2612e;

        /* renamed from: f  reason: collision with root package name */
        private PathMeasure f2613f;

        /* renamed from: g  reason: collision with root package name */
        private int f2614g;

        /* renamed from: h  reason: collision with root package name */
        final d f2615h;

        /* renamed from: i  reason: collision with root package name */
        float f2616i;

        /* renamed from: j  reason: collision with root package name */
        float f2617j;

        /* renamed from: k  reason: collision with root package name */
        float f2618k;

        /* renamed from: l  reason: collision with root package name */
        float f2619l;

        /* renamed from: m  reason: collision with root package name */
        int f2620m;

        /* renamed from: n  reason: collision with root package name */
        String f2621n;

        /* renamed from: o  reason: collision with root package name */
        Boolean f2622o;

        /* renamed from: p  reason: collision with root package name */
        final l.a f2623p;

        public C0026g() {
            this.f2610c = new Matrix();
            this.f2616i = 0.0f;
            this.f2617j = 0.0f;
            this.f2618k = 0.0f;
            this.f2619l = 0.0f;
            this.f2620m = 255;
            this.f2621n = null;
            this.f2622o = null;
            this.f2623p = new l.a();
            this.f2615h = new d();
            this.f2608a = new Path();
            this.f2609b = new Path();
        }

        private static float a(float f6, float f7, float f8, float f9) {
            return (f6 * f9) - (f7 * f8);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i6, int i7, ColorFilter colorFilter) {
            dVar.f2590a.set(matrix);
            dVar.f2590a.preConcat(dVar.f2599j);
            canvas.save();
            for (int i8 = 0; i8 < dVar.f2591b.size(); i8++) {
                e eVar = (e) dVar.f2591b.get(i8);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f2590a, canvas, i6, i7, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i6, i7, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i6, int i7, ColorFilter colorFilter) {
            float f6 = i6 / this.f2618k;
            float f7 = i7 / this.f2619l;
            float min = Math.min(f6, f7);
            Matrix matrix = dVar.f2590a;
            this.f2610c.set(matrix);
            this.f2610c.postScale(f6, f7);
            float e6 = e(matrix);
            if (e6 == 0.0f) {
                return;
            }
            fVar.d(this.f2608a);
            Path path = this.f2608a;
            this.f2609b.reset();
            if (fVar.c()) {
                this.f2609b.setFillType(fVar.f2605c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f2609b.addPath(path, this.f2610c);
                canvas.clipPath(this.f2609b);
                return;
            }
            c cVar = (c) fVar;
            float f8 = cVar.f2584k;
            if (f8 != 0.0f || cVar.f2585l != 1.0f) {
                float f9 = cVar.f2586m;
                float f10 = (f8 + f9) % 1.0f;
                float f11 = (cVar.f2585l + f9) % 1.0f;
                if (this.f2613f == null) {
                    this.f2613f = new PathMeasure();
                }
                this.f2613f.setPath(this.f2608a, false);
                float length = this.f2613f.getLength();
                float f12 = f10 * length;
                float f13 = f11 * length;
                path.reset();
                if (f12 > f13) {
                    this.f2613f.getSegment(f12, length, path, true);
                    this.f2613f.getSegment(0.0f, f13, path, true);
                } else {
                    this.f2613f.getSegment(f12, f13, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f2609b.addPath(path, this.f2610c);
            if (cVar.f2581h.l()) {
                v.b bVar = cVar.f2581h;
                if (this.f2612e == null) {
                    Paint paint = new Paint(1);
                    this.f2612e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f2612e;
                if (bVar.h()) {
                    Shader f14 = bVar.f();
                    f14.setLocalMatrix(this.f2610c);
                    paint2.setShader(f14);
                    paint2.setAlpha(Math.round(cVar.f2583j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(g.a(bVar.e(), cVar.f2583j));
                }
                paint2.setColorFilter(colorFilter);
                this.f2609b.setFillType(cVar.f2605c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f2609b, paint2);
            }
            if (cVar.f2579f.l()) {
                v.b bVar2 = cVar.f2579f;
                if (this.f2611d == null) {
                    Paint paint3 = new Paint(1);
                    this.f2611d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f2611d;
                Paint.Join join = cVar.f2588o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f2587n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f2589p);
                if (bVar2.h()) {
                    Shader f15 = bVar2.f();
                    f15.setLocalMatrix(this.f2610c);
                    paint4.setShader(f15);
                    paint4.setAlpha(Math.round(cVar.f2582i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(g.a(bVar2.e(), cVar.f2582i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f2580g * min * e6);
                canvas.drawPath(this.f2609b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a6 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a6) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i6, int i7, ColorFilter colorFilter) {
            c(this.f2615h, f2607q, canvas, i6, i7, colorFilter);
        }

        public boolean f() {
            if (this.f2622o == null) {
                this.f2622o = Boolean.valueOf(this.f2615h.a());
            }
            return this.f2622o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f2615h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f2620m;
        }

        public void setAlpha(float f6) {
            setRootAlpha((int) (f6 * 255.0f));
        }

        public void setRootAlpha(int i6) {
            this.f2620m = i6;
        }

        public C0026g(C0026g c0026g) {
            this.f2610c = new Matrix();
            this.f2616i = 0.0f;
            this.f2617j = 0.0f;
            this.f2618k = 0.0f;
            this.f2619l = 0.0f;
            this.f2620m = 255;
            this.f2621n = null;
            this.f2622o = null;
            l.a aVar = new l.a();
            this.f2623p = aVar;
            this.f2615h = new d(c0026g.f2615h, aVar);
            this.f2608a = new Path(c0026g.f2608a);
            this.f2609b = new Path(c0026g.f2609b);
            this.f2616i = c0026g.f2616i;
            this.f2617j = c0026g.f2617j;
            this.f2618k = c0026g.f2618k;
            this.f2619l = c0026g.f2619l;
            this.f2614g = c0026g.f2614g;
            this.f2620m = c0026g.f2620m;
            this.f2621n = c0026g.f2621n;
            String str = c0026g.f2621n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f2622o = c0026g.f2622o;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f2624a;

        /* renamed from: b  reason: collision with root package name */
        C0026g f2625b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f2626c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f2627d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2628e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f2629f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f2630g;

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f2631h;

        /* renamed from: i  reason: collision with root package name */
        int f2632i;

        /* renamed from: j  reason: collision with root package name */
        boolean f2633j;

        /* renamed from: k  reason: collision with root package name */
        boolean f2634k;

        /* renamed from: l  reason: collision with root package name */
        Paint f2635l;

        public h() {
            this.f2626c = null;
            this.f2627d = g.f2568l;
            this.f2625b = new C0026g();
        }

        public boolean a(int i6, int i7) {
            return i6 == this.f2629f.getWidth() && i7 == this.f2629f.getHeight();
        }

        public boolean b() {
            return !this.f2634k && this.f2630g == this.f2626c && this.f2631h == this.f2627d && this.f2633j == this.f2628e && this.f2632i == this.f2625b.getRootAlpha();
        }

        public void c(int i6, int i7) {
            if (this.f2629f == null || !a(i6, i7)) {
                this.f2629f = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
                this.f2634k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f2629f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (f() || colorFilter != null) {
                if (this.f2635l == null) {
                    Paint paint = new Paint();
                    this.f2635l = paint;
                    paint.setFilterBitmap(true);
                }
                this.f2635l.setAlpha(this.f2625b.getRootAlpha());
                this.f2635l.setColorFilter(colorFilter);
                return this.f2635l;
            }
            return null;
        }

        public boolean f() {
            return this.f2625b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f2625b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2624a;
        }

        public boolean h(int[] iArr) {
            boolean g6 = this.f2625b.g(iArr);
            this.f2634k |= g6;
            return g6;
        }

        public void i() {
            this.f2630g = this.f2626c;
            this.f2631h = this.f2627d;
            this.f2632i = this.f2625b.getRootAlpha();
            this.f2633j = this.f2628e;
            this.f2634k = false;
        }

        public void j(int i6, int i7) {
            this.f2629f.eraseColor(0);
            this.f2625b.b(new Canvas(this.f2629f), i6, i7, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new g(this);
        }

        public h(h hVar) {
            this.f2626c = null;
            this.f2627d = g.f2568l;
            if (hVar != null) {
                this.f2624a = hVar.f2624a;
                C0026g c0026g = new C0026g(hVar.f2625b);
                this.f2625b = c0026g;
                if (hVar.f2625b.f2612e != null) {
                    c0026g.f2612e = new Paint(hVar.f2625b.f2612e);
                }
                if (hVar.f2625b.f2611d != null) {
                    this.f2625b.f2611d = new Paint(hVar.f2625b.f2611d);
                }
                this.f2626c = hVar.f2626c;
                this.f2627d = hVar.f2627d;
                this.f2628e = hVar.f2628e;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f2636a;

        public i(Drawable.ConstantState constantState) {
            this.f2636a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f2636a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2636a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g();
            gVar.f2567b = (VectorDrawable) this.f2636a.newDrawable();
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            g gVar = new g();
            gVar.f2567b = (VectorDrawable) this.f2636a.newDrawable(resources);
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            g gVar = new g();
            gVar.f2567b = (VectorDrawable) this.f2636a.newDrawable(resources, theme);
            return gVar;
        }
    }

    g() {
        this.f2573g = true;
        this.f2575i = new float[9];
        this.f2576j = new Matrix();
        this.f2577k = new Rect();
        this.f2569c = new h();
    }

    static int a(int i6, float f6) {
        return (i6 & 16777215) | (((int) (Color.alpha(i6) * f6)) << 24);
    }

    public static g b(Resources resources, int i6, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            g gVar = new g();
            gVar.f2567b = v.f.b(resources, i6, theme);
            gVar.f2574h = new i(gVar.f2567b.getConstantState());
            return gVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i6);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException e6) {
            Log.e("VectorDrawableCompat", "parser error", e6);
            return null;
        }
    }

    public static g c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        g gVar = new g();
        gVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return gVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int i6;
        int i7;
        h hVar = this.f2569c;
        C0026g c0026g = hVar.f2625b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(c0026g.f2615h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z5 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f2591b.add(cVar);
                    if (cVar.getPathName() != null) {
                        c0026g.f2623p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f2624a = cVar.f2606d | hVar.f2624a;
                    z5 = false;
                } else {
                    if ("clip-path".equals(name)) {
                        b bVar = new b();
                        bVar.e(resources, attributeSet, theme, xmlPullParser);
                        dVar.f2591b.add(bVar);
                        if (bVar.getPathName() != null) {
                            c0026g.f2623p.put(bVar.getPathName(), bVar);
                        }
                        i6 = hVar.f2624a;
                        i7 = bVar.f2606d;
                    } else if ("group".equals(name)) {
                        d dVar2 = new d();
                        dVar2.c(resources, attributeSet, theme, xmlPullParser);
                        dVar.f2591b.add(dVar2);
                        arrayDeque.push(dVar2);
                        if (dVar2.getGroupName() != null) {
                            c0026g.f2623p.put(dVar2.getGroupName(), dVar2);
                        }
                        i6 = hVar.f2624a;
                        i7 = dVar2.f2600k;
                    }
                    hVar.f2624a = i7 | i6;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z5) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return isAutoMirrored() && x.b.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i6, PorterDuff.Mode mode) {
        if (i6 != 3) {
            if (i6 != 5) {
                if (i6 != 9) {
                    switch (i6) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        h hVar = this.f2569c;
        C0026g c0026g = hVar.f2625b;
        hVar.f2627d = g(v.h.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c6 = v.h.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c6 != null) {
            hVar.f2626c = c6;
        }
        hVar.f2628e = v.h.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f2628e);
        c0026g.f2618k = v.h.f(typedArray, xmlPullParser, "viewportWidth", 7, c0026g.f2618k);
        float f6 = v.h.f(typedArray, xmlPullParser, "viewportHeight", 8, c0026g.f2619l);
        c0026g.f2619l = f6;
        if (c0026g.f2618k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (f6 <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            c0026g.f2616i = typedArray.getDimension(3, c0026g.f2616i);
            float dimension = typedArray.getDimension(2, c0026g.f2617j);
            c0026g.f2617j = dimension;
            if (c0026g.f2616i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                c0026g.setAlpha(v.h.f(typedArray, xmlPullParser, "alpha", 4, c0026g.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c0026g.f2621n = string;
                    c0026g.f2623p.put(string, c0026g);
                }
            }
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.b(drawable);
            return false;
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f2569c.f2625b.f2623p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f2577k);
        if (this.f2577k.width() <= 0 || this.f2577k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f2571e;
        if (colorFilter == null) {
            colorFilter = this.f2570d;
        }
        canvas.getMatrix(this.f2576j);
        this.f2576j.getValues(this.f2575i);
        float abs = Math.abs(this.f2575i[0]);
        float abs2 = Math.abs(this.f2575i[4]);
        float abs3 = Math.abs(this.f2575i[1]);
        float abs4 = Math.abs(this.f2575i[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.f2577k.width() * abs));
        int min2 = Math.min(2048, (int) (this.f2577k.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.f2577k;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f2577k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f2577k.offsetTo(0, 0);
        this.f2569c.c(min, min2);
        if (!this.f2573g) {
            this.f2569c.j(min, min2);
        } else if (!this.f2569c.b()) {
            this.f2569c.j(min, min2);
            this.f2569c.i();
        }
        this.f2569c.d(canvas, colorFilter, this.f2577k);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f2567b;
        return drawable != null ? x.b.d(drawable) : this.f2569c.f2625b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f2569c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f2567b;
        return drawable != null ? x.b.e(drawable) : this.f2571e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f2567b == null || Build.VERSION.SDK_INT < 24) {
            this.f2569c.f2624a = getChangingConfigurations();
            return this.f2569c;
        }
        return new i(this.f2567b.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f2569c.f2625b.f2617j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f2569c.f2625b.f2616i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z5) {
        this.f2573g = z5;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f2567b;
        return drawable != null ? x.b.h(drawable) : this.f2569c.f2628e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.f2569c) != null && (hVar.g() || ((colorStateList = this.f2569c.f2626c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f2572f && super.mutate() == this) {
            this.f2569c = new h(this.f2569c);
            this.f2572f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z5;
        PorterDuff.Mode mode;
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f2569c;
        ColorStateList colorStateList = hVar.f2626c;
        if (colorStateList == null || (mode = hVar.f2627d) == null) {
            z5 = false;
        } else {
            this.f2570d = j(this.f2570d, colorStateList, mode);
            invalidateSelf();
            z5 = true;
        }
        if (hVar.g() && hVar.h(iArr)) {
            invalidateSelf();
            return true;
        }
        return z5;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j6) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j6);
        } else {
            super.scheduleSelf(runnable, j6);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.setAlpha(i6);
        } else if (this.f2569c.f2625b.getRootAlpha() != i6) {
            this.f2569c.f2625b.setRootAlpha(i6);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z5) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.j(drawable, z5);
        } else {
            this.f2569c.f2628e = z5;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i6) {
        super.setChangingConfigurations(i6);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i6, PorterDuff.Mode mode) {
        super.setColorFilter(i6, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z5) {
        super.setFilterBitmap(z5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f6, float f7) {
        super.setHotspot(f6, f7);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i6, int i7, int i8, int i9) {
        super.setHotspotBounds(i6, i7, i8, i9);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i6) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.n(drawable, i6);
        } else {
            setTintList(ColorStateList.valueOf(i6));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f2569c;
        if (hVar.f2626c != colorStateList) {
            hVar.f2626c = colorStateList;
            this.f2570d = j(this.f2570d, colorStateList, hVar.f2627d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.p(drawable, mode);
            return;
        }
        h hVar = this.f2569c;
        if (hVar.f2627d != mode) {
            hVar.f2627d = mode;
            this.f2570d = j(this.f2570d, hVar.f2626c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        Drawable drawable = this.f2567b;
        return drawable != null ? drawable.setVisible(z5, z6) : super.setVisible(z5, z6);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    g(h hVar) {
        this.f2573g = true;
        this.f2575i = new float[9];
        this.f2576j = new Matrix();
        this.f2577k = new Rect();
        this.f2569c = hVar;
        this.f2570d = j(this.f2570d, hVar.f2626c, hVar.f2627d);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            x.b.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f2569c;
        hVar.f2625b = new C0026g();
        TypedArray k6 = v.h.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2540a);
        i(k6, xmlPullParser, theme);
        k6.recycle();
        hVar.f2624a = getChangingConfigurations();
        hVar.f2634k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f2570d = j(this.f2570d, hVar.f2626c, hVar.f2627d);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2567b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f2571e = colorFilter;
        invalidateSelf();
    }
}
