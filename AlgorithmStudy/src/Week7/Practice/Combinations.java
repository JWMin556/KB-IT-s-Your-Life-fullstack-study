package Week7.Practice;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void backstrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result){
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // start는 다음 재귀 호출에서 숫자를 선택할 시작 지점을 의미한다
        // start를 이용해야만, [1,2]와 [2,1]같은 녀석들이 나오는 것을 방지할 수 있다.
        for (int i = start; i <= n; i++) {
            current.add(i);
            backstrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backstrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>(combine(4, 2));
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
