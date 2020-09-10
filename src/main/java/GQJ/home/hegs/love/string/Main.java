package GQJ.home.hegs.love.string;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.logging.Logger;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/10
 */
public class Main {

    static Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        /**
         * %s：显示字符串；任意类型
         * %d：显示整数；
         * %x：显示十六进制整数；
         * %f：显示浮点数。
         */
        String val = "dd %s,来了，%d,什么，%f元";
        logger.info(String.format(val, "崎岖", 200, 100.21));
        String[] vals = new String[]{"a", "v", "d"};
        logger.info(String.join("**", vals));
        // 秀气的很
        StringJoiner joiner = new StringJoiner(",", "hello ", "!");
        Arrays.asList(vals).forEach(v -> {
            joiner.add(v);
        });
        logger.info(joiner.toString());
        String h = "0xe4b8ad";
        byte[] b = h.getBytes(StandardCharsets.UTF_8);
        logger.info(new String(b, StandardCharsets.UTF_8));
    }
}
