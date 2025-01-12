package i1;

import c1.t;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.y;
import n1.a;
/* loaded from: classes.dex */
abstract class i {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f10955a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    private static s1.e a(int i6, y yVar) {
        int k6 = yVar.k();
        if (yVar.k() == 1684108385) {
            yVar.N(8);
            String v5 = yVar.v(k6 - 16);
            return new s1.e("und", v5, v5);
        }
        String valueOf = String.valueOf(a.a(i6));
        com.google.android.exoplayer2.util.n.h("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
        return null;
    }

    private static s1.a b(y yVar) {
        String str;
        int k6 = yVar.k();
        if (yVar.k() == 1684108385) {
            int b6 = a.b(yVar.k());
            String str2 = b6 == 13 ? "image/jpeg" : b6 == 14 ? "image/png" : null;
            if (str2 != null) {
                yVar.N(4);
                int i6 = k6 - 16;
                byte[] bArr = new byte[i6];
                yVar.i(bArr, 0, i6);
                return new s1.a(str2, null, 3, bArr);
            }
            StringBuilder sb = new StringBuilder(41);
            sb.append("Unrecognized cover art flags: ");
            sb.append(b6);
            str = sb.toString();
        } else {
            str = "Failed to parse cover art attribute";
        }
        com.google.android.exoplayer2.util.n.h("MetadataUtil", str);
        return null;
    }

    public static a.b c(y yVar) {
        int d6 = yVar.d() + yVar.k();
        int k6 = yVar.k();
        int i6 = (k6 >> 24) & 255;
        try {
            if (i6 == 169 || i6 == 253) {
                int i7 = 16777215 & k6;
                if (i7 == 6516084) {
                    return a(k6, yVar);
                }
                if (i7 == 7233901 || i7 == 7631467) {
                    return h(k6, "TIT2", yVar);
                }
                if (i7 == 6516589 || i7 == 7828084) {
                    return h(k6, "TCOM", yVar);
                }
                if (i7 == 6578553) {
                    return h(k6, "TDRC", yVar);
                }
                if (i7 == 4280916) {
                    return h(k6, "TPE1", yVar);
                }
                if (i7 == 7630703) {
                    return h(k6, "TSSE", yVar);
                }
                if (i7 == 6384738) {
                    return h(k6, "TALB", yVar);
                }
                if (i7 == 7108978) {
                    return h(k6, "USLT", yVar);
                }
                if (i7 == 6776174) {
                    return h(k6, "TCON", yVar);
                }
                if (i7 == 6779504) {
                    return h(k6, "TIT1", yVar);
                }
            } else if (k6 == 1735291493) {
                return g(yVar);
            } else {
                if (k6 == 1684632427) {
                    return d(k6, "TPOS", yVar);
                }
                if (k6 == 1953655662) {
                    return d(k6, "TRCK", yVar);
                }
                if (k6 == 1953329263) {
                    return i(k6, "TBPM", yVar, true, false);
                }
                if (k6 == 1668311404) {
                    return i(k6, "TCMP", yVar, true, true);
                }
                if (k6 == 1668249202) {
                    return b(yVar);
                }
                if (k6 == 1631670868) {
                    return h(k6, "TPE2", yVar);
                }
                if (k6 == 1936682605) {
                    return h(k6, "TSOT", yVar);
                }
                if (k6 == 1936679276) {
                    return h(k6, "TSO2", yVar);
                }
                if (k6 == 1936679282) {
                    return h(k6, "TSOA", yVar);
                }
                if (k6 == 1936679265) {
                    return h(k6, "TSOP", yVar);
                }
                if (k6 == 1936679791) {
                    return h(k6, "TSOC", yVar);
                }
                if (k6 == 1920233063) {
                    return i(k6, "ITUNESADVISORY", yVar, false, false);
                }
                if (k6 == 1885823344) {
                    return i(k6, "ITUNESGAPLESS", yVar, false, true);
                }
                if (k6 == 1936683886) {
                    return h(k6, "TVSHOWSORT", yVar);
                }
                if (k6 == 1953919848) {
                    return h(k6, "TVSHOW", yVar);
                }
                if (k6 == 757935405) {
                    return e(yVar, d6);
                }
            }
            String valueOf = String.valueOf(a.a(k6));
            com.google.android.exoplayer2.util.n.b("MetadataUtil", valueOf.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf) : new String("Skipped unknown metadata entry: "));
            yVar.M(d6);
            return null;
        } finally {
            yVar.M(d6);
        }
    }

