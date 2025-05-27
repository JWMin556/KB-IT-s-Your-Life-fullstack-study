package composite.practice;

import java.util.ArrayList;
import java.util.List;

public class Band extends BandComponent {
    private String name;
    private List<BandComponent> members;

    public Band(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void add(BandComponent component) {
        members.add(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printStructure(String prefix) {
        System.out.println(prefix + "🎤 Band - " + name);
        for (BandComponent component : members) {
            component.printStructure(prefix + "  ");
        }
    }

    @Override
    public void perform() {
        for (BandComponent member : members) {
            member.perform();
        }
    }
}
