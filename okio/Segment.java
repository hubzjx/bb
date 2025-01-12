package okio;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class Segment {
    public static final Companion Companion = new Companion(null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public Segment() {
        this.data = new byte[SIZE];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        Segment segment = this.prev;
        int i6 = 0;
        if (!(segment != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        kotlin.jvm.internal.l.b(segment);
        if (segment.owner) {
            int i7 = this.limit - this.pos;
            Segment segment2 = this.prev;
            kotlin.jvm.internal.l.b(segment2);
            int i8 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            kotlin.jvm.internal.l.b(segment3);
            if (!segment3.shared) {
                Segment segment4 = this.prev;
                kotlin.jvm.internal.l.b(segment4);
                i6 = segment4.pos;
            }
            if (i7 > i8 + i6) {
                return;
            }
            Segment segment5 = this.prev;
            kotlin.jvm.internal.l.b(segment5);
            writeTo(segment5, i7);
            pop();
            SegmentPool.recycle(this);
        }
    }

    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        kotlin.jvm.internal.l.b(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        kotlin.jvm.internal.l.b(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        kotlin.jvm.internal.l.d(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        kotlin.jvm.internal.l.b(segment2);
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i6) {
        Segment take;
        if (i6 > 0 && i6 <= this.limit - this.pos) {
            if (i6 >= 1024) {
                take = sharedCopy();
            } else {
                take = SegmentPool.take();
                byte[] bArr = this.data;
                byte[] bArr2 = take.data;
                int i7 = this.pos;
                kotlin.collections.i.f(bArr, bArr2, 0, i7, i7 + i6, 2, null);
            }
            take.limit = take.pos + i6;
            this.pos += i6;
            Segment segment = this.prev;
            kotlin.jvm.internal.l.b(segment);
            segment.push(take);
            return take;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.l.c(copyOf, "copyOf(this, size)");
        return new Segment(copyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment segment, int i6) {
        kotlin.jvm.internal.l.d(segment, "sink");
        if (!segment.owner) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i7 = segment.limit;
        if (i7 + i6 > 8192) {
            if (segment.shared) {
                throw new IllegalArgumentException();
            }
            int i8 = segment.pos;
            if ((i7 + i6) - i8 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.data;
            kotlin.collections.i.f(bArr, bArr, 0, i8, i7, 2, null);
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = segment.data;
        int i9 = segment.limit;
        int i10 = this.pos;
        kotlin.collections.i.d(bArr2, bArr3, i9, i10, i10 + i6);
        segment.limit += i6;
        this.pos += i6;
    }

    public Segment(byte[] bArr, int i6, int i7, boolean z5, boolean z6) {
        kotlin.jvm.internal.l.d(bArr, "data");
        this.data = bArr;
        this.pos = i6;
        this.limit = i7;
        this.shared = z5;
        this.owner = z6;
    }
}
