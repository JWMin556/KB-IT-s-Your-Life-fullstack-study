package ch14.practice.exercise4;

public class Fan implements Runnable {
    private String name;
    private TicketBuyer buyer;
    private EntryManager entryManager;

    public Fan(String name, TicketBuyer buyer, EntryManager entryManager) {
        this.name = name;
        this.buyer = buyer;
        this.entryManager = entryManager;
    }

    public String getName() {
        return name;
    }

    public TicketBuyer getBuyer() {
        return buyer;
    }

    @Override
    public void run() {
        entryManager.registerFan(this);
        while (!entryManager.processEntry(this)) {
            buyer.waitTurn();  // 등급에 따라 다르게
        }
    }
}
