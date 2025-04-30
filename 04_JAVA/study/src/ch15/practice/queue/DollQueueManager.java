package ch15.practice.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DollQueueManager {
    private Queue<String> queue = new LinkedList<>();

    public void registerCustomer(String name) {
        queue.add(name);
        System.out.println("\uD83D\uDC49 " + name + "님이 대기열에 등록되었습니다.");
    }

    public void processNextCustomer() {
        String customerName = queue.poll();
        System.out.println("\uD83C\uDF89 " + customerName + "님! 인형 뽑기 하러 오세요!");
    }

    public void showWaitingList() {
        ArrayList<String> list = new ArrayList<>(queue);
        System.out.println("\uD83E\uDDFE 현재 대기열: " + list);
    }

    public String getNextCustomer() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }
}
