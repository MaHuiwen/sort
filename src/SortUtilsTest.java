import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SortUtilsTest {

    @Test
    public void sortTest() {
        int i = 1000;
        while (i-- > 0) {
            long[] arrRandom = SortUtils.createRandomArray(10, 0, 50);
            //打印测试数据
            System.out.print("第" + i + "组测试示例" + ": ");
            for (long r : arrRandom) {
                System.out.print(r + " ");
            }
            System.out.println();
            //打印排序结果
            SortUtils.mergeSort(arrRandom);
            System.out.print("第" + i + "组排序结果" + ": ");
            for (long r : arrRandom) {
                System.out.print(r + " ");
            }
            System.out.println("\n");

            Assert.assertTrue(SortUtils.isSorted(arrRandom));

        }

    }

    @Test
    public void createRandomArray() {
        int length = 100000;
        int min = 0;
        int max = 9;
        Map<Long, Integer> map = new HashMap<>();
        long[] arrRandom = SortUtils.createRandomArray(length, min, max);
        for (long i = min; i <= max; i++) {
            map.put(i, 0);
        }
        for (long a : arrRandom) {
            map.put(a, map.get(a)+1);
        }
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    @Test
    public void isSorted() {
        long[] arr;
        boolean result;

        //test
        arr = new long[] {1,2,3,4};
        result = SortUtils.isSorted(arr);
        Assert.assertFalse(result);
        //test
        arr = new long[] {4,3,2,1};
        result = SortUtils.isSorted(arr);
        Assert.assertTrue(result);
        //test
        arr = new long[] {4,4,3,3};
        result = SortUtils.isSorted(arr);
        Assert.assertTrue(result);
        //test
        arr = new long[] {4,4,4,4};
        result = SortUtils.isSorted(arr);
        Assert.assertTrue(result);
    }

    private void printArr(long[] arr) {

    }
}