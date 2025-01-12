package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public final class Options extends kotlin.collections.b implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final void buildTrieRecursive(long j6, Buffer buffer, int i6, List<? extends ByteString> list, int i7, int i8, List<Integer> list2) {
            int i9;
            int i10;
            int i11;
            int i12;
            Buffer buffer2;
            int i13 = i6;
            if (!(i7 < i8)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i14 = i7; i14 < i8; i14++) {
                if (!(list.get(i14).size() >= i13)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            ByteString byteString = list.get(i7);
            ByteString byteString2 = list.get(i8 - 1);
            if (i13 == byteString.size()) {
                int i15 = i7 + 1;
                i9 = i15;
                i10 = list2.get(i7).intValue();
                byteString = list.get(i15);
            } else {
                i9 = i7;
                i10 = -1;
            }
            if (byteString.getByte(i13) == byteString2.getByte(i13)) {
                int min = Math.min(byteString.size(), byteString2.size());
                int i16 = 0;
                for (int i17 = i13; i17 < min && byteString.getByte(i17) == byteString2.getByte(i17); i17++) {
                    i16++;
                }
                long intCount = j6 + getIntCount(buffer) + 2 + i16 + 1;
                buffer.writeInt(-i16);
                buffer.writeInt(i10);
                int i18 = i13 + i16;
                while (i13 < i18) {
                    buffer.writeInt(byteString.getByte(i13) & 255);
                    i13++;
                }
                if (i9 + 1 == i8) {
                    if (!(i18 == list.get(i9).size())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    buffer.writeInt(list2.get(i9).intValue());
                    return;
                }
                Buffer buffer3 = new Buffer();
                buffer.writeInt(((int) (getIntCount(buffer3) + intCount)) * (-1));
                buildTrieRecursive(intCount, buffer3, i18, list, i9, i8, list2);
                buffer.writeAll(buffer3);
                return;
            }
            int i19 = 1;
            for (int i20 = i9 + 1; i20 < i8; i20++) {
                if (list.get(i20 - 1).getByte(i13) != list.get(i20).getByte(i13)) {
                    i19++;
                }
            }
            long intCount2 = j6 + getIntCount(buffer) + 2 + (i19 * 2);
            buffer.writeInt(i19);
            buffer.writeInt(i10);
            for (int i21 = i9; i21 < i8; i21++) {
                byte b6 = list.get(i21).getByte(i13);
                if (i21 == i9 || b6 != list.get(i21 - 1).getByte(i13)) {
                    buffer.writeInt(b6 & 255);
                }
            }
            Buffer buffer4 = new Buffer();
            while (i9 < i8) {
                byte b7 = list.get(i9).getByte(i13);
                int i22 = i9 + 1;
                int i23 = i22;
                while (true) {
                    if (i23 >= i8) {
                        i11 = i8;
                        break;
                    } else if (b7 != list.get(i23).getByte(i13)) {
                        i11 = i23;
                        break;
                    } else {
                        i23++;
                    }
                }
                if (i22 == i11 && i13 + 1 == list.get(i9).size()) {
                    buffer.writeInt(list2.get(i9).intValue());
                    i12 = i11;
                    buffer2 = buffer4;
                } else {
                    buffer.writeInt(((int) (intCount2 + getIntCount(buffer4))) * (-1));
                    i12 = i11;
                    buffer2 = buffer4;
                    buildTrieRecursive(intCount2, buffer4, i13 + 1, list, i9, i11, list2);
                }
                buffer4 = buffer2;
                i9 = i12;
            }
            buffer.writeAll(buffer4);
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j6, Buffer buffer, int i6, List list, int i7, int i8, List list2, int i9, Object obj) {
            companion.buildTrieRecursive((i9 & 1) != 0 ? 0L : j6, buffer, (i9 & 4) != 0 ? 0 : i6, list, (i9 & 16) != 0 ? 0 : i7, (i9 & 32) != 0 ? list.size() : i8, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:58:0x00eb, code lost:
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Options of(ByteString... byteStringArr) {
            List w5;
            List k6;
            int e6;
            kotlin.jvm.internal.l.d(byteStringArr, "byteStrings");
            int i6 = 0;
            if (byteStringArr.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, null);
            }
            w5 = kotlin.collections.j.w(byteStringArr);
            kotlin.collections.r.q(w5);
            ArrayList arrayList = new ArrayList(byteStringArr.length);
            for (ByteString byteString : byteStringArr) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array != null) {
                Integer[] numArr = (Integer[]) array;
                k6 = kotlin.collections.n.k(Arrays.copyOf(numArr, numArr.length));
                int length = byteStringArr.length;
                int i7 = 0;
                int i8 = 0;
                while (i7 < length) {
                    e6 = kotlin.collections.n.e(w5, byteStringArr[i7], 0, 0, 6, null);
                    k6.set(e6, Integer.valueOf(i8));
                    i7++;
                    i8++;
                }
                if (((ByteString) w5.get(0)).size() > 0) {
                    int i9 = 0;
                    while (i9 < w5.size()) {
                        ByteString byteString2 = (ByteString) w5.get(i9);
                        int i10 = i9 + 1;
                        int i11 = i10;
                        while (i11 < w5.size()) {
                            ByteString byteString3 = (ByteString) w5.get(i11);
                            if (byteString3.startsWith(byteString2)) {
                                if (!(byteString3.size() != byteString2.size())) {
                                    throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                                } else if (((Number) k6.get(i11)).intValue() > ((Number) k6.get(i9)).intValue()) {
                                    w5.remove(i11);
                                    k6.remove(i11);
                                } else {
                                    i11++;
                                }
                            }
                        }
                        i9 = i10;
                    }
                    Buffer buffer = new Buffer();
                    buildTrieRecursive$default(this, 0L, buffer, 0, w5, 0, 0, k6, 53, null);
                    int[] iArr = new int[(int) getIntCount(buffer)];
                    while (!buffer.exhausted()) {
                        iArr[i6] = buffer.readInt();
                        i6++;
                    }
                    Object[] copyOf = Arrays.copyOf(byteStringArr, byteStringArr.length);
                    kotlin.jvm.internal.l.c(copyOf, "copyOf(this, size)");
                    return new Options((ByteString[]) copyOf, iArr, null);
                }
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public static final Options of(ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    @Override // kotlin.collections.a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.a
    public int getSize() {
        return this.byteStrings.length;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, kotlin.jvm.internal.g gVar) {
        this(byteStringArr, iArr);
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    @Override // kotlin.collections.b, java.util.List
    public ByteString get(int i6) {
        return this.byteStrings[i6];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }
}
