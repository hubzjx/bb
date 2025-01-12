package okio;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    Buffer buffer();

    BufferedSink emit();

    BufferedSink emitCompleteSegments();

    @Override // okio.Sink, java.io.Flushable
    void flush();

    Buffer getBuffer();

    OutputStream outputStream();

    BufferedSink write(ByteString byteString);

    BufferedSink write(ByteString byteString, int i6, int i7);

    BufferedSink write(Source source, long j6);

    BufferedSink write(byte[] bArr);

    BufferedSink write(byte[] bArr, int i6, int i7);

    long writeAll(Source source);

    BufferedSink writeByte(int i6);

    BufferedSink writeDecimalLong(long j6);

    BufferedSink writeHexadecimalUnsignedLong(long j6);

    BufferedSink writeInt(int i6);

    BufferedSink writeIntLe(int i6);

    BufferedSink writeLong(long j6);

    BufferedSink writeLongLe(long j6);

    BufferedSink writeShort(int i6);

    BufferedSink writeShortLe(int i6);

    BufferedSink writeString(String str, int i6, int i7, Charset charset);

    BufferedSink writeString(String str, Charset charset);

    BufferedSink writeUtf8(String str);

    BufferedSink writeUtf8(String str, int i6, int i7);

    BufferedSink writeUtf8CodePoint(int i6);
}
