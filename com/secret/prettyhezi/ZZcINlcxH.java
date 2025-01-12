package com.secret.prettyhezi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.secret.prettyhezi.User.TK1dGVzP;
import com.secret.prettyhezi.controls.a0;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.controls.z;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import okhttp3.HttpUrl;
import okio.Segment;
/* loaded from: classes.dex */
public class ZZcINlcxH extends Activity {

    /* renamed from: m  reason: collision with root package name */
    public static boolean f8161m = true;

    /* renamed from: n  reason: collision with root package name */
    public static ArrayList f8162n = new ArrayList(10);

    /* renamed from: o  reason: collision with root package name */
    static Point f8163o = null;

    /* renamed from: p  reason: collision with root package name */
    public static String f8164p = "keyLanguage";

    /* renamed from: g  reason: collision with root package name */
    private String f8170g;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8165b = false;

    /* renamed from: c  reason: collision with root package name */
    public int f8166c = Color.parseColor("#ff00aa00");

    /* renamed from: d  reason: collision with root package name */
    long f8167d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f8168e = 0;

    /* renamed from: f  reason: collision with root package name */
    boolean f8169f = false;

    /* renamed from: h  reason: collision with root package name */
    com.secret.AD.d f8171h = null;

    /* renamed from: i  reason: collision with root package name */
    com.secret.AD.d f8172i = null;

    /* renamed from: j  reason: collision with root package name */
    Dialog f8173j = null;

    /* renamed from: k  reason: collision with root package name */
    Runnable f8174k = null;

    /* renamed from: l  reason: collision with root package name */
    p f8175l = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnDismissListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f8176b;

