[452. Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/)

# Intuition
We need to sort the arrays so that we can easily calculate how many baloons will burst for one arrow.

# Approach
- The approach used here is to sort the intervals by their end point (the second element of each interval), and then iterate through the sorted list. At each iteration, we compare the start point of the current interval with the end point of the previous interval. If the start point of the current interval is after the end point of the previous interval, it means that the current interval does not overlap with the previous one, and therefore we need an additional arrow to burst the current interval. If the start point of the current interval is before or at the same point as the end point of the previous interval, it means that the current interval overlaps with the previous one, and we can burst both intervals with only one arrow.

- This solution works because if we sort the intervals by their end point, it will always be optimal to use the minimum number of arrows to burst the intervals that end first. This is because, if we have two intervals A and B such that A ends before B and we use one arrow to burst A, it means that we cannot use that same arrow to burst B, and therefore we must use an additional arrow for B. Therefore, it is always optimal to use the minimum number of arrows to burst the intervals that end first.

# Complexity
- Time complexity : O(n^2)

- Space complexity: No extra space

# Code
```
class Solution {
   // Finds the minimum number of arrows needed to burst all balloons
   public int findMinArrowShots(int[][] points) {
        // Sort the balloons by the end position of the arrow
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        
        // Initialize the number of arrows needed to 1
        int result = 1;
        // Set the index of the previously burst balloon to 0
        int previous = 0;
        
        // Iterate through all balloons
        for(int current = 1; current < points.length; current++){
            // If the start position of the current balloon is after the end position of the arrow that burst the previous balloon,
            // then a new arrow is needed to burst the current balloon
            if(points[current][0] > points[previous][1]){
                result++;
                // Update the index of the previously burst balloon
                previous = current;
            }
        }
        return result;            
    }
}
```