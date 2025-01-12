package w;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import b0.f;
import java.io.IOException;
import v.c;
/* loaded from: classes.dex */
public class m0 extends n0 {
    @Override // w.n0
    public Typeface a(Context context, c.b bVar, Resources resources, int i6) {
        FontFamily build;
        Typeface.CustomFallbackBuilder style;
        Typeface build2;
        Font.Builder weight;
        Font.Builder slant;
        Font.Builder ttcIndex;
        Font.Builder fontVariationSettings;
        Font build3;
        try {
            c.C0219c[] a6 = bVar.a();
            int length = a6.length;
            FontFamily.Builder builder = null;
            int i7 = 0;
            while (true) {
                int i8 = 1;
                if (i7 >= length) {
                    break;
                }
                c.C0219c c0219c = a6[i7];
                try {
                    z.a();
                    weight = u.a(resources, c0219c.b()).setWeight(c0219c.e());
                    if (!c0219c.f()) {
                        i8 = 0;
                    }
                    slant = weight.setSlant(i8);
                    ttcIndex = slant.setTtcIndex(c0219c.c());
                    fontVariationSettings = ttcIndex.setFontVariationSettings(c0219c.d());
                    build3 = fontVariationSettings.build();
                    if (builder == null) {
                        b0.a();
                        builder = x.a(build3);
                    } else {
                        builder.addFont(build3);
                    }
                } catch (IOException unused) {
                }
                i7++;
            }
            if (builder == null) {
                return null;
            }
            y.a();
            FontStyle a7 = v.a((i6 & 1) != 0 ? 700 : 400, (i6 & 2) != 0 ? 1 : 0);
            a0.a();
            build = builder.build();
            style = w.a(build).setStyle(a7);
            build2 = style.build();
            return build2;
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // w.n0
    public Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i6) {
        int i7;
        FontFamily build;
        Typeface.CustomFallbackBuilder style;
        Typeface build2;
        ParcelFileDescriptor openFileDescriptor;
        Font.Builder weight;
        Font.Builder slant;
        Font.Builder ttcIndex;
        Font build3;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = bVarArr.length;
            FontFamily.Builder builder = null;
            while (true) {
                int i8 = 1;
                if (i7 >= length) {
                    if (builder == null) {
                        return null;
                    }
                    y.a();
                    FontStyle a6 = v.a((i6 & 1) != 0 ? 700 : 400, (i6 & 2) != 0 ? 1 : 0);
                    a0.a();
                    build = builder.build();
                    style = w.a(build).setStyle(a6);
                    build2 = style.build();
                    return build2;
                }
                f.b bVar = bVarArr[i7];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(bVar.d(), "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (openFileDescriptor != null) {
                    try {
                        z.a();
                        weight = c0.a(openFileDescriptor).setWeight(bVar.e());
                        if (!bVar.f()) {
                            i8 = 0;
                        }
                        slant = weight.setSlant(i8);
                        ttcIndex = slant.setTtcIndex(bVar.c());
                        build3 = ttcIndex.build();
                        if (builder == null) {
                            b0.a();
                            builder = x.a(build3);
                        } else {
                            builder.addFont(build3);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                        break;
                    }
                } else {
                    i7 = openFileDescriptor == null ? i7 + 1 : 0;
                }
                openFileDescriptor.close();
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // w.n0
    public Typeface d(Context context, Resources resources, int i6, String str, int i7) {
        Font build;
        FontFamily build2;
        FontStyle style;
        Typeface.CustomFallbackBuilder style2;
        Typeface build3;
        try {
            z.a();
            build = u.a(resources, i6).build();
            b0.a();
            build2 = x.a(build).build();
            a0.a();
            Typeface.CustomFallbackBuilder a6 = w.a(build2);
            style = build.getStyle();
            style2 = a6.setStyle(style);
            build3 = style2.build();
            return build3;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w.n0
    public f.b f(f.b[] bVarArr, int i6) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
