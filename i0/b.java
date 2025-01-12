package i0;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes.dex */
abstract class b {

    /* loaded from: classes.dex */
    public interface a {
        void a(Object obj, Rect rect);
    }

    /* renamed from: i0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0176b {
        Object a(Object obj, int i6);

        int b(Object obj);
    }

    /* loaded from: classes.dex */
    private static class c implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f10842a = new Rect();

        /* renamed from: b  reason: collision with root package name */
        private final Rect f10843b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final boolean f10844c;

        /* renamed from: d  reason: collision with root package name */
        private final a f10845d;

        c(boolean z5, a aVar) {
            this.f10844c = z5;
            this.f10845d = aVar;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            Rect rect = this.f10842a;
            Rect rect2 = this.f10843b;
            this.f10845d.a(obj, rect);
            this.f10845d.a(obj2, rect2);
            int i6 = rect.top;
            int i7 = rect2.top;
            if (i6 < i7) {
                return -1;
            }
            if (i6 > i7) {
                return 1;
            }
            int i8 = rect.left;
            int i9 = rect2.left;
            if (i8 < i9) {
                return this.f10844c ? 1 : -1;
            } else if (i8 > i9) {
                return this.f10844c ? -1 : 1;
            } else {
                int i10 = rect.bottom;
                int i11 = rect2.bottom;
                if (i10 < i11) {
                    return -1;
                }
                if (i10 > i11) {
                    return 1;
                }
                int i12 = rect.right;
                int i13 = rect2.right;
                if (i12 < i13) {
                    return this.f10844c ? 1 : -1;
                } else if (i12 > i13) {
                    return this.f10844c ? -1 : 1;
                } else {
                    return 0;
                }
            }
        }
    }

    private static boolean a(int i6, Rect rect, Rect rect2, Rect rect3) {
        boolean b6 = b(i6, rect, rect2);
        if (b(i6, rect, rect3) || !b6) {
            return false;
        }
        return !j(i6, rect, rect3) || i6 == 17 || i6 == 66 || k(i6, rect, rect2) < m(i6, rect, rect3);
    }

    private static boolean b(int i6, Rect rect, Rect rect2) {
        if (i6 != 17) {
            if (i6 != 33) {
                if (i6 != 66) {
                    if (i6 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object c(Object obj, InterfaceC0176b interfaceC0176b, a aVar, Object obj2, Rect rect, int i6) {
        int width;
        int b6;
        int height;
        Rect rect2 = new Rect(rect);
        if (i6 != 17) {
            if (i6 == 33) {
                height = rect.height() + 1;
            } else if (i6 == 66) {
                width = -(rect.width() + 1);
            } else if (i6 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            } else {
                height = -(rect.height() + 1);
            }
            rect2.offset(0, height);
            b6 = interfaceC0176b.b(obj);
            Rect rect3 = new Rect();
            Object obj3 = null;
            for (int i7 = 0; i7 < b6; i7++) {
                Object a6 = interfaceC0176b.a(obj, i7);
                if (a6 != obj2) {
                    aVar.a(a6, rect3);
                    if (h(i6, rect, rect3, rect2)) {
                        rect2.set(rect3);
                        obj3 = a6;
                    }
                }
            }
            return obj3;
        }
        width = rect.width() + 1;
        rect2.offset(width, 0);
        b6 = interfaceC0176b.b(obj);
        Rect rect32 = new Rect();
        Object obj32 = null;
        while (i7 < b6) {
        }
        return obj32;
    }

    public static Object d(Object obj, InterfaceC0176b interfaceC0176b, a aVar, Object obj2, int i6, boolean z5, boolean z6) {
        int b6 = interfaceC0176b.b(obj);
        ArrayList arrayList = new ArrayList(b6);
        for (int i7 = 0; i7 < b6; i7++) {
            arrayList.add(interfaceC0176b.a(obj, i7));
        }
        Collections.sort(arrayList, new c(z5, aVar));
        if (i6 != 1) {
            if (i6 == 2) {
                return e(obj2, arrayList, z6);
            }
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        return f(obj2, arrayList, z6);
    }

    private static Object e(Object obj, ArrayList arrayList, boolean z5) {
        int size = arrayList.size();
        int lastIndexOf = (obj == null ? -1 : arrayList.lastIndexOf(obj)) + 1;
        if (lastIndexOf < size) {
            return arrayList.get(lastIndexOf);
        }
        if (!z5 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static Object f(Object obj, ArrayList arrayList, boolean z5) {
        int size = arrayList.size();
        int indexOf = (obj == null ? size : arrayList.indexOf(obj)) - 1;
        if (indexOf >= 0) {
            return arrayList.get(indexOf);
        }
        if (!z5 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int g(int i6, int i7) {
        return (i6 * 13 * i6) + (i7 * i7);
    }

    private static boolean h(int i6, Rect rect, Rect rect2, Rect rect3) {
        if (i(rect, rect2, i6)) {
            if (i(rect, rect3, i6) && !a(i6, rect, rect2, rect3)) {
                return !a(i6, rect, rect3, rect2) && g(k(i6, rect, rect2), o(i6, rect, rect2)) < g(k(i6, rect, rect3), o(i6, rect, rect3));
            }
            return true;
        }
        return false;
    }

    private static boolean i(Rect rect, Rect rect2, int i6) {
        if (i6 == 17) {
            int i7 = rect.right;
            int i8 = rect2.right;
            return (i7 > i8 || rect.left >= i8) && rect.left > rect2.left;
        } else if (i6 == 33) {
            int i9 = rect.bottom;
            int i10 = rect2.bottom;
            return (i9 > i10 || rect.top >= i10) && rect.top > rect2.top;
        } else if (i6 == 66) {
            int i11 = rect.left;
            int i12 = rect2.left;
            return (i11 < i12 || rect.right <= i12) && rect.right < rect2.right;
        } else if (i6 == 130) {
            int i13 = rect.top;
            int i14 = rect2.top;
            return (i13 < i14 || rect.bottom <= i14) && rect.bottom < rect2.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static boolean j(int i6, Rect rect, Rect rect2) {
        if (i6 == 17) {
            return rect.left >= rect2.right;
        } else if (i6 == 33) {
            return rect.top >= rect2.bottom;
        } else if (i6 == 66) {
            return rect.right <= rect2.left;
        } else if (i6 == 130) {
            return rect.bottom <= rect2.top;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static int k(int i6, Rect rect, Rect rect2) {
        return Math.max(0, l(i6, rect, rect2));
    }

    private static int l(int i6, Rect rect, Rect rect2) {
        int i7;
        int i8;
        if (i6 == 17) {
            i7 = rect.left;
            i8 = rect2.right;
        } else if (i6 == 33) {
            i7 = rect.top;
            i8 = rect2.bottom;
        } else if (i6 == 66) {
            i7 = rect2.left;
            i8 = rect.right;
        } else if (i6 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            i7 = rect2.top;
            i8 = rect.bottom;
        }
        return i7 - i8;
    }

    private static int m(int i6, Rect rect, Rect rect2) {
        return Math.max(1, n(i6, rect, rect2));
    }

    private static int n(int i6, Rect rect, Rect rect2) {
        int i7;
        int i8;
        if (i6 == 17) {
            i7 = rect.left;
            i8 = rect2.left;
        } else if (i6 == 33) {
            i7 = rect.top;
            i8 = rect2.top;
        } else if (i6 == 66) {
            i7 = rect2.right;
            i8 = rect.right;
        } else if (i6 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            i7 = rect2.bottom;
            i8 = rect.bottom;
        }
        return i7 - i8;
    }

    private static int o(int i6, Rect rect, Rect rect2) {
        int height;
        int i7;
        int height2;
        if (i6 != 17) {
            if (i6 != 33) {
                if (i6 != 66) {
                    if (i6 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            height = rect.left + (rect.width() / 2);
            i7 = rect2.left;
            height2 = rect2.width();
            return Math.abs(height - (i7 + (height2 / 2)));
        }
        height = rect.top + (rect.height() / 2);
        i7 = rect2.top;
        height2 = rect2.height();
        return Math.abs(height - (i7 + (height2 / 2)));
    }
}
