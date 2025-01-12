package e;

import j$.util.function.Function;
import java.io.Serializable;
import java.util.Comparator;
/* renamed from: e.j$d  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0230j$d implements Comparator, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f9283a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator f9284b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9285c;

    public /* synthetic */ C0230j$d(Comparator comparator, Object obj, int i6) {
        this.f9283a = i6;
        this.f9284b = comparator;
        this.f9285c = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9283a) {
            case 0:
                Comparator comparator = this.f9284b;
                Comparator comparator2 = (Comparator) this.f9285c;
                int compare = comparator.compare(obj, obj2);
                return compare != 0 ? compare : comparator2.compare(obj, obj2);
            default:
                Comparator comparator3 = this.f9284b;
                Function function = (Function) this.f9285c;
                return comparator3.compare(function.a(obj), function.a(obj2));
        }
    }
}
