import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SetCoverageTest
 * @Description TODO
 * @Date 2020/2/6 下午12:12
 * @Created by kamisama
 */
public class SetCoverageTest {
    @Test
    public void Test() {
        List<String> regions = new ArrayList<String>();
        regions.add("A");
        regions.add("B");
        regions.add("C");
        regions.add("D");
        regions.add("E");
        String[] k1Regions = {"A", "C", "E"};
        String[] k2Regions = {"B", "C"};
        String[] k3Regions = {"B", "D"};


        SetCoverage setCoverage = new SetCoverage(3, regions);
        setCoverage.SetRadio(0, k1Regions);
        setCoverage.SetRadio(1, k2Regions);
        setCoverage.SetRadio(2, k3Regions);

        int[] used = setCoverage.Process();
        for (int u : used) {
            System.out.println(u);
        }
    }
}
