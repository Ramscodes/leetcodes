[1833. Maximum Ice Cream Bars](https://leetcode.com/problems/maximum-ice-cream-bars/description/)

# Intuition
 This is a simple program where we need to more ice creams with coins we have where we have given the costs of ice cream
# Approach
 - We just sort the costs of ice creams and we just start from the lowest price so that we can buy
 the more number of ice creams.
# Complexity 
 - Time complexity : O(n^2)
 - Space complexity: No extra space
# Code
```
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res=0;
        for(int i=0;i<costs.length;i++){
            if(coins <= 0 || coins < costs[i])
                break;
            else{
                res++;
                coins = coins - costs[i];
            }
        }
        return res;
    }
}
``` 
