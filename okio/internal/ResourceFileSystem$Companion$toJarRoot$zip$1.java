package okio.internal;

import kotlin.jvm.internal.m;
import p4.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ResourceFileSystem$Companion$toJarRoot$zip$1 extends m implements l {
    public static final ResourceFileSystem$Companion$toJarRoot$zip$1 INSTANCE = new ResourceFileSystem$Companion$toJarRoot$zip$1();

    ResourceFileSystem$Companion$toJarRoot$zip$1() {
        super(1);
    }

    @Override // p4.l
    public final Boolean invoke(ZipEntry zipEntry) {
        kotlin.jvm.internal.l.d(zipEntry, "entry");
        return Boolean.valueOf(ResourceFileSystem.Companion.keepPath(zipEntry.getCanonicalPath()));
    }
}
