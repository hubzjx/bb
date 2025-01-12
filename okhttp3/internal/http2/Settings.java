package okhttp3.internal.http2;

import kotlin.collections.i;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
public final class Settings {
    public static final int COUNT = 10;
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final void clear() {
        this.set = 0;
        i.l(this.values, 0, 0, 0, 6, null);
    }

    public final int get(int i6) {
        return this.values[i6];
    }

    public final boolean getEnablePush(boolean z5) {
        return (this.set & 4) != 0 ? this.values[2] == 1 : z5;
    }

    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int getInitialWindowSize() {
        return (this.set & 128) != 0 ? this.values[7] : DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public final int getMaxConcurrentStreams() {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int getMaxFrameSize(int i6) {
        return (this.set & 32) != 0 ? this.values[5] : i6;
    }

    public final int getMaxHeaderListSize(int i6) {
        return (this.set & 64) != 0 ? this.values[6] : i6;
    }

    public final boolean isSet(int i6) {
        return ((1 << i6) & this.set) != 0;
    }

    public final void merge(Settings settings) {
        l.d(settings, "other");
        int i6 = 0;
        while (i6 < 10) {
            int i7 = i6 + 1;
            if (settings.isSet(i6)) {
                set(i6, settings.get(i6));
            }
            i6 = i7;
        }
    }

    public final Settings set(int i6, int i7) {
        if (i6 >= 0) {
            int[] iArr = this.values;
            if (i6 < iArr.length) {
                this.set = (1 << i6) | this.set;
                iArr[i6] = i7;
            }
        }
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}
