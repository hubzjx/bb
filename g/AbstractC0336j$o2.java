package g;

import java.util.Comparator;
/* renamed from: g.j$o2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0336j$o2 extends j$X1 {

    /* renamed from: b  reason: collision with root package name */
    protected final Comparator f10229b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f10230c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0336j$o2(InterfaceC0284j$b2 interfaceC0284j$b2, Comparator comparator) {
        super(interfaceC0284j$b2);
        this.f10229b = comparator;
    }

    @Override // g.j$X1, g.InterfaceC0284j$b2
    public final boolean o() {
        this.f10230c = true;
        return false;
    }
}
