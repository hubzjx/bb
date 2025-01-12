package androidx.lifecycle;

import androidx.lifecycle.c;
/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements d {

    /* renamed from: a  reason: collision with root package name */
    private final d f1957a;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1958a;

        static {
            int[] iArr = new int[c.a.values().length];
            f1958a = iArr;
            try {
                iArr[c.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1958a[c.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1958a[c.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1958a[c.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1958a[c.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1958a[c.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1958a[c.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // androidx.lifecycle.d
    public void a(f fVar, c.a aVar) {
        switch (a.f1958a[aVar.ordinal()]) {
            case 1:
                throw null;
            case 2:
                throw null;
            case 3:
                throw null;
            case 4:
                throw null;
            case 5:
                throw null;
            case 6:
                throw null;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                d dVar = this.f1957a;
                if (dVar != null) {
                    dVar.a(fVar, aVar);
                    return;
                }
                return;
        }
    }
}
