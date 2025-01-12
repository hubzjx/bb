package okhttp3.internal.cache;

import h4.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.l;
import okhttp3.internal.cache.DiskLruCache;
import q4.a;
/* loaded from: classes.dex */
public final class DiskLruCache$snapshots$1 implements Iterator<DiskLruCache.Snapshot>, a {
    private final Iterator<DiskLruCache.Entry> delegate;
    private DiskLruCache.Snapshot nextSnapshot;
    private DiskLruCache.Snapshot removeSnapshot;
    final /* synthetic */ DiskLruCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiskLruCache$snapshots$1(DiskLruCache diskLruCache) {
        this.this$0 = diskLruCache;
        Iterator<DiskLruCache.Entry> it = new ArrayList(diskLruCache.getLruEntries$okhttp().values()).iterator();
        l.c(it, "ArrayList(lruEntries.values).iterator()");
        this.delegate = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextSnapshot != null) {
            return true;
        }
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            if (diskLruCache.getClosed$okhttp()) {
                return false;
            }
            while (this.delegate.hasNext()) {
                DiskLruCache.Entry next = this.delegate.next();
                DiskLruCache.Snapshot snapshot$okhttp = next == null ? null : next.snapshot$okhttp();
                if (snapshot$okhttp != null) {
                    this.nextSnapshot = snapshot$okhttp;
                    return true;
                }
            }
            q qVar = q.f10774a;
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        DiskLruCache.Snapshot snapshot = this.removeSnapshot;
        if (snapshot == null) {
            throw new IllegalStateException("remove() before next()".toString());
        }
        try {
            this.this$0.remove(snapshot.key());
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.removeSnapshot = null;
            throw th;
        }
        this.removeSnapshot = null;
    }

    @Override // java.util.Iterator
    public DiskLruCache.Snapshot next() {
        if (hasNext()) {
            DiskLruCache.Snapshot snapshot = this.nextSnapshot;
            this.removeSnapshot = snapshot;
            this.nextSnapshot = null;
            l.b(snapshot);
            return snapshot;
        }
        throw new NoSuchElementException();
    }
}
