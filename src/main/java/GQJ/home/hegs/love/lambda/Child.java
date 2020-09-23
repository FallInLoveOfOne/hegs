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
        // 类胜于接口，目的向后兼容
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