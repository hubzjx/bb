package e;

import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.Serializable;
import java.util.Comparator;
/* renamed from: e.j$c  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0229j$c implements Comparator, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f9281a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9282b;

    public /* synthetic */ C0229j$c(int i6, Object obj) {
        this.f9281a = i6;
        this.f9282b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9281a) {
            case 0:
                ToDoubleFunction toDoubleFunction = (ToDoubleFunction) this.f9282b;
                return Double.compare(toDoubleFunction.e(obj), toDoubleFunction.e(obj2));
            case 1:
                ToIntFunction toIntFunction = (ToIntFunction) this.f9282b;
                return Integer.compare(toIntFunction.a(obj), toIntFunction.a(obj2));
            case 2:
                ToLongFunction toLongFunction = (ToLongFunction) this.f9282b;
                return Long.compare(toLongFunction.c(obj), toLongFunction.c(obj2));
            default:
                Function function = (Function) this.f9282b;
                return ((Comparable) function.a(obj)).compareTo(function.a(obj2));
        }
    }
}
