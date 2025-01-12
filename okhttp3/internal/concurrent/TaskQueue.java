package okhttp3.internal.concurrent;

import h4.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import p4.a;
/* loaded from: classes.dex */
public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks;
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    /* loaded from: classes.dex */
    private static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(l.i(Util.okHttpName, " awaitIdle"), false);
            this.latch = new CountDownLatch(1);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }

    public TaskQueue(TaskRunner taskRunner, String str) {
        l.d(taskRunner, "taskRunner");
        l.d(str, "name");
        this.taskRunner = taskRunner;
        this.name = str;
        this.futureTasks = new ArrayList();
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String str, long j6, boolean z5, a aVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        if ((i6 & 4) != 0) {
            z5 = true;
        }
        l.d(str, "name");
        l.d(aVar, "block");
        taskQueue.schedule(new TaskQueue$execute$1(str, z5, aVar), j6);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String str, long j6, a aVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        l.d(str, "name");
        l.d(aVar, "block");
        taskQueue.schedule(new TaskQueue$schedule$2(str, aVar), j6);
    }

    public final void cancelAll() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this.taskRunner) {
            if (cancelAllAndDecide$okhttp()) {
                getTaskRunner$okhttp().kickCoordinator$okhttp(this);
            }
            q qVar = q.f10774a;
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            l.b(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        int size = this.futureTasks.size() - 1;
        boolean z5 = false;
        if (size >= 0) {
            while (true) {
                int i6 = size - 1;
                if (this.futureTasks.get(size).getCancelable()) {
                    Task task2 = this.futureTasks.get(size);
                    if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                        TaskLoggerKt.access$log(task2, this, "canceled");
                    }
                    this.futureTasks.remove(size);
                    z5 = true;
                }
                if (i6 < 0) {
                    break;
                }
                size = i6;
            }
        }
        return z5;
    }

    public final void execute(String str, long j6, boolean z5, a aVar) {
        l.d(str, "name");
        l.d(aVar, "block");
        schedule(new TaskQueue$execute$1(str, z5, aVar), j6);
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final List<Task> getScheduledTasks() {
        List<Task> O;
        synchronized (this.taskRunner) {
            O = kotlin.collections.l.O(getFutureTasks$okhttp());
        }
        return O;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (getActiveTask$okhttp() == null && getFutureTasks$okhttp().isEmpty()) {
                return new CountDownLatch(0);
            }
            Task activeTask$okhttp = getActiveTask$okhttp();
            if (activeTask$okhttp instanceof AwaitIdleTask) {
                return ((AwaitIdleTask) activeTask$okhttp).getLatch();
            }
            for (Task task : getFutureTasks$okhttp()) {
                if (task instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask) task).getLatch();
                }
            }
            AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
            if (scheduleAndDecide$okhttp(awaitIdleTask, 0L, false)) {
                getTaskRunner$okhttp().kickCoordinator$okhttp(this);
            }
            return awaitIdleTask.getLatch();
        }
    }

    public final void schedule(String str, long j6, a aVar) {
        l.d(str, "name");
        l.d(aVar, "block");
        schedule(new TaskQueue$schedule$2(str, aVar), j6);
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long j6, boolean z5) {
        String formatDuration;
        String str;
        l.d(task, "task");
        task.initQueue$okhttp(this);
        long nanoTime = this.taskRunner.getBackend().nanoTime();
        long j7 = nanoTime + j6;
        int indexOf = this.futureTasks.indexOf(task);
        if (indexOf != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= j7) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(indexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j7);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            long j8 = j7 - nanoTime;
            if (z5) {
                formatDuration = TaskLoggerKt.formatDuration(j8);
                str = "run again after ";
            } else {
                formatDuration = TaskLoggerKt.formatDuration(j8);
                str = "scheduled after ";
            }
            TaskLoggerKt.access$log(task, this, l.i(str, formatDuration));
        }
        Iterator<Task> it = this.futureTasks.iterator();
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                i6 = -1;
                break;
            }
            if (it.next().getNextExecuteNanoTime$okhttp() - nanoTime > j6) {
                break;
            }
            i6++;
        }
        if (i6 == -1) {
            i6 = this.futureTasks.size();
        }
        this.futureTasks.add(i6, task);
        return i6 == 0;
    }

    public final void setActiveTask$okhttp(Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z5) {
        this.cancelActiveTask = z5;
    }

    public final void setShutdown$okhttp(boolean z5) {
        this.shutdown = z5;
    }

    public final void shutdown() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this.taskRunner) {
            setShutdown$okhttp(true);
            if (cancelAllAndDecide$okhttp()) {
                getTaskRunner$okhttp().kickCoordinator$okhttp(this);
            }
            q qVar = q.f10774a;
        }
    }

    public String toString() {
        return this.name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j6, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        taskQueue.schedule(task, j6);
    }

    public final void schedule(Task task, long j6) {
        l.d(task, "task");
        synchronized (this.taskRunner) {
            if (!getShutdown$okhttp()) {
                if (scheduleAndDecide$okhttp(task, j6, false)) {
                    getTaskRunner$okhttp().kickCoordinator$okhttp(this);
                }
                q qVar = q.f10774a;
            } else if (task.getCancelable()) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }
}
