package okio;

import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.e0;
import kotlin.collections.v;
/* loaded from: classes.dex */
public final class FileMetadata {
    private final Long createdAtMillis;
    private final Map<s4.c, Object> extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;
    private final Long lastAccessedAtMillis;
    private final Long lastModifiedAtMillis;
    private final Long size;
    private final Path symlinkTarget;

    public FileMetadata() {
        this(false, false, null, null, null, null, null, null, 255, null);
    }

    public final FileMetadata copy(boolean z5, boolean z6, Path path, Long l6, Long l7, Long l8, Long l9, Map<s4.c, ? extends Object> map) {
        kotlin.jvm.internal.l.d(map, "extras");
        return new FileMetadata(z5, z6, path, l6, l7, l8, l9, map);
    }

    public final <T> T extra(s4.c cVar) {
        kotlin.jvm.internal.l.d(cVar, "type");
        Object obj = this.extras.get(cVar);
        if (obj == null) {
            return null;
        }
        return (T) s4.d.a(cVar, obj);
    }

    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public final Map<s4.c, Object> getExtras() {
        return this.extras;
    }

    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    public String toString() {
        String F;
        ArrayList arrayList = new ArrayList();
        if (this.isRegularFile) {
            arrayList.add("isRegularFile");
        }
        if (this.isDirectory) {
            arrayList.add("isDirectory");
        }
        if (this.size != null) {
            arrayList.add("byteCount=" + this.size);
        }
        if (this.createdAtMillis != null) {
            arrayList.add("createdAt=" + this.createdAtMillis);
        }
        if (this.lastModifiedAtMillis != null) {
            arrayList.add("lastModifiedAt=" + this.lastModifiedAtMillis);
        }
        if (this.lastAccessedAtMillis != null) {
            arrayList.add("lastAccessedAt=" + this.lastAccessedAtMillis);
        }
        if (!this.extras.isEmpty()) {
            arrayList.add("extras=" + this.extras);
        }
        F = v.F(arrayList, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
        return F;
    }

    public FileMetadata(boolean z5, boolean z6, Path path, Long l6, Long l7, Long l8, Long l9, Map<s4.c, ? extends Object> map) {
        Map<s4.c, Object> k6;
        kotlin.jvm.internal.l.d(map, "extras");
        this.isRegularFile = z5;
        this.isDirectory = z6;
        this.symlinkTarget = path;
        this.size = l6;
        this.createdAtMillis = l7;
        this.lastModifiedAtMillis = l8;
        this.lastAccessedAtMillis = l9;
        k6 = e0.k(map);
        this.extras = k6;
    }

    public /* synthetic */ FileMetadata(boolean z5, boolean z6, Path path, Long l6, Long l7, Long l8, Long l9, Map map, int i6, kotlin.jvm.internal.g gVar) {
        this((i6 & 1) != 0 ? false : z5, (i6 & 2) == 0 ? z6 : false, (i6 & 4) != 0 ? null : path, (i6 & 8) != 0 ? null : l6, (i6 & 16) != 0 ? null : l7, (i6 & 32) != 0 ? null : l8, (i6 & 64) == 0 ? l9 : null, (i6 & 128) != 0 ? e0.d() : map);
    }
}
