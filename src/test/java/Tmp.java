import org.junit.Test;

/**
 * @Classname Tmp
 * @Description TODO
 * @Date 2020/2/4 下午2:04
 * @Created by kamisama
 */
public class Tmp {
    @Test
    public void Test() {
        int[] array = {1, 4, 5, 7, 9, 31, 32};
        int target = 31;
        int left = 0;
        int right = 7 - 1;
        System.out.println("target - array[left] = "+(target-array[left]));
        System.out.println("array[right] - array[left] = "+(array[right]-array[left]));
        double re = (double) (target-array[left])/(double) (array[right]-array[left]);
        System.out.println("out: "+(re));
        int mid = (int) Math.ceil((double)left + (double)(right-left)*re);
        System.out.printf("left: %d    right: %d    mid: %d", left, right, mid);
    }
}
