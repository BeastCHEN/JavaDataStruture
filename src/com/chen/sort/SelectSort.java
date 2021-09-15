package com.chen.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        //int[] arr={101,34,119,1};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        System.out.println("------排序前------");
        //System.out.println(Arrays.toString(arr));
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);
        selectSort(arr);
        System.out.println("------排序后------");
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序前的时间是=" + date2Str);
        //System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            //System.out.println("------第"+(i+1)+"轮------");
            //System.out.println(Arrays.toString(arr));
        }
        /**
         int minIndex=0;
         int min=arr[0];
         for (int j=0+1;j<arr.length;j++){
         if (min>arr[j]){
         min=arr[j];
         minIndex=j;
         }
         }
         arr[minIndex]=arr[0];
         arr[0]=min;
         System.out.println("------第一轮------");
         System.out.println(Arrays.toString(arr));

         minIndex=1;
         min=arr[1];
         for (int j=1+1;j<arr.length;j++){
         if (min>arr[j]){
         min=arr[j];
         minIndex=j;
         }
         }
         arr[minIndex]=arr[1];
         arr[1]=min;
         System.out.println("------第二轮------");
         System.out.println(Arrays.toString(arr));*/
    }
}
