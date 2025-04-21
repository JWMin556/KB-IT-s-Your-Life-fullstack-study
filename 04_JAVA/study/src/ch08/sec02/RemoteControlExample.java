package ch08.sec02;

public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc;

        //rc 변수에 Television 객체를 대입
        rc = new Television(); //자식을 부모에게 넣었으니 업캐스팅
        rc.turnOn(); // 자식인 텔레비전의 턴온 호출

        //rc 변수에 Audio 객체를 대입(교체시킴)
        rc = new Audio();
        rc.turnOn();
    }
}
