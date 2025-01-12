package r4;

import java.util.NoSuchElementException;
import kotlin.collections.a0;
/* loaded from: classes.dex */
public final class b extends a0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f13057a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13058b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13059c;

    /* renamed from: d  reason: collision with root package name */
    private int f13060d;

    public b(int i6, int i7, int i8) {
        this.f13057a = i8;
        this.f13058b = i7;
        boolean z5 = true;
        if (i8 <= 0 ? i6 < i7 : i6 > i7) {
            z5 = false;
        }
        this.f13059c = z5;
        this.f13060d = z5 ? i6 : i7;
    }

    @Override // kotlin.collections.a0
    public int a() {
        int i6 = this.f13060d;
        if (i6 != this.f13058b) {
            this.f13060d = this.f13057a + i6;
        } else if (!this.f13059c) {
            throw new NoSuchElementException();
        } else {
            this.f13059c = false;
        }
        return i6;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13059c;
    }
}
