import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SetCoverage
 * @Description TODO
 * @Date 2020/2/6 下午12:11
 * @Created by kamisama
 */
public class SetCoverage {
    private List<String> regions;
    private int numRadio;
    private String[][] coverage;

    public SetCoverage(int num, List<String> re) {
        regions = re;
        numRadio = num;
        coverage = new String[numRadio][];
    }

    public void SetRadio(int index, String[] strings) {
        coverage[index] = strings;
    }

    public int[] Process() {
        // copy the regions list
        List<String> tmpRegionsResidual = new ArrayList<>();
        for (String s : regions) {
            tmpRegionsResidual.add(s);
        }
        // output array to identity which is used.
        int[] items = new int[numRadio];

        while(tmpRegionsResidual.size() != 0) {
            System.out.println("while Started! ");
            int[] nums = new int[numRadio];
            // enumerate the radio.
            for (int i=0;i<numRadio;i++) {
                // ith radio is not be used.
                if (items[i] == 0) {
                    // initialize the count of useful region covering.
                    int ithUsefulCover = 0;
                    // check whether ith radio covered region s is in uncovered regions or not.
                    for (String s : coverage[i]) {
                        for (String sResidual : tmpRegionsResidual) {
                            // s in uncovered regions.
                            if (s.equals(sResidual)) {
                                System.out.println(i+"th item: "+s+" is equal to "+sResidual);
                                ithUsefulCover++;
                            }
                        }
                    }
                    nums[i] = ithUsefulCover;
                }
            }

            // find the best radio covering most uncovered regions.
            int max = 0;
            int value = 0;
            for (int i=0;i<nums.length;i++) {
                if (nums[i] > value) {
                    value = nums[i];
                    max = i;
                }
            }
            System.out.println(max+" is used. ");
            // mark the used radio.
            items[max] = 1;

            // drop the regions covered
            for (String s : coverage[max]) {
                tmpRegionsResidual.remove(s);
            }
        }
        return items;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public int getNumRadio() {
        return numRadio;
    }

    public void setNumRadio(int numRadio) {
        this.numRadio = numRadio;
    }

    public String[][] getCoverage() {
        return coverage;
    }

    @Deprecated
    public void setCoverage(String[][] coverage) {
        this.coverage = coverage;
    }
}
