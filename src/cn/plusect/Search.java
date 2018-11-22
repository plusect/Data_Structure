package cn.plusect;

import java.util.Arrays;

/**
 * 查找算法
 */
public class Search {
    public static void main(String[] args) {
        System.out.println("Simple Binary Search without recursion to get index for value :2 from " + Arrays.toString(new int[]{5, 4, 2, 7, 1})
                + ",the result:" + simpleBinarySearchByWithoutRecursion(new int[]{5, 4, 2, 7, 1}, 2));
        System.out.println("Simple Binary Search with recursion to get index for value:2 from " + Arrays.toString(new int[]{5, 4, 2, 7, 1})
                + ",the result:" + simpleBinarySearchByWithRecursion(new int[]{5, 4, 2, 7, 1}, 2));
    }

    /**
     * 简易递归二分查找
     *
     * @param a
     * @param value
     * @return
     */
    private static int simpleBinarySearchByWithRecursion(int[] a, int value) {
        int length = a.length;
        int low = 0;
        int high = length - 1;
        return binarySearchWithRecursion(a, low, high, value);
    }

    private static int binarySearchWithRecursion(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value)
            return mid;
        else if (a[mid] > value)
            return binarySearchWithRecursion(a, low, mid - 1, value);
        else
            return binarySearchWithRecursion(a, mid + 1, high, value);
    }

    /**
     * 简易非递归二分查找：数组、有序
     *
     * @param a
     * @param value
     * @return
     */
    private static int simpleBinarySearchByWithoutRecursion(int[] a, int value) {
        int length = a.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


}
