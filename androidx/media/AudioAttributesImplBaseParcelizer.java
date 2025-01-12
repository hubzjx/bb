package androidx.media;
/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(androidx.versionedparcelable.a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f2015a = aVar.p(audioAttributesImplBase.f2015a, 1);
        audioAttributesImplBase.f2016b = aVar.p(audioAttributesImplBase.f2016b, 2);
        audioAttributesImplBase.f2017c = aVar.p(audioAttributesImplBase.f2017c, 3);
        audioAttributesImplBase.f2018d = aVar.p(audioAttributesImplBase.f2018d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.F(audioAttributesImplBase.f2015a, 1);
        aVar.F(audioAttributesImplBase.f2016b, 2);
        aVar.F(audioAttributesImplBase.f2017c, 3);
        aVar.F(audioAttributesImplBase.f2018d, 4);
    }
}
