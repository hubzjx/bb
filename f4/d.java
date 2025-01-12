package f4;

import android.app.Dialog;
import android.media.AudioManager;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Video.MSqCZ2mQ;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes.dex */
public class d implements View.OnTouchListener {
    protected ImageView A;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9899b;

    /* renamed from: c  reason: collision with root package name */
    protected float f9900c;

    /* renamed from: d  reason: collision with root package name */
    protected float f9901d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f9902e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f9903f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f9904g;

    /* renamed from: h  reason: collision with root package name */
    protected long f9905h;

    /* renamed from: i  reason: collision with root package name */
    protected int f9906i;

    /* renamed from: j  reason: collision with root package name */
    protected float f9907j;

    /* renamed from: k  reason: collision with root package name */
    protected long f9908k;

    /* renamed from: l  reason: collision with root package name */
    protected AudioManager f9909l;

    /* renamed from: m  reason: collision with root package name */
    int f9910m;

    /* renamed from: n  reason: collision with root package name */
    int f9911n;

    /* renamed from: o  reason: collision with root package name */
    MSqCZ2mQ f9912o;

    /* renamed from: p  reason: collision with root package name */
    protected Dialog f9913p;

    /* renamed from: q  reason: collision with root package name */
    protected ProgressBar f9914q;

    /* renamed from: r  reason: collision with root package name */
    protected TextView f9915r;

    /* renamed from: s  reason: collision with root package name */
    protected Dialog f9916s;

    /* renamed from: t  reason: collision with root package name */
    protected ProgressBar f9917t;

    /* renamed from: u  reason: collision with root package name */
    protected TextView f9918u;

    /* renamed from: v  reason: collision with root package name */
    protected TextView f9919v;

    /* renamed from: w  reason: collision with root package name */
    protected ImageView f9920w;

    /* renamed from: x  reason: collision with root package name */
    protected Dialog f9921x;

    /* renamed from: y  reason: collision with root package name */
    protected ProgressBar f9922y;

    /* renamed from: z  reason: collision with root package name */
    protected TextView f9923z;

    public d(MSqCZ2mQ mSqCZ2mQ) {
        this.f9912o = mSqCZ2mQ;
        this.f9910m = mSqCZ2mQ.f7772x.getWidth();
        this.f9911n = mSqCZ2mQ.f7772x.getHeight();
        this.f9909l = (AudioManager) mSqCZ2mQ.getSystemService("audio");
    }

