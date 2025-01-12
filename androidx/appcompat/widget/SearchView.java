package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import okhttp3.HttpUrl;
import okhttp3.dnsoverhttps.DnsOverHttps;
/* loaded from: classes.dex */
public class SearchView extends j1 implements h.c {

    /* renamed from: o0  reason: collision with root package name */
    static final n f728o0;
    private Rect A;
    private Rect B;
    private int[] C;
    private int[] D;
    private final ImageView E;
    private final Drawable F;
    private final int G;
    private final int H;
    private final Intent I;
    private final Intent J;
    private final CharSequence K;
    View.OnFocusChangeListener L;
    private View.OnClickListener M;
    private boolean N;
    private boolean O;
    g0.a P;
    private boolean Q;
    private CharSequence R;
    private boolean S;
    private boolean T;
    private int U;
    private boolean V;
    private CharSequence W;

    /* renamed from: a0  reason: collision with root package name */
    private CharSequence f729a0;

    /* renamed from: b0  reason: collision with root package name */
    private boolean f730b0;

    /* renamed from: c0  reason: collision with root package name */
    private int f731c0;

    /* renamed from: d0  reason: collision with root package name */
    SearchableInfo f732d0;

    /* renamed from: e0  reason: collision with root package name */
    private Bundle f733e0;

    /* renamed from: f0  reason: collision with root package name */
    private final Runnable f734f0;

    /* renamed from: g0  reason: collision with root package name */
    private Runnable f735g0;

    /* renamed from: h0  reason: collision with root package name */
    private final WeakHashMap f736h0;

    /* renamed from: i0  reason: collision with root package name */
    private final View.OnClickListener f737i0;

    /* renamed from: j0  reason: collision with root package name */
    View.OnKeyListener f738j0;

    /* renamed from: k0  reason: collision with root package name */
    private final TextView.OnEditorActionListener f739k0;

    /* renamed from: l0  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f740l0;

    /* renamed from: m0  reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f741m0;

    /* renamed from: n0  reason: collision with root package name */
    private TextWatcher f742n0;

    /* renamed from: q  reason: collision with root package name */
    final SearchAutoComplete f743q;

    /* renamed from: r  reason: collision with root package name */
    private final View f744r;

    /* renamed from: s  reason: collision with root package name */
    private final View f745s;

    /* renamed from: t  reason: collision with root package name */
    private final View f746t;

    /* renamed from: u  reason: collision with root package name */
    final ImageView f747u;

    /* renamed from: v  reason: collision with root package name */
    final ImageView f748v;

    /* renamed from: w  reason: collision with root package name */
    final ImageView f749w;

    /* renamed from: x  reason: collision with root package name */
    final ImageView f750x;

    /* renamed from: y  reason: collision with root package name */
    private final View f751y;

