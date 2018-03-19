package com.timer.sort;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhubo
 * Date: 2018-03-19
 * Time: 14:14
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = new int[]{10,2,4,3,5,6,8,7};
        int t = 0;
        for(int i = 0 ; i < arr.length ; i ++){
            for(int j = 0 ; j < arr.length - i -1 ; j++){
                if(arr[j] > arr[j+1]){
                    t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }

        System.out.println(arr);
    }


}
