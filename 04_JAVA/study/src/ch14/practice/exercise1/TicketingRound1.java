package ch14.practice.exercise1;

public class TicketingRound1 {
    public static void main(String[] args) {
        System.out.println("=== run() 직접 호출 테스트 ===");

        // 팬1: Runnable 익명 클래스 생성
        Thread fan1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
            }
        });
        fan1.setName("팬1");

        // 팬2: Runnable 익명 클래스 생성
        Thread fan2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
            }
        });
        fan2.setName("팬2");

        // run() 직접 호출 (멀티스레딩 아님)
        fan1.start(); // 메인 스레드에서 실행
        System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
        fan2.start(); // 메인 스레드에서 실행
    }
}
