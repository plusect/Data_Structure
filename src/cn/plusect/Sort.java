package cn.plusect;

import java.util.Arrays;

/**
 * 排序
 */
public class Sort {
    public static void main(String[] args) {
        System.out.println("Array: "+Arrays.toString(new int[]{5, 4, 2, 7, 1}));
        System.out.println("Bubble Sort: "+Arrays.toString(bubbleSort(new int[]{5, 4, 2, 7, 1})));
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSort(new int[]{5, 4, 2, 7, 1})));
        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(new int[]{5, 4, 2, 7, 1})));
        System.out.println("Merge Sort: " + Arrays.toString(mergeSort(new int[]{5, 4, 2, 7, 1})));
    }

    /**
     * 归并排序：
     * @param a
     * @return
     */
    private static int[] mergeSort(int[] a) {
        return new int[0];
    }

    /**
     * 选择排序：找到无序区间最小的值放到有序区间最后
     * @param a
     * @return
     */
    private static int[] selectionSort(int[] a) {
        int length = a.length;
        if (length <= 1) return a;
        for (int i = 0; i < length -1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < a[minIndex]){
                    minIndex = j;
                }
            }

            //swap
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
        return a;
    }

    /**
     * 冒泡排序：每轮都把最大的放到最后
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
     * 插入排序： 每轮都把无序区间的数在有序区间找到位置插入
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
