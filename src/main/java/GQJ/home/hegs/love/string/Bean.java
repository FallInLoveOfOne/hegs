package GQJ.home.hegs.love.string;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/10
 */
public class Bean {
    static Logger logger = Logger.getGlobal();

    public static void main(String[] args) throws Exception {
        // 获取bean的属性名及方法
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        Arrays.asList(info.getPropertyDescriptors()).forEach(bean -> {
            logger.info(bean.getName());
            logger.info("readMethod:" + bean.getReadMethod());
            logger.info("writeMethod:" + bean.getWriteMethod());
        });
        // 记录类
        Point point = new Point(1,2);
    }

    public static class Person {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        private String name;
        private Integer age;
    }

    public static final class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() {
            return this.x;
        }

        public int y() {
            return this.y;
        }
    }
}
