package cn.plusect;

import java.util.Arrays;

/**
 * 排序算法
 */
public class Sort {
    public static void main(String[] args) {
        System.out.println("Array: " + Arrays.toString(new int[]{5, 4, 2, 7, 1}));
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSort(new int[]{5, 4, 2, 7, 1})));
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSort(new int[]{5, 4, 2, 7, 1})));
        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(new int[]{5, 4, 2, 7, 1})));
        System.out.println("Merge Sort: " + Arrays.toString(mergeSort(new int[]{5, 4, 2, 7, 1})));
        System.out.println("Quick Sort: " + Arrays.toString(quickSort(new int[]{5, 4, 2, 7, 1})));
        System.out.println("Counting Sort: " + Arrays.toString(countingSort(new int[]{5, 4, 2, 7, 1})));
    }


    /**
     * 计数排序：非负最大值最小区范围差别不大，给每个值分配一个桶，桶中保存该值的数量，再修改值为到该值为止的值数量，
     * 然后通过倒序原数组给把个值在和原数组一样大的临时数组中插入到该最大值索引位置来实现排序
     *
     * @param a 假设数组中存储的都是非负整数
     * @return
     */
    private static int[] countingSort(int[] a) {
        int length = a.length;
        if (length <= 1) return a;

        //找到最大值区间

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < length; i++) {
            if (a[i] > max) max = a[i];
        }

        //创建桶,申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];
        //把各个值的总数放入桶中
        for (int i = 0; i < max + 1; i++) {
            c[i] = 0;
        }
        for (int anA : a) {
            c[anA]++;
        }
        // 每个桶值替换为到该值位置的总数
        for (int i = 1; i < max + 1; i++) {
            c[i] += c[i - 1];
        }
        // 临时数组r，存储排序之后的结果
        int[] r = new int[length];
        // 计算排序的关键步骤
        for (int i = length - 1; i >= 0; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }
        // 将结果拷贝会a数组
        for (int i = 0; i < length; i++) {
            a[i] = r[i];
        }

        return a;
    }

    /**
     * 快速排序：使用一个区分值（默认使用最后一个数），把小于区分值的放左边，大于区分值的放右边，直到区分缩小为1
     *
     * @param a
     * @return
     */
    private static int[] quickSort(int[] a) {
        int length = a.length;
        quickSortInternally(a, 0, length - 1);
        return a;
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        //获取分区点
        int q = partition(a, p, r);

        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        //使用末尾作为区分点
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
                i++;
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }

    /**
     * 归并排序：分治递归，数组半劈到只有一个数后，开始对前后两部分排序合并，直到完整数组
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
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int[] tmp = new int[r - p + 1]; // 申请一个大小跟a[p...r]一样的临时数组
        int i = p;
        int j = q + 1;
        int k = 0; //tmp数组的index
        while (i <= q && j <= r) {
            //判断往临时数据中插入谁，因为前后两部分都是有序的，所以可以保证tmp数组有序
            tmp[k++] = a[i] < a[j] ? a[i++] : a[j++];
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }
        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i < tmp.length; i++) {
            a[p + i] = tmp[i];
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
        for (int i = 1; i < length; i++) {
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
