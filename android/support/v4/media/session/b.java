package android.support.v4.media.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: android.support.v4.media.session.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0007a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f212a;

            C0007a(IBinder iBinder) {
                this.f212a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f212a;
            }
        }

        public static b o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0007a(iBinder) : (b) queryLocalInterface;
        }
    }
}
