package ch14.practice.exercise4;

public class RegularBuyer implements TicketBuyer {
    @Override
    public void waitTurn() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void entranceMessage(String name) {
        System.out.println(name + " 입장 완료!");
    }
}
