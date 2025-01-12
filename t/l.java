package t;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class l implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f13320a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Context f13321b;

    /* loaded from: classes.dex */
    public interface a {
        Intent e();
    }

    private l(Context context) {
        this.f13321b = context;
    }

    public static l d(Context context) {
        return new l(context);
    }

    public l a(Intent intent) {
        this.f13320a.add(intent);
        return this;
    }

    public l b(Activity activity) {
        Intent e6 = activity instanceof a ? ((a) activity).e() : null;
        if (e6 == null) {
            e6 = j.a(activity);
        }
        if (e6 != null) {
            ComponentName component = e6.getComponent();
            if (component == null) {
                component = e6.resolveActivity(this.f13321b.getPackageManager());
            }
            c(component);
            a(e6);
        }
        return this;
    }

    public l c(ComponentName componentName) {
        int size = this.f13320a.size();
        try {
            Context context = this.f13321b;
            while (true) {
                Intent b6 = j.b(context, componentName);
                if (b6 == null) {
                    return this;
                }
                this.f13320a.add(size, b6);
                context = this.f13321b;
                componentName = b6.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e6) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e6);
        }
    }

    public void e() {
        f(null);
    }

    public void f(Bundle bundle) {
        if (this.f13320a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList arrayList = this.f13320a;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (u.c.h(this.f13321b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f13321b.startActivity(intent);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f13320a.iterator();
    }
}
