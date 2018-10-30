package cn.plusect;

import java.util.Arrays;

/**
 * 排序
 */
public class Sort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{5, 4, 2, 7, 1})));
    }

    /**
     * 冒泡排序
     * @param a
     * @return
     */
    private static int[] bubbleSort(int[] a){
        int length = a.length;
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++){
                if (a[j]>a[j+1]){
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                }
                flag = true;
            }
            if (!flag) break;
        }
        return a;
    }

    private static int[] insertionSort(int[] a){

        return a;
    }
}
