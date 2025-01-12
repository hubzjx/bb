package com.google.common.primitives;

import com.google.common.base.j;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class b {

    /* loaded from: classes.dex */
    private static class a extends AbstractList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        a(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && b.e(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                int size = size();
                if (aVar.size() != size) {
                    return false;
                }
                for (int i6 = 0; i6 < size; i6++) {
                    if (this.array[this.start + i6] != aVar.array[aVar.start + i6]) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i6) {
            j.h(i6, size());
            return Integer.valueOf(this.array[this.start + i6]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i6 = 1;
            for (int i7 = this.start; i7 < this.end; i7++) {
                i6 = (i6 * 31) + b.d(this.array[i7]);
            }
            return i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int e6;
            if (!(obj instanceof Integer) || (e6 = b.e(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return e6 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int f6;
            if (!(obj instanceof Integer) || (f6 = b.f(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return f6 - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer set(int i6, Integer num) {
            j.h(i6, size());
            int[] iArr = this.array;
            int i7 = this.start;
            int i8 = iArr[i7 + i6];
            iArr[i7 + i6] = ((Integer) j.j(num)).intValue();
            return Integer.valueOf(i8);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i6, int i7) {
            j.n(i6, i7, size());
            if (i6 == i7) {
                return Collections.emptyList();
            }
            int[] iArr = this.array;
            int i8 = this.start;
            return new a(iArr, i6 + i8, i8 + i7);
        }

        int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i6 = this.start;
            while (true) {
                i6++;
                if (i6 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.array[i6]);
            }
        }

        a(int[] iArr, int i6, int i7) {
            this.array = iArr;
            this.start = i6;
            this.end = i7;
        }
    }

    public static int c(int i6, int i7) {
        if (i6 < i7) {
            return -1;
        }
        return i6 > i7 ? 1 : 0;
    }

    public static int d(int i6) {
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(int[] iArr, int i6, int i7, int i8) {
        while (i7 < i8) {
            if (iArr[i7] == i6) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(int[] iArr, int i6, int i7, int i8) {
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            if (iArr[i9] == i6) {
                return i9;
            }
        }
        return -1;
    }

    public static int g(long j6) {
        if (j6 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j6 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j6;
    }

    public static int[] h(Collection collection) {
        if (collection instanceof a) {
            return ((a) collection).toIntArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = ((Number) j.j(array[i6])).intValue();
        }
        return iArr;
    }
}
