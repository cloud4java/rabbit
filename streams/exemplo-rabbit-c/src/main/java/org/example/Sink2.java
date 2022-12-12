package org.example;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface Sink2 {
    String INPUT = "simple-queue-with-dlq";

    @Input(INPUT)
    MessageChannel input();
}
