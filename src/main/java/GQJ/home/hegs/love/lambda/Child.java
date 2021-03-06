package GQJ.home.hegs.love.lambda;

/**
 * @Author: sh
 * @Description: 三定律 如果对默认方法的工作原理，特别是在多重继承下的行为还没有把握，如下三条简单的定
 * 律可以帮助大家。
 * 1. 类胜于接口。如果在继承链中有方法体或抽象的方法声明，那么就可以忽略接口中定义
 * 的方法。
 * 2. 子类胜于父类。如果一个接口继承了另一个接口，且两个接口都定义了一个默认方法，
 * 那么子类中定义的方法胜出。
 * 3. 没有规则三。如果上面两条规则不适用，子类要么需要实现该方法，要么将该方法声明
 * 为抽象方法。
 * 其中第一条规则是为了让代码向后兼容
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
        ICh.staticMe();
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

    static void staticMe(){
        System.out.println("ICh staticMe()----");
    }

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