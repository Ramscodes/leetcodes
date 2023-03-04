[493. Reverse Pairs](https://leetcode.com/problems/reverse-pairs/)

# Intuition and Approach

1. This problem is about finding a reverse pair (i,j) where 
 - 0 <= i < j < nums.length and
 - nums[i] > 2 * nums[j].
2. If we are using two pointers approach and iterate every pair possible it will take more time.
3. Here we use the merge sort approach .
- 3.1. First we split the array like we do in the merge sort algorithm.
- 3.2. While we are merging the array , we apply the logic of finding the pair 

        - as half of the arrays is already sorted we compare the element from first half array to the element in second half array and move the element in second array to the right.
        - as we are comparing elements in sorted array it takes less time to iterate and find the pairs.

# Complexity

- Time complexity : O(nLog n)
- Space complexity : O(n)

# Code 
```
class Solution {
    public int reversePairs(int[] nums) {

        // approach using merge sort approach
        return mergeSort(nums,0,nums.length-1);

    }

    public int mergeSort(int[] nums,int low,int high){
        if(low>=high) return 0;
        int mid = (low+high)/2;
        int res = mergeSort(nums,low,mid);
        res += mergeSort(nums,mid+1,high);
        res += merge(nums,low,mid,high);
        return res;
    }

    public int merge(int[] nums,int low,int mid,int high){
        int res=0;
        int j=mid+1;
        //core logic of forming pairs
        // here we iterate the first array from low ->mid by comparing low to element
        // in the second array from mid -> high
        //as the array is sorted we can easily calculate the pairs by comparing and moving the pointer in second array.
        for(int i=low;i<=mid;i++){
            while(j<=high&&nums[i]>(2*(long)nums[j])) j++;
            res += (j-(mid+1));
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int i=low;
        j=mid+1;
        while(i<=mid&&j<=high){
            if(nums[i] < nums[j]) temp.add(nums[i++]);
            else temp.add(nums[j++]);
        }
        while(i<=mid) temp.add(nums[i++]);
        while(j<=high) temp.add(nums[j++]);
        for(int id=low;id<=high;id++){
            nums[id] = temp.get(id-low);
        }
        return res;
    }
}