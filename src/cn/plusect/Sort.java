package cn.plusect;

import java.util.Arrays;

/**
 * 排序
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = {5, 4, 2, 7, 1};
        System.out.println("Array: "+Arrays.toString(a));
        System.out.println("Bubble Sort: "+Arrays.toString(bubbleSort(a)));
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSort(a)));
        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(a)));
    }

    /**
     * 选择排序
     * @param a
     * @return
     */
    private static int[] selectionSort(int[] a) {
        int length = a.length;
        if (length <= 1) return a;
        return a;
    }

    /**
     * 冒泡排序
     *
     * @param a
     * @return
     */
    private static int[] bubbleSort(int[] a) {
        int length = a.length;
        if (length <= 1) {
            return a;
        }
        for (int i = 0; i < length; i++) {
            //提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                    flag = true; //表示数据交换
                }
            }
            if (!flag) break; //没有数据交换，提前退出
        }
        return a;
    }

    /**
     * 插入排序
     * @param a
     * @return
     */
    private static int[] insertionSort(int[] a) {
        int length = a.length;
        if (length <= 1) return a;
        for (int i = 0; i < length; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
        return a;
    }

}
