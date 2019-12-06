public class Planet {
    public Planet parent = null;

    public Planet(Planet parent) {
        this.parent = parent;
    }

    public Planet() {
    }

    public int getOrbits() {
        int i = 0;
        for(Planet p  = this; p.parent != null; p = p.parent) i++;
        return i;
    }
}
