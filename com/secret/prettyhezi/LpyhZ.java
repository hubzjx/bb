package com.secret.prettyhezi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.controls.l;
import com.secret.prettyhezi.d;
import java.util.ArrayList;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class LpyhZ extends UoWMF {
    com.secret.prettyhezi.View.f A;
    com.secret.prettyhezi.View.j B;
    TextView C;
    l.f D = new b();

    /* renamed from: r  reason: collision with root package name */
    FrameLayout f6694r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f6695s;

    /* renamed from: t  reason: collision with root package name */
    com.secret.prettyhezi.controls.l f6696t;

    /* renamed from: u  reason: collision with root package name */
    int f6697u;

    /* renamed from: v  reason: collision with root package name */
    com.secret.prettyhezi.View.j[] f6698v;

    /* renamed from: w  reason: collision with root package name */
    com.secret.prettyhezi.View.k f6699w;

    /* renamed from: x  reason: collision with root package name */
    com.secret.prettyhezi.View.j f6700x;

    /* renamed from: y  reason: collision with root package name */
    com.secret.prettyhezi.View.j f6701y;

    /* renamed from: z  reason: collision with root package name */
    com.secret.prettyhezi.View.k f6702z;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            com.secret.prettyhezi.controls.l lVar;
            boolean z5;
            if (LpyhZ.this.C.getText().toString().equals(LpyhZ.this.s0(C0382R.string.edit))) {
                LpyhZ lpyhZ = LpyhZ.this;
                lpyhZ.C.setText(lpyhZ.s0(C0382R.string.cancel));
                lVar = LpyhZ.this.f6696t;
                z5 = true;
            } else {
                LpyhZ lpyhZ2 = LpyhZ.this;
                lpyhZ2.C.setText(lpyhZ2.s0(C0382R.string.edit));
                lVar = LpyhZ.this.f6696t;
                z5 = false;
            }
            lVar.g(z5);
        }
    }

    /* loaded from: classes.dex */
    class b implements l.f {
        b() {
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public int a() {
            return LpyhZ.this.f6697u;
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public String b(int i6) {
            LpyhZ lpyhZ;
            int i7;
            switch (i6) {
                case 0:
                    lpyhZ = LpyhZ.this;
                    i7 = C0382R.string.Boxes;
                    break;
                case 1:
                    lpyhZ = LpyhZ.this;
                    i7 = C0382R.string.Images;
                    break;
                case 2:
                    lpyhZ = LpyhZ.this;
                    i7 = C0382R.string.Gallerys;
                    break;
                case 3:
                    lpyhZ = LpyhZ.this;
                    i7 = C0382R.string.Audios;
                    break;
                case 4:
                    lpyhZ = LpyhZ.this;
                    i7 = C0382R.string.ShortVideos;
                    break;
                case 5:
                    lpyhZ = LpyhZ.this;
                    i7 = C0382R.string.Films;
                    break;
                case 6:
                    lpyhZ = LpyhZ.this;
                    i7 = C0382R.string.Novels;
                    break;
                case 7:
                    lpyhZ = LpyhZ.this;
                    i7 = C0382R.string.LongVideos;
                    break;
                default:
                    return null;
            }
            return lpyhZ.s0(i7);
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public String c(int i6) {
            StringBuilder sb;
            d.a aVar;
            switch (i6) {
                case 0:
                    sb = new StringBuilder();
                    aVar = d.Box;
                    break;
                case 1:
                    sb = new StringBuilder();
                    aVar = d.Photo;
                    break;
                case 2:
                    sb = new StringBuilder();
                    aVar = d.Gallery;
                    break;
                case 3:
                    sb = new StringBuilder();
                    aVar = d.Audio;
                    break;
                case 4:
                    sb = new StringBuilder();
                    aVar = d.Video;
                    break;
                case 5:
                    sb = new StringBuilder();
                    aVar = d.Film;
                    break;
                case 6:
                    sb = new StringBuilder();
                    aVar = d.Book;
                    break;
                case 7:
                    sb = new StringBuilder();
                    aVar = d.Upload;
                    break;
                default:
                    return null;
            }
            sb.append(aVar.items.size());
            sb.append(HttpUrl.FRAGMENT_ENCODE_SET);
            return sb.toString();
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public View d(int i6) {
            if (c(i6).equals("0")) {
                return LpyhZ.this.f6696t.r();
            }
            if (i6 == 0) {
                LpyhZ lpyhZ = LpyhZ.this;
                if (lpyhZ.A == null) {
                    lpyhZ.A = new com.secret.prettyhezi.View.f(LpyhZ.this);
                    com.secret.prettyhezi.View.f fVar = LpyhZ.this.A;
                    ArrayList<com.secret.prettyhezi.Server.n> arrayList = d.Box.items;
                    fVar.setItems((com.secret.prettyhezi.Server.d[]) arrayList.toArray(new com.secret.prettyhezi.Server.d[arrayList.size()]));
                }
                return LpyhZ.this.A;
            } else if (i6 == 1 || i6 == 2) {
                com.secret.prettyhezi.View.j[] jVarArr = LpyhZ.this.f6698v;
                int i7 = i6 - 1;
                if (jVarArr[i7] == null) {
                    if (i6 == 1) {
                        jVarArr[i7] = new com.secret.prettyhezi.View.j(LpyhZ.this, 1);
                        com.secret.prettyhezi.View.j jVar = LpyhZ.this.f6698v[i7];
                        ArrayList<com.secret.prettyhezi.Server.n> arrayList2 = d.Photo.items;
                        jVar.setItems((com.secret.prettyhezi.Server.h[]) arrayList2.toArray(new com.secret.prettyhezi.Server.h[arrayList2.size()]));
                    } else if (i6 == 2) {
                        jVarArr[i7] = new com.secret.prettyhezi.View.j(LpyhZ.this, 6);
                        com.secret.prettyhezi.View.j jVar2 = LpyhZ.this.f6698v[i7];
                        ArrayList<com.secret.prettyhezi.Server.n> arrayList3 = d.Gallery.items;
                        jVar2.setItems((com.secret.prettyhezi.Server.h[]) arrayList3.toArray(new com.secret.prettyhezi.Server.h[arrayList3.size()]));
                    }
                }
                return LpyhZ.this.f6698v[i7];
            } else if (i6 == 3) {
                LpyhZ lpyhZ2 = LpyhZ.this;
                if (lpyhZ2.f6699w == null) {
                    lpyhZ2.f6699w = new com.secret.prettyhezi.View.k(LpyhZ.this, 7);
                    com.secret.prettyhezi.View.k kVar = LpyhZ.this.f6699w;
                    ArrayList<com.secret.prettyhezi.Server.n> arrayList4 = d.Audio.items;
                    kVar.setItems((com.secret.prettyhezi.Server.h[]) arrayList4.toArray(new com.secret.prettyhezi.Server.h[arrayList4.size()]));
                }
                return LpyhZ.this.f6699w;
            } else if (i6 == 4) {
                LpyhZ lpyhZ3 = LpyhZ.this;
                if (lpyhZ3.f6700x == null) {
                    lpyhZ3.f6700x = new com.secret.prettyhezi.View.j(LpyhZ.this, 2);
                    com.secret.prettyhezi.View.j jVar3 = LpyhZ.this.f6700x;
                    ArrayList<com.secret.prettyhezi.Server.n> arrayList5 = d.Video.items;
                    jVar3.setItems((com.secret.prettyhezi.Server.h[]) arrayList5.toArray(new com.secret.prettyhezi.Server.h[arrayList5.size()]));
                }
                return LpyhZ.this.f6700x;
            } else if (i6 == 5) {
                LpyhZ lpyhZ4 = LpyhZ.this;
                if (lpyhZ4.f6701y == null) {
                    lpyhZ4.f6701y = new com.secret.prettyhezi.View.j(LpyhZ.this, 4);
                    com.secret.prettyhezi.View.j jVar4 = LpyhZ.this.f6701y;
                    ArrayList<com.secret.prettyhezi.Server.n> arrayList6 = d.Film.items;
                    jVar4.setItems((com.secret.prettyhezi.Server.h[]) arrayList6.toArray(new com.secret.prettyhezi.Server.h[arrayList6.size()]));
                }
                return LpyhZ.this.f6701y;
            } else if (i6 == 6) {
                LpyhZ lpyhZ5 = LpyhZ.this;
                if (lpyhZ5.f6702z == null) {
                    lpyhZ5.f6702z = new com.secret.prettyhezi.View.k(LpyhZ.this, 3);
                    com.secret.prettyhezi.View.k kVar2 = LpyhZ.this.f6702z;
                    ArrayList<com.secret.prettyhezi.Server.n> arrayList7 = d.Book.items;
                    kVar2.setItems((com.secret.prettyhezi.Server.h[]) arrayList7.toArray(new com.secret.prettyhezi.Server.h[arrayList7.size()]));
                }
                return LpyhZ.this.f6702z;
            } else if (i6 == 7) {
                LpyhZ lpyhZ6 = LpyhZ.this;
                if (lpyhZ6.B == null) {
                    lpyhZ6.B = new com.secret.prettyhezi.View.j(LpyhZ.this, 5);
                    com.secret.prettyhezi.View.j jVar5 = LpyhZ.this.B;
                    jVar5.R = 2;
                    ArrayList<com.secret.prettyhezi.Server.n> arrayList8 = d.Upload.items;
                    jVar5.setItems((com.secret.prettyhezi.Server.h[]) arrayList8.toArray(new com.secret.prettyhezi.Server.h[arrayList8.size()]));
                }
                return LpyhZ.this.B;
            } else {
                return null;
            }
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public View e() {
            return LpyhZ.this.f6695s;
        }
    }

    int S0() {
        if (d.Box.items.size() > 0) {
            return 0;
        }
        if (d.Photo.items.size() > 0) {
            return 1;
        }
        if (d.Gallery.items.size() > 0) {
            return 2;
        }
        if (d.Audio.items.size() > 0) {
            return 3;
        }
        if (d.Video.items.size() > 0) {
            return 4;
        }
        if (d.Film.items.size() > 0) {
            return 5;
        }
        if (d.Book.items.size() > 0) {
            return 6;
        }
        return d.Upload.items.size() > 0 ? 7 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6694r = A0(3, 4);
        this.f6695s = b0(s0(C0382R.string.History));
        this.f6697u = g4.i.r(52.0f);
        this.f6698v = new com.secret.prettyhezi.View.j[2];
        com.secret.prettyhezi.controls.l lVar = new com.secret.prettyhezi.controls.l(this, 8, this.D);
        this.f6696t = lVar;
        this.f6694r.addView(lVar, new FrameLayout.LayoutParams(-1, -1));
        this.f6696t.f(S0());
        TextView b6 = g4.d.b(this, 14.0f, -16777216, s0(C0382R.string.edit));
        this.C = b6;
        b6.setGravity(17);
        this.C.setBackground(g4.i.d(g4.i.b(-1, 12.0f), g4.i.b(-65536, 12.0f)));
        this.C.setOnClickListener(new a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(52.0f), g4.i.r(36.0f));
        layoutParams.rightMargin = g4.i.r(12.0f);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        this.f6695s.addView(this.C, 0, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.secret.prettyhezi.View.f fVar = this.A;
        if (fVar != null) {
            fVar.b();
        }
        com.secret.prettyhezi.View.j jVar = this.f6701y;
        if (jVar != null) {
            jVar.b();
        }
        com.secret.prettyhezi.View.k kVar = this.f6702z;
        if (kVar != null) {
            kVar.b();
        }
        int i6 = 0;
        while (true) {
            com.secret.prettyhezi.View.j[] jVarArr = this.f6698v;
            if (i6 >= jVarArr.length) {
                break;
            }
            com.secret.prettyhezi.View.j jVar2 = jVarArr[i6];
            if (jVar2 != null) {
                jVar2.b();
            }
            i6++;
        }
        com.secret.prettyhezi.View.j jVar3 = this.f6700x;
        if (jVar3 != null) {
            jVar3.b();
        }
        com.secret.prettyhezi.View.j jVar4 = this.B;
        if (jVar4 != null) {
            jVar4.b();
        }
        com.secret.prettyhezi.View.k kVar2 = this.f6699w;
        if (kVar2 != null) {
            kVar2.b();
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        if (this.f6696t == null || System.currentTimeMillis() - this.f6696t.A >= 500) {
            super.startActivity(intent);
        }
    }
}
