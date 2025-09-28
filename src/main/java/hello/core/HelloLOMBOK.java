package hello.core;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class HelloLOMBOK {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLOMBOK helloLOMBOK = new HelloLOMBOK();
        helloLOMBOK.setName("hello");
        String name = helloLOMBOK.getName();
        System.out.println("name = " + name);


    }
}
