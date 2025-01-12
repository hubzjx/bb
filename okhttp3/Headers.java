package okhttp3;

import h4.j;
import h4.n;
import j$.time.Instant;
import j$.util.DateRetargetClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import k4.c;
import kotlin.collections.s;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.u;
import kotlin.text.w;
import kotlin.text.x;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
/* loaded from: classes.dex */
public final class Headers implements Iterable<j>, q4.a {
    public static final Companion Companion = new Companion(null);
    private final String[] namesAndValues;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String str) {
            int N;
            CharSequence v02;
            l.d(str, "line");
            N = x.N(str, ':', 0, false, 6, null);
            if (N != -1) {
                String substring = str.substring(0, N);
                l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                v02 = x.v0(substring);
                String obj = v02.toString();
                String substring2 = str.substring(N + 1);
                l.c(substring2, "this as java.lang.String).substring(startIndex)");
                add(obj, substring2);
                return this;
            }
            throw new IllegalArgumentException(l.i("Unexpected header: ", str).toString());
        }

        public final Builder addAll(Headers headers) {
            l.d(headers, "headers");
            int size = headers.size();
            for (int i6 = 0; i6 < size; i6++) {
                addLenient$okhttp(headers.name(i6), headers.value(i6));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String str) {
            int N;
            l.d(str, "line");
            N = x.N(str, ':', 1, false, 4, null);
            if (N != -1) {
                String substring = str.substring(0, N);
                l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = str.substring(N + 1);
                l.c(substring2, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(substring, substring2);
            } else {
                if (str.charAt(0) == ':') {
                    str = str.substring(1);
                    l.c(str, "this as java.lang.String).substring(startIndex)");
                }
                addLenient$okhttp(HttpUrl.FRAGMENT_ENCODE_SET, str);
            }
            return this;
        }

        public final Builder addUnsafeNonAscii(String str, String str2) {
            l.d(str, "name");
            l.d(str2, "value");
            Headers.Companion.checkName(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public final String get(String str) {
            boolean l6;
            l.d(str, "name");
            int size = this.namesAndValues.size() - 2;
            int b6 = c.b(size, 0, -2);
            if (b6 > size) {
                return null;
            }
            while (true) {
                int i6 = size - 2;
                l6 = w.l(str, this.namesAndValues.get(size), true);
                if (l6) {
                    return this.namesAndValues.get(size + 1);
                }
                if (size == b6) {
                    return null;
                }
                size = i6;
            }
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String str) {
            boolean l6;
            l.d(str, "name");
            int i6 = 0;
            while (i6 < getNamesAndValues$okhttp().size()) {
                l6 = w.l(str, getNamesAndValues$okhttp().get(i6), true);
                if (l6) {
                    getNamesAndValues$okhttp().remove(i6);
                    getNamesAndValues$okhttp().remove(i6);
                    i6 -= 2;
                }
                i6 += 2;
            }
            return this;
        }

        public final Builder set(String str, String str2) {
            l.d(str, "name");
            l.d(str2, "value");
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            removeAll(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder add(String str, String str2) {
            l.d(str, "name");
            l.d(str2, "value");
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder addLenient$okhttp(String str, String str2) {
            CharSequence v02;
            l.d(str, "name");
            l.d(str2, "value");
            getNamesAndValues$okhttp().add(str);
            List<String> namesAndValues$okhttp = getNamesAndValues$okhttp();
            v02 = x.v0(str2);
            namesAndValues$okhttp.add(v02.toString());
            return this;
        }

        @IgnoreJRERequirement
        public final Builder set(String str, Instant instant) {
            l.d(str, "name");
            l.d(instant, "value");
            return set(str, new Date(instant.toEpochMilli()));
        }

        @IgnoreJRERequirement
        public final Builder add(String str, Instant instant) {
            l.d(str, "name");
            l.d(instant, "value");
            add(str, new Date(instant.toEpochMilli()));
            return this;
        }

        public final Builder set(String str, Date date) {
            l.d(str, "name");
            l.d(date, "value");
            set(str, DatesKt.toHttpDateString(date));
            return this;
        }

        public final Builder add(String str, Date date) {
            l.d(str, "name");
            l.d(date, "value");
            add(str, DatesKt.toHttpDateString(date));
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 1;
                char charAt = str.charAt(i6);
                if (!('!' <= charAt && charAt < 127)) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i6), str).toString());
                }
                i6 = i7;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005b A[LOOP:0: B:3:0x0006->B:23:0x005b, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0026 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void checkValue(String str, String str2) {
            boolean z5;
            int length = str.length();
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 1;
                char charAt = str.charAt(i6);
                if (charAt != '\t') {
                    if (!(' ' <= charAt && charAt < 127)) {
                        z5 = false;
                        if (z5) {
                            throw new IllegalArgumentException(l.i(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(charAt), Integer.valueOf(i6), str2), Util.isSensitiveHeader(str2) ? HttpUrl.FRAGMENT_ENCODE_SET : l.i(": ", str)).toString());
                        }
                        i6 = i7;
                    }
                }
                z5 = true;
                if (z5) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            boolean l6;
            int length = strArr.length - 2;
            int b6 = c.b(length, 0, -2);
            if (b6 > length) {
                return null;
            }
            while (true) {
                int i6 = length - 2;
                l6 = w.l(str, strArr[length], true);
                if (l6) {
                    return strArr[length + 1];
                }
                if (length == b6) {
                    return null;
                }
                length = i6;
            }
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m74deprecated_of(Map<String, String> map) {
            l.d(map, "headers");
            return of(map);
        }

        public final Headers of(Map<String, String> map) {
            CharSequence v02;
            CharSequence v03;
            l.d(map, "<this>");
            String[] strArr = new String[map.size() * 2];
            int i6 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                v02 = x.v0(entry.getKey());
                String obj = v02.toString();
                v03 = x.v0(entry.getValue());
                String obj2 = v03.toString();
                checkName(obj);
                checkValue(obj2, obj);
                strArr[i6] = obj;
                strArr[i6 + 1] = obj2;
                i6 += 2;
            }
            return new Headers(strArr, null);
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m75deprecated_of(String... strArr) {
            l.d(strArr, "namesAndValues");
            return of((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final Headers of(String... strArr) {
            CharSequence v02;
            l.d(strArr, "namesAndValues");
            int i6 = 0;
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                int length = strArr2.length;
                int i7 = 0;
                while (i7 < length) {
                    int i8 = i7 + 1;
                    String str = strArr2[i7];
                    if (!(str != null)) {
                        throw new IllegalArgumentException("Headers cannot be null".toString());
                    }
                    v02 = x.v0(str);
                    strArr2[i7] = v02.toString();
                    i7 = i8;
                }
                int b6 = c.b(0, strArr2.length - 1, 2);
                if (b6 >= 0) {
                    while (true) {
                        int i9 = i6 + 2;
                        String str2 = strArr2[i6];
                        String str3 = strArr2[i6 + 1];
                        checkName(str2);
                        checkValue(str3, str2);
                        if (i6 == b6) {
                            break;
                        }
                        i6 = i9;
                    }
                }
                return new Headers(strArr2, null);
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m73deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i6 = 0; i6 < strArr.length; i6++) {
            length += this.namesAndValues[i6].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    public final String get(String str) {
        l.d(str, "name");
        return Companion.get(this.namesAndValues, str);
    }

    public final Date getDate(String str) {
        l.d(str, "name");
        String str2 = get(str);
        if (str2 == null) {
            return null;
        }
        return DatesKt.toHttpDateOrNull(str2);
    }

    @IgnoreJRERequirement
    public final Instant getInstant(String str) {
        l.d(str, "name");
        Date date = getDate(str);
        if (date == null) {
            return null;
        }
        return DateRetargetClass.toInstant(date);
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<j> iterator() {
        int size = size();
        j[] jVarArr = new j[size];
        for (int i6 = 0; i6 < size; i6++) {
            jVarArr[i6] = n.a(name(i6), value(i6));
        }
        return kotlin.jvm.internal.b.a(jVarArr);
    }

    public final String name(int i6) {
        return this.namesAndValues[i6 * 2];
    }

    public final Set<String> names() {
        Comparator m5;
        m5 = w.m(u.f11325a);
        TreeSet treeSet = new TreeSet(m5);
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            treeSet.add(name(i6));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        l.c(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        s.t(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        Comparator m5;
        m5 = w.m(u.f11325a);
        TreeMap treeMap = new TreeMap(m5);
        int size = size();
        int i6 = 0;
        while (i6 < size) {
            int i7 = i6 + 1;
            String name = name(i6);
            Locale locale = Locale.US;
            l.c(locale, "US");
            String lowerCase = name.toLowerCase(locale);
            l.c(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i6));
            i6 = i7;
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        int i6 = 0;
        while (i6 < size) {
            int i7 = i6 + 1;
            String name = name(i6);
            String value = value(i6);
            sb.append(name);
            sb.append(": ");
            if (Util.isSensitiveHeader(name)) {
                value = "██";
            }
            sb.append(value);
            sb.append("\n");
            i6 = i7;
        }
        String sb2 = sb.toString();
        l.c(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String value(int i6) {
        return this.namesAndValues[(i6 * 2) + 1];
    }

    public final List<String> values(String str) {
        List<String> f6;
        boolean l6;
        l.d(str, "name");
        int size = size();
        ArrayList arrayList = null;
        int i6 = 0;
        while (i6 < size) {
            int i7 = i6 + 1;
            l6 = w.l(str, name(i6), true);
            if (l6) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i6));
            }
            i6 = i7;
        }
        if (arrayList == null) {
            f6 = kotlin.collections.n.f();
            return f6;
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        l.c(unmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return unmodifiableList;
    }

    public /* synthetic */ Headers(String[] strArr, g gVar) {
        this(strArr);
    }

    public static final Headers of(String... strArr) {
        return Companion.of(strArr);
    }
}
