package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import w.h;
/* loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements TypeEvaluator {

        /* renamed from: a  reason: collision with root package name */
        private h.b[] f2565a;

        a() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public h.b[] evaluate(float f6, h.b[] bVarArr, h.b[] bVarArr2) {
            if (h.b(bVarArr, bVarArr2)) {
                if (!h.b(this.f2565a, bVarArr)) {
                    this.f2565a = h.f(bVarArr);
                }
                for (int i6 = 0; i6 < bVarArr.length; i6++) {
                    this.f2565a[i6].d(bVarArr[i6], bVarArr2[i6], f6);
                }
                return this.f2565a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f6) {
        return b(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Animator b(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i6, float f6) {
        int i7;
        int depth = xmlPullParser.getDepth();
        ValueAnimator valueAnimator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            i7 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        valueAnimator = n(context, resources, theme, attributeSet, f6, xmlPullParser);
                    } else if (name.equals("animator")) {
                        valueAnimator = l(context, resources, theme, attributeSet, null, f6, xmlPullParser);
                    } else {
                        if (name.equals("set")) {
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            TypedArray k6 = v.h.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2547h);
                            b(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, v.h.g(k6, xmlPullParser, "ordering", 0, 0), f6);
                            k6.recycle();
                            valueAnimator = animatorSet2;
                        } else if (!name.equals("propertyValuesHolder")) {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        } else {
                            PropertyValuesHolder[] p5 = p(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                            if (p5 != null && (valueAnimator instanceof ValueAnimator)) {
                                valueAnimator.setValues(p5);
                            }
                            i7 = 1;
                        }
                        if (animatorSet != null && i7 == 0) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(valueAnimator);
                        }
                    }
                    if (animatorSet != null) {
                        if (arrayList == null) {
                        }
                        arrayList.add(valueAnimator);
                    }
                }
            }
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i7] = (Animator) it.next();
                i7++;
            }
            if (i6 == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return valueAnimator;
    }

    private static Keyframe c(Keyframe keyframe, float f6) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f6) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f6) : Keyframe.ofObject(f6);
    }

    private static void d(Keyframe[] keyframeArr, float f6, int i6, int i7) {
        float f7 = f6 / ((i7 - i6) + 2);
        while (i6 <= i7) {
            keyframeArr[i6].setFraction(keyframeArr[i6 - 1].getFraction() + f7);
            i6++;
        }
    }

    private static PropertyValuesHolder e(TypedArray typedArray, int i6, int i7, int i8, String str) {
        PropertyValuesHolder ofFloat;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i7);
        boolean z5 = peekValue != null;
        int i9 = z5 ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i8);
        boolean z6 = peekValue2 != null;
        int i10 = z6 ? peekValue2.type : 0;
        if (i6 == 4) {
            i6 = ((z5 && h(i9)) || (z6 && h(i10))) ? 3 : 0;
        }
        boolean z7 = i6 == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i6 != 2) {
            e a6 = i6 == 3 ? e.a() : null;
            if (z7) {
                if (z5) {
                    float dimension = i9 == 5 ? typedArray.getDimension(i7, 0.0f) : typedArray.getFloat(i7, 0.0f);
                    if (z6) {
                        ofFloat = PropertyValuesHolder.ofFloat(str, dimension, i10 == 5 ? typedArray.getDimension(i8, 0.0f) : typedArray.getFloat(i8, 0.0f));
                    } else {
                        ofFloat = PropertyValuesHolder.ofFloat(str, dimension);
                    }
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, i10 == 5 ? typedArray.getDimension(i8, 0.0f) : typedArray.getFloat(i8, 0.0f));
                }
                propertyValuesHolder = ofFloat;
            } else if (z5) {
                int dimension2 = i9 == 5 ? (int) typedArray.getDimension(i7, 0.0f) : h(i9) ? typedArray.getColor(i7, 0) : typedArray.getInt(i7, 0);
                if (z6) {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2, i10 == 5 ? (int) typedArray.getDimension(i8, 0.0f) : h(i10) ? typedArray.getColor(i8, 0) : typedArray.getInt(i8, 0));
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2);
                }
            } else if (z6) {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i10 == 5 ? (int) typedArray.getDimension(i8, 0.0f) : h(i10) ? typedArray.getColor(i8, 0) : typedArray.getInt(i8, 0));
            }
            if (propertyValuesHolder == null || a6 == null) {
                return propertyValuesHolder;
            }
            propertyValuesHolder.setEvaluator(a6);
            return propertyValuesHolder;
        }
        String string = typedArray.getString(i7);
        String string2 = typedArray.getString(i8);
        h.b[] d6 = h.d(string);
        h.b[] d7 = h.d(string2);
        if (d6 == null && d7 == null) {
            return null;
        }
        if (d6 == null) {
            if (d7 != null) {
                return PropertyValuesHolder.ofObject(str, new a(), d7);
            }
            return null;
        }
        a aVar = new a();
        if (d7 == null) {
            ofObject = PropertyValuesHolder.ofObject(str, aVar, d6);
        } else if (!h.b(d6, d7)) {
            throw new InflateException(" Can't morph from " + string + " to " + string2);
        } else {
            ofObject = PropertyValuesHolder.ofObject(str, aVar, d6, d7);
        }
        return ofObject;
    }

    private static int f(TypedArray typedArray, int i6, int i7) {
        TypedValue peekValue = typedArray.peekValue(i6);
        boolean z5 = peekValue != null;
        int i8 = z5 ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i7);
        boolean z6 = peekValue2 != null;
        return ((z5 && h(i8)) || (z6 && h(z6 ? peekValue2.type : 0))) ? 3 : 0;
    }

    private static int g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray k6 = v.h.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2549j);
        int i6 = 0;
        TypedValue l6 = v.h.l(k6, xmlPullParser, "value", 0);
        if ((l6 != null) && h(l6.type)) {
            i6 = 3;
        }
        k6.recycle();
        return i6;
    }

    private static boolean h(int i6) {
        return i6 >= 28 && i6 <= 31;
    }

    public static Animator i(Context context, int i6) {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i6) : j(context, context.getResources(), context.getTheme(), i6);
    }

    public static Animator j(Context context, Resources resources, Resources.Theme theme, int i6) {
        return k(context, resources, theme, i6, 1.0f);
    }

    public static Animator k(Context context, Resources resources, Resources.Theme theme, int i6, float f6) {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i6);
                    return a(context, resources, theme, xmlResourceParser, f6);
                } catch (XmlPullParserException e6) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i6));
                    notFoundException.initCause(e6);
                    throw notFoundException;
                }
            } catch (IOException e7) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i6));
                notFoundException2.initCause(e7);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static ValueAnimator l(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f6, XmlPullParser xmlPullParser) {
        TypedArray k6 = v.h.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2546g);
        TypedArray k7 = v.h.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2550k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        q(valueAnimator, k6, k7, f6, xmlPullParser);
        int h6 = v.h.h(k6, xmlPullParser, "interpolator", 0, 0);
        if (h6 > 0) {
            valueAnimator.setInterpolator(c.a(context, h6));
        }
        k6.recycle();
        if (k7 != null) {
            k7.recycle();
        }
        return valueAnimator;
    }

    private static Keyframe m(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i6, XmlPullParser xmlPullParser) {
        TypedArray k6 = v.h.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2549j);
        float f6 = v.h.f(k6, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue l6 = v.h.l(k6, xmlPullParser, "value", 0);
        boolean z5 = l6 != null;
        if (i6 == 4) {
            i6 = (z5 && h(l6.type)) ? 3 : 0;
        }
        Keyframe ofInt = z5 ? i6 != 0 ? (i6 == 1 || i6 == 3) ? Keyframe.ofInt(f6, v.h.g(k6, xmlPullParser, "value", 0, 0)) : null : Keyframe.ofFloat(f6, v.h.f(k6, xmlPullParser, "value", 0, 0.0f)) : i6 == 0 ? Keyframe.ofFloat(f6) : Keyframe.ofInt(f6);
        int h6 = v.h.h(k6, xmlPullParser, "interpolator", 1, 0);
        if (h6 > 0) {
            ofInt.setInterpolator(c.a(context, h6));
        }
        k6.recycle();
        return ofInt;
    }

    private static ObjectAnimator n(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f6, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        l(context, resources, theme, attributeSet, objectAnimator, f6, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder o(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i6) {
        int size;
        PropertyValuesHolder propertyValuesHolder = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i6 == 4) {
                    i6 = g(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe m5 = m(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i6, xmlPullParser);
                if (m5 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(m5);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), c(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, c(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i7 = 0; i7 < size; i7++) {
                Keyframe keyframe3 = keyframeArr[i7];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i7 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i8 = size - 1;
                        if (i7 == i8) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i9 = i7;
                            for (int i10 = i7 + 1; i10 < i8 && keyframeArr[i10].getFraction() < 0.0f; i10++) {
                                i9 = i10;
                            }
                            d(keyframeArr, keyframeArr[i9 + 1].getFraction() - keyframeArr[i7 - 1].getFraction(), i7, i9);
                        }
                    }
                }
            }
            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i6 == 3) {
                propertyValuesHolder.setEvaluator(e.a());
            }
        }
        return propertyValuesHolder;
    }

    private static PropertyValuesHolder[] p(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        int i6;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType == 2 && xmlPullParser.getName().equals("propertyValuesHolder")) {
                TypedArray k6 = v.h.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2548i);
                String i7 = v.h.i(k6, xmlPullParser, "propertyName", 3);
                int g6 = v.h.g(k6, xmlPullParser, "valueType", 2, 4);
                PropertyValuesHolder o5 = o(context, resources, theme, xmlPullParser, i7, g6);
                if (o5 == null) {
                    o5 = e(k6, g6, 0, 1, i7);
                }
                if (o5 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(o5);
                }
                k6.recycle();
            }
            xmlPullParser.next();
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i6 = 0; i6 < size; i6++) {
                propertyValuesHolderArr[i6] = (PropertyValuesHolder) arrayList.get(i6);
            }
        }
        return propertyValuesHolderArr;
    }

    private static void q(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f6, XmlPullParser xmlPullParser) {
        long g6 = v.h.g(typedArray, xmlPullParser, "duration", 1, 300);
        long g7 = v.h.g(typedArray, xmlPullParser, "startOffset", 2, 0);
        int g8 = v.h.g(typedArray, xmlPullParser, "valueType", 7, 4);
        if (v.h.j(xmlPullParser, "valueFrom") && v.h.j(xmlPullParser, "valueTo")) {
            if (g8 == 4) {
                g8 = f(typedArray, 5, 6);
            }
            PropertyValuesHolder e6 = e(typedArray, g8, 5, 6, HttpUrl.FRAGMENT_ENCODE_SET);
            if (e6 != null) {
                valueAnimator.setValues(e6);
            }
        }
        valueAnimator.setDuration(g6);
        valueAnimator.setStartDelay(g7);
        valueAnimator.setRepeatCount(v.h.g(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(v.h.g(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            r(valueAnimator, typedArray2, g8, f6, xmlPullParser);
        }
    }

    private static void r(ValueAnimator valueAnimator, TypedArray typedArray, int i6, float f6, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String i7 = v.h.i(typedArray, xmlPullParser, "pathData", 1);
        if (i7 == null) {
            objectAnimator.setPropertyName(v.h.i(typedArray, xmlPullParser, "propertyName", 0));
            return;
        }
        String i8 = v.h.i(typedArray, xmlPullParser, "propertyXName", 2);
        String i9 = v.h.i(typedArray, xmlPullParser, "propertyYName", 3);
        if (i6 != 2) {
        }
        if (i8 != null || i9 != null) {
            s(h.e(i7), objectAnimator, f6 * 0.5f, i8, i9);
            return;
        }
        throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    }

    private static void s(Path path, ObjectAnimator objectAnimator, float f6, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f7 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float f8 = 0.0f;
        do {
            f8 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f8));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f8 / f6)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f9 = f8 / (min - 1);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= min) {
                break;
            }
            pathMeasure2.getPosTan(f7 - ((Float) arrayList.get(i7)).floatValue(), fArr3, null);
            fArr[i6] = fArr3[0];
            fArr2[i6] = fArr3[1];
            f7 += f9;
            int i8 = i7 + 1;
            if (i8 < arrayList.size() && f7 > ((Float) arrayList.get(i8)).floatValue()) {
                pathMeasure2.nextContour();
                i7 = i8;
            }
            i6++;
        }
        PropertyValuesHolder ofFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder ofFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (ofFloat == null) {
            objectAnimator.setValues(ofFloat2);
        } else if (ofFloat2 == null) {
            objectAnimator.setValues(ofFloat);
        } else {
            objectAnimator.setValues(ofFloat, ofFloat2);
        }
    }
}
