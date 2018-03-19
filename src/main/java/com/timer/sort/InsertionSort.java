package com.timer.sort;

/**
 * Created with IntelliJ IDEA.
 * Description: 插入排序
 * User: zhubo
 * Date: 2018-03-19
 * Time: 14:41
 */
public class InsertionSort {
    /**
     * 将数组分为两部分，将后部分元素逐一与前部分元素比较，如果当前元素array[i]小，就替换。
     * 找到合理位置插入array[i]
     * 插入排序算法有种递归的思想在里面，它由N-1趟排序组成。初始时，只考虑数组下标0处的元素，只有一个元素，显然是有序的。
     * 然后第一趟 对下标 1 处的元素进行排序，保证数组[0,1]上的元素有序；
     * 第二趟 对下标 2 处的元素进行排序，保证数组[0,2]上的元素有序；@param args
     */
    public static void main(String[] args) {
        int arr[] = new int[]{10,2,4,3,5,6,8,7};
        int i , j , t = 0;
        for(i = 1 ; i < arr.length ; i ++){
            t = arr[i];
            for( j = i -1 ; j >=0 && t < arr[j]; j--){
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = t;
        }
        System.out.println(arr);
    }
}
