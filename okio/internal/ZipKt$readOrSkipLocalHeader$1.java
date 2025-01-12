package okio.internal;

import h4.q;
import java.io.IOException;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.r;
import okio.BufferedSource;
import p4.p;
/* loaded from: classes.dex */
final class ZipKt$readOrSkipLocalHeader$1 extends m implements p {
    final /* synthetic */ r $createdAtMillis;
    final /* synthetic */ r $lastAccessedAtMillis;
    final /* synthetic */ r $lastModifiedAtMillis;
    final /* synthetic */ BufferedSource $this_readOrSkipLocalHeader;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZipKt$readOrSkipLocalHeader$1(BufferedSource bufferedSource, r rVar, r rVar2, r rVar3) {
        super(2);
        this.$this_readOrSkipLocalHeader = bufferedSource;
        this.$lastModifiedAtMillis = rVar;
        this.$lastAccessedAtMillis = rVar2;
        this.$createdAtMillis = rVar3;
    }

    @Override // p4.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
        return q.f10774a;
    }

    public final void invoke(int i6, long j6) {
        if (i6 == 21589) {
            if (j6 < 1) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            int readByte = this.$this_readOrSkipLocalHeader.readByte() & 255;
            boolean z5 = (readByte & 1) == 1;
            boolean z6 = (readByte & 2) == 2;
            boolean z7 = (readByte & 4) == 4;
            BufferedSource bufferedSource = this.$this_readOrSkipLocalHeader;
            long j7 = z5 ? 5L : 1L;
            if (z6) {
                j7 += 4;
            }
            if (z7) {
                j7 += 4;
            }
            if (j6 < j7) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            if (z5) {
                this.$lastModifiedAtMillis.element = Long.valueOf(bufferedSource.readIntLe() * 1000);
            }
            if (z6) {
                this.$lastAccessedAtMillis.element = Long.valueOf(this.$this_readOrSkipLocalHeader.readIntLe() * 1000);
            }
            if (z7) {
                this.$createdAtMillis.element = Long.valueOf(this.$this_readOrSkipLocalHeader.readIntLe() * 1000);
            }
        }
    }
}
