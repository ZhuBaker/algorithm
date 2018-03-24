package com.timer.search;

/**
 * Created with IntelliJ IDEA.
 * Description: 二分查找
 * User: zhubo
 * Date: 2018-03-23
 * Time: 15:04
 */
public class BinarySearch {

    /**
     * @param arr
     * @param x
     * @return
     */
    public static int binarySearch(int[] arr , int x){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int middle = (low + high)/2;
            if(x == arr[middle]){
                return middle;
            }else if(x < arr[middle]){
                high = middle -1;
            }else{
                low = middle + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {6,12,33,87,90,97,108,561};

        System.out.println("循环查找:"+binarySearch(arr,90)+"");
    }



}
