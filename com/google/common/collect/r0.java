package com.google.common.collect;

import com.google.common.collect.q0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r0 extends AbstractMap implements ConcurrentMap, Serializable, j$.util.concurrent.ConcurrentMap {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final f0 UNSET_WEAK_VALUE_REFERENCE = new a();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient j entryHelper;
    @MonotonicNonNullDecl
    transient Set<Map.Entry<Object, Object>> entrySet;
    final com.google.common.base.c keyEquivalence;
    @MonotonicNonNullDecl
    transient Set<Object> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient n[] segments;
    @MonotonicNonNullDecl
    transient Collection<Object> values;

    /* loaded from: classes.dex */
    static class a implements f0 {
        a() {
        }

        @Override // com.google.common.collect.r0.f0
        public /* bridge */ /* synthetic */ i a() {
            d();
            return null;
        }

        @Override // com.google.common.collect.r0.f0
        public /* bridge */ /* synthetic */ f0 b(ReferenceQueue referenceQueue, i iVar) {
            android.support.v4.media.a.a(iVar);
            return c(referenceQueue, null);
        }

        public f0 c(ReferenceQueue referenceQueue, e eVar) {
            return this;
        }

        @Override // com.google.common.collect.r0.f0
        public void clear() {
        }

        public e d() {
            return null;
        }

        @Override // com.google.common.collect.r0.f0
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a0 extends d {

        /* renamed from: c  reason: collision with root package name */
        private volatile Object f5693c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a implements j {

            /* renamed from: a  reason: collision with root package name */
            private static final a f5694a = new a();

            a() {
            }

            static a h() {
                return f5694a;
            }

            @Override // com.google.common.collect.r0.j
            public p c() {
                return p.WEAK;
            }

            @Override // com.google.common.collect.r0.j
            public p d() {
                return p.STRONG;
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: g */
            public a0 b(b0 b0Var, a0 a0Var, a0 a0Var2) {
                if (a0Var.getKey() == null) {
                    return null;
                }
                return a0Var.d(b0Var.queueForKeys, a0Var2);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: i */
            public a0 e(b0 b0Var, Object obj, int i6, a0 a0Var) {
                return new a0(b0Var.queueForKeys, obj, i6, a0Var);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: j */
            public b0 a(r0 r0Var, int i6, int i7) {
                return new b0(r0Var, i6, i7);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: k */
            public void f(b0 b0Var, a0 a0Var, Object obj) {
                a0Var.e(obj);
            }
        }

        a0(ReferenceQueue referenceQueue, Object obj, int i6, a0 a0Var) {
            super(referenceQueue, obj, i6, a0Var);
            this.f5693c = null;
        }

        a0 d(ReferenceQueue referenceQueue, a0 a0Var) {
            a0 a0Var2 = new a0(referenceQueue, getKey(), this.f5700a, a0Var);
            a0Var2.e(this.f5693c);
            return a0Var2;
        }

        void e(Object obj) {
            this.f5693c = obj;
        }

        @Override // com.google.common.collect.r0.i
        public Object getValue() {
            return this.f5693c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b0 extends n {
        private final ReferenceQueue<Object> queueForKeys;

        b0(r0 r0Var, int i6, int i7) {
            super(r0Var, i6, i7);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.r0.n
        ReferenceQueue<Object> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.r0.n
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.r0.n
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.r0.n
        public a0 castForTesting(i iVar) {
            return (a0) iVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.r0.n
        public b0 self() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c implements i {

        /* renamed from: a  reason: collision with root package name */
        final Object f5695a;

        /* renamed from: b  reason: collision with root package name */
        final int f5696b;

        /* renamed from: c  reason: collision with root package name */
        final i f5697c;

        c(Object obj, int i6, i iVar) {
            this.f5695a = obj;
            this.f5696b = i6;
            this.f5697c = iVar;
        }

        @Override // com.google.common.collect.r0.i
        public i b() {
            return this.f5697c;
        }

        @Override // com.google.common.collect.r0.i
        public int c() {
            return this.f5696b;
        }

        @Override // com.google.common.collect.r0.i
        public Object getKey() {
            return this.f5695a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c0 extends d implements e0 {

        /* renamed from: c  reason: collision with root package name */
        private volatile f0 f5698c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a implements j {

            /* renamed from: a  reason: collision with root package name */
            private static final a f5699a = new a();

            a() {
            }

            static a h() {
                return f5699a;
            }

            @Override // com.google.common.collect.r0.j
            public p c() {
                return p.WEAK;
            }

            @Override // com.google.common.collect.r0.j
            public p d() {
                return p.WEAK;
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: g */
            public c0 b(d0 d0Var, c0 c0Var, c0 c0Var2) {
                if (c0Var.getKey() == null || n.isCollected(c0Var)) {
                    return null;
                }
                return c0Var.f(d0Var.queueForKeys, d0Var.queueForValues, c0Var2);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: i */
            public c0 e(d0 d0Var, Object obj, int i6, c0 c0Var) {
                return new c0(d0Var.queueForKeys, obj, i6, c0Var);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: j */
            public d0 a(r0 r0Var, int i6, int i7) {
                return new d0(r0Var, i6, i7);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: k */
            public void f(d0 d0Var, c0 c0Var, Object obj) {
                c0Var.g(obj, d0Var.queueForValues);
            }
        }

        c0(ReferenceQueue referenceQueue, Object obj, int i6, c0 c0Var) {
            super(referenceQueue, obj, i6, c0Var);
            this.f5698c = r0.unsetWeakValueReference();
        }

        @Override // com.google.common.collect.r0.e0
        public f0 a() {
            return this.f5698c;
        }

        c0 f(ReferenceQueue referenceQueue, ReferenceQueue referenceQueue2, c0 c0Var) {
            c0 c0Var2 = new c0(referenceQueue, getKey(), this.f5700a, c0Var);
            c0Var2.f5698c = this.f5698c.b(referenceQueue2, c0Var2);
            return c0Var2;
        }

        void g(Object obj, ReferenceQueue referenceQueue) {
            f0 f0Var = this.f5698c;
            this.f5698c = new g0(referenceQueue, obj, this);
            f0Var.clear();
        }

        @Override // com.google.common.collect.r0.i
        public Object getValue() {
            return this.f5698c.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class d extends WeakReference implements i {

        /* renamed from: a  reason: collision with root package name */
        final int f5700a;

        /* renamed from: b  reason: collision with root package name */
        final i f5701b;

        d(ReferenceQueue referenceQueue, Object obj, int i6, i iVar) {
            super(obj, referenceQueue);
            this.f5700a = i6;
            this.f5701b = iVar;
        }

        @Override // com.google.common.collect.r0.i
        public i b() {
            return this.f5701b;
        }

        @Override // com.google.common.collect.r0.i
        public int c() {
            return this.f5700a;
        }

        @Override // com.google.common.collect.r0.i
        public Object getKey() {
            return get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d0 extends n {
        private final ReferenceQueue<Object> queueForKeys;
        private final ReferenceQueue<Object> queueForValues;

        d0(r0 r0Var, int i6, int i7) {
            super(r0Var, i6, i7);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.r0.n
        ReferenceQueue<Object> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.r0.n
        ReferenceQueue<Object> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.r0.n
        public f0 getWeakValueReferenceForTesting(i iVar) {
            return castForTesting(iVar).a();
        }

        @Override // com.google.common.collect.r0.n
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.r0.n
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.r0.n
        public f0 newWeakValueReferenceForTesting(i iVar, Object obj) {
            return new g0(this.queueForValues, obj, castForTesting(iVar));
        }

        @Override // com.google.common.collect.r0.n
        public void setWeakValueReferenceForTesting(i iVar, f0 f0Var) {
            c0 castForTesting = castForTesting(iVar);
            f0 f0Var2 = castForTesting.f5698c;
            castForTesting.f5698c = f0Var;
            f0Var2.clear();
        }

        @Override // com.google.common.collect.r0.n
        public c0 castForTesting(i iVar) {
            return (c0) iVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.r0.n
        public d0 self() {
            return this;
        }
    }

    /* loaded from: classes.dex */
    static final class e implements i {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e0 extends i {
        f0 a();
    }

    /* loaded from: classes.dex */
    final class f extends h {
        f() {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: f */
        public Map.Entry next() {
            return c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f0 {
        i a();

        f0 b(ReferenceQueue referenceQueue, i iVar);

        void clear();

        Object get();
    }

    /* loaded from: classes.dex */
    final class g extends m {
        g() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            r0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = r0.this.get(key)) != null && r0.this.valueEquivalence().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return r0.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && r0.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return r0.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class g0 extends WeakReference implements f0 {

        /* renamed from: a  reason: collision with root package name */
        final i f5704a;

        g0(ReferenceQueue referenceQueue, Object obj, i iVar) {
            super(obj, referenceQueue);
            this.f5704a = iVar;
        }

        @Override // com.google.common.collect.r0.f0
        public i a() {
            return this.f5704a;
        }

        @Override // com.google.common.collect.r0.f0
        public f0 b(ReferenceQueue referenceQueue, i iVar) {
            return new g0(referenceQueue, get(), iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class h implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        int f5705a;

        /* renamed from: b  reason: collision with root package name */
        int f5706b = -1;

        /* renamed from: c  reason: collision with root package name */
        n f5707c;

        /* renamed from: d  reason: collision with root package name */
        AtomicReferenceArray f5708d;

        /* renamed from: e  reason: collision with root package name */
        i f5709e;

        /* renamed from: f  reason: collision with root package name */
        h0 f5710f;

        /* renamed from: g  reason: collision with root package name */
        h0 f5711g;

        h() {
            this.f5705a = r0.this.segments.length - 1;
            a();
        }

        final void a() {
            this.f5710f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i6 = this.f5705a;
                if (i6 < 0) {
                    return;
                }
                n[] nVarArr = r0.this.segments;
                this.f5705a = i6 - 1;
                n nVar = nVarArr[i6];
                this.f5707c = nVar;
                if (nVar.count != 0) {
                    AtomicReferenceArray<i> atomicReferenceArray = this.f5707c.table;
                    this.f5708d = atomicReferenceArray;
                    this.f5706b = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        boolean b(i iVar) {
            try {
                Object key = iVar.getKey();
                Object liveValue = r0.this.getLiveValue(iVar);
                if (liveValue == null) {
                    this.f5707c.postReadCleanup();
                    return false;
                }
                this.f5710f = new h0(key, liveValue);
                this.f5707c.postReadCleanup();
                return true;
            } catch (Throwable th) {
                this.f5707c.postReadCleanup();
                throw th;
            }
        }

        h0 c() {
            h0 h0Var = this.f5710f;
            if (h0Var != null) {
                this.f5711g = h0Var;
                a();
                return this.f5711g;
            }
            throw new NoSuchElementException();
        }

        boolean d() {
            i iVar = this.f5709e;
            if (iVar == null) {
                return false;
            }
            while (true) {
                this.f5709e = iVar.b();
                i iVar2 = this.f5709e;
                if (iVar2 == null) {
                    return false;
                }
                if (b(iVar2)) {
                    return true;
                }
                iVar = this.f5709e;
            }
        }

        boolean e() {
            while (true) {
                int i6 = this.f5706b;
                if (i6 < 0) {
                    return false;
                }
                AtomicReferenceArray atomicReferenceArray = this.f5708d;
                this.f5706b = i6 - 1;
                i iVar = (i) atomicReferenceArray.get(i6);
                this.f5709e = iVar;
                if (iVar != null && (b(iVar) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5710f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.i.d(this.f5711g != null);
            r0.this.remove(this.f5711g.getKey());
            this.f5711g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class h0 extends com.google.common.collect.c {

        /* renamed from: a  reason: collision with root package name */
        final Object f5713a;

        /* renamed from: b  reason: collision with root package name */
        Object f5714b;

        h0(Object obj, Object obj2) {
            this.f5713a = obj;
            this.f5714b = obj2;
        }

        @Override // com.google.common.collect.c, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.f5713a.equals(entry.getKey()) && this.f5714b.equals(entry.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.c, java.util.Map.Entry
        public Object getKey() {
            return this.f5713a;
        }

        @Override // com.google.common.collect.c, java.util.Map.Entry
        public Object getValue() {
            return this.f5714b;
        }

        @Override // com.google.common.collect.c, java.util.Map.Entry
        public int hashCode() {
            return this.f5713a.hashCode() ^ this.f5714b.hashCode();
        }

        @Override // com.google.common.collect.c, java.util.Map.Entry
        public Object setValue(Object obj) {
            Object put = r0.this.put(this.f5713a, obj);
            this.f5714b = obj;
            return put;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface i {
        i b();

        int c();

        Object getKey();

        Object getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface j {
        n a(r0 r0Var, int i6, int i7);

        i b(n nVar, i iVar, i iVar2);

        p c();

        p d();

        i e(n nVar, Object obj, int i6, i iVar);

        void f(n nVar, i iVar, Object obj);
    }

    /* loaded from: classes.dex */
    final class k extends h {
        k() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c().getKey();
        }
    }

    /* loaded from: classes.dex */
    final class l extends m {
        l() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            r0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return r0.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return r0.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new k();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return r0.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return r0.this.size();
        }
    }

    /* loaded from: classes.dex */
    private static abstract class m extends AbstractSet {
        private m() {
        }

        /* synthetic */ m(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return r0.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            return r0.toArrayList(this).toArray(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class n extends ReentrantLock {
        volatile int count;
        @Weak
        final r0 map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<i> table;
        int threshold;

        n(r0 r0Var, int i6, int i7) {
            this.map = r0Var;
            this.maxSegmentSize = i7;
            initTable(newEntryArray(i6));
        }

        static <K, V, E extends i> boolean isCollected(E e6) {
            return e6.getValue() == null;
        }

        abstract i castForTesting(i iVar);

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<i> atomicReferenceArray = this.table;
                    for (int i6 = 0; i6 < atomicReferenceArray.length(); i6++) {
                        atomicReferenceArray.set(i6, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        @CanIgnoreReturnValue
        boolean clearValueForTesting(Object obj, int i6, f0 f0Var) {
            lock();
            try {
                AtomicReferenceArray<i> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                i iVar = atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.b()) {
                    Object key = iVar2.getKey();
                    if (iVar2.c() == i6 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        if (((e0) iVar2).a() == f0Var) {
                            atomicReferenceArray.set(length, removeFromChain(iVar, iVar2));
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        boolean containsKey(Object obj, int i6) {
            try {
                boolean z5 = false;
                if (this.count != 0) {
                    i liveEntry = getLiveEntry(obj, i6);
                    if (liveEntry != null) {
                        if (liveEntry.getValue() != null) {
                            z5 = true;
                        }
                    }
                    return z5;
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<i> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i6 = 0; i6 < length; i6++) {
                        for (i iVar = atomicReferenceArray.get(i6); iVar != null; iVar = iVar.b()) {
                            Object liveValue = getLiveValue(iVar);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        i copyEntry(i iVar, i iVar2) {
            return this.map.entryHelper.b(self(), iVar, iVar2);
        }

        i copyForTesting(i iVar, @NullableDecl i iVar2) {
            return this.map.entryHelper.b(self(), castForTesting(iVar), castForTesting(iVar2));
        }

        @GuardedBy("this")
        void drainKeyReferenceQueue(ReferenceQueue<Object> referenceQueue) {
            int i6 = 0;
            do {
                Reference<? extends Object> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimKey((i) poll);
                i6++;
            } while (i6 != 16);
        }

        @GuardedBy("this")
        void drainValueReferenceQueue(ReferenceQueue<Object> referenceQueue) {
            int i6 = 0;
            do {
                Reference<? extends Object> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimValue((f0) poll);
                i6++;
            } while (i6 != 16);
        }

        @GuardedBy("this")
        void expand() {
            AtomicReferenceArray<i> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= r0.MAXIMUM_CAPACITY) {
                return;
            }
            int i6 = this.count;
            AtomicReferenceArray<i> newEntryArray = newEntryArray(length << 1);
            this.threshold = (newEntryArray.length() * 3) / 4;
            int length2 = newEntryArray.length() - 1;
            for (int i7 = 0; i7 < length; i7++) {
                i iVar = atomicReferenceArray.get(i7);
                if (iVar != null) {
                    i b6 = iVar.b();
                    int c6 = iVar.c() & length2;
                    if (b6 == null) {
                        newEntryArray.set(c6, iVar);
                    } else {
                        i iVar2 = iVar;
                        while (b6 != null) {
                            int c7 = b6.c() & length2;
                            if (c7 != c6) {
                                iVar2 = b6;
                                c6 = c7;
                            }
                            b6 = b6.b();
                        }
                        newEntryArray.set(c6, iVar2);
                        while (iVar != iVar2) {
                            int c8 = iVar.c() & length2;
                            i copyEntry = copyEntry(iVar, newEntryArray.get(c8));
                            if (copyEntry != null) {
                                newEntryArray.set(c8, copyEntry);
                            } else {
                                i6--;
                            }
                            iVar = iVar.b();
                        }
                    }
                }
            }
            this.table = newEntryArray;
            this.count = i6;
        }

        Object get(Object obj, int i6) {
            try {
                i liveEntry = getLiveEntry(obj, i6);
                if (liveEntry == null) {
                    postReadCleanup();
                    return null;
                }
                Object value = liveEntry.getValue();
                if (value == null) {
                    tryDrainReferenceQueues();
                }
                return value;
            } finally {
                postReadCleanup();
            }
        }

        i getEntry(Object obj, int i6) {
            if (this.count != 0) {
                for (i first = getFirst(i6); first != null; first = first.b()) {
                    if (first.c() == i6) {
                        Object key = first.getKey();
                        if (key == null) {
                            tryDrainReferenceQueues();
                        } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                            return first;
                        }
                    }
                }
                return null;
            }
            return null;
        }

        i getFirst(int i6) {
            AtomicReferenceArray<i> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i6 & (atomicReferenceArray.length() - 1));
        }

        ReferenceQueue<Object> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        i getLiveEntry(Object obj, int i6) {
            return getEntry(obj, i6);
        }

        @NullableDecl
        Object getLiveValue(i iVar) {
            if (iVar.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            Object value = iVar.getValue();
            if (value == null) {
                tryDrainReferenceQueues();
                return null;
            }
            return value;
        }

        @NullableDecl
        Object getLiveValueForTesting(i iVar) {
            return getLiveValue(castForTesting(iVar));
        }

        ReferenceQueue<Object> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        f0 getWeakValueReferenceForTesting(i iVar) {
            throw new AssertionError();
        }

        void initTable(AtomicReferenceArray<i> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        void maybeClearReferenceQueues() {
        }

        @GuardedBy("this")
        void maybeDrainReferenceQueues() {
        }

        AtomicReferenceArray<i> newEntryArray(int i6) {
            return new AtomicReferenceArray<>(i6);
        }

        i newEntryForTesting(Object obj, int i6, @NullableDecl i iVar) {
            return this.map.entryHelper.e(self(), obj, i6, castForTesting(iVar));
        }

        f0 newWeakValueReferenceForTesting(i iVar, Object obj) {
            throw new AssertionError();
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        @GuardedBy("this")
        void preWriteCleanup() {
            runLockedCleanup();
        }

        Object put(Object obj, int i6, Object obj2, boolean z5) {
            lock();
            try {
                preWriteCleanup();
                int i7 = this.count + 1;
                if (i7 > this.threshold) {
                    expand();
                    i7 = this.count + 1;
                }
                AtomicReferenceArray<i> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                i iVar = atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.b()) {
                    Object key = iVar2.getKey();
                    if (iVar2.c() == i6 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        Object value = iVar2.getValue();
                        if (value == null) {
                            this.modCount++;
                            setValue(iVar2, obj2);
                            this.count = this.count;
                            return null;
                        } else if (z5) {
                            return value;
                        } else {
                            this.modCount++;
                            setValue(iVar2, obj2);
                            return value;
                        }
                    }
                }
                this.modCount++;
                i e6 = this.map.entryHelper.e(self(), obj, i6, iVar);
                setValue(e6, obj2);
                atomicReferenceArray.set(length, e6);
                this.count = i7;
                return null;
            } finally {
                unlock();
            }
        }

        @CanIgnoreReturnValue
        boolean reclaimKey(i iVar, int i6) {
            lock();
            try {
                AtomicReferenceArray<i> atomicReferenceArray = this.table;
                int length = i6 & (atomicReferenceArray.length() - 1);
                i iVar2 = atomicReferenceArray.get(length);
                for (i iVar3 = iVar2; iVar3 != null; iVar3 = iVar3.b()) {
                    if (iVar3 == iVar) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeFromChain(iVar2, iVar3));
                        this.count--;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        @CanIgnoreReturnValue
        boolean reclaimValue(Object obj, int i6, f0 f0Var) {
            lock();
            try {
                AtomicReferenceArray<i> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                i iVar = atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.b()) {
                    Object key = iVar2.getKey();
                    if (iVar2.c() == i6 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        if (((e0) iVar2).a() == f0Var) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeFromChain(iVar, iVar2));
                            this.count--;
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        @CanIgnoreReturnValue
        Object remove(Object obj, int i6) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<i> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                i iVar = atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.b()) {
                    Object key = iVar2.getKey();
                    if (iVar2.c() == i6 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        Object value = iVar2.getValue();
                        if (value == null && !isCollected(iVar2)) {
                            return null;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, removeFromChain(iVar, iVar2));
                        this.count--;
                        return value;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        @GuardedBy("this")
        boolean removeEntryForTesting(i iVar) {
            int c6 = iVar.c();
            AtomicReferenceArray<i> atomicReferenceArray = this.table;
            int length = c6 & (atomicReferenceArray.length() - 1);
            i iVar2 = atomicReferenceArray.get(length);
            for (i iVar3 = iVar2; iVar3 != null; iVar3 = iVar3.b()) {
                if (iVar3 == iVar) {
                    this.modCount++;
                    atomicReferenceArray.set(length, removeFromChain(iVar2, iVar3));
                    this.count--;
                    return true;
                }
            }
            return false;
        }

        @GuardedBy("this")
        i removeFromChain(i iVar, i iVar2) {
            int i6 = this.count;
            i b6 = iVar2.b();
            while (iVar != iVar2) {
                i copyEntry = copyEntry(iVar, b6);
                if (copyEntry != null) {
                    b6 = copyEntry;
                } else {
                    i6--;
                }
                iVar = iVar.b();
            }
            this.count = i6;
            return b6;
        }

        i removeFromChainForTesting(i iVar, i iVar2) {
            return removeFromChain(castForTesting(iVar), castForTesting(iVar2));
        }

        @CanIgnoreReturnValue
        boolean removeTableEntryForTesting(i iVar) {
            return removeEntryForTesting(castForTesting(iVar));
        }

        Object replace(Object obj, int i6, Object obj2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<i> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                i iVar = atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.b()) {
                    Object key = iVar2.getKey();
                    if (iVar2.c() == i6 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        Object value = iVar2.getValue();
                        if (value != null) {
                            this.modCount++;
                            setValue(iVar2, obj2);
                            return value;
                        }
                        if (isCollected(iVar2)) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeFromChain(iVar, iVar2));
                            this.count--;
                        }
                        return null;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        void runCleanup() {
            runLockedCleanup();
        }

        void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        abstract n self();

        void setTableEntryForTesting(int i6, i iVar) {
            this.table.set(i6, castForTesting(iVar));
        }

        void setValue(i iVar, Object obj) {
            this.map.entryHelper.f(self(), iVar, obj);
        }

        void setValueForTesting(i iVar, Object obj) {
            this.map.entryHelper.f(self(), castForTesting(iVar), obj);
        }

        void setWeakValueReferenceForTesting(i iVar, f0 f0Var) {
            throw new AssertionError();
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
            if (isCollected(r4) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
            r8.modCount++;
            r0.set(r1, removeFromChain(r3, r4));
            r8.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean remove(Object obj, int i6, Object obj2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<i> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                i iVar = atomicReferenceArray.get(length);
                i iVar2 = iVar;
                while (true) {
                    boolean z5 = false;
                    if (iVar2 == null) {
                        return false;
                    }
                    Object key = iVar2.getKey();
                    if (iVar2.c() == i6 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        break;
                    }
                    iVar2 = iVar2.b();
                }
            } finally {
                unlock();
            }
        }

        boolean replace(Object obj, int i6, Object obj2, Object obj3) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<i> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                i iVar = atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.b()) {
                    Object key = iVar2.getKey();
                    if (iVar2.c() == i6 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        Object value = iVar2.getValue();
                        if (value != null) {
                            if (this.map.valueEquivalence().equivalent(obj2, value)) {
                                this.modCount++;
                                setValue(iVar2, obj3);
                                return true;
                            }
                            return false;
                        }
                        if (isCollected(iVar2)) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeFromChain(iVar, iVar2));
                            this.count--;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class o extends b {
        private static final long serialVersionUID = 3;

        o(p pVar, p pVar2, com.google.common.base.c cVar, com.google.common.base.c cVar2, int i6, ConcurrentMap<Object, Object> concurrentMap) {
            super(pVar, pVar2, cVar, cVar2, i6, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).i();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static abstract class p {
        private static final /* synthetic */ p[] $VALUES;
        public static final p STRONG;
        public static final p WEAK;

        /* loaded from: classes.dex */
        enum a extends p {
            a(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.google.common.collect.r0.p
            com.google.common.base.c defaultEquivalence() {
                return com.google.common.base.c.equals();
            }
        }

        /* loaded from: classes.dex */
        enum b extends p {
            b(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.google.common.collect.r0.p
            com.google.common.base.c defaultEquivalence() {
                return com.google.common.base.c.identity();
            }
        }

        static {
            a aVar = new a("STRONG", 0);
            STRONG = aVar;
            b bVar = new b("WEAK", 1);
            WEAK = bVar;
            $VALUES = new p[]{aVar, bVar};
        }

        private p(String str, int i6) {
        }

        public static p valueOf(String str) {
            return (p) Enum.valueOf(p.class, str);
        }

        public static p[] values() {
            return (p[]) $VALUES.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract com.google.common.base.c defaultEquivalence();

        /* synthetic */ p(String str, int i6, a aVar) {
            this(str, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class q extends c {

        /* loaded from: classes.dex */
        static final class a implements j {

            /* renamed from: a  reason: collision with root package name */
            private static final a f5718a = new a();

            a() {
            }

            static a h() {
                return f5718a;
            }

            @Override // com.google.common.collect.r0.j
            public p c() {
                return p.STRONG;
            }

            @Override // com.google.common.collect.r0.j
            public p d() {
                return p.STRONG;
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: g */
            public q b(r rVar, q qVar, q qVar2) {
                return qVar.d(qVar2);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: i */
            public q e(r rVar, Object obj, int i6, q qVar) {
                return new q(obj, i6, qVar);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: j */
            public r a(r0 r0Var, int i6, int i7) {
                return new r(r0Var, i6, i7);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: k */
            public void f(r rVar, q qVar, q0.a aVar) {
            }
        }

        q(Object obj, int i6, q qVar) {
            super(obj, i6, qVar);
        }

        q d(q qVar) {
            return new q(this.f5695a, this.f5696b, qVar);
        }

        @Override // com.google.common.collect.r0.i
        /* renamed from: e */
        public q0.a getValue() {
            return q0.a.VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class r extends n {
        r(r0 r0Var, int i6, int i7) {
            super(r0Var, i6, i7);
        }

        @Override // com.google.common.collect.r0.n
        public q castForTesting(i iVar) {
            return (q) iVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.r0.n
        public r self() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class s extends c {

        /* renamed from: d  reason: collision with root package name */
        private volatile Object f5719d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a implements j {

            /* renamed from: a  reason: collision with root package name */
            private static final a f5720a = new a();

            a() {
            }

            static a h() {
                return f5720a;
            }

            @Override // com.google.common.collect.r0.j
            public p c() {
                return p.STRONG;
            }

            @Override // com.google.common.collect.r0.j
            public p d() {
                return p.STRONG;
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: g */
            public s b(t tVar, s sVar, s sVar2) {
                return sVar.d(sVar2);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: i */
            public s e(t tVar, Object obj, int i6, s sVar) {
                return new s(obj, i6, sVar);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: j */
            public t a(r0 r0Var, int i6, int i7) {
                return new t(r0Var, i6, i7);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: k */
            public void f(t tVar, s sVar, Object obj) {
                sVar.e(obj);
            }
        }

        s(Object obj, int i6, s sVar) {
            super(obj, i6, sVar);
            this.f5719d = null;
        }

        s d(s sVar) {
            s sVar2 = new s(this.f5695a, this.f5696b, sVar);
            sVar2.f5719d = this.f5719d;
            return sVar2;
        }

        void e(Object obj) {
            this.f5719d = obj;
        }

        @Override // com.google.common.collect.r0.i
        public Object getValue() {
            return this.f5719d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class t extends n {
        t(r0 r0Var, int i6, int i7) {
            super(r0Var, i6, i7);
        }

        @Override // com.google.common.collect.r0.n
        public s castForTesting(i iVar) {
            return (s) iVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.r0.n
        public t self() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class u extends c implements e0 {

        /* renamed from: d  reason: collision with root package name */
        private volatile f0 f5721d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a implements j {

            /* renamed from: a  reason: collision with root package name */
            private static final a f5722a = new a();

            a() {
            }

            static a h() {
                return f5722a;
            }

            @Override // com.google.common.collect.r0.j
            public p c() {
                return p.STRONG;
            }

            @Override // com.google.common.collect.r0.j
            public p d() {
                return p.WEAK;
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: g */
            public u b(v vVar, u uVar, u uVar2) {
                if (n.isCollected(uVar)) {
                    return null;
                }
                return uVar.f(vVar.queueForValues, uVar2);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: i */
            public u e(v vVar, Object obj, int i6, u uVar) {
                return new u(obj, i6, uVar);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: j */
            public v a(r0 r0Var, int i6, int i7) {
                return new v(r0Var, i6, i7);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: k */
            public void f(v vVar, u uVar, Object obj) {
                uVar.g(obj, vVar.queueForValues);
            }
        }

        u(Object obj, int i6, u uVar) {
            super(obj, i6, uVar);
            this.f5721d = r0.unsetWeakValueReference();
        }

        @Override // com.google.common.collect.r0.e0
        public f0 a() {
            return this.f5721d;
        }

        u f(ReferenceQueue referenceQueue, u uVar) {
            u uVar2 = new u(this.f5695a, this.f5696b, uVar);
            uVar2.f5721d = this.f5721d.b(referenceQueue, uVar2);
            return uVar2;
        }

        void g(Object obj, ReferenceQueue referenceQueue) {
            f0 f0Var = this.f5721d;
            this.f5721d = new g0(referenceQueue, obj, this);
            f0Var.clear();
        }

        @Override // com.google.common.collect.r0.i
        public Object getValue() {
            return this.f5721d.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class v extends n {
        private final ReferenceQueue<Object> queueForValues;

        v(r0 r0Var, int i6, int i7) {
            super(r0Var, i6, i7);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.r0.n
        ReferenceQueue<Object> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.r0.n
        public f0 getWeakValueReferenceForTesting(i iVar) {
            return castForTesting(iVar).a();
        }

        @Override // com.google.common.collect.r0.n
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.r0.n
        void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.r0.n
        public f0 newWeakValueReferenceForTesting(i iVar, Object obj) {
            return new g0(this.queueForValues, obj, castForTesting(iVar));
        }

        @Override // com.google.common.collect.r0.n
        public void setWeakValueReferenceForTesting(i iVar, f0 f0Var) {
            u castForTesting = castForTesting(iVar);
            f0 f0Var2 = castForTesting.f5721d;
            castForTesting.f5721d = f0Var;
            f0Var2.clear();
        }

        @Override // com.google.common.collect.r0.n
        public u castForTesting(i iVar) {
            return (u) iVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.r0.n
        public v self() {
            return this;
        }
    }

    /* loaded from: classes.dex */
    final class w extends h {
        w() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c().getValue();
        }
    }

    /* loaded from: classes.dex */
    final class x extends AbstractCollection {
        x() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            r0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return r0.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return r0.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new w();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return r0.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return r0.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return r0.toArrayList(this).toArray(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class y extends d {

        /* loaded from: classes.dex */
        static final class a implements j {

            /* renamed from: a  reason: collision with root package name */
            private static final a f5725a = new a();

            a() {
            }

            static a h() {
                return f5725a;
            }

            @Override // com.google.common.collect.r0.j
            public p c() {
                return p.WEAK;
            }

            @Override // com.google.common.collect.r0.j
            public p d() {
                return p.STRONG;
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: g */
            public y b(z zVar, y yVar, y yVar2) {
                if (yVar.getKey() == null) {
                    return null;
                }
                return yVar.d(zVar.queueForKeys, yVar2);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: i */
            public y e(z zVar, Object obj, int i6, y yVar) {
                return new y(zVar.queueForKeys, obj, i6, yVar);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: j */
            public z a(r0 r0Var, int i6, int i7) {
                return new z(r0Var, i6, i7);
            }

            @Override // com.google.common.collect.r0.j
            /* renamed from: k */
            public void f(z zVar, y yVar, q0.a aVar) {
            }
        }

        y(ReferenceQueue referenceQueue, Object obj, int i6, y yVar) {
            super(referenceQueue, obj, i6, yVar);
        }

        y d(ReferenceQueue referenceQueue, y yVar) {
            return new y(referenceQueue, getKey(), this.f5700a, yVar);
        }

        @Override // com.google.common.collect.r0.i
        /* renamed from: e */
        public q0.a getValue() {
            return q0.a.VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class z extends n {
        private final ReferenceQueue<Object> queueForKeys;

        z(r0 r0Var, int i6, int i7) {
            super(r0Var, i6, i7);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.r0.n
        ReferenceQueue<Object> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.r0.n
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.r0.n
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.r0.n
        public y castForTesting(i iVar) {
            return (y) iVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.r0.n
        public z self() {
            return this;
        }
    }

    private r0(q0 q0Var, j jVar) {
        this.concurrencyLevel = Math.min(q0Var.b(), 65536);
        this.keyEquivalence = q0Var.d();
        this.entryHelper = jVar;
        int min = Math.min(q0Var.c(), (int) MAXIMUM_CAPACITY);
        int i6 = 0;
        int i7 = 1;
        int i8 = 1;
        int i9 = 0;
        while (i8 < this.concurrencyLevel) {
            i9++;
            i8 <<= 1;
        }
        this.segmentShift = 32 - i9;
        this.segmentMask = i8 - 1;
        this.segments = newSegmentArray(i8);
        int i10 = min / i8;
        while (i7 < (i8 * i10 < min ? i10 + 1 : i10)) {
            i7 <<= 1;
        }
        while (true) {
            n[] nVarArr = this.segments;
            if (i6 >= nVarArr.length) {
                return;
            }
            nVarArr[i6] = createSegment(i7, -1);
            i6++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> r0 create(q0 q0Var) {
        p e6 = q0Var.e();
        p pVar = p.STRONG;
        if (e6 == pVar && q0Var.f() == pVar) {
            return new r0(q0Var, s.a.h());
        }
        if (q0Var.e() == pVar && q0Var.f() == p.WEAK) {
            return new r0(q0Var, u.a.h());
        }
        p e7 = q0Var.e();
        p pVar2 = p.WEAK;
        if (e7 == pVar2 && q0Var.f() == pVar) {
            return new r0(q0Var, a0.a.h());
        }
        if (q0Var.e() == pVar2 && q0Var.f() == pVar2) {
            return new r0(q0Var, c0.a.h());
        }
        throw new AssertionError();
    }

    static <K> r0 createWithDummyValues(q0 q0Var) {
        p e6 = q0Var.e();
        p pVar = p.STRONG;
        if (e6 == pVar && q0Var.f() == pVar) {
            return new r0(q0Var, q.a.h());
        }
        p e7 = q0Var.e();
        p pVar2 = p.WEAK;
        if (e7 == pVar2 && q0Var.f() == pVar) {
            return new r0(q0Var, y.a.h());
        }
        if (q0Var.f() == pVar2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    static int rehash(int i6) {
        int i7 = i6 + ((i6 << 15) ^ (-12931));
        int i8 = i7 ^ (i7 >>> 10);
        int i9 = i8 + (i8 << 3);
        int i10 = i9 ^ (i9 >>> 6);
        int i11 = i10 + (i10 << 2) + (i10 << 14);
        return i11 ^ (i11 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        n0.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V, E extends i> f0 unsetWeakValueReference() {
        return UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (n nVar : this.segments) {
            nVar.clear();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        n[] nVarArr = this.segments;
        long j6 = -1;
        int i6 = 0;
        while (i6 < 3) {
            long j7 = 0;
            for (n nVar : nVarArr) {
                int i7 = nVar.count;
                AtomicReferenceArray<i> atomicReferenceArray = nVar.table;
                for (int i8 = 0; i8 < atomicReferenceArray.length(); i8++) {
                    for (i iVar = atomicReferenceArray.get(i8); iVar != null; iVar = iVar.b()) {
                        Object liveValue = nVar.getLiveValue(iVar);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j7 += nVar.modCount;
            }
            if (j7 == j6) {
                return false;
            }
            i6++;
            j6 = j7;
        }
        return false;
    }

    i copyEntry(i iVar, i iVar2) {
        return segmentFor(iVar.c()).copyEntry(iVar, iVar2);
    }

    n createSegment(int i6, int i7) {
        return this.entryHelper.a(this, i6, i7);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        Set<Map.Entry<Object, Object>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.entrySet = gVar;
        return gVar;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    i getEntry(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    Object getLiveValue(i iVar) {
        Object value;
        if (iVar.getKey() == null || (value = iVar.getValue()) == null) {
            return null;
        }
        return value;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return get(obj);
    }

    int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        n[] nVarArr = this.segments;
        long j6 = 0;
        for (int i6 = 0; i6 < nVarArr.length; i6++) {
            if (nVarArr[i6].count != 0) {
                return false;
            }
            j6 += nVarArr[i6].modCount;
        }
        if (j6 != 0) {
            for (int i7 = 0; i7 < nVarArr.length; i7++) {
                if (nVarArr[i7].count != 0) {
                    return false;
                }
                j6 -= nVarArr[i7].modCount;
            }
            return j6 == 0;
        }
        return true;
    }

    boolean isLiveForTesting(i iVar) {
        return segmentFor(iVar.c()).getLiveValueForTesting(iVar) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Object> keySet() {
        Set<Object> set = this.keySet;
        if (set != null) {
            return set;
        }
        l lVar = new l();
        this.keySet = lVar;
        return lVar;
    }

    p keyStrength() {
        return this.entryHelper.c();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    final n[] newSegmentArray(int i6) {
        return new n[i6];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public Object put(Object obj, Object obj2) {
        com.google.common.base.j.j(obj);
        com.google.common.base.j.j(obj2);
        int hash = hash(obj);
        return segmentFor(hash).put(obj, hash, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<Object, Object> map) {
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    @CanIgnoreReturnValue
    public Object putIfAbsent(Object obj, Object obj2) {
        com.google.common.base.j.j(obj);
        com.google.common.base.j.j(obj2);
        int hash = hash(obj);
        return segmentFor(hash).put(obj, hash, obj2, true);
    }

    void reclaimKey(i iVar) {
        int c6 = iVar.c();
        segmentFor(c6).reclaimKey(iVar, c6);
    }

    void reclaimValue(f0 f0Var) {
        i a6 = f0Var.a();
        int c6 = a6.c();
        segmentFor(c6).reclaimValue(a6.getKey(), c6, f0Var);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public Object remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    @CanIgnoreReturnValue
    public Object replace(Object obj, Object obj2) {
        com.google.common.base.j.j(obj);
        com.google.common.base.j.j(obj2);
        int hash = hash(obj);
        return segmentFor(hash).replace(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    n segmentFor(int i6) {
        return this.segments[(i6 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j6 = 0;
        for (n nVar : this.segments) {
            j6 += nVar.count;
        }
        return com.google.common.primitives.b.g(j6);
    }

    com.google.common.base.c valueEquivalence() {
        return this.entryHelper.d().defaultEquivalence();
    }

    p valueStrength() {
        return this.entryHelper.d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<Object> values() {
        Collection<Object> collection = this.values;
        if (collection != null) {
            return collection;
        }
        x xVar = new x();
        this.values = xVar;
        return xVar;
    }

    Object writeReplace() {
        return new o(this.entryHelper.c(), this.entryHelper.d(), this.keyEquivalence, this.entryHelper.d().defaultEquivalence(), this.concurrencyLevel, this);
    }

    /* loaded from: classes.dex */
    static abstract class b extends com.google.common.collect.s implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<Object, Object> delegate;
        final com.google.common.base.c keyEquivalence;
        final p keyStrength;
        final com.google.common.base.c valueEquivalence;
        final p valueStrength;

        b(p pVar, p pVar2, com.google.common.base.c cVar, com.google.common.base.c cVar2, int i6, ConcurrentMap<Object, Object> concurrentMap) {
            this.keyStrength = pVar;
            this.valueStrength = pVar2;
            this.keyEquivalence = cVar;
            this.valueEquivalence = cVar2;
            this.concurrencyLevel = i6;
            this.delegate = concurrentMap;
        }

        void readEntries(ObjectInputStream objectInputStream) {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        q0 readMapMaker(ObjectInputStream objectInputStream) {
            return new q0().g(objectInputStream.readInt()).j(this.keyStrength).k(this.valueStrength).h(this.keyEquivalence).a(this.concurrencyLevel);
        }

        void writeMapTo(ObjectOutputStream objectOutputStream) {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<Object, Object> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.s, com.google.common.collect.t, com.google.common.collect.u
        public ConcurrentMap<Object, Object> delegate() {
            return this.delegate;
        }
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object compute(Object obj, j$.util.function.BiFunction biFunction) {
        return ConcurrentMap.CC.$default$compute(this, obj, biFunction);
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, j$.util.function.Function function) {
        return ConcurrentMap.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, j$.util.function.BiFunction biFunction) {
        return ConcurrentMap.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ void forEach(j$.util.function.BiConsumer biConsumer) {
        ConcurrentMap.CC.$default$forEach(this, biConsumer);
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, j$.util.function.BiFunction biFunction) {
        return ConcurrentMap.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    @CanIgnoreReturnValue
    public boolean replace(Object obj, @NullableDecl Object obj2, Object obj3) {
        com.google.common.base.j.j(obj);
        com.google.common.base.j.j(obj3);
        if (obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).replace(obj, hash, obj2, obj3);
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ void replaceAll(j$.util.function.BiFunction biFunction) {
        ConcurrentMap.CC.$default$replaceAll(this, biFunction);
    }
}
