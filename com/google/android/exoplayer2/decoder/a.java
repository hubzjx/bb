package com.google.android.exoplayer2.decoder;
/* loaded from: classes.dex */
public abstract class a {
    private int flags;

    public final void addFlag(int i6) {
        this.flags = i6 | this.flags;
    }

    public void clear() {
        this.flags = 0;
    }

    public final void clearFlag(int i6) {
        this.flags = (~i6) & this.flags;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getFlag(int i6) {
        return (this.flags & i6) == i6;
    }

    public final boolean hasSupplementalData() {
        return getFlag(268435456);
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final void setFlags(int i6) {
        this.flags = i6;
    }
}
