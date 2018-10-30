package cn.plusect;

/**
 * 链表
 */
public class LinkesList {
    public static void main(String[] args) {
        System.out.println(CourseSix(new String[]{"a","b","a"}));
    }

    /**
     * 判断单链表的字符串是否为回文字符串
     * @param source
     * @return
     */
    private static boolean CourseSix(String[] source){
        if (source.length != 1){
            for (int i = 0; i < source.length/2; i++) {
                if (!source[source.length - 1 - i].equals(source[i])){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 使用数组实现LRU
     * @param c 要判断的字符
     * @param arr 定长数组
     */
    private static void CourseSixForLRUByArray(char c,char[] arr){

    }
}
