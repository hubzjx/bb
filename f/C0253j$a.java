package f;

import java.util.Comparator;
/* renamed from: f.j$a  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0253j$a implements InterfaceC0255j$c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f9712a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator f9713b;

    public /* synthetic */ C0253j$a(Comparator comparator, int i6) {
        this.f9712a = i6;
        this.f9713b = comparator;
    }

    @Override // j$.util.function.BiFunction
    public final Object p(Object obj, Object obj2) {
        int i6 = this.f9712a;
        Comparator comparator = this.f9713b;
        switch (i6) {
            case 0:
                return comparator.compare(obj, obj2) >= 0 ? obj : obj2;
            default:
                return comparator.compare(obj, obj2) <= 0 ? obj : obj2;
        }
    }
}
