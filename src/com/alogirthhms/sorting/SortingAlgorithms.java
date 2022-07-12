package com.alogirthhms.sorting;

import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] nums1 = {5, 4, 3, 2, 1};
        bubbleSort(nums1);
        System.out.println("BUBBLE SORT: " + Arrays.toString(nums1));

        int[] nums2 = {5, 4, 3, 2, 1};
        insertionSort(nums2);
        System.out.println("INSERTION SORT: " + Arrays.toString(nums2));

        int[] nums3 = {5, 4, 3, 2, 1};
        quickSort(nums3, 0, nums3.length - 1);
        System.out.println("QUICK SORT: " + Arrays.toString(nums3));

        int[] nums4 = {5, 4, 3, 2, 1};
        selectionSort(nums4);
        System.out.println("SELECTION SORT:" + Arrays.toString(nums4));

        int[] nums5 = {5, 4, 3, 2, 1};
        mergeSort(nums5);
        System.out.println("MERGE SORT:" + Arrays.toString(nums5));

    }

    static void bubbleSort(int[] nums){
       boolean sorted = false;
       while(!sorted){
           sorted = true;
           for(int i = 0; i < nums.length - 1; i++){
               if(nums[i] > nums[i +1]){
                   int temp = nums[i];
                   nums[i] = nums[i + 1];
                   nums[i + 1] = temp;
                   sorted = false;
               }
           }
       }
    }

    static void insertionSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int idx = i - 1;
            while(idx > -1){
                if(nums[i] < nums[idx]){
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                    i = idx;
                }
                idx--;
            }
        }
    }

    static void quickSort(int[] nums, int start, int end){
        if(start < end){
            int partitionIndex = partitionArray(nums, start, end);
            quickSort(nums, start, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, end);
        }
    }

   static int partitionArray(int[] nums, int start, int end){
           int pivotElement = nums[end];
           int partitionIndex = start - 1;
           for(int i = start; i <= end; i++){
               if(nums[i] <= pivotElement){
                   partitionIndex++;
                   int temp = nums[i];
                   nums[i] = nums[partitionIndex];
                   nums[partitionIndex] = temp;
               }
           }
           return partitionIndex;
    }

    private static void selectionSort(int[] nums) {
      int idx = 0;
      boolean sorted = false;

      while(!sorted){
          sorted = true;
          int minIdx = -1;
          int minValue = Integer.MAX_VALUE;
          for(int i = idx; i < nums.length; i++){
            if(nums[i] < minValue){
                minValue = nums[i];
                minIdx= i;
                sorted = false;
            }
          }
          int temp = nums[idx];
          nums[idx] = nums[minIdx];
          nums[minIdx] = temp;
          if(idx < nums.length - 1)
            idx++;
          else
              sorted = true;
      }



    }

    private static void mergeSort(int[] nums){
        int length = nums.length;
        if(length == 1)
            return;
        int mid  = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        System.arraycopy(nums, 0, left, 0, left.length);
        System.arraycopy(nums, mid, right, 0,right.length);
        mergeSort(left);
        mergeSort(right);
        merge(nums, left, right);
    }

    private static void merge(int[] nums, int[] left, int[] right){
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                nums[k] = left[i];
                i++;
            } else{
                nums[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < left.length){
            nums[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length){
            nums[k] = right[j];
            j++;
            k++;
        }
    }


}
