package io.jsonwebtoken.lang;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class Strings {
    private static final String CURRENT_PATH = ".";
    private static final char EXTENSION_SEPARATOR = '.';
    private static final String FOLDER_SEPARATOR = "/";
    private static final String TOP_PATH = "..";
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final String WINDOWS_FOLDER_SEPARATOR = "\\";

    private Strings() {
    }

    public static String[] addStringToArray(String[] strArr, String str) {
        if (Objects.isEmpty(strArr)) {
            return new String[]{str};
        }
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr.length] = str;
        return strArr2;
    }

    public static String applyRelativePath(String str, String str2) {
        int lastIndexOf = str.lastIndexOf(FOLDER_SEPARATOR);
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            if (!str2.startsWith(FOLDER_SEPARATOR)) {
                substring = substring + FOLDER_SEPARATOR;
            }
            return substring + str2;
        }
        return str2;
    }

    public static String arrayToCommaDelimitedString(Object[] objArr) {
        return arrayToDelimitedString(objArr, ",");
    }

    public static String arrayToDelimitedString(Object[] objArr, String str) {
        if (Objects.isEmpty(objArr)) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (objArr.length == 1) {
            return Objects.nullSafeToString(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < objArr.length; i6++) {
            if (i6 > 0) {
                sb.append(str);
            }
            sb.append(objArr[i6]);
        }
        return sb.toString();
    }

    public static String capitalize(String str) {
        return changeFirstCharacterCase(str, true);
    }

    private static String changeFirstCharacterCase(String str, boolean z5) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(z5 ? Character.toUpperCase(str.charAt(0)) : Character.toLowerCase(str.charAt(0)));
        sb.append(str.substring(1));
        return sb.toString();
    }

    public static CharSequence clean(CharSequence charSequence) {
        CharSequence trimWhitespace = trimWhitespace(charSequence);
        if (hasLength(trimWhitespace)) {
            return trimWhitespace;
        }
        return null;
    }

    public static String cleanPath(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        String replace = replace(str, WINDOWS_FOLDER_SEPARATOR, FOLDER_SEPARATOR);
        int indexOf = replace.indexOf(":");
        if (indexOf != -1) {
            int i6 = indexOf + 1;
            str2 = replace.substring(0, i6);
            replace = replace.substring(i6);
        } else {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (replace.startsWith(FOLDER_SEPARATOR)) {
            str2 = str2 + FOLDER_SEPARATOR;
            replace = replace.substring(1);
        }
        String[] delimitedListToStringArray = delimitedListToStringArray(replace, FOLDER_SEPARATOR);
        LinkedList linkedList = new LinkedList();
        int i7 = 0;
        for (int length = delimitedListToStringArray.length - 1; length >= 0; length--) {
            String str3 = delimitedListToStringArray[length];
            if (!CURRENT_PATH.equals(str3)) {
                if (TOP_PATH.equals(str3)) {
                    i7++;
                } else if (i7 > 0) {
                    i7--;
                } else {
                    linkedList.add(0, str3);
                }
            }
        }
        for (int i8 = 0; i8 < i7; i8++) {
            linkedList.add(0, TOP_PATH);
        }
        return str2 + collectionToDelimitedString(linkedList, FOLDER_SEPARATOR);
    }

    public static String collectionToCommaDelimitedString(Collection<?> collection) {
        return collectionToDelimitedString(collection, ",");
    }

    public static String collectionToDelimitedString(Collection<?> collection, String str) {
        return collectionToDelimitedString(collection, str, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public static Set<String> commaDelimitedListToSet(String str) {
        TreeSet treeSet = new TreeSet();
        for (String str2 : commaDelimitedListToStringArray(str)) {
            treeSet.add(str2);
        }
        return treeSet;
    }

    public static String[] commaDelimitedListToStringArray(String str) {
        return delimitedListToStringArray(str, ",");
    }

    public static String[] concatenateStringArrays(String[] strArr, String[] strArr2) {
        if (Objects.isEmpty(strArr)) {
            return strArr2;
        }
        if (Objects.isEmpty(strArr2)) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (hasLength(charSequence)) {
            int length = charSequence.length();
            for (int i6 = 0; i6 < length; i6++) {
                if (Character.isWhitespace(charSequence.charAt(i6))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static int countOccurrencesOf(String str, String str2) {
        int i6 = 0;
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int i7 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i6);
            if (indexOf == -1) {
                return i7;
            }
            i7++;
            i6 = indexOf + str2.length();
        }
    }

    public static String delete(String str, String str2) {
        return replace(str, str2, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public static String deleteAny(String str, String str2) {
        if (hasLength(str) && hasLength(str2)) {
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < str.length(); i6++) {
                char charAt = str.charAt(i6);
                if (str2.indexOf(charAt) == -1) {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return str;
    }

    public static String[] delimitedListToStringArray(String str, String str2) {
        return delimitedListToStringArray(str, str2, null);
    }

    public static boolean endsWithIgnoreCase(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str.endsWith(str2)) {
            return true;
        }
        if (str.length() < str2.length()) {
            return false;
        }
        return str.substring(str.length() - str2.length()).toLowerCase().equals(str2.toLowerCase());
    }

    public static String getFilename(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(FOLDER_SEPARATOR);
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : str;
    }

    public static String getFilenameExtension(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) == -1 || str.lastIndexOf(FOLDER_SEPARATOR) > lastIndexOf) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static boolean hasLength(CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0;
    }

    public static boolean hasText(CharSequence charSequence) {
        if (hasLength(charSequence)) {
            int length = charSequence.length();
            for (int i6 = 0; i6 < length; i6++) {
                if (!Character.isWhitespace(charSequence.charAt(i6))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static String[] mergeStringArrays(String[] strArr, String[] strArr2) {
        if (Objects.isEmpty(strArr)) {
            return strArr2;
        }
        if (Objects.isEmpty(strArr2)) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(java.util.Arrays.asList(strArr));
        for (String str : strArr2) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return toStringArray(arrayList);
    }

    public static Locale parseLocaleString(String str) {
        String[] strArr = tokenizeToStringArray(str, "_ ", false, false);
        int length = strArr.length;
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        String str3 = length > 0 ? strArr[0] : HttpUrl.FRAGMENT_ENCODE_SET;
        String str4 = strArr.length > 1 ? strArr[1] : HttpUrl.FRAGMENT_ENCODE_SET;
        validateLocalePart(str3);
        validateLocalePart(str4);
        if (strArr.length >= 2) {
            str2 = trimLeadingWhitespace(str.substring(str.indexOf(str4) + str4.length()));
            if (str2.startsWith("_")) {
                str2 = trimLeadingCharacter(str2, '_');
            }
        }
        if (str3.length() > 0) {
            return new Locale(str3, str4, str2);
        }
        return null;
    }

    public static boolean pathEquals(String str, String str2) {
        return cleanPath(str).equals(cleanPath(str2));
    }

    public static String quote(String str) {
        if (str != null) {
            return "'" + str + "'";
        }
        return null;
    }

    public static Object quoteIfString(Object obj) {
        return obj instanceof String ? quote((String) obj) : obj;
    }

    public static String[] removeDuplicateStrings(String[] strArr) {
        if (Objects.isEmpty(strArr)) {
            return strArr;
        }
        TreeSet treeSet = new TreeSet();
        for (String str : strArr) {
            treeSet.add(str);
        }
        return toStringArray(treeSet);
    }

    public static String replace(String str, String str2, String str3) {
        if (hasLength(str) && hasLength(str2) && str3 != null) {
            StringBuilder sb = new StringBuilder();
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            int i6 = 0;
            while (indexOf >= 0) {
                sb.append(str.substring(i6, indexOf));
                sb.append(str3);
                i6 = indexOf + length;
                indexOf = str.indexOf(str2, i6);
            }
            sb.append(str.substring(i6));
            return sb.toString();
        }
        return str;
    }

    public static String[] sortStringArray(String[] strArr) {
        if (Objects.isEmpty(strArr)) {
            return new String[0];
        }
        java.util.Arrays.sort(strArr);
        return strArr;
    }

    public static String[] split(String str, String str2) {
        int indexOf;
        if (hasLength(str) && hasLength(str2) && (indexOf = str.indexOf(str2)) >= 0) {
            return new String[]{str.substring(0, indexOf), str.substring(indexOf + str2.length())};
        }
        return null;
    }

    public static Properties splitArrayElementsIntoProperties(String[] strArr, String str) {
        return splitArrayElementsIntoProperties(strArr, str, null);
    }

    public static boolean startsWithIgnoreCase(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str.startsWith(str2)) {
            return true;
        }
        if (str.length() < str2.length()) {
            return false;
        }
        return str.substring(0, str2.length()).toLowerCase().equals(str2.toLowerCase());
    }

    public static String stripFilenameExtension(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf != -1 && str.lastIndexOf(FOLDER_SEPARATOR) <= lastIndexOf) ? str.substring(0, lastIndexOf) : str;
    }

    public static boolean substringMatch(CharSequence charSequence, int i6, CharSequence charSequence2) {
        for (int i7 = 0; i7 < charSequence2.length(); i7++) {
            int i8 = i6 + i7;
            if (i8 >= charSequence.length() || charSequence.charAt(i8) != charSequence2.charAt(i7)) {
                return false;
            }
        }
        return true;
    }

    public static String toLanguageTag(Locale locale) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage());
        if (hasText(locale.getCountry())) {
            str = "-" + locale.getCountry();
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        return sb.toString();
    }

    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }
        return (String[]) collection.toArray(new String[collection.size()]);
    }

    public static String[] tokenizeToStringArray(String str, String str2) {
        return tokenizeToStringArray(str, str2, true, true);
    }

    public static String trimAllWhitespace(String str) {
        if (hasLength(str)) {
            StringBuilder sb = new StringBuilder(str);
            int i6 = 0;
            while (sb.length() > i6) {
                if (Character.isWhitespace(sb.charAt(i6))) {
                    sb.deleteCharAt(i6);
                } else {
                    i6++;
                }
            }
            return sb.toString();
        }
        return str;
    }

    public static String[] trimArrayElements(String[] strArr) {
        if (Objects.isEmpty(strArr)) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        for (int i6 = 0; i6 < strArr.length; i6++) {
            String str = strArr[i6];
            strArr2[i6] = str != null ? str.trim() : null;
        }
        return strArr2;
    }

    public static String trimLeadingCharacter(String str, char c6) {
        if (hasLength(str)) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() > 0 && sb.charAt(0) == c6) {
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }
        return str;
    }

    public static String trimLeadingWhitespace(String str) {
        if (hasLength(str)) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }
        return str;
    }

    public static String trimTrailingCharacter(String str, char c6) {
        if (hasLength(str)) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == c6) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return str;
    }

    public static String trimTrailingWhitespace(String str) {
        if (hasLength(str)) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return str;
    }

    private static CharSequence trimWhitespace(CharSequence charSequence) {
        if (hasLength(charSequence)) {
            int length = charSequence.length();
            int i6 = 0;
            while (i6 < length && Character.isWhitespace(charSequence.charAt(i6))) {
                i6++;
            }
            int i7 = length;
            while (i6 < length && Character.isWhitespace(charSequence.charAt(i7 - 1))) {
                i7--;
            }
            return (i6 > 0 || i7 < length) ? charSequence.subSequence(i6, i7) : charSequence;
        }
        return charSequence;
    }

    public static String uncapitalize(String str) {
        return changeFirstCharacterCase(str, false);
    }

    public static String unqualify(String str) {
        return unqualify(str, '.');
    }

    private static void validateLocalePart(String str) {
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt != '_' && charAt != ' ' && !Character.isLetterOrDigit(charAt)) {
                throw new IllegalArgumentException("Locale part \"" + str + "\" contains invalid characters");
            }
        }
    }

    public static String clean(String str) {
        CharSequence clean = clean((CharSequence) str);
        if (clean != null) {
            return clean.toString();
        }
        return null;
    }

    public static String collectionToDelimitedString(Collection<?> collection, String str, String str2, String str3) {
        if (Collections.isEmpty(collection)) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(str2);
            sb.append(it.next());
            sb.append(str3);
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static boolean containsWhitespace(String str) {
        return containsWhitespace((CharSequence) str);
    }

    public static String[] delimitedListToStringArray(String str, String str2, String str3) {
        int i6 = 0;
        if (str == null) {
            return new String[0];
        }
        if (str2 == null) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        if (HttpUrl.FRAGMENT_ENCODE_SET.equals(str2)) {
            while (i6 < str.length()) {
                int i7 = i6 + 1;
                arrayList.add(deleteAny(str.substring(i6, i7), str3));
                i6 = i7;
            }
        } else {
            while (true) {
                int indexOf = str.indexOf(str2, i6);
                if (indexOf == -1) {
                    break;
                }
                arrayList.add(deleteAny(str.substring(i6, indexOf), str3));
                i6 = str2.length() + indexOf;
            }
            if (str.length() > 0 && i6 <= str.length()) {
                arrayList.add(deleteAny(str.substring(i6), str3));
            }
        }
        return toStringArray(arrayList);
    }

    public static boolean hasLength(String str) {
        return hasLength((CharSequence) str);
    }

    public static boolean hasText(String str) {
        return hasText((CharSequence) str);
    }

    public static Properties splitArrayElementsIntoProperties(String[] strArr, String str, String str2) {
        if (Objects.isEmpty(strArr)) {
            return null;
        }
        Properties properties = new Properties();
        for (String str3 : strArr) {
            if (str2 != null) {
                str3 = deleteAny(str3, str2);
            }
            String[] split = split(str3, str);
            if (split != null) {
                properties.setProperty(split[0].trim(), split[1].trim());
            }
        }
        return properties;
    }

    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }
        ArrayList list = java.util.Collections.list(enumeration);
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static String[] tokenizeToStringArray(String str, String str2, boolean z5, boolean z6) {
        if (str == null) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (z5) {
                nextToken = nextToken.trim();
            }
            if (!z6 || nextToken.length() > 0) {
                arrayList.add(nextToken);
            }
        }
        return toStringArray(arrayList);
    }

    public static String trimWhitespace(String str) {
        return (String) trimWhitespace((CharSequence) str);
    }

    public static String unqualify(String str, char c6) {
        return str.substring(str.lastIndexOf(c6) + 1);
    }
}
