package strategy.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestFilter {
    public static void main(String[] args) {
        /*
        * 1번
        FilterStrategy f1 = new SmoothSkinFilter();
        System.out.println(f1.apply("My Face"));

        FilterStrategy f2 = new CuteEyesFilter();
        System.out.println(f2.apply("Beautiful"));

        FilterStrategy f3 = new KawaiiFilter();
        System.out.println(f3.apply("Lovely"));
        * */
        Map<String, FilterStrategy> filters = new HashMap<>();
        System.out.println("\uD83D\uDCF8 AI 필터 엔진에 오신 걸 환영합니다!\n✨ 사용할 필터를 선택해주세요 (smooth, cute, kawaii, exit)");

        String filterName = "";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n>> 적용할 필터 입력: ");
            filterName = scanner.nextLine();
            if (filterName.equalsIgnoreCase("exit")) {
                System.out.println("\uD83D\uDCF8 필터 부스를 종료합니다. 안녕히 가세요!");
                break;
            }

            if (filterName.equalsIgnoreCase("smooth")) {
                FilterStrategy f1 = new SmoothSkinFilter();
                System.out.print(">> 사진 입력: ");
                String inputValue = scanner.nextLine();
                System.out.println("[사용 필터: " + filterName + "] => " + f1.apply(inputValue));
                filters.put(filterName, f1);
            } else if (filterName.equalsIgnoreCase("cute")) {
                FilterStrategy f2 = new CuteEyesFilter();
                System.out.print(">> 사진 입력: ");
                String inputValue = scanner.nextLine();
                System.out.println("[사용 필터: " + filterName + "] => " + f2.apply(inputValue));
                filters.put(filterName, f2);
            } else if (filterName.equalsIgnoreCase("kawaii")) {
                FilterStrategy f3 = new KawaiiFilter();
                System.out.print(">> 사진 입력: ");
                String inputValue = scanner.nextLine();
                System.out.println("[사용 필터: " + filterName + "] => " + f3.apply(inputValue));
                filters.put(filterName, f3);
            }
            else {
                System.out.println("⚠\uFE0F 존재하지 않는 필터입니다. 다시 입력해주세요.");
            }
        }
    }
}
