package com.google.zxing;

import java.util.Map;
/* loaded from: classes.dex */
public final class j implements r {

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5835a;

        static {
            int[] iArr = new int[com.google.zxing.a.values().length];
            f5835a = iArr;
            try {
                iArr[com.google.zxing.a.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5835a[com.google.zxing.a.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5835a[com.google.zxing.a.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5835a[com.google.zxing.a.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5835a[com.google.zxing.a.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5835a[com.google.zxing.a.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5835a[com.google.zxing.a.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5835a[com.google.zxing.a.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5835a[com.google.zxing.a.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5835a[com.google.zxing.a.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f5835a[com.google.zxing.a.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f5835a[com.google.zxing.a.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f5835a[com.google.zxing.a.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // com.google.zxing.r
    public s3.b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        r kVar;
        switch (a.f5835a[aVar.ordinal()]) {
            case 1:
                kVar = new x3.k();
                break;
            case 2:
                kVar = new x3.s();
                break;
            case 3:
                kVar = new x3.j();
                break;
            case 4:
                kVar = new x3.o();
                break;
            case 5:
                kVar = new a4.b();
                break;
            case 6:
                kVar = new x3.f();
                break;
            case 7:
                kVar = new x3.h();
                break;
            case 8:
                kVar = new x3.d();
                break;
            case 9:
                kVar = new x3.l();
                break;
            case 10:
                kVar = new y3.a();
                break;
            case 11:
                kVar = new x3.b();
                break;
            case 12:
                kVar = new v3.a();
                break;
            case 13:
                kVar = new q3.a();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + aVar);
        }
        return kVar.a(str, aVar, i6, i7, map);
    }
}
