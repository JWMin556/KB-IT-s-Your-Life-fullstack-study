package ch14.sec04;

public class ThreadNameExample {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName() + " 실행");
        for(int i=0; i<3; i++) {
            Thread threadA = new Thread() {
                @Override
                public void run() {
                    System.out.println(getName() + " 실행"); // 스레드 이름 리턴
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
    }
}
