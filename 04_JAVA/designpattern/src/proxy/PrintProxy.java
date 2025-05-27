package proxy;

public class PrintProxy implements Printable {
    private String name ;
    // 이름
    private Printer real;
    public PrintProxy() {
        this.name = "No Name";
        this.real = null;
    }

    // 실체
    public PrintProxy(String name) {
        this.name = name;
        this.real = null;
    }
    @Override
    public void setPrinterName(String name) {
        if(real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);  // 실제 작업
    }

    private void realize() {
        if(real == null) {
            real = new Printer(name);  // 여기서 약 5초 지연 발생
        }
    }
}
