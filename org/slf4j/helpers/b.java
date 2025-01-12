package org.slf4j.helpers;
/* loaded from: classes.dex */
public abstract class b extends f {
    private static final long serialVersionUID = 9044267456635152283L;

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void debug(String str);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void debug(String str, Object obj);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void debug(String str, Object obj, Object obj2);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void debug(String str, Throwable th);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void debug(String str, Object... objArr);

    @Override // org.slf4j.helpers.f
    public void debug(k5.d dVar, String str) {
        debug(str);
    }

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void error(String str);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void error(String str, Object obj);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void error(String str, Object obj, Object obj2);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void error(String str, Throwable th);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void error(String str, Object... objArr);

    @Override // org.slf4j.helpers.f
    public void error(k5.d dVar, String str) {
        error(str);
    }

    @Override // org.slf4j.helpers.f
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void info(String str);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void info(String str, Object obj);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void info(String str, Object obj, Object obj2);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void info(String str, Throwable th);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void info(String str, Object... objArr);

    @Override // org.slf4j.helpers.f
    public void info(k5.d dVar, String str) {
        info(str);
    }

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ boolean isDebugEnabled();

    @Override // org.slf4j.helpers.f
    public boolean isDebugEnabled(k5.d dVar) {
        return isDebugEnabled();
    }

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ boolean isErrorEnabled();

    @Override // org.slf4j.helpers.f
    public boolean isErrorEnabled(k5.d dVar) {
        return isErrorEnabled();
    }

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ boolean isInfoEnabled();

    @Override // org.slf4j.helpers.f
    public boolean isInfoEnabled(k5.d dVar) {
        return isInfoEnabled();
    }

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ boolean isTraceEnabled();

    @Override // org.slf4j.helpers.f
    public boolean isTraceEnabled(k5.d dVar) {
        return isTraceEnabled();
    }

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ boolean isWarnEnabled();

    @Override // org.slf4j.helpers.f
    public boolean isWarnEnabled(k5.d dVar) {
        return isWarnEnabled();
    }

    public String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void trace(String str);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void trace(String str, Object obj);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void trace(String str, Object obj, Object obj2);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void trace(String str, Throwable th);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void trace(String str, Object... objArr);

    @Override // org.slf4j.helpers.f
    public void trace(k5.d dVar, String str) {
        trace(str);
    }

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void warn(String str);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void warn(String str, Object obj);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void warn(String str, Object obj, Object obj2);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void warn(String str, Throwable th);

    @Override // org.slf4j.helpers.f
    public abstract /* synthetic */ void warn(String str, Object... objArr);

    @Override // org.slf4j.helpers.f
    public void warn(k5.d dVar, String str) {
        warn(str);
    }

    @Override // org.slf4j.helpers.f
    public void debug(k5.d dVar, String str, Object obj) {
        debug(str, obj);
    }

    @Override // org.slf4j.helpers.f
    public void error(k5.d dVar, String str, Object obj) {
        error(str, obj);
    }

    @Override // org.slf4j.helpers.f
    public void info(k5.d dVar, String str, Object obj) {
        info(str, obj);
    }

    @Override // org.slf4j.helpers.f
    public void trace(k5.d dVar, String str, Object obj) {
        trace(str, obj);
    }

    @Override // org.slf4j.helpers.f
    public void warn(k5.d dVar, String str, Object obj) {
        warn(str, obj);
    }

    @Override // org.slf4j.helpers.f
    public void debug(k5.d dVar, String str, Object obj, Object obj2) {
        debug(str, obj, obj2);
    }

    @Override // org.slf4j.helpers.f
    public void error(k5.d dVar, String str, Object obj, Object obj2) {
        error(str, obj, obj2);
    }

    @Override // org.slf4j.helpers.f
    public void info(k5.d dVar, String str, Object obj, Object obj2) {
        info(str, obj, obj2);
    }

    @Override // org.slf4j.helpers.f
    public void trace(k5.d dVar, String str, Object obj, Object obj2) {
        trace(str, obj, obj2);
    }

    @Override // org.slf4j.helpers.f
    public void warn(k5.d dVar, String str, Object obj, Object obj2) {
        warn(str, obj, obj2);
    }

    @Override // org.slf4j.helpers.f
    public void debug(k5.d dVar, String str, Throwable th) {
        debug(str, th);
    }

    @Override // org.slf4j.helpers.f
    public void error(k5.d dVar, String str, Throwable th) {
        error(str, th);
    }

    @Override // org.slf4j.helpers.f
    public void info(k5.d dVar, String str, Throwable th) {
        info(str, th);
    }

    @Override // org.slf4j.helpers.f
    public void trace(k5.d dVar, String str, Throwable th) {
        trace(str, th);
    }

    @Override // org.slf4j.helpers.f
    public void warn(k5.d dVar, String str, Throwable th) {
        warn(str, th);
    }

    @Override // org.slf4j.helpers.f
    public void debug(k5.d dVar, String str, Object... objArr) {
        debug(str, objArr);
    }

    @Override // org.slf4j.helpers.f
    public void error(k5.d dVar, String str, Object... objArr) {
        error(str, objArr);
    }

    @Override // org.slf4j.helpers.f
    public void info(k5.d dVar, String str, Object... objArr) {
        info(str, objArr);
    }

    @Override // org.slf4j.helpers.f
    public void trace(k5.d dVar, String str, Object... objArr) {
        trace(str, objArr);
    }

    @Override // org.slf4j.helpers.f
    public void warn(k5.d dVar, String str, Object... objArr) {
        warn(str, objArr);
    }
}
