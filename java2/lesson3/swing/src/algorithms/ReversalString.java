package algorithms;

/**
 * Created by Артем on 07.01.2015.
 */
public class ReversalString {

    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(str);
        System.out.println(reverse(str));
    }

    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        char[] res = new char[chars.length];
        for (int i = 0, j = chars.length - 1; i < chars.length; i++, j--) {
            res[i] = chars[j];
        }
        return new String(res);
    }
}
