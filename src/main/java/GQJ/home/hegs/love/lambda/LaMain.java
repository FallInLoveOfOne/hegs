package GQJ.home.hegs.love.lambda;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/21
 */
public class LaMain {

    public static void main(String[] args) {
        ActionListener actionListener = (e -> {
            System.out.println();
        });

        BooInterface<Integer, Integer> bl = (x, y) -> {
            return (x > y);
        };
        System.out.println(bl.isBig(10, 11));
        System.out.println(print(bl, 100, 99));

        List<String> collect = Stream.of("a", "c", "d").map(String::toLowerCase).collect(Collectors.toList());
        collect.forEach(System.out::println);
        collect = Stream.of("a", "c", "d").map(val -> val.toUpperCase()).collect(Collectors.toList());
        collect.forEach(System.out::println);

        List<Integer> nums = Stream.of(1, 2, 9).collect(Collectors.toList());
        System.out.println(nums.stream().max(Comparator.comparing(val -> val.intValue())).get());

        List<Object> joinCollect = Stream.of(new String[]{"dd", "hh"}, new String[]{"11", "22"}).flatMap(val -> Arrays.stream(val)).collect(Collectors.toList());
        joinCollect.forEach(System.out::println);

        List<Integer> sumCollect = Stream.of(1, 2, 3).collect(Collectors.toList());
        Integer sum = sumCollect.stream().reduce(Integer::sum).get();
        System.out.println("求和：" + sum);

    }

    public static <T extends Number, Q extends Number> String print(BooInterface booInterface, T t, Q q) {
        return String.valueOf(booInterface.isBig(t, q));
    }
}
