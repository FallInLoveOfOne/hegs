package GQJ.home.hegs.love.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        // --------------元数据
        List<ObVO> list = new ArrayList();
        list.add(new ObVO("1","1-"));
        list.add(new ObVO("2","2-"));
        list.add(new ObVO("3","3-"));
        list.add(new ObVO("4","4-"));

        // --------------替换元素属性
        list.stream().filter(bean->{
            // id为1元素name变为1-1
            if("1".equals(bean.getId())){
                bean.setName("1-1");
            }
            return true;
        }).collect(Collectors.toList());
        // END

        // --------------遍历元素
        list.forEach(bean->{
            System.out.println(bean.getName());
        });
        // END
    }
}
