[134. Gas Station](https://leetcode.com/problems/gas-station/description/)

# Intuition and Approach
1. The function takes in two arrays: gas and cost, where *gas[i]* represents the amount of gas available at the i-th gas station, and *cost[i]* represents the amount of gas needed to travel from the i-th gas station to the next one.
2. The function first calculates the total amount of gas available at all the gas stations (totalGas) and the total amount of gas needed to travel around all the gas stations (totalCost). If totalGas is less than totalCost, it means that it is not possible to travel around all the gas stations, so the function returns -1.
3. If the total amount of gas available at all the gas stations is greater than the total amount of gas needed to travel all the gas stations, it means that there is sufficient gas available in the gas stations , we just need to find from the which station we should start to travel through the stations. We find that station from the process described in the below process.
4. Next, the function starts at the first gas station (*start=0*) and iterates through the gas stations. At each iteration, it calculates the remaining gas after visiting the current gas station (remainsGas) and adding the gas available at that station (*gas[i]*) and subtracting the gas needed to travel to the next gas station (*cost[i]*). If remainsGas becomes negative at any point, it means that it is not possible to travel from the current gas station to the next one without running out of gas. In this case, the function sets the starting gas station to the next one (*start=i+1*) and resets the remaining gas to 0 (*remainsGas=0*). 
5. Finally, the function returns the starting gas station that allows the travel around all the gas stations.

# Complexity

- Time complexity : o(n)
- Space complexity : O(1)

# Code 
```
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Initialize totalGas and totalCost to 0
        int totalGas = 0, totalCost = 0;
        // Iterate through all the gas stations
        for(int i = 0 ; i<gas.length; i++){
            // Add the gas and cost at each station to the total
            totalGas += gas[i];
            totalCost += cost[i];
        }
        // If totalCost is greater than totalGas, it is not possible to complete the circuit
        if(totalGas < totalCost) return -1;
        
        // Initialize remainsGas and start to 0
        int remainsGas = 0, start = 0;
        // Iterate through all the gas stations
        for(int i = 0 ; i < gas.length; i++){
            // Add the difference between gas and cost at each station to remainsGas
            remainsGas = remainsGas +(gas[i] - cost[i]);
            // If remainsGas becomes negative, set start to the next station and reset remainsGas to 0
            if(remainsGas < 0 ){
                start = i+1;
                remainsGas = 0;
            }
        }
        // Return the starting station
        return start;
    }
}
```