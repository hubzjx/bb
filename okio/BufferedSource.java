package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    Buffer buffer();

    boolean exhausted();

    Buffer getBuffer();

    long indexOf(byte b6);

    long indexOf(byte b6, long j6);

    long indexOf(byte b6, long j6, long j7);

    long indexOf(ByteString byteString);

    long indexOf(ByteString byteString, long j6);

    long indexOfElement(ByteString byteString);

    long indexOfElement(ByteString byteString, long j6);

    InputStream inputStream();

    BufferedSource peek();

    boolean rangeEquals(long j6, ByteString byteString);

    boolean rangeEquals(long j6, ByteString byteString, int i6, int i7);

    int read(byte[] bArr);

    int read(byte[] bArr, int i6, int i7);

    long readAll(Sink sink);

    byte readByte();

    byte[] readByteArray();

    byte[] readByteArray(long j6);

    ByteString readByteString();

    ByteString readByteString(long j6);

    long readDecimalLong();

    void readFully(Buffer buffer, long j6);

    void readFully(byte[] bArr);

    long readHexadecimalUnsignedLong();

    int readInt();

    int readIntLe();

    long readLong();

    long readLongLe();

    short readShort();

    short readShortLe();

    String readString(long j6, Charset charset);

    String readString(Charset charset);

    String readUtf8();

    String readUtf8(long j6);

    int readUtf8CodePoint();

    String readUtf8Line();

    String readUtf8LineStrict();

    String readUtf8LineStrict(long j6);

    boolean request(long j6);

    void require(long j6);

    int select(Options options);

    void skip(long j6);
}
