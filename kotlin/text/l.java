package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public abstract class l {
    /* JADX INFO: Access modifiers changed from: private */
    public static final i f(Matcher matcher, int i6, CharSequence charSequence) {
        if (matcher.find(i6)) {
            return new j(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i g(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new j(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r4.c h(MatchResult matchResult) {
        r4.c g6;
        g6 = r4.f.g(matchResult.start(), matchResult.end());
        return g6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r4.c i(MatchResult matchResult, int i6) {
        r4.c g6;
        g6 = r4.f.g(matchResult.start(i6), matchResult.end(i6));
        return g6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(Iterable iterable) {
        Iterator it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 |= ((f) it.next()).getValue();
        }
        return i6;
    }
}
