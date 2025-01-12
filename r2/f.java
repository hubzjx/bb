package r2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
final class f {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f12970c = {"name", "length", "last_touch_timestamp"};

    /* renamed from: a  reason: collision with root package name */
    private final z0.b f12971a;

    /* renamed from: b  reason: collision with root package name */
    private String f12972b;

    public f(z0.b bVar) {
        this.f12971a = bVar;
    }

    private static void a(SQLiteDatabase sQLiteDatabase, String str) {
        String valueOf = String.valueOf(str);
        sQLiteDatabase.execSQL(valueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(valueOf) : new String("DROP TABLE IF EXISTS "));
    }

    private Cursor c() {
        com.google.android.exoplayer2.util.a.e(this.f12972b);
        return this.f12971a.getReadableDatabase().query(this.f12972b, f12970c, null, null, null, null, null);
    }

    private static String d(String str) {
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? "ExoPlayerCacheFileMetadata".concat(valueOf) : new String("ExoPlayerCacheFileMetadata");
    }

    public Map b() {
        try {
            Cursor c6 = c();
            HashMap hashMap = new HashMap(c6.getCount());
            while (c6.moveToNext()) {
                hashMap.put(c6.getString(0), new e(c6.getLong(1), c6.getLong(2)));
            }
            c6.close();
            return hashMap;
        } catch (SQLException e6) {
            throw new z0.a(e6);
        }
    }

    public void e(long j6) {
        try {
            String hexString = Long.toHexString(j6);
            this.f12972b = d(hexString);
            if (z0.d.b(this.f12971a.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f12971a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                z0.d.d(writableDatabase, 2, hexString, 1);
                a(writableDatabase, this.f12972b);
                String str = this.f12972b;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + androidx.constraintlayout.widget.g.Z0);
                sb.append("CREATE TABLE ");
                sb.append(str);
                sb.append(" ");
                sb.append("(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                writableDatabase.execSQL(sb.toString());
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (SQLException e6) {
            throw new z0.a(e6);
        }
    }

    public void f(String str) {
        com.google.android.exoplayer2.util.a.e(this.f12972b);
        try {
            this.f12971a.getWritableDatabase().delete(this.f12972b, "name = ?", new String[]{str});
        } catch (SQLException e6) {
            throw new z0.a(e6);
        }
    }

    public void g(Set set) {
        com.google.android.exoplayer2.util.a.e(this.f12972b);
        try {
            SQLiteDatabase writableDatabase = this.f12971a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                writableDatabase.delete(this.f12972b, "name = ?", new String[]{(String) it.next()});
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLException e6) {
            throw new z0.a(e6);
        }
    }

    public void h(String str, long j6, long j7) {
        com.google.android.exoplayer2.util.a.e(this.f12972b);
        try {
            SQLiteDatabase writableDatabase = this.f12971a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j6));
            contentValues.put("last_touch_timestamp", Long.valueOf(j7));
            writableDatabase.replaceOrThrow(this.f12972b, null, contentValues);
        } catch (SQLException e6) {
            throw new z0.a(e6);
        }
    }
}
