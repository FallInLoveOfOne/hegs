package GQJ.home.hegs.love.cls;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/4
 */
public abstract class Parent /*implements IParent*/ {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private String flag;

    protected String sex = "man";

    public Parent() {
        this.name = "parent";
        this.flag = "parent flag";
        System.out.println("parent-this name:" + this.getName());
    }

    static {
        System.out.println("parent-static");
    }

    //@Override
    public void say() {
        System.out.println("say this name:" + this.getName());
        System.out.println("parent say hello!");
    }
}
