package g;

import java.util.Collections;
import java.util.EnumSet;
/* renamed from: g.j$k  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0317j$k {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f10187a = 0;

    static {
        EnumC0309j$i enumC0309j$i = EnumC0309j$i.CONCURRENT;
        EnumC0309j$i enumC0309j$i2 = EnumC0309j$i.UNORDERED;
        EnumC0309j$i enumC0309j$i3 = EnumC0309j$i.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(enumC0309j$i, enumC0309j$i2, enumC0309j$i3));
        Collections.unmodifiableSet(EnumSet.of(enumC0309j$i, enumC0309j$i2));
        Collections.unmodifiableSet(EnumSet.of(enumC0309j$i3));
        Collections.unmodifiableSet(EnumSet.of(enumC0309j$i2, enumC0309j$i3));
        Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(double[] dArr, double d6) {
        double d7 = d6 - dArr[1];
        double d8 = dArr[0];
        double d9 = d8 + d7;
        dArr[1] = (d9 - d8) - d7;
        dArr[0] = d9;
    }
}
