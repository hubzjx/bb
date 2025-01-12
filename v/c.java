package v;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public abstract class c {

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final C0219c[] f13628a;

        public b(C0219c[] c0219cArr) {
            this.f13628a = c0219cArr;
        }

        public C0219c[] a() {
            return this.f13628a;
        }
    }

    /* renamed from: v.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0219c {

        /* renamed from: a  reason: collision with root package name */
        private final String f13629a;

        /* renamed from: b  reason: collision with root package name */
        private int f13630b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f13631c;

        /* renamed from: d  reason: collision with root package name */
        private String f13632d;

        /* renamed from: e  reason: collision with root package name */
        private int f13633e;

        /* renamed from: f  reason: collision with root package name */
        private int f13634f;

        public C0219c(String str, int i6, boolean z5, String str2, int i7, int i8) {
            this.f13629a = str;
            this.f13630b = i6;
            this.f13631c = z5;
            this.f13632d = str2;
            this.f13633e = i7;
            this.f13634f = i8;
        }

        public String a() {
            return this.f13629a;
        }

        public int b() {
            return this.f13634f;
        }

        public int c() {
            return this.f13633e;
        }

        public String d() {
            return this.f13632d;
        }

        public int e() {
            return this.f13630b;
        }

        public boolean f() {
            return this.f13631c;
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        private final b0.d f13635a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13636b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13637c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13638d;

        public d(b0.d dVar, int i6, int i7, String str) {
            this.f13635a = dVar;
            this.f13637c = i6;
            this.f13636b = i7;
            this.f13638d = str;
        }

        public int a() {
            return this.f13637c;
        }

        public b0.d b() {
            return this.f13635a;
        }

        public String c() {
            return this.f13638d;
        }

        public int d() {
            return this.f13636b;
        }
    }

    private static int a(TypedArray typedArray, int i6) {
        return typedArray.getType(i6);
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i6) {
        if (i6 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i6);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i7 = 0; i7 < obtainTypedArray.length(); i7++) {
                    int resourceId = obtainTypedArray.getResourceId(i7, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i6)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static a d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static a e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), s.c.f13067e);
        String string = obtainAttributes.getString(s.c.f13068f);
        String string2 = obtainAttributes.getString(s.c.f13072j);
        String string3 = obtainAttributes.getString(s.c.f13073k);
        int resourceId = obtainAttributes.getResourceId(s.c.f13069g, 0);
        int integer = obtainAttributes.getInteger(s.c.f13070h, 1);
        int integer2 = obtainAttributes.getInteger(s.c.f13071i, 500);
        String string4 = obtainAttributes.getString(s.c.f13074l);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new d(new b0.d(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0219c[]) arrayList.toArray(new C0219c[arrayList.size()]));
    }

    private static C0219c f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), s.c.f13075m);
        int i6 = s.c.f13084v;
        if (!obtainAttributes.hasValue(i6)) {
            i6 = s.c.f13077o;
        }
        int i7 = obtainAttributes.getInt(i6, 400);
        int i8 = s.c.f13082t;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = s.c.f13078p;
        }
        boolean z5 = 1 == obtainAttributes.getInt(i8, 0);
        int i9 = s.c.f13085w;
        if (!obtainAttributes.hasValue(i9)) {
            i9 = s.c.f13079q;
        }
        int i10 = s.c.f13083u;
        if (!obtainAttributes.hasValue(i10)) {
            i10 = s.c.f13080r;
        }
        String string = obtainAttributes.getString(i10);
        int i11 = obtainAttributes.getInt(i9, 0);
        int i12 = s.c.f13081s;
        if (!obtainAttributes.hasValue(i12)) {
            i12 = s.c.f13076n;
        }
        int resourceId = obtainAttributes.getResourceId(i12, 0);
        String string2 = obtainAttributes.getString(i12);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0219c(string2, i7, z5, string, i11, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i6 = 1;
        while (i6 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i6++;
            } else if (next == 3) {
                i6--;
            }
        }
    }

    private static List h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
