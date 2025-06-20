package Week8.Example;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    static Map<Integer, Integer> map = new HashMap<>();

    public static int climbStairs(int n) {
        if (n <= 2) { return n; }
        if (!map.containsKey(n)) {
            map.put(n, climbStairs(n-1) + climbStairs(n-2));
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
