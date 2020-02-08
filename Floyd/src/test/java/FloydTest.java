import org.junit.Test;

/**
 * @Classname FloydTest
 * @Description TODO
 * @Date 2020/2/8 上午10:55
 * @Created by kamisama
 */
public class FloydTest {
    @Test
    public void Test() {
        int[][] am = {
                {0, 2, 6, 4},
                {Integer.MAX_VALUE/2, 0, 3, Integer.MAX_VALUE/2},
                {7, Integer.MAX_VALUE/2, 0, 1},
                {5, Integer.MAX_VALUE/2, 12, 0},
        };
        Floyd floyd = new Floyd(am);

        System.out.println("==============Before===============");
        int[][] re = floyd.getAdjacencyMatrix();
        for (int i=0;i<am.length;i++) {
            for (int j = 0; j < am.length; j++)
                System.out.printf("%12d", re[i][j]);
            System.out.println();
        }

        floyd.Process();
        System.out.println("==============After===============");
        re = floyd.getAdjacencyMatrix();
        for (int i=0;i<am.length;i++) {
            for (int j = 0; j < am.length; j++)
                System.out.printf("%12d", re[i][j]);
            System.out.println();
        }

    }
}
