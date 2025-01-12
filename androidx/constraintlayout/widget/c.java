package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f1257a;

    /* renamed from: b  reason: collision with root package name */
    int f1258b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f1259c = -1;

    /* renamed from: d  reason: collision with root package name */
    private SparseArray f1260d = new SparseArray();

    /* renamed from: e  reason: collision with root package name */
    private SparseArray f1261e = new SparseArray();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1262a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList f1263b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        int f1264c;

        /* renamed from: d  reason: collision with root package name */
        d f1265d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f1264c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), g.f1448q4);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == g.f1454r4) {
                    this.f1262a = obtainStyledAttributes.getResourceId(index, this.f1262a);
                } else if (index == g.f1460s4) {
                    this.f1264c = obtainStyledAttributes.getResourceId(index, this.f1264c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1264c);
                    context.getResources().getResourceName(this.f1264c);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f1265d = dVar;
                        dVar.f(context, this.f1264c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f1263b.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        float f1266a;

        /* renamed from: b  reason: collision with root package name */
        float f1267b;

        /* renamed from: c  reason: collision with root package name */
        float f1268c;

        /* renamed from: d  reason: collision with root package name */
        float f1269d;

        /* renamed from: e  reason: collision with root package name */
        int f1270e;

        /* renamed from: f  reason: collision with root package name */
        d f1271f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f1266a = Float.NaN;
            this.f1267b = Float.NaN;
            this.f1268c = Float.NaN;
            this.f1269d = Float.NaN;
            this.f1270e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), g.M4);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == g.N4) {
                    this.f1270e = obtainStyledAttributes.getResourceId(index, this.f1270e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1270e);
                    context.getResources().getResourceName(this.f1270e);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f1271f = dVar;
                        dVar.f(context, this.f1270e);
                    }
                } else if (index == g.O4) {
                    this.f1269d = obtainStyledAttributes.getDimension(index, this.f1269d);
                } else if (index == g.P4) {
                    this.f1267b = obtainStyledAttributes.getDimension(index, this.f1267b);
                } else if (index == g.Q4) {
                    this.f1268c = obtainStyledAttributes.getDimension(index, this.f1268c);
                } else if (index == g.R4) {
                    this.f1266a = obtainStyledAttributes.getDimension(index, this.f1266a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, ConstraintLayout constraintLayout, int i6) {
        this.f1257a = constraintLayout;
        a(context, i6);
    }

    private void a(Context context, int i6) {
        char c6;
        XmlResourceParser xml = context.getResources().getXml(i6);
        try {
            a aVar = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c6 = 4;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c6 = 2;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c6 = 1;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c6 = 0;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c6 = 3;
                                break;
                            }
                            c6 = 65535;
                            break;
                        default:
                            c6 = 65535;
                            break;
                    }
                    if (c6 != 0 && c6 != 1) {
                        if (c6 == 2) {
                            aVar = new a(context, xml);
                            this.f1260d.put(aVar.f1262a, aVar);
                            continue;
                        } else if (c6 == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.a(bVar);
                                continue;
                            } else {
                                continue;
                            }
                        } else if (c6 != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            continue;
                        } else {
                            b(context, xml);
                            continue;
                        }
                    }
                }
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        } catch (XmlPullParserException e7) {
            e7.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        d dVar = new d();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i6 = 0; i6 < attributeCount; i6++) {
            if ("id".equals(xmlPullParser.getAttributeName(i6))) {
                String attributeValue = xmlPullParser.getAttributeValue(i6);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                dVar.m(context, xmlPullParser);
                this.f1261e.put(identifier, dVar);
                return;
            }
        }
    }

    public void c(e eVar) {
    }
}
