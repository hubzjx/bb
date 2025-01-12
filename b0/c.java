package b0;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import b0.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator f2851a = new a();

    /* loaded from: classes.dex */
    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i6 = 0; i6 < bArr.length; i6++) {
                byte b6 = bArr[i6];
                byte b7 = bArr2[i6];
                if (b6 != b7) {
                    return b6 - b7;
                }
            }
            return 0;
        }
    }

    private static List a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (!Arrays.equals((byte[]) list.get(i6), (byte[]) list2.get(i6))) {
                return false;
            }
        }
        return true;
    }

    private static List c(d dVar, Resources resources) {
        return dVar.b() != null ? dVar.b() : v.c.c(resources, dVar.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f.a d(Context context, d dVar, CancellationSignal cancellationSignal) {
        ProviderInfo e6 = e(context.getPackageManager(), dVar, context.getResources());
        return e6 == null ? f.a.a(1, null) : f.a.a(0, f(context, dVar, e6.authority, cancellationSignal));
    }

    static ProviderInfo e(PackageManager packageManager, d dVar, Resources resources) {
        String e6 = dVar.e();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e6, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + e6);
        } else if (!resolveContentProvider.packageName.equals(dVar.f())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + e6 + ", but package was not " + dVar.f());
        } else {
            List a6 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a6, f2851a);
            List c6 = c(dVar, resources);
            for (int i6 = 0; i6 < c6.size(); i6++) {
                ArrayList arrayList = new ArrayList((Collection) c6.get(i6));
                Collections.sort(arrayList, f2851a);
                if (b(a6, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        }
    }

    static f.b[] f(Context context, d dVar, String str, CancellationSignal cancellationSignal) {
        int i6;
        boolean z5;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{dVar.g()}, null, cancellationSignal);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i7 = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i8 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    int i9 = i7;
                    Uri withAppendedId = columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    int i10 = columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400;
                    if (columnIndex6 == -1 || cursor.getInt(columnIndex6) != 1) {
                        i6 = i9;
                        z5 = false;
                    } else {
                        i6 = i9;
                        z5 = true;
                    }
                    arrayList2.add(f.b.a(withAppendedId, i8, i10, z5, i6));
                }
                arrayList = arrayList2;
            }
            return (f.b[]) arrayList.toArray(new f.b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
