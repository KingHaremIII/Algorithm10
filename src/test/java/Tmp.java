import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Tmp
 * @Description arbitrary test
 * @Date 2020/2/4 下午2:04
 * @Created by kamisama
 */
public class Tmp {
    @Test
    public void Test() {
        List<String> a = new ArrayList<>();
        a.add("fuck");
        a.add("you");
        System.out.println(a.subList(0, 2));
    }
}
