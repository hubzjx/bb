package org.slf4j.helpers;

import java.io.Serializable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f implements k5.b, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    public abstract /* synthetic */ void debug(String str);

    public abstract /* synthetic */ void debug(String str, Object obj);

    public abstract /* synthetic */ void debug(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void debug(String str, Throwable th);

    public abstract /* synthetic */ void debug(String str, Object... objArr);

    public abstract /* synthetic */ void debug(k5.d dVar, String str);

    public abstract /* synthetic */ void debug(k5.d dVar, String str, Object obj);

    public abstract /* synthetic */ void debug(k5.d dVar, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void debug(k5.d dVar, String str, Throwable th);

    public abstract /* synthetic */ void debug(k5.d dVar, String str, Object... objArr);

    public abstract /* synthetic */ void error(String str);

    public abstract /* synthetic */ void error(String str, Object obj);

    public abstract /* synthetic */ void error(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void error(String str, Throwable th);

    public abstract /* synthetic */ void error(String str, Object... objArr);

    public abstract /* synthetic */ void error(k5.d dVar, String str);

    public abstract /* synthetic */ void error(k5.d dVar, String str, Object obj);

    public abstract /* synthetic */ void error(k5.d dVar, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void error(k5.d dVar, String str, Throwable th);

    public abstract /* synthetic */ void error(k5.d dVar, String str, Object... objArr);

    public String getName() {
        return this.name;
    }

    public abstract /* synthetic */ void info(String str);

    public abstract /* synthetic */ void info(String str, Object obj);

    public abstract /* synthetic */ void info(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void info(String str, Throwable th);

    public abstract /* synthetic */ void info(String str, Object... objArr);

    public abstract /* synthetic */ void info(k5.d dVar, String str);

    public abstract /* synthetic */ void info(k5.d dVar, String str, Object obj);

    public abstract /* synthetic */ void info(k5.d dVar, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void info(k5.d dVar, String str, Throwable th);

    public abstract /* synthetic */ void info(k5.d dVar, String str, Object... objArr);

    public abstract /* synthetic */ boolean isDebugEnabled();

    public abstract /* synthetic */ boolean isDebugEnabled(k5.d dVar);

    public abstract /* synthetic */ boolean isErrorEnabled();

    public abstract /* synthetic */ boolean isErrorEnabled(k5.d dVar);

    public abstract /* synthetic */ boolean isInfoEnabled();

    public abstract /* synthetic */ boolean isInfoEnabled(k5.d dVar);

    public abstract /* synthetic */ boolean isTraceEnabled();

    public abstract /* synthetic */ boolean isTraceEnabled(k5.d dVar);

    public abstract /* synthetic */ boolean isWarnEnabled();

    public abstract /* synthetic */ boolean isWarnEnabled(k5.d dVar);

    protected Object readResolve() {
        return k5.c.g(getName());
    }

    public abstract /* synthetic */ void trace(String str);

    public abstract /* synthetic */ void trace(String str, Object obj);

    public abstract /* synthetic */ void trace(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void trace(String str, Throwable th);

    public abstract /* synthetic */ void trace(String str, Object... objArr);

    public abstract /* synthetic */ void trace(k5.d dVar, String str);

    public abstract /* synthetic */ void trace(k5.d dVar, String str, Object obj);

    public abstract /* synthetic */ void trace(k5.d dVar, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void trace(k5.d dVar, String str, Throwable th);

    public abstract /* synthetic */ void trace(k5.d dVar, String str, Object... objArr);

    public abstract /* synthetic */ void warn(String str);

    public abstract /* synthetic */ void warn(String str, Object obj);

    public abstract /* synthetic */ void warn(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void warn(String str, Throwable th);

    public abstract /* synthetic */ void warn(String str, Object... objArr);

    public abstract /* synthetic */ void warn(k5.d dVar, String str);

    public abstract /* synthetic */ void warn(k5.d dVar, String str, Object obj);

    public abstract /* synthetic */ void warn(k5.d dVar, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void warn(k5.d dVar, String str, Throwable th);

    public abstract /* synthetic */ void warn(k5.d dVar, String str, Object... objArr);
}
