package com.timer.sort;

/**
 * Created with IntelliJ IDEA.
 * Description:选择排序
 * User: zhubo
 * Date: 2018-03-19
 * Time: 14:32
 */
public class SelectSort {

    /**
     * （从小到大排）
     * 每一趟从待排序序列选择一个最小的元素放到已排好序序列的末尾，剩下的位待排序序列，重复上述步骤直到完成排序。
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = new int[]{10,2,4,3,5,6,8,7};
        int t = 0;
        for(int i = 0 ; i < arr.length -1 ; i++){
            for(int j = i + 1 ;j < arr.length; j++ ){
                if(arr[i] > arr[j]){
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }

        System.out.println(arr);
    }


}
