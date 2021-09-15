package com.chen.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        //int[] arr={101,34,119,1,-1,89};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);
        insertSort(arr);
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序前的时间是=" + date2Str);
    }

    public static void insertSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int insertVal=arr[i];
            int insertIndex=i-1;
            while (insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex+1!=i){
                arr[insertIndex+1]=insertVal;
            }
            //System.out.println("----Round "+i+"----");
            //System.out.println(Arrays.toString(arr));
        }
    }
}
