//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 848 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        quickSort(nums,left,right);
        return nums;
    }

    private void quickSort(int[]arr, int lo, int hi) {
        if(lo>=hi) {
            return;
        }
        int mid = partition(arr,lo,hi);
        quickSort(arr,lo,mid-1);
        quickSort(arr, mid+1,hi);
    }

    private int partition(int[]arr, int lo, int hi) {
        int n=arr[lo];
        int i=lo;
        int j=hi;
        while(i<j) {
            while(i<j && arr[j]>=n) j--;
            if(i<j)arr[i++]=arr[j];
            while(i<j && arr[i]<n)i++;
            if(i<j)arr[j--]=arr[i];
        }
        arr[j]=n;
        return j;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
