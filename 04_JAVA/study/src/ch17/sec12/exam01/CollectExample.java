package ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<Student> totalList = new ArrayList< >();
        totalList.add(new Student("홍길동", "남", 92));
        totalList.add(new Student("김수영", "여", 87));
        totalList.add(new Student("감자바", "남", 95));
        totalList.add(new Student("오해영", "여", 93));

        List<Student> maleArbitaryList = new ArrayList<>();
        for (Student student : totalList) {
            if (student.getSex().equals("남")) {
                maleArbitaryList.add(student);
            }
        }
        //아마 이렇게 남자학생들만 구했을 것이다.

        // 이번에는 스트림을 써서 만들어보자
        List<Student> maleStreamCollectorsList = totalList.stream()
                .filter(s -> s.getSex().equals("남"))
                .collect(Collectors.toList());

        // 이번에는 스트림을 쓰되 java16부터 지원한 방식인 Collectors를 사용하지 않고 해보자
        List<Student> maleList = totalList.stream().filter(s -> s.getSex().equals("남")).toList();

        maleList.stream().forEach(s -> System.out.println(s.getName()));

        maleList.stream()
                .map(Student::getName)
                .forEach(System.out::println);

        // 성적으로 내림차순 정렬 후 상위 2명 -> 이러한 방식을 선언전 프로그래밍이라고 한다.
        List<Student> topList = totalList.stream()
                .sorted((a, b) -> Integer.compare(b.getScore(), a.getScore()))
                .limit(2)
                .toList();

        //학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
        Map<String, Integer> map = totalList.stream()
                .collect(
                        Collectors.toMap(
                                s -> s.getName(),
                                s -> s.getScore()
                        )
                );
        System.out.println(map);
    }
}
