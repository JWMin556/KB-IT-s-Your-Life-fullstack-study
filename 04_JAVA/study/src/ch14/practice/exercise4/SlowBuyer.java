package ch14.practice.exercise4;

public class SlowBuyer implements TicketBuyer {
    @Override
    public void waitTurn() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void entranceMessage(String name) {
        System.out.println(name + ": 처음이라 떨려요... 입장 완료!");
    }
}
