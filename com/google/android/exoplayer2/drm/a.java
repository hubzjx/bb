package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.s0;
import io.jsonwebtoken.JwsHeader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
abstract class a {
    public static byte[] a(byte[] bArr) {
        return s0.f4673a >= 27 ? bArr : s0.h0(c(s0.E(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (s0.f4673a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(s0.E(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                if (i6 != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString(JwsHeader.KEY_ID)));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return s0.h0(sb.toString());
        } catch (JSONException e6) {
            String valueOf = String.valueOf(s0.E(bArr));
            com.google.android.exoplayer2.util.n.d("ClearKeyUtil", valueOf.length() != 0 ? "Failed to adjust response data: ".concat(valueOf) : new String("Failed to adjust response data: "), e6);
            return bArr;
        }
    }

    private static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
