package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;


public class Member {

    private Long id;
    private String username;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //기본 생성자도 생성
    public Member() {
    }

    //생성자 생성
    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
