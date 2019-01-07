
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
