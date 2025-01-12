package com.secret.prettyhezi.Cache;

import g4.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public class d {

    /* renamed from: j  reason: collision with root package name */
    static d f6030j;

    /* renamed from: a  reason: collision with root package name */
    String f6031a;

    /* renamed from: b  reason: collision with root package name */
    String f6032b;

    /* renamed from: c  reason: collision with root package name */
    String f6033c;

    /* renamed from: d  reason: collision with root package name */
    String f6034d;

    /* renamed from: e  reason: collision with root package name */
    String f6035e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f6036f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f6037g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f6038h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f6039i;

    public d() {
        f6030j = this;
        StringBuilder sb = new StringBuilder();
        sb.append(i.j().getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("VideoDownload");
        this.f6031a = sb.toString();
        File file = new File(this.f6031a);
        if (!file.exists()) {
            file.mkdir();
        }
        this.f6031a += str;
        this.f6032b = this.f6031a + "all";
        this.f6034d = this.f6031a + "completed";
        this.f6033c = this.f6031a + "m3u8all";
        this.f6035e = this.f6031a + "m3u8completed";
        b();
    }

    public ArrayList a(String str) {
        try {
            return new ArrayList(Arrays.asList((h[]) com.secret.prettyhezi.f.b(g4.c.g(str), h[].class)));
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public void b() {
        this.f6036f = a(this.f6032b);
        this.f6037g = a(this.f6034d);
        this.f6038h = c(this.f6033c);
        this.f6039i = c(this.f6035e);
    }

    public ArrayList c(String str) {
        try {
            return new ArrayList(Arrays.asList((e[]) com.secret.prettyhezi.f.b(g4.c.g(str), e[].class)));
        } catch (Exception unused) {
            return new ArrayList();
        }
    }
}
