package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.decoder.k;
import com.google.android.exoplayer2.s0;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class VideoDecoderOutputBuffer extends k {
    public static final int COLORSPACE_BT2020 = 3;
    public static final int COLORSPACE_BT601 = 1;
    public static final int COLORSPACE_BT709 = 2;
    public static final int COLORSPACE_UNKNOWN = 0;
    public int colorspace;
    public ByteBuffer data;
    public int decoderPrivate;
    public s0 format;
    public int height;
    public int mode;
    private final k.a owner;
    public ByteBuffer supplementalData;
    public int width;
    public ByteBuffer[] yuvPlanes;
    public int[] yuvStrides;

    public VideoDecoderOutputBuffer(k.a aVar) {
        this.owner = aVar;
    }

    private static boolean isSafeToMultiply(int i6, int i7) {
        return i6 >= 0 && i7 >= 0 && (i7 <= 0 || i6 < Integer.MAX_VALUE / i7);
    }

    public void init(long j6, int i6, ByteBuffer byteBuffer) {
        this.timeUs = j6;
        this.mode = i6;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            this.supplementalData = null;
            return;
        }
        addFlag(268435456);
        int limit = byteBuffer.limit();
        ByteBuffer byteBuffer2 = this.supplementalData;
        if (byteBuffer2 == null || byteBuffer2.capacity() < limit) {
            this.supplementalData = ByteBuffer.allocate(limit);
        } else {
            this.supplementalData.clear();
        }
        this.supplementalData.put(byteBuffer);
        this.supplementalData.flip();
        byteBuffer.position(0);
    }

    public void initForPrivateFrame(int i6, int i7) {
        this.width = i6;
        this.height = i7;
    }

    public boolean initForYuvFrame(int i6, int i7, int i8, int i9, int i10) {
        this.width = i6;
        this.height = i7;
        this.colorspace = i10;
        int i11 = (int) ((i7 + 1) / 2);
        if (isSafeToMultiply(i8, i7) && isSafeToMultiply(i9, i11)) {
            int i12 = i7 * i8;
            int i13 = i11 * i9;
            int i14 = (i13 * 2) + i12;
            if (isSafeToMultiply(i13, 2) && i14 >= i12) {
                ByteBuffer byteBuffer = this.data;
                if (byteBuffer == null || byteBuffer.capacity() < i14) {
                    this.data = ByteBuffer.allocateDirect(i14);
                } else {
                    this.data.position(0);
                    this.data.limit(i14);
                }
                if (this.yuvPlanes == null) {
                    this.yuvPlanes = new ByteBuffer[3];
                }
                ByteBuffer byteBuffer2 = this.data;
                ByteBuffer[] byteBufferArr = this.yuvPlanes;
                ByteBuffer slice = byteBuffer2.slice();
                byteBufferArr[0] = slice;
                slice.limit(i12);
                byteBuffer2.position(i12);
                ByteBuffer slice2 = byteBuffer2.slice();
                byteBufferArr[1] = slice2;
                slice2.limit(i13);
                byteBuffer2.position(i12 + i13);
                ByteBuffer slice3 = byteBuffer2.slice();
                byteBufferArr[2] = slice3;
                slice3.limit(i13);
                if (this.yuvStrides == null) {
                    this.yuvStrides = new int[3];
                }
                int[] iArr = this.yuvStrides;
                iArr[0] = i8;
                iArr[1] = i9;
                iArr[2] = i9;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.decoder.k
    public void release() {
        this.owner.a(this);
    }
}
