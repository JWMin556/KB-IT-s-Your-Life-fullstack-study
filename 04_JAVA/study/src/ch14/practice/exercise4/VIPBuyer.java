package ch14.practice.exercise4;

public class VIPBuyer implements TicketBuyer {
    @Override
    public void waitTurn() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void entranceMessage(String name) {
        System.out.println("VIP " + name + " 입장 완료!");
    }
}
