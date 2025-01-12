package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import c0.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class v {

    /* loaded from: classes.dex */
    private static class a implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final ActionMode.Callback f1673a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f1674b;

        /* renamed from: c  reason: collision with root package name */
        private Class f1675c;

        /* renamed from: d  reason: collision with root package name */
        private Method f1676d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1677e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1678f = false;

        a(ActionMode.Callback callback, TextView textView) {
            this.f1673a = callback;
            this.f1674b = textView;
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent putExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !d(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private List c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (context instanceof Activity) {
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                    if (e(resolveInfo, context)) {
                        arrayList.add(resolveInfo);
                    }
                }
                return arrayList;
            }
            return arrayList;
        }

        private boolean d(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private boolean e(ResolveInfo resolveInfo, Context context) {
            int checkSelfPermission;
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo.exported) {
                String str = activityInfo.permission;
                if (str != null) {
                    checkSelfPermission = context.checkSelfPermission(str);
                    return checkSelfPermission == 0;
                }
                return true;
            }
            return false;
        }

        private void f(Menu menu) {
            Context context = this.f1674b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f1678f) {
                this.f1678f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f1675c = cls;
                    this.f1676d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f1677e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f1675c = null;
                    this.f1676d = null;
                    this.f1677e = false;
                }
            }
            try {
                Method declaredMethod = (this.f1677e && this.f1675c.isInstance(menu)) ? this.f1676d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List c6 = c(context, packageManager);
                for (int i6 = 0; i6 < c6.size(); i6++) {
                    ResolveInfo resolveInfo = (ResolveInfo) c6.get(i6);
                    menu.add(0, 0, i6 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f1674b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f1673a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f1673a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f1673a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            f(menu);
            return this.f1673a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static Drawable[] a(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static int b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    private static int d(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    private static TextDirectionHeuristic e(TextView textView) {
        DecimalFormatSymbols decimalFormatSymbols;
        String[] digitStrings;
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            decimalFormatSymbols = DecimalFormatSymbols.getInstance(textView.getTextLocale());
            digitStrings = decimalFormatSymbols.getDigitStrings();
            byte directionality = Character.getDirectionality(digitStrings[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        boolean z5 = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                return z5 ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    public static n.a f(TextView textView) {
        int breakStrategy;
        int hyphenationFrequency;
        PrecomputedText.Params textMetricsParams;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 28) {
            textMetricsParams = textView.getTextMetricsParams();
            return new n.a(textMetricsParams);
        }
        n.a.C0032a c0032a = new n.a.C0032a(new TextPaint(textView.getPaint()));
        if (i6 >= 23) {
            breakStrategy = textView.getBreakStrategy();
            c0032a.b(breakStrategy);
            hyphenationFrequency = textView.getHyphenationFrequency();
            c0032a.c(hyphenationFrequency);
        }
        c0032a.d(e(textView));
        return c0032a.a();
    }

    public static void g(TextView textView, ColorStateList colorStateList) {
        d0.i.c(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof w) {
            ((w) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    public static void h(TextView textView, PorterDuff.Mode mode) {
        d0.i.c(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof w) {
            ((w) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void i(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public static void j(TextView textView, int i6) {
        d0.i.b(i6);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i6);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i7 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i6 > Math.abs(i7)) {
            textView.setPadding(textView.getPaddingLeft(), i6 + i7, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void k(TextView textView, int i6) {
        d0.i.b(i6);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i7 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i6 > Math.abs(i7)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i6 - i7);
        }
    }

    public static void l(TextView textView, int i6) {
        d0.i.b(i6);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i6 != fontMetricsInt) {
            textView.setLineSpacing(i6 - fontMetricsInt, 1.0f);
        }
    }

    public static void m(TextView textView, c0.n nVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        f(textView);
        throw null;
    }

    public static void n(TextView textView, int i6) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i6);
        } else {
            textView.setTextAppearance(textView.getContext(), i6);
        }
    }

    public static void o(TextView textView, n.a aVar) {
        int i6 = Build.VERSION.SDK_INT;
        textView.setTextDirection(d(aVar.d()));
        if (i6 >= 23) {
            textView.getPaint().set(aVar.e());
            textView.setBreakStrategy(aVar.b());
            textView.setHyphenationFrequency(aVar.c());
            return;
        }
        float textScaleX = aVar.e().getTextScaleX();
        textView.getPaint().set(aVar.e());
        if (textScaleX == textView.getTextScaleX()) {
            textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
        }
        textView.setTextScaleX(textScaleX);
    }

    public static ActionMode.Callback p(TextView textView, ActionMode.Callback callback) {
        int i6 = Build.VERSION.SDK_INT;
        return (i6 < 26 || i6 > 27 || (callback instanceof a)) ? callback : new a(callback, textView);
    }
}
