package androidx.media;

import android.media.session.MediaSessionManager;
/* loaded from: classes.dex */
final class j implements f {

    /* renamed from: a  reason: collision with root package name */
    final MediaSessionManager.RemoteUserInfo f2113a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, int i6, int i7) {
        i.a();
        this.f2113a = h.a(str, i6, i7);
    }

    public boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        if (obj instanceof j) {
            equals = this.f2113a.equals(((j) obj).f2113a);
            return equals;
        }
        return false;
    }

    public int hashCode() {
        return d0.d.b(this.f2113a);
    }
}
