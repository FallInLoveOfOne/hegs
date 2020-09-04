package GQJ.home.hegs.love.cls;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/4
 */
public class Child extends Parent implements IParent {// 虽然Parent已经实现了IParent，但是Child依然可以实现IParent
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

    public static final String F_V = "fv";

    public Child() {
        //super();
        //this.name = "child";
        System.out.println("child-this name:" + this.getName());
    }

    public Child(String name) {
        this.name = name;
        System.out.println("有参构造public Child(String name)");
    }

    static {
        System.out.println("child-static");
    }

    //@Override
    //public void say() {
    //    System.out.println("child say hello!");
    //}

    public static void main(String[] args) {
        Child child = new Child();
        // 子类可以继承父类的public、protected的方法及属性，但是private的不能继承
        // child
        System.out.println(child.getName());
        // parent flag
        System.out.println(child.getFlag());
        // man
        System.out.println(child.sex);
        // 无法访问parent-private flag属性
        // System.out.println(child.flag);
        // Parent没有实现接口，但是Child实现了接口，对于接口方法say，相当于Parent代替Child实现了IParent的say方法
        // 事实证明this指向的是当前类的当前对象parent
        // parent say hello!
        child.say();
        System.out.println(Child.I_PARENT_P);
        System.out.println("======================// 反射 ST=================");
        System.out.println(child.getClass().getClassLoader());
        System.out.println(Child.class.toGenericString());
        System.out.println(Child.class.getCanonicalName());
        try {
            Class<?>[] ins = Child.class.getInterfaces();
            for (Class in : ins) {
                System.out.println("Child实现的接口:" + in.getName());
                Field inFild = in.getDeclaredField("I_PARENT_P");
                System.out.println("通过Field获取接口的属性值:" + inFild.get(in));
                // 未接口常量赋值不可
                //inFild.setAccessible(true);
                //inFild.set(null, "卧槽");
            }
            System.out.println(Child.I_PARENT_P);
            // newInstance()无参数构函数创建对象
            Object ob = child.getClass().newInstance();
            Child fsChild = (Child) ob;
            System.out.println("fsChild-name:" + fsChild.getName());
            Class cf = Class.forName("GQJ.home.hegs.love.cls.Child");
            Child c = (Child) cf.newInstance();
            System.out.println("c-flag:" + c.getFlag());
            Constructor cons = Child.class.getDeclaredConstructor(String.class);
            Child childCons = (Child) cons.newInstance("hava one arg");
            System.out.println("childCons-name:" + childCons.getName());
            // 父类的属性、方法此方式没能获取,需要通过父类clss反射获取
            //Field nameField = childCons.getClass().getDeclaredField("name");
            //nameField.set(childCons, "通过Filed赋值");
            //System.out.println("childCons-name:" + childCons.getName());
            //Method nameMethod = Child.class.getDeclaredMethod("setFlag", String.class);
            //nameMethod.invoke(childCons, "通过Method赋值");
            //System.out.println("childCons-flag:" + childCons.getFlag());
            Field fField = Child.class.getDeclaredField("F_V");
            System.out.println("F_V属性修饰符:" + Modifier.toString(fField.getModifiers()));
            //fField.setAccessible(true);
            //fField.set(null,"静态常量赋值");
            //System.out.println(Child.F_V);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("======================// 反射 END=================");
    }
}
