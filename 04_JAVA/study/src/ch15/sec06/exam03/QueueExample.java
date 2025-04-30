package ch15.sec06.exam03;

import ch15.sec06.exam03.command.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Map<String, Command> commands = new LinkedHashMap<>();
        commands.put("sendMail", new SendMailCommand());
        commands.put("sendSMS", new SendSMSCommand());
        commands.put("sendKakaotalk", new SendKakaotalkCommand());

        Queue<Message> messageQueue = new LinkedList<>();
        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "감자바"));

        while(!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();  // poll메서드: 도착한 순서대로 뽑는다.

            Command command = commands.get(message.command);
            if(command != null) {
                command.execute(message);
            }
        }
    }
}
