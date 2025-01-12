package okhttp3.internal.http2;

import h4.q;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.r;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import p4.a;
/* loaded from: classes.dex */
public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion(null);
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean client;
        public String connectionName;
        private Listener listener;
        private int pingIntervalMillis;
        private PushObserver pushObserver;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;
        private final TaskRunner taskRunner;

        public Builder(boolean z5, TaskRunner taskRunner) {
            l.d(taskRunner, "taskRunner");
            this.client = z5;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                str = Util.peerName(socket);
            }
            if ((i6 & 4) != 0) {
                bufferedSource = Okio.buffer(Okio.source(socket));
            }
            if ((i6 & 8) != 0) {
                bufferedSink = Okio.buffer(Okio.sink(socket));
            }
            return builder.socket(socket, str, bufferedSource, bufferedSink);
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            l.m("connectionName");
            return null;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink != null) {
                return bufferedSink;
            }
            l.m("sink");
            return null;
        }

        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            l.m("socket");
            return null;
        }

        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            l.m("source");
            return null;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final Builder listener(Listener listener) {
            l.d(listener, "listener");
            setListener$okhttp(listener);
            return this;
        }

        public final Builder pingIntervalMillis(int i6) {
            setPingIntervalMillis$okhttp(i6);
            return this;
        }

        public final Builder pushObserver(PushObserver pushObserver) {
            l.d(pushObserver, "pushObserver");
            setPushObserver$okhttp(pushObserver);
            return this;
        }

        public final void setClient$okhttp(boolean z5) {
            this.client = z5;
        }

        public final void setConnectionName$okhttp(String str) {
            l.d(str, "<set-?>");
            this.connectionName = str;
        }

        public final void setListener$okhttp(Listener listener) {
            l.d(listener, "<set-?>");
            this.listener = listener;
        }

        public final void setPingIntervalMillis$okhttp(int i6) {
            this.pingIntervalMillis = i6;
        }

        public final void setPushObserver$okhttp(PushObserver pushObserver) {
            l.d(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final void setSink$okhttp(BufferedSink bufferedSink) {
            l.d(bufferedSink, "<set-?>");
            this.sink = bufferedSink;
        }

        public final void setSocket$okhttp(Socket socket) {
            l.d(socket, "<set-?>");
            this.socket = socket;
        }

        public final void setSource$okhttp(BufferedSource bufferedSource) {
            l.d(bufferedSource, "<set-?>");
            this.source = bufferedSource;
        }

        public final Builder socket(Socket socket) {
            l.d(socket, "socket");
            return socket$default(this, socket, null, null, null, 14, null);
        }

        public final Builder socket(Socket socket, String str) {
            l.d(socket, "socket");
            l.d(str, "peerName");
            return socket$default(this, socket, str, null, null, 12, null);
        }

        public final Builder socket(Socket socket, String str, BufferedSource bufferedSource) {
            l.d(socket, "socket");
            l.d(str, "peerName");
            l.d(bufferedSource, "source");
            return socket$default(this, socket, str, bufferedSource, null, 8, null);
        }

        public final Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            String i6;
            l.d(socket, "socket");
            l.d(str, "peerName");
            l.d(bufferedSource, "source");
            l.d(bufferedSink, "sink");
            setSocket$okhttp(socket);
            if (getClient$okhttp()) {
                i6 = Util.okHttpName + ' ' + str;
            } else {
                i6 = l.i("MockWebServer ", str);
            }
            setConnectionName$okhttp(i6);
            setSource$okhttp(bufferedSource);
            setSink$okhttp(bufferedSink);
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

        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Listener {
        public static final Companion Companion = new Companion(null);
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: okhttp3.internal.http2.Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream http2Stream) {
                l.d(http2Stream, "stream");
                http2Stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }
        }

        public void onSettings(Http2Connection http2Connection, Settings settings) {
            l.d(http2Connection, "connection");
            l.d(settings, "settings");
        }

        public abstract void onStream(Http2Stream http2Stream);
    }

    /* loaded from: classes.dex */
    public final class ReaderRunnable implements Http2Reader.Handler, a {
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(Http2Connection http2Connection, Http2Reader http2Reader) {
            l.d(http2Connection, "this$0");
            l.d(http2Reader, "reader");
            this.this$0 = http2Connection;
            this.reader = http2Reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i6, String str, ByteString byteString, String str2, int i7, long j6) {
            l.d(str, "origin");
            l.d(byteString, "protocol");
            l.d(str2, "host");
        }

        public final void applyAndAckSettings(boolean z5, Settings settings) {
            long initialWindowSize;
            int i6;
            Http2Stream[] http2StreamArr;
            l.d(settings, "settings");
            r rVar = new r();
            Http2Writer writer = this.this$0.getWriter();
            Http2Connection http2Connection = this.this$0;
            synchronized (writer) {
                synchronized (http2Connection) {
                    Settings peerSettings = http2Connection.getPeerSettings();
                    if (!z5) {
                        Settings settings2 = new Settings();
                        settings2.merge(peerSettings);
                        settings2.merge(settings);
                        settings = settings2;
                    }
                    rVar.element = settings;
                    initialWindowSize = settings.getInitialWindowSize() - peerSettings.getInitialWindowSize();
                    i6 = 0;
                    if (initialWindowSize != 0 && !http2Connection.getStreams$okhttp().isEmpty()) {
                        Object[] array = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                        if (array == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        }
                        http2StreamArr = (Http2Stream[]) array;
                        http2Connection.setPeerSettings((Settings) rVar.element);
                        http2Connection.settingsListenerQueue.schedule(new Task(l.i(http2Connection.getConnectionName$okhttp(), " onSettings"), true, http2Connection, rVar) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$lambda-7$lambda-6$$inlined$execute$default$1
                            final /* synthetic */ boolean $cancelable;
                            final /* synthetic */ String $name;
                            final /* synthetic */ r $newPeerSettings$inlined;
                            final /* synthetic */ Http2Connection this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r1, r2);
                                this.$name = r1;
                                this.$cancelable = r2;
                                this.this$0 = http2Connection;
                                this.$newPeerSettings$inlined = rVar;
                            }

                            @Override // okhttp3.internal.concurrent.Task
                            public long runOnce() {
                                this.this$0.getListener$okhttp().onSettings(this.this$0, (Settings) this.$newPeerSettings$inlined.element);
                                return -1L;
                            }
                        }, 0L);
                        q qVar = q.f10774a;
                    }
                    http2StreamArr = null;
                    http2Connection.setPeerSettings((Settings) rVar.element);
                    http2Connection.settingsListenerQueue.schedule(new Task(l.i(http2Connection.getConnectionName$okhttp(), " onSettings"), true, http2Connection, rVar) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$lambda-7$lambda-6$$inlined$execute$default$1
                        final /* synthetic */ boolean $cancelable;
                        final /* synthetic */ String $name;
                        final /* synthetic */ r $newPeerSettings$inlined;
                        final /* synthetic */ Http2Connection this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r1, r2);
                            this.$name = r1;
                            this.$cancelable = r2;
                            this.this$0 = http2Connection;
                            this.$newPeerSettings$inlined = rVar;
                        }

                        @Override // okhttp3.internal.concurrent.Task
                        public long runOnce() {
                            this.this$0.getListener$okhttp().onSettings(this.this$0, (Settings) this.$newPeerSettings$inlined.element);
                            return -1L;
                        }
                    }, 0L);
                    q qVar2 = q.f10774a;
                }
                try {
                    http2Connection.getWriter().applyAndAckSettings((Settings) rVar.element);
                } catch (IOException e6) {
                    http2Connection.failConnection(e6);
                }
                q qVar3 = q.f10774a;
            }
            if (http2StreamArr != null) {
                int length = http2StreamArr.length;
                while (i6 < length) {
                    Http2Stream http2Stream = http2StreamArr[i6];
                    i6++;
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(initialWindowSize);
                        q qVar4 = q.f10774a;
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z5, int i6, BufferedSource bufferedSource, int i7) {
            l.d(bufferedSource, "source");
            if (this.this$0.pushedStream$okhttp(i6)) {
                this.this$0.pushDataLater$okhttp(i6, bufferedSource, i7, z5);
                return;
            }
            Http2Stream stream = this.this$0.getStream(i6);
            if (stream == null) {
                this.this$0.writeSynResetLater$okhttp(i6, ErrorCode.PROTOCOL_ERROR);
                long j6 = i7;
                this.this$0.updateConnectionFlowControl$okhttp(j6);
                bufferedSource.skip(j6);
                return;
            }
            stream.receiveData(bufferedSource, i7);
            if (z5) {
                stream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i6, ErrorCode errorCode, ByteString byteString) {
            int i7;
            Object[] array;
            l.d(errorCode, "errorCode");
            l.d(byteString, "debugData");
            byteString.size();
            Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                i7 = 0;
                array = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                http2Connection.isShutdown = true;
                q qVar = q.f10774a;
            }
            Http2Stream[] http2StreamArr = (Http2Stream[]) array;
            int length = http2StreamArr.length;
            while (i7 < length) {
                Http2Stream http2Stream = http2StreamArr[i7];
                i7++;
                if (http2Stream.getId() > i6 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z5, int i6, int i7, List<Header> list) {
            l.d(list, "headerBlock");
            if (this.this$0.pushedStream$okhttp(i6)) {
                this.this$0.pushHeadersLater$okhttp(i6, list, z5);
                return;
            }
            Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                Http2Stream stream = http2Connection.getStream(i6);
                if (stream != null) {
                    q qVar = q.f10774a;
                    stream.receiveHeaders(Util.toHeaders(list), z5);
                } else if (http2Connection.isShutdown) {
                } else {
                    if (i6 <= http2Connection.getLastGoodStreamId$okhttp()) {
                        return;
                    }
                    if (i6 % 2 == http2Connection.getNextStreamId$okhttp() % 2) {
                        return;
                    }
                    Http2Stream http2Stream = new Http2Stream(i6, http2Connection, false, z5, Util.toHeaders(list));
                    http2Connection.setLastGoodStreamId$okhttp(i6);
                    http2Connection.getStreams$okhttp().put(Integer.valueOf(i6), http2Stream);
                    TaskQueue newQueue = http2Connection.taskRunner.newQueue();
                    newQueue.schedule(new Task(http2Connection.getConnectionName$okhttp() + '[' + i6 + "] onStream", true, http2Connection, http2Stream) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$lambda-2$$inlined$execute$default$1
                        final /* synthetic */ boolean $cancelable;
                        final /* synthetic */ String $name;
                        final /* synthetic */ Http2Stream $newStream$inlined;
                        final /* synthetic */ Http2Connection this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r1, r2);
                            this.$name = r1;
                            this.$cancelable = r2;
                            this.this$0 = http2Connection;
                            this.$newStream$inlined = http2Stream;
                        }

                        @Override // okhttp3.internal.concurrent.Task
                        public long runOnce() {
                            try {
                                this.this$0.getListener$okhttp().onStream(this.$newStream$inlined);
                                return -1L;
                            } catch (IOException e6) {
                                Platform.Companion.get().log(l.i("Http2Connection.Listener failure for ", this.this$0.getConnectionName$okhttp()), 4, e6);
                                try {
                                    this.$newStream$inlined.close(ErrorCode.PROTOCOL_ERROR, e6);
                                    return -1L;
                                } catch (IOException unused) {
                                    return -1L;
                                }
                            }
                        }
                    }, 0L);
                }
            }
        }

        @Override // p4.a
        public /* bridge */ /* synthetic */ Object invoke() {
            invoke();
            return q.f10774a;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z5, int i6, int i7) {
            if (!z5) {
                this.this$0.writerQueue.schedule(new Task(l.i(this.this$0.getConnectionName$okhttp(), " ping"), true, this.this$0, i6, i7) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$ping$$inlined$execute$default$1
                    final /* synthetic */ boolean $cancelable;
                    final /* synthetic */ String $name;
                    final /* synthetic */ int $payload1$inlined;
                    final /* synthetic */ int $payload2$inlined;
                    final /* synthetic */ Http2Connection this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r1, r2);
                        this.$name = r1;
                        this.$cancelable = r2;
                        this.this$0 = r3;
                        this.$payload1$inlined = i6;
                        this.$payload2$inlined = i7;
                    }

                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        this.this$0.writePing(true, this.$payload1$inlined, this.$payload2$inlined);
                        return -1L;
                    }
                }, 0L);
                return;
            }
            Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                if (i6 == 1) {
                    http2Connection.intervalPongsReceived++;
                } else if (i6 != 2) {
                    if (i6 == 3) {
                        http2Connection.awaitPongsReceived++;
                        http2Connection.notifyAll();
                    }
                    q qVar = q.f10774a;
                } else {
                    http2Connection.degradedPongsReceived++;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i6, int i7, int i8, boolean z5) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i6, int i7, List<Header> list) {
            l.d(list, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(i7, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i6, ErrorCode errorCode) {
            l.d(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(i6)) {
                this.this$0.pushResetLater$okhttp(i6, errorCode);
                return;
            }
            Http2Stream removeStream$okhttp = this.this$0.removeStream$okhttp(i6);
            if (removeStream$okhttp == null) {
                return;
            }
            removeStream$okhttp.receiveRstStream(errorCode);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(boolean z5, Settings settings) {
            l.d(settings, "settings");
            this.this$0.writerQueue.schedule(new Task(l.i(this.this$0.getConnectionName$okhttp(), " applyAndAckSettings"), true, this, z5, settings) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1
                final /* synthetic */ boolean $cancelable;
                final /* synthetic */ boolean $clearPrevious$inlined;
                final /* synthetic */ String $name;
                final /* synthetic */ Settings $settings$inlined;
                final /* synthetic */ Http2Connection.ReaderRunnable this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r1, r2);
                    this.$name = r1;
                    this.$cancelable = r2;
                    this.this$0 = this;
                    this.$clearPrevious$inlined = z5;
                    this.$settings$inlined = settings;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    this.this$0.applyAndAckSettings(this.$clearPrevious$inlined, this.$settings$inlined);
                    return -1L;
                }
            }, 0L);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i6, long j6) {
            Http2Stream http2Stream;
            if (i6 == 0) {
                Http2Connection http2Connection = this.this$0;
                synchronized (http2Connection) {
                    http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + j6;
                    http2Connection.notifyAll();
                    q qVar = q.f10774a;
                    http2Stream = http2Connection;
                }
            } else {
                Http2Stream stream = this.this$0.getStream(i6);
                if (stream == null) {
                    return;
                }
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j6);
                    q qVar2 = q.f10774a;
                    http2Stream = stream;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, okhttp3.internal.http2.Http2Reader] */
        @Override // p4.a
        public void invoke() {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e6 = null;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    while (this.reader.nextFrame(false, this)) {
                    }
                    ErrorCode errorCode3 = ErrorCode.NO_ERROR;
                    try {
                        this.this$0.close$okhttp(errorCode3, ErrorCode.CANCEL, null);
                        errorCode = errorCode3;
                    } catch (IOException e7) {
                        e6 = e7;
                        ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                        Http2Connection http2Connection = this.this$0;
                        http2Connection.close$okhttp(errorCode4, errorCode4, e6);
                        errorCode = http2Connection;
                        errorCode2 = this.reader;
                        Util.closeQuietly((Closeable) errorCode2);
                    }
                } catch (Throwable th) {
                    th = th;
                    this.this$0.close$okhttp(errorCode, errorCode2, e6);
                    Util.closeQuietly(this.reader);
                    throw th;
                }
            } catch (IOException e8) {
                e6 = e8;
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode2;
                this.this$0.close$okhttp(errorCode, errorCode2, e6);
                Util.closeQuietly(this.reader);
                throw th;
            }
            errorCode2 = this.reader;
            Util.closeQuietly((Closeable) errorCode2);
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        settings.set(5, Http2.INITIAL_MAX_FRAME_SIZE);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(Builder builder) {
        l.d(builder, "builder");
        boolean client$okhttp = builder.getClient$okhttp();
        this.client = client$okhttp;
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        TaskQueue newQueue = taskRunner$okhttp.newQueue();
        this.writerQueue = newQueue;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(7, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        this.okHttpSettings = settings;
        Settings settings2 = DEFAULT_SETTINGS;
        this.peerSettings = settings2;
        this.writeBytesMaximum = settings2.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), client$okhttp);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), client$okhttp));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
            newQueue.schedule(new Task(l.i(connectionName$okhttp, " ping"), this, nanos) { // from class: okhttp3.internal.http2.Http2Connection$special$$inlined$schedule$1
                final /* synthetic */ String $name;
                final /* synthetic */ long $pingIntervalNanos$inlined;
                final /* synthetic */ Http2Connection this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r1, false, 2, null);
                    this.$name = r1;
                    this.this$0 = this;
                    this.$pingIntervalNanos$inlined = nanos;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    long j6;
                    long j7;
                    boolean z5;
                    synchronized (this.this$0) {
                        long j8 = this.this$0.intervalPongsReceived;
                        j6 = this.this$0.intervalPingsSent;
                        if (j8 < j6) {
                            z5 = true;
                        } else {
                            j7 = this.this$0.intervalPingsSent;
                            this.this$0.intervalPingsSent = j7 + 1;
                            z5 = false;
                        }
                    }
                    Http2Connection http2Connection = this.this$0;
                    if (z5) {
                        http2Connection.failConnection(null);
                        return -1L;
                    }
                    http2Connection.writePing(false, 1, 0);
                    return this.$pingIntervalNanos$inlined;
                }
            }, nanos);
        }
    }

    public final void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0055 A[Catch: all -> 0x0096, TryCatch #1 {, blocks: (B:48:0x0006, B:67:0x0062, B:69:0x0065, B:70:0x006d, B:72:0x0074, B:77:0x0084, B:78:0x008f, B:49:0x0007, B:51:0x0010, B:52:0x0015, B:54:0x0019, B:56:0x0033, B:58:0x003f, B:63:0x004f, B:65:0x0055, B:66:0x0060, B:79:0x0090, B:80:0x0095), top: B:87:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Http2Stream newStream(int i6, List<Header> list, boolean z5) {
        int nextStreamId$okhttp;
        Http2Stream http2Stream;
        boolean z6;
        boolean z7 = !z5;
        synchronized (this.writer) {
            synchronized (this) {
                if (getNextStreamId$okhttp() > 1073741823) {
                    shutdown(ErrorCode.REFUSED_STREAM);
                }
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                nextStreamId$okhttp = getNextStreamId$okhttp();
                setNextStreamId$okhttp(getNextStreamId$okhttp() + 2);
                http2Stream = new Http2Stream(nextStreamId$okhttp, this, z7, false, null);
                if (z5 && getWriteBytesTotal() < getWriteBytesMaximum() && http2Stream.getWriteBytesTotal() < http2Stream.getWriteBytesMaximum()) {
                    z6 = false;
                    if (http2Stream.isOpen()) {
                        getStreams$okhttp().put(Integer.valueOf(nextStreamId$okhttp), http2Stream);
                    }
                    q qVar = q.f10774a;
                }
                z6 = true;
                if (http2Stream.isOpen()) {
                }
                q qVar2 = q.f10774a;
            }
            if (i6 == 0) {
                getWriter().headers(z7, nextStreamId$okhttp, list);
            } else if (!(true ^ getClient$okhttp())) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
            } else {
                getWriter().pushPromise(i6, nextStreamId$okhttp, list);
            }
        }
        if (z6) {
            this.writer.flush();
        }
        return http2Stream;
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z5, TaskRunner taskRunner, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = true;
        }
        if ((i6 & 2) != 0) {
            taskRunner = TaskRunner.INSTANCE;
        }
        http2Connection.start(z5, taskRunner);
    }

    public final synchronized void awaitPong() {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode errorCode, ErrorCode errorCode2, IOException iOException) {
        int i6;
        Object[] objArr;
        l.d(errorCode, "connectionCode");
        l.d(errorCode2, "streamCode");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        try {
            shutdown(errorCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (!getStreams$okhttp().isEmpty()) {
                objArr = getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (objArr == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                getStreams$okhttp().clear();
            } else {
                objArr = null;
            }
            q qVar = q.f10774a;
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) objArr;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            getWriter().close();
        } catch (IOException unused3) {
        }
        try {
            getSocket$okhttp().close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final synchronized Http2Stream getStream(int i6) {
        return this.streams.get(Integer.valueOf(i6));
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isHealthy(long j6) {
        if (this.isShutdown) {
            return false;
        }
        if (this.degradedPongsReceived < this.degradedPingsSent) {
            if (j6 >= this.degradedPongDeadlineNs) {
                return false;
            }
        }
        return true;
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    public final void pushDataLater$okhttp(int i6, BufferedSource bufferedSource, int i7, boolean z5) {
        l.d(bufferedSource, "source");
        Buffer buffer = new Buffer();
        long j6 = i7;
        bufferedSource.require(j6);
        bufferedSource.read(buffer, j6);
        this.pushQueue.schedule(new Task(this.connectionName + '[' + i6 + "] onData", true, this, i6, buffer, i7, z5) { // from class: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$default$1
            final /* synthetic */ Buffer $buffer$inlined;
            final /* synthetic */ int $byteCount$inlined;
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ boolean $inFinished$inlined;
            final /* synthetic */ String $name;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ Http2Connection this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r1, r2);
                this.$name = r1;
                this.$cancelable = r2;
                this.this$0 = this;
                this.$streamId$inlined = i6;
                this.$buffer$inlined = buffer;
                this.$byteCount$inlined = i7;
                this.$inFinished$inlined = z5;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                PushObserver pushObserver;
                Set set;
                try {
                    pushObserver = this.this$0.pushObserver;
                    boolean onData = pushObserver.onData(this.$streamId$inlined, this.$buffer$inlined, this.$byteCount$inlined, this.$inFinished$inlined);
                    if (onData) {
                        this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                    }
                    if (onData || this.$inFinished$inlined) {
                        synchronized (this.this$0) {
                            set = this.this$0.currentPushRequests;
                            set.remove(Integer.valueOf(this.$streamId$inlined));
                        }
                        return -1L;
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void pushHeadersLater$okhttp(int i6, List<Header> list, boolean z5) {
        l.d(list, "requestHeaders");
        TaskQueue taskQueue = this.pushQueue;
        taskQueue.schedule(new Task(this.connectionName + '[' + i6 + "] onHeaders", true, this, i6, list, z5) { // from class: okhttp3.internal.http2.Http2Connection$pushHeadersLater$$inlined$execute$default$1
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ boolean $inFinished$inlined;
            final /* synthetic */ String $name;
            final /* synthetic */ List $requestHeaders$inlined;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ Http2Connection this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r1, r2);
                this.$name = r1;
                this.$cancelable = r2;
                this.this$0 = this;
                this.$streamId$inlined = i6;
                this.$requestHeaders$inlined = list;
                this.$inFinished$inlined = z5;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                PushObserver pushObserver;
                Set set;
                pushObserver = this.this$0.pushObserver;
                boolean onHeaders = pushObserver.onHeaders(this.$streamId$inlined, this.$requestHeaders$inlined, this.$inFinished$inlined);
                if (onHeaders) {
                    try {
                        this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
                if (onHeaders || this.$inFinished$inlined) {
                    synchronized (this.this$0) {
                        set = this.this$0.currentPushRequests;
                        set.remove(Integer.valueOf(this.$streamId$inlined));
                    }
                    return -1L;
                }
                return -1L;
            }
        }, 0L);
    }

    public final void pushRequestLater$okhttp(int i6, List<Header> list) {
        l.d(list, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i6))) {
                writeSynResetLater$okhttp(i6, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i6));
            TaskQueue taskQueue = this.pushQueue;
            taskQueue.schedule(new Task(this.connectionName + '[' + i6 + "] onRequest", true, this, i6, list) { // from class: okhttp3.internal.http2.Http2Connection$pushRequestLater$$inlined$execute$default$1
                final /* synthetic */ boolean $cancelable;
                final /* synthetic */ String $name;
                final /* synthetic */ List $requestHeaders$inlined;
                final /* synthetic */ int $streamId$inlined;
                final /* synthetic */ Http2Connection this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r1, r2);
                    this.$name = r1;
                    this.$cancelable = r2;
                    this.this$0 = this;
                    this.$streamId$inlined = i6;
                    this.$requestHeaders$inlined = list;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    PushObserver pushObserver;
                    Set set;
                    pushObserver = this.this$0.pushObserver;
                    if (pushObserver.onRequest(this.$streamId$inlined, this.$requestHeaders$inlined)) {
                        try {
                            this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                            synchronized (this.this$0) {
                                set = this.this$0.currentPushRequests;
                                set.remove(Integer.valueOf(this.$streamId$inlined));
                            }
                            return -1L;
                        } catch (IOException unused) {
                            return -1L;
                        }
                    }
                    return -1L;
                }
            }, 0L);
        }
    }

    public final void pushResetLater$okhttp(int i6, ErrorCode errorCode) {
        l.d(errorCode, "errorCode");
        TaskQueue taskQueue = this.pushQueue;
        taskQueue.schedule(new Task(this.connectionName + '[' + i6 + "] onReset", true, this, i6, errorCode) { // from class: okhttp3.internal.http2.Http2Connection$pushResetLater$$inlined$execute$default$1
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ ErrorCode $errorCode$inlined;
            final /* synthetic */ String $name;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ Http2Connection this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r1, r2);
                this.$name = r1;
                this.$cancelable = r2;
                this.this$0 = this;
                this.$streamId$inlined = i6;
                this.$errorCode$inlined = errorCode;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                PushObserver pushObserver;
                Set set;
                pushObserver = this.this$0.pushObserver;
                pushObserver.onReset(this.$streamId$inlined, this.$errorCode$inlined);
                synchronized (this.this$0) {
                    set = this.this$0.currentPushRequests;
                    set.remove(Integer.valueOf(this.$streamId$inlined));
                    q qVar = q.f10774a;
                }
                return -1L;
            }
        }, 0L);
    }

    public final Http2Stream pushStream(int i6, List<Header> list, boolean z5) {
        l.d(list, "requestHeaders");
        if (!this.client) {
            return newStream(i6, list, z5);
        }
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final boolean pushedStream$okhttp(int i6) {
        return i6 != 0 && (i6 & 1) == 0;
    }

    public final synchronized Http2Stream removeStream$okhttp(int i6) {
        Http2Stream remove;
        remove = this.streams.remove(Integer.valueOf(i6));
        notifyAll();
        return remove;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j6 = this.degradedPongsReceived;
            long j7 = this.degradedPingsSent;
            if (j6 < j7) {
                return;
            }
            this.degradedPingsSent = j7 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + ((long) DEGRADED_PONG_TIMEOUT_NS);
            q qVar = q.f10774a;
            this.writerQueue.schedule(new Task(l.i(this.connectionName, " ping"), true, this) { // from class: okhttp3.internal.http2.Http2Connection$sendDegradedPingLater$$inlined$execute$default$1
                final /* synthetic */ boolean $cancelable;
                final /* synthetic */ String $name;
                final /* synthetic */ Http2Connection this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r1, r2);
                    this.$name = r1;
                    this.$cancelable = r2;
                    this.this$0 = this;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    this.this$0.writePing(false, 2, 0);
                    return -1L;
                }
            }, 0L);
        }
    }

    public final void setLastGoodStreamId$okhttp(int i6) {
        this.lastGoodStreamId = i6;
    }

    public final void setNextStreamId$okhttp(int i6) {
        this.nextStreamId = i6;
    }

    public final void setPeerSettings(Settings settings) {
        l.d(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final void setSettings(Settings settings) {
        l.d(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                getOkHttpSettings().merge(settings);
                q qVar = q.f10774a;
            }
            getWriter().settings(settings);
        }
    }

    public final void shutdown(ErrorCode errorCode) {
        l.d(errorCode, "statusCode");
        synchronized (this.writer) {
            p pVar = new p();
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                pVar.element = getLastGoodStreamId$okhttp();
                q qVar = q.f10774a;
                getWriter().goAway(pVar.element, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public final void start() {
        start$default(this, false, null, 3, null);
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j6) {
        long j7 = this.readBytesTotal + j6;
        this.readBytesTotal = j7;
        long j8 = j7 - this.readBytesAcknowledged;
        if (j8 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j8);
            this.readBytesAcknowledged += j8;
        }
    }

    public final void writeData(int i6, boolean z5, Buffer buffer, long j6) {
        int min;
        long j7;
        if (j6 == 0) {
            this.writer.data(z5, i6, buffer, 0);
            return;
        }
        while (j6 > 0) {
            synchronized (this) {
                while (getWriteBytesTotal() >= getWriteBytesMaximum()) {
                    try {
                        if (!getStreams$okhttp().containsKey(Integer.valueOf(i6))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j6, getWriteBytesMaximum() - getWriteBytesTotal()), getWriter().maxDataLength());
                j7 = min;
                this.writeBytesTotal = getWriteBytesTotal() + j7;
                q qVar = q.f10774a;
            }
            j6 -= j7;
            this.writer.data(z5 && j6 == 0, i6, buffer, min);
        }
    }

    public final void writeHeaders$okhttp(int i6, boolean z5, List<Header> list) {
        l.d(list, "alternating");
        this.writer.headers(z5, i6, list);
    }

    public final void writePing() {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    public final void writePingAndAwaitPong() {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int i6, ErrorCode errorCode) {
        l.d(errorCode, "statusCode");
        this.writer.rstStream(i6, errorCode);
    }

    public final void writeSynResetLater$okhttp(int i6, ErrorCode errorCode) {
        l.d(errorCode, "errorCode");
        TaskQueue taskQueue = this.writerQueue;
        taskQueue.schedule(new Task(this.connectionName + '[' + i6 + "] writeSynReset", true, this, i6, errorCode) { // from class: okhttp3.internal.http2.Http2Connection$writeSynResetLater$$inlined$execute$default$1
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ ErrorCode $errorCode$inlined;
            final /* synthetic */ String $name;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ Http2Connection this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r1, r2);
                this.$name = r1;
                this.$cancelable = r2;
                this.this$0 = this;
                this.$streamId$inlined = i6;
                this.$errorCode$inlined = errorCode;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    this.this$0.writeSynReset$okhttp(this.$streamId$inlined, this.$errorCode$inlined);
                    return -1L;
                } catch (IOException e6) {
                    this.this$0.failConnection(e6);
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void writeWindowUpdateLater$okhttp(int i6, long j6) {
        TaskQueue taskQueue = this.writerQueue;
        taskQueue.schedule(new Task(this.connectionName + '[' + i6 + "] windowUpdate", true, this, i6, j6) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ String $name;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ long $unacknowledgedBytesRead$inlined;
            final /* synthetic */ Http2Connection this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r1, r2);
                this.$name = r1;
                this.$cancelable = r2;
                this.this$0 = this;
                this.$streamId$inlined = i6;
                this.$unacknowledgedBytesRead$inlined = j6;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    this.this$0.getWriter().windowUpdate(this.$streamId$inlined, this.$unacknowledgedBytesRead$inlined);
                    return -1L;
                } catch (IOException e6) {
                    this.this$0.failConnection(e6);
                    return -1L;
                }
            }
        }, 0L);
    }

    public final Http2Stream newStream(List<Header> list, boolean z5) {
        l.d(list, "requestHeaders");
        return newStream(0, list, z5);
    }

    public final void start(boolean z5) {
        start$default(this, z5, null, 2, null);
    }

    public final void writePing(boolean z5, int i6, int i7) {
        try {
            this.writer.ping(z5, i6, i7);
        } catch (IOException e6) {
            failConnection(e6);
        }
    }

    public final void start(boolean z5, TaskRunner taskRunner) {
        l.d(taskRunner, "taskRunner");
        if (z5) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, initialWindowSize - Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            }
        }
        taskRunner.newQueue().schedule(new TaskQueue$execute$1(this.connectionName, true, this.readerRunnable), 0L);
    }
}
