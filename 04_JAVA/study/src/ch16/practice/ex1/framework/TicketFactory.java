package ch16.practice.ex1.framework;

public abstract class TicketFactory {
    protected abstract ch16.practice.ex1.framework.Ticket createTicket(String owner);
    protected abstract void registerTicket(ch16.practice.ex1.framework.Ticket ticket);

    public final ch16.practice.ex1.framework.Ticket create(String owner) {
        ch16.practice.ex1.framework.Ticket ticket = createTicket(owner);
        registerTicket(ticket);
        return ticket;
    }
}
