import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname Kruskal
 * @Description Kruskal Algorithm for MST
 * @Date 2020/2/7 下午1:27
 * @Created by kamisama
 */
public class Kruskal {
    int nodeNum;
    Forest forest;
    List<Edge> edgeList;

    public Kruskal(int num) {
        nodeNum = num;
        forest = new Forest(nodeNum);
        edgeList = new ArrayList<>();
    }

    public void addEdges(List<Edge> edges) {
        for (Edge edge : edges)
            edgeList.add(edge);
        Collections.sort(edgeList);
    }

    public int[][] Process() {
        while(!forest.MSTCompleted()) {
            int i=0;
            for (;i<edgeList.size();i++) {

                System.out.println(i+"th judge =" + judge(edgeList.get(i)));

                if (judge(edgeList.get(i)))
                    break;
            }
            forest.addEdge(edgeList.get(i));
            edgeList.remove(i);
            Collections.sort(edgeList);
        }
        return forest.getAdjacentMatrix();
    }

    private boolean judge(Edge edge) {
        boolean returnValue = true;

        int x = edge.getX();
        int y = edge.getY();

        // System.out.println("Judge: x = "+x+", y = "+y+"; end of x = "+forest.getEndOfI(x)+", end of y = "+forest.getEndOfI(y));

        if ((forest.getEndOfI(x) == forest.getEndOfI(y)) && (forest.getEndOfI(x) != -1)) {
            returnValue = false;
        }

        return returnValue;
    }
}
