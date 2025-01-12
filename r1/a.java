package r1;

import com.google.android.exoplayer2.util.s0;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n1.e;
import n1.h;
/* loaded from: classes.dex */
public final class a extends h {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f12916c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: a  reason: collision with root package name */
    private final CharsetDecoder f12917a = com.google.common.base.b.f5585c.newDecoder();

    /* renamed from: b  reason: collision with root package name */
    private final CharsetDecoder f12918b = com.google.common.base.b.f5584b.newDecoder();

    private String c(ByteBuffer byteBuffer) {
        String charBuffer;
        CharsetDecoder charsetDecoder;
        try {
            charBuffer = this.f12917a.decode(byteBuffer).toString();
            charsetDecoder = this.f12917a;
        } catch (CharacterCodingException unused) {
            this.f12917a.reset();
            byteBuffer.rewind();
            try {
                charBuffer = this.f12918b.decode(byteBuffer).toString();
                charsetDecoder = this.f12918b;
            } catch (CharacterCodingException unused2) {
                this.f12918b.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.f12918b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } catch (Throwable th2) {
            this.f12917a.reset();
            byteBuffer.rewind();
            throw th2;
        }
        charsetDecoder.reset();
        byteBuffer.rewind();
        return charBuffer;
    }

    @Override // n1.h
    protected n1.a b(e eVar, ByteBuffer byteBuffer) {
        String c6 = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (c6 == null) {
            return new n1.a(new c(bArr, null, null));
        }
        Matcher matcher = f12916c.matcher(c6);
        String str2 = null;
        for (int i6 = 0; matcher.find(i6); i6 = matcher.end()) {
            String S0 = s0.S0(matcher.group(1));
            String group = matcher.group(2);
            if (S0 != null) {
                if (S0.equals("streamurl")) {
                    str2 = group;
                } else if (S0.equals("streamtitle")) {
                    str = group;
                }
            }
        }
        return new n1.a(new c(bArr, str, str2));
    }
}
