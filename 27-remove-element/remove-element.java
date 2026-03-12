class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for the next non-val element
        
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not the value we want to remove
            if (nums[i] != val) {
                // Move it to the front at index k
                nums[k] = nums[i];
                k++;
            }
        }
        
        return k; // k is the count of elements not equal to val
    }
}