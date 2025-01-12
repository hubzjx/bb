package g;
/* renamed from: g.j$e  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0293j$e {

    /* renamed from: a  reason: collision with root package name */
    protected final int f10141a;

    /* renamed from: b  reason: collision with root package name */
    protected int f10142b;

    /* renamed from: c  reason: collision with root package name */
    protected int f10143c;

    /* renamed from: d  reason: collision with root package name */
    protected long[] f10144d;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0293j$e() {
        this.f10141a = 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0293j$e(int i6) {
        if (i6 >= 0) {
            this.f10141a = Math.max(4, 32 - Integer.numberOfLeadingZeros(i6 - 1));
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i6);
    }

    public abstract void clear();

    public final long count() {
        int i6 = this.f10143c;
        return i6 == 0 ? this.f10142b : this.f10144d[i6] + this.f10142b;
    }
}
