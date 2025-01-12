package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.t1;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: b  reason: collision with root package name */
    private static final PorterDuff.Mode f960b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private static j f961c;

    /* renamed from: a  reason: collision with root package name */
    private t1 f962a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements t1.e {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f963a = {b.e.abc_textfield_search_default_mtrl_alpha, b.e.abc_textfield_default_mtrl_alpha, b.e.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b  reason: collision with root package name */
        private final int[] f964b = {b.e.abc_ic_commit_search_api_mtrl_alpha, b.e.abc_seekbar_tick_mark_material, b.e.abc_ic_menu_share_mtrl_alpha, b.e.abc_ic_menu_copy_mtrl_am_alpha, b.e.abc_ic_menu_cut_mtrl_alpha, b.e.abc_ic_menu_selectall_mtrl_alpha, b.e.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c  reason: collision with root package name */
        private final int[] f965c = {b.e.abc_textfield_activated_mtrl_alpha, b.e.abc_textfield_search_activated_mtrl_alpha, b.e.abc_cab_background_top_mtrl_alpha, b.e.abc_text_cursor_material, b.e.abc_text_select_handle_left_mtrl_dark, b.e.abc_text_select_handle_middle_mtrl_dark, b.e.abc_text_select_handle_right_mtrl_dark, b.e.abc_text_select_handle_left_mtrl_light, b.e.abc_text_select_handle_middle_mtrl_light, b.e.abc_text_select_handle_right_mtrl_light};

        /* renamed from: d  reason: collision with root package name */
        private final int[] f966d = {b.e.abc_popup_background_mtrl_mult, b.e.abc_cab_background_internal_bg, b.e.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e  reason: collision with root package name */
        private final int[] f967e = {b.e.abc_tab_indicator_material, b.e.abc_textfield_search_material};

        /* renamed from: f  reason: collision with root package name */
        private final int[] f968f = {b.e.abc_btn_check_material, b.e.abc_btn_radio_material, b.e.abc_btn_check_material_anim, b.e.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i6) {
            for (int i7 : iArr) {
                if (i7 == i6) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i6) {
            int c6 = y1.c(context, b.a.f2710s);
            return new ColorStateList(new int[][]{y1.f1137b, y1.f1140e, y1.f1138c, y1.f1144i}, new int[]{y1.b(context, b.a.colorButtonNormal), w.a.e(c6, i6), w.a.e(c6, i6), i6});
        }

        private ColorStateList i(Context context) {
            return h(context, y1.c(context, b.a.colorAccent));
        }

        private ColorStateList j(Context context) {
            return h(context, y1.c(context, b.a.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            int i6 = b.a.colorSwitchThumbNormal;
            ColorStateList e6 = y1.e(context, i6);
            if (e6 == null || !e6.isStateful()) {
                iArr[0] = y1.f1137b;
                iArr2[0] = y1.b(context, i6);
                iArr[1] = y1.f1141f;
                iArr2[1] = y1.c(context, b.a.f2709r);
                iArr[2] = y1.f1144i;
                iArr2[2] = y1.c(context, i6);
            } else {
                int[] iArr3 = y1.f1137b;
                iArr[0] = iArr3;
                iArr2[0] = e6.getColorForState(iArr3, 0);
                iArr[1] = y1.f1141f;
                iArr2[1] = y1.c(context, b.a.f2709r);
                iArr[2] = y1.f1144i;
                iArr2[2] = e6.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private void l(Drawable drawable, int i6, PorterDuff.Mode mode) {
            if (f1.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = j.f960b;
            }
            drawable.setColorFilter(j.e(i6, mode));
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006d A[RETURN] */
        @Override // androidx.appcompat.widget.t1.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(Context context, int i6, Drawable drawable) {
            PorterDuff.Mode mode;
            int i7;
            int i8;
            boolean z5;
            PorterDuff.Mode mode2 = j.f960b;
            if (f(this.f963a, i6)) {
                i7 = b.a.colorControlNormal;
            } else if (f(this.f965c, i6)) {
                i7 = b.a.f2709r;
            } else {
                if (!f(this.f966d, i6)) {
                    if (i6 == b.e.abc_list_divider_mtrl_alpha) {
                        mode = mode2;
                        z5 = true;
                        i8 = Math.round(40.8f);
                        i7 = 16842800;
                    } else if (i6 != b.e.abc_dialog_material_background) {
                        mode = mode2;
                        i7 = 0;
                        i8 = -1;
                        z5 = false;
                    }
                    if (z5) {
                        if (f1.a(drawable)) {
                            drawable = drawable.mutate();
                        }
                        drawable.setColorFilter(j.e(y1.c(context, i7), mode));
                        if (i8 != -1) {
                            drawable.setAlpha(i8);
                        }
                        return true;
                    }
                    return false;
                }
                mode2 = PorterDuff.Mode.MULTIPLY;
                mode = mode2;
                i7 = 16842801;
                i8 = -1;
                z5 = true;
                if (z5) {
                }
            }
            mode = mode2;
            i8 = -1;
            z5 = true;
            if (z5) {
            }
        }

        @Override // androidx.appcompat.widget.t1.e
        public PorterDuff.Mode b(int i6) {
            if (i6 == b.e.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.t1.e
        public Drawable c(t1 t1Var, Context context, int i6) {
            if (i6 == b.e.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{t1Var.j(context, b.e.abc_cab_background_internal_bg), t1Var.j(context, b.e.abc_cab_background_top_mtrl_alpha)});
            }
            return null;
        }

        @Override // androidx.appcompat.widget.t1.e
        public ColorStateList d(Context context, int i6) {
            if (i6 == b.e.abc_edit_text_material) {
                return e.b.c(context, b.c.abc_tint_edittext);
            }
            if (i6 == b.e.abc_switch_track_mtrl_alpha) {
                return e.b.c(context, b.c.abc_tint_switch_track);
            }
            if (i6 == b.e.abc_switch_thumb_material) {
                return k(context);
            }
            if (i6 == b.e.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i6 == b.e.abc_btn_borderless_material) {
                return g(context);
            }
            if (i6 == b.e.abc_btn_colored_material) {
                return i(context);
            }
            if (i6 == b.e.abc_spinner_mtrl_am_alpha || i6 == b.e.abc_spinner_textfield_background_material) {
                return e.b.c(context, b.c.abc_tint_spinner);
            }
            if (f(this.f964b, i6)) {
                return y1.e(context, b.a.colorControlNormal);
            }
            if (f(this.f967e, i6)) {
                return e.b.c(context, b.c.abc_tint_default);
            }
            if (f(this.f968f, i6)) {
                return e.b.c(context, b.c.abc_tint_btn_checkable);
            }
            if (i6 == b.e.abc_seekbar_thumb_material) {
                return e.b.c(context, b.c.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.t1.e
        public boolean e(Context context, int i6, Drawable drawable) {
            Drawable findDrawableByLayerId;
            int c6;
            if (i6 == b.e.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(16908288);
                int i7 = b.a.colorControlNormal;
                l(findDrawableByLayerId2, y1.c(context, i7), j.f960b);
                l(layerDrawable.findDrawableByLayerId(16908303), y1.c(context, i7), j.f960b);
                findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301);
                c6 = y1.c(context, b.a.f2709r);
            } else if (i6 != b.e.abc_ratingbar_material && i6 != b.e.abc_ratingbar_indicator_material && i6 != b.e.abc_ratingbar_small_material) {
                return false;
            } else {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                l(layerDrawable2.findDrawableByLayerId(16908288), y1.b(context, b.a.colorControlNormal), j.f960b);
                Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(16908303);
                int i8 = b.a.f2709r;
                l(findDrawableByLayerId3, y1.c(context, i8), j.f960b);
                findDrawableByLayerId = layerDrawable2.findDrawableByLayerId(16908301);
                c6 = y1.c(context, i8);
            }
            l(findDrawableByLayerId, c6, j.f960b);
            return true;
        }
    }

    public static synchronized j b() {
        j jVar;
        synchronized (j.class) {
            if (f961c == null) {
                h();
            }
            jVar = f961c;
        }
        return jVar;
    }

    public static synchronized PorterDuffColorFilter e(int i6, PorterDuff.Mode mode) {
        PorterDuffColorFilter l6;
        synchronized (j.class) {
            l6 = t1.l(i6, mode);
        }
        return l6;
    }

    public static synchronized void h() {
        synchronized (j.class) {
            if (f961c == null) {
                j jVar = new j();
                f961c = jVar;
                jVar.f962a = t1.h();
                f961c.f962a.u(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Drawable drawable, a2 a2Var, int[] iArr) {
        t1.w(drawable, a2Var, iArr);
    }

    public synchronized Drawable c(Context context, int i6) {
        return this.f962a.j(context, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i6, boolean z5) {
        return this.f962a.k(context, i6, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i6) {
        return this.f962a.m(context, i6);
    }

    public synchronized void g(Context context) {
        this.f962a.s(context);
    }
}
