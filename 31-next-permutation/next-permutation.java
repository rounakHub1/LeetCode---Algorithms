class Solution {
    
    public void nextPermutation(int[] nums) {
        
        int ln = nums.length;
        int i = ln - 1;

        while (i > 0) {
            if (nums[i] > nums[i - 1]) {
                
                int pivotIndex = i - 1;
                int successorIndex = ln - 1;
                
                while (nums[successorIndex] <= nums[pivotIndex]) {
                    successorIndex--;
                }

                int temp = nums[pivotIndex];
                nums[pivotIndex] = nums[successorIndex];
                nums[successorIndex] = temp;

                int start = i;
                int end = ln - 1;

                while (start < end) {
                    int t = nums[start];
                    nums[start] = nums[end];
                    nums[end] = t;
                    start++;
                    end--;
                }
                return;
            } 
            i--;
        }
        if (i == 0) {
            Arrays.sort(nums);
        }
    }
}