package androidx.media;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class AudioAttributesCompat implements o0.a {

    /* renamed from: b  reason: collision with root package name */
    private static final SparseIntArray f2010b;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f2011c;

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributesImpl f2012a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2010b = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
        f2011c = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(boolean z5, int i6, int i7) {
        if ((i6 & 1) == 1) {
            return z5 ? 1 : 7;
        } else if ((i6 & 4) == 4) {
            return z5 ? 0 : 6;
        } else {
            switch (i7) {
                case 0:
                    return z5 ? Integer.MIN_VALUE : 3;
                case 1:
                case 12:
                case 14:
                case 16:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return z5 ? 0 : 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 11:
                    return 10;
                case 13:
                    return 1;
                case 15:
                default:
                    if (z5) {
                        throw new IllegalArgumentException("Unknown usage value " + i7 + " in audio attributes");
                    }
                    return 3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(int i6) {
        switch (i6) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 15:
            default:
                return "unknown usage " + i6;
            case 16:
                return "USAGE_ASSISTANT";
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesCompat) {
            AudioAttributesImpl audioAttributesImpl = this.f2012a;
            AudioAttributesImpl audioAttributesImpl2 = ((AudioAttributesCompat) obj).f2012a;
            return audioAttributesImpl == null ? audioAttributesImpl2 == null : audioAttributesImpl.equals(audioAttributesImpl2);
        }
        return false;
    }

    public int hashCode() {
        return this.f2012a.hashCode();
    }

    public String toString() {
        return this.f2012a.toString();
    }
}
