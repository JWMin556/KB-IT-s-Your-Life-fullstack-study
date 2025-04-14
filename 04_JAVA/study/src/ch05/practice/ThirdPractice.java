package ch05.practice;

public class ThirdPractice {
    public static void main(String[] args) {
        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        int count = array[0].length + array[1].length + array[2].length;
        double avg = (double) sum / count;
        System.out.println("합: " + sum);
        System.out.printf("평균: %.1f", avg);
    }
}
