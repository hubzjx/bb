package androidx.media;

import android.media.AudioAttributes;
/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributes f2013a;

    /* renamed from: b  reason: collision with root package name */
    public int f2014b = -1;

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f2013a.equals(((AudioAttributesImplApi21) obj).f2013a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2013a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2013a;
    }
}
