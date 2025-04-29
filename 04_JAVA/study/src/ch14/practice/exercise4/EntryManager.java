package ch14.practice.exercise4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EntryManager {
    private Stack<Fan> vipStack = new Stack<>();
    private Queue<Fan> normalQueue = new LinkedList<>();
    private int ticketCount;

    public EntryManager(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public void registerFan(Fan fan) {
        if (fan.getBuyer() instanceof VIPBuyer) {
            vipStack.push(fan);
        } else {
            normalQueue.add(fan);
        }
    }

    public synchronized boolean processEntry(Fan fan) {
        if (ticketCount <= 0) { return false; }

        if (fan.getBuyer() instanceof VIPBuyer) {
            if (!vipStack.isEmpty() && vipStack.peek().equals(fan)) {
                vipStack.pop();
                ticketCount--;
                fan.getBuyer().entranceMessage(fan.getName());
                return true;
            }
        } else {
            if (!normalQueue.isEmpty() && normalQueue.peek().equals(fan)) {
                normalQueue.poll();
                ticketCount--;
                fan.getBuyer().entranceMessage(fan.getName());
                return true;
            }
        }
        return false;
    }
}
