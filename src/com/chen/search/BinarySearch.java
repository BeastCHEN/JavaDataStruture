package com.chen.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1234};
        //int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
        //System.out.println("resIndex=" + resIndex);
        List resIndexlist=binarySearch2(arr,0,arr.length-1,1000);
        System.out.println("resIndexlist="+resIndexlist);
    }

    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (value > midVal) {
            return binarySearch(arr, mid + 1, right, value);
        } else if (value < midVal) {
            return binarySearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }

    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int value) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (value > midVal) {
            return binarySearch2(arr, mid + 1, right, value);
        } else if (value < midVal) {
            return binarySearch2(arr, left, mid - 1, value);
        } else {
            ArrayList<Integer> resIndexlist = new ArrayList<Integer>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != value) {
                    break;
                }
                resIndexlist.add(temp);
                temp -= 1;
            }
            resIndexlist.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != value) {
                    break;
                }
                resIndexlist.add(temp);
                temp += 1;
            }
            return resIndexlist;
        }
    }

}
