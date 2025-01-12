package okio.internal;

import kotlin.jvm.internal.m;
import p4.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ZipKt$openZip$1 extends m implements l {
    public static final ZipKt$openZip$1 INSTANCE = new ZipKt$openZip$1();

    ZipKt$openZip$1() {
        super(1);
    }

    @Override // p4.l
    public final Boolean invoke(ZipEntry zipEntry) {
        kotlin.jvm.internal.l.d(zipEntry, "it");
        return Boolean.TRUE;
    }
}
