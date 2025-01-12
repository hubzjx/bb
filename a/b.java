package a;

import a.a;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final boolean f3a = false;

    /* renamed from: b  reason: collision with root package name */
    final Handler f4b = null;

    /* renamed from: c  reason: collision with root package name */
    a.a f5c;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b[] newArray(int i6) {
            return new b[i6];
        }
    }

    /* renamed from: a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class BinderC0002b extends a.AbstractBinderC0000a {
        BinderC0002b() {
        }

        @Override // a.a
        public void m(int i6, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f4b;
            if (handler != null) {
                handler.post(new c(i6, bundle));
            } else {
                bVar.e(i6, bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final int f7a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f8b;

        c(int i6, Bundle bundle) {
            this.f7a = i6;
            this.f8b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.e(this.f7a, this.f8b);
        }
    }

    b(Parcel parcel) {
        this.f5c = a.AbstractBinderC0000a.o(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void e(int i6, Bundle bundle) {
    }

    public void f(int i6, Bundle bundle) {
        if (this.f3a) {
            Handler handler = this.f4b;
            if (handler != null) {
                handler.post(new c(i6, bundle));
                return;
            } else {
                e(i6, bundle);
                return;
            }
        }
        a.a aVar = this.f5c;
        if (aVar != null) {
            try {
                aVar.m(i6, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        synchronized (this) {
            if (this.f5c == null) {
                this.f5c = new BinderC0002b();
            }
            parcel.writeStrongBinder(this.f5c.asBinder());
        }
    }
}
