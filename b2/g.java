package b2;

import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class g implements u1.c {

    /* renamed from: a  reason: collision with root package name */
    public final String f2985a;

    /* renamed from: b  reason: collision with root package name */
    public final List f2986b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f2987c;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(String str, List list, boolean z5) {
        this.f2985a = str;
        this.f2986b = Collections.unmodifiableList(list);
        this.f2987c = z5;
    }
}
