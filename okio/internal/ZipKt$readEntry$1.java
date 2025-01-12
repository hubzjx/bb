package okio.internal;

import java.io.IOException;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import okio.BufferedSource;
import p4.p;
/* loaded from: classes.dex */
final class ZipKt$readEntry$1 extends m implements p {
    final /* synthetic */ q $compressedSize;
    final /* synthetic */ o $hasZip64Extra;
    final /* synthetic */ q $offset;
    final /* synthetic */ long $requiredZip64ExtraSize;
    final /* synthetic */ q $size;
    final /* synthetic */ BufferedSource $this_readEntry;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZipKt$readEntry$1(o oVar, long j6, q qVar, BufferedSource bufferedSource, q qVar2, q qVar3) {
        super(2);
        this.$hasZip64Extra = oVar;
        this.$requiredZip64ExtraSize = j6;
        this.$size = qVar;
        this.$this_readEntry = bufferedSource;
        this.$compressedSize = qVar2;
        this.$offset = qVar3;
    }

    @Override // p4.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
        return h4.q.f10774a;
    }

    public final void invoke(int i6, long j6) {
        if (i6 == 1) {
            o oVar = this.$hasZip64Extra;
            if (oVar.element) {
                throw new IOException("bad zip: zip64 extra repeated");
            }
            oVar.element = true;
            if (j6 < this.$requiredZip64ExtraSize) {
                throw new IOException("bad zip: zip64 extra too short");
            }
            q qVar = this.$size;
            long j7 = qVar.element;
            if (j7 == 4294967295L) {
                j7 = this.$this_readEntry.readLongLe();
            }
            qVar.element = j7;
            q qVar2 = this.$compressedSize;
            qVar2.element = qVar2.element == 4294967295L ? this.$this_readEntry.readLongLe() : 0L;
            q qVar3 = this.$offset;
            qVar3.element = qVar3.element == 4294967295L ? this.$this_readEntry.readLongLe() : 0L;
        }
    }
}
