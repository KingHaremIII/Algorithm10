import static java.lang.Integer.max;

/**
 * @Classname BagProblem
 * @Description TODO
 * @Date 2020/2/5 下午12:57
 * @Created by kamisama
 */
public class BagProblem {
    int[] listWeight;
    int[] listValue;
    int bagV;
    // create a 2D array with expanded size due to the 0 column and row.
    int[][] dp;
    // set maxtmp, x and y to record the current max and its cooridnation.
    int maxtmp = 0;
    int x;
    int y;
    // create a array to record whether certain thing is put into the bag or not.
    int[] item;

    public BagProblem(int[] weights, int[] values, int bagLim) {
        listWeight = new int[weights.length+1];
        listValue = new int[values.length+1];
        bagV = bagLim;
        dp = new int[listWeight.length][bagV+1];
        item = new int[listWeight.length];
        for (int ai=1;ai<dp.length;ai++) {
            listWeight[ai] = weights[ai-1];
            listValue[ai] = values[ai-1];
        }
    }

    public void findMax() {
        for (int i = 1; i < listWeight.length; i++) {
            for (int j = 1; j <= bagV; j++) {
                // the current thing cannot be put into the bag.
                if (j < listWeight[i])
                    dp[i][j] = dp[i - 1][j];
                    // check whether it is valuable to be put into the bag.
                else
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - listWeight[i]] + listValue[i]);

                // check out whether it is a better one.
                if (maxtmp < dp[i][j]) {
                    maxtmp = dp[i][j];
                    x = i;
                    y = j;
                }
            }
        }
    }

    /**
     * dp[i][j] == 1) dp[i - 1][j]    ---->   item[i] is not accounted.
     *          == 2) dp[i-1][j-listWeight[i]]+listValue[i]    ---->    item[i] is accounted.
     * @param i
     * @param j
     */
    public void findWhat(int i, int j) {
//        boolean s1 = dp[i][j] == dp[i - 1][j];
//        boolean s2 = (j-listWeight[i]) >= 0 && (dp[i][j]==dp[i-1][j-listWeight[i]]+listValue[i]);
        if (i > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                item[i] = 0;
                findWhat(i - 1, j);
            }
            else if ((j-listWeight[i]) >= 0 && (dp[i][j]==dp[i-1][j-listWeight[i]]+listValue[i])) {
                item[i] = 1;
                findWhat(i - 1, j - listWeight[i]);
            }
        }
    }

    public int[] getItem() {
        return item;
    }

    public int getMax() {
        return maxtmp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
