package org.slf4j.impl;

import io.jsonwebtoken.JwtParser;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
class b implements k5.a {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentMap f12504a = new ConcurrentHashMap();

    private static String b(String str) {
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            int i6 = lastIndexOf + 1;
            if (length - i6 <= 23) {
                return str.substring(i6);
            }
        }
        return '*' + str.substring((length - 23) + 1);
    }

    static String c(String str) {
        if (str == null) {
            return "null";
        }
        int length = str.length();
        if (length <= 23) {
            return str;
        }
        StringBuilder sb = new StringBuilder(26);
        int i6 = 0;
        int i7 = 0;
        do {
            int indexOf = str.indexOf(46, i6);
            if (indexOf == -1) {
                int i8 = length - i6;
                if (i7 == 0 || i7 + i8 > 23) {
                    return b(str);
                }
                sb.append((CharSequence) str, i6, length);
                return sb.toString();
            }
            sb.append(str.charAt(i6));
            if (indexOf - i6 > 1) {
                sb.append('*');
            }
            sb.append(JwtParser.SEPARATOR_CHAR);
            i6 = indexOf + 1;
            i7 = sb.length();
        } while (i7 <= 23);
        return b(str);
    }

    @Override // k5.a
    public k5.b a(String str) {
        String c6 = c(str);
        k5.b bVar = (k5.b) this.f12504a.get(c6);
        if (bVar == null) {
            a aVar = new a(c6);
            k5.b bVar2 = (k5.b) this.f12504a.putIfAbsent(c6, aVar);
            return bVar2 == null ? aVar : bVar2;
        }
        return bVar;
    }
}
