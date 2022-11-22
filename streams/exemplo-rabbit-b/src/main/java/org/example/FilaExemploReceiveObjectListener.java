package org.example;

import lombok.Data;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;

@EnableBinding(Sink2.class)
public class FilaExemploReceiveObjectListener {

    @StreamListener(Sink2.INPUT)
    public void listen(UsuarioInput object){
        System.out.println("Escutando um object = " + object);
        if (object.getName() == null) {
            throw new IllegalArgumentException("Name é obrigatório");
        }
    }

}

@Data
class UsuarioInput{
    private Integer id;
    private String name;
    private Double salary;
}

interface Sink2{
    String INPUT = "fila-exemplo-object-input";

    @Input(INPUT)
    MessageChannel input();
}