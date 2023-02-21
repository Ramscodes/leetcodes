[540. Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array/)

# Intuition and Approach
1. In this problem we are given a sorted array in which every element occurs twice except one.We have to find out the number which occurred only once in the array.
2. From the given examples in the problem statement we can observe that first occurrence of an element will be in odd number and second occurrence will be in even number. 
3. If there is an element which occurred only once then the above pattern will change.
4. By the above observations , we can use the binary search to find out the single occurred element by the following algorithm.
- 4.1. Take low  as lowest index of the array and high as highest index of the array.
- 4.2. If the mid is even then it's duplicate should be in next element or if mid is in odd then it's duplicate should be in previous element. 
- 4.3. If these two conditions are satisfied, it means the pattern is not broken. So the single occurred element will be in second half of the array.So we change low to mid+1.
- 4.4. If the conditions are not met, it means the pattern is broken. We change the high to mid.
- 4.5. Follow this until the low is less than high. We can find our answer in the low index of the array.
# Complexity

- Time complexity : O(log n)
- Space complexity : O(1)

# Code
```
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0,high = nums.length-1;
        while(low<high){
            int mid = (low+high)/2;
            if((mid%2 == 0 && nums[mid+1] == nums[mid] ) ||
             (mid%2 != 0 && nums[mid-1] == nums[mid] )){
                low = mid+1;
            }
            else{
                high = mid;
            }

        }

        return nums[low];
    }
}
```