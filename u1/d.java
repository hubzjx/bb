package u1;

import android.net.Uri;
import java.io.InputStream;
import java.util.List;
import q2.f0;
/* loaded from: classes.dex */
public final class d implements f0.a {

    /* renamed from: a  reason: collision with root package name */
    private final f0.a f13426a;

    /* renamed from: b  reason: collision with root package name */
    private final List f13427b;

    public d(f0.a aVar, List list) {
        this.f13426a = aVar;
        this.f13427b = list;
    }

    @Override // q2.f0.a
    /* renamed from: b */
    public c a(Uri uri, InputStream inputStream) {
        c cVar = (c) this.f13426a.a(uri, inputStream);
        List list = this.f13427b;
        return (list == null || list.isEmpty()) ? cVar : (c) cVar.a(this.f13427b);
    }
}
