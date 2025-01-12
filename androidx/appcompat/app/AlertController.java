package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.j1;
import androidx.core.widget.NestedScrollView;
import b.j;
import e0.b0;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* renamed from: a  reason: collision with root package name */
    private final Context f238a;

    /* renamed from: b  reason: collision with root package name */
    final d.h f239b;

    /* renamed from: c  reason: collision with root package name */
    private final Window f240c;

    /* renamed from: d  reason: collision with root package name */
    private final int f241d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f242e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f243f;

    /* renamed from: g  reason: collision with root package name */
    ListView f244g;

    /* renamed from: h  reason: collision with root package name */
    private View f245h;

    /* renamed from: i  reason: collision with root package name */
    private int f246i;

    /* renamed from: j  reason: collision with root package name */
    private int f247j;

    /* renamed from: k  reason: collision with root package name */
    private int f248k;

    /* renamed from: l  reason: collision with root package name */
    private int f249l;

    /* renamed from: m  reason: collision with root package name */
    private int f250m;

    /* renamed from: o  reason: collision with root package name */
    Button f252o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f253p;

    /* renamed from: q  reason: collision with root package name */
    Message f254q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f255r;

    /* renamed from: s  reason: collision with root package name */
    Button f256s;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f257t;

    /* renamed from: u  reason: collision with root package name */
    Message f258u;

    /* renamed from: v  reason: collision with root package name */
    private Drawable f259v;

    /* renamed from: w  reason: collision with root package name */
    Button f260w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f261x;

    /* renamed from: y  reason: collision with root package name */
    Message f262y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f263z;

    /* renamed from: n  reason: collision with root package name */
    private boolean f251n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new a();

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: b  reason: collision with root package name */
        private final int f264b;

        /* renamed from: c  reason: collision with root package name */
        private final int f265c;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f2740f2);
            this.f265c = obtainStyledAttributes.getDimensionPixelOffset(j.f2745g2, -1);
            this.f264b = obtainStyledAttributes.getDimensionPixelOffset(j.f2750h2, -1);
        }

        public void a(boolean z5, boolean z6) {
            if (z6 && z5) {
                return;
            }
            setPadding(getPaddingLeft(), z5 ? getPaddingTop() : this.f264b, getPaddingRight(), z6 ? getPaddingBottom() : this.f265c);
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            AlertController alertController = AlertController.this;
            Message obtain = ((view != alertController.f252o || (message2 = alertController.f254q) == null) && (view != alertController.f256s || (message2 = alertController.f258u) == null)) ? (view != alertController.f260w || (message = alertController.f262y) == null) ? null : Message.obtain(message) : Message.obtain(message2);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f239b).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f267a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f268b;

        b(View view, View view2) {
            this.f267a = view;
            this.f268b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.b
        public void a(NestedScrollView nestedScrollView, int i6, int i7, int i8, int i9) {
            AlertController.f(nestedScrollView, this.f267a, this.f268b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f270a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f271b;

        c(View view, View view2) {
            this.f270a = view;
            this.f271b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.A, this.f270a, this.f271b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements AbsListView.OnScrollListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f273b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f274c;

        d(View view, View view2) {
            this.f273b = view;
            this.f274c = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i6, int i7, int i8) {
            AlertController.f(absListView, this.f273b, this.f274c);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f276a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f277b;

        e(View view, View view2) {
            this.f276a = view;
            this.f277b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.f244g, this.f276a, this.f277b);
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;

        /* renamed from: a  reason: collision with root package name */
        public final Context f279a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f280b;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f282d;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f284f;

        /* renamed from: g  reason: collision with root package name */
        public View f285g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f286h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f287i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f288j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f289k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f290l;

        /* renamed from: m  reason: collision with root package name */
        public Drawable f291m;

        /* renamed from: n  reason: collision with root package name */
        public DialogInterface.OnClickListener f292n;

        /* renamed from: o  reason: collision with root package name */
        public CharSequence f293o;

        /* renamed from: p  reason: collision with root package name */
        public Drawable f294p;

        /* renamed from: q  reason: collision with root package name */
        public DialogInterface.OnClickListener f295q;

        /* renamed from: s  reason: collision with root package name */
        public DialogInterface.OnCancelListener f297s;

        /* renamed from: t  reason: collision with root package name */
        public DialogInterface.OnDismissListener f298t;

        /* renamed from: u  reason: collision with root package name */
        public DialogInterface.OnKeyListener f299u;

        /* renamed from: v  reason: collision with root package name */
        public CharSequence[] f300v;

        /* renamed from: w  reason: collision with root package name */
        public ListAdapter f301w;

        /* renamed from: x  reason: collision with root package name */
        public DialogInterface.OnClickListener f302x;

        /* renamed from: y  reason: collision with root package name */
        public int f303y;

        /* renamed from: z  reason: collision with root package name */
        public View f304z;

        /* renamed from: c  reason: collision with root package name */
        public int f281c = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f283e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean O = true;

        /* renamed from: r  reason: collision with root package name */
        public boolean f296r = true;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends ArrayAdapter {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ RecycleListView f305b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i6, int i7, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i6, i7, charSequenceArr);
                this.f305b = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i6, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i6, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i6]) {
                    this.f305b.setItemChecked(i6, true);
                }
                return view2;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b extends CursorAdapter {

            /* renamed from: b  reason: collision with root package name */
            private final int f307b;

            /* renamed from: c  reason: collision with root package name */
            private final int f308c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ RecycleListView f309d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ AlertController f310e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z5, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z5);
                this.f309d = recycleListView;
                this.f310e = alertController;
                Cursor cursor2 = getCursor();
                this.f307b = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f308c = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f307b));
                this.f309d.setItemChecked(cursor.getPosition(), cursor.getInt(this.f308c) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f280b.inflate(this.f310e.M, viewGroup, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AlertController f312b;

            c(AlertController alertController) {
                this.f312b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                f.this.f302x.onClick(this.f312b.f239b, i6);
                if (f.this.H) {
                    return;
                }
                this.f312b.f239b.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ RecycleListView f314b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ AlertController f315c;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f314b = recycleListView;
                this.f315c = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i6] = this.f314b.isItemChecked(i6);
                }
                f.this.J.onClick(this.f315c.f239b, i6, this.f314b.isItemChecked(i6));
            }
        }

        public f(Context context) {
            this.f279a = context;
            this.f280b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void b(AlertController alertController) {
            ListAdapter listAdapter;
            AdapterView.OnItemClickListener dVar;
            AdapterView.OnItemSelectedListener onItemSelectedListener;
            RecycleListView recycleListView = (RecycleListView) this.f280b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                listAdapter = this.K == null ? new a(this.f279a, alertController.M, 16908308, this.f300v, recycleListView) : new b(this.f279a, this.K, false, recycleListView, alertController);
            } else {
                int i6 = this.H ? alertController.N : alertController.O;
                if (this.K != null) {
                    listAdapter = new SimpleCursorAdapter(this.f279a, i6, this.K, new String[]{this.L}, new int[]{16908308});
                } else {
                    listAdapter = this.f301w;
                    if (listAdapter == null) {
                        listAdapter = new h(this.f279a, i6, 16908308, this.f300v);
                    }
                }
            }
            alertController.H = listAdapter;
            alertController.I = this.I;
            if (this.f302x == null) {
                if (this.J != null) {
                    dVar = new d(recycleListView, alertController);
                }
                onItemSelectedListener = this.N;
                if (onItemSelectedListener != null) {
                    recycleListView.setOnItemSelectedListener(onItemSelectedListener);
                }
                if (!this.H) {
                    recycleListView.setChoiceMode(1);
                } else if (this.G) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.f244g = recycleListView;
            }
            dVar = new c(alertController);
            recycleListView.setOnItemClickListener(dVar);
            onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
            }
            if (!this.H) {
            }
            alertController.f244g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f285g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f284f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f282d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i6 = this.f281c;
                if (i6 != 0) {
                    alertController.m(i6);
                }
                int i7 = this.f283e;
                if (i7 != 0) {
                    alertController.m(alertController.c(i7));
                }
            }
            CharSequence charSequence2 = this.f286h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f287i;
            if (charSequence3 != null || this.f288j != null) {
                alertController.k(-1, charSequence3, this.f289k, null, this.f288j);
            }
            CharSequence charSequence4 = this.f290l;
            if (charSequence4 != null || this.f291m != null) {
                alertController.k(-2, charSequence4, this.f292n, null, this.f291m);
            }
            CharSequence charSequence5 = this.f293o;
            if (charSequence5 != null || this.f294p != null) {
                alertController.k(-3, charSequence5, this.f295q, null, this.f294p);
            }
            if (this.f300v != null || this.K != null || this.f301w != null) {
                b(alertController);
            }
            View view2 = this.f304z;
            if (view2 != null) {
                if (this.E) {
                    alertController.t(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.s(view2);
                    return;
                }
            }
            int i8 = this.f303y;
            if (i8 != 0) {
                alertController.r(i8);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference f317a;

        public g(DialogInterface dialogInterface) {
            this.f317a = new WeakReference(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i6 = message.what;
            if (i6 == -3 || i6 == -2 || i6 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f317a.get(), message.what);
            } else if (i6 != 1) {
            } else {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends ArrayAdapter {
        public h(Context context, int i6, int i7, CharSequence[] charSequenceArr) {
            super(context, i6, i7, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i6) {
            return i6;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, d.h hVar, Window window) {
        this.f238a = context;
        this.f239b = hVar;
        this.f240c = window;
        this.R = new g(hVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.F, b.a.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(j.G, 0);
        this.K = obtainStyledAttributes.getResourceId(j.I, 0);
        this.L = obtainStyledAttributes.getResourceId(j.K, 0);
        this.M = obtainStyledAttributes.getResourceId(j.L, 0);
        this.N = obtainStyledAttributes.getResourceId(j.N, 0);
        this.O = obtainStyledAttributes.getResourceId(j.J, 0);
        this.P = obtainStyledAttributes.getBoolean(j.M, true);
        this.f241d = obtainStyledAttributes.getDimensionPixelSize(j.H, 0);
        obtainStyledAttributes.recycle();
        hVar.e(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (a(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void f(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i6 = this.K;
        return (i6 != 0 && this.Q == 1) ? i6 : this.J;
    }

    private void p(ViewGroup viewGroup, View view, int i6, int i7) {
        View view2;
        Runnable eVar;
        View findViewById = this.f240c.findViewById(b.f.scrollIndicatorUp);
        View findViewById2 = this.f240c.findViewById(b.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT < 23) {
            if (findViewById != null && (i6 & 1) == 0) {
                viewGroup.removeView(findViewById);
                findViewById = null;
            }
            if (findViewById2 != null && (i6 & 2) == 0) {
                viewGroup.removeView(findViewById2);
                findViewById2 = null;
            }
            if (findViewById == null && findViewById2 == null) {
                return;
            }
            if (this.f243f != null) {
                this.A.setOnScrollChangeListener(new b(findViewById, findViewById2));
                view2 = this.A;
                eVar = new c(findViewById, findViewById2);
            } else {
                ListView listView = this.f244g;
                if (listView != null) {
                    listView.setOnScrollListener(new d(findViewById, findViewById2));
                    view2 = this.f244g;
                    eVar = new e(findViewById, findViewById2);
                } else {
                    if (findViewById != null) {
                        viewGroup.removeView(findViewById);
                    }
                    if (findViewById2 == null) {
                        return;
                    }
                }
            }
            view2.post(eVar);
            return;
        }
        b0.y0(view, i6, i7);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 == null) {
            return;
        }
        viewGroup.removeView(findViewById2);
    }

    private void u(ViewGroup viewGroup) {
        boolean z5;
        Button button;
        Button button2 = (Button) viewGroup.findViewById(16908313);
        this.f252o = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f253p) && this.f255r == null) {
            this.f252o.setVisibility(8);
            z5 = false;
        } else {
            this.f252o.setText(this.f253p);
            Drawable drawable = this.f255r;
            if (drawable != null) {
                int i6 = this.f241d;
                drawable.setBounds(0, 0, i6, i6);
                this.f252o.setCompoundDrawables(this.f255r, null, null, null);
            }
            this.f252o.setVisibility(0);
            z5 = true;
        }
        Button button3 = (Button) viewGroup.findViewById(16908314);
        this.f256s = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f257t) && this.f259v == null) {
            this.f256s.setVisibility(8);
        } else {
            this.f256s.setText(this.f257t);
            Drawable drawable2 = this.f259v;
            if (drawable2 != null) {
                int i7 = this.f241d;
                drawable2.setBounds(0, 0, i7, i7);
                this.f256s.setCompoundDrawables(this.f259v, null, null, null);
            }
            this.f256s.setVisibility(0);
            z5 |= true;
        }
        Button button4 = (Button) viewGroup.findViewById(16908315);
        this.f260w = button4;
        button4.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f261x) && this.f263z == null) {
            this.f260w.setVisibility(8);
        } else {
            this.f260w.setText(this.f261x);
            Drawable drawable3 = this.f263z;
            if (drawable3 != null) {
                int i8 = this.f241d;
                drawable3.setBounds(0, 0, i8, i8);
                this.f260w.setCompoundDrawables(this.f263z, null, null, null);
            }
            this.f260w.setVisibility(0);
            z5 |= true;
        }
        if (z(this.f238a)) {
            if (z5) {
                button = this.f252o;
            } else if (z5) {
                button = this.f256s;
            } else if (z5) {
                button = this.f260w;
            }
            b(button);
        }
        if (z5) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f240c.findViewById(b.f.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f243f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f244g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int indexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(indexOfChild);
        viewGroup2.addView(this.f244g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void w(ViewGroup viewGroup) {
        View view = this.f245h;
        if (view == null) {
            view = this.f246i != 0 ? LayoutInflater.from(this.f238a).inflate(this.f246i, viewGroup, false) : null;
        }
        boolean z5 = view != null;
        if (!z5 || !a(view)) {
            this.f240c.setFlags(131072, 131072);
        }
        if (!z5) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f240c.findViewById(b.f.custom);
        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        if (this.f251n) {
            frameLayout.setPadding(this.f247j, this.f248k, this.f249l, this.f250m);
        }
        if (this.f244g != null) {
            ((j1.a) viewGroup.getLayoutParams()).f984a = 0.0f;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [android.view.View] */
    private void x(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            viewGroup2 = this.f240c.findViewById(b.f.title_template);
        } else {
            this.D = (ImageView) this.f240c.findViewById(16908294);
            if ((!TextUtils.isEmpty(this.f242e)) && this.P) {
                TextView textView = (TextView) this.f240c.findViewById(b.f.alertTitle);
                this.E = textView;
                textView.setText(this.f242e);
                int i6 = this.B;
                if (i6 != 0) {
                    this.D.setImageResource(i6);
                    return;
                }
                Drawable drawable = this.C;
                if (drawable != null) {
                    this.D.setImageDrawable(drawable);
                    return;
                }
                this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
                this.D.setVisibility(8);
                return;
            }
            this.f240c.findViewById(b.f.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup2 = viewGroup;
        }
        viewGroup2.setVisibility(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0092, code lost:
        if (r1 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009d, code lost:
        if (r1 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
        r1.setVisibility(0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void y() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f240c.findViewById(b.f.parentPanel);
        int i6 = b.f.topPanel;
        View findViewById4 = findViewById3.findViewById(i6);
        int i7 = b.f.contentPanel;
        View findViewById5 = findViewById3.findViewById(i7);
        int i8 = b.f.buttonPanel;
        View findViewById6 = findViewById3.findViewById(i8);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(b.f.customPanel);
        w(viewGroup);
        View findViewById7 = viewGroup.findViewById(i6);
        View findViewById8 = viewGroup.findViewById(i7);
        View findViewById9 = viewGroup.findViewById(i8);
        ViewGroup i9 = i(findViewById7, findViewById4);
        ViewGroup i10 = i(findViewById8, findViewById5);
        ViewGroup i11 = i(findViewById9, findViewById6);
        v(i10);
        u(i11);
        x(i9);
        boolean z5 = viewGroup.getVisibility() != 8;
        boolean z6 = (i9 == null || i9.getVisibility() == 8) ? 0 : 1;
        boolean z7 = (i11 == null || i11.getVisibility() == 8) ? false : true;
        if (!z7 && i10 != null && (findViewById2 = i10.findViewById(b.f.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z6) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            findViewById = (this.f243f == null && this.f244g == null) ? null : i9.findViewById(b.f.titleDividerNoCustom);
        } else if (i10 != null) {
            findViewById = i10.findViewById(b.f.textSpacerNoTitle);
        }
        ListView listView = this.f244g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z6, z7);
        }
        if (!z5) {
            View view = this.f244g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                p(i10, view, z6 | (z7 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f244g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i12 = this.I;
        if (i12 > -1) {
            listView2.setItemChecked(i12, true);
            listView2.setSelection(i12);
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public int c(int i6) {
        TypedValue typedValue = new TypedValue();
        this.f238a.getTheme().resolveAttribute(i6, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f244g;
    }

    public void e() {
        this.f239b.setContentView(j());
        y();
    }

    public boolean g(int i6, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public boolean h(int i6, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public void k(int i6, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i6, onClickListener);
        }
        if (i6 == -3) {
            this.f261x = charSequence;
            this.f262y = message;
            this.f263z = drawable;
        } else if (i6 == -2) {
            this.f257t = charSequence;
            this.f258u = message;
            this.f259v = drawable;
        } else if (i6 != -1) {
            throw new IllegalArgumentException("Button does not exist");
        } else {
            this.f253p = charSequence;
            this.f254q = message;
            this.f255r = drawable;
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i6) {
        this.C = null;
        this.B = i6;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i6 == 0) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
        }
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            this.D.setImageDrawable(drawable);
        }
    }

    public void o(CharSequence charSequence) {
        this.f243f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f242e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i6) {
        this.f245h = null;
        this.f246i = i6;
        this.f251n = false;
    }

    public void s(View view) {
        this.f245h = view;
        this.f246i = 0;
        this.f251n = false;
    }

    public void t(View view, int i6, int i7, int i8, int i9) {
        this.f245h = view;
        this.f246i = 0;
        this.f251n = true;
        this.f247j = i6;
        this.f248k = i7;
        this.f249l = i8;
        this.f250m = i9;
    }
}
