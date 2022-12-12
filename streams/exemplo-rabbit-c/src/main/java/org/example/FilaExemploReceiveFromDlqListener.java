package org.example;

import org.springframework.amqp.ImmediateAcknowledgeAmqpException;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;

import java.util.Map;

@EnableBinding(DlqSink.class)
public class FilaExemploReceiveFromDlqListener {

    @StreamListener(target = "simple-queue-with-dlq.dlq")
    public void listen(UsuarioInput object, @Header(name = "x-death", required = false) Map<?, ?> death) {
        System.out.println("Lendo da DLQ = " + object);
        if (death != null && death.get("count").equals(3L)) {
            throw new ImmediateAcknowledgeAmqpException("Desistindo");
        }

    }
}
interface DlqSink {
    String INPUT = "simple-queue-with-dlq.dlq";

    @Input(INPUT)
    MessageChannel input();
}
