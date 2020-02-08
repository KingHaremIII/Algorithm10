/**
 * @Classname Dijkstra
 * @Description Dijkstra Algorithm for shortest route from the specific node.
 * @Date 2020/2/8 下午3:28
 * @Created by kamisama
 */
public class Dijkstra {
    private int nodeNum;
    private int[][] AdjacencyMatrix;
    // previousVector[i] == -1: not visited, -2: start point, other non-negative value: previous node in the path.
    private int[] previousVector;

    public Dijkstra(int[][] am) {
        nodeNum = am.length;
        AdjacencyMatrix = new int[nodeNum][nodeNum];
        for (int i=0;i<nodeNum;i++)
            for (int j=0;j<nodeNum;j++)
                AdjacencyMatrix[i][j] = am[i][j];
        previousVector = new int[nodeNum];
    }

    public void Process(int startPoint) {
        for (int i=0;i<nodeNum;i++)
            previousVector[i] = -1;
        previousVector[startPoint] = -2;
        int[][] adjacencyMatrix = new int[nodeNum][nodeNum];
        for (int i=0;i<nodeNum;i++) {
            for (int j = 0; j < nodeNum; j++)
                adjacencyMatrix[i][j] = AdjacencyMatrix[i][j];
        }

        int cnt = 1;
        int currentPoint = startPoint;
        while (cnt < nodeNum) {
            System.out.println("coutn = "+cnt);
            int i = search(currentPoint, adjacencyMatrix);
            System.out.println("searched: "+i);

            // newly connected node.
            if (previousVector[i] == -1) {
                // increment the number of nodes in route.
                cnt++;
                previousVector[i] = currentPoint;
            }
            else if (previousVector[i] != -2) {
                if (adjacencyMatrix[previousVector[i]][i] > adjacencyMatrix[currentPoint][i]+adjacencyMatrix[previousVector[i]][currentPoint]) {
                    adjacencyMatrix[previousVector[i]][i] = adjacencyMatrix[currentPoint][i]+adjacencyMatrix[previousVector[i]][currentPoint];
                    previousVector[i] = currentPoint;
                }
            }
            else {
                if (adjacencyMatrix[startPoint][i] > adjacencyMatrix[currentPoint][i]+adjacencyMatrix[startPoint][currentPoint]) {
                    adjacencyMatrix[startPoint][i] = adjacencyMatrix[currentPoint][i]+adjacencyMatrix[startPoint][currentPoint];
                    previousVector[i] = currentPoint;
                }
            }
            for (int q=0;q<previousVector.length;q++) {
                System.out.printf("%12d", previousVector[q]);
            }
            System.out.println();
            currentPoint = i;
        }
    }

    private int search(int cuP, int[][] am) {
        int min=Integer.MAX_VALUE;
        int index = 0;
        for (int i=0;i<nodeNum;i++) {
            if (min > am[cuP][i]) {
                min = am[cuP][i];
                index = i;
            }
        }
        return index;
    }

    public int[] getPreviousVector() {
        return previousVector;
    }
}
