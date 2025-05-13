package builder.builder1;

public class Main {
    // 사용 방법을 표시
    public static void usage() {
        System.out.println("Usage: java Main text 텍스트 문서 작성");
        System.out.println("Usage: java Main html HTML 파일로 문서 작성");
    }

    public static void main(String[] args) {
        // args로 무엇이 넘어오는지에 따라 다르다.

        if (args.length != 1) { //그냥 Main실행시 여기로 감
            usage();
            System.exit(0);
        }
        
        // 실행 구성을 편집해야 함

        if (args[0].equals("text")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getTextResult();
            System.out.println(result);
        } else if (args[0].equals("html")) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String fileName = htmlBuilder.getHTMLResult();
            System.out.println("HTML파일" + fileName + "이 작성되었습니다.");
        } else {
            usage();
            System.exit(0);
        }
    }
}
