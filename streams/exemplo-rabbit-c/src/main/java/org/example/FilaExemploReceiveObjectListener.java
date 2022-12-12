package org.example;

import lombok.Data;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;

import java.util.Map;

@EnableBinding(Sink2.class)
public class FilaExemploReceiveObjectListener {

    @StreamListener(Sink2.INPUT)
    public void listen(UsuarioInput object, @Header(name = "x-death", required = false)Map<?,?> death){
        System.out.println("Escutando um object = " + object);

        if (object.getName() == null) {
            //TODO: Postar na fila intemediária, por 3 vezes
            throw new IllegalArgumentException("Name é obrigatório");
        }
    }

}

