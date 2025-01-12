package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class s0 implements Parcelable {
    public static final Parcelable.Creator<s0> CREATOR = new a();
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final Class G;
    private int H;

    /* renamed from: a  reason: collision with root package name */
    public final String f4045a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4046b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4047c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4048d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4049e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4050f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4051g;

    /* renamed from: h  reason: collision with root package name */
    public final int f4052h;

    /* renamed from: k  reason: collision with root package name */
    public final String f4053k;

    /* renamed from: l  reason: collision with root package name */
    public final n1.a f4054l;

    /* renamed from: m  reason: collision with root package name */
    public final String f4055m;

    /* renamed from: n  reason: collision with root package name */
    public final String f4056n;

    /* renamed from: o  reason: collision with root package name */
    public final int f4057o;

    /* renamed from: p  reason: collision with root package name */
    public final List f4058p;

    /* renamed from: q  reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.k f4059q;

    /* renamed from: r  reason: collision with root package name */
    public final long f4060r;

    /* renamed from: s  reason: collision with root package name */
    public final int f4061s;

    /* renamed from: t  reason: collision with root package name */
    public final int f4062t;

    /* renamed from: u  reason: collision with root package name */
    public final float f4063u;

    /* renamed from: v  reason: collision with root package name */
    public final int f4064v;

    /* renamed from: w  reason: collision with root package name */
    public final float f4065w;

    /* renamed from: x  reason: collision with root package name */
    public final byte[] f4066x;

    /* renamed from: y  reason: collision with root package name */
    public final int f4067y;

    /* renamed from: z  reason: collision with root package name */
    public final s2.b f4068z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public s0 createFromParcel(Parcel parcel) {
            return new s0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public s0[] newArray(int i6) {
            return new s0[i6];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private int A;
        private int B;
        private int C;
        private Class D;

        /* renamed from: a  reason: collision with root package name */
        private String f4069a;

        /* renamed from: b  reason: collision with root package name */
        private String f4070b;

        /* renamed from: c  reason: collision with root package name */
        private String f4071c;

        /* renamed from: d  reason: collision with root package name */
        private int f4072d;

        /* renamed from: e  reason: collision with root package name */
        private int f4073e;

        /* renamed from: f  reason: collision with root package name */
        private int f4074f;

        /* renamed from: g  reason: collision with root package name */
        private int f4075g;

        /* renamed from: h  reason: collision with root package name */
        private String f4076h;

        /* renamed from: i  reason: collision with root package name */
        private n1.a f4077i;

        /* renamed from: j  reason: collision with root package name */
        private String f4078j;

        /* renamed from: k  reason: collision with root package name */
        private String f4079k;

        /* renamed from: l  reason: collision with root package name */
        private int f4080l;

        /* renamed from: m  reason: collision with root package name */
        private List f4081m;

        /* renamed from: n  reason: collision with root package name */
        private com.google.android.exoplayer2.drm.k f4082n;

        /* renamed from: o  reason: collision with root package name */
        private long f4083o;

        /* renamed from: p  reason: collision with root package name */
        private int f4084p;

        /* renamed from: q  reason: collision with root package name */
        private int f4085q;

        /* renamed from: r  reason: collision with root package name */
        private float f4086r;

        /* renamed from: s  reason: collision with root package name */
        private int f4087s;

        /* renamed from: t  reason: collision with root package name */
        private float f4088t;

        /* renamed from: u  reason: collision with root package name */
        private byte[] f4089u;

        /* renamed from: v  reason: collision with root package name */
        private int f4090v;

        /* renamed from: w  reason: collision with root package name */
        private s2.b f4091w;

        /* renamed from: x  reason: collision with root package name */
        private int f4092x;

        /* renamed from: y  reason: collision with root package name */
        private int f4093y;

        /* renamed from: z  reason: collision with root package name */
        private int f4094z;

        public b() {
            this.f4074f = -1;
            this.f4075g = -1;
            this.f4080l = -1;
            this.f4083o = Long.MAX_VALUE;
            this.f4084p = -1;
            this.f4085q = -1;
            this.f4086r = -1.0f;
            this.f4088t = 1.0f;
            this.f4090v = -1;
            this.f4092x = -1;
            this.f4093y = -1;
            this.f4094z = -1;
            this.C = -1;
        }

        public s0 E() {
            return new s0(this, null);
        }

        public b F(int i6) {
            this.C = i6;
            return this;
        }

        public b G(int i6) {
            this.f4074f = i6;
            return this;
        }

        public b H(int i6) {
            this.f4092x = i6;
            return this;
        }

        public b I(String str) {
            this.f4076h = str;
            return this;
        }

        public b J(s2.b bVar) {
            this.f4091w = bVar;
            return this;
        }

        public b K(String str) {
            this.f4078j = str;
            return this;
        }

        public b L(com.google.android.exoplayer2.drm.k kVar) {
            this.f4082n = kVar;
            return this;
        }

        public b M(int i6) {
            this.A = i6;
            return this;
        }

        public b N(int i6) {
            this.B = i6;
            return this;
        }

        public b O(Class cls) {
            this.D = cls;
            return this;
        }

        public b P(float f6) {
            this.f4086r = f6;
            return this;
        }

        public b Q(int i6) {
            this.f4085q = i6;
            return this;
        }

        public b R(int i6) {
            this.f4069a = Integer.toString(i6);
            return this;
        }

        public b S(String str) {
            this.f4069a = str;
            return this;
        }

        public b T(List list) {
            this.f4081m = list;
            return this;
        }

        public b U(String str) {
            this.f4070b = str;
            return this;
        }

        public b V(String str) {
            this.f4071c = str;
            return this;
        }

        public b W(int i6) {
            this.f4080l = i6;
            return this;
        }

        public b X(n1.a aVar) {
            this.f4077i = aVar;
            return this;
        }

        public b Y(int i6) {
            this.f4094z = i6;
            return this;
        }

        public b Z(int i6) {
            this.f4075g = i6;
            return this;
        }

        public b a0(float f6) {
            this.f4088t = f6;
            return this;
        }

        public b b0(byte[] bArr) {
            this.f4089u = bArr;
            return this;
        }

        public b c0(int i6) {
            this.f4073e = i6;
            return this;
        }

        public b d0(int i6) {
            this.f4087s = i6;
            return this;
        }

        public b e0(String str) {
            this.f4079k = str;
            return this;
        }

        public b f0(int i6) {
            this.f4093y = i6;
            return this;
        }

        public b g0(int i6) {
            this.f4072d = i6;
            return this;
        }

        public b h0(int i6) {
            this.f4090v = i6;
            return this;
        }

        public b i0(long j6) {
            this.f4083o = j6;
            return this;
        }

        public b j0(int i6) {
            this.f4084p = i6;
            return this;
        }

        private b(s0 s0Var) {
            this.f4069a = s0Var.f4045a;
            this.f4070b = s0Var.f4046b;
            this.f4071c = s0Var.f4047c;
            this.f4072d = s0Var.f4048d;
            this.f4073e = s0Var.f4049e;
            this.f4074f = s0Var.f4050f;
            this.f4075g = s0Var.f4051g;
            this.f4076h = s0Var.f4053k;
            this.f4077i = s0Var.f4054l;
            this.f4078j = s0Var.f4055m;
            this.f4079k = s0Var.f4056n;
            this.f4080l = s0Var.f4057o;
            this.f4081m = s0Var.f4058p;
            this.f4082n = s0Var.f4059q;
            this.f4083o = s0Var.f4060r;
            this.f4084p = s0Var.f4061s;
            this.f4085q = s0Var.f4062t;
            this.f4086r = s0Var.f4063u;
            this.f4087s = s0Var.f4064v;
            this.f4088t = s0Var.f4065w;
            this.f4089u = s0Var.f4066x;
            this.f4090v = s0Var.f4067y;
            this.f4091w = s0Var.f4068z;
            this.f4092x = s0Var.A;
            this.f4093y = s0Var.B;
            this.f4094z = s0Var.C;
            this.A = s0Var.D;
            this.B = s0Var.E;
            this.C = s0Var.F;
            this.D = s0Var.G;
        }

        /* synthetic */ b(s0 s0Var, a aVar) {
            this(s0Var);
        }
    }

    s0(Parcel parcel) {
        this.f4045a = parcel.readString();
        this.f4046b = parcel.readString();
        this.f4047c = parcel.readString();
        this.f4048d = parcel.readInt();
        this.f4049e = parcel.readInt();
        int readInt = parcel.readInt();
        this.f4050f = readInt;
        int readInt2 = parcel.readInt();
        this.f4051g = readInt2;
        this.f4052h = readInt2 != -1 ? readInt2 : readInt;
        this.f4053k = parcel.readString();
        this.f4054l = (n1.a) parcel.readParcelable(n1.a.class.getClassLoader());
        this.f4055m = parcel.readString();
        this.f4056n = parcel.readString();
        this.f4057o = parcel.readInt();
        int readInt3 = parcel.readInt();
        this.f4058p = new ArrayList(readInt3);
        for (int i6 = 0; i6 < readInt3; i6++) {
            this.f4058p.add((byte[]) com.google.android.exoplayer2.util.a.e(parcel.createByteArray()));
        }
        com.google.android.exoplayer2.drm.k kVar = (com.google.android.exoplayer2.drm.k) parcel.readParcelable(com.google.android.exoplayer2.drm.k.class.getClassLoader());
        this.f4059q = kVar;
        this.f4060r = parcel.readLong();
        this.f4061s = parcel.readInt();
        this.f4062t = parcel.readInt();
        this.f4063u = parcel.readFloat();
        this.f4064v = parcel.readInt();
        this.f4065w = parcel.readFloat();
        this.f4066x = com.google.android.exoplayer2.util.s0.D0(parcel) ? parcel.createByteArray() : null;
        this.f4067y = parcel.readInt();
        this.f4068z = (s2.b) parcel.readParcelable(s2.b.class.getClassLoader());
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = kVar != null ? com.google.android.exoplayer2.drm.j0.class : null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public b e() {
        return new b(this, null);
    }

    public boolean equals(Object obj) {
        int i6;
        if (this == obj) {
            return true;
        }
        if (obj == null || s0.class != obj.getClass()) {
            return false;
        }
        s0 s0Var = (s0) obj;
        int i7 = this.H;
        return (i7 == 0 || (i6 = s0Var.H) == 0 || i7 == i6) && this.f4048d == s0Var.f4048d && this.f4049e == s0Var.f4049e && this.f4050f == s0Var.f4050f && this.f4051g == s0Var.f4051g && this.f4057o == s0Var.f4057o && this.f4060r == s0Var.f4060r && this.f4061s == s0Var.f4061s && this.f4062t == s0Var.f4062t && this.f4064v == s0Var.f4064v && this.f4067y == s0Var.f4067y && this.A == s0Var.A && this.B == s0Var.B && this.C == s0Var.C && this.D == s0Var.D && this.E == s0Var.E && this.F == s0Var.F && Float.compare(this.f4063u, s0Var.f4063u) == 0 && Float.compare(this.f4065w, s0Var.f4065w) == 0 && com.google.android.exoplayer2.util.s0.c(this.G, s0Var.G) && com.google.android.exoplayer2.util.s0.c(this.f4045a, s0Var.f4045a) && com.google.android.exoplayer2.util.s0.c(this.f4046b, s0Var.f4046b) && com.google.android.exoplayer2.util.s0.c(this.f4053k, s0Var.f4053k) && com.google.android.exoplayer2.util.s0.c(this.f4055m, s0Var.f4055m) && com.google.android.exoplayer2.util.s0.c(this.f4056n, s0Var.f4056n) && com.google.android.exoplayer2.util.s0.c(this.f4047c, s0Var.f4047c) && Arrays.equals(this.f4066x, s0Var.f4066x) && com.google.android.exoplayer2.util.s0.c(this.f4054l, s0Var.f4054l) && com.google.android.exoplayer2.util.s0.c(this.f4068z, s0Var.f4068z) && com.google.android.exoplayer2.util.s0.c(this.f4059q, s0Var.f4059q) && h(s0Var);
    }

    public s0 f(Class cls) {
        return e().O(cls).E();
    }

    public int g() {
        int i6;
        int i7 = this.f4061s;
        if (i7 == -1 || (i6 = this.f4062t) == -1) {
            return -1;
        }
        return i7 * i6;
    }

    public boolean h(s0 s0Var) {
        if (this.f4058p.size() != s0Var.f4058p.size()) {
            return false;
        }
        for (int i6 = 0; i6 < this.f4058p.size(); i6++) {
            if (!Arrays.equals((byte[]) this.f4058p.get(i6), (byte[]) s0Var.f4058p.get(i6))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.H == 0) {
            String str = this.f4045a;
            int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f4046b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f4047c;
            int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f4048d) * 31) + this.f4049e) * 31) + this.f4050f) * 31) + this.f4051g) * 31;
            String str4 = this.f4053k;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            n1.a aVar = this.f4054l;
            int hashCode5 = (hashCode4 + (aVar == null ? 0 : aVar.hashCode())) * 31;
            String str5 = this.f4055m;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f4056n;
            int hashCode7 = (((((((((((((((((((((((((((((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.f4057o) * 31) + ((int) this.f4060r)) * 31) + this.f4061s) * 31) + this.f4062t) * 31) + Float.floatToIntBits(this.f4063u)) * 31) + this.f4064v) * 31) + Float.floatToIntBits(this.f4065w)) * 31) + this.f4067y) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.F) * 31;
            Class cls = this.G;
            this.H = hashCode7 + (cls != null ? cls.hashCode() : 0);
        }
        return this.H;
    }

    public s0 i(s0 s0Var) {
        String str;
        if (this == s0Var) {
            return this;
        }
        int j6 = com.google.android.exoplayer2.util.q.j(this.f4056n);
        String str2 = s0Var.f4045a;
        String str3 = s0Var.f4046b;
        if (str3 == null) {
            str3 = this.f4046b;
        }
        String str4 = this.f4047c;
        if ((j6 == 3 || j6 == 1) && (str = s0Var.f4047c) != null) {
            str4 = str;
        }
        int i6 = this.f4050f;
        if (i6 == -1) {
            i6 = s0Var.f4050f;
        }
        int i7 = this.f4051g;
        if (i7 == -1) {
            i7 = s0Var.f4051g;
        }
        String str5 = this.f4053k;
        if (str5 == null) {
            String J = com.google.android.exoplayer2.util.s0.J(s0Var.f4053k, j6);
            if (com.google.android.exoplayer2.util.s0.M0(J).length == 1) {
                str5 = J;
            }
        }
        n1.a aVar = this.f4054l;
        n1.a f6 = aVar == null ? s0Var.f4054l : aVar.f(s0Var.f4054l);
        float f7 = this.f4063u;
        if (f7 == -1.0f && j6 == 2) {
            f7 = s0Var.f4063u;
        }
        return e().S(str2).U(str3).V(str4).g0(this.f4048d | s0Var.f4048d).c0(this.f4049e | s0Var.f4049e).G(i6).Z(i7).I(str5).X(f6).L(com.google.android.exoplayer2.drm.k.h(s0Var.f4059q, this.f4059q)).P(f7).E();
    }

    public String toString() {
        String str = this.f4045a;
        String str2 = this.f4046b;
        String str3 = this.f4055m;
        String str4 = this.f4056n;
        String str5 = this.f4053k;
        int i6 = this.f4052h;
        String str6 = this.f4047c;
        int i7 = this.f4061s;
        int i8 = this.f4062t;
        float f6 = this.f4063u;
        int i9 = this.A;
        int i10 = this.B;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + androidx.constraintlayout.widget.g.W0 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(str4);
        sb.append(", ");
        sb.append(str5);
        sb.append(", ");
        sb.append(i6);
        sb.append(", ");
        sb.append(str6);
        sb.append(", [");
        sb.append(i7);
        sb.append(", ");
        sb.append(i8);
        sb.append(", ");
        sb.append(f6);
        sb.append("], [");
        sb.append(i9);
        sb.append(", ");
        sb.append(i10);
        sb.append("])");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f4045a);
        parcel.writeString(this.f4046b);
        parcel.writeString(this.f4047c);
        parcel.writeInt(this.f4048d);
        parcel.writeInt(this.f4049e);
        parcel.writeInt(this.f4050f);
        parcel.writeInt(this.f4051g);
        parcel.writeString(this.f4053k);
        parcel.writeParcelable(this.f4054l, 0);
        parcel.writeString(this.f4055m);
        parcel.writeString(this.f4056n);
        parcel.writeInt(this.f4057o);
        int size = this.f4058p.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeByteArray((byte[]) this.f4058p.get(i7));
        }
        parcel.writeParcelable(this.f4059q, 0);
        parcel.writeLong(this.f4060r);
        parcel.writeInt(this.f4061s);
        parcel.writeInt(this.f4062t);
        parcel.writeFloat(this.f4063u);
        parcel.writeInt(this.f4064v);
        parcel.writeFloat(this.f4065w);
        com.google.android.exoplayer2.util.s0.X0(parcel, this.f4066x != null);
        byte[] bArr = this.f4066x;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.f4067y);
        parcel.writeParcelable(this.f4068z, i6);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
    }

    private s0(b bVar) {
        this.f4045a = bVar.f4069a;
        this.f4046b = bVar.f4070b;
        this.f4047c = com.google.android.exoplayer2.util.s0.v0(bVar.f4071c);
        this.f4048d = bVar.f4072d;
        this.f4049e = bVar.f4073e;
        int i6 = bVar.f4074f;
        this.f4050f = i6;
        int i7 = bVar.f4075g;
        this.f4051g = i7;
        this.f4052h = i7 != -1 ? i7 : i6;
        this.f4053k = bVar.f4076h;
        this.f4054l = bVar.f4077i;
        this.f4055m = bVar.f4078j;
        this.f4056n = bVar.f4079k;
        this.f4057o = bVar.f4080l;
        this.f4058p = bVar.f4081m == null ? Collections.emptyList() : bVar.f4081m;
        com.google.android.exoplayer2.drm.k kVar = bVar.f4082n;
        this.f4059q = kVar;
        this.f4060r = bVar.f4083o;
        this.f4061s = bVar.f4084p;
        this.f4062t = bVar.f4085q;
        this.f4063u = bVar.f4086r;
        this.f4064v = bVar.f4087s == -1 ? 0 : bVar.f4087s;
        this.f4065w = bVar.f4088t == -1.0f ? 1.0f : bVar.f4088t;
        this.f4066x = bVar.f4089u;
        this.f4067y = bVar.f4090v;
        this.f4068z = bVar.f4091w;
        this.A = bVar.f4092x;
        this.B = bVar.f4093y;
        this.C = bVar.f4094z;
        this.D = bVar.A == -1 ? 0 : bVar.A;
        this.E = bVar.B != -1 ? bVar.B : 0;
        this.F = bVar.C;
        this.G = (bVar.D != null || kVar == null) ? bVar.D : com.google.android.exoplayer2.drm.j0.class;
    }

    /* synthetic */ s0(b bVar, a aVar) {
        this(bVar);
    }
}
