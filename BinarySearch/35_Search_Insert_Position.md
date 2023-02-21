[35. Search Insert Position](https://leetcode.com/problems/search-insert-position/description/)


# Intuition and Approach

1. It is a simple easy question where we are given a sorted integer array  and a target. We have to find out the position in which we can place this target number.
2. To solve this problem we use the binary search algorithm and to find out where we can place this target.
3. We compare the target element with the middle element we calculate in the binary search. 
- 3.1. If the mid is greater than or equal to target then we have to place the target in the first half of the array.  
So we change the high to mid-1.
- 3.2. If the mid is lower than target then we have to place target in second half of array.  
So we change the low to mid+1.

# Complexity

- Time complexity : o(log n)
- Space complexity : O(1)

# code
```
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0,high = nums.length-1;
        int res = 0;
        while(low<=high){
                int mid = (low+high)/2;
                if(nums[mid]>=target){
                    res = mid;
                    high = mid-1;
                }
                else{
                    res = mid+1;
                    low = mid+1;
                }
        }
        return res;
    }
}
```
  