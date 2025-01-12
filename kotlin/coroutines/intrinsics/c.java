package kotlin.coroutines.intrinsics;

import h4.l;
import kotlin.coroutines.jvm.internal.g;
import kotlin.coroutines.jvm.internal.i;
import kotlin.jvm.internal.v;
import p4.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c {

    /* loaded from: classes.dex */
    public static final class a extends i {
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j4.a aVar, p pVar, Object obj) {
            super(aVar);
            this.$this_createCoroutineUnintercepted$inlined = pVar;
            this.$receiver$inlined = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            int i6 = this.label;
            if (i6 == 0) {
                this.label = 1;
                l.b(obj);
                return ((p) v.b(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
            } else if (i6 == 1) {
                this.label = 2;
                l.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends kotlin.coroutines.jvm.internal.c {
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j4.a aVar, j4.c cVar, p pVar, Object obj) {
            super(aVar, cVar);
            this.$this_createCoroutineUnintercepted$inlined = pVar;
            this.$receiver$inlined = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            int i6 = this.label;
            if (i6 == 0) {
                this.label = 1;
                l.b(obj);
                return ((p) v.b(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
            } else if (i6 == 1) {
                this.label = 2;
                l.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    public static j4.a a(p pVar, Object obj, j4.a aVar) {
        kotlin.jvm.internal.l.d(pVar, "<this>");
        kotlin.jvm.internal.l.d(aVar, "completion");
        j4.a a6 = g.a(aVar);
        if (pVar instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) pVar).create(obj, a6);
        }
        j4.c context = a6.getContext();
        return context == j4.d.INSTANCE ? new a(a6, pVar, obj) : new b(a6, context, pVar, obj);
    }
}
