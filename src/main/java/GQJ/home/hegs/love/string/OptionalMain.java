package GQJ.home.hegs.love.string;

import java.util.Optional;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/23
 */
public class OptionalMain {
    public static void main(String[] args) {
        String val = null;
        //val = "heme";
        Optional<String> optional = Optional.ofNullable(val);
        System.out.println(optional.orElse("wo"));
        User user = null;
        user = new User("Jim", "man", 88);
        Optional<User> userOptional = Optional.ofNullable(user);
        System.out.println(userOptional.orElse(new User()).getSex());
    }

    public static class User {

        public User() {
        }

        public User(String name, String sex, Integer yearOld) {
            this.name = name;
            this.sex = sex;
            this.yearOld = yearOld;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Integer getYearOld() {
            return yearOld;
        }

        public void setYearOld(Integer yearOld) {
            this.yearOld = yearOld;
        }

        String name;
        String sex;
        Integer yearOld;
    }
}
