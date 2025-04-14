package ch05.sec03;

public class ReferenceVariableCompareExample {
    public static void main(String[] args) {
        int[] arr1;
        int[] arr2;
        int[] arr3;

        arr1 = new int[] {1,2,3};
        arr2 = new int[] {1,2,3};
        arr3 = arr2;

        System.out.println(arr1 == arr2); // 둘 다 new로 만들었기에 주소값이 다르다 -> false
        System.out.println(arr2 == arr3); // arr2의 주소값을 arr3에 복사했기에 주소값이 같다 -> true
    }
}
