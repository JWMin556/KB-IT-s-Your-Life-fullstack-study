package ch15.sec03.exam03;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) { // 다음 값이 있는지 hasNext로 확인한다.
            String element = iterator.next();  // next로 다음 값을 가져온다.
            System.out.println( element);
            if(element.equals("JSP")) {
                iterator.remove();  // 가져온 값을 컬렉션에서 제거하는 remove
            }
        }
        System.out.println();

        set.remove("JDBC");  // 이건 set에 있는 remove로 제거
        for(String element : set) {
            System.out.println(element);
        }
    }
}
