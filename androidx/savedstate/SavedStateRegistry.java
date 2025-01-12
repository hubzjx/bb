package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.c;
import androidx.lifecycle.d;
import androidx.lifecycle.f;
import java.util.Map;
import k.b;
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: b  reason: collision with root package name */
    private Bundle f2534b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2535c;

    /* renamed from: a  reason: collision with root package name */
    private k.b f2533a = new k.b();

    /* renamed from: d  reason: collision with root package name */
    boolean f2536d = true;

    /* loaded from: classes.dex */
    public interface a {
    }

    public Bundle a(String str) {
        if (this.f2535c) {
            Bundle bundle = this.f2534b;
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle(str);
                this.f2534b.remove(str);
                if (this.f2534b.isEmpty()) {
                    this.f2534b = null;
                }
                return bundle2;
            }
            return null;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(c cVar, Bundle bundle) {
        if (this.f2535c) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f2534b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        cVar.a(new d() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // androidx.lifecycle.d
            public void a(f fVar, c.a aVar) {
                SavedStateRegistry savedStateRegistry;
                boolean z5;
                if (aVar == c.a.ON_START) {
                    savedStateRegistry = SavedStateRegistry.this;
                    z5 = true;
                } else if (aVar != c.a.ON_STOP) {
                    return;
                } else {
                    savedStateRegistry = SavedStateRegistry.this;
                    z5 = false;
                }
                savedStateRegistry.f2536d = z5;
            }
        });
        this.f2535c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f2534b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        b.d c6 = this.f2533a.c();
        if (!c6.hasNext()) {
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
            return;
        }
        Map.Entry entry = (Map.Entry) c6.next();
        String str = (String) entry.getKey();
        android.support.v4.media.a.a(entry.getValue());
        throw null;
    }
}
