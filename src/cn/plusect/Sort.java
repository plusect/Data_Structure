package cn.plusect;

import java.util.Arrays;

/**
 * 排序
 */
public class Sort {
    public static void main(String[] args) {
        System.out.println("Array: " + Arrays.toString(new int[]{5, 4, 2, 7, 1}));
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSort(new int[]{5, 4, 2, 7, 1})));
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSort(new int[]{5, 4, 2, 7, 1})));
        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(new int[]{5, 4, 2, 7, 1})));
        System.out.println("Merge Sort: " + Arrays.toString(mergeSort(new int[]{5, 4, 2, 7, 1})));
    }

    /**
     * 归并排序：分治递归，数组半劈，直到只有一个数后，对前后两部分排序合并
     *
     * @param a
     * @return
     */
    private static int[] mergeSort(int[] a) {
        int length = a.length;
        mergeSortInternally(a, 0, length - 1);
        return a;
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        //递归终止条件，只有一个数
        if (p >= r) return;

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值,唯一操作更快
        int q = p + ((r - p) >> 1);
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p ,q ,r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int[] tmp = new int[r-p+1]; // 申请一个大小跟a[p...r]一样的临时数组
        int i = p;
        int j = q+1;
        int k = 0; //tmp数组的index
        while (i <= q && j <=r){
            //判断往临时数据中插入谁，因为前后两部分都是有序的，所以可以保证tmp数组有序
            if (a[i]<a[j]){
                tmp[k++] = a[i++];
            }else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r){
            start = j;
            end = r;
        }
        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end){
            tmp[k++] = a[start++];
        }
        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; i ++){
            a[p+i] = tmp[i];
        }
    }

    /**
     * 选择排序：找到无序区间最小的值放到有序区间末尾
     *
     * @param a
     * @return
     */
    private static int[] selectionSort(int[] a) {
        int length = a.length;
        if (length <= 1) return a;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < a[minIndex]) {
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
     *
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
