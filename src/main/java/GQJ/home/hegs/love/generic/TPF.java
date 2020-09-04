package GQJ.home.hegs.love.generic;

/**
 * @Author: sh
 * @Description: 泛型通配符？
 * @Version:
 * @Date: 2020/9/4
 */
public class TPF {
    /**
     * 总结：
     * <? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）；
     * <p>
     * <? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。
     * <p>
     * 一个是允许读不允许写，另一个是允许写不允许读
     * <p>
     * <?>通配符有一个独特的特点，就是：Pair<?>是所有Pair<T>的超类
     *
     * @param args
     */
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);
        //<?>通配符有一个独特的特点，就是：Pair<?>是所有Pair<T>的超类
        Pair<?> pa = p;
        System.out.println(pa.first + "--" + pa.last);
        Pair<Long> pl = new Pair<>(100L, 200L);
        pa = pl;
        System.out.println(pa.first + "--" + pa.last);
    }

    /**
     * 只能读p,无法修改p
     * 普通方法，不是泛型方法
     *
     * @param p
     * @return
     */
    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        Number f = new Integer(first.intValue() + 100);
        Number l = new Integer(last.intValue() + 100);
        //编译不通过，通过提示可知,设置需要传入的类型是[capture of ? extends Number]，相当于是未确定的类型
        //Required type:
        //capture of ? extends Number
        //Provided:
        //Number
        //p.setFirst(f);
        //p.setLast(l);
        return p.getFirst().intValue() + p.getFirst().intValue();
    }

    static class Pair<T> {
        private T first;
        private T last;

        public Pair(T first, T last) {
            this.first = first;
            this.last = last;
        }

        public T getFirst() {
            return first;
        }

        public T getLast() {
            return last;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public void setLast(T last) {
            this.last = last;
        }
    }
}
