package com.secret.prettyhezi.message;

import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Server.n;
/* loaded from: classes.dex */
public class e extends n {
    public int chat_id;
    public String content;
    public long created_at;
    public String image;
    public e notify;
    public int sender;
    public String sender_share;
    public int target;
    public String target_share;
    public long updated_at;

    public String GetFakeUrl() {
        String str = this.image;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return "session/" + this.chat_id + "_" + this.image + ".jpg";
    }

    public String GetText() {
        String str = this.content;
        if (str == null || str.length() <= 0) {
            String str2 = this.image;
            if (str2 != null && str2.length() > 0) {
                return "[" + g4.i.j().s0(C0382R.string.Photo) + "]";
            }
            e eVar = this.notify;
            if (eVar != null) {
                String str3 = eVar.content;
                if (str3 == null || str3.length() <= 0) {
                    String str4 = this.notify.image;
                    if (str4 == null || str4.length() <= 0) {
                        return "空";
                    }
                    return "[" + g4.i.j().s0(C0382R.string.Photo) + "]";
                }
                return this.notify.content;
            }
            return "空";
        }
        return this.content;
    }

    public boolean IsImage() {
        String str = this.image;
        return str != null && str.length() > 0;
    }
}
