//package org.example;
//
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.Input;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.messaging.MessageChannel;
//
//@EnableBinding(Sink1.class)
//public class FilaExemploListener {
//    @StreamListener(Sink1.INPUT)
//    public void listen(){
//        System.out.println("Listener Executado = " + Sink1.INPUT);
//    }
//}
//
//interface Sink1{
//    String INPUT = "fila-exemplo-input";
//
//    @Input(INPUT)
//    MessageChannel input();
//}