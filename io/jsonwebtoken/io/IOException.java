package io.jsonwebtoken.io;

import io.jsonwebtoken.JwtException;
/* loaded from: classes.dex */
public class IOException extends JwtException {
    public IOException(String str) {
        super(str);
    }

    public IOException(String str, Throwable th) {
        super(str, th);
    }
}
