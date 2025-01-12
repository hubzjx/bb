package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
final class e {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap f4264a;

    /* loaded from: classes.dex */
    class a extends LinkedHashMap {
        final /* synthetic */ int val$maxSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e eVar, int i6, float f6, boolean z5, int i7) {
            super(i6, f6, z5);
            this.val$maxSize = i7;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
            return size() > this.val$maxSize;
        }
    }

    public e(int i6) {
        this.f4264a = new a(this, i6 + 1, 1.0f, false, i6);
    }

    public byte[] a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return (byte[]) this.f4264a.get(uri);
    }

    public byte[] b(Uri uri, byte[] bArr) {
        return (byte[]) this.f4264a.put((Uri) com.google.android.exoplayer2.util.a.e(uri), (byte[]) com.google.android.exoplayer2.util.a.e(bArr));
    }

    public byte[] c(Uri uri) {
        return (byte[]) this.f4264a.remove(com.google.android.exoplayer2.util.a.e(uri));
    }
}
