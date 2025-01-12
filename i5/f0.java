package i5;

import e5.q;
import g5.a;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f11035a = {0, 0, -92, -127};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f11036b = {0, 0, -19, 65};

    /* loaded from: classes.dex */
    class a implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f11037a;

        a(String str) {
            this.f11037a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f11037a + ".");
        }
    }

    private static void a(File file) {
        if (file.exists()) {
            return;
        }
        throw new a5.a("File does not exist: " + file);
    }

    public static void b(List list, q.a aVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (!q(file)) {
                a(file);
            } else if (aVar.equals(q.a.INCLUDE_LINK_AND_LINKED_FILE) || aVar.equals(q.a.INCLUDE_LINKED_FILE_ONLY)) {
                c(file);
            }
        }
    }

    private static void c(File file) {
        if (file.exists()) {
            return;
        }
        throw new a5.a("Symlink target '" + u(file) + "' does not exist for link '" + file + "'");
    }

    public static void d(RandomAccessFile randomAccessFile, OutputStream outputStream, long j6, long j7, g5.a aVar, int i6) {
        int i7;
        long j8 = 0;
        if (j6 < 0 || j7 < 0 || j6 > j7) {
            throw new a5.a("invalid offsets");
        }
        if (i7 == 0) {
            return;
        }
        try {
            randomAccessFile.seek(j6);
            long j9 = j7 - j6;
            byte[] bArr = j9 < ((long) i6) ? new byte[(int) j9] : new byte[i6];
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read == -1) {
                    return;
                }
                outputStream.write(bArr, 0, read);
                long j10 = read;
                aVar.l(j10);
                if (aVar.e()) {
                    aVar.i(a.EnumC0171a.CANCELLED);
                    return;
                }
                j8 += j10;
                if (j8 == j9) {
                    return;
                }
                if (bArr.length + j8 > j9) {
                    bArr = new byte[(int) (j9 - j8)];
                }
            }
        } catch (IOException e6) {
            throw new a5.a(e6);
        }
    }

    public static File[] e(File file) {
        File[] listFiles = file.getParentFile().listFiles(new a(i(file.getName())));
        if (listFiles == null) {
            return new File[0];
        }
        Arrays.sort(listFiles);
        return listFiles;
    }

    public static byte[] f(boolean z5) {
        byte[] bArr = new byte[4];
        if (r() || o()) {
            if (z5) {
                System.arraycopy(f11036b, 0, bArr, 0, 4);
            } else {
                System.arraycopy(f11035a, 0, bArr, 0, 4);
            }
        } else if (s() && z5) {
            bArr[0] = i5.a.b(bArr[0], 4);
        }
        return bArr;
    }

    public static byte[] g(File file) {
        Path path;
        boolean isSymbolicLink;
        Path path2;
        if (file != null) {
            try {
                path = file.toPath();
                isSymbolicLink = Files.isSymbolicLink(path);
                if (isSymbolicLink || file.exists()) {
                    path2 = file.toPath();
                    if (s()) {
                        return m(path2);
                    }
                    if (!o() && !r()) {
                        return new byte[4];
                    }
                    return k(path2);
                }
            } catch (NoSuchMethodError unused) {
                return new byte[4];
            }
        }
        return new byte[4];
    }

    public static String h(File file) {
        String name = file.getName();
        return !name.contains(".") ? HttpUrl.FRAGMENT_ENCODE_SET : name.substring(name.lastIndexOf(".") + 1);
    }

    public static String i(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    private static String j(File file, String str) {
        Path path;
        LinkOption linkOption;
        Path realPath;
        Path fileName;
        String path2;
        if (i0.d(str)) {
            return str;
        }
        if (q(file)) {
            path = file.toPath();
            linkOption = LinkOption.NOFOLLOW_LINKS;
            realPath = path.toRealPath(linkOption);
            fileName = realPath.getFileName();
            path2 = fileName.toString();
            return path2;
        }
        return file.getName();
    }

    private static byte[] k(Path path) {
        LinkOption linkOption;
        FileAttributeView fileAttributeView;
        PosixFileAttributes readAttributes;
        Set permissions;
        boolean isRegularFile;
        boolean isDirectory;
        boolean isSymbolicLink;
        PosixFilePermission posixFilePermission;
        PosixFilePermission posixFilePermission2;
        PosixFilePermission posixFilePermission3;
        PosixFilePermission posixFilePermission4;
        PosixFilePermission posixFilePermission5;
        PosixFilePermission posixFilePermission6;
        PosixFilePermission posixFilePermission7;
        PosixFilePermission posixFilePermission8;
        PosixFilePermission posixFilePermission9;
        byte[] bArr = new byte[4];
        try {
            linkOption = LinkOption.NOFOLLOW_LINKS;
            fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class, linkOption);
            readAttributes = q.a(fileAttributeView).readAttributes();
            permissions = readAttributes.permissions();
            isRegularFile = Files.isRegularFile(path, new LinkOption[0]);
            bArr[3] = v(isRegularFile, bArr[3], 7);
            isDirectory = Files.isDirectory(path, new LinkOption[0]);
            bArr[3] = v(isDirectory, bArr[3], 6);
            isSymbolicLink = Files.isSymbolicLink(path);
            bArr[3] = v(isSymbolicLink, bArr[3], 5);
            posixFilePermission = PosixFilePermission.OWNER_READ;
            bArr[3] = v(permissions.contains(posixFilePermission), bArr[3], 0);
            posixFilePermission2 = PosixFilePermission.OWNER_WRITE;
            bArr[2] = v(permissions.contains(posixFilePermission2), bArr[2], 7);
            posixFilePermission3 = PosixFilePermission.OWNER_EXECUTE;
            bArr[2] = v(permissions.contains(posixFilePermission3), bArr[2], 6);
            posixFilePermission4 = PosixFilePermission.GROUP_READ;
            bArr[2] = v(permissions.contains(posixFilePermission4), bArr[2], 5);
            posixFilePermission5 = PosixFilePermission.GROUP_WRITE;
            bArr[2] = v(permissions.contains(posixFilePermission5), bArr[2], 4);
            posixFilePermission6 = PosixFilePermission.GROUP_EXECUTE;
            bArr[2] = v(permissions.contains(posixFilePermission6), bArr[2], 3);
            posixFilePermission7 = PosixFilePermission.OTHERS_READ;
            bArr[2] = v(permissions.contains(posixFilePermission7), bArr[2], 2);
            posixFilePermission8 = PosixFilePermission.OTHERS_WRITE;
            bArr[2] = v(permissions.contains(posixFilePermission8), bArr[2], 1);
            posixFilePermission9 = PosixFilePermission.OTHERS_EXECUTE;
            bArr[2] = v(permissions.contains(posixFilePermission9), bArr[2], 0);
        } catch (IOException unused) {
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0196 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String l(File file, e5.q qVar) {
        String j6;
        StringBuilder sb;
        String m5;
        String substring;
        try {
            String canonicalPath = file.getCanonicalPath();
            if (!i0.d(qVar.e())) {
                File file2 = new File(canonicalPath);
                j6 = j(file2, qVar.k());
                if (file2.isDirectory()) {
                    sb = new StringBuilder();
                    sb.append(j6);
                    sb.append("/");
                }
                m5 = qVar.m();
                if (i0.d(m5)) {
                    if (!m5.endsWith("\\") && !m5.endsWith("/")) {
                        m5 = m5 + g0.f11038a;
                    }
                    m5 = m5.replaceAll("\\\\", "/");
                    j6 = m5 + j6;
                }
                if (i0.d(j6)) {
                    String str = "fileName to add to zip is empty or null. fileName: '" + j6 + "' DefaultFolderPath: '" + qVar.e() + "' FileNameInZip: " + qVar.k();
                    if (q(file)) {
                        str = str + "isSymlink: true ";
                    }
                    if (i0.d(m5)) {
                        str = "rootFolderNameInZip: '" + m5 + "' ";
                    }
                    throw new a5.a(str);
                }
                return j6;
            }
            String canonicalPath2 = new File(qVar.e()).getCanonicalPath();
            String str2 = g0.f11038a;
            if (!canonicalPath2.endsWith(str2)) {
                canonicalPath2 = canonicalPath2 + str2;
            }
            if (q(file)) {
                substring = new File(file.getParentFile().getCanonicalFile().getPath() + File.separator + file.getCanonicalFile().getName()).getPath().substring(canonicalPath2.length());
            } else {
                substring = canonicalPath.substring(canonicalPath2.length());
            }
            if (substring.startsWith(System.getProperty("file.separator"))) {
                substring = substring.substring(1);
            }
            File file3 = new File(canonicalPath);
            if (file3.isDirectory()) {
                String replaceAll = substring.replaceAll("\\\\", "/");
                sb = new StringBuilder();
                sb.append(replaceAll);
                sb.append("/");
            } else {
                String replaceAll2 = substring.substring(0, substring.lastIndexOf(file3.getName())).replaceAll("\\\\", "/");
                sb = new StringBuilder();
                sb.append(replaceAll2);
                sb.append(j(file3, qVar.k()));
            }
            j6 = sb.toString();
            m5 = qVar.m();
            if (i0.d(m5)) {
            }
            if (i0.d(j6)) {
            }
        } catch (IOException e6) {
            throw new a5.a(e6);
        }
    }

    private static byte[] m(Path path) {
        LinkOption linkOption;
        FileAttributeView fileAttributeView;
        DosFileAttributes readAttributes;
        boolean isReadOnly;
        boolean isHidden;
        boolean isSystem;
        boolean isDirectory;
        boolean isArchive;
        byte[] bArr = new byte[4];
        try {
            linkOption = LinkOption.NOFOLLOW_LINKS;
            fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class, linkOption);
            readAttributes = d0.a(fileAttributeView).readAttributes();
            isReadOnly = readAttributes.isReadOnly();
            byte v5 = v(isReadOnly, (byte) 0, 0);
            isHidden = readAttributes.isHidden();
            byte v6 = v(isHidden, v5, 1);
            isSystem = readAttributes.isSystem();
            byte v7 = v(isSystem, v6, 2);
            isDirectory = readAttributes.isDirectory();
            byte v8 = v(isDirectory, v7, 4);
            isArchive = readAttributes.isArchive();
            bArr[0] = v(isArchive, v8, 5);
        } catch (IOException unused) {
        }
        return bArr;
    }

    public static String n(String str) {
        if (i0.d(str)) {
            if (str.contains(System.getProperty("file.separator"))) {
                str = str.substring(str.lastIndexOf(System.getProperty("file.separator")) + 1);
            }
            return str.endsWith(".zip") ? str.substring(0, str.lastIndexOf(".")) : str;
        }
        throw new a5.a("zip file name is empty or null, cannot determine zip file name");
    }

    public static boolean o() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

    public static boolean p(File file) {
        return file.getName().endsWith(".zip.001");
    }

    public static boolean q(File file) {
        Path path;
        boolean isSymbolicLink;
        try {
            path = file.toPath();
            isSymbolicLink = Files.isSymbolicLink(path);
            return isSymbolicLink;
        } catch (Error | Exception unused) {
            return false;
        }
    }

    public static boolean r() {
        return System.getProperty("os.name").toLowerCase().contains("nux");
    }

    public static boolean s() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static boolean t(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    public static String u(File file) {
        Path path;
        Path readSymbolicLink;
        String path2;
        try {
            path = file.toPath();
            readSymbolicLink = Files.readSymbolicLink(path);
            path2 = readSymbolicLink.toString();
            return path2;
        } catch (Error | Exception unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    private static byte v(boolean z5, byte b6, int i6) {
        return z5 ? i5.a.b(b6, i6) : b6;
    }
}
