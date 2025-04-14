package ch05.practice;

public class SecondPractice {
    public static void main(String[] args) {
        int[] array = {1,5,3,8,2};
        int max = array[0];
        for (int x = 0; x < array.length; x++) {
            if (array[x] > max) {
                max = array[x];
            }
        }
        System.out.println(max);
    }
}
