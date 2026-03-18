class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[left] == target) return left;
            if(nums[right] == target) return right;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target) left = mid + 1;
        }
        int sum = right + left;
        return (sum % 2 == 0) ? sum / 2 : (sum + 1) / 2;
    }
}