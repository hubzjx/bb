package h3;
/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: a  reason: collision with root package name */
    float f10651a = -1.0f;

    @Override // h3.d
    public void a(m mVar, float f6, float f7, float f8) {
        mVar.o(0.0f, f8 * f7, 180.0f, 180.0f - f6);
        double d6 = f8;
        double d7 = f7;
        mVar.m((float) (Math.sin(Math.toRadians(f6)) * d6 * d7), (float) (Math.sin(Math.toRadians(90.0f - f6)) * d6 * d7));
    }
}
