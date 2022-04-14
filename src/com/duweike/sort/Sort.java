package com.duweike.sort;

public class Sort {

    public static void heapSort(int[]nums, int lo, int hi) {
        buildMaxHeap(nums, lo, hi);
        for(int i=hi;i>lo;i--) {
            swap(nums,lo,i);
            i--;
            heapify(nums,lo,i);
        }

    }

    public static void buildMaxHeap(int[]nums, int lo, int hi) {
        for(int i=hi/2;i>=lo;i--) {
            heapify(nums,i,hi);
        }

    }

    public static void heapify(int[]nums, int i, int hi) {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;

        if(left<=hi && nums[left] > nums[largest]) {
            largest = left;
        }
        if(right<=hi && nums[right] > nums[largest]) {
            largest = right;
        }
        if(largest!=i) {
            swap(nums,i,largest);
            heapify(nums,largest,hi);
        }

    }

    public static void swap(int[]nums, int i,int j) {
        nums[j] = nums[j]^nums[i];
        nums[i] = nums[j]^nums[i];
        nums[j] = nums[j]^nums[i];
    }


    public static void quickSort(int[] nums,int left, int right) {
        if(left<right) {
            int partition = partition(nums, left, right);
            quickSort(nums,left,partition-1);
            quickSort(nums,partition+1,right);
        }
    }
    public static int partition(int[] nums,int low,int high){
        int pivot = nums[low];
        while(low<high) {
            while(low<high && nums[high]<=pivot)--high;
            nums[low] = nums[high];
            while(low<high && nums[low]>pivot) ++low;
            nums[high] = nums[low];
        }
        nums[high] = pivot;
        return low;

    }

    public static void mergeSort(int[]nums, int lo, int hi) {
        if(lo>=hi) return;
        int mid = lo + (hi-lo)/2;
        mergeSort(nums,lo,mid);
        mergeSort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);

    }

    public static void merge(int[]nums,int lo, int mid, int hi) {
        int[] temp = new int[nums.length];
        for(int i=lo;i<=hi;i++) {
            temp[i] = nums[i];
        }

        for(int i=lo,j=mid+1,k=lo;k<=hi;k++){
            if(i>mid) nums[k] = temp[j++];
            else if(j>hi) nums[k] = temp[i++];
            else if(temp[i]<temp[j]) nums[k] = temp[i++];
            else nums[k] = temp[j++];
        }

    }

    public static void main(String[] args) {
        int[] nums = {7,5,9,6,8,8,4,0,3,2,1,1};
        mergeSort(nums,0, nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ",nums[i]);
        }
        System.out.println();
//        quickSort(nums,0, nums.length-1);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.printf("%d ",nums[i]);
//        }
        System.out.println();
        heapSort(nums,0, nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ",nums[i]);
        }
    }
}
