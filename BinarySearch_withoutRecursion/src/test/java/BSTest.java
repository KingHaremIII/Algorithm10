import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname BSTest
 * @Description TODO
 * @Date 2020/2/4 下午1:22
 * @Created by kamisama
 */
public class BSTest {
    int[] arr = {1, 4, 5, 7, 9, 31, 32};
    BinarySearch bs;
    int target;
    int index;

    @Before
    public void Preparation() {
        bs = new BinarySearch(arr);
        System.out.println("Array: "+ Arrays.toString(bs.getArray()));
    }

    @Test
    public void Test() {
        target = 5;;

        index = bs.Search(target);
        System.out.println("Index: "+index);
    }

    @Test
    public void InserTest() {
        target = 31;;

        index = bs.InsertSearch(target);
        System.out.println("Index: "+index);
    }

    @After
    public void Assert() {
        assert arr[index]==target;
    }
}
