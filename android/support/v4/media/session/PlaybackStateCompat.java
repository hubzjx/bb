package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f197a;

    /* renamed from: b  reason: collision with root package name */
    final long f198b;

    /* renamed from: c  reason: collision with root package name */
    final long f199c;

    /* renamed from: d  reason: collision with root package name */
    final float f200d;

    /* renamed from: e  reason: collision with root package name */
    final long f201e;

    /* renamed from: f  reason: collision with root package name */
    final int f202f;

    /* renamed from: g  reason: collision with root package name */
    final CharSequence f203g;

    /* renamed from: h  reason: collision with root package name */
    final long f204h;

    /* renamed from: k  reason: collision with root package name */
    List f205k;

    /* renamed from: l  reason: collision with root package name */
    final long f206l;

    /* renamed from: m  reason: collision with root package name */
    final Bundle f207m;

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f208a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f209b;

        /* renamed from: c  reason: collision with root package name */
        private final int f210c;

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f211d;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public CustomAction[] newArray(int i6) {
                return new CustomAction[i6];
            }
        }

        CustomAction(Parcel parcel) {
            this.f208a = parcel.readString();
            this.f209b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f210c = parcel.readInt();
            this.f211d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f209b) + ", mIcon=" + this.f210c + ", mExtras=" + this.f211d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeString(this.f208a);
            TextUtils.writeToParcel(this.f209b, parcel, i6);
            parcel.writeInt(this.f210c);
            parcel.writeBundle(this.f211d);
        }
    }

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i6) {
            return new PlaybackStateCompat[i6];
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f197a = parcel.readInt();
        this.f198b = parcel.readLong();
        this.f200d = parcel.readFloat();
        this.f204h = parcel.readLong();
        this.f199c = parcel.readLong();
        this.f201e = parcel.readLong();
        this.f203g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f205k = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f206l = parcel.readLong();
        this.f207m = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f202f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f197a + ", position=" + this.f198b + ", buffered position=" + this.f199c + ", speed=" + this.f200d + ", updated=" + this.f204h + ", actions=" + this.f201e + ", error code=" + this.f202f + ", error message=" + this.f203g + ", custom actions=" + this.f205k + ", active item id=" + this.f206l + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f197a);
        parcel.writeLong(this.f198b);
        parcel.writeFloat(this.f200d);
        parcel.writeLong(this.f204h);
        parcel.writeLong(this.f199c);
        parcel.writeLong(this.f201e);
        TextUtils.writeToParcel(this.f203g, parcel, i6);
        parcel.writeTypedList(this.f205k);
        parcel.writeLong(this.f206l);
        parcel.writeBundle(this.f207m);
        parcel.writeInt(this.f202f);
    }
}
