import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname KruskalTest
 * @Description TODO
 * @Date 2020/2/7 下午12:50
 * @Created by kamisama
 */
public class KruskalTest {
    @Test
    public void Test() {
        int num = 4;
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(0, 2, 1));
        edgeList.add(new Edge(0, 1, 2));
        edgeList.add(new Edge(1, 3, 4));
        edgeList.add(new Edge(2, 3, 7));
        edgeList.add(new Edge(1, 2, 3));

        Kruskal kruskal = new Kruskal(num);
        kruskal.addEdges(edgeList);
        int[][] am = kruskal.Process();

        for (int i=0;i<num;i++) {
            for (int j=0;j<num;j++)
                System.out.printf("%4d", am[i][j]);
            System.out.println();
        }
    }

    @Test
    public void TestEdge() {
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(0, 1, 5));
        edgeList.add(new Edge(2, 3, 7));
        edgeList.add(new Edge(1, 2, 2));
        Collections.sort(edgeList);
        System.out.println(edgeList);

        Forest forest = new Forest(4);
        for (int i=0;i<edgeList.size();i++) {
            forest.addEdge(edgeList.get(i));
            int[] endNodes = forest.getEndNodes();
            for (int j=0;j<endNodes.length;j++)
                System.out.printf("%4d", endNodes[j]);
            System.out.printf("\n\n");
        }

        int[][] m = forest.getAdjacentMatrix();
        for (int i=0;i<4;i++) {
            for (int j = 0; j < 4; j++)
                System.out.printf("%4d", m[i][j]);
            System.out.println();
        }
        System.out.println(forest.MSTCompleted());
    }
}
