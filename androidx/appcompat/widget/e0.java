package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
/* loaded from: classes.dex */
final class e0 {

    /* renamed from: a  reason: collision with root package name */
    private TextView f892a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f893b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(TextView textView) {
        this.f892a = (TextView) d0.i.c(textView);
    }

    public TextClassifier a() {
        Object systemService;
        TextClassifier textClassifier;
        TextClassifier textClassifier2;
        TextClassifier textClassifier3 = this.f893b;
        if (textClassifier3 == null) {
            systemService = this.f892a.getContext().getSystemService(TextClassificationManager.class);
            TextClassificationManager a6 = b0.a(systemService);
            if (a6 != null) {
                textClassifier2 = a6.getTextClassifier();
                return textClassifier2;
            }
            textClassifier = TextClassifier.NO_OP;
            return textClassifier;
        }
        return textClassifier3;
    }

    public void b(TextClassifier textClassifier) {
        this.f893b = textClassifier;
    }
}
