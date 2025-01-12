package kotlin.text;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class o {
    public static void a(Appendable appendable, Object obj, p4.l lVar) {
        CharSequence valueOf;
        kotlin.jvm.internal.l.d(appendable, "<this>");
        if (lVar != null) {
            obj = lVar.invoke(obj);
        } else {
            if (!(obj == null ? true : obj instanceof CharSequence)) {
                if (obj instanceof Character) {
                    appendable.append(((Character) obj).charValue());
                    return;
                }
                valueOf = String.valueOf(obj);
                appendable.append(valueOf);
            }
        }
        valueOf = (CharSequence) obj;
        appendable.append(valueOf);
    }
}
