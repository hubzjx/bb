package i1;

import android.util.Pair;
import c1.t;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.audio.d1;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import i1.a;
import i1.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import n1.a;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f10875a = s0.h0("OpusHead");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10876a;

        /* renamed from: b  reason: collision with root package name */
        public int f10877b;

        /* renamed from: c  reason: collision with root package name */
        public int f10878c;

        /* renamed from: d  reason: collision with root package name */
        public long f10879d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f10880e;

        /* renamed from: f  reason: collision with root package name */
        private final y f10881f;

        /* renamed from: g  reason: collision with root package name */
        private final y f10882g;

        /* renamed from: h  reason: collision with root package name */
        private int f10883h;

        /* renamed from: i  reason: collision with root package name */
        private int f10884i;

        public a(y yVar, y yVar2, boolean z5) {
            this.f10882g = yVar;
            this.f10881f = yVar2;
            this.f10880e = z5;
            yVar2.M(12);
            this.f10876a = yVar2.E();
            yVar.M(12);
            this.f10884i = yVar.E();
            com.google.android.exoplayer2.util.a.h(yVar.k() == 1, "first_chunk must be 1");
            this.f10877b = -1;
        }

        public boolean a() {
            int i6 = this.f10877b + 1;
            this.f10877b = i6;
            if (i6 == this.f10876a) {
                return false;
            }
            this.f10879d = this.f10880e ? this.f10881f.F() : this.f10881f.C();
            if (this.f10877b == this.f10883h) {
                this.f10878c = this.f10882g.E();
                this.f10882g.N(4);
                int i7 = this.f10884i - 1;
                this.f10884i = i7;
                this.f10883h = i7 > 0 ? this.f10882g.E() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0179b {
        int a();

        int b();

        int c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final p[] f10885a;

        /* renamed from: b  reason: collision with root package name */
        public com.google.android.exoplayer2.s0 f10886b;

        /* renamed from: c  reason: collision with root package name */
        public int f10887c;

        /* renamed from: d  reason: collision with root package name */
        public int f10888d = 0;

        public c(int i6) {
            this.f10885a = new p[i6];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d implements InterfaceC0179b {

        /* renamed from: a  reason: collision with root package name */
        private final int f10889a;

        /* renamed from: b  reason: collision with root package name */
        private final int f10890b;

        /* renamed from: c  reason: collision with root package name */
        private final y f10891c;

        public d(a.b bVar) {
            y yVar = bVar.f10874b;
            this.f10891c = yVar;
            yVar.M(12);
            int E = yVar.E();
            this.f10889a = E == 0 ? -1 : E;
            this.f10890b = yVar.E();
        }

        @Override // i1.b.InterfaceC0179b
        public int a() {
            return this.f10889a;
        }

        @Override // i1.b.InterfaceC0179b
        public int b() {
            return this.f10890b;
        }

        @Override // i1.b.InterfaceC0179b
        public int c() {
            int i6 = this.f10889a;
            return i6 == -1 ? this.f10891c.E() : i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e implements InterfaceC0179b {

        /* renamed from: a  reason: collision with root package name */
        private final y f10892a;

        /* renamed from: b  reason: collision with root package name */
        private final int f10893b;

        /* renamed from: c  reason: collision with root package name */
        private final int f10894c;

        /* renamed from: d  reason: collision with root package name */
        private int f10895d;

        /* renamed from: e  reason: collision with root package name */
        private int f10896e;

        public e(a.b bVar) {
            y yVar = bVar.f10874b;
            this.f10892a = yVar;
            yVar.M(12);
            this.f10894c = yVar.E() & 255;
            this.f10893b = yVar.E();
        }

        @Override // i1.b.InterfaceC0179b
        public int a() {
            return -1;
        }

        @Override // i1.b.InterfaceC0179b
        public int b() {
            return this.f10893b;
        }

        @Override // i1.b.InterfaceC0179b
        public int c() {
            int i6 = this.f10894c;
            if (i6 == 8) {
                return this.f10892a.A();
            }
            if (i6 == 16) {
                return this.f10892a.G();
            }
            int i7 = this.f10895d;
            this.f10895d = i7 + 1;
            if (i7 % 2 == 0) {
                int A = this.f10892a.A();
                this.f10896e = A;
                return (A & 240) >> 4;
            }
            return this.f10896e & 15;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final int f10897a;

        /* renamed from: b  reason: collision with root package name */
        private final long f10898b;

        /* renamed from: c  reason: collision with root package name */
        private final int f10899c;

        public f(int i6, long j6, int i7) {
            this.f10897a = i6;
            this.f10898b = j6;
            this.f10899c = i7;
        }
    }

    private static void A(y yVar, int i6, int i7, int i8, int i9, int i10, com.google.android.exoplayer2.drm.k kVar, c cVar, int i11) {
        com.google.android.exoplayer2.drm.k kVar2;
        List list;
        String str;
        List list2;
        String str2;
        int i12 = i7;
        com.google.android.exoplayer2.drm.k kVar3 = kVar;
        yVar.M(i12 + 8 + 8);
        yVar.N(16);
        int G = yVar.G();
        int G2 = yVar.G();
        yVar.N(50);
        int d6 = yVar.d();
        String str3 = null;
        int i13 = i6;
        if (i13 == 1701733238) {
            Pair q5 = q(yVar, i12, i8);
            if (q5 != null) {
                i13 = ((Integer) q5.first).intValue();
                kVar3 = kVar3 == null ? null : kVar3.g(((p) q5.second).f10998b);
                cVar.f10885a[i11] = (p) q5.second;
            }
            yVar.M(d6);
        }
        byte[] bArr = null;
        List list3 = null;
        String str4 = null;
        float f6 = 1.0f;
        int i14 = -1;
        boolean z5 = false;
        while (true) {
            if (d6 - i12 >= i8) {
                kVar2 = kVar3;
                list = list3;
                break;
            }
            yVar.M(d6);
            int d7 = yVar.d();
            kVar2 = kVar3;
            int k6 = yVar.k();
            if (k6 == 0) {
                list = list3;
                if (yVar.d() - i12 == i8) {
                    break;
                }
            } else {
                list = list3;
            }
            com.google.android.exoplayer2.util.a.h(k6 > 0, "childAtomSize should be positive");
            int k7 = yVar.k();
            if (k7 == 1635148611) {
                com.google.android.exoplayer2.util.a.g(str4 == null);
                yVar.M(d7 + 8);
                s2.a b6 = s2.a.b(yVar);
                list2 = b6.f13167a;
                cVar.f10887c = b6.f13168b;
                if (!z5) {
                    f6 = b6.f13171e;
                }
                str2 = "video/avc";
            } else if (k7 == 1752589123) {
                com.google.android.exoplayer2.util.a.g(str4 == null);
                yVar.M(d7 + 8);
                s2.e a6 = s2.e.a(yVar);
                list2 = a6.f13190a;
                cVar.f10887c = a6.f13191b;
                str2 = "video/hevc";
            } else {
                if (k7 == 1685480259 || k7 == 1685485123) {
                    s2.c a7 = s2.c.a(yVar);
                    if (a7 != null) {
                        str3 = a7.f13179c;
                        str4 = "video/dolby-vision";
                    }
                } else {
                    if (k7 == 1987076931) {
                        com.google.android.exoplayer2.util.a.g(str4 == null);
                        str = i13 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                    } else if (k7 == 1635135811) {
                        com.google.android.exoplayer2.util.a.g(str4 == null);
                        str = "video/av01";
                    } else if (k7 == 1681012275) {
                        com.google.android.exoplayer2.util.a.g(str4 == null);
                        str = "video/3gpp";
                    } else {
                        if (k7 == 1702061171) {
                            com.google.android.exoplayer2.util.a.g(str4 == null);
                            Pair g6 = g(yVar, d7);
                            String str5 = (String) g6.first;
                            byte[] bArr2 = (byte[]) g6.second;
                            list3 = bArr2 != null ? com.google.common.collect.y.of(bArr2) : list;
                            str4 = str5;
                        } else if (k7 == 1885434736) {
                            list3 = list;
                            f6 = o(yVar, d7);
                            z5 = true;
                        } else if (k7 == 1937126244) {
                            list3 = list;
                            bArr = p(yVar, d7, k6);
                        } else if (k7 == 1936995172) {
                            int A = yVar.A();
                            yVar.N(3);
                            if (A == 0) {
                                int A2 = yVar.A();
                                if (A2 == 0) {
                                    list3 = list;
                                    i14 = 0;
                                } else if (A2 == 1) {
                                    list3 = list;
                                    i14 = 1;
                                } else if (A2 == 2) {
                                    list3 = list;
                                    i14 = 2;
                                } else if (A2 == 3) {
                                    list3 = list;
                                    i14 = 3;
                                }
                            }
                        }
                        d6 += k6;
                        i12 = i7;
                        kVar3 = kVar2;
                    }
                    list3 = list;
                    str4 = str;
                    d6 += k6;
                    i12 = i7;
                    kVar3 = kVar2;
                }
                list3 = list;
                d6 += k6;
                i12 = i7;
                kVar3 = kVar2;
            }
            str4 = str2;
            list3 = list2;
            d6 += k6;
            i12 = i7;
            kVar3 = kVar2;
        }
        if (str4 == null) {
            return;
        }
        cVar.f10886b = new s0.b().R(i9).e0(str4).I(str3).j0(G).Q(G2).a0(f6).d0(i10).b0(bArr).h0(i14).T(list).L(kVar2).E();
    }

    private static boolean a(long[] jArr, long j6, long j7, long j8) {
        int length = jArr.length - 1;
        return jArr[0] <= j7 && j7 < jArr[com.google.android.exoplayer2.util.s0.r(4, 0, length)] && jArr[com.google.android.exoplayer2.util.s0.r(jArr.length - 4, 0, length)] < j8 && j8 <= j6;
    }

    private static int b(y yVar, int i6, int i7) {
        int d6 = yVar.d();
        while (d6 - i6 < i7) {
            yVar.M(d6);
            int k6 = yVar.k();
            com.google.android.exoplayer2.util.a.h(k6 > 0, "childAtomSize should be positive");
            if (yVar.k() == 1702061171) {
                return d6;
            }
            d6 += k6;
        }
        return -1;
    }

    private static int c(int i6) {
        if (i6 == 1936684398) {
            return 1;
        }
        if (i6 == 1986618469) {
            return 2;
        }
        if (i6 == 1952807028 || i6 == 1935832172 || i6 == 1937072756 || i6 == 1668047728) {
            return 3;
        }
        return i6 == 1835365473 ? 4 : -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0138  */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void d(y yVar, int i6, int i7, int i8, int i9, String str, boolean z5, com.google.android.exoplayer2.drm.k kVar, c cVar, int i10) {
        int i11;
        int i12;
        int i13;
        com.google.android.exoplayer2.drm.k kVar2;
        String str2;
        String str3;
        int i14;
        int i15;
        com.google.android.exoplayer2.s0 E;
        int i16 = i7;
        int i17 = i8;
        yVar.M(i16 + 8 + 8);
        if (z5) {
            i11 = yVar.G();
            yVar.N(6);
        } else {
            yVar.N(8);
            i11 = 0;
        }
        boolean z6 = true;
        if (i11 == 0 || i11 == 1) {
            int G = yVar.G();
            yVar.N(6);
            int B = yVar.B();
            if (i11 == 1) {
                yVar.N(16);
            }
            i12 = B;
            i13 = G;
        } else if (i11 != 2) {
            return;
        } else {
            yVar.N(16);
            i12 = (int) Math.round(yVar.j());
            i13 = yVar.E();
            yVar.N(20);
        }
        int d6 = yVar.d();
        int i18 = i6;
        if (i18 == 1701733217) {
            Pair q5 = q(yVar, i16, i17);
            if (q5 != null) {
                i18 = ((Integer) q5.first).intValue();
                kVar2 = kVar == null ? null : kVar.g(((p) q5.second).f10998b);
                cVar.f10885a[i10] = (p) q5.second;
            } else {
                kVar2 = kVar;
            }
            yVar.M(d6);
        } else {
            kVar2 = kVar;
        }
        if (i18 == 1633889587) {
            str2 = "audio/ac3";
        } else if (i18 == 1700998451) {
            str2 = "audio/eac3";
        } else if (i18 == 1633889588) {
            str2 = "audio/ac4";
        } else if (i18 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (i18 == 1685353320 || i18 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (i18 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i18 == 1935764850) {
            str2 = "audio/3gpp";
        } else if (i18 != 1935767394) {
            str3 = "audio/raw";
            if (i18 == 1819304813 || i18 == 1936684916) {
                i14 = 2;
            } else if (i18 == 1953984371) {
                i14 = 268435456;
            } else if (i18 == 778924082 || i18 == 778924083) {
                str2 = "audio/mpeg";
            } else if (i18 == 1634492771) {
                str2 = "audio/alac";
            } else if (i18 == 1634492791) {
                str2 = "audio/g711-alaw";
            } else if (i18 == 1970037111) {
                str2 = "audio/g711-mlaw";
            } else if (i18 == 1332770163) {
                str2 = "audio/opus";
            } else if (i18 == 1716281667) {
                str2 = "audio/flac";
            } else {
                i14 = -1;
                str3 = null;
            }
            String str4 = str3;
            String str5 = null;
            com.google.common.collect.y yVar2 = null;
            while (d6 - i16 < i17) {
                yVar.M(d6);
                int k6 = yVar.k();
                if (k6 <= 0) {
                    z6 = false;
                }
                com.google.android.exoplayer2.util.a.h(z6, "childAtomSize should be positive");
                int k7 = yVar.k();
                if (k7 == 1702061171) {
                    z6 = true;
                    i15 = 1702061171;
                } else if (z5 && k7 == 2002876005) {
                    i15 = 1702061171;
                    z6 = true;
                } else {
                    if (k7 == 1684103987) {
                        yVar.M(d6 + 8);
                        E = com.google.android.exoplayer2.audio.b.c(yVar, Integer.toString(i9), str, kVar2);
                    } else if (k7 == 1684366131) {
                        yVar.M(d6 + 8);
                        E = com.google.android.exoplayer2.audio.b.g(yVar, Integer.toString(i9), str, kVar2);
                    } else if (k7 == 1684103988) {
                        yVar.M(d6 + 8);
                        E = com.google.android.exoplayer2.audio.c.b(yVar, Integer.toString(i9), str, kVar2);
                    } else if (k7 == 1684305011) {
                        E = new s0.b().R(i9).e0(str4).H(i13).f0(i12).L(kVar2).V(str).E();
                    } else {
                        if (k7 == 1682927731) {
                            int i19 = k6 - 8;
                            byte[] bArr = f10875a;
                            byte[] copyOf = Arrays.copyOf(bArr, bArr.length + i19);
                            yVar.M(d6 + 8);
                            yVar.i(copyOf, bArr.length, i19);
                            yVar2 = d1.a(copyOf);
                            z6 = true;
                        } else if (k7 == 1684425825) {
                            int i20 = k6 - 12;
                            byte[] bArr2 = new byte[i20 + 4];
                            bArr2[0] = 102;
                            z6 = true;
                            bArr2[1] = 76;
                            bArr2[2] = 97;
                            bArr2[3] = 67;
                            yVar.M(d6 + 12);
                            yVar.i(bArr2, 4, i20);
                            yVar2 = com.google.common.collect.y.of(bArr2);
                        } else {
                            z6 = true;
                            if (k7 == 1634492771) {
                                int i21 = k6 - 12;
                                byte[] bArr3 = new byte[i21];
                                yVar.M(d6 + 12);
                                yVar.i(bArr3, 0, i21);
                                Pair f6 = com.google.android.exoplayer2.util.d.f(bArr3);
                                i12 = ((Integer) f6.first).intValue();
                                int intValue = ((Integer) f6.second).intValue();
                                yVar2 = com.google.common.collect.y.of(bArr3);
                                i13 = intValue;
                            }
                        }
                        d6 += k6;
                        i16 = i7;
                        i17 = i8;
                    }
                    cVar.f10886b = E;
                    z6 = true;
                    d6 += k6;
                    i16 = i7;
                    i17 = i8;
                }
                int b6 = k7 == i15 ? d6 : b(yVar, d6, k6);
                if (b6 != -1) {
                    Pair g6 = g(yVar, b6);
                    str4 = (String) g6.first;
                    byte[] bArr4 = (byte[]) g6.second;
                    if (bArr4 != null) {
                        if ("audio/mp4a-latm".equals(str4)) {
                            a.b g7 = com.google.android.exoplayer2.audio.a.g(bArr4);
                            i12 = g7.f3314a;
                            i13 = g7.f3315b;
                            str5 = g7.f3316c;
                        }
                        yVar2 = com.google.common.collect.y.of(bArr4);
                    }
                }
                d6 += k6;
                i16 = i7;
                i17 = i8;
            }
            if (cVar.f10886b == null || str4 == null) {
            }
            cVar.f10886b = new s0.b().R(i9).e0(str4).I(str5).H(i13).f0(i12).Y(i14).T(yVar2).L(kVar2).V(str).E();
            return;
        } else {
            str2 = "audio/amr-wb";
        }
        str3 = str2;
        i14 = -1;
        String str42 = str3;
        String str52 = null;
        com.google.common.collect.y yVar22 = null;
        while (d6 - i16 < i17) {
        }
        if (cVar.f10886b == null) {
        }
    }

    static Pair e(y yVar, int i6, int i7) {
        int i8 = i6 + 8;
        String str = null;
        Integer num = null;
        int i9 = -1;
        int i10 = 0;
        while (i8 - i6 < i7) {
            yVar.M(i8);
            int k6 = yVar.k();
            int k7 = yVar.k();
            if (k7 == 1718775137) {
                num = Integer.valueOf(yVar.k());
            } else if (k7 == 1935894637) {
                yVar.N(4);
                str = yVar.x(4);
            } else if (k7 == 1935894633) {
                i9 = i8;
                i10 = k6;
            }
            i8 += k6;
        }
        if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
            com.google.android.exoplayer2.util.a.j(num, "frma atom is mandatory");
            com.google.android.exoplayer2.util.a.h(i9 != -1, "schi atom is mandatory");
            return Pair.create(num, (p) com.google.android.exoplayer2.util.a.j(r(yVar, i9, i10, str), "tenc atom is mandatory"));
        }
        return null;
    }

    private static Pair f(a.C0178a c0178a) {
        a.b g6 = c0178a.g(1701606260);
        if (g6 == null) {
            return null;
        }
        y yVar = g6.f10874b;
        yVar.M(8);
        int c6 = i1.a.c(yVar.k());
        int E = yVar.E();
        long[] jArr = new long[E];
        long[] jArr2 = new long[E];
        for (int i6 = 0; i6 < E; i6++) {
            jArr[i6] = c6 == 1 ? yVar.F() : yVar.C();
            jArr2[i6] = c6 == 1 ? yVar.t() : yVar.k();
            if (yVar.w() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            yVar.N(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair g(y yVar, int i6) {
        yVar.M(i6 + 8 + 4);
        yVar.N(1);
        h(yVar);
        yVar.N(2);
        int A = yVar.A();
        if ((A & 128) != 0) {
            yVar.N(2);
        }
        if ((A & 64) != 0) {
            yVar.N(yVar.G());
        }
        if ((A & 32) != 0) {
            yVar.N(2);
        }
        yVar.N(1);
        h(yVar);
        String f6 = com.google.android.exoplayer2.util.q.f(yVar.A());
        if ("audio/mpeg".equals(f6) || "audio/vnd.dts".equals(f6) || "audio/vnd.dts.hd".equals(f6)) {
            return Pair.create(f6, null);
        }
        yVar.N(12);
        yVar.N(1);
        int h6 = h(yVar);
        byte[] bArr = new byte[h6];
        yVar.i(bArr, 0, h6);
        return Pair.create(f6, bArr);
    }

    private static int h(y yVar) {
        int A = yVar.A();
        int i6 = A & 127;
        while ((A & 128) == 128) {
            A = yVar.A();
            i6 = (i6 << 7) | (A & 127);
        }
        return i6;
    }

    private static int i(y yVar) {
        yVar.M(16);
        return yVar.k();
    }

    private static n1.a j(y yVar, int i6) {
        yVar.N(8);
        ArrayList arrayList = new ArrayList();
        while (yVar.d() < i6) {
            a.b c6 = i.c(yVar);
            if (c6 != null) {
                arrayList.add(c6);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new n1.a(arrayList);
    }

    private static Pair k(y yVar) {
        yVar.M(8);
        int c6 = i1.a.c(yVar.k());
        yVar.N(c6 == 0 ? 8 : 16);
        long C = yVar.C();
        yVar.N(c6 == 0 ? 4 : 8);
        int G = yVar.G();
        StringBuilder sb = new StringBuilder(3);
        sb.append((char) (((G >> 10) & 31) + 96));
        sb.append((char) (((G >> 5) & 31) + 96));
        sb.append((char) ((G & 31) + 96));
        return Pair.create(Long.valueOf(C), sb.toString());
    }

    public static n1.a l(a.C0178a c0178a) {
        a.b g6 = c0178a.g(1751411826);
        a.b g7 = c0178a.g(1801812339);
        a.b g8 = c0178a.g(1768715124);
        if (g6 == null || g7 == null || g8 == null || i(g6.f10874b) != 1835299937) {
            return null;
        }
        y yVar = g7.f10874b;
        yVar.M(12);
        int k6 = yVar.k();
        String[] strArr = new String[k6];
        for (int i6 = 0; i6 < k6; i6++) {
            int k7 = yVar.k();
            yVar.N(4);
            strArr[i6] = yVar.x(k7 - 8);
        }
        y yVar2 = g8.f10874b;
        yVar2.M(8);
        ArrayList arrayList = new ArrayList();
        while (yVar2.a() > 8) {
            int d6 = yVar2.d();
            int k8 = yVar2.k();
            int k9 = yVar2.k() - 1;
            if (k9 < 0 || k9 >= k6) {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Skipped metadata with unknown key index: ");
                sb.append(k9);
                com.google.android.exoplayer2.util.n.h("AtomParsers", sb.toString());
            } else {
                h f6 = i.f(yVar2, d6 + k8, strArr[k9]);
                if (f6 != null) {
                    arrayList.add(f6);
                }
            }
            yVar2.M(d6 + k8);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new n1.a(arrayList);
    }

    private static void m(y yVar, int i6, int i7, int i8, c cVar) {
        yVar.M(i7 + 8 + 8);
        if (i6 == 1835365492) {
            yVar.u();
            String u5 = yVar.u();
            if (u5 != null) {
                cVar.f10886b = new s0.b().R(i8).e0(u5).E();
            }
        }
    }

    private static long n(y yVar) {
        yVar.M(8);
        yVar.N(i1.a.c(yVar.k()) != 0 ? 16 : 8);
        return yVar.C();
    }

    private static float o(y yVar, int i6) {
        yVar.M(i6 + 8);
        return yVar.E() / yVar.E();
    }

    private static byte[] p(y yVar, int i6, int i7) {
        int i8 = i6 + 8;
        while (i8 - i6 < i7) {
            yVar.M(i8);
            int k6 = yVar.k();
            if (yVar.k() == 1886547818) {
                return Arrays.copyOfRange(yVar.c(), i8, k6 + i8);
            }
            i8 += k6;
        }
        return null;
    }

    private static Pair q(y yVar, int i6, int i7) {
        Pair e6;
        int d6 = yVar.d();
        while (d6 - i6 < i7) {
            yVar.M(d6);
            int k6 = yVar.k();
            com.google.android.exoplayer2.util.a.h(k6 > 0, "childAtomSize should be positive");
            if (yVar.k() == 1936289382 && (e6 = e(yVar, d6, k6)) != null) {
                return e6;
            }
            d6 += k6;
        }
        return null;
    }

    private static p r(y yVar, int i6, int i7, String str) {
        int i8;
        int i9;
        int i10 = i6 + 8;
        while (true) {
            byte[] bArr = null;
            if (i10 - i6 >= i7) {
                return null;
            }
            yVar.M(i10);
            int k6 = yVar.k();
            if (yVar.k() == 1952804451) {
                int c6 = i1.a.c(yVar.k());
                yVar.N(1);
                if (c6 == 0) {
                    yVar.N(1);
                    i9 = 0;
                    i8 = 0;
                } else {
                    int A = yVar.A();
                    i8 = A & 15;
                    i9 = (A & 240) >> 4;
                }
                boolean z5 = yVar.A() == 1;
                int A2 = yVar.A();
                byte[] bArr2 = new byte[16];
                yVar.i(bArr2, 0, 16);
                if (z5 && A2 == 0) {
                    int A3 = yVar.A();
                    bArr = new byte[A3];
                    yVar.i(bArr, 0, A3);
                }
                return new p(z5, str, A2, bArr2, i9, i8, bArr);
            }
            i10 += k6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x042b A[EDGE_INSN: B:208:0x042b->B:170:0x042b ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static r s(o oVar, a.C0178a c0178a, t tVar) {
        InterfaceC0179b eVar;
        boolean z5;
        int i6;
        int i7;
        int i8;
        int a6;
        int i9;
        int i10;
        boolean z6;
        int i11;
        int i12;
        int i13;
        boolean z7;
        int i14;
        o oVar2;
        int i15;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int i16;
        int i17;
        long j6;
        int[] iArr2;
        int i18;
        int i19;
        long[] jArr3;
        int i20;
        int[] iArr3;
        long j7;
        long[] jArr4;
        long[] jArr5;
        int i21;
        long[] jArr6;
        int i22;
        boolean z8;
        int[] iArr4;
        int i23;
        int[] iArr5;
        int[] iArr6;
        long[] jArr7;
        int[] iArr7;
        int i24;
        long[] jArr8;
        int i25;
        int i26;
        a.b g6 = c0178a.g(1937011578);
        if (g6 != null) {
            eVar = new d(g6);
        } else {
            a.b g7 = c0178a.g(1937013298);
            if (g7 == null) {
                throw new f1("Track has no sample table size information");
            }
            eVar = new e(g7);
        }
        int b6 = eVar.b();
        if (b6 == 0) {
            return new r(oVar, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        a.b g8 = c0178a.g(1937007471);
        if (g8 == null) {
            g8 = (a.b) com.google.android.exoplayer2.util.a.e(c0178a.g(1668232756));
            z5 = true;
        } else {
            z5 = false;
        }
        y yVar = g8.f10874b;
        y yVar2 = ((a.b) com.google.android.exoplayer2.util.a.e(c0178a.g(1937011555))).f10874b;
        y yVar3 = ((a.b) com.google.android.exoplayer2.util.a.e(c0178a.g(1937011827))).f10874b;
        a.b g9 = c0178a.g(1937011571);
        y yVar4 = g9 != null ? g9.f10874b : null;
        a.b g10 = c0178a.g(1668576371);
        y yVar5 = g10 != null ? g10.f10874b : null;
        a aVar = new a(yVar2, yVar, z5);
        yVar3.M(12);
        int E = yVar3.E() - 1;
        int E2 = yVar3.E();
        int E3 = yVar3.E();
        if (yVar5 != null) {
            yVar5.M(12);
            i6 = yVar5.E();
        } else {
            i6 = 0;
        }
        if (yVar4 != null) {
            yVar4.M(12);
            i7 = yVar4.E();
            if (i7 > 0) {
                i8 = yVar4.E() - 1;
                a6 = eVar.a();
                String str = oVar.f10991f.f4056n;
                if (a6 == -1 && (("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && E == 0 && i6 == 0 && i7 == 0)) {
                    i9 = E;
                    i10 = E2;
                    z6 = true;
                } else {
                    i9 = E;
                    i10 = E2;
                    z6 = false;
                }
                if (z6) {
                    long[] jArr9 = new long[b6];
                    int[] iArr8 = new int[b6];
                    long[] jArr10 = new long[b6];
                    int[] iArr9 = new int[b6];
                    int i27 = i8;
                    int i28 = 0;
                    int i29 = 0;
                    int i30 = 0;
                    int i31 = 0;
                    int i32 = 0;
                    long j8 = 0;
                    long j9 = 0;
                    int i33 = i6;
                    int i34 = E3;
                    int i35 = i10;
                    while (true) {
                        if (i28 >= b6) {
                            i11 = i35;
                            i12 = i30;
                            i13 = i31;
                            break;
                        }
                        long j10 = j9;
                        int i36 = i31;
                        boolean z9 = true;
                        while (i36 == 0) {
                            z9 = aVar.a();
                            if (!z9) {
                                break;
                            }
                            int i37 = i35;
                            long j11 = aVar.f10879d;
                            i36 = aVar.f10878c;
                            j10 = j11;
                            i35 = i37;
                            i34 = i34;
                            b6 = b6;
                        }
                        int i38 = b6;
                        i11 = i35;
                        int i39 = i34;
                        if (!z9) {
                            com.google.android.exoplayer2.util.n.h("AtomParsers", "Unexpected end of chunk data");
                            jArr9 = Arrays.copyOf(jArr9, i28);
                            iArr8 = Arrays.copyOf(iArr8, i28);
                            jArr10 = Arrays.copyOf(jArr10, i28);
                            iArr9 = Arrays.copyOf(iArr9, i28);
                            b6 = i28;
                            i12 = i30;
                            i13 = i36;
                            break;
                        }
                        if (yVar5 != null) {
                            while (i32 == 0 && i33 > 0) {
                                i32 = yVar5.E();
                                i30 = yVar5.k();
                                i33--;
                            }
                            i32--;
                        }
                        int i40 = i30;
                        jArr9[i28] = j10;
                        int c6 = eVar.c();
                        iArr8[i28] = c6;
                        if (c6 > i29) {
                            i29 = c6;
                        }
                        jArr10[i28] = j8 + i40;
                        iArr9[i28] = yVar4 == null ? 1 : 0;
                        if (i28 == i27) {
                            iArr9[i28] = 1;
                            i7--;
                            if (i7 > 0) {
                                i27 = ((y) com.google.android.exoplayer2.util.a.e(yVar4)).E() - 1;
                            }
                        }
                        int i41 = i27;
                        j8 += i39;
                        int i42 = i11 - 1;
                        if (i42 != 0 || i9 <= 0) {
                            i18 = i39;
                            i19 = i9;
                        } else {
                            i42 = yVar3.E();
                            i18 = yVar3.k();
                            i19 = i9 - 1;
                        }
                        int i43 = i42;
                        i31 = i36 - 1;
                        i28++;
                        j9 = j10 + iArr8[i28];
                        i27 = i41;
                        i34 = i18;
                        b6 = i38;
                        i30 = i40;
                        int i44 = i19;
                        i35 = i43;
                        i9 = i44;
                    }
                    long j12 = j8 + i12;
                    if (yVar5 != null) {
                        while (i33 > 0) {
                            if (yVar5.E() != 0) {
                                z7 = false;
                                break;
                            }
                            yVar5.k();
                            i33--;
                        }
                    }
                    z7 = true;
                    if (i7 == 0 && i11 == 0 && i13 == 0 && i9 == 0) {
                        i14 = i32;
                        if (i14 == 0 && z7) {
                            oVar2 = oVar;
                            i15 = b6;
                            jArr = jArr9;
                            iArr = iArr8;
                            jArr2 = jArr10;
                            i16 = i29;
                            i17 = i15;
                            j6 = j12;
                            iArr2 = iArr9;
                        }
                    } else {
                        i14 = i32;
                    }
                    oVar2 = oVar;
                    int i45 = oVar2.f10986a;
                    String str2 = !z7 ? ", ctts invalid" : HttpUrl.FRAGMENT_ENCODE_SET;
                    i15 = b6;
                    StringBuilder sb = new StringBuilder(str2.length() + 262);
                    sb.append("Inconsistent stbl box for track ");
                    sb.append(i45);
                    sb.append(": remainingSynchronizationSamples ");
                    sb.append(i7);
                    sb.append(", remainingSamplesAtTimestampDelta ");
                    sb.append(i11);
                    sb.append(", remainingSamplesInChunk ");
                    sb.append(i13);
                    sb.append(", remainingTimestampDeltaChanges ");
                    sb.append(i9);
                    sb.append(", remainingSamplesAtTimestampOffset ");
                    sb.append(i14);
                    sb.append(str2);
                    com.google.android.exoplayer2.util.n.h("AtomParsers", sb.toString());
                    jArr = jArr9;
                    iArr = iArr8;
                    jArr2 = jArr10;
                    i16 = i29;
                    i17 = i15;
                    j6 = j12;
                    iArr2 = iArr9;
                } else {
                    int i46 = aVar.f10876a;
                    long[] jArr11 = new long[i46];
                    int[] iArr10 = new int[i46];
                    while (aVar.a()) {
                        int i47 = aVar.f10877b;
                        jArr11[i47] = aVar.f10879d;
                        iArr10[i47] = aVar.f10878c;
                    }
                    d.b a7 = i1.d.a(a6, jArr11, iArr10, E3);
                    long[] jArr12 = a7.f10904a;
                    int[] iArr11 = a7.f10905b;
                    i16 = a7.f10906c;
                    long[] jArr13 = a7.f10907d;
                    int[] iArr12 = a7.f10908e;
                    long j13 = a7.f10909f;
                    i17 = b6;
                    jArr = jArr12;
                    iArr = iArr11;
                    jArr2 = jArr13;
                    iArr2 = iArr12;
                    j6 = j13;
                    oVar2 = oVar;
                }
                long F0 = com.google.android.exoplayer2.util.s0.F0(j6, 1000000L, oVar2.f10988c);
                jArr3 = oVar2.f10993h;
                if (jArr3 != null) {
                    com.google.android.exoplayer2.util.s0.H0(jArr2, 1000000L, oVar2.f10988c);
                    return new r(oVar, jArr, iArr, i16, jArr2, iArr2, F0);
                }
                if (jArr3.length == 1 && oVar2.f10987b == 1 && jArr2.length >= 2) {
                    long j14 = ((long[]) com.google.android.exoplayer2.util.a.e(oVar2.f10994i))[0];
                    long F02 = j14 + com.google.android.exoplayer2.util.s0.F0(oVar2.f10993h[0], oVar2.f10988c, oVar2.f10989d);
                    i20 = i17;
                    if (a(jArr2, j6, j14, F02)) {
                        long F03 = com.google.android.exoplayer2.util.s0.F0(j14 - jArr2[0], oVar2.f10991f.B, oVar2.f10988c);
                        iArr3 = iArr2;
                        j7 = j6;
                        long F04 = com.google.android.exoplayer2.util.s0.F0(j6 - F02, oVar2.f10991f.B, oVar2.f10988c);
                        if ((F03 != 0 || F04 != 0) && F03 <= 2147483647L && F04 <= 2147483647L) {
                            tVar.f3240a = (int) F03;
                            tVar.f3241b = (int) F04;
                            com.google.android.exoplayer2.util.s0.H0(jArr2, 1000000L, oVar2.f10988c);
                            return new r(oVar, jArr, iArr, i16, jArr2, iArr3, com.google.android.exoplayer2.util.s0.F0(oVar2.f10993h[0], 1000000L, oVar2.f10989d));
                        }
                        jArr4 = oVar2.f10993h;
                        if (jArr4.length != 1 && jArr4[0] == 0) {
                            long j15 = ((long[]) com.google.android.exoplayer2.util.a.e(oVar2.f10994i))[0];
                            for (int i48 = 0; i48 < jArr2.length; i48++) {
                                jArr2[i48] = com.google.android.exoplayer2.util.s0.F0(jArr2[i48] - j15, 1000000L, oVar2.f10988c);
                            }
                            return new r(oVar, jArr, iArr, i16, jArr2, iArr3, com.google.android.exoplayer2.util.s0.F0(j7 - j15, 1000000L, oVar2.f10988c));
                        }
                        boolean z10 = oVar2.f10987b != 1;
                        int[] iArr13 = new int[jArr4.length];
                        int[] iArr14 = new int[jArr4.length];
                        jArr5 = (long[]) com.google.android.exoplayer2.util.a.e(oVar2.f10994i);
                        i21 = 0;
                        boolean z11 = false;
                        int i49 = 0;
                        int i50 = 0;
                        while (true) {
                            jArr6 = oVar2.f10993h;
                            if (i21 < jArr6.length) {
                                break;
                            }
                            long j16 = jArr5[i21];
                            if (j16 != -1) {
                                long j17 = jArr6[i21];
                                i24 = i16;
                                jArr8 = jArr5;
                                jArr7 = jArr;
                                iArr7 = iArr;
                                long F05 = com.google.android.exoplayer2.util.s0.F0(j17, oVar2.f10988c, oVar2.f10989d);
                                iArr13[i21] = com.google.android.exoplayer2.util.s0.i(jArr2, j16, true, true);
                                iArr14[i21] = com.google.android.exoplayer2.util.s0.e(jArr2, j16 + F05, z10, false);
                                while (true) {
                                    i25 = iArr13[i21];
                                    i26 = iArr14[i21];
                                    if (i25 >= i26 || (iArr3[i25] & 1) != 0) {
                                        break;
                                    }
                                    iArr13[i21] = i25 + 1;
                                }
                                i49 += i26 - i25;
                                z11 = (i50 != i25) | z11;
                                i50 = i26;
                            } else {
                                jArr7 = jArr;
                                iArr7 = iArr;
                                i24 = i16;
                                jArr8 = jArr5;
                            }
                            i21++;
                            jArr5 = jArr8;
                            i16 = i24;
                            jArr = jArr7;
                            iArr = iArr7;
                        }
                        long[] jArr14 = jArr;
                        int[] iArr15 = iArr;
                        int i51 = i16;
                        i22 = 0;
                        z8 = z11 | (i49 == i20);
                        long[] jArr15 = !z8 ? new long[i49] : jArr14;
                        int[] iArr16 = !z8 ? new int[i49] : iArr15;
                        if (z8) {
                            i51 = 0;
                        }
                        int[] iArr17 = !z8 ? new int[i49] : iArr3;
                        long[] jArr16 = new long[i49];
                        int i52 = 0;
                        long j18 = 0;
                        while (i22 < oVar2.f10993h.length) {
                            long j19 = oVar2.f10994i[i22];
                            int i53 = iArr13[i22];
                            int i54 = iArr14[i22];
                            int[] iArr18 = iArr14;
                            if (z8) {
                                int i55 = i54 - i53;
                                iArr4 = iArr13;
                                System.arraycopy(jArr14, i53, jArr15, i52, i55);
                                iArr5 = iArr15;
                                System.arraycopy(iArr5, i53, iArr16, i52, i55);
                                i23 = i51;
                                iArr6 = iArr3;
                                System.arraycopy(iArr6, i53, iArr17, i52, i55);
                            } else {
                                iArr4 = iArr13;
                                i23 = i51;
                                iArr5 = iArr15;
                                iArr6 = iArr3;
                            }
                            int i56 = i23;
                            while (i53 < i54) {
                                int[] iArr19 = iArr5;
                                int i57 = i22;
                                long[] jArr17 = jArr2;
                                long[] jArr18 = jArr15;
                                long j20 = j18;
                                jArr16[i52] = com.google.android.exoplayer2.util.s0.F0(j18, 1000000L, oVar2.f10989d) + com.google.android.exoplayer2.util.s0.F0(Math.max(0L, jArr2[i53] - j19), 1000000L, oVar2.f10988c);
                                if (z8 && iArr16[i52] > i56) {
                                    i56 = iArr19[i53];
                                }
                                i52++;
                                i53++;
                                i22 = i57;
                                j18 = j20;
                                jArr2 = jArr17;
                                iArr5 = iArr19;
                                jArr15 = jArr18;
                            }
                            int[] iArr20 = iArr5;
                            int i58 = i22;
                            j18 += oVar2.f10993h[i58];
                            i22 = i58 + 1;
                            iArr3 = iArr6;
                            jArr2 = jArr2;
                            iArr13 = iArr4;
                            iArr15 = iArr20;
                            jArr15 = jArr15;
                            i51 = i56;
                            iArr14 = iArr18;
                        }
                        return new r(oVar, jArr15, iArr16, i51, jArr16, iArr17, com.google.android.exoplayer2.util.s0.F0(j18, 1000000L, oVar2.f10989d));
                    }
                } else {
                    i20 = i17;
                }
                iArr3 = iArr2;
                j7 = j6;
                jArr4 = oVar2.f10993h;
                if (jArr4.length != 1) {
                }
                if (oVar2.f10987b != 1) {
                }
                int[] iArr132 = new int[jArr4.length];
                int[] iArr142 = new int[jArr4.length];
                jArr5 = (long[]) com.google.android.exoplayer2.util.a.e(oVar2.f10994i);
                i21 = 0;
                boolean z112 = false;
                int i492 = 0;
                int i502 = 0;
                while (true) {
                    jArr6 = oVar2.f10993h;
                    if (i21 < jArr6.length) {
                    }
                    i21++;
                    jArr5 = jArr8;
                    i16 = i24;
                    jArr = jArr7;
                    iArr = iArr7;
                }
                long[] jArr142 = jArr;
                int[] iArr152 = iArr;
                int i512 = i16;
                i22 = 0;
                z8 = z112 | (i492 == i20);
                if (!z8) {
                }
                if (!z8) {
                }
                if (z8) {
                }
                if (!z8) {
                }
                long[] jArr162 = new long[i492];
                int i522 = 0;
                long j182 = 0;
                while (i22 < oVar2.f10993h.length) {
                }
                return new r(oVar, jArr15, iArr16, i512, jArr162, iArr17, com.google.android.exoplayer2.util.s0.F0(j182, 1000000L, oVar2.f10989d));
            }
            yVar4 = null;
        } else {
            i7 = 0;
        }
        i8 = -1;
        a6 = eVar.a();
        String str3 = oVar.f10991f.f4056n;
        if (a6 == -1) {
        }
        i9 = E;
        i10 = E2;
        z6 = false;
        if (z6) {
        }
        long F06 = com.google.android.exoplayer2.util.s0.F0(j6, 1000000L, oVar2.f10988c);
        jArr3 = oVar2.f10993h;
        if (jArr3 != null) {
        }
    }

    private static c t(y yVar, int i6, int i7, String str, com.google.android.exoplayer2.drm.k kVar, boolean z5) {
        int i8;
        yVar.M(12);
        int k6 = yVar.k();
        c cVar = new c(k6);
        for (int i9 = 0; i9 < k6; i9++) {
            int d6 = yVar.d();
            int k7 = yVar.k();
            com.google.android.exoplayer2.util.a.h(k7 > 0, "childAtomSize should be positive");
            int k8 = yVar.k();
            if (k8 == 1635148593 || k8 == 1635148595 || k8 == 1701733238 || k8 == 1836070006 || k8 == 1752589105 || k8 == 1751479857 || k8 == 1932670515 || k8 == 1987063864 || k8 == 1987063865 || k8 == 1635135537 || k8 == 1685479798 || k8 == 1685479729 || k8 == 1685481573 || k8 == 1685481521) {
                i8 = d6;
                A(yVar, k8, i8, k7, i6, i7, kVar, cVar, i9);
            } else if (k8 == 1836069985 || k8 == 1701733217 || k8 == 1633889587 || k8 == 1700998451 || k8 == 1633889588 || k8 == 1685353315 || k8 == 1685353317 || k8 == 1685353320 || k8 == 1685353324 || k8 == 1935764850 || k8 == 1935767394 || k8 == 1819304813 || k8 == 1936684916 || k8 == 1953984371 || k8 == 778924082 || k8 == 778924083 || k8 == 1634492771 || k8 == 1634492791 || k8 == 1970037111 || k8 == 1332770163 || k8 == 1716281667) {
                i8 = d6;
                d(yVar, k8, d6, k7, i6, str, z5, kVar, cVar, i9);
            } else {
                if (k8 == 1414810956 || k8 == 1954034535 || k8 == 2004251764 || k8 == 1937010800 || k8 == 1664495672) {
                    u(yVar, k8, d6, k7, i6, str, cVar);
                } else if (k8 == 1835365492) {
                    m(yVar, k8, d6, i6, cVar);
                } else if (k8 == 1667329389) {
                    cVar.f10886b = new s0.b().R(i6).e0("application/x-camera-motion").E();
                }
                i8 = d6;
            }
            yVar.M(i8 + k7);
        }
        return cVar;
    }

    private static void u(y yVar, int i6, int i7, int i8, int i9, String str, c cVar) {
        yVar.M(i7 + 8 + 8);
        String str2 = "application/ttml+xml";
        com.google.common.collect.y yVar2 = null;
        long j6 = Long.MAX_VALUE;
        if (i6 != 1414810956) {
            if (i6 == 1954034535) {
                int i10 = (i8 - 8) - 8;
                byte[] bArr = new byte[i10];
                yVar.i(bArr, 0, i10);
                yVar2 = com.google.common.collect.y.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i6 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i6 == 1937010800) {
                j6 = 0;
            } else if (i6 != 1664495672) {
                throw new IllegalStateException();
            } else {
                cVar.f10888d = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        cVar.f10886b = new s0.b().R(i9).e0(str2).V(str).i0(j6).T(yVar2).E();
    }

    private static f v(y yVar) {
        boolean z5;
        yVar.M(8);
        int c6 = i1.a.c(yVar.k());
        yVar.N(c6 == 0 ? 8 : 16);
        int k6 = yVar.k();
        yVar.N(4);
        int d6 = yVar.d();
        int i6 = c6 == 0 ? 4 : 8;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i8 >= i6) {
                z5 = true;
                break;
            } else if (yVar.c()[d6 + i8] != -1) {
                z5 = false;
                break;
            } else {
                i8++;
            }
        }
        long j6 = -9223372036854775807L;
        if (z5) {
            yVar.N(i6);
        } else {
            long C = c6 == 0 ? yVar.C() : yVar.F();
            if (C != 0) {
                j6 = C;
            }
        }
        yVar.N(16);
        int k7 = yVar.k();
        int k8 = yVar.k();
        yVar.N(4);
        int k9 = yVar.k();
        int k10 = yVar.k();
        if (k7 == 0 && k8 == 65536 && k9 == -65536 && k10 == 0) {
            i7 = 90;
        } else if (k7 == 0 && k8 == -65536 && k9 == 65536 && k10 == 0) {
            i7 = 270;
        } else if (k7 == -65536 && k8 == 0 && k9 == 0 && k10 == -65536) {
            i7 = 180;
        }
        return new f(k6, j6, i7);
    }

    private static o w(a.C0178a c0178a, a.b bVar, long j6, com.google.android.exoplayer2.drm.k kVar, boolean z5, boolean z6) {
        a.b bVar2;
        long j7;
        long[] jArr;
        long[] jArr2;
        a.C0178a f6;
        Pair f7;
        a.C0178a c0178a2 = (a.C0178a) com.google.android.exoplayer2.util.a.e(c0178a.f(1835297121));
        int c6 = c(i(((a.b) com.google.android.exoplayer2.util.a.e(c0178a2.g(1751411826))).f10874b));
        if (c6 == -1) {
            return null;
        }
        f v5 = v(((a.b) com.google.android.exoplayer2.util.a.e(c0178a.g(1953196132))).f10874b);
        if (j6 == -9223372036854775807L) {
            bVar2 = bVar;
            j7 = v5.f10898b;
        } else {
            bVar2 = bVar;
            j7 = j6;
        }
        long n5 = n(bVar2.f10874b);
        long F0 = j7 != -9223372036854775807L ? com.google.android.exoplayer2.util.s0.F0(j7, 1000000L, n5) : -9223372036854775807L;
        Pair k6 = k(((a.b) com.google.android.exoplayer2.util.a.e(c0178a2.g(1835296868))).f10874b);
        c t5 = t(((a.b) com.google.android.exoplayer2.util.a.e(((a.C0178a) com.google.android.exoplayer2.util.a.e(((a.C0178a) com.google.android.exoplayer2.util.a.e(c0178a2.f(1835626086))).f(1937007212))).g(1937011556))).f10874b, v5.f10897a, v5.f10899c, (String) k6.second, kVar, z6);
        if (z5 || (f6 = c0178a.f(1701082227)) == null || (f7 = f(f6)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            jArr2 = (long[]) f7.second;
            jArr = (long[]) f7.first;
        }
        if (t5.f10886b == null) {
            return null;
        }
        return new o(v5.f10897a, c6, ((Long) k6.first).longValue(), n5, F0, t5.f10886b, t5.f10888d, t5.f10885a, t5.f10887c, jArr, jArr2);
    }

    public static List x(a.C0178a c0178a, t tVar, long j6, com.google.android.exoplayer2.drm.k kVar, boolean z5, boolean z6, com.google.common.base.e eVar) {
        o oVar;
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < c0178a.f10873d.size(); i6++) {
            a.C0178a c0178a2 = (a.C0178a) c0178a.f10873d.get(i6);
            if (c0178a2.f10870a == 1953653099 && (oVar = (o) eVar.apply(w(c0178a2, (a.b) com.google.android.exoplayer2.util.a.e(c0178a.g(1836476516)), j6, kVar, z5, z6))) != null) {
                arrayList.add(s(oVar, (a.C0178a) com.google.android.exoplayer2.util.a.e(((a.C0178a) com.google.android.exoplayer2.util.a.e(((a.C0178a) com.google.android.exoplayer2.util.a.e(c0178a2.f(1835297121))).f(1835626086))).f(1937007212)), tVar));
            }
        }
        return arrayList;
    }

    public static n1.a y(a.b bVar, boolean z5) {
        if (z5) {
            return null;
        }
        y yVar = bVar.f10874b;
        yVar.M(8);
        while (yVar.a() >= 8) {
            int d6 = yVar.d();
            int k6 = yVar.k();
            if (yVar.k() == 1835365473) {
                yVar.M(d6);
                return z(yVar, d6 + k6);
            }
            yVar.M(d6 + k6);
        }
        return null;
    }

    private static n1.a z(y yVar, int i6) {
        yVar.N(12);
        while (yVar.d() < i6) {
            int d6 = yVar.d();
            int k6 = yVar.k();
            if (yVar.k() == 1768715124) {
                yVar.M(d6);
                return j(yVar, d6 + k6);
            }
            yVar.M(d6 + k6);
        }
        return null;
    }
}
