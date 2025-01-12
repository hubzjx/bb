package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.o;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.internal.l;
import okio.Buffer;
import okio.ByteString;
import okio.Path;
/* loaded from: classes.dex */
public final class _PathKt {
    private static final ByteString ANY_SLASH;
    private static final ByteString BACKSLASH;
    private static final ByteString DOT;
    private static final ByteString DOT_DOT;
    private static final ByteString SLASH;

    static {
        ByteString.Companion companion = ByteString.Companion;
        SLASH = companion.encodeUtf8("/");
        BACKSLASH = companion.encodeUtf8("\\");
        ANY_SLASH = companion.encodeUtf8("/\\");
        DOT = companion.encodeUtf8(".");
        DOT_DOT = companion.encodeUtf8("..");
    }

    public static final int commonCompareTo(Path path, Path path2) {
        l.d(path, "<this>");
        l.d(path2, "other");
        return path.getBytes$okio().compareTo(path2.getBytes$okio());
    }

    public static final boolean commonEquals(Path path, Object obj) {
        l.d(path, "<this>");
        return (obj instanceof Path) && l.a(((Path) obj).getBytes$okio(), path.getBytes$okio());
    }

    public static final int commonHashCode(Path path) {
        l.d(path, "<this>");
        return path.getBytes$okio().hashCode();
    }

    public static final boolean commonIsAbsolute(Path path) {
        l.d(path, "<this>");
        return rootLength(path) != -1;
    }

    public static final boolean commonIsRelative(Path path) {
        l.d(path, "<this>");
        return rootLength(path) == -1;
    }

    public static final boolean commonIsRoot(Path path) {
        l.d(path, "<this>");
        return rootLength(path) == path.getBytes$okio().size();
    }

    public static final String commonName(Path path) {
        l.d(path, "<this>");
        return path.nameBytes().utf8();
    }

    public static final ByteString commonNameBytes(Path path) {
        l.d(path, "<this>");
        int indexOfLastSlash = getIndexOfLastSlash(path);
        return indexOfLastSlash != -1 ? ByteString.substring$default(path.getBytes$okio(), indexOfLastSlash + 1, 0, 2, null) : (path.volumeLetter() == null || path.getBytes$okio().size() != 2) ? path.getBytes$okio() : ByteString.EMPTY;
    }

    public static final Path commonNormalized(Path path) {
        l.d(path, "<this>");
        return Path.Companion.get(path.toString(), true);
    }

