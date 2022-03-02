package com.chen.search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 1; i < 100; i++) {
            arr[i] = i + 1;
        }
        int index = insertSearch(arr, 0, arr.length - 1, 100);
        System.out.println("Index=" + index);
    }

    public static int insertSearch(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {
            return insertSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
