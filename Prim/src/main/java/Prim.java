import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Prim
 * @Description Solve MST with Prim algorithm
 * @Date 2020/2/7 上午10:22
 * @Created by kamisama
 */
public class Prim {
    private char[] regionNames;
    private int[] visited;
    private int[][] AdjacencyMatrix;
    private int[][] mst;

    public Prim(int regionNum) {
        regionNames = new char[regionNum];
        for (int i=0;i<regionNum;i++) {
            regionNames[i] = (char) (65+i);
        }
        init_V_AM_MST(regionNum);
    }

    public Prim(char[] regionNames) {
        this.regionNames = new char[regionNames.length];
        for (int i=0;i<regionNames.length;i++) {
            this.regionNames[i] = regionNames[i];
        }
        init_V_AM_MST(regionNames.length);
    }

    public void generateMST() {
        int[][] tmp = new int[visited.length][visited.length];
        visited[0] = 1;

        extendMST(tmp);
        while (sumVisited() != visited.length) {
            extendMST(tmp);
        }
    }

    private void extendMST(int[][] tmp) {
        fullWithMax(tmp);
        for (int i=0;i<visited.length;i++) {
            if (visited[i]==1) {
                for (int j=0;j<visited.length;j++) {
                    if (visited[j]==0) {
                        tmp[i][j] = AdjacencyMatrix[i][j];
                    }
                }
            }
        }
        int[] xy = VertexOfMin(tmp);
        mst[xy[0]][xy[1]] = AdjacencyMatrix[xy[0]][xy[1]];
        visited[xy[1]] = 1;
    }

    public int[][] getMST() {
        return mst;
    }

    private void fullWithMax(int[][] matrix) {
        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix.length;j++)
                matrix[i][j] = Integer.MAX_VALUE;
    }

    private int[] VertexOfMin(int[][] tmp) {
        int min = Integer.MAX_VALUE;
        int x = -1;
        int y = -1;
        for (int i=0;i<tmp.length;i++) {
            for (int j=0;j<tmp.length;j++) {
                if (tmp[i][j] < min) {
                    min = tmp[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        return new int[]{x, y};
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        for (int i=0;i<adjacencyMatrix.length;i++)
            for (int j=0;j<adjacencyMatrix.length;j++) {
                AdjacencyMatrix[i][j] = adjacencyMatrix[i][j];
            }
    }

    private void init_V_AM_MST(int regionNum) {
        visited = new int[regionNum];
        AdjacencyMatrix = new int[regionNum][regionNum];
        mst = new int[regionNum][regionNum];
    }

    private int sumVisited() {
        int sum = 0;
        for (int i=0;i<visited.length;i++) {
            sum = sum + visited[i];
        }
        return sum;
    }
}
