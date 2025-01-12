package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.internal.http2.Http2Connection;
import p.d;
import p.e;
import q.b;
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    SparseArray f1167b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f1168c;

    /* renamed from: d  reason: collision with root package name */
    protected p.f f1169d;

    /* renamed from: e  reason: collision with root package name */
    private int f1170e;

    /* renamed from: f  reason: collision with root package name */
    private int f1171f;

    /* renamed from: g  reason: collision with root package name */
    private int f1172g;

    /* renamed from: h  reason: collision with root package name */
    private int f1173h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f1174i;

    /* renamed from: j  reason: collision with root package name */
    private int f1175j;

    /* renamed from: k  reason: collision with root package name */
    private d f1176k;

    /* renamed from: l  reason: collision with root package name */
    protected androidx.constraintlayout.widget.c f1177l;

    /* renamed from: m  reason: collision with root package name */
    private int f1178m;

    /* renamed from: n  reason: collision with root package name */
    private HashMap f1179n;

    /* renamed from: o  reason: collision with root package name */
    private int f1180o;

    /* renamed from: p  reason: collision with root package name */
    private int f1181p;

    /* renamed from: q  reason: collision with root package name */
    int f1182q;

    /* renamed from: r  reason: collision with root package name */
    int f1183r;

    /* renamed from: s  reason: collision with root package name */
    int f1184s;

    /* renamed from: t  reason: collision with root package name */
    int f1185t;

    /* renamed from: u  reason: collision with root package name */
    private SparseArray f1186u;

    /* renamed from: v  reason: collision with root package name */
    c f1187v;

    /* renamed from: w  reason: collision with root package name */
    private int f1188w;

    /* renamed from: x  reason: collision with root package name */
    private int f1189x;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1190a;

        static {
            int[] iArr = new int[e.b.values().length];
            f1190a = iArr;
            try {
                iArr[e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1190a[e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1190a[e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1190a[e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        float C;
        int D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public float O;
        public float P;
        public int Q;
        public int R;
        public int S;
        public boolean T;
        public boolean U;
        public String V;
        boolean W;
        boolean X;
        boolean Y;
        boolean Z;

        /* renamed from: a  reason: collision with root package name */
        public int f1191a;

        /* renamed from: a0  reason: collision with root package name */
        boolean f1192a0;

        /* renamed from: b  reason: collision with root package name */
        public int f1193b;

        /* renamed from: b0  reason: collision with root package name */
        boolean f1194b0;

        /* renamed from: c  reason: collision with root package name */
        public float f1195c;

        /* renamed from: c0  reason: collision with root package name */
        boolean f1196c0;

        /* renamed from: d  reason: collision with root package name */
        public int f1197d;

        /* renamed from: d0  reason: collision with root package name */
        int f1198d0;

        /* renamed from: e  reason: collision with root package name */
        public int f1199e;

        /* renamed from: e0  reason: collision with root package name */
        int f1200e0;

        /* renamed from: f  reason: collision with root package name */
        public int f1201f;

        /* renamed from: f0  reason: collision with root package name */
        int f1202f0;

        /* renamed from: g  reason: collision with root package name */
        public int f1203g;

        /* renamed from: g0  reason: collision with root package name */
        int f1204g0;

        /* renamed from: h  reason: collision with root package name */
        public int f1205h;

        /* renamed from: h0  reason: collision with root package name */
        int f1206h0;

        /* renamed from: i  reason: collision with root package name */
        public int f1207i;

        /* renamed from: i0  reason: collision with root package name */
        int f1208i0;

        /* renamed from: j  reason: collision with root package name */
        public int f1209j;

        /* renamed from: j0  reason: collision with root package name */
        float f1210j0;

        /* renamed from: k  reason: collision with root package name */
        public int f1211k;

        /* renamed from: k0  reason: collision with root package name */
        int f1212k0;

        /* renamed from: l  reason: collision with root package name */
        public int f1213l;

        /* renamed from: l0  reason: collision with root package name */
        int f1214l0;

        /* renamed from: m  reason: collision with root package name */
        public int f1215m;

        /* renamed from: m0  reason: collision with root package name */
        float f1216m0;

        /* renamed from: n  reason: collision with root package name */
        public int f1217n;

        /* renamed from: n0  reason: collision with root package name */
        p.e f1218n0;

        /* renamed from: o  reason: collision with root package name */
        public float f1219o;

        /* renamed from: o0  reason: collision with root package name */
        public boolean f1220o0;

        /* renamed from: p  reason: collision with root package name */
        public int f1221p;

        /* renamed from: q  reason: collision with root package name */
        public int f1222q;

        /* renamed from: r  reason: collision with root package name */
        public int f1223r;

        /* renamed from: s  reason: collision with root package name */
        public int f1224s;

        /* renamed from: t  reason: collision with root package name */
        public int f1225t;

        /* renamed from: u  reason: collision with root package name */
        public int f1226u;

        /* renamed from: v  reason: collision with root package name */
        public int f1227v;

        /* renamed from: w  reason: collision with root package name */
        public int f1228w;

        /* renamed from: x  reason: collision with root package name */
        public int f1229x;

        /* renamed from: y  reason: collision with root package name */
        public int f1230y;

        /* renamed from: z  reason: collision with root package name */
        public float f1231z;

        /* loaded from: classes.dex */
        private static class a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f1232a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f1232a = sparseIntArray;
                sparseIntArray.append(g.K1, 8);
                sparseIntArray.append(g.L1, 9);
                sparseIntArray.append(g.N1, 10);
                sparseIntArray.append(g.O1, 11);
                sparseIntArray.append(g.U1, 12);
                sparseIntArray.append(g.T1, 13);
                sparseIntArray.append(g.f1457s1, 14);
                sparseIntArray.append(g.f1451r1, 15);
                sparseIntArray.append(g.f1439p1, 16);
                sparseIntArray.append(g.f1463t1, 2);
                sparseIntArray.append(g.f1475v1, 3);
                sparseIntArray.append(g.f1469u1, 4);
                sparseIntArray.append(g.f1362c2, 49);
                sparseIntArray.append(g.f1368d2, 50);
                sparseIntArray.append(g.f1499z1, 5);
                sparseIntArray.append(g.A1, 6);
                sparseIntArray.append(g.B1, 7);
                sparseIntArray.append(g.f1355b1, 1);
                sparseIntArray.append(g.P1, 17);
                sparseIntArray.append(g.Q1, 18);
                sparseIntArray.append(g.f1493y1, 19);
                sparseIntArray.append(g.f1487x1, 20);
                sparseIntArray.append(g.f1386g2, 21);
                sparseIntArray.append(g.f1404j2, 22);
                sparseIntArray.append(g.f1392h2, 23);
                sparseIntArray.append(g.f1374e2, 24);
                sparseIntArray.append(g.f1398i2, 25);
                sparseIntArray.append(g.f1380f2, 26);
                sparseIntArray.append(g.G1, 29);
                sparseIntArray.append(g.V1, 30);
                sparseIntArray.append(g.f1481w1, 44);
                sparseIntArray.append(g.I1, 45);
                sparseIntArray.append(g.X1, 46);
                sparseIntArray.append(g.H1, 47);
                sparseIntArray.append(g.W1, 48);
                sparseIntArray.append(g.f1427n1, 27);
                sparseIntArray.append(g.f1421m1, 28);
                sparseIntArray.append(g.Y1, 31);
                sparseIntArray.append(g.C1, 32);
                sparseIntArray.append(g.f1350a2, 33);
                sparseIntArray.append(g.Z1, 34);
                sparseIntArray.append(g.f1356b2, 35);
                sparseIntArray.append(g.E1, 36);
                sparseIntArray.append(g.D1, 37);
                sparseIntArray.append(g.F1, 38);
                sparseIntArray.append(g.J1, 39);
                sparseIntArray.append(g.S1, 40);
                sparseIntArray.append(g.M1, 41);
                sparseIntArray.append(g.f1445q1, 42);
                sparseIntArray.append(g.f1433o1, 43);
                sparseIntArray.append(g.R1, 51);
            }
        }

        public b(int i6, int i7) {
            super(i6, i7);
            this.f1191a = -1;
            this.f1193b = -1;
            this.f1195c = -1.0f;
            this.f1197d = -1;
            this.f1199e = -1;
            this.f1201f = -1;
            this.f1203g = -1;
            this.f1205h = -1;
            this.f1207i = -1;
            this.f1209j = -1;
            this.f1211k = -1;
            this.f1213l = -1;
            this.f1215m = -1;
            this.f1217n = 0;
            this.f1219o = 0.0f;
            this.f1221p = -1;
            this.f1222q = -1;
            this.f1223r = -1;
            this.f1224s = -1;
            this.f1225t = -1;
            this.f1226u = -1;
            this.f1227v = -1;
            this.f1228w = -1;
            this.f1229x = -1;
            this.f1230y = -1;
            this.f1231z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.f1192a0 = false;
            this.f1194b0 = false;
            this.f1196c0 = false;
            this.f1198d0 = -1;
            this.f1200e0 = -1;
            this.f1202f0 = -1;
            this.f1204g0 = -1;
            this.f1206h0 = -1;
            this.f1208i0 = -1;
            this.f1210j0 = 0.5f;
            this.f1218n0 = new p.e();
            this.f1220o0 = false;
        }

        public void a() {
            this.Z = false;
            this.W = true;
            this.X = true;
            int i6 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i6 == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            int i7 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i7 == -2 && this.U) {
                this.X = false;
                if (this.J == 0) {
                    this.J = 1;
                }
            }
            if (i6 == 0 || i6 == -1) {
                this.W = false;
                if (i6 == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.T = true;
                }
            }
            if (i7 == 0 || i7 == -1) {
                this.X = false;
                if (i7 == 0 && this.J == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.U = true;
                }
            }
            if (this.f1195c == -1.0f && this.f1191a == -1 && this.f1193b == -1) {
                return;
            }
            this.Z = true;
            this.W = true;
            this.X = true;
            if (!(this.f1218n0 instanceof p.g)) {
                this.f1218n0 = new p.g();
            }
            ((p.g) this.f1218n0).N0(this.S);
        }

        /* JADX WARN: Code restructure failed: missing block: B:72:0x00ca, code lost:
            if (r1 > 0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x00cc, code lost:
            ((android.view.ViewGroup.MarginLayoutParams) r9).rightMargin = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x00d9, code lost:
            if (r1 > 0) goto L50;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x00eb  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void resolveLayoutDirection(int i6) {
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i13 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i6);
            boolean z5 = false;
            boolean z6 = 1 == getLayoutDirection();
            this.f1202f0 = -1;
            this.f1204g0 = -1;
            this.f1198d0 = -1;
            this.f1200e0 = -1;
            this.f1206h0 = this.f1225t;
            this.f1208i0 = this.f1227v;
            float f6 = this.f1231z;
            this.f1210j0 = f6;
            int i14 = this.f1191a;
            this.f1212k0 = i14;
            int i15 = this.f1193b;
            this.f1214l0 = i15;
            float f7 = this.f1195c;
            this.f1216m0 = f7;
            if (z6) {
                int i16 = this.f1221p;
                if (i16 != -1) {
                    this.f1202f0 = i16;
                } else {
                    int i17 = this.f1222q;
                    if (i17 != -1) {
                        this.f1204g0 = i17;
                    }
                    i8 = this.f1223r;
                    if (i8 != -1) {
                        this.f1200e0 = i8;
                        z5 = true;
                    }
                    i9 = this.f1224s;
                    if (i9 != -1) {
                        this.f1198d0 = i9;
                        z5 = true;
                    }
                    i10 = this.f1229x;
                    if (i10 != -1) {
                        this.f1208i0 = i10;
                    }
                    i11 = this.f1230y;
                    if (i11 != -1) {
                        this.f1206h0 = i11;
                    }
                    if (z5) {
                        this.f1210j0 = 1.0f - f6;
                    }
                    if (this.Z && this.S == 1) {
                        if (f7 == -1.0f) {
                            this.f1216m0 = 1.0f - f7;
                            this.f1212k0 = -1;
                            this.f1214l0 = -1;
                        } else {
                            if (i14 != -1) {
                                this.f1214l0 = i14;
                                this.f1212k0 = -1;
                            } else if (i15 != -1) {
                                this.f1212k0 = i15;
                                this.f1214l0 = -1;
                            }
                            this.f1216m0 = -1.0f;
                        }
                    }
                }
                z5 = true;
                i8 = this.f1223r;
                if (i8 != -1) {
                }
                i9 = this.f1224s;
                if (i9 != -1) {
                }
                i10 = this.f1229x;
                if (i10 != -1) {
                }
                i11 = this.f1230y;
                if (i11 != -1) {
                }
                if (z5) {
                }
                if (this.Z) {
                    if (f7 == -1.0f) {
                    }
                }
            } else {
                int i18 = this.f1221p;
                if (i18 != -1) {
                    this.f1200e0 = i18;
                }
                int i19 = this.f1222q;
                if (i19 != -1) {
                    this.f1198d0 = i19;
                }
                int i20 = this.f1223r;
                if (i20 != -1) {
                    this.f1202f0 = i20;
                }
                int i21 = this.f1224s;
                if (i21 != -1) {
                    this.f1204g0 = i21;
                }
                int i22 = this.f1229x;
                if (i22 != -1) {
                    this.f1206h0 = i22;
                }
                int i23 = this.f1230y;
                if (i23 != -1) {
                    this.f1208i0 = i23;
                }
            }
            if (this.f1223r == -1 && this.f1224s == -1 && this.f1222q == -1 && this.f1221p == -1) {
                int i24 = this.f1201f;
                if (i24 == -1) {
                    int i25 = this.f1203g;
                    if (i25 != -1) {
                        this.f1204g0 = i25;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0) {
                        }
                    }
                    i7 = this.f1197d;
                    if (i7 == -1) {
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i12;
                }
                this.f1202f0 = i24;
                if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0) {
                }
                i7 = this.f1197d;
                if (i7 == -1) {
                    this.f1198d0 = i7;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i12 <= 0) {
                        return;
                    }
                } else {
                    int i26 = this.f1199e;
                    if (i26 == -1) {
                        return;
                    }
                    this.f1200e0 = i26;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i12 <= 0) {
                        return;
                    }
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i12;
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            String str;
            int i6;
            float parseFloat;
            this.f1191a = -1;
            this.f1193b = -1;
            this.f1195c = -1.0f;
            this.f1197d = -1;
            this.f1199e = -1;
            this.f1201f = -1;
            this.f1203g = -1;
            this.f1205h = -1;
            this.f1207i = -1;
            this.f1209j = -1;
            this.f1211k = -1;
            this.f1213l = -1;
            this.f1215m = -1;
            this.f1217n = 0;
            this.f1219o = 0.0f;
            this.f1221p = -1;
            this.f1222q = -1;
            this.f1223r = -1;
            this.f1224s = -1;
            this.f1225t = -1;
            this.f1226u = -1;
            this.f1227v = -1;
            this.f1228w = -1;
            this.f1229x = -1;
            this.f1230y = -1;
            this.f1231z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.f1192a0 = false;
            this.f1194b0 = false;
            this.f1196c0 = false;
            this.f1198d0 = -1;
            this.f1200e0 = -1;
            this.f1202f0 = -1;
            this.f1204g0 = -1;
            this.f1206h0 = -1;
            this.f1208i0 = -1;
            this.f1210j0 = 0.5f;
            this.f1218n0 = new p.e();
            this.f1220o0 = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f1349a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                int i8 = a.f1232a.get(index);
                switch (i8) {
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        continue;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f1215m);
                        this.f1215m = resourceId;
                        if (resourceId == -1) {
                            this.f1215m = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 3:
                        this.f1217n = obtainStyledAttributes.getDimensionPixelSize(index, this.f1217n);
                        continue;
                    case 4:
                        float f6 = obtainStyledAttributes.getFloat(index, this.f1219o) % 360.0f;
                        this.f1219o = f6;
                        if (f6 < 0.0f) {
                            this.f1219o = (360.0f - f6) % 360.0f;
                        } else {
                            continue;
                        }
                    case 5:
                        this.f1191a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1191a);
                        continue;
                    case 6:
                        this.f1193b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1193b);
                        continue;
                    case 7:
                        this.f1195c = obtainStyledAttributes.getFloat(index, this.f1195c);
                        continue;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f1197d);
                        this.f1197d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f1197d = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f1199e);
                        this.f1199e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1199e = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f1201f);
                        this.f1201f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f1201f = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f1203g);
                        this.f1203g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f1203g = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f1205h);
                        this.f1205h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f1205h = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f1207i);
                        this.f1207i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f1207i = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f1209j);
                        this.f1209j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f1209j = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f1211k);
                        this.f1211k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f1211k = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f1213l);
                        this.f1213l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f1213l = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f1221p);
                        this.f1221p = resourceId11;
                        if (resourceId11 == -1) {
                            this.f1221p = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f1222q);
                        this.f1222q = resourceId12;
                        if (resourceId12 == -1) {
                            this.f1222q = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f1223r);
                        this.f1223r = resourceId13;
                        if (resourceId13 == -1) {
                            this.f1223r = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f1224s);
                        this.f1224s = resourceId14;
                        if (resourceId14 == -1) {
                            this.f1224s = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 21:
                        this.f1225t = obtainStyledAttributes.getDimensionPixelSize(index, this.f1225t);
                        continue;
                    case 22:
                        this.f1226u = obtainStyledAttributes.getDimensionPixelSize(index, this.f1226u);
                        continue;
                    case 23:
                        this.f1227v = obtainStyledAttributes.getDimensionPixelSize(index, this.f1227v);
                        continue;
                    case 24:
                        this.f1228w = obtainStyledAttributes.getDimensionPixelSize(index, this.f1228w);
                        continue;
                    case 25:
                        this.f1229x = obtainStyledAttributes.getDimensionPixelSize(index, this.f1229x);
                        continue;
                    case 26:
                        this.f1230y = obtainStyledAttributes.getDimensionPixelSize(index, this.f1230y);
                        continue;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        continue;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        continue;
                    case 29:
                        this.f1231z = obtainStyledAttributes.getFloat(index, this.f1231z);
                        continue;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        continue;
                    case 31:
                        int i9 = obtainStyledAttributes.getInt(index, 0);
                        this.I = i9;
                        if (i9 == 1) {
                            str = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
                            break;
                        } else {
                            continue;
                        }
                    case 32:
                        int i10 = obtainStyledAttributes.getInt(index, 0);
                        this.J = i10;
                        if (i10 == 1) {
                            str = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
                            break;
                        } else {
                            continue;
                        }
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        this.I = 2;
                        continue;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            continue;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        this.J = 2;
                        continue;
                    default:
                        switch (i8) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = Float.NaN;
                                this.D = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i6 = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.D = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.D = 1;
                                        }
                                        i6 = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.B.substring(i6, indexOf2);
                                        String substring3 = this.B.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat2 = Float.parseFloat(substring2);
                                                float parseFloat3 = Float.parseFloat(substring3);
                                                parseFloat = (parseFloat2 > 0.0f && parseFloat3 > 0.0f) ? this.D == 1 ? Math.abs(parseFloat3 / parseFloat2) : Math.abs(parseFloat2 / parseFloat3) : parseFloat;
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.B.substring(i6);
                                        if (substring4.length() <= 0) {
                                            break;
                                        } else {
                                            parseFloat = Float.parseFloat(substring4);
                                        }
                                    }
                                    this.C = parseFloat;
                                    break;
                                } else {
                                    continue;
                                }
                            case 45:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                continue;
                            case 46:
                                this.F = obtainStyledAttributes.getFloat(index, this.F);
                                continue;
                            case 47:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.H = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                continue;
                            case 50:
                                this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                                continue;
                            case 51:
                                this.V = obtainStyledAttributes.getString(index);
                                continue;
                                continue;
                        }
                        break;
                }
                Log.e("ConstraintLayout", str);
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1191a = -1;
            this.f1193b = -1;
            this.f1195c = -1.0f;
            this.f1197d = -1;
            this.f1199e = -1;
            this.f1201f = -1;
            this.f1203g = -1;
            this.f1205h = -1;
            this.f1207i = -1;
            this.f1209j = -1;
            this.f1211k = -1;
            this.f1213l = -1;
            this.f1215m = -1;
            this.f1217n = 0;
            this.f1219o = 0.0f;
            this.f1221p = -1;
            this.f1222q = -1;
            this.f1223r = -1;
            this.f1224s = -1;
            this.f1225t = -1;
            this.f1226u = -1;
            this.f1227v = -1;
            this.f1228w = -1;
            this.f1229x = -1;
            this.f1230y = -1;
            this.f1231z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.f1192a0 = false;
            this.f1194b0 = false;
            this.f1196c0 = false;
            this.f1198d0 = -1;
            this.f1200e0 = -1;
            this.f1202f0 = -1;
            this.f1204g0 = -1;
            this.f1206h0 = -1;
            this.f1208i0 = -1;
            this.f1210j0 = 0.5f;
            this.f1218n0 = new p.e();
            this.f1220o0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements b.InterfaceC0206b {

        /* renamed from: a  reason: collision with root package name */
        ConstraintLayout f1233a;

        /* renamed from: b  reason: collision with root package name */
        int f1234b;

        /* renamed from: c  reason: collision with root package name */
        int f1235c;

        /* renamed from: d  reason: collision with root package name */
        int f1236d;

        /* renamed from: e  reason: collision with root package name */
        int f1237e;

        /* renamed from: f  reason: collision with root package name */
        int f1238f;

        /* renamed from: g  reason: collision with root package name */
        int f1239g;

        public c(ConstraintLayout constraintLayout) {
            this.f1233a = constraintLayout;
        }

        @Override // q.b.InterfaceC0206b
        public final void a() {
            int childCount = this.f1233a.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                this.f1233a.getChildAt(i6);
            }
            int size = this.f1233a.f1168c.size();
            if (size > 0) {
                for (int i7 = 0; i7 < size; i7++) {
                    ((androidx.constraintlayout.widget.b) this.f1233a.f1168c.get(i7)).h(this.f1233a);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x0166 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:112:0x018c  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x0197  */
        /* JADX WARN: Removed duplicated region for block: B:115:0x01a3  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x01ad  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x01ba  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x01c4  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x01cc  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:130:0x01d6  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x01de A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:136:0x01eb A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:139:0x01f6 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:145:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:147:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x021e  */
        /* JADX WARN: Removed duplicated region for block: B:151:0x0220  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x0225  */
        /* JADX WARN: Removed duplicated region for block: B:161:0x0233  */
        /* JADX WARN: Removed duplicated region for block: B:162:0x0235  */
        /* JADX WARN: Removed duplicated region for block: B:164:0x0238  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x013d  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0148  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0153  */
        @Override // q.b.InterfaceC0206b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void b(p.e eVar, b.a aVar) {
            int i6;
            boolean z5;
            int i7;
            int makeMeasureSpec;
            boolean z6;
            boolean z7;
            boolean z8;
            int measuredWidth;
            int measuredHeight;
            int i8;
            int max;
            int i9;
            int max2;
            int i10;
            int measuredWidth2;
            int measuredHeight2;
            int baseline;
            int i11;
            boolean z9;
            int childMeasureSpec;
            int childMeasureSpec2;
            if (eVar == null) {
                return;
            }
            if (eVar.M() == 8 && !eVar.U()) {
                aVar.f12643e = 0;
                aVar.f12644f = 0;
                aVar.f12645g = 0;
                return;
            }
            e.b bVar = aVar.f12639a;
            e.b bVar2 = aVar.f12640b;
            int i12 = aVar.f12641c;
            int i13 = aVar.f12642d;
            int i14 = this.f1234b + this.f1235c;
            int i15 = this.f1236d;
            View view = (View) eVar.o();
            int[] iArr = a.f1190a;
            int i16 = iArr[bVar.ordinal()];
            if (i16 != 1) {
                if (i16 == 2) {
                    i6 = ViewGroup.getChildMeasureSpec(this.f1238f, i15, -2);
                    eVar.f12556h[2] = -2;
                } else if (i16 == 3) {
                    i6 = ViewGroup.getChildMeasureSpec(this.f1238f, i15 + eVar.x(), -1);
                    eVar.f12556h[2] = -1;
                } else if (i16 != 4) {
                    i6 = 0;
                } else {
                    i6 = ViewGroup.getChildMeasureSpec(this.f1238f, i15, -2);
                    boolean z10 = eVar.f12564l == 1;
                    int[] iArr2 = eVar.f12556h;
                    iArr2[2] = 0;
                    if (aVar.f12648j) {
                        boolean z11 = (!z10 || iArr2[3] == 0 || iArr2[0] == eVar.N()) ? false : true;
                        if (!z10 || z11) {
                            i6 = View.MeasureSpec.makeMeasureSpec(eVar.N(), 1073741824);
                        }
                    }
                }
                z5 = true;
                i7 = iArr[bVar2.ordinal()];
                if (i7 == 1) {
                    if (i7 != 2) {
                        if (i7 == 3) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f1239g, i14 + eVar.L(), -1);
                            eVar.f12556h[3] = -1;
                        } else if (i7 != 4) {
                            z6 = false;
                            makeMeasureSpec = 0;
                            e.b bVar3 = e.b.MATCH_CONSTRAINT;
                            boolean z12 = bVar != bVar3;
                            boolean z13 = bVar2 != bVar3;
                            e.b bVar4 = e.b.MATCH_PARENT;
                            boolean z14 = bVar2 != bVar4 || bVar2 == e.b.FIXED;
                            boolean z15 = bVar != bVar4 || bVar == e.b.FIXED;
                            z7 = !z12 && eVar.Q > 0.0f;
                            z8 = !z13 && eVar.Q > 0.0f;
                            b bVar5 = (b) view.getLayoutParams();
                            if (aVar.f12648j && z12 && eVar.f12564l == 0 && z13 && eVar.f12566m == 0) {
                                measuredWidth2 = 0;
                                measuredHeight2 = 0;
                                baseline = 0;
                                i11 = -1;
                            } else {
                                view.measure(i6, makeMeasureSpec);
                                measuredWidth = view.getMeasuredWidth();
                                measuredHeight = view.getMeasuredHeight();
                                int baseline2 = view.getBaseline();
                                if (z5) {
                                    i8 = 0;
                                    int[] iArr3 = eVar.f12556h;
                                    iArr3[0] = 0;
                                    iArr3[2] = 0;
                                } else {
                                    int[] iArr4 = eVar.f12556h;
                                    i8 = 0;
                                    iArr4[0] = measuredWidth;
                                    iArr4[2] = measuredHeight;
                                }
                                if (z6) {
                                    int[] iArr5 = eVar.f12556h;
                                    iArr5[1] = i8;
                                    iArr5[3] = i8;
                                } else {
                                    int[] iArr6 = eVar.f12556h;
                                    iArr6[1] = measuredHeight;
                                    iArr6[3] = measuredWidth;
                                }
                                int i17 = eVar.f12570o;
                                max = i17 <= 0 ? Math.max(i17, measuredWidth) : measuredWidth;
                                i9 = eVar.f12572p;
                                if (i9 > 0) {
                                    max = Math.min(i9, max);
                                }
                                int i18 = eVar.f12576r;
                                max2 = i18 <= 0 ? Math.max(i18, measuredHeight) : measuredHeight;
                                i10 = eVar.f12578s;
                                if (i10 > 0) {
                                    max2 = Math.min(i10, max2);
                                }
                                if (!z7 && z14) {
                                    max = (int) ((max2 * eVar.Q) + 0.5f);
                                } else if (z8 && z15) {
                                    max2 = (int) ((max / eVar.Q) + 0.5f);
                                }
                                if (measuredWidth == max || measuredHeight != max2) {
                                    if (measuredWidth != max) {
                                        i6 = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
                                    }
                                    if (measuredHeight != max2) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max2, 1073741824);
                                    }
                                    view.measure(i6, makeMeasureSpec);
                                    measuredWidth2 = view.getMeasuredWidth();
                                    measuredHeight2 = view.getMeasuredHeight();
                                    baseline = view.getBaseline();
                                } else {
                                    measuredWidth2 = max;
                                    measuredHeight2 = max2;
                                    baseline = baseline2;
                                }
                                i11 = -1;
                            }
                            boolean z16 = baseline == i11;
                            aVar.f12647i = measuredWidth2 == aVar.f12641c || measuredHeight2 != aVar.f12642d;
                            z9 = !bVar5.Y ? true : z16;
                            if (z9 && baseline != -1 && eVar.l() != baseline) {
                                aVar.f12647i = true;
                            }
                            aVar.f12643e = measuredWidth2;
                            aVar.f12644f = measuredHeight2;
                            aVar.f12646h = z9;
                            aVar.f12645g = baseline;
                        } else {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1239g, i14, -2);
                            boolean z17 = eVar.f12566m == 1;
                            int[] iArr7 = eVar.f12556h;
                            iArr7[3] = 0;
                            if (aVar.f12648j) {
                                boolean z18 = (!z17 || iArr7[2] == 0 || iArr7[1] == eVar.t()) ? false : true;
                                if (!z17 || z18) {
                                    childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.t(), 1073741824);
                                }
                            }
                        }
                        makeMeasureSpec = childMeasureSpec2;
                    } else {
                        childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1239g, i14, -2);
                        eVar.f12556h[3] = -2;
                    }
                    makeMeasureSpec = childMeasureSpec;
                    z6 = true;
                    e.b bVar32 = e.b.MATCH_CONSTRAINT;
                    if (bVar != bVar32) {
                    }
                    if (bVar2 != bVar32) {
                    }
                    e.b bVar42 = e.b.MATCH_PARENT;
                    if (bVar2 != bVar42) {
                    }
                    if (bVar != bVar42) {
                    }
                    if (z12) {
                    }
                    if (z13) {
                    }
                    b bVar52 = (b) view.getLayoutParams();
                    if (aVar.f12648j) {
                    }
                    view.measure(i6, makeMeasureSpec);
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    int baseline22 = view.getBaseline();
                    if (z5) {
                    }
                    if (z6) {
                    }
                    int i172 = eVar.f12570o;
                    if (i172 <= 0) {
                    }
                    i9 = eVar.f12572p;
                    if (i9 > 0) {
                    }
                    int i182 = eVar.f12576r;
                    if (i182 <= 0) {
                    }
                    i10 = eVar.f12578s;
                    if (i10 > 0) {
                    }
                    if (!z7) {
                    }
                    if (z8) {
                        max2 = (int) ((max / eVar.Q) + 0.5f);
                    }
                    if (measuredWidth == max) {
                    }
                    if (measuredWidth != max) {
                    }
                    if (measuredHeight != max2) {
                    }
                    view.measure(i6, makeMeasureSpec);
                    measuredWidth2 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    i11 = -1;
                    if (baseline == i11) {
                    }
                    aVar.f12647i = measuredWidth2 == aVar.f12641c || measuredHeight2 != aVar.f12642d;
                    if (!bVar52.Y) {
                    }
                    if (z9) {
                        aVar.f12647i = true;
                    }
                    aVar.f12643e = measuredWidth2;
                    aVar.f12644f = measuredHeight2;
                    aVar.f12646h = z9;
                    aVar.f12645g = baseline;
                }
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                eVar.f12556h[3] = i13;
                z6 = false;
                e.b bVar322 = e.b.MATCH_CONSTRAINT;
                if (bVar != bVar322) {
                }
                if (bVar2 != bVar322) {
                }
                e.b bVar422 = e.b.MATCH_PARENT;
                if (bVar2 != bVar422) {
                }
                if (bVar != bVar422) {
                }
                if (z12) {
                }
                if (z13) {
                }
                b bVar522 = (b) view.getLayoutParams();
                if (aVar.f12648j) {
                }
                view.measure(i6, makeMeasureSpec);
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();
                int baseline222 = view.getBaseline();
                if (z5) {
                }
                if (z6) {
                }
                int i1722 = eVar.f12570o;
                if (i1722 <= 0) {
                }
                i9 = eVar.f12572p;
                if (i9 > 0) {
                }
                int i1822 = eVar.f12576r;
                if (i1822 <= 0) {
                }
                i10 = eVar.f12578s;
                if (i10 > 0) {
                }
                if (!z7) {
                }
                if (z8) {
                }
                if (measuredWidth == max) {
                }
                if (measuredWidth != max) {
                }
                if (measuredHeight != max2) {
                }
                view.measure(i6, makeMeasureSpec);
                measuredWidth2 = view.getMeasuredWidth();
                measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                i11 = -1;
                if (baseline == i11) {
                }
                aVar.f12647i = measuredWidth2 == aVar.f12641c || measuredHeight2 != aVar.f12642d;
                if (!bVar522.Y) {
                }
                if (z9) {
                }
                aVar.f12643e = measuredWidth2;
                aVar.f12644f = measuredHeight2;
                aVar.f12646h = z9;
                aVar.f12645g = baseline;
            }
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            eVar.f12556h[2] = i12;
            i6 = makeMeasureSpec2;
            z5 = false;
            i7 = iArr[bVar2.ordinal()];
            if (i7 == 1) {
            }
            z6 = false;
            e.b bVar3222 = e.b.MATCH_CONSTRAINT;
            if (bVar != bVar3222) {
            }
            if (bVar2 != bVar3222) {
            }
            e.b bVar4222 = e.b.MATCH_PARENT;
            if (bVar2 != bVar4222) {
            }
            if (bVar != bVar4222) {
            }
            if (z12) {
            }
            if (z13) {
            }
            b bVar5222 = (b) view.getLayoutParams();
            if (aVar.f12648j) {
            }
            view.measure(i6, makeMeasureSpec);
            measuredWidth = view.getMeasuredWidth();
            measuredHeight = view.getMeasuredHeight();
            int baseline2222 = view.getBaseline();
            if (z5) {
            }
            if (z6) {
            }
            int i17222 = eVar.f12570o;
            if (i17222 <= 0) {
            }
            i9 = eVar.f12572p;
            if (i9 > 0) {
            }
            int i18222 = eVar.f12576r;
            if (i18222 <= 0) {
            }
            i10 = eVar.f12578s;
            if (i10 > 0) {
            }
            if (!z7) {
            }
            if (z8) {
            }
            if (measuredWidth == max) {
            }
            if (measuredWidth != max) {
            }
            if (measuredHeight != max2) {
            }
            view.measure(i6, makeMeasureSpec);
            measuredWidth2 = view.getMeasuredWidth();
            measuredHeight2 = view.getMeasuredHeight();
            baseline = view.getBaseline();
            i11 = -1;
            if (baseline == i11) {
            }
            aVar.f12647i = measuredWidth2 == aVar.f12641c || measuredHeight2 != aVar.f12642d;
            if (!bVar5222.Y) {
            }
            if (z9) {
            }
            aVar.f12643e = measuredWidth2;
            aVar.f12644f = measuredHeight2;
            aVar.f12646h = z9;
            aVar.f12645g = baseline;
        }

        public void c(int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f1234b = i8;
            this.f1235c = i9;
            this.f1236d = i10;
            this.f1237e = i11;
            this.f1238f = i6;
            this.f1239g = i7;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1167b = new SparseArray();
        this.f1168c = new ArrayList(4);
        this.f1169d = new p.f();
        this.f1170e = 0;
        this.f1171f = 0;
        this.f1172g = Integer.MAX_VALUE;
        this.f1173h = Integer.MAX_VALUE;
        this.f1174i = true;
        this.f1175j = 263;
        this.f1176k = null;
        this.f1177l = null;
        this.f1178m = -1;
        this.f1179n = new HashMap();
        this.f1180o = -1;
        this.f1181p = -1;
        this.f1182q = -1;
        this.f1183r = -1;
        this.f1184s = 0;
        this.f1185t = 0;
        this.f1186u = new SparseArray();
        this.f1187v = new c(this);
        this.f1188w = 0;
        this.f1189x = 0;
        j(attributeSet, 0, 0);
    }

    private final p.e g(int i6) {
        if (i6 == 0) {
            return this.f1169d;
        }
        View view = (View) this.f1167b.get(i6);
        if (view == null && (view = findViewById(i6)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f1169d;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).f1218n0;
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return max2 > 0 ? max2 : max;
    }

    private void j(AttributeSet attributeSet, int i6, int i7) {
        this.f1169d.Z(this);
        this.f1169d.a1(this.f1187v);
        this.f1167b.put(getId(), this);
        this.f1176k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, g.f1349a1, i6, i7);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                if (index == g.f1373e1) {
                    this.f1170e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1170e);
                } else if (index == g.f1379f1) {
                    this.f1171f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1171f);
                } else if (index == g.f1361c1) {
                    this.f1172g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1172g);
                } else if (index == g.f1367d1) {
                    this.f1173h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1173h);
                } else if (index == g.f1410k2) {
                    this.f1175j = obtainStyledAttributes.getInt(index, this.f1175j);
                } else if (index == g.f1415l1) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            m(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1177l = null;
                        }
                    }
                } else if (index == g.f1403j1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar = new d();
                        this.f1176k = dVar;
                        dVar.l(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f1176k = null;
                    }
                    this.f1178m = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1169d.b1(this.f1175j);
    }

    private void l() {
        this.f1174i = true;
        this.f1180o = -1;
        this.f1181p = -1;
        this.f1182q = -1;
        this.f1183r = -1;
        this.f1184s = 0;
        this.f1185t = 0;
    }

    private void p() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            p.e i7 = i(getChildAt(i6));
            if (i7 != null) {
                i7.W();
            }
        }
        if (isInEditMode) {
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    q(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    g(childAt.getId()).a0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f1178m != -1) {
            for (int i9 = 0; i9 < childCount; i9++) {
                getChildAt(i9).getId();
                int i10 = this.f1178m;
            }
        }
        d dVar = this.f1176k;
        if (dVar != null) {
            dVar.d(this, true);
        }
        this.f1169d.I0();
        int size = this.f1168c.size();
        if (size > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                ((androidx.constraintlayout.widget.b) this.f1168c.get(i11)).j(this);
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            getChildAt(i12);
        }
        this.f1186u.clear();
        this.f1186u.put(0, this.f1169d);
        this.f1186u.put(getId(), this.f1169d);
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            this.f1186u.put(childAt2.getId(), i(childAt2));
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt3 = getChildAt(i14);
            p.e i15 = i(childAt3);
            if (i15 != null) {
                b bVar = (b) childAt3.getLayoutParams();
                this.f1169d.c(i15);
                b(isInEditMode, childAt3, i15, bVar, this.f1186u);
            }
        }
    }

    private boolean s() {
        int childCount = getChildCount();
        boolean z5 = false;
        int i6 = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            } else if (getChildAt(i6).isLayoutRequested()) {
                z5 = true;
                break;
            } else {
                i6++;
            }
        }
        if (z5) {
            p();
        }
        return z5;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i6, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void b(boolean z5, View view, p.e eVar, b bVar, SparseArray sparseArray) {
        float f6;
        p.e eVar2;
        d.b bVar2;
        d.b bVar3;
        int i6;
        p.e eVar3;
        p.e eVar4;
        d.b bVar4;
        int i7;
        p.e eVar5;
        d.b bVar5;
        int i8;
        p.e eVar6;
        d.b bVar6;
        d.b bVar7;
        int i9;
        int i10;
        p.e eVar7;
        int i11;
        p.e eVar8;
        d.b bVar8;
        int i12;
        int i13;
        p.e eVar9;
        d.b bVar9;
        int i14;
        float f7;
        float f8;
        int i15;
        bVar.a();
        bVar.f1220o0 = false;
        eVar.z0(view.getVisibility());
        if (bVar.f1194b0) {
            eVar.m0(true);
            eVar.z0(8);
        }
        eVar.Z(view);
        if (view instanceof androidx.constraintlayout.widget.b) {
            ((androidx.constraintlayout.widget.b) view).f(eVar, this.f1169d.V0());
        }
        if (bVar.Z) {
            p.g gVar = (p.g) eVar;
            int i16 = bVar.f1212k0;
            int i17 = bVar.f1214l0;
            float f9 = bVar.f1216m0;
            if (f9 != -1.0f) {
                gVar.M0(f9);
                return;
            } else if (i16 != -1) {
                gVar.K0(i16);
                return;
            } else if (i17 != -1) {
                gVar.L0(i17);
                return;
            } else {
                return;
            }
        }
        int i18 = bVar.f1198d0;
        int i19 = bVar.f1200e0;
        int i20 = bVar.f1202f0;
        int i21 = bVar.f1204g0;
        int i22 = bVar.f1206h0;
        int i23 = bVar.f1208i0;
        float f10 = bVar.f1210j0;
        int i24 = bVar.f1215m;
        if (i24 != -1) {
            p.e eVar10 = (p.e) sparseArray.get(i24);
            if (eVar10 != null) {
                eVar.i(eVar10, bVar.f1219o, bVar.f1217n);
            }
        } else if (i18 != -1) {
            eVar2 = (p.e) sparseArray.get(i18);
            if (eVar2 != null) {
                bVar3 = d.b.LEFT;
                eVar3 = eVar;
                bVar2 = bVar3;
                f6 = f10;
                i6 = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
                eVar3.R(bVar2, eVar2, bVar3, i6, i22);
                if (i20 != -1) {
                    eVar4 = (p.e) sparseArray.get(i20);
                    if (eVar4 != null) {
                        bVar5 = d.b.RIGHT;
                        bVar4 = d.b.LEFT;
                        i7 = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
                        eVar5 = eVar;
                        eVar5.R(bVar5, eVar4, bVar4, i7, i23);
                    }
                    i8 = bVar.f1205h;
                    if (i8 == -1) {
                        eVar6 = (p.e) sparseArray.get(i8);
                        if (eVar6 != null) {
                            bVar7 = d.b.TOP;
                            i9 = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
                            i10 = bVar.f1226u;
                            eVar7 = eVar;
                            bVar6 = bVar7;
                            eVar7.R(bVar6, eVar6, bVar7, i9, i10);
                        }
                        i11 = bVar.f1209j;
                        if (i11 == -1) {
                            eVar8 = (p.e) sparseArray.get(i11);
                            if (eVar8 != null) {
                                bVar9 = d.b.BOTTOM;
                                bVar8 = d.b.TOP;
                                i12 = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
                                i13 = bVar.f1228w;
                                eVar9 = eVar;
                                eVar9.R(bVar9, eVar8, bVar8, i12, i13);
                            }
                            i14 = bVar.f1213l;
                            if (i14 != -1) {
                                View view2 = (View) this.f1167b.get(i14);
                                p.e eVar11 = (p.e) sparseArray.get(bVar.f1213l);
                                if (eVar11 != null && view2 != null && (view2.getLayoutParams() instanceof b)) {
                                    b bVar10 = (b) view2.getLayoutParams();
                                    bVar.Y = true;
                                    bVar10.Y = true;
                                    d.b bVar11 = d.b.BASELINE;
                                    eVar.k(bVar11).a(eVar11.k(bVar11), 0, -1, true);
                                    eVar.d0(true);
                                    bVar10.f1218n0.d0(true);
                                    eVar.k(d.b.TOP).k();
                                    eVar.k(d.b.BOTTOM).k();
                                }
                            }
                            f7 = f6;
                            if (f7 >= 0.0f) {
                                eVar.f0(f7);
                            }
                            f8 = bVar.A;
                            if (f8 >= 0.0f) {
                                eVar.t0(f8);
                            }
                        } else {
                            int i25 = bVar.f1211k;
                            if (i25 != -1 && (eVar8 = (p.e) sparseArray.get(i25)) != null) {
                                bVar8 = d.b.BOTTOM;
                                i12 = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
                                i13 = bVar.f1228w;
                                eVar9 = eVar;
                                bVar9 = bVar8;
                                eVar9.R(bVar9, eVar8, bVar8, i12, i13);
                            }
                            i14 = bVar.f1213l;
                            if (i14 != -1) {
                            }
                            f7 = f6;
                            if (f7 >= 0.0f) {
                            }
                            f8 = bVar.A;
                            if (f8 >= 0.0f) {
                            }
                        }
                    } else {
                        int i26 = bVar.f1207i;
                        if (i26 != -1 && (eVar6 = (p.e) sparseArray.get(i26)) != null) {
                            bVar6 = d.b.TOP;
                            bVar7 = d.b.BOTTOM;
                            i9 = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
                            i10 = bVar.f1226u;
                            eVar7 = eVar;
                            eVar7.R(bVar6, eVar6, bVar7, i9, i10);
                        }
                        i11 = bVar.f1209j;
                        if (i11 == -1) {
                        }
                    }
                } else {
                    if (i21 != -1 && (eVar4 = (p.e) sparseArray.get(i21)) != null) {
                        bVar4 = d.b.RIGHT;
                        i7 = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
                        eVar5 = eVar;
                        bVar5 = bVar4;
                        eVar5.R(bVar5, eVar4, bVar4, i7, i23);
                    }
                    i8 = bVar.f1205h;
                    if (i8 == -1) {
                    }
                }
            } else {
                f6 = f10;
                if (i20 != -1) {
                }
            }
        } else {
            f6 = f10;
            if (i19 != -1 && (eVar2 = (p.e) sparseArray.get(i19)) != null) {
                bVar2 = d.b.LEFT;
                bVar3 = d.b.RIGHT;
                i6 = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
                eVar3 = eVar;
                eVar3.R(bVar2, eVar2, bVar3, i6, i22);
            }
            if (i20 != -1) {
            }
        }
        if (z5 && ((i15 = bVar.Q) != -1 || bVar.R != -1)) {
            eVar.r0(i15, bVar.R);
        }
        if (bVar.W) {
            eVar.i0(e.b.FIXED);
            eVar.A0(((ViewGroup.MarginLayoutParams) bVar).width);
            if (((ViewGroup.MarginLayoutParams) bVar).width == -2) {
                eVar.i0(e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).width == -1) {
            eVar.i0(bVar.T ? e.b.MATCH_CONSTRAINT : e.b.MATCH_PARENT);
            eVar.k(d.b.LEFT).f12537e = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            eVar.k(d.b.RIGHT).f12537e = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        } else {
            eVar.i0(e.b.MATCH_CONSTRAINT);
            eVar.A0(0);
        }
        if (bVar.X) {
            eVar.w0(e.b.FIXED);
            eVar.e0(((ViewGroup.MarginLayoutParams) bVar).height);
            if (((ViewGroup.MarginLayoutParams) bVar).height == -2) {
                eVar.w0(e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).height == -1) {
            eVar.w0(bVar.U ? e.b.MATCH_CONSTRAINT : e.b.MATCH_PARENT);
            eVar.k(d.b.TOP).f12537e = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            eVar.k(d.b.BOTTOM).f12537e = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        } else {
            eVar.w0(e.b.MATCH_CONSTRAINT);
            eVar.e0(0);
        }
        eVar.b0(bVar.B);
        eVar.k0(bVar.E);
        eVar.y0(bVar.F);
        eVar.g0(bVar.G);
        eVar.u0(bVar.H);
        eVar.j0(bVar.I, bVar.K, bVar.M, bVar.O);
        eVar.x0(bVar.J, bVar.L, bVar.N, bVar.P);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: c */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.ViewGroup
    /* renamed from: d */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f1168c;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((androidx.constraintlayout.widget.b) this.f1168c.get(i6)).i(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i8 = (int) ((parseInt / 1080.0f) * width);
                        int i9 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f6 = i8;
                        float f7 = i9;
                        float f8 = i8 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f6, f7, f8, f7, paint);
                        float parseInt4 = i9 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f8, f7, f8, parseInt4, paint);
                        canvas.drawLine(f8, parseInt4, f6, parseInt4, paint);
                        canvas.drawLine(f6, parseInt4, f6, f7, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f6, f7, f8, parseInt4, paint);
                        canvas.drawLine(f6, parseInt4, f8, f7, paint);
                    }
                }
            }
        }
    }

    public Object f(int i6, Object obj) {
        if (i6 == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap hashMap = this.f1179n;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return null;
            }
            return this.f1179n.get(str);
        }
        return null;
    }

    @Override // android.view.View
    public void forceLayout() {
        l();
        super.forceLayout();
    }

    public int getMaxHeight() {
        return this.f1173h;
    }

    public int getMaxWidth() {
        return this.f1172g;
    }

    public int getMinHeight() {
        return this.f1171f;
    }

    public int getMinWidth() {
        return this.f1170e;
    }

    public int getOptimizationLevel() {
        return this.f1169d.R0();
    }

    public View h(int i6) {
        return (View) this.f1167b.get(i6);
    }

    public final p.e i(View view) {
        if (view == this) {
            return this.f1169d;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).f1218n0;
    }

    protected boolean k() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    protected void m(int i6) {
        this.f1177l = new androidx.constraintlayout.widget.c(getContext(), this, i6);
    }

    protected void n(int i6, int i7, int i8, int i9, boolean z5, boolean z6) {
        c cVar = this.f1187v;
        int i10 = cVar.f1237e;
        int resolveSizeAndState = View.resolveSizeAndState(i8 + cVar.f1236d, i6, 0);
        int min = Math.min(this.f1172g, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.f1173h, View.resolveSizeAndState(i9 + i10, i7, 0) & 16777215);
        if (z5) {
            min |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        if (z6) {
            min2 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        setMeasuredDimension(min, min2);
        this.f1180o = min;
        this.f1181p = min2;
    }

    protected void o(p.f fVar, int i6, int i7, int i8) {
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i8);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i9 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.f1187v.c(i7, i8, max, max2, paddingWidth, i9);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        int max5 = (max3 > 0 || max4 > 0) ? k() ? max4 : max3 : Math.max(0, getPaddingLeft());
        int i10 = size - paddingWidth;
        int i11 = size2 - i9;
        r(fVar, mode, i10, mode2, i11);
        fVar.X0(i6, mode, i10, mode2, i11, this.f1180o, this.f1181p, max5, max);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            b bVar = (b) childAt.getLayoutParams();
            p.e eVar = bVar.f1218n0;
            if ((childAt.getVisibility() != 8 || bVar.Z || bVar.f1192a0 || bVar.f1196c0 || isInEditMode) && !bVar.f1194b0) {
                int O = eVar.O();
                int P = eVar.P();
                childAt.layout(O, P, eVar.N() + O, eVar.t() + P);
            }
        }
        int size = this.f1168c.size();
        if (size > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                ((androidx.constraintlayout.widget.b) this.f1168c.get(i11)).g(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i6, int i7) {
        this.f1188w = i6;
        this.f1189x = i7;
        this.f1169d.c1(k());
        if (this.f1174i) {
            this.f1174i = false;
            if (s()) {
                this.f1169d.e1();
            }
        }
        o(this.f1169d, this.f1175j, i6, i7);
        n(i6, i7, this.f1169d.N(), this.f1169d.t(), this.f1169d.W0(), this.f1169d.U0());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        p.e i6 = i(view);
        if ((view instanceof Guideline) && !(i6 instanceof p.g)) {
            b bVar = (b) view.getLayoutParams();
            p.g gVar = new p.g();
            bVar.f1218n0 = gVar;
            bVar.Z = true;
            gVar.N0(bVar.S);
        }
        if (view instanceof androidx.constraintlayout.widget.b) {
            androidx.constraintlayout.widget.b bVar2 = (androidx.constraintlayout.widget.b) view;
            bVar2.k();
            ((b) view.getLayoutParams()).f1192a0 = true;
            if (!this.f1168c.contains(bVar2)) {
                this.f1168c.add(bVar2);
            }
        }
        this.f1167b.put(view.getId(), view);
        this.f1174i = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1167b.remove(view.getId());
        this.f1169d.H0(i(view));
        this.f1168c.remove(view);
        this.f1174i = true;
    }

    public void q(int i6, Object obj, Object obj2) {
        if (i6 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f1179n == null) {
                this.f1179n = new HashMap();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f1179n.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r3 == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r3 == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        r10 = java.lang.Math.max(0, r7.f1170e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
        if (r3 == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
        if (r3 == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
        r12 = java.lang.Math.max(0, r7.f1171f);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void r(p.f fVar, int i6, int i7, int i8, int i9) {
        e.b bVar;
        c cVar = this.f1187v;
        int i10 = cVar.f1237e;
        int i11 = cVar.f1236d;
        e.b bVar2 = e.b.FIXED;
        int childCount = getChildCount();
        if (i6 != Integer.MIN_VALUE) {
            if (i6 == 0) {
                bVar = e.b.WRAP_CONTENT;
            } else if (i6 != 1073741824) {
                bVar = bVar2;
            } else {
                i7 = Math.min(this.f1172g - i11, i7);
                bVar = bVar2;
            }
            i7 = 0;
        } else {
            bVar = e.b.WRAP_CONTENT;
        }
        if (i8 != Integer.MIN_VALUE) {
            if (i8 == 0) {
                bVar2 = e.b.WRAP_CONTENT;
            } else if (i8 == 1073741824) {
                i9 = Math.min(this.f1173h - i10, i9);
            }
            i9 = 0;
        } else {
            bVar2 = e.b.WRAP_CONTENT;
        }
        if (i7 != fVar.N() || i9 != fVar.t()) {
            fVar.T0();
        }
        fVar.B0(0);
        fVar.C0(0);
        fVar.o0(this.f1172g - i11);
        fVar.n0(this.f1173h - i10);
        fVar.q0(0);
        fVar.p0(0);
        fVar.i0(bVar);
        fVar.A0(i7);
        fVar.w0(bVar2);
        fVar.e0(i9);
        fVar.q0(this.f1170e - i11);
        fVar.p0(this.f1171f - i10);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        l();
        super.requestLayout();
    }

    public void setConstraintSet(d dVar) {
        this.f1176k = dVar;
    }

    @Override // android.view.View
    public void setId(int i6) {
        this.f1167b.remove(getId());
        super.setId(i6);
        this.f1167b.put(getId(), this);
    }

    public void setMaxHeight(int i6) {
        if (i6 == this.f1173h) {
            return;
        }
        this.f1173h = i6;
        requestLayout();
    }

    public void setMaxWidth(int i6) {
        if (i6 == this.f1172g) {
            return;
        }
        this.f1172g = i6;
        requestLayout();
    }

    public void setMinHeight(int i6) {
        if (i6 == this.f1171f) {
            return;
        }
        this.f1171f = i6;
        requestLayout();
    }

    public void setMinWidth(int i6) {
        if (i6 == this.f1170e) {
            return;
        }
        this.f1170e = i6;
        requestLayout();
    }

    public void setOnConstraintsChanged(e eVar) {
        androidx.constraintlayout.widget.c cVar = this.f1177l;
        if (cVar != null) {
            cVar.c(eVar);
        }
    }

    public void setOptimizationLevel(int i6) {
        this.f1175j = i6;
        this.f1169d.b1(i6);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1167b = new SparseArray();
        this.f1168c = new ArrayList(4);
        this.f1169d = new p.f();
        this.f1170e = 0;
        this.f1171f = 0;
        this.f1172g = Integer.MAX_VALUE;
        this.f1173h = Integer.MAX_VALUE;
        this.f1174i = true;
        this.f1175j = 263;
        this.f1176k = null;
        this.f1177l = null;
        this.f1178m = -1;
        this.f1179n = new HashMap();
        this.f1180o = -1;
        this.f1181p = -1;
        this.f1182q = -1;
        this.f1183r = -1;
        this.f1184s = 0;
        this.f1185t = 0;
        this.f1186u = new SparseArray();
        this.f1187v = new c(this);
        this.f1188w = 0;
        this.f1189x = 0;
        j(attributeSet, i6, 0);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }
}
