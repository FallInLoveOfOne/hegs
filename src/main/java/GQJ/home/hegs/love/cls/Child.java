package GQJ.home.hegs.love.cls;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/4
 */
public class Child extends Parent {
    //@Override
    //public String getName() {
    //    return name;
    //}

    //@Override
    //public void setName(String name) {
    //    this.name = name;
    //}
    //
    //public String name;

    public Child() {
        //super();
        //this.name = "child";
        System.out.println("child-this name:" + this.getName());
    }

    static {
        System.out.println("child-static");
    }

    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.getName());// child
        System.out.println(child.getFlag());// parent flag
        //System.out.println(child.flag);// 无法访问parent-private flag属性
        child.say();// parent say hello!

    }
}
