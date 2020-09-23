package GQJ.home.hegs.love.lambda;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/23
 */
public class Child extends Parent implements IChild, ICh {

    /**
     * 实现不同接口，有相同的方法，必须实现
     */
    @Override
    public void same() {
        ICh.super.same();
    }

    @Override
    public void say() {
        /**
         * 类胜于接口，目的向后兼容
         * 假设已实现了一个定制的列表 MyCustomList ，该类中有一个 addAll 方法，如果新的 List
         * 类库 ｜ 45
         * 接口也增加了一个默认方法 addAll ，该方法将对列表的操作代理到 add 方法。如果类中重
         * 写的方法没有默认方法的优先级高，那么就会破坏已有的实现。
         */
        super.say();
    }

    public static void main(String[] args) {
        new Child().print().say();
        new Child().same();
        // result
        //GQJ.home.hegs.love.lambda.Child:print()
        //Parent say()GQJ.home.hegs.love.lambda.Child
    }
}

interface IChild {
    /**
     * say
     */
    default void say() {
        System.out.println("IChild say()" + this.getClass().getName());
    }

    /**
     * print
     *
     * @return
     */
    default IChild print() {
        System.out.println(this.getClass().getName() + ":print()");
        return this;
    }

    /**
     * same
     */
    default void same() {
        System.out.println("IChild same()" + this.getClass().getName());
    }
}

interface ICh {

    /**
     * same
     */
    default void same() {
        System.out.println("ICh same()" + this.getClass().getName());
    }
}

class Parent {
    void say() {
        System.out.println("Parent say()" + this.getClass().getName());
    }
}