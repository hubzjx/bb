package f0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private final int f9729a;

    /* renamed from: b  reason: collision with root package name */
    private final y f9730b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9731c;

    public a(int i6, y yVar, int i7) {
        this.f9729a = i6;
        this.f9730b = yVar;
        this.f9731c = i7;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f9729a);
        this.f9730b.N(this.f9731c, bundle);
    }
}
