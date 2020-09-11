package GQJ.home.hegs.love.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/10
 */
public class Coll {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"a", "b", "c", "d"});
        list.add("e");
        list.get(0);
        Set<Integer> set = Stream.of(new Integer[]{1,2,4}).collect(Collectors.toSet());
        set.add(5);

    }
}
