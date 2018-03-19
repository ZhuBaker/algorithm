package com.timer.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 快排
 * User: zhubo
 * Date: 2018-03-19
 * Time: 16:10
 */
public class QuickSort {


    /**
     * http://blog.csdn.net/vayne_xiao/article/details/53508973
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 7, 4, 5 ,3 ,9 ,0};
        System.out.println(Arrays.toString(a));

        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a , int low , int high){
        //1.找到递归算法的出口
        if(low > high){
            return ;
        }
        //2.存
        int i = low;
        int j = high;
        //3.key
        int t = a[low];
        //4，完成一趟排序
        while(i < j ){
            //4.1 ，从右往左找到第一个小于key的数
            while(i < j && a[j] > t){
                j -- ;
            }
            //4.1 ，从左往右找到第一个大于key的数
            while(i < j && a[i] <= t){
                i ++ ;
            }
            //4.3 交换
            if(i < j){
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }

        //调整 key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5, 对key左边的数快排
        quickSort(a, low,i-1);
        //6, 对key右边的数快排
        quickSort(a , i+1 , high);

    }




    /*private static void quickSort(int[] a, int low, int high) {
        //1,找到递归算法的出口
        if( low > high) {
            return;
        }
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[ low ];
        //4，完成一趟排序
        while( i< j) {
            //4.1 ，从右往左找到第一个小于key的数
            while(i<j && a[j] > key){
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i<j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if(i<j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        // 4.4，调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5, 对key左边的数快排
        quickSort(a, low, i-1 );
        //6, 对key右边的数快排
        quickSort(a, i+1, high);
    }*/



}
