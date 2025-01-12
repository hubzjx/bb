package n0;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class s {

    /* renamed from: b  reason: collision with root package name */
    public View f12174b;

    /* renamed from: a  reason: collision with root package name */
    public final Map f12173a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList f12175c = new ArrayList();

    public s(View view) {
        this.f12174b = view;
    }

    public boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            return this.f12174b == sVar.f12174b && this.f12173a.equals(sVar.f12173a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f12174b.hashCode() * 31) + this.f12173a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f12174b + "\n") + "    values:";
        for (String str2 : this.f12173a.keySet()) {
            str = str + "    " + str2 + ": " + this.f12173a.get(str2) + "\n";
        }
        return str;
    }
}
