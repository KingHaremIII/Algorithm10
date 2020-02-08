import org.junit.Test;

/**
 * @Classname DijkstraTest
 * @Description Test Dijkstra
 * @Date 2020/2/8 下午4:02
 * @Created by kamisama
 */
public class DijkstraTest {
    @Test
    public void Test() {
        int[][] am = {
                {Integer.MAX_VALUE/2, 2, 6, 4},
                {Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, 3, Integer.MAX_VALUE/2},
                {7, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, 1},
                {5, Integer.MAX_VALUE/2, 12, Integer.MAX_VALUE/2},
        };

        Dijkstra dijkstra = new Dijkstra(am);
        dijkstra.Process(2);
        int[] re = dijkstra.getPreviousVector();
        for (int i=0;i<re.length;i++) {
            System.out.printf("%12d", re[i]);
        }
        System.out.println();
    }
}
