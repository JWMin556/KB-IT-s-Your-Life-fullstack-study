package ch16.practice.ex1.metamong;

import ch16.practice.ex1.framework.Ticket;
import ch16.practice.ex1.framework.TicketFactory;

public class MetaMonTicketFactory extends TicketFactory {
    @Override
    protected Ticket createTicket(String owner) {
        return new ch16.practice.ex1.metamong.MetaMonTicket(owner);
    }

    @Override
    protected void registerTicket(ch16.practice.ex1.framework.Ticket ticket) {
        System.out.println("티켓" + ticket + "등록 완료");
    }
}
