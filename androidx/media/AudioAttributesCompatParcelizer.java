package androidx.media;
/* loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(androidx.versionedparcelable.a aVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f2012a = (AudioAttributesImpl) aVar.v(audioAttributesCompat.f2012a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.M(audioAttributesCompat.f2012a, 1);
    }
}
