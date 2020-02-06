import org.junit.Test;

/**
 * @Classname KMPTest
 * @Description TestKMP
 * @Date 2020/2/6 上午9:30
 * @Created by kamisama
 */
public class KMPTest {
    @Test
    public void Test() {
        KMP kmp = new KMP("BBC ABCDAB ABCDABCDABDE", "ABCDABD");
        System.out.println("Origin String: "+kmp.getOrigin());
        System.out.println("Target String: "+kmp.getTarget());
        int[] table = kmp.getPartMatchTable();
        System.out.print("Part Match Table: ");
        for (int i=0;i<table.length;i++)
            System.out.print(table[i]+" ");
        System.out.println();
        int index = kmp.Match();
        System.out.println(index);
    }
}
