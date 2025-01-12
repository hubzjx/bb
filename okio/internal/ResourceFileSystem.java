package okio.internal;

import h4.f;
import h4.h;
import h4.j;
import h4.n;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.o;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import kotlin.text.x;
import okhttp3.HttpUrl;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;
/* loaded from: classes.dex */
public final class ResourceFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
    private final f roots$delegate;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean keepPath(Path path) {
            boolean j6;
            j6 = w.j(path.name(), ".class", true);
            return !j6;
        }

        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        public final Path removeBase(Path path, Path path2) {
            String c02;
            String t5;
            l.d(path, "<this>");
            l.d(path2, "base");
            String path3 = path2.toString();
            Path root = getROOT();
            c02 = x.c0(path.toString(), path3);
            t5 = w.t(c02, '\\', '/', false, 4, null);
            return root.resolve(t5);
        }

        public final List<j> toClasspathRoots(ClassLoader classLoader) {
            List<j> H;
            l.d(classLoader, "<this>");
            Enumeration<URL> resources = classLoader.getResources(HttpUrl.FRAGMENT_ENCODE_SET);
            l.c(resources, "getResources(\"\")");
            ArrayList<URL> list = Collections.list(resources);
            l.c(list, "list(this)");
            ArrayList arrayList = new ArrayList();
            for (URL url : list) {
                Companion companion = ResourceFileSystem.Companion;
                l.c(url, "it");
                j fileRoot = companion.toFileRoot(url);
                if (fileRoot != null) {
                    arrayList.add(fileRoot);
                }
            }
            Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
            l.c(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList<URL> list2 = Collections.list(resources2);
            l.c(list2, "list(this)");
            ArrayList arrayList2 = new ArrayList();
            for (URL url2 : list2) {
                Companion companion2 = ResourceFileSystem.Companion;
                l.c(url2, "it");
                j jarRoot = companion2.toJarRoot(url2);
                if (jarRoot != null) {
                    arrayList2.add(jarRoot);
                }
            }
            H = v.H(arrayList, arrayList2);
            return H;
        }

        public final j toFileRoot(URL url) {
            l.d(url, "<this>");
            if (l.a(url.getProtocol(), "file")) {
                return n.a(FileSystem.SYSTEM, Path.Companion.get$default(Path.Companion, new File(url.toURI()), false, 1, (Object) null));
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x001a, code lost:
            r0 = kotlin.text.x.T(r10, "!", 0, false, 6, null);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final j toJarRoot(URL url) {
            boolean y5;
            int T;
            l.d(url, "<this>");
            String url2 = url.toString();
            l.c(url2, "toString()");
            y5 = w.y(url2, "jar:file:", false, 2, null);
            if (y5 && T != -1) {
                Path.Companion companion = Path.Companion;
                String substring = url2.substring(4, T);
                l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return n.a(ZipKt.openZip(Path.Companion.get$default(companion, new File(URI.create(substring)), false, 1, (Object) null), FileSystem.SYSTEM, ResourceFileSystem$Companion$toJarRoot$zip$1.INSTANCE), getROOT());
            }
            return null;
        }
    }

    public ResourceFileSystem(ClassLoader classLoader, boolean z5) {
        f a6;
        l.d(classLoader, "classLoader");
        a6 = h.a(new ResourceFileSystem$roots$2(classLoader));
        this.roots$delegate = a6;
        if (z5) {
            getRoots().size();
        }
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<j> getRoots() {
        return (List) this.roots$delegate.getValue();
    }

    private final String toRelativePath(Path path) {
        return canonicalizeInternal(path).relativeTo(ROOT).toString();
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path path, boolean z5) {
        l.d(path, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(Path path, Path path2) {
        l.d(path, "source");
        l.d(path2, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) {
        l.d(path, "path");
        return canonicalizeInternal(path);
    }

    @Override // okio.FileSystem
    public void createDirectory(Path path, boolean z5) {
        l.d(path, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(Path path, Path path2) {
        l.d(path, "source");
        l.d(path2, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z5) {
        l.d(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public List<Path> list(Path path) {
        List<Path> O;
        int p5;
        l.d(path, "dir");
        String relativePath = toRelativePath(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z5 = false;
        for (j jVar : getRoots()) {
            FileSystem fileSystem = (FileSystem) jVar.component1();
            Path path2 = (Path) jVar.component2();
            try {
                List<Path> list = fileSystem.list(path2.resolve(relativePath));
                ArrayList<Path> arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Companion.keepPath((Path) obj)) {
                        arrayList.add(obj);
                    }
                }
                p5 = o.p(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(p5);
                for (Path path3 : arrayList) {
                    arrayList2.add(Companion.removeBase(path3, path2));
                }
                s.s(linkedHashSet, arrayList2);
                z5 = true;
            } catch (IOException unused) {
            }
        }
        if (z5) {
            O = v.O(linkedHashSet);
            return O;
        }
        throw new FileNotFoundException("file not found: " + path);
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path path) {
        List<Path> O;
        int p5;
        l.d(path, "dir");
        String relativePath = toRelativePath(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<j> it = getRoots().iterator();
        boolean z5 = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            j next = it.next();
            Path path2 = (Path) next.component2();
            List<Path> listOrNull = ((FileSystem) next.component1()).listOrNull(path2.resolve(relativePath));
            if (listOrNull != null) {
                ArrayList<Path> arrayList2 = new ArrayList();
                for (Object obj : listOrNull) {
                    if (Companion.keepPath((Path) obj)) {
                        arrayList2.add(obj);
                    }
                }
                p5 = o.p(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(p5);
                for (Path path3 : arrayList2) {
                    arrayList3.add(Companion.removeBase(path3, path2));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                s.s(linkedHashSet, arrayList);
                z5 = true;
            }
        }
        if (z5) {
            O = v.O(linkedHashSet);
            return O;
        }
        return null;
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        l.d(path, "path");
        if (Companion.keepPath(path)) {
            String relativePath = toRelativePath(path);
            for (j jVar : getRoots()) {
                FileMetadata metadataOrNull = ((FileSystem) jVar.component1()).metadataOrNull(((Path) jVar.component2()).resolve(relativePath));
                if (metadataOrNull != null) {
                    return metadataOrNull;
                }
            }
            return null;
        }
        return null;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path path) {
        l.d(path, "file");
        if (!Companion.keepPath(path)) {
            throw new FileNotFoundException("file not found: " + path);
        }
        String relativePath = toRelativePath(path);
        for (j jVar : getRoots()) {
            try {
                return ((FileSystem) jVar.component1()).openReadOnly(((Path) jVar.component2()).resolve(relativePath));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + path);
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path path, boolean z5, boolean z6) {
        l.d(path, "file");
        throw new IOException("resources are not writable");
    }

    @Override // okio.FileSystem
    public Sink sink(Path path, boolean z5) {
        l.d(path, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public Source source(Path path) {
        l.d(path, "file");
        if (!Companion.keepPath(path)) {
            throw new FileNotFoundException("file not found: " + path);
        }
        String relativePath = toRelativePath(path);
        for (j jVar : getRoots()) {
            try {
                return ((FileSystem) jVar.component1()).source(((Path) jVar.component2()).resolve(relativePath));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + path);
    }
}
