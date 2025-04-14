package ch05.sec04;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        int[] intArray = null;
//        intArray[0] = 10; // null값을 사용하면 NullPointerException

        String str = null;
//        System.out.println("총문자수: " + str.length() );//NullPointerException
    }
}
