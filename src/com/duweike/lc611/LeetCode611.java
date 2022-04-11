package com.duweike.lc611;

import java.util.Arrays;

public class LeetCode611 {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for(int i=0;i<n;i++) {
            if(nums[i]==0)continue;
            for(int j=i+1;j<n;j++) {
                int sum = nums[i] + nums[j];
                int lo = j+1;
                int hi = n-1;
                int idx = 0;
                while(lo<=hi) {
                    int mid = lo + (hi-lo)/2;
                    if(nums[mid]>=sum) hi=mid-1;
                    else {
                        idx = mid;
                        lo = mid+1;
                    }
                }
                res += idx==0? 0: idx-j;

            }
        }
        return res;

    }

    private static int binarySearch(int[]nums, int left, int right, int target) {
        int mid = left + (right-left)/2;
        while(left<=right) {
            if(nums[mid]>=target)right = mid-1;
            else left = mid + 1;
            mid = left + (right-left)/2;
        }
        return mid;
    }



    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9};
        System.out.println(binarySearch(nums,0,nums.length-1,6));
    }
}
