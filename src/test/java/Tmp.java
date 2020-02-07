import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Tmp
 * @Description arbitrary test
 * @Date 2020/2/4 下午2:04
 * @Created by kamisama
 */
public class Tmp {
    @Test
    public void Test() {
        int[][] tmp = new int[2][2];
        full(tmp);
        for (int i=0;i<2;i++)
            for (int j=0;j<2;j++)
                System.out.println(tmp[i][j]);
    }

    private void full(int[][] matrix) {
        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix.length;j++)
                matrix[i][j] = Integer.MAX_VALUE;
    }
}
