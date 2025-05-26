package MultiCampus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] arbitary = new int[progresses.length];
        for (int i = 0; i < arbitary.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                arbitary[i] = (100 - progresses[i]) / speeds[i];
            } else {
                arbitary[i] = ((100 - progresses[i]) / speeds[i]) + 1;
            }
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < arbitary.length) {
            int count = 1;
            int j = i+1;
            while (j < arbitary.length) {
                if (arbitary[i] >= arbitary[j]) {
                    count++;
                    j++;

                    if (j == arbitary.length) {
                        i = j - 1;
                        break;
                    }
                } else {
                    i = j - 1;
                    break;
                }
            }
            i++;
            list.add(count);
        }
        answer = list.stream().mapToInt(x -> x).toArray();
        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = { 1,30,5};
//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = { 1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
}
