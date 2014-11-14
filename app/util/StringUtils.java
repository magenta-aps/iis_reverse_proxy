package util;

/**
 * Created by Beemen on 14/11/2014.
 */
public class StringUtils {
    public static String TrimZerosOnLeft(String string) {
        if (string != null)
            return string.replaceAll("\\A0+", "");
        return string;
    }
}
