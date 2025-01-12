package org.slf4j.impl;

import android.util.Log;
/* loaded from: classes.dex */
class a extends org.slf4j.helpers.b {
    private static final long serialVersionUID = -1227274521521287937L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        this.name = str;
    }

    private void formatAndLog(int i6, String str, Object... objArr) {
        if (isLoggable(i6)) {
            org.slf4j.helpers.a a6 = org.slf4j.helpers.c.a(str, objArr);
            logInternal(i6, a6.a(), a6.b());
        }
    }

    private boolean isLoggable(int i6) {
        return Log.isLoggable(this.name, i6);
    }

    private void log(int i6, String str, Throwable th) {
        if (isLoggable(i6)) {
            logInternal(i6, str, th);
        }
    }

    private void logInternal(int i6, String str, Throwable th) {
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        Log.println(i6, this.name, str);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void debug(String str) {
        log(3, str, null);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void error(String str) {
        log(6, str, null);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void info(String str) {
        log(4, str, null);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public boolean isDebugEnabled() {
        return isLoggable(3);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public boolean isErrorEnabled() {
        return isLoggable(6);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public boolean isInfoEnabled() {
        return isLoggable(4);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public boolean isTraceEnabled() {
        return isLoggable(2);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public boolean isWarnEnabled() {
        return isLoggable(5);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void trace(String str) {
        log(2, str, null);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void warn(String str) {
        log(5, str, null);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void debug(String str, Object obj) {
        formatAndLog(3, str, obj);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void error(String str, Object obj) {
        formatAndLog(6, str, obj);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void info(String str, Object obj) {
        formatAndLog(4, str, obj);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void trace(String str, Object obj) {
        formatAndLog(2, str, obj);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void warn(String str, Object obj) {
        formatAndLog(5, str, obj);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void debug(String str, Object obj, Object obj2) {
        formatAndLog(3, str, obj, obj2);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void error(String str, Object obj, Object obj2) {
        formatAndLog(6, str, obj, obj2);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void info(String str, Object obj, Object obj2) {
        formatAndLog(4, str, obj, obj2);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void trace(String str, Object obj, Object obj2) {
        formatAndLog(2, str, obj, obj2);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void warn(String str, Object obj, Object obj2) {
        formatAndLog(5, str, obj, obj2);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void debug(String str, Throwable th) {
        log(2, str, th);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void error(String str, Throwable th) {
        log(6, str, th);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void info(String str, Throwable th) {
        log(4, str, th);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void trace(String str, Throwable th) {
        log(2, str, th);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void warn(String str, Throwable th) {
        log(5, str, th);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void debug(String str, Object... objArr) {
        formatAndLog(3, str, objArr);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void error(String str, Object... objArr) {
        formatAndLog(6, str, objArr);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void info(String str, Object... objArr) {
        formatAndLog(4, str, objArr);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void trace(String str, Object... objArr) {
        formatAndLog(2, str, objArr);
    }

    @Override // org.slf4j.helpers.b, org.slf4j.helpers.f
    public void warn(String str, Object... objArr) {
        formatAndLog(5, str, objArr);
    }
}
