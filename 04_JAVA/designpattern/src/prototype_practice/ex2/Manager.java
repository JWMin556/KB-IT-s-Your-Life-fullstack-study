package prototype_practice.ex2;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product prototype) {
        showcase.put(name, prototype);
    }

    public Product create(String prototypeName) {
        Product p = showcase.get(prototypeName);
        if (p == null) {
            return null;
        }
        return p.createCopy();
    }

    public void printRegisteredStyles() {
        System.out.println("[등록된 스타일 목록]");
        for (String key : showcase.keySet()) {
            Product p = showcase.get(key);
            if (p instanceof CardTemplate) {
                System.out.println("- " + key + " : " + ((CardTemplate)p).getTitle());
            }
        }
        System.out.println();
    }

    public boolean isRegistered(String name) {
        return showcase.containsKey(name);
    }
}
