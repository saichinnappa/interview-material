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
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < nums.length - 1; i++){
                if(nums[i] > nums[i + 1]){
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    static void insertionSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int left = i - 1;
            while(left > -1 && nums[i] < nums[left]){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left--;
                i--;
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
        int startIdx = 0;
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            int min = nums[startIdx];
            int minIdx = -1;
            for(int i = startIdx + 1; i < nums.length; i++){
                if(min > nums[i]){
                    min = nums[i];
                    minIdx =  i;
                    isSorted = false;
                }
            }
            if(!isSorted){
                int temp = nums[minIdx];
                nums[minIdx] = nums[startIdx];
                nums[startIdx] = temp;
                startIdx++;
            }
        }

    }

    private static void mergeSort(int[] nums){
        int length = nums.length;
        if(length == 1)
            return;
        int mid = length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];
        System.arraycopy(nums, 0, leftArray, 0, leftArray.length);
        System.arraycopy(nums, mid, rightArray, 0, rightArray.length);
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(nums, leftArray, rightArray);

    }

    private static void merge(int[] nums, int[] left, int[] right){
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                nums[k] = left[i];
                i++;
            } else{
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        while(j < right.length){
            nums[k] = right[j];
            j++;
            k++;
        }

        while(i < left.length) {
            nums[k] = left[i];
            i++;
            k++;
        }
    }


}
