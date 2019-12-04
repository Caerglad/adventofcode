public class CrossPoint implements Comparable<CrossPoint>{
    public int x;
    public int y;
    private int distance;

    public CrossPoint(int x, int y) {
        this.x = x;
        this.y = y;

        int absX = Math.abs(x - (Main.SIZE / 2));
        int absY = Math.abs(y - (Main.SIZE / 2));

        distance = absX + absY;
    }

    public CrossPoint(int cost) {
        distance = cost;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(CrossPoint o) {
        return Integer.compare(o.distance, this.distance) * -1;
    }
}
