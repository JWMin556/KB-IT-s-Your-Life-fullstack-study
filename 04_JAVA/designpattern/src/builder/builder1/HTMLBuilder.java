package builder.builder1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class HTMLBuilder extends Builder {
    private String filename = "untitled.html";
    private StringBuilder sb = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        filename = title + ".html"; //상대경로이기에 인텔리제이의 루트 디렉토리인 src에 넣어진다.
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        sb.append("<head><title>");
        sb.append(title);
        sb.append("</title></head>\n");
        sb.append("<body>\n");
        sb.append("<h1>");
        sb.append(title);
        sb.append("</h1>\n\n");
    }

    @Override
    public void makeString(String str) {
        sb.append("<p>");
        sb.append(str);
        sb.append("<p>\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        sb.append("<ul>\n");
        for (String s : items) {
            sb.append("<li>");
            sb.append(s);
            sb.append("<li>\n");
        }
        sb.append("</ul>\n\n");
    }

    @Override
    public void close() {
        sb.append("</body>");
        sb.append("</html>\n");

        //파일에 텍스트를 기록하기에 FileWriter를 입력한다. 
        try(Writer writer = new FileWriter(filename)) {
            writer.write(sb.toString());  // 1번만 기록 -> 여러 번 하면 IO처리때문에 늦어진다
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHTMLResult() {
        return filename;
    }
}
