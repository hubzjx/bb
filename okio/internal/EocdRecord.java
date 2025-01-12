package okio.internal;
/* loaded from: classes.dex */
final class EocdRecord {
    private final long centralDirectoryOffset;
    private final int commentByteCount;
    private final long entryCount;

    public EocdRecord(long j6, long j7, int i6) {
        this.entryCount = j6;
        this.centralDirectoryOffset = j7;
        this.commentByteCount = i6;
    }

    public final long getCentralDirectoryOffset() {
        return this.centralDirectoryOffset;
    }

    public final int getCommentByteCount() {
        return this.commentByteCount;
    }

    public final long getEntryCount() {
        return this.entryCount;
    }
}
