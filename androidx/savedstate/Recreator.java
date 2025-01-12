package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.c;
import androidx.lifecycle.d;
import androidx.lifecycle.f;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class Recreator implements d {

    /* renamed from: a  reason: collision with root package name */
    private final b f2532a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Recreator(b bVar) {
        this.f2532a = bVar;
    }

    private void b(String str) {
        Class cls;
        try {
            try {
                Constructor declaredConstructor = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.a.class).getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    android.support.v4.media.a.a(declaredConstructor.newInstance(new Object[0]));
                    throw null;
                } catch (Exception e6) {
                    throw new RuntimeException("Failed to instantiate " + str, e6);
                }
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e7);
            }
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("Class " + str + " wasn't found", e8);
        }
    }

    @Override // androidx.lifecycle.d
    public void a(f fVar, c.a aVar) {
        if (aVar != c.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        fVar.h().c(this);
        Bundle a6 = this.f2532a.b().a("androidx.savedstate.Restarter");
        if (a6 == null) {
            return;
        }
        ArrayList<String> stringArrayList = a6.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }
}
