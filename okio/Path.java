package okio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import okio.internal._PathKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
/* loaded from: classes.dex */
public final class Path implements Comparable<Path> {
    public static final Companion Companion = new Companion(null);
    public static final String DIRECTORY_SEPARATOR;
    private final ByteString bytes;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                z5 = false;
            }
            return companion.get(file, z5);
        }

        public final Path get(File file) {
            kotlin.jvm.internal.l.d(file, "<this>");
            return get$default(this, file, false, 1, (Object) null);
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                z5 = false;
            }
            return companion.get(str, z5);
        }

        public final Path get(File file, boolean z5) {
            kotlin.jvm.internal.l.d(file, "<this>");
            String file2 = file.toString();
            kotlin.jvm.internal.l.c(file2, "toString()");
            return get(file2, z5);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                z5 = false;
            }
            return companion.get(path, z5);
        }

        public final Path get(String str) {
            kotlin.jvm.internal.l.d(str, "<this>");
            return get$default(this, str, false, 1, (Object) null);
        }

        public final Path get(String str, boolean z5) {
            kotlin.jvm.internal.l.d(str, "<this>");
            return _PathKt.commonToPath(str, z5);
        }

        @IgnoreJRERequirement
        public final Path get(java.nio.file.Path path) {
            kotlin.jvm.internal.l.d(path, "<this>");
            return get$default(this, path, false, 1, (Object) null);
        }

        @IgnoreJRERequirement
        public final Path get(java.nio.file.Path path, boolean z5) {
            kotlin.jvm.internal.l.d(path, "<this>");
            return get(path.toString(), z5);
        }
    }

    static {
        String str = File.separator;
        kotlin.jvm.internal.l.c(str, "separator");
        DIRECTORY_SEPARATOR = str;
    }

    public Path(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "bytes");
        this.bytes = byteString;
    }

    public static final Path get(File file) {
        return Companion.get(file);
    }

    public static /* synthetic */ Path resolve$default(Path path, String str, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return path.resolve(str, z5);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Path) && kotlin.jvm.internal.l.a(((Path) obj).getBytes$okio(), getBytes$okio());
    }

    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    public final Path getRoot() {
        int access$rootLength = _PathKt.access$rootLength(this);
        if (access$rootLength == -1) {
            return null;
        }
        return new Path(getBytes$okio().substring(0, access$rootLength));
    }

    public final List<String> getSegments() {
        int p5;
        ArrayList<ByteString> arrayList = new ArrayList();
        int access$rootLength = _PathKt.access$rootLength(this);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < getBytes$okio().size() && getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = getBytes$okio().size();
        int i6 = access$rootLength;
        while (access$rootLength < size) {
            if (getBytes$okio().getByte(access$rootLength) == ((byte) 47) || getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
                arrayList.add(getBytes$okio().substring(i6, access$rootLength));
                i6 = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i6 < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i6, getBytes$okio().size()));
        }
        p5 = kotlin.collections.o.p(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(p5);
        for (ByteString byteString : arrayList) {
            arrayList2.add(byteString.utf8());
        }
        return arrayList2;
    }

    public final List<ByteString> getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int access$rootLength = _PathKt.access$rootLength(this);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < getBytes$okio().size() && getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = getBytes$okio().size();
        int i6 = access$rootLength;
        while (access$rootLength < size) {
            if (getBytes$okio().getByte(access$rootLength) == ((byte) 47) || getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
                arrayList.add(getBytes$okio().substring(i6, access$rootLength));
                i6 = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i6 < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i6, getBytes$okio().size()));
        }
        return arrayList;
    }

    public int hashCode() {
        return getBytes$okio().hashCode();
    }

    public final boolean isAbsolute() {
        return _PathKt.access$rootLength(this) != -1;
    }

    public final boolean isRelative() {
        return _PathKt.access$rootLength(this) == -1;
    }

    public final boolean isRoot() {
        return _PathKt.access$rootLength(this) == getBytes$okio().size();
    }

    public final String name() {
        return nameBytes().utf8();
    }

    public final ByteString nameBytes() {
        int access$getIndexOfLastSlash = _PathKt.access$getIndexOfLastSlash(this);
        return access$getIndexOfLastSlash != -1 ? ByteString.substring$default(getBytes$okio(), access$getIndexOfLastSlash + 1, 0, 2, null) : (volumeLetter() == null || getBytes$okio().size() != 2) ? getBytes$okio() : ByteString.EMPTY;
    }

    public final Path normalized() {
        return Companion.get(toString(), true);
    }

    public final Path parent() {
        Path path;
        if (kotlin.jvm.internal.l.a(getBytes$okio(), _PathKt.access$getDOT$p()) || kotlin.jvm.internal.l.a(getBytes$okio(), _PathKt.access$getSLASH$p()) || kotlin.jvm.internal.l.a(getBytes$okio(), _PathKt.access$getBACKSLASH$p()) || _PathKt.access$lastSegmentIsDotDot(this)) {
            return null;
        }
        int access$getIndexOfLastSlash = _PathKt.access$getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash != 2 || volumeLetter() == null) {
            if (access$getIndexOfLastSlash == 1 && getBytes$okio().startsWith(_PathKt.access$getBACKSLASH$p())) {
                return null;
            }
            if (access$getIndexOfLastSlash != -1 || volumeLetter() == null) {
                if (access$getIndexOfLastSlash == -1) {
                    return new Path(_PathKt.access$getDOT$p());
                }
                if (access$getIndexOfLastSlash != 0) {
                    return new Path(ByteString.substring$default(getBytes$okio(), 0, access$getIndexOfLastSlash, 1, null));
                }
                path = new Path(ByteString.substring$default(getBytes$okio(), 0, 1, 1, null));
            } else if (getBytes$okio().size() == 2) {
                return null;
            } else {
                path = new Path(ByteString.substring$default(getBytes$okio(), 0, 2, 1, null));
            }
        } else if (getBytes$okio().size() == 3) {
            return null;
        } else {
            path = new Path(ByteString.substring$default(getBytes$okio(), 0, 3, 1, null));
        }
        return path;
    }

    public final Path relativeTo(Path path) {
        kotlin.jvm.internal.l.d(path, "other");
        if (!kotlin.jvm.internal.l.a(getRoot(), path.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + path).toString());
        }
        List<ByteString> segmentsBytes = getSegmentsBytes();
        List<ByteString> segmentsBytes2 = path.getSegmentsBytes();
        int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i6 = 0;
        while (i6 < min && kotlin.jvm.internal.l.a(segmentsBytes.get(i6), segmentsBytes2.get(i6))) {
            i6++;
        }
        if (i6 == min && getBytes$okio().size() == path.getBytes$okio().size()) {
            return Companion.get$default(Companion, ".", false, 1, (Object) null);
        }
        if (!(segmentsBytes2.subList(i6, segmentsBytes2.size()).indexOf(_PathKt.access$getDOT_DOT$p()) == -1)) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + path).toString());
        }
        Buffer buffer = new Buffer();
        ByteString access$getSlash = _PathKt.access$getSlash(path);
        if (access$getSlash == null && (access$getSlash = _PathKt.access$getSlash(this)) == null) {
            access$getSlash = _PathKt.access$toSlash(DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i7 = i6; i7 < size; i7++) {
            buffer.write(_PathKt.access$getDOT_DOT$p());
            buffer.write(access$getSlash);
        }
        int size2 = segmentsBytes.size();
        while (i6 < size2) {
            buffer.write(segmentsBytes.get(i6));
            buffer.write(access$getSlash);
            i6++;
        }
        return _PathKt.toPath(buffer, false);
    }

    public final Path resolve(String str) {
        kotlin.jvm.internal.l.d(str, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(str), false), false);
    }

    public final File toFile() {
        return new File(toString());
    }

    @IgnoreJRERequirement
    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path;
        path = Paths.get(toString(), new String[0]);
        kotlin.jvm.internal.l.c(path, "get(toString())");
        return path;
    }

    public String toString() {
        return getBytes$okio().utf8();
    }

    public final Character volumeLetter() {
        boolean z5 = false;
        if (ByteString.indexOf$default(getBytes$okio(), _PathKt.access$getSLASH$p(), 0, 2, (Object) null) == -1 && getBytes$okio().size() >= 2 && getBytes$okio().getByte(1) == ((byte) 58)) {
            char c6 = (char) getBytes$okio().getByte(0);
            if (!('a' <= c6 && c6 < '{')) {
                if ('A' <= c6 && c6 < '[') {
                    z5 = true;
                }
                if (!z5) {
                    return null;
                }
            }
            return Character.valueOf(c6);
        }
        return null;
    }

    public static final Path get(File file, boolean z5) {
        return Companion.get(file, z5);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return path.resolve(byteString, z5);
    }

    @Override // java.lang.Comparable
    public int compareTo(Path path) {
        kotlin.jvm.internal.l.d(path, "other");
        return getBytes$okio().compareTo(path.getBytes$okio());
    }

    public final Path resolve(String str, boolean z5) {
        kotlin.jvm.internal.l.d(str, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(str), false), z5);
    }

    public static final Path get(String str) {
        return Companion.get(str);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return path.resolve(path2, z5);
    }

    public final Path resolve(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(byteString), false), false);
    }

    public static final Path get(String str, boolean z5) {
        return Companion.get(str, z5);
    }

    public final Path resolve(ByteString byteString, boolean z5) {
        kotlin.jvm.internal.l.d(byteString, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(byteString), false), z5);
    }

    @IgnoreJRERequirement
    public static final Path get(java.nio.file.Path path) {
        return Companion.get(path);
    }

    public final Path resolve(Path path) {
        kotlin.jvm.internal.l.d(path, "child");
        return _PathKt.commonResolve(this, path, false);
    }

    @IgnoreJRERequirement
    public static final Path get(java.nio.file.Path path, boolean z5) {
        return Companion.get(path, z5);
    }

    public final Path resolve(Path path, boolean z5) {
        kotlin.jvm.internal.l.d(path, "child");
        return _PathKt.commonResolve(this, path, z5);
    }
}
