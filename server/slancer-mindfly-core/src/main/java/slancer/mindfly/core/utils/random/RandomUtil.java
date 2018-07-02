package slancer.mindfly.core.utils.random;

import java.util.Random;

public class RandomUtil {

    private static final String chars = "abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "1234567890";

    /**
     *
     * @param len required length for random string
     * @return random string for specific length
     */
    public static String nextString(int len) {
        Random rand = new Random();
        String rst = "";
        int index = 0;
        while (len > 0) {
            index = rand.nextInt(chars.length());
            rst += chars.charAt(index);
            --len;
        }
        return rst;
    }
}
