package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.u;
import okhttp3.internal.http2.Http2Connection;
import p4.a;
/* loaded from: classes.dex */
public final class TaskLoggerKt {
    public static final /* synthetic */ void access$log(Task task, TaskQueue taskQueue, String str) {
        log(task, taskQueue, str);
    }

    public static final String formatDuration(long j6) {
        StringBuilder sb;
        long j7;
        long j8;
        long j9;
        if (j6 > -999500000) {
            if (j6 > -999500) {
                if (j6 <= 0) {
                    sb = new StringBuilder();
                    j9 = j6 - 500;
                } else if (j6 < 999500) {
                    sb = new StringBuilder();
                    j9 = j6 + 500;
                } else if (j6 < 999500000) {
                    sb = new StringBuilder();
                    j8 = j6 + 500000;
                } else {
                    sb = new StringBuilder();
                    j7 = j6 + 500000000;
                }
                sb.append(j9 / 1000);
                sb.append(" µs");
                String sb2 = sb.toString();
                u uVar = u.f11325a;
                String format = String.format("%6s", Arrays.copyOf(new Object[]{sb2}, 1));
                l.c(format, "format(format, *args)");
                return format;
            }
            sb = new StringBuilder();
            j8 = j6 - 500000;
            sb.append(j8 / 1000000);
            sb.append(" ms");
            String sb22 = sb.toString();
            u uVar2 = u.f11325a;
            String format2 = String.format("%6s", Arrays.copyOf(new Object[]{sb22}, 1));
            l.c(format2, "format(format, *args)");
            return format2;
        }
        sb = new StringBuilder();
        j7 = j6 - 500000000;
        sb.append(j7 / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS));
        sb.append(" s ");
        String sb222 = sb.toString();
        u uVar22 = u.f11325a;
        String format22 = String.format("%6s", Arrays.copyOf(new Object[]{sb222}, 1));
        l.c(format22, "format(format, *args)");
        return format22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.getName$okhttp());
        sb.append(' ');
        u uVar = u.f11325a;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        l.c(format, "format(format, *args)");
        sb.append(format);
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }

    public static final <T> T logElapsed(Task task, TaskQueue taskQueue, a aVar) {
        long j6;
        l.d(task, "task");
        l.d(taskQueue, "queue");
        l.d(aVar, "block");
        boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (isLoggable) {
            j6 = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, taskQueue, "starting");
        } else {
            j6 = -1;
        }
        try {
            T t5 = (T) aVar.invoke();
            k.b(1);
            if (isLoggable) {
                log(task, taskQueue, l.i("finished run in ", formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j6)));
            }
            k.a(1);
            return t5;
        } catch (Throwable th) {
            k.b(1);
            if (isLoggable) {
                log(task, taskQueue, l.i("failed a run in ", formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j6)));
            }
            k.a(1);
            throw th;
        }
    }

    public static final void taskLog(Task task, TaskQueue taskQueue, a aVar) {
        l.d(task, "task");
        l.d(taskQueue, "queue");
        l.d(aVar, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, taskQueue, (String) aVar.invoke());
        }
    }
}
