package s2;

import android.view.Surface;
/* loaded from: classes.dex */
public class f extends com.google.android.exoplayer2.mediacodec.i {
    public final boolean isSurfaceValid;
    public final int surfaceIdentityHashCode;

    public f(Throwable th, com.google.android.exoplayer2.mediacodec.j jVar, Surface surface) {
        super(th, jVar);
        this.surfaceIdentityHashCode = System.identityHashCode(surface);
        this.isSurfaceValid = surface == null || surface.isValid();
    }
}
