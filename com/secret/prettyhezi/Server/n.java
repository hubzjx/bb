package com.secret.prettyhezi.Server;

import android.widget.FrameLayout;
import java.io.Serializable;
/* loaded from: classes.dex */
public class n implements Serializable {
    public int id;
    public transient FrameLayout.LayoutParams pa;
    public transient int pageIndex;
    public transient boolean selected = false;
    public transient com.secret.prettyhezi.View.u view;

    public void Clear() {
        this.view = null;
        this.pa = null;
    }
}
