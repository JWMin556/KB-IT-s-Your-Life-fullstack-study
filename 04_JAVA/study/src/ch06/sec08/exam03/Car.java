package ch06.sec08.exam03;

public class Car {
    int gas;

    // 가스값 받아와서 설정해주는 메소드
    void setGas(int gas) {
        this.gas = gas;
    }

    //리턴값이 boolean인 메소드로 gas 필드값이 0이면 false를, 0이 아니면 true를 리턴
    // gas가 남아있는지 bool값으로 리턴해주는 메소드
    boolean isLeftGas() {
        if (gas == 0) {
            System.out.println("gas가 없습니다.");
            return false;
        }
        // gas가 0인 경우, 위쪽에서 리턴되기 때문에 else문 불필요
        System.out.println("gas가 있습니다.");
        return true;
    }

    //리턴값이 없는 메소드로 gas 필드값이 0이면 return 문으로 메소드를 종료
    void run() {
        while (true) {
            if (gas > 0) {
                System.out.println("달립니다.(gas잔량:" + gas + ")");
                gas -= 1;
            } else {
                System.out.println("멈춥니다.(gas잔량:" + gas + ")");
                return; //메소드 종료
            }
        }
    }
}
