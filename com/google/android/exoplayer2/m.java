package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final AudioManager f3807a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3808b;

    /* renamed from: c  reason: collision with root package name */
    private b f3809c;

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.exoplayer2.audio.e f3810d;

    /* renamed from: f  reason: collision with root package name */
    private int f3812f;

    /* renamed from: h  reason: collision with root package name */
    private AudioFocusRequest f3814h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3815i;

    /* renamed from: g  reason: collision with root package name */
    private float f3813g = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private int f3811e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f3816a;

        public a(Handler handler) {
            this.f3816a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i6) {
            m.this.h(i6);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i6) {
            this.f3816a.post(new Runnable() { // from class: com.google.android.exoplayer2.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.a.this.b(i6);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void j(int i6);

        void v(float f6);
    }

    public m(Context context, Handler handler, b bVar) {
        this.f3807a = (AudioManager) com.google.android.exoplayer2.util.a.e((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.f3809c = bVar;
        this.f3808b = new a(handler);
    }

    private void a() {
        if (this.f3811e == 0) {
            return;
        }
        if (com.google.android.exoplayer2.util.s0.f4673a >= 26) {
            c();
        } else {
            b();
        }
        n(0);
    }

    private void b() {
        this.f3807a.abandonAudioFocus(this.f3808b);
    }

    private void c() {
        AudioFocusRequest audioFocusRequest = this.f3814h;
        if (audioFocusRequest != null) {
            this.f3807a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int e(com.google.android.exoplayer2.audio.e eVar) {
        if (eVar == null) {
            return 0;
        }
        int i6 = eVar.f3354c;
        switch (i6) {
            case 0:
                com.google.android.exoplayer2.util.n.h("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                break;
            case 11:
                if (eVar.f3352a == 1) {
                    return 2;
                }
                break;
            case 15:
            default:
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unidentified audio usage: ");
                sb.append(i6);
                com.google.android.exoplayer2.util.n.h("AudioFocusManager", sb.toString());
                return 0;
            case 16:
                return com.google.android.exoplayer2.util.s0.f4673a >= 19 ? 4 : 2;
        }
        return 3;
    }

    private void f(int i6) {
        b bVar = this.f3809c;
        if (bVar != null) {
            bVar.j(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i6) {
        int i7;
        if (i6 == -3 || i6 == -2) {
            if (i6 == -2 || q()) {
                f(0);
                i7 = 2;
            } else {
                i7 = 3;
            }
            n(i7);
        } else if (i6 == -1) {
            f(-1);
            a();
        } else if (i6 == 1) {
            n(1);
            f(1);
        } else {
            StringBuilder sb = new StringBuilder(38);
            sb.append("Unknown focus change type: ");
            sb.append(i6);
            com.google.android.exoplayer2.util.n.h("AudioFocusManager", sb.toString());
        }
    }

    private int j() {
        if (this.f3811e == 1) {
            return 1;
        }
        if ((com.google.android.exoplayer2.util.s0.f4673a >= 26 ? l() : k()) == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    private int k() {
        return this.f3807a.requestAudioFocus(this.f3808b, com.google.android.exoplayer2.util.s0.c0(((com.google.android.exoplayer2.audio.e) com.google.android.exoplayer2.util.a.e(this.f3810d)).f3354c), this.f3812f);
    }

    private int l() {
        AudioFocusRequest.Builder a6;
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder willPauseWhenDucked;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        int requestAudioFocus;
        AudioFocusRequest audioFocusRequest = this.f3814h;
        if (audioFocusRequest == null || this.f3815i) {
            if (audioFocusRequest == null) {
                k.a();
                a6 = j.a(this.f3812f);
            } else {
                k.a();
                a6 = i.a(this.f3814h);
            }
            boolean q5 = q();
            audioAttributes = a6.setAudioAttributes(((com.google.android.exoplayer2.audio.e) com.google.android.exoplayer2.util.a.e(this.f3810d)).a());
            willPauseWhenDucked = audioAttributes.setWillPauseWhenDucked(q5);
            onAudioFocusChangeListener = willPauseWhenDucked.setOnAudioFocusChangeListener(this.f3808b);
            build = onAudioFocusChangeListener.build();
            this.f3814h = build;
            this.f3815i = false;
        }
        requestAudioFocus = this.f3807a.requestAudioFocus(this.f3814h);
        return requestAudioFocus;
    }

    private void n(int i6) {
        if (this.f3811e == i6) {
            return;
        }
        this.f3811e = i6;
        float f6 = i6 == 3 ? 0.2f : 1.0f;
        if (this.f3813g == f6) {
            return;
        }
        this.f3813g = f6;
        b bVar = this.f3809c;
        if (bVar != null) {
            bVar.v(f6);
        }
    }

    private boolean o(int i6) {
        return i6 == 1 || this.f3812f != 1;
    }

    private boolean q() {
        com.google.android.exoplayer2.audio.e eVar = this.f3810d;
        return eVar != null && eVar.f3352a == 1;
    }

    public float g() {
        return this.f3813g;
    }

    public void i() {
        this.f3809c = null;
        a();
    }

    public void m(com.google.android.exoplayer2.audio.e eVar) {
        if (com.google.android.exoplayer2.util.s0.c(this.f3810d, eVar)) {
            return;
        }
        this.f3810d = eVar;
        int e6 = e(eVar);
        this.f3812f = e6;
        boolean z5 = true;
        if (e6 != 1 && e6 != 0) {
            z5 = false;
        }
        com.google.android.exoplayer2.util.a.b(z5, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public int p(boolean z5, int i6) {
        if (o(i6)) {
            a();
            return z5 ? 1 : -1;
        } else if (z5) {
            return j();
        } else {
            return -1;
        }
    }
}
