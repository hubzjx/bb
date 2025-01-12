package s2;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.x;
import com.google.android.exoplayer2.mediacodec.y;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.t0;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.s0;
import io.jsonwebtoken.JwtParser;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import s2.u;
/* loaded from: classes.dex */
public class h extends com.google.android.exoplayer2.mediacodec.m {

    /* renamed from: t1  reason: collision with root package name */
    private static final int[] f13192t1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* renamed from: u1  reason: collision with root package name */
    private static final Method f13193u1;

    /* renamed from: v1  reason: collision with root package name */
    private static boolean f13194v1;

    /* renamed from: w1  reason: collision with root package name */
    private static boolean f13195w1;
    private final Context H0;
    private final k I0;
    private final u.a J0;
    private final long K0;
    private final int L0;
    private final boolean M0;
    private a N0;
    private boolean O0;
    private boolean P0;
    private Surface Q0;
    private float R0;
    private Surface S0;
    private boolean T0;
    private int U0;
    private boolean V0;
    private boolean W0;
    private boolean X0;
    private long Y0;
    private long Z0;

    /* renamed from: a1  reason: collision with root package name */
    private long f13196a1;

    /* renamed from: b1  reason: collision with root package name */
    private int f13197b1;

    /* renamed from: c1  reason: collision with root package name */
    private int f13198c1;

    /* renamed from: d1  reason: collision with root package name */
    private int f13199d1;

    /* renamed from: e1  reason: collision with root package name */
    private long f13200e1;

    /* renamed from: f1  reason: collision with root package name */
    private long f13201f1;

    /* renamed from: g1  reason: collision with root package name */
    private int f13202g1;

    /* renamed from: h1  reason: collision with root package name */
    private int f13203h1;

    /* renamed from: i1  reason: collision with root package name */
    private int f13204i1;

    /* renamed from: j1  reason: collision with root package name */
    private int f13205j1;

    /* renamed from: k1  reason: collision with root package name */
    private float f13206k1;

    /* renamed from: l1  reason: collision with root package name */
    private float f13207l1;

    /* renamed from: m1  reason: collision with root package name */
    private int f13208m1;

    /* renamed from: n1  reason: collision with root package name */
    private int f13209n1;

    /* renamed from: o1  reason: collision with root package name */
    private int f13210o1;

    /* renamed from: p1  reason: collision with root package name */
    private float f13211p1;

    /* renamed from: q1  reason: collision with root package name */
    private boolean f13212q1;

    /* renamed from: r1  reason: collision with root package name */
    private int f13213r1;

    /* renamed from: s1  reason: collision with root package name */
    b f13214s1;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f13215a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13216b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13217c;

