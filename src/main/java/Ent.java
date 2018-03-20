import java.util.List;

public class Ent {
    String name;
    List<String> ents;

    public Ent(String name, List<String> ents) {
        this.name = name;
        this.ents = ents;
    }

    public Ent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEnts() {
        return ents;
    }

    public void setEnts(List<String> ents) {
        this.ents = ents;
    }

    @Override
    public String toString() {
        return "Ent{" +
                "name='" + name + '\'' +
                ", ents=" + ents +
                '}';
    }
}
