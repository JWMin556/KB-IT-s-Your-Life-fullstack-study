package ch15.sec06.exam03.command;

import ch15.sec06.exam03.Message;

public class SendSMSCommand implements Command {
    @Override
    public void execute(Message message) {
        System.out.println(message.to + "님에게 SMS를 보냅니다.");
    }
}
