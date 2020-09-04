package GQJ.home.hegs.love.generic;

/**
 * @Author: sh
 * @Description: 泛型
 * @Version:
 * @Date: 2020/9/4
 */
public class MyGeneric {

    public static void main(String[] args) throws Exception {
        // 静态内部类会被初始化
        MyGeneric myGeneric = new MyGeneric();
        User man = new Man("man");
        User women = new Women("women");
        // 创建非静态内部类对象的方式，
        // 也就是说此类对象的创建是依赖外部类对象的，相当于外部类的一个属性，静态的话相当于外部类的静态属性
        NonStaticClass nonStaticClass = myGeneric.new NonStaticClass();
        NonStaticClass nonStaticClassX = new MyGeneric().new NonStaticClass();
        // 泛型类的使用
        Say say = new Say<Man>();
        say.setT(man).print();
        say.setT(women).print();
        // 泛型方法的使用
        say.genericMethod(man);
        say.genericMethod(women);
        //由于泛型方法限制了参数的的类型，以下无法通过编译
        //say.genericMethod(new Object());
    }

    /**
     * 泛型类
     *
     * @param <T>
     */
    public static class Say<T extends User> {
        private T t;

        // 这只是一个普通的方法，不是泛型泛型方法,此方法只是设置T类型的对象（实例）
        public Say setT(T t) {
            this.t = t;
            return this;
        }

        public void print() {
            t.saySex();
        }

        /**
         * 泛型方法，T与Say<T extends User>中的T不是一个，只是一个参数标识，可用E、F等替代
         * extends定义T的父范围
         *
         * @param t
         * @param <T>
         */
        public <T extends User> void genericMethod(T t) {
            System.out.println(t.getClass().getName());
            t.saySex();
        }
    }

    public interface User {
        /**
         *
         */
        void saySex();
    }

    public static class Man implements User {
        static {
            System.out.println("Man static{}" + Man.class.getName());
        }

        public String sex;

        public Man(String sex) {
            this.sex = sex;
        }

        @Override
        public void saySex() {
            //【静态】内部类无法使用外部非静态属性
            //System.out.println(outFiled);
            MyGeneric myGeneric = new MyGeneric();
            System.out.println(myGeneric.outFiled);
            System.out.println("sex-" + this.sex);
        }


    }

    public static class Women implements User {
        static {
            System.out.println("Women static{}" + Women.class.getName());
        }

        public String sex;

        public Women(String sex) {
            this.sex = sex;
        }

        @Override
        public void saySex() {
            System.out.println(outStaticFiled);
            System.out.println("sex-" + this.sex);
        }
    }

    // 静态内部类可以直接使用
    private static String outStaticFiled = "out_class_private_static_filed";

    //
    private String outFiled = "out_class_private_filed";

    static {
        System.out.println("MyGeneric static{}" + MyGeneric.class.getName());
    }

    /**
     * 非静态内部的一些特点
     */
    public class NonStaticClass {
        // 非静态内部了无法定义静态块，以下无法编译
        //static {}
        // 非静态内部类无法定义静态方法，以下无法编译
        //public static void tt(){}
        // 必须使用final，方可定义static属性
        public final static String X_X = "X_X";

        public NonStaticClass() throws Exception {
            //【非静态】内部类对象依赖外部类对象创建，所以都是可使用的
            System.out.println(outFiled);
            System.out.println(outStaticFiled);
            System.out.println("NonStaticClass 构造");
        }
    }
}
