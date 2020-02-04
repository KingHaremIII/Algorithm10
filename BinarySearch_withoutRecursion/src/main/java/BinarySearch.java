/**
 * @Classname BinarySearch
 * @Description Binary search class
 * @Date 2020/2/4 下午1:16
 * @Created by kamisama
 */
public class BinarySearch {
    int[] array;

    public BinarySearch(int[] arr) {
        array = arr;
    }

    /**
     * 二分查找目标，采用非递归形式。
     * @param target the target for searching
     * @return
     */
    public int Search(int target) {
        int index = -1;
        /*
        initialize the bound and mid point.
        */
        int left = 0;
        int right = array.length - 1;
        int mid = (int) ((left + right) / 2);;
        /*
        update the bound and mid point.
        */
        while((target!=array[mid])&&((right-left)>1)) {
            if (target < array[mid]) {
                right = mid;
            } else {
                left = mid;
            }
            mid = (int) ((left + right) / 2);
        }
        /*
        judge whether satisfied or not found.
        */
        if (target == array[mid]) {
            index = mid;
        } else {
            if (target == array[left])
                index = left;
            else if (target == array[right])
                index = right;
        }
        return index;
    }

    public int[] getArray() {
        return array;
    }

    /**
     * 使用插入查找法
     * @param target the target for searching
     * @return
     */
    public int InsertSearch(int target) {
        int index = -1;
        /*
        initialize the bound and mid point.
        */
        int left = 0;
        int right = array.length - 1;
        double tmp = (double) (target-array[left])/(double) (array[right]-array[left]);
        int mid = (int) Math.ceil((double)left + (double)(right-left)*tmp);
        if (mid == right)
            mid--;
        out(left, right, mid);
        /*
        update the bound and mid point.
        */
        int cnt = 0;
        while((target!=array[mid])&&((right-left)>1)) {
            if (target < array[mid]) {
                right = mid;
            } else {
                left = mid;
            }
            tmp = (double) (target-array[left])/(double) (array[right]-array[left]);
            mid = (int) Math.ceil((double)left + (double)(right-left)*tmp);
            if (mid == right)
                mid--;
            out(left, right, mid);
            cnt++;
            if (cnt>10)
                break;
        }
        /*
        judge whether satisfied or not found.
        */
        if (target == array[mid]) {
            index = mid;
        } else {
            if (target == array[left])
                index = left;
            else if (target == array[right])
                index = right;
        }
        return index;
    }

    private void out(int left, int right, int mid) {
        System.out.printf("left: %d=>%d    right: %d=>%d    mid: %d=>%d\n", left, array[left], right, array[right], mid, array[mid]);
    }
}
