package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: c  reason: collision with root package name */
    public static final f f3361c = new f(new int[]{2}, 8);

    /* renamed from: d  reason: collision with root package name */
    private static final f f3362d = new f(new int[]{2, 5, 6}, 8);

    /* renamed from: a  reason: collision with root package name */
    private final int[] f3363a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3364b;

    public f(int[] iArr, int i6) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f3363a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f3363a = new int[0];
        }
        this.f3364b = i6;
    }

    private static boolean a() {
        return com.google.android.exoplayer2.util.s0.f4673a >= 17 && "Amazon".equals(com.google.android.exoplayer2.util.s0.f4675c);
    }

    public static f b(Context context) {
        return c(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    static f c(Context context, Intent intent) {
        return (a() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) ? f3362d : (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f3361c : new f(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }

    public int d() {
        return this.f3364b;
    }

    public boolean e(int i6) {
        return Arrays.binarySearch(this.f3363a, i6) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return Arrays.equals(this.f3363a, fVar.f3363a) && this.f3364b == fVar.f3364b;
        }
        return false;
    }

    public int hashCode() {
        return this.f3364b + (Arrays.hashCode(this.f3363a) * 31);
    }

    public String toString() {
        int i6 = this.f3364b;
        String arrays = Arrays.toString(this.f3363a);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i6);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
