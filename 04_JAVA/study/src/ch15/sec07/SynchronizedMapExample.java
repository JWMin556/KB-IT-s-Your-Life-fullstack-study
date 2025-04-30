package ch15.sec07;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());

        Thread threadA = new Thread() {
            @Override
            public void run() {
                //객체 1000개 추가
                for(int i=1; i<=1000; i++) {
                    map.put(i, "내용"+i);
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                //객체 1000개 추가
                for(int i=1001; i<=2000; i++) {
                    map.put(i, "내용"+i);
                }
            }
        };
        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        int size = map.size();
        System.out.println("총객체수: " + size);
        System.out.println();
    }
}
