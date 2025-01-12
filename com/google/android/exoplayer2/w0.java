package com.google.android.exoplayer2;

import android.net.Uri;
import com.google.android.exoplayer2.x0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f4701a;

    /* renamed from: b  reason: collision with root package name */
    public final e f4702b;

    /* renamed from: c  reason: collision with root package name */
    public final x0 f4703c;

    /* renamed from: d  reason: collision with root package name */
    public final c f4704d;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f4705a;

        /* renamed from: b  reason: collision with root package name */
        private Uri f4706b;

        /* renamed from: c  reason: collision with root package name */
        private String f4707c;

        /* renamed from: d  reason: collision with root package name */
        private long f4708d;

        /* renamed from: e  reason: collision with root package name */
        private long f4709e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f4710f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f4711g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f4712h;

        /* renamed from: i  reason: collision with root package name */
        private Uri f4713i;

        /* renamed from: j  reason: collision with root package name */
        private Map f4714j;

        /* renamed from: k  reason: collision with root package name */
        private UUID f4715k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f4716l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f4717m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f4718n;

        /* renamed from: o  reason: collision with root package name */
        private List f4719o;

        /* renamed from: p  reason: collision with root package name */
        private byte[] f4720p;

        /* renamed from: q  reason: collision with root package name */
        private List f4721q;

        /* renamed from: r  reason: collision with root package name */
        private String f4722r;

        /* renamed from: s  reason: collision with root package name */
        private List f4723s;

        /* renamed from: t  reason: collision with root package name */
        private Uri f4724t;

        /* renamed from: u  reason: collision with root package name */
        private Object f4725u;

        /* renamed from: v  reason: collision with root package name */
        private x0 f4726v;

        public b() {
            this.f4709e = Long.MIN_VALUE;
            this.f4719o = Collections.emptyList();
            this.f4714j = Collections.emptyMap();
            this.f4721q = Collections.emptyList();
            this.f4723s = Collections.emptyList();
        }

        public w0 a() {
            e eVar;
            com.google.android.exoplayer2.util.a.g(this.f4713i == null || this.f4715k != null);
            Uri uri = this.f4706b;
            if (uri != null) {
                String str = this.f4707c;
                UUID uuid = this.f4715k;
                e eVar2 = new e(uri, str, uuid != null ? new d(uuid, this.f4713i, this.f4714j, this.f4716l, this.f4718n, this.f4717m, this.f4719o, this.f4720p) : null, this.f4721q, this.f4722r, this.f4723s, this.f4724t, this.f4725u);
                String str2 = this.f4705a;
                if (str2 == null) {
                    str2 = this.f4706b.toString();
                }
                this.f4705a = str2;
                eVar = eVar2;
            } else {
                eVar = null;
            }
            String str3 = (String) com.google.android.exoplayer2.util.a.e(this.f4705a);
            c cVar = new c(this.f4708d, this.f4709e, this.f4710f, this.f4711g, this.f4712h);
            x0 x0Var = this.f4726v;
            if (x0Var == null) {
                x0Var = new x0.b().a();
            }
            return new w0(str3, cVar, eVar, x0Var);
        }

        public b b(String str) {
            this.f4722r = str;
            return this;
        }

        public b c(String str) {
            this.f4705a = str;
            return this;
        }

        public b d(String str) {
            this.f4707c = str;
            return this;
        }

        public b e(List list) {
            this.f4721q = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public b f(Object obj) {
            this.f4725u = obj;
            return this;
        }

        public b g(Uri uri) {
            this.f4706b = uri;
            return this;
        }

        private b(w0 w0Var) {
            this();
            c cVar = w0Var.f4704d;
            this.f4709e = cVar.f4728b;
            this.f4710f = cVar.f4729c;
            this.f4711g = cVar.f4730d;
            this.f4708d = cVar.f4727a;
            this.f4712h = cVar.f4731e;
            this.f4705a = w0Var.f4701a;
            this.f4726v = w0Var.f4703c;
            e eVar = w0Var.f4702b;
            if (eVar != null) {
                this.f4724t = eVar.f4746g;
                this.f4722r = eVar.f4744e;
                this.f4707c = eVar.f4741b;
                this.f4706b = eVar.f4740a;
                this.f4721q = eVar.f4743d;
                this.f4723s = eVar.f4745f;
                this.f4725u = eVar.f4747h;
                d dVar = eVar.f4742c;
                if (dVar != null) {
                    this.f4713i = dVar.f4733b;
                    this.f4714j = dVar.f4734c;
                    this.f4716l = dVar.f4735d;
                    this.f4718n = dVar.f4737f;
                    this.f4717m = dVar.f4736e;
                    this.f4719o = dVar.f4738g;
                    this.f4715k = dVar.f4732a;
                    this.f4720p = dVar.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final long f4727a;

        /* renamed from: b  reason: collision with root package name */
        public final long f4728b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f4729c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f4730d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f4731e;

        private c(long j6, long j7, boolean z5, boolean z6, boolean z7) {
            this.f4727a = j6;
            this.f4728b = j7;
            this.f4729c = z5;
            this.f4730d = z6;
            this.f4731e = z7;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f4727a == cVar.f4727a && this.f4728b == cVar.f4728b && this.f4729c == cVar.f4729c && this.f4730d == cVar.f4730d && this.f4731e == cVar.f4731e;
            }
            return false;
        }

        public int hashCode() {
            return (((((((Long.valueOf(this.f4727a).hashCode() * 31) + Long.valueOf(this.f4728b).hashCode()) * 31) + (this.f4729c ? 1 : 0)) * 31) + (this.f4730d ? 1 : 0)) * 31) + (this.f4731e ? 1 : 0);
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final UUID f4732a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri f4733b;

        /* renamed from: c  reason: collision with root package name */
        public final Map f4734c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f4735d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f4736e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f4737f;

        /* renamed from: g  reason: collision with root package name */
        public final List f4738g;

        /* renamed from: h  reason: collision with root package name */
        private final byte[] f4739h;

        private d(UUID uuid, Uri uri, Map map, boolean z5, boolean z6, boolean z7, List list, byte[] bArr) {
            this.f4732a = uuid;
            this.f4733b = uri;
            this.f4734c = map;
            this.f4735d = z5;
            this.f4737f = z6;
            this.f4736e = z7;
            this.f4738g = list;
            this.f4739h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        }

        public byte[] a() {
            byte[] bArr = this.f4739h;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                return this.f4732a.equals(dVar.f4732a) && com.google.android.exoplayer2.util.s0.c(this.f4733b, dVar.f4733b) && com.google.android.exoplayer2.util.s0.c(this.f4734c, dVar.f4734c) && this.f4735d == dVar.f4735d && this.f4737f == dVar.f4737f && this.f4736e == dVar.f4736e && this.f4738g.equals(dVar.f4738g) && Arrays.equals(this.f4739h, dVar.f4739h);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f4732a.hashCode() * 31;
            Uri uri = this.f4733b;
            return ((((((((((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f4734c.hashCode()) * 31) + (this.f4735d ? 1 : 0)) * 31) + (this.f4737f ? 1 : 0)) * 31) + (this.f4736e ? 1 : 0)) * 31) + this.f4738g.hashCode()) * 31) + Arrays.hashCode(this.f4739h);
        }
    }

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f4740a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4741b;

        /* renamed from: c  reason: collision with root package name */
        public final d f4742c;

        /* renamed from: d  reason: collision with root package name */
        public final List f4743d;

        /* renamed from: e  reason: collision with root package name */
        public final String f4744e;

        /* renamed from: f  reason: collision with root package name */
        public final List f4745f;

        /* renamed from: g  reason: collision with root package name */
        public final Uri f4746g;

        /* renamed from: h  reason: collision with root package name */
        public final Object f4747h;

        private e(Uri uri, String str, d dVar, List list, String str2, List list2, Uri uri2, Object obj) {
            this.f4740a = uri;
            this.f4741b = str;
            this.f4742c = dVar;
            this.f4743d = list;
            this.f4744e = str2;
            this.f4745f = list2;
            this.f4746g = uri2;
            this.f4747h = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof e) {
                e eVar = (e) obj;
                return this.f4740a.equals(eVar.f4740a) && com.google.android.exoplayer2.util.s0.c(this.f4741b, eVar.f4741b) && com.google.android.exoplayer2.util.s0.c(this.f4742c, eVar.f4742c) && this.f4743d.equals(eVar.f4743d) && com.google.android.exoplayer2.util.s0.c(this.f4744e, eVar.f4744e) && this.f4745f.equals(eVar.f4745f) && com.google.android.exoplayer2.util.s0.c(this.f4746g, eVar.f4746g) && com.google.android.exoplayer2.util.s0.c(this.f4747h, eVar.f4747h);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f4740a.hashCode() * 31;
            String str = this.f4741b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            d dVar = this.f4742c;
            int hashCode3 = (((hashCode2 + (dVar == null ? 0 : dVar.hashCode())) * 31) + this.f4743d.hashCode()) * 31;
            String str2 = this.f4744e;
            int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f4745f.hashCode()) * 31;
            Uri uri = this.f4746g;
            int hashCode5 = (hashCode4 + (uri == null ? 0 : uri.hashCode())) * 31;
            Object obj = this.f4747h;
            return hashCode5 + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* loaded from: classes.dex */
    public static final class f {
    }

    private w0(String str, c cVar, e eVar, x0 x0Var) {
        this.f4701a = str;
        this.f4702b = eVar;
        this.f4703c = x0Var;
        this.f4704d = cVar;
    }

    public b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w0) {
            w0 w0Var = (w0) obj;
            return com.google.android.exoplayer2.util.s0.c(this.f4701a, w0Var.f4701a) && this.f4704d.equals(w0Var.f4704d) && com.google.android.exoplayer2.util.s0.c(this.f4702b, w0Var.f4702b) && com.google.android.exoplayer2.util.s0.c(this.f4703c, w0Var.f4703c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f4701a.hashCode() * 31;
        e eVar = this.f4702b;
        return ((((hashCode + (eVar != null ? eVar.hashCode() : 0)) * 31) + this.f4704d.hashCode()) * 31) + this.f4703c.hashCode();
    }
}
