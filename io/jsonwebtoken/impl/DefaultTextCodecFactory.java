package io.jsonwebtoken.impl;
@Deprecated
/* loaded from: classes.dex */
public class DefaultTextCodecFactory implements TextCodecFactory {
    protected String getSystemProperty(String str) {
        return System.getProperty(str);
    }

    @Override // io.jsonwebtoken.impl.TextCodecFactory
    public TextCodec getTextCodec() {
        return isAndroid() ? new AndroidBase64Codec() : new Base64Codec();
    }

    protected boolean isAndroid() {
        String lowerCase;
        String str;
        String systemProperty = getSystemProperty("java.vm.name");
        if (systemProperty != null) {
            lowerCase = systemProperty.toLowerCase();
            str = "dalvik";
        } else {
            String systemProperty2 = getSystemProperty("java.vm.vendor");
            if (systemProperty2 == null) {
                return false;
            }
            lowerCase = systemProperty2.toLowerCase();
            str = "android";
        }
        return lowerCase.contains(str);
    }
}