    private static s1.m d(int i6, String str, y yVar) {
        int k6 = yVar.k();
        if (yVar.k() == 1684108385 && k6 >= 22) {
            yVar.N(10);
            int G = yVar.G();
            if (G > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(G);
                String sb2 = sb.toString();
                int G2 = yVar.G();
                if (G2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(valueOf.length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(G2);
                    sb2 = sb3.toString();
                }
                return new s1.m(str, null, sb2);
            }
        }
        String valueOf2 = String.valueOf(a.a(i6));
        com.google.android.exoplayer2.util.n.h("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    private static s1.i e(y yVar, int i6) {
        String str = null;
        String str2 = null;
        int i7 = -1;
        int i8 = -1;
        while (yVar.d() < i6) {
            int d6 = yVar.d();
            int k6 = yVar.k();
            int k7 = yVar.k();
            yVar.N(4);
            if (k7 == 1835360622) {
                str = yVar.v(k6 - 12);
            } else if (k7 == 1851878757) {
                str2 = yVar.v(k6 - 12);
            } else {
                if (k7 == 1684108385) {
                    i7 = d6;
                    i8 = k6;
                }
                yVar.N(k6 - 12);
            }
        }
        if (str == null || str2 == null || i7 == -1) {
            return null;
        }
        yVar.M(i7);
        yVar.N(16);
        return new s1.j(str, str2, yVar.v(i8 - 16));
    }

    public static h f(y yVar, int i6, String str) {
        while (true) {
            int d6 = yVar.d();
            if (d6 >= i6) {
                return null;
            }
            int k6 = yVar.k();
            if (yVar.k() == 1684108385) {
                int k7 = yVar.k();
                int k8 = yVar.k();
                int i7 = k6 - 16;
                byte[] bArr = new byte[i7];
                yVar.i(bArr, 0, i7);
                return new h(str, bArr, k8, k7);
            }
            yVar.M(d6 + k6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static s1.m g(y yVar) {
        String str;
        int j6 = j(yVar);
        if (j6 > 0) {
            String[] strArr = f10955a;
            if (j6 <= strArr.length) {
                str = strArr[j6 - 1];
                if (str == null) {
                    return new s1.m("TCON", null, str);
                }
                com.google.android.exoplayer2.util.n.h("MetadataUtil", "Failed to parse standard genre code");
                return null;
            }
        }
        str = null;
        if (str == null) {
        }
    }

    private static s1.m h(int i6, String str, y yVar) {
        int k6 = yVar.k();
        if (yVar.k() == 1684108385) {
            yVar.N(8);
            return new s1.m(str, null, yVar.v(k6 - 16));
        }
        String valueOf = String.valueOf(a.a(i6));
        com.google.android.exoplayer2.util.n.h("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static s1.i i(int i6, String str, y yVar, boolean z5, boolean z6) {
        int j6 = j(yVar);
        if (z6) {
            j6 = Math.min(1, j6);
        }
        if (j6 >= 0) {
            return z5 ? new s1.m(str, null, Integer.toString(j6)) : new s1.e("und", str, Integer.toString(j6));
        }
        String valueOf = String.valueOf(a.a(i6));
        com.google.android.exoplayer2.util.n.h("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static int j(y yVar) {
        yVar.N(4);
        if (yVar.k() == 1684108385) {
            yVar.N(8);
            return yVar.A();
        }
        com.google.android.exoplayer2.util.n.h("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i6, n1.a aVar, n1.a aVar2, t tVar, s0.b bVar) {
        if (i6 == 1) {
            if (tVar.a()) {
                bVar.M(tVar.f3240a).N(tVar.f3241b);
            }
            if (aVar != null) {
                bVar.X(aVar);
            }
        } else if (i6 == 2 && aVar2 != null) {
            for (int i7 = 0; i7 < aVar2.h(); i7++) {
                a.b g6 = aVar2.g(i7);
                if (g6 instanceof h) {
                    h hVar = (h) g6;
                    if ("com.android.capture.fps".equals(hVar.f10951a)) {
                        bVar.X(new n1.a(hVar));
                    }
                }
            }
        }
    }
}