        public a(int i6, int i7, int i8) {
            this.f13215a = i6;
            this.f13216b = i7;
            this.f13217c = i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements MediaCodec.OnFrameRenderedListener, Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f13218a;

        public b(MediaCodec mediaCodec) {
            Handler y5 = s0.y(this);
            this.f13218a = y5;
            mediaCodec.setOnFrameRenderedListener(this, y5);
        }

        private void a(long j6) {
            h hVar = h.this;
            if (this != hVar.f13214s1) {
                return;
            }
            if (j6 == Long.MAX_VALUE) {
                hVar.S1();
                return;
            }
            try {
                hVar.R1(j6);
            } catch (com.google.android.exoplayer2.t e6) {
                h.this.h1(e6);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a(s0.R0(message.arg1, message.arg2));
            return true;
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(MediaCodec mediaCodec, long j6, long j7) {
            if (s0.f4673a >= 30) {
                a(j6);
                return;
            }
            this.f13218a.sendMessageAtFrontOfQueue(Message.obtain(this.f13218a, 0, (int) (j6 >> 32), (int) j6));
        }
    }

    static {
        Method method;
        if (s0.f4673a >= 30) {
            try {
                method = Surface.class.getMethod("setFrameRate", Float.TYPE, Integer.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            f13193u1 = method;
        }
        method = null;
        f13193u1 = method;
    }

    public h(Context context, com.google.android.exoplayer2.mediacodec.o oVar, long j6, boolean z5, Handler handler, u uVar, int i6) {
        super(2, oVar, z5, 30.0f);
        this.K0 = j6;
        this.L0 = i6;
        Context applicationContext = context.getApplicationContext();
        this.H0 = applicationContext;
        this.I0 = new k(applicationContext);
        this.J0 = new u.a(handler, uVar);
        this.M0 = y1();
        this.Z0 = -9223372036854775807L;
        this.f13203h1 = -1;
        this.f13204i1 = -1;
        this.f13206k1 = -1.0f;
        this.U0 = 1;
        u1();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x07cf, code lost:
        if (r0.equals("CP8676_I02") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:604:0x0819, code lost:
        if (r0.equals("AFTN") == false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean A1() {
        char c6;
        int i6 = s0.f4673a;
        char c7 = 4;
        char c8 = 2;
        if (i6 <= 28) {
            String str = s0.f4674b;
            str.hashCode();
            switch (str.hashCode()) {
                case -1339091551:
                    if (str.equals("dangal")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1220081023:
                    if (str.equals("dangalFHD")) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1220066608:
                    if (str.equals("dangalUHD")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -64886864:
                    if (str.equals("magnolia")) {
                        c6 = 3;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 825323514:
                    if (str.equals("machuca")) {
                        c6 = 4;
                        break;
                    }
                    c6 = 65535;
                    break;
                default:
                    c6 = 65535;
                    break;
            }
            switch (c6) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    return true;
            }
        }
        if (i6 > 27 || !"HWEML".equals(s0.f4674b)) {
            if (i6 <= 26) {
                String str2 = s0.f4674b;
                str2.hashCode();
                switch (str2.hashCode()) {
                    case -2144781245:
                        if (str2.equals("GIONEE_SWW1609")) {
                            c7 = 0;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -2144781185:
                        if (str2.equals("GIONEE_SWW1627")) {
                            c7 = 1;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -2144781160:
                        if (str2.equals("GIONEE_SWW1631")) {
                            c7 = 2;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -2097309513:
                        if (str2.equals("K50a40")) {
                            c7 = 3;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -2022874474:
                        break;
                    case -1978993182:
                        if (str2.equals("NX541J")) {
                            c7 = 5;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1978990237:
                        if (str2.equals("NX573J")) {
                            c7 = 6;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1936688988:
                        if (str2.equals("PGN528")) {
                            c7 = 7;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1936688066:
                        if (str2.equals("PGN610")) {
                            c7 = '\b';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1936688065:
                        if (str2.equals("PGN611")) {
                            c7 = '\t';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1931988508:
                        if (str2.equals("AquaPowerM")) {
                            c7 = '\n';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1885099851:
                        if (str2.equals("RAIJIN")) {
                            c7 = 11;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1696512866:
                        if (str2.equals("XT1663")) {
                            c7 = '\f';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1680025915:
                        if (str2.equals("ComioS1")) {
                            c7 = '\r';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1615810839:
                        if (str2.equals("Phantom6")) {
                            c7 = 14;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1600724499:
                        if (str2.equals("pacificrim")) {
                            c7 = 15;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1554255044:
                        if (str2.equals("vernee_M5")) {
                            c7 = 16;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1481772737:
                        if (str2.equals("panell_dl")) {
                            c7 = 17;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1481772730:
                        if (str2.equals("panell_ds")) {
                            c7 = 18;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1481772729:
                        if (str2.equals("panell_dt")) {
                            c7 = 19;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1320080169:
                        if (str2.equals("GiONEE_GBL7319")) {
                            c7 = 20;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1217592143:
                        if (str2.equals("BRAVIA_ATV2")) {
                            c7 = 21;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1180384755:
                        if (str2.equals("iris60")) {
                            c7 = 22;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1139198265:
                        if (str2.equals("Slate_Pro")) {
                            c7 = 23;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -1052835013:
                        if (str2.equals("namath")) {
                            c7 = 24;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -993250464:
                        if (str2.equals("A10-70F")) {
                            c7 = 25;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -993250458:
                        if (str2.equals("A10-70L")) {
                            c7 = 26;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -965403638:
                        if (str2.equals("s905x018")) {
                            c7 = 27;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -958336948:
                        if (str2.equals("ELUGA_Ray_X")) {
                            c7 = 28;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -879245230:
                        if (str2.equals("tcl_eu")) {
                            c7 = 29;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -842500323:
                        if (str2.equals("nicklaus_f")) {
                            c7 = 30;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -821392978:
                        if (str2.equals("A7000-a")) {
                            c7 = 31;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -797483286:
                        if (str2.equals("SVP-DTV15")) {
                            c7 = ' ';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -794946968:
                        if (str2.equals("watson")) {
                            c7 = '!';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -788334647:
                        if (str2.equals("whyred")) {
                            c7 = '\"';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -782144577:
                        if (str2.equals("OnePlus5T")) {
                            c7 = '#';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -575125681:
                        if (str2.equals("GiONEE_CBL7513")) {
                            c7 = '$';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -521118391:
                        if (str2.equals("GIONEE_GBL7360")) {
                            c7 = '%';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -430914369:
                        if (str2.equals("Pixi4-7_3G")) {
                            c7 = '&';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -290434366:
                        if (str2.equals("taido_row")) {
                            c7 = '\'';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -282781963:
                        if (str2.equals("BLACK-1X")) {
                            c7 = '(';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -277133239:
                        if (str2.equals("Z12_PRO")) {
                            c7 = ')';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -173639913:
                        if (str2.equals("ELUGA_A3_Pro")) {
                            c7 = '*';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case -56598463:
                        if (str2.equals("woods_fn")) {
                            c7 = '+';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2126:
                        if (str2.equals("C1")) {
                            c7 = ',';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2564:
                        if (str2.equals("Q5")) {
                            c7 = '-';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2715:
                        if (str2.equals("V1")) {
                            c7 = JwtParser.SEPARATOR_CHAR;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2719:
                        if (str2.equals("V5")) {
                            c7 = '/';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 3091:
                        if (str2.equals("b5")) {
                            c7 = '0';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 3483:
                        if (str2.equals("mh")) {
                            c7 = '1';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 73405:
                        if (str2.equals("JGZ")) {
                            c7 = '2';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 75537:
                        if (str2.equals("M04")) {
                            c7 = '3';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 75739:
                        if (str2.equals("M5c")) {
                            c7 = '4';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 76779:
                        if (str2.equals("MX6")) {
                            c7 = '5';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 78669:
                        if (str2.equals("P85")) {
                            c7 = '6';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 79305:
                        if (str2.equals("PLE")) {
                            c7 = '7';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 80618:
                        if (str2.equals("QX1")) {
                            c7 = '8';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 88274:
                        if (str2.equals("Z80")) {
                            c7 = '9';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 98846:
                        if (str2.equals("cv1")) {
                            c7 = ':';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 98848:
                        if (str2.equals("cv3")) {
                            c7 = ';';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 99329:
                        if (str2.equals("deb")) {
                            c7 = '<';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 101481:
                        if (str2.equals("flo")) {
                            c7 = '=';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1513190:
                        if (str2.equals("1601")) {
                            c7 = '>';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1514184:
                        if (str2.equals("1713")) {
                            c7 = '?';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1514185:
                        if (str2.equals("1714")) {
                            c7 = '@';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2133089:
                        if (str2.equals("F01H")) {
                            c7 = 'A';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2133091:
                        if (str2.equals("F01J")) {
                            c7 = 'B';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2133120:
                        if (str2.equals("F02H")) {
                            c7 = 'C';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2133151:
                        if (str2.equals("F03H")) {
                            c7 = 'D';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2133182:
                        if (str2.equals("F04H")) {
                            c7 = 'E';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2133184:
                        if (str2.equals("F04J")) {
                            c7 = 'F';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2436959:
                        if (str2.equals("P681")) {
                            c7 = 'G';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2463773:
                        if (str2.equals("Q350")) {
                            c7 = 'H';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2464648:
                        if (str2.equals("Q427")) {
                            c7 = 'I';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2689555:
                        if (str2.equals("XE2X")) {
                            c7 = 'J';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 3154429:
                        if (str2.equals("fugu")) {
                            c7 = 'K';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 3284551:
                        if (str2.equals("kate")) {
                            c7 = 'L';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 3351335:
                        if (str2.equals("mido")) {
                            c7 = 'M';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 3386211:
                        if (str2.equals("p212")) {
                            c7 = 'N';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 41325051:
                        if (str2.equals("MEIZU_M5")) {
                            c7 = 'O';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 51349633:
                        if (str2.equals("601LV")) {
                            c7 = 'P';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 51350594:
                        if (str2.equals("602LV")) {
                            c7 = 'Q';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 55178625:
                        if (str2.equals("Aura_Note_2")) {
                            c7 = 'R';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 61542055:
                        if (str2.equals("A1601")) {
                            c7 = 'S';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 65355429:
                        if (str2.equals("E5643")) {
                            c7 = 'T';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 66214468:
                        if (str2.equals("F3111")) {
                            c7 = 'U';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 66214470:
                        if (str2.equals("F3113")) {
                            c7 = 'V';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 66214473:
                        if (str2.equals("F3116")) {
                            c7 = 'W';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 66215429:
                        if (str2.equals("F3211")) {
                            c7 = 'X';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 66215431:
                        if (str2.equals("F3213")) {
                            c7 = 'Y';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 66215433:
                        if (str2.equals("F3215")) {
                            c7 = 'Z';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 66216390:
                        if (str2.equals("F3311")) {
                            c7 = '[';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 76402249:
                        if (str2.equals("PRO7S")) {
                            c7 = '\\';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 76404105:
                        if (str2.equals("Q4260")) {
                            c7 = ']';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 76404911:
                        if (str2.equals("Q4310")) {
                            c7 = '^';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 80963634:
                        if (str2.equals("V23GB")) {
                            c7 = '_';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 82882791:
                        if (str2.equals("X3_HK")) {
                            c7 = '`';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 98715550:
                        if (str2.equals("i9031")) {
                            c7 = 'a';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 101370885:
                        if (str2.equals("l5460")) {
                            c7 = 'b';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 102844228:
                        if (str2.equals("le_x6")) {
                            c7 = 'c';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 165221241:
                        if (str2.equals("A2016a40")) {
                            c7 = 'd';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 182191441:
                        if (str2.equals("CPY83_I00")) {
                            c7 = 'e';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 245388979:
                        if (str2.equals("marino_f")) {
                            c7 = 'f';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 287431619:
                        if (str2.equals("griffin")) {
                            c7 = 'g';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 307593612:
                        if (str2.equals("A7010a48")) {
                            c7 = 'h';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 308517133:
                        if (str2.equals("A7020a48")) {
                            c7 = 'i';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 316215098:
                        if (str2.equals("TB3-730F")) {
                            c7 = 'j';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 316215116:
                        if (str2.equals("TB3-730X")) {
                            c7 = 'k';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 316246811:
                        if (str2.equals("TB3-850F")) {
                            c7 = 'l';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 316246818:
                        if (str2.equals("TB3-850M")) {
                            c7 = 'm';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 407160593:
                        if (str2.equals("Pixi5-10_4G")) {
                            c7 = 'n';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 507412548:
                        if (str2.equals("QM16XE_U")) {
                            c7 = 'o';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 793982701:
                        if (str2.equals("GIONEE_WBL5708")) {
                            c7 = 'p';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 794038622:
                        if (str2.equals("GIONEE_WBL7365")) {
                            c7 = 'q';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 794040393:
                        if (str2.equals("GIONEE_WBL7519")) {
                            c7 = 'r';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 835649806:
                        if (str2.equals("manning")) {
                            c7 = 's';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 917340916:
                        if (str2.equals("A7000plus")) {
                            c7 = 't';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 958008161:
                        if (str2.equals("j2xlteins")) {
                            c7 = 'u';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1060579533:
                        if (str2.equals("panell_d")) {
                            c7 = 'v';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1150207623:
                        if (str2.equals("LS-5017")) {
                            c7 = 'w';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1176899427:
                        if (str2.equals("itel_S41")) {
                            c7 = 'x';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1280332038:
                        if (str2.equals("hwALE-H")) {
                            c7 = 'y';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1306947716:
                        if (str2.equals("EverStar_S")) {
                            c7 = 'z';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1349174697:
                        if (str2.equals("htc_e56ml_dtul")) {
                            c7 = '{';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1522194893:
                        if (str2.equals("woods_f")) {
                            c7 = '|';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1691543273:
                        if (str2.equals("CPH1609")) {
                            c7 = '}';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1691544261:
                        if (str2.equals("CPH1715")) {
                            c7 = '~';
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1709443163:
                        if (str2.equals("iball8735_9806")) {
                            c7 = 127;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1865889110:
                        if (str2.equals("santoni")) {
                            c7 = 128;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1906253259:
                        if (str2.equals("PB2-670M")) {
                            c7 = 129;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 1977196784:
                        if (str2.equals("Infinix-X572")) {
                            c7 = 130;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2006372676:
                        if (str2.equals("BRAVIA_ATV3_4K")) {
                            c7 = 131;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2019281702:
                        if (str2.equals("DM-01K")) {
                            c7 = 132;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2029784656:
                        if (str2.equals("HWBLN-H")) {
                            c7 = 133;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2030379515:
                        if (str2.equals("HWCAM-H")) {
                            c7 = 134;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2033393791:
                        if (str2.equals("ASUS_X00AD_2")) {
                            c7 = 135;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2047190025:
                        if (str2.equals("ELUGA_Note")) {
                            c7 = 136;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2047252157:
                        if (str2.equals("ELUGA_Prim")) {
                            c7 = 137;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2048319463:
                        if (str2.equals("HWVNS-H")) {
                            c7 = 138;
                            break;
                        }
                        c7 = 65535;
                        break;
                    case 2048855701:
                        if (str2.equals("HWWAS-H")) {
                            c7 = 139;
                            break;
                        }
                        c7 = 65535;
                        break;
                    default:
                        c7 = 65535;
                        break;
                }
                switch (c7) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case '\b':
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case ' ':
                    case '!':
                    case '\"':
                    case '#':
                    case '$':
                    case '%':
                    case '&':
                    case '\'':
                    case '(':
                    case ')':
                    case '*':
                    case '+':
                    case ',':
                    case '-':
                    case '.':
                    case '/':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                    case 'A':
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F':
                    case 'G':
                    case 'H':
                    case 'I':
                    case 'J':
                    case 'K':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'O':
                    case 'P':
                    case 'Q':
                    case 'R':
                    case 'S':
                    case 'T':
                    case 'U':
                    case 'V':
                    case 'W':
                    case 'X':
                    case 'Y':
                    case androidx.constraintlayout.widget.g.I0 /* 90 */:
                    case androidx.constraintlayout.widget.g.J0 /* 91 */:
                    case androidx.constraintlayout.widget.g.K0 /* 92 */:
                    case androidx.constraintlayout.widget.g.L0 /* 93 */:
                    case androidx.constraintlayout.widget.g.M0 /* 94 */:
                    case androidx.constraintlayout.widget.g.N0 /* 95 */:
                    case androidx.constraintlayout.widget.g.O0 /* 96 */:
                    case androidx.constraintlayout.widget.g.P0 /* 97 */:
                    case androidx.constraintlayout.widget.g.Q0 /* 98 */:
                    case androidx.constraintlayout.widget.g.R0 /* 99 */:
                    case 'd':
                    case androidx.constraintlayout.widget.g.T0 /* 101 */:
                    case androidx.constraintlayout.widget.g.U0 /* 102 */:
                    case androidx.constraintlayout.widget.g.V0 /* 103 */:
                    case androidx.constraintlayout.widget.g.W0 /* 104 */:
                    case 'i':
                    case androidx.constraintlayout.widget.g.X0 /* 106 */:
                    case androidx.constraintlayout.widget.g.Y0 /* 107 */:
                    case androidx.constraintlayout.widget.g.Z0 /* 108 */:
                    case 'm':
                    case 'n':
                    case 'o':
                    case 'p':
                    case 'q':
                    case b.j.D0 /* 114 */:
                    case b.j.E0 /* 115 */:
                    case b.j.F0 /* 116 */:
                    case b.j.G0 /* 117 */:
                    case b.j.H0 /* 118 */:
                    case b.j.I0 /* 119 */:
                    case b.j.J0 /* 120 */:
                    case b.j.K0 /* 121 */:
                    case b.j.L0 /* 122 */:
                    case b.j.M0 /* 123 */:
                    case b.j.N0 /* 124 */:
                    case '}':
                    case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                    case 131:
                    case 132:
                    case 133:
                    case 134:
                    case 135:
                    case 136:
                    case 137:
                    case 138:
                    case 139:
                        break;
                    default:
                        String str3 = s0.f4676d;
                        str3.hashCode();
                        switch (str3.hashCode()) {
                            case -594534941:
                                if (str3.equals("JSN-L21")) {
                                    c8 = 0;
                                    break;
                                }
                                c8 = 65535;
                                break;
                            case 2006354:
                                if (str3.equals("AFTA")) {
                                    c8 = 1;
                                    break;
                                }
                                c8 = 65535;
                                break;
                            case 2006367:
                                break;
                            default:
                                c8 = 65535;
                                break;
                        }
                        switch (c8) {
                        }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int B1(com.google.android.exoplayer2.mediacodec.j jVar, String str, int i6, int i7) {
        char c6;
        int i8;
        if (i6 == -1 || i7 == -1) {
            return -1;
        }
        str.hashCode();
        int i9 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c6 = 3;
                    break;
                }
                c6 = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c6 = 4;
                    break;
                }
                c6 = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c6 = 5;
                    break;
                }
                c6 = 65535;
                break;
            default:
                c6 = 65535;
                break;
        }
        switch (c6) {
            case 0:
            case 2:
            case 4:
                i8 = i6 * i7;
                i9 = 2;
                break;
            case 1:
            case 5:
                i8 = i6 * i7;
                break;
            case 3:
                String str2 = s0.f4676d;
                if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(s0.f4675c) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !jVar.f3867g)))) {
                    i8 = s0.l(i6, 16) * s0.l(i7, 16) * 16 * 16;
                    i9 = 2;
                    break;
                } else {
                    return -1;
                }
                break;
            default:
                return -1;
        }
        return (i8 * 3) / (i9 * 2);
    }

    private static Point C1(com.google.android.exoplayer2.mediacodec.j jVar, com.google.android.exoplayer2.s0 s0Var) {
        int[] iArr;
        int i6 = s0Var.f4062t;
        int i7 = s0Var.f4061s;
        boolean z5 = i6 > i7;
        int i8 = z5 ? i6 : i7;
        if (z5) {
            i6 = i7;
        }
        float f6 = i6 / i8;
        for (int i9 : f13192t1) {
            int i10 = (int) (i9 * f6);
            if (i9 <= i8 || i10 <= i6) {
                break;
            }
            if (s0.f4673a >= 21) {
                int i11 = z5 ? i10 : i9;
                if (!z5) {
                    i9 = i10;
                }
                Point b6 = jVar.b(i11, i9);
                if (jVar.t(b6.x, b6.y, s0Var.f4063u)) {
                    return b6;
                }
            } else {
                try {
                    int l6 = s0.l(i9, 16) * 16;
                    int l7 = s0.l(i10, 16) * 16;
                    if (l6 * l7 <= x.N()) {
                        int i12 = z5 ? l7 : l6;
                        if (!z5) {
                            l6 = l7;
                        }
                        return new Point(i12, l6);
                    }
                } catch (x.c unused) {
                }
            }
        }
        return null;
    }

    private static List E1(com.google.android.exoplayer2.mediacodec.o oVar, com.google.android.exoplayer2.s0 s0Var, boolean z5, boolean z6) {
        Pair q5;
        String str;
        String str2 = s0Var.f4056n;
        if (str2 == null) {
            return Collections.emptyList();
        }
        List u5 = x.u(oVar.a(str2, z5, z6), s0Var);
        if ("video/dolby-vision".equals(str2) && (q5 = x.q(s0Var)) != null) {
            int intValue = ((Integer) q5.first).intValue();
            if (intValue != 16 && intValue != 256) {
                str = intValue == 512 ? "video/avc" : "video/hevc";
            }
            u5.addAll(oVar.a(str, z5, z6));
        }
        return Collections.unmodifiableList(u5);
    }

    protected static int F1(com.google.android.exoplayer2.mediacodec.j jVar, com.google.android.exoplayer2.s0 s0Var) {
        if (s0Var.f4057o != -1) {
            int size = s0Var.f4058p.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                i6 += ((byte[]) s0Var.f4058p.get(i7)).length;
            }
            return s0Var.f4057o + i6;
        }
        return B1(jVar, s0Var.f4056n, s0Var.f4061s, s0Var.f4062t);
    }

    private static boolean H1(long j6) {
        return j6 < -30000;
    }

    private static boolean I1(long j6) {
        return j6 < -500000;
    }

    private void K1() {
        if (this.f13197b1 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.J0.k(this.f13197b1, elapsedRealtime - this.f13196a1);
            this.f13197b1 = 0;
            this.f13196a1 = elapsedRealtime;
        }
    }

    private void M1() {
        int i6 = this.f13202g1;
        if (i6 != 0) {
            this.J0.w(this.f13201f1, i6);
            this.f13201f1 = 0L;
            this.f13202g1 = 0;
        }
    }

    private void N1() {
        int i6 = this.f13203h1;
        if (i6 == -1 && this.f13204i1 == -1) {
            return;
        }
        if (this.f13208m1 == i6 && this.f13209n1 == this.f13204i1 && this.f13210o1 == this.f13205j1 && this.f13211p1 == this.f13206k1) {
            return;
        }
        this.J0.x(i6, this.f13204i1, this.f13205j1, this.f13206k1);
        this.f13208m1 = this.f13203h1;
        this.f13209n1 = this.f13204i1;
        this.f13210o1 = this.f13205j1;
        this.f13211p1 = this.f13206k1;
    }

    private void O1() {
        if (this.T0) {
            this.J0.v(this.Q0);
        }
    }

    private void P1() {
        int i6 = this.f13208m1;
        if (i6 == -1 && this.f13209n1 == -1) {
            return;
        }
        this.J0.x(i6, this.f13209n1, this.f13210o1, this.f13211p1);
    }

    private void Q1(long j6, long j7, com.google.android.exoplayer2.s0 s0Var) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1() {
        g1();
    }

    private static void V1(MediaCodec mediaCodec, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodec.setParameters(bundle);
    }

    private void W1() {
        this.Z0 = this.K0 > 0 ? SystemClock.elapsedRealtime() + this.K0 : -9223372036854775807L;
    }

    private void Y1(Surface surface) {
        if (surface == null) {
            Surface surface2 = this.S0;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.google.android.exoplayer2.mediacodec.j o02 = o0();
                if (o02 != null && d2(o02)) {
                    surface = d.g(this.H0, o02.f3867g);
                    this.S0 = surface;
                }
            }
        }
        if (this.Q0 == surface) {
            if (surface == null || surface == this.S0) {
                return;
            }
            P1();
            O1();
            return;
        }
        v1();
        this.Q0 = surface;
        this.T0 = false;
        g2(true);
        int state = getState();
        MediaCodec m02 = m0();
        if (m02 != null) {
            if (s0.f4673a < 23 || surface == null || this.O0) {
                Y0();
                I0();
            } else {
                X1(m02, surface);
            }
        }
        if (surface == null || surface == this.S0) {
            u1();
            t1();
            return;
        }
        P1();
        t1();
        if (state == 2) {
            W1();
        }
    }

    private void Z1(Surface surface, float f6) {
        Method method = f13193u1;
        if (method == null) {
            com.google.android.exoplayer2.util.n.c("MediaCodecVideoRenderer", "Failed to call Surface.setFrameRate (method does not exist)");
        }
        try {
            method.invoke(surface, Float.valueOf(f6), Integer.valueOf(f6 == 0.0f ? 0 : 1));
        } catch (Exception e6) {
            com.google.android.exoplayer2.util.n.d("MediaCodecVideoRenderer", "Failed to call Surface.setFrameRate", e6);
        }
    }

    private boolean d2(com.google.android.exoplayer2.mediacodec.j jVar) {
        return s0.f4673a >= 23 && !this.f13212q1 && !w1(jVar.f3861a) && (!jVar.f3867g || d.f(this.H0));
    }

    private void g2(boolean z5) {
        Surface surface;
        if (s0.f4673a < 30 || (surface = this.Q0) == null || surface == this.S0) {
            return;
        }
        float w02 = getState() == 2 && (this.f13207l1 > (-1.0f) ? 1 : (this.f13207l1 == (-1.0f) ? 0 : -1)) != 0 ? this.f13207l1 * w0() : 0.0f;
        if (this.R0 != w02 || z5) {
            this.R0 = w02;
            Z1(this.Q0, w02);
        }
    }

    private void t1() {
        MediaCodec m02;
        this.V0 = false;
        if (s0.f4673a < 23 || !this.f13212q1 || (m02 = m0()) == null) {
            return;
        }
        this.f13214s1 = new b(m02);
    }

    private void u1() {
        this.f13208m1 = -1;
        this.f13209n1 = -1;
        this.f13211p1 = -1.0f;
        this.f13210o1 = -1;
    }

    private void v1() {
        Surface surface;
        if (s0.f4673a < 30 || (surface = this.Q0) == null || surface == this.S0 || this.R0 == 0.0f) {
            return;
        }
        this.R0 = 0.0f;
        Z1(surface, 0.0f);
    }

    private static void x1(MediaFormat mediaFormat, int i6) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i6);
    }

    private static boolean y1() {
        return "NVIDIA".equals(s0.f4675c);
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected void A0(com.google.android.exoplayer2.decoder.j jVar) {
        if (this.P0) {
            ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(jVar.f3603e);
            if (byteBuffer.remaining() >= 7) {
                byte b6 = byteBuffer.get();
                short s5 = byteBuffer.getShort();
                short s6 = byteBuffer.getShort();
                byte b7 = byteBuffer.get();
                byte b8 = byteBuffer.get();
                byteBuffer.position(0);
                if (b6 == -75 && s5 == 60 && s6 == 1 && b7 == 4 && b8 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    V1(m0(), bArr);
                }
            }
        }
    }

    protected a D1(com.google.android.exoplayer2.mediacodec.j jVar, com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.s0[] s0VarArr) {
        int B1;
        int i6 = s0Var.f4061s;
        int i7 = s0Var.f4062t;
        int F1 = F1(jVar, s0Var);
        if (s0VarArr.length == 1) {
            if (F1 != -1 && (B1 = B1(jVar, s0Var.f4056n, s0Var.f4061s, s0Var.f4062t)) != -1) {
                F1 = Math.min((int) (F1 * 1.5f), B1);
            }
            return new a(i6, i7, F1);
        }
        boolean z5 = false;
        for (com.google.android.exoplayer2.s0 s0Var2 : s0VarArr) {
            if (jVar.o(s0Var, s0Var2, false)) {
                int i8 = s0Var2.f4061s;
                z5 |= i8 == -1 || s0Var2.f4062t == -1;
                i6 = Math.max(i6, i8);
                i7 = Math.max(i7, s0Var2.f4062t);
                F1 = Math.max(F1, F1(jVar, s0Var2));
            }
        }
        if (z5) {
            StringBuilder sb = new StringBuilder(66);
            sb.append("Resolutions unknown. Codec max resolution: ");
            sb.append(i6);
            sb.append("x");
            sb.append(i7);
            com.google.android.exoplayer2.util.n.h("MediaCodecVideoRenderer", sb.toString());
            Point C1 = C1(jVar, s0Var);
            if (C1 != null) {
                i6 = Math.max(i6, C1.x);
                i7 = Math.max(i7, C1.y);
                F1 = Math.max(F1, B1(jVar, s0Var.f4056n, i6, i7));
                StringBuilder sb2 = new StringBuilder(57);
                sb2.append("Codec max resolution adjusted to: ");
                sb2.append(i6);
                sb2.append("x");
                sb2.append(i7);
                com.google.android.exoplayer2.util.n.h("MediaCodecVideoRenderer", sb2.toString());
            }
        }
        return new a(i6, i7, F1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o
    public void G() {
        u1();
        t1();
        this.T0 = false;
        this.I0.d();
        this.f13214s1 = null;
        try {
            super.G();
        } finally {
            this.J0.j(this.C0);
        }
    }

    protected MediaFormat G1(com.google.android.exoplayer2.s0 s0Var, String str, a aVar, float f6, boolean z5, int i6) {
        Pair q5;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", s0Var.f4061s);
        mediaFormat.setInteger("height", s0Var.f4062t);
        y.e(mediaFormat, s0Var.f4058p);
        y.c(mediaFormat, "frame-rate", s0Var.f4063u);
        y.d(mediaFormat, "rotation-degrees", s0Var.f4064v);
        y.b(mediaFormat, s0Var.f4068z);
        if ("video/dolby-vision".equals(s0Var.f4056n) && (q5 = x.q(s0Var)) != null) {
            y.d(mediaFormat, "profile", ((Integer) q5.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.f13215a);
        mediaFormat.setInteger("max-height", aVar.f13216b);
        y.d(mediaFormat, "max-input-size", aVar.f13217c);
        if (s0.f4673a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f6 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f6);
            }
        }
        if (z5) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i6 != 0) {
            x1(mediaFormat, i6);
        }
        return mediaFormat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o
    public void H(boolean z5, boolean z6) {
        super.H(z5, z6);
        int i6 = this.f13213r1;
        int i7 = B().f4025a;
        this.f13213r1 = i7;
        this.f13212q1 = i7 != 0;
        if (i7 != i6) {
            Y0();
        }
        this.J0.l(this.C0);
        this.I0.e();
        this.W0 = z6;
        this.X0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o
    public void I(long j6, boolean z5) {
        super.I(j6, z5);
        t1();
        this.Y0 = -9223372036854775807L;
        this.f13198c1 = 0;
        if (z5) {
            W1();
        } else {
            this.Z0 = -9223372036854775807L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o
    public void J() {
        try {
            super.J();
            Surface surface = this.S0;
            if (surface != null) {
                if (this.Q0 == surface) {
                    this.Q0 = null;
                }
                surface.release();
                this.S0 = null;
            }
        } catch (Throwable th) {
            if (this.S0 != null) {
                Surface surface2 = this.Q0;
                Surface surface3 = this.S0;
                if (surface2 == surface3) {
                    this.Q0 = null;
                }
                surface3.release();
                this.S0 = null;
            }
            throw th;
        }
    }

    protected boolean J1(MediaCodec mediaCodec, int i6, long j6, long j7, boolean z5) {
        int O = O(j7);
        if (O == 0) {
            return false;
        }
        com.google.android.exoplayer2.decoder.h hVar = this.C0;
        hVar.f3596i++;
        int i7 = this.f13199d1 + O;
        if (z5) {
            hVar.f3593f += i7;
        } else {
            f2(i7);
        }
        j0();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o
    public void K() {
        super.K();
        this.f13197b1 = 0;
        this.f13196a1 = SystemClock.elapsedRealtime();
        this.f13200e1 = SystemClock.elapsedRealtime() * 1000;
        this.f13201f1 = 0L;
        this.f13202g1 = 0;
        g2(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o
    public void L() {
        this.Z0 = -9223372036854775807L;
        K1();
        M1();
        v1();
        super.L();
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected void L0(String str, long j6, long j7) {
        this.J0.i(str, j6, j7);
        this.O0 = w1(str);
        this.P0 = ((com.google.android.exoplayer2.mediacodec.j) com.google.android.exoplayer2.util.a.e(o0())).m();
    }

    void L1() {
        this.X0 = true;
        if (this.V0) {
            return;
        }
        this.V0 = true;
        this.J0.v(this.Q0);
        this.T0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m
    public void M0(t0 t0Var) {
        super.M0(t0Var);
        this.J0.m(t0Var.f4441b);
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected void N0(com.google.android.exoplayer2.s0 s0Var, MediaFormat mediaFormat) {
        MediaCodec m02 = m0();
        if (m02 != null) {
            m02.setVideoScalingMode(this.U0);
        }
        if (this.f13212q1) {
            this.f13203h1 = s0Var.f4061s;
            this.f13204i1 = s0Var.f4062t;
        } else {
            com.google.android.exoplayer2.util.a.e(mediaFormat);
            boolean z5 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.f13203h1 = z5 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.f13204i1 = z5 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f6 = s0Var.f4065w;
        this.f13206k1 = f6;
        if (s0.f4673a >= 21) {
            int i6 = s0Var.f4064v;
            if (i6 == 90 || i6 == 270) {
                int i7 = this.f13203h1;
                this.f13203h1 = this.f13204i1;
                this.f13204i1 = i7;
                this.f13206k1 = 1.0f / f6;
            }
        } else {
            this.f13205j1 = s0Var.f4064v;
        }
        this.f13207l1 = s0Var.f4063u;
        g2(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m
    public void O0(long j6) {
        super.O0(j6);
        if (this.f13212q1) {
            return;
        }
        this.f13199d1--;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m
    public void P0() {
        super.P0();
        t1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected int Q(MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.j jVar, com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.s0 s0Var2) {
        if (jVar.o(s0Var, s0Var2, true)) {
            int i6 = s0Var2.f4061s;
            a aVar = this.N0;
            if (i6 > aVar.f13215a || s0Var2.f4062t > aVar.f13216b || F1(jVar, s0Var2) > this.N0.f13217c) {
                return 0;
            }
            return s0Var.h(s0Var2) ? 3 : 2;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected void Q0(com.google.android.exoplayer2.decoder.j jVar) {
        boolean z5 = this.f13212q1;
        if (!z5) {
            this.f13199d1++;
        }
        if (s0.f4673a >= 23 || !z5) {
            return;
        }
        R1(jVar.f3602d);
    }

    protected void R1(long j6) {
        q1(j6);
        N1();
        this.C0.f3592e++;
        L1();
        O0(j6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0088, code lost:
        if (c2(r1, r13) != false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bf  */
    @Override // com.google.android.exoplayer2.mediacodec.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean S0(long j6, long j7, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i6, int i7, int i8, long j8, boolean z5, boolean z6, com.google.android.exoplayer2.s0 s0Var) {
        long j9;
        boolean z7;
        long j10;
        boolean z8;
        long j11;
        com.google.android.exoplayer2.util.a.e(mediaCodec);
        if (this.Y0 == -9223372036854775807L) {
            this.Y0 = j6;
        }
        long z02 = z0();
        long j12 = j8 - z02;
        if (z5 && !z6) {
            e2(mediaCodec, i6, j12);
            return true;
        }
        long j13 = j8 - j6;
        if (this.Q0 == this.S0) {
            if (H1(j13)) {
                e2(mediaCodec, i6, j12);
                h2(j13);
                return true;
            }
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j14 = elapsedRealtime - this.f13200e1;
        boolean z9 = getState() == 2;
        if (this.X0 ? this.V0 : !(z9 || this.W0)) {
            j9 = elapsedRealtime;
            z7 = false;
        } else {
            j9 = elapsedRealtime;
            z7 = true;
        }
        if (this.Z0 == -9223372036854775807L && j6 >= z02) {
            if (z7) {
                j10 = j13;
            } else if (z9) {
                j10 = j13;
            }
            z8 = true;
            if (!z8) {
                long nanoTime = System.nanoTime();
                Q1(j12, nanoTime, s0Var);
                if (s0.f4673a >= 21) {
                    U1(mediaCodec, i6, j12, nanoTime);
                } else {
                    T1(mediaCodec, i6, j12);
                }
                h2(j10);
                return true;
            }
            if (z9 && j6 != this.Y0) {
                long nanoTime2 = System.nanoTime();
                long b6 = this.I0.b(j8, ((j10 - (j9 - j7)) * 1000) + nanoTime2);
                long j15 = (b6 - nanoTime2) / 1000;
                boolean z10 = this.Z0 != -9223372036854775807L;
                if (a2(j15, j7, z6) && J1(mediaCodec, i6, j12, j6, z10)) {
                    return false;
                }
                if (b2(j15, j7, z6)) {
                    if (z10) {
                        e2(mediaCodec, i6, j12);
                    } else {
                        z1(mediaCodec, i6, j12);
                    }
                    j11 = j15;
                } else {
                    j11 = j15;
                    if (s0.f4673a >= 21) {
                        if (j11 < 50000) {
                            Q1(j12, b6, s0Var);
                            U1(mediaCodec, i6, j12, b6);
                        }
                    } else if (j11 < 30000) {
                        if (j11 > 11000) {
                            try {
                                Thread.sleep((j11 - 10000) / 1000);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        }
                        Q1(j12, b6, s0Var);
                        T1(mediaCodec, i6, j12);
                    }
                }
                h2(j11);
                return true;
            }
            return false;
        }
        j10 = j13;
        z8 = false;
        if (!z8) {
        }
    }

    protected void T1(MediaCodec mediaCodec, int i6, long j6) {
        N1();
        l0.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i6, true);
        l0.c();
        this.f13200e1 = SystemClock.elapsedRealtime() * 1000;
        this.C0.f3592e++;
        this.f13198c1 = 0;
        L1();
    }

    protected void U1(MediaCodec mediaCodec, int i6, long j6, long j7) {
        N1();
        l0.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i6, j7);
        l0.c();
        this.f13200e1 = SystemClock.elapsedRealtime() * 1000;
        this.C0.f3592e++;
        this.f13198c1 = 0;
        L1();
    }

    protected void X1(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected void a0(com.google.android.exoplayer2.mediacodec.j jVar, com.google.android.exoplayer2.mediacodec.g gVar, com.google.android.exoplayer2.s0 s0Var, MediaCrypto mediaCrypto, float f6) {
        String str = jVar.f3863c;
        a D1 = D1(jVar, s0Var, E());
        this.N0 = D1;
        MediaFormat G1 = G1(s0Var, str, D1, f6, this.M0, this.f13213r1);
        if (this.Q0 == null) {
            if (!d2(jVar)) {
                throw new IllegalStateException();
            }
            if (this.S0 == null) {
                this.S0 = d.g(this.H0, jVar.f3867g);
            }
            this.Q0 = this.S0;
        }
        gVar.e(G1, this.Q0, mediaCrypto, 0);
        if (s0.f4673a < 23 || !this.f13212q1) {
            return;
        }
        this.f13214s1 = new b(gVar.h());
    }

    protected boolean a2(long j6, long j7, boolean z5) {
        return I1(j6) && !z5;
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected com.google.android.exoplayer2.mediacodec.i b0(Throwable th, com.google.android.exoplayer2.mediacodec.j jVar) {
        return new f(th, jVar, this.Q0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m
    public void b1() {
        super.b1();
        this.f13199d1 = 0;
    }

    protected boolean b2(long j6, long j7, boolean z5) {
        return H1(j6) && !z5;
    }

    protected boolean c2(long j6, long j7) {
        return H1(j6) && j7 > 100000;
    }

    protected void e2(MediaCodec mediaCodec, int i6, long j6) {
        l0.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i6, false);
        l0.c();
        this.C0.f3593f++;
    }

    @Override // com.google.android.exoplayer2.n1, com.google.android.exoplayer2.p1
    public String f() {
        return "MediaCodecVideoRenderer";
    }

    protected void f2(int i6) {
        com.google.android.exoplayer2.decoder.h hVar = this.C0;
        hVar.f3594g += i6;
        this.f13197b1 += i6;
        int i7 = this.f13198c1 + i6;
        this.f13198c1 = i7;
        hVar.f3595h = Math.max(i7, hVar.f3595h);
        int i8 = this.L0;
        if (i8 <= 0 || this.f13197b1 < i8) {
            return;
        }
        K1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.n1
    public boolean g() {
        Surface surface;
        if (super.g() && (this.V0 || (((surface = this.S0) != null && this.Q0 == surface) || m0() == null || this.f13212q1))) {
            this.Z0 = -9223372036854775807L;
            return true;
        } else if (this.Z0 == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.Z0) {
                return true;
            }
            this.Z0 = -9223372036854775807L;
            return false;
        }
    }

    protected void h2(long j6) {
        this.C0.a(j6);
        this.f13201f1 += j6;
        this.f13202g1++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected boolean k1(com.google.android.exoplayer2.mediacodec.j jVar) {
        return this.Q0 != null || d2(jVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected int m1(com.google.android.exoplayer2.mediacodec.o oVar, com.google.android.exoplayer2.s0 s0Var) {
        int i6 = 0;
        if (com.google.android.exoplayer2.util.q.q(s0Var.f4056n)) {
            boolean z5 = s0Var.f4059q != null;
            List E1 = E1(oVar, s0Var, z5, false);
            if (z5 && E1.isEmpty()) {
                E1 = E1(oVar, s0Var, false, false);
            }
            if (E1.isEmpty()) {
                return o1.a(1);
            }
            if (com.google.android.exoplayer2.mediacodec.m.n1(s0Var)) {
                com.google.android.exoplayer2.mediacodec.j jVar = (com.google.android.exoplayer2.mediacodec.j) E1.get(0);
                boolean l6 = jVar.l(s0Var);
                int i7 = jVar.n(s0Var) ? 16 : 8;
                if (l6) {
                    List E12 = E1(oVar, s0Var, z5, true);
                    if (!E12.isEmpty()) {
                        com.google.android.exoplayer2.mediacodec.j jVar2 = (com.google.android.exoplayer2.mediacodec.j) E12.get(0);
                        if (jVar2.l(s0Var) && jVar2.n(s0Var)) {
                            i6 = 32;
                        }
                    }
                }
                return o1.b(l6 ? 4 : 3, i7, i6);
            }
            return o1.a(2);
        }
        return o1.a(0);
    }

    @Override // com.google.android.exoplayer2.o, com.google.android.exoplayer2.k1.b
    public void p(int i6, Object obj) {
        if (i6 == 1) {
            Y1((Surface) obj);
        } else if (i6 != 4) {
            if (i6 == 6) {
                android.support.v4.media.a.a(obj);
            } else {
                super.p(i6, obj);
            }
        } else {
            this.U0 = ((Integer) obj).intValue();
            MediaCodec m02 = m0();
            if (m02 != null) {
                m02.setVideoScalingMode(this.U0);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected boolean p0() {
        return this.f13212q1 && s0.f4673a < 23;
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected float q0(float f6, com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.s0[] s0VarArr) {
        float f7 = -1.0f;
        for (com.google.android.exoplayer2.s0 s0Var2 : s0VarArr) {
            float f8 = s0Var2.f4063u;
            if (f8 != -1.0f) {
                f7 = Math.max(f7, f8);
            }
        }
        if (f7 == -1.0f) {
            return -1.0f;
        }
        return f7 * f6;
    }

    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o, com.google.android.exoplayer2.n1
    public void r(float f6) {
        super.r(f6);
        g2(false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected List r0(com.google.android.exoplayer2.mediacodec.o oVar, com.google.android.exoplayer2.s0 s0Var, boolean z5) {
        return E1(oVar, s0Var, z5, this.f13212q1);
    }

    protected boolean w1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (h.class) {
            if (!f13194v1) {
                f13195w1 = A1();
                f13194v1 = true;
            }
        }
        return f13195w1;
    }

    protected void z1(MediaCodec mediaCodec, int i6, long j6) {
        l0.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i6, false);
        l0.c();
        f2(1);
    }
}
