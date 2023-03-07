package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class HelloData {
    private String Username;
    private int age;

    //@Getter @Setter 를 사용하면 필요가 없다.
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}