    /* renamed from: z  reason: collision with root package name */
    private p f752z;

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends androidx.appcompat.widget.d {

        /* renamed from: e  reason: collision with root package name */
        private int f753e;

        /* renamed from: f  reason: collision with root package name */
        private SearchView f754f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f755g;

        /* renamed from: h  reason: collision with root package name */
        final Runnable f756h;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.c();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, b.a.f2707m);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i6 = configuration.screenWidthDp;
            int i7 = configuration.screenHeightDp;
            if (i6 < 960 || i7 < 720 || configuration.orientation != 2) {
                if (i6 < 600) {
                    return (i6 < 640 || i7 < 480) ? 160 : 192;
                }
                return 192;
            }
            return 256;
        }

        void a() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.f728o0.c(this);
                return;
            }
            setInputMethodMode(1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        boolean b() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void c() {
            if (this.f755g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f755g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f753e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f755g) {
                removeCallbacks(this.f756h);
                post(this.f756h);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z5, int i6, Rect rect) {
            super.onFocusChanged(z5, i6, rect);
            this.f754f.Z();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i6, KeyEvent keyEvent) {
            if (i6 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f754f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i6, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z5) {
            super.onWindowFocusChanged(z5);
            if (z5 && this.f754f.hasFocus() && getVisibility() == 0) {
                this.f755g = true;
                if (SearchView.M(getContext())) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z5) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z5) {
                this.f755g = false;
                removeCallbacks(this.f756h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (!inputMethodManager.isActive(this)) {
                this.f755g = true;
            } else {
                this.f755g = false;
                removeCallbacks(this.f756h);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f754f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i6) {
            super.setThreshold(i6);
            this.f753e = i6;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i6) {
            super(context, attributeSet, i6);
            this.f756h = new a();
            this.f753e = getThreshold();
        }
    }

    /* loaded from: classes.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            SearchView.this.Y(charSequence);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.f0();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g0.a aVar = SearchView.this.P;
            if (aVar instanceof x1) {
                aVar.a(null);
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z5) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.L;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z5);
            }
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
            SearchView.this.B();
        }
    }

    /* loaded from: classes.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f747u) {
                searchView.V();
            } else if (view == searchView.f749w) {
                searchView.R();
            } else if (view == searchView.f748v) {
                searchView.W();
            } else if (view == searchView.f750x) {
                searchView.a0();
            } else if (view == searchView.f743q) {
                searchView.H();
            }
        }
    }

    /* loaded from: classes.dex */
    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i6, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f732d0 == null) {
                return false;
            }
            if (!searchView.f743q.isPopupShowing() || SearchView.this.f743q.getListSelection() == -1) {
                if (!SearchView.this.f743q.b() && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i6 == 66) {
                    view.cancelLongPress();
                    SearchView searchView2 = SearchView.this;
                    searchView2.P(0, null, searchView2.f743q.getText().toString());
                    return true;
                }
                return false;
            }
            return SearchView.this.X(view, i6, keyEvent);
        }
    }

    /* loaded from: classes.dex */
    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i6, KeyEvent keyEvent) {
            SearchView.this.W();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
            SearchView.this.S(i6, 0, null);
        }
    }

    /* loaded from: classes.dex */
    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i6, long j6) {
            SearchView.this.T(i6);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* loaded from: classes.dex */
    public interface k {
    }

    /* loaded from: classes.dex */
    public interface l {
    }

    /* loaded from: classes.dex */
    public interface m {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class n {

        /* renamed from: a  reason: collision with root package name */
        private Method f768a;

        /* renamed from: b  reason: collision with root package name */
        private Method f769b;

        /* renamed from: c  reason: collision with root package name */
        private Method f770c;

        n() {
            this.f768a = null;
            this.f769b = null;
            this.f770c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f768a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f769b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f770c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f769b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f768a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f770c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class o extends h0.a {
        public static final Parcelable.Creator<o> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        boolean f771c;

        /* loaded from: classes.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public o createFromParcel(Parcel parcel) {
                return new o(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public o[] newArray(int i6) {
                return new o[i6];
            }
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f771c = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f771c + "}";
        }

        @Override // h0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeValue(Boolean.valueOf(this.f771c));
        }

        o(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes.dex */
    private static class p extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f772a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f773b;

        /* renamed from: c  reason: collision with root package name */
        private final Rect f774c;

        /* renamed from: d  reason: collision with root package name */
        private final Rect f775d;

        /* renamed from: e  reason: collision with root package name */
        private final int f776e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f777f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f776e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f773b = new Rect();
            this.f775d = new Rect();
            this.f774c = new Rect();
            a(rect, rect2);
            this.f772a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f773b.set(rect);
            this.f775d.set(rect);
            Rect rect3 = this.f775d;
            int i6 = this.f776e;
            rect3.inset(-i6, -i6);
            this.f774c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z5;
            float f6;
            int i6;
            boolean z6;
            int x5 = (int) motionEvent.getX();
            int y5 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z7 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z6 = this.f777f;
                    if (z6 && !this.f775d.contains(x5, y5)) {
                        z7 = z6;
                        z5 = false;
                    }
                } else {
                    if (action == 3) {
                        z6 = this.f777f;
                        this.f777f = false;
                    }
                    z5 = true;
                    z7 = false;
                }
                z7 = z6;
                z5 = true;
            } else {
                if (this.f773b.contains(x5, y5)) {
                    this.f777f = true;
                    z5 = true;
                }
                z5 = true;
                z7 = false;
            }
            if (z7) {
                if (!z5 || this.f774c.contains(x5, y5)) {
                    Rect rect = this.f774c;
                    f6 = x5 - rect.left;
                    i6 = y5 - rect.top;
                } else {
                    f6 = this.f772a.getWidth() / 2;
                    i6 = this.f772a.getHeight() / 2;
                }
                motionEvent.setLocation(f6, i6);
                return this.f772a.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    static {
        f728o0 = Build.VERSION.SDK_INT < 29 ? new n() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private Intent C(String str, Uri uri, String str2, String str3, int i6, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f729a0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f733e0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i6 != 0) {
            intent.putExtra("action_key", i6);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f732d0.getSearchActivity());
        return intent;
    }

    private Intent D(Cursor cursor, int i6, String str) {
        int i7;
        String o5;
        try {
            String o6 = x1.o(cursor, "suggest_intent_action");
            if (o6 == null) {
                o6 = this.f732d0.getSuggestIntentAction();
            }
            if (o6 == null) {
                o6 = "android.intent.action.SEARCH";
            }
            String str2 = o6;
            String o7 = x1.o(cursor, "suggest_intent_data");
            if (o7 == null) {
                o7 = this.f732d0.getSuggestIntentData();
            }
            if (o7 != null && (o5 = x1.o(cursor, "suggest_intent_data_id")) != null) {
                o7 = o7 + "/" + Uri.encode(o5);
            }
            return C(str2, o7 == null ? null : Uri.parse(o7), x1.o(cursor, "suggest_intent_extra_data"), x1.o(cursor, "suggest_intent_query"), i6, str);
        } catch (RuntimeException e6) {
            try {
                i7 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i7 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i7 + " returned exception.", e6);
            return null;
        }
    }

    private Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f733e0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void G() {
        this.f743q.dismissDropDown();
    }

    private void I(View view, Rect rect) {
        view.getLocationInWindow(this.C);
        getLocationInWindow(this.D);
        int[] iArr = this.C;
        int i6 = iArr[1];
        int[] iArr2 = this.D;
        int i7 = i6 - iArr2[1];
        int i8 = iArr[0] - iArr2[0];
        rect.set(i8, i7, view.getWidth() + i8, view.getHeight() + i7);
    }

    private CharSequence J(CharSequence charSequence) {
        if (!this.N || this.F == null) {
            return charSequence;
        }
        int textSize = (int) (this.f743q.getTextSize() * 1.25d);
        this.F.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.F), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean K() {
        SearchableInfo searchableInfo = this.f732d0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = this.f732d0.getVoiceSearchLaunchWebSearch() ? this.I : this.f732d0.getVoiceSearchLaunchRecognizer() ? this.J : null;
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, DnsOverHttps.MAX_RESPONSE_SIZE) == null) ? false : true;
    }

    static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean N() {
        return (this.Q || this.V) && !L();
    }

    private void O(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e6) {
            Log.e("SearchView", "Failed launch activity: " + intent, e6);
        }
    }

    private boolean Q(int i6, int i7, String str) {
        Cursor b6 = this.P.b();
        if (b6 == null || !b6.moveToPosition(i6)) {
            return false;
        }
        O(D(b6, i7, str));
        return true;
    }

    private void b0() {
        post(this.f734f0);
    }

    private void c0(int i6) {
        CharSequence c6;
        Editable text = this.f743q.getText();
        Cursor b6 = this.P.b();
        if (b6 == null) {
            return;
        }
        if (!b6.moveToPosition(i6) || (c6 = this.P.c(b6)) == null) {
            setQuery(text);
        } else {
            setQuery(c6);
        }
    }

    private void e0() {
        boolean z5 = true;
        boolean z6 = !TextUtils.isEmpty(this.f743q.getText());
        if (!z6 && (!this.N || this.f730b0)) {
            z5 = false;
        }
        this.f749w.setVisibility(z5 ? 0 : 8);
        Drawable drawable = this.f749w.getDrawable();
        if (drawable != null) {
            drawable.setState(z6 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void g0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f743q;
        if (queryHint == null) {
            queryHint = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(b.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(b.d.abc_search_view_preferred_width);
    }

    private void h0() {
        this.f743q.setThreshold(this.f732d0.getSuggestThreshold());
        this.f743q.setImeOptions(this.f732d0.getImeOptions());
        int inputType = this.f732d0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f732d0.getSuggestAuthority() != null) {
                inputType = inputType | DnsOverHttps.MAX_RESPONSE_SIZE | 524288;
            }
        }
        this.f743q.setInputType(inputType);
        g0.a aVar = this.P;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.f732d0.getSuggestAuthority() != null) {
            x1 x1Var = new x1(getContext(), this, this.f732d0, this.f736h0);
            this.P = x1Var;
            this.f743q.setAdapter(x1Var);
            ((x1) this.P).x(this.S ? 2 : 1);
        }
    }

    private void i0() {
        this.f746t.setVisibility((N() && (this.f748v.getVisibility() == 0 || this.f750x.getVisibility() == 0)) ? 0 : 8);
    }

    private void j0(boolean z5) {
        this.f748v.setVisibility((this.Q && N() && hasFocus() && (z5 || !this.V)) ? 0 : 8);
    }

    private void k0(boolean z5) {
        this.O = z5;
        int i6 = 0;
        int i7 = z5 ? 0 : 8;
        boolean z6 = !TextUtils.isEmpty(this.f743q.getText());
        this.f747u.setVisibility(i7);
        j0(z6);
        this.f744r.setVisibility(z5 ? 8 : 0);
        this.E.setVisibility((this.E.getDrawable() == null || this.N) ? 8 : 8);
        e0();
        l0(!z6);
        i0();
    }

    private void l0(boolean z5) {
        int i6 = 8;
        if (this.V && !L() && z5) {
            this.f748v.setVisibility(8);
            i6 = 0;
        }
        this.f750x.setVisibility(i6);
    }

    private void setQuery(CharSequence charSequence) {
        this.f743q.setText(charSequence);
        this.f743q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void B() {
        if (this.f751y.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f745s.getPaddingLeft();
            Rect rect = new Rect();
            boolean b6 = j2.b(this);
            int dimensionPixelSize = this.N ? resources.getDimensionPixelSize(b.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(b.d.abc_dropdownitem_text_padding_left) : 0;
            this.f743q.getDropDownBackground().getPadding(rect);
            int i6 = rect.left;
            this.f743q.setDropDownHorizontalOffset(b6 ? -i6 : paddingLeft - (i6 + dimensionPixelSize));
            this.f743q.setDropDownWidth((((this.f751y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f743q.refreshAutoCompleteResults();
            return;
        }
        n nVar = f728o0;
        nVar.b(this.f743q);
        nVar.a(this.f743q);
    }

    public boolean L() {
        return this.O;
    }

    void P(int i6, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", null, null, str2, i6, str));
    }

    void R() {
        if (!TextUtils.isEmpty(this.f743q.getText())) {
            this.f743q.setText(HttpUrl.FRAGMENT_ENCODE_SET);
            this.f743q.requestFocus();
            this.f743q.setImeVisibility(true);
        } else if (this.N) {
            clearFocus();
            k0(true);
        }
    }

    boolean S(int i6, int i7, String str) {
        Q(i6, 0, null);
        this.f743q.setImeVisibility(false);
        G();
        return true;
    }

    boolean T(int i6) {
        c0(i6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void V() {
        k0(false);
        this.f743q.requestFocus();
        this.f743q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.M;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void W() {
        Editable text = this.f743q.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f732d0 != null) {
            P(0, null, text.toString());
        }
        this.f743q.setImeVisibility(false);
        G();
    }

    boolean X(View view, int i6, KeyEvent keyEvent) {
        if (this.f732d0 != null && this.P != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i6 == 66 || i6 == 84 || i6 == 61) {
                return S(this.f743q.getListSelection(), 0, null);
            }
            if (i6 == 21 || i6 == 22) {
                this.f743q.setSelection(i6 == 21 ? 0 : this.f743q.length());
                this.f743q.setListSelection(0);
                this.f743q.clearListSelection();
                this.f743q.a();
                return true;
            } else if (i6 == 19) {
                this.f743q.getListSelection();
                return false;
            }
        }
        return false;
    }

    void Y(CharSequence charSequence) {
        Editable text = this.f743q.getText();
        this.f729a0 = text;
        boolean z5 = !TextUtils.isEmpty(text);
        j0(z5);
        l0(!z5);
        e0();
        i0();
        this.W = charSequence.toString();
    }

    void Z() {
        k0(L());
        b0();
        if (this.f743q.hasFocus()) {
            H();
        }
    }

    void a0() {
        Intent E;
        SearchableInfo searchableInfo = this.f732d0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                E = F(this.I, searchableInfo);
            } else if (!searchableInfo.getVoiceSearchLaunchRecognizer()) {
                return;
            } else {
                E = E(this.J, searchableInfo);
            }
            getContext().startActivity(E);
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    @Override // h.c
    public void c() {
        if (this.f730b0) {
            return;
        }
        this.f730b0 = true;
        int imeOptions = this.f743q.getImeOptions();
        this.f731c0 = imeOptions;
        this.f743q.setImeOptions(imeOptions | 33554432);
        this.f743q.setText(HttpUrl.FRAGMENT_ENCODE_SET);
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.T = true;
        super.clearFocus();
        this.f743q.clearFocus();
        this.f743q.setImeVisibility(false);
        this.T = false;
    }

    public void d0(CharSequence charSequence, boolean z5) {
        this.f743q.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f743q;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f729a0 = charSequence;
        }
        if (!z5 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        W();
    }

    @Override // h.c
    public void f() {
        d0(HttpUrl.FRAGMENT_ENCODE_SET, false);
        clearFocus();
        k0(true);
        this.f743q.setImeOptions(this.f731c0);
        this.f730b0 = false;
    }

    void f0() {
        int[] iArr = this.f743q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f745s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f746t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.f743q.getImeOptions();
    }

    public int getInputType() {
        return this.f743q.getInputType();
    }

    public int getMaxWidth() {
        return this.U;
    }

    public CharSequence getQuery() {
        return this.f743q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.R;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f732d0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.K : getContext().getText(this.f732d0.getHintId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.G;
    }

    public g0.a getSuggestionsAdapter() {
        return this.P;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f734f0);
        post(this.f735g0);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.j1, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (z5) {
            I(this.f743q, this.A);
            Rect rect = this.B;
            Rect rect2 = this.A;
            rect.set(rect2.left, 0, rect2.right, i9 - i7);
            p pVar = this.f752z;
            if (pVar != null) {
                pVar.a(this.B, this.A);
                return;
            }
            p pVar2 = new p(this.B, this.A, this.f743q);
            this.f752z = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r0 <= 0) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    @Override // androidx.appcompat.widget.j1, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i6, int i7) {
        int i8;
        int mode;
        if (L()) {
            super.onMeasure(i6, i7);
            return;
        }
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                size = this.U;
                if (size <= 0) {
                    size = getPreferredWidth();
                }
            } else if (mode2 == 1073741824) {
                i8 = this.U;
            }
            mode = View.MeasureSpec.getMode(i7);
            int size2 = View.MeasureSpec.getSize(i7);
            if (mode != Integer.MIN_VALUE) {
                size2 = Math.min(getPreferredHeight(), size2);
            } else if (mode == 0) {
                size2 = getPreferredHeight();
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
        i8 = this.U;
        if (i8 <= 0) {
            i8 = getPreferredWidth();
        }
        size = Math.min(i8, size);
        mode = View.MeasureSpec.getMode(i7);
        int size22 = View.MeasureSpec.getSize(i7);
        if (mode != Integer.MIN_VALUE) {
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size22, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.e());
        k0(oVar.f771c);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.f771c = L();
        return oVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        b0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i6, Rect rect) {
        if (!this.T && isFocusable()) {
            if (L()) {
                return super.requestFocus(i6, rect);
            }
            boolean requestFocus = this.f743q.requestFocus(i6, rect);
            if (requestFocus) {
                k0(false);
            }
            return requestFocus;
        }
        return false;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f733e0 = bundle;
    }

    public void setIconified(boolean z5) {
        if (z5) {
            R();
        } else {
            V();
        }
    }

    public void setIconifiedByDefault(boolean z5) {
        if (this.N == z5) {
            return;
        }
        this.N = z5;
        k0(z5);
        g0();
    }

    public void setImeOptions(int i6) {
        this.f743q.setImeOptions(i6);
    }

    public void setInputType(int i6) {
        this.f743q.setInputType(i6);
    }

    public void setMaxWidth(int i6) {
        this.U = i6;
        requestLayout();
    }

    public void setOnCloseListener(k kVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.L = onFocusChangeListener;
    }

    public void setOnQueryTextListener(l lVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.M = onClickListener;
    }

    public void setOnSuggestionListener(m mVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.R = charSequence;
        g0();
    }

    public void setQueryRefinementEnabled(boolean z5) {
        this.S = z5;
        g0.a aVar = this.P;
        if (aVar instanceof x1) {
            ((x1) aVar).x(z5 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f732d0 = searchableInfo;
        if (searchableInfo != null) {
            h0();
            g0();
        }
        boolean K = K();
        this.V = K;
        if (K) {
            this.f743q.setPrivateImeOptions("nm");
        }
        k0(L());
    }

    public void setSubmitButtonEnabled(boolean z5) {
        this.Q = z5;
        k0(L());
    }

    public void setSuggestionsAdapter(g0.a aVar) {
        this.P = aVar;
        this.f743q.setAdapter(aVar);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.A = new Rect();
        this.B = new Rect();
        this.C = new int[2];
        this.D = new int[2];
        this.f734f0 = new b();
        this.f735g0 = new c();
        this.f736h0 = new WeakHashMap();
        f fVar = new f();
        this.f737i0 = fVar;
        this.f738j0 = new g();
        h hVar = new h();
        this.f739k0 = hVar;
        i iVar = new i();
        this.f740l0 = iVar;
        j jVar = new j();
        this.f741m0 = jVar;
        this.f742n0 = new a();
        c2 v5 = c2.v(context, attributeSet, b.j.f2755i2, i6, 0);
        LayoutInflater.from(context).inflate(v5.n(b.j.f2805s2, b.g.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(b.f.search_src_text);
        this.f743q = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f744r = findViewById(b.f.search_edit_frame);
        View findViewById = findViewById(b.f.search_plate);
        this.f745s = findViewById;
        View findViewById2 = findViewById(b.f.submit_area);
        this.f746t = findViewById2;
        ImageView imageView = (ImageView) findViewById(b.f.search_button);
        this.f747u = imageView;
        ImageView imageView2 = (ImageView) findViewById(b.f.search_go_btn);
        this.f748v = imageView2;
        ImageView imageView3 = (ImageView) findViewById(b.f.search_close_btn);
        this.f749w = imageView3;
        ImageView imageView4 = (ImageView) findViewById(b.f.search_voice_btn);
        this.f750x = imageView4;
        ImageView imageView5 = (ImageView) findViewById(b.f.search_mag_icon);
        this.E = imageView5;
        e0.b0.o0(findViewById, v5.g(b.j.f2810t2));
        e0.b0.o0(findViewById2, v5.g(b.j.f2830x2));
        int i7 = b.j.f2825w2;
        imageView.setImageDrawable(v5.g(i7));
        imageView2.setImageDrawable(v5.g(b.j.f2795q2));
        imageView3.setImageDrawable(v5.g(b.j.f2780n2));
        imageView4.setImageDrawable(v5.g(b.j.f2840z2));
        imageView5.setImageDrawable(v5.g(i7));
        this.F = v5.g(b.j.f2820v2);
        f2.a(imageView, getResources().getString(b.h.abc_searchview_description_search));
        this.G = v5.n(b.j.f2835y2, b.g.abc_search_dropdown_item_icons_2line);
        this.H = v5.n(b.j.f2785o2, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f742n0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f738j0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(v5.a(b.j.f2800r2, true));
        int f6 = v5.f(b.j.f2765k2, -1);
        if (f6 != -1) {
            setMaxWidth(f6);
        }
        this.K = v5.p(b.j.f2790p2);
        this.R = v5.p(b.j.f2815u2);
        int k6 = v5.k(b.j.f2775m2, -1);
        if (k6 != -1) {
            setImeOptions(k6);
        }
        int k7 = v5.k(b.j.f2770l2, -1);
        if (k7 != -1) {
            setInputType(k7);
        }
        setFocusable(v5.a(b.j.f2760j2, true));
        v5.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.I = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.J = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f751y = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        k0(this.N);
        g0();
    }
}
