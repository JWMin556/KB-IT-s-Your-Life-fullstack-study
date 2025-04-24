package ch14.practice.exercise3;

public class Fan implements Runnable {
    private String name;
    private boolean isVIP;
    private EntryManager entryManager;

    public Fan(String name, boolean isVIP, EntryManager entryManager) {
        this.name = name;
        this.isVIP = isVIP;
        this.entryManager = entryManager;
    }

    public String getName() {
        return name;
    }

    public boolean isVIP() {
        return isVIP;
    }

    @Override
    public void run() {
        entryManager.registerFan(this);
        while (!entryManager.processEntry(this)) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
