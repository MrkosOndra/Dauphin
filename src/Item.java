public class Item {
    private String name;
    private boolean have;

    public Item(String name) {
        this.name = name;
        this.have = false;
    }

    public String getName() {
        return name;
    }

    public boolean isHave() {
        return have;
    }

    public void setHave(boolean have) {
        this.have = have;
    }
}
