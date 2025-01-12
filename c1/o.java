package c1;

import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public interface o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f3220a = new o() { // from class: c1.m
        @Override // c1.o
        public final i[] a() {
            return n.b();
        }

        @Override // c1.o
        public /* synthetic */ i[] b(Uri uri, Map map) {
            return n.a(this, uri, map);
        }
    };

    i[] a();

    i[] b(Uri uri, Map map);
}
