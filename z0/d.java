package z0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public abstract class d {
    private static String[] a(int i6, String str) {
        return new String[]{Integer.toString(i6), str};
    }

    public static int b(SQLiteDatabase sQLiteDatabase, int i6, String str) {
        try {
            if (s0.P0(sQLiteDatabase, "ExoPlayerVersions")) {
                Cursor query = sQLiteDatabase.query("ExoPlayerVersions", new String[]{"version"}, "feature = ? AND instance_uid = ?", a(i6, str), null, null, null);
                if (query.getCount() == 0) {
                    query.close();
                    return -1;
                }
                query.moveToNext();
                int i7 = query.getInt(0);
                query.close();
                return i7;
            }
            return -1;
        } catch (SQLException e6) {
            throw new a(e6);
        }
    }

    public static void c(SQLiteDatabase sQLiteDatabase, int i6, String str) {
        try {
            if (s0.P0(sQLiteDatabase, "ExoPlayerVersions")) {
                sQLiteDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", a(i6, str));
            }
        } catch (SQLException e6) {
            throw new a(e6);
        }
    }

    public static void d(SQLiteDatabase sQLiteDatabase, int i6, String str, int i7) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues = new ContentValues();
            contentValues.put("feature", Integer.valueOf(i6));
            contentValues.put("instance_uid", str);
            contentValues.put("version", Integer.valueOf(i7));
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", null, contentValues);
        } catch (SQLException e6) {
            throw new a(e6);
        }
    }
}
