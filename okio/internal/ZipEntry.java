package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.HttpUrl;
import okio.Path;
/* loaded from: classes.dex */
public final class ZipEntry {
    private final Path canonicalPath;
    private final List<Path> children;
    private final String comment;
    private final long compressedSize;
    private final int compressionMethod;
    private final long crc;
    private final boolean isDirectory;
    private final Long lastModifiedAtMillis;
    private final long offset;
    private final long size;

    public ZipEntry(Path path, boolean z5, String str, long j6, long j7, long j8, int i6, Long l6, long j9) {
        l.d(path, "canonicalPath");
        l.d(str, "comment");
        this.canonicalPath = path;
        this.isDirectory = z5;
        this.comment = str;
        this.crc = j6;
        this.compressedSize = j7;
        this.size = j8;
        this.compressionMethod = i6;
        this.lastModifiedAtMillis = l6;
        this.offset = j9;
        this.children = new ArrayList();
    }

    public final Path getCanonicalPath() {
        return this.canonicalPath;
    }

    public final List<Path> getChildren() {
        return this.children;
    }

    public final String getComment() {
        return this.comment;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final int getCompressionMethod() {
        return this.compressionMethod;
    }

    public final long getCrc() {
        return this.crc;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final long getSize() {
        return this.size;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public /* synthetic */ ZipEntry(Path path, boolean z5, String str, long j6, long j7, long j8, int i6, Long l6, long j9, int i7, g gVar) {
        this(path, (i7 & 2) != 0 ? false : z5, (i7 & 4) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str, (i7 & 8) != 0 ? -1L : j6, (i7 & 16) != 0 ? -1L : j7, (i7 & 32) != 0 ? -1L : j8, (i7 & 64) != 0 ? -1 : i6, (i7 & 128) != 0 ? null : l6, (i7 & 256) == 0 ? j9 : -1L);
    }
}
