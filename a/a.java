package a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0000a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0001a implements a {

            /* renamed from: b  reason: collision with root package name */
            public static a f1b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f2a;

            C0001a(IBinder iBinder) {
                this.f2a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2a;
            }

            @Override // a.a
            public void m(int i6, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    obtain.writeInt(i6);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f2a.transact(1, obtain, null, 1) || AbstractBinderC0000a.p() == null) {
                        return;
                    }
                    AbstractBinderC0000a.p().m(i6, bundle);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0000a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0001a(iBinder) : (a) queryLocalInterface;
        }

        public static a p() {
            return C0001a.f1b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                m(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i6 != 1598968902) {
                return super.onTransact(i6, parcel, parcel2, i7);
            } else {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
        }
    }

    void m(int i6, Bundle bundle);
}
