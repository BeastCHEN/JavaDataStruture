package com.chen.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20};
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));
            if (flag == false) {
                break;
            } else {
                flag = false;
            }
        }
        /**
         for(int j=0;j<arr.length-1-1;j++){
         if (arr[j]>arr[j+1]){
         temp=arr[j];
         arr[j]=arr[j+1];
         arr[j+1]=temp;
         }
         }
         System.out.println("第二趟排序后的数组");
         System.out.println(Arrays.toString(arr));
         for(int j=0;j<arr.length-1-2;j++){
         if (arr[j]>arr[j+1]){
         temp=arr[j];
         arr[j]=arr[j+1];
         arr[j+1]=temp;
         }
         }
         System.out.println("第三趟排序后的数组");
         System.out.println(Arrays.toString(arr));
         for(int j=0;j<arr.length-1-3;j++){
         if (arr[j]>arr[j+1]){
         temp=arr[j];
         arr[j]=arr[j+1];
         arr[j+1]=temp;
         }
         }
         System.out.println("第四趟排序后的数组");
         System.out.println(Arrays.toString(arr));
         */
    }
}
