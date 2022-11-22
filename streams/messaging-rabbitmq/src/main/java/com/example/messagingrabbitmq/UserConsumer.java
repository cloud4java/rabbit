package com.example.messagingrabbitmq;


import jdk.jfr.Enabled;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.EnableMBeanExport;

@EnableBinding(UserSink.class)
public class UserConsumer {

    @StreamListener(UserSink.INPUT)
    public void listen(User user){
        System.out.println("Listem to user = " + user);
    }
}

interface UserSink{
    String INPUT = "user-input";

    void input();
}
class User{
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
