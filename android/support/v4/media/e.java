package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
/* loaded from: classes.dex */
abstract class e {

    /* loaded from: classes.dex */
    static class a {
        public static void a(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri a(Object obj) {
        Uri mediaUri;
        mediaUri = ((MediaDescription) obj).getMediaUri();
        return mediaUri;
    }
}
