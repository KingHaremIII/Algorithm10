import java.util.ArrayList;
import java.util.List;

/**
 * @Classname KMP
 * @Description Match the origin string with the target string.
 * @Date 2020/2/6 上午9:10
 * @Created by kamisama
 */
public class KMP {
    // ==============private members=============
    // store each char of the string as a string in list.
    private List<String> origin;
    private List<String> target;
    private int[] partMatchTable;

    /**
     * constructor with ortgin and target string parameters.
     * @param s1
     * @param s2
     */
    public KMP(String s1, String s2) {
        origin = new ArrayList<>();
        target = new ArrayList<>();
        setInnerString(0, s1);
        setInnerString(1, s2);
        PMTConstructor();
    }

    /**
     * deal with the transformation between inner string list and input string, which
     * make the input of string convenient.
     * @param model
     * @param s
     */
    private void setInnerString(int model, String s) {
        if (model == 0) {
            origin = new ArrayList<>();
            char[] tmp = s.toCharArray();
            for (char t : tmp) {
                origin.add(t + "");
            }
        } else {
            target = new ArrayList<>();
            char[] tmp = s.toCharArray();
            for (char t : tmp) {
                target.add(t + "");
            }
        }
    }

    /**
     * construct part match table corresponding to target string.
     */
    public void PMTConstructor() {
        partMatchTable = new int[target.size()];
        for (int i=0;i<partMatchTable.length;i++) {
            partMatchTable[i] = subCommonMaxLength(target.subList(0, i+1));
        }
    }

    private int subCommonMaxLength(List<String> sub) {
        List<String> prefix = new ArrayList<>();
        List<String> postfix = new ArrayList<>();

        // i+1为前后缀长度
        for (int i=0;i<sub.size()-1;i++) {
            String tmpPre = "";
            for (int j=0;j<=i;j++) {
                tmpPre = tmpPre + sub.get(j);
            }
            String tmpPost = "";
            for (int j=0;j<=i;j++) {
                tmpPost= tmpPost + sub.get(sub.size()-j-1);
            }
            // reverse the string to postfix
            tmpPost = new StringBuilder(tmpPost).reverse().toString();
            prefix.add(tmpPre);
            postfix.add(tmpPost);
        }

//        System.out.println(prefix);
//        System.out.println(postfix);

        int length = 0;
        for (int i=0;i<prefix.size();i++) {
            if (prefix.get(i).equals(postfix.get(i))) {
                length = i+1;
            }
        }
        return length;
    }

    /**
     * match algorithm and return the index.
     * @return the index.
     */
    public int Match() {
        int index = -1;
        int i = 0;
        int j = 0;

        while (true) {
//            System.out.println("i = "+i);
//            System.out.printf("j = "+j+"\n\n");
            // the current position matched.
            if (origin.get(i).equals(target.get(j))) {
                i++;
                j++;
                // all char matched.
                if (j==target.size()) {
                    index = i - target.size();
                    break;
                } else if(i==origin.size()) {
                    break;
                }
            }
            // not matched
            else {
                i = i -j;
//                System.out.println("rest i = "+i);
                if (j>0) {
                    i = i + j - partMatchTable[j - 1];
//                    System.out.println("pmt: " + partMatchTable[j - 1]);
                } else {
                    i = i + 1;
                }
                j = 0;
            }
        }
        return index;
    }

    // =========================Getters and Setters========================
    public String getOrigin() {
        String out = "";
        for (String ele : origin) {
            out = out + ele;
        }
        return out;
    }

    public void setOrigin(String origin) {
        setInnerString(0, origin);
    }

    public String getTarget() {
        String out = "";
        for (String ele : target) {
            out = out + ele;
        }
        return out;
    }

    public void setTarget(String target) {
        setInnerString(1, target);
        PMTConstructor();
    }

    public int[] getPartMatchTable() {
        return partMatchTable;
    }
}
