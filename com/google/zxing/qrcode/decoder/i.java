package com.google.zxing.qrcode.decoder;

import com.google.zxing.p;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5862a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(boolean z5) {
        this.f5862a = z5;
    }

    public void a(p[] pVarArr) {
        if (!this.f5862a || pVarArr == null || pVarArr.length < 3) {
            return;
        }
        p pVar = pVarArr[0];
        pVarArr[0] = pVarArr[2];
        pVarArr[2] = pVar;
    }
}
