import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Hanoi
 * @Description Solve the problem of tower of Hanoi using divide-and-conquer
 * @Date 2020/2/5 上午10:07
 * @Created by kamisama
 */
public class Hanoi {
    public static void Move(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘： "+a+"==>"+c);
        } else {
            // move all plans exclude the largest one in a to b, using c.
            Move(num-1, a, c, b);
            System.out.println("第"+num+"个盘： "+a+"==>"+c);
            Move(num-1, b, a, c);
        }
    }
}
