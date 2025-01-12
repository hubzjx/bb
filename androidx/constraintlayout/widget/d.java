package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f1272d = {0, 4, 8};

    /* renamed from: e  reason: collision with root package name */
    private static SparseIntArray f1273e;

    /* renamed from: a  reason: collision with root package name */
    private HashMap f1274a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1275b = true;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f1276c = new HashMap();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1277a;

        /* renamed from: b  reason: collision with root package name */
        public final C0014d f1278b = new C0014d();

        /* renamed from: c  reason: collision with root package name */
        public final c f1279c = new c();

        /* renamed from: d  reason: collision with root package name */
        public final b f1280d = new b();

        /* renamed from: e  reason: collision with root package name */
        public final e f1281e = new e();

        /* renamed from: f  reason: collision with root package name */
        public HashMap f1282f = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        public void d(int i6, ConstraintLayout.b bVar) {
            this.f1277a = i6;
            b bVar2 = this.f1280d;
            bVar2.f1298h = bVar.f1197d;
            bVar2.f1300i = bVar.f1199e;
            bVar2.f1302j = bVar.f1201f;
            bVar2.f1304k = bVar.f1203g;
            bVar2.f1305l = bVar.f1205h;
            bVar2.f1306m = bVar.f1207i;
            bVar2.f1307n = bVar.f1209j;
            bVar2.f1308o = bVar.f1211k;
            bVar2.f1309p = bVar.f1213l;
            bVar2.f1310q = bVar.f1221p;
            bVar2.f1311r = bVar.f1222q;
            bVar2.f1312s = bVar.f1223r;
            bVar2.f1313t = bVar.f1224s;
            bVar2.f1314u = bVar.f1231z;
            bVar2.f1315v = bVar.A;
            bVar2.f1316w = bVar.B;
            bVar2.f1317x = bVar.f1215m;
            bVar2.f1318y = bVar.f1217n;
            bVar2.f1319z = bVar.f1219o;
            bVar2.A = bVar.Q;
            bVar2.B = bVar.R;
            bVar2.C = bVar.S;
            bVar2.f1296g = bVar.f1195c;
            bVar2.f1292e = bVar.f1191a;
            bVar2.f1294f = bVar.f1193b;
            bVar2.f1288c = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f1290d = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.D = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.E = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.F = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.G = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.P = bVar.F;
            bVar2.Q = bVar.E;
            bVar2.S = bVar.H;
            bVar2.R = bVar.G;
            bVar2.f1299h0 = bVar.T;
            bVar2.f1301i0 = bVar.U;
            bVar2.T = bVar.I;
            bVar2.U = bVar.J;
            bVar2.V = bVar.M;
            bVar2.W = bVar.N;
            bVar2.X = bVar.K;
            bVar2.Y = bVar.L;
            bVar2.Z = bVar.O;
            bVar2.f1285a0 = bVar.P;
            bVar2.f1297g0 = bVar.V;
            bVar2.K = bVar.f1226u;
            bVar2.M = bVar.f1228w;
            bVar2.J = bVar.f1225t;
            bVar2.L = bVar.f1227v;
            bVar2.O = bVar.f1229x;
            bVar2.N = bVar.f1230y;
            bVar2.H = bVar.getMarginEnd();
            this.f1280d.I = bVar.getMarginStart();
        }

        public void b(ConstraintLayout.b bVar) {
            b bVar2 = this.f1280d;
            bVar.f1197d = bVar2.f1298h;
            bVar.f1199e = bVar2.f1300i;
            bVar.f1201f = bVar2.f1302j;
            bVar.f1203g = bVar2.f1304k;
            bVar.f1205h = bVar2.f1305l;
            bVar.f1207i = bVar2.f1306m;
            bVar.f1209j = bVar2.f1307n;
            bVar.f1211k = bVar2.f1308o;
            bVar.f1213l = bVar2.f1309p;
            bVar.f1221p = bVar2.f1310q;
            bVar.f1222q = bVar2.f1311r;
            bVar.f1223r = bVar2.f1312s;
            bVar.f1224s = bVar2.f1313t;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.D;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.E;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.F;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.G;
            bVar.f1229x = bVar2.O;
            bVar.f1230y = bVar2.N;
            bVar.f1226u = bVar2.K;
            bVar.f1228w = bVar2.M;
            bVar.f1231z = bVar2.f1314u;
            bVar.A = bVar2.f1315v;
            bVar.f1215m = bVar2.f1317x;
            bVar.f1217n = bVar2.f1318y;
            bVar.f1219o = bVar2.f1319z;
            bVar.B = bVar2.f1316w;
            bVar.Q = bVar2.A;
            bVar.R = bVar2.B;
            bVar.F = bVar2.P;
            bVar.E = bVar2.Q;
            bVar.H = bVar2.S;
            bVar.G = bVar2.R;
            bVar.T = bVar2.f1299h0;
            bVar.U = bVar2.f1301i0;
            bVar.I = bVar2.T;
            bVar.J = bVar2.U;
            bVar.M = bVar2.V;
            bVar.N = bVar2.W;
            bVar.K = bVar2.X;
            bVar.L = bVar2.Y;
            bVar.O = bVar2.Z;
            bVar.P = bVar2.f1285a0;
            bVar.S = bVar2.C;
            bVar.f1195c = bVar2.f1296g;
            bVar.f1191a = bVar2.f1292e;
            bVar.f1193b = bVar2.f1294f;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f1288c;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f1290d;
            String str = bVar2.f1297g0;
            if (str != null) {
                bVar.V = str;
            }
            bVar.setMarginStart(bVar2.I);
            bVar.setMarginEnd(this.f1280d.H);
            bVar.a();
        }

        /* renamed from: c */
        public a clone() {
            a aVar = new a();
            aVar.f1280d.a(this.f1280d);
            aVar.f1279c.a(this.f1279c);
            aVar.f1278b.a(this.f1278b);
            aVar.f1281e.a(this.f1281e);
            aVar.f1277a = this.f1277a;
            return aVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: k0  reason: collision with root package name */
        private static SparseIntArray f1283k0;

        /* renamed from: c  reason: collision with root package name */
        public int f1288c;

        /* renamed from: d  reason: collision with root package name */
        public int f1290d;

        /* renamed from: e0  reason: collision with root package name */
        public int[] f1293e0;

        /* renamed from: f0  reason: collision with root package name */
        public String f1295f0;

        /* renamed from: g0  reason: collision with root package name */
        public String f1297g0;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1284a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1286b = false;

        /* renamed from: e  reason: collision with root package name */
        public int f1292e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f1294f = -1;

        /* renamed from: g  reason: collision with root package name */
        public float f1296g = -1.0f;

        /* renamed from: h  reason: collision with root package name */
        public int f1298h = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f1300i = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f1302j = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f1304k = -1;

        /* renamed from: l  reason: collision with root package name */
        public int f1305l = -1;

        /* renamed from: m  reason: collision with root package name */
        public int f1306m = -1;

        /* renamed from: n  reason: collision with root package name */
        public int f1307n = -1;

        /* renamed from: o  reason: collision with root package name */
        public int f1308o = -1;

        /* renamed from: p  reason: collision with root package name */
        public int f1309p = -1;

        /* renamed from: q  reason: collision with root package name */
        public int f1310q = -1;

        /* renamed from: r  reason: collision with root package name */
        public int f1311r = -1;

        /* renamed from: s  reason: collision with root package name */
        public int f1312s = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f1313t = -1;

        /* renamed from: u  reason: collision with root package name */
        public float f1314u = 0.5f;

        /* renamed from: v  reason: collision with root package name */
        public float f1315v = 0.5f;

        /* renamed from: w  reason: collision with root package name */
        public String f1316w = null;

        /* renamed from: x  reason: collision with root package name */
        public int f1317x = -1;

        /* renamed from: y  reason: collision with root package name */
        public int f1318y = 0;

        /* renamed from: z  reason: collision with root package name */
        public float f1319z = 0.0f;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public float P = -1.0f;
        public float Q = -1.0f;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = -1;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public float Z = 1.0f;

        /* renamed from: a0  reason: collision with root package name */
        public float f1285a0 = 1.0f;

        /* renamed from: b0  reason: collision with root package name */
        public int f1287b0 = -1;

        /* renamed from: c0  reason: collision with root package name */
        public int f1289c0 = 0;

        /* renamed from: d0  reason: collision with root package name */
        public int f1291d0 = -1;

        /* renamed from: h0  reason: collision with root package name */
        public boolean f1299h0 = false;

        /* renamed from: i0  reason: collision with root package name */
        public boolean f1301i0 = false;

        /* renamed from: j0  reason: collision with root package name */
        public boolean f1303j0 = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1283k0 = sparseIntArray;
            sparseIntArray.append(g.f1447q3, 24);
            f1283k0.append(g.f1453r3, 25);
            f1283k0.append(g.f1465t3, 28);
            f1283k0.append(g.f1471u3, 29);
            f1283k0.append(g.f1501z3, 35);
            f1283k0.append(g.f1495y3, 34);
            f1283k0.append(g.f1357b3, 4);
            f1283k0.append(g.f1351a3, 3);
            f1283k0.append(g.Y2, 1);
            f1283k0.append(g.E3, 6);
            f1283k0.append(g.F3, 7);
            f1283k0.append(g.f1399i3, 17);
            f1283k0.append(g.f1405j3, 18);
            f1283k0.append(g.f1411k3, 19);
            f1283k0.append(g.J2, 26);
            f1283k0.append(g.f1477v3, 31);
            f1283k0.append(g.f1483w3, 32);
            f1283k0.append(g.f1393h3, 10);
            f1283k0.append(g.f1387g3, 9);
            f1283k0.append(g.I3, 13);
            f1283k0.append(g.L3, 16);
            f1283k0.append(g.J3, 14);
            f1283k0.append(g.G3, 11);
            f1283k0.append(g.K3, 15);
            f1283k0.append(g.H3, 12);
            f1283k0.append(g.C3, 38);
            f1283k0.append(g.f1435o3, 37);
            f1283k0.append(g.f1429n3, 39);
            f1283k0.append(g.B3, 40);
            f1283k0.append(g.f1423m3, 20);
            f1283k0.append(g.A3, 36);
            f1283k0.append(g.f1381f3, 5);
            f1283k0.append(g.f1441p3, 76);
            f1283k0.append(g.f1489x3, 76);
            f1283k0.append(g.f1459s3, 76);
            f1283k0.append(g.Z2, 76);
            f1283k0.append(g.X2, 76);
            f1283k0.append(g.M2, 23);
            f1283k0.append(g.O2, 27);
            f1283k0.append(g.Q2, 30);
            f1283k0.append(g.R2, 8);
            f1283k0.append(g.N2, 33);
            f1283k0.append(g.P2, 2);
            f1283k0.append(g.K2, 22);
            f1283k0.append(g.L2, 21);
            f1283k0.append(g.f1363c3, 61);
            f1283k0.append(g.f1375e3, 62);
            f1283k0.append(g.f1369d3, 63);
            f1283k0.append(g.D3, 69);
            f1283k0.append(g.f1417l3, 70);
            f1283k0.append(g.V2, 71);
            f1283k0.append(g.T2, 72);
            f1283k0.append(g.U2, 73);
            f1283k0.append(g.W2, 74);
            f1283k0.append(g.S2, 75);
        }

        public void a(b bVar) {
            this.f1284a = bVar.f1284a;
            this.f1288c = bVar.f1288c;
            this.f1286b = bVar.f1286b;
            this.f1290d = bVar.f1290d;
            this.f1292e = bVar.f1292e;
            this.f1294f = bVar.f1294f;
            this.f1296g = bVar.f1296g;
            this.f1298h = bVar.f1298h;
            this.f1300i = bVar.f1300i;
            this.f1302j = bVar.f1302j;
            this.f1304k = bVar.f1304k;
            this.f1305l = bVar.f1305l;
            this.f1306m = bVar.f1306m;
            this.f1307n = bVar.f1307n;
            this.f1308o = bVar.f1308o;
            this.f1309p = bVar.f1309p;
            this.f1310q = bVar.f1310q;
            this.f1311r = bVar.f1311r;
            this.f1312s = bVar.f1312s;
            this.f1313t = bVar.f1313t;
            this.f1314u = bVar.f1314u;
            this.f1315v = bVar.f1315v;
            this.f1316w = bVar.f1316w;
            this.f1317x = bVar.f1317x;
            this.f1318y = bVar.f1318y;
            this.f1319z = bVar.f1319z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.f1285a0 = bVar.f1285a0;
            this.f1287b0 = bVar.f1287b0;
            this.f1289c0 = bVar.f1289c0;
            this.f1291d0 = bVar.f1291d0;
            this.f1297g0 = bVar.f1297g0;
            int[] iArr = bVar.f1293e0;
            if (iArr != null) {
                this.f1293e0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f1293e0 = null;
            }
            this.f1295f0 = bVar.f1295f0;
            this.f1299h0 = bVar.f1299h0;
            this.f1301i0 = bVar.f1301i0;
            this.f1303j0 = bVar.f1303j0;
        }

        void b(Context context, AttributeSet attributeSet) {
            StringBuilder sb;
            String str;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.I2);
            this.f1286b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                int i7 = f1283k0.get(index);
                if (i7 == 80) {
                    this.f1299h0 = obtainStyledAttributes.getBoolean(index, this.f1299h0);
                } else if (i7 != 81) {
                    switch (i7) {
                        case 1:
                            this.f1309p = d.n(obtainStyledAttributes, index, this.f1309p);
                            continue;
                        case 2:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            continue;
                        case 3:
                            this.f1308o = d.n(obtainStyledAttributes, index, this.f1308o);
                            continue;
                        case 4:
                            this.f1307n = d.n(obtainStyledAttributes, index, this.f1307n);
                            continue;
                        case 5:
                            this.f1316w = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.A = obtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                            continue;
                        case 7:
                            this.B = obtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            continue;
                        case 8:
                            this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            continue;
                        case 9:
                            this.f1313t = d.n(obtainStyledAttributes, index, this.f1313t);
                            continue;
                        case 10:
                            this.f1312s = d.n(obtainStyledAttributes, index, this.f1312s);
                            continue;
                        case 11:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        case 12:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        case 13:
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            continue;
                        case 14:
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            continue;
                        case 15:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            continue;
                        case 16:
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        case 17:
                            this.f1292e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1292e);
                            continue;
                        case 18:
                            this.f1294f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1294f);
                            continue;
                        case 19:
                            this.f1296g = obtainStyledAttributes.getFloat(index, this.f1296g);
                            continue;
                        case 20:
                            this.f1314u = obtainStyledAttributes.getFloat(index, this.f1314u);
                            continue;
                        case 21:
                            this.f1290d = obtainStyledAttributes.getLayoutDimension(index, this.f1290d);
                            continue;
                        case 22:
                            this.f1288c = obtainStyledAttributes.getLayoutDimension(index, this.f1288c);
                            continue;
                        case 23:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            continue;
                        case 24:
                            this.f1298h = d.n(obtainStyledAttributes, index, this.f1298h);
                            continue;
                        case 25:
                            this.f1300i = d.n(obtainStyledAttributes, index, this.f1300i);
                            continue;
                        case 26:
                            this.C = obtainStyledAttributes.getInt(index, this.C);
                            continue;
                        case 27:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            continue;
                        case 28:
                            this.f1302j = d.n(obtainStyledAttributes, index, this.f1302j);
                            continue;
                        case 29:
                            this.f1304k = d.n(obtainStyledAttributes, index, this.f1304k);
                            continue;
                        case 30:
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            continue;
                        case 31:
                            this.f1310q = d.n(obtainStyledAttributes, index, this.f1310q);
                            continue;
                        case 32:
                            this.f1311r = d.n(obtainStyledAttributes, index, this.f1311r);
                            continue;
                        case 33:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            continue;
                        case 34:
                            this.f1306m = d.n(obtainStyledAttributes, index, this.f1306m);
                            continue;
                        case 35:
                            this.f1305l = d.n(obtainStyledAttributes, index, this.f1305l);
                            continue;
                        case 36:
                            this.f1315v = obtainStyledAttributes.getFloat(index, this.f1315v);
                            continue;
                        case 37:
                            this.Q = obtainStyledAttributes.getFloat(index, this.Q);
                            continue;
                        case 38:
                            this.P = obtainStyledAttributes.getFloat(index, this.P);
                            continue;
                        case 39:
                            this.R = obtainStyledAttributes.getInt(index, this.R);
                            continue;
                        case 40:
                            this.S = obtainStyledAttributes.getInt(index, this.S);
                            continue;
                        default:
                            switch (i7) {
                                case 54:
                                    this.T = obtainStyledAttributes.getInt(index, this.T);
                                    continue;
                                case 55:
                                    this.U = obtainStyledAttributes.getInt(index, this.U);
                                    continue;
                                case 56:
                                    this.V = obtainStyledAttributes.getDimensionPixelSize(index, this.V);
                                    continue;
                                case 57:
                                    this.W = obtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                    continue;
                                case 58:
                                    this.X = obtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                    continue;
                                case 59:
                                    this.Y = obtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                    continue;
                                default:
                                    switch (i7) {
                                        case 61:
                                            this.f1317x = d.n(obtainStyledAttributes, index, this.f1317x);
                                            continue;
                                        case 62:
                                            this.f1318y = obtainStyledAttributes.getDimensionPixelSize(index, this.f1318y);
                                            continue;
                                        case 63:
                                            this.f1319z = obtainStyledAttributes.getFloat(index, this.f1319z);
                                            continue;
                                        default:
                                            switch (i7) {
                                                case 69:
                                                    this.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.f1285a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    break;
                                                case 72:
                                                    this.f1287b0 = obtainStyledAttributes.getInt(index, this.f1287b0);
                                                    break;
                                                case 73:
                                                    this.f1289c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1289c0);
                                                    break;
                                                case 74:
                                                    this.f1295f0 = obtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.f1303j0 = obtainStyledAttributes.getBoolean(index, this.f1303j0);
                                                    break;
                                                case 76:
                                                    sb = new StringBuilder();
                                                    str = "unused attribute 0x";
                                                    sb.append(str);
                                                    sb.append(Integer.toHexString(index));
                                                    sb.append("   ");
                                                    sb.append(f1283k0.get(index));
                                                    Log.w("ConstraintSet", sb.toString());
                                                    continue;
                                                    continue;
                                                    continue;
                                                case 77:
                                                    this.f1297g0 = obtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    sb = new StringBuilder();
                                                    str = "Unknown attribute 0x";
                                                    sb.append(str);
                                                    sb.append(Integer.toHexString(index));
                                                    sb.append("   ");
                                                    sb.append(f1283k0.get(index));
                                                    Log.w("ConstraintSet", sb.toString());
                                                    continue;
                                                    continue;
                                                    continue;
                                            }
                                    }
                            }
                    }
                } else {
                    this.f1301i0 = obtainStyledAttributes.getBoolean(index, this.f1301i0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: h  reason: collision with root package name */
        private static SparseIntArray f1320h;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1321a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f1322b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f1323c = null;

        /* renamed from: d  reason: collision with root package name */
        public int f1324d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f1325e = 0;

        /* renamed from: f  reason: collision with root package name */
        public float f1326f = Float.NaN;

        /* renamed from: g  reason: collision with root package name */
        public float f1327g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1320h = sparseIntArray;
            sparseIntArray.append(g.W3, 1);
            f1320h.append(g.Y3, 2);
            f1320h.append(g.Z3, 3);
            f1320h.append(g.V3, 4);
            f1320h.append(g.U3, 5);
            f1320h.append(g.X3, 6);
        }

        public void a(c cVar) {
            this.f1321a = cVar.f1321a;
            this.f1322b = cVar.f1322b;
            this.f1323c = cVar.f1323c;
            this.f1324d = cVar.f1324d;
            this.f1325e = cVar.f1325e;
            this.f1327g = cVar.f1327g;
            this.f1326f = cVar.f1326f;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.T3);
            this.f1321a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                switch (f1320h.get(index)) {
                    case 1:
                        this.f1327g = obtainStyledAttributes.getFloat(index, this.f1327g);
                        break;
                    case 2:
                        this.f1324d = obtainStyledAttributes.getInt(index, this.f1324d);
                        break;
                    case 3:
                        this.f1323c = obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : m.a.f11937c[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.f1325e = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f1322b = d.n(obtainStyledAttributes, index, this.f1322b);
                        break;
                    case 6:
                        this.f1326f = obtainStyledAttributes.getFloat(index, this.f1326f);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1328a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f1329b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f1330c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f1331d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1332e = Float.NaN;

        public void a(C0014d c0014d) {
            this.f1328a = c0014d.f1328a;
            this.f1329b = c0014d.f1329b;
            this.f1331d = c0014d.f1331d;
            this.f1332e = c0014d.f1332e;
            this.f1330c = c0014d.f1330c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f1400i4);
            this.f1328a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == g.f1412k4) {
                    this.f1331d = obtainStyledAttributes.getFloat(index, this.f1331d);
                } else if (index == g.f1406j4) {
                    this.f1329b = obtainStyledAttributes.getInt(index, this.f1329b);
                    this.f1329b = d.f1272d[this.f1329b];
                } else if (index == g.f1424m4) {
                    this.f1330c = obtainStyledAttributes.getInt(index, this.f1330c);
                } else if (index == g.f1418l4) {
                    this.f1332e = obtainStyledAttributes.getFloat(index, this.f1332e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: n  reason: collision with root package name */
        private static SparseIntArray f1333n;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1334a = false;

        /* renamed from: b  reason: collision with root package name */
        public float f1335b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f1336c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f1337d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1338e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f1339f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f1340g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f1341h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public float f1342i = 0.0f;

        /* renamed from: j  reason: collision with root package name */
        public float f1343j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f1344k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public boolean f1345l = false;

        /* renamed from: m  reason: collision with root package name */
        public float f1346m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1333n = sparseIntArray;
            sparseIntArray.append(g.G4, 1);
            f1333n.append(g.H4, 2);
            f1333n.append(g.I4, 3);
            f1333n.append(g.E4, 4);
            f1333n.append(g.F4, 5);
            f1333n.append(g.A4, 6);
            f1333n.append(g.B4, 7);
            f1333n.append(g.C4, 8);
            f1333n.append(g.D4, 9);
            f1333n.append(g.J4, 10);
            f1333n.append(g.K4, 11);
        }

        public void a(e eVar) {
            this.f1334a = eVar.f1334a;
            this.f1335b = eVar.f1335b;
            this.f1336c = eVar.f1336c;
            this.f1337d = eVar.f1337d;
            this.f1338e = eVar.f1338e;
            this.f1339f = eVar.f1339f;
            this.f1340g = eVar.f1340g;
            this.f1341h = eVar.f1341h;
            this.f1342i = eVar.f1342i;
            this.f1343j = eVar.f1343j;
            this.f1344k = eVar.f1344k;
            this.f1345l = eVar.f1345l;
            this.f1346m = eVar.f1346m;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f1502z4);
            this.f1334a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                switch (f1333n.get(index)) {
                    case 1:
                        this.f1335b = obtainStyledAttributes.getFloat(index, this.f1335b);
                        break;
                    case 2:
                        this.f1336c = obtainStyledAttributes.getFloat(index, this.f1336c);
                        break;
                    case 3:
                        this.f1337d = obtainStyledAttributes.getFloat(index, this.f1337d);
                        break;
                    case 4:
                        this.f1338e = obtainStyledAttributes.getFloat(index, this.f1338e);
                        break;
                    case 5:
                        this.f1339f = obtainStyledAttributes.getFloat(index, this.f1339f);
                        break;
                    case 6:
                        this.f1340g = obtainStyledAttributes.getDimension(index, this.f1340g);
                        break;
                    case 7:
                        this.f1341h = obtainStyledAttributes.getDimension(index, this.f1341h);
                        break;
                    case 8:
                        this.f1342i = obtainStyledAttributes.getDimension(index, this.f1342i);
                        break;
                    case 9:
                        this.f1343j = obtainStyledAttributes.getDimension(index, this.f1343j);
                        break;
                    case 10:
                        this.f1344k = obtainStyledAttributes.getDimension(index, this.f1344k);
                        break;
                    case 11:
                        this.f1345l = true;
                        this.f1346m = obtainStyledAttributes.getDimension(index, this.f1346m);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1273e = sparseIntArray;
        sparseIntArray.append(g.f1468u0, 25);
        f1273e.append(g.f1474v0, 26);
        f1273e.append(g.f1486x0, 29);
        f1273e.append(g.f1492y0, 30);
        f1273e.append(g.E0, 36);
        f1273e.append(g.D0, 35);
        f1273e.append(g.f1360c0, 4);
        f1273e.append(g.f1354b0, 3);
        f1273e.append(g.Z, 1);
        f1273e.append(g.M0, 6);
        f1273e.append(g.N0, 7);
        f1273e.append(g.f1402j0, 17);
        f1273e.append(g.f1408k0, 18);
        f1273e.append(g.f1414l0, 19);
        f1273e.append(g.f1455s, 27);
        f1273e.append(g.f1498z0, 32);
        f1273e.append(g.A0, 33);
        f1273e.append(g.f1396i0, 10);
        f1273e.append(g.f1390h0, 9);
        f1273e.append(g.Q0, 13);
        f1273e.append(g.T0, 16);
        f1273e.append(g.R0, 14);
        f1273e.append(g.O0, 11);
        f1273e.append(g.S0, 15);
        f1273e.append(g.P0, 12);
        f1273e.append(g.H0, 40);
        f1273e.append(g.f1456s0, 39);
        f1273e.append(g.f1450r0, 41);
        f1273e.append(g.G0, 42);
        f1273e.append(g.f1444q0, 20);
        f1273e.append(g.F0, 37);
        f1273e.append(g.f1384g0, 5);
        f1273e.append(g.f1462t0, 82);
        f1273e.append(g.C0, 82);
        f1273e.append(g.f1480w0, 82);
        f1273e.append(g.f1348a0, 82);
        f1273e.append(g.Y, 82);
        f1273e.append(g.f1485x, 24);
        f1273e.append(g.f1497z, 28);
        f1273e.append(g.L, 31);
        f1273e.append(g.M, 8);
        f1273e.append(g.f1491y, 34);
        f1273e.append(g.A, 2);
        f1273e.append(g.f1473v, 23);
        f1273e.append(g.f1479w, 21);
        f1273e.append(g.f1467u, 22);
        f1273e.append(g.B, 43);
        f1273e.append(g.O, 44);
        f1273e.append(g.J, 45);
        f1273e.append(g.K, 46);
        f1273e.append(g.I, 60);
        f1273e.append(g.G, 47);
        f1273e.append(g.H, 48);
        f1273e.append(g.C, 49);
        f1273e.append(g.D, 50);
        f1273e.append(g.E, 51);
        f1273e.append(g.F, 52);
        f1273e.append(g.N, 53);
        f1273e.append(g.I0, 54);
        f1273e.append(g.f1420m0, 55);
        f1273e.append(g.J0, 56);
        f1273e.append(g.f1426n0, 57);
        f1273e.append(g.K0, 58);
        f1273e.append(g.f1432o0, 59);
        f1273e.append(g.f1366d0, 61);
        f1273e.append(g.f1378f0, 62);
        f1273e.append(g.f1372e0, 63);
        f1273e.append(g.P, 64);
        f1273e.append(g.X0, 65);
        f1273e.append(g.V, 66);
        f1273e.append(g.Y0, 67);
        f1273e.append(g.V0, 79);
        f1273e.append(g.f1461t, 38);
        f1273e.append(g.U0, 68);
        f1273e.append(g.L0, 69);
        f1273e.append(g.f1438p0, 70);
        f1273e.append(g.T, 71);
        f1273e.append(g.R, 72);
        f1273e.append(g.S, 73);
        f1273e.append(g.U, 74);
        f1273e.append(g.Q, 75);
        f1273e.append(g.W0, 76);
        f1273e.append(g.B0, 77);
        f1273e.append(g.Z0, 78);
        f1273e.append(g.X, 80);
        f1273e.append(g.W, 81);
    }

    private int[] i(View view, String str) {
        int i6;
        Object f6;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i7 = 0;
        int i8 = 0;
        while (i7 < split.length) {
            String trim = split[i7].trim();
            try {
                i6 = f.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i6 = 0;
            }
            if (i6 == 0) {
                i6 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i6 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (f6 = ((ConstraintLayout) view.getParent()).f(0, trim)) != null && (f6 instanceof Integer)) {
                i6 = ((Integer) f6).intValue();
            }
            iArr[i8] = i6;
            i7++;
            i8++;
        }
        return i8 != split.length ? Arrays.copyOf(iArr, i8) : iArr;
    }

    private a j(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f1449r);
        o(context, aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private a k(int i6) {
        if (!this.f1276c.containsKey(Integer.valueOf(i6))) {
            this.f1276c.put(Integer.valueOf(i6), new a());
        }
        return (a) this.f1276c.get(Integer.valueOf(i6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(TypedArray typedArray, int i6, int i7) {
        int resourceId = typedArray.getResourceId(i6, i7);
        return resourceId == -1 ? typedArray.getInt(i6, -1) : resourceId;
    }

    private void o(Context context, a aVar, TypedArray typedArray) {
        c cVar;
        String str;
        StringBuilder sb;
        String str2;
        int indexCount = typedArray.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArray.getIndex(i6);
            if (index != g.f1461t && g.L != index && g.M != index) {
                aVar.f1279c.f1321a = true;
                aVar.f1280d.f1286b = true;
                aVar.f1278b.f1328a = true;
                aVar.f1281e.f1334a = true;
            }
            switch (f1273e.get(index)) {
                case 1:
                    b bVar = aVar.f1280d;
                    bVar.f1309p = n(typedArray, index, bVar.f1309p);
                    continue;
                case 2:
                    b bVar2 = aVar.f1280d;
                    bVar2.G = typedArray.getDimensionPixelSize(index, bVar2.G);
                    continue;
                case 3:
                    b bVar3 = aVar.f1280d;
                    bVar3.f1308o = n(typedArray, index, bVar3.f1308o);
                    continue;
                case 4:
                    b bVar4 = aVar.f1280d;
                    bVar4.f1307n = n(typedArray, index, bVar4.f1307n);
                    continue;
                case 5:
                    aVar.f1280d.f1316w = typedArray.getString(index);
                    continue;
                case 6:
                    b bVar5 = aVar.f1280d;
                    bVar5.A = typedArray.getDimensionPixelOffset(index, bVar5.A);
                    continue;
                case 7:
                    b bVar6 = aVar.f1280d;
                    bVar6.B = typedArray.getDimensionPixelOffset(index, bVar6.B);
                    continue;
                case 8:
                    b bVar7 = aVar.f1280d;
                    bVar7.H = typedArray.getDimensionPixelSize(index, bVar7.H);
                    continue;
                case 9:
                    b bVar8 = aVar.f1280d;
                    bVar8.f1313t = n(typedArray, index, bVar8.f1313t);
                    continue;
                case 10:
                    b bVar9 = aVar.f1280d;
                    bVar9.f1312s = n(typedArray, index, bVar9.f1312s);
                    continue;
                case 11:
                    b bVar10 = aVar.f1280d;
                    bVar10.M = typedArray.getDimensionPixelSize(index, bVar10.M);
                    continue;
                case 12:
                    b bVar11 = aVar.f1280d;
                    bVar11.N = typedArray.getDimensionPixelSize(index, bVar11.N);
                    continue;
                case 13:
                    b bVar12 = aVar.f1280d;
                    bVar12.J = typedArray.getDimensionPixelSize(index, bVar12.J);
                    continue;
                case 14:
                    b bVar13 = aVar.f1280d;
                    bVar13.L = typedArray.getDimensionPixelSize(index, bVar13.L);
                    continue;
                case 15:
                    b bVar14 = aVar.f1280d;
                    bVar14.O = typedArray.getDimensionPixelSize(index, bVar14.O);
                    continue;
                case 16:
                    b bVar15 = aVar.f1280d;
                    bVar15.K = typedArray.getDimensionPixelSize(index, bVar15.K);
                    continue;
                case 17:
                    b bVar16 = aVar.f1280d;
                    bVar16.f1292e = typedArray.getDimensionPixelOffset(index, bVar16.f1292e);
                    continue;
                case 18:
                    b bVar17 = aVar.f1280d;
                    bVar17.f1294f = typedArray.getDimensionPixelOffset(index, bVar17.f1294f);
                    continue;
                case 19:
                    b bVar18 = aVar.f1280d;
                    bVar18.f1296g = typedArray.getFloat(index, bVar18.f1296g);
                    continue;
                case 20:
                    b bVar19 = aVar.f1280d;
                    bVar19.f1314u = typedArray.getFloat(index, bVar19.f1314u);
                    continue;
                case 21:
                    b bVar20 = aVar.f1280d;
                    bVar20.f1290d = typedArray.getLayoutDimension(index, bVar20.f1290d);
                    continue;
                case 22:
                    C0014d c0014d = aVar.f1278b;
                    c0014d.f1329b = typedArray.getInt(index, c0014d.f1329b);
                    C0014d c0014d2 = aVar.f1278b;
                    c0014d2.f1329b = f1272d[c0014d2.f1329b];
                    continue;
                case 23:
                    b bVar21 = aVar.f1280d;
                    bVar21.f1288c = typedArray.getLayoutDimension(index, bVar21.f1288c);
                    continue;
                case 24:
                    b bVar22 = aVar.f1280d;
                    bVar22.D = typedArray.getDimensionPixelSize(index, bVar22.D);
                    continue;
                case 25:
                    b bVar23 = aVar.f1280d;
                    bVar23.f1298h = n(typedArray, index, bVar23.f1298h);
                    continue;
                case 26:
                    b bVar24 = aVar.f1280d;
                    bVar24.f1300i = n(typedArray, index, bVar24.f1300i);
                    continue;
                case 27:
                    b bVar25 = aVar.f1280d;
                    bVar25.C = typedArray.getInt(index, bVar25.C);
                    continue;
                case 28:
                    b bVar26 = aVar.f1280d;
                    bVar26.E = typedArray.getDimensionPixelSize(index, bVar26.E);
                    continue;
                case 29:
                    b bVar27 = aVar.f1280d;
                    bVar27.f1302j = n(typedArray, index, bVar27.f1302j);
                    continue;
                case 30:
                    b bVar28 = aVar.f1280d;
                    bVar28.f1304k = n(typedArray, index, bVar28.f1304k);
                    continue;
                case 31:
                    b bVar29 = aVar.f1280d;
                    bVar29.I = typedArray.getDimensionPixelSize(index, bVar29.I);
                    continue;
                case 32:
                    b bVar30 = aVar.f1280d;
                    bVar30.f1310q = n(typedArray, index, bVar30.f1310q);
                    continue;
                case 33:
                    b bVar31 = aVar.f1280d;
                    bVar31.f1311r = n(typedArray, index, bVar31.f1311r);
                    continue;
                case 34:
                    b bVar32 = aVar.f1280d;
                    bVar32.F = typedArray.getDimensionPixelSize(index, bVar32.F);
                    continue;
                case 35:
                    b bVar33 = aVar.f1280d;
                    bVar33.f1306m = n(typedArray, index, bVar33.f1306m);
                    continue;
                case 36:
                    b bVar34 = aVar.f1280d;
                    bVar34.f1305l = n(typedArray, index, bVar34.f1305l);
                    continue;
                case 37:
                    b bVar35 = aVar.f1280d;
                    bVar35.f1315v = typedArray.getFloat(index, bVar35.f1315v);
                    continue;
                case 38:
                    aVar.f1277a = typedArray.getResourceId(index, aVar.f1277a);
                    continue;
                case 39:
                    b bVar36 = aVar.f1280d;
                    bVar36.Q = typedArray.getFloat(index, bVar36.Q);
                    continue;
                case 40:
                    b bVar37 = aVar.f1280d;
                    bVar37.P = typedArray.getFloat(index, bVar37.P);
                    continue;
                case 41:
                    b bVar38 = aVar.f1280d;
                    bVar38.R = typedArray.getInt(index, bVar38.R);
                    continue;
                case 42:
                    b bVar39 = aVar.f1280d;
                    bVar39.S = typedArray.getInt(index, bVar39.S);
                    continue;
                case 43:
                    C0014d c0014d3 = aVar.f1278b;
                    c0014d3.f1331d = typedArray.getFloat(index, c0014d3.f1331d);
                    continue;
                case 44:
                    e eVar = aVar.f1281e;
                    eVar.f1345l = true;
                    eVar.f1346m = typedArray.getDimension(index, eVar.f1346m);
                    continue;
                case 45:
                    e eVar2 = aVar.f1281e;
                    eVar2.f1336c = typedArray.getFloat(index, eVar2.f1336c);
                    continue;
                case 46:
                    e eVar3 = aVar.f1281e;
                    eVar3.f1337d = typedArray.getFloat(index, eVar3.f1337d);
                    continue;
                case 47:
                    e eVar4 = aVar.f1281e;
                    eVar4.f1338e = typedArray.getFloat(index, eVar4.f1338e);
                    continue;
                case 48:
                    e eVar5 = aVar.f1281e;
                    eVar5.f1339f = typedArray.getFloat(index, eVar5.f1339f);
                    continue;
                case 49:
                    e eVar6 = aVar.f1281e;
                    eVar6.f1340g = typedArray.getDimension(index, eVar6.f1340g);
                    continue;
                case 50:
                    e eVar7 = aVar.f1281e;
                    eVar7.f1341h = typedArray.getDimension(index, eVar7.f1341h);
                    continue;
                case 51:
                    e eVar8 = aVar.f1281e;
                    eVar8.f1342i = typedArray.getDimension(index, eVar8.f1342i);
                    continue;
                case 52:
                    e eVar9 = aVar.f1281e;
                    eVar9.f1343j = typedArray.getDimension(index, eVar9.f1343j);
                    continue;
                case 53:
                    e eVar10 = aVar.f1281e;
                    eVar10.f1344k = typedArray.getDimension(index, eVar10.f1344k);
                    continue;
                case 54:
                    b bVar40 = aVar.f1280d;
                    bVar40.T = typedArray.getInt(index, bVar40.T);
                    continue;
                case 55:
                    b bVar41 = aVar.f1280d;
                    bVar41.U = typedArray.getInt(index, bVar41.U);
                    continue;
                case 56:
                    b bVar42 = aVar.f1280d;
                    bVar42.V = typedArray.getDimensionPixelSize(index, bVar42.V);
                    continue;
                case 57:
                    b bVar43 = aVar.f1280d;
                    bVar43.W = typedArray.getDimensionPixelSize(index, bVar43.W);
                    continue;
                case 58:
                    b bVar44 = aVar.f1280d;
                    bVar44.X = typedArray.getDimensionPixelSize(index, bVar44.X);
                    continue;
                case 59:
                    b bVar45 = aVar.f1280d;
                    bVar45.Y = typedArray.getDimensionPixelSize(index, bVar45.Y);
                    continue;
                case 60:
                    e eVar11 = aVar.f1281e;
                    eVar11.f1335b = typedArray.getFloat(index, eVar11.f1335b);
                    continue;
                case 61:
                    b bVar46 = aVar.f1280d;
                    bVar46.f1317x = n(typedArray, index, bVar46.f1317x);
                    continue;
                case 62:
                    b bVar47 = aVar.f1280d;
                    bVar47.f1318y = typedArray.getDimensionPixelSize(index, bVar47.f1318y);
                    continue;
                case 63:
                    b bVar48 = aVar.f1280d;
                    bVar48.f1319z = typedArray.getFloat(index, bVar48.f1319z);
                    continue;
                case 64:
                    c cVar2 = aVar.f1279c;
                    cVar2.f1322b = n(typedArray, index, cVar2.f1322b);
                    continue;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        cVar = aVar.f1279c;
                        str = typedArray.getString(index);
                    } else {
                        cVar = aVar.f1279c;
                        str = m.a.f11937c[typedArray.getInteger(index, 0)];
                    }
                    cVar.f1323c = str;
                    continue;
                case 66:
                    aVar.f1279c.f1325e = typedArray.getInt(index, 0);
                    continue;
                case 67:
                    c cVar3 = aVar.f1279c;
                    cVar3.f1327g = typedArray.getFloat(index, cVar3.f1327g);
                    continue;
                case 68:
                    C0014d c0014d4 = aVar.f1278b;
                    c0014d4.f1332e = typedArray.getFloat(index, c0014d4.f1332e);
                    continue;
                case 69:
                    aVar.f1280d.Z = typedArray.getFloat(index, 1.0f);
                    continue;
                case 70:
                    aVar.f1280d.f1285a0 = typedArray.getFloat(index, 1.0f);
                    continue;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    continue;
                case 72:
                    b bVar49 = aVar.f1280d;
                    bVar49.f1287b0 = typedArray.getInt(index, bVar49.f1287b0);
                    continue;
                case 73:
                    b bVar50 = aVar.f1280d;
                    bVar50.f1289c0 = typedArray.getDimensionPixelSize(index, bVar50.f1289c0);
                    continue;
                case 74:
                    aVar.f1280d.f1295f0 = typedArray.getString(index);
                    continue;
                case 75:
                    b bVar51 = aVar.f1280d;
                    bVar51.f1303j0 = typedArray.getBoolean(index, bVar51.f1303j0);
                    continue;
                case 76:
                    c cVar4 = aVar.f1279c;
                    cVar4.f1324d = typedArray.getInt(index, cVar4.f1324d);
                    continue;
                case 77:
                    aVar.f1280d.f1297g0 = typedArray.getString(index);
                    continue;
                case 78:
                    C0014d c0014d5 = aVar.f1278b;
                    c0014d5.f1330c = typedArray.getInt(index, c0014d5.f1330c);
                    continue;
                case 79:
                    c cVar5 = aVar.f1279c;
                    cVar5.f1326f = typedArray.getFloat(index, cVar5.f1326f);
                    continue;
                case 80:
                    b bVar52 = aVar.f1280d;
                    bVar52.f1299h0 = typedArray.getBoolean(index, bVar52.f1299h0);
                    continue;
                case 81:
                    b bVar53 = aVar.f1280d;
                    bVar53.f1301i0 = typedArray.getBoolean(index, bVar53.f1301i0);
                    continue;
                case 82:
                    sb = new StringBuilder();
                    str2 = "unused attribute 0x";
                    break;
                default:
                    sb = new StringBuilder();
                    str2 = "Unknown attribute 0x";
                    break;
            }
            sb.append(str2);
            sb.append(Integer.toHexString(index));
            sb.append("   ");
            sb.append(f1273e.get(index));
            Log.w("ConstraintSet", sb.toString());
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ConstraintLayout constraintLayout, boolean z5) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1276c.keySet());
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = constraintLayout.getChildAt(i6);
            int id = childAt.getId();
            if (!this.f1276c.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + n.a.a(childAt));
            } else if (this.f1275b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1) {
                    if (this.f1276c.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = (a) this.f1276c.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            aVar.f1280d.f1291d0 = 1;
                        }
                        int i7 = aVar.f1280d.f1291d0;
                        if (i7 != -1 && i7 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(aVar.f1280d.f1287b0);
                            barrier.setMargin(aVar.f1280d.f1289c0);
                            barrier.setAllowsGoneWidget(aVar.f1280d.f1303j0);
                            b bVar = aVar.f1280d;
                            int[] iArr = bVar.f1293e0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = bVar.f1295f0;
                                if (str != null) {
                                    bVar.f1293e0 = i(barrier, str);
                                    barrier.setReferencedIds(aVar.f1280d.f1293e0);
                                }
                            }
                        }
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                        bVar2.a();
                        aVar.b(bVar2);
                        if (z5) {
                            androidx.constraintlayout.widget.a.c(childAt, aVar.f1282f);
                        }
                        childAt.setLayoutParams(bVar2);
                        C0014d c0014d = aVar.f1278b;
                        if (c0014d.f1330c == 0) {
                            childAt.setVisibility(c0014d.f1329b);
                        }
                        childAt.setAlpha(aVar.f1278b.f1331d);
                        childAt.setRotation(aVar.f1281e.f1335b);
                        childAt.setRotationX(aVar.f1281e.f1336c);
                        childAt.setRotationY(aVar.f1281e.f1337d);
                        childAt.setScaleX(aVar.f1281e.f1338e);
                        childAt.setScaleY(aVar.f1281e.f1339f);
                        if (!Float.isNaN(aVar.f1281e.f1340g)) {
                            childAt.setPivotX(aVar.f1281e.f1340g);
                        }
                        if (!Float.isNaN(aVar.f1281e.f1341h)) {
                            childAt.setPivotY(aVar.f1281e.f1341h);
                        }
                        childAt.setTranslationX(aVar.f1281e.f1342i);
                        childAt.setTranslationY(aVar.f1281e.f1343j);
                        childAt.setTranslationZ(aVar.f1281e.f1344k);
                        e eVar = aVar.f1281e;
                        if (eVar.f1345l) {
                            childAt.setElevation(eVar.f1346m);
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = (a) this.f1276c.get(num);
            int i8 = aVar2.f1280d.f1291d0;
            if (i8 != -1 && i8 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar3 = aVar2.f1280d;
                int[] iArr2 = bVar3.f1293e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = bVar3.f1295f0;
                    if (str2 != null) {
                        bVar3.f1293e0 = i(barrier2, str2);
                        barrier2.setReferencedIds(aVar2.f1280d.f1293e0);
                    }
                }
                barrier2.setType(aVar2.f1280d.f1287b0);
                barrier2.setMargin(aVar2.f1280d.f1289c0);
                ConstraintLayout.b generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.k();
                aVar2.b(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (aVar2.f1280d.f1284a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.b generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                aVar2.b(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public void e(int i6, int i7) {
        if (this.f1276c.containsKey(Integer.valueOf(i6))) {
            a aVar = (a) this.f1276c.get(Integer.valueOf(i6));
            switch (i7) {
                case 1:
                    b bVar = aVar.f1280d;
                    bVar.f1300i = -1;
                    bVar.f1298h = -1;
                    bVar.D = -1;
                    bVar.J = -1;
                    return;
                case 2:
                    b bVar2 = aVar.f1280d;
                    bVar2.f1304k = -1;
                    bVar2.f1302j = -1;
                    bVar2.E = -1;
                    bVar2.L = -1;
                    return;
                case 3:
                    b bVar3 = aVar.f1280d;
                    bVar3.f1306m = -1;
                    bVar3.f1305l = -1;
                    bVar3.F = -1;
                    bVar3.K = -1;
                    return;
                case 4:
                    b bVar4 = aVar.f1280d;
                    bVar4.f1307n = -1;
                    bVar4.f1308o = -1;
                    bVar4.G = -1;
                    bVar4.M = -1;
                    return;
                case 5:
                    aVar.f1280d.f1309p = -1;
                    return;
                case 6:
                    b bVar5 = aVar.f1280d;
                    bVar5.f1310q = -1;
                    bVar5.f1311r = -1;
                    bVar5.I = -1;
                    bVar5.O = -1;
                    return;
                case 7:
                    b bVar6 = aVar.f1280d;
                    bVar6.f1312s = -1;
                    bVar6.f1313t = -1;
                    bVar6.H = -1;
                    bVar6.N = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void f(Context context, int i6) {
        g((ConstraintLayout) LayoutInflater.from(context).inflate(i6, (ViewGroup) null));
    }

    public void g(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f1276c.clear();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = constraintLayout.getChildAt(i6);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f1275b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f1276c.containsKey(Integer.valueOf(id))) {
                this.f1276c.put(Integer.valueOf(id), new a());
            }
            a aVar = (a) this.f1276c.get(Integer.valueOf(id));
            aVar.f1282f = androidx.constraintlayout.widget.a.a(this.f1274a, childAt);
            aVar.d(id, bVar);
            aVar.f1278b.f1329b = childAt.getVisibility();
            aVar.f1278b.f1331d = childAt.getAlpha();
            aVar.f1281e.f1335b = childAt.getRotation();
            aVar.f1281e.f1336c = childAt.getRotationX();
            aVar.f1281e.f1337d = childAt.getRotationY();
            aVar.f1281e.f1338e = childAt.getScaleX();
            aVar.f1281e.f1339f = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                e eVar = aVar.f1281e;
                eVar.f1340g = pivotX;
                eVar.f1341h = pivotY;
            }
            aVar.f1281e.f1342i = childAt.getTranslationX();
            aVar.f1281e.f1343j = childAt.getTranslationY();
            aVar.f1281e.f1344k = childAt.getTranslationZ();
            e eVar2 = aVar.f1281e;
            if (eVar2.f1345l) {
                eVar2.f1346m = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                aVar.f1280d.f1303j0 = barrier.l();
                aVar.f1280d.f1293e0 = barrier.getReferencedIds();
                aVar.f1280d.f1287b0 = barrier.getType();
                aVar.f1280d.f1289c0 = barrier.getMargin();
            }
        }
    }

    public void h(int i6, int i7, int i8, float f6) {
        b bVar = k(i6).f1280d;
        bVar.f1317x = i7;
        bVar.f1318y = i8;
        bVar.f1319z = f6;
    }

    public void l(Context context, int i6) {
        XmlResourceParser xml = context.getResources().getXml(i6);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    a j6 = j(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        j6.f1280d.f1284a = true;
                    }
                    this.f1276c.put(Integer.valueOf(j6.f1277a), j6);
                    continue;
                }
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        } catch (XmlPullParserException e7) {
            e7.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x0178, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(Context context, XmlPullParser xmlPullParser) {
        a j6;
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    char c6 = 3;
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case -2025855158:
                                if (name.equals("Layout")) {
                                    c6 = 5;
                                    break;
                                }
                                c6 = 65535;
                                break;
                            case -1984451626:
                                if (name.equals("Motion")) {
                                    c6 = 6;
                                    break;
                                }
                                c6 = 65535;
                                break;
                            case -1269513683:
                                if (name.equals("PropertySet")) {
                                    break;
                                }
                                c6 = 65535;
                                break;
                            case -1238332596:
                                if (name.equals("Transform")) {
                                    c6 = 4;
                                    break;
                                }
                                c6 = 65535;
                                break;
                            case -71750448:
                                if (name.equals("Guideline")) {
                                    c6 = 1;
                                    break;
                                }
                                c6 = 65535;
                                break;
                            case 1331510167:
                                if (name.equals("Barrier")) {
                                    c6 = 2;
                                    break;
                                }
                                c6 = 65535;
                                break;
                            case 1791837707:
                                if (name.equals("CustomAttribute")) {
                                    c6 = 7;
                                    break;
                                }
                                c6 = 65535;
                                break;
                            case 1803088381:
                                if (name.equals("Constraint")) {
                                    c6 = 0;
                                    break;
                                }
                                c6 = 65535;
                                break;
                            default:
                                c6 = 65535;
                                break;
                        }
                        switch (c6) {
                            case 0:
                                j6 = j(context, Xml.asAttributeSet(xmlPullParser));
                                aVar = j6;
                                break;
                            case 1:
                                j6 = j(context, Xml.asAttributeSet(xmlPullParser));
                                b bVar = j6.f1280d;
                                bVar.f1284a = true;
                                bVar.f1286b = true;
                                aVar = j6;
                                break;
                            case 2:
                                j6 = j(context, Xml.asAttributeSet(xmlPullParser));
                                j6.f1280d.f1291d0 = 1;
                                aVar = j6;
                                break;
                            case 3:
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                aVar.f1278b.b(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 4:
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                aVar.f1281e.b(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 5:
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                aVar.f1280d.b(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 6:
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                aVar.f1279c.b(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 7:
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                androidx.constraintlayout.widget.a.b(context, xmlPullParser, aVar.f1282f);
                                break;
                        }
                    } else if (eventType != 3) {
                        continue;
                    } else {
                        String name2 = xmlPullParser.getName();
                        if ("ConstraintSet".equals(name2)) {
                            return;
                        }
                        if (name2.equalsIgnoreCase("Constraint")) {
                            this.f1276c.put(Integer.valueOf(aVar.f1277a), aVar);
                            aVar = null;
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        } catch (XmlPullParserException e7) {
            e7.printStackTrace();
        }
    }
}