        a(q qVar) {
            this.f8176b = qVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            this.f8176b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnDismissListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LinearLayout f8178b;

        b(LinearLayout linearLayout) {
            this.f8178b = linearLayout;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Object tag = this.f8178b.getTag();
            ZZcINlcxH zZcINlcxH = ZZcINlcxH.this;
            if (tag == zZcINlcxH.f8173j) {
                zZcINlcxH.f8173j = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayout f8180a;

        c(LinearLayout linearLayout) {
            this.f8180a = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object tag = this.f8180a.getTag();
            Dialog dialog = ZZcINlcxH.this.f8173j;
            if (tag == dialog) {
                try {
                    dialog.dismiss();
                } catch (Exception unused) {
                }
                ZZcINlcxH.this.f8173j = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bitmap f8182a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f8183b;

        d(Bitmap bitmap, String str) {
            this.f8182a = bitmap;
            this.f8183b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00ab A[LOOP:0: B:18:0x00a9->B:19:0x00ab, LOOP_END] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i6;
            Bitmap decodeFile;
            int random;
            int width;
            int height;
            float max = Math.max(this.f8182a.getWidth() / 1024.0f, this.f8182a.getHeight() / 1024.0f);
            if (max < 1.0f) {
                max = 1.0f;
            }
            int width2 = (int) (this.f8182a.getWidth() / max);
            int height2 = (int) (this.f8182a.getHeight() / max);
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#ff0000"));
            paint.setTextSize(24.0f);
            Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            int i7 = 1;
            canvas.drawBitmap(Bitmap.createScaledBitmap(this.f8182a, width2, height2, true), 0.0f, 0.0f, paint);
            int i8 = 20;
            try {
                decodeFile = BitmapFactory.decodeFile(this.f8183b);
                random = (int) (Math.random() * 4.0d);
            } catch (Exception unused) {
            }
            if (random == 0) {
                width = 20;
            } else if (random != 1) {
                if (random == 2) {
                    height = (height2 - 20) - decodeFile.getHeight();
                    width = 20;
                } else {
                    width = (width2 - 20) - decodeFile.getWidth();
                    height = (height2 - 20) - decodeFile.getHeight();
                }
                canvas.translate(width, height);
                canvas.drawBitmap(decodeFile, 0.0f, 0.0f, paint);
                canvas.translate(-width, -height);
                i6 = 0;
                while (i6 < i8) {
                    int random2 = ((int) (Math.random() * (width2 - 5))) + i7;
                    int random3 = ((int) (Math.random() * (height2 - 5))) + i7;
                    paint.setColor(Color.argb(5, (int) (Math.random() * 255.0d), (int) (Math.random() * 255.0d), (int) (255.0d * Math.random())));
                    canvas.drawPoint(random2, random3, paint);
                    i6++;
                    i8 = 20;
                    i7 = 1;
                }
                ZZcINlcxH.this.k(createBitmap);
            } else {
                width = (width2 - 20) - decodeFile.getWidth();
            }
            height = 20;
            canvas.translate(width, height);
            canvas.drawBitmap(decodeFile, 0.0f, 0.0f, paint);
            canvas.translate(-width, -height);
            i6 = 0;
            while (i6 < i8) {
            }
            ZZcINlcxH.this.k(createBitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bitmap f8185a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f8186b;

        e(Bitmap bitmap, String str) {
            this.f8185a = bitmap;
            this.f8186b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            OutputStream fileOutputStream;
            String str = "BeautyBox_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".jpg";
            StringBuilder sb = new StringBuilder();
            String str2 = File.separator;
            sb.append(str2);
            sb.append("BeautyBox");
            String sb2 = sb.toString();
            String str3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + sb2;
            String str4 = str3 + str2 + str;
            try {
                int i6 = Build.VERSION.SDK_INT;
                if (i6 >= 29) {
                    ContentResolver contentResolver = ZZcINlcxH.this.getContentResolver();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_display_name", str);
                    contentValues.put("mime_type", "image/jpeg");
                    contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + sb2);
                    fileOutputStream = contentResolver.openOutputStream(contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues));
                } else {
                    File file = new File(str3);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    fileOutputStream = new FileOutputStream(new File(str3, str));
                }
                if (fileOutputStream != null) {
                    this.f8185a.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                    if (i6 < 29) {
                        ZZcINlcxH.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + str4)));
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            String str5 = this.f8186b;
            if (str5 == null || str5.length() == 0) {
                str5 = "Saved to " + str4;
            }
            ZZcINlcxH.this.H(str5);
        }
    }

    /* loaded from: classes.dex */
    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f8188a;

        f(p pVar) {
            this.f8188a = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZZcINlcxH zZcINlcxH;
            Intent createChooser;
            ZZcINlcxH.this.f8175l = this.f8188a;
            boolean z5 = g4.g.a().d("keySupportPick", 0) == 0;
            try {
                if (z5) {
                    createChooser = new Intent("android.intent.action.PICK");
                    createChooser.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    zZcINlcxH = ZZcINlcxH.this;
                } else {
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                    zZcINlcxH = ZZcINlcxH.this;
                    createChooser = Intent.createChooser(intent, "选择一张图片");
                }
                zZcINlcxH.startActivityForResult(createChooser, 2);
            } catch (Exception unused) {
                if (z5) {
                    g4.g.a().n("keySupportPick", 1);
                }
                p pVar = ZZcINlcxH.this.f8175l;
                if (pVar != null) {
                    pVar.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class g extends q {
        g() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void a() {
            ZZcINlcxH.this.l0();
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            ZZcINlcxH.this.M0(TK1dGVzP.class);
        }
    }

    /* loaded from: classes.dex */
    class h extends q {
        h() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            ZZcINlcxH.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ZZcINlcxH.this.j0();
        }
    }

    /* loaded from: classes.dex */
    class j implements DialogInterface.OnDismissListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ZZcINlcxH zZcINlcxH = ZZcINlcxH.this;
            if (zZcINlcxH.f8169f && zZcINlcxH.f8168e == 2) {
                ZZcINlcxH.this.f8169f = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends g4.f {
        k() {
        }

        @Override // g4.f
        public void a(View view) {
            ZZcINlcxH.this.v0();
        }
    }

    /* loaded from: classes.dex */
    class l extends g4.f {
        l() {
        }

        @Override // g4.f
        public void a(View view) {
            ZZcINlcxH.this.u0();
        }
    }

    /* loaded from: classes.dex */
    class m extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f8196d;

        m(String str) {
            this.f8196d = str;
        }

        @Override // g4.f
        public void a(View view) {
            ZZcINlcxH.g(this.f8196d);
            ZZcINlcxH.this.H("已复制到剪贴板");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f8198a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f8199b;

        n(com.secret.prettyhezi.controls.x xVar, q qVar) {
            this.f8198a = xVar;
            this.f8199b = qVar;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            q qVar;
            if (!ZZcINlcxH.this.j(this.f8198a) || (qVar = this.f8199b) == null) {
                return;
            }
            qVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f8201a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f8202b;

        o(com.secret.prettyhezi.controls.x xVar, q qVar) {
            this.f8201a = xVar;
            this.f8202b = qVar;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            q qVar;
            if (!ZZcINlcxH.this.j(this.f8201a) || (qVar = this.f8202b) == null) {
                return;
            }
            if (i6 == 0) {
                qVar.a();
            } else if (i6 == 1) {
                qVar.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface p {
        void a();

        void b(Bitmap bitmap);
    }

    /* loaded from: classes.dex */
    public static class q {
        public void a() {
        }

        public void b() {
        }
    }

    private String J() {
        Locale locale;
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = getResources().getConfiguration().getLocales();
            locale = locales.get(0);
        } else {
            locale = getResources().getConfiguration().locale;
        }
        String language = locale.getLanguage();
        if (locale.getCountry().length() > 0) {
            language = language + "-" + locale.getCountry();
        }
        return language.equals("zh-CN") ? "zh" : language.startsWith("zh") ? "zh-rTW" : "en";
    }

    public static void R(ZZcINlcxH zZcINlcxH, LinearLayout linearLayout, int i6, float f6, int i7, int i8, int i9) {
        View view = new View(zZcINlcxH);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(2);
        gradientDrawable.setStroke(g4.i.r(f6), i6, g4.i.r(4.0f), g4.i.r(4.0f));
        view.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i0(f6 + 1.0f));
        layoutParams.leftMargin = i0(i7);
        layoutParams.topMargin = i0(i8);
        layoutParams.rightMargin = i0(i9);
        linearLayout.addView(view, layoutParams);
    }

    public static GradientDrawable f0(int i6, float f6) {
        return g0(i6, f6, 0, 0.0f);
    }

    public static void g(String str) {
        ((ClipboardManager) g4.i.j().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", str));
    }

    public static GradientDrawable g0(int i6, float f6, int i7, float f7) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i6);
        gradientDrawable.setCornerRadius(i0(f6));
        if (f7 > 0.0f) {
            gradientDrawable.setStroke(i0(f7), i7);
        }
        return gradientDrawable;
    }

    public static int i0(float f6) {
        return g4.i.r(f6);
    }

    public static String m() {
        ClipData.Item itemAt;
        ClipData primaryClip = ((ClipboardManager) g4.i.j().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null) {
            return null;
        }
        return itemAt.getText().toString();
    }

    public void A(a0.f fVar) {
        View a0Var = new a0(this, 0, fVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(324.0f), g4.i.r(380.0f));
        layoutParams.addRule(13, -1);
        a0Var.setLayoutParams(layoutParams);
        x(a0Var, null, false);
    }

    public FrameLayout A0(int i6, int i7) {
        FrameLayout frameLayout = new FrameLayout(this);
        w(frameLayout, i6, i7);
        return frameLayout;
    }

    public void AnimateZoomOut(View view) {
        f(view, 1.5f);
    }

    public com.secret.prettyhezi.controls.x B(String str, q qVar, boolean z5) {
        return C(str, new String[]{s0(C0382R.string.cancel), s0(C0382R.string.ok)}, qVar, z5);
    }

    public LinearLayout B0(int i6, int i7) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        w(linearLayout, i6, i7);
        return linearLayout;
    }

    public com.secret.prettyhezi.controls.x C(String str, String[] strArr, q qVar, boolean z5) {
        com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(this);
        xVar.f(str);
        xVar.d(strArr, new o(xVar, qVar));
        x(xVar, qVar, z5);
        return xVar;
    }

    public LinearLayout C0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#ececec"));
        setContentView(linearLayout);
        return linearLayout;
    }

    public com.secret.prettyhezi.controls.x D(String str, q qVar, boolean z5) {
        return E(str, null, qVar, z5);
    }

    public RelativeLayout D0(int i6, int i7) {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        w(relativeLayout, i6, i7);
        return relativeLayout;
    }

    public com.secret.prettyhezi.controls.x E(String str, String str2, q qVar, boolean z5) {
        return F(str, str2, s0(C0382R.string.ok), qVar, z5);
    }

    public RelativeLayout E0() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#ececec"));
        setContentView(relativeLayout);
        return relativeLayout;
    }

    public com.secret.prettyhezi.controls.x F(String str, String str2, String str3, q qVar, boolean z5) {
        return G(str, str2, str3, qVar, z5, 0);
    }

    public void F0(int i6) {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i6);
        this.f8166c = i6;
    }

    public com.secret.prettyhezi.controls.x G(String str, String str2, String str3, q qVar, boolean z5, int i6) {
        if (isFinishing() || isDestroyed()) {
            return null;
        }
        com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(this);
        if (str2 == null || str2.length() <= 0) {
            xVar.f(str);
        } else {
            xVar.i(str, str2);
        }
        xVar.d(new String[]{str3}, new n(xVar, qVar));
        if (i6 > 0) {
            xVar.c(0, i6);
        }
        x(xVar, qVar, z5);
        return xVar;
    }

    public void G0() {
        K0(null, 2);
    }

    public void H(String str) {
        z(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H0() {
        if (g4.g.a().c().length() > 10) {
            NbWDzx1XT.R0(this, false);
        }
    }

    public void I(String str, int i6) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        boolean areNotificationsEnabled = Build.VERSION.SDK_INT >= 24 ? ((NotificationManager) getSystemService("notification")).areNotificationsEnabled() : true;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackground(f0(i6, 12.0f));
        TextView c6 = g4.d.c(this, 18, -1, str, 17);
        c6.setPadding(g4.i.r(20.0f), g4.i.r(16.0f), g4.i.r(20.0f), g4.i.r(16.0f));
        linearLayout.addView(c6, new LinearLayout.LayoutParams(-2, -2));
        if (areNotificationsEnabled) {
            Toast toast = new Toast(this);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(linearLayout);
            toast.show();
            return;
        }
        Dialog dialog = this.f8173j;
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Exception unused) {
            }
            this.f8173j = null;
        }
        Dialog dialog2 = new Dialog(this, C0382R.style.TransparentDialog);
        this.f8173j = dialog2;
        dialog2.setContentView(linearLayout);
        Window window = this.f8173j.getWindow();
        window.addFlags(8);
        window.addFlags(32);
        window.addFlags(16);
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        this.f8173j.setCancelable(true);
        this.f8173j.setOnDismissListener(new b(linearLayout));
        linearLayout.setTag(this.f8173j);
        linearLayout.postDelayed(new c(linearLayout), 1000L);
        this.f8173j.show();
    }

    public void I0() {
        J0(null);
    }

    public void J0(String str) {
        K0(str, 1);
    }

    public void K0(String str, int i6) {
        if (isDestroyed() || isFinishing()) {
            return;
        }
        this.f8170g = str;
        showDialog(i6);
        this.f8169f = true;
        this.f8168e = i6;
    }

    public RelativeLayout L(LinearLayout linearLayout) {
        RelativeLayout a02 = a0();
        linearLayout.addView(a02, new LinearLayout.LayoutParams(-1, g4.i.r(52.0f)));
        return a02;
    }

    public boolean L0() {
        return this.f8169f;
    }

    public RelativeLayout M(LinearLayout linearLayout, String str) {
        RelativeLayout b02 = b0(str);
        linearLayout.addView(b02, new LinearLayout.LayoutParams(-1, g4.i.r(52.0f)));
        return b02;
    }

    public void M0(Class cls) {
        startActivity(new Intent(this, cls));
    }

    public RelativeLayout N(LinearLayout linearLayout, String str, String str2, View.OnClickListener onClickListener) {
        RelativeLayout M = M(linearLayout, str);
        TextView b6 = g4.d.b(this, 16.0f, Color.parseColor("#333333"), str2);
        b6.setTextColor(g4.i.q(Color.parseColor("#333333"), -16777216, -7829368, -7829368));
        b6.setPadding(g4.i.r(12.0f), 0, g4.i.r(12.0f), 0);
        b6.setGravity(17);
        b6.setTextAlignment(4);
        b6.setBackground(g4.i.f(0, Color.parseColor("#f0f0f0")));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(11, -1);
        M.addView(b6, layoutParams);
        b6.setId(13);
        b6.setOnClickListener(onClickListener);
        return M;
    }

    public void N0(Class cls, int i6) {
        Intent intent = new Intent(this, cls);
        Bundle bundle = new Bundle();
        bundle.putInt("id", i6);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public RelativeLayout O(LinearLayout linearLayout, String str) {
        RelativeLayout c02 = c0(str);
        linearLayout.addView(c02, new LinearLayout.LayoutParams(-1, g4.i.r(52.0f)));
        return c02;
    }

    public void O0(Class cls, int i6, int i7) {
        Intent intent = new Intent(this, cls);
        Bundle bundle = new Bundle();
        bundle.putInt("id", i6);
        bundle.putInt("type", i7);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public RelativeLayout P(LinearLayout linearLayout, String str) {
        RelativeLayout M = M(linearLayout, str);
        z zVar = new z(this, C0382R.drawable.ic_settings);
        int r5 = g4.i.r(12.0f);
        zVar.setPadding(r5, r5, r5, r5);
        zVar.setBackground(g4.i.d(null, g4.i.b(Color.parseColor("#cccccc"), 4.0f)));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(52.0f), -1);
        layoutParams.addRule(21, -1);
        M.addView(zVar, layoutParams);
        zVar.setOnClickListener(new l());
        return M;
    }

    public void P0(Class cls, int i6, int i7, int i8) {
        Intent intent = new Intent(this, cls);
        Bundle bundle = new Bundle();
        bundle.putInt("id", i6);
        bundle.putInt("type", i7);
        bundle.putInt("extra", i8);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void Q(LinearLayout linearLayout, int i6, float f6, int i7, int i8, int i9) {
        R(this, linearLayout, i6, f6, i7, i8, i9);
    }

    protected void Q0(String str) {
        Locale locale;
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        str.hashCode();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -704711850:
                if (str.equals("zh-rTW")) {
                    c6 = 0;
                    break;
                }
                break;
            case 3241:
                if (str.equals("en")) {
                    c6 = 1;
                    break;
                }
                break;
            case 3886:
                if (str.equals("zh")) {
                    c6 = 2;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                locale = Locale.TRADITIONAL_CHINESE;
                break;
            case 1:
                locale = Locale.ENGLISH;
                break;
            case 2:
                locale = Locale.CHINESE;
                break;
            default:
                locale = Locale.US;
                break;
        }
        configuration.locale = locale;
        resources.updateConfiguration(configuration, displayMetrics);
        com.secret.prettyhezi.c.a(str);
    }

    public void RemoveParentScrollView(View view) {
        ScrollView scrollView;
        ViewParent parent;
        ViewParent parent2 = view.getParent();
        if (parent2 == null || !(parent2 instanceof ScrollView) || (parent = (scrollView = (ScrollView) parent2).getParent()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
        scrollView.removeView(view);
        ((ViewGroup) parent).addView(view, layoutParams);
    }

    public void S(LinearLayout linearLayout, String str) {
        V(linearLayout, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        TextView b6 = g4.d.b(this, 14.0f, Color.parseColor("#666666"), str);
        b6.setPadding(g4.i.r(12.0f), 0, 0, 0);
        b6.setBackgroundColor(Color.parseColor("#dddddd"));
        b6.setGravity(16);
        linearLayout.addView(b6, new LinearLayout.LayoutParams(-1, g4.i.r(40.0f)));
        V(linearLayout, Color.parseColor("#cccccc"), 0.5f, 0, 0);
    }

    public LinearLayout T(LinearLayout linearLayout, String str) {
        S(linearLayout, str);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(-1);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        return linearLayout2;
    }

    public TextView U(LinearLayout linearLayout, String str, int i6, int i7) {
        TextView b6 = g4.d.b(this, 16.0f, -1, str);
        b6.setGravity(17);
        b6.setBackground(g4.i.e(f0(Color.parseColor("#ff0000"), 2.5f), f0(Color.parseColor("#aa0000"), 2.5f), f0(Color.parseColor("#cccccc"), 2.5f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i0(42.0f));
        float f6 = i7;
        layoutParams.setMargins(i0(f6), i0(i6), i0(f6), 0);
        linearLayout.addView(b6, layoutParams);
        return b6;
    }

    public void V(LinearLayout linearLayout, int i6, float f6, int i7, int i8) {
        View view = new View(this);
        view.setBackgroundColor(i6);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i0(f6));
        layoutParams.leftMargin = i0(i7);
        layoutParams.topMargin = i0(i8);
        linearLayout.addView(view, layoutParams);
    }

    public void W(LinearLayout linearLayout, int i6, float f6, int i7, int i8, int i9) {
        View view = new View(this);
        view.setBackgroundColor(i6);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i0(f6));
        layoutParams.leftMargin = i0(i7);
        layoutParams.topMargin = i0(i8);
        layoutParams.rightMargin = i0(i9);
        linearLayout.addView(view, layoutParams);
    }

    public boolean X() {
        com.secret.prettyhezi.Server.a0 r5 = MainApplication.f6711r.r();
        if (r5 == null || r5.grade != 0) {
            return false;
        }
        com.secret.prettyhezi.User.f.j(this);
        return true;
    }

    void Y() {
        if (f8162n.size() > 7) {
            for (int i6 = 1; i6 < f8162n.size() - 2; i6++) {
                Activity activity = (Activity) f8162n.get(i6);
                if (!(activity instanceof EjNkL)) {
                    activity.finish();
                    return;
                }
            }
        }
    }

    public void Z() {
        for (int size = f8162n.size() - 1; size >= 0; size--) {
            ((Activity) f8162n.get(size)).finish();
        }
    }

    public RelativeLayout a0() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        com.secret.prettyhezi.controls.u a6 = com.secret.prettyhezi.controls.u.a(new z(this, C0382R.drawable.ic_back), 32, 32);
        a6.setBackground(g4.i.d(new ColorDrawable(-1), g4.i.b(Color.parseColor("#cccccc"), 20.0f)));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(42.0f), g4.i.r(42.0f));
        layoutParams.leftMargin = g4.i.r(6.0f);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(a6, layoutParams);
        a6.setId(11);
        a6.setOnClickListener(new k());
        return relativeLayout;
    }

    public RelativeLayout b0(String str) {
        RelativeLayout a02 = a0();
        TextView b6 = g4.d.b(this, 18.0f, Color.parseColor("#333333"), str);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        a02.addView(b6, layoutParams);
        b6.setId(12);
        return a02;
    }

    public RelativeLayout c0(String str) {
        RelativeLayout a02 = a0();
        TextView b6 = g4.d.b(this, 18.0f, Color.parseColor("#333333"), str);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15, -1);
        layoutParams.leftMargin = g4.i.r(80.0f);
        a02.addView(b6, layoutParams);
        b6.setId(12);
        return a02;
    }

    public void d() {
        if (this.f8167d <= 0 || MainApplication.f() <= 0) {
            return;
        }
        MainApplication.f6711r.f6722h += ((System.currentTimeMillis() / 1000) - this.f8167d) - 1;
        this.f8167d = System.currentTimeMillis() / 1000;
    }

    public RotateAnimation d0() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 3600.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(8000L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatMode(1);
        return rotateAnimation;
    }

    public LinearLayout e(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setScrollBarSize(0);
        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        scrollView.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        return linearLayout2;
    }

    public View e0() {
        View view = new View(this);
        view.setBackgroundResource(C0382R.drawable.ic_waiting);
        view.startAnimation(d0());
        return view;
    }

    public void f(View view, float f6) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f6, 1.0f, f6, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(500L);
        scaleAnimation.setRepeatCount(2);
        scaleAnimation.setRepeatMode(2);
        view.clearAnimation();
        view.startAnimation(scaleAnimation);
    }

    public TextView h(String str, String str2) {
        TextView c6 = g4.d.c(this, 16, -1, str, 17);
        c6.setPadding(g4.i.r(10.0f), 0, g4.i.r(10.0f), 0);
        c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#555555"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        c6.setLayoutParams(new LinearLayout.LayoutParams(-2, g4.i.r(36.0f)));
        c6.setOnClickListener(new m(str2));
        return c6;
    }

    Bitmap h0(String str) {
        if (str == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
            int i6 = options.outWidth;
            if (i6 == 0) {
                return null;
            }
            float max = Math.max(Math.min(i6 / 1024.0f, options.outHeight / 1024.0f) + 0.2f, 1.0f);
            int i7 = 0;
            options.inJustDecodeBounds = false;
            options.inSampleSize = (int) max;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 6) {
                i7 = 90;
            } else if (attributeInt == 3) {
                i7 = 180;
            } else if (attributeInt == 8) {
                i7 = 270;
            }
            if (i7 != 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate(i7);
                Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                decodeFile.recycle();
                return createBitmap;
            }
            return decodeFile;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String i() {
        String h6 = g4.g.a().h(f8164p, HttpUrl.FRAGMENT_ENCODE_SET);
        if (h6.length() == 0) {
            String J = J();
            g4.g.a().o("keySysLanguage", J);
            u(J);
            return J;
        }
        return h6;
    }

    public boolean j(View view) {
        Object tag = view.getTag();
        if (tag == null) {
            return false;
        }
        view.setTag(null);
        ((AlertDialog) tag).dismiss();
        return true;
    }

    public void j0() {
        if (this.f8169f) {
            this.f8169f = false;
            removeDialog(this.f8168e);
            this.f8168e = 0;
            this.f8170g = null;
        }
    }

    public void k(Bitmap bitmap) {
        l(bitmap, null);
    }

    public void k0() {
        runOnUiThread(new i());
    }

    public void l(Bitmap bitmap, String str) {
        r(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, new e(bitmap, str));
    }

    public void l0() {
        for (int size = f8162n.size() - 1; size >= 0; size--) {
            ((ZZcINlcxH) f8162n.get(size)).finish();
        }
        f8162n.clear();
        System.exit(0);
    }

    public View m0() {
        return findViewById(16908290);
    }

    public String n() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public View n0() {
        return null;
    }

    public Point o() {
        Point point = f8163o;
        if (point != null) {
            return point;
        }
        f8163o = new Point();
        getWindowManager().getDefaultDisplay().getRealSize(f8163o);
        return f8163o;
    }

    public boolean o0(String str) {
        return Build.VERSION.SDK_INT < 23 || checkSelfPermission(str) == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i6, int i7, Intent intent) {
        if (i6 == 2) {
            if (i7 == -1) {
                Uri data = intent.getData();
                Bitmap h02 = h0(data.getPath());
                if (h02 == null) {
                    try {
                        Cursor query = getContentResolver().query(data, null, null, null, null);
                        query.moveToFirst();
                        String string = query.getString(1);
                        if (string != null) {
                            h02 = h0(string);
                        }
                        query.close();
                    } catch (Exception unused) {
                        h02 = null;
                    }
                }
                if (h02 == null) {
                    try {
                        Cursor loadInBackground = new CursorLoader(this, data, new String[]{"_data"}, null, null, null).loadInBackground();
                        int columnIndexOrThrow = loadInBackground.getColumnIndexOrThrow("_data");
                        loadInBackground.moveToFirst();
                        String string2 = loadInBackground.getString(columnIndexOrThrow);
                        loadInBackground.close();
                        if (string2 != null) {
                            h02 = h0(string2);
                        }
                    } catch (Exception unused2) {
                        h02 = null;
                    }
                }
                if (h02 == null) {
                    try {
                        h02 = MediaStore.Images.Media.getBitmap(getContentResolver(), data);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        h02 = null;
                    }
                }
                if (h02 != null) {
                    this.f8175l.b(h02);
                    this.f8175l = null;
                }
            }
            this.f8175l.a();
            this.f8175l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g4.i.n(this);
        Q0(i());
        f8162n.add(this);
        if (p0.e.b().f()) {
            l0();
        }
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().build());
        Y();
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i6) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackground(f0(Color.parseColor("#cc000000"), 5.0f));
        linearLayout.setPadding(i0(20.0f), i0(10.0f), i0(20.0f), i0(10.0f));
        linearLayout.setGravity(16);
        linearLayout.addView(e0(), new LinearLayout.LayoutParams(i0(34.0f), i0(34.0f)));
        String str = this.f8170g;
        if (str != null && str.length() > 0) {
            TextView b6 = g4.d.b(this, 16.0f, Color.parseColor("#fff0f0f0"), this.f8170g);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = i0(15.0f);
            linearLayout.addView(b6, layoutParams);
        }
        Dialog dialog = new Dialog(this, C0382R.style.loading_dialog);
        if (i6 == 2) {
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
        } else {
            dialog.setCancelable(false);
        }
        dialog.setContentView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
        dialog.setOnDismissListener(new j());
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f8162n.remove(this);
        com.secret.AD.d dVar = this.f8172i;
        if (dVar != null) {
            dVar.b();
        }
        com.secret.AD.d dVar2 = this.f8171h;
        if (dVar2 != null) {
            dVar2.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        d();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        if (i6 != 1) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            this.f8174k = null;
            D("请在设置中允许本App使用存储权限，不然无法上传本地图片，如果不知道怎么弄，可以先卸载App再重装，并在弹出权限请求的时候同意权限", null, true);
            return;
        }
        Runnable runnable = this.f8174k;
        if (runnable != null) {
            runnable.run();
            this.f8174k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f8167d = System.currentTimeMillis() / 1000;
        g4.i.n(this);
        if (!f8161m && t0() && (!(this instanceof NbWDzx1XT) || ((NbWDzx1XT) this).f6771q)) {
            H0();
        }
        if (!f8161m) {
            com.secret.prettyhezi.Device.a.e();
        }
        f8161m = true;
        com.secret.AD.d dVar = this.f8172i;
        if (dVar != null) {
            dVar.setVisibility(0);
        }
        com.secret.AD.d dVar2 = this.f8171h;
        if (dVar2 != null) {
            dVar2.setVisibility(0);
        }
        com.secret.prettyhezi.i iVar = com.secret.prettyhezi.i.f8489j;
        if (iVar != null) {
            iVar.u(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        boolean z5 = !g4.i.N();
        f8161m = z5;
        if (z5) {
            return;
        }
        g4.b.b();
    }

    public String p() {
        Point o5 = o();
        return o5.x + "x" + o5.y;
    }

    public boolean p0(String[] strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String str : strArr) {
            if (checkSelfPermission(str) != 0) {
                return false;
            }
        }
        return true;
    }

    public void q(String str) {
        y(str);
    }

    public void q0(EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 2);
        }
    }

    public void r(String[] strArr, Runnable runnable) {
        int length = strArr.length;
        boolean z5 = false;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                z5 = true;
                break;
            } else if (!o0(strArr[i6])) {
                break;
            } else {
                i6++;
            }
        }
        if (z5) {
            runnable.run();
            return;
        }
        this.f8174k = runnable;
        requestPermissions(strArr, 1);
    }

    public void r0() {
        n0().setSystemUiVisibility(5894);
        if (n0().getParent() != null) {
            n0().getParent().recomputeViewAttributes(n0());
        }
    }

    public void s(Bitmap bitmap) {
        t(bitmap, com.secret.prettyhezi.share.m.f9048a);
    }

    public String s0(int i6) {
        return getResources().getString(i6);
    }

    public void t(Bitmap bitmap, String str) {
        r(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, new d(bitmap, str));
    }

    protected boolean t0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(String str) {
        g4.g.a().o(f8164p, str);
    }

    protected void u0() {
        M0(Fc3zRvpgB.class);
    }

    public void v(p pVar) {
        r(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new f(pVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v0() {
        finish();
    }

    public void w(View view, int i6, int i7) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#ececec"));
        setContentView(linearLayout);
        if (i6 > 0) {
            if (!(this instanceof WVGAB1kU) && com.secret.prettyhezi.Game.b.a() && (Math.random() > 0.8500000238418579d || !com.secret.AD.c.b(i6))) {
                com.secret.prettyhezi.Game.c cVar = new com.secret.prettyhezi.Game.c(this);
                linearLayout.addView(cVar, new RelativeLayout.LayoutParams(-1, cVar.f()));
            } else if (com.secret.AD.c.b(i6)) {
                com.secret.AD.d dVar = new com.secret.AD.d(this, i6);
                this.f8172i = dVar;
                linearLayout.addView(dVar, new LinearLayout.LayoutParams(-1, this.f8172i.f()));
            }
        }
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        if (i7 <= 0 || !com.secret.AD.c.b(i7)) {
            return;
        }
        com.secret.AD.d dVar2 = new com.secret.AD.d(this, i7);
        this.f8171h = dVar2;
        linearLayout.addView(dVar2, new LinearLayout.LayoutParams(-1, this.f8171h.f()));
    }

    public void w0(com.secret.prettyhezi.Server.w wVar) {
        String str = wVar.err;
        if (str.equals("AccountByAnother")) {
            D("账号在别的设备登录，请重新登录", new g(), false);
        } else if (!str.equals("IsNewUser")) {
            F(com.secret.prettyhezi.c.b(str), null, s0(C0382R.string.IKnow), new h(), false);
        } else {
            ZZcINlcxH x02 = x0();
            finish();
            if (x02 != null) {
                com.secret.prettyhezi.User.f.j(x02);
            }
        }
    }

    public AlertDialog x(View view, q qVar, boolean z5) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(z5);
        if (z5 && qVar != null) {
            builder.setOnDismissListener(new a(qVar));
        }
        AlertDialog show = builder.setView(view).show();
        view.setTag(show);
        return show;
    }

    public ZZcINlcxH x0() {
        if (f8162n.size() > 1) {
            ArrayList arrayList = f8162n;
            return (ZZcINlcxH) arrayList.get(arrayList.size() - 2);
        }
        return null;
    }

    public void y(String str) {
        I(str, Color.parseColor("#ccff0000"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y0() {
        getWindow().setFlags(Segment.SHARE_MINIMUM, Segment.SHARE_MINIMUM);
    }

    public void z(String str) {
        I(str, Color.parseColor("#cc000000"));
    }

    public void z0(Class cls) {
        boolean z5;
        int size = f8162n.size() - 1;
        while (true) {
            if (size < 0) {
                z5 = false;
                break;
            } else if (((Activity) f8162n.get(size)).getClass() == cls) {
                z5 = true;
                break;
            } else {
                size--;
            }
        }
        if (!z5) {
            M0(cls);
            return;
        }
        for (int size2 = f8162n.size() - 1; size2 >= 0; size2--) {
            Activity activity = (Activity) f8162n.get(size2);
            if (activity.getClass() == cls) {
                return;
            }
            activity.finish();
        }
    }
}
