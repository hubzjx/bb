package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final String f3861a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3862b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3863c;

    /* renamed from: d  reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f3864d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f3865e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3866f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3867g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f3868h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f3869i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f3870j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f3871k;

    private j(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.f3861a = (String) com.google.android.exoplayer2.util.a.e(str);
        this.f3862b = str2;
        this.f3863c = str3;
        this.f3864d = codecCapabilities;
        this.f3868h = z5;
        this.f3869i = z6;
        this.f3870j = z7;
        boolean z10 = true;
        this.f3865e = (z8 || codecCapabilities == null || !g(codecCapabilities)) ? false : true;
        this.f3866f = codecCapabilities != null && r(codecCapabilities);
        if (!z9 && (codecCapabilities == null || !p(codecCapabilities))) {
            z10 = false;
        }
        this.f3867g = z10;
        this.f3871k = com.google.android.exoplayer2.util.q.q(str2);
    }

    private static int a(String str, String str2, int i6) {
        if (i6 > 1 || ((s0.f4673a >= 26 && i6 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i6;
        }
        int i7 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("AssumedMaxChannelAdjustment: ");
        sb.append(str);
        sb.append(", [");
        sb.append(i6);
        sb.append(" to ");
        sb.append(i7);
        sb.append("]");
        com.google.android.exoplayer2.util.n.h("MediaCodecInfo", sb.toString());
        return i7;
    }

    private static Point c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i6, int i7) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(s0.l(i6, widthAlignment) * widthAlignment, s0.l(i7, heightAlignment) * heightAlignment);
    }

    private static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i6, int i7, double d6) {
        Point c6 = c(videoCapabilities, i6, i7);
        int i8 = c6.x;
        int i9 = c6.y;
        return (d6 == -1.0d || d6 < 1.0d) ? videoCapabilities.isSizeSupported(i8, i9) : videoCapabilities.areSizeAndRateSupported(i8, i9, Math.floor(d6));
    }

    private static final boolean e(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(s0.f4674b)) ? false : true;
    }

    private static boolean g(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return s0.f4673a >= 19 && h(codecCapabilities);
    }

    private static boolean h(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean p(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return s0.f4673a >= 21 && q(codecCapabilities);
    }

    private static boolean q(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean r(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return s0.f4673a >= 21 && s(codecCapabilities);
    }

    private static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void u(String str) {
        String str2 = this.f3861a;
        String str3 = this.f3862b;
        String str4 = s0.f4677e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("AssumedSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        com.google.android.exoplayer2.util.n.b("MediaCodecInfo", sb.toString());
    }

    private void v(String str) {
        String str2 = this.f3861a;
        String str3 = this.f3862b;
        String str4 = s0.f4677e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        com.google.android.exoplayer2.util.n.b("MediaCodecInfo", sb.toString());
    }

    public static j w(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        return new j(str, str2, str3, codecCapabilities, z5, z6, z7, z8, z9);
    }

    public Point b(int i6, int i7) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f3864d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return c(videoCapabilities, i6, i7);
    }

    public MediaCodecInfo.CodecProfileLevel[] f() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f3864d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean i(int i6) {
        String sb;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f3864d;
        if (codecCapabilities == null) {
            sb = "channelCount.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                sb = "channelCount.aCaps";
            } else if (a(this.f3861a, this.f3862b, audioCapabilities.getMaxInputChannelCount()) >= i6) {
                return true;
            } else {
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("channelCount.support, ");
                sb2.append(i6);
                sb = sb2.toString();
            }
        }
        v(sb);
        return false;
    }

    public boolean j(int i6) {
        String sb;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f3864d;
        if (codecCapabilities == null) {
            sb = "sampleRate.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                sb = "sampleRate.aCaps";
            } else if (audioCapabilities.isSampleRateSupported(i6)) {
                return true;
            } else {
                StringBuilder sb2 = new StringBuilder(31);
                sb2.append("sampleRate.support, ");
                sb2.append(i6);
                sb = sb2.toString();
            }
        }
        v(sb);
        return false;
    }

    public boolean k(com.google.android.exoplayer2.s0 s0Var) {
        String e6;
        MediaCodecInfo.CodecProfileLevel[] f6;
        String str;
        StringBuilder sb;
        String str2;
        String str3 = s0Var.f4053k;
        if (str3 == null || this.f3862b == null || (e6 = com.google.android.exoplayer2.util.q.e(str3)) == null) {
            return true;
        }
        if (this.f3862b.equals(e6)) {
            Pair q5 = x.q(s0Var);
            if (q5 == null) {
                return true;
            }
            int intValue = ((Integer) q5.first).intValue();
            int intValue2 = ((Integer) q5.second).intValue();
            if (!this.f3871k && intValue != 42) {
                return true;
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : f()) {
                if (codecProfileLevel.profile == intValue && codecProfileLevel.level >= intValue2) {
                    return true;
                }
            }
            str = s0Var.f4053k;
            sb = new StringBuilder(String.valueOf(str).length() + 22 + e6.length());
            str2 = "codec.profileLevel, ";
        } else {
            str = s0Var.f4053k;
            sb = new StringBuilder(String.valueOf(str).length() + 13 + e6.length());
            str2 = "codec.mime ";
        }
        sb.append(str2);
        sb.append(str);
        sb.append(", ");
        sb.append(e6);
        v(sb.toString());
        return false;
    }

    public boolean l(com.google.android.exoplayer2.s0 s0Var) {
        int i6;
        if (k(s0Var)) {
            if (!this.f3871k) {
                if (s0.f4673a >= 21) {
                    int i7 = s0Var.B;
                    if (i7 != -1 && !j(i7)) {
                        return false;
                    }
                    int i8 = s0Var.A;
                    if (i8 != -1 && !i(i8)) {
                        return false;
                    }
                }
                return true;
            }
            int i9 = s0Var.f4061s;
            if (i9 <= 0 || (i6 = s0Var.f4062t) <= 0) {
                return true;
            }
            if (s0.f4673a >= 21) {
                return t(i9, i6, s0Var.f4063u);
            }
            boolean z5 = i9 * i6 <= x.N();
            if (!z5) {
                int i10 = s0Var.f4061s;
                int i11 = s0Var.f4062t;
                StringBuilder sb = new StringBuilder(40);
                sb.append("legacyFrameSize, ");
                sb.append(i10);
                sb.append("x");
                sb.append(i11);
                v(sb.toString());
            }
            return z5;
        }
        return false;
    }

    public boolean m() {
        if (s0.f4673a >= 29 && "video/x-vnd.on2.vp9".equals(this.f3862b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : f()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean n(com.google.android.exoplayer2.s0 s0Var) {
        if (this.f3871k) {
            return this.f3865e;
        }
        Pair q5 = x.q(s0Var);
        return q5 != null && ((Integer) q5.first).intValue() == 42;
    }

    public boolean o(com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.s0 s0Var2, boolean z5) {
        if (this.f3871k) {
            return ((String) com.google.android.exoplayer2.util.a.e(s0Var.f4056n)).equals(s0Var2.f4056n) && s0Var.f4064v == s0Var2.f4064v && (this.f3865e || (s0Var.f4061s == s0Var2.f4061s && s0Var.f4062t == s0Var2.f4062t)) && ((!z5 && s0Var2.f4068z == null) || s0.c(s0Var.f4068z, s0Var2.f4068z));
        }
        if ("audio/mp4a-latm".equals(this.f3862b) && ((String) com.google.android.exoplayer2.util.a.e(s0Var.f4056n)).equals(s0Var2.f4056n) && s0Var.A == s0Var2.A && s0Var.B == s0Var2.B) {
            Pair q5 = x.q(s0Var);
            Pair q6 = x.q(s0Var2);
            if (q5 != null && q6 != null) {
                return ((Integer) q5.first).intValue() == 42 && ((Integer) q6.first).intValue() == 42;
            }
        }
        return false;
    }

    public boolean t(int i6, int i7, double d6) {
        String sb;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f3864d;
        if (codecCapabilities == null) {
            sb = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                sb = "sizeAndRate.vCaps";
            } else if (d(videoCapabilities, i6, i7, d6)) {
                return true;
            } else {
                if (i6 < i7 && e(this.f3861a) && d(videoCapabilities, i7, i6, d6)) {
                    StringBuilder sb2 = new StringBuilder(69);
                    sb2.append("sizeAndRate.rotated, ");
                    sb2.append(i6);
                    sb2.append("x");
                    sb2.append(i7);
                    sb2.append("x");
                    sb2.append(d6);
                    u(sb2.toString());
                    return true;
                }
                StringBuilder sb3 = new StringBuilder(69);
                sb3.append("sizeAndRate.support, ");
                sb3.append(i6);
                sb3.append("x");
                sb3.append(i7);
                sb3.append("x");
                sb3.append(d6);
                sb = sb3.toString();
            }
        }
        v(sb);
        return false;
    }

    public String toString() {
        return this.f3861a;
    }
}
