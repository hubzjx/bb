package androidx.media;

import android.media.AudioAttributes;
/* loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(androidx.versionedparcelable.a aVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f2013a = (AudioAttributes) aVar.r(audioAttributesImplApi21.f2013a, 1);
        audioAttributesImplApi21.f2014b = aVar.p(audioAttributesImplApi21.f2014b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.H(audioAttributesImplApi21.f2013a, 1);
        aVar.F(audioAttributesImplApi21.f2014b, 2);
    }
}
