package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c extends AbstractList implements List, q4.b {
    public abstract int a();

    public abstract Object b(int i6);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i6) {
        return b(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
