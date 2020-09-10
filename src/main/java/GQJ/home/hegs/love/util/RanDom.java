package GQJ.home.hegs.love.util;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/10
 */
public class RanDom {
    static Logger logger = Logger.getGlobal();

    public static void main(String[] args) throws Exception {
        // 伪随机，产生的序列都是固定的
        //Random random = new Random(100);
        //for (int n = 0; n < 3; n++) {
        //    logger.info(String.valueOf(random.nextInt(8)));
        //}
        //SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        //secureRandom.nextLong();
        rand(Stream.of(10L, 20L, 30L, 40L).collect(Collectors.toList()));

    }

    static Integer order = 1;

    /**
     * 模拟抽奖
     *
     * @param sources
     * @return
     */
    public static Long rand(List<Long> sources) {
        System.out.println("=========" + order + "=========");
        if (null == sources || sources.isEmpty()) {
            return 99999L;
        }
        Integer size = sources.size();
        Random random = new Random();
        Integer integer = random.nextInt(size);
        Long result = sources.get(integer);
        System.out.println("第" + order + "次中奖编码:" + result);
        sources = sources.stream().filter(val -> {
            if (!val.equals(result)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        System.out.println("未抽中人员编码:");
        sources.forEach(val -> {
            System.out.println(val);
        });
        System.out.println("=========" + order + "=========");
        order = (order + 1);
        rand(sources);
        return result;
    }
}
