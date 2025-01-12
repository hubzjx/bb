package o2;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.s0;
import java.util.Locale;
/* loaded from: classes.dex */
public class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR;

    /* renamed from: f  reason: collision with root package name */
    public static final l f12463f;

    /* renamed from: g  reason: collision with root package name */
    public static final l f12464g;

    /* renamed from: a  reason: collision with root package name */
    public final String f12465a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12466b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12467c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f12468d;

    /* renamed from: e  reason: collision with root package name */
    public final int f12469e;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public l[] newArray(int i6) {
            return new l[i6];
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        String f12470a;

        /* renamed from: b  reason: collision with root package name */
        String f12471b;

        /* renamed from: c  reason: collision with root package name */
        int f12472c;

        /* renamed from: d  reason: collision with root package name */
        boolean f12473d;

        /* renamed from: e  reason: collision with root package name */
        int f12474e;

        public b() {
            this.f12470a = null;
            this.f12471b = null;
            this.f12472c = 0;
            this.f12473d = false;
            this.f12474e = 0;
        }

        private void c(Context context) {
            CaptioningManager captioningManager;
            if ((s0.f4673a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f12472c = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f12471b = s0.S(locale);
                }
            }
        }

        public l a() {
            return new l(this.f12470a, this.f12471b, this.f12472c, this.f12473d, this.f12474e);
        }

        public b b(Context context) {
            if (s0.f4673a >= 19) {
                c(context);
            }
            return this;
        }

        public b(Context context) {
            this();
            b(context);
        }
    }

    static {
        l a6 = new b().a();
        f12463f = a6;
        f12464g = a6;
        CREATOR = new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Parcel parcel) {
        this.f12465a = parcel.readString();
        this.f12466b = parcel.readString();
        this.f12467c = parcel.readInt();
        this.f12468d = s0.D0(parcel);
        this.f12469e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return TextUtils.equals(this.f12465a, lVar.f12465a) && TextUtils.equals(this.f12466b, lVar.f12466b) && this.f12467c == lVar.f12467c && this.f12468d == lVar.f12468d && this.f12469e == lVar.f12469e;
    }

    public int hashCode() {
        String str = this.f12465a;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f12466b;
        return ((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f12467c) * 31) + (this.f12468d ? 1 : 0)) * 31) + this.f12469e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f12465a);
        parcel.writeString(this.f12466b);
        parcel.writeInt(this.f12467c);
        s0.X0(parcel, this.f12468d);
        parcel.writeInt(this.f12469e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(String str, String str2, int i6, boolean z5, int i7) {
        this.f12465a = s0.v0(str);
        this.f12466b = s0.v0(str2);
        this.f12467c = i6;
        this.f12468d = z5;
        this.f12469e = i7;
    }
}
