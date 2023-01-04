[2244. Minimum Rounds to Complete All Tasks](https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/)

# Intuition
We first count the tasks of same difficulty and use that count to complete the tasks.
# Approach
We make a hashmap where key represent the count and value represent the how many of such tasks are there.
If the count is 
- less than 1 then return -1 because we should solve 2 or 3 tasks in one round compulsory so if count less than that then we can't solve all the tasks.
- greater than 1 then we divided the count by 3 , if the reminder is 0 then we can solve the tasks of that difficulty in that many rounds or if the reminder is 1 or 2 then we have to take one more extra round to solve all the number of such difficulty tasks.
# Complexity
- Time complexity:O(n)

- Space complexity: Extra HashMap for counting number of similar difficulty tasks.

# Code
```
class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> taskCount = new HashMap<>();
        int rounds = 0;
        for(int i=0;i<tasks.length;i++)
            taskCount.put(tasks[i],taskCount.getOrDefault(tasks[i],0)+1);
        for(Integer key : taskCount.keySet()){
            if(taskCount.get(key)<2) return -1;
            else{
                if(taskCount.get(key)%3 == 0)
                    rounds = rounds+taskCount.get(key)/3;
                else
                    rounds = rounds + taskCount.get(key)/3+1;
            }
        }
        return rounds;
    }
}
```

