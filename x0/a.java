package x0;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import java.util.List;
/* loaded from: classes.dex */
public class a extends ScrollView {

    /* renamed from: b  reason: collision with root package name */
    private int f14159b;

    /* renamed from: c  reason: collision with root package name */
    private int f14160c;

    /* renamed from: d  reason: collision with root package name */
    private x0.b f14161d;

    /* renamed from: e  reason: collision with root package name */
    private List f14162e;

    /* renamed from: f  reason: collision with root package name */
    private c f14163f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14164g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14165h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14166i;

    /* renamed from: j  reason: collision with root package name */
    private MotionEvent f14167j;

    /* renamed from: k  reason: collision with root package name */
    private ViewGroup f14168k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0223a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f14169a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MotionEvent f14170b;

        RunnableC0223a(ViewGroup viewGroup, MotionEvent motionEvent) {
            this.f14169a = viewGroup;
            this.f14170b = motionEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14169a.dispatchTouchEvent(this.f14170b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new C0224a();

        /* renamed from: a  reason: collision with root package name */
        int f14172a;

        /* renamed from: b  reason: collision with root package name */
        int f14173b;

        /* renamed from: x0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0224a implements Parcelable.Creator {
            C0224a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public b[] newArray(int i6) {
                return new b[i6];
            }
        }

        private b(Parcel parcel) {
            super(parcel);
            this.f14172a = parcel.readInt();
            this.f14173b = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f14172a);
            parcel.writeInt(this.f14173b);
        }

        /* synthetic */ b(Parcel parcel, RunnableC0223a runnableC0223a) {
            this(parcel);
        }

        b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public a(Context context) {
        super(context);
    }

    private void a() {
        x0.b bVar = this.f14161d;
        if (bVar != null) {
            bVar.b();
        }
        if (this.f14162e != null) {
            for (int i6 = 0; i6 < this.f14162e.size(); i6++) {
                ((x0.b) this.f14162e.get(i6)).b();
            }
        }
    }

    private void b(int i6, boolean z5, boolean z6) {
        x0.b bVar = this.f14161d;
        if (bVar != null) {
            bVar.c(i6, z5, z6);
        }
        if (this.f14162e != null) {
            for (int i7 = 0; i7 < this.f14162e.size(); i7++) {
                ((x0.b) this.f14162e.get(i7)).c(i6, z5, z6);
            }
        }
    }

    private void c(c cVar) {
        x0.b bVar = this.f14161d;
        if (bVar != null) {
            bVar.a(cVar);
        }
        if (this.f14162e != null) {
            for (int i6 = 0; i6 < this.f14162e.size(); i6++) {
                ((x0.b) this.f14162e.get(i6)).a(cVar);
            }
        }
    }

    private boolean d() {
        return this.f14161d == null && this.f14162e == null;
    }

    public int getCurrentScrollY() {
        return this.f14160c;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (d()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f14165h = true;
            this.f14164g = true;
            a();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        this.f14159b = bVar.f14172a;
        this.f14160c = bVar.f14173b;
        super.onRestoreInstanceState(bVar.getSuperState());
    }

    @Override // android.widget.ScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f14172a = this.f14159b;
        bVar.f14173b = this.f14160c;
        return bVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i6, int i7, int i8, int i9) {
        c cVar;
        super.onScrollChanged(i6, i7, i8, i9);
        if (d()) {
            return;
        }
        this.f14160c = i7;
        b(i7, this.f14164g, this.f14165h);
        if (this.f14164g) {
            this.f14164g = false;
        }
        int i10 = this.f14159b;
        if (i10 >= i7) {
            if (i7 < i10) {
                cVar = c.DOWN;
            }
            this.f14159b = i7;
        }
        cVar = c.UP;
        this.f14163f = cVar;
        this.f14159b = i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.widget.ScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (d()) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.f14167j == null) {
                    this.f14167j = motionEvent;
                }
                float y5 = motionEvent.getY() - this.f14167j.getY();
                this.f14167j = MotionEvent.obtainNoHistory(motionEvent);
                float currentScrollY = getCurrentScrollY() - y5;
                float f6 = 0.0f;
                if (currentScrollY <= 0.0f) {
                    if (this.f14166i) {
                        return false;
                    }
                    ViewGroup viewGroup = this.f14168k;
                    if (viewGroup == null) {
                        viewGroup = (ViewGroup) getParent();
                    }
                    float f7 = 0.0f;
                    for (View view = this; view != null && view != viewGroup; view = (View) view.getParent()) {
                        f6 += view.getLeft() - view.getScrollX();
                        f7 += view.getTop() - view.getScrollY();
                    }
                    MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                    obtainNoHistory.offsetLocation(f6, f7);
                    if (viewGroup.onInterceptTouchEvent(obtainNoHistory)) {
                        this.f14166i = true;
                        obtainNoHistory.setAction(0);
                        post(new RunnableC0223a(viewGroup, obtainNoHistory));
                        return false;
                    }
                    return super.onTouchEvent(motionEvent);
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        this.f14166i = false;
        this.f14165h = false;
        c(this.f14163f);
        return super.onTouchEvent(motionEvent);
    }

    public void setScrollViewCallbacks(x0.b bVar) {
        this.f14161d = bVar;
    }

    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.f14168k = viewGroup;
    }
}
