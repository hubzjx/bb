package q2;

import android.content.Context;
import com.google.android.exoplayer2.r0;
import q2.l;
/* loaded from: classes.dex */
public final class t implements l.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f12866a;

    /* renamed from: b  reason: collision with root package name */
    private final i0 f12867b;

    /* renamed from: c  reason: collision with root package name */
    private final l.a f12868c;

    public t(Context context) {
        this(context, r0.f4032a, (i0) null);
    }

    @Override // q2.l.a
    /* renamed from: b */
    public s a() {
        s sVar = new s(this.f12866a, this.f12868c.a());
        i0 i0Var = this.f12867b;
        if (i0Var != null) {
            sVar.i(i0Var);
        }
        return sVar;
    }

    public t(Context context, String str, i0 i0Var) {
        this(context, i0Var, new v(str, i0Var));
    }

    public t(Context context, i0 i0Var, l.a aVar) {
        this.f12866a = context.getApplicationContext();
        this.f12867b = i0Var;
        this.f12868c = aVar;
    }
}
