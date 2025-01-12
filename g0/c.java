package g0;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: j  reason: collision with root package name */
    private int f10327j;

    /* renamed from: k  reason: collision with root package name */
    private int f10328k;

    /* renamed from: l  reason: collision with root package name */
    private LayoutInflater f10329l;

    public c(Context context, int i6, Cursor cursor, boolean z5) {
        super(context, cursor, z5);
        this.f10328k = i6;
        this.f10327j = i6;
        this.f10329l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // g0.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f10329l.inflate(this.f10328k, viewGroup, false);
    }

    @Override // g0.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f10329l.inflate(this.f10327j, viewGroup, false);
    }
}
