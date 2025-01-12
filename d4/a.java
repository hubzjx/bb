package d4;

import android.os.AsyncTask;
import com.secret.prettyhezi.j;
import g4.b;
import g4.c;
/* loaded from: classes.dex */
public abstract class a extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public static b f9200a = b.g();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str = strArr[0];
        String d6 = str.startsWith("/") ? str : f9200a.d(str);
        if (d6 != null) {
            return d6;
        }
        String n5 = c.n();
        if (j.e(str, n5) == 200) {
            return f9200a.a(str, n5, true);
        }
        return null;
    }
}