    public static String h(long j6) {
        if (j6 <= 0 || j6 >= 86400000) {
            return "00:00";
        }
        long j7 = j6 / 1000;
        int i6 = (int) (j7 % 60);
        int i7 = (int) ((j7 / 60) % 60);
        int i8 = (int) (j7 / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return (i8 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i8), Integer.valueOf(i7), Integer.valueOf(i6)) : formatter.format("%02d:%02d", Integer.valueOf(i7), Integer.valueOf(i6))).toString();
    }

    public Dialog a(View view) {
        Dialog dialog = new Dialog(this.f9912o, C0382R.style.style_dialog_progress);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.addFlags(8);
        window.addFlags(32);
        window.addFlags(16);
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        return dialog;
    }

    public void b() {
        Dialog dialog = this.f9913p;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void c() {
        Dialog dialog = this.f9916s;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void d() {
        Dialog dialog = this.f9921x;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void e(int i6) {
        if (this.f9913p == null) {
            View inflate = LayoutInflater.from(this.f9912o).inflate(C0382R.layout.jz_dialog_brightness, (ViewGroup) null);
            this.f9915r = (TextView) inflate.findViewById(C0382R.id.tv_brightness);
            this.f9914q = (ProgressBar) inflate.findViewById(C0382R.id.brightness_progressbar);
            this.f9913p = a(inflate);
        }
        if (!this.f9913p.isShowing()) {
            this.f9913p.show();
        }
        if (i6 > 100) {
            i6 = 100;
        } else if (i6 < 0) {
            i6 = 0;
        }
        TextView textView = this.f9915r;
        textView.setText(i6 + "%");
        this.f9914q.setProgress(i6);
    }

    public void f(float f6, String str, long j6, String str2, long j7) {
        ImageView imageView;
        int i6;
        if (this.f9916s == null) {
            View inflate = LayoutInflater.from(this.f9912o).inflate(C0382R.layout.jz_dialog_progress, (ViewGroup) null);
            this.f9917t = (ProgressBar) inflate.findViewById(C0382R.id.duration_progressbar);
            this.f9918u = (TextView) inflate.findViewById(C0382R.id.tv_current);
            this.f9919v = (TextView) inflate.findViewById(C0382R.id.tv_duration);
            this.f9920w = (ImageView) inflate.findViewById(C0382R.id.duration_image_tip);
            this.f9916s = a(inflate);
        }
        if (!this.f9916s.isShowing()) {
            this.f9916s.show();
        }
        this.f9918u.setText(str);
        TextView textView = this.f9919v;
        textView.setText(" / " + str2);
        this.f9917t.setProgress(j7 <= 0 ? 0 : (int) ((j6 * 100) / j7));
        if (f6 > 0.0f) {
            imageView = this.f9920w;
            i6 = C0382R.drawable.forward_icon;
        } else {
            imageView = this.f9920w;
            i6 = C0382R.drawable.backward_icon;
        }
        imageView.setBackgroundResource(i6);
    }

    public void g(float f6, int i6) {
        if (this.f9921x == null) {
            View inflate = LayoutInflater.from(this.f9912o).inflate(C0382R.layout.jz_dialog_volume, (ViewGroup) null);
            this.A = (ImageView) inflate.findViewById(C0382R.id.volume_image_tip);
            this.f9923z = (TextView) inflate.findViewById(C0382R.id.tv_volume);
            this.f9922y = (ProgressBar) inflate.findViewById(C0382R.id.volume_progressbar);
            this.f9921x = a(inflate);
        }
        if (!this.f9921x.isShowing()) {
            this.f9921x.show();
        }
        this.A.setBackgroundResource(i6 <= 0 ? C0382R.drawable.close_volume : C0382R.drawable.add_volume);
        if (i6 > 100) {
            i6 = 100;
        } else if (i6 < 0) {
            i6 = 0;
        }
        TextView textView = this.f9923z;
        textView.setText(i6 + "%");
        this.f9922y.setProgress(i6);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int streamMaxVolume;
        int i6;
        if (this.f9912o.v1()) {
            return true;
        }
        float x5 = motionEvent.getX();
        float y5 = motionEvent.getY();
        if (view.getId() == C0382R.id.surface_container) {
            int action = motionEvent.getAction();
            if (action == 0) {
                Log.i("VideoTouch", "onTouch surfaceContainer actionDown [" + hashCode() + "] ");
                this.f9899b = true;
                this.f9900c = x5;
                this.f9901d = y5;
                this.f9902e = false;
                this.f9903f = false;
                this.f9904g = false;
            } else if (action == 1) {
                Log.i("VideoTouch", "onTouch surfaceContainer actionUp [" + hashCode() + "] ");
                this.f9899b = false;
                c();
                d();
                b();
                if (this.f9903f) {
                    this.f9912o.t1(this.f9908k);
                    long f12 = this.f9912o.f1();
                    long j6 = this.f9908k * 100;
                    if (f12 == 0) {
                        f12 = 1;
                    }
                    int i7 = (int) (j6 / f12);
                    this.f9912o.M.setProgress(i7);
                    this.f9912o.J.setProgress(i7);
                } else if (!this.f9904g && !this.f9902e) {
                    MSqCZ2mQ mSqCZ2mQ = this.f9912o;
                    if (mSqCZ2mQ.f7758l0 == 1) {
                        mSqCZ2mQ.p1();
                    }
                }
                this.f9912o.f7762p0 = false;
            } else if (action == 2) {
                Log.i("VideoTouch", "onTouch surfaceContainer actionMove [" + hashCode() + "] ");
                float f6 = x5 - this.f9900c;
                float f7 = y5 - this.f9901d;
                float abs = Math.abs(f6);
                float abs2 = Math.abs(f7);
                if (!this.f9903f && !this.f9902e && !this.f9904g && (abs > 80.0f || abs2 > 80.0f)) {
                    MSqCZ2mQ mSqCZ2mQ2 = this.f9912o;
                    mSqCZ2mQ2.f7762p0 = true;
                    if (i6 >= 0) {
                        if (mSqCZ2mQ2.f7758l0 == 1) {
                            this.f9903f = true;
                            this.f9905h = mSqCZ2mQ2.e1();
                        }
                    } else if (this.f9900c < this.f9910m * 0.5f) {
                        this.f9904g = true;
                        float f8 = mSqCZ2mQ2.getWindow().getAttributes().screenBrightness;
                        if (f8 < 0.0f) {
                            try {
                                this.f9907j = Settings.System.getInt(this.f9912o.getContentResolver(), "screen_brightness");
                                Log.i("VideoTouch", "current system brightness: " + this.f9907j);
                            } catch (Settings.SettingNotFoundException e6) {
                                e6.printStackTrace();
                            }
                        } else {
                            this.f9907j = f8 * 255.0f;
                            Log.i("VideoTouch", "current activity brightness: " + this.f9907j);
                        }
                    } else {
                        this.f9902e = true;
                        this.f9906i = this.f9909l.getStreamVolume(3);
                    }
                }
                if (this.f9903f) {
                    long f13 = this.f9912o.f1();
                    long j7 = (int) (((float) this.f9905h) + ((((float) f13) * f6) / this.f9910m));
                    this.f9908k = j7;
                    if (j7 > f13) {
                        this.f9908k = f13;
                    }
                    f(f6, h(this.f9908k), this.f9908k, h(f13), f13);
                }
                if (this.f9902e) {
                    f7 = -f7;
                    this.f9909l.setStreamVolume(3, this.f9906i + ((int) (((this.f9909l.getStreamMaxVolume(3) * f7) * 3.0f) / this.f9911n)), 0);
                    g(-f7, (int) (((this.f9906i * 100) / streamMaxVolume) + (((f7 * 3.0f) * 100.0f) / this.f9911n)));
                }
                if (this.f9904g) {
                    float f9 = -f7;
                    WindowManager.LayoutParams attributes = this.f9912o.getWindow().getAttributes();
                    float f10 = this.f9907j;
                    float f11 = (int) (((f9 * 255.0f) * 3.0f) / this.f9911n);
                    if ((f10 + f11) / 255.0f >= 1.0f) {
                        attributes.screenBrightness = 1.0f;
                    } else if ((f10 + f11) / 255.0f <= 0.0f) {
                        attributes.screenBrightness = 0.01f;
                    } else {
                        attributes.screenBrightness = (f10 + f11) / 255.0f;
                    }
                    this.f9912o.getWindow().setAttributes(attributes);
                    e((int) (((this.f9907j * 100.0f) / 255.0f) + (((f9 * 3.0f) * 100.0f) / this.f9911n)));
                }
            }
        }
        return true;
    }
}