    public static final Path commonParent(Path path) {
        l.d(path, "<this>");
        if (l.a(path.getBytes$okio(), DOT) || l.a(path.getBytes$okio(), SLASH) || l.a(path.getBytes$okio(), BACKSLASH) || lastSegmentIsDotDot(path)) {
            return null;
        }
        int indexOfLastSlash = getIndexOfLastSlash(path);
        if (indexOfLastSlash == 2 && path.volumeLetter() != null) {
            if (path.getBytes$okio().size() == 3) {
                return null;
            }
            return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 3, 1, null));
        } else if (indexOfLastSlash == 1 && path.getBytes$okio().startsWith(BACKSLASH)) {
            return null;
        } else {
            if (indexOfLastSlash != -1 || path.volumeLetter() == null) {
                return indexOfLastSlash == -1 ? new Path(DOT) : indexOfLastSlash == 0 ? new Path(ByteString.substring$default(path.getBytes$okio(), 0, 1, 1, null)) : new Path(ByteString.substring$default(path.getBytes$okio(), 0, indexOfLastSlash, 1, null));
            } else if (path.getBytes$okio().size() == 2) {
                return null;
            } else {
                return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 2, 1, null));
            }
        }
    }

    public static final Path commonRelativeTo(Path path, Path path2) {
        l.d(path, "<this>");
        l.d(path2, "other");
        if (!l.a(path.getRoot(), path2.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + path + " and " + path2).toString());
        }
        List<ByteString> segmentsBytes = path.getSegmentsBytes();
        List<ByteString> segmentsBytes2 = path2.getSegmentsBytes();
        int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i6 = 0;
        while (i6 < min && l.a(segmentsBytes.get(i6), segmentsBytes2.get(i6))) {
            i6++;
        }
        if (i6 == min && path.getBytes$okio().size() == path2.getBytes$okio().size()) {
            return Path.Companion.get$default(Path.Companion, ".", false, 1, (Object) null);
        }
        if (!(segmentsBytes2.subList(i6, segmentsBytes2.size()).indexOf(DOT_DOT) == -1)) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + path + " and " + path2).toString());
        }
        Buffer buffer = new Buffer();
        ByteString slash = getSlash(path2);
        if (slash == null && (slash = getSlash(path)) == null) {
            slash = toSlash(Path.DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i7 = i6; i7 < size; i7++) {
            buffer.write(DOT_DOT);
            buffer.write(slash);
        }
        int size2 = segmentsBytes.size();
        while (i6 < size2) {
            buffer.write(segmentsBytes.get(i6));
            buffer.write(slash);
            i6++;
        }
        return toPath(buffer, false);
    }

    public static final Path commonResolve(Path path, String str, boolean z5) {
        l.d(path, "<this>");
        l.d(str, "child");
        return commonResolve(path, toPath(new Buffer().writeUtf8(str), false), z5);
    }

    public static final Path commonRoot(Path path) {
        l.d(path, "<this>");
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            return null;
        }
        return new Path(path.getBytes$okio().substring(0, rootLength));
    }

    public static final List<String> commonSegments(Path path) {
        int p5;
        l.d(path, "<this>");
        ArrayList<ByteString> arrayList = new ArrayList();
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(rootLength) == ((byte) 92)) {
            rootLength++;
        }
        int size = path.getBytes$okio().size();
        int i6 = rootLength;
        while (rootLength < size) {
            if (path.getBytes$okio().getByte(rootLength) == ((byte) 47) || path.getBytes$okio().getByte(rootLength) == ((byte) 92)) {
                arrayList.add(path.getBytes$okio().substring(i6, rootLength));
                i6 = rootLength + 1;
            }
            rootLength++;
        }
        if (i6 < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(i6, path.getBytes$okio().size()));
        }
        p5 = o.p(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(p5);
        for (ByteString byteString : arrayList) {
            arrayList2.add(byteString.utf8());
        }
        return arrayList2;
    }

    public static final List<ByteString> commonSegmentsBytes(Path path) {
        l.d(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(rootLength) == ((byte) 92)) {
            rootLength++;
        }
        int size = path.getBytes$okio().size();
        int i6 = rootLength;
        while (rootLength < size) {
            if (path.getBytes$okio().getByte(rootLength) == ((byte) 47) || path.getBytes$okio().getByte(rootLength) == ((byte) 92)) {
                arrayList.add(path.getBytes$okio().substring(i6, rootLength));
                i6 = rootLength + 1;
            }
            rootLength++;
        }
        if (i6 < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(i6, path.getBytes$okio().size()));
        }
        return arrayList;
    }

    public static final Path commonToPath(String str, boolean z5) {
        l.d(str, "<this>");
        return toPath(new Buffer().writeUtf8(str), z5);
    }

    public static final String commonToString(Path path) {
        l.d(path, "<this>");
        return path.getBytes$okio().utf8();
    }

    public static final Character commonVolumeLetter(Path path) {
        l.d(path, "<this>");
        boolean z5 = false;
        if (ByteString.indexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null) == -1 && path.getBytes$okio().size() >= 2 && path.getBytes$okio().getByte(1) == ((byte) 58)) {
            char c6 = (char) path.getBytes$okio().getByte(0);
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

    private static /* synthetic */ void getANY_SLASH$annotations() {
    }

    private static /* synthetic */ void getBACKSLASH$annotations() {
    }

    private static /* synthetic */ void getDOT$annotations() {
    }

    private static /* synthetic */ void getDOT_DOT$annotations() {
    }

    public static final int getIndexOfLastSlash(Path path) {
        int lastIndexOf$default = ByteString.lastIndexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null);
        return lastIndexOf$default != -1 ? lastIndexOf$default : ByteString.lastIndexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, (Object) null);
    }

    private static /* synthetic */ void getSLASH$annotations() {
    }

    public static final ByteString getSlash(Path path) {
        ByteString bytes$okio = path.getBytes$okio();
        ByteString byteString = SLASH;
        if (ByteString.indexOf$default(bytes$okio, byteString, 0, 2, (Object) null) != -1) {
            return byteString;
        }
        ByteString bytes$okio2 = path.getBytes$okio();
        ByteString byteString2 = BACKSLASH;
        if (ByteString.indexOf$default(bytes$okio2, byteString2, 0, 2, (Object) null) != -1) {
            return byteString2;
        }
        return null;
    }

    public static final boolean lastSegmentIsDotDot(Path path) {
        return path.getBytes$okio().endsWith(DOT_DOT) && (path.getBytes$okio().size() == 2 || path.getBytes$okio().rangeEquals(path.getBytes$okio().size() + (-3), SLASH, 0, 1) || path.getBytes$okio().rangeEquals(path.getBytes$okio().size() + (-3), BACKSLASH, 0, 1));
    }

    public static final int rootLength(Path path) {
        if (path.getBytes$okio().size() == 0) {
            return -1;
        }
        boolean z5 = false;
        if (path.getBytes$okio().getByte(0) == ((byte) 47)) {
            return 1;
        }
        byte b6 = (byte) 92;
        if (path.getBytes$okio().getByte(0) == b6) {
            if (path.getBytes$okio().size() <= 2 || path.getBytes$okio().getByte(1) != b6) {
                return 1;
            }
            int indexOf = path.getBytes$okio().indexOf(BACKSLASH, 2);
            return indexOf == -1 ? path.getBytes$okio().size() : indexOf;
        } else if (path.getBytes$okio().size() > 2 && path.getBytes$okio().getByte(1) == ((byte) 58) && path.getBytes$okio().getByte(2) == b6) {
            char c6 = (char) path.getBytes$okio().getByte(0);
            if ('a' <= c6 && c6 < '{') {
                return 3;
            }
            if ('A' <= c6 && c6 < '[') {
                z5 = true;
            }
            return !z5 ? -1 : 3;
        } else {
            return -1;
        }
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer, ByteString byteString) {
        if (l.a(byteString, BACKSLASH) && buffer.size() >= 2 && buffer.getByte(1L) == ((byte) 58)) {
            char c6 = (char) buffer.getByte(0L);
            if (!('a' <= c6 && c6 < '{')) {
                if (!('A' <= c6 && c6 < '[')) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Path toPath(Buffer buffer, boolean z5) {
        ByteString byteString;
        int size;
        ByteString readByteString;
        Object G;
        l.d(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        ByteString byteString2 = null;
        int i6 = 0;
        while (true) {
            if (!buffer.rangeEquals(0L, SLASH)) {
                byteString = BACKSLASH;
                if (!buffer.rangeEquals(0L, byteString)) {
                    break;
                }
            }
            byte readByte = buffer.readByte();
            if (byteString2 == null) {
                byteString2 = toSlash(readByte);
            }
            i6++;
        }
        boolean z6 = i6 >= 2 && l.a(byteString2, byteString);
        if (z6) {
            l.b(byteString2);
            buffer2.write(byteString2);
        } else if (i6 <= 0) {
            long indexOfElement = buffer.indexOfElement(ANY_SLASH);
            if (byteString2 == null) {
                byteString2 = indexOfElement == -1 ? toSlash(Path.DIRECTORY_SEPARATOR) : toSlash(buffer.getByte(indexOfElement));
            }
            if (startsWithVolumeLetterAndColon(buffer, byteString2)) {
                if (indexOfElement == 2) {
                    buffer2.write(buffer, 3L);
                } else {
                    buffer2.write(buffer, 2L);
                }
            }
            boolean z7 = buffer2.size() <= 0;
            ArrayList arrayList = new ArrayList();
            while (!buffer.exhausted()) {
                long indexOfElement2 = buffer.indexOfElement(ANY_SLASH);
                if (indexOfElement2 == -1) {
                    readByteString = buffer.readByteString();
                } else {
                    readByteString = buffer.readByteString(indexOfElement2);
                    buffer.readByte();
                }
                ByteString byteString3 = DOT_DOT;
                if (l.a(readByteString, byteString3)) {
                    if (!z7 || !arrayList.isEmpty()) {
                        if (z5) {
                            if (!z7) {
                                if (!arrayList.isEmpty()) {
                                    G = v.G(arrayList);
                                    if (l.a(G, byteString3)) {
                                    }
                                }
                            }
                            if (!z6 || arrayList.size() != 1) {
                                s.v(arrayList);
                            }
                        }
                        arrayList.add(readByteString);
                    }
                } else if (!l.a(readByteString, DOT) && !l.a(readByteString, ByteString.EMPTY)) {
                    arrayList.add(readByteString);
                }
            }
            size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                if (i7 > 0) {
                    buffer2.write(byteString2);
                }
                buffer2.write((ByteString) arrayList.get(i7));
            }
            if (buffer2.size() == 0) {
                buffer2.write(DOT);
            }
            return new Path(buffer2.readByteString());
        } else {
            l.b(byteString2);
        }
        buffer2.write(byteString2);
        if (buffer2.size() <= 0) {
        }
        ArrayList arrayList2 = new ArrayList();
        while (!buffer.exhausted()) {
        }
        size = arrayList2.size();
        while (i7 < size) {
        }
        if (buffer2.size() == 0) {
        }
        return new Path(buffer2.readByteString());
    }

    private static final ByteString toSlash(byte b6) {
        if (b6 == 47) {
            return SLASH;
        }
        if (b6 == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + ((int) b6));
    }

    public static final Path commonResolve(Path path, Buffer buffer, boolean z5) {
        l.d(path, "<this>");
        l.d(buffer, "child");
        return commonResolve(path, toPath(buffer, false), z5);
    }

    public static final ByteString toSlash(String str) {
        if (l.a(str, "/")) {
            return SLASH;
        }
        if (l.a(str, "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }

    public static final Path commonResolve(Path path, ByteString byteString, boolean z5) {
        l.d(path, "<this>");
        l.d(byteString, "child");
        return commonResolve(path, toPath(new Buffer().write(byteString), false), z5);
    }

    public static final Path commonResolve(Path path, Path path2, boolean z5) {
        l.d(path, "<this>");
        l.d(path2, "child");
        if (path2.isAbsolute() || path2.volumeLetter() != null) {
            return path2;
        }
        ByteString slash = getSlash(path);
        if (slash == null && (slash = getSlash(path2)) == null) {
            slash = toSlash(Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(path.getBytes$okio());
        if (buffer.size() > 0) {
            buffer.write(slash);
        }
        buffer.write(path2.getBytes$okio());
        return toPath(buffer, z5);
    }
}
