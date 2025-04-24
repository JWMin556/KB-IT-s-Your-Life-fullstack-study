package ch14.sec04;

public class ThreadNameExample {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName() + " 실행");
        
        // 작업 스레드를 3개 만들고 실행
        for(int i=0; i<3; i++) {
            Thread threadA = new Thread() {
                @Override
                public void run() {
                    System.out.println(getName() + " 실행"); // 자동 할당된 스레드 이름 리턴
                }
            };
            threadA.start();
        }

        Thread chatThread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " 실행"); // 스레드이름리턴
            }
        };
        chatThread.setName("chat-thread"); // 작업스레드이름변경
        chatThread.start();

        // 총 5개의 스레드가 실행된다.
    }
}
