package q2;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
/* loaded from: classes.dex */
public final class j0 extends f {

    /* renamed from: e  reason: collision with root package name */
    private final int f12778e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f12779f;

    /* renamed from: g  reason: collision with root package name */
    private final DatagramPacket f12780g;

    /* renamed from: h  reason: collision with root package name */
    private Uri f12781h;

    /* renamed from: i  reason: collision with root package name */
    private DatagramSocket f12782i;

    /* renamed from: j  reason: collision with root package name */
    private MulticastSocket f12783j;

    /* renamed from: k  reason: collision with root package name */
    private InetAddress f12784k;

    /* renamed from: l  reason: collision with root package name */
    private InetSocketAddress f12785l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f12786m;

    /* renamed from: n  reason: collision with root package name */
    private int f12787n;

    /* loaded from: classes.dex */
    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public j0() {
        this(2000);
    }

    @Override // q2.l
    public long b(o oVar) {
        DatagramSocket datagramSocket;
        Uri uri = oVar.f12794a;
        this.f12781h = uri;
        String host = uri.getHost();
        int port = this.f12781h.getPort();
        s(oVar);
        try {
            this.f12784k = InetAddress.getByName(host);
            this.f12785l = new InetSocketAddress(this.f12784k, port);
            if (this.f12784k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.f12785l);
                this.f12783j = multicastSocket;
                multicastSocket.joinGroup(this.f12784k);
                datagramSocket = this.f12783j;
            } else {
                datagramSocket = new DatagramSocket(this.f12785l);
            }
            this.f12782i = datagramSocket;
            try {
                this.f12782i.setSoTimeout(this.f12778e);
                this.f12786m = true;
                t(oVar);
                return -1L;
            } catch (SocketException e6) {
                throw new a(e6);
            }
        } catch (IOException e7) {
            throw new a(e7);
        }
    }

    @Override // q2.l
    public void close() {
        this.f12781h = null;
        MulticastSocket multicastSocket = this.f12783j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.f12784k);
            } catch (IOException unused) {
            }
            this.f12783j = null;
        }
        DatagramSocket datagramSocket = this.f12782i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f12782i = null;
        }
        this.f12784k = null;
        this.f12785l = null;
        this.f12787n = 0;
        if (this.f12786m) {
            this.f12786m = false;
            r();
        }
    }

    @Override // q2.l
    public Uri k() {
        return this.f12781h;
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        if (this.f12787n == 0) {
            try {
                this.f12782i.receive(this.f12780g);
                int length = this.f12780g.getLength();
                this.f12787n = length;
                q(length);
            } catch (IOException e6) {
                throw new a(e6);
            }
        }
        int length2 = this.f12780g.getLength();
        int i8 = this.f12787n;
        int min = Math.min(i8, i7);
        System.arraycopy(this.f12779f, length2 - i8, bArr, i6, min);
        this.f12787n -= min;
        return min;
    }

    public j0(int i6) {
        this(i6, 8000);
    }

    public j0(int i6, int i7) {
        super(true);
        this.f12778e = i7;
        byte[] bArr = new byte[i6];
        this.f12779f = bArr;
        this.f12780g = new DatagramPacket(bArr, 0, i6);
    }
}
