package ch14.practice.exercise2;

public  class FestivalTicketEvent extends AbstractTicketEvent {
    public FestivalTicketEvent(int ticketCount) {
        super(ticketCount);
    }

    @Override
    protected void fanEntry() {
        Thread[] fans = new Thread[ticketCount];
        for (int i = 0; i < ticketCount; i++) {
            int fanNumber = i + 1;
            fans[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
                }
            });
            fans[i].setName("팬" + fanNumber);
            fans[i].start();
        }

        //모든 팬 스레드가 끝날 때까지 대기
        for (int i = 0; i < ticketCount; i++) {
            try {
                fans[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
