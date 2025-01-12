package p2;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.q;
import java.util.Locale;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f12619a;

    public a(Resources resources) {
        this.f12619a = (Resources) com.google.android.exoplayer2.util.a.e(resources);
    }

    private String b(s0 s0Var) {
        Resources resources;
        int i6;
        int i7 = s0Var.A;
        if (i7 == -1 || i7 < 1) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (i7 == 1) {
            resources = this.f12619a;
            i6 = c.exo_track_mono;
        } else if (i7 == 2) {
            resources = this.f12619a;
            i6 = c.exo_track_stereo;
        } else if (i7 == 6 || i7 == 7) {
            resources = this.f12619a;
            i6 = c.exo_track_surround_5_point_1;
        } else if (i7 != 8) {
            resources = this.f12619a;
            i6 = c.exo_track_surround;
        } else {
            resources = this.f12619a;
            i6 = c.exo_track_surround_7_point_1;
        }
        return resources.getString(i6);
    }

    private String c(s0 s0Var) {
        int i6 = s0Var.f4052h;
        return i6 == -1 ? HttpUrl.FRAGMENT_ENCODE_SET : this.f12619a.getString(c.exo_track_bitrate, Float.valueOf(i6 / 1000000.0f));
    }

    private String d(s0 s0Var) {
        return TextUtils.isEmpty(s0Var.f4046b) ? HttpUrl.FRAGMENT_ENCODE_SET : s0Var.f4046b;
    }

    private String e(s0 s0Var) {
        String j6 = j(f(s0Var), h(s0Var));
        return TextUtils.isEmpty(j6) ? d(s0Var) : j6;
    }

    private String f(s0 s0Var) {
        String str = s0Var.f4047c;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return (com.google.android.exoplayer2.util.s0.f4673a >= 21 ? Locale.forLanguageTag(str) : new Locale(str)).getDisplayName();
    }

    private String g(s0 s0Var) {
        int i6 = s0Var.f4061s;
        int i7 = s0Var.f4062t;
        return (i6 == -1 || i7 == -1) ? HttpUrl.FRAGMENT_ENCODE_SET : this.f12619a.getString(c.exo_track_resolution, Integer.valueOf(i6), Integer.valueOf(i7));
    }

    private String h(s0 s0Var) {
        String string = (s0Var.f4049e & 2) != 0 ? this.f12619a.getString(c.exo_track_role_alternate) : HttpUrl.FRAGMENT_ENCODE_SET;
        if ((s0Var.f4049e & 4) != 0) {
            string = j(string, this.f12619a.getString(c.exo_track_role_supplementary));
        }
        if ((s0Var.f4049e & 8) != 0) {
            string = j(string, this.f12619a.getString(c.exo_track_role_commentary));
        }
        return (s0Var.f4049e & 1088) != 0 ? j(string, this.f12619a.getString(c.exo_track_role_closed_captions)) : string;
    }

    private static int i(s0 s0Var) {
        int j6 = q.j(s0Var.f4056n);
        if (j6 != -1) {
            return j6;
        }
        if (q.m(s0Var.f4053k) != null) {
            return 2;
        }
        if (q.b(s0Var.f4053k) != null) {
            return 1;
        }
        if (s0Var.f4061s == -1 && s0Var.f4062t == -1) {
            return (s0Var.A == -1 && s0Var.B == -1) ? -1 : 1;
        }
        return 2;
    }

    private String j(String... strArr) {
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                str = TextUtils.isEmpty(str) ? str2 : this.f12619a.getString(c.exo_item_list, str, str2);
            }
        }
        return str;
    }

    @Override // p2.e
    public String a(s0 s0Var) {
        int i6 = i(s0Var);
        String j6 = i6 == 2 ? j(h(s0Var), g(s0Var), c(s0Var)) : i6 == 1 ? j(e(s0Var), b(s0Var), c(s0Var)) : e(s0Var);
        return j6.length() == 0 ? this.f12619a.getString(c.exo_track_unknown) : j6;
    }
}
