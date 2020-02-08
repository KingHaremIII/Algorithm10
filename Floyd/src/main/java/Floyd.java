/**
 * @Classname Floyd
 * @Description Floyd Algorithm
 * @Date 2020/2/8 上午10:48
 * @Created by kamisama
 */
public class Floyd {
    int[][] AdjacencyMatrix;
    int nodeNum;

    public Floyd(int[][] adjacencyMatrix) {
        nodeNum = adjacencyMatrix.length;
        AdjacencyMatrix = new int[nodeNum][nodeNum];
        for (int i=0;i<nodeNum;i++)
            for (int j=0;j<nodeNum;j++)
                AdjacencyMatrix[i][j] = adjacencyMatrix[i][j];
    }

    public void Process() {
        for (int k=0;k<nodeNum;k++)
            for (int i=0;i<nodeNum;i++)
                for (int j = 0; j < nodeNum; j++)
                    if (AdjacencyMatrix[i][j] > AdjacencyMatrix[i][k] + AdjacencyMatrix[k][j])
                        AdjacencyMatrix[i][j] = AdjacencyMatrix[i][k] + AdjacencyMatrix[k][j];
    }

    public int[][] getAdjacencyMatrix() {
        return AdjacencyMatrix;
    }
}
