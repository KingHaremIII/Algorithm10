import org.junit.Test;

/**
 * @Classname BagPTest
 * @Description TODO
 * @Date 2020/2/5 下午1:11
 * @Created by kamisama
 */
public class BagPTest {
    @Test
    public void Test() {
        int[] weights = {1, 2, 3, 4};
        int[] values = {3, 5, 7, 9};
        BagProblem bp = new BagProblem(weights, values, 4);
        bp.findMax();
        int max = bp.getMax();
        System.out.println("Max = "+max);
        System.out.println(bp.getX());
        System.out.println(bp.getY());
        bp.findWhat(bp.getX(), bp.getY());
        int[] items = bp.getItem();
        for (int tmp=0;tmp<items.length;tmp++) {
            if (items[tmp] == 1) {
                System.out.println(tmp+" is put into the bag. ");
            }
        }
    }
}
