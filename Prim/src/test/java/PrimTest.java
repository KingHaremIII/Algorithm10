import org.junit.Test;

/**
 * @Classname PrimTest
 * @Description Prim Test
 * @Date 2020/2/7 上午10:57
 * @Created by kamisama
 */
public class PrimTest {
    @Test
    public void Test() {
        int[][] am = {
                {Integer.MAX_VALUE, 5, 7, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2},
                {5, Integer.MAX_VALUE, Integer.MAX_VALUE, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, 3},
                {7, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 4},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 5, Integer.MAX_VALUE, 6},
                {2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 6, Integer.MAX_VALUE},
        };
        Prim prim = new Prim(7);
        prim.setAdjacencyMatrix(am);
        prim.generateMST();
        int[][] re = prim.getMST();
        for (int i=0;i<re.length;i++) {
            for (int j = 0; j < re.length; j++) {
                System.out.printf("%4d", re[i][j]);
            }
            System.out.println();
        }
    }
}
