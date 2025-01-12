package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import q2.d0;
/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f4609a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f4610b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4611c = false;

    /* renamed from: d  reason: collision with root package name */
    private static long f4612d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static String f4613e = "time.android.com";

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b(IOException iOException);
    }

    /* loaded from: classes.dex */
    private static final class c implements d0.b {

        /* renamed from: a  reason: collision with root package name */
        private final b f4614a;

        public c(b bVar) {
            this.f4614a = bVar;
        }

        @Override // q2.d0.b
        public d0.c k(d0.e eVar, long j6, long j7, IOException iOException, int i6) {
            b bVar = this.f4614a;
            if (bVar != null) {
                bVar.b(iOException);
            }
            return q2.d0.f12728f;
        }

        @Override // q2.d0.b
        public void m(d0.e eVar, long j6, long j7) {
            if (this.f4614a != null) {
                if (f0.k()) {
                    this.f4614a.a();
                } else {
                    this.f4614a.b(new IOException(new ConcurrentModificationException()));
                }
            }
        }

        @Override // q2.d0.b
        public void p(d0.e eVar, long j6, long j7, boolean z5) {
        }
    }

    /* loaded from: classes.dex */
    private static final class d implements d0.e {
        private d() {
        }

        @Override // q2.d0.e
        public void a() {
            synchronized (f0.f4609a) {
                synchronized (f0.f4610b) {
                    if (f0.f4611c) {
                        return;
                    }
                    long l6 = f0.l();
                    synchronized (f0.f4610b) {
                        long unused = f0.f4612d = l6;
                        boolean unused2 = f0.f4611c = true;
                    }
                }
            }
        }

        @Override // q2.d0.e
        public void c() {
        }
    }

    private static void g(byte b6, byte b7, int i6, long j6) {
        if (b6 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b7 != 4 && b7 != 5) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("SNTP: Untrusted mode: ");
            sb.append((int) b7);
            throw new IOException(sb.toString());
        } else if (i6 != 0 && i6 <= 15) {
            if (j6 == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
        } else {
            StringBuilder sb2 = new StringBuilder(36);
            sb2.append("SNTP: Untrusted stratum: ");
            sb2.append(i6);
            throw new IOException(sb2.toString());
        }
    }

    public static long h() {
        long j6;
        synchronized (f4610b) {
            j6 = f4611c ? f4612d : -9223372036854775807L;
        }
        return j6;
    }

    public static String i() {
        String str;
        synchronized (f4610b) {
            str = f4613e;
        }
        return str;
    }

    public static void j(q2.d0 d0Var, b bVar) {
        if (k()) {
            if (bVar != null) {
                bVar.a();
                return;
            }
            return;
        }
        if (d0Var == null) {
            d0Var = new q2.d0("SntpClient");
        }
        d0Var.n(new d(), new c(bVar), 1);
    }

    public static boolean k() {
        boolean z5;
        synchronized (f4610b) {
            z5 = f4611c;
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long l() {
        InetAddress byName = InetAddress.getByName(i());
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, (int) b.j.M0);
            bArr[0] = 27;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            o(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j6 = currentTimeMillis + (elapsedRealtime2 - elapsedRealtime);
            byte b6 = bArr[0];
            long n5 = n(bArr, 24);
            long n6 = n(bArr, 32);
            long n7 = n(bArr, 40);
            g((byte) ((b6 >> 6) & 3), (byte) (b6 & 7), bArr[1] & 255, n7);
            long j7 = (j6 + (((n6 - n5) + (n7 - j6)) / 2)) - elapsedRealtime2;
            datagramSocket.close();
            return j7;
        } catch (Throwable th) {
            try {
                datagramSocket.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static long m(byte[] bArr, int i6) {
        int i7 = bArr[i6];
        int i8 = bArr[i6 + 1];
        int i9 = bArr[i6 + 2];
        int i10 = bArr[i6 + 3];
        if ((i7 & 128) == 128) {
            i7 = (i7 & 127) + 128;
        }
        if ((i8 & 128) == 128) {
            i8 = (i8 & 127) + 128;
        }
        if ((i9 & 128) == 128) {
            i9 = (i9 & 127) + 128;
        }
        if ((i10 & 128) == 128) {
            i10 = (i10 & 127) + 128;
        }
        return (i7 << 24) + (i8 << 16) + (i9 << 8) + i10;
    }

    private static long n(byte[] bArr, int i6) {
        long m5 = m(bArr, i6);
        long m6 = m(bArr, i6 + 4);
        if (m5 == 0 && m6 == 0) {
            return 0L;
        }
        return ((m5 - 2208988800L) * 1000) + ((m6 * 1000) / 4294967296L);
    }

    private static void o(byte[] bArr, int i6, long j6) {
        if (j6 == 0) {
            Arrays.fill(bArr, i6, i6 + 8, (byte) 0);
            return;
        }
        long j7 = j6 / 1000;
        long j8 = j6 - (j7 * 1000);
        long j9 = j7 + 2208988800L;
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j9 >> 24);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (j9 >> 16);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (j9 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (j9 >> 0);
        long j10 = (j8 * 4294967296L) / 1000;
        int i11 = i10 + 1;
        bArr[i10] = (byte) (j10 >> 24);
        int i12 = i11 + 1;
        bArr[i11] = (byte) (j10 >> 16);
        bArr[i12] = (byte) (j10 >> 8);
        bArr[i12 + 1] = (byte) (Math.random() * 255.0d);
    }
}
