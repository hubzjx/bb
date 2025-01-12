package io.jsonwebtoken.impl;

import io.jsonwebtoken.Clock;
import java.util.Date;
/* loaded from: classes.dex */
public class FixedClock implements Clock {
    private final Date now;

    public FixedClock() {
        this(new Date());
    }

    @Override // io.jsonwebtoken.Clock
    public Date now() {
        return this.now;
    }

    public FixedClock(Date date) {
        this.now = date;
    }
}
