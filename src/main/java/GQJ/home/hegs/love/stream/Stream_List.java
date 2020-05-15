package GQJ.home.hegs.love.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @PACKAGE_NAME: GQJ.home.hegs.love.stream
 * @NAME: Stream_
 * @USER: SS
 * @DATE: 2020/5/13
 * @PROJECT_NAME: hegs
 **/
public class Stream_List {

    public static void main(String[] args) {

        List<ObVO> source = new ArrayList<>();
        source.add(new ObVO("1", "1-1",1));
        source.add(new ObVO("2", "2-2",2));
        source.add(new ObVO("3", "3-3",3));
        source.add(new ObVO("4", "4-4",4));

        updateListObj(source);// 更新list中某个元素属性

        filterList(source);

        sortList(source);
    }

    public static void forEachList(List<ObVO> source) {
        source.forEach(bean -> System.out.println(bean.getName()));
    }

    public static List<ObVO> updateListObj(List<ObVO> source) {
        System.out.println("===================改变元素=====================");
        source.parallelStream().filter(bean -> {
            if ("1".equals(bean.getId())) {
                bean.setName("1-update");
            }
            return true;
        }).collect(Collectors.toList());

        forEachList(source);

        System.out.println("===================改变元素=====================");
        return source;
    }

    public static List<ObVO> filterList(List<ObVO> source) {
        System.out.println("===================过滤元素=====================");
        source = source.stream().filter(bean -> "1".equals(bean.getId())).collect(Collectors.toList());
        forEachList(source);
        System.out.println("===================过滤元素=====================");
        return source;
    }

    public static List<ObVO> sortList(List<ObVO> source){
        Collections.sort(source);
        forEachList(source);
        Collections.sort(source, new Comparator<ObVO>() {
            @Override
            public int compare(ObVO o1, ObVO o2) {
                // 与重写对象方法相反
                int n = 1;
                System.out.println("排序标记值："+n);
                return n;
            }
        });
        forEachList(source);
        System.out.println("===================排序=====================");
        // 排序无效！
        source = source.stream().sorted(Comparator.comparing(ObVO::getYearOld)).collect(Collectors.toList());
        forEachList(source);
        System.out.println("===================排序=====================");
        return source;
    }
}
