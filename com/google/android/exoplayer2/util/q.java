package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayList f4648a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f4649b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f4650a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4651b;

        public a(int i6, int i7) {
            this.f4650a = i6;
            this.f4651b = i7;
        }
    }

    public static boolean a(String str, String str2) {
        a g6;
        int d6;
        if (str == null) {
            return false;
        }
        char c6 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c6 = 0;
                    break;
                }
                break;
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                    c6 = 1;
                    break;
                }
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                    c6 = 2;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c6 = 3;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c6 = 4;
                    break;
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                    c6 = 5;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c6 = 6;
                    break;
                }
                break;
            case 1504619009:
                if (str.equals("audio/flac")) {
                    c6 = 7;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c6 = '\b';
                    break;
                }
                break;
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                    c6 = '\t';
                    break;
                }
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                    c6 = '\n';
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
                return true;
            case 3:
                return (str2 == null || (g6 = g(str2)) == null || (d6 = com.google.android.exoplayer2.audio.a.d(g6.f4651b)) == 0 || d6 == 16) ? false : true;
            default:
                return false;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : s0.M0(str)) {
            String e6 = e(str2);
            if (e6 != null && n(e6)) {
                return e6;
            }
        }
        return null;
    }

    private static String c(String str) {
        ArrayList arrayList = f4648a;
        if (arrayList.size() <= 0) {
            return null;
        }
        android.support.v4.media.a.a(arrayList.get(0));
        throw null;
    }

    public static int d(String str, String str2) {
        a g6;
        str.hashCode();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c6 = 0;
                    break;
                }
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c6 = 1;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c6 = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c6 = 3;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c6 = 4;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c6 = 5;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c6 = 6;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c6 = 7;
                    break;
                }
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c6 = '\b';
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                return 18;
            case 1:
                return 7;
            case 2:
                if (str2 == null || (g6 = g(str2)) == null) {
                    return 0;
                }
                return com.google.android.exoplayer2.audio.a.d(g6.f4651b);
            case 3:
                return 5;
            case 4:
                return 17;
            case 5:
                return 6;
            case 6:
                return 9;
            case 7:
                return 8;
            case '\b':
                return 14;
            default:
                return 0;
        }
    }

    public static String e(String str) {
        a g6;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String S0 = s0.S0(str.trim());
        if (S0.startsWith("avc1") || S0.startsWith("avc3")) {
            return "video/avc";
        }
        if (S0.startsWith("hev1") || S0.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (S0.startsWith("dvav") || S0.startsWith("dva1") || S0.startsWith("dvhe") || S0.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (S0.startsWith("av01")) {
            return "video/av01";
        }
        if (S0.startsWith("vp9") || S0.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (S0.startsWith("vp8") || S0.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (!S0.startsWith("mp4a")) {
            return (S0.startsWith("ac-3") || S0.startsWith("dac3")) ? "audio/ac3" : (S0.startsWith("ec-3") || S0.startsWith("dec3")) ? "audio/eac3" : S0.startsWith("ec+3") ? "audio/eac3-joc" : (S0.startsWith("ac-4") || S0.startsWith("dac4")) ? "audio/ac4" : (S0.startsWith("dtsc") || S0.startsWith("dtse")) ? "audio/vnd.dts" : (S0.startsWith("dtsh") || S0.startsWith("dtsl")) ? "audio/vnd.dts.hd" : S0.startsWith("opus") ? "audio/opus" : S0.startsWith("vorbis") ? "audio/vorbis" : S0.startsWith("flac") ? "audio/flac" : S0.startsWith("stpp") ? "application/ttml+xml" : S0.startsWith("wvtt") ? "text/vtt" : S0.contains("cea708") ? "application/cea-708" : (S0.contains("eia608") || S0.contains("cea608")) ? "application/cea-608" : c(S0);
        }
        if (S0.startsWith("mp4a.") && (g6 = g(S0)) != null) {
            str2 = f(g6.f4650a);
        }
        return str2 == null ? "audio/mp4a-latm" : str2;
    }

    public static String f(int i6) {
        if (i6 != 32) {
            if (i6 != 33) {
                if (i6 != 35) {
                    if (i6 != 64) {
                        if (i6 != 163) {
                            if (i6 != 177) {
                                if (i6 != 165) {
                                    if (i6 != 166) {
                                        switch (i6) {
                                            case androidx.constraintlayout.widget.g.O0 /* 96 */:
                                            case androidx.constraintlayout.widget.g.P0 /* 97 */:
                                            case androidx.constraintlayout.widget.g.Q0 /* 98 */:
                                            case androidx.constraintlayout.widget.g.R0 /* 99 */:
                                            case 100:
                                            case androidx.constraintlayout.widget.g.T0 /* 101 */:
                                                return "video/mpeg2";
                                            case androidx.constraintlayout.widget.g.U0 /* 102 */:
                                            case androidx.constraintlayout.widget.g.V0 /* 103 */:
                                            case androidx.constraintlayout.widget.g.W0 /* 104 */:
                                                return "audio/mp4a-latm";
                                            case 105:
                                            case androidx.constraintlayout.widget.g.Y0 /* 107 */:
                                                return "audio/mpeg";
                                            case androidx.constraintlayout.widget.g.X0 /* 106 */:
                                                return "video/mpeg";
                                            default:
                                                switch (i6) {
                                                    case 169:
                                                    case 172:
                                                        return "audio/vnd.dts";
                                                    case 170:
                                                    case 171:
                                                        return "audio/vnd.dts.hd";
                                                    case 173:
                                                        return "audio/opus";
                                                    case 174:
                                                        return "audio/ac4";
                                                    default:
                                                        return null;
                                                }
                                        }
                                    }
                                    return "audio/eac3";
                                }
                                return "audio/ac3";
                            }
                            return "video/x-vnd.on2.vp9";
                        }
                        return "video/wvc1";
                    }
                    return "audio/mp4a-latm";
                }
                return "video/hevc";
            }
            return "video/avc";
        }
        return "video/mp4v-es";
    }

    static a g(String str) {
        Matcher matcher = f4649b.matcher(str);
        if (matcher.matches()) {
            String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
            String group = matcher.group(2);
            try {
                return new a(Integer.parseInt(str2, 16), group != null ? Integer.parseInt(group) : 0);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    public static String h(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : s0.M0(str)) {
            String e6 = e(str2);
            if (e6 != null && p(e6)) {
                return e6;
            }
        }
        return null;
    }

    private static String i(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static int j(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (n(str)) {
            return 1;
        }
        if (q(str)) {
            return 2;
        }
        if (p(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 4;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 5;
        }
        return k(str);
    }

    private static int k(String str) {
        ArrayList arrayList = f4648a;
        if (arrayList.size() <= 0) {
            return -1;
        }
        android.support.v4.media.a.a(arrayList.get(0));
        throw null;
    }

    public static int l(String str) {
        return j(e(str));
    }

    public static String m(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : s0.M0(str)) {
            String e6 = e(str2);
            if (e6 != null && q(e6)) {
                return e6;
            }
        }
        return null;
    }

    public static boolean n(String str) {
        return "audio".equals(i(str));
    }

    public static boolean o(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska");
    }

    public static boolean p(String str) {
        return "text".equals(i(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean q(String str) {
        return "video".equals(i(str));
    }

    public static String r(String str) {
        str.hashCode();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1007807498:
                if (str.equals("audio/x-flac")) {
                    c6 = 0;
                    break;
                }
                break;
            case -586683234:
                if (str.equals("audio/x-wav")) {
                    c6 = 1;
                    break;
                }
                break;
            case 187090231:
                if (str.equals("audio/mp3")) {
                    c6 = 2;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                return "audio/flac";
            case 1:
                return "audio/wav";
            case 2:
                return "audio/mpeg";
            default:
                return str;
        }
    }
}
