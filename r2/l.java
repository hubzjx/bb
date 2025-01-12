package r2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.s0;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f12987a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray f12988b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseBooleanArray f12989c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseBooleanArray f12990d;

    /* renamed from: e  reason: collision with root package name */
    private c f12991e;

    /* renamed from: f  reason: collision with root package name */
    private c f12992f;

    /* loaded from: classes.dex */
    private static final class a implements c {

        /* renamed from: e  reason: collision with root package name */
        private static final String[] f12993e = {"id", "key", "metadata"};

        /* renamed from: a  reason: collision with root package name */
        private final z0.b f12994a;

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray f12995b = new SparseArray();

        /* renamed from: c  reason: collision with root package name */
        private String f12996c;

        /* renamed from: d  reason: collision with root package name */
        private String f12997d;

        public a(z0.b bVar) {
            this.f12994a = bVar;
        }

        private void i(SQLiteDatabase sQLiteDatabase, k kVar) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            l.t(kVar.c(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(kVar.f12980a));
            contentValues.put("key", kVar.f12981b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) com.google.android.exoplayer2.util.a.e(this.f12997d), null, contentValues);
        }

        private static void j(z0.b bVar, String str) {
            try {
                String n5 = n(str);
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                z0.d.c(writableDatabase, 1, str);
                l(writableDatabase, n5);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (SQLException e6) {
                throw new z0.a(e6);
            }
        }

        private void k(SQLiteDatabase sQLiteDatabase, int i6) {
            sQLiteDatabase.delete((String) com.google.android.exoplayer2.util.a.e(this.f12997d), "id = ?", new String[]{Integer.toString(i6)});
        }

        private static void l(SQLiteDatabase sQLiteDatabase, String str) {
            String valueOf = String.valueOf(str);
            sQLiteDatabase.execSQL(valueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(valueOf) : new String("DROP TABLE IF EXISTS "));
        }

        private Cursor m() {
            return this.f12994a.getReadableDatabase().query((String) com.google.android.exoplayer2.util.a.e(this.f12997d), f12993e, null, null, null, null, null);
        }

        private static String n(String str) {
            String valueOf = String.valueOf(str);
            return valueOf.length() != 0 ? "ExoPlayerCacheIndex".concat(valueOf) : new String("ExoPlayerCacheIndex");
        }

        private void o(SQLiteDatabase sQLiteDatabase) {
            z0.d.d(sQLiteDatabase, 1, (String) com.google.android.exoplayer2.util.a.e(this.f12996c), 1);
            l(sQLiteDatabase, (String) com.google.android.exoplayer2.util.a.e(this.f12997d));
            String str = this.f12997d;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 88);
            sb.append("CREATE TABLE ");
            sb.append(str);
            sb.append(" ");
            sb.append("(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
            sQLiteDatabase.execSQL(sb.toString());
        }

        @Override // r2.l.c
        public boolean a() {
            return z0.d.b(this.f12994a.getReadableDatabase(), 1, (String) com.google.android.exoplayer2.util.a.e(this.f12996c)) != -1;
        }

        @Override // r2.l.c
        public void b(HashMap hashMap) {
            if (this.f12995b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f12994a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i6 = 0; i6 < this.f12995b.size(); i6++) {
                    k kVar = (k) this.f12995b.valueAt(i6);
                    if (kVar == null) {
                        k(writableDatabase, this.f12995b.keyAt(i6));
                    } else {
                        i(writableDatabase, kVar);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f12995b.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e6) {
                throw new z0.a(e6);
            }
        }

        @Override // r2.l.c
        public void c(HashMap hashMap) {
            try {
                SQLiteDatabase writableDatabase = this.f12994a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                o(writableDatabase);
                for (k kVar : hashMap.values()) {
                    i(writableDatabase, kVar);
                }
                writableDatabase.setTransactionSuccessful();
                this.f12995b.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e6) {
                throw new z0.a(e6);
            }
        }

        @Override // r2.l.c
        public void d(long j6) {
            String hexString = Long.toHexString(j6);
            this.f12996c = hexString;
            this.f12997d = n(hexString);
        }

        @Override // r2.l.c
        public void e(k kVar) {
            this.f12995b.put(kVar.f12980a, kVar);
        }

        @Override // r2.l.c
        public void f(HashMap hashMap, SparseArray sparseArray) {
            com.google.android.exoplayer2.util.a.g(this.f12995b.size() == 0);
            try {
                if (z0.d.b(this.f12994a.getReadableDatabase(), 1, (String) com.google.android.exoplayer2.util.a.e(this.f12996c)) != 1) {
                    SQLiteDatabase writableDatabase = this.f12994a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    o(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                }
                Cursor m5 = m();
                while (m5.moveToNext()) {
                    k kVar = new k(m5.getInt(0), m5.getString(1), l.q(new DataInputStream(new ByteArrayInputStream(m5.getBlob(2)))));
                    hashMap.put(kVar.f12981b, kVar);
                    sparseArray.put(kVar.f12980a, kVar.f12981b);
                }
                m5.close();
            } catch (SQLiteException e6) {
                hashMap.clear();
                sparseArray.clear();
                throw new z0.a(e6);
            }
        }

        @Override // r2.l.c
        public void g(k kVar, boolean z5) {
            if (z5) {
                this.f12995b.delete(kVar.f12980a);
            } else {
                this.f12995b.put(kVar.f12980a, null);
            }
        }

        @Override // r2.l.c
        public void h() {
            j(this.f12994a, (String) com.google.android.exoplayer2.util.a.e(this.f12996c));
        }
    }

    /* loaded from: classes.dex */
    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f12998a;

        /* renamed from: b  reason: collision with root package name */
        private final Cipher f12999b;

        /* renamed from: c  reason: collision with root package name */
        private final SecretKeySpec f13000c;

        /* renamed from: d  reason: collision with root package name */
        private final SecureRandom f13001d;

        /* renamed from: e  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.b f13002e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f13003f;

        /* renamed from: g  reason: collision with root package name */
        private b0 f13004g;

        public b(File file, byte[] bArr, boolean z5) {
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            com.google.android.exoplayer2.util.a.g((bArr == null && z5) ? false : true);
            if (bArr != null) {
                com.google.android.exoplayer2.util.a.a(bArr.length == 16);
                try {
                    cipher = l.i();
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e6) {
                    throw new IllegalStateException(e6);
                }
            } else {
                com.google.android.exoplayer2.util.a.a(!z5);
                cipher = null;
                secretKeySpec = null;
            }
            this.f12998a = z5;
            this.f12999b = cipher;
            this.f13000c = secretKeySpec;
            this.f13001d = z5 ? new SecureRandom() : null;
            this.f13002e = new com.google.android.exoplayer2.util.b(file);
        }

        private int i(k kVar, int i6) {
            int hashCode = (kVar.f12980a * 31) + kVar.f12981b.hashCode();
            if (i6 < 2) {
                long a6 = m.a(kVar.c());
                return (hashCode * 31) + ((int) (a6 ^ (a6 >>> 32)));
            }
            return (hashCode * 31) + kVar.c().hashCode();
        }

        private k j(int i6, DataInputStream dataInputStream) {
            p q5;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i6 < 2) {
                long readLong = dataInputStream.readLong();
                o oVar = new o();
                o.g(oVar, readLong);
                q5 = p.f13007c.e(oVar);
            } else {
                q5 = l.q(dataInputStream);
            }
            return new k(readInt, readUTF, q5);
        }

        private boolean k(HashMap hashMap, SparseArray sparseArray) {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            if (this.f13002e.c()) {
                DataInputStream dataInputStream2 = null;
                try {
                    bufferedInputStream = new BufferedInputStream(this.f13002e.d());
                    dataInputStream = new DataInputStream(bufferedInputStream);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    int readInt = dataInputStream.readInt();
                    if (readInt >= 0 && readInt <= 2) {
                        if ((dataInputStream.readInt() & 1) != 0) {
                            if (this.f12999b == null) {
                                s0.n(dataInputStream);
                                return false;
                            }
                            byte[] bArr = new byte[16];
                            dataInputStream.readFully(bArr);
                            try {
                                this.f12999b.init(2, (Key) s0.j(this.f13000c), new IvParameterSpec(bArr));
                                dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f12999b));
                            } catch (InvalidAlgorithmParameterException e6) {
                                e = e6;
                                throw new IllegalStateException(e);
                            } catch (InvalidKeyException e7) {
                                e = e7;
                                throw new IllegalStateException(e);
                            }
                        } else if (this.f12998a) {
                            this.f13003f = true;
                        }
                        int readInt2 = dataInputStream.readInt();
                        int i6 = 0;
                        for (int i7 = 0; i7 < readInt2; i7++) {
                            k j6 = j(readInt, dataInputStream);
                            hashMap.put(j6.f12981b, j6);
                            sparseArray.put(j6.f12980a, j6.f12981b);
                            i6 += i(j6, readInt);
                        }
                        int readInt3 = dataInputStream.readInt();
                        boolean z5 = dataInputStream.read() == -1;
                        if (readInt3 == i6 && z5) {
                            s0.n(dataInputStream);
                            return true;
                        }
                        s0.n(dataInputStream);
                        return false;
                    }
                    s0.n(dataInputStream);
                    return false;
                } catch (IOException unused2) {
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        s0.n(dataInputStream2);
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        s0.n(dataInputStream2);
                    }
                    throw th;
                }
            }
            return true;
        }

        private void l(k kVar, DataOutputStream dataOutputStream) {
            dataOutputStream.writeInt(kVar.f12980a);
            dataOutputStream.writeUTF(kVar.f12981b);
            l.t(kVar.c(), dataOutputStream);
        }

        private void m(HashMap hashMap) {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream f6 = this.f13002e.f();
                b0 b0Var = this.f13004g;
                if (b0Var == null) {
                    this.f13004g = new b0(f6);
                } else {
                    b0Var.a(f6);
                }
                b0 b0Var2 = this.f13004g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(b0Var2);
                try {
                    dataOutputStream2.writeInt(2);
                    int i6 = 0;
                    dataOutputStream2.writeInt(this.f12998a ? 1 : 0);
                    if (this.f12998a) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) s0.j(this.f13001d)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            ((Cipher) s0.j(this.f12999b)).init(1, (Key) s0.j(this.f13000c), new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(b0Var2, this.f12999b));
                        } catch (InvalidAlgorithmParameterException e6) {
                            e = e6;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e7) {
                            e = e7;
                            throw new IllegalStateException(e);
                        }
                    }
                    dataOutputStream2.writeInt(hashMap.size());
                    for (k kVar : hashMap.values()) {
                        l(kVar, dataOutputStream2);
                        i6 += i(kVar, 2);
                    }
                    dataOutputStream2.writeInt(i6);
                    this.f13002e.b(dataOutputStream2);
                    s0.n(null);
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    s0.n(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // r2.l.c
        public boolean a() {
            return this.f13002e.c();
        }

        @Override // r2.l.c
        public void b(HashMap hashMap) {
            if (this.f13003f) {
                c(hashMap);
            }
        }

        @Override // r2.l.c
        public void c(HashMap hashMap) {
            m(hashMap);
            this.f13003f = false;
        }

        @Override // r2.l.c
        public void d(long j6) {
        }

        @Override // r2.l.c
        public void e(k kVar) {
            this.f13003f = true;
        }

        @Override // r2.l.c
        public void f(HashMap hashMap, SparseArray sparseArray) {
            com.google.android.exoplayer2.util.a.g(!this.f13003f);
            if (k(hashMap, sparseArray)) {
                return;
            }
            hashMap.clear();
            sparseArray.clear();
            this.f13002e.a();
        }

        @Override // r2.l.c
        public void g(k kVar, boolean z5) {
            this.f13003f = true;
        }

        @Override // r2.l.c
        public void h() {
            this.f13002e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        boolean a();

        void b(HashMap hashMap);

        void c(HashMap hashMap);

        void d(long j6);

        void e(k kVar);

        void f(HashMap hashMap, SparseArray sparseArray);

        void g(k kVar, boolean z5);

        void h();
    }

    public l(z0.b bVar, File file, byte[] bArr, boolean z5, boolean z6) {
        com.google.android.exoplayer2.util.a.g((bVar == null && file == null) ? false : true);
        this.f12987a = new HashMap();
        this.f12988b = new SparseArray();
        this.f12989c = new SparseBooleanArray();
        this.f12990d = new SparseBooleanArray();
        a aVar = bVar != null ? new a(bVar) : null;
        b bVar2 = file != null ? new b(new File(file, "cached_content_index.exi"), bArr, z5) : null;
        if (aVar == null || (bVar2 != null && z6)) {
            this.f12991e = (c) s0.j(bVar2);
            this.f12992f = aVar;
            return;
        }
        this.f12991e = aVar;
        this.f12992f = bVar2;
    }

    private k d(String str) {
        int l6 = l(this.f12988b);
        k kVar = new k(l6, str);
        this.f12987a.put(str, kVar);
        this.f12988b.put(l6, str);
        this.f12990d.put(l6, true);
        this.f12991e.e(kVar);
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher i() {
        if (s0.f4673a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    static int l(SparseArray sparseArray) {
        int size = sparseArray.size();
        int i6 = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt < 0) {
            while (i6 < size && i6 == sparseArray.keyAt(i6)) {
                i6++;
            }
            return i6;
        }
        return keyAt;
    }

    public static boolean o(String str) {
        return str.startsWith("cached_content_index.exi");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static p q(DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i6 = 0; i6 < readInt; i6++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 < 0) {
                StringBuilder sb = new StringBuilder(31);
                sb.append("Invalid value size: ");
                sb.append(readInt2);
                throw new IOException(sb.toString());
            }
            int min = Math.min(readInt2, 10485760);
            byte[] bArr = s0.f4678f;
            int i7 = 0;
            while (i7 != readInt2) {
                int i8 = i7 + min;
                bArr = Arrays.copyOf(bArr, i8);
                dataInputStream.readFully(bArr, i7, min);
                min = Math.min(readInt2 - i8, 10485760);
                i7 = i8;
            }
            hashMap.put(readUTF, bArr);
        }
        return new p(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(p pVar, DataOutputStream dataOutputStream) {
        Set<Map.Entry> f6 = pVar.f();
        dataOutputStream.writeInt(f6.size());
        for (Map.Entry entry : f6) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public void e(String str, o oVar) {
        k m5 = m(str);
        if (m5.b(oVar)) {
            this.f12991e.e(m5);
        }
    }

    public int f(String str) {
        return m(str).f12980a;
    }

    public k g(String str) {
        return (k) this.f12987a.get(str);
    }

    public Collection h() {
        return Collections.unmodifiableCollection(this.f12987a.values());
    }

    public n j(String str) {
        k g6 = g(str);
        return g6 != null ? g6.c() : p.f13007c;
    }

    public String k(int i6) {
        return (String) this.f12988b.get(i6);
    }

    public k m(String str) {
        k kVar = (k) this.f12987a.get(str);
        return kVar == null ? d(str) : kVar;
    }

    public void n(long j6) {
        c cVar;
        this.f12991e.d(j6);
        c cVar2 = this.f12992f;
        if (cVar2 != null) {
            cVar2.d(j6);
        }
        if (this.f12991e.a() || (cVar = this.f12992f) == null || !cVar.a()) {
            this.f12991e.f(this.f12987a, this.f12988b);
        } else {
            this.f12992f.f(this.f12987a, this.f12988b);
            this.f12991e.c(this.f12987a);
        }
        c cVar3 = this.f12992f;
        if (cVar3 != null) {
            cVar3.h();
            this.f12992f = null;
        }
    }

    public void p(String str) {
        k kVar = (k) this.f12987a.get(str);
        if (kVar != null && kVar.f() && kVar.h()) {
            this.f12987a.remove(str);
            int i6 = kVar.f12980a;
            boolean z5 = this.f12990d.get(i6);
            this.f12991e.g(kVar, z5);
            SparseArray sparseArray = this.f12988b;
            if (z5) {
                sparseArray.remove(i6);
                this.f12990d.delete(i6);
                return;
            }
            sparseArray.put(i6, null);
            this.f12989c.put(i6, true);
        }
    }

    public void r() {
        int size = this.f12987a.size();
        String[] strArr = new String[size];
        this.f12987a.keySet().toArray(strArr);
        for (int i6 = 0; i6 < size; i6++) {
            p(strArr[i6]);
        }
    }

    public void s() {
        this.f12991e.b(this.f12987a);
        int size = this.f12989c.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f12988b.remove(this.f12989c.keyAt(i6));
        }
        this.f12989c.clear();
        this.f12990d.clear();
    }
}
