package cn.plusect;

import java.util.*;

public class Array {
    public static void main(String[] args) {
//        System.out.println(singleNumber(new int[]{2,2,1}));
//        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 3, 4, 5}, new int[]{2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,8,7,6,5,4,3,2,1,0})));
    }

    /**
     * 求出现一次的数字
     * @param nums
     * @return
     */
    private static int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i< nums.length; i++){
            result^=nums[i];
        }
        return result;
    }

    /**
     * 求交集
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (!set.contains(i)){
                result.add(i);
            }
        }
        int[] newArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            newArr[i] = result.get(i);
        }
        return newArr;
    }

    private static int[] plusOne(int[] digits) {
        //get row integer
        int row = 0;
        for(int i =0; i < digits.length; i ++){
            row += (digits[i] * getPow(10,digits.length - i - 1));
        }
        // plus one
        row +=1;
        //get num's length
        int length = getLength(row);
        int[] newArr = new int[length];
        for(int i=0; i< length; i++){
            newArr[length-i-1] = row%10;
            row/=10;
        }
        return newArr;
    }

    private static int getPow(int i, int n) {
        for (int j = 0; j < n; j++) {
            i *= 10;
        }
        return i;
    }

    private static int getLength(int row){
        int length = 1;
        while (row/10 > 0){
            ++length;
            row /= 10;
        }
        return length;
    }

}
