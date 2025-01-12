package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
/* loaded from: classes.dex */
public abstract class MediaSessionCompat {

    /* loaded from: classes.dex */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final MediaDescriptionCompat f186a;

        /* renamed from: b  reason: collision with root package name */
        private final long f187b;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public QueueItem[] newArray(int i6) {
                return new QueueItem[i6];
            }
        }

        QueueItem(Parcel parcel) {
            this.f186a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f187b = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f186a + ", Id=" + this.f187b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            this.f186a.writeToParcel(parcel, i6);
            parcel.writeLong(this.f187b);
        }
    }

    /* loaded from: classes.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        ResultReceiver f188a;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public ResultReceiverWrapper[] newArray(int i6) {
                return new ResultReceiverWrapper[i6];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f188a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            this.f188a.writeToParcel(parcel, i6);
        }
    }

    /* loaded from: classes.dex */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final Object f189a;

        /* renamed from: b  reason: collision with root package name */
        private b f190b;

        /* renamed from: c  reason: collision with root package name */
        private Bundle f191c;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public Token[] newArray(int i6) {
                return new Token[i6];
            }
        }

        Token(Object obj) {
            this(obj, null, null);
        }

        public static Token e(Object obj) {
            return f(obj, null);
        }

        public static Token f(Object obj, b bVar) {
            if (obj != null) {
                return new Token(d.a(obj), bVar);
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Token) {
                Object obj2 = this.f189a;
                Object obj3 = ((Token) obj).f189a;
                if (obj2 == null) {
                    return obj3 == null;
                } else if (obj3 == null) {
                    return false;
                } else {
                    return obj2.equals(obj3);
                }
            }
            return false;
        }

        public b g() {
            return this.f190b;
        }

        public Object h() {
            return this.f189a;
        }

        public int hashCode() {
            Object obj = this.f189a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void i(b bVar) {
            this.f190b = bVar;
        }

        public void j(Bundle bundle) {
            this.f191c = bundle;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable((Parcelable) this.f189a, i6);
        }

        Token(Object obj, b bVar) {
            this(obj, bVar, null);
        }

        Token(Object obj, b bVar, Bundle bundle) {
            this.f189a = obj;
            this.f190b = bVar;
            this.f191c = bundle;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }
}
