[283. Move Zeroes](https://leetcode.com/problems/move-zeroes/description/)

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
We just need to put the non zero integers to starting whenever we find it.
# Approach
<!-- Describe your approach to solving the problem. -->
We just have a pointer(pos) which shows us where the non zero integer. We iterate through the array in the following way 
- if we find zero we just pass 
- if we find non zero we check the pos and put this non zero into pos and make this position zero.
# Complexity
- Time complexity:O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: No extra space
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public void moveZeroes(int[] nums) {
       
        int pos=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(pos==i) pos++;
                if(pos<i){
                        nums[pos++] = nums[i];
                        nums[i] = 0;
                }
            }
        }

    }
}
```