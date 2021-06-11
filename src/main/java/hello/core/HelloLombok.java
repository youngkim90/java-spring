package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//롬복 라이브러리 활용
@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private String age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdf");
        
        String name = helloLombok.getName();
        System.out.println("name = " + name);
        System.out.println("helloLombok = " + helloLombok);
    }
}
