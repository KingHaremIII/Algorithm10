/**
 * @Classname Forest
 * @Description a forest generating to a MST.
 * @Date 2020/2/7 下午1:33
 * @Created by kamisama
 */
public class Forest {
    private int nodeNum;
    private int[] endNodes;
    private int[][] AdjacentMatrix;

    public Forest(int num) {
        nodeNum = num;
        AdjacentMatrix = new int[num][num];
        endNodes = new int[num];
        for (int i=0;i<num;i++)
            endNodes[i] = -1;
    }

    /**
     * add a path to the forest and update all end-nodes.
     * @param edge the newly added edge.
     */
    public void addEdge(Edge edge) {
        int a = edge.getX();
        int b = edge.getY();
        if (a < b) {
            AdjacentMatrix[a][b] = edge.getWeight();
            // update the end of all nodes.
            UpdateEnd(a, b);
        }
        else if (a > b) {
            AdjacentMatrix[b][a] = edge.getWeight();
            // update the end of all nodes.
            UpdateEnd(b, a);
        }
        else
            System.out.println("Error edge: self-edge{"+a+"}");
    }

    private void UpdateEnd(int a, int b) {
        if (endNodes[a] != -1) {
            // b is not connected! ===================================
            if (endNodes[b] == -1) {
                // update end-node to node<b>.
                if (endNodes[a] < b) {
                    int tmp = endNodes[a];
                    for (int i = 0; i < nodeNum; i++) {
                        if (endNodes[i] == tmp) {
                            endNodes[i] = b;
                        }
                    }
                    endNodes[b] = b;
                }
                // update the end node of node<b> to endNode[a].
                else {
                    endNodes[b] = endNodes[a];
                }
            }
            // b is connected! ======================================
            else {
                if (endNodes[a] < endNodes[b]) {
                    int tmp = endNodes[a];
                    for (int i = 0; i < nodeNum; i++) {
                        if (endNodes[i] == tmp) {
                            endNodes[i] = endNodes[b];
                        }
                    }
                }
                else {
                    int tmp = endNodes[b];
                    for (int i = 0; i < nodeNum; i++) {
                        if (endNodes[i] == tmp) {
                            endNodes[i] = endNodes[a];
                        }
                    }
                }
            }
        }

        else {
            if (endNodes[b] != -1) {
                endNodes[a] = endNodes[b];
            }
            else {
                endNodes[a] = b;
                endNodes[b] = b;
            }
        }
    }

    /**
     * get the end node of node<index>
     * @param index
     * @return
     */
    public int getEndOfI(int index) {
        return endNodes[index];
    }

    public int[] getEndNodes() {
        return endNodes;
    }

    public int[][] getAdjacentMatrix() {
        return AdjacentMatrix;
    }

    /**
     * MST is completed or not
     * @return
     */
    public boolean MSTCompleted() {
        for (int i=0;i<nodeNum;i++) {
            if (endNodes[i] != nodeNum-1) {
                return false;
            }
        }
        return true;
    }
}
