package cn.plusect;

/**
 * 堆
 */
public class Heap {
    /**
     * 从index=1开始储存
     */
    private int[] a;
    /**
     * 堆可以储存的最大个数
     */
    private int n;
    /**
     * 目前的个数
     */
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        this.n = capacity;
        count = 0;
    }

    public void insert(int data){
        //堆满了
        if (count >= n) return;

        ++count;

        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]){
            swap(a,i,i/2);
            i/=2;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = this.a[i];
        this.a[i] = this.a[j];
        this.a[j] = tmp;
    }
}
