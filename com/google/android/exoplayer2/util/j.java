package com.google.android.exoplayer2.util;

import android.net.Uri;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class j {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c6;
        if (str == null) {
            return -1;
        }
        String r5 = q.r(str);
        r5.hashCode();
        switch (r5.hashCode()) {
            case -2123537834:
                if (r5.equals("audio/eac3-joc")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case -1662384011:
                if (r5.equals("video/mp2p")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case -1662384007:
                if (r5.equals("video/mp2t")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            case -1662095187:
                if (r5.equals("video/webm")) {
                    c6 = 3;
                    break;
                }
                c6 = 65535;
                break;
            case -1606874997:
                if (r5.equals("audio/amr-wb")) {
                    c6 = 4;
                    break;
                }
                c6 = 65535;
                break;
            case -1248337486:
                if (r5.equals("application/mp4")) {
                    c6 = 5;
                    break;
                }
                c6 = 65535;
                break;
            case -1004728940:
                if (r5.equals("text/vtt")) {
                    c6 = 6;
                    break;
                }
                c6 = 65535;
                break;
            case -387023398:
                if (r5.equals("audio/x-matroska")) {
                    c6 = 7;
                    break;
                }
                c6 = 65535;
                break;
            case -43467528:
                if (r5.equals("application/webm")) {
                    c6 = '\b';
                    break;
                }
                c6 = 65535;
                break;
            case 13915911:
                if (r5.equals("video/x-flv")) {
                    c6 = '\t';
                    break;
                }
                c6 = 65535;
                break;
            case 187078296:
                if (r5.equals("audio/ac3")) {
                    c6 = '\n';
                    break;
                }
                c6 = 65535;
                break;
            case 187078297:
                if (r5.equals("audio/ac4")) {
                    c6 = 11;
                    break;
                }
                c6 = 65535;
                break;
            case 187078669:
                if (r5.equals("audio/amr")) {
                    c6 = '\f';
                    break;
                }
                c6 = 65535;
                break;
            case 187090232:
                if (r5.equals("audio/mp4")) {
                    c6 = '\r';
                    break;
                }
                c6 = 65535;
                break;
            case 187091926:
                if (r5.equals("audio/ogg")) {
                    c6 = 14;
                    break;
                }
                c6 = 65535;
                break;
            case 187099443:
                if (r5.equals("audio/wav")) {
                    c6 = 15;
                    break;
                }
                c6 = 65535;
                break;
            case 1331848029:
                if (r5.equals("video/mp4")) {
                    c6 = 16;
                    break;
                }
                c6 = 65535;
                break;
            case 1503095341:
                if (r5.equals("audio/3gpp")) {
                    c6 = 17;
                    break;
                }
                c6 = 65535;
                break;
            case 1504578661:
                if (r5.equals("audio/eac3")) {
                    c6 = 18;
                    break;
                }
                c6 = 65535;
                break;
            case 1504619009:
                if (r5.equals("audio/flac")) {
                    c6 = 19;
                    break;
                }
                c6 = 65535;
                break;
            case 1504831518:
                if (r5.equals("audio/mpeg")) {
                    c6 = 20;
                    break;
                }
                c6 = 65535;
                break;
            case 1505118770:
                if (r5.equals("audio/webm")) {
                    c6 = 21;
                    break;
                }
                c6 = 65535;
                break;
            case 2039520277:
                if (r5.equals("video/x-matroska")) {
                    c6 = 22;
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
            case '\n':
            case 18:
                return 0;
            case 1:
                return 10;
            case 2:
                return 11;
            case 3:
            case 7:
            case '\b':
            case 21:
            case 22:
                return 6;
            case 4:
            case '\f':
            case 17:
                return 3;
            case 5:
            case '\r':
            case 16:
                return 8;
            case 6:
                return 13;
            case '\t':
                return 5;
            case 11:
                return 1;
            case 14:
                return 9;
            case 15:
                return 12;
            case 19:
                return 4;
            case 20:
                return 7;
            default:
                return -1;
        }
    }

    public static int b(Map map) {
        List list = (List) map.get("Content-Type");
        return a((list == null || list.isEmpty()) ? null : (String) list.get(0));
    }

    public static int c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        return (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) ? 13 : -1;
    }
}
