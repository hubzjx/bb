package com.google.gson.stream;

import androidx.constraintlayout.widget.g;
import com.google.gson.internal.f;
import io.jsonwebtoken.JwtParser;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import okio.Segment;
/* loaded from: classes.dex */
public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Reader in;
    private int[] pathIndices;
    private String[] pathNames;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int[] stack;
    private boolean lenient = false;
    private final char[] buffer = new char[Segment.SHARE_MINIMUM];
    private int pos = 0;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    int peeked = 0;
    private int stackSize = 0 + 1;

    static {
        f.INSTANCE = new f() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.f
            public void promoteNameToValue(JsonReader jsonReader) {
                int i6;
                int i7 = jsonReader.peeked;
                if (i7 == 0) {
                    i7 = jsonReader.doPeek();
                }
                if (i7 == 13) {
                    i6 = 9;
                } else if (i7 == 12) {
                    i6 = 8;
                } else if (i7 != 14) {
                    throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
                } else {
                    i6 = 10;
                }
                jsonReader.peeked = i6;
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    private void checkLenient() {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() {
        nextNonWhitespace(true);
        int i6 = this.pos - 1;
        this.pos = i6;
        if (i6 + 5 <= this.limit || fillBuffer(5)) {
            char[] cArr = this.buffer;
            if (cArr[i6] == ')' && cArr[i6 + 1] == ']' && cArr[i6 + 2] == '}' && cArr[i6 + 3] == '\'' && cArr[i6 + 4] == '\n') {
                this.pos += 5;
            }
        }
    }

    private boolean fillBuffer(int i6) {
        int i7;
        int i8;
        char[] cArr = this.buffer;
        int i9 = this.lineStart;
        int i10 = this.pos;
        this.lineStart = i9 - i10;
        int i11 = this.limit;
        if (i11 != i10) {
            int i12 = i11 - i10;
            this.limit = i12;
            System.arraycopy(cArr, i10, cArr, 0, i12);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i13 = this.limit;
            int read = reader.read(cArr, i13, cArr.length - i13);
            if (read == -1) {
                return false;
            }
            i7 = this.limit + read;
            this.limit = i7;
            if (this.lineNumber == 0 && (i8 = this.lineStart) == 0 && i7 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i8 + 1;
                i6++;
                continue;
            }
        } while (i7 < i6);
        return true;
    }

    private boolean isLiteral(char c6) {
        if (c6 == '\t' || c6 == '\n' || c6 == '\f' || c6 == '\r' || c6 == ' ') {
            return false;
        }
        if (c6 != '#') {
            if (c6 == ',') {
                return false;
            }
            if (c6 != '/' && c6 != '=') {
                if (c6 == '{' || c6 == '}' || c6 == ':') {
                    return false;
                }
                if (c6 != ';') {
                    switch (c6) {
                        case g.J0 /* 91 */:
                        case g.L0 /* 93 */:
                            return false;
                        case g.K0 /* 92 */:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
        if (r1 != '/') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
        r7.pos = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r4 != r2) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        r7.pos = r4 - 1;
        r2 = fillBuffer(2);
        r7.pos++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
        if (r2 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
        checkLenient();
        r2 = r7.pos;
        r3 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
        if (r3 == '*') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
        if (r3 == '/') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0078, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0080, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
        if (skipTo("*\/") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0098, code lost:
        r7.pos = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009c, code lost:
        if (r1 != '#') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009e, code lost:
        checkLenient();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a2, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int nextNonWhitespace(boolean z5) {
        char[] cArr = this.buffer;
        while (true) {
            int i6 = this.pos;
            while (true) {
                int i7 = this.limit;
                while (true) {
                    if (i6 == i7) {
                        this.pos = i6;
                        if (!fillBuffer(1)) {
                            if (z5) {
                                throw new EOFException("End of input" + locationString());
                            }
                            return -1;
                        }
                        i6 = this.pos;
                        i7 = this.limit;
                    }
                    int i8 = i6 + 1;
                    char c6 = cArr[i6];
                    if (c6 != '\n') {
                        if (c6 != ' ' && c6 != '\r' && c6 != '\t') {
                            break;
                        }
                    } else {
                        this.lineNumber++;
                        this.lineStart = i8;
                    }
                    i6 = i8;
                }
                i6 = this.pos + 2;
            }
            skipToEndOfLine();
        }
    }

    private String nextQuotedValue(char c6) {
        char[] cArr = this.buffer;
        StringBuilder sb = null;
        while (true) {
            int i6 = this.pos;
            int i7 = this.limit;
            while (true) {
                if (i6 < i7) {
                    int i8 = i6 + 1;
                    char c7 = cArr[i6];
                    if (c7 == c6) {
                        this.pos = i8;
                        int i9 = (i8 - i6) - 1;
                        if (sb == null) {
                            return new String(cArr, i6, i9);
                        }
                        sb.append(cArr, i6, i9);
                        return sb.toString();
                    } else if (c7 == '\\') {
                        this.pos = i8;
                        int i10 = (i8 - i6) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i10 + 1) * 2, 16));
                        }
                        sb.append(cArr, i6, i10);
                        sb.append(readEscapeCharacter());
                    } else {
                        if (c7 == '\n') {
                            this.lineNumber++;
                            this.lineStart = i8;
                        }
                        i6 = i8;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i6 - i6) * 2, 16));
                    }
                    sb.append(cArr, i6, i6 - i6);
                    this.pos = i6;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        checkLenient();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String nextUnquotedValue() {
        String sb;
        StringBuilder sb2 = null;
        int i6 = 0;
        do {
            int i7 = 0;
            while (true) {
                int i8 = this.pos;
                if (i8 + i7 < this.limit) {
                    char c6 = this.buffer[i8 + i7];
                    if (c6 != '\t' && c6 != '\n' && c6 != '\f' && c6 != '\r' && c6 != ' ') {
                        if (c6 != '#') {
                            if (c6 != ',') {
                                if (c6 != '/' && c6 != '=') {
                                    if (c6 != '{' && c6 != '}' && c6 != ':') {
                                        if (c6 != ';') {
                                            switch (c6) {
                                                case g.J0 /* 91 */:
                                                case g.L0 /* 93 */:
                                                    break;
                                                case g.K0 /* 92 */:
                                                    break;
                                                default:
                                                    i7++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i7 >= this.buffer.length) {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i7, 16));
                    }
                    sb2.append(this.buffer, this.pos, i7);
                    this.pos += i7;
                } else if (fillBuffer(i7 + 1)) {
                }
            }
            i6 = i7;
            if (sb2 != null) {
                sb = new String(this.buffer, this.pos, i6);
            } else {
                sb2.append(this.buffer, this.pos, i6);
                sb = sb2.toString();
            }
            this.pos += i6;
            return sb;
        } while (fillBuffer(1));
        if (sb2 != null) {
        }
        this.pos += i6;
        return sb;
    }

    private int peekKeyword() {
        String str;
        String str2;
        int i6;
        char c6 = this.buffer[this.pos];
        if (c6 == 't' || c6 == 'T') {
            str = "true";
            str2 = "TRUE";
            i6 = 5;
        } else if (c6 == 'f' || c6 == 'F') {
            str = "false";
            str2 = "FALSE";
            i6 = 6;
        } else if (c6 != 'n' && c6 != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i6 = 7;
        }
        int length = str.length();
        for (int i7 = 1; i7 < length; i7++) {
            if (this.pos + i7 >= this.limit && !fillBuffer(i7 + 1)) {
                return 0;
            }
            char c7 = this.buffer[this.pos + i7];
            if (c7 != str.charAt(i7) && c7 != str2.charAt(i7)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i6;
        return i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        if (isLiteral(r14) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (r9 != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        if (r10 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
        if (r13 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a7, code lost:
        if (r11 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a9, code lost:
        if (r13 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ae, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00af, code lost:
        r18.peekedLong = r11;
        r18.pos += r8;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b8, code lost:
        r18.peeked = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ba, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bb, code lost:
        if (r9 == 2) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00be, code lost:
        if (r9 == 4) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c1, code lost:
        if (r9 != 7) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c4, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c6, code lost:
        r18.peekedNumberLength = r8;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cb, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int peekNumber() {
        char[] cArr = this.buffer;
        int i6 = this.pos;
        int i7 = this.limit;
        int i8 = 0;
        int i9 = 0;
        char c6 = 0;
        boolean z5 = true;
        long j6 = 0;
        boolean z6 = false;
        while (true) {
            if (i6 + i9 == i7) {
                if (i9 == cArr.length) {
                    return i8;
                }
                if (!fillBuffer(i9 + 1)) {
                    break;
                }
                i6 = this.pos;
                i7 = this.limit;
            }
            char c7 = cArr[i6 + i9];
            if (c7 != '+') {
                if (c7 == 'E' || c7 == 'e') {
                    i8 = 0;
                    if (c6 != 2 && c6 != 4) {
                        return 0;
                    }
                    c6 = 5;
                } else if (c7 == '-') {
                    i8 = 0;
                    if (c6 == 0) {
                        c6 = 1;
                        z6 = true;
                    } else if (c6 != 5) {
                        return 0;
                    }
                } else if (c7 == '.') {
                    i8 = 0;
                    if (c6 != 2) {
                        return 0;
                    }
                    c6 = 3;
                } else if (c7 < '0' || c7 > '9') {
                    break;
                } else if (c6 == 1 || c6 == 0) {
                    j6 = -(c7 - '0');
                    i8 = 0;
                    c6 = 2;
                } else {
                    if (c6 == 2) {
                        if (j6 == 0) {
                            return 0;
                        }
                        long j7 = (10 * j6) - (c7 - '0');
                        int i10 = (j6 > (-922337203685477580L) ? 1 : (j6 == (-922337203685477580L) ? 0 : -1));
                        z5 &= i10 > 0 || (i10 == 0 && j7 < j6);
                        j6 = j7;
                    } else if (c6 == 3) {
                        i8 = 0;
                        c6 = 4;
                    } else if (c6 == 5 || c6 == 6) {
                        i8 = 0;
                        c6 = 7;
                    }
                    i8 = 0;
                }
                i9++;
            } else {
                i8 = 0;
                if (c6 != 5) {
                    return 0;
                }
            }
            c6 = 6;
            i9++;
        }
    }

    private void push(int i6) {
        int i7 = this.stackSize;
        int[] iArr = this.stack;
        if (i7 == iArr.length) {
            int i8 = i7 * 2;
            this.stack = Arrays.copyOf(iArr, i8);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i8);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i8);
        }
        int[] iArr2 = this.stack;
        int i9 = this.stackSize;
        this.stackSize = i9 + 1;
        iArr2[i9] = i6;
    }

    private char readEscapeCharacter() {
        int i6;
        int i7;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i8 = this.pos;
            int i9 = i8 + 1;
            this.pos = i9;
            char c6 = cArr[i8];
            if (c6 == '\n') {
                this.lineNumber++;
                this.lineStart = i9;
            } else if (c6 != '\"' && c6 != '\'' && c6 != '/' && c6 != '\\') {
                if (c6 != 'b') {
                    if (c6 != 'f') {
                        if (c6 != 'n') {
                            if (c6 != 'r') {
                                if (c6 != 't') {
                                    if (c6 == 'u') {
                                        if (i9 + 4 <= this.limit || fillBuffer(4)) {
                                            int i10 = this.pos;
                                            int i11 = i10 + 4;
                                            char c7 = 0;
                                            while (i10 < i11) {
                                                char c8 = this.buffer[i10];
                                                char c9 = (char) (c7 << 4);
                                                if (c8 < '0' || c8 > '9') {
                                                    if (c8 >= 'a' && c8 <= 'f') {
                                                        i6 = c8 - 'a';
                                                    } else if (c8 < 'A' || c8 > 'F') {
                                                        throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                                                    } else {
                                                        i6 = c8 - 'A';
                                                    }
                                                    i7 = i6 + 10;
                                                } else {
                                                    i7 = c8 - '0';
                                                }
                                                c7 = (char) (c9 + i7);
                                                i10++;
                                            }
                                            this.pos += 4;
                                            return c7;
                                        }
                                        throw syntaxError("Unterminated escape sequence");
                                    }
                                    throw syntaxError("Invalid escape sequence");
                                }
                                return '\t';
                            }
                            return '\r';
                        }
                        return '\n';
                    }
                    return '\f';
                }
                return '\b';
            }
            return c6;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char c6) {
        char[] cArr = this.buffer;
        while (true) {
            int i6 = this.pos;
            int i7 = this.limit;
            while (true) {
                if (i6 < i7) {
                    int i8 = i6 + 1;
                    char c7 = cArr[i6];
                    if (c7 == c6) {
                        this.pos = i8;
                        return;
                    } else if (c7 == '\\') {
                        this.pos = i8;
                        readEscapeCharacter();
                        break;
                    } else {
                        if (c7 == '\n') {
                            this.lineNumber++;
                            this.lineStart = i8;
                        }
                        i6 = i8;
                    }
                } else {
                    this.pos = i6;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean skipTo(String str) {
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i6 = this.pos;
            if (cArr[i6] != '\n') {
                for (int i7 = 0; i7 < length; i7++) {
                    if (this.buffer[this.pos + i7] != str.charAt(i7)) {
                        break;
                    }
                }
                return true;
            }
            this.lineNumber++;
            this.lineStart = i6 + 1;
            this.pos++;
        }
    }

    private void skipToEndOfLine() {
        char c6;
        do {
            if (this.pos >= this.limit && !fillBuffer(1)) {
                return;
            }
            char[] cArr = this.buffer;
            int i6 = this.pos;
            int i7 = i6 + 1;
            this.pos = i7;
            c6 = cArr[i6];
            if (c6 == '\n') {
                this.lineNumber++;
                this.lineStart = i7;
                return;
            }
        } while (c6 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        checkLenient();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void skipUnquotedValue() {
        do {
            int i6 = 0;
            while (true) {
                int i7 = this.pos;
                if (i7 + i6 < this.limit) {
                    char c6 = this.buffer[i7 + i6];
                    if (c6 != '\t' && c6 != '\n' && c6 != '\f' && c6 != '\r' && c6 != ' ') {
                        if (c6 != '#') {
                            if (c6 != ',') {
                                if (c6 != '/' && c6 != '=') {
                                    if (c6 != '{' && c6 != '}' && c6 != ':') {
                                        if (c6 != ';') {
                                            switch (c6) {
                                                case g.J0 /* 91 */:
                                                case g.L0 /* 93 */:
                                                    break;
                                                case g.K0 /* 92 */:
                                                    break;
                                                default:
                                                    i6++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.pos = i7 + i6;
                }
            }
            this.pos += i6;
            return;
        } while (fillBuffer(1));
    }

    private IOException syntaxError(String str) {
        throw new MalformedJsonException(str + locationString());
    }

    public void beginArray() {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
    }

    public void beginObject() {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    int doPeek() {
        int i6;
        int nextNonWhitespace;
        int[] iArr = this.stack;
        int i7 = this.stackSize;
        int i8 = iArr[i7 - 1];
        if (i8 == 1) {
            iArr[i7 - 1] = 2;
        } else if (i8 != 2) {
            if (i8 == 3 || i8 == 5) {
                iArr[i7 - 1] = 4;
                if (i8 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                    if (nextNonWhitespace != 59) {
                        if (nextNonWhitespace == 125) {
                            this.peeked = 2;
                            return 2;
                        }
                        throw syntaxError("Unterminated object");
                    }
                    checkLenient();
                }
                int nextNonWhitespace2 = nextNonWhitespace(true);
                if (nextNonWhitespace2 == 34) {
                    i6 = 13;
                } else if (nextNonWhitespace2 == 39) {
                    checkLenient();
                    i6 = 12;
                } else if (nextNonWhitespace2 == 125) {
                    if (i8 != 5) {
                        this.peeked = 2;
                        return 2;
                    }
                    throw syntaxError("Expected name");
                } else {
                    checkLenient();
                    this.pos--;
                    if (!isLiteral((char) nextNonWhitespace2)) {
                        throw syntaxError("Expected name");
                    }
                    i6 = 14;
                }
            } else if (i8 == 4) {
                iArr[i7 - 1] = 5;
                int nextNonWhitespace3 = nextNonWhitespace(true);
                if (nextNonWhitespace3 != 58) {
                    if (nextNonWhitespace3 != 61) {
                        throw syntaxError("Expected ':'");
                    }
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i9 = this.pos;
                        if (cArr[i9] == '>') {
                            this.pos = i9 + 1;
                        }
                    }
                }
            } else if (i8 == 6) {
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = 7;
            } else if (i8 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    i6 = 17;
                } else {
                    checkLenient();
                    this.pos--;
                }
            } else if (i8 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            this.peeked = i6;
            return i6;
        } else {
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 44) {
                if (nextNonWhitespace4 != 59) {
                    if (nextNonWhitespace4 == 93) {
                        this.peeked = 4;
                        return 4;
                    }
                    throw syntaxError("Unterminated array");
                }
                checkLenient();
            }
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 != 34) {
            if (nextNonWhitespace5 == 39) {
                checkLenient();
                this.peeked = 8;
                return 8;
            }
            if (nextNonWhitespace5 != 44 && nextNonWhitespace5 != 59) {
                if (nextNonWhitespace5 == 91) {
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 == 123) {
                        this.peeked = 1;
                        return 1;
                    }
                    this.pos--;
                    int peekKeyword = peekKeyword();
                    if (peekKeyword != 0) {
                        return peekKeyword;
                    }
                    int peekNumber = peekNumber();
                    if (peekNumber != 0) {
                        return peekNumber;
                    }
                    if (!isLiteral(this.buffer[this.pos])) {
                        throw syntaxError("Expected value");
                    }
                    checkLenient();
                    i6 = 10;
                } else if (i8 == 1) {
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i8 == 1 || i8 == 2) {
                checkLenient();
                this.pos--;
                this.peeked = 7;
                return 7;
            }
            throw syntaxError("Unexpected value");
        }
        i6 = 9;
        this.peeked = i6;
        return i6;
    }

    public void endArray() {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
        }
        int i7 = this.stackSize - 1;
        this.stackSize = i7;
        int[] iArr = this.pathIndices;
        int i8 = i7 - 1;
        iArr[i8] = iArr[i8] + 1;
        this.peeked = 0;
    }

    public void endObject() {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
        }
        int i7 = this.stackSize - 1;
        this.stackSize = i7;
        this.pathNames[i7] = null;
        int[] iArr = this.pathIndices;
        int i8 = i7 - 1;
        iArr[i8] = iArr[i8] + 1;
        this.peeked = 0;
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i6 = this.stackSize;
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = this.stack[i7];
            if (i8 == 1 || i8 == 2) {
                sb.append('[');
                sb.append(this.pathIndices[i7]);
                sb.append(']');
            } else if (i8 == 3 || i8 == 4 || i8 == 5) {
                sb.append(JwtParser.SEPARATOR_CHAR);
                String str = this.pathNames[i7];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public boolean hasNext() {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        return (i6 == 2 || i6 == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i7 = this.stackSize - 1;
            iArr[i7] = iArr[i7] + 1;
            return true;
        } else if (i6 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i8 = this.stackSize - 1;
            iArr2[i8] = iArr2[i8] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
        }
    }

    public double nextDouble() {
        String nextQuotedValue;
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i7 = this.stackSize - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.peekedLong;
        }
        if (i6 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i6 == 8 || i6 == 9) {
                nextQuotedValue = nextQuotedValue(i6 == 8 ? '\'' : '\"');
            } else if (i6 == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else if (i6 != 11) {
                throw new IllegalStateException("Expected a double but was " + peek() + locationString());
            }
            this.peekedString = nextQuotedValue;
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr2 = this.pathIndices;
        int i8 = this.stackSize - 1;
        iArr2[i8] = iArr2[i8] + 1;
        return parseDouble;
    }

    public int nextInt() {
        String nextQuotedValue;
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 15) {
            long j6 = this.peekedLong;
            int i7 = (int) j6;
            if (j6 == i7) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i8 = this.stackSize - 1;
                iArr[i8] = iArr[i8] + 1;
                return i7;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i6 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i6 != 8 && i6 != 9 && i6 != 10) {
            throw new IllegalStateException("Expected an int but was " + peek() + locationString());
        } else {
            if (i6 == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i6 == 8 ? '\'' : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i9 = this.stackSize - 1;
                iArr2[i9] = iArr2[i9] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i10 = (int) parseDouble;
        if (i10 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i11 = this.stackSize - 1;
        iArr3[i11] = iArr3[i11] + 1;
        return i10;
    }

    public long nextLong() {
        String nextQuotedValue;
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i7 = this.stackSize - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.peekedLong;
        }
        if (i6 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i6 != 8 && i6 != 9 && i6 != 10) {
            throw new IllegalStateException("Expected a long but was " + peek() + locationString());
        } else {
            if (i6 == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i6 == 8 ? '\'' : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i8 = this.stackSize - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j6 = (long) parseDouble;
        if (j6 != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i9 = this.stackSize - 1;
        iArr3[i9] = iArr3[i9] + 1;
        return j6;
    }

    public String nextName() {
        char c6;
        String nextQuotedValue;
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 14) {
            nextQuotedValue = nextUnquotedValue();
        } else {
            if (i6 == 12) {
                c6 = '\'';
            } else if (i6 != 13) {
                throw new IllegalStateException("Expected a name but was " + peek() + locationString());
            } else {
                c6 = '\"';
            }
            nextQuotedValue = nextQuotedValue(c6);
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = nextQuotedValue;
        return nextQuotedValue;
    }

    public void nextNull() {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i7 = this.stackSize - 1;
            iArr[i7] = iArr[i7] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() {
        String str;
        char c6;
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 10) {
            str = nextUnquotedValue();
        } else {
            if (i6 == 8) {
                c6 = '\'';
            } else if (i6 == 9) {
                c6 = '\"';
            } else if (i6 == 11) {
                str = this.peekedString;
                this.peekedString = null;
            } else if (i6 == 15) {
                str = Long.toString(this.peekedLong);
            } else if (i6 != 16) {
                throw new IllegalStateException("Expected a string but was " + peek() + locationString());
            } else {
                str = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            }
            str = nextQuotedValue(c6);
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i7 = this.stackSize - 1;
        iArr[i7] = iArr[i7] + 1;
        return str;
    }

    public JsonToken peek() {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        switch (i6) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z5) {
        this.lenient = z5;
    }

    public void skipValue() {
        char c6;
        int i6 = 0;
        do {
            int i7 = this.peeked;
            if (i7 == 0) {
                i7 = doPeek();
            }
            if (i7 == 3) {
                push(1);
            } else if (i7 == 1) {
                push(3);
            } else {
                if (i7 == 4 || i7 == 2) {
                    this.stackSize--;
                    i6--;
                } else if (i7 == 14 || i7 == 10) {
                    skipUnquotedValue();
                } else {
                    if (i7 == 8 || i7 == 12) {
                        c6 = '\'';
                    } else if (i7 == 9 || i7 == 13) {
                        c6 = '\"';
                    } else if (i7 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    skipQuotedValue(c6);
                }
                this.peeked = 0;
            }
            i6++;
            this.peeked = 0;
        } while (i6 != 0);
        int[] iArr = this.pathIndices;
        int i8 = this.stackSize;
        int i9 = i8 - 1;
        iArr[i9] = iArr[i9] + 1;
        this.pathNames[i8 - 1] = "null";
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
