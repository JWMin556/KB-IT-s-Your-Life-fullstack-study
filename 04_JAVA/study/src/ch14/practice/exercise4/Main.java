package ch14.practice.exercise4;

public class Main {
    public static void main(String[] args) {
        System.out.println("이벤트 시작! 남은 티켓: 5장");

        EntryManager manager = new EntryManager(5);

        Thread fan1 = new Thread(new Fan("팬1", new RegularBuyer(), manager));
        Thread fan2 = new Thread(new Fan("팬2", new VIPBuyer(), manager));
        Thread fan3 = new Thread(new Fan("팬3", new RegularBuyer(), manager));
        Thread fan4 = new Thread(new Fan("팬4", new VIPBuyer(), manager));
        Thread fan5 = new Thread(new Fan("팬5", new SlowBuyer(), manager));

        fan1.start();
        fan2.start();
        fan3.start();
        fan4.start();
        fan5.start();

        try {
            fan1.join();
            fan2.join();
            fan3.join();
            fan4.join();
            fan5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("이벤트 종료! 모두 수고하셨습니다 🎉");
    }
}
