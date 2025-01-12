package com.secret.prettyhezi.Server;

import com.secret.prettyhezi.Upload.y;
import java.io.Serializable;
/* loaded from: classes.dex */
public class a0 extends n {
    public int amount;
    public boolean auditor;
    public boolean bindcert;
    public int cards;
    public a count;
    public long created_at;
    public boolean digital;
    public boolean download;
    public b expire;
    public c fc;
    public d fp;
    public com.secret.prettyhezi.Upload.q[] gns;
    public int grade;
    public y.n[] hosts;
    public e integral;
    public boolean is_digital;
    public boolean is_up;
    public boolean isa;
    public boolean isb;
    public f level;
    public long logined_at;
    public boolean mas;
    public com.secret.prettyhezi.Upload.q[] mns;
    public String nickname;

    /* renamed from: p1  reason: collision with root package name */
    public boolean f7102p1;

    /* renamed from: p2  reason: collision with root package name */
    public boolean f7103p2;
    public boolean payment_password;
    public g permission;
    public String photomask;
    public int py1;
    public int py2;
    public boolean rer;
    public com.secret.prettyhezi.Upload.q[] rns;
    public String sharehash;
    public String shareurl;
    public h token;
    public boolean upload;
    public int userid;
    public String username;
    public String videomask;

    /* loaded from: classes.dex */
    public static class a implements Serializable {
        public int box;
        public int box_follow;
        public int fans;
        public int follow;
    }

    /* loaded from: classes.dex */
    public static class b implements Serializable {

        /* renamed from: p1  reason: collision with root package name */
        public long f7104p1;

        /* renamed from: p2  reason: collision with root package name */
        public long f7105p2;

        /* renamed from: p3  reason: collision with root package name */
        public long f7106p3;
    }

    /* loaded from: classes.dex */
    public static class c implements Serializable {
        public int cert_id;
        public long created_at;
    }

    /* loaded from: classes.dex */
    public static class d implements Serializable {
        public long created_at;
        public boolean verify;
    }

    /* loaded from: classes.dex */
    public static class e implements Serializable {
        public double all;
        public double contribution;
        public double freeze;
        public double invite;
        public double last;
        public int sign_count;
    }

    /* loaded from: classes.dex */
    public static class f implements Serializable {
        public long exp;
        public String level;
    }

    /* loaded from: classes.dex */
    public static class g implements Serializable {

        /* renamed from: p1  reason: collision with root package name */
        public boolean f7107p1;

        /* renamed from: p2  reason: collision with root package name */
        public boolean f7108p2;

        /* renamed from: p3  reason: collision with root package name */
        public boolean f7109p3;
    }

    /* loaded from: classes.dex */
    public static class h implements Serializable {
        public int cert;
        public long expires;
        public int id;
        public long timestamp;
        public String token;
    }

    public boolean HasForgetBindDevice() {
        c cVar = this.fc;
        return cVar != null && cVar.created_at > 0;
    }

    public boolean HasForgetExchangePassword() {
        d dVar = this.fp;
        return dVar != null && dVar.created_at > 0;
    }

    public boolean IsTimeToResetExchangePassword() {
        if (this.fp.verify) {
            return true;
        }
        if ((this.fp.created_at + g4.i.o()) * 1000 < System.currentTimeMillis()) {
            this.fp.verify = true;
        }
        return this.fp.verify;
    }

    public int UserId() {
        int i6 = this.id;
        return i6 > 0 ? i6 : this.userid;
    }
}
