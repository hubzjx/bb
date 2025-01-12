package com.secret.prettyhezi;

import android.util.Log;
import com.secret.prettyhezi.Server.o;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    static com.google.gson.d f8488a = new com.google.gson.d();

    public static Object a(Object obj, Class cls) {
        com.google.gson.d dVar = f8488a;
        return dVar.i(dVar.r(obj), cls);
    }

    public static Object[] b(String str, Class cls) {
        return (Object[]) f8488a.i(str, cls);
    }

    public static com.secret.prettyhezi.Server.o c(String str, Class cls) {
        com.secret.prettyhezi.Server.o oVar = new com.secret.prettyhezi.Server.o();
        try {
            JSONObject jSONObject = new JSONObject(str);
            oVar.code = jSONObject.optInt("code");
            oVar.err = jSONObject.optString("err", null);
            if (jSONObject.has("data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                o.a aVar = new o.a();
                oVar.data = aVar;
                aVar.pages = jSONObject2.optInt("pages");
                oVar.data.total = jSONObject2.optInt("total");
                JSONArray optJSONArray = jSONObject2.optJSONArray("items");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    oVar.data.items = new com.secret.prettyhezi.Server.n[length];
                    for (int i6 = 0; i6 < length; i6++) {
                        oVar.data.items[i6] = (com.secret.prettyhezi.Server.n) f8488a.i(optJSONArray.getString(i6), cls);
                    }
                }
            }
        } catch (Exception e6) {
            Log.e("jsonToListResponse", e6.toString() + str);
        }
        return oVar;
    }

    public static Object d(String str, Class cls) {
        return f8488a.i(str, cls);
    }

    public static String e(Object obj) {
        return f8488a.r(obj);
    }
}
