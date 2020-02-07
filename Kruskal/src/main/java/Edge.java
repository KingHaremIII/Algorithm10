
/**
 * @Classname Edge
 * @Description Edge class containing vertexes and the weight of the path.
 * @Date 2020/2/7 下午12:42
 * @Created by kamisama
 */
public class Edge implements Comparable<Edge> {
    private int x;
    private int y;
    private int weight;

    public Edge(int a, int b, int length) {
        x = a;
        y = b;
        weight = length;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "x=" + x +
                ", y=" + y +
                ", weight=" + weight +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
