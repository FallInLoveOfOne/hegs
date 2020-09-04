package GQJ.home.hegs.love.generic;

/**
 * @Author: sh
 * @Description: 泛型通配符？
 * @Version:
 * @Date: 2020/9/4
 */
public class TPF {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);
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
