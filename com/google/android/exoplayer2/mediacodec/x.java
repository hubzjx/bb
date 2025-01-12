package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.mediacodec.x;
import com.google.android.exoplayer2.util.s0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.dnsoverhttps.DnsOverHttps;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import okio.Segment;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f3913a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap f3914b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static int f3915c = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f3916a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3917b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f3918c;

        public b(String str, boolean z5, boolean z6) {
            this.f3916a = str;
            this.f3917b = z5;
            this.f3918c = z6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.f3916a, bVar.f3916a) && this.f3917b == bVar.f3917b && this.f3918c == bVar.f3918c;
        }

        public int hashCode() {
            return ((((this.f3916a.hashCode() + 31) * 31) + (this.f3917b ? 1231 : 1237)) * 31) + (this.f3918c ? 1231 : 1237);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Exception {
        private c(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d {
        MediaCodecInfo a(int i6);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int c();

        boolean d(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e implements d {
        private e() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.x.d
        public MediaCodecInfo a(int i6) {
            return MediaCodecList.getCodecInfoAt(i6);
        }

        @Override // com.google.android.exoplayer2.mediacodec.x.d
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.x.d
        public int c() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.x.d
        public boolean d(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.x.d
        public boolean e() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class f implements d {

        /* renamed from: a  reason: collision with root package name */
        private final int f3919a;

        /* renamed from: b  reason: collision with root package name */
        private MediaCodecInfo[] f3920b;

        public f(boolean z5, boolean z6) {
            this.f3919a = (z5 || z6) ? 1 : 0;
        }

        private void f() {
            if (this.f3920b == null) {
                this.f3920b = new MediaCodecList(this.f3919a).getCodecInfos();
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.x.d
        public MediaCodecInfo a(int i6) {
            f();
            return this.f3920b[i6];
        }

        @Override // com.google.android.exoplayer2.mediacodec.x.d
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.x.d
        public int c() {
            f();
            return this.f3920b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.x.d
        public boolean d(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.x.d
        public boolean e() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface g {
        int a(Object obj);
    }

    private static boolean A(MediaCodecInfo mediaCodecInfo) {
        return s0.f4673a >= 29 && B(mediaCodecInfo);
    }

    private static boolean B(MediaCodecInfo mediaCodecInfo) {
        boolean isAlias;
        isAlias = mediaCodecInfo.isAlias();
        return isAlias;
    }

    private static boolean C(MediaCodecInfo mediaCodecInfo, String str, boolean z5, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z5 && str.endsWith(".secure"))) {
            return false;
        }
        int i6 = s0.f4673a;
        if (i6 >= 21 || !("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            if (i6 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
                String str3 = s0.f4674b;
                if ("a70".equals(str3) || ("Xiaomi".equals(s0.f4675c) && str3.startsWith("HM"))) {
                    return false;
                }
            }
            if (i6 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
                String str4 = s0.f4674b;
                if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                    return false;
                }
            }
            if (i6 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
                String str5 = s0.f4674b;
                if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                    return false;
                }
            }
            if (i6 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(s0.f4675c))) {
                String str6 = s0.f4674b;
                if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                    return false;
                }
            }
            if (i6 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(s0.f4675c)) {
                String str7 = s0.f4674b;
                if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                    return false;
                }
            }
            if (i6 <= 19 && s0.f4674b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
                return false;
            }
            return ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
        }
        return false;
    }

    private static boolean D(MediaCodecInfo mediaCodecInfo) {
        return s0.f4673a >= 29 ? E(mediaCodecInfo) : !F(mediaCodecInfo);
    }

    private static boolean E(MediaCodecInfo mediaCodecInfo) {
        boolean isHardwareAccelerated;
        isHardwareAccelerated = mediaCodecInfo.isHardwareAccelerated();
        return isHardwareAccelerated;
    }

    private static boolean F(MediaCodecInfo mediaCodecInfo) {
        if (s0.f4673a >= 29) {
            return G(mediaCodecInfo);
        }
        String S0 = s0.S0(mediaCodecInfo.getName());
        if (S0.startsWith("arc.")) {
            return false;
        }
        return S0.startsWith("omx.google.") || S0.startsWith("omx.ffmpeg.") || (S0.startsWith("omx.sec.") && S0.contains(".sw.")) || S0.equals("omx.qcom.video.decoder.hevcswvdec") || S0.startsWith("c2.android.") || S0.startsWith("c2.google.") || !(S0.startsWith("omx.") || S0.startsWith("c2."));
    }

    private static boolean G(MediaCodecInfo mediaCodecInfo) {
        boolean isSoftwareOnly;
        isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
        return isSoftwareOnly;
    }

    private static boolean H(MediaCodecInfo mediaCodecInfo) {
        if (s0.f4673a >= 29) {
            return I(mediaCodecInfo);
        }
        String S0 = s0.S0(mediaCodecInfo.getName());
        return (S0.startsWith("omx.google.") || S0.startsWith("c2.android.") || S0.startsWith("c2.google.")) ? false : true;
    }

    private static boolean I(MediaCodecInfo mediaCodecInfo) {
        boolean isVendor;
        isVendor = mediaCodecInfo.isVendor();
        return isVendor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int J(j jVar) {
        String str = jVar.f3861a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (s0.f4673a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int K(j jVar) {
        return jVar.f3861a.startsWith("OMX.google") ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int L(com.google.android.exoplayer2.s0 s0Var, j jVar) {
        try {
            return jVar.l(s0Var) ? 1 : 0;
        } catch (c unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int M(g gVar, Object obj, Object obj2) {
        return gVar.a(obj2) - gVar.a(obj);
    }

    public static int N() {
        if (f3915c == -1) {
            int i6 = 0;
            j r5 = r("video/avc", false, false);
            if (r5 != null) {
                MediaCodecInfo.CodecProfileLevel[] f6 = r5.f();
                int length = f6.length;
                int i7 = 0;
                while (i6 < length) {
                    i7 = Math.max(h(f6[i6].level), i7);
                    i6++;
                }
                i6 = Math.max(i7, s0.f4673a >= 21 ? 345600 : 172800);
            }
            f3915c = i6;
        }
        return f3915c;
    }

    private static int O(int i6) {
        int i7 = 17;
        if (i6 != 17) {
            i7 = 20;
            if (i6 != 20) {
                i7 = 23;
                if (i6 != 23) {
                    i7 = 29;
                    if (i6 != 29) {
                        i7 = 39;
                        if (i6 != 39) {
                            i7 = 42;
                            if (i6 != 42) {
                                switch (i6) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i7;
    }

    private static void P(List list, final g gVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.exoplayer2.mediacodec.w
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int M;
                M = x.M(x.g.this, obj, obj2);
                return M;
            }
        });
    }

    private static int Q(int i6) {
        if (i6 != 10) {
            if (i6 != 11) {
                if (i6 != 20) {
                    if (i6 != 21) {
                        if (i6 != 30) {
                            if (i6 != 31) {
                                if (i6 != 40) {
                                    if (i6 != 41) {
                                        if (i6 != 50) {
                                            if (i6 != 51) {
                                                switch (i6) {
                                                    case 60:
                                                        return 2048;
                                                    case 61:
                                                        return _BufferKt.SEGMENTING_THRESHOLD;
                                                    case 62:
                                                        return Segment.SIZE;
                                                    default:
                                                        return -1;
                                                }
                                            }
                                            return 512;
                                        }
                                        return 256;
                                    }
                                    return 128;
                                }
                                return 64;
                            }
                            return 32;
                        }
                        return 16;
                    }
                    return 8;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    private static int R(int i6) {
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    return i6 != 3 ? -1 : 8;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    private static void e(String str, List list) {
        if ("audio/raw".equals(str)) {
            if (s0.f4673a < 26 && s0.f4674b.equals("R9") && list.size() == 1 && ((j) list.get(0)).f3861a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(j.w("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            P(list, new g() { // from class: com.google.android.exoplayer2.mediacodec.t
                @Override // com.google.android.exoplayer2.mediacodec.x.g
                public final int a(Object obj) {
                    int J;
                    J = x.J((j) obj);
                    return J;
                }
            });
        }
        int i6 = s0.f4673a;
        if (i6 < 21 && list.size() > 1) {
            String str2 = ((j) list.get(0)).f3861a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                P(list, new g() { // from class: com.google.android.exoplayer2.mediacodec.u
                    @Override // com.google.android.exoplayer2.mediacodec.x.g
                    public final int a(Object obj) {
                        int K;
                        K = x.K((j) obj);
                        return K;
                    }
                });
            }
        }
        if (i6 >= 30 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((j) list.get(0)).f3861a)) {
            return;
        }
        list.add((j) list.remove(0));
    }

    private static int f(int i6) {
        switch (i6) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return Segment.SHARE_MINIMUM;
            case 11:
                return 2048;
            case 12:
                return _BufferKt.SEGMENTING_THRESHOLD;
            case 13:
                return Segment.SIZE;
            case 14:
                return Http2.INITIAL_MAX_FRAME_SIZE;
            case 15:
                return 32768;
            case 16:
                return DnsOverHttps.MAX_RESPONSE_SIZE;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int g(int i6) {
        switch (i6) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i6) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i6) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return Segment.SHARE_MINIMUM;
                            default:
                                switch (i6) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return _BufferKt.SEGMENTING_THRESHOLD;
                                    case 42:
                                        return Segment.SIZE;
                                    default:
                                        switch (i6) {
                                            case 50:
                                                return Http2.INITIAL_MAX_FRAME_SIZE;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return DnsOverHttps.MAX_RESPONSE_SIZE;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int h(int i6) {
        if (i6 == 1 || i6 == 2) {
            return 25344;
        }
        switch (i6) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case Segment.SHARE_MINIMUM /* 1024 */:
                return 1310720;
            case 2048:
            case _BufferKt.SEGMENTING_THRESHOLD /* 4096 */:
                return 2097152;
            case Segment.SIZE /* 8192 */:
                return 2228224;
            case Http2.INITIAL_MAX_FRAME_SIZE /* 16384 */:
                return 5652480;
            case 32768:
            case DnsOverHttps.MAX_RESPONSE_SIZE /* 65536 */:
                return 9437184;
            default:
                return -1;
        }
    }

    private static int i(int i6) {
        if (i6 != 66) {
            if (i6 != 77) {
                if (i6 != 88) {
                    if (i6 != 100) {
                        if (i6 != 110) {
                            if (i6 != 122) {
                                return i6 != 244 ? -1 : 64;
                            }
                            return 32;
                        }
                        return 16;
                    }
                    return 8;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    private static boolean j(String str) {
        if (s0.f4673a <= 22) {
            String str2 = s0.f4676d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    private static Integer k(String str) {
        int i6;
        if (str == null) {
            return null;
        }
        char c6 = 65535;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals("01")) {
                    c6 = 0;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c6 = 1;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c6 = 2;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c6 = 3;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c6 = 4;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c6 = 5;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c6 = 6;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c6 = 7;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c6 = '\b';
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                i6 = 16;
                break;
            case 5:
                i6 = 32;
                break;
            case 6:
                i6 = 64;
                break;
            case 7:
                i6 = 128;
                break;
            case '\b':
                i6 = 256;
                break;
            default:
                return null;
        }
        return Integer.valueOf(i6);
    }

    private static Integer l(String str) {
        int i6;
        if (str == null) {
            return null;
        }
        char c6 = 65535;
        switch (str.hashCode()) {
            case 1536:
                if (str.equals("00")) {
                    c6 = 0;
                    break;
                }
                break;
            case 1537:
                if (str.equals("01")) {
                    c6 = 1;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c6 = 2;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c6 = 3;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c6 = 4;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c6 = 5;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c6 = 6;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c6 = 7;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c6 = '\b';
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c6 = '\t';
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                i6 = 16;
                break;
            case 5:
                i6 = 32;
                break;
            case 6:
                i6 = 64;
                break;
            case 7:
                i6 = 128;
                break;
            case '\b':
                i6 = 256;
                break;
            case '\t':
                i6 = 512;
                break;
            default:
                return null;
        }
        return Integer.valueOf(i6);
    }

    private static Pair m(String str, String[] strArr) {
        int O;
        if (strArr.length != 3) {
            String valueOf = String.valueOf(str);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(valueOf) : new String("Ignoring malformed MP4A codec string: "));
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(com.google.android.exoplayer2.util.q.f(Integer.parseInt(strArr[1], 16))) && (O = O(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair(Integer.valueOf(O), 0);
            }
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(valueOf2) : new String("Ignoring malformed MP4A codec string: "));
        }
        return null;
    }

    private static Pair n(String str, String[] strArr, s2.b bVar) {
        StringBuilder sb;
        int i6;
        String sb2;
        if (strArr.length < 4) {
            String valueOf = String.valueOf(str);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(valueOf) : new String("Ignoring malformed AV1 codec string: "));
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2].substring(0, 2));
            int parseInt3 = Integer.parseInt(strArr[3]);
            if (parseInt != 0) {
                sb = new StringBuilder(32);
                sb.append("Unknown AV1 profile: ");
                sb.append(parseInt);
            } else if (parseInt3 != 8 && parseInt3 != 10) {
                StringBuilder sb3 = new StringBuilder(34);
                sb3.append("Unknown AV1 bit depth: ");
                sb3.append(parseInt3);
                sb2 = sb3.toString();
                com.google.android.exoplayer2.util.n.h("MediaCodecUtil", sb2);
                return null;
            } else {
                int i7 = parseInt3 != 8 ? (bVar == null || !(bVar.f13175d != null || (i6 = bVar.f13174c) == 7 || i6 == 6)) ? 2 : _BufferKt.SEGMENTING_THRESHOLD : 1;
                int f6 = f(parseInt2);
                if (f6 != -1) {
                    return new Pair(Integer.valueOf(i7), Integer.valueOf(f6));
                }
                sb = new StringBuilder(30);
                sb.append("Unknown AV1 level: ");
                sb.append(parseInt2);
            }
            sb2 = sb.toString();
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", sb2);
            return null;
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(valueOf2) : new String("Ignoring malformed AV1 codec string: "));
            return null;
        }
    }

    private static Pair o(String str, String[] strArr) {
        int parseInt;
        int i6;
        String sb;
        if (strArr.length < 2) {
            String valueOf = String.valueOf(str);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i6 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                parseInt = Integer.parseInt(strArr[1].substring(4), 16);
            } else if (strArr.length < 3) {
                String valueOf2 = String.valueOf(str);
                com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf2) : new String("Ignoring malformed AVC codec string: "));
                return null;
            } else {
                int parseInt2 = Integer.parseInt(strArr[1]);
                parseInt = Integer.parseInt(strArr[2]);
                i6 = parseInt2;
            }
            int i7 = i(i6);
            if (i7 == -1) {
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown AVC profile: ");
                sb2.append(i6);
                sb = sb2.toString();
            } else {
                int g6 = g(parseInt);
                if (g6 != -1) {
                    return new Pair(Integer.valueOf(i7), Integer.valueOf(g6));
                }
                StringBuilder sb3 = new StringBuilder(30);
                sb3.append("Unknown AVC level: ");
                sb3.append(parseInt);
                sb = sb3.toString();
            }
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", sb);
            return null;
        } catch (NumberFormatException unused) {
            String valueOf3 = String.valueOf(str);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf3.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf3) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    private static String p(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        String[] supportedTypes;
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        } else if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
                return "audio/x-lg-flac";
            }
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0075, code lost:
        if (r3.equals("av01") == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair q(com.google.android.exoplayer2.s0 s0Var) {
        String str = s0Var.f4053k;
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        if ("video/dolby-vision".equals(s0Var.f4056n)) {
            return w(s0Var.f4053k, split);
        }
        char c6 = 0;
        String str2 = split[0];
        str2.hashCode();
        switch (str2.hashCode()) {
            case 3004662:
                break;
            case 3006243:
                if (str2.equals("avc1")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case 3006244:
                if (str2.equals("avc2")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            case 3199032:
                if (str2.equals("hev1")) {
                    c6 = 3;
                    break;
                }
                c6 = 65535;
                break;
            case 3214780:
                if (str2.equals("hvc1")) {
                    c6 = 4;
                    break;
                }
                c6 = 65535;
                break;
            case 3356560:
                if (str2.equals("mp4a")) {
                    c6 = 5;
                    break;
                }
                c6 = 65535;
                break;
            case 3624515:
                if (str2.equals("vp09")) {
                    c6 = 6;
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
                return n(s0Var.f4053k, split, s0Var.f4068z);
            case 1:
            case 2:
                return o(s0Var.f4053k, split);
            case 3:
            case 4:
                return x(s0Var.f4053k, split);
            case 5:
                return m(s0Var.f4053k, split);
            case 6:
                return y(s0Var.f4053k, split);
            default:
                return null;
        }
    }

    public static j r(String str, boolean z5, boolean z6) {
        List s5 = s(str, z5, z6);
        if (s5.isEmpty()) {
            return null;
        }
        return (j) s5.get(0);
    }

    public static synchronized List s(String str, boolean z5, boolean z6) {
        synchronized (x.class) {
            b bVar = new b(str, z5, z6);
            HashMap hashMap = f3914b;
            List list = (List) hashMap.get(bVar);
            if (list != null) {
                return list;
            }
            int i6 = s0.f4673a;
            ArrayList t5 = t(bVar, i6 >= 21 ? new f(z5, z6) : new e());
            if (z5 && t5.isEmpty() && 21 <= i6 && i6 <= 23) {
                t5 = t(bVar, new e());
                if (!t5.isEmpty()) {
                    String str2 = ((j) t5.get(0)).f3861a;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    com.google.android.exoplayer2.util.n.h("MediaCodecUtil", sb.toString());
                }
            }
            e(str, t5);
            List unmodifiableList = Collections.unmodifiableList(t5);
            hashMap.put(bVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    private static ArrayList t(b bVar, d dVar) {
        String p5;
        String str;
        String str2;
        int i6;
        boolean z5;
        int i7;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean d6;
        boolean b6;
        boolean z6;
        try {
            ArrayList arrayList = new ArrayList();
            String str3 = bVar.f3916a;
            boolean e6 = dVar.e();
            int i8 = 0;
            for (int c6 = dVar.c(); i8 < c6; c6 = i7) {
                MediaCodecInfo a6 = dVar.a(i8);
                if (!A(a6)) {
                    String name = a6.getName();
                    if (C(a6, name, e6, str3) && (p5 = p(a6, name, str3)) != null) {
                        try {
                            capabilitiesForType = a6.getCapabilitiesForType(p5);
                            d6 = dVar.d("tunneled-playback", p5, capabilitiesForType);
                            b6 = dVar.b("tunneled-playback", p5, capabilitiesForType);
                            z6 = bVar.f3918c;
                        } catch (Exception e7) {
                            e = e7;
                            str = p5;
                            str2 = name;
                            i6 = i8;
                            z5 = e6;
                            i7 = c6;
                        }
                        if ((z6 || !b6) && (!z6 || d6)) {
                            boolean d7 = dVar.d("secure-playback", p5, capabilitiesForType);
                            boolean b7 = dVar.b("secure-playback", p5, capabilitiesForType);
                            boolean z7 = bVar.f3917b;
                            if ((z7 || !b7) && (!z7 || d7)) {
                                boolean D = D(a6);
                                boolean F = F(a6);
                                boolean H = H(a6);
                                boolean j6 = j(name);
                                if (!(e6 && bVar.f3917b == d7) && (e6 || bVar.f3917b)) {
                                    str = p5;
                                    str2 = name;
                                    i6 = i8;
                                    z5 = e6;
                                    i7 = c6;
                                    if (!z5 && d7) {
                                        arrayList.add(j.w(String.valueOf(str2).concat(".secure"), str3, str, capabilitiesForType, D, F, H, j6, true));
                                        return arrayList;
                                    }
                                    i8 = i6 + 1;
                                    e6 = z5;
                                } else {
                                    str = p5;
                                    str2 = name;
                                    i6 = i8;
                                    z5 = e6;
                                    i7 = c6;
                                    try {
                                        arrayList.add(j.w(name, str3, p5, capabilitiesForType, D, F, H, j6, false));
                                    } catch (Exception e8) {
                                        e = e8;
                                        if (s0.f4673a > 23 || arrayList.isEmpty()) {
                                            String str4 = str2;
                                            StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + 25 + str.length());
                                            sb.append("Failed to query codec ");
                                            sb.append(str4);
                                            sb.append(" (");
                                            sb.append(str);
                                            sb.append(")");
                                            com.google.android.exoplayer2.util.n.c("MediaCodecUtil", sb.toString());
                                            throw e;
                                        }
                                        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 46);
                                        sb2.append("Skipping codec ");
                                        sb2.append(str2);
                                        sb2.append(" (failed to query capabilities)");
                                        com.google.android.exoplayer2.util.n.c("MediaCodecUtil", sb2.toString());
                                        i8 = i6 + 1;
                                        e6 = z5;
                                    }
                                    i8 = i6 + 1;
                                    e6 = z5;
                                }
                            }
                        }
                    }
                }
                i6 = i8;
                z5 = e6;
                i7 = c6;
                i8 = i6 + 1;
                e6 = z5;
            }
            return arrayList;
        } catch (Exception e9) {
            throw new c(e9);
        }
    }

    public static List u(List list, final com.google.android.exoplayer2.s0 s0Var) {
        ArrayList arrayList = new ArrayList(list);
        P(arrayList, new g() { // from class: com.google.android.exoplayer2.mediacodec.v
            @Override // com.google.android.exoplayer2.mediacodec.x.g
            public final int a(Object obj) {
                int L;
                L = x.L(com.google.android.exoplayer2.s0.this, (j) obj);
                return L;
            }
        });
        return arrayList;
    }

    public static j v() {
        return r("audio/raw", false, false);
    }

    private static Pair w(String str, String[] strArr) {
        if (strArr.length < 3) {
            String valueOf = String.valueOf(str);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(valueOf) : new String("Ignoring malformed Dolby Vision codec string: "));
            return null;
        }
        Matcher matcher = f3913a.matcher(strArr[1]);
        if (!matcher.matches()) {
            String valueOf2 = String.valueOf(str);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(valueOf2) : new String("Ignoring malformed Dolby Vision codec string: "));
            return null;
        }
        String group = matcher.group(1);
        Integer l6 = l(group);
        if (l6 == null) {
            String valueOf3 = String.valueOf(group);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf3.length() != 0 ? "Unknown Dolby Vision profile string: ".concat(valueOf3) : new String("Unknown Dolby Vision profile string: "));
            return null;
        }
        String str2 = strArr[2];
        Integer k6 = k(str2);
        if (k6 == null) {
            String valueOf4 = String.valueOf(str2);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf4.length() != 0 ? "Unknown Dolby Vision level string: ".concat(valueOf4) : new String("Unknown Dolby Vision level string: "));
            return null;
        }
        return new Pair(l6, k6);
    }

    private static Pair x(String str, String[] strArr) {
        if (strArr.length < 4) {
            String valueOf = String.valueOf(str);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(valueOf) : new String("Ignoring malformed HEVC codec string: "));
            return null;
        }
        int i6 = 1;
        Matcher matcher = f3913a.matcher(strArr[1]);
        if (!matcher.matches()) {
            String valueOf2 = String.valueOf(str);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(valueOf2) : new String("Ignoring malformed HEVC codec string: "));
            return null;
        }
        String group = matcher.group(1);
        if (!"1".equals(group)) {
            if (!"2".equals(group)) {
                String valueOf3 = String.valueOf(group);
                com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf3.length() != 0 ? "Unknown HEVC profile string: ".concat(valueOf3) : new String("Unknown HEVC profile string: "));
                return null;
            }
            i6 = 2;
        }
        String str2 = strArr[3];
        Integer z5 = z(str2);
        if (z5 == null) {
            String valueOf4 = String.valueOf(str2);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf4.length() != 0 ? "Unknown HEVC level string: ".concat(valueOf4) : new String("Unknown HEVC level string: "));
            return null;
        }
        return new Pair(Integer.valueOf(i6), z5);
    }

    private static Pair y(String str, String[] strArr) {
        String sb;
        if (strArr.length < 3) {
            String valueOf = String.valueOf(str);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(valueOf) : new String("Ignoring malformed VP9 codec string: "));
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2]);
            int R = R(parseInt);
            if (R == -1) {
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown VP9 profile: ");
                sb2.append(parseInt);
                sb = sb2.toString();
            } else {
                int Q = Q(parseInt2);
                if (Q != -1) {
                    return new Pair(Integer.valueOf(R), Integer.valueOf(Q));
                }
                StringBuilder sb3 = new StringBuilder(30);
                sb3.append("Unknown VP9 level: ");
                sb3.append(parseInt2);
                sb = sb3.toString();
            }
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", sb);
            return null;
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            com.google.android.exoplayer2.util.n.h("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(valueOf2) : new String("Ignoring malformed VP9 codec string: "));
            return null;
        }
    }

    private static Integer z(String str) {
        int i6;
        if (str == null) {
            return null;
        }
        char c6 = 65535;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    c6 = 0;
                    break;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    c6 = 1;
                    break;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    c6 = 2;
                    break;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    c6 = 3;
                    break;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    c6 = 4;
                    break;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    c6 = 5;
                    break;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    c6 = 6;
                    break;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    c6 = 7;
                    break;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    c6 = '\b';
                    break;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    c6 = '\t';
                    break;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    c6 = '\n';
                    break;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    c6 = 11;
                    break;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    c6 = '\f';
                    break;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    c6 = '\r';
                    break;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    c6 = 14;
                    break;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    c6 = 15;
                    break;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    c6 = 16;
                    break;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    c6 = 17;
                    break;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    c6 = 18;
                    break;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    c6 = 19;
                    break;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    c6 = 20;
                    break;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    c6 = 21;
                    break;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    c6 = 22;
                    break;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    c6 = 23;
                    break;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    c6 = 24;
                    break;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    c6 = 25;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                return 2;
            case 1:
                return 8;
            case 2:
                i6 = 32;
                break;
            case 3:
                i6 = 128;
                break;
            case 4:
                i6 = 512;
                break;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 16;
            case '\b':
                i6 = 64;
                break;
            case '\t':
                i6 = 256;
                break;
            case '\n':
                i6 = 2048;
                break;
            case 11:
                i6 = Segment.SIZE;
                break;
            case '\f':
                i6 = 32768;
                break;
            case '\r':
                i6 = 131072;
                break;
            case 14:
                i6 = 524288;
                break;
            case 15:
                i6 = 2097152;
                break;
            case 16:
                i6 = 8388608;
                break;
            case 17:
                i6 = 33554432;
                break;
            case 18:
                i6 = Segment.SHARE_MINIMUM;
                break;
            case 19:
                i6 = _BufferKt.SEGMENTING_THRESHOLD;
                break;
            case 20:
                i6 = Http2.INITIAL_MAX_FRAME_SIZE;
                break;
            case 21:
                i6 = DnsOverHttps.MAX_RESPONSE_SIZE;
                break;
            case 22:
                i6 = 262144;
                break;
            case 23:
                i6 = 1048576;
                break;
            case 24:
                i6 = 4194304;
                break;
            case 25:
                i6 = Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
                break;
            default:
                return null;
        }
        return Integer.valueOf(i6);
    }
}
