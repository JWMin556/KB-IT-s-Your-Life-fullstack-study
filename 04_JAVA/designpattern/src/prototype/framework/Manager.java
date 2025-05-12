package prototype.framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product prototype) {
        showcase.put(name, prototype);
    }

    public Product create(String prototypeName) {  //key를 파라미터로 넣어서
        Product p = showcase.get(prototypeName);  // 맵에서 key로 꺼내서
        return p.createCopy(); //p의 createCopy를 통해 새로운 인스턴스를 리턴한다.
    }
}
