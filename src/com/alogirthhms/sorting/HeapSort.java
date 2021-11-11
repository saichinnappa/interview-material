package com.alogirthhms.sorting;

import java.util.Arrays;

/**
 * HEAP SORT:
 * Step 1. Build Heap (MAX)
 * Step 2: Keep deleting elements from root and add to the end of the list
 * <p>
 * Time Complexity: O(nlogn) [for 1 node it takes 'logn' traversals and for 'n' nodes it will be 'n*logn')
 * Space Complexity: O(n) [since everything happens in place no additional space is used]
 */

public class HeapSort {

    public static void main(String[] args) {
        int[] unsortedArray = {9, 4, 7, 1, -2, 6, 5};
        insertNode(unsortedArray, 100);
        // BUILD MAX HEAP
        buildHeap(unsortedArray, "min");
        System.out.println("MAX-HEAP:\n" + Arrays.toString(unsortedArray));
        //BUILD MIN HEAP
//        buildHeap(unsortedArray, "min");
//        System.out.println("MIN-HEAP:\n" + Arrays.toString(unsortedArray));
        //DELETE ROOT ELEMENT
//        deleteRoot(unsortedArray, unsortedArray.length);
//        System.out.println("After deletion:\n" + Arrays.toString(unsortedArray));
    }

    private static void buildHeap(int[] unsortedArray, String heapType) {
        int length = unsortedArray.length;
        int lastParentNodeIndex = (length) / 2 - 1; //gives parent node of the last leaf node

        if (heapType.equals("max")) {
            //MAX HEAP
            for (int i = lastParentNodeIndex; i >= 0; i--) {
                maxHeapify(unsortedArray, length, i); //keep calling recursively until the parent is max-heapified
            }
        }
        if (heapType.equals("min")) {
            //MIN HEAP
            for (int i = lastParentNodeIndex; i >= 0; i--) {
                minHeapify(unsortedArray, length, i); //keep calling recursively until the parent is max-heapified
            }
        }
    }

    static void minHeapify(int[] unsortedArray, int arrayLength, int root) {
        int smallest = root;
        int leftNode = 2 * root + 1; //calculate left of parent
        int rightNode = 2 * root + 2; // calculate right of parent
        if (leftNode < arrayLength && unsortedArray[leftNode] < unsortedArray[smallest]) { //check if indices are within the array range and check if left node is less than parent
            smallest = leftNode; // if above condition true get the index of the left node
        }
        if (rightNode < arrayLength && unsortedArray[rightNode] < unsortedArray[smallest]) { //check if indices are within the array range and check if right node is less than parent
            smallest = rightNode; // if above condition true get the index of the right node
        }
        if (smallest != root) { //if the parent node index is changed then swap parent with left/right node and then call this function again to rearrange the subtree elements
            int temp = unsortedArray[smallest];
            unsortedArray[smallest] = unsortedArray[root];
            unsortedArray[root] = temp;
            minHeapify(unsortedArray, arrayLength, smallest); //recursive call
        }

    }

    static void maxHeapify(int[] unsortedArray, int arrayLength, int root) {
        int largest = root;
        int leftNode = 2 * root + 1;
        int rightNode = 2 * root + 2;
        if (leftNode < arrayLength && unsortedArray[leftNode] > unsortedArray[largest]) {
            largest = leftNode;
        }
        if (rightNode < arrayLength && unsortedArray[rightNode] > unsortedArray[largest]) {
            largest = rightNode;
        }
        if (largest != root) {
            int temp = unsortedArray[largest];
            unsortedArray[largest] = unsortedArray[root];
            unsortedArray[root] = temp;
            maxHeapify(unsortedArray, arrayLength, largest);
        }
    }

    static void deleteRoot(int[] unsortedArray, int length) {
        int lastNode = unsortedArray[length - 1];
        unsortedArray[length - 1] = unsortedArray[0];
        unsortedArray[0] = lastNode;
        length = length - 1;
        maxHeapify(unsortedArray, length, 0);
        if (length > 1) {
            deleteRoot(unsortedArray, length);
        }
    }

    //Copy all the elements to new array and add new node as the leaf node i.e end of the array and create a max heap
    static void insertNode(int[] unsortedArray, int newNode) {
        int[] newUnsortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length + 1);
        newUnsortedArray[unsortedArray.length] = newNode;
        buildHeap(newUnsortedArray, "max");
        System.out.println(Arrays.toString(newUnsortedArray));
        deleteRoot(newUnsortedArray, newUnsortedArray.length);
        System.out.println(Arrays.toString(newUnsortedArray));
    }
}
