package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class x1 extends g0.c implements View.OnClickListener {

    /* renamed from: m  reason: collision with root package name */
    private final SearchView f1117m;

    /* renamed from: n  reason: collision with root package name */
    private final SearchableInfo f1118n;

    /* renamed from: o  reason: collision with root package name */
    private final Context f1119o;

    /* renamed from: p  reason: collision with root package name */
    private final WeakHashMap f1120p;

    /* renamed from: q  reason: collision with root package name */
    private final int f1121q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1122r;

    /* renamed from: s  reason: collision with root package name */
    private int f1123s;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f1124t;

    /* renamed from: u  reason: collision with root package name */
    private int f1125u;

    /* renamed from: v  reason: collision with root package name */
    private int f1126v;

    /* renamed from: w  reason: collision with root package name */
    private int f1127w;

    /* renamed from: x  reason: collision with root package name */
    private int f1128x;

    /* renamed from: y  reason: collision with root package name */
    private int f1129y;

    /* renamed from: z  reason: collision with root package name */
    private int f1130z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f1131a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1132b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f1133c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f1134d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f1135e;

        public a(View view) {
            this.f1131a = (TextView) view.findViewById(16908308);
            this.f1132b = (TextView) view.findViewById(16908309);
            this.f1133c = (ImageView) view.findViewById(16908295);
            this.f1134d = (ImageView) view.findViewById(16908296);
            this.f1135e = (ImageView) view.findViewById(b.f.edit_query);
        }
    }

    public x1(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1122r = false;
        this.f1123s = 1;
        this.f1125u = -1;
        this.f1126v = -1;
        this.f1127w = -1;
        this.f1128x = -1;
        this.f1129y = -1;
        this.f1130z = -1;
        this.f1117m = searchView;
        this.f1118n = searchableInfo;
        this.f1121q = searchView.getSuggestionCommitIconResId();
        this.f1119o = context;
        this.f1120p = weakHashMap;
    }

    private void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1120p.put(str, drawable.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable k(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f1120p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence l(CharSequence charSequence) {
        if (this.f1124t == null) {
            TypedValue typedValue = new TypedValue();
            this.f10319e.getTheme().resolveAttribute(b.a.textColorSearchUrl, typedValue, true);
            this.f1124t = this.f10319e.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1124t, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) {
        String obj;
        ActivityInfo activityInfo;
        int iconResource;
        PackageManager packageManager = this.f10319e.getPackageManager();
        try {
            activityInfo = packageManager.getActivityInfo(componentName, 128);
            iconResource = activityInfo.getIconResource();
        } catch (PackageManager.NameNotFoundException e6) {
            obj = e6.toString();
        }
        if (iconResource == 0) {
            return null;
        }
        Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
        if (drawable == null) {
            obj = "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString();
            Log.w("SuggestionsAdapter", obj);
            return null;
        }
        return drawable;
    }

    private Drawable n(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (!this.f1120p.containsKey(flattenToShortString)) {
            Drawable m5 = m(componentName);
            this.f1120p.put(flattenToShortString, m5 != null ? m5.getConstantState() : null);
            return m5;
        }
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f1120p.get(flattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f1119o.getResources());
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    private Drawable p() {
        Drawable n5 = n(this.f1118n.getSearchActivity());
        return n5 != null ? n5 : this.f10319e.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f1119o.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
            } catch (IOException e6) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e6);
            }
            return createFromStream;
        } catch (FileNotFoundException e7) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e7.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e7.getMessage());
        return null;
    }

    private Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1119o.getPackageName() + "/" + parseInt;
            Drawable k6 = k(str2);
            if (k6 != null) {
                return k6;
            }
            Drawable c6 = u.c.c(this.f1119o, parseInt);
            A(str2, c6);
            return c6;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable k7 = k(str);
            if (k7 != null) {
                return k7;
            }
            Drawable q5 = q(Uri.parse(str));
            A(str, q5);
            return q5;
        }
    }

    private Drawable t(Cursor cursor) {
        int i6 = this.f1128x;
        if (i6 == -1) {
            return null;
        }
        Drawable s5 = s(cursor.getString(i6));
        return s5 != null ? s5 : p();
    }

    private Drawable u(Cursor cursor) {
        int i6 = this.f1129y;
        if (i6 == -1) {
            return null;
        }
        return s(cursor.getString(i6));
    }

    private static String w(Cursor cursor, int i6) {
        if (i6 == -1) {
            return null;
        }
        try {
            return cursor.getString(i6);
        } catch (Exception e6) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e6);
            return null;
        }
    }

    private void y(ImageView imageView, Drawable drawable, int i6) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i6);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    @Override // g0.a, g0.b.a
    public void a(Cursor cursor) {
        if (this.f1122r) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f1125u = cursor.getColumnIndex("suggest_text_1");
                this.f1126v = cursor.getColumnIndex("suggest_text_2");
                this.f1127w = cursor.getColumnIndex("suggest_text_2_url");
                this.f1128x = cursor.getColumnIndex("suggest_icon_1");
                this.f1129y = cursor.getColumnIndex("suggest_icon_2");
                this.f1130z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e6) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e6);
        }
    }

    @Override // g0.a, g0.b.a
    public CharSequence c(Cursor cursor) {
        String o5;
        String o6;
        if (cursor == null) {
            return null;
        }
        String o7 = o(cursor, "suggest_intent_query");
        if (o7 != null) {
            return o7;
        }
        if (!this.f1118n.shouldRewriteQueryFromData() || (o6 = o(cursor, "suggest_intent_data")) == null) {
            if (!this.f1118n.shouldRewriteQueryFromText() || (o5 = o(cursor, "suggest_text_1")) == null) {
                return null;
            }
            return o5;
        }
        return o6;
    }

    @Override // g0.b.a
    public Cursor d(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? HttpUrl.FRAGMENT_ENCODE_SET : charSequence.toString();
        if (this.f1117m.getVisibility() == 0 && this.f1117m.getWindowVisibility() == 0) {
            try {
                Cursor v5 = v(this.f1118n, charSequence2, 50);
                if (v5 != null) {
                    v5.getCount();
                    return v5;
                }
            } catch (RuntimeException e6) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e6);
            }
        }
        return null;
    }

    @Override // g0.a
    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i6 = this.f1130z;
        int i7 = i6 != -1 ? cursor.getInt(i6) : 0;
        if (aVar.f1131a != null) {
            z(aVar.f1131a, w(cursor, this.f1125u));
        }
        if (aVar.f1132b != null) {
            String w5 = w(cursor, this.f1127w);
            CharSequence l6 = w5 != null ? l(w5) : w(cursor, this.f1126v);
            if (TextUtils.isEmpty(l6)) {
                TextView textView = aVar.f1131a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1131a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1131a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1131a.setMaxLines(1);
                }
            }
            z(aVar.f1132b, l6);
        }
        ImageView imageView = aVar.f1133c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f1134d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i8 = this.f1123s;
        if (i8 != 2 && (i8 != 1 || (i7 & 1) == 0)) {
            aVar.f1135e.setVisibility(8);
            return;
        }
        aVar.f1135e.setVisibility(0);
        aVar.f1135e.setTag(aVar.f1131a.getText());
        aVar.f1135e.setOnClickListener(this);
    }

    @Override // g0.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i6, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i6, view, viewGroup);
        } catch (RuntimeException e6) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e6);
            View g6 = g(this.f10319e, this.f10318d, viewGroup);
            if (g6 != null) {
                ((a) g6.getTag()).f1131a.setText(e6.toString());
            }
            return g6;
        }
    }

    @Override // g0.a, android.widget.Adapter
    public View getView(int i6, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i6, view, viewGroup);
        } catch (RuntimeException e6) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e6);
            View h6 = h(this.f10319e, this.f10318d, viewGroup);
            if (h6 != null) {
                ((a) h6.getTag()).f1131a.setText(e6.toString());
            }
            return h6;
        }
    }

    @Override // g0.c, g0.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View h6 = super.h(context, cursor, viewGroup);
        h6.setTag(new a(h6));
        ((ImageView) h6.findViewById(b.f.edit_query)).setImageResource(this.f1121q);
        return h6;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(b());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1117m.U((CharSequence) tag);
        }
    }

    Drawable r(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f10319e.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size != 2) {
                throw new FileNotFoundException("More than two path segments: " + uri);
            } else {
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor v(SearchableInfo searchableInfo, String str, int i6) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query(HttpUrl.FRAGMENT_ENCODE_SET).fragment(HttpUrl.FRAGMENT_ENCODE_SET);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i6 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i6));
        }
        return this.f10319e.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i6) {
        this.f1123s = i6;
    }
}
