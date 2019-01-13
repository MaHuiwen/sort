
/**
 * 各大排序算法，从大到小排序
 *
 * @author mhw
 * @date 2019/1/7 15:13
 */
public class SortUtils {

    /**
     * 冒泡排序
     */
    public static void bubbleSort(long[] arr) {
        int length = arr.length;
        long tmp;
        boolean isChange;
        for (int i = 0; i < length - 1; i++) {
            isChange = false;
            for (int j = length - 1; j > i; j--) {
                if (arr[j] > arr[j-1]) {
                    tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                    isChange = true;
                }
            }
            if (!isChange) break;
        }
    }

    /**
     * 插入排序
     */
    public static void insertionSort(long[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            long tmp = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if (tmp > arr[j]) {
                    arr[j+1] = arr[j];
                } else {
                    arr[j+1] = tmp;
                    break;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    public static void selectionSort(long[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            long max = arr[i];
            int loc = i;
            for (int j = i+1; j < length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    loc = j;
                }
            }
            arr[loc] = arr[i];
            arr[i] = max;
        }
    }

    /**
     * 归并排序
     */
    public static void mergeSort(long[] arr) {
        mergeSortPartArray(arr, 0, arr.length-1);
    }
    private static void mergeSortPartArray(long[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortPartArray(arr, start, mid);
            mergeSortPartArray(arr, mid+1, end);
            //将arr[start]-arr[mid]与arr[mid+1]-arr[end]进行合并
            int i = start;
            int j = mid + 1;
            long[] tmp = new long[end-start+1];
            int k = 0;
            while (i <= mid && j <= end) {
                if (arr[i] >= arr[j]) {
                    tmp[k] = arr[i];
                    i++;
                } else {
                    tmp[k] = arr[j];
                    j++;
                }
                k++;
            }
            while (i <= mid) {
                tmp[k] = arr[i];
                k++;
                i++;
            }
            while (j <= end) {
                tmp[k] = arr[j];
                k++;
                j++;
            }
            //将tmp复制到arr
            int s = start;
            for (long t : tmp) {
                arr[s] = t;
                s++;
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(long[] arr) {
        int low = 0;
        int high = arr.length - 1;
        qSort(arr, low, high);

    }
    private static void qSort(long[] arr, int low, int high) {
        if (low >= high) return;
        //选取三个数中的中位数作为基准值
        swapMidNumber(arr, low, high);
        long n = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[j] <= n && i < j) j--;
            if (arr[j] > n) arr[i++] = arr[j];
            while (arr[i] >= n && j > i) i++;
            if (arr[i] < n) arr[j--] = arr[i];
        }
        arr[i] = n;
        qSort(arr, low, i-1);
        qSort(arr, i+1, high);
    }
    private static void swapMidNumber(long[] arr, int low, int high) {
        int mid = (low + high) / 2;
        long a = arr[low];
        long b = arr[mid];
        long c = arr[high];
        if ((b>a && b<c) || (b<a && b>c)) {
            arr[low] = b;
            arr[mid] = a;
        }
        if ((c>a && c<b) || (c<a && c>b)) {
            arr[low] = c;
            arr[mid] = a;
        }
    }


    /**
     * 随机生成数组
     * @param length 数组的长度
     * @param min 最小值
     * @param max 最大值
     * @return 随机数组
     */
    public static long[] createRandomArray(int length, long min, long max) {
        long[] arr = new long[length];
        for (int i = 0; i <= length - 1; i++) {
            arr[i] = (long) (Math.random() * (max - min + 1)) + min;
        }
        return arr;
    }

    /**
     * 验证数组是否排序正确
     */
    public static boolean isSorted(long[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] < arr[i+1]) return false;
        }
        return true;
    }

}
