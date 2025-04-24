package ch14.practice.exercise3;

public class TicketingRound3 {
    public static void main(String[] args) throws InterruptedException {
        int totalTickets = 5;
        EntryManager entryManager = new EntryManager(totalTickets);

        Fan[] fans = {
                new Fan("팬1", false, entryManager),
                new Fan("팬2", true, entryManager),
                new Fan("팬3", false, entryManager),
                new Fan("팬4", true, entryManager),
                new Fan("팬5", false, entryManager)
        };
        System.out.println("이벤트 시작! 남은 티켓: " + totalTickets + "장");
        Thread[] threads = new Thread[fans.length];
        for (int i = 0; i < fans.length; i++) {
            threads[i] = new Thread(fans[i]);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join(); // 모든 팬 입장 완료까지 대기
        }

        System.out.println("이벤트 종료! 모두 수고하셨습니다 🎉");
    }
}
