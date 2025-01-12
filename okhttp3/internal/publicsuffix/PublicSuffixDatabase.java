package okhttp3.internal.publicsuffix;

import h4.q;
import io.jsonwebtoken.JwtParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.d;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.text.x;
import n4.a;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
/* loaded from: classes.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final PublicSuffixDatabase instance;
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    public static final Companion Companion = new Companion(null);
    private static final byte[] WILDCARD_LABEL = {42};
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i6) {
            int i7;
            boolean z5;
            int and;
            int and2;
            int length = bArr.length;
            int i8 = 0;
            while (i8 < length) {
                int i9 = (i8 + length) / 2;
                while (i9 > -1 && bArr[i9] != 10) {
                    i9--;
                }
                int i10 = i9 + 1;
                int i11 = 1;
                while (true) {
                    i7 = i10 + i11;
                    if (bArr[i7] == 10) {
                        break;
                    }
                    i11++;
                }
                int i12 = i7 - i10;
                int i13 = i6;
                boolean z6 = false;
                int i14 = 0;
                int i15 = 0;
                while (true) {
                    if (z6) {
                        and = 46;
                        z5 = false;
                    } else {
                        z5 = z6;
                        and = Util.and(bArr2[i13][i14], 255);
                    }
                    and2 = and - Util.and(bArr[i10 + i15], 255);
                    if (and2 != 0) {
                        break;
                    }
                    i15++;
                    i14++;
                    if (i15 == i12) {
                        break;
                    } else if (bArr2[i13].length != i14) {
                        z6 = z5;
                    } else if (i13 == bArr2.length - 1) {
                        break;
                    } else {
                        i13++;
                        z6 = true;
                        i14 = -1;
                    }
                }
                if (and2 >= 0) {
                    if (and2 <= 0) {
                        int i16 = i12 - i15;
                        int length2 = bArr2[i13].length - i14;
                        int length3 = bArr2.length;
                        for (int i17 = i13 + 1; i17 < length3; i17++) {
                            length2 += bArr2[i17].length;
                        }
                        if (length2 >= i16) {
                            if (length2 <= i16) {
                                Charset charset = StandardCharsets.UTF_8;
                                l.c(charset, "UTF_8");
                                return new String(bArr, i10, i12, charset);
                            }
                        }
                    }
                    i8 = i7 + 1;
                }
                length = i10 - 1;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }
    }

    static {
        List<String> b6;
        b6 = m.b(d.ANY_MARKER);
        PREVAILING_RULE = b6;
        instance = new PublicSuffixDatabase();
    }

    private final List<String> findMatchingRule(List<String> list) {
        String str;
        String str2;
        String str3;
        List<String> j02;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.publicSuffixListBytes != null) {
            int size = list.size();
            byte[][] bArr = new byte[size];
            for (int i6 = 0; i6 < size; i6++) {
                Charset charset = StandardCharsets.UTF_8;
                l.c(charset, "UTF_8");
                byte[] bytes = list.get(i6).getBytes(charset);
                l.c(bytes, "this as java.lang.String).getBytes(charset)");
                bArr[i6] = bytes;
            }
            int i7 = 0;
            while (true) {
                if (i7 >= size) {
                    str = null;
                    break;
                }
                int i8 = i7 + 1;
                Companion companion = Companion;
                byte[] bArr2 = this.publicSuffixListBytes;
                if (bArr2 == null) {
                    l.m("publicSuffixListBytes");
                    bArr2 = null;
                }
                String binarySearch = companion.binarySearch(bArr2, bArr, i7);
                if (binarySearch != null) {
                    str = binarySearch;
                    break;
                }
                i7 = i8;
            }
            if (size > 1) {
                byte[][] bArr3 = (byte[][]) bArr.clone();
                int length = bArr3.length - 1;
                int i9 = 0;
                while (i9 < length) {
                    int i10 = i9 + 1;
                    bArr3[i9] = WILDCARD_LABEL;
                    Companion companion2 = Companion;
                    byte[] bArr4 = this.publicSuffixListBytes;
                    if (bArr4 == null) {
                        l.m("publicSuffixListBytes");
                        bArr4 = null;
                    }
                    String binarySearch2 = companion2.binarySearch(bArr4, bArr3, i9);
                    if (binarySearch2 != null) {
                        str2 = binarySearch2;
                        break;
                    }
                    i9 = i10;
                }
            }
            str2 = null;
            if (str2 != null) {
                int i11 = size - 1;
                int i12 = 0;
                while (i12 < i11) {
                    int i13 = i12 + 1;
                    Companion companion3 = Companion;
                    byte[] bArr5 = this.publicSuffixExceptionListBytes;
                    if (bArr5 == null) {
                        l.m("publicSuffixExceptionListBytes");
                        bArr5 = null;
                    }
                    str3 = companion3.binarySearch(bArr5, bArr, i12);
                    if (str3 != null) {
                        break;
                    }
                    i12 = i13;
                }
            }
            str3 = null;
            if (str3 != null) {
                j02 = x.j0(l.i("!", str3), new char[]{JwtParser.SEPARATOR_CHAR}, false, 0, 6, null);
                return j02;
            } else if (str == null && str2 == null) {
                return PREVAILING_RULE;
            } else {
                List<String> j03 = str == null ? null : x.j0(str, new char[]{JwtParser.SEPARATOR_CHAR}, false, 0, 6, null);
                if (j03 == null) {
                    j03 = n.f();
                }
                List<String> j04 = str2 != null ? x.j0(str2, new char[]{JwtParser.SEPARATOR_CHAR}, false, 0, 6, null) : null;
                if (j04 == null) {
                    j04 = n.f();
                }
                return j03.size() > j04.size() ? j03 : j04;
            }
        }
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
    }

    private final void readTheList() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] readByteArray = buffer.readByteArray(buffer.readInt());
            byte[] readByteArray2 = buffer.readByteArray(buffer.readInt());
            q qVar = q.f10774a;
            a.a(buffer, null);
            synchronized (this) {
                l.b(readByteArray);
                this.publicSuffixListBytes = readByteArray;
                l.b(readByteArray2);
                this.publicSuffixExceptionListBytes = readByteArray2;
            }
            this.readCompleteLatch.countDown();
        } finally {
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z5 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z5 = true;
                } catch (IOException e6) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e6);
                    if (z5) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> splitDomain(String str) {
        List<String> j02;
        Object G;
        List<String> y5;
        j02 = x.j0(str, new char[]{JwtParser.SEPARATOR_CHAR}, false, 0, 6, null);
        G = v.G(j02);
        if (l.a(G, HttpUrl.FRAGMENT_ENCODE_SET)) {
            y5 = v.y(j02, 1);
            return y5;
        }
        return j02;
    }

    public final String getEffectiveTldPlusOne(String str) {
        t4.d x5;
        t4.d e6;
        String h6;
        l.d(str, "domain");
        String unicode = IDN.toUnicode(str);
        l.c(unicode, "unicodeDomain");
        List<String> splitDomain = splitDomain(unicode);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() != findMatchingRule.size() || findMatchingRule.get(0).charAt(0) == '!') {
            char charAt = findMatchingRule.get(0).charAt(0);
            int size = splitDomain.size();
            int size2 = findMatchingRule.size();
            if (charAt != '!') {
                size2++;
            }
            x5 = v.x(splitDomain(str));
            e6 = t4.l.e(x5, size - size2);
            h6 = t4.l.h(e6, ".", null, null, 0, null, null, 62, null);
            return h6;
        }
        return null;
    }

    public final void setListBytes(byte[] bArr, byte[] bArr2) {
        l.d(bArr, "publicSuffixListBytes");
        l.d(bArr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
